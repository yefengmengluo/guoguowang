<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="common.jsp" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${path}/css/public.css">
<link rel="stylesheet" href="${path}/css/regis.css">
<script type="text/javascript" src="${path}/js/jquery-1.7.min.js"></script>
<script type="text/javascript" src="${path}/js/dropload.min.js"></script>
<title>采购列表页面</title>
<script type="text/javascript">
	$(function(){
		var param = {
			buyDetail : $("#box").val()
		};
		var count=2;
		/*采购列表 加载更多*/
		$(".pclist-con").dropload({
		    scrollArea : window,
		    domDown : {
				domClass : "dropload-down",
				domUpdate : '<div class="dropload-update">↓释放加载</div>'
			},
			distance: 50,
		    loadDownFn : function(me){
	   			$(".load").html("正在加载更多数据");
	   			param.currentNum=count;
	   	    	count++;
		        $.ajax({
		            type: "POST",
		            url: "${path}/buy/buy_list.do",
		            data: param,
		            async : false,
		            dataType: "json",
		            success: function(data){
		            	var arr = data;
						var result = "";
						if(arr.length > 0){
							for(var i = 0; i < arr.length; i++){
								 result += "<ul><li><label>" + arr[i].linkPerson 
								 + "</label><span><a href='tel://"+arr[i].phoneNum +"'>" + arr[i].phoneNum 
								 + "</a></span></li><li class='xbk'><p>"; 
								 if(arr[i].address.length <= 14){
									 result += arr[i].address;
								 }else{
									 result += arr[i].address.substring(0,14) + "...";
								 }
								 result += "</p></li><p>";
								 if(arr[i].buyDetail.length <= 200){
									 result += arr[i].buyDetail;
								 }else{
									 result += arr[i].buyDetail.substring(0,199) + "...";
								 }
								 result += "</p><i>" + arr[i].createTime 
								 + "</i></ul>";
							}
							$(".pclist-con").append(result);
							$(".load").html("向上滑动加载更多");
						}else{
							$(".load").html("没有更多了");
						}
						me.resetload();
	        		},
					error: function(xhr, type){
						me.resetload();
					}
				});
			}
		});
		
	});
	
	// 页面加载完后执行
	document.onreadystatechange = function () {   
        if(document.readyState=="complete") {  
        	if($("#box").val().trim().length != 0){
        		$("#title").text("查询结果");
        		var buyCountVal = $("#buyCount").val();
        		if(buyCountVal > 10){
        			$(".load").html("向上滑动加载更多");
        		}else{
        			$(".load").html("没有更多了");
        		}
        	}
         }   
    } 
	
	Date.prototype.Format = function(fmt)   
	{  
	  var o = {   
	    "M+" : this.getMonth()+1,                 //月份   
	    "d+" : this.getDate(),                    //日   
	    "h+" : this.getHours(),                   //小时   
	    "m+" : this.getMinutes(),                 //分   
	    "s+" : this.getSeconds(),                 //秒   
	    "q+" : Math.floor((this.getMonth()+3)/3), //季度   
	    "S"  : this.getMilliseconds()             //毫秒   
	  };   
	  if(/(y+)/.test(fmt))   
	    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
	  for(var k in o)   
	    if(new RegExp("("+ k +")").test(fmt))   
	  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
	  return fmt;   
	};
</script>
</head>
<body>
	<div class="pclist">
	    <form action="${path}/buy/list.do" method="post">
	    	<input type="text" id="box" name="buyDetail" value="${buyDetail }" placeholder="请输入您的关键词">
	    	<input type="submit" id="seek" value=" 搜索 ">
	    	<input type="hidden" id="buyCount" value="${buyCount }"/>
	    </form>
	</div>
	<div class="pclist-con">
		<h2 id="title">最新采购商机</h2>
		<c:forEach items="${buyList }" var="buy">
			<ul>
			<li><label>${buy.linkPerson }</label><span><a href="tel://${buy.phoneNum }">${buy.phoneNum }</a></span></li>
			<li class="xbk">
				<p>
					<c:if test="${fn:length(buy.address) > 14 }">
	           			${fn:substring(buy.address, 0, 14)}...
	           		</c:if>
					<c:if test="${fn:length(buy.address) <= 14 }">
	           			${buy.address}
	           		</c:if>
				</p>
			</li>
			<p>
				<c:if test="${fn:length(buy.buyDetail) > 200 }">
           			${fn:substring(buy.buyDetail, 0, 200)}...
           		</c:if>
				<c:if test="${fn:length(buy.buyDetail) <= 200 }">
           			${buy.buyDetail}
           		</c:if>
			</p>
			<i>${buy.createTime }</i>
		</ul>
		</c:forEach>
	</div>
	<div class="load">正在加载更多数据</div>
</body>
</html>
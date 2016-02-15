<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<meta charset="UTF-8">
<title>供应列表页面</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/public.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/css/regis.css'/>" />
</head>
<body>
	<div class="pclist">
		<form action="<c:url value='/supply/list'/>" method="post">
			<input type="text" id="box" name="keyWord" value="${keyWord}" placeholder="请输入您的关键词"> 
			<input type="submit" id="seek" value=" 搜索 ">
		</form>
	</div>
	<div class="pclist-con">
		<h2 id="title">最新供应商机</h2>
		<c:forEach items="${supplyPage.pageList }" var="supply">
			<ul>
				<li><label>${supply.linkPerson }</label><span><a href="tel://${supply.phoneNum }">${supply.phoneNum }</a></span></li>
				<li class="xbk">
					<p>
						<c:if test="${fn:length(supply.address) > 14 }">
		           			${fn:substring(supply.address, 0, 14)}...
		           		</c:if>
						<c:if test="${fn:length(supply.address) <= 14 }">
		           			${supply.address}
		           		</c:if>
					</p>
				</li>
				<p>
					<c:if test="${fn:length(supply.supplyDetail) > 200 }">
	           			${fn:substring(supply.supplyDetail, 0, 200)}...
	           		</c:if>
					<c:if test="${fn:length(supply.supplyDetail) <= 200 }">
	           			${supply.supplyDetail}
	           		</c:if>
				</p>
				<i><fmt:formatDate value="${supply.createTime }" pattern="yyyy.MM.dd HH:mm" /></i>
			</ul>
		</c:forEach>
	</div>
	<c:if test="${empty supplyPage.pageList }">
		<div class="load">没有更多了</div>
	</c:if>
	<c:if test="${!empty supplyPage.pageList }">
		<div class="load">加载更多数据</div>
	</c:if>

<script type="text/javascript" src="<c:url value='/js/jquery-1.7.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/dropload.min.js'/>"></script>
<script type="text/javascript">
	$(function() {
		//加载更多
		var count = 2;
		var keyWord = $("#box").val();
		$('.pclist-con').dropload({
			scrollArea : window,
			domDown : {
				domClass : "dropload-down",
				domUpdate : '<div class="dropload-update">↓释放加载</div>'
			},
			distance : 50,
			loadDownFn : function(me) {
				$(".load").html("加载中...");
				var currentNum = count;
				count++;
				$.post(
					    "<c:url value='/supply/listMore'/>",
			   		 	{"currentNum":currentNum,"keyWord":keyWord},
					    function(data){
			   		 		var obj = data;
			   		 		var arr=obj.pageList;
					    	var result = '';
					    	var supplyDetail;
					    	var address;
							if(arr.length>0){
								for(var i = 0; i < arr.length; i++){
									var _obj = arr[i];
									supplyDetail = _obj.supplyDetail.length>200 ? _obj.supplyDetail.substring(0,200)+"..." : _obj.supplyDetail;
									address = _obj.address.length>14 ? _obj.address.substring(0,14)+"..." : _obj.address;
									result +="<ul><li><label>"+_obj.linkPerson+"</label><span><a href='tel://"+_obj.phoneNum+"'>"+_obj.phoneNum+"</a></span></li>"
									+"<li class='xbk'><p>"+address+"</p></li>"
									+"<p>"+supplyDetail+"</p><i>"+_obj.crtTime+"</i>"
								+"</ul>";
								}
								$(".pclist-con").append(result);
								$(".load").html("向上滑动加载更多");
							}else{
								$(".load").html("没有更多了");
							}
							me.resetload();		
					    }
				);
			}
		});
		
		//搜索
		/* $("#seek").click(){
			var keyWord = $("#box").val();
			$.post(
			    "<c:url value='/supply/list'/>",
	   		 	{"keyWord":keyWord,"currentNum":1},
			    function(data){ 
			    	if(data==1){
			    		//添加成功
			    	}
			    }
			);
			return false;
		} */
		
	});
	
	// 页面加载完后执行
	document.onreadystatechange = function () {   
        if(document.readyState=="complete") {  
        	if($("#box").val().trim().length != 0){
        		$("#title").text("查询结果");
        	}
         }   
    }
</script>
</body>
</html>
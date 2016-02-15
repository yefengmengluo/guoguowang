<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="common.jsp" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="${path}/css/public.css"/>
<link rel="stylesheet" type="text/css" href="${path}/css/regis.css"/>
<script type="text/javascript" src="${path}/js/jquery-1.7.min.js"></script>
<title>我要采购</title>
<script type="text/javascript">
	$(function(){
		
		var buyDetailVal;// 采购详细
		var linkPersonVal;
		var phoneNumVal;
		var addressVal;
		var phoneNumReg = /^0?1[3|4|5|8][0-9]\d{8}$/;// 验证手机号的正则表达式
		
		// 验证
		$("#txt").blur(function(){
			buyDetailVal = $("#txt").val().trim();
			if(buyDetailVal== "" || buyDetailVal == "请在下方填写您的真实报价，并对您的货物描述清楚"){
				$("#txt").css("border","1px solid red");
			}else{
				$("#txt").css("border","1px solid #a7a7a7");
			}
		});
		
		$("#linkPerson").blur(function(){
			linkPersonVal = $("#linkPerson").val().trim();
			if(linkPersonVal== ""){
				$("#linkPerson").css("border","1px solid red");
			}else{
				$("#linkPerson").css("border","1px solid #a7a7a7");
			}
		});
		
		$("#phoneNum").blur(function(){
			phoneNumVal = $("#phoneNum").val().trim();
			if(!phoneNumReg.test(phoneNumVal) || phoneNumVal == ""){// 验证手机号码非空和是否合法
				$("#phoneNum").css("border","1px solid red");
			}else{
				$("#phoneNum").css("border","1px solid #a7a7a7");
			}
		});
		
		$("#dztxt").blur(function(){
			addressVal = $("#dztxt").val().trim();
			if(addressVal== "" || addressVal== "请输入您的详细地址"){
				$("#dztxt").css("border","1px solid red");
			}else{
				$("#dztxt").css("border","1px solid #a7a7a7");
			}
		});
		
		$(":input").blur(function(){
			if(!phoneNumReg.test(phoneNumVal) || buyDetailVal== "" || linkPersonVal == "" || addressVal == ""){
	            return false;
	        }else{
	        	$("#addBtn").removeClass("post-icn-con2");
	        }
		});
		
		// 点击发布采购按钮
		$("#addBtn").click(function(){
			if(!phoneNumReg.test(phoneNumVal) || buyDetailVal == "" || buyDetailVal == "请在下方填写您的真实报价，并对您的货物描述清楚" || linkPersonVal == "" || addressVal == ""){
	            return false;
	        }
			var param = {buyDetail:buyDetailVal,linkPerson:linkPersonVal,phoneNum:phoneNumVal,address:addressVal};
			$.ajax({
				type : "POST",
				url : "${path}/buy/add.do",
				data : param,
				dataType : "json",
				async : false,
				success : function(data) {
					if(data.success == true){
						// 提示添加成功
						$(".account_bg").css("display","block");
					}
				}
			});
		});
		
		// 点击确定按钮
		$("#conform").click(function(){
			$(".account_bg").hide();
			var userAgent = navigator.userAgent; 
			WeixinJSBridge.call("closeWindow");
			return false;
		});
	});
	
	//获得焦点
	function getfocus_detail(obj){
	    if (obj.value == "请在下方填写您的真实报价，并对您的货物描述清楚"){
	        obj.value = "";
	    }
	    obj.style.color = "black";
	}
	
	//失去焦点
	function losefocus_detail(obj){
	    if (obj.value == ""){
	        obj.style.color = "#D0CECE";
	        obj.value = "请在下方填写您的真实报价，并对您的货物描述清楚";
	    }
	}
	
	//获得焦点
	function getfocus_address(obj){
	    if (obj.value == "请输入您的详细地址"){
	        obj.value = "";
	    }
	    obj.style.color = "black";
	}
	
	//失去焦点
	function losefocus_address(obj){
	    if (obj.value == ""){
	        obj.style.color = "#D0CECE";
	        obj.value = "请输入您的详细地址";
	    }
	}
</script>
</head>
<body>
	<div class="post-cg">
	    <h2>采购详细</h2>
	    <textarea cols="50" rows="10" id="txt" maxlength="500" onfocus="getfocus_detail(this)" onblur="losefocus_detail(this)">请在下方填写您的真实报价，并对您的货物描述清楚</textarea>
	</div>
	
	<div class="post_con">
	<h2>联系方式</h2>
	<ul>
	    <li>
	    <label for="phone"> 联系人：</label>
	    <input type="text" id="linkPerson" onkeyup="value=value.replace(/[^\a-zA-Z\u4E00-\u9FA5]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\a-zA-Z\u4E00-\u9FA5]/g,''))"/>
	    </li>
	    <li>
	    <label for="code-two">手机号：</label>
	    <input type="text" id="phoneNum"/>
	    </li>
	    <li>
	    <label for="szdq">所在地：</label>
	    </li>
	    <li><textarea name="address" cols="35" rows="2" id="dztxt" onfocus="getfocus_address(this)" onblur="losefocus_address(this)">请输入您的详细地址</textarea></li>
	</ul>
	</div>
	<div class="post-icn">
	    <a class="post-icn-con post-icn-con2" id="addBtn" href="#">发布采购信息</a>
	    <!-- 注册成功！请等待审核-->
	    <div class="account_bg">
	        <div class="account_con">
	            <p><img src="../images/icon_nav_msg.png" alt="">发布采购信息成功！</p>
	            <a id="conform" href="#">确定</a>
	        </div>
	    </div>
	</div>
</body>
</html>
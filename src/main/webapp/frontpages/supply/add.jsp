<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>发布供应</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/public.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/css/regis.css'/>" />
</head>
<body>
	<div class="post-cg">
		<h2>供应详细</h2>
		<textarea cols="50" rows="10" maxlength="500" id="txt">请在下方填写您的真实报价，并对您的货物描述清楚</textarea>
	</div>

	<div class="post_con">
		<h2>联系方式</h2>
		<ul>
			<li>
				<label for="phone">联系人：</label> 
				<input type="text" id="phone" onkeyup="value=value.replace(/[^\a-zA-Z\u4E00-\u9FA5]/g,'')" onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\a-zA-Z\u4E00-\u9FA5]/g,''))">
			</li>
			<li>
				<label for="code-two">手机号：</label> 
				<input type="text" id="code-two">
			</li>
			<li>
			<label for="szdq">所在地：</label>
			</li>
			<li>
				<textarea name="dztxt" cols="35" rows="2" id="dztxt">请输入您的详细地址</textarea>
			</li>
		</ul>
	</div>

	<div class="post-icn">
		<a id="publish" class="post-icn-con post-icn-con2" href="#">发布供应信息</a>
		<!-- 注册成功！请等待审核-->
		<div class="account_bg">
			<div class="account_con">
				<p>
					<img src="../images/icon_nav_msg.png" alt="">发布供应信息成功！
				</p>
				<a id="conform" href="#">确定</a>
			</div>
		</div>
	</div>

<script type="text/javascript" src="<c:url value='/js/jquery-1.7.min.js'/>"></script>
<script type="text/javascript">
$(function(){
	var supplyDetail;
	var linkPerson;
	var phoneNum;
	var address;
	var phoneFlag = false;
	var checkStatus = 1;//1:审核通过
	var phoneNumReg =  /^0?1[3|4|5|8][0-9]\d{8}$/;
	
	var supplyDetailFlag = false;
	var linkPersonFlag = false;
	var addressFlag = false;
	var phoneFlag = false;
	
	
	$("#txt").focus(function(){
		supplyDetail = $("#txt").val().trim();
		if(supplyDetail==""|| supplyDetail=="请在下方填写您的真实报价，并对您的货物描述清楚"){
			$(this).val("").css({"border-color":"#A9A9A9","color":"#000"});
		}else{
			$(this).css({"border-color":"#A9A9A9","color":"#000"});
			supplyDetailFlag = true;
		}
	}).blur(function(){
		supplyDetail = $("#txt").val().trim();
		if(supplyDetail==""||supplyDetail=="请在下方填写您的真实报价，并对您的货物描述清楚"){
			$(this).val("请在下方填写您的真实报价，并对您的货物描述清楚").css({"border-color":"red","color":"#d0cece"});
			supplyDetailFlag = false;
		}else{
			$(this).css({"border-color":"#A9A9A9","color":"#000"});
			supplyDetailFlag = true;
		}

	});
	
	$("#phone").focus(function(){
		
		if(linkPerson==""){
			$(this).css({"border-color":"#A9A9A9","color":"#000"});
		}else{
			$(this).css({"border-color":"#A9A9A9","color":"#000"});
			linkPersonFlag = true;
		}
	}).blur(function(){

		linkPerson = $("#phone").val().trim();
		if(linkPerson==""){
			$(this).css({"border-color":"red","color":"#d0cece"});
			linkPersonFlag = false;
		}else{
			$(this).css({"border-color":"#A9A9A9","color":"#000"});
			linkPersonFlag = true;
		}

	});
	
	$("#code-two").focus(function(){
		phoneNum = $("#code-two").val().trim();
		if(!phoneNumReg.test(phoneNum)){
			$(this).css({"border-color":"#A9A9A9","color":"#000"});
		}else{
			$(this).css({"border-color":"#A9A9A9","color":"#000"});
			phoneFlag = true;
		}
		
	}).blur(function(){
		phoneNum = $("#code-two").val().trim();
		if(!phoneNumReg.test(phoneNum)){
			$(this).css({"border-color":"red","color":"#d0cece"});
			phoneFlag = false;
		}else{
			$(this).css({"border-color":"#A9A9A9","color":"#000"});
			phoneFlag = true;
		}

	});
	
	
	$("#dztxt").focus(function(){
		address = $("#dztxt").val().trim();
		if(address==""||address=="请输入您的详细地址"){
			$(this).val("").css({"border-color":"#A9A9A9","color":"#000"});
		}else{
			$(this).css({"border-color":"#A9A9A9","color":"#000"});
			addressFlag = true;
		}
		
	}).blur(function(){
		address = $("#dztxt").val().trim();
		if(address==""||address=="请输入您的详细地址"){
			$(this).val("请输入您的详细地址").css({"border-color":"red","color":"#d0cece"});
			addressFlag = false;
		}else{
			$(this).css({"border-color":"#A9A9A9","color":"#000"});
			addressFlag = true;
		}

	});
	
	$(":input").blur(function(){
		if(!phoneNumReg.test(phoneNum) || !supplyDetailFlag || !linkPersonFlag || !addressFlag || !phoneFlag){
			$("#publish").addClass("post-icn-con2");
			return false;
        }else{
        	$("#publish").removeClass("post-icn-con2");
        }
	});
	
	
	//添加信息
	$("#publish").click(function(){
		
		if(!phoneNumReg.test(phoneNum) || supplyDetail==""||linkPerson==""||address == ""){
			return false;
		}else{
			$.post(
			    "<c:url value='/supply/add'/>",
	   		 	{"supplyDetail":supplyDetail,"linkPerson":linkPerson,"phoneNum":phoneNum,"address":address,"checkStatus":checkStatus},
			    function(data){ 
			    	if(data==1){
			    		//添加成功
			    		$(".account_bg").css("display","block");
			    	}
			    }
			);
		}
		return false;//取消默认行为
	});
	
	$("#conform").click(function(){
		$(".account_bg").hide();
		var userAgent = navigator.userAgent; 
		WeixinJSBridge.call("closeWindow");
		return false;
	});
	
});
</script>



</body>
</html>
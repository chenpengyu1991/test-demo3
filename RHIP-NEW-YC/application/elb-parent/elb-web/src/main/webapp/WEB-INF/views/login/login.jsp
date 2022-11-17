<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
	<title>HCMS</title>	
	<link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet" type="text/css" />
	<!--[if IE 6]>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/DD_belatedPNG.js" ></script>
	<script type="text/javascript">
		DD_belatedPNG.fix('#login_centent,.login_error,.login_button,#login_logo');
	</script>
	<![endif]-->  
	<script src="${pageContext.request.contextPath}/resources/js/jquery/jquery-1.7.2.min.js" type="text/javascript"></script>	
 	<script src="${pageContext.request.contextPath}/resources/js/jquery-validation/jquery.validate.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-validation/jquery.validate.expand.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-validation/jquery.metadata.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-validation/messages_cn.js" type="text/javascript"></script>
	<script type="text/javascript"> 
		$(function(){$("#signupForm").validate();});		
		 function enterTab(obj, evt) {
		   evt = (evt) ? evt : ((window.event) ? window.event : "");
		   keyCode = evt.keyCode ? evt.keyCode : (evt.which ? evt.which : evt.charCode);
		   if (keyCode == 13) {$("#signupForm").submit();}
		} 
 		$(document).ready(function(){
	    	$("#nameTextId").focus();
	    }); 
	    function login()
	    { 
			var form = document.getElementById('loginFormId');
			form.action = "${pageContext.request.contextPath}/access/login";
			form.submit();
	    }   
	</script> 
</head>
<body id="login_bg" >
	<div id="login_logo"></div>	
    <div id="login_copyright">&copy;2012-2022 Founder International Co., Ltd.</div>
	<div id="login_centent">
		<form id="signupForm" method="post" action="${pageContext.request.contextPath}/access/login">
			<ul>
				<li><input type="text" id="nameTextId" name="userName" class="login_input {required:true,rangelength:[5,15]}" onkeydown="javacript:enterTab(this,event);"/></li>
				<li><input type="password" id="passwordTextId" name="password" class="login_input {required:true,rangelength:[1,1]}" onkeydown="javacript:enterTab(this,event);"/></li>
				<li><input type="submit" id="loginButtonId" name="login" class="login_button submit" value="登 录" />
					<input type="reset" id="ResetButtonId" name="reset" class="login_button" value="重 置"  />
				</li>
			</ul>
		</form>
		<c:if test="${ not empty message}"><div id="login_error">${message}</div></c:if>
	</div>
</body>
</html>

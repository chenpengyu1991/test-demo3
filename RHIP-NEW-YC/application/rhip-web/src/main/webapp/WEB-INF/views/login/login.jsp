﻿﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 
response.setHeader("PRagma","No-cache"); 
response.setHeader("Cache-Control","no-cache"); 
response.setDateHeader("Expires", 0);
%> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
	<title>永城市全民健康信息平台</title>
	<meta http-equiv="Pragma" content="no-cache"></meta> 
	<meta http-equiv="Cache-Control" content="no-cache"></meta> 
	<meta http-equiv="Expires" content="0"></meta>
 	<meta http-equiv="X-UA-Compatible" content="IE=10; IE=9; IE=8; IE=7; IE=EDGE"></meta>
	<link href="${pageContext.request.contextPath}/css/base/login.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/css/newbase/base.css" type="text/css"  rel="stylesheet" />
	<%--<link href="${pageContext.request.contextPath}/css/redmond/jquery-ui-1.8.18.custom.css" type="text/css"  rel="stylesheet" />--%>
	<link href="${pageContext.request.contextPath}/css/base/menu.css" type="text/css"  rel="stylesheet" />
	<link rel = "Shortcut Icon" href="${pageContext.request.contextPath}/images/favicon.ico"></link>
	<script src="${pageContext.request.contextPath}/js/jquery/jquery-1.1.js" type="text/javascript"></script>	 
	<script src="${pageContext.request.contextPath}/js/jquery/jquery-ui-1.11.0.custom.js" type="text/javascript"></script>	
	<!--[if lt IE 7.]>
		<script src="${pageContext.request.contextPath}/js/png/DD_belatedPNG.js" type="text/javascript"></script>
 	<![endif]-->
	<script language="javascript" type="text/javascript">
	    function login()
	    { 
			var form = document.getElementById('loginFormId');	
			var type=$(":radio:checked").val();			
			var act=type=="0"?"login":"plogin"; 
			form.action = "${pageContext.request.contextPath}/access/"+"login"; 
			form.submit(); 
	    }
	   $(function(){
			$("#nameTextId")[0].focus();
			document.onkeydown = function(e){ 
			    var ev = document.all ? window.event : e;
			    if(ev.keyCode==13) {
			    	login();
			    }
			}
	   });
	   
	</script> 
</head>

<body id="login_bg">
	<p align="center" class="title_txt">
		<img src="${pageContext.request.contextPath}/images/title_txt.png" />
	</p>
	<div class="login_lbg"></div>
	<div class="login_conbg">
		<form id="loginFormId" name="loginForm" action="" method="post">
		<table cellpadding="0" cellspacing="0" border="0" class="table_login">
			<tr>
			 	<td align="center" colspan="3">
					<c:if test="${ not empty message}">
		    			<div class="msgError" style="width:180px">${message}</div>
					</c:if>
					<c:if test="${ empty message}">
					<p class="logo_bg">
					<br/>
					<br/>
					<br/>
					</p>
					</c:if>
				</td>
			</tr>
			<tr>
				<td width="34%" align="right" style="color:#fff;"> 用户名</td>
				<td align="left" colspan="2">
					<input type="text" value="" id="nameTextId" name="userName" class="input_login"/>
				</td>
			</tr>
			<tr>
				<td align="right"  style="color:#fff;">密 &nbsp;&nbsp; 码</td>
				<td align="left" colspan="2">
					<input type="password" id="passwordTextId" name="password" class="input_login" />
				</td>
			</tr>
			<tr>
				<td align="center" colspan="3">
					<input type="radio" name="type" value="0" checked="checked" style="width:20px;display: none;"/>	
					<!-- <input type="radio" name="type" value="0" checked="checked" style="width:20px;"/>机构
					<input type="radio" name="type" value="1" style="width:20px;" />患者 -->
				</td>
			</tr> 
		</table>
		</form>
		<p class="space20"></p>
		<p align="center">
			<input name="login" type="button" class="btn_login" onclick="login()" />
		</p>
	</div>  
</body>
</html>

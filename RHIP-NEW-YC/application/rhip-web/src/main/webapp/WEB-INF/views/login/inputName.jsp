<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
	<title>IDS</title>
	<link href="${pageContext.request.contextPath}/css/base/login.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/css/base/base.css" type="text/css"  rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/css/redmond/jquery-ui-1.8.18.custom.css" type="text/css"  rel="stylesheet" />
	<link href="${pageContext.request.contextPath}/css/base/menu.css" type="text/css"  rel="stylesheet" />
	
	<script src="${pageContext.request.contextPath}/js/jquery/jquery1.7.2.js" type="text/javascript"></script>	 
	<script src="${pageContext.request.contextPath}/js/jquery/jquery-ui-1.8.18.custom.min.js" type="text/javascript"></script>	
	<!--[if lt IE 7.]>
		<script src="${pageContext.request.contextPath}/js/png/DD_belatedPNG.js" type="text/javascript"></script>
 	<![endif]--> 
	<script type="text/javascript">
	    function inputName()
	    { 
			var form = document.getElementById('nameFormId');	
			form.action = "${pageContext.request.contextPath}/access/inputName"; 
			form.submit();
	    }  
	</script> 
</head>

<body id="login_bg">
	<p align="center" class="title_txt">
		<img src="${pageContext.request.contextPath}/images/title_txt.png" />
	</p>
	<div class="login_lbg"></div>
	<div class="login_conbg">
		<p class="logo_bg">
<%-- 			<img src="${pageContext.request.contextPath}/images/login.gif" /> --%>
			</br>
			</br>
		</p>
		<form id="nameFormId" name="nameForm" action="" method="post">
		<input type="hidden" id="certNoTextId" name="certNo" value="${certNo}"/>
		<input type="hidden" id="passwordTextId" name="password" value="${password}"/>
		<table cellpadding="0" cellspacing="0" border="0" class="table_login">
			<tr>
				<td width="34%" align="right">请输入姓名</td>
				<td align="left" colspan="2">
					<input type="text" id="nameTextId" name="name" class="input_login" />
				</td>
			</tr>
		</table>
		</form>
		<p class="space20"></p>
		<p align="center">
			<input name="inputName" type="button" class="btn_login" onClick="inputName()" />
		</p>
	</div>  
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<% 
response.setHeader("PRagma","No-cache"); 
response.setHeader("Cache-Control","no-cache"); 
response.setDateHeader("Expires", 0);
%> 

<!--[if lt IE 8.]>
	<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<![endif]-->

<!--[if gt IE 7.]>
	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<![endif]-->
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
	<TITLE>健康档案管理系统</TITLE>
	<script type="text/javascript">
		var contextPath = "${pageContext.request.contextPath}";
	</script>
	
	<script src="${pageContext.request.contextPath}/js/jquery/jquery1.7.2.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/util/load.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/views/layouts/baseLayoutLoad.js" type="text/javascript"></script>
	<link rel = "Shortcut Icon" href="${pageContext.request.contextPath}/images/favicon.ico"></link>
	
	<!--[if IE 6]>
		<script src="${pageContext.request.contextPath}/js/png/DD_belatedPNG.js" type="text/javascript"></script>
		<script type="text/javascript">
			DD_belatedPNG.fix('img');
			DD_belatedPNG.fix('#requiredName');
			DD_belatedPNG.fix('#requiredZheng');
		</script>
 	<![endif]--> 
	
	<script type="text/javascript">
		$.ajaxSetup ({
			cache: false
		});
	</script>
</HEAD>

<body class="twoColFixRtHdr">
	<TABLE id="container">
		<TBODY>
			<TR>
				<TD valign="top" colspan="2">
					<div id="header">
						<div>
							<tiles:insertAttribute name="header" />
						</div>
						<div id="banner">
							<tiles:insertAttribute name="loginbar" />
						</div>
					</div>
				</TD>
			</TR>
			<TR>
				<TD id="MainBody" height="100%" width="100%">
				<div id="Main">
					<tiles:insertAttribute name="content" />
				</div>
				</TD>
			</TR>
		</TBODY>
	</TABLE>
</body>
</HTML>


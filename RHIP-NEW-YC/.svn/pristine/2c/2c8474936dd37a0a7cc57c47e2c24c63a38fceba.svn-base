<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
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

<html>
<head>
	<TITLE>公共卫生信息系统</TITLE>
	<META HTTP-EQUIV="Pragma" CONTENT="no-cache"></META>
	<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"></META>
	<META HTTP-EQUIV="Expires" CONTENT="0"></META>
	<meta http-equiv="X-UA-Compatible" content="IE=10; IE=9; IE=8; IE=7; IE=EDGE"></meta>

	<script type="text/javascript">
		var contextPath = "${pageContext.request.contextPath}";
	</script>

	<link rel = "Shortcut Icon" href="${pageContext.request.contextPath}/images/favicon.ico"></link>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/views/populace/populace.css"></link>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base/ehr.css"></link>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base/forms.css"></link>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base/page.css"></link>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base/pop_layout.css"></link>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/multselect/jquery.multiselect.css"></link>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/select/select.css"></link>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/founderUI/skin.css"></link>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/autocomplete/jquery.autocomplete.css"></link>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/newbase/base.css"></link>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/newbase/forms.css"></link>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/newbase/layout.css"></link>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery.alerts/jquery.alerts.css"></link>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/fineuploader/fineuploader-3.4.1.css"></link>
	<link href="${pageContext.request.contextPath}/css/views/ehrbrowser/personalRecord/cover.css" type="text/css" rel="stylesheet"></link>
		 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin/font.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin/xadmin.css">

	<script data-main="${pageContext.request.contextPath}/js/util/main_print" src="${pageContext.request.contextPath}/js/require/require.js"></script>
	
	<style type="text/css">
		@media print {
			.print {
				page-break-after: always;
			}
			.toolbar {
				display: none;
			}
		}
	</style>
</head>

<body>
<div class="toolbar">
	<%-- <a href="javascript:void(0)" id="printMainId"><b class="dayin">打印</b></a> --%>
	<a href="javascript:void(0)" id="printMainId" ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe66d;</i>打印</button></a>
</div>
<div id="Container">
	<tiles:insertAttribute name="printContent" />
</div>
</body>
</html>
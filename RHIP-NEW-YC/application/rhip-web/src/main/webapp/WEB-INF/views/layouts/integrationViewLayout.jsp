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
	<TITLE>集成监控平台</TITLE>
	<META HTTP-EQUIV="Pragma" CONTENT="no-cache"></META> 
	<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"></META> 
	<META HTTP-EQUIV="Expires" CONTENT="0"></META>
 	<meta http-equiv="X-UA-Compatible" content="IE=10; IE=9; IE=8; IE=7; IE=EDGE"></meta>

    <script type="text/javascript">
        var contextPath = "${pageContext.request.contextPath}";
    </script>

	<link rel = "Shortcut Icon" href="${pageContext.request.contextPath}/images/favicon.ico"></link>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/views/populace/populace.css"></link>
	<%--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/redmond/jquery-ui-1.8.21.custom.css"></link>--%>
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

	<%--<script src="${pageContext.request.contextPath}/js/jquery/jquery1.7.2.js" type="text/javascript"></script>--%>
	<%--<script src="${pageContext.request.contextPath}/js/util/load.js" type="text/javascript"></script>--%>

    <%--<script src="${pageContext.request.contextPath}/js/jquery/jquery.treeview.js" type="text/javascript"></script>--%>
    <%--<script src="${pageContext.request.contextPath}/js/jquery/jquery-ui-1.8.21.custom.min.js" type="text/javascript"></script>--%>
    <%--<script src="${pageContext.request.contextPath}/js/jquery/jquery.form.js" type="text/javascript"></script>--%>
    <%--<script src="${pageContext.request.contextPath}/js/jquery/jquery.cookie.js" type="text/javascript"></script>--%>
    <%--<script src="${pageContext.request.contextPath}/js/jquery/jquery.blockUI.js" type="text/javascript"></script>--%>

    <%--<script src="${pageContext.request.contextPath}/js/multiselect/jquery.multiselect.js" type="text/javascript"></script>--%>
    <%--<script src="${pageContext.request.contextPath}/js/util/base.js" type="text/javascript"></script>--%>
    <%--<script src="${pageContext.request.contextPath}/js/util/ajax.js" type="text/javascript"></script>--%>
    <%--<script src="${pageContext.request.contextPath}/js/datepicker/WdatePicker.js" type="text/javascript"></script>--%>
    <%--<script src="${pageContext.request.contextPath}/js/util/util.js" type="text/javascript"></script>--%>
    <%--<script src="${pageContext.request.contextPath}/js/util/jquery.founder.js" type="text/javascript"></script>--%>
    <%--<script src="${pageContext.request.contextPath}/js/util/jquery.founder.form.js" type="text/javascript"></script>--%>
    <%--<script src="${pageContext.request.contextPath}/js/util/jquery.founder.ajax.js" type="text/javascript"></script>--%>
    <%--<script src="${pageContext.request.contextPath}/js/util/jquery.bgiframe.js" type="text/javascript"></script>--%>
    <%--<script src="${pageContext.request.contextPath}/js/util/section.js" type="text/javascript"></script>--%>
    <%--<script src="${pageContext.request.contextPath}/js/util/idCardUtil.js" type="text/javascript"></script>--%>
    <%--<script src="${pageContext.request.contextPath}/js/util/jquery.easy_validator.js" type="text/javascript"></script>--%>
    <%--&lt;%&ndash;//add for mdm&ndash;%&gt;--%>
    <%--<script src="${pageContext.request.contextPath}/js/util/jquery.founder.page.js" type="text/javascript"></script>--%>
    <%--<script src="${pageContext.request.contextPath}/js/autocomplete/jquery.autocomplete.js" type="text/javascript"></script>--%>
    <%--<script src="${pageContext.request.contextPath}/js/jquery/ajaxfileupload.js" type="text/javascript"></script>--%>

    <%--<script src="${pageContext.request.contextPath}/js/Highcharts-2.3.3/js/highcharts.js" type="text/javascript"></script>--%>
    <%--<script src="${pageContext.request.contextPath}/js/Highcharts-2.3.3/js/modules/exporting.js" type="text/javascript"></script>--%>
    <%--<script src="${pageContext.request.contextPath}/js/util/jquery.placeholder.1.3.js" type="text/javascript"></script>--%>
    <%--<script src="${pageContext.request.contextPath}/js/jquery.alerts/jquery.alerts.js" type="text/javascript"></script>--%>

</head>

<body>
	<div id="Container">
		<tiles:insertAttribute name="content" />
	</div>
</body>
</html>
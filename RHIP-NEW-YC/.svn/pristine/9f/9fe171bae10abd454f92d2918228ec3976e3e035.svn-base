<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script type="text/javascript">
		var contextPath = "${pageContext.request.contextPath}";
        var casLogoutUrl="${logoutUrl}";
        var logoutServeceUrl="${logoutServeceUrl}";
		//在查询预约详细的时候使用到，用于区分患者页面的显示
		var showBack = false;
		var isJg = "";
		var showList = "";
	</script>
	<link rel = "Shortcut Icon" href="${pageContext.request.contextPath}/images/favicon.ico"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/views/populace/populace.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/redmond/jquery-ui-1.11.0.custom.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base/ehr.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base/forms.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base/page.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base/pop_layout.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/multselect/jquery.multiselect.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/select/select.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/founderUI/skin.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/autocomplete/jquery.autocomplete.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/newbase/base.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/newbase/forms.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/newbase/layout.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/jquery.alerts/jquery.alerts.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/zTree/css/zTreeStyle/zTreeStyle.css"/>
	<link href="${pageContext.request.contextPath}/css/views/ehrbrowser/personalRecord/cover.css" type="text/css" rel="stylesheet"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin/font.css">
	 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin/fontsextend_arrow.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/x-admin/xadmin.css">
    <script src="${pageContext.request.contextPath}/js/layui/layui.js" charset="utf-8"></script>
<%-- <script src="${pageContext.request.contextPath}/js/views/ehr/region/list.js" type="text/javascript"></script> --%>
<script data-main="${pageContext.request.contextPath}/js/util/main_ehr_region" src="${pageContext.request.contextPath}/js/require/require.js"></script>
<div class="section">
<%@include file="list_search.jsp" %>
<!--<div id="list_datagrid" ></div>  -->
<input type="hidden" id="orgCode" value="${currentLoginInfo.organization.organCode}" ></input>
</div>
<%-- 市民卡控件
 <object id="CsSmkActive" classid="clsid:AE451137-38F8-4240-A9F9-6D8E182D9C16" codebase="${pageContext.request.contextPath}/activex/csSmk.cab#version=1,0,0,1" style="width:0;height:0;display:none;"></object>
 --%>

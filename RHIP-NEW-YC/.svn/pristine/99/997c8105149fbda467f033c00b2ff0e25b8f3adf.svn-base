﻿<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
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
	<TITLE>永城市全民健康信息平台</TITLE>
	<META HTTP-EQUIV="Pragma" CONTENT="no-cache"/>
	<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"/>
	<META HTTP-EQUIV="Expires" CONTENT="0"/>
 	<meta http-equiv="X-UA-Compatible" content="IE=10; IE=9; IE=8; IE=7; IE=EDGE"/>
 	
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
    <%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.css" /> --%>

	<script data-main="${pageContext.request.contextPath}/js/util/main" src="${pageContext.request.contextPath}/js/require/require.js"></script>

</head>

<body>
	<div id="Container">
        <c:if test="${saas ne 1}">
            <div id="Topmain">
                <div>
                    <tiles:insertAttribute name="header" />
                </div>
			<div id="Loginbar">
				<tiles:insertAttribute name="loginbar" />
			</div>
		    </div>
        </c:if>
        <div id="LeftMenu" style="${saas==1?'margin-top:-60px':''}">
			<tiles:insertAttribute name="left" />
		</div>
		<div id="SwitchBar" class="SwitchBar" onClick="baseLayoutLoad.switchSysBar()" style="${saas==1?'margin-top:-60px':''}">
			<a id="switchPoint" class="close"></a>
		</div>
		<div id="Main" style="${saas==1?'margin-top:-60px':''}">
			<tiles:insertAttribute name="content" />
		</div>
		<c:if test="${saas ne 1}">
			<div id="Footer">
					版权所有：北大医疗信息技术有限公司 &nbsp;版本信息：V4.2.20210716&nbsp;&nbsp;&nbsp;&nbsp;平台在线人数：${onlineUserlist.size()}
			</div>
			<div id="setWidth"></div>
		</c:if>
    </div>
</body>
</html>
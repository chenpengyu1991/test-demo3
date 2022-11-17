<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="JKMBK" value="<%=RoleType.JKMBK.getValue()%>"/>
<c:set var="ZXMB" value="<%=RoleType.ZXMB.getValue()%>"/>
<c:set var="ZMB" value="<%=RoleType.ZMB.getValue()%>"/>

<script
	src="${pageContext.request.contextPath}/js/views/cdm/standardization/healthPlan/list.js"
	type="text/javascript"></script>
<div class="section" id="cdm-plan-list-hbp-box">
	<div class="toolbar">
		<c:if test="${empty titleFlag}">
			<a href="javascript:void(0)" id="cdm-planInfo-list-hbp-back-btn"><b class="fanhui" >返回</b></a>
		</c:if>
		<ehr:authorize ifAnyGranted="${ZXMB},${ZMB}">
			<a href="javascript:void(0)" id="cdm-plan-list-hbp-add-btn"><b class="xinz" >新增</b></a> 
		</ehr:authorize>
	</div>
	<form method="post" id="cdm-plan-list-hbp-form"></form>
	<div id="cdm-plan-list-hbp-result" class="repeattable"></div>
</div>

	<div id="cdm-plan-input-hbp"></div>


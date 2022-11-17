<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="JKMBK" value="<%=RoleType.JKMBK.getValue()%>"/>
<c:set var="ZXMB" value="<%=RoleType.ZXMB.getValue()%>"/>
<c:set var="ZMB" value="<%=RoleType.ZMB.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/cdm/standardization/healthPlan/mainPlan.js" type="text/javascript"></script>
<div class="toolbar">
	<a href="javascript:void(0)" id="health-back-btn"><b class="fanhui">返回</b></a>
	
	<ehr:authorize ifAnyGranted="${ZXMB},${ZMB}">
		<a href="javascript:void(0)" id="health-add-btn"><b class="xinz">新增</b></a>
		<a href="javascript:void(0);" id="health-save-btn"><b class="baocun">保存</b></a>
	</ehr:authorize>
</div>
<div style="float: left; width: 25%">
	<fieldset>
		<legend>保健计划</legend>
		<div id="planYearList"></div>
	</fieldset>
	<fieldset>
		<legend>随访计划</legend>
		<div id="planFollowupList" style="position: relative;"></div>
	</fieldset>
</div>
<div style="float: right; width: 74%">
	<div id="planInfoTabList" style="position: relative;"></div>
</div>
<br style="clear: both;" />
​
<input type="hidden" id="hiddenPersonId" value="${personInfo.id}" name="personId">
<input type="hidden" id="hiddenPersonName" value="${personInfo.name}">
<input type="hidden" id="hiddenPersonIdCard" value="${personInfo.idcard}" name="idcard">
<input type="hidden" id="hiddenPersonHealthFileNo" value="${personInfo.healthFileNo}" name="healthFileNo">

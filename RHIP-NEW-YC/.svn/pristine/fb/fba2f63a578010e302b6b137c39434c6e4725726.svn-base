<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<script src="${pageContext.request.contextPath}/js/views/da/daCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/da/daily/physicianDrug/medication.js" type="text/javascript"></script>
<div class="toolbar">
	<a href="javascript:void(0)" onclick="physicianSearch.returnSearch()"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon"></i>返回</button></a>
</div>
<div class="repeattable" style="margin:10px 0px 0px 0px">
	<fieldset class="layui-elem-field">
		<legend>用药排名</legend>
		<input type="hidden" id="medicationPageIndex" value="${medicationPageIndex}">
		<input type="hidden" id="hospitalCode" value="${hospitalCode}">
		<input type="hidden" id="drugCode" value="${drugCode}">
		<input type="hidden" id="prescribeDateBegin" value="${prescribeDateBegin}">
		<input type="hidden" id="prescribeDateEnd" value="${prescribeDateEnd}">
		<input type="hidden" id="patientType" value="${patientType}">
		<form id="medicationSearchForm">
		</form>
		<div id="medicationResultDiv" style="margin:10px 0px 0px 0px"></div>		
	</fieldset>
</div>


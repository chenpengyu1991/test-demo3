<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath}/js/views/hm/manage/add.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/hm/manage/report.js"/>
	<form id="hm-person-phyexam-form">
		<input type="hidden" id="person_name" value="${personInfo.name}"/>
		<input type="hidden" id="idCard" value="${personInfo.idcard}">
		<input type="hidden" name="personId" value="${examination.personId}" id="personid_prephyexam"/>
		<input type="hidden" name="physicalExamRecordId" value="${physicalExamRecordId}"/>
		<input type="hidden" name="id" value="${examination.id}"/>
		<input type="hidden" name="ehrId" value="${examination.ehrId}"/>
		<input type="hidden" id="currentEhrId" value="${examination.ehrId}"  id="ehrId_prephyexam">
		<input type="hidden" id="emotionScreenResultStr" name="emotionScreenResultStr"/>
		<input type="hidden" name='physicalExamCode' value="${examination.physicalExamCode}"/>
		<input type="hidden" name='healthFileNo' value="${personInfo.healthFileNo}"/>
		<input type="hidden" name='healthGuidance' value="${examination.healthGuidance}"/>
		<div class="postcontent">
			<i class="popno">健康体检</i>
			<jsp:include page="add_personPhyExam.jsp"></jsp:include>
		</div>
	</form>


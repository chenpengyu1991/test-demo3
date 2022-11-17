<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/hsa/inspRecord/add/add.js" type="text/javascript"></script>
<div class="toolbar">
	<a href="javascript:void(0)"  id="hsa-input-back-btn"><b class="fanhui">返回</b></a>
	<c:if test="${inspRecord.status==1}">
		<ehr:authorize ifAnyGranted="01,28">
			<a href="javascript:void(0)"  id="hsa-input-confirm-btn"><b class="baocun">确认</b></a>
		</ehr:authorize>
	</c:if>
	<c:if test="${flag!='view'}">
		<a href="javascript:void(0)" id="hsa-input-save-btn"><b class="baocun">保存</b></a>
	</c:if>
</div>
<input type="hidden" id="has-insprecord-flag" value="${flag}">
<input type="hidden" id="has-insprecord-id" value="${inspRecord.id}">
<form id="hsa-input-form">
<c:if test="${type==1}">
	<div class="postcontent">
		<i class="popno">工作登记</i>
		<div class="postdiv">
			<jsp:include page="../add/inspLocInfo.jsp"></jsp:include>
		</div>
		
		<div class="postdiv">
			<jsp:include page="../add/mainProblem.jsp"></jsp:include>
		</div>
	</div>
</c:if>
<c:if test="${type==2}">
	<jsp:include page="../add/familyRecordAdd.jsp"></jsp:include>
</c:if>
</form>

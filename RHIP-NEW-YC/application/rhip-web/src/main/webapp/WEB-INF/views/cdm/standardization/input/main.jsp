<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<script src="${pageContext.request.contextPath}/js/views/cdm/standardization/input/domanage.js" type="text/javascript"></script>
<div class="toolbar">
	<a href="javascript:void(0)" id="health-card-back-btn"><b class="fanhui">返回</b></a> <a href="javascript:void(0);" id="health-card-save-btn"><b
		class="tijiao"
	>提交</b></a>
</div>
<div id="health-card-main">
	<form id="health-card-form">
		<input type="hidden" id="disPersonId" name="personId" value="${diseaseInfo.personInfo.id}"> <input type="hidden" id="disid" name="id"
			value="${diseaseInfo.id}"
		>
		<%--保留带纳入报卡的信息 --%>
		<c:forEach items="${ diseaseInfo.toManagedReports}" var="report" varStatus="status">
			<input type="hidden" name="toManagedReports[${status.index}].cdmStatusInfo.id" value="${report.cdmId}">
			<input type="hidden" name="toManagedReports[${status.index}].id" value="${report.id}">
			<input type="hidden" name="toManagedReports[${status.index}].dmPersonId" value="${report.dmPersonId}">
		</c:forEach>
		<c:set var="isBringIntoManage" scope="request" value="${true}" ></c:set>
		<div class="postcontent">
			<i class="popno">慢病管理</i>
			<div class="postdiv">
				<div id="person-info"><jsp:include page="personInfo.jsp"></jsp:include>
				</div>
				<div id="dis-info">
					<c:if test="${diseaseInfo.hbpFlag eq '2'}">
						<fieldset>
							<legend>高血压信息</legend>
							<input type="hidden" name="hbpReportId" value="${hbpReportId}"/>
							<input type="hidden" value="2" name="hbpFlag">
							<jsp:include page="hbp.jsp"></jsp:include>
						</fieldset>
					</c:if>
				
					<c:if test="${diseaseInfo.diFlag eq '2'}">
						<fieldset>
							<legend>糖尿病信息</legend>
							<input type="hidden" name="diReportId" value="${diReportId}"/>
							<input type="hidden" value="2" name="diFlag">
							<jsp:include page="di.jsp"></jsp:include>
						</fieldset>
					</c:if>
					
					<c:if test="${diseaseInfo.coronaryFlag eq '2'}">
						<fieldset>
							<legend>冠心病信息</legend>
							<input type="hidden" value="2" name="coronaryFlag">
							<jsp:include page="coronary.jsp"></jsp:include>
						</fieldset>
					</c:if>
					<c:if test="${diseaseInfo.strokeFlag eq '2'}">
						<fieldset>
							<legend>脑卒中信息</legend>
							<input type="hidden" value="2" name="strokeFlag">
							<jsp:include page="stroke.jsp"></jsp:include>
						</fieldset>
					</c:if>
					<c:if test="${diseaseInfo.tumorFlag eq '2'}">
						<fieldset>
							<legend>肿瘤信息</legend>
							<input type="hidden" value="2" name="tumorFlag">
							<jsp:include page="tumor.jsp"></jsp:include>
						</fieldset>
					</c:if>
				</div>
				<div id="phyexam-info"></div>
				<div id="input-info"></div>
			</div>
		</div>
	</form>
</div>

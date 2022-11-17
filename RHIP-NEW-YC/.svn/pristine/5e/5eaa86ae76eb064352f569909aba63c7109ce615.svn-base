<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<c:choose>
	<c:when test="${not empty errorStr}">
		${errorStr}
	</c:when>
	<c:otherwise>
		<script src="${pageContext.request.contextPath}/js/views/cdm/standardization/healthPlan/planInfoTab.js" type="text/javascript"></script>
		<input type="hidden" id="cdmPlanHiddenPersonId" value="${personInfo.id}"/>
		<div>
			<jsp:include page="personInfo.jsp"></jsp:include>
		</div>
		<div>
			<ul id="tags">
				<c:if test="${diseaseInfo.hbpFlag eq '2'}">
					<li><a id="hbpPlan" data-type="1" data-target="hbpPlan-content">高血压保健计划</a></li>
				</c:if>
				<c:if test="${diseaseInfo.diFlag eq '2'}">
					<li><a id="diPlan" data-type="2" data-target="diPlan-content">糖尿病保健计划</a></li>
				</c:if>
			</ul>
			<div id="tagContent" class="postdiv">
				<div id="hbpPlan-content">
					<jsp:include page="./hbp/main.jsp"></jsp:include>
				</div>
				<div id="diPlan-content" style="display: none;">
					<jsp:include page="./di/main.jsp"></jsp:include>
				</div>
			</div>
		</div>
	</c:otherwise>
</c:choose>

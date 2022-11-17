<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/manage/followUp/edit.js" type="text/javascript"></script>
<c:if test="${not empty dmHypertensionFollowup}">
	<jsp:include page="hbp/main.jsp"></jsp:include>
</c:if>
<c:if test="${not empty dmDiabeticFollowup}">
	<jsp:include page="di/main.jsp"></jsp:include>
</c:if>
<c:if test="${not empty dmTumorFollowup}">
	<jsp:include page="tumor/tumorMain.jsp"></jsp:include>
</c:if>
<c:if test="${not empty dmStrtumFollowup}">
	<c:if test="${dmStrtumFollowup.diseaseType eq 3 }">
		<jsp:include page="tumor/tumorMain.jsp"></jsp:include>
	</c:if>
	<c:if test="${dmStrtumFollowup.diseaseType eq 4 }">
		<jsp:include page="coronary/main.jsp"></jsp:include>
	</c:if>
</c:if>
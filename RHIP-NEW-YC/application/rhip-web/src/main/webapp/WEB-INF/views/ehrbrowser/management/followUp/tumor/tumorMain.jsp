<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<c:if test="${tumor.followupFlag eq 2}">
	<jsp:include page="tumorFollowupInput.jsp"></jsp:include>
</c:if>
<c:if test="${tumor.followupFlag eq 1}">
	<jsp:include page="tumorFirstFollowupInput.jsp"></jsp:include>
</c:if>
<c:if test="${tumor.followupFlag eq 3}">
	<jsp:include page="tumorLastFollowupInput.jsp"></jsp:include>
</c:if>
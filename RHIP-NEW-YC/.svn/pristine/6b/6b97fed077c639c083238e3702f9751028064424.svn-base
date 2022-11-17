<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<div>
	<c:if test="${planInfo.diseaseType eq '1'}">
		<div id="hbpPlan-content" >
			<form id="hbpPlanForm" method="post">
	     		<jsp:include page="hbpPlanInfo.jsp"/>
	     	</form>
		</div>
	</c:if>
	<c:if test="${planInfo.diseaseType eq '2'}">
		<div id="diPlan-content">
			<form id="diPlanForm" method="post">
		 		<jsp:include page="diPlanInfo.jsp"/>
		 	</form>
		</div>
	</c:if>
</div>
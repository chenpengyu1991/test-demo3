<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

您好，${organization.name}&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/user/userUpdate"><span id="currentUserName" class="userName">${logonUserName}</span></a>！
<c:if test="${isUser}">
	<c:if test="${organization.typeCode eq '02' || organization.typeCode eq '03'}">
		<c:if test="${quikLink == 1}">
			<a onclick="cancelToMainUrl('${pageContext.request.contextPath}/reserve/patient/search?flag=1')" href="javascript:void(-1);">
				<span class="quika">●提交预约</span>
			</a>
			<a onclick="cancelToMainUrl('${pageContext.request.contextPath}/reserve/search')" href="javascript:void(-1);">
				<span class="quika">●预约查询</span>
			</a>
			<a onclick="cancelToMainUrl('${pageContext.request.contextPath}/referral/patient/search?flag=1')" href="javascript:void(-1);">
				<span class="quika">●提交上转</span></a>
			<a onclick="cancelToMainUrl('${pageContext.request.contextPath}/referral/search')" href="javascript:void(-1);">
				<span class="quika">●上转查询</span></a>
			<a onclick="cancelToMainUrl('${pageContext.request.contextPath}/patient/search')" href="javascript:void(-1);">
				<span class="quika">●患者管理</span></a>
		</c:if>
	</c:if>
	<c:if test="${organization.typeCode eq '01'}">
		<c:if test="${quikLink == 2}">
			<a onclick="cancelToMainUrl('${pageContext.request.contextPath}/reserve/search')" href="javascript:void(-1);">
				<span class="quika">●预约查询</span></a>
			<a onclick="cancelToMainUrl('${pageContext.request.contextPath}/referral/back/patient/search')" href="javascript:void(-1);">
				<span class="quika">●提交下转</span></a>
		</c:if>
	</c:if>
	<c:if test="${showStatistics}">
		<a onclick="cancelToMainUrl('${pageContext.request.contextPath}/statistics/search')" href="javascript:void(-1);">
			<span class="quika">●综合统计</span></a>
	</c:if>
</c:if>
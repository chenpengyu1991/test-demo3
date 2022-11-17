<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="ehr" uri="/WEB-INF/tld/ehr-tag.tld"%>
<%@ page import="com.founder.rhip.portal.common.InteractionStatus" %>
<c:set var="REPLY" value="<%=InteractionStatus.REPLY.getValue()%>"/>
<c:set var="RETURN" value="<%=InteractionStatus.RETURN.getValue()%>"/>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/views/info/interaction.css"/>

<script src="${pageContext.request.contextPath}/js/views/layouts/page.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/interaction/common.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/interaction/list.js" type="text/javascript"></script>

<input type="hidden" id="eventType" value="${eventType}"/>


<div class="interaction_contents">
	<ul>
		<c:forEach items="${interactionList}" var="record">
			<li class="messageTitle">
				<span style="color:red; float:left">[<ehr:tip><ehr:dic dicmeta="LH00002" code="${record.eventType}"/></ehr:tip>]</span>
			<span style="float:left">
				<c:choose>
					<c:when test="${record.status == REPLY}">
						[已回复]
					</c:when>
					<c:when test="${record.status == RETURN}">
						[已退回]
					</c:when>
					<c:otherwise>
						[未回复]
					</c:otherwise>
				</c:choose>
			</span>
				<label style="float:left; cursor: pointer;">${record.title}</label>
				<span style="float:right"><fmt:formatDate value='${record.insertDate}' pattern='yyyy/MM/dd'/></span>
			</li>
			<ul class="message">
				<li class="messageInfo">
					<strong>咨询内容：</strong>
					<div class="content">${record.content }</div>
				</li>
				<c:if test="${record.status == REPLY}">
				<li class="messageReinfo">
					<strong><ehr:org code="${record.unitCode}"></ehr:org>回复：</strong>
					<div class="messageReinfoTime">回复日期：<fmt:formatDate value='${record.replyDate}' pattern='yyyy/MM/dd'/></div>
					<div class="content">${record.replyContent}</div>
				</li>
				</c:if>
			</ul>
		</c:forEach>
	</ul>
</div>
<ehr:pagination action="interactionSearch.search"/>


<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.portal.common.InteractionStatus" %>

<c:set var="REPLY" value="<%=InteractionStatus.REPLY.getValue()%>"/>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/views/info/interaction.css"/>

<script src="${pageContext.request.contextPath}/js/views/interaction/common.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/interaction/add.js" type="text/javascript"></script>

<!-- 互动信息 -->
<div class="navRight">
	<div class="location">
	  	当前位置：<a id="zxzx" class="space">在线咨询</a>
	  	<c:if test="${not empty eventType}">
			<c:if test="${eventType == '01'}">&gt;&gt;<a id="zx1">咨询</a></c:if>
			<c:if test="${eventType == '02'}">&gt;&gt;<a id="jy1">建议</a></c:if>
			<c:if test="${eventType == '03'}">&gt;&gt;<a id="ts1">投诉</a></c:if>
		</c:if>
		<div class="location_right">
			<a id="toZx"><i class="zx"></i>咨询</a>
			<a id="toJy"><i class="jy"></i>建议</a>
			<a id="toTs"><i class="ts"></i>投诉</a>
		</div>
	</div>
	<table>
		<tr>
			<td><div class="interactionIcon"></div></td>
			<td>
				<div class="eventName">
					<strong><ehr:dic dicmeta="LH00002" code="${interactionInfo.eventType}"/></strong>
				</div>
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<td width="60" valign="top" rowspan="3"><div class="questionIcon"></div></td>
			<td>
				<table id="con">
					<tr>
						<td><div>主题：${interactionInfo.title}</div></td>
					</tr>
					<tr>
						<td><div>提交日期：<fmt:formatDate value='${interactionInfo.insertDate}' pattern='yyyy/MM/dd'/> | 
						受理部门：
						<c:choose>
						<c:when test="${null == interactionInfo.unitCode}">
							<ehr:org code="${interactionInfo.orgCode}"></ehr:org>
						</c:when>
						<c:otherwise>
							<ehr:org code="${interactionInfo.unitCode}"></ehr:org>
							（由<ehr:org code="${interactionInfo.orgCode}"></ehr:org>转交）
						</c:otherwise>
						</c:choose>
						</div></td>
					</tr>
					<tr>
						<td>${interactionInfo.content}</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<c:if test="${interactionInfo.status == REPLY}">
		<table>
		<tr>
			<td width="60" valign="top" rowspan="2"><div class="answerIcon"></div></td>
			<td>
				<table id="con">
				<tr>
					<td><div>回复日期：<fmt:formatDate value='${interactionInfo.replyDate}' pattern='yyyy/MM/dd'/> | 
					回复部门：<ehr:org code="${interactionInfo.unitCode}"></ehr:org>
					</div>
					</td>
				</tr>
				<tr>
					<td>${interactionInfo.replyContent}</td>
				</tr>
			</table>
			</td>
		</tr>
		</table>
	</c:if>
</div>


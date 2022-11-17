<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ZXXG" value="<%=RoleType.ZXXG.getValue()%>"/>
<c:set var="ZXG" value="<%=RoleType.ZXG.getValue()%>"/>
<table >
	<colgroup>
		<col style="width:60px;" />
		<col style="width:60px;" />
	</colgroup>
	<thead>
	<tr>
		<th>计划随访时间</th>
		<th>实际随访时间</th>
	</tr>
	</thead>
	<tbody class="tbody">
	<c:forEach var="plan" items="${plans}">
		<tr class="plan-tr ${ empty plan.monitorDate ? 'to-follow-tr':'followed-tr' }" >
			<td style="text-align: center;position:relative;padding-left: 0px;">
					<span class="plan-date">
						<fmt:formatDate value='${plan.planDate}' pattern='yyyy/MM/dd' />
						<%--<c:if test="${plan.pastVistFlag&&empty plan.followupId}">
							<div style="color: red;position:absolute;right:5px;top:-5px;" title="逾期30天未做的随访">&nbsp;逾</div>
						</c:if>--%>
					</span>
				<input class="plan-id" type="hidden" value="${plan.id}" />
			</td>
			<td style="text-align: center;position:relative;padding-left: 0px;">
				<ehr:authorize ifAnyGranted="${ZXXG},${ZXG}">
					<c:if test="${empty plan.monitorDate}">
						<c:choose>
							<c:when test="${type eq '3'}">
								<c:if test="${plan.planType eq '1' && plan.notOverTime}"><%--计划内随访--%>
									<span  title="点击新建随访记录" style="cursor: pointer;" data-planid="${plan.id}"
										   data-monitorid="${plan.monitorId}" class="deal-plan"  onclick="ncpFollowupEdit.viewMonitor1('${plan.monitorId}','${plan.id}')">
									填写随访
								</span>
								</c:if>
								<c:if test="${plan.planType eq '2'}"><%--计划外随访--%>
									<span  title="点击新建随访记录" style="cursor: pointer;" data-planid="${plan.id}"
										   data-monitorid="${plan.monitorId}" class="deal-plan" onclick="ncpFollowupEdit.viewMonitor1('${plan.monitorId}','${plan.id}')">
									填写随访
								</span>
								</c:if>
							</c:when>
							<c:otherwise>
								<span  title="点击新建随访记录" style="cursor: pointer;" data-planid="${plan.id}"
									   data-monitorid="${plan.monitorId}" class="deal-plan" onclick="ncpFollowupEdit.viewMonitor1('${plan.monitorId}','${plan.id}')">
									填写随访
								</span>
							</c:otherwise>
						</c:choose>
					</c:if>
				</ehr:authorize>
				<c:if test="${not empty  plan.monitorDate }">
						<span title="点击查看/修改随访记录" style="cursor: pointer;" data-planid="${plan.id}"
							  data-monitorid="${plan.monitorId}" class="deal-plan"  onclick="ncpFollowupEdit.viewMonitor1('${plan.monitorId}','${plan.id}')">
							<fmt:formatDate value='${plan.monitorDate}' pattern='yyyy/MM/dd' />
							<%--<span style="color: red;" title="因随访不满意新增的随访">${plan.planType eq "2"?"追":""}</span>--%>
						</span>
				</c:if>
				<input class="followup-id"  type="hidden" value="${plan.monitorId}" />
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>

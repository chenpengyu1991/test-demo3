<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<table >
	<colgroup>
		<col style="width:60px;" />
		<col style="width:60px;" />
	</colgroup>
	<thead>
		<tr>
			<th>计划时间</th>
			<th>随访时间</th>
		</tr>
	</thead>
	<tbody class="tbody">
		<c:forEach var="plan" items="${plans}">
			<tr class="plan-tr ${ empty plan.followupId ? 'to-follow-tr':'followed-tr' }" style="cursor: pointer;">
				<td><fmt:formatDate value='${plan.planDate}' pattern='yyyy/MM/dd' /><input class="plan-id" type="hidden" value="${plan.id}" /> </td>
				<td title="点击新建或者修改随访记录"><c:if test="${empty  plan.followupId}">待随访</c:if><fmt:formatDate value='${plan.followupDate}' pattern='yyyy/MM/dd' /><input class="followup-id"  type="hidden" value="${plan.followupId}" /><input class="followup-flag"  type="hidden" value="${plan.followupFlag}" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

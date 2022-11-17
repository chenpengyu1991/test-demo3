<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/he/plan/edit.js" type="text/javascript"></script>

<form id="heWorkPlanForm">
	<div class="postcontent">
		<input type="hidden" name="id" value="${heWorkPlan.id}">
		<tag:dateInput name="createDate" id="createDate" date="${heWorkPlan.createDate}" style="display:none;"/>
		<input type="hidden" name="createUserCode" value="${heWorkPlan.createUserCode}">
		<table class="posttable">
			<colgroup>
				<col style="width: 20%;" />
				<col style="width: 30%;" />
				<col style="width: 20%;" />
				<col style="width: 30%;" />
			</colgroup>
			<tr>
				<th>填报人</th>
				<td>
					<ehr:user userCode="${heWorkPlan.createUserCode}"/>
				</td>
				<th>填报日期</th>
				<td>
					<fmt:formatDate value="${heWorkPlan.createDate}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th>计划类型</th>
				<td><ehr:dic code="${heWorkPlan.planType}" dicmeta="HE00033"/></td>
				<th></th>
				<td></td>
			</tr>
			<tr>
				<th>计划开始日期</th>
				<td>
					<fmt:formatDate value="${heWorkPlan.beginDate}" pattern="yyyy/MM/dd"/>
				</td>
				<th>计划结束日期</th>
				<td>
					<fmt:formatDate value="${heWorkPlan.endDate}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th>计划内容</th>
				<td colspan="6">${heWorkPlan.planContent}</td>
			</tr>
		</table>
	</div>
</form>

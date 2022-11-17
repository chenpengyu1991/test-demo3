<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script type="text/javascript">
$(function() {
		$("td[name='operateTime']").each(function() {
			$(this).html(util.formatOperateTime($(this).html()));
		});
});
</script>
<div class="repeattable" style="width: 98%;margin-left: 5px;">
<table class="layui-table x-admin-sm-table-list-small">
	<thead>
	<tr>
		<th width="150px">操作时间</th>
		<th width="100px">操作者</th>
		<th width="100px">操作类型</th>
		<th width="60px">主要编码</th>
		<th>附加编码</th>
		<th width="140px">疾病名称</th>
		<th width="50px">状态</th>
	</tr>
	</thead>
	<c:forEach items="${logList}" var="disease" varStatus="status">
		<tr>
			<td name="operateTime">${disease.operateTime}</td>
			<td>${disease.operator}</td>
			<td>${disease.operateType}</td>
			<td>${disease.icd10main}</td>
			<td>${disease.icd10ext}</td>
			<td>${disease.diseaseName}</td>
			<td>
				<c:if test="${disease.status eq -1}">作废</c:if>
				<c:if test="${disease.status eq 1}">有效</c:if>
			</td>
		</tr>
	</c:forEach>
</table>
<table>
	<tr>
		<ehr:pagination action="diseaseSearch.searchLog" />
	</tr>
</table>
<input type="hidden" id="diseaseId_log" value="${diseaseId}" />
</div>
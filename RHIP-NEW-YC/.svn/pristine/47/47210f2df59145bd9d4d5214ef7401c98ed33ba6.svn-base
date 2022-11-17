<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div style="overflow:auto">
<div class="repeattable" style="width: 98.5%">
    <table class="layui-table x-admin-sm-table-list-middle">
		<thead>
			<tr>
				<th rowspan="2">管理机构</th>
				<th colspan="3">常住</th>
				<th colspan="3">户籍</th>
				<th colspan="3">非户籍</th>
			</tr>
			<tr>
				<th>档案数(份)</th>
				<th>人口数(人)</th>
				<th>建档率</th>
				<th>档案数(份)</th>
				<th>人口数(人)</th>
				<th>建档率</th>
				<th>档案数(份)</th>
				<th>人口数(人)</th>
				<th>建档率</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${recordStatistics}" var="item">
				<tr>
					<td><tags:textWithTip value=" ${item.title}"></tags:textWithTip></td>
					<td style="text-align: right" ><tags:textWithTip value=" ${item.recordCount}"></tags:textWithTip></td>
					<td style="text-align: right"><tags:textWithTip value=" ${item.personCount}"></tags:textWithTip></td>
					<td style="text-align: right" title="<fmt:formatNumber pattern="#0.00%" type="percent" value=" ${item.recordOccupancy }"></fmt:formatNumber>"><fmt:formatNumber pattern="#0.00%" type="percent" value=" ${item.recordOccupancy }"></fmt:formatNumber></td>
					<td style="text-align: right"><tags:textWithTip value=" ${item.householdRecordCount}"></tags:textWithTip></td>
					<td style="text-align: right"><tags:textWithTip value=" ${item.householdPersonCount}"></tags:textWithTip></td>
					<td style="text-align: right" title="<fmt:formatNumber pattern="#0.00%" type="percent" value=" ${item.householdRecordOccupancy }"></fmt:formatNumber>"><fmt:formatNumber pattern="#0.00%" type="percent" value=" ${item.householdRecordOccupancy }"></fmt:formatNumber></td>
					<td style="text-align: right"><tags:textWithTip value=" ${item.unhouseholdRecordCount}"></tags:textWithTip></td>
					<td style="text-align: right"><tags:textWithTip value=" ${item.unhouseholdPersonCount}"></tags:textWithTip></td>
					<td style="text-align: right" title="<fmt:formatNumber pattern="#0.00%" type="percent" value=" ${item.unhouseholdPecordOccupancy }"></fmt:formatNumber>"><fmt:formatNumber pattern="#0.00%" type="percent" value=" ${item.unhouseholdPecordOccupancy }"></fmt:formatNumber></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</div>

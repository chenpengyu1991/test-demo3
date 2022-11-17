<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<div style="overflow:auto">
	<div class="repeattable"style="width: 98.5%">
	<table class="layui-table x-admin-sm-table-list-middle">
		<thead>
			<tr>
				<th rowspan="2" colspan="1">管理机构</th>
				<th rowspan="1" colspan="5">建档数(份)</th>
				<th colspan="4">建档率</th>
				<th rowspan="1" colspan="4">完整率</th>
				<th rowspan="1" colspan="3">二星及以上档案</th>
			</tr>
			<tr>
				<th>应建档数</th>
				<th>档案总数</th>
				<th>一星</th>
				<th>二星</th>
				<th>三星</th>
				<th>总建档率</th>
				<th>一星</th>
				<th>二星</th>
				<th>三星</th>
				<th>总完整率</th>
				<th>一星</th>
				<th>二星</th>
				<th>三星</th>
				<th style="width: 120px;" >建档数(份)</th>
				<th>建档率</th>
				<th>完整率</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${starStatisticsList}"  var="item">
			<tr>
			<td ><tags:textWithTip value=" ${item.title}"></tags:textWithTip></td>
			<td ><tags:numberLabel  value="${item.personCount}" /></td>
			<td ><tags:numberLabel  value="${item.recordCount}" /></td>
			<td style="text-align: right"><tags:textWithTip value=" ${item.oneStarRecordCount}"></tags:textWithTip></td>
			<td style="text-align: right"><tags:textWithTip value=" ${item.twoStarRecordCount}"></tags:textWithTip></td>
			<td style="text-align: right"><tags:textWithTip value=" ${item.threeStarRecordCount}"></tags:textWithTip></td>

			<td style="text-align: right" title="<fmt:formatNumber  pattern="#0.00%" type="percent" value=" ${item.recordOccupancy}"></fmt:formatNumber>"><fmt:formatNumber  pattern="#0.00%" type="percent" value=" ${item.recordOccupancy}"></fmt:formatNumber></td>
			<td style="text-align: right" title="<fmt:formatNumber  pattern="#0.00%" type="percent" value=" ${item.oneStarRecordOccupancy}" ></fmt:formatNumber>"><fmt:formatNumber  pattern="#0.00%" type="percent" value=" ${item.oneStarRecordOccupancy}" ></fmt:formatNumber></td>
			<td style="text-align: right" title="<fmt:formatNumber  pattern="#0.00%" type="percent" value=" ${item.twoStarRecordOccupancy}" ></fmt:formatNumber>"><fmt:formatNumber  pattern="#0.00%" type="percent" value=" ${item.twoStarRecordOccupancy}" ></fmt:formatNumber></td>
			<td style="text-align: right" title="<fmt:formatNumber  pattern="#0.00%" type="percent" value=" ${item.threeStarRecordOccupancy}" ></fmt:formatNumber>"><fmt:formatNumber  pattern="#0.00%" type="percent" value=" ${item.threeStarRecordOccupancy}" ></fmt:formatNumber></td>

			<td style="text-align: right" title="<fmt:formatNumber  pattern="#0.00%" type="percent" value=" ${item.recordIntegrity}" ></fmt:formatNumber>"><fmt:formatNumber  pattern="#0.00%" type="percent" value=" ${item.recordIntegrity}" ></fmt:formatNumber></td>
			<td style="text-align: right" title="<fmt:formatNumber pattern="#0.00%" type="percent"  value="${item.oneStarRecordIntegrity}"></fmt:formatNumber>"><fmt:formatNumber pattern="#0.00%" type="percent"  value="${item.oneStarRecordIntegrity}"></fmt:formatNumber></td>
			<td style="text-align: right" title="<fmt:formatNumber pattern="#0.00%" type="percent"  value="${item.twoStarRecordIntegrity}"></fmt:formatNumber>"><fmt:formatNumber pattern="#0.00%" type="percent"  value="${item.twoStarRecordIntegrity}"></fmt:formatNumber></td>
			<td style="text-align: right" title="<fmt:formatNumber pattern="#0.00%" type="percent"  value="${item.threeStarRecordIntegrity}"></fmt:formatNumber>"><fmt:formatNumber pattern="#0.00%" type="percent"  value="${item.threeStarRecordIntegrity}"></fmt:formatNumber></td>


			<td style="text-align: right"><tags:textWithTip value=" ${item.twoAboveStarRecordCount}"></tags:textWithTip></td>
			<td style="text-align: right" title="<fmt:formatNumber pattern="#0.00%" type="percent"  value="${item.twoAboveStarRecordOccupancy}"></fmt:formatNumber>"><fmt:formatNumber pattern="#0.00%" type="percent"  value="${item.twoAboveStarRecordOccupancy}"></fmt:formatNumber></td>
			<td style="text-align: right" title="<fmt:formatNumber pattern="#0.00%" type="percent"  value="${item.twoAboveStarRecordIntegrity}"></fmt:formatNumber>"><fmt:formatNumber pattern="#0.00%" type="percent"  value="${item.twoAboveStarRecordIntegrity}"></fmt:formatNumber></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
</div>

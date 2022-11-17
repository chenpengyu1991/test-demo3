<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="repeattable" style="width: 99.5%">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:150px;width: 22%;"/>
			<!-- <col style="min-width:60px;"/> -->
	        <col style="min-width:60px;"/>
			<col style="min-width:60px;"/>
	        <col style="min-width:60px;"/>
	        <col style="min-width:60px;"/>
	        <col style="min-width:60px;"/>
	        <col style="min-width:60px;"/>
	        <col style="min-width:60px;"/>
			<col style="min-width:60px;"/>
	        <col style="min-width:60px;"/>
	        <col style="min-width:60px;"/>
		</colgroup>
		<thead>
			<tr>
				<th>机构/乡镇</th>
				<!-- <th>合计</th> -->
				<th>正高</th>
				<th>副高</th>
				<th>中级</th>
				<th>师级（助理）</th>
				<th>士级</th>
				<th>其他</th>

				<th>临床</th>
				<th>公卫</th>
				<th>中医</th>
				<th>口腔</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="health" items="${healthlist}" varStatus="status">
				<tr>
					<td style="text-align: center"><ehr:tip>${health.ORGAN_NAME}</ehr:tip></td>
					<!-- <td style="text-align: center">${health.COUNT_ROW}</td> -->
					<td style="text-align: center">${health.COUNT1}</td>
					<td style="text-align: center">${health.COUNT2}</td>
					<td style="text-align: center">${health.COUNT3}</td>
					<td style="text-align: center">${health.COUNT4}</td>
					<td style="text-align: center">${health.COUNT5}</td>
					<td style="text-align: center">${health.COUNT6}</td>
					<td style="text-align: center">${health.COUNT7}</td>
					<td style="text-align: center">${health.COUNT8}</td>
					<td style="text-align: center">${health.COUNT9}</td>
					<td style="text-align: center">${health.COUNT10}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
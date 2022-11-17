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
			<!-- <col style="min-width:80px;width: 6%;"/> -->
	        <col style="min-width:80px;width: 6%;"/>
			<col style="min-width:80px;width: 6%;"/>
	        <col style="min-width:80px;width: 6%;"/>
	        <col style="min-width:80px;width: 6%;"/>
	        <col style="min-width:80px;width: 6%;"/>
	        <col style="min-width:80px;width: 6%;"/>
	        <col style="min-width:80px;width: 6%;"/>
			<col style="min-width:80px;width: 6%;"/>
	        <col style="min-width:80px;width: 6%;"/>
	        <col style="min-width:80px;width: 6%;"/>
	        <col style="min-width:80px;width: 6%;"/>
	        <col style="min-width:80px;width: 6%;"/>
		</colgroup>
		<thead>
			<tr>
				<th>机构/乡镇</th>
				<!-- <th>合计</th> -->
				<th>卫生人员</th>
				<th>卫生技<br/>术人员</th>
				<th>执业(助<br/>理)医师</th>
				<th>注册护士</th>
				<th>卫生<br/>监督员</th>
				<th>管理人员</th>

				<th>在编</th>
				<th>事业人<br/>事代理</th>
				<th>占编劳<br/>动合同</th>
				<th>编外人员</th>
				<th>退休返聘</th>
				<th>乡村医生</th>
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
					<td style="text-align: center">${health.COUNT11}</td>
					<td style="text-align: center">${health.COUNT12}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
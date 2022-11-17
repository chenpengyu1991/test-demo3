<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
	<table>
		<colgroup>
			<col style="min-width:150px;width: 20%;"/>
	        <col style="min-width:80px;width: 30%;"/>
			<col style="min-width:80px;width: 30%;"/>
	        <col style="min-width:80px;width: 20%;"/>
		</colgroup>
		<thead>
			<tr>
				<th>姓名</th>
				<th>身份证号</th>
				<th>机构</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="womanDisease" items="${womanDiseaseList}" varStatus="status">
				<tr>
					<td style="text-align: center">${womanDisease.name}</td>
					<td style="text-align: center">${womanDisease.id_card}</td>
					<td style="text-align: center">${womanDisease.create_organ_name}</td>
					<td style="text-align: center">
					    <a href="javascript:void(0)" onclick="fpSearch.womanDiseaseDetail('${womanDisease.id}')">查看</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<tr>
			<ehr:pagination action="fpSearch.search"/>
		</tr>
	</table>
</div>
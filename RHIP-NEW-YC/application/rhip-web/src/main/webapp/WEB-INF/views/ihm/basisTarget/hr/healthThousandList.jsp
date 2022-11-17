<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="repeattable" style="width: 99.5%">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:150px;width: 20%;"/>
			<!-- <col style="min-width:120px;width: 20%;"/> -->
	        <col style="min-width:120px;width: 20%;"/>
			<col style="min-width:80px;width: 20%;"/>
	        <col style="min-width:80px;width: 20%;"/>
		</colgroup>
		<thead>
			<tr>
				<th>机构/乡镇</th>
				<!-- <th>合计</th> -->
				<th>每千人卫生技术人员</th>
                <th>每千人执业(助理)医师</th>
                <th>每千人注册护士</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="health" items="${healthlist}" varStatus="status">
				<tr>
					<td style="text-align: center"><ehr:tip>${health.ORGAN_NAME}</ehr:tip></td>
					<!-- <td style="text-align: center">${health.COUNT_ROW}</td> -->
					<td style="text-align: center">${health.COUNT2}</td>
					<td style="text-align: center">${health.COUNT3}</td>
					<td style="text-align: center">${health.COUNT4}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
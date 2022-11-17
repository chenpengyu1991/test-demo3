<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="repeattable" style="width: 99.5%">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
		    <col style="min-width:150px;width: 30%;"/>
			<col style="min-width:150px;"/>
	        <col style="min-width:120px;"/>
		</colgroup>
		<thead>
			<tr>
			    <th>医疗机构</th>
				<th>核准床位数</th>
				<th>开放床位数</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="organization" items="${organizations}" varStatus="status">
				<tr>
				    <td style="text-align: center">${organization.organName}</td>
					<td style="text-align: center">${organization.bedCount}</td>
					<td style="text-align: center">${organization.openBedCount}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-small">
		<colgroup>
			<col style="width:20%;"/>
			<col style="width:20%;"/>
	        <col style="width:30%;"/>
	        <col style="width:25%;"/>
		</colgroup>	
		<thead>
			<tr>
				<th>追踪时间</th>	
				<th>追踪结果</th>
				<th>追踪单位</th>
				<th>追踪医生</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="traceRecord" items="${traceRecodes}" varStatus="status">
				<tr>
					<td class="centertd"><fmt:formatDate value="${traceRecord.createDt}" pattern="yyyy/MM/dd"/> </td>
					<td class="centertd"><ehr:dic code="${traceRecord.transferStatus}" dicmeta="IDM00255"/></td>
					<td><ehr:org code="${traceRecord.createUnit}"/> </td>
					<td><ehr:user userCode="${traceRecord.createUser}"/> </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<tr>
			<ehr:pagination action="transfertreat.searchRecord" colspan="4" />
		</tr>
	</table>
</div>
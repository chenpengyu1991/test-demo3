<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable" style="width: 98%;margin-left: 5px;">
	<table id="result_table" class="layui-table x-admin-sm-table-list-small">
		<thead>
			<tr>
				<th style="width: 30%;">调阅机构</th>
				<th style="width: 30%;">调阅人</th>
				<th style="width: 30%;">调阅时间</th>
			</tr>
		</thead>
		<tbody class="tbody">
			<c:forEach items="${readHealthRecords}" var="record">
				<tr>
					<td><ehr:org code="${record.readerOrgancode}"></ehr:org></td>
					<td><c:out value="${record.readerName}"></c:out></td>
					<td><fmt:formatDate value="${record.readDate}" pattern="yyyy/MM/dd"/></td>
				</tr>
			</c:forEach>
			<tr>
				<ehr:pagination action="readRecordJS.pagination" colspan="3" />
			</tr>
		</tbody>
		<%-- <ehr:pagination action="readRecordJS.pagination" colspan="3" /> --%>
	</table>
</div>
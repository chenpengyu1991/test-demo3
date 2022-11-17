<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="repeattable">
	<thead>
		<tr>
			<th>申请日期</th>
			<th>检查单号</th>
			<th>检查类型</th>
			<th>结论</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${studyEvents}" var="studyEvent">
			<tr>
				<td><fmt:formatDate value="${studyEvent.applyDate}" pattern="yyyy/MM/dd" /></td>
				<td><c:out value="${studyEvent.recordNumber}"></c:out></td>
				<td><ehr:dic dicmeta="FS10249" code="${studyEvent.inspectionType}"/></td>
				<td><tags:textWithTip value="${studyEvent.conclusionDesc}"></tags:textWithTip></td>
			</tr>
		</c:forEach>
	</tbody>
</table>



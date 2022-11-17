<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/ehr-tag" prefix="ehr" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<table class="layui-table x-admin-sm-table-list-middle">
	<colgroup>
		<col style="min-width:150px;width: 25%;"/>
		<col style="min-width:80px;"/>
		<c:forEach  var="icd10" items="${icd10list}">
			<col style="min-width:80px;"/>
		</c:forEach>
	</colgroup>
	<thead>
		<tr>
			<th>医疗机构</th>
			<th>合计</th>
			<c:forEach  var="icd10l" items="${icd10list}">
				<th title="${icd10l.deathReason}">${icd10l.deathIcd}</th>
			</c:forEach>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="personDeathRecord" items="${personDeathRecords}" varStatus="status">
			<tr>
				<td>
					<c:choose>
						<c:when test="${personDeathRecord.inputOrgancode=='合计' }"><b><ehr:tip>${personDeathRecord.inputOrgancode }</ehr:tip></b></c:when>
						<c:otherwise><ehr:tip><ehr:org code="${personDeathRecord.inputOrgancode}"/> </ehr:tip></c:otherwise>
					</c:choose>
				</td>
				<td><tags:numberLabel  defaultValue="0"  value="${personDeathRecord.total}" type="number"/></td>
				<c:if test="${fn:length(icd10list)>=1}">
					<td><tags:numberLabel  defaultValue="0"  value="${personDeathRecord.one}" type="number"/></td>
				</c:if>
				<c:if test="${fn:length(icd10list)>=2}">
					<td><tags:numberLabel  defaultValue="0"  value="${personDeathRecord.two}" type="number"/></td>
				</c:if>
				<c:if test="${fn:length(icd10list)>=3}">
					<td><tags:numberLabel  defaultValue="0"  value="${personDeathRecord.three}" type="number"/></td>
				</c:if>
				<c:if test="${fn:length(icd10list)>=4}">
					<td><tags:numberLabel  defaultValue="0"  value="${personDeathRecord.four}" type="number"/></td>
				</c:if>
				<c:if test="${fn:length(icd10list)>=5}">
					<td><tags:numberLabel  defaultValue="0"  value="${personDeathRecord.five}" type="number"/></td>
				</c:if>
				<c:if test="${fn:length(icd10list)>=6}">
					<td><tags:numberLabel  defaultValue="0"  value="${personDeathRecord.six}" type="number"/></td>
				</c:if>
				<c:if test="${fn:length(icd10list)>=7}">
					<td><tags:numberLabel  defaultValue="0"  value="${personDeathRecord.seven}" type="number"/></td>
				</c:if>
				<c:if test="${fn:length(icd10list)>=8}">
					<td><tags:numberLabel  defaultValue="0"  value="${personDeathRecord.eight}" type="number"/></td>
				</c:if>
				<c:if test="${fn:length(icd10list)>=9}">
					<td><tags:numberLabel  defaultValue="0"  value="${personDeathRecord.nine}" type="number"/></td>
				</c:if>
				<c:if test="${fn:length(icd10list)>=10}">
					<td><tags:numberLabel  defaultValue="0"  value="${personDeathRecord.ten}" type="number"/></td>
				</c:if>
			</tr>
		</c:forEach>
	</tbody>
</table>

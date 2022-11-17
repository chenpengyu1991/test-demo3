<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<div class="repeattable">
	<table>
		<colgroup>
			<col style="width: 200px;" />
			<col style="width: 100px;" />
			<col style="width: 100px;" />
			<col style="width: 100px;" />
			<col style="width: 100px;" />
			<col style="width: 100px;" />
		</colgroup>
		<thead>
			<tr>
				<th>学校</th>
				<th>应检人数</th>
				<th>录入人数</th>
				<th>录入率</th>
				<th>打印人数</th>
				<th>打印率</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="progress" items="${progresslist}">
				<tr>
					<td>${progress.schoolName}</td>
					<td>${progress.shouldNum}</td>
					<td>${progress.actualNum}</td>
					<td><fmt:formatNumber pattern="#0.00%" type="percent" value="${progress.examRate}"></fmt:formatNumber></td>
					<td>${progress.printCount}</td>
					<td><fmt:formatNumber pattern="#0.00%" type="percent" value="${progress.printRate}"></fmt:formatNumber></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<tr>
			<ehr:pagination action="progressSearch.search" />
		</tr>
	</table>	
</div>
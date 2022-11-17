<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="repeattable">
    <table id="planImmuTable">
		<thead>
			<tr>
				<c:forEach items="${dateList}" var="d">
					<th colspan="2"><fmt:formatDate value="${d}" pattern="MM月dd日"/></th>
				</c:forEach>
			</tr>
			<tr>
				<c:forEach items="${dateList}" var="d">
					<th>应传数量</th>
					<th>实传数量</th>
				</c:forEach>
			</tr>
		</thead>
		<tbody>
			<tr>
				<c:forEach items="${genericMonitorList}" var="m">
					<td style="text-align: left" >${m.shouldCount}</td>
					<td style="text-align: left" >${m.actualCount}</td>
				</c:forEach>
			</tr>
		</tbody>
	</table>
</div>

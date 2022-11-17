<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="repeattable">
    <div id="drugCategoryTopDiv" >
    <table id="drugCategoryTable">
		<thead>
			<tr>
				<th  rowspan="2" style="width: 110px;">医院名称</th>
				<c:forEach items="${dateList}" var="d">
					<th colspan="2"><fmt:formatDate value="${d}" pattern="MM月dd日"/></th>
				</c:forEach>
			</tr>
			<tr>
				<c:forEach items="${dateList}" var="d">
					<th>应传数量</th>
					<th>实际数量</th>
				</c:forEach>
			</tr>
		</thead>
    </table>
    <div id="drugCategoryDiv" class="contentfixed149">
    <table>
		<tbody>
			<c:forEach items="${drugMonitorRecordList}" var="drugMonitorRecord">
			<tr>
				<td style="width: 100px;"><tags:textWithTip value="${drugMonitorRecord.organization.organName}"></tags:textWithTip></td>
				<c:forEach items="${drugMonitorRecord.genericMonitors}" var="m">
					<td style="text-align: left" >${m.shouldCount}</td>
					<td style="text-align: left" >${m.actualCount}</td>
				</c:forEach>
			</tr>
			</c:forEach>
		</tbody>
	</table>
    </div>
    </div>
</div>

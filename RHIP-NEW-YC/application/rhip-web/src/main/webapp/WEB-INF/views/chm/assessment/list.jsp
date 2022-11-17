<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.idm.common.ReportStatus" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<div class="repeattable">
	<table>
		<colgroup>
			<col style="min-width:60px;width: 20%;"/>
	        <col style="min-width:120px;width: 20%;"/>
			<col style="min-width:40px;width: 30%;"/>
	        <col style="min-width:100px;width: 30%;"/>			
		</colgroup>	
		<thead>
			<tr>
				<th>员工ID</th>
				<th>被考核人</th>
				<th>所属单位</th>
				<th>统计结果</th>				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="report" items="${reports.list}" varStatus="status">
				<tr>
					<td title="${report.personCode}">${report.personCode}</td>
					<td title="${report.personName}" class="centertd">${report.personName}</td>
					<td title="${report.unit}">${report.unit}</td>
					<td title="${report.resultNum}">${report.resultNum}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="statisticsSearch.search" />
		</tr>
	</table>
</div>
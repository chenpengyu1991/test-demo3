<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.idm.common.ReportStatus" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<div class="repeattable">
	<table>
		<colgroup>
			<col style="min-width:60px;width: 30%;"/>
	        <col style="min-width:120px;width: 22%;"/>
			<col style="min-width:40px;width: 16%;"/>
	        <col style="min-width:100px;width: 16%;"/>	
	        <col style="min-width:100px;width: 16%;"/>		
		</colgroup>	
		<thead>
			<tr>
				<th>医疗机构</th>
				<th>统计时段</th>
				<th>门诊抗生素比例(%)</th>				
				<th>急诊抗生素比例(%)</th>
				<th>二联抗生素比例(%)</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="report" items="${reports.list}" varStatus="status">
				<tr>
					<td title="${report.unit}">${report.unit}</td>
					<td title="${report.period}" class="centertd">${report.period}</td>
					<td title="${report.atbtcRatio}">${report.atbtcRatio}</td>
					<td title="${report.atbtcEopRatio}">${report.atbtcEopRatio}</td>
					<td title="${report.antibioticTwoRatio}">${report.antibioticTwoRatio}</td>
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
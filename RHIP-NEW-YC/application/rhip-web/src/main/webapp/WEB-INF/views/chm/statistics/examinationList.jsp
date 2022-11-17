<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.idm.common.ReportStatus" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<div class="repeattable">
	<table>
		<colgroup>
			<col style="min-width:60px;width: 15%;"/>
	        <col style="min-width:120px;width: 23%;"/>
			<col style="min-width:40px;width: 8%;"/>
	        <col style="min-width:100px;width: 8%;"/>	
	        <col style="min-width:100px;width: 8%;"/>
	        
	        <col style="min-width:100px;width: 8%;"/>		
	        <col style="min-width:100px;width: 10%;"/>		
	        <col style="min-width:100px;width: 10%;"/>		
	        <col style="min-width:100px;width: 10%;"/>				
		</colgroup>	
		<thead>
			<tr>
				<th rowspan="2">医疗机构</th>
				<th rowspan="2">统计时段</th>
				<th colspan="2">门诊与住院CT次数</th>				
				<th colspan="2">X-线门诊住院次数</th>
				<th rowspan="2">B超例数（门诊与住院）</th>
				<th rowspan="2">心电图例数（门诊与住院）</th>
				<th rowspan="2">胃镜例数（门诊与住院）</th>
			</tr>
			<tr>
				<th>门诊CT数</th>
				<th>住院CT数</th>				
				<th>X-线门诊数</th>
				<th>X-线门诊数</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="report" items="${reports.list}" varStatus="status">
				<tr>
					<td title="${report.unit}">${report.unit}</td>
					<td title="${report.period}" class="centertd">${report.period}</td>
					<td title="${report.outpatientCtNum}">${report.outpatientCtNum}</td>
					<td title="${report.inpatientCtNum}">${report.inpatientCtNum}</td>
					<td title="${report.outpatientXrayNum}">${report.outpatientXrayNum}</td>
					
					<td title="${report.inpatientXrayNum}">${report.inpatientXrayNum}</td>
					<td title="${report.bUltrasoundNum}">${report.bUltrasoundNum}</td>
					<td title="${report.electrocardiogramNum}">${report.electrocardiogramNum}</td>
					<td title="${report.gastroscopeNum}">${report.gastroscopeNum}</td>
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
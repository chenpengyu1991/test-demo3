<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.idm.common.ReportStatus" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<div class="repeattable">
	<table>
		<colgroup>
			<col style="min-width:60px;width: 15%;"/>
			<col style="min-width:40px;width: 15%;"/>
	        <col style="min-width:100px;width: 15%;"/>	
	        <col style="min-width:40px;width: 15%;"/>	
	        <col style="min-width:40px;width: 20%;"/>
	        <col style="min-width:40px;width: 20%;"/>
		</colgroup>	
		<thead>
			<tr>
				<th>医疗机构</th>
				<th>统计时间</th>
				<th>新发现2型糖尿病患者数</th>
				<th>累计管理2型糖尿病患者数</th>
				<th>规范管理2型糖尿病患者数</th>	
				<th>最近一次随访血糖达标患者数</th>				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="report" items="${reports.list}" varStatus="status">
				<tr>
					<td ><ehr:tip> 
					<ehr:org code="${report.organCode}" />
					</ehr:tip></td>
					<td ><ehr:tip>${report.period}</ehr:tip></td>
					<td ><ehr:tip>${report.argOutpEmergencyFee}</ehr:tip></td>
					<td ><ehr:tip>${report.medicinalFeePer}%</ehr:tip></td>
					<td ><ehr:tip>${report.allFee}</ehr:tip></td>
					<td ><ehr:tip>${report.outpatientNum}</ehr:tip></td>
					<td ><ehr:tip>${report.emergencyNum}</ehr:tip></td>
					<td><ehr:tip>${report.infusionRate }</ehr:tip></td>
					<td><ehr:tip>${report.antibioticRate }</ehr:tip></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<%-- <ehr:pagination action="mcSearch.search" /> --%>
		</tr>
	</table>
</div>
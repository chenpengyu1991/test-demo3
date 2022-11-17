<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<div class="repeattable">
	<table id="selfchecktable">
		<thead>
			<tr style="text-align: center;">
				<td style="border:none;width:60px"></td>
				<td style="border:none;width:${fn:length(infections)*2*50 + 600}px" colspan="${fn:length(infections)*2 + 4}">
					<h1 style="font-size:150%;margin: 20px 0px 20px 0px"><ehr:org code="${reportUnitCode}"/>${reportMonth}《传染病防治法》执行情况自查报表</h1>
				</td>
				<td style="border:none;width:60px"></td>
			</tr>
			<tr>
				<th rowspan="2" colspan="2" style="width:200px">抽查内容及部门</th>
				<th rowspan="2" style="width:60px">抽查病例数</th>
				<th rowspan="2" style="width:60px">应报数</th>
				<th rowspan="2" style="width:60px">漏报数</th>
				<th rowspan="2" style="width:100px;">漏报率%</th>
				<c:forEach var="infection" items="${infections}" varStatus="status">
					<c:set var="infectionSize" value="${fn:length(infections)}" scope="request"></c:set>
					<th colspan="2" style="width:100px"><ehr:dic dicmeta="CV0501017" code="${infection.infectiousCode}"/></th>
				</c:forEach>
			</tr>
			<tr>
				<c:forEach var="infection" items="${infections}" varStatus="status">
					<th style="width:50px">应报</th>
					<th style="width:50px">漏报</th>
				</c:forEach>
			</tr>			
		</thead>
		<tbody>
			<c:forEach var="selfCheck" items="${selfChecks}" varStatus="selfCheckStatus">
				<tr>
					<c:if test="${selfCheckStatus.count == 1}">
						<td rowspan="${fn:length(selfChecks) + 1}"  style="width:60px"><ehr:tip>法定传染病报告</ehr:tip></td>
					</c:if>
					<td><ehr:tip><ehr:dic dicmeta="IDM00333" code="${selfCheck.departmentCode}"/></ehr:tip></td>
					<td><tags:numberLabel value="${selfCheck.checkNum}"/></td>
					<td><tags:numberLabel value="${selfCheck.shouldNum}"/></td>
					<td><tags:numberLabel value="${selfCheck.missNum}"/></td>
					<td><tags:numberLabel fractionDigits="2" type="percent" value="${selfCheck.missRate/100}"/></td>
					<c:forEach var="infection" items="${selfCheck.listScDcs}" varStatus="infectionStatus">
						<td><tags:numberLabel value="${infection.shouldNum}"/></td>
						<td><tags:numberLabel value="${infection.missNum}"/></td>
					</c:forEach>
				</tr>
			</c:forEach>
			<tr>
				<td>合计</td>
				<td><b><tags:numberLabel value="${summary.checkNum}"/></b></td>
				<td><b><tags:numberLabel value="${summary.shouldNum}"/></b></td>
				<td><b><tags:numberLabel value="${summary.missNum}"/></b></td>		
				<td><b><tags:numberLabel fractionDigits="2" type="percent" value="${summary.missRate/100}"/></b></td>	
				<c:forEach var="summaryInfection" items="${summary.listScDcs}" varStatus="summaryInfectionStatus">
					<td>
						<b><tags:numberLabel value="${summaryInfection.shouldNum}"/></b>
					</td>
					<td>
						<b><tags:numberLabel value="${summaryInfection.missNum}"/></b>
					</td>
				</c:forEach>		
			</tr>
			<tr>
				<td colspan="2" rowspan="2">新生儿产房接种</td>
				<td colspan="${infectionSize*2 + 4}">
					新生儿 <b><c:if test="${empty neonate.neonateNum}">____</c:if>${neonate.neonateNum}</b>
					人(其中三类新生儿<b><c:if test="${empty neonate.threeNeonateNum}">____</c:if>${neonate.threeNeonateNum}</b>人)
					,乙肝疫苗：应种<b><c:if test="${empty neonate.hbvShouldNum}">____</c:if>${neonate.hbvShouldNum}</b>
					人,实种<b><c:if test="${empty neonate.hbvActualNum}">____</c:if>${neonate.hbvActualNum}</b>人,
					接种率<b><c:if test="${empty neonate.hbvActualRate}">____</c:if>${neonate.hbvActualRate}</b>%
				</td>
			</tr>
			<tr>
				<td colspan="${infectionSize*2 + 4}">
					卡介苗：应种<b><c:if test="${empty neonate.bcgShouldNum}">____</c:if>${neonate.bcgShouldNum}</b>
					人,实种<b><c:if test="${empty neonate.bcgActualNum}">____</c:if>${neonate.bcgActualNum}</b>人,
					接种率<b><c:if test="${empty neonate.bcgActualRate}">____</c:if>${neonate.bcgActualRate}</b>%
				</td>
			</tr>
			<tr>
				<td style="border:none;text-align: left;" colspan="${fn:length(infections)*2 + 6}">
					<div> 填表要求：各单位每月开展一次《传染病防治法》执行情况自查，将自查情况填写于本报表，于每月3日前将上个月的自查报表</div>
				</td>
			</tr>	
			<tr>
				<td style="border:none;text-align: left;" colspan="${fn:length(infections)*2 + 6}">
					<span style="margin: 0px 20px 20px 0px">填表单位</span>
					<span style="margin: 0px 10px 0px 0px"><b><ehr:org code="${reportUnitCode}"/></b></span>
					<span style="margin: 0px 20px 20px 0px">调查人：</span>
					<span style="margin: 0px 10px 0px 0px"><b><ehr:user userCode="${reportUserCode}"/></b></span>
					<span style="margin: 0px 20px 20px 0px">填表人：</span>
					<span style="margin: 0px 10px 0px 0px"><b><ehr:user userCode="${reportUserCode}"/></b></span>
					<span style="margin: 0px 100px 20px 0px">填表日期：<b><fmt:formatDate pattern="yyyy/MM/dd" value="${reportDate}"/></b></span>
				</td>
			</tr>								
		</tbody>
	</table>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<div class="repeattable">
	<table id="childCensusTable">
		<thead>
			<tr>
				<th rowspan="2">单位</th>
				<th colspan="7">0-6岁儿童健康管理统计报表</th>
			</tr>
			<tr>
				<th>新生儿访视人次数</th>
				<th>1-8月龄儿童健康检查人次数</th>
				<th>12-30月龄儿童健康检查人次数</th>
				<th>3-6岁龄儿童健康检查人次数</th>
				<th>0-36个月中医药健康管理儿童数</th>
				<th>0-6岁中医药健康管理儿童数</th>
				<th>儿童死亡报告卡</th>
			</tr>
		</thead>
		<tbody id="displayBody">
			<c:forEach var="report" items="${reports}">
				<tr>
					<td>
						<c:choose>
							<c:when test="${not empty all}">
								<ehr:tip><ehr:org code="${report.orgCode}" /></ehr:tip>
							</c:when>
							<c:when test="${empty orgCode && empty centerOrgCode && empty gbcode}">
								<ehr:tip><ehr:dic code="${report.orgCode}" dicmeta="FS990001"  /></ehr:tip>
							</c:when>
							<c:when test="${not empty orgCode || not empty centerOrgCode || not empty gbcode}">
								<ehr:tip><ehr:org code="${report.orgCode}" /></ehr:tip>
							</c:when>
						</c:choose>
						<c:if test="${report.orgCode eq '_999'}"><ehr:tip>健康教育所</ehr:tip></c:if>
					</td>
					<td>${report.visitCount}</td>
					<td>${report.examineCount1}</td>
					<td>${report.examineCount2}</td>
					<td>${report.examineCount6}</td>
					<td>${report.tcmCount1 + report.tcmCount2}</td>
					<td>${report.tcmCount1 + report.tcmCount2 + report.tcmCount6}</td>
					<td>${report.deathCount}</td>
				</tr>
			</c:forEach>
			<tr>
				<td><strong>合计</strong></td>
				<td>${census.visitSum}</td>
				<td>${census.examineSum1}</td>
				<td>${census.examineSum2}</td>
				<td>${census.examineSum6}</td>
				<td>${census.tcmSum1 + census.tcmSum2}</td>
				<td>${census.tcmSum1 + census.tcmSum2 + census.tcmSum6}</td>
				<td>${census.deathSum}</td>
			</tr>
		</tbody>
	</table>
</div>
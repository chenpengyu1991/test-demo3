<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>


<div class="repeattable" style="width:100%;overflow:auto;height:450px;">
	<table id="familyStatisticsTable" class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width: 70px;" />
			<col style="width: 130px;" />
			<col style="width: 60px;" />
			<col style="width: 70px;" />
		</colgroup>
		<thead>
			<tr>
				<th rowspan="2">区县</th>
				<th rowspan="2">机构</th>
				<th colspan="2">家庭档案统计报表</th>
			</tr>
			<tr>
				<th>家庭档案建档数</th>
				<th>家庭档案建档率</th>
			</tr>
		</thead>
		<tbody id="displayBody">
			 <c:forEach var="report" items="${reports}" >
				<tr>
					<td>
						<ehr:tip><ehr:dic code="${report.gbCode}" dicmeta="FS990001"  /></ehr:tip>
					</td>
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
					</td>
					<!-- 家庭档案建档数 -->
					<td title="${report.recordFamilyNum}">${report.recordFamilyNum}</td>
					
					<!-- 家庭档案建档率 -->
					<td title="<fmt:formatNumber value="${report.familyNum==0?0:(report.recordFamilyNum/report.familyNum)*100}" pattern="#,##0.00"/>%">
						<fmt:formatNumber value="${report.familyNum==0?0:(report.recordFamilyNum/report.familyNum)*100}" pattern="#,##0.00"/>%
					</td>

				</tr>
			</c:forEach>
			<c:if test="${familyStatisticDto!=null}">
				<tr>
					<td colspan="2"><strong>合计</strong></td>
						<!-- 家庭档案建档数 -->
						<td title="${familyStatisticDto.recordFamilyNum}">${familyStatisticDto.recordFamilyNum}</td>

						<!-- 家庭档案建档率 -->
						<td title="<fmt:formatNumber value="${familyStatisticDto.recordFamilyRate}" pattern="#,##0.00"/>%">
							<fmt:formatNumber value="${familyStatisticDto.recordFamilyRate}" pattern="#,##0.00"/>%
						</td>
				</tr>
			</c:if>
		</tbody>
	</table>
</div>
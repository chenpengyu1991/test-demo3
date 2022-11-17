<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>


<div class="repeattable">
	<table id="healthVaccinationTable" class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width: 40px;" />
			<col style="width: 100px;" />
			<col style="width: 45px;" />
			<col style="width: 45px;" />
			<col style="width: 45px;" />
			<col style="width: 45px;" />
			<col style="width: 45px;" />
			<col style="width: 45px;" />
			<col style="width: 45px;" />
			<col style="width: 45px;" />
			<col style="width: 45px;" />
		</colgroup>
		<thead>
			<tr>
				<th rowspan="2">区县</th>
				<th rowspan="2">机构</th>
				<th colspan="9">2型糖尿病患者健康管理统计报表</th>
			</tr>
			<tr>
				<th>辖区内已管理的2型糖尿病患者人数</th>
				<th>按照规范要求进行2型糖尿病患者健康管理的人数</th>
				<th>2型糖尿病患者规范管理率</th>
				<th>最近一次随访空腹血糖达标人数</th>
				<th>管理人群血糖控制率</th>
				<th>在管糖尿病患者家庭医生签约人数</th>
				<th>糖尿病患者人数</th>
				<th>糖尿病患者管理率</th>
				<th>最近一次餐后2小时血糖达标人数</th>
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
							<c:when test="${empty report.orgCode && empty report.centerOrgCode && empty report.gbcode}">
								<ehr:tip><ehr:dic code="${report.orgCode}" dicmeta="FS990001"  /></ehr:tip>
							</c:when>
							<c:when test="${not empty report.orgCode || not empty report.centerOrgCode || not empty report.gbcode}">
								<ehr:tip><ehr:org code="${report.orgCode}" /></ehr:tip>
							</c:when>
						</c:choose>
					</td>
					<!-- 已管理人数 -->
					<td title="${report.diCount}">${report.diCount}</td>
					<!-- 按照规范要求进行健康管理的人数-->
					<td title="${report.diManageCount}">${report.diManageCount}</td>
					<!-- 规范管理率 -->
					<td title="<fmt:formatNumber value="${report.diCount==0?0:(report.diManageCount/report.diCount)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${report.diCount==0?0:(report.diManageCount/report.diCount)*100}" pattern="#,##0.0"/>% 
					</td>
					
					<!-- 最近一次随访空腹血糖达标人数-->
					<td title="${report.diBsCount}">${report.diBsCount}</td>
					<!-- 血糖控制率-->
					<td title="<fmt:formatNumber value="${report.diCount==0?0:(report.diBsCount/report.diCount)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${report.diCount==0?0:(report.diBsCount/report.diCount)*100}" pattern="#,##0.0"/>% 
					</td>
					<!-- 家庭医生签约人数 -->
					<td title="${report.diSignCount}">${report.diSignCount}</td>
					<!-- 糖尿病患者人数-->
					<td title="${report.diShouldCount}">${report.diShouldCount}</td>
					<!-- 糖尿病患者管理率-->
					<td title="<fmt:formatNumber value="${report.diShouldCount==0?0:(report.diCount/report.diShouldCount)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${report.diShouldCount==0?0:(report.diCount/report.diShouldCount)*100}" pattern="#,##0.0"/>% 
					</td>
					<!-- 最近一次餐后2小时血糖达标人数-->
					<td title="${report.diTwohourCount}">${report.diTwohourCount}</td>
				</tr>
			</c:forEach>
			<c:if test="${census!=null}">
				<tr>
					<td colspan="2"><strong>合计</strong></td>
						<!-- 已管理人数 -->
						<td title="${census.diSum}">${census.diSum}</td>
						<!-- 按照规范要求进行健康管理的人数-->
						<td title="${census.diManageSum}">${census.diManageSum}</td>
						<!-- 规范管理率 -->
						<td title="<fmt:formatNumber value="${census.diSum==0?0:(census.diManageSum/census.diSum)*100}" pattern="#,##0.0"/>%">
							<fmt:formatNumber value="${census.diSum==0?0:(census.diManageSum/census.diSum)*100}" pattern="#,##0.0"/>% 
						</td>
						
						<!-- 最近一次随访空腹血糖达标人数-->
						<td title="${census.diBsSum}">${census.diBsSum}</td>
						<!-- 血糖控制率-->
						<td title="<fmt:formatNumber value="${census.diSum==0?0:(census.diBsSum/census.diSum)*100}" pattern="#,##0.0"/>%">
							<fmt:formatNumber value="${census.diSum==0?0:(census.diBsSum/census.diSum)*100}" pattern="#,##0.0"/>% 
						</td>
						<!-- 家庭医生签约人数 -->
						<td title="${census.diSignCount}">${census.diSignCount}</td>
						<!-- 糖尿病患者人数-->
						<td title="${census.diShouldSum}">${census.diShouldSum}</td>
						<!-- 糖尿病患者管理率-->
						<td title="<fmt:formatNumber value="${census.diShouldSum==0?0:(census.diSum/census.diShouldSum)*100}" pattern="#,##0.0"/>%">
							<fmt:formatNumber value="${census.diShouldSum==0?0:(census.diSum/census.diShouldSum)*100}" pattern="#,##0.0"/>% 
						</td>
						<!-- 最近一次餐后2小时血糖达标总数-->
						<td title="${census.diTwoHSum}">${census.diTwoHSum}</td>
			</tr>
		</c:if>
		</tbody>
	</table>
</div>
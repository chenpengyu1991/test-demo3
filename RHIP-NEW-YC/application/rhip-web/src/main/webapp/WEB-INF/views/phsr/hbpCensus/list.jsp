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
				<th colspan="9">高血压患者健康管理统计报表</th>
			</tr>
			<tr>
				<th>辖区内已管理的高血压患者人数</th>
				<th>按照规范要求进行高血压患者健康管理的人数</th>
				<th>高血压患者规范管理率</th>
				<th>最近一次随访血压达标人数</th>
				<th>管理人群血压控制率</th>
				<th>在管高血压患者家庭医生签约人数</th>
				<th>在管高血压患者家庭医生签约率</th>
				<th>高血压患者人数</th>
				<th>高血压患者管理率</th>
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
					<!-- 已管理高血压患者人数 -->
					<td title="${report.hbpCount}">${report.hbpCount}</td>
					<!-- 按照规范要求进行高血压患者健康管理的人数-->
					<td title="${report.hbpManageCount}">${report.hbpManageCount}</td>
					<!-- 高血压患者规范管理率 -->
					<td title="<fmt:formatNumber value="${report.hbpCount==0?0:(report.hbpManageCount/report.hbpCount)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${report.hbpCount==0?0:(report.hbpManageCount/report.hbpCount)*100}" pattern="#,##0.0"/>% 
					</td>
					
					<!-- 最近一次随访血压达标人数-->
					<td title="${report.hbpBpCount}">${report.hbpBpCount}</td>
					<!-- 管理人群血压控制率-->
					<td title="<fmt:formatNumber value="${report.hbpCount==0?0:(report.hbpBpCount/report.hbpCount)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${report.hbpCount==0?0:(report.hbpBpCount/report.hbpCount)*100}" pattern="#,##0.0"/>% 
					</td>
					
					<!-- 在管高血压患者家庭医生签约人数-->
					<td title="${report.hbpSignCount}">${report.hbpSignCount}</td>
					<!-- 在管高血压患者家庭医生签约率 -->
					<td title="<fmt:formatNumber value="${report.hbpCount==0?0:(report.hbpSignCount/report.hbpCount)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${report.hbpCount==0?0:(report.hbpSignCount/report.hbpCount)*100}" pattern="#,##0.0"/>% 
					</td>

					<!-- 高血压患者人数-->
					<td title="${report.hbpShouldCount}">${report.hbpShouldCount}</td>
					<!-- 高血压患者管理率 -->
					<td title="<fmt:formatNumber value="${report.hbpShouldCount==0?0:(report.hbpCount/report.hbpShouldCount)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${report.hbpShouldCount==0?0:(report.hbpCount/report.hbpShouldCount)*100}" pattern="#,##0.0"/>% 
					</td>
										
				</tr>
			</c:forEach>
			<c:if test="${census!=null}">
				<tr>
					<td colspan="2"><strong>合计</strong></td>
					<!-- 已管理高血压患者人数 -->
					<td title="${census.hbpSum}">${census.hbpSum}</td>
					<!-- 按照规范要求进行高血压患者健康管理的人数-->
					<td title="${census.hbpManageSum}">${census.hbpManageSum}</td>
					<!-- 高血压患者规范管理率 -->
					<td title="<fmt:formatNumber value="${census.hbpSum==0?0:(census.hbpManageSum/census.hbpSum)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${census.hbpSum==0?0:(census.hbpManageSum/census.hbpSum)*100}" pattern="#,##0.0"/>% 
					</td>
					
					<!-- 最近一次随访血压达标人数-->
					<td title="${census.hbpBpSum}">${census.hbpBpSum}</td>
					<!-- 管理人群血压控制率-->
					<td title="<fmt:formatNumber value="${census.hbpSum==0?0:(census.hbpBpSum/census.hbpSum)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${census.hbpSum==0?0:(census.hbpBpSum/census.hbpSum)*100}" pattern="#,##0.0"/>% 
					</td>
					
					<!-- 在管高血压患者家庭医生签约人数-->
					<td title="${census.hbpSignSum}">${census.hbpSignSum}</td>
					<!-- 在管高血压患者家庭医生签约率 -->
					<td title="<fmt:formatNumber value="${census.hbpSum==0?0:(census.hbpSignSum/census.hbpSum)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${census.hbpSum==0?0:(census.hbpSignSum/census.hbpSum)*100}" pattern="#,##0.0"/>% 
					</td>
					
					<!-- 高血压患者人数-->
					<td title="${census.hbpShouldSum}">${census.hbpShouldSum}</td>
					<!-- 高血压患者管理率 -->
					<td title="<fmt:formatNumber value="${census.hbpShouldSum==0?0:(census.hbpSum/census.hbpShouldSum)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${census.hbpShouldSum==0?0:(census.hbpSum/census.hbpShouldSum)*100}" pattern="#,##0.0"/>% 
					</td>
			</tr>
		</c:if>
		</tbody>
	</table>
</div>
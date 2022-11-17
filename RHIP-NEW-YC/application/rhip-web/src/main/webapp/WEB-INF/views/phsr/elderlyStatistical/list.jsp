<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>


<div class="repeattable">
	<table id="tuberculosisTable" class="layui-table x-admin-sm-table-list-middle">
		<thead>
		<tr>
			<th rowspan="2">区县</th>
			<th rowspan="2">机构</th>
			<th colspan="6">老年人健康管理统计报表</th>
		</tr>
		<tr>
			<th>辖区内65岁及以上常住居民数</th>
			<th>65岁以上老年人家庭医生签约人数</th>
			<th>接受健康体检人数</th>
			<th>接受健康管理人数</th>
			<th>老年人健康管理率</th>
			<th>建立居民健康档案的65岁以上老年人数(人)</th>
		</tr>
		</thead>
		<tbody id="displayBody">
		<c:forEach var="report" items="${reports}" >
			<tr>
				<c:choose>
					<c:when test="${report.GB_CODE != '合计'}">
						<td>
							<ehr:tip><ehr:dic code="${report.GB_CODE}" dicmeta="FS990001"  /></ehr:tip>
						</td>
						<td title="${report.organName}">${report.organName}</td>
					</c:when>
					<c:otherwise>
						<td title="${report.organName}" colspan="2" style="text-align:center"><strong>${report.organName}</strong></td>
					</c:otherwise>
				</c:choose>
				<td>${empty report.permanentNum?0:report.permanentNum}</td>
				<td>${empty report.JY_RESERVE?0:report.JY_RESERVE}</td>
				<td>${empty report.SAMSUNG_NUM?0:report.SAMSUNG_NUM}</td>
				<td>${empty report.HEALTH_MANAGEMENT_NUM?0:report.HEALTH_MANAGEMENT_NUM}</td>
				<td>${report.MANAGEMENT_RATE}%</td>
				<td>${empty report.TOWSTAR_NUM?0:report.TOWSTAR_NUM}</td>
					<%--<td>
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
					<td>0</td>
					<td title="${report.residentNum}">
					<c:if test="${empty report.residentNum}">0</c:if>
					<c:if test="${not empty report.residentNum}">${report.residentNum}</c:if>
					</td>
					<td title="${report.samsungNum}">${report.samsungNum}</td>
					<td title="${report.healthManagementNum}">${report.healthManagementNum}</td>
					<c:if test="${report.healthManagementNum eq 0 &&report.residentNum eq 0}">
					<td>0.0%</td>
					</c:if>
					<c:if test="${report.healthManagementNum == 0 && report.residentNum != 0}">
					<td>0.0%</td>
					</c:if>
					<c:if test="${report.healthManagementNum != 0 && report.residentNum == 0}">
					<td>0.0%</td>
					</c:if>
					<c:if test="${report.healthManagementNum != 0 && report.residentNum != 0}">
					<td><fmt:formatNumber value="${(report.healthManagementNum/report.residentNum)*100}" pattern="#,##0.0"/>%</td></c:if>
					<td title="${report.towstarNum}">${report.towstarNum}</td>	--%>
			</tr>
		</c:forEach>
		<%--<c:if test="${elderlyStatisticalServiceDto!=null}">
           <tr>
               <td colspan="2"><strong>合计</strong></td>
               <td>0</td>
               <td title="${elderlyStatisticalServiceDto.residentNum}">${elderlyStatisticalServiceDto.residentNum}</td>
                <td title="${elderlyStatisticalServiceDto.samsungNum}">${elderlyStatisticalServiceDto.samsungNum}</td>
               <td title="${elderlyStatisticalServiceDto.healthManagementNum}">${elderlyStatisticalServiceDto.healthManagementNum}</td>
               <c:if test="${elderlyStatisticalServiceDto.healthManagementNum eq 0 &&elderlyStatisticalServiceDto.residentNum eq 0}">
               <td>0.0%</td>
               </c:if>
               <c:if test="${elderlyStatisticalServiceDto.healthManagementNum == 0 && elderlyStatisticalServiceDto.residentNum != 0}">
               <td>0.0%</td>
               </c:if>
               <c:if test="${elderlyStatisticalServiceDto.healthManagementNum != 0 && elderlyStatisticalServiceDto.residentNum == 0}">
               <td>0.0%</td>
               </c:if>
               <c:if test="${elderlyStatisticalServiceDto.healthManagementNum != 0 && elderlyStatisticalServiceDto.residentNum != 0}">
               <td><fmt:formatNumber value="${(elderlyStatisticalServiceDto.healthManagementNum/elderlyStatisticalServiceDto.residentNum)*100}" pattern="#,##0.0"/>%</td>

               </c:if>
               <td title="${elderlyStatisticalServiceDto.towstarNum}">${elderlyStatisticalServiceDto.towstarNum}</td>
           </tr>
       </c:if>--%>
		</tbody>

	</table>
</div>
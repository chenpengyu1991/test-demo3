<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>


<div class="repeattable">
	<table id="healthVaccinationTable" class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width: 50px;" />
			<col style="width: 100px;" />
			<col style="width: 35px;" />
			<col style="width: 35px;" />
			<col style="width: 35px;" />
			<col style="width: 35px;" />
			<col style="width: 35px;" />
			<col style="width: 35px;" />
			<col style="width: 35px;" />
			<col style="width: 35px;" />
			<col style="width: 35px;" />
			<col style="width: 35px;" />
			<col style="width: 35px;" />
		</colgroup>
		<thead>
			<tr>
				<th rowspan="2">区县</th>
				<th rowspan="2">机构</th>
				<th colspan="11">中医药健康管理统计报表</th>
			</tr>
			<tr>
				<th>辖区内65岁及以上常住居民数</th>
				<th>接受中医药健康管理服务65岁及以上居民数</th>
				<th>老年人中医药健康管理率</th>
				<th>辖区内应管理的0-36个月儿童数</th>
				<th>辖区内按照月龄接受中医药健康管理服务的0-36个月儿童数</th>
				<th>0-36个月儿童中医药健康管理服务率</th>
				<th>辖区内已管理的高血压患者数</th>
<%--				<th>辖区内接受中医药健康管理服务的高血压患者数</th>
				<th>高血压患者中医药健康管理服务率</th>--%>
				<th>辖区内已管理的糖尿病患者数</th>
<%--				<th>辖区内接受中医药健康管理服务的糖尿病患者数</th>
				<th>糖尿病患者中医药健康管理服务率</th>--%>
				<th>辖区内已管理的孕产妇数</th>
				<th>辖区内接受中医药健康管理服务的孕产妇数</th>
				<th>孕产妇中医药健康管理服务率</th>
		</thead>
		<tbody id="displayBody">
			 <c:forEach var="report" items="${reports}" >
				<tr>
					<td>
						<ehr:tip><ehr:dic code="${report.gbCode}" dicmeta="FS990001"  /></ehr:tip>
					</td>
					<td>
						<ehr:tip><ehr:org code="${report.orgCode}" /></ehr:tip>
					</td>
					<!-- 65岁及以上老人 -->
					<td title="${report.householdGreatSixfNum}">${report.householdGreatSixfNum}</td>
					<td title="${report.medicineGreatSixfNum}">${report.medicineGreatSixfNum}</td>
					<td title="<fmt:formatNumber value="${report.householdGreatSixfNum==0?0:(report.medicineGreatSixfNum/report.householdGreatSixfNum)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${report.householdGreatSixfNum==0?0:(report.medicineGreatSixfNum/report.householdGreatSixfNum)*100}" pattern="#,##0.0"/>% 
					</td>
						
					<!-- 0-36个月儿童-->
					<td title="${report.childCount }">${report.childCount }</td>
					<td title="${report.childServeCount }">${report.childServeCount }</td>
					<td title="<fmt:formatNumber value="${report.childCount==0?0:(report.childServeCount/report.childCount)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${report.childCount==0?0:(report.childServeCount/report.childCount)*100}" pattern="#,##0.0"/>% 
					</td>
					
					<!-- 高血压 -->
					<td title="${report.hbpCount}">${report.hbpCount}</td>
					<%--<td title="${report.hbpServeCount}">${report.hbpServeCount}</td>
					<td title="<fmt:formatNumber value="${report.hbpCount==0?0:(report.hbpServeCount/report.hbpCount)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${report.hbpCount==0?0:(report.hbpServeCount/report.hbpCount)*100}" pattern="#,##0.0"/>% 
					</td>--%>
					
					<!-- 糖尿病-->
					<td title="${report.diCount}">${report.diCount}</td>
					<%--<td title="${report.diManageCount}">${report.diManageCount}</td>
					<td title="<fmt:formatNumber value="${report.diCount==0?0:(report.diManageCount/report.diCount)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${report.diCount==0?0:(report.diManageCount/report.diCount)*100}" pattern="#,##0.0"/>% 
					</td>--%>
					
					<!-- 孕产妇 -->
					<td title="${report.womenCount}">${report.womenCount}</td>
					<td title="${report.womenServeCount}">${report.womenServeCount}</td>
					<td title="<fmt:formatNumber value="${report.womenCount==0?0:(report.womenServeCount/report.womenCount)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${report.womenCount==0?0:(report.womenServeCount/report.womenCount)*100}" pattern="#,##0.0"/>% 
					</td>
				</tr>
			</c:forEach>
			 <c:if test="${census!=null}">
				<tr>
					<td  colspan="2"><strong>合计</strong></td>
					<!-- 65岁及以上老人 -->
					<td title="${census.householdGreatSixfSum }">${census.householdGreatSixfSum }</td>
					<td title="${census.medicineGreatSixfSum }">${census.medicineGreatSixfSum }</td>
					<td title="<fmt:formatNumber value="${census.householdGreatSixfSum==0?0:(census.medicineGreatSixfSum/census.householdGreatSixfSum)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${census.householdGreatSixfSum==0?0:(census.medicineGreatSixfSum/census.householdGreatSixfSum)*100}" pattern="#,##0.0"/>% 
					</td>
					
					<!--0-36个月儿童  -->
					<td title="${census.childSum }">${census.childSum }</td>
					<td title="${census.childServeSum }">${census.childServeSum }</td>
					<td title="<fmt:formatNumber value="${census.childSum==0?0:(census.childServeSum/census.childSum)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${census.childSum==0?0:(census.childServeSum/census.childSum)*100}" pattern="#,##0.0"/>% 
					</td>
					
					<!--高血压 -->
					<td title="${census.hbpSum }">${census.hbpSum }</td>
					<%--<td title="${census.hbpManageSum }">${census.hbpManageSum }</td>
					<td title="<fmt:formatNumber value="${census.hbpSum==0?0:(census.hbpManageSum/census.hbpSum)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${census.hbpSum==0?0:(census.hbpManageSum/census.hbpSum)*100}" pattern="#,##0.0"/>% 
					</td>--%>
					
					<!-- 糖尿病 -->
					<td title="${census.diSum }">${census.diSum }</td>
					<%--<td title="${census.diManageSum }">${census.diManageSum }</td>
					<td title="<fmt:formatNumber value="${census.diSum==0?0:(census.diManageSum/census.diSum)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${census.diSum==0?0:(census.diManageSum/census.diSum)*100}" pattern="#,##0.0"/>% 
					</td>--%>
					
					<!-- 孕产妇-->
					<td title="${census.womenSum }">${census.womenSum }</td>
					<td title="${census.womenServeSum }">${census.womenServeSum }</td>
					<td title="<fmt:formatNumber value="${census.womenSum==0?0:(census.womenServeSum/census.womenSum)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${census.womenSum==0?0:(census.womenServeSum/census.womenSum)*100}" pattern="#,##0.0"/>% 
					</td>
			</tr>
		</c:if>
		</tbody>
	</table>
</div>
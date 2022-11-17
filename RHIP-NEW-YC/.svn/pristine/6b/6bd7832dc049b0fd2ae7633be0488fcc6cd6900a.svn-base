<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<script src="${pageContext.request.contextPath}/js/views/vaccine/statistics/report/monthReport/rabies/list.js" type="text/javascript"></script>
<div id="rabiesList" class="repeattable">
	<form id="rabiesForm">
		<input type="hidden" name="currentOrgCode" value="${currentOrgCode}"/>
		<input type="hidden" name="currentMonth" value="${currentMonth}"/>
		<input type="hidden" id="reportNameId" name="reportName" value="<ehr:org code="${fillOrgCode}"/>${reportMonth}传染病管理月报表"/>
	<table id="rabiestable">
		<colgroup>
			<col style="width: 100px;"/>
			<col style="width: 100px;"/>
			<col style="width: 100px;"/>
			<col style="width: 100px;"/>
			<col style="width: 100px;"/>
			<col style="width: 100px;"/>
			<col style="width: 100px;"/>
			<col style="width: 100px;"/>
			<col style="width: 100px;"/>
			<col style="width: 100px;"/>
		</colgroup>		
		<thead>
			<tr style="text-align: center;">
				<td style="border:none;"></td>
				<td style="border:none;" colspan="8">
					<h1 style="font-size:150%;margin: 20px 0px 20px 0px">狂犬病防治月报表</h1>
				</td>
				<td style="border:none;"></td>
			</tr>
			<tr>
				<th rowspan="2"></th>
				<th rowspan="2">被动物咬伤就诊人数</th>
				<th rowspan="2">一犬伤多人事件起数</th>
				<th rowspan="2">伤口经正规处理人数</th>
				<th rowspan="2">使用人用狂犬病疫苗人数</th>
				<th rowspan="2">使用狂犬病人免疫球蛋白联合疫苗人数</th>
				<th colspan="3">人狂犬病发病情况</th>
				<th rowspan="2">其他</th>
			</tr>
			<tr>
				<th>发病人数</th>
				<th>死亡人数</th>
				<th>处理疫点数</th>
			</tr>			
		</thead>
		<tbody>
			<c:forEach var="rabies" items="${rabieses}" varStatus="status">
				<c:if test="${rabies.diseaseCode !='-1'}">
					<tr>
						<td>
							<ehr:tip>本月</ehr:tip>
							<input type="hidden" name="diseaseCode" value="${rabies.diseaseCode}"/>
						</td>
						<td><tags:numberLabel value="${rabies.rabiesVisit}"/></td>
						<td><tags:numberLabel value="${rabies.biteMany}"/></td>
						<td><tags:numberLabel value="${rabies.disposeVulnus}"/></td>
						<td><tags:numberLabel value="${rabies.rabiesVaccine}"/></td>
						<td><tags:numberLabel value="${rabies.rabiesImmunoglobulin}"/></td>
						<td><tags:numberLabel value="${rabies.incidence}"/></td>
						<td><tags:numberLabel value="${rabies.deathToll}"/></td>
						<td>
							<span id="viewReport2${status.count}Id" style="float:right;">${rabies.disposeEpidemic}</span>
							<input type="text" id="editReport2${status.count}Id" name="disposeEpidemic" value="${rabies.disposeEpidemic}" style="width: 95%;text-align:right;" reg='{"digits":"true","min":"0","max":"10000"}'/>
						</td>
						<td>
							<span id="viewReport3${status.count}Id" style="float:left;">${rabies.rabiesOther}</span>
							<input type="text" id="editReport3${status.count}Id" name="rabiesOther" value="${rabies.rabiesOther}" style="width: 95%;text-align:left;" reg='{"maxlength":"100"}'/>
						</td>
					</tr>
				</c:if>
			</c:forEach>
			<c:forEach var="rabies" items="${rabieses}" varStatus="status">
				<c:if test="${rabies.diseaseCode =='-1'}">
						<tr>
							<td>
								<ehr:tip>累计</ehr:tip>
							</td>
							<td><tags:numberLabel value="${rabies.rabiesVisit}"/></td>
							<td><tags:numberLabel value="${rabies.biteMany}"/></td>
							<td><tags:numberLabel value="${rabies.disposeVulnus}"/></td>
							<td><tags:numberLabel value="${rabies.rabiesVaccine}"/></td>
							<td><tags:numberLabel value="${rabies.rabiesImmunoglobulin}"/></td>
							<td><tags:numberLabel value="${rabies.incidence}"/></td>
							<td><tags:numberLabel value="${rabies.deathToll}"/></td>
							<td><tags:numberLabel value="${rabies.disposeEpidemic}"/></td>
							<td></td>
						</tr>
				</c:if>	
			</c:forEach>		
			<tr>
				<td colspan="10" style="border:none;text-align: left;">
					<p>填表要求：各单位于每月3日前将上月的《传染病管理月报表》通过永城市疾病预防</p>
				</td>
			</tr>
			<tr>
				<td colspan="10" style="border:none;text-align: right;">
					<c:choose>
						<c:when test="${empty fillUserId}">
							<span style="margin: 0px 180px 20px 0px">填表单位</span>
							<span style="margin:0px 100px 20px 0px">填报人：</span>
							<span style="margin: 0px 150px 20px 0px">填报日期：</span>						
						</c:when>
						<c:otherwise>
							<span style="margin: 0px 10px 20px 0px">填表单位</span>
							<span style="margin: 0px 10px 0px 0px"><b><ehr:org code="${fillOrgCode}"/></b></span>
							<span style="margin: 0px 10px 20px 0px">填报人：</span>
							<span style="margin: 0px 10px 0px 0px"><b><ehr:user userId="${fillUserId}"/></b></span>
							<span style="margin: 0px 100px 20px 0px">填报日期：<b><fmt:formatDate pattern="yyyy/MM/dd" value="${fillDt}"/></b></span>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>									
		</tbody>
	</table>
	</form>
</div>
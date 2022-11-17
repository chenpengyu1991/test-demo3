<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<script src="${pageContext.request.contextPath}/js/views/idm/statistics/report/acuteReport/month/list.js" type="text/javascript"></script>
<div id="acuteMonthList" class="repeattable" style="padding-bottom: 50px;">
	<form id="acuteMonthForm">
		<input type="hidden" name="currentOrgCode" value="${currentOrgCode}"/>
		<input type="hidden" name="currentMonth" value="${currentMonth}"/>

	<table id="acuteMonthtable">
		<colgroup>
			<col style="width: 150px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>			
		</colgroup>		
		<thead>
			<tr style="text-align: center;">
				<td style="border:none;"></td>
				<td style="border:none;" colspan="25">
					<h1 style="font-size:150%;margin: 20px 0px 20px 0px">江苏省急性传染病防制相关工作情况报表</h1>
				</td>
				<td style="border:none;"></td>
			</tr>
			<tr style="text-align: center;">
		        <td  colspan="3" style="text-align: left;border:none;">
		       		<span>苏州市</span>
		        </td>
		        <td colspan="9" style="text-align: right;border:none;">
		        	<span>________年</span>
		        </td>
		        <td colspan="14" style="text-align: right;border:none;">
		        	<span>填报日期：________年________月________日</span>
		        </td>
		        <td style="text-align: right;border:none;"></td>	        	        
			</tr>			
			<tr>
				<th rowspan="2">单位名称</th>
				<th colspan="3">传染病疫情调查处理</th>
				<th colspan="3">伤寒防制</th>
				<th colspan="3">痢疾防制</th>
				<th colspan="4">手足口病</th>
				<th colspan="2">戊肝防制</th>
				<th colspan="2">甲肝防制</th>
				<th colspan="3">出血热防制</th>
				<th colspan="6">犬伤处置情况</th>
			</tr>
			<tr>
				<th>首发和重点病例疫情起数</th>
				<th>调查起数</th>
				<th>规范处置总起数</th>
				<th>散发疫情数</th>
				<th>处理数</th>
				<th>隔离治疗数</th>
				<th>散发疫情数</th>
				<th>处理数</th>
				<th>隔离治疗数</th>
				<th>重症病例数</th>
				<th>调查处置数</th>
				<th>聚集性疫情起数</th>
				<th>调查起数</th>
				<th>暴发起数</th>
				<th>处理起数</th>
				<th>散发疫情数</th>
				<th>处理数</th>
				<th>病例数</th>
				<th>流调数</th>
				<th>标本采集数</th>
				<th>犬伤就诊数</th>
				<th>伤口处理数</th>
				<th>接种疫苗人数</th>
				<th>使用被动免疫制剂数</th>
				<th>一犬伤多人事件数</th>
				<th>调查处理起数</th>
			</tr>			
		</thead>
		<tbody>
			<c:forEach var="acuteYear" items="${acuteYears}" varStatus="status">
				<c:if test="${acuteYear.fillOrganCode !='-1'}">
					<tr>
						<td>
							<ehr:tip><ehr:org code="${acuteYear.fillOrganCode}"/></ehr:tip>
							<input type="hidden" name="fillOrganCode" value="${acuteYear.fillOrganCode}"/>
						</td>
						<td><tags:numberLabel value="${acuteYear.firstAndKey}"/></td>
						<td><tags:numberLabel value="${acuteYear.investigation}"/></td>
						<td><tags:numberLabel value="${acuteYear.regulateDisposal}"/></td>
						<td><tags:numberLabel value="${acuteYear.efdSporadic}"/></td>
						<td><tags:numberLabel value="${acuteYear.efdDispose}"/></td>
						<td><tags:numberLabel value="${acuteYear.efdInsulate}"/></td>
						<td><tags:numberLabel value="${acuteYear.dysenterySporadic}"/></td>
						<td><tags:numberLabel value="${acuteYear.dysenteryDispose}"/></td>
						<td><tags:numberLabel value="${acuteYear.dysenteryInsulate}"/></td>
						<td><tags:numberLabel value="${acuteYear.hfmdGrave}"/></td>
						<td><tags:numberLabel value="${acuteYear.hfmdDisposition}"/></td>
						<td><tags:numberLabel value="${acuteYear.hfmdAggregation}"/></td>
						<td><tags:numberLabel value="${acuteYear.hfmdInvestigation}"/></td>
						<td><tags:numberLabel value="${acuteYear.hevFulminant}"/></td>
						<td><tags:numberLabel value="${acuteYear.hevDispose}"/></td>
						<td><tags:numberLabel value="${acuteYear.havSporadic}"/></td>
						<td><tags:numberLabel value="${acuteYear.havDispose}"/></td>
						<td><tags:numberLabel value="${acuteYear.havCase}"/></td>
						<td><tags:numberLabel value="${acuteYear.hfSurvey}"/></td>
						<td><tags:numberLabel value="${acuteYear.hfSample}"/></td>
						<td><tags:numberLabel value="${acuteYear.rabiesVisit}"/></td>
						<td><tags:numberLabel value="${acuteYear.rabiesDispose}"/></td>
						<td><tags:numberLabel value="${acuteYear.rabiesVaccine}"/></td>
						<td><tags:numberLabel value="${acuteYear.rabiesPassive}"/></td>
						<td><tags:numberLabel value="${acuteYear.biteMany}"/></td>
						<td><tags:numberLabel value="${acuteYear.rabiesInvestigation}"/></td>
					</tr>
				</c:if>
			</c:forEach>
			<c:forEach var="acuteYear" items="${acuteYears}" varStatus="status">
				<c:if test="${acuteYear.fillOrganCode =='-1'}">
					<tr>
						<td>
							<ehr:tip><b>合计</b></ehr:tip>
						</td>
						<td><b><tags:numberLabel value="${acuteYear.firstAndKey}"/></b></td>
						<td><b><tags:numberLabel value="${acuteYear.investigation}"/></b></td>
						<td><b><tags:numberLabel value="${acuteYear.regulateDisposal}"/></b></td>
						<td><b><tags:numberLabel value="${acuteYear.efdSporadic}"/></b></td>
						<td><b><tags:numberLabel value="${acuteYear.efdDispose}"/></b></td>
						<td><b><tags:numberLabel value="${acuteYear.efdInsulate}"/></b></td>
						<td><b><tags:numberLabel value="${acuteYear.dysenterySporadic}"/></b></td>
						<td><b><tags:numberLabel value="${acuteYear.dysenteryDispose}"/></b></td>
						<td><b><tags:numberLabel value="${acuteYear.dysenteryInsulate}"/></b></td>
						<td><b><tags:numberLabel value="${acuteYear.hfmdGrave}"/></b></td>
						<td><b><tags:numberLabel value="${acuteYear.hfmdDisposition}"/></b></td>
						<td><b><tags:numberLabel value="${acuteYear.hfmdAggregation}"/></b></td>
						<td><b><tags:numberLabel value="${acuteYear.hfmdInvestigation}"/></b></td>
						<td><b><tags:numberLabel value="${acuteYear.hevFulminant}"/></b></td>
						<td><b><tags:numberLabel value="${acuteYear.hevDispose}"/></b></td>
						<td><b><tags:numberLabel value="${acuteYear.havSporadic}"/></b></td>
						<td><b><tags:numberLabel value="${acuteYear.havDispose}"/></b></td>
						<td><b><tags:numberLabel value="${acuteYear.havCase}"/></b></td>
						<td><b><tags:numberLabel value="${acuteYear.hfSurvey}"/></b></td>
						<td><b><tags:numberLabel value="${acuteYear.hfSample}"/></b></td>
						<td><b><tags:numberLabel value="${acuteYear.rabiesVisit}"/></b></td>
						<td><b><tags:numberLabel value="${acuteYear.rabiesDispose}"/></b></td>
						<td><b><tags:numberLabel value="${acuteYear.rabiesVaccine}"/></b></td>
						<td><b><tags:numberLabel value="${acuteYear.rabiesPassive}"/></b></td>
						<td><b><tags:numberLabel value="${acuteYear.biteMany}"/></b></td>
						<td><b><tags:numberLabel value="${acuteYear.rabiesInvestigation}"/></b></td>
					</tr>
				</c:if>	
			</c:forEach>		
			<tr>
				<td colspan="27" style="border:none;text-align: left;">
					<p>注：此表按月填写，市级按月汇总，并完成全年汇总表一份，于每月25日前报上月数据。</p>
				</td>
			</tr>
			<tr>
				<td colspan="27" style="border:none;text-align: right;">
					<span style="margin: 0px 120px 20px 0px">填报人：</span>
				</td>
			</tr>									
		</tbody>
	</table>
	</form>
</div>
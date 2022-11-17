<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<script src="${pageContext.request.contextPath}/js/views/idm/statistics/report/acuteReport/month/list.js" type="text/javascript"></script>
<div id="acuteMonthList" class="repeattable">
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
		        	<c:if test="${not empty reportMonth}">
						<span><b><fmt:formatDate pattern="yyyy  年   MM  月份" value="${reportMonth}"/></b></span>
					</c:if>
		        </td>
		        <td colspan="14" style="text-align: right;border:none;">
		        	<c:if test="${not empty fillDt}">
		        		<span>填报日期：<b><fmt:formatDate pattern="yyyy  年   MM  月  dd  日" value="${fillDt}"/></b></span>
		        	</c:if>
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
			<c:forEach var="acuteMonth" items="${acuteMonths}" varStatus="status">
				<c:if test="${acuteMonth.fillOrganCode !='-1'}">
					<tr>
						<td>
							<ehr:tip><ehr:org code="${acuteMonth.fillOrganCode}"/></ehr:tip>
							<input type="hidden" name="fillOrganCode" value="${acuteMonth.fillOrganCode}"/>
						</td>
						<td><tags:numberLabel value="${acuteMonth.firstAndKey}"/></td>
						<td><tags:numberLabel value="${acuteMonth.investigation}"/></td>
						<td><tags:numberLabel value="${acuteMonth.regulateDisposal}"/></td>
						<td><tags:numberLabel value="${acuteMonth.efdSporadic}"/></td>
						<td>
							<span id="viewReport2${status.count}Id" style="float:right;">${acuteMonth.efdDispose}</span>
							<input type="text" id="editReport2${status.count}Id" name="efdDispose${acuteMonth.fillOrganCode}" value="${acuteMonth.efdDispose}" style="width: 95%;text-align:right;" reg='{"digits":"true","min":"0","max":"10000"}'/>
						</td>
						<td>
							<span id="viewReport2${status.count}Id" style="float:right;">${acuteMonth.efdInsulate}</span>
							<input type="text" id="editReport2${status.count}Id" name="efdInsulate${acuteMonth.fillOrganCode}" value="${acuteMonth.efdInsulate}" style="width: 95%;text-align:right;" reg='{"digits":"true","min":"0","max":"10000"}'/>
						</td>
						<td><tags:numberLabel value="${acuteMonth.dysenterySporadic}"/></td>
						<td>
							<span id="viewReport2${status.count}Id" style="float:right;">${acuteMonth.dysenteryDispose}</span>
							<input type="text" id="editReport2${status.count}Id" name="dysenteryDispose${acuteMonth.fillOrganCode}" value="${acuteMonth.dysenteryDispose}" style="width: 95%;text-align:right;" reg='{"digits":"true","min":"0","max":"10000"}'/>
						</td>
						<td>
							<span id="viewReport3${status.count}Id" style="float:right;">${acuteMonth.dysenteryInsulate}</span>
							<input type="text" id="editReport3${status.count}Id" name="dysenteryInsulate${acuteMonth.fillOrganCode}" value="${acuteMonth.dysenteryInsulate}" style="width: 95%;text-align:right;" reg='{"maxlength":"100"}'/>
						</td>
						<td><tags:numberLabel value="${acuteMonth.hfmdGrave}"/></td>
						<td><tags:numberLabel value="${acuteMonth.hfmdDisposition}"/></td>
						<td><tags:numberLabel value="${acuteMonth.hfmdAggregation}"/></td>
						<td><tags:numberLabel value="${acuteMonth.hfmdInvestigation}"/></td>
						<td><tags:numberLabel value="${acuteMonth.hevFulminant}"/></td>
						<td><tags:numberLabel value="${acuteMonth.hevDispose}"/></td>
						<td><tags:numberLabel value="${acuteMonth.havSporadic}"/></td>
						<td><tags:numberLabel value="${acuteMonth.havDispose}"/></td>
						<td><tags:numberLabel value="${acuteMonth.havCase}"/></td>
						<td><tags:numberLabel value="${acuteMonth.hfSurvey}"/></td>
						<td><tags:numberLabel value="${acuteMonth.hfSample}"/></td>
						<td><tags:numberLabel value="${acuteMonth.rabiesVisit}"/></td>
						<td><tags:numberLabel value="${acuteMonth.rabiesDispose}"/></td>
						<td><tags:numberLabel value="${acuteMonth.rabiesVaccine}"/></td>
						<td><tags:numberLabel value="${acuteMonth.rabiesPassive}"/></td>
						<td><tags:numberLabel value="${acuteMonth.biteMany}"/></td>
						<td><tags:numberLabel value="${acuteMonth.rabiesInvestigation}"/></td>
					</tr>
				</c:if>
			</c:forEach>
			<c:forEach var="acuteMonth" items="${acuteMonths}" varStatus="status">
				<c:if test="${acuteMonth.fillOrganCode =='-1'}">
					<tr>
						<td>
							<ehr:tip><b>合计</b></ehr:tip>
						</td>
						<td><b><tags:numberLabel value="${acuteMonth.firstAndKey}"/></b></td>
						<td><b><tags:numberLabel value="${acuteMonth.investigation}"/></b></td>
						<td><b><tags:numberLabel value="${acuteMonth.regulateDisposal}"/></b></td>
						<td><b><tags:numberLabel value="${acuteMonth.efdSporadic}"/></b></td>
						<td><b><tags:numberLabel value="${acuteMonth.efdDispose}"/></b></td>
						<td><b><tags:numberLabel value="${acuteMonth.efdInsulate}"/></b></td>
						<td><b><tags:numberLabel value="${acuteMonth.dysenterySporadic}"/></b></td>
						<td><b><tags:numberLabel value="${acuteMonth.dysenteryDispose}"/></b></td>
						<td><b><tags:numberLabel value="${acuteMonth.dysenteryInsulate}"/></b></td>
						<td><b><tags:numberLabel value="${acuteMonth.hfmdGrave}"/></b></td>
						<td><b><tags:numberLabel value="${acuteMonth.hfmdDisposition}"/></b></td>
						<td><b><tags:numberLabel value="${acuteMonth.hfmdAggregation}"/></b></td>
						<td><b><tags:numberLabel value="${acuteMonth.hfmdInvestigation}"/></b></td>
						<td><b><tags:numberLabel value="${acuteMonth.hevFulminant}"/></b></td>
						<td><b><tags:numberLabel value="${acuteMonth.hevDispose}"/></b></td>
						<td><b><tags:numberLabel value="${acuteMonth.havSporadic}"/></b></td>
						<td><b><tags:numberLabel value="${acuteMonth.havDispose}"/></b></td>
						<td><b><tags:numberLabel value="${acuteMonth.havCase}"/></b></td>
						<td><b><tags:numberLabel value="${acuteMonth.hfSurvey}"/></b></td>
						<td><b><tags:numberLabel value="${acuteMonth.hfSample}"/></b></td>
						<td><b><tags:numberLabel value="${acuteMonth.rabiesVisit}"/></b></td>
						<td><b><tags:numberLabel value="${acuteMonth.rabiesDispose}"/></b></td>
						<td><b><tags:numberLabel value="${acuteMonth.rabiesVaccine}"/></b></td>
						<td><b><tags:numberLabel value="${acuteMonth.rabiesPassive}"/></b></td>
						<td><b><tags:numberLabel value="${acuteMonth.biteMany}"/></b></td>
						<td><b><tags:numberLabel value="${acuteMonth.rabiesInvestigation}"/></b></td>
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
					<c:if test="${not empty fillUserId}">
						<span style="margin: 0px 10px 20px 0px">填报人：</span>
						<span style="margin: 0px 60px 0px 0px"><b><ehr:user userCode="${fillUserId}"/></b></span>
		        	</c:if>
				</td>
			</tr>									
		</tbody>
	</table>
	</form>
</div>
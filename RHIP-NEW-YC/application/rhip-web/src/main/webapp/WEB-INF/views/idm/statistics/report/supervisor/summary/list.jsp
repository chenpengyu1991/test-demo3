<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<div class="repeattable" style="padding-bottom: 50px;">
	<table>
		<tr style="text-align: center;">
			<td style="border:none;">
				<h1 style="font-size:150%">江苏省传染病管理及督导汇总表</h1>
			</td>
		</tr>
	</table>  	
	<c:set var="summaryColspan" value="${summaryType==1?6:7}" scope="request"></c:set>
	<table id="supervisortable">
		<colgroup>
			<c:if test="${summaryType== '2'}"><col style="min-width:100px;width:100px;"/></c:if>
			<col style="min-width:120px;width:120px;"/>
	        <col style="min-width:60px;width:60px;"/>
			<col style="min-width:60px;width:60px;"/>
            <col style="min-width:60px;width:60px;"/>
			<col style="min-width:80px;width:80px;"/>
	        <col style="min-width:80px;width:80px;"/>
			<col style="min-width:60px;width:60px;"/>
            <col style="min-width:60px;width:60px;"/>
			<col style="min-width:60px;width:60px;"/>
	        <col style="min-width:80px;width:80px;"/>
			<col style="min-width:60px;width:60px;"/>
            <col style="min-width:60px;width:80px;"/>
			<col style="min-width:60px;width:60px;"/>
	        <col style="min-width:60px;width:60px;"/>
			<col style="min-width:60px;width:60px;"/>
            <col style="min-width:60px;width:60px;"/> 
	        <col style="min-width:60px;width:60px;"/>
			<col style="min-width:60px;width:60px;"/>
            <col style="min-width:60px;width:80px;"/>                                    
		</colgroup>	
		<thead>
			<tr style="text-align: center;">
		        <td  colspan="3" style="text-align: left;border:none;">
		       		<span>苏州市</span>
		        </td>
		        <td colspan="${summaryColspan}" style="text-align: right;border:none;">
		        	<c:if test="${not empty reportMonth}">
						<span><b><fmt:formatDate pattern="yyyy  年   MM  月份" value="${reportMonth}"/></b></span>
					</c:if>
		        </td>
		        <td colspan="9" style="text-align: right;border:none;">
		        	<c:if test="${not empty reportDate}">
		        		<span>填报日期：<b><fmt:formatDate pattern="yyyy  年   MM  月  dd  日" value="${reportDate}"/></b></span>
		        	</c:if>
		        </td>
		        <td style="text-align: right;border:none;"></td>	        	        
			</tr>		
			<tr>
				<c:if test="${summaryType== '2'}"><th rowspan="3">填报月份</th></c:if>
				<th rowspan="3">县级单位</th>
				<th colspan="11">传染病零缺报县督导情况</th>
				<th colspan="7">网络直报及漏报调查情况</th>
			</tr>
			<tr>
				<th rowspan="2">上月是否零缺报</th>
				<th colspan="2">是否开展督导</th>
				<th rowspan="2">本级上月零缺报网络直报点数</th>
				<th rowspan="2">本级县以上医疗机构零缺报单位数</th>
				<th colspan="3">督导网络直报点数</th>
				<th rowspan="2">督导应报传染病数</th>
				<th rowspan="2">传染病漏报数</th>
				<th rowspan="2">漏报率(%)</th>
				<th colspan="2">督导或调查点数</th>
				<th colspan="2">是否开展传染病漏报专项调查</th>
				<th rowspan="2">应报传染病数</th>
				<th rowspan="2">传染病漏报数</th>
				<th rowspan="2">漏报率(%)</th>
			</tr>	
			<tr>
				<th>省级</th>
				<th>市级</th>
				<th>省级</th>
				<th>市级</th>
				<th>县级</th>
				<th>市级</th>
				<th>县级</th>
				<th>市级</th>
				<th>县级</th>
			</tr>					
		</thead>
		<tbody>
			<c:forEach var="supervisor" items="${supervisors}" varStatus="status">
				<tr>
					<c:if test="${summaryType== '2'}">
						<td><ehr:tip><fmt:formatDate pattern="yyyy/MM" value="${supervisor.reportMonth}"/></ehr:tip></td>
					</c:if>
					<td><ehr:tip><ehr:org code="${supervisor.reportUnitCode}"/></ehr:tip></td>
					<td class="centertd"><ehr:tip><ehr:dic dicmeta="PH00001" code="${supervisor.lastMonthMiss}"/></ehr:tip></td>
					<td class="centertd"><ehr:tip><ehr:dic dicmeta="PH00001" code="${supervisor.supervisorProvince}"/></ehr:tip></td>
					<td class="centertd"><ehr:tip><ehr:dic dicmeta="PH00001" code="${supervisor.supervisorCity}"/></ehr:tip></td>
					<td><tags:numberLabel value="${supervisor.zeroDefectOrgNum}"/></td>
					<td><tags:numberLabel value="${supervisor.zeroDefectMedicalNum}"/></td>
					<td><tags:numberLabel value="${supervisor.directNumProvince}"/></td>
					<td><tags:numberLabel value="${supervisor.directNumCity}"/></td>
					<td><tags:numberLabel value="${supervisor.directNumCounty}"/></td>
					<td><tags:numberLabel value="${supervisor.supervisorNum}"/></td>
					<td><tags:numberLabel value="${supervisor.supervisorMissNum}"/></td>
					<td><tags:numberLabel fractionDigits="2" type="percent" value="${supervisor.supervisorMissRate/100}"/></td>
					<td><tags:numberLabel value="${supervisor.networkNumCity}"/></td>
					<td><tags:numberLabel value="${supervisor.networkNumCounty}"/></td>
					<td class="centertd"><ehr:tip><ehr:dic dicmeta="PH00001" code="${supervisor.surveyFlagCity}"/></ehr:tip></td>
					<td class="centertd"><ehr:tip><ehr:dic dicmeta="PH00001" code="${supervisor.surveyFlagCounty}"/></ehr:tip></td>
					<td><tags:numberLabel value="${supervisor.networkNum}"/></td>
					<td><tags:numberLabel value="${supervisor.networkMissNum}"/></td>
					<td><tags:numberLabel fractionDigits="2" type="percent" value="${supervisor.networkMissRate/100}"/></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="${summaryColspan-5}"><b>合计</b></td>
				<td></td>
				<td></td>
				<td></td>
				<td><b><tags:numberLabel value="${supervisor.sumZeroDefectOrgNum}"/></b></td>
				<td><b><tags:numberLabel value="${supervisor.sumZeroDefectMedicalNum}"/></b></td>
				<td><b><tags:numberLabel value="${supervisor.sumDirectNumProvince}"/></b></td>
				<td><b><tags:numberLabel value="${supervisor.sumDirectNumCity}"/></b></td>
				<td><b><tags:numberLabel value="${supervisor.sumDirectNumCounty}"/></b></td>
				<td><b><tags:numberLabel value="${supervisor.sumSupervisorNum}"/></b></td>
				<td><b><tags:numberLabel value="${supervisor.sumSupervisorMissNum}"/></b></td>
				<td><b><tags:numberLabel fractionDigits="2" type="percent" value="${supervisor.avgSupervisorMissRate/100}"/></b></td>
				<td><b><tags:numberLabel value="${supervisor.sumNetworkNumCity}"/></b></td>
				<td><b><tags:numberLabel value="${supervisor.sumNetworkNumCounty}"/></b></td>
				<td></td>
				<td></td>
				<td><b><tags:numberLabel value="${supervisor.sumNetworkNum}"/></b></td>
				<td><b><tags:numberLabel value="${supervisor.sumNetworkMissNum}"/></b></td>
				<td><b><tags:numberLabel fractionDigits="2" type="percent" value="${supervisor.avgNetworkMissRate/100}"/></b></td>			
			</tr>
			<tr>
				<td colspan="19" style="border:none;text-align: left;">
					<div>注：此表按月填写，市级按月汇总，并完成全年汇总表1份，于每月25日前报上月数据</div>
				</td>
			</tr>
			<tr>
				<td colspan="19" style="border:none;text-align: right;">
					<c:if test="${not empty reportUserCode}">
						<span style="margin: 0px 10px 20px 0px">填报人：</span>
						<span style="margin: 0px 60px 0px 0px"><b><ehr:user userCode="${reportUserCode}"/></b></span>
		        	</c:if>
					
				</td>
			</tr>			
		</tbody>
	</table>
</div>
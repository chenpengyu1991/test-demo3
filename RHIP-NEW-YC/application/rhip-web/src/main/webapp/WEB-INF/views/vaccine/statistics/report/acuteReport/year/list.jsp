<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<script src="${pageContext.request.contextPath}/js/views/vaccine/statistics/report/acuteReport/month/list.js" type="text/javascript"></script>
<div id="acuteMonthList" class="repeattable" style="padding-bottom: 50px;">
	<form id="acuteMonthForm">
		<input type="hidden" name="currentOrgCode" value="${currentOrgCode}"/>
		<input type="hidden" name="currentMonth" value="${currentMonth}"/>

	<table id="acuteMonthtable">
		<colgroup>
			<col style="width: 16%;"/>
			<col style="width: 14%;"/>
			<col style="width: 14%;"/>
			<col style="width: 14%;"/>
			<col style="width: 14%;"/>
			<col style="width: 14%;"/>
			<col style="width: 14%;"/>			
		</colgroup>		
		<thead>
			<tr style="text-align: center;">
				<td style="border:none;"></td>
				<td style="border:none;" colspan="25">
					<h1 style="font-size:150%;margin: 20px 0px 20px 0px">江苏省犬伤处置相关工作情况报表</h1>
				</td>
				<td style="border:none;"></td>
			</tr>
			<tr style="text-align: center;">
		        <td  colspan="1" style="text-align: left;border:none;">
		       		<span>苏州市</span>
		        </td>
		        <td colspan="3" style="text-align: right;border:none;">
		        	<span>________年</span>
		        </td>
		        <td colspan="3" style="text-align: right;border:none;">
		        	<span>填报日期：________年________月________日</span>
		        </td>
		        <td style="text-align: right;border:none;"></td>	        	        
			</tr>			
			<tr>
				<th rowspan="2">单位名称</th>

				<th colspan="6">犬伤处置情况</th>
			</tr>
			<tr>
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
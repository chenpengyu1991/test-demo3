<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page import="com.founder.rhip.ehr.common.EventType" %>
<c:set var="OUTPATIENT" value="<%=EventType.OUTPATIENT.getCode()%>"/>
<c:set var="INPATIENT" value="<%=EventType.INPATIENT.getCode()%>"/>

<input type="hidden" id="prescribeDateBegin" value="${prescribeDateBegin}">
<input type="hidden" id="prescribeDateEnd" value="${prescribeDateEnd}">
<input type="hidden" id="patientType" value="${patientType}">
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:120px;width: 15%;"/>
	        <col style="min-width:80px;width: 10%;"/>
			<col style="min-width:80px;width: 10%;"/>
	        <col style="min-width:80px;width: 10%;"/>
			<col style="min-width:140px;width: 15%;"/>
			<col style="min-width:80px;width: 10%;"/>
           	<col style="min-width:80px;width: 10%;"/>
			<col style="min-width:100px;width: 10%;"/>
		</colgroup>
		<thead>
			<tr>
                <th>医疗机构</th>
				<th>药品通用名</th>
                <th>总金额</th>
				<th>总用量</th>
                <th>
					<c:choose>
                        <c:when test='${patientType == OUTPATIENT}'>处方数</c:when>
                        <c:when test='${patientType == INPATIENT}'>医嘱数</c:when>
	                </c:choose>
                </th>
               	<th>平均用药天数</th>
               	<th>平均用量</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="physicianDrug" items="${physicianDrugs}" varStatus="status">
				<tr>
                    <td><ehr:tip><ehr:org  code="${physicianDrug.hospitalCode}"/></ehr:tip></td>
                    <td class="centertd">${physicianDrug.drugGenericName}</td>
                    <td class="centertd"><tags:numberLabel value="${physicianDrug.totalCost}" fractionDigits="4"/></td>
                    <td class="centertd"><tags:numberLabel value="${physicianDrug.totalDose}" fractionDigits="2"/></td>
                    <td class="lefttd"><tags:numberLabel value="${physicianDrug.recordNumber}"/></td>
                    <td class="centertd"><tags:numberLabel value="${physicianDrug.avgDays}" fractionDigits="2"/></td>
                    <td class="centertd"><tags:numberLabel value="${physicianDrug.avgDose}" fractionDigits="2"/></td>
					<td class="centertd">
						<a href='#' onclick="physicianSearch.medicationRanking('${physicianDrug.hospitalCode}','${physicianDrug.medicareCode}')" class='layui-btn layui-btn-normal layui-btn-xs' title="用药排名" style="color: #FFF;" ><i class="layui-icon">&#xe615;</i>用药排名</a>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<ehr:pagination action="physicianSearch.search" colspan="8"/>
			</tr>
		</tbody>
	</table>
	
</div>
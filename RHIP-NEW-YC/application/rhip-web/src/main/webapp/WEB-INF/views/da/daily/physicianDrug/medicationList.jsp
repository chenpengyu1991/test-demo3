<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
		<div class="repeattable">
			<table class="layui-table x-admin-sm-table-list-middle">
				<colgroup>
					<col style="min-width:100px; width: 25%;"/>
					<col style="min-width:60px; width: 15%;"/>
					<col style="min-width:60px; width: 15%;"/>
					<col style="min-width:60px; width: 15%;"/>
					<col style="min-width:60px; width: 15%;"/>
					<col style="min-width:60px; width: 15%;"/>
				</colgroup>
				<thead>
					<tr>
		                <th class="centerth">医疗机构</th>
						<th class="centerth">
							<c:choose>
		                        <c:when test='${patientType == "1"}'><ehr:tip>处方金额</ehr:tip></c:when>
		                        <c:when test='${patientType == "2"}'><ehr:tip>医嘱费用</ehr:tip></c:when>
		                	</c:choose>						
						</th>
						<th class="centerth">
							<c:choose>
		                        <c:when test='${patientType == "1"}'><ehr:tip>处方类型</ehr:tip></c:when>
		                        <c:when test='${patientType == "2"}'><ehr:tip>医嘱类型</ehr:tip></c:when>
		                	</c:choose>						
						</th>						
		                <th class="centerth">
							<c:choose>
		                        <c:when test='${patientType == "1"}'><ehr:tip>处方号</ehr:tip></c:when>
		                        <c:when test='${patientType == "2"}'><ehr:tip>医嘱号</ehr:tip></c:when>
		                	</c:choose>			                
						</th>
		                <th class="centerth">
							<c:choose>
		                        <c:when test='${patientType == "1"}'><ehr:tip>开方日期</ehr:tip></c:when>
		                        <c:when test='${patientType == "2"}'><ehr:tip>医嘱下达日期</ehr:tip></c:when>
		                	</c:choose>	
						</th>
						<th class="centerth">
							<c:choose>
		                        <c:when test='${patientType == "1"}'><ehr:tip>开方医生</ehr:tip></c:when>
		                        <c:when test='${patientType == "2"}'><ehr:tip>主治医师</ehr:tip></c:when>
		                	</c:choose>							
						</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="medication" items="${medications}" varStatus="status">
					<tr>
	                    <td class="centertd"><ehr:tip><ehr:org  code="${medication.hospitalCode}"/></ehr:tip></td>
	                    <td class="centertd"><tags:numberLabel value="${medication.totalCost}" fractionDigits="2"/></td>
	                    <td class="centertd">
							<c:choose>
		                        <c:when test='${patientType == "1"}'><ehr:tip><ehr:dic dicmeta="FS10306" code="${medication.cmType}"/></ehr:tip></c:when>
		                        <c:when test='${patientType == "2"}'><ehr:tip><ehr:dic dicmeta="FS10303" code="${medication.cmType}"/></ehr:tip></c:when>
		                	</c:choose>		                    
	                    </td>
	                    <td class="centertd">${medication.recordNumber}</td>
	                    <td class="centertd"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${medication.clinicDate}"/></ehr:tip></td>
	                    <td class="centertd"><ehr:tip>${medication.doctorName}</ehr:tip></td>
					</tr>
				</c:forEach>
				<tr>
					<ehr:pagination action="medication.medicationSearch" colspan="6"/>
				</tr>
				</tbody>
			</table>
		</div>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<input type="hidden" id="prescribeDateBegin" value="${prescribeDateBegin}">
<input type="hidden" id="prescribeDateEnd" value="${prescribeDateEnd}">
<input type="hidden" id="patientType" value="${patientType}">
<div class="repeattable">
	<table>
		<colgroup>
			<col style="min-width:120px;width: 20%;"/>
	        <col style="min-width:80px;width: 30%;"/>
			<col style="min-width:80px;width: 30%;"/>
	        <col style="min-width:80px;width: 20%;"/>
		</colgroup>
		<thead>
			<tr>
                <th>医疗机构</th>
				<th>药品总费用</th>
                <th>门诊总费用</th>
				<th>药占比%</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="outpatientDrug" items="${outpatientDrugs}" varStatus="status">
				<tr>
                    <td><ehr:tip><ehr:org  code="${outpatientDrug.hospitalCode}"/></ehr:tip></td>
                    <td class="centertd">
						<a href="javascript:void(0)" onclick="outpatientDrugSearch.drugSearch('${outpatientDrug.hospitalCode}','${outpatientDrug.drugCostSum}')" class="person-link-btn">                    
                    		<tags:numberLabel value="${outpatientDrug.drugCostSum}" fractionDigits="2"/>
                    	</a>
                    </td>
                    <td class="centertd">
						<a href="javascript:void(0)" onclick="outpatientDrugSearch.itemSearch('${outpatientDrug.hospitalCode}','${outpatientDrug.totalCostSum}')" class="person-link-btn">                    
                    		<tags:numberLabel value="${outpatientDrug.totalCostSum}" fractionDigits="2"/>
                    	</a>                    
                    </td>
                    <td class="centertd"><tags:numberLabel value="${outpatientDrug.drugRate*100}" fractionDigits="2"  defaultValue="0"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="outpatientDrugSearch.search" />
		</tr>
	</table>
</div>
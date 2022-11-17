<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<div class="repeattable">
	<table>
		<colgroup>
			<col style="width:5%;"/>		
	        <col style="width:35%;"/>
	        <col style="width:20%;"/>
			<col style="width:20%;"/>
			<col style="width:20%;"/>
		</colgroup>	
		<thead>
			<tr>
				<th class="centerth">选择</th>
				<th class="centerth">药物名称</th>
				<th class="centerth">药品剂型</th>
				<th class="centerth">药品单位</th>
				<th class="centerth">药品价格</th>				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="mhmDrug" items="${mhmDrugs}" varStatus="status">
				<tr id="${mhmDrug.id}" onclick = 'medication.rowclick(this)'>
					<td><input type="radio" name="selectMedication" value="${mhmDrug.id}" style="width: 20px;"/></td>
					<td data-value="${mhmDrug.drugName}"><ehr:tip>${mhmDrug.drugName}</ehr:tip></td>
					<td data-value="${mhmDrug.drugForm}"><ehr:tip>${mhmDrug.drugForm}</ehr:tip></td>
					<td data-value="${mhmDrug.drugUnit}"><ehr:tip>${mhmDrug.drugUnit}</ehr:tip></td>
					<td data-value="${mhmDrug.unitPrice}"><ehr:tip>${mhmDrug.unitPrice}</ehr:tip></td>										
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="medication.search" />
		</tr>
	</table>
</div>
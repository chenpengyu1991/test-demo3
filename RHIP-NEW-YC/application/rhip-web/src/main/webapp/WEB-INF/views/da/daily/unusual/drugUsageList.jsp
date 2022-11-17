<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
	<fieldset>
		<div class="repeattable">
			<table>
				<colgroup>
					<col style="min-width:60px; width: 10%;"/>
					<col style="min-width:60px; width: 10%;"/>
					<col style="min-width:60px; width: 10%;"/>
					<col style="min-width:60px; width: 10%;"/>
					<col style="min-width:60px; width: 10%;"/>
					<col style="min-width:60px; width: 10%;"/>
					<col style="min-width:60px; width: 10%;"/>
					<col style="min-width:60px; width: 10%;"/>
					<col style="min-width:60px; width: 10%;"/>
				</colgroup>
				<thead>
					<tr>
		                <th class="centerth">药品名称</th>
						<th class="centerth">规格</th>
		                <th class="centerth">单位</th>
		                <th class="centerth">数量</th>
		                <th class="centerth">总剂量</th>
						
		                <th class="centerth">频次</th>
		               	<th class="centerth">天数</th>
						<th class="centerth">用法</th>
						<th class="centerth">单价</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="drugusage" items="${drugusages}" varStatus="status">
					<tr>
	                    <td class="centertd"><ehr:tip>${drugusage.drugGenericName}</ehr:tip></td>
	                    <td class="centertd">${drugusage.drugSpecifications}</td>
	                    <td class="centertd">${drugusage.quantityUnit}</td>
	                    <td class="centertd"><tags:numberLabel value="${drugusage.quantity}" fractionDigits="2"/></td>
	                    <td class="centertd"><tags:numberLabel value="${drugusage.drugUseTotalDose}" fractionDigits="2"/></td>
	                    
	                    <td class="centertd"><ehr:tip>${drugusage.drugUseFrequency}</ehr:tip></td>
	                    <td class="centertd"><tags:numberLabel value="${drugusage.drugUseDays}"/></td>
	                    <td class="centertd"><ehr:tip>${drugusage.drugUseRouteCode}</ehr:tip></td>
	                    <td class="centertd"><tags:numberLabel value="${drugusage.unitPrice}" fractionDigits="2"/></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<table>
				<tr>
					<ehr:pagination action="prescription.drugUsageSearch" />
				</tr>
			</table>
		</div>	
	</fieldset>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<table class="layui-table x-admin-sm-table-list-middle">
	<colgroup>
		<col style="min-width:120px;width: 10%;"/>
		<col style="min-width:80px;width: 8%;"/>
		<col style="min-width:80px;width: 6%;"/>
		<col style="min-width:80px;width: 6%;"/>
		<col style="min-width:80px;width: 6%;"/>
		<col style="min-width:80px;width: 6%;"/>
		<col style="min-width:100px;width: 6%;"/>
		<col style="min-width:80px;width: 6%;"/>
		<col style="min-width:100px;width: 10%;"/>
		<col style="min-width:80px;width: 6%;"/>
		<col style="min-width:80px;width: 6%;"/>
		<col style="min-width:80px;width: 6%;"/>
		<col style="min-width:100px;width: 10%;"/>
		<col style="min-width:80px;width: 8%;"/>
	</colgroup>
	<thead>
		<tr>
			<th>医疗机构</th>
			<th>所属药房</th>
			<th>药品代码</th>
			<th>药品名</th>
			<th>通用名</th>
			<th>药品规格</th>
			<th>包装</th>
			<th>产地</th>
			<th>生产厂家</th>
			<th>库存数量</th>
			<th>零售价格</th>
			<th>库存金额</th>
			<th>批号</th>
			<th>失效日期</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="pharmacy" items="${pharmacys}" varStatus="status">
			<tr>
				<td><ehr:tip><ehr:org  code="${pharmacy.ORGAN_CODE}"/></ehr:tip></td>
				<td><ehr:tip>${pharmacy.PHARMACY_NAME}</ehr:tip></td>
				<td><ehr:tip>${pharmacy.DRUG_MEDICARE_CODE}</ehr:tip></td>
				<td><ehr:tip>${pharmacy.DRUG_TRADE_NAME}</ehr:tip></td>
				<td><ehr:tip>${pharmacy.DRUG_GENERIC_NAME}</ehr:tip></td>
				<td><ehr:tip>${pharmacy.SPECIFICATIONS}</ehr:tip></td>
				<td><ehr:tip>${pharmacy.PACKAGING}</ehr:tip></td>
				<td><ehr:tip><ehr:dic dicmeta="DA00002" code="${pharmacy.SOURCE_TYPE}"/></ehr:tip></td>
				<td><ehr:tip>${pharmacy.FAC_NAME}</ehr:tip></td>
				<td><tags:numberLabel value="${pharmacy.PHARMACY_NUM}" fractionDigits="2"/></td>
				<td><tags:numberLabel value="${pharmacy.RETAIL_PRICE}" fractionDigits="2"/></td>
				<td><tags:numberLabel value="${pharmacy.PHARMACY_AMOUNT}" fractionDigits="2"/></td>
				<td><ehr:tip>${pharmacy.BATCH_NO}</ehr:tip></td>
				<td><ehr:tip><fmt:formatDate value="${pharmacy.EXPIRY_DT}" pattern="yyyy/MM/dd"/></ehr:tip></td>
			</tr>
		</c:forEach>
		<tr>
			<c:if test="${not empty type}"><ehr:pagination action="disDetailSearch.search" colspan="14"/></c:if>
			<c:if test="${empty type}"><ehr:pagination action="pharmacySearch.search" colspan="14"/></c:if>
		</tr>
	</tbody>
</table>

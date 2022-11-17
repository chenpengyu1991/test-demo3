<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:120px;width: 12%;"/>
			<col style="min-width:80px;width: 6%;"/>
	        <col style="min-width:80px;width: 8%;"/>
			<col style="min-width:80px;width: 8%;"/>
	        <col style="min-width:80px;width: 8%;"/>
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
                <th>药品名称</th>
                <th>通用名</th>
				<th>药品规格</th>
				<th>包装</th>
				<th>产地</th>
				<th>生产厂家</th>
				<th>库存数量</th>
				<th>进货价格</th>
				<th>批发价格</th>
				<th>零售价格</th>
				<th>批号</th>
				<th>失效日期</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="storage" items="${storages}" varStatus="status">
				<tr>
					<td><ehr:tip><ehr:org  code="${storage.ORGAN_CODE}"/></ehr:tip></td> 
                    <td><ehr:tip>${storage.DRUG_TRADE_NAME}</ehr:tip></td>
                    <td><ehr:tip>${storage.DRUG_GENERIC_NAME}</ehr:tip></td>
                    <td><ehr:tip>${storage.SPECIFICATIONS}</ehr:tip></td>
                    <td><ehr:tip>${storage.PACKAGING}</ehr:tip></td>
                    <td><ehr:tip><ehr:dic dicmeta="DA00002" code="${storage.SOURCE_TYPE}"/></ehr:tip></td>
                    <td><ehr:tip>${storage.FAC_NAME}</ehr:tip></td>
                    <td><tags:numberLabel value="${storage.STORAGE_NUM}" fractionDigits="2"/></td>
                    <td><tags:numberLabel value="${storage.STORAGE_PRICE}" fractionDigits="2"/></td>
                    <td><tags:numberLabel value="${storage.WHOLESALE_PRICE}" fractionDigits="2"/></td>
                    <td><tags:numberLabel value="${storage.RETAIL_PRICE}" fractionDigits="2"/></td>
                    <td><ehr:tip>${storage.BATCH_NO}</ehr:tip></td>
                    <td><ehr:tip><fmt:formatDate value="${storage.EXPIRY_DT}" pattern="yyyy/MM/dd"/></ehr:tip></td>
				</tr>
			</c:forEach>
			<tr>
				<c:if test="${not empty type}"><ehr:pagination action="disDetailSearch.search" colspan="13"/></c:if>
				<c:if test="${empty type}"><ehr:pagination action="storageSearch.search" colspan="13"/></c:if>
			</tr>
		</tbody>
	</table>
</div>
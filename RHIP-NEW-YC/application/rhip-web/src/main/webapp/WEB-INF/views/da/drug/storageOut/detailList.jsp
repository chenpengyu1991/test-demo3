<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="repeattable" style="overflow: auto">
	<table class="layui-table x-admin-sm-table-list-middle" >
		<colgroup>
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
			<col style="min-width:80px;width: 6%;"/>
			<col style="min-width:150px;width: 20%;"/>
			<col style="min-width:100px;width: 10%;"/>
		</colgroup>
		<thead>
			<tr>
                <th>药品代码</th>
				<th>药品名</th>
                <th>通用名</th>
				<th>规格</th>
				<th>包装</th>
				<th>产地</th>
				<th>生产厂家</th>
				<th>批发价格</th>
				<th>零售价格</th>
				<th>请领数量</th>
				<th>实发数量</th>
				<th>出库单价</th>
				<th>出库金额</th>
				<th>批号</th>
				<th>失效日期</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="detail" items="${storageOutDetails}" varStatus="status">
				<tr>
                    <td><ehr:tip>${detail.DRUG_MEDICARE_CODE}</ehr:tip></td>
                    <td><ehr:tip>${detail.DRUG_TRADE_NAME}</ehr:tip></td>
                    <td><ehr:tip>${detail.DRUG_GENERIC_NAME}</ehr:tip></td>
                    <td><ehr:tip>${detail.SPECIFICATIONS}</ehr:tip></td>
                    <td><ehr:tip>${detail.PACKAGING}</ehr:tip></td>
                    <td><ehr:tip><ehr:dic dicmeta="DA00002" code="${detail.SOURCE_TYPE}"/></ehr:tip></td>
                    <td><ehr:tip>${detail.FAC_NAME}</ehr:tip></td>
                    <td><tags:numberLabel value="${detail.WHOLESALE_PRICE}" fractionDigits="2"/></td>
                    <td><tags:numberLabel value="${detail.RETAIL_PRICE}" fractionDigits="2"/></td>
                    <td><tags:numberLabel value="${detail.APPLY_NUM}" fractionDigits="2"/></td>
                    <td><tags:numberLabel value="${detail.APPLY_REAL_NUM}" fractionDigits="2"/></td>
                    <td><tags:numberLabel value="${detail.APPLY_PRICE}" fractionDigits="2"/></td>
                    <td><tags:numberLabel value="${detail.APPLY_PRICE*detail.APPLY_REAL_NUM}" fractionDigits="2"/></td>
                    <td><ehr:tip>${detail.BATCH_NO}</ehr:tip></td>
                    <td><ehr:tip><fmt:formatDate value="${detail.EXPIRY_DT}" pattern="yyyy/MM/dd"/></ehr:tip></td>
				</tr>
			</c:forEach>
			<tr>
				<ehr:pagination action="detailSearch.search"  colspan="15"/>
			</tr>
		</tbody>
	</table>
</div>
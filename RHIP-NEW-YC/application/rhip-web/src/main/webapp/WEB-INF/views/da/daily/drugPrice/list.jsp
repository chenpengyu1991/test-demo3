<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="repeattable">
	<table>
		<colgroup>
			<col style="min-width:80px;width: 10%;"/>
			<col style="min-width:80px;width: 10%;"/>
	        <col style="min-width:80px;width: 7%;"/>
			<col style="min-width:80px;width: 7%;"/>
	        <col style="min-width:80px;width: 7%;"/>
			<col style="min-width:80px;width: 7%;"/>
	        <col style="min-width:80px;width: 7%;"/>
			<col style="min-width:80px;width: 7%;"/>
	        <col style="min-width:80px;width: 7%;"/>
	        <col style="min-width:80px;width: 7%;"/>
			<col style="min-width:80px;width: 7%;"/>
	        <col style="min-width:80px;width: 7%;"/>
	        <col style="min-width:80px;width: 10%;"/>
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
				<th>批发价格</th>
				<th>零售价格</th>
				<th>价格差</th>
				<th>差价率</th>
				<th>批号</th>
				<th>失效日期</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="drugPrice" items="${drugPrices}" varStatus="status">
				<tr>
					<td><ehr:tip><ehr:org  code="${drugPrice.hospitalCode}"/></ehr:tip></td>
                    <td><ehr:tip>${drugPrice.genericName}</ehr:tip></td>
                    <td><ehr:tip>${drugPrice.genericName}</ehr:tip></td>
                    <td><ehr:tip>${drugPrice.specifications}</ehr:tip></td>
                    <td><ehr:tip>${drugPrice.packaging}</ehr:tip></td>
                    <td><ehr:tip><ehr:dic dicmeta="DA00002" code="${drugPrice.sourceType}"/></ehr:tip></td>
                    <td><ehr:tip>${drugPrice.facName}</ehr:tip></td>
                    <td><tags:numberLabel value="${drugPrice.wholesalePrice}" fractionDigits="2"/></td>
                    <td><tags:numberLabel value="${drugPrice.retailPrice}" fractionDigits="2"/></td>
                    <td><tags:numberLabel value="${drugPrice.priceDifference}" fractionDigits="2"/></td>
                    <td><tags:numberLabel value="${drugPrice.diffdrenceRate}" fractionDigits="2"/></td>                    
                    <td><ehr:tip>${drugPrice.batchNo}</ehr:tip></td>
                    <td><ehr:tip><fmt:formatDate value="${drugPrice.expiryDt}" pattern="yyyy/MM/dd"/></ehr:tip></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="drugPriceSearch.search" />
		</tr>
	</table>
</div>
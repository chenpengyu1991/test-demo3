<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="repeattable">
	<table>
		<colgroup>
			<col style="min-width:80px;width: 8%;"/>
	        <col style="min-width:80px;width: 8%;"/>
			<col style="min-width:80px;width: 8%;"/>
	        <col style="min-width:90px;width: 8%;"/>
			<col style="min-width:100px;width: 8%;"/>
	        <col style="min-width:80px;width: 8%;"/>
			<col style="min-width:80px;width: 8%;"/>
	        <col style="min-width:80px;width: 8%;"/>
	        <col style="min-width:80px;width: 8%;"/>
			<col style="min-width:100px;width: 10%;"/>
	        <col style="min-width:100px;width: 10%;"/>
	        <col style="min-width:80px;width: 8%;"/>
		</colgroup>
		<thead>
			<tr>
                <th>药品编码</th>
				<th>药品名称</th>
                <th>通用名</th>
				<th>规格</th>
				<th>包装</th>
				<th>产地</th>
				<th>生产厂家</th>
				<th>批发价格</th>
				<th>零售价格</th>
				<th>总数量</th>
				<th>总金额</th>
				<th>批号</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="detail" items="${details}" varStatus="status">
				<tr>
                    <td><ehr:tip>${detail.drugCode}</ehr:tip></td>
                    <td><ehr:tip>${detail.tradeName}</ehr:tip></td>
                    <td><ehr:tip>${detail.genericName}</ehr:tip></td>
                    <td><ehr:tip>${detail.specifications}</ehr:tip></td>
                    <td><ehr:tip>${detail.packaging}</ehr:tip></td>
                    <td><ehr:tip><ehr:dic dicmeta="DA00002" code="${detail.sourceType}"/></ehr:tip></td>
                    <td><ehr:tip>${detail.facName}</ehr:tip></td>
                    <td><tags:numberLabel value="${detail.wholesalePrice}" fractionDigits="2"/></td>
                    <td><tags:numberLabel value="${detail.retailPrice}" fractionDigits="2"/></td>
                    <td><tags:numberLabel value="${detail.quantitySum}" fractionDigits="2"/></td>
                    <td><tags:numberLabel value="${detail.costSum}" fractionDigits="2"/></td>
                    <td><ehr:tip>${detail.batchNo}</ehr:tip></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="detailSearch.search" />
		</tr>
	</table>
	
</div>
<div style="float:right;margin:10px 10px 5px 0px"><b>金额合计：</b><fmt:formatNumber value="${drugCostSum}" pattern="##.##" minFractionDigits="2" ></fmt:formatNumber></div>
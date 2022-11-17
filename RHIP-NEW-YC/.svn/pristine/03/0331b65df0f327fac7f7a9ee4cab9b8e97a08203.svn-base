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
			<col style="min-width:120px;width: 12%;"/>
	        <col style="min-width:100px;width: 10%;"/>
			<col style="min-width:100px;width: 10%;"/>
			<col style="min-width:80px;width: 8%;"/>
	        <col style="min-width:80px;width: 8%;"/>
			<col style="min-width:100px;width: 8%;"/>
	        <col style="min-width:80px;width: 8%;"/>
	        <col style="min-width:140px;width: 12%;"/>
	        <col style="min-width:80px;width: 8%;"/>
		</colgroup>
		<thead>
			<tr>
				<th>单位名称</th>
                <th>设备名称</th>
				<th>规格型号</th>
				<th>生产厂家</th>
				<th>库存数量</th>
				<th>采购价格</th>
				<th>采购日期</th>
				<th>单位</th>
				<th>财产编号</th>
				<th>品牌</th>
				<th>使用年限</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="store" items="${stores}" varStatus="status">
				<tr>
                    <td><ehr:tip><ehr:org  code="${store.ORGAN_CODE}"/></ehr:tip></td>
                    <td><ehr:tip>${store.GENERIC_NAME}</ehr:tip></td>
                    <td><ehr:tip>${store.SPECIFICATIONS}</ehr:tip></td>
                    <td><ehr:tip>${store.FAC_NAME}</ehr:tip></td>
                    <td><tags:numberLabel value="${store.STORAGE_NUM}" fractionDigits="2"/></td>
                    <td><tags:numberLabel value="${store.STORAGE_PRICE}" fractionDigits="2"/></td>
					<td><ehr:tip><fmt:formatDate value="${store.PURCHASE_DT}" pattern="yyyy/MM/dd"/></ehr:tip></td>
					<td><ehr:tip>${store.UNIT}</ehr:tip></td>                    
                    <td><ehr:tip>${store.PROPERTY_NO}</ehr:tip></td>
                    <td><ehr:tip>${store.BRAND}</ehr:tip></td>
                    <td><ehr:tip>${store.DURABLE_YEARS}</ehr:tip></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<tr>
			<ehr:pagination action="storageSearch.search" />
		</tr>
	</table>
</div>
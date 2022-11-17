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
				<th>报损数量</th>
				<th>采购价格</th>
				<th>采购日期</th>
				<th>单位</th>
				<th>财产编号</th>
				<th>品牌</th>
				<th>使用年限</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="breakage" items="${breakages}" varStatus="status">
				<tr>
                    <td><ehr:tip><ehr:org  code="${breakage.ORGAN_CODE}"/></ehr:tip></td>
                    <td><ehr:tip>${breakage.GENERIC_NAME}</ehr:tip></td>
                    <td><ehr:tip>${breakage.SPECIFICATIONS}</ehr:tip></td>
                    <td><ehr:tip>${breakage.FAC_NAME}</ehr:tip></td>
                    <td><tags:numberLabel value="${breakage.BREAKAGE_NUM}" fractionDigits="2"/></td>
                    <td><tags:numberLabel value="${breakage.STORAGE_PRICE}" fractionDigits="2"/></td>
					<td><ehr:tip><fmt:formatDate value="${breakage.PURCHASE_DT}" pattern="yyyy/MM/dd"/></ehr:tip></td>
					<td><ehr:tip>${breakage.MODEL_NO}</ehr:tip></td>                    
                    <td><ehr:tip>${breakage.PROPERTY_NO}</ehr:tip></td>
                    <td><ehr:tip>${breakage.BRAND}</ehr:tip></td>
                    <td><ehr:tip>${breakage.DURABLE_YEARS}</ehr:tip></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<tr>
			<ehr:pagination action="breakageSearch.search" />
		</tr>
	</table>
</div>
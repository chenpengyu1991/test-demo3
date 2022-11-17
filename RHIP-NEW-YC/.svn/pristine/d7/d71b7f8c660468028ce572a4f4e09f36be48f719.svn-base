<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:150px;width: 25%;"/>
	        <col style="min-width:120px;width: 15%;"/>
			<col style="min-width:80px;width: 12%;"/>
	        <col style="min-width:80px;width: 12%;"/>
	        <col style="min-width:80px;width: 12%;"/>
	        <col style="min-width:80px;width: 12%;"/>
	        <col style="min-width:80px;width: 12%;"/>	
		</colgroup>
		<thead>
			<tr>
                <th>医疗机构</th>
				<th>药品编码</th>
                <th>通用名</th>
				<th>药库入库量</th>
				<th>药库出库量</th>
				<th>药房入库量</th>
				<th>药房出库量</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="change" items="${changelist}" varStatus="status">
				<tr>
                    <td>${storage.orgCode}${change.orgCode}
                    	<c:choose>
                    		<c:when test="${genreCode eq '0'}"><ehr:tip><ehr:dic dicmeta="FS990001" code="${change.orgCode}"/></ehr:tip></c:when>
                    		<c:otherwise><ehr:tip><ehr:org code="${change.orgCode}"/></ehr:tip></c:otherwise>
                    	</c:choose>
                    </td>
                    <td><ehr:tip>${change.medicareCode}</ehr:tip></td>
                    <td><ehr:tip>${change.medicareName}</ehr:tip></td>                       
                    <td><tags:numberLabel value="${change.storageInNum}" fractionDigits="2" defaultValue="0"/></td>
                    <td><tags:numberLabel value="${change.storageOutNum}" fractionDigits="2" defaultValue="0"/></td>
                    <td><tags:numberLabel value="${change.pharmacyInNum}" fractionDigits="2" defaultValue="0"/></td>
                    <td><tags:numberLabel value="${change.pharmacyOutNum}" fractionDigits="2" defaultValue="0"/></td>
				</tr>
			</c:forEach>
			<tr>
				<ehr:pagination action="ihmCommon.search" colspan="7" />
			</tr>
		</tbody>
	</table>
</div>
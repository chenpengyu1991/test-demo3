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
	        <col style="min-width:80px;width: 15%;"/>
			<col style="min-width:80px;width: 15%;"/>
	        <col style="min-width:80px;width: 15%;"/>
	        <col style="min-width:80px;width: 15%;"/>
	        <%-- <col style="min-width:80px;width: 15%;"/> --%>
		</colgroup>
		<thead>
			<tr>
                <th>医疗机构</th>
				<th>药品编码</th>
                <th>通用名</th>
				<th>药库库存量</th>
				<th>药房库存量</th>
				<!-- <th>科室库存量</th> -->
			</tr>
		</thead>
		<tbody>
			<c:forEach var="storage" items="${storagelist}" varStatus="status">
				<tr>
                    <td>
                   		<c:choose>
                    		<c:when test="${genreCode eq '0'}"><ehr:tip><ehr:dic dicmeta="FS990001" code="${storage.orgCode}"/></ehr:tip></c:when>
                    		<c:otherwise><ehr:tip><ehr:org code="${storage.orgCode}"/></ehr:tip></c:otherwise>
                    	</c:choose>
                    </td>
                    <td><ehr:tip>${storage.medicareCode}</ehr:tip></td>
                    <td><ehr:tip>${storage.medicareName}</ehr:tip></td>                       
                    <td><tags:numberLabel value="${storage.storageNum}" fractionDigits="2" defaultValue="0"/></td>
                    <td><tags:numberLabel value="${storage.pharmacyNum}" fractionDigits="2" defaultValue="0"/></td>
                    <%-- <td><tags:numberLabel value="${storage.roomNum}" fractionDigits="2" defaultValue="0"/></td> --%>
                </tr>
			</c:forEach>
			<tr>
				<ehr:pagination action="ihmCommon.search" colspan="5" />
			</tr>
		</tbody>
	</table>
	<%-- <ehr:paging /> --%>
</div>
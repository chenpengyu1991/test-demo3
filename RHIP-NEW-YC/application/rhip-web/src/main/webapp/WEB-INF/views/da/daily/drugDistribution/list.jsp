<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:120px;width: 20%;"/>
	        <col style="min-width:80px;width: 10%;"/>
			<col style="min-width:80px;width: 10%;"/>
	        <col style="min-width:80px;width: 15%;"/>
	        <col style="min-width:80px;width: 15%;"/>
	        <col style="min-width:80px;width: 15%;"/>
	        <col style="min-width:80px;width: 15%;"/>	        	        	        
		</colgroup>
		<thead>
			<tr>
                <th>医疗机构</th>
				<th>药品名称</th>
                <th>通用名</th>
				<th>药库入库量</th>
				<th>药库库存量</th>
				<th>药房库存量</th>
				<th>科室库存量</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="drugDistribution" items="${drugDistributions}" varStatus="status">
				<tr>
                    <td><ehr:tip><ehr:org  code="${drugDistribution.organCode}"/></ehr:tip></td>
                    <td><ehr:tip>${drugDistribution.tradeName}</ehr:tip></td>
                    <td><ehr:tip>${drugDistribution.genericName}</ehr:tip></td>                       
                    <td>
                    	<c:choose>
                    		<c:when test="${drugDistribution.purchaseNum>0}">
		                     	<a href="javascript:void(0)"  class="person-link-btn  storage-in-link"
		                     		data-type="1" data-organ-code="${drugDistribution.organCode}" data-generic-name="${drugDistribution.genericName}"  data-medicare-code="${drugDistribution.medicareCode}" >
		                    		<tags:numberLabel value="${drugDistribution.purchaseNum}" fractionDigits="2" defaultValue="0"/>
		                    	</a>                   		
                    		</c:when>
                    		<c:otherwise>
                    			<tags:numberLabel value="${drugDistribution.purchaseNum}" fractionDigits="2" defaultValue="0"/>
                    		</c:otherwise>
                    	</c:choose>
                    </td>
                    <td>
                    	<c:choose>
                    		<c:when test="${drugDistribution.storageNum>0}">
		                    	<a href="javascript:void(0)" class="person-link-btn storage-link"
		                    		data-type="2" data-organ-code="${drugDistribution.organCode}" data-generic-name="${drugDistribution.genericName}"  data-medicare-code="${drugDistribution.medicareCode}" >
		                    		<tags:numberLabel value="${drugDistribution.storageNum}" fractionDigits="2" defaultValue="0"/>
		                    	</a>                 		
                    		</c:when>
                    		<c:otherwise>
                    			<tags:numberLabel value="${drugDistribution.storageNum}" fractionDigits="2" defaultValue="0"/>
                    		</c:otherwise>
                    	</c:choose>                    
                    </td>
                    <td>
                    	<c:choose>
                    		<c:when test="${drugDistribution.pharmacyNum>0}">
		                    	<a href="javascript:void(0)" class="person-link-btn pharmacy-link"
		                    		data-type="3" data-organ-code="${drugDistribution.organCode}" data-generic-name="${drugDistribution.genericName}"  data-medicare-code="${drugDistribution.medicareCode}" >
		                    		<tags:numberLabel value="${drugDistribution.pharmacyNum}" fractionDigits="2" defaultValue="0"/>
		                    	</a>               		
                    		</c:when>
                    		<c:otherwise>
                    			<tags:numberLabel value="${drugDistribution.pharmacyNum}" fractionDigits="2" defaultValue="0"/>
                    		</c:otherwise>
                    	</c:choose>                     
                    </td>
                    <td>
                    	<c:choose>
                    		<c:when test="${drugDistribution.roomNum>0}">
		                    	<a href="javascript:void(0)" class="person-link-btn clinic-link"
		                    		data-type="4" data-organ-code="${drugDistribution.organCode}" data-generic-name="${drugDistribution.genericName}"  data-medicare-code="${drugDistribution.medicareCode}" >
		                    		<tags:numberLabel value="${drugDistribution.roomNum}" fractionDigits="2" defaultValue="0"/>
		                    	</a>             		
                    		</c:when>
                    		<c:otherwise>
                    			<tags:numberLabel value="${drugDistribution.roomNum}" fractionDigits="2" defaultValue="0"/>
                    		</c:otherwise>
                    	</c:choose>                     
                    </td>
				</tr>
			</c:forEach>
			<tr>
				<ehr:pagination action="drugDistributionSearch.search" colspan="7"/>
			</tr>
		</tbody>
	</table>
</div>
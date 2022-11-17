<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:100px;width: 10%;"/>
			<col style="min-width:80px;width: 6%;"/>
			<col style="min-width:80px;width: 6%;"/>
	        <col style="min-width:80px;width: 6%;"/>
			<col style="min-width:100px;width: 8%;"/>
	        <col style="min-width:80px;width: 6%;"/>
			<col style="min-width:100px;width: 7%;"/>
	        <col style="min-width:80px;width: 6%;"/>
			<col style="min-width:100px;width: 6%;"/>
	        <col style="min-width:80px;width: 7%;"/>
	        <col style="min-width:80px;width: 7%;"/>
			<col style="min-width:80px;width: 7%;"/>
	        <col style="min-width:80px;width: 6%;"/>
	        <col style="min-width:80px;width: 7%;"/>
	        <col style="min-width:80px;width: 6%;"/>
		</colgroup>
		<thead>
			<tr>
				<th>医疗机构</th>
				<th>库位</th>
				<th>药品代码</th>
				<th>药品分类</th>
                <th>药品名</th>
                <th>通用名</th>
				<th>规格</th>
				<th>包装</th>
				<th>生产厂家</th>
				<th>零售价格</th>
				<th>药品批号</th>		
				<th>失效日期</th>						
				<th>损坏因素</th>
				<th>养护日期</th>
				<th>养护人</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="upkeep" items="${upkeeps}" varStatus="status">
				<tr>
					<td><ehr:tip><ehr:org  code="${upkeep.ORGAN_CODE}"/></ehr:tip></td>
                    <td><ehr:tip>${upkeep.STORAGE_LOCATION}</ehr:tip></td>
                    <td><ehr:tip>${upkeep.DRUG_MEDICARE_CODE}</ehr:tip></td>
                    <td><ehr:tip><ehr:dic dicmeta="DA00004" code="${upkeep.DRUG_TYPE_CODE}"/></ehr:tip></td>
                    <td><ehr:tip>${upkeep.DRUG_TRADE_NAME}</ehr:tip></td>
                    <td><ehr:tip>${upkeep.DRUG_GENERIC_NAME}</ehr:tip></td>
                    <td><ehr:tip>${upkeep.SPECIFICATIONS}</ehr:tip></td>
                    <td><ehr:tip>${upkeep.PACKAGING}</ehr:tip></td>
                    <td><ehr:tip>${upkeep.FAC_NAME}</ehr:tip></td>
                    <td><tags:numberLabel value="${upkeep.RETAIL_PRICE}" fractionDigits="2"/></td>
                    <td><ehr:tip>${upkeep.PROD_PATCH}</ehr:tip></td>
                    <td><ehr:tip><fmt:formatDate value="${upkeep.EXPIRY_DT}" pattern="yyyy/MM/dd"/></ehr:tip></td>
                    <td><ehr:tip><ehr:dic dicmeta="DA00014" code="${upkeep.DAMAGE_ELEMENT_CODE}"/></ehr:tip></td>
                    <td><ehr:tip><fmt:formatDate value="${upkeep.UPKEEP_DT}" pattern="yyyy/MM/dd"/></ehr:tip></td>
                    <td><ehr:tip>${upkeep.OPERATOR_NAME}</ehr:tip></td>
				</tr>
			</c:forEach>
			<tr>
			<ehr:pagination action="upkeepSearch.search" colspan="15"/>
			</tr>
		</tbody>
	</table>
	<%-- <table>
		<tr>
			<ehr:pagination action="pharmacySearch.search" />
		</tr>
	</table> --%>
</div>
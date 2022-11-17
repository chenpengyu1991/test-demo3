<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:80px;width: 12%;"/>
	        <col style="min-width:80px;width: 7%;"/>
			<col style="min-width:80px;width: 7%;"/>
	        <col style="min-width:80px;width: 7%;"/>
			<col style="min-width:100px;width: 7%;"/>
	        <col style="min-width:80px;width: 7%;"/>
			<col style="min-width:100px;width: 7%;"/>
	        <col style="min-width:80px;width: 7%;"/>
	        <col style="min-width:80px;width: 7%;"/>
	        <col style="min-width:80px;width: 7%;"/>
	        <col style="min-width:100px;width: 15%;"/>
	        <col style="min-width:80px;width: 10%;"/>
		</colgroup>
		<thead>
			<tr>
                <th>耗材名称</th>
				<th>管理分类</th>
				<th>规格</th>
				<th>单位</th>
				<th>生产企业</th>
				<th>批发价</th>
				<th>零售价</th>
				<th>入库数量</th>
				<th>进货价</th>
				<th>进货金额</th>
				<th>注册证号</th>
				<th>失效日期</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="detail" items="${consumableInDetails}" varStatus="status">
				<tr>
                    <td><ehr:tip>${detail.GENERIC_NAME}</ehr:tip></td>
                    <td><ehr:tip>${detail.MANAGE_TYPE_NAME}</ehr:tip></td>
                    <td><ehr:tip>${detail.SPECIFICATIONS}</ehr:tip></td>
                    <td><ehr:tip>${detail.PACKAGING}</ehr:tip></td>
                    <td><ehr:tip>${detail.FAC_NAME}</ehr:tip></td>
                    <td><tags:numberLabel value="${detail.WHOLESALE_PRICE}" fractionDigits="2"/></td>
                    <td><tags:numberLabel value="${detail.RETAIL_PRICE}" fractionDigits="2"/></td>
                    <td><tags:numberLabel value="${detail.PURCHASE_NUM}" fractionDigits="2"/></td>
					<td><tags:numberLabel value="${detail.PURCHASE_PRICE}" fractionDigits="2"/></td>
                    <td><tags:numberLabel value="${detail.PURCHASE_AMOUNT}" fractionDigits="2"/></td>                    
                    <td><ehr:tip>${detail.REGISTER_NO}</ehr:tip></td>
                    <td><ehr:tip><fmt:formatDate value="${detail.EXPIRY_DT}" pattern="yyyy/MM/dd"/></ehr:tip></td>
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
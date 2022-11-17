<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<div class="repeattable" style="width: 98%;margin-left: 2px;">
	<table class="layui-table x-admin-sm-table-list-small" >
		<colgroup>
			<col style="min-width:100px;width: 20%;"/>
	        <col style="min-width:100px;width: 20%;"/>
			<col style="min-width:100px;width: 20%;"/>
	        <col style="min-width:100px;width: 20%;"/>
	        <col style="min-width:100px;width: 20%;"/>
		</colgroup>
		<thead>
			<tr>
                <th>药品价格</th>
				<th>药品单价</th>
				<th>开始时间</th>
                <th>结束时间</th>
                <th>版本</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="mhmDrugPrice" items="${mhmDrugPrices}" varStatus="status">
				<tr>
                    <td><tags:numberLabel value="${mhmDrugPrice.price}"/></td>
                    <td><tags:numberLabel value="${mhmDrugPrice.unitPrice}"/></td>
                    <td><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${mhmDrugPrice.startDt}"/></ehr:tip></td>
                    <td><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${mhmDrugPrice.endDt}"/></ehr:tip></td>
                    <td><ehr:tip>${mhmDrugPrice.version}</ehr:tip></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="drugPrice.search" />
		</tr>
	</table>
</div>
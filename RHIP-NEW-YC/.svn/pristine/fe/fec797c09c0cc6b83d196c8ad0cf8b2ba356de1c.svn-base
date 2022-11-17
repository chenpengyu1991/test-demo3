<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<table class="layui-table x-admin-sm-table-list-middle">
	<colgroup>
		<col style="min-width:80px;width: 10%;"/>
		<col style="min-width:120px;width: 15%;"/>
		<col style="min-width:80px;width: 10%;"/>
		<col style="min-width:120px;width: 15%;"/>
		<col style="min-width:80px;width: 10%;"/>
		<col style="min-width:80px;width: 10%;"/>
		<col style="min-width:80px;width: 10%;"/>
	</colgroup>
	<thead>
		<tr>
			<th>医疗机构</th>
			<th>入库单号</th>
			<th>入库药房类型</th>
			<th>入库药房</th>
			<!-- <th>入库科室</th>
			<th>入库方式</th> -->
			<th>入库日期</th>
			<th>备注</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="pharmacyIn" items="${pharmacyIns}" varStatus="status">
			<tr>
				<td><ehr:tip><ehr:org  code="${pharmacyIn.ORGAN_CODE}"/></ehr:tip></td>
				<td><ehr:tip>${pharmacyIn.BATCH_NO}</ehr:tip></td>
				<td><ehr:tip><ehr:dic dicmeta="DA00009" code="${pharmacyIn.PHARMACY_TYPE_CODE}"/></ehr:tip></td>
				<td><ehr:tip>${pharmacyIn.PHARMACY_NAME}</ehr:tip></td>
			   <%--  <td><ehr:tip>${pharmacyIn.DEPARTMENT_NAME}</ehr:tip></td>
				<td><ehr:tip><ehr:dic dicmeta="DA00008" code="${pharmacyIn.STORAGE_TYPE_CODE}"/></ehr:tip></td> --%>
				<td><ehr:tip><fmt:formatDate value="${pharmacyIn.PHARMACY_DT}" pattern="yyyy/MM/dd" /></ehr:tip></td>
				<td><ehr:tip>${pharmacyIn.COMMENTS}</ehr:tip></td>
				<td>
					<a title="查看详细信息" class="layui-btn layui-btn-normal layui-btn-xs" href="javascript:void(0)" style="color: #FFF;font-size: 12px;"
					   onclick="pharmacyInSearch.detailSearch('${pharmacyIn.BATCH_NO}')">
						<i class="layui-icon">&#xe615;</i>查看</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<table>
	<tr>
		<ehr:pagination action="pharmacyInSearch.search" />
	</tr>
</table>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<table class="layui-table x-admin-sm-table-list-middle">
	<colgroup>
		<col style="min-width:100px;width: 10%;"/>
		<col style="min-width:80px;width: 8%;"/>
		<col style="min-width:80px;width: 8%;"/>
		<col style="min-width:80px;width: 8%;"/>
		<col style="min-width:80px;width: 8%;"/>
		<col style="min-width:80px;width: 8%;"/>
		<col style="min-width:100px;width: 10%;"/>
		<col style="min-width:100px;width: 10%;"/>
		<col style="min-width:100px;width: 10%;"/>
	</colgroup>
	<thead>
		<tr>
			<th>医疗机构</th>
			<th title="出库/调拨/发票">单据号</th>
			<th>出库类型</th>
			<th>病人姓名</th>
			<th>门诊号</th>
			<th>住院号</th>
			<th>出库日期</th>
			<th>备注</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="pharmacyOut" items="${pharmacyOuts}" varStatus="status">
			<tr>
				<td><ehr:tip><ehr:org  code="${pharmacyOut.ORGAN_CODE}"/></ehr:tip></td>
				<td>
					<c:choose>
						<c:when test='${pharmacyOut.DELIVERY_TYPE_CODE == "1"}'><ehr:tip>${pharmacyOut.TRANSFER_SLIP}</ehr:tip></c:when>
						<c:when test='${pharmacyOut.DELIVERY_TYPE_CODE == "3"}'><ehr:tip>${pharmacyOut.INVOICE_NO}</ehr:tip></c:when>
						<c:otherwise><ehr:tip>${pharmacyOut.BATCH_NO}</ehr:tip></c:otherwise>
					</c:choose>
				</td>
				<td><ehr:tip><ehr:dic dicmeta="DA00010" code="${pharmacyOut.DELIVERY_TYPE_CODE}"/></ehr:tip></td>
				<%-- <td><ehr:tip>${pharmacyOut.IN_DEPARTMENT_NAME}</ehr:tip></td>
				<td><ehr:tip>${pharmacyOut.OUT_DEPARTMENT_NAME}</ehr:tip></td>  --%>
				<td><ehr:tip>${pharmacyOut.PATIENT_NAME}</ehr:tip></td>
				<td>
					<c:if test='${pharmacyOut.PATIENT_TYPE == "0" || pharmacyOut.PATIENT_TYPE =="1"}'>
						<ehr:tip>${pharmacyOut.PATIENT_MZH}</ehr:tip>
					</c:if>
				</td>
				<td>
					<c:if test='${pharmacyOut.PATIENT_TYPE == "2"}'>
						<ehr:tip>${pharmacyOut.PATIENT_MZH}</ehr:tip>
					</c:if>
				</td>
				<td><ehr:tip><fmt:formatDate value="${pharmacyOut.DELIVERY_DT}" pattern="yyyy/MM/dd" /></ehr:tip></td>
				<td><ehr:tip>${pharmacyOut.COMMENTS}</ehr:tip></td>
				<td>
					<a title="查看详细信息" class="layui-btn layui-btn-normal layui-btn-xs" href="javascript:void(0)" style="color: #FFF;font-size: 12px;"
					   onclick="pharmacyOutSearch.detailSearch('${pharmacyOut.BATCH_NO}')">
						<i class="layui-icon">&#xe615;</i>查看</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<table>
	<tr>
		<ehr:pagination action="pharmacyOutSearch.search" />
	</tr>
</table>

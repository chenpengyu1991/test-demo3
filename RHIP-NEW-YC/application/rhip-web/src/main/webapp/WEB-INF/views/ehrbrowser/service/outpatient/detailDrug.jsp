<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="table-01 ">
	<div align="right">
		<fmt:formatDate value="${outpatientReportDTO.clinicDate}" pattern="yyyy/MM/dd" />
	</div>
	<br />
	<ins>
		<h3 align="center">
			<c:out value="${outpatientReportDTO.clinicOrganName }"></c:out>
			处方单
		</h3>
	</ins>
	<br />
	<table class="formtable">
		<tr>
			<th width="16%">姓名：</th>
			<td width="16%"><c:out value="${outpatientReportDTO.clinicPeopleName }"></c:out></td>
			<th width="16%">性别：</th>
			<td width="16%"><ehr:dic dicmeta="GBT226112003" code="${outpatientReportDTO.gender}" /></td>
			<th width="18%">年龄：</th>
			<td width="18%"><c:out value="${outpatientReportDTO.age }"></c:out></td>
		</tr>
		<tr>
			<th>医生科室：</th>
			<td><c:out value="${outpatientReportDTO.medicalRoomName }"></c:out></td>
			<th>医生：</th>
			<td><c:out value="${outpatientReportDTO.prescribeDoctorName }"></c:out></td>
			<th>处方号：</th>
			<td><c:out value="${outpatientReportDTO.recordNumber }"></c:out></td>
		</tr>
	</table>
	<br />
	<div style="height: 210px;overflow: auto;" class="repeattable">
		<table>
			<thead>
				<tr>
					<th>药品名称</th>
					<th>规格</th>
					<th>单位</th>
					<th>数量</th>
					<th>单价</th>
					<th>小计</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${outpatientReportDTO.drugUsageList}" var="drugUsage">
					<tr>
						<td><tags:textWithTip value="${drugUsage.drugGenericName }"></tags:textWithTip></td>
						<td><c:out value="${drugUsage.drugSpecifications }"></c:out></td>
                        <td><c:out value="${drugUsage.quantityUnit }"></c:out></td>
                        <td><c:out value="${drugUsage.quantity }"></c:out></td>
                        <td><c:out value="${drugUsage.unitPrice }"></c:out></td>
                        <td><fmt:formatNumber value="${drugUsage.subtotal }" type="currency" pattern="￥0.00"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<hr/>
	<div align="right">
		总计：<fmt:formatNumber value="${outpatientReportDTO.totalPrice}" type="currency"/>
	</div>
</div>

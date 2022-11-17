<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<div class="repeattable">
	<table>
		<colgroup>
			<col style="min-width:150px;width: 20%;"/>
			<col style="min-width:100px;width: 10%;"/>
	        <col style="min-width:100px;width: 10%;"/>
			<col style="min-width:100px;width: 10%;"/>
	        <col style="min-width:150px;width: 15%;"/>
			<col style="min-width:100px;width: 10%;"/>
			<col style="min-width:150px;width: 15%;"/>
			<col style="min-width:100px;width: 10%;"/>
		</colgroup>
		<thead>
			<tr>
				<th>医疗机构</th>
				<th>姓名</th>
				<th>身份证号</th>
				<th>门诊号</th>
				<th>处方总费用</th>
				<th>医师姓名</th>
				<th>开具时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="prescription" items="${prescriptionList}" varStatus="status">
				<tr>
					<td class="centertd"><ehr:tip><ehr:org code="${prescription.hospitalCode}"/></ehr:tip></td>
					<td class="centertd"><ehr:tip>${prescription.name}</ehr:tip></td>
					<td class="centertd"><ehr:tip>${prescription.idcard}</ehr:tip></td>
					<td class="centertd"><ehr:tip>${prescription.outpatientNo}</ehr:tip></td>
					<td class="centertd"><tags:numberLabel value="${prescription.prescriptionTotalCost}"  fractionDigits="2" defaultValue="0" /></td>
					<td class="centertd"><ehr:tip>${prescription.prescribeDoctorName}</ehr:tip></td>
					<td class="centertd"><ehr:tip><fmt:formatDate value="${prescription.prescribeDate}" pattern="yyyy/MM/dd HH:mm:ss" /></ehr:tip></td>
					<td class="centertd">
						<a href="javascript:void(0)" onclick="prescriptionSearch.prescriptionDetail('${prescription.ehrId}','${prescription.personId}','${prescription.recordNumber}')">查看</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<tr>
			<ehr:pagination action="prescriptionSearch.search"/>
		</tr>
	</table>
</div>
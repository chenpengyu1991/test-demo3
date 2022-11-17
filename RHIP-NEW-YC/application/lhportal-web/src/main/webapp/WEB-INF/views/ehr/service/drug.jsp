<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="rightnav">
	<table>
		<tr>
      		<td class="crumbs"><div id="location" parentMenu="medical-activties" childMenu="drug">当前位置:&gt;&gt;医疗活动&gt;&gt;用药信息</div>
			</td>
	  	</tr>
	</table>		
	<div class="table-basic">
		<table>
			<thead>
				<tr>
					<th>日期</th>
					<th>药名</th>
					<th>规格</th>
					<th>数量</th>
					<th>单位</th>
					<th>机构</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${drugUsages}" var="drugUsage">
					<tr>
						<td><fmt:formatDate value="${drugUsage.startDate}" pattern="yyyy/MM/dd" /></td>
						<c:if test="${empty drugUsage.drugTradeName}">
							<td><tags:textWithTip value="${drugUsage.drugGenericName}"></tags:textWithTip></td>
						</c:if>
						<c:if test="${not empty drugUsage.drugTradeName}">
							<td><tags:textWithTip value="${drugUsage.drugGenericName}(${drugUsage.drugTradeName})"></tags:textWithTip></td>
						</c:if>
						<td><c:out value="${drugUsage.drugSpecifications}"></c:out></td>
						<td><c:out value="${drugUsage.quantity}"></c:out></td>
						<td><c:out value="${drugUsage.quantityUnit}"></c:out></td>
						<td><tags:textWithTip value="${drugUsage.referralHospitalName}"></tags:textWithTip></td>
					</tr>
				</c:forEach>
		</tbody>
	</table>
	</div>
</div>
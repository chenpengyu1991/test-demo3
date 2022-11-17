<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="rightnav">
	<table>
		<tr>
      		<td class="crumbs"><div id="location" parentMenu="medical-activties" childMenu="result">当前位置:&gt;&gt;医疗活动&gt;&gt;医疗保健活动</div>
			</td>
	  	</tr>
	</table>
	<div class="table-basic">
		<table border="1">
			<thead>
				<tr>
					<th>日期</th>
					<th>机构</th>
					<th>类型</th>
					<th>科室</th>
					<th>用药</th>
					<th>检验</th>
					<th>检查</th>
					<th>电子病历</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${healthEventItems}" var="item">
					<tr>
						<td><fmt:formatDate value="${item.ehrHealthEvent.clinicDate}" pattern="yyyy/MM/dd" /></td>
						<td><tags:textWithTip  value="${item.ehrHealthEvent.clinicOrganName}"></tags:textWithTip></td>
						<td>
						<c:if test="${item.ehrHealthEvent.ehrType=='2'}"><!-- 住院 -->
						住院
						</c:if>
						<c:if test="${item.ehrHealthEvent.ehrType=='1'}"><!-- 门诊 -->
						门诊
						</c:if>
						<c:if test="${item.ehrHealthEvent.ehrType=='3'}"><!-- 体检 -->
						体检
						</c:if>
						</td>
						<td><tags:textWithTip value="${item.ehrHealthEvent.clinicRoomName}"></tags:textWithTip></td>
						<td><c:if test="${item.hasDrug}">√</c:if> </td>
						<td><c:if test="${item.hasExam}">√</c:if> </td>
						<td><c:if test="${item.hasStudy}">√</c:if> </td>
						<td><c:if test="${item.hasElecMedicalRecord}">√</c:if> </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
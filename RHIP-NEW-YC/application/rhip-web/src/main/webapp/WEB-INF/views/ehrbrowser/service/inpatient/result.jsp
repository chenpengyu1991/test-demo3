<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

		<table border="1" class="repeattable">
			<thead>
				<tr>
					<th>时间</th>
					<th>机构</th>
					<th>科室</th>
					<th>用药</th>
					<th>检验</th>
					<th>检查</th>
					<th>电子病历</th>
					<th>查看临床图表</th>
				</tr>
			</thead>
			

			
			<tbody>
				<c:forEach items="${inpatientItems}" var="inpatientItem">
					<tr>
						<td><fmt:formatDate value="${inpatientItem.inpatientInfo.inhosDate}" pattern="yyyy/MM/dd HH:mm:ss" /></td>
						<td><c:out value="${inpatientItem.inpatientInfo.referralHospitalName}"></c:out></td>
						<td><c:out value="${inpatientItem.inpatientInfo.referralDeptName}"></c:out></td>
						<td><c:out value="${inpatientItem.hasDrug}"></c:out></td>
						<td><c:out value="${inpatientItem.hasExam}"></c:out></td>
						<td><c:out value="${inpatientItem.hasStudy}"></c:out></td>
						<td><c:out value="${inpatientItem.hasElecMedicalRecord}"></c:out></td>
						<td><a  class="chart-link-btn" href="<c:url value="/inpatient/chart/${examineDetail.id}"  />">查看</a></td>
					</tr>
				</c:forEach>
					<tr  >
						<ehr:pagination colspan="8"  action="inpatientSearch.search"  />
					</tr>
			</tbody>
		</table>


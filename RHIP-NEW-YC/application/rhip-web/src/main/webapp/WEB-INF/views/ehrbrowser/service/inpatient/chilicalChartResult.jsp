<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<div class="repeattable" style="width: 99%;">
	<table class="layui-table x-admin-sm-table-list-small" >
		<thead>
			<tr>
				<th>项目/日期</th>
				<c:forEach items="${clinicalChartData.weeks}" var="item">
					<th><c:out value="${item}"></c:out></th>
				</c:forEach>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>医嘱</td>
				<c:forEach  items="${clinicalChartData.weeks}" var="item">
					<td><c:forEach items="${clinicalChartData.drugUsagesMap[item]}" var="drug">
                        <ehr:tip trim="true">
                             ${drug.value.drugGenericName}&lt;${drug.value.drugSpecifications}&gt;
                            ${drug.value.quantity} ${drug.value.quantityUnit}
                        </ehr:tip><br />
						</c:forEach>
					</td>
				</c:forEach>
			</tr>
			<tr>
				<td>检查</td>
				<c:forEach  items="${clinicalChartData.weeks}" var="item">
					<td><c:forEach items="${clinicalChartData.studyMap[item]}" var="study">
							<a class="study_report_btn" href="<c:url value="/study/report/${study.id}" />"><tags:textWithTip linkStyle="true" value="${study.title}"></tags:textWithTip> </a><br />
						</c:forEach>
					</td>
				</c:forEach>
			</tr>
			<tr>
				<td>检验</td>
				<c:forEach  items="${clinicalChartData.weeks}" var="item">
					<td><c:forEach items="${clinicalChartData.examMap[item]}" var="exam">
							<a class="exam_report_btn"  href="<c:url value="/exam/report/${exam.id}" />"><tags:textWithTip linkStyle="true" value="${exam.title}"></tags:textWithTip> </a><br />
						</c:forEach>
					</td>
				</c:forEach>
			</tr>
			<tr >
				<td> 病历</td>
					<td>
						<c:if test="${not empty clinicalChartData.inpatientMedicalRecord}">
							<a class="chilical_chart_index_a"  href="<c:url value="/inpatient/cindex/${clinicalChartData.inpatientMedicalRecord}" />">病案首页 </a>
						</c:if>
						<c:if test="${fn:length(clinicalChartData.weeks)==1 }">
							<c:if test="${not empty clinicalChartData.outhospitalSummary}">
								<a class="chilical_chart_summary_a"  href="<c:url value="/inpatient/detail/${clinicalChartData.outhospitalSummary}" />">出院小结 </a>
							</c:if>
						</c:if>
					</td>
		
					<c:if test="${fn:length(clinicalChartData.weeks)>1}">
						
						<c:forEach begin="2" end="${fn:length(clinicalChartData.weeks)-1}"   items="${clinicalChartData.weeks}" var="item">
							<td>
								
							</td>
						</c:forEach>
						
						<td>
							<c:if test="${not empty clinicalChartData.outhospitalSummary}">
									<a class="chilical_chart_summary_a"  href="<c:url value="/inpatient/detail/${clinicalChartData.outhospitalSummary}" />">出院小结 </a>
							</c:if>
						</td>
					</c:if>	
			</tr>
			
			<tr>
				<td>费用</td>
				<c:forEach  items="${clinicalChartData.weeks}" var="item">
					<td><c:forEach items="${clinicalChartData.expenseMap[item]}" var="expense">
							<tags:textWithTip linkStyle="true" value="${expense}"></tags:textWithTip><br />
						</c:forEach>
					</td>
				</c:forEach>
			</tr>
			
	<!-- 		<tr> -->
	<!-- 			<td>其它</td> -->
	<%-- 			<c:forEach  items="${clinicalChartData.weeks}" var="item"> --%>
	<!-- 				<td> -->
	<!-- 				</td> -->
	<%-- 			</c:forEach> --%>
	<!-- 		</tr> -->
		</tbody>
	</table>
</div>

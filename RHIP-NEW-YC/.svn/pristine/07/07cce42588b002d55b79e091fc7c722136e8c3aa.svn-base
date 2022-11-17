<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script
	src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/service/outpatient/main.js"
	type="text/javascript"></script>

<div class="report_box" id="drugReport" style="margin-left: 3px;">
	<h1 align="center">
		<span class="line_with_border" style="font-size: 2em;font-weight: bold;"><c:out
				value="${outpatientReportDTO.clinicOrganName}"></c:out>门诊处方</span>
	</h1>

	<table class="layout_table">

		<tr>
			<td colspan="3">（医保、合作医疗、自费）</td>
			<td colspan="5" align="right"><fmt:formatDate
					value="${outpatientReportDTO.clinicDate}" pattern="yyyy/MM/dd " /></td>
		</tr>
		<tr>
			<td>门诊号:</td>
			<td class="line_with_border"><c:out
					value="${outpatientReportDTO.outpatientNo}"></c:out></td>
			<td>初步诊断:</td>
			<td class="line_with_border" colspan="5"><c:out
					value="${outpatientReportDTO.diagnosisDesc}"></c:out><br /></td>
			<td valign="middle" rowspan="4" style="width: 20px;"><span>处方仅当日有效</span></td>
		</tr>
		<tr>
			<td style="width: 8%">姓名:</td>
			<td class="line_with_border" style="width: 12%"><c:out
					value="${outpatientReportDTO.clinicPeopleName }"></c:out></td>
			<td style="width: 10%">性别:</td>
			<td class="line_with_border" style="width: 4%"><ehr:dic
					dicmeta="GBT226112003" code="${outpatientReportDTO.gender}" /></td>
			<td style="width:10%">年龄:</td>
			<td class="line_with_border" style="width: 6%"><c:out
					value="${outpatientReportDTO.age}"></c:out></td>
			<td class="" style="width: 8%">地址:</td>
			<td class="line_with_border">
                <ehr:dic dicmeta="FS990001" code="${outpatientReportDTO.patownShip}"></ehr:dic>
                <ehr:dic dicmeta="FS990001" code="${outpatientReportDTO.pastreet}"></ehr:dic>
                ${outpatientReportDTO.pahouseNumber } </td>
		</tr>
		<tr>
			<td colspan="8">
				<div class="drug_report_box">
					<div style="float:left;">
						<img  src="${pageContext.request.contextPath}/images/R.png" style="width:28px;height:30px;"/>
					</div>
					<div style="margin-left: 20px!important;margin-top:10px!important;float:left;">
					<c:forEach items="${outpatientReportDTO.drugUsageList}"
						var="outpatientReport">
						<c:out value="${outpatientReport.drugGenericName }"></c:out>
						&lt;<c:out value="${outpatientReport.drugSpecifications }"></c:out>&gt; X
                        <c:out value="${outpatientReport.quantity }"></c:out>
                        <c:out value="${outpatientReport.quantityUnit }"></c:out>
						<div style="margin-left: 20px">
								Sig:
								<c:if test="${not empty outpatientReport.drugUseDose}">
									每次用量:
									<c:out value="${outpatientReport.drugUseDose }"></c:out>
									<c:out value="${outpatientReport.drugUseDoseUnit }"></c:out>
								</c:if>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<c:if test="${not empty outpatientReport.drugUseFrequency}">
									<c:out value="${outpatientReport.drugUseFrequency }"></c:out>
									<c:if test="${not empty outpatientReport.drugUseDays}">X</c:if>
								</c:if>
								<c:out value="${outpatientReport.drugUseDays }"></c:out>
								<c:if test="${not empty outpatientReport.drugUseDays}">
									天
								</c:if>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<ehr:dic dicmeta="CV0600102" code="${outpatientReport.drugUseRouteCode }"/>
							</div>
					</c:forEach>
					</div>
					<div align="center"  style="clear:both;">---------------以下为空---------------</div>
				</div>
			</td>
		</tr>
		<tr>
			<td colspan="6"  >医生签名：<c:out value="${outpatientReportDTO.prescribeDoctorName }"></c:out></td>
			<td colspan="2" align="right"><a id="outpatient_report_btn"  href="<c:url value="/outpatient/detailReport" />">门诊摘要</a></td>
		</tr>

	</table>
	<input type="hidden" id="ehrId" value="${outpatientReportDTO.ehrId}" />
	<input type="hidden" id="personId" value="${outpatientReportDTO.personId}" />
</div>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/healthEvent/datagrid.js" type="text/javascript"></script>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div class="repeattable" id="healthEventResultDiv">
		<table class="layui-table x-admin-sm-table-list-small">
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
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${healthEventItems}" var="item">
					<tr>
						<td><fmt:formatDate value="${item.ehrHealthEvent.clinicDate}" pattern="yyyy/MM/dd" /></td>
						<td><ehr:tip>${item.ehrHealthEvent.clinicOrganName}</ehr:tip>
							<c:choose>
								<c:when test="${item.ehrHealthEvent.clinicOrganName != null}">${item.ehrHealthEvent.clinicOrganName}</c:when>
								<c:when test="${item.ehrHealthEvent.clinicOrganCode != null}"><ehr:tip><ehr:org code="${item.ehrHealthEvent.clinicOrganCode}"/></ehr:tip></c:when>
								<c:when test="${item.ehrHealthEvent.createOrganName != null}">${item.ehrHealthEvent.createOrganName}</c:when>
								<c:otherwise><ehr:tip><ehr:org code="${item.ehrHealthEvent.createOrganCode}"/> </ehr:tip></c:otherwise>
							</c:choose>
						</td>
						<td>
							<c:choose>
								<c:when test="${item.ehrHealthEvent.ehrType=='1'}">门诊</c:when>
								<c:when test="${item.ehrHealthEvent.ehrType=='2'}">住院</c:when>
								<c:otherwise>
									<ehr:dic code="${item.ehrHealthEvent.ehrType}" dicmeta="PH00021"/>
								</c:otherwise>
							</c:choose>
						</td>
						<td><tags:textWithTip value="${item.ehrHealthEvent.clinicRoomName}"></tags:textWithTip></td>
						<td><c:if test="${item.hasDrug}">√</c:if> </td>
						<td><c:if test="${item.hasExam}">√</c:if> </td>
						<td><c:if test="${item.hasStudy}">√</c:if> </td>
						<td><c:if test="${item.hasElecMedicalRecord}">√</c:if> </td>
						<td class="centertd">
							<c:choose>
								<c:when test="${item.ehrHealthEvent.ehrType=='1'}">
									<%--<a title="处方" class="serviceIndex_openDatail_btn drug_report_btn" href="<c:url value="/outpatient/drugReport/${item.ehrHealthEvent.id}"/>">处方</a>--%>
									<a title="门诊摘要" style="color: #FFF;font-size: 12px;"class="serviceIndex_openDatail_btn drug_report_btn layui-btn layui-btn-xs" href="<c:url value="/outpatient/detailReport/${item.ehrHealthEvent.personId}/${item.ehrHealthEvent.ehrId}"/>"><i class="layui-icon">&#xe615;</i>查看</a>
								</c:when>
								<c:when test="${item.ehrHealthEvent.ehrType=='2'}">
									<a title="临床图表"  style="color: #FFF;font-size: 12px;"class="serviceIndex_openDatail_btn inhos_chart_btn layui-btn layui-btn-xs" href="<c:url value="/inpatient/chart/${item.ehrHealthEvent.id}"/>"><i class="layui-icon">&#xe615;</i>查看</a>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${item.ehrHealthEvent.ehrType=='33'}">
											<a title="学生体检" style="color: #FFF;font-size: 12px;"class="serviceIndex_openDatail_btn student_exam_btn layui-btn layui-btn-xs" href="<c:url value="/hm/studentExam/viewStudentExam/${item.ehrHealthEvent.personId}/${item.ehrHealthEvent.ehrId}"/>"><i class="layui-icon">&#xe615;</i>查看</a>
										</c:when>
										<c:when test="${item.ehrHealthEvent.ehrType=='39'}">
											<a title="慢病体检" style="color: #FFF;font-size: 12px;"class="serviceIndex_openDatail_btn cd_exam_btn layui-btn layui-btn-xs" href="<c:url value="/cdm/standardization/phyExamination/externalView/${item.ehrHealthEvent.personId}/${item.ehrHealthEvent.ehrId}"/>"><i class="layui-icon">&#xe615;</i>查看</a>
										</c:when>
										<c:when test="${item.ehrHealthEvent.ehrType=='31'}">
											<c:if test="${!item.hasPhysicalExamRecord}">暂无报告</c:if>
											<c:if test="${item.hasPhysicalExamRecord}">
												<a title="老年人体检" style="color: #FFF;font-size: 12px;"class="hm_exam_btn layui-btn layui-btn-xs" href="javascript:void(0);" data-person-id="${item.ehrHealthEvent.personId}" data-physicalexamcode="${item.examNumber}"><i class="layui-icon">&#xe615;</i>查看</a>
											</c:if>
										</c:when>										
										<c:otherwise>
											<a title="体检报告" style="color: #FFF;font-size: 12px;"class="serviceIndex_openDatail_btn other_exam_btn layui-btn layui-btn-xs" href="<c:url value="/physicalExam/index/${item.ehrHealthEvent.personId}/${item.ehrHealthEvent.ehrId}"/>"><i class="layui-icon">&#xe615;</i>查看</a>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
            </tbody>
        </table>
    </div>

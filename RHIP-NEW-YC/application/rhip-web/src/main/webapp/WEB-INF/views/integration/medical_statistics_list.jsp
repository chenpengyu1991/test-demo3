<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>


<div class="repeattable">
    <div id="medicalDataTopDiv">
    <table id="medicalDataTable11">
    	<colgroup>
			<col style="width:15%;"/>
	        <col style="width:15%;"/>
	        <col style="width:10%;"/>
			<col style="width:10%;"/>
			<col style="width:10%;"/>
			<col style="width:10%;"/>
			<col style="width:10%;"/>
			<col style="width:10%;"/>
			<col style="width:10%;"/>
		</colgroup>	
		<thead>
			<tr>
				<th>医院名称</th>
				<th>项目名称</th>
				<c:forEach items="${dateList}" var="d">
					<th><fmt:formatDate value="${d}" pattern="MM月dd日"/></th>
				</c:forEach>
			</tr>
		</thead>
    </table>

    <div id="medicalDataDiv" class="contentfixed126">
        <table id="medicalDataTable">
            <colgroup>
                <col style="width:15%;"/>
                <col style="width:15%;"/>
                <col style="width:10%;"/>
                <col style="width:10%;"/>
                <col style="width:10%;"/>
                <col style="width:10%;"/>
                <col style="width:10%;"/>
                <col style="width:10%;"/>
                <col style="width:10%;"/>
            </colgroup>
            <tbody>
            <c:forEach items="${medicalDataList}" var="medicalDataDate">
                <c:if test="${fn:contains(projectNameList, 'h01')}">
                    <tr>
                        <c:if test="${fn:contains(projectNameList, 'h01')}">
                        <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${medicalDataDate.organization.organName}"></tags:textWithTip></td>
                        </c:if>
                        <td style="text-align: left">门诊记录</td>
                        <c:forEach items="${medicalDataDate.medicalDatas}" var="m">
                            <td style="text-align: left" >${m.actualOutpatientCount}</td>
                        </c:forEach>
                    </tr>
                </c:if>
                <c:if test="${fn:contains(projectNameList, 'h06')}">
                <tr>
                    <c:if test="${!fn:contains(projectNameList, 'h01')}">
                        <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${medicalDataDate.organization.organName}"></tags:textWithTip></td>
                    </c:if>
                    <td style="text-align: left">住院记录</td>
                    <c:forEach items="${medicalDataDate.medicalDatas}" var="m">
                        <td style="text-align: left" >${m.actualInpatientCount}</td>
                    </c:forEach>
                </tr>
                </c:if>
                <c:if test="${fn:contains(projectNameList, 'h02')}">
                <tr>
                    <c:if test="${!fn:contains(projectNameList, 'h01') && !fn:contains(projectNameList, 'h06')}">
                        <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${medicalDataDate.organization.organName}"></tags:textWithTip></td>
                    </c:if>

                    <td style="text-align: left">诊断记录</td>
                    <c:forEach items="${medicalDataDate.medicalDatas}" var="m">
                        <td style="text-align: left" >${m.actualDiseaseDiagnosisCount}</td>
                    </c:forEach>
                </tr>
                </c:if>
                <c:if test="${fn:contains(projectNameList, 'h03')}">
                <tr>
                    <c:if test="${!fn:contains(projectNameList, 'h01') && !fn:contains(projectNameList, 'h06') && !fn:contains(projectNameList, 'h02')}">
                        <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${medicalDataDate.organization.organName}"></tags:textWithTip></td>
                    </c:if>
                    <td style="text-align: left">门诊处方</td>
                    <c:forEach items="${medicalDataDate.medicalDatas}" var="m">
                        <td style="text-align: left" >${m.actualOutpatientPrescriptionCount}</td>
                    </c:forEach>
                </tr>
                </c:if>
                <c:if test="${fn:contains(projectNameList, 'h04')}">
                <tr>
                    <c:if test="${!fn:contains(projectNameList, 'h01') && !fn:contains(projectNameList, 'h06')
                        && !fn:contains(projectNameList, 'h02') && !fn:contains(projectNameList, 'h03')}">
                        <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${medicalDataDate.organization.organName}"></tags:textWithTip></td>
                    </c:if>
                    <td style="text-align: left">医嘱用药</td>
                    <c:forEach items="${medicalDataDate.medicalDatas}" var="m">
                        <td style="text-align: left" >${m.actualDrugCount}</td>
                    </c:forEach>
                </tr>
                </c:if>
                <c:if test="${fn:contains(projectNameList, 'h07')}">
                <tr>
                    <c:if test="${!fn:contains(projectNameList, 'h01') && !fn:contains(projectNameList, 'h06')
                        && !fn:contains(projectNameList, 'h02') && !fn:contains(projectNameList, 'h03') && !fn:contains(projectNameList, 'h04')}">
                        <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${medicalDataDate.organization.organName}"></tags:textWithTip></td>
                    </c:if>
                    <td style="text-align: left">手术记录</td>
                    <c:forEach items="${medicalDataDate.medicalDatas}" var="m">
                        <td style="text-align: left" >${m.actualSurgeryCount}</td>
                    </c:forEach>
                </tr>
                </c:if>
                <c:if test="${fn:contains(projectNameList, 'h08')}">
                <tr>
                    <c:if test="${!fn:contains(projectNameList, 'h01') && !fn:contains(projectNameList, 'h06')
                        && !fn:contains(projectNameList, 'h02') && !fn:contains(projectNameList, 'h03')
                        && !fn:contains(projectNameList, 'h04')&& !fn:contains(projectNameList, 'h07')}">
                        <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${medicalDataDate.organization.organName}"></tags:textWithTip></td>
                    </c:if>
                    <td style="text-align: left">输血记录</td>
                    <c:forEach items="${medicalDataDate.medicalDatas}" var="m">
                        <td style="text-align: left" >${m.actualTransBloodCount}</td>
                    </c:forEach>
                </tr>
                </c:if>
                <c:if test="${fn:contains(projectNameList, 'h09')}">
                <tr>
                    <c:if test="${!fn:contains(projectNameList, 'h01') && !fn:contains(projectNameList, 'h06')
                        && !fn:contains(projectNameList, 'h02') && !fn:contains(projectNameList, 'h03')
                        && !fn:contains(projectNameList, 'h04')&& !fn:contains(projectNameList, 'h07')&& !fn:contains(projectNameList, 'h08')}">
                        <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${medicalDataDate.organization.organName}"></tags:textWithTip></td>
                    </c:if>
                    <td style="text-align: left">检验</td>
                    <c:forEach items="${medicalDataDate.medicalDatas}" var="m">
                        <td style="text-align: left" >${m.actualExamineEventCount}</td>
                    </c:forEach>
                </tr>
                </c:if>
                <c:if test="${fn:contains(projectNameList, 'h10')}">
                <tr>
                    <c:if test="${!fn:contains(projectNameList, 'h01') && !fn:contains(projectNameList, 'h06')
                        && !fn:contains(projectNameList, 'h02') && !fn:contains(projectNameList, 'h03')
                        && !fn:contains(projectNameList, 'h04') && !fn:contains(projectNameList, 'h07')
                        && !fn:contains(projectNameList, 'h08') && !fn:contains(projectNameList, 'h09')}">
                        <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${medicalDataDate.organization.organName}"></tags:textWithTip></td>
                    </c:if>
                    <td style="text-align: left">体检</td>
                    <c:forEach items="${medicalDataDate.medicalDatas}" var="m">
                        <td style="text-align: left" >${m.actualHealthExaminationCount}</td>
                    </c:forEach>
                </tr>
                </c:if>
                <c:if test="${fn:contains(projectNameList, 'h11')}">
                <tr>
                    <c:if test="${!fn:contains(projectNameList, 'h01') && !fn:contains(projectNameList, 'h06')
                        && !fn:contains(projectNameList, 'h02') && !fn:contains(projectNameList, 'h03')
                        && !fn:contains(projectNameList, 'h04') && !fn:contains(projectNameList, 'h07')
                        && !fn:contains(projectNameList, 'h08') && !fn:contains(projectNameList, 'h09')
                         && !fn:contains(projectNameList, 'h10')}">
                        <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${medicalDataDate.organization.organName}"></tags:textWithTip></td>
                    </c:if>
                    <td style="text-align: left">出院小结</td>
                    <c:forEach items="${medicalDataDate.medicalDatas}" var="m">
                        <td style="text-align: left" >${m.actualOuthospitalSummaryCount}</td>
                    </c:forEach>
                </tr>
                </c:if>
                <c:if test="${fn:contains(projectNameList, 'h12')}">
                <tr>
                    <c:if test="${!fn:contains(projectNameList, 'h01') && !fn:contains(projectNameList, 'h06')
                        && !fn:contains(projectNameList, 'h02') && !fn:contains(projectNameList, 'h03')
                        && !fn:contains(projectNameList, 'h04') && !fn:contains(projectNameList, 'h07')
                        && !fn:contains(projectNameList, 'h08') && !fn:contains(projectNameList, 'h09')
                        && !fn:contains(projectNameList, 'h10') && !fn:contains(projectNameList, 'h11')}">
                        <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${medicalDataDate.organization.organName}"></tags:textWithTip></td>
                    </c:if>
                    <td style="text-align: left">病案首页</td>
                    <c:forEach items="${medicalDataDate.medicalDatas}" var="m">
                        <td style="text-align: left" >${m.actualInpatientMedicalRecordCount}</td>
                    </c:forEach>
                </tr>
                </c:if>
                <c:if test="${fn:contains(projectNameList, 'h13')}">
                <tr>
                    <c:if test="${!fn:contains(projectNameList, 'h01') && !fn:contains(projectNameList, 'h06')
                        && !fn:contains(projectNameList, 'h02') && !fn:contains(projectNameList, 'h03')
                        && !fn:contains(projectNameList, 'h04') && !fn:contains(projectNameList, 'h07')
                        && !fn:contains(projectNameList, 'h08') && !fn:contains(projectNameList, 'h09')
                        && !fn:contains(projectNameList, 'h10') && !fn:contains(projectNameList, 'h11')
                        && !fn:contains(projectNameList, 'h12')}">
                        <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${medicalDataDate.organization.organName}"></tags:textWithTip></td>
                    </c:if>
                    <td style="text-align: left">转诊</td>
                    <c:forEach items="${medicalDataDate.medicalDatas}" var="m">
                        <td style="text-align: left" >${m.actualReferralCount}</td>
                    </c:forEach>
                </tr>
                </c:if>
                <c:if test="${fn:contains(projectNameList, 'h14')}">
                <tr>
                    <c:if test="${!fn:contains(projectNameList, 'h01') && !fn:contains(projectNameList, 'h06')
                        && !fn:contains(projectNameList, 'h02') && !fn:contains(projectNameList, 'h03')
                        && !fn:contains(projectNameList, 'h04') && !fn:contains(projectNameList, 'h07')
                        && !fn:contains(projectNameList, 'h08') && !fn:contains(projectNameList, 'h09')
                        && !fn:contains(projectNameList, 'h10') && !fn:contains(projectNameList, 'h11')
                        && !fn:contains(projectNameList, 'h12') && !fn:contains(projectNameList, 'h13')}">
                        <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${medicalDataDate.organization.organName}"></tags:textWithTip></td>
                    </c:if>
                    <td style="text-align: left">会诊</td>
                    <c:forEach items="${medicalDataDate.medicalDatas}" var="m">
                        <td style="text-align: left" >${m.actualConsultationCount}</td>
                    </c:forEach>
                </tr>
                </c:if>
                <c:if test="${fn:contains(projectNameList, 'h15')}">
                <tr>
                    <c:if test="${!fn:contains(projectNameList, 'h01') && !fn:contains(projectNameList, 'h06')
                        && !fn:contains(projectNameList, 'h02') && !fn:contains(projectNameList, 'h03')
                        && !fn:contains(projectNameList, 'h04') && !fn:contains(projectNameList, 'h07')
                        && !fn:contains(projectNameList, 'h08') && !fn:contains(projectNameList, 'h09')
                        && !fn:contains(projectNameList, 'h10') && !fn:contains(projectNameList, 'h11')
                        && !fn:contains(projectNameList, 'h12') && !fn:contains(projectNameList, 'h13')
                         && !fn:contains(projectNameList, 'h14')}">
                        <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${medicalDataDate.organization.organName}"></tags:textWithTip></td>
                    </c:if>
                    <td style="text-align: left">检查</td>
                    <c:forEach items="${medicalDataDate.medicalDatas}" var="m">
                        <td style="text-align: left" >${m.actualStudyEventCount}</td>
                    </c:forEach>
                </tr>
                </c:if>
            </c:forEach>
            </tbody>
	    </table>
    </div>
    </div>
</div>

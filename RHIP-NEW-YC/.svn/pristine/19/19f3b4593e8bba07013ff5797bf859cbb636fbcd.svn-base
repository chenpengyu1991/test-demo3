<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<div class="repeattable">
<div id="medicalGoodsTopDiv">
<table id="medicalGoodsTable">
    <colgroup>
        <col style="width:15%;"/>
        <col style="width:15%;"/>
        <col style="width:5%;"/>
        <col style="width:5%;"/>
        <col style="width:5%;"/>
        <col style="width:5%;"/>
        <col style="width:5%;"/>
        <col style="width:5%;"/>
        <col style="width:5%;"/>
        <col style="width:5%;"/>
        <col style="width:5%;"/>
        <col style="width:5%;"/>
        <col style="width:5%;"/>
        <col style="width:5%;"/>
        <col style="width:5%;"/>
        <col style="width:5%;"/>
    </colgroup>
    <thead>
    <tr>
        <th rowspan="2" style="width: 110px;">医院名称</th>
        <th rowspan="2" style="width: 110px;">项目名称</th>
        <c:forEach items="${dateList}" var="d">
            <th colspan="2"><fmt:formatDate value="${d}" pattern="MM月dd日"/></th>
        </c:forEach>
    </tr>
    <tr>
        <c:forEach items="${dateList}" var="d">
            <th>应传数量</th>
            <th>实际数量</th>
        </c:forEach>
    </tr>
    </thead>
</table>
<div id="medicalGoodsDiv" class="contentfixed149">
<table>
<colgroup>
    <col style="width:15%;"/>
    <col style="width:15%;"/>
    <col style="width:5%;"/>
    <col style="width:5%;"/>
    <col style="width:5%;"/>
    <col style="width:5%;"/>
    <col style="width:5%;"/>
    <col style="width:5%;"/>
    <col style="width:5%;"/>
    <col style="width:5%;"/>
    <col style="width:5%;"/>
    <col style="width:5%;"/>
    <col style="width:5%;"/>
    <col style="width:5%;"/>
    <col style="width:5%;"/>
    <col style="width:5%;"/>
</colgroup>
<tbody>
<c:forEach items="${hmMonitorList}" var="monitor">
<c:if test="${fn:contains(projectNameList, 'da01')}">
    <tr>
        <c:if test="${fn:contains(projectNameList, 'da01')}">
            <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${monitor.organization.organName}"></tags:textWithTip></td>
        </c:if>
        <td style="text-align: left">药库入库</td>
        <c:forEach items="${monitor.monitors}" var="m">
            <td style="text-align: left" >${m.shouldOutpatientCount}</td>
            <td style="text-align: left" >${m.actualOutpatientCount}</td>
        </c:forEach>
    </tr>
</c:if>
<c:if test="${fn:contains(projectNameList, 'da02')}">
    <tr>
        <c:if test="${!fn:contains(projectNameList, 'da01')}">
            <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${monitor.organization.organName}"></tags:textWithTip></td>
        </c:if>
        <td style="text-align: left">药库入库详细</td>
        <c:forEach items="${monitor.monitors}" var="m">
            <td style="text-align: left" >${m.shouldInpatientCount}</td>
            <td style="text-align: left" >${m.actualInpatientCount}</td>
        </c:forEach>
    </tr>
</c:if>
<c:if test="${fn:contains(projectNameList, 'da03')}">
    <tr>
        <c:if test="${!fn:contains(projectNameList, 'da01') && !fn:contains(projectNameList, 'da02')}">
            <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${monitor.organization.organName}"></tags:textWithTip></td>
        </c:if>
        <td style="text-align: left">药库出库</td>
        <c:forEach items="${monitor.monitors}" var="m">
            <td style="text-align: left" >${m.shouldDiseaseDiagnosisCount}</td>
            <td style="text-align: left" >${m.actualDiseaseDiagnosisCount}</td>
        </c:forEach>
    </tr>
</c:if>
<c:if test="${fn:contains(projectNameList, 'da04')}">
    <tr>
        <c:if test="${!fn:contains(projectNameList, 'da01') && !fn:contains(projectNameList, 'da02') && !fn:contains(projectNameList, 'da03')}">
            <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${monitor.organization.organName}"></tags:textWithTip></td>
        </c:if>
        <td style="text-align: left">药库出库详细</td>
        <c:forEach items="${monitor.monitors}" var="m">
            <td style="text-align: left" >${m.shouldOutpatientPrescriptionCount}</td>
            <td style="text-align: left" >${m.actualOutpatientPrescriptionCount}</td>
        </c:forEach>
    </tr>
</c:if>
<c:if test="${fn:contains(projectNameList, 'da05')}">
    <tr>
        <c:if test="${!fn:contains(projectNameList, 'da01') && !fn:contains(projectNameList, 'da02')
                        && !fn:contains(projectNameList, 'da03') && !fn:contains(projectNameList, 'da04')}">
            <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${monitor.organization.organName}"></tags:textWithTip></td>
        </c:if>
        <td style="text-align: left">药库库存</td>
        <c:forEach items="${monitor.monitors}" var="m">
            <td style="text-align: left" >${m.shouldDrugCount}</td>
            <td style="text-align: left" >${m.actualDrugCount}</td>
        </c:forEach>
    </tr>
</c:if>
<c:if test="${fn:contains(projectNameList, 'da06')}">
    <tr>
        <c:if test="${!fn:contains(projectNameList, 'da01') && !fn:contains(projectNameList, 'da02')
                        && !fn:contains(projectNameList, 'da03') && !fn:contains(projectNameList, 'da04') && !fn:contains(projectNameList, 'da05')}">
            <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${monitor.organization.organName}"></tags:textWithTip></td>
        </c:if>
        <td style="text-align: left">药库退货</td>
        <c:forEach items="${monitor.monitors}" var="m">
            <td style="text-align: left" >${m.shouldSurgeryCount}</td>
            <td style="text-align: left" >${m.actualSurgeryCount}</td>
        </c:forEach>
    </tr>
</c:if>
<c:if test="${fn:contains(projectNameList, 'da07')}">
    <tr>
        <c:if test="${!fn:contains(projectNameList, 'da01') && !fn:contains(projectNameList, 'da02')
                        && !fn:contains(projectNameList, 'da03') && !fn:contains(projectNameList, 'da04')
                        && !fn:contains(projectNameList, 'da05')&& !fn:contains(projectNameList, 'da06')}">
            <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${monitor.organization.organName}"></tags:textWithTip></td>
        </c:if>
        <td style="text-align: left">药库退货详细</td>
        <c:forEach items="${monitor.monitors}" var="m">
            <td style="text-align: left" >${m.shouldTransBloodCount}</td>
            <td style="text-align: left" >${m.actualTransBloodCount}</td>
        </c:forEach>
    </tr>
</c:if>
<c:if test="${fn:contains(projectNameList, 'da08')}">
    <tr>
        <c:if test="${!fn:contains(projectNameList, 'da01') && !fn:contains(projectNameList, 'da02')
                        && !fn:contains(projectNameList, 'da03') && !fn:contains(projectNameList, 'da04')
                        && !fn:contains(projectNameList, 'da05')&& !fn:contains(projectNameList, 'da06')&& !fn:contains(projectNameList, 'da07')}">
            <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${monitor.organization.organName}"></tags:textWithTip></td>
        </c:if>
        <td style="text-align: left">药房入库</td>
        <c:forEach items="${monitor.monitors}" var="m">
            <td style="text-align: left" >${m.shouldUploadCount08}</td>
            <td style="text-align: left" >${m.actualUploadCount08}</td>
        </c:forEach>
    </tr>
</c:if>
<c:if test="${fn:contains(projectNameList, 'da09')}">
    <tr>
        <c:if test="${!fn:contains(projectNameList, 'da01') && !fn:contains(projectNameList, 'da02')
                        && !fn:contains(projectNameList, 'da03') && !fn:contains(projectNameList, 'da04')
                        && !fn:contains(projectNameList, 'da05') && !fn:contains(projectNameList, 'da06')
                        && !fn:contains(projectNameList, 'da07') && !fn:contains(projectNameList, 'da08')}">
            <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${monitor.organization.organName}"></tags:textWithTip></td>
        </c:if>
        <td style="text-align: left">药房入库详细</td>
        <c:forEach items="${monitor.monitors}" var="m">
            <td style="text-align: left" >${m.shouldExamineEventCount}</td>
            <td style="text-align: left" >${m.actualExamineEventCount}</td>
        </c:forEach>
    </tr>
</c:if>
<c:if test="${fn:contains(projectNameList, 'da10')}">
    <tr>
        <c:if test="${!fn:contains(projectNameList, 'da01') && !fn:contains(projectNameList, 'da02')
                        && !fn:contains(projectNameList, 'da03') && !fn:contains(projectNameList, 'da04')
                        && !fn:contains(projectNameList, 'da05') && !fn:contains(projectNameList, 'da06')
                        && !fn:contains(projectNameList, 'da07') && !fn:contains(projectNameList, 'da08')
                        && !fn:contains(projectNameList, 'da09')}">
            <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${monitor.organization.organName}"></tags:textWithTip></td>
        </c:if>
        <td style="text-align: left">药房出库</td>
        <c:forEach items="${monitor.monitors}" var="m">
            <td style="text-align: left" >${m.shouldHealthExaminationCount}</td>
            <td style="text-align: left" >${m.actualHealthExaminationCount}</td>
        </c:forEach>
    </tr>
</c:if>
<c:if test="${fn:contains(projectNameList, 'da11')}">
    <tr>
        <c:if test="${!fn:contains(projectNameList, 'da01') && !fn:contains(projectNameList, 'da02')
                        && !fn:contains(projectNameList, 'da03') && !fn:contains(projectNameList, 'da04')
                        && !fn:contains(projectNameList, 'da05') && !fn:contains(projectNameList, 'da06')
                        && !fn:contains(projectNameList, 'da07') && !fn:contains(projectNameList, 'da08')
                        && !fn:contains(projectNameList, 'da09') && !fn:contains(projectNameList, 'da10')}">
            <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${monitor.organization.organName}"></tags:textWithTip></td>
        </c:if>
        <td style="text-align: left">药房出库详细</td>
        <c:forEach items="${monitor.monitors}" var="m">
            <td style="text-align: left" >${m.shouldOuthospitalSummaryCount}</td>
            <td style="text-align: left" >${m.actualOuthospitalSummaryCount}</td>
        </c:forEach>
    </tr>
</c:if>
<c:if test="${fn:contains(projectNameList, 'da12')}">
    <tr>
        <c:if test="${!fn:contains(projectNameList, 'da01') && !fn:contains(projectNameList, 'da02')
                        && !fn:contains(projectNameList, 'da03') && !fn:contains(projectNameList, 'da04')
                        && !fn:contains(projectNameList, 'da05') && !fn:contains(projectNameList, 'da06')
                        && !fn:contains(projectNameList, 'da07') && !fn:contains(projectNameList, 'da08')
                        && !fn:contains(projectNameList, 'da09') && !fn:contains(projectNameList, 'da10')
                        && !fn:contains(projectNameList, 'da11')}">
            <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${monitor.organization.organName}"></tags:textWithTip></td>
        </c:if>
        <td style="text-align: left">药房库存</td>
        <c:forEach items="${monitor.monitors}" var="m">
            <td style="text-align: left" >${m.shouldInpatientMedicalRecordCount}</td>
            <td style="text-align: left" >${m.actualInpatientMedicalRecordCount}</td>
        </c:forEach>
    </tr>
</c:if>
<c:if test="${fn:contains(projectNameList, 'da13')}">
    <tr>
        <c:if test="${!fn:contains(projectNameList, 'da01') && !fn:contains(projectNameList, 'da02')
                        && !fn:contains(projectNameList, 'da03') && !fn:contains(projectNameList, 'da04')
                        && !fn:contains(projectNameList, 'da05') && !fn:contains(projectNameList, 'da06')
                        && !fn:contains(projectNameList, 'da07') && !fn:contains(projectNameList, 'da08')
                        && !fn:contains(projectNameList, 'da09') && !fn:contains(projectNameList, 'da10')
                        && !fn:contains(projectNameList, 'da11') && !fn:contains(projectNameList, 'da12')}">
            <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${monitor.organization.organName}"></tags:textWithTip></td>
        </c:if>
        <td style="text-align: left">药房退货</td>
        <c:forEach items="${monitor.monitors}" var="m">
            <td style="text-align: left" >${m.shouldReferralCount}</td>
            <td style="text-align: left" >${m.actualReferralCount}</td>
        </c:forEach>
    </tr>
</c:if>
<c:if test="${fn:contains(projectNameList, 'da14')}">
    <tr>
        <c:if test="${!fn:contains(projectNameList, 'da01') && !fn:contains(projectNameList, 'da02')
                        && !fn:contains(projectNameList, 'da03') && !fn:contains(projectNameList, 'da04')
                        && !fn:contains(projectNameList, 'da05') && !fn:contains(projectNameList, 'da06')
                        && !fn:contains(projectNameList, 'da07') && !fn:contains(projectNameList, 'da08')
                        && !fn:contains(projectNameList, 'da09') && !fn:contains(projectNameList, 'da10')
                        && !fn:contains(projectNameList, 'da11') && !fn:contains(projectNameList, 'da12')
                        && !fn:contains(projectNameList, 'da13')}">
            <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${monitor.organization.organName}"></tags:textWithTip></td>
        </c:if>
        <td style="text-align: left">药房退货详细</td>
        <c:forEach items="${monitor.monitors}" var="m">
            <td style="text-align: left" >${m.shouldConsultationCount}</td>
            <td style="text-align: left" >${m.actualConsultationCount}</td>
        </c:forEach>
    </tr>
</c:if>
<c:if test="${fn:contains(projectNameList, 'da15')}">
    <tr>
        <c:if test="${!fn:contains(projectNameList, 'da01') && !fn:contains(projectNameList, 'da02')
                        && !fn:contains(projectNameList, 'da03') && !fn:contains(projectNameList, 'da04')
                        && !fn:contains(projectNameList, 'da05') && !fn:contains(projectNameList, 'da06')
                        && !fn:contains(projectNameList, 'da07') && !fn:contains(projectNameList, 'da08')
                        && !fn:contains(projectNameList, 'da09') && !fn:contains(projectNameList, 'da10')
                        && !fn:contains(projectNameList, 'da11') && !fn:contains(projectNameList, 'da12')
                        && !fn:contains(projectNameList, 'da13') && !fn:contains(projectNameList, 'da14')}">
            <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${monitor.organization.organName}"></tags:textWithTip></td>
        </c:if>
        <td style="text-align: left">药房退药</td>
        <c:forEach items="${monitor.monitors}" var="m">
            <td style="text-align: left" >${m.shouldUploadCount15}</td>
            <td style="text-align: left" >${m.actualUploadCount15}</td>
        </c:forEach>
    </tr>
</c:if>
<c:if test="${fn:contains(projectNameList, 'da16')}">
    <tr>
        <c:if test="${!fn:contains(projectNameList, 'da01') && !fn:contains(projectNameList, 'da02')
                        && !fn:contains(projectNameList, 'da03') && !fn:contains(projectNameList, 'da04')
                        && !fn:contains(projectNameList, 'da05') && !fn:contains(projectNameList, 'da06')
                        && !fn:contains(projectNameList, 'da07') && !fn:contains(projectNameList, 'da08')
                        && !fn:contains(projectNameList, 'da09') && !fn:contains(projectNameList, 'da10')
                        && !fn:contains(projectNameList, 'da11') && !fn:contains(projectNameList, 'da12')
                        && !fn:contains(projectNameList, 'da13') && !fn:contains(projectNameList, 'da14')
                        && !fn:contains(projectNameList, 'da15')}">
            <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${monitor.organization.organName}"></tags:textWithTip></td>
        </c:if>
        <td style="text-align: left">药房退药详细</td>
        <c:forEach items="${monitor.monitors}" var="m">
            <td style="text-align: left" >${m.shouldUploadCount16}</td>
            <td style="text-align: left" >${m.actualUploadCount16}</td>
        </c:forEach>
    </tr>
</c:if>
<c:if test="${fn:contains(projectNameList, 'da17')}">
    <tr>
        <c:if test="${!fn:contains(projectNameList, 'da01') && !fn:contains(projectNameList, 'da02')
                        && !fn:contains(projectNameList, 'da03') && !fn:contains(projectNameList, 'da04')
                        && !fn:contains(projectNameList, 'da05') && !fn:contains(projectNameList, 'da06')
                        && !fn:contains(projectNameList, 'da07') && !fn:contains(projectNameList, 'da08')
                        && !fn:contains(projectNameList, 'da09') && !fn:contains(projectNameList, 'da10')
                        && !fn:contains(projectNameList, 'da11') && !fn:contains(projectNameList, 'da12')
                        && !fn:contains(projectNameList, 'da13') && !fn:contains(projectNameList, 'da14')
                        && !fn:contains(projectNameList, 'da15') && !fn:contains(projectNameList, 'da16')}">
            <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${monitor.organization.organName}"></tags:textWithTip></td>
        </c:if>
        <td style="text-align: left">药品养护</td>
        <c:forEach items="${monitor.monitors}" var="m">
            <td style="text-align: left" >${m.shouldUploadCount17}</td>
            <td style="text-align: left" >${m.actualUploadCount17}</td>
        </c:forEach>
    </tr>
</c:if>
<c:if test="${fn:contains(projectNameList, 'da18')}">
    <tr>
        <c:if test="${!fn:contains(projectNameList, 'da01') && !fn:contains(projectNameList, 'da02')
                        && !fn:contains(projectNameList, 'da03') && !fn:contains(projectNameList, 'da04')
                        && !fn:contains(projectNameList, 'da05') && !fn:contains(projectNameList, 'da06')
                        && !fn:contains(projectNameList, 'da07') && !fn:contains(projectNameList, 'da08')
                        && !fn:contains(projectNameList, 'da09') && !fn:contains(projectNameList, 'da10')
                        && !fn:contains(projectNameList, 'da11') && !fn:contains(projectNameList, 'da12')
                        && !fn:contains(projectNameList, 'da13') && !fn:contains(projectNameList, 'da14')
                        && !fn:contains(projectNameList, 'da15') && !fn:contains(projectNameList, 'da16')
                        && !fn:contains(projectNameList, 'da17')}">
            <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${monitor.organization.organName}"></tags:textWithTip></td>
        </c:if>
        <td style="text-align: left">耗材监控(入库单)</td>
        <c:forEach items="${monitor.monitors}" var="m">
            <td style="text-align: left" >${m.shouldUploadCount18}</td>
            <td style="text-align: left" >${m.actualUploadCount18}</td>
        </c:forEach>
    </tr>
</c:if>
<c:if test="${fn:contains(projectNameList, 'da19')}">
    <tr>
        <c:if test="${!fn:contains(projectNameList, 'da01') && !fn:contains(projectNameList, 'da02')
                        && !fn:contains(projectNameList, 'da03') && !fn:contains(projectNameList, 'da04')
                        && !fn:contains(projectNameList, 'da05') && !fn:contains(projectNameList, 'da06')
                        && !fn:contains(projectNameList, 'da07') && !fn:contains(projectNameList, 'da08')
                        && !fn:contains(projectNameList, 'da09') && !fn:contains(projectNameList, 'da10')
                        && !fn:contains(projectNameList, 'da11') && !fn:contains(projectNameList, 'da12')
                        && !fn:contains(projectNameList, 'da13') && !fn:contains(projectNameList, 'da14')
                        && !fn:contains(projectNameList, 'da15') && !fn:contains(projectNameList, 'da16')
                        && !fn:contains(projectNameList, 'da17') && !fn:contains(projectNameList, 'da18')}">
            <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${monitor.organization.organName}"></tags:textWithTip></td>
        </c:if>
        <td style="text-align: left">耗材监控(入库明细)</td>
        <c:forEach items="${monitor.monitors}" var="m">
            <td style="text-align: left" >${m.shouldUploadCount19}</td>
            <td style="text-align: left" >${m.actualUploadCount19}</td>
        </c:forEach>
    </tr>
</c:if>
<c:if test="${fn:contains(projectNameList, 'da20')}">
    <tr>
        <c:if test="${!fn:contains(projectNameList, 'da01') && !fn:contains(projectNameList, 'da02')
                        && !fn:contains(projectNameList, 'da03') && !fn:contains(projectNameList, 'da04')
                        && !fn:contains(projectNameList, 'da05') && !fn:contains(projectNameList, 'da06')
                        && !fn:contains(projectNameList, 'da07') && !fn:contains(projectNameList, 'da08')
                        && !fn:contains(projectNameList, 'da09') && !fn:contains(projectNameList, 'da10')
                        && !fn:contains(projectNameList, 'da11') && !fn:contains(projectNameList, 'da12')
                        && !fn:contains(projectNameList, 'da13') && !fn:contains(projectNameList, 'da14')
                        && !fn:contains(projectNameList, 'da15') && !fn:contains(projectNameList, 'da16')
                        && !fn:contains(projectNameList, 'da17') && !fn:contains(projectNameList, 'da18')
                        && !fn:contains(projectNameList, 'da19')}">
            <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${monitor.organization.organName}"></tags:textWithTip></td>
        </c:if>
        <td style="text-align: left">耗材监控(出库单)</td>
        <c:forEach items="${monitor.monitors}" var="m">
            <td style="text-align: left" >${m.shouldUploadCount20}</td>
            <td style="text-align: left" >${m.actualUploadCount20}</td>
        </c:forEach>
    </tr>
</c:if>
<c:if test="${fn:contains(projectNameList, 'da21')}">
    <tr>
        <c:if test="${!fn:contains(projectNameList, 'da01') && !fn:contains(projectNameList, 'da02')
                        && !fn:contains(projectNameList, 'da03') && !fn:contains(projectNameList, 'da04')
                        && !fn:contains(projectNameList, 'da05') && !fn:contains(projectNameList, 'da06')
                        && !fn:contains(projectNameList, 'da07') && !fn:contains(projectNameList, 'da08')
                        && !fn:contains(projectNameList, 'da09') && !fn:contains(projectNameList, 'da10')
                        && !fn:contains(projectNameList, 'da11') && !fn:contains(projectNameList, 'da12')
                        && !fn:contains(projectNameList, 'da13') && !fn:contains(projectNameList, 'da14')
                        && !fn:contains(projectNameList, 'da15') && !fn:contains(projectNameList, 'da16')
                        && !fn:contains(projectNameList, 'da17') && !fn:contains(projectNameList, 'da18')
                        && !fn:contains(projectNameList, 'da19') && !fn:contains(projectNameList, 'da20')}">
            <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${monitor.organization.organName}"></tags:textWithTip></td>
        </c:if>
        <td style="text-align: left">耗材监控(出库明细)</td>
        <c:forEach items="${monitor.monitors}" var="m">
            <td style="text-align: left" >${m.shouldUploadCount21}</td>
            <td style="text-align: left" >${m.actualUploadCount21}</td>
        </c:forEach>
    </tr>
</c:if>
<c:if test="${fn:contains(projectNameList, 'da22')}">
    <tr>
        <c:if test="${!fn:contains(projectNameList, 'da01') && !fn:contains(projectNameList, 'da02')
                        && !fn:contains(projectNameList, 'da03') && !fn:contains(projectNameList, 'da04')
                        && !fn:contains(projectNameList, 'da05') && !fn:contains(projectNameList, 'da06')
                        && !fn:contains(projectNameList, 'da07') && !fn:contains(projectNameList, 'da08')
                        && !fn:contains(projectNameList, 'da09') && !fn:contains(projectNameList, 'da10')
                        && !fn:contains(projectNameList, 'da11') && !fn:contains(projectNameList, 'da12')
                        && !fn:contains(projectNameList, 'da13') && !fn:contains(projectNameList, 'da14')
                        && !fn:contains(projectNameList, 'da15') && !fn:contains(projectNameList, 'da16')
                        && !fn:contains(projectNameList, 'da17') && !fn:contains(projectNameList, 'da18')
                        && !fn:contains(projectNameList, 'da19') && !fn:contains(projectNameList, 'da20')
                        && !fn:contains(projectNameList, 'da21')}">
            <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${monitor.organization.organName}"></tags:textWithTip></td>
        </c:if>
        <td style="text-align: left">耗材监控(库存)</td>
        <c:forEach items="${monitor.monitors}" var="m">
            <td style="text-align: left" >${m.shouldUploadCount22}</td>
            <td style="text-align: left" >${m.actualUploadCount22}</td>
        </c:forEach>
    </tr>
</c:if>
<c:if test="${fn:contains(projectNameList, 'da23')}">
    <tr>
        <c:if test="${!fn:contains(projectNameList, 'da01') && !fn:contains(projectNameList, 'da02')
                        && !fn:contains(projectNameList, 'da03') && !fn:contains(projectNameList, 'da04')
                        && !fn:contains(projectNameList, 'da05') && !fn:contains(projectNameList, 'da06')
                        && !fn:contains(projectNameList, 'da07') && !fn:contains(projectNameList, 'da08')
                        && !fn:contains(projectNameList, 'da09') && !fn:contains(projectNameList, 'da10')
                        && !fn:contains(projectNameList, 'da11') && !fn:contains(projectNameList, 'da12')
                        && !fn:contains(projectNameList, 'da13') && !fn:contains(projectNameList, 'da14')
                        && !fn:contains(projectNameList, 'da15') && !fn:contains(projectNameList, 'da16')
                        && !fn:contains(projectNameList, 'da17') && !fn:contains(projectNameList, 'da18')
                        && !fn:contains(projectNameList, 'da19') && !fn:contains(projectNameList, 'da20')
                        && !fn:contains(projectNameList, 'da21') && !fn:contains(projectNameList, 'da22')}">
            <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${monitor.organization.organName}"></tags:textWithTip></td>
        </c:if>
        <td style="text-align: left">耗材监控(报损)</td>
        <c:forEach items="${monitor.monitors}" var="m">
            <td style="text-align: left" >${m.shouldUploadCount23}</td>
            <td style="text-align: left" >${m.actualUploadCount23}</td>
        </c:forEach>
    </tr>
</c:if>
<c:if test="${fn:contains(projectNameList, 'da24')}">
    <tr>
        <c:if test="${!fn:contains(projectNameList, 'da01') && !fn:contains(projectNameList, 'da02')
                        && !fn:contains(projectNameList, 'da03') && !fn:contains(projectNameList, 'da04')
                        && !fn:contains(projectNameList, 'da05') && !fn:contains(projectNameList, 'da06')
                        && !fn:contains(projectNameList, 'da07') && !fn:contains(projectNameList, 'da08')
                        && !fn:contains(projectNameList, 'da09') && !fn:contains(projectNameList, 'da10')
                        && !fn:contains(projectNameList, 'da11') && !fn:contains(projectNameList, 'da12')
                        && !fn:contains(projectNameList, 'da13') && !fn:contains(projectNameList, 'da14')
                        && !fn:contains(projectNameList, 'da15') && !fn:contains(projectNameList, 'da16')
                        && !fn:contains(projectNameList, 'da17') && !fn:contains(projectNameList, 'da18')
                        && !fn:contains(projectNameList, 'da19') && !fn:contains(projectNameList, 'da20')
                        && !fn:contains(projectNameList, 'da21') && !fn:contains(projectNameList, 'da22')
                        && !fn:contains(projectNameList, 'da23')}">
            <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${monitor.organization.organName}"></tags:textWithTip></td>
        </c:if>
        <td style="text-align: left">设备监控(库存)</td>
        <c:forEach items="${monitor.monitors}" var="m">
            <td style="text-align: left" >${m.shouldUploadCount24}</td>
            <td style="text-align: left" >${m.actualUploadCount24}</td>
        </c:forEach>
    </tr>
</c:if>
<c:if test="${fn:contains(projectNameList, 'da25')}">
    <tr>
        <c:if test="${!fn:contains(projectNameList, 'da01') && !fn:contains(projectNameList, 'da02')
                        && !fn:contains(projectNameList, 'da03') && !fn:contains(projectNameList, 'da04')
                        && !fn:contains(projectNameList, 'da05') && !fn:contains(projectNameList, 'da06')
                        && !fn:contains(projectNameList, 'da07') && !fn:contains(projectNameList, 'da08')
                        && !fn:contains(projectNameList, 'da09') && !fn:contains(projectNameList, 'da10')
                        && !fn:contains(projectNameList, 'da11') && !fn:contains(projectNameList, 'da12')
                        && !fn:contains(projectNameList, 'da13') && !fn:contains(projectNameList, 'da14')
                        && !fn:contains(projectNameList, 'da15') && !fn:contains(projectNameList, 'da16')
                        && !fn:contains(projectNameList, 'da17') && !fn:contains(projectNameList, 'da18')
                        && !fn:contains(projectNameList, 'da19') && !fn:contains(projectNameList, 'da20')
                        && !fn:contains(projectNameList, 'da21') && !fn:contains(projectNameList, 'da22')
                        && !fn:contains(projectNameList, 'da23') && !fn:contains(projectNameList, 'da24')}">
            <td rowspan="${fn:length(projectNameList)}"><tags:textWithTip value="${monitor.organization.organName}"></tags:textWithTip></td>
        </c:if>
        <td style="text-align: left">设备监控(报损)</td>
        <c:forEach items="${monitor.monitors}" var="m">
            <td style="text-align: left" >${m.shouldUploadCount25}</td>
            <td style="text-align: left" >${m.actualUploadCount25}</td>
        </c:forEach>
    </tr>
</c:if>
</c:forEach>
</tbody>
</table>
</div>
</div>
</div>

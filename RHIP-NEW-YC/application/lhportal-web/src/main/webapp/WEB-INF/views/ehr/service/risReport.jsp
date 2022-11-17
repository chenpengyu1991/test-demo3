<%--
  Created by IntelliJ IDEA.
  User: chen.q
  Date: 15-6-8
  Time: 下午6:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="postdiv">
    <c:set var="studyEvent" value="${studyReportDTO.studyEvent}" scope="request">
    </c:set>
    <c:set var="imageIndex" value="${studyReportDTO.imageIndex}" scope="request">
    </c:set>
    <fieldset class="setcontent">
        <legend>基本信息:</legend>
        <table class="posttable">
            <tr>
                <th style="width: 25%">申请时间:</th>
                <td style="width: 25%"><fmt:formatDate value="${studyEvent.applyDate}" pattern="yyyy/MM/dd HH:mm:ss" /></td>
                <th style="width: 25%">检查单号:</th>
                <td style="width: 25%"><c:out value="${studyEvent.recordNumber}"></c:out></td>
            </tr>
            <tr>
                <th style="width: 25%">申请科室:</th>
                <td style="width: 25%"><c:out value="${studyEvent.applyRoomName}"></c:out></td>
                <th style="width: 25%">申请医生:</th>
                <td style="width: 25%"><c:out value="${studyEvent.applyPeopleName}"></c:out></td>
            </tr>
            <tr>
                <th style="width: 25%">检查类型:</th>
                <%--<td style="width: 25%"><ehr:dic dicmeta="FS10249" code="${studyEvent.inspectionType}"/></td>--%>
                <td style="width: 25%"><c:out value="${studyEvent.inspectionItemName}"></c:out></td>
                <th style="width: 25%">检查机构:</th>
                <td style="width: 25%"><c:out value="${studyEvent.hospitalName}"></c:out></td>
            </tr>
        </table>
    </fieldset>

    <fieldset class="setcontent" style="height: 60%">
        <legend>检查结果:</legend>
        <table class="posttable" style="width: 100%;">
            <colgroup>
                <col style="width: 16%">
                <col style="width: 16%">
                <col style="width: 16%">
                <col style="width: 16%">
                <col style="width: 16%">
                <col style="width: 20%">
            </colgroup>
            <tr>
                <th>检查所见:</th>
                <td colspan="5" ><c:out value="${studyEvent.findings}"></c:out></td>
            </tr>
            <tr>
                <th>所得结论:</th>
                <td colspan="5"><c:out value="${studyEvent.conclusionDesc}"></c:out></td>
            </tr>
            <tr>
                <th>医生建议:</th>
                <td colspan="5"><c:out value="${studyEvent.suggestion}"></c:out></td>
            </tr>
            <tr>
                <th >检查医生:</th>
                <td ><c:out value="${studyEvent.checkPeopleName}"></c:out></td>
                <th >审核医生:</th>
                <td ><c:out value="${studyEvent.auditName}"></c:out></td>
                <th >审核日期:</th>
                <td ><fmt:formatDate value="${studyEvent.auditDate}" pattern="yyyy/MM/dd" /></td>
            </tr>

        </table>
    </fieldset>

</div>

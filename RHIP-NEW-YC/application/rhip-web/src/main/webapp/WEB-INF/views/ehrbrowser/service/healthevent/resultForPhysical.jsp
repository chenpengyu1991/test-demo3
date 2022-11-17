<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/ehr-tag" prefix="ehr" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<script src="${pageContext.request.contextPath}/js/views/ehr/ehrbrowser/basic/physical.js" type="text/javascript"></script>

<div style="float: left; width: 25%;height: 535px;overflow: auto" class="repeattable" >
    <table  class="layui-table x-admin-sm-table-list-small">
        <thead>
        <tr>
            <th width="27%">日期</th>
            <th>机构</th>
            <th width="28%">类型</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${healthEventItems}" var="item">
            <c:choose>
                <c:when test="${item.ehrHealthEvent.ehrType=='33'}">
                    <tr onclick="ehrBrowserBasicForPhysical.studentPhysical(${item.ehrHealthEvent.personId},'${item.ehrHealthEvent.ehrId}')" style="cursor: hand">
                </c:when>
                <c:when test="${item.ehrHealthEvent.ehrType=='39'}">
                    <tr  onclick="ehrBrowserBasicForPhysical.cdmPhysical(${item.ehrHealthEvent.personId},'${item.ehrHealthEvent.ehrId}')" style="cursor: hand">
                </c:when>
                <c:when test="${item.ehrHealthEvent.ehrType=='31'}">
                    <c:if test="${!item.hasPhysicalExamRecord}">
                        <tr title="暂无报告" onclick="ehrBrowserBasicForPhysical.oldPhysical(0,0)" style="cursor: hand">
                    </c:if>
                    <c:if test="${item.hasPhysicalExamRecord}">
                        <tr onclick="ehrBrowserBasicForPhysical.oldPhysical(${item.ehrHealthEvent.personId},${item.ehrHealthEvent.ehrId})" style="cursor: hand">
                    </c:if>
                </c:when>
                <c:when test="${item.ehrHealthEvent.ehrType=='A00000003'}">
                    <tr onclick="ehrBrowserBasicForPhysical.ehrphysical(${item.ehrHealthEvent.personId},'${item.ehrHealthEvent.ehrId}')">
                </c:when>
                <c:otherwise>
                    <tr onclick="ehrBrowserBasicForPhysical.physical(${item.ehrHealthEvent.personId},'${item.ehrHealthEvent.ehrId}')" style="cursor: hand">
                </c:otherwise>
            </c:choose>
            <td>
                <fmt:formatDate value="${item.ehrHealthEvent.clinicDate}" pattern="yyyy/MM/dd" />
            </td>
            <td>
                <c:choose>
                    <c:when test="${item.ehrHealthEvent.clinicOrganName != null}"><ehr:tip>${item.ehrHealthEvent.clinicOrganName}</ehr:tip></c:when>
                    <c:when test="${item.ehrHealthEvent.clinicOrganName==null && item.ehrHealthEvent.clinicOrganCode!=null}"><ehr:tip><ehr:org code="${item.ehrHealthEvent.clinicOrganCode}"/></ehr:tip></c:when>
                    <%-- <c:when test="${item.ehrHealthEvent.createOrganName != null}">${item.ehrHealthEvent.createOrganName}</c:when>
                    <c:otherwise><ehr:tip><ehr:org code="${item.ehrHealthEvent.createOrganCode}"/> </ehr:tip></c:otherwise> --%>
                </c:choose>
            </td>
            <td>
                <c:choose>
                    <c:when test="${item.ehrHealthEvent.ehrType=='1'}">门诊</c:when>
                    <c:when test="${item.ehrHealthEvent.ehrType=='2'}">住院</c:when>
                    <c:when test="${item.ehrHealthEvent.ehrType=='A00000003'}">个人体检表</c:when>
                    <c:otherwise>
                        <ehr:dic code="${item.ehrHealthEvent.ehrType}" dicmeta="PH00021"/>
                    </c:otherwise>
                </c:choose>
            </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
<div style="float: right; width: 74%">
    <div id="physicalDetailId" style="position: relative;height: 535px;overflow: auto"></div>
</div>


<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%--<script src="${pageContext.request.contextPath}/js/views/mhm/management/outInfo/edit.js" type="text/javascript"></script>--%>

<div class="repeattable" id="contactsList" style="width:218px; float: left;margin-right: 5px;margin-top: 10px; margin-left: 5px;">
    <table id="ccList">
        <thead>
        <tr>
            <th class="centerth">出院日期</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="plist" items="${plist}" varStatus="status">
            <tr onclick="outInfo.clickRow(this)" id="${plist.eventId}">
                <%--<td><ehr:user userCode="${plist.visitById}"/></td>--%>
                <td><fmt:formatDate value="${plist.dischargeDate}" pattern="yyyy/MM/dd" /></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <table class="mini">
        <tr>
            <ehr:pagination-mini action="outInfo.searchInPatientRecords"/>
        </tr>
    </table>
</div>


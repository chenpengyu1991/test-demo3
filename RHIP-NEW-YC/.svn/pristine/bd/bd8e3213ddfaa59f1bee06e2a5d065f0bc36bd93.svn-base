<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>

<!-- 住院-->
<c:choose> <c:when test="${not empty healthHistoryDTO.hospitalizedHistories}">
    <div class="repeattable">
        <table class="layui-table x-admin-sm-table-list-middle" style="margin: 2px 0px;">
            <thead>
            <tr>
                <th style="height: 22px">住院日期</th>
                <th style="height: 22px">住院机构</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="hospitalizedHistory" items="${healthHistoryDTO.hospitalizedHistories}">
                <c:if test="${hospitalizedHistory.ehrId != '0'}">
                    <tr>
                        <td><fmt:formatDate value="${hospitalizedHistory.inDate}" pattern="yyyy/MM/dd "/></td>
                        <td><tags:textWithTip value="${hospitalizedHistory.inputOrganName }"></tags:textWithTip></td>
                    </tr>
                </c:if>
            </c:forEach>
            </tbody>
        </table>
    </div>
</c:when> <c:otherwise>
    <div style="text-align: left;margin-left: 10px;margin-top: 10px;">没有记录</div>
</c:otherwise> </c:choose>

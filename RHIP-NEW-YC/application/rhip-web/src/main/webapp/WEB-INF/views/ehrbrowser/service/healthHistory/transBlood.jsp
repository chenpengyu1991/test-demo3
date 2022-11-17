<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>

    <!-- 输血史-->
<c:choose> <c:when test="${not empty healthHistoryDTO.transBloodHistories}">
    <div class="repeattable">
        <table class="layui-table x-admin-sm-table-list-middle" style="margin: 2px 0px;">
            <thead>
            <tr>
                <th style="height: 22px">输血日期</th>
                <th style="height: 22px">输血原因</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="transBloodHistory" items="${healthHistoryDTO.transBloodHistories}">
                <c:if test="${transBloodHistory.ehrId != '0'}">
                    <tr>
                        <td><fmt:formatDate value="${transBloodHistory.bloodDate}" pattern="yyyy/MM/dd "/></td>
                        <td><ehr:tip>${transBloodHistory.bloodReason}</ehr:tip></td>
                    </tr>
                </c:if>
            </c:forEach>
            </tbody>
        </table>
    </div>
</c:when> <c:otherwise>
    <div style="text-align: left;margin-left: 10px;margin-top: 10px;">没有记录</div>
</c:otherwise> </c:choose>

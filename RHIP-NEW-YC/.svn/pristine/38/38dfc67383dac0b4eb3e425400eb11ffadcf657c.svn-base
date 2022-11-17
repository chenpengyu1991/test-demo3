<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.mdm.common.OrgGenreCode" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<c:set var="HOSPITAL" value="<%=OrgGenreCode.HOSPITAL.getValue()%>" />
<c:set var="CENTRE" value="<%=OrgGenreCode.CENTRE.getValue()%>" />
<c:set var="STATION" value="<%=OrgGenreCode.STATION.getValue()%>" />
<table class="layui-table x-admin-sm-table-list-middle">
    <colgroup>
        <c:choose>
            <c:when test="${genreCode == '0' }">
                <col style="min-width:400px;width: 50%;"/>
                <col style="min-width:400px;width: 50%;"/>
            </c:when>
            <c:when test="${genreCode == STATION}">
                <col style="min-width:400px;width: 50%;"/>
                <col style="min-width:400px;width: 50%;"/>
            </c:when>
            <c:otherwise>
                <col style="min-width:400px;width: 50%;"/>
                <col style="min-width:400px;width: 50%;"/>
            </c:otherwise>
         </c:choose>
    </colgroup>
    <thead>
        <tr>
            <c:choose>
                <c:when test="${genreCode == '0' }">
                    <th rowspan="2">镇</th>
                </c:when>
                <c:otherwise>
                    <th rowspan="2">医疗机构</th>
                </c:otherwise>
            </c:choose>
                     <th>健康档案调阅数</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="recReadStatistics" items="${recReadStatisticsList}" varStatus="status">
            <tr>
                <td>
                    <c:choose>
                        <c:when test="${genreCode == '0'}">
                            ${recReadStatistics.organName}
                        </c:when>
                        <c:otherwise>
                            <ehr:org code="${recReadStatistics.organCode}"/>
                            <c:if test="${recReadStatistics.organCode=='grouping'}">
                             合计
                            </c:if>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                        ${recReadStatistics.countNum}
                </td>

            </tr>
        </c:forEach>
    </tbody>
</table>

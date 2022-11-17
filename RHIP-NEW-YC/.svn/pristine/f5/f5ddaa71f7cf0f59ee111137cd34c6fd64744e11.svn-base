<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/ehr-tag" prefix="ehr" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ page import="com.founder.rhip.mdm.common.OrgGenreCode" %>

<c:set var="HOSPITAL" value="<%=OrgGenreCode.HOSPITAL.getValue()%>" />
<c:set var="CENTRE" value="<%=OrgGenreCode.CENTRE.getValue()%>" />
<c:set var="STATION" value="<%=OrgGenreCode.STATION.getValue()%>" />

<table class="layui-table x-admin-sm-table-list-middle">
    <thead>
    <tr>
        <th rowspan="2" colspan="1">管理机构</th>
        <th rowspan="1" colspan="5">建档数(份)</th>
        <th colspan="4">建档率</th>
        <th rowspan="1" colspan="4">完整率</th>
        <th rowspan="1" colspan="3">二星及以上档案</th>
    </tr>
    <tr>
        <th>应建档数</th>
        <th>档案总数</th>
        <th>一星</th>
        <th>二星</th>
        <th>三星</th>
        <th>总建档率</th>
        <th>一星</th>
        <th>二星</th>
        <th>三星</th>
        <th>总完整率</th>
        <th>一星</th>
        <th>二星</th>
        <th>三星</th>
        <th>建档数(份)</th>
        <th>建档率</th>
        <th>完整率</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="item" items="${data}">
        <c:choose>
            <c:when test="${item.targetCode=='-1'}">
                <c:set var="total" scope="request" value="${item}"></c:set>
            </c:when>
            <c:otherwise>
                <c:if test="${item.targetName ne '卫生局'}">
                    <tr>
                        <td><ehr:tip>${item.targetName}</ehr:tip></td>
                        <td><tags:numberLabel defaultValue="0" value="${item.personCount}" type="number"/></td>
                        <td><tags:numberLabel defaultValue="0" value="${item.recordCount}" type="number"/></td>
                        <td><tags:numberLabel defaultValue="0" value="${item.oneStarRecordCount}" type="number"/></td>
                        <td><tags:numberLabel defaultValue="0" value="${item.twoStarRecordCount}" type="number"/></td>
                        <td><tags:numberLabel defaultValue="0" value="${item.threeStarRecordCount}" type="number"/></td>

                        <td><tags:numberLabel defaultValue="0" value="${item.recordOccupancy}" fractionDigits="2" type="percent"/></td>
                        <td><tags:numberLabel defaultValue="0" value="${item.oneStarRecordOccupancy}"   fractionDigits="2" type="percent"/></td>
                        <td><tags:numberLabel defaultValue="0" value="${item.twoStarRecordOccupancy}"   fractionDigits="2" type="percent"/></td>
                        <td><tags:numberLabel defaultValue="0" value="${item.threeStarRecordOccupancy}"   fractionDigits="2" type="percent"/></td>

                        <td><tags:numberLabel defaultValue="0" value="${item.recordIntegrity}" fractionDigits="2" type="percent"/></td>
                        <td><tags:numberLabel defaultValue="0" value="${item.oneStarRecordIntegrity}"   fractionDigits="2" type="percent"/></td>
                        <td><tags:numberLabel defaultValue="0" value="${item.twoStarRecordIntegrity}"   fractionDigits="2" type="percent"/></td>
                        <td><tags:numberLabel defaultValue="0" value="${item.threeStarRecordIntegrity}"    fractionDigits="2" type="percent"/></td>

                        <td><tags:numberLabel defaultValue="0" value="${item.twoaStarRecordCount}"   type="number"/></td>
                        <td><tags:numberLabel defaultValue="0" value="${item.twoaStarRecordOccupancy}"   fractionDigits="2" type="percent"/></td>
                        <td><tags:numberLabel defaultValue="0" value="${item.twoaStarRecordIntegrity}"    fractionDigits="2" type="percent"/>
                    </tr>
                </c:if>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <c:if test="${not empty total}">
        <tr>
            <td>合计</td>
            <td><tags:numberLabel defaultValue="0" value="${total.personCount}" type="number"/></td>
            <td><tags:numberLabel defaultValue="0" value="${total.recordCount}" type="number"/></td>
            <td><tags:numberLabel defaultValue="0" value="${total.oneStarRecordCount}" type="number"/></td>
            <td><tags:numberLabel defaultValue="0" value="${total.twoStarRecordCount}" type="number"/></td>
            <td><tags:numberLabel defaultValue="0" value="${total.threeStarRecordCount}" type="number"/></td>

            <td><tags:numberLabel defaultValue="0" value="${total.recordOccupancy}" fractionDigits="2" type="percent"/></td>
            <td><tags:numberLabel defaultValue="0" value="${total.oneStarRecordOccupancy}"   fractionDigits="2" type="percent"/></td>
            <td><tags:numberLabel defaultValue="0" value="${total.twoStarRecordOccupancy}"   fractionDigits="2" type="percent"/></td>
            <td><tags:numberLabel defaultValue="0" value="${total.threeStarRecordOccupancy}"   fractionDigits="2" type="percent"/></td>

            <td><tags:numberLabel defaultValue="0" value="${total.recordIntegrity}" fractionDigits="2" type="percent"/></td>
            <td><tags:numberLabel defaultValue="0" value="${total.oneStarRecordIntegrity}"   fractionDigits="2" type="percent"/></td>
            <td><tags:numberLabel defaultValue="0" value="${total.twoStarRecordIntegrity}"   fractionDigits="2" type="percent"/></td>
            <td><tags:numberLabel defaultValue="0" value="${total.threeStarRecordIntegrity}"    fractionDigits="2" type="percent"/></td>

            <td><tags:numberLabel defaultValue="0" value="${total.twoaStarRecordCount}"   type="number"/></td>
            <td><tags:numberLabel defaultValue="0" value="${total.twoaStarRecordOccupancy}"   fractionDigits="2" type="percent"/></td>
            <td><tags:numberLabel defaultValue="0" value="${total.twoaStarRecordIntegrity}"    fractionDigits="2" type="percent"/></td>
        </tr>
    </c:if>
    </tbody>
</table>


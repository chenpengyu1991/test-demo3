<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/ehr-tag" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<table class="layui-table x-admin-sm-table-list-middle">
    <thead>
        <tr>
            <th rowspan="2">机构</th>
            <th colspan="3">全部</th>
            <th colspan="3">户籍</th>
            <th colspan="3">非户籍</th>
        </tr>
        <tr>
            <th>档案数(份)</th>
            <th>人口数(人)</th>
            <th>建档率</th>
            <th>档案数(份)</th>
            <th>人口数(人)</th>
            <th>建档率</th>
            <th>档案数(份)</th>
            <th>人口数(人)</th>
            <th>建档率</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="item" items="${data}"> <c:choose> <c:when test="${item.targetCode=='-1'}">
            <c:set var="total" scope="request" value="${item}"></c:set> </c:when> <c:otherwise>
            <tr>
                <td><ehr:tip>${item.targetName}</ehr:tip></td>
                <td><tags:numberLabel  defaultValue="0"  value="${item.recordCount}" type="number"/></td>
                <td><tags:numberLabel  defaultValue="0"  value="${item.personCount}" type="number"/></td>
                <td><tags:numberLabel  defaultValue="0"  value="${item.recordOccupancy}" fractionDigits="2" type="percent"/></td>
                <td><tags:numberLabel  defaultValue="0"  value="${item.householdRecordCount}" type="number"/></td>
                <td><tags:numberLabel  defaultValue="0"  value="${item.householdPersonCount}" type="number"/></td>
                <td>
                    <tags:numberLabel  defaultValue="0"  value="${item.householdRecordOccupancy}" fractionDigits="2" type="percent"/></td>
                <td><tags:numberLabel  defaultValue="0"  value="${item.unhouseholdRecordCount}" type="number"/></td>
                <td><tags:numberLabel  defaultValue="0"  value="${item.unhouseholdPersonCount}" type="number"/></td>
                <td>
                    <tags:numberLabel  defaultValue="0"  value="${item.unhouseholdRecordOccupancy}" fractionDigits="2" type="percent"/></td>
            </tr>
        </c:otherwise> </c:choose> </c:forEach> <c:if test="${not empty total}">
            <tr>
                <td>合计</td>
                <td><tags:numberLabel  defaultValue="0"   value="${total.recordCount}" type="number"/></td>
                <td><tags:numberLabel  defaultValue="0"  value="${total.personCount}" type="number"/></td>
                <td><tags:numberLabel  defaultValue="0"  value="${total.recordOccupancy}" fractionDigits="2" type="percent"/></td>
                <td><tags:numberLabel  defaultValue="0"  value="${total.householdRecordCount}" type="number"/></td>
                <td><tags:numberLabel  defaultValue="0"  value="${total.householdPersonCount}" type="number"/></td>
                <td>
                    <tags:numberLabel  defaultValue="0"  value="${total.householdRecordOccupancy}" fractionDigits="2" type="percent"/></td>
                <td><tags:numberLabel  defaultValue="0"  value="${total.unhouseholdRecordCount}" type="number"/></td>
                <td><tags:numberLabel  defaultValue="0"  value="${total.unhouseholdPersonCount}" type="number"/></td>
                <td>
                    <tags:numberLabel  defaultValue="0"  value="${total.unhouseholdRecordOccupancy}" fractionDigits="2" type="percent"/></td>
            </tr>
        </c:if>
    </tbody>
</table>

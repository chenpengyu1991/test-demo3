<%--
  Created by IntelliJ IDEA.
  User: wang_zhou
  Date: 2015/6/11
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>


<div class="repeattable">
    <table id="healthEducationStatisticsTable" class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="width: 100px;" />
            <col style="width: 55px;" />
            <col style="width: 70px;" />
        </colgroup>
        <thead>
        <tr>
            <th>机构</th>
            <th>转出人次数</th>
            <th>转入人次数</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="report" items="${reports}">
            <tr>
                <td>
                    <c:choose>
                        <c:when test="${genreCodeFlag == '0'}">
                            <ehr:tip><ehr:dic code="${report.orgCode}" dicmeta="FS990001"  /></ehr:tip>
                        </c:when>
                        <c:when test="${report.orgCode eq '_999'}"><ehr:tip>健康教育所</ehr:tip></c:when>
                        <c:when test="${genreCodeFlag != '0'}">
                            <ehr:tip><ehr:org code="${report.orgCode}" /></ehr:tip>
                        </c:when>
                    </c:choose>
                </td>
                <td>${report.outTransfer}</td>
                <td>${report.inTransfer}</td>
            </tr>
        </c:forEach>
        <c:if test="${not empty reports}">
            <tr>
                <td><strong>合计</strong></td>
                <td>${reportSummary.outTransfer}</td>
                <td>${reportSummary.inTransfer}</td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>
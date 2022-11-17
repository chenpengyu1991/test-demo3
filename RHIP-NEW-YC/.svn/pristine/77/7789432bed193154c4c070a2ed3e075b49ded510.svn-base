<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<form id="drugFreeSearchForm">
</form>
<div id="drugFreeResultDiv" class="repeattable">
    <table class="layui-table x-admin-sm-table-list-small">
        <colgroup>
            <col style="min-width:100px;width:30%;"/>
            <col style="min-width:120px;width:30%;"/>
            <col style="min-width:120px;"/>
        </colgroup>
        <thead>
        <tr>
            <th>状态</th>
            <th>开始时间</th>
            <th>结束时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="drugFree" items="${drugFrees}" varStatus="status">
            <tr>
                <td class="centertd">${drugFree.status == '1'?'免费':'收费'}</td>
                <td class="centertd"><ehr:tip><fmt:formatDate value="${drugFree.startDt}" pattern="yyyy/MM/dd" /></ehr:tip></td>
                <td class="centertd"><ehr:tip><fmt:formatDate value="${drugFree.endDt}" pattern="yyyy/MM/dd" /></ehr:tip></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <table>
        <tr>
            <ehr:pagination action="baseArchives.searchDrugFree" />
        </tr>
    </table>
</div>
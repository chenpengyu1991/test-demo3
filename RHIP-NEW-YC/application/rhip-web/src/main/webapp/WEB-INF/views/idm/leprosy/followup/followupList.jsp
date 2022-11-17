<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table id="frList">
    <colgroup>
        <col style="width:20px"/>
        <col style="width:50px"/>
    </colgroup>
    <thead>
    <tr>
        <th class="centerth">序号</th>
        <th class="centerth">随访时间</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="followup" items="${listFrs}" varStatus="status">
        <tr onclick="followup.clickRow(this)" id="${followup.id}">
            <td>${status.index + 1}</</td>
            <td><fmt:formatDate value="${followup.visitDt}" pattern="yyyy/MM/dd" /></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<table class="mini">
    <tr>
        <ehr:pagination-mini action="followup.searchFollowList" colspan="3" />
    </tr>
</table>

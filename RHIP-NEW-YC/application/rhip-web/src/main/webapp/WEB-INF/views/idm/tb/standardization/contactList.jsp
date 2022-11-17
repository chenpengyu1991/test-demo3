<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table id="ccList" style="width:300px; float: left;margin-right: 10px;" class="layui-table x-admin-sm-table-list-small">
    <colgroup>
        <col style="width:20px"/>
        <col style="width:50px"/>
        <col style="width:50px"/>
    </colgroup>
    <thead>
    <tr>
        <th class="centerth">序号</th>
        <th class="centerth">姓名</th>
        <th class="centerth">登记日期</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="contact" items="${listCcs}" varStatus="status">
        <tr onclick="contact.clickRow(this)" id="${contact.id}">
            <td>${status.index + 1}</</td>
            <td>${contact.closeName}</td>
            <td class="centertd"><fmt:formatDate value="${contact.registDt}" pattern="yyyy/MM/dd" /></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<table class="mini">
    <tr>
        <ehr:pagination-mini action="contact.search" colspan="3" />
    </tr>
</table>

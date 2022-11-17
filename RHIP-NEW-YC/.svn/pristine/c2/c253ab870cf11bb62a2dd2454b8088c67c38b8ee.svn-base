<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table id="ccList">
    <colgroup>
        <col style="width:10px"/>
        <col style="width:80px"/>
        <col style="width:30px"/>
    </colgroup>
    <thead>
    <tr>
        <th class="centerth">序号</th>
        <th class="centerth">调查描述</th>
        <th class="centerth">标签类型</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="surveyItem" items="${surveyItems}" varStatus="status">
        <tr onclick="items.clickRow(this)" id="${surveyItem.id}">
            <td>${surveyItem.orderNum}</</td>
            <td title="${surveyItem.description}">${surveyItem.description}</td>
            <td><ehr:dic code="${surveyItem.labelTypeCode}" dicmeta="LH00005"/> </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<table class="mini">
    <tr>
        <ehr:pagination-mini action="items.searchSurveyItem" colspan="3" />
    </tr>
</table>
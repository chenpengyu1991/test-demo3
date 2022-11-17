<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="repeattable" id="contactsList" style="width:300px; float: left;margin-right: 10px; margin-right: 10px;">
    <table id="ccList">
        <colgroup>
            <col style="width:50%"/>
            <col style="width:50%"/>
        </colgroup>
        <thead>
        <tr>
            <th class="centerth">随访医生</th>
            <th class="centerth">随访日期</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="fr" items="${frList}" varStatus="status">
            <tr onclick="filStandard.clickRow(this)" id="${fr.id}">
                <td><ehr:user userCode="${fr.visitById}"/></td>
                <td><fmt:formatDate value="${fr.visitDt}" pattern="yyyy/MM/dd" /></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <table class="mini">
        <tr>
            <ehr:pagination-mini action="filStandard.searchFollowUpList"/>
        </tr>
    </table>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div id="historyDiv">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="width: 12%;"/>
            <col style="width: 22%;"/>
            <col style="width: 18%;"/>
            <col style="width: 12%;"/>
            <col style="width: 10%;"/>
            <col style="width: 10%;"/>
        </colgroup>
        <thead>
        <tr>
            <th>姓名</th>
            <th>证件号码</th>
            <th>联系电话</th>
            <th>市民卡号</th>
            <th>更新日期</th>
            <th>状态</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="card" items="${healthCardList}" varStatus="status">
            <tr>
                <td class="centertd">${card.name}</td>
                <td class="centertd"><ehr:tip>${card.paperNo}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${card.phone}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${card.citizenCardNo}</ehr:tip></td>
                <td class="centertd"><ehr:tip><fmt:formatDate value="${card.updateDate}" pattern="yyyy/MM/dd"></fmt:formatDate></ehr:tip></td>
                <td class="centertd">
                    <c:if test="${card.cardStatus == '00'}">正常</c:if>
                    <c:if test="${card.cardStatus == '01'}">挂失</c:if>
                    <c:if test="${card.cardStatus == '02'}">冻结</c:if>
                    <c:if test="${card.cardStatus == '03'}">退卡</c:if>
                    <c:if test="${card.cardStatus == '04'}">换卡</c:if>
                    <c:if test="${card.cardStatus == '05'}">补卡</c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <input type="hidden" id="paperNo" value="${paperNo}">
    <input type="hidden" id="paperType" value="${paperType}">
    <table>
        <tr>
            <ehr:pagination action="healthCardSearch.searchHistory"/>
        </tr>
    </table>
</div>
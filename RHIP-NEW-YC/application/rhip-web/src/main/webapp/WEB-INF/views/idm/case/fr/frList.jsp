<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="repeattable" id="frListPart">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:120px;"/>
            <col style="width:220px;"/>
            <col style="width:70px;"/>
            <col style="width:70px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col/>
        </colgroup>
        <thead>
        <tr>
            <th rowspan="2" class="centerth">患者姓名</th>
            <th rowspan="2" class="centerth">家长姓名</th>
            <th rowspan="2" class="centerth">联系电话</th>
            <th rowspan="2" class="centerth">现  住  址</th>
            <th colspan="3" class="centerth">病例类型</th>
            <th rowspan="2" class="centerth">填报日期</th>
            <th rowspan="2" class="centerth">备注</th>
        </tr>
        <tr>
            <th  class="centerth">居家治疗</th>
            <th class="centerth">入院治疗</th>
            <th class="centerth">是否重症病例</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="fr" items="${frList}" varStatus="status">
            <tr onclick="frts.clickRow(this, 'fr')" id="${fr.id}">
                <td><ehr:tip>${fr.name}</ehr:tip></td>
                <td><ehr:tip>${fr.parentsName}</ehr:tip></td>
                <td><ehr:tip>${fr.phoneNumber}</ehr:tip></td>
                <td title="<ehr:dic dicmeta="FS990001" code="${fr.patownShip}"/><ehr:dic dicmeta="FS990001" code="${fr.pastreet}"/>${fr.pahouseNumber}"><ehr:dic dicmeta="FS990001" code="${fr.patownShip}"/><ehr:dic dicmeta="FS990001" code="${fr.pastreet}"/>${fr.pahouseNumber}
                </td>
                <td style="text-align: center"><c:if test="${fr.caseType == 1}">√</c:if></td>
                <td style="text-align: center"><c:if test="${fr.caseType == 2}">√</c:if></td>
                <td style="text-align: center"><c:if test="${fr.caseType == 3}">√</c:if></td>
                <td class="centertd"><ehr:tip><fmt:formatDate value="${fr.visitDt}" pattern="yyyy/MM/dd"/></ehr:tip></td>
                <td title="${fr.comments}">${fr.comments}</td>
            </tr>
        </c:forEach>
         <tr>
            <ehr:pagination action="frts.searchFrList" colspan="9"/>
        </tr>
        </tbody>
    </table>
    <%-- <table>
        <tr>
            <ehr:pagination action="frts.searchFrList"/>
        </tr>
    </table> --%>
</div>

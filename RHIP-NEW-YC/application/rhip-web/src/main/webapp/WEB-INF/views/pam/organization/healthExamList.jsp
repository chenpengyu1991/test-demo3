<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%--接种疫苗针次数--%>
<div class="repeattable">
    <table>
        <colgroup>
            <col style="min-width:80px;width: 20%;"/>
            <col style="min-width:80px;"/>
            <col style="min-width:80px;"/>
            <col style="min-width:80px;"/>
            <col style="min-width:80px;"/>
            <col style="min-width:80px;"/>
        </colgroup>
        <thead>
        <tr>
            <th>机构</th>
            <th>体检人次数</th>
            <th>B超人次数</th>
            <th>胸透人次数</th>
            <th>心电图人次数</th>
            <th>CT人次数</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="report" items="${summaryList}" varStatus="status">
            <tr>
                <td class="centertd"><ehr:org code="${report.ORGAN_CODE}"></ehr:org></td>
                <td class="centertd"><tags:numberLabel value="${report.HECOUNT}" defaultValue="0" align="center"/></td>
                <td class="centertd"><tags:numberLabel value="${report.BCCOUNT}" defaultValue="0" align="center"/></td>
                <td class="centertd"><tags:numberLabel value="${report.XTCOUNT}" defaultValue="0" align="center"/></td>
                <td class="centertd"><tags:numberLabel value="${report.XDTCOUNT}" defaultValue="0" align="center"/></td>
                <td class="centertd"><tags:numberLabel value="${report.CTCOUNT}" defaultValue="0" align="center"/></td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
</div>
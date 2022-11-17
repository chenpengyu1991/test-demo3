<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<%--医疗考核--%>
<div class="repeattable">
    <table>
        <colgroup>
        	<col style="min-width:160px;width: 20%;"/>
        	<col style="min-width:90px;width: 12%;"/>
        	<col style="min-width:100px;width: 17%;"/>
        	<col style="min-width:100px;width: 17%;"/>
        	<col style="min-width:100px;width: 17%;"/>
        	<col style="min-width:100px;width: 17%;"/>
        </colgroup>
        <thead>
        <tr>
            <th>医疗机构</th>
            <th>姓名</th>
            <th>挂号量</th>
            <th>处方量</th>
            <th>收费处方量</th>
            <th>平均处方金额</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="summary" items="${summaryList}" varStatus="status">
            <tr>
            	<td><ehr:tip><ehr:org  code="${summary.organCode}"/></ehr:tip></td>
                <td class="centertd">${summary.doctorName}</td>
                <td><tags:numberLabel value="${summary.registerNum}" defaultValue="0" align="center" /></td>
                <td><tags:numberLabel value="${summary.prescriptionNum}" defaultValue="0" align="center" /></td>
                <td><tags:numberLabel value="${summary.chargeNum}" defaultValue="0" align="center" /></td>
                <td><tags:numberLabel value="${summary.avgTotalCost}" fractionDigits="2" defaultValue="0" /></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <table>
        <tr>
            <c:if test="${!empty summaryList}">
                <ehr:pagination action="performanceSearch.search"/>
            </c:if>
        </tr>
    </table>
</div>
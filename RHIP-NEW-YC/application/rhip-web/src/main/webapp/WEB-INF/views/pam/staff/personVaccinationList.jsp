<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>


<%--妇幼保健指标--%>
<div class="repeattable">
    <table>
        <colgroup>
        </colgroup>
        <thead>
        <tr>
            <th>机构</th>
            <th>医生姓名</th>
            <th>医生身份证</th>
            <th>疫苗接种人次数</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="summary" items="${summaryList}" varStatus="status">
            <tr>
            	<td><ehr:tip><ehr:org code="${summary.organ_code}"/></ehr:tip></td>
                <td class="centertd">${summary.doctor_name}</td>
                <td class="centertd">${summary.doctor_idcard}</td>
                <td><tags:numberLabel value="${summary.vaccination_num}" defaultValue="0" align="center" /></td>

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
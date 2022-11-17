<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<%--糖尿病指标--%>
<div class="repeattable">
    <table>
        <colgroup>
        </colgroup>
        <thead>
        <tr>
            <th>姓名</th>
            <th>登记病人数</th>
            <th>随访人次数</th>
        </tr>
        </thead>
        <tbody><c:forEach var="summary" items="${summaryList}" varStatus="status">
            <tr>
                <td class="centertd"><ehr:user userCode="${summary.CREATE_DOCTOR_CODE}"></ehr:user></td>
                <td><tags:numberLabel value="${summary.mgntCount}" defaultValue="0" align="center" /></td>
                <td><tags:numberLabel value="${summary.visitCount}" defaultValue="0" align="center" /></td>
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
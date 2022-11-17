<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<%--人员培训指标--%>
<div class="repeattable">
    <table>
        <colgroup>
        </colgroup>
        <thead>
        <tr>
            <th>机构</th>
            <th>完成继续教育（学分）达标率 %</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="report" items="${summaryList}" varStatus="status">
            <tr>
                <td><ehr:org code="${report.ORGAN_CODE}"></ehr:org></td>
                <td class="centertd">
                    <tags:numberLabel value="${report.percent * 100}" defaultValue="0" align="center" fractionDigits="4"/>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
</div>
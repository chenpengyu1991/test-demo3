<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%--检查检验分析--%>
<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:80px;width: 15%;"/>
            <col style="min-width:50px;"/>
            <col style="min-width:50px;"/>
            <col style="min-width:50px;"/>
            <col style="min-width:50px;"/>
            <col style="min-width:50px;"/>
            <col style="min-width:50px;"/>
        </colgroup>
        <thead>
        <tr>
            <th>机构</th>
            <th>门诊检查收入</th>
            <th>门诊检验收入</th>
            <th>急诊检查收入</th>
            <th>急诊检验收入</th>
            <th>住院检查收入</th>
            <th>住院检验收入</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="report" items="${result}" varStatus="status">
            <tr>
                <td class="centertd"><ehr:tip>
                    <c:choose>
                        <c:when test="${not empty report.ORGAN_CODE}">
                            <ehr:org code="${report.ORGAN_CODE}"/>
                        </c:when>
                        <c:otherwise>
                            合计
                        </c:otherwise>
                    </c:choose>
                </ehr:tip></td>
                <td><tags:numberLabel value="${report.OUTPATIENT_CHECK_FEE}" defaultValue="0" /></td>
                <td><tags:numberLabel value="${report.OUTPATIENT_TEST_FEE}" defaultValue="0" /></td>
                <td><tags:numberLabel value="${report.EMERGENCY_CHECK_FEE}" defaultValue="0" /></td>
                <td><tags:numberLabel value="${report.EMERGENCY_TEST_FEE}" defaultValue="0" /></td>
                <td><tags:numberLabel value="${report.IN_HOS_CHECK_FEE}" defaultValue="0" /></td>
                <td><tags:numberLabel value="${report.IN_HOS_TEST_FEE}" defaultValue="0" /></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
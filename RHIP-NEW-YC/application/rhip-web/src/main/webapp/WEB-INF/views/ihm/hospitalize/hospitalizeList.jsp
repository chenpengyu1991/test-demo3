<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%--检查检验分析--%>
<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:80px;width: 20%;"/>
            <col style="min-width:50px;width: 30%;"/>
            <col style="min-width:50px;width: 30%;"/>
            <col style="min-width:50px;width: 20%;"/>
        </colgroup>
        <thead>
        <tr>
            <th>机构</th>
            <th>门诊和出院诊断符合数</th>
            <th>入院和出院诊断符合数</th>
            <th>术前和术后诊断符合数</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="report" items="${hospitalizeList}" varStatus="status">
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
                <td><tags:numberLabel value="${report.CLINIC_DIAG_ACCORD_NUM}" defaultValue="0" /></td>
                <td><tags:numberLabel value="${report.ADMIT_DIAG_ACCORD_NUM}" defaultValue="0" /></td>
                <td><tags:numberLabel value="${report.OPERATE_ACCORD_NUM}" defaultValue="0" /></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
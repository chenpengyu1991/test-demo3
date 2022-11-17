<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%--用药分析--%>
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
            <th>手术出院病人总费用数</th>
            <th>手术出院病人总费用药品费</th>
            <th>出院病人药品比例</th>
            <th>门急诊病人总费用</th>
            <th>门急诊病人药品收入</th>
            <th>门急诊病人药品比例</th>
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
                <td><tags:numberLabel value="${report.IN_HOS_FEE}" defaultValue="0" /></td>
                <td><tags:numberLabel value="${report.IN_HOS_MEDICINAL_FEE}" defaultValue="0" /></td>
                <td><tags:numberLabel value="${report.CY_YP_RATE}" defaultValue="0" fractionDigits="2" type="percent"/></td>
                <td><tags:numberLabel value="${report.MZ_TOTAL_FEE}" defaultValue="0"  /></td>
                <td><tags:numberLabel value="${report.MZ_YP_FEE}" defaultValue="0" /></td>
                <td><tags:numberLabel value="${report.MZ_YP_RATE}" defaultValue="0" fractionDigits="2" type="percent"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
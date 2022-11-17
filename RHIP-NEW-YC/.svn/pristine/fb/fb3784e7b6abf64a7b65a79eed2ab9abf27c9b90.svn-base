<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%--治疗结果分析--%>
<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:80px;width: 25%;"/>
            <col style="min-width:50px;width: 25%;"/>
            <col style="min-width:50px;width: 25%;"/>
            <col style="min-width:50px;width: 25%;"/>
        </colgroup>
        <thead>
        <tr>
            <th>机构</th>
            <th>门诊手术收入</th>
            <th>急诊手术收入</th>
            <th>住院手术收入</th>
            
        </tr>
        </thead>
        <tbody>
        <c:forEach var="report" items="${outpatientList}" varStatus="status">
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
                <td><tags:numberLabel value="${report.OUTPATIENT_OPERATION_FEE}" defaultValue="0" /></td>
                <td><tags:numberLabel value="${report.EMERGENCY_OPERATION_FEE}" defaultValue="0" /></td>
                <td><tags:numberLabel value="${report.IN_HOS_OPERATION_FEE}" defaultValue="0" /></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
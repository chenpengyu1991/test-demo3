<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%--治疗结果分析--%>
<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:80px;width: 20%;"/>
            <col style="min-width:50px;width: 16%;"/>
            <col style="min-width:50px;width: 16%;"/>
            <col style="min-width:50px;width: 16%;"/>
            <col style="min-width:50px;width: 16%;"/>
            <col style="min-width:50px;width: 16%;"/>
        </colgroup>
        <thead>
        <tr>
            <th>机构</th>
            <th>治愈人数</th>
            <th>好转人数</th>
            <th>抢救成功人次</th>
            <th>十日病死人数</th>
            <th>死亡人数</th>
            
        </tr>
        </thead>
        <tbody>
        <c:forEach var="report" items="${simpleDiseaseList}" varStatus="status">
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
                <td><tags:numberLabel value="${report.CURE_NUM}" defaultValue="0" /></td>
                <td><tags:numberLabel value="${report.IMPROVE_NUM}" defaultValue="0" /></td>
                <td><tags:numberLabel value="${report.RESCU_SUCCESS_NUM}" defaultValue="0" /></td>
                <td><tags:numberLabel value="${report.DIED_10DAY_NUM}" defaultValue="0" /></td>
                <td><tags:numberLabel value="${report.DEATH_NUM}" defaultValue="0" /></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
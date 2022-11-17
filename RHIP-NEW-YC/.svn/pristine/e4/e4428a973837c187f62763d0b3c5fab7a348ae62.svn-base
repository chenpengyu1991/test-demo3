<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%--检验结果统计分析--%>
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
            <col style="min-width:50px;"/>
            <col style="min-width:50px;"/>
            <col style="min-width:50px;"/>
            <col style="min-width:50px;"/>
            <col style="min-width:50px;"/>
            <col style="min-width:50px;"/>
        </colgroup>
        <thead>
        <tr>
            <th rowspan="2">机构</th>
            <th colspan="4">白细胞计数</th>
            <th colspan="4">红细胞计数</th>
            <th colspan="4">血小板计数</th>
            <th rowspan="2">乙型肝炎抗原检查人数</th>
            <th rowspan="2">乙型肝炎抗原阳性人数</th>
            <th rowspan="2">B超检查人次</th>
            <th rowspan="2">胸透检查人次</th>
            <th rowspan="2">心电图检查人次</th>
            <th rowspan="2">CT检查人次</th>
        </tr>
        <tr>
        <th>检验人次数</th>
        <th>偏低</th>
        <th>偏高</th>
        <th>检出率（%）</th>
        <th>检验人次数</th>
        <th>偏低</th>
        <th>偏高</th>
        <th>检出率（%）</th>
        <th>检验人次数</th>
        <th>偏低</th>
        <th>偏高</th>
        <th>检出率（%）</th>
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
                <td><tags:numberLabel value="${report.wbcNumber}" defaultValue="0" /></td>
                <td><tags:numberLabel value="${report.wbcLowNumber}" defaultValue="0" /></td>
                <td><tags:numberLabel value="${report.wbcHighNumber}" defaultValue="0" /></td>
                <td><tags:numberLabel value="${report.wbcRate}" defaultValue="0"  fractionDigits="2" type="percent"/></td>
                <td><tags:numberLabel value="${report.rbcNumber}" defaultValue="0" /></td>
                <td><tags:numberLabel value="${report.rbcLowNumber}" defaultValue="0" /></td>
                <td><tags:numberLabel value="${report.rbcHighNumber}" defaultValue="0" /></td>
                <td><tags:numberLabel value="${report.rbcRate}" defaultValue="0"  fractionDigits="2" type="percent"/></td>
                <td><tags:numberLabel value="${report.pltNumber}" defaultValue="0" /></td>
                <td><tags:numberLabel value="${report.pltLowNumber}" defaultValue="0" /></td>
                <td><tags:numberLabel value="${report.pltHighNumber}" defaultValue="0" /></td>
                <td><tags:numberLabel value="${report.pltRate}" defaultValue="0"  fractionDigits="2" type="percent"/></td>
                <td><tags:numberLabel value="${report.aaNumber}" defaultValue="0" /></td>
                <td><tags:numberLabel value="${report.aaPositiveNumber}" defaultValue="0" /></td>
                <td><tags:numberLabel value="${report.BUSNUM}" defaultValue="0"/></td>
                <td><tags:numberLabel value="${report.CXRNUM}" defaultValue="0"/></td>
                <td><tags:numberLabel value="${report.ECGNUM}" defaultValue="0"/></td>
                <td><tags:numberLabel value="${report.CTNUM}" defaultValue="0"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
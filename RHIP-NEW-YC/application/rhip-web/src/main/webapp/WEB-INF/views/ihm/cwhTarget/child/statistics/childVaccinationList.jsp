<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="repeattable">
    <table  class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:100px;width: 15%;"/>
            <col style="min-width:60px;"/>
            <col style="min-width:60px;"/>
            <col style="min-width:60px;"/>
            <col style="min-width:60px;"/>
            <col style="min-width:60px;"/>
            <col style="min-width:90px;"/>
            <col style="min-width:50px;"/>
            <col style="min-width:60px;"/>
            <col style="min-width:60px;"/>
            <col style="min-width:60px;"/>
        </colgroup>
        <thead>
        <tr>
            <th>镇</th>
            <th>乙肝疫苗(%)</th>
            <th>脊灰疫苗(%)</th>
            <th>百白破(%)</th>
            <th>流脑A(%)</th>
            <th>麻风疫苗(%)</th>
            <th>乙脑(减毒)(%)</th>
            <th>卡介苗(%)</th>
            <th>甲肝灭活(%)</th>
            <th>群流脑A+C(%)</th>
            <th>白破疫苗(%)</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="vaccination" items="${vaccinationList}" varStatus="status">
            <tr>
                <c:if test="${vaccination.GB_CODE ne 'grouping'}">
                    <td class="centertd">
                        <ehr:tip> <ehr:dic dicmeta="FS990001" code="${vaccination.GB_CODE}"/> </ehr:tip>
                    </td>
                    <td class="centertd"><ehr:tip><fmt:formatNumber value="${empty vaccination.HBV ? 0: vaccination.HBV}" type="number" pattern="0.00%"/></ehr:tip></td>
                    <td class="centertd"><ehr:tip><fmt:formatNumber value="${empty vaccination.JH ? 0: vaccination.JH}" type="number" pattern="0.00%"/></ehr:tip></td>
                    <td class="centertd"><ehr:tip><fmt:formatNumber value="${empty vaccination.BBP ? 0: vaccination.BBP}" type="number" pattern="0.00%"/></ehr:tip></td>
                    <td class="centertd"><ehr:tip><fmt:formatNumber value="${empty vaccination.LNA ? 0: vaccination.LNA}" type="number" pattern="0.00%"/></ehr:tip></td>
                    <td class="centertd"><ehr:tip><fmt:formatNumber value="${empty vaccination.MF ? 0: vaccination.MF}" type="number" pattern="0.00%"/></ehr:tip></td>
                    <td class="centertd"><ehr:tip><fmt:formatNumber value="${empty vaccination.YNJD ? 0: vaccination.YNJD}" type="number" pattern="0.00%"/></ehr:tip></td>
                    <td class="centertd"><ehr:tip><fmt:formatNumber value="${empty vaccination.MSF ? 0: vaccination.MSF}" type="number" pattern="0.00%"/></ehr:tip></td>
                    <td class="centertd"><ehr:tip><fmt:formatNumber value="${empty vaccination.JGMH ? 0: vaccination.JGMH}" type="number" pattern="0.00%"/></ehr:tip></td>
                    <td class="centertd"><ehr:tip><fmt:formatNumber value="${empty vaccination.QLNAC ? 0: vaccination.QLNAC}" type="number" pattern="0.00%"/></ehr:tip></td>
                    <td class="centertd"><ehr:tip><fmt:formatNumber value="${empty vaccination.BP ? 0: vaccination.BP}" type="number" pattern="0.00%"/></ehr:tip></td>
                </c:if>
                <c:if test="${vaccination.GB_CODE eq 'grouping'}">
                    <td class="centertd"><ehr:tip>总计</ehr:tip>
                    <td class="centertd"><ehr:tip><fmt:formatNumber value="${empty vaccination.HBV ? 0: vaccination.HBV/countNum}" type="number" pattern="0.00%"/></ehr:tip></td>
                    <td class="centertd"><ehr:tip><fmt:formatNumber value="${empty vaccination.JH ? 0: vaccination.JH/countNum}" type="number" pattern="0.00%"/></ehr:tip></td>
                    <td class="centertd"><ehr:tip><fmt:formatNumber value="${empty vaccination.BBP ? 0: vaccination.BBP/countNum}" type="number" pattern="0.00%"/></ehr:tip></td>
                    <td class="centertd"><ehr:tip><fmt:formatNumber value="${empty vaccination.LNA ? 0: vaccination.LNA/countNum}" type="number" pattern="0.00%"/></ehr:tip></td>
                    <td class="centertd"><ehr:tip><fmt:formatNumber value="${empty vaccination.MF ? 0: vaccination.MF/countNum}" type="number" pattern="0.00%"/></ehr:tip></td>
                    <td class="centertd"><ehr:tip><fmt:formatNumber value="${empty vaccination.YNJD ? 0: vaccination.YNJD/countNum}" type="number" pattern="0.00%"/></ehr:tip></td>
                    <td class="centertd"><ehr:tip><fmt:formatNumber value="${empty vaccination.MSF ? 0: vaccination.MSF/countNum}" type="number" pattern="0.00%"/></ehr:tip></td>
                    <td class="centertd"><ehr:tip><fmt:formatNumber value="${empty vaccination.JGMH ? 0: vaccination.JGMH/countNum}" type="number" pattern="0.00%"/></ehr:tip></td>
                    <td class="centertd"><ehr:tip><fmt:formatNumber value="${empty vaccination.QLNAC ? 0: vaccination.QLNAC/countNum}" type="number" pattern="0.00%"/></ehr:tip></td>
                    <td class="centertd"><ehr:tip><fmt:formatNumber value="${empty vaccination.BP ? 0: vaccination.BP/countNum}" type="number" pattern="0.00%"/></ehr:tip></td>

                </c:if>
                </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
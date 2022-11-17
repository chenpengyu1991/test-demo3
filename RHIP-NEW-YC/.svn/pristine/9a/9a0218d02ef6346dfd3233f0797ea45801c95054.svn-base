<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ page import="com.founder.rhip.mdm.common.OrgGenreCode" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<c:set var="HOSPITAL" value="<%=OrgGenreCode.HOSPITAL.getValue()%>" />
<c:set var="CENTRE" value="<%=OrgGenreCode.CENTRE.getValue()%>" />
<c:set var="STATION" value="<%=OrgGenreCode.STATION.getValue()%>" />

<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:60px;width: 15%;"/>
            <col style="min-width:40px;width: 10%;"/>
            <col style="min-width:40px;width: 10%;"/>
            <col style="min-width:40px;width: 8%;"/>
            <col style="min-width:40px;width: 8%;"/>
            <col style="min-width:40px;width: 9%;"/>
            <col style="min-width:40px;width: 10%;"/>
            <col style="min-width:100px;width: 10%;"/>
            <col style="min-width:40px;width: 10%;"/>
            <col style="min-width:100px;width: 10%;"/>
        </colgroup>
        <thead>
        <tr>
            <th rowspan="2">机构/区域</th>
            <th colspan="3">门急诊收费</th>
            <th rowspan="2">门急诊均次费用</th>
            <th rowspan="2">门急诊药占比</th>
            <th rowspan="2">门诊人次</th>
            <th rowspan="2">急诊人次</th>
            <th rowspan="2">输液处方比例</th>
            <th rowspan="2">抗生素比例</th>
        </tr>
        <tr>
            <th >医保</th>
            <th >个人</th>
            <th >合计</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="report" items="${reports}" varStatus="status">
            <tr>
                <c:choose>
                    <c:when test="${genreCode == '0' }">
                        <td>
                            <ehr:tip><ehr:dic code="${report.gb_code}" dicmeta="FS990001"/></ehr:tip>
                            <c:if test="${report.gb_code == '合计' || report.organ_code == '合计'}"> <b>合计</b> </c:if>
                        </td>
                    </c:when>

                    <c:otherwise>
                        <c:choose>
                            <c:when test="${report.gb_code == '合计' || report.organ_code == '合计'}">
                                <td class="centertd"><b>合计</b></td>
                            </c:when>
                            <c:when test="${report.gb_code == '小计' || report.organ_code == '小计'}">
                                <%--<td><ehr:tip><ehr:dic code="${report.gb_code}" dicmeta="FS990001"/></ehr:tip> </td>--%>
                                <%--<td><ehr:tip><ehr:org code="${report.center_code}"/></ehr:tip></td>--%>
                                <%--<td><b>小计</b></td>--%>
                            </c:when>
                            <c:otherwise>
                                <td><ehr:tip><ehr:org code="${report.organ_code}"/></ehr:tip></td>
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>
                <td ><tags:numberLabel value="${report.insurance_fee}" defaultValue="0" fractionDigits="2"/></td>
                <td ><tags:numberLabel value="${report.personal_fee}" defaultValue="0" fractionDigits="2"/></td>
                <td ><tags:numberLabel value="${report.all_fee}" defaultValue="0" fractionDigits="2"/></td>
                <td ><tags:numberLabel value="${report.arg_outp_emergency_fee}" defaultValue="0" fractionDigits="2"/></td>
                <td ><ehr:tip>
                    ${report.medicinal_fee_per}<c:if test="${report.medicinal_fee_per!=null}">%</c:if>
                    <c:if test="${report.medicinal_fee_per==null}">0.0%</c:if>
                </ehr:tip></td>

                <td ><ehr:tip>${report.outpatient_num}<c:if test="${report.outpatient_num==null}">0</c:if></ehr:tip></td>
                <td ><ehr:tip>${report.emergency_num}<c:if test="${report.emergency_num==null}">0</c:if></ehr:tip></td>
                <td><ehr:tip>${report.infusion_rate }<c:if test="${report.infusion_rate!=null}">‰</c:if>
                    <c:if test="${report.infusion_rate==null}">0.0‰</c:if></ehr:tip></td>
                <td><ehr:tip>${report.antibiotic_rate }<c:if test="${report.antibiotic_rate!=null}">‰</c:if>
                    <c:if test="${report.antibiotic_rate==null}">0.0‰</c:if></ehr:tip></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <table>
        <tr>
            <%-- <ehr:pagination action="statisticsSearch.search" /> --%>
        </tr>
    </table>
</div>
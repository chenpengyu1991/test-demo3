<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.idm.common.ReportStatus" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="width: 13%;"/>
            <col style="width: 8%;"/>
            <col style="width: 8%;"/>
            <col style="width: 9%;"/>
            <col style="width: 8%;"/>
            <col style="width: 8%;"/>
            <col style="width: 7%;"/>
            <col style="width: 7%;"/>
            <col style="width: 8%;"/>
            <col style="width: 10%;"/>
            <col style="width: 8%;"/>
            <col style="width: 10%;"/>
        </colgroup>
        <thead>
        <tr>
            <th rowspan="2">机构/乡镇</th>
            <th colspan="3">住院费用</th>
            <th rowspan="2">住院均次费用</th>
            <th rowspan="2">住院药占比</th>
            <th rowspan="2">住院人次</th>
            <th rowspan="2">出院人次</th>
            <th rowspan="2">手术人次</th>
            <th rowspan="2">人均出院占床日</th>
            <th rowspan="2">危重病人数</th>
            <th rowspan="2">抗菌药物使用率</th>
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
                    <%-- <td ><ehr:tip>${report.period}</ehr:tip></td> --%>
                <td ><ehr:tip>
                    <c:if test="${not empty report.in_insurance_fee}">
                        ${report.in_insurance_fee}
                    </c:if>

                    <c:if test="${empty report.in_insurance_fee}">
                        ${report.in_hos_fee-report.in_personal_fee}
                    </c:if>

                </ehr:tip></td>
                <td ><ehr:tip>${report.in_personal_fee}<c:if test="${report.in_personal_fee==null}">0</c:if></ehr:tip></td>
                <td ><ehr:tip>${report.in_hos_fee}<c:if test="${report.in_hos_fee==null}">0</c:if></ehr:tip></td>
                <td ><ehr:tip>${report.avg_fee}<c:if test="${report.avg_fee==null}">0</c:if></ehr:tip></td>
                <td ><ehr:tip>${report.medicinal_fee_per} <c:if test="${report.medicinal_fee_per!=null}">%</c:if>
                    <c:if test="${report.medicinal_fee_per==null}">0 %</c:if>
                </ehr:tip></td>
                <td ><ehr:tip>${report.in_hospital_num}<c:if test="${report.in_hospital_num==null}">0</c:if></ehr:tip></td>
                <td ><ehr:tip>${report.leave_hospital_num}<c:if test="${report.leave_hospital_num==null}">0</c:if></ehr:tip></td>

                <td ><ehr:tip>${report.inhosp_operate_num}<c:if test="${report.inhosp_operate_num==null}">0</c:if></ehr:tip></td>
                <td><tags:numberLabel value="${report.out_hosp_bed}"  defaultValue="0" fractionDigits="2"/></td>
                <td ><ehr:tip>${report.critical_ill_num}<c:if test="${report.critical_ill_num==null}">0</c:if></ehr:tip></td>
                <td><tags:numberLabel value="${report.antibacterial_rate}"  defaultValue="0" fractionDigits="2"/></td>
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
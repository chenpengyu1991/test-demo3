<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.mdm.common.OrgGenreCode" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<c:set var="HOSPITAL" value="<%=OrgGenreCode.HOSPITAL.getValue()%>" />
<c:set var="CENTRE" value="<%=OrgGenreCode.CENTRE.getValue()%>" />
<c:set var="STATION" value="<%=OrgGenreCode.STATION.getValue()%>" />

<div style="height: 400px;">
    <div class="repeattable">
        <div style="min-width: 1000px; width: 100%">
            <div id="ihmpatientlisttableTopDiv">
                <table class="layui-table x-admin-sm-table-list-middle">
                    <colgroup>
                        <col style="width: 100px;"/>
                        <col style="width: 60px;"/>
                        <col style="width: 60px;"/>
                        <%--<col style="width: 60px;"/>--%>
                        <col style="width: 60px;"/>
                        <col style="width: 60px;"/>
                        <col style="width: 60px;"/>
                        <col style="width: 60px;"/>
                        <col style="width: 60px;"/>
                        <col style="width: 60px;"/>
                        <col style="width: 60px;"/>
                    </colgroup>
                    <thead>
                    <tr>
                        <th rowspan="2">机构/乡镇</th>
                        <th colspan="3">住院费用</th>
                        <th rowspan="2">入院病人数</th>
                        <%--<th rowspan="2">在院病人数</th>--%>
                        <th rowspan="2">出院病人数</th>
                        <%--<th rowspan="2">住院人均工作量</th>--%>
                        <th rowspan="2">平均住院费用</th>
                        <th rowspan="2">平均住院日</th>
                        <th rowspan="2">出院病人手术数</th>
                        <th rowspan="2">出院病人麻醉数</th>
                    </tr>
                    <tr>
                        <th>个人费用</th>
                        <th>医疗保险金额</th>
                        <th>合计费用</th>
                    </tr>
                    </thead>
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
                                        <c:otherwise>
                                            <td><ehr:tip><ehr:org code="${report.organ_code}"/></ehr:tip></td>
                                        </c:otherwise>
                                    </c:choose>
                                </c:otherwise>
                            </c:choose>
                            <td ><ehr:tip>${report.in_personal_fee}<c:if test="${report.in_personal_fee==null}">0</c:if></ehr:tip></td>
                            <td >
                                <ehr:tip>
                                    <c:if test="${not empty report.in_insurance_fee}">
                                        ${report.in_insurance_fee}
                                    </c:if>
                                    <c:if test="${empty report.in_insurance_fee}">${report.in_hos_fee-report.in_personal_fee}</c:if>
                                </ehr:tip></td>
                            <td ><ehr:tip>${report.in_hos_fee}<c:if test="${report.in_hos_fee==null}">0</c:if></ehr:tip></td>
                            <td><tags:numberLabel value="${report.in_hospital_num}" defaultValue="0" /></td>
                                <%--<td><tags:numberLabel value="${report.sickbed_count}"  defaultValue="0" /></td>--%>
                            <td><tags:numberLabel value="${report.leave_hospital_num}" defaultValue="0" /></td>
                                <%--<td><tags:numberLabel value="${report.workload}"  defaultValue="0" fractionDigits="2"/></td>--%>
                            <td><tags:numberLabel value="${report.avg_fee}"  defaultValue="0" fractionDigits="2"/></td>
                            <td><tags:numberLabel value="${report.out_hosp_bed}"  defaultValue="0" fractionDigits="2"/></td>
                            <td><tags:numberLabel value="${report.inhosp_operate_num}" defaultValue="0" /></td>
                            <td><tags:numberLabel value="${report.anesthesia_num}" defaultValue="0" /></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
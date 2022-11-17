<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page import="com.founder.rhip.mdm.common.OrgGenreCode" %>
<c:set var="HOSPITAL" value="<%=OrgGenreCode.HOSPITAL.getValue()%>" />
<c:set var="CENTRE" value="<%=OrgGenreCode.CENTRE.getValue()%>" />
<c:set var="STATION" value="<%=OrgGenreCode.STATION.getValue()%>" />

<script src="${pageContext.request.contextPath}/js/views/ihm/idmTarget/abChartList.js" type="text/javascript"></script>
<div class="repeattable">
        <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <c:choose>
                <c:when test="${genreCode == '0' }">
                    <col style="min-width: 160px; width: 30%;"/>
                </c:when>
                <c:when test="${genreCode == HOSPITAL || genreCode == CENTRE}">
                    <col style="min-width: 160px; width: 15%;"/>
                    <col style="min-width: 160px; width: 15%;"/>
                </c:when>
                <c:when test="${genreCode == STATION}">
                    <col style="min-width: 160px; width: 10%;"/>
                    <col style="min-width: 160px; width: 10%;"/>
                    <col style="min-width: 160px; width: 10%;"/>
                </c:when>
            </c:choose>
            <col style="min-width:60px;"/>
            <col style="min-width:60px;"/>
            <%-- <col style="min-width:60px;"/> --%>
        </colgroup>
        <thead>
        <tr>
            <c:choose>
                <c:when test="${genreCode == '0' }">
                    <th>街道</th>
                </c:when>
                <c:when test="${genreCode == HOSPITAL || genreCode == CENTRE}">
                    <th colspan="2">医疗机构</th>
                </c:when>
                <c:when test="${genreCode == STATION}">
                    <th colspan="3">医疗机构</th>
                </c:when>
                <c:otherwise>
                    <th rowspan="2">医疗机构</th>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${genreCode == '0' }">
                    <th>ICD-10（A开头的疾病）</th>
                    <th>ICD-10（B开头的疾病）</th>
                   <!--  <th>近12个月发病趋势</th> -->
                </c:when>
                <c:otherwise>
                    <th rowspan="2">ICD-10（A开头的疾病）</th>
                    <th rowspan="2">ICD-10（B开头的疾病）</th>
                    <!-- <th rowspan="2">近12个月发病趋势</th> -->
                </c:otherwise>
            </c:choose>
        </tr>
        <c:if test="${genreCode != '0' }">
            <tr>
                <c:choose>
                    <c:when test="${genreCode == HOSPITAL}">
                        <th>街道</th>
                        <th>医院</th>
                    </c:when>
                    <c:when test="${genreCode == CENTRE}">
                        <th>街道</th>
                        <th>中心</th>
                    </c:when>
                    <c:when test="${genreCode == STATION}">
                        <th>街道</th>
                        <th>中心</th>
                        <th>站</th>
                    </c:when>
                </c:choose>
            </tr>
        </c:if>
        </thead>
        <tbody>
        <c:forEach var="report" items="${results}" varStatus="status">
            <tr>
                <c:choose>
                    <c:when test="${genreCode == '0' }">
                        <td><ehr:tip><ehr:dic code="${report.gbCode}" dicmeta="FS990001"/></ehr:tip>
                            <c:if test="${report.gbCode == '合计' || report.organCode == '合计'}"> <b>合计</b> </c:if>
                        </td>
                    </c:when>
                    <c:when test="${genreCode == HOSPITAL || genreCode == CENTRE}">
                        <c:choose>
                            <c:when test="${report.gbCode == '合计' || report.organCode == '合计'}">
                                <td colspan="2" class="centertd"><b>合计</b></td>
                            </c:when>
                            <c:when test="${report.gbCode == '小计' || report.organCode == '小计'}">
                                <td><ehr:tip><ehr:dic code="${report.gbCode}" dicmeta="FS990001"/></ehr:tip> </td>
                                <td><b>小计</b></td>
                            </c:when>
                            <c:otherwise>
                                <td><ehr:tip><ehr:dic code="${report.gbCode}" dicmeta="FS990001"/></ehr:tip> </td>
                                <td><ehr:tip><ehr:org code="${report.organCode}"/></ehr:tip></td>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:when test="${genreCode == STATION}">
                        <c:choose>
                            <c:when test="${report.gbCode == '合计' || report.organCode == '合计'}">
                                <td colspan="3" class="centertd"><b>合计</b></td>
                            </c:when>
                            <c:when test="${report.gbCode == '小计' || report.organCode == '小计'}">
                                <td><ehr:tip><ehr:dic code="${report.gbCode}" dicmeta="FS990001"/></ehr:tip> </td>
                                <td><ehr:tip><ehr:org code="${report.centerCode}"/></ehr:tip></td>
                                <td><b>小计</b></td>
                            </c:when>
                            <c:otherwise>
                                <td><ehr:tip><ehr:dic code="${report.gbCode}" dicmeta="FS990001"/></ehr:tip> </td>
                                <td><ehr:tip><ehr:org code="${report.centerCode}"/></ehr:tip></td>
                                <td><ehr:tip><ehr:org code="${report.organCode}"/></ehr:tip></td>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                </c:choose>
                <td class="centertd"><tags:numberLabel value="${report.aNum}" defaultValue="0" align="center"/></td>
                <td class="centertd"><tags:numberLabel value="${report.bNum}" defaultValue="0" align="center"/></td>
               <%--  <td class="centertd">
                    <c:choose>
                        <c:when test="${report.gbCode == '合计' || report.organCode == '合计'}"></c:when>
                        <c:when test="${report.gbCode == '小计' || report.organCode == '小计'}"></c:when>
                        <c:otherwise>
                            <a href="javascript:void(0)" onclick="abChartList.openChart('${report.organCode}','${report.gbCode}')"class="person-link-btn">发病趋势曲线</a>
                        </c:otherwise>
                    </c:choose>
                </td> --%>

                <%--<td class="centertd"><ehr:tip>${report.organCode}</ehr:tip></td>--%>
                <%--<td class="centertd"><tags:numberLabel value="${report.aNum}" defaultValue="0" align="center"/></td>--%>
                <%--<td class="centertd"><tags:numberLabel value="${report.bNum}" defaultValue="0" align="center"/></td>--%>
                <%--<td class="centertd">--%>
                    <%--&lt;%&ndash;<a class="idmDiseaseTypePopChart" href="javascript:void(0)">发病趋势曲线</a>&ndash;%&gt;--%>
                    <%--<a href="javascript:void(0)" onclick="abChartList.openChart('${report.organCode}')"class="person-link-btn">发病趋势曲线</a>--%>
                <%--</td>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

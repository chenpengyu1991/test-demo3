<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="com.founder.rhip.mdm.common.OrgGenreCode" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<script src="${pageContext.request.contextPath}/js/views/ihm/medicalTarget/hospitalCostsList.js"
        type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ihm/popChart.js" type="text/javascript"></script>
<c:set var="HOSPITAL" value="<%=OrgGenreCode.HOSPITAL.getValue()%>"/>
<c:set var="CENTRE" value="<%=OrgGenreCode.CENTRE.getValue()%>"/>
<c:set var="STATION" value="<%=OrgGenreCode.STATION.getValue()%>"/>

<div class="repeattable" style="overflow-x: auto;overflow-y: auto; min-width: 800px; width: 100%; height: 450px;">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <c:choose>
                <c:when test="${genreCode == '0' }">
                    <col style="width:150px;"/>
                </c:when>
                <c:when test="${genreCode == HOSPITAL || genreCode == CENTRE}">
                    <col style="width:120px;"/>
                    <col style="width:120px;"/>
                </c:when>
                <c:when test="${genreCode == STATION}">
                    <col style="width:80px;"/>
                    <col style="width:80px;"/>
                    <col style="width:80px;"/>
                </c:when>
                <c:otherwise>
                    <col style="width:150px;"/>
                </c:otherwise>
            </c:choose>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <%--<col style="width:80px;"/>
            <col style="width:80px;"/>--%>
        </colgroup>
        <thead>
        <tr>
            <c:choose>
                <c:when test="${genreCode == '0' }">
                    <th rowspan="2">镇</th>
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
            <th colspan="3">药品收入</th>
            <th colspan="11">收费分类统计</th>
            <%--<th rowspan="2">操作</th>--%>
        </tr>
        <tr>
            <c:choose>
                <c:when test="${genreCode == '0' }">
                </c:when>
                <c:when test="${genreCode == HOSPITAL}">
                    <th>镇</th>
                    <th>医院</th>
                </c:when>
                <c:when test="${genreCode == CENTRE}">
                    <th>镇</th>
                    <th>卫生院</th>
                </c:when>
                <c:when test="${genreCode == STATION}">
                    <th>镇</th>
                    <th>中心</th>
                    <th>站</th>
                </c:when>
                <c:otherwise>
                </c:otherwise>
            </c:choose>
            <th>中药</th>
            <th>中成药</th>
            <th>西药</th>
            <%--<th>耗材</th>--%>
            <th>诊查费</th>
            <th>检查费</th>
            <th>化验费</th>
            <th>放射费</th>
            <th>治疗费</th>
            <th>手术费</th>
            <th>输血费</th>
            <th>床位费</th>
            <th>护理费</th>
            <th>麻醉费</th>
            <th>其他</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="report" items="${reports}" varStatus="status">
            <tr>
                <c:choose>
                    <c:when test="${genreCode == '0' }">
                        <td>
                            <ehr:tip><ehr:dic code="${report.GB_CODE}" dicmeta="FS990001"/></ehr:tip>
                            <c:if test="${report.GB_CODE eq 'grouping'}"> <b>合计</b> </c:if>
                        </td>
                    </c:when>
                    <c:when test="${genreCode == HOSPITAL || genreCode == CENTRE}">
                        <c:choose>
                            <c:when test="${report.GB_CODE eq 'grouping' && report.ORGAN_CODE eq 'grouping'}">
                                <td colspan="2" class="centertd"><b>合计</b></td>
                            </c:when>
                            <c:when test="${report.GB_CODE ne 'grouping' && report.ORGAN_CODE eq 'grouping'}">
                                <td><ehr:tip><ehr:dic code="${report.GB_CODE}" dicmeta="FS990001"/></ehr:tip></td>
                                <td><b>合计</b></td>
                            </c:when>
                            <c:otherwise>
                                <td><ehr:tip><ehr:dic code="${report.GB_CODE}" dicmeta="FS990001"/></ehr:tip></td>
                                <td><ehr:tip><ehr:org code="${report.ORGAN_CODE}"/></ehr:tip></td>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:when test="${genreCode == STATION}">
                        <c:choose>
                            <c:when test="${report.GB_CODE eq 'grouping' && report.PARENT_CODE eq 'grouping' && report.ORGAN_CODE eq 'grouping'}">
                                <td colspan="3" class="centertd"><b>合计</b></td>
                            </c:when>
                            <c:when test="${report.GB_CODE ne 'grouping' && report.PARENT_CODE ne 'grouping' && report.ORGAN_CODE eq 'grouping'}">
                                <td><ehr:tip><ehr:dic code="${report.GB_CODE}" dicmeta="FS990001"/></ehr:tip></td>
                                <td><ehr:tip><ehr:org code="${report.PARENT_CODE}"/></ehr:tip></td>
                                <td><b>合计</b></td>
                            </c:when>
                            <c:when test="${report.GB_CODE ne 'grouping' && report.PARENT_CODE eq 'grouping' && report.ORGAN_CODE eq 'grouping'}">
                                <td><ehr:tip><ehr:dic code="${report.GB_CODE}" dicmeta="FS990001"/></ehr:tip></td>
                                <td colspan="2"><b>合计</b></td>
                            </c:when>
                            <c:otherwise>
                                <td><ehr:tip><ehr:dic code="${report.GB_CODE}" dicmeta="FS990001"/></ehr:tip></td>
                                <td><ehr:tip><ehr:org code="${report.PARENT_CODE}"/></ehr:tip></td>
                                <td><ehr:tip><ehr:org code="${report.ORGAN_CODE}"/></ehr:tip></td>
                            </c:otherwise>
                        </c:choose>

                    </c:when>
                </c:choose>
                <td data-type="1" data-is-data="true" data-total-level="中药" data-total="${report.chinese_medicine_fee}">
                    <tags:numberLabel value="${report.COST01}" fractionDigits="2" defaultValue="0"/></td>
                <td data-type="1" data-is-data="true" data-total-level="中成药" data-total="${report.medicine_fee}">
                    <tags:numberLabel value="${report.COST02}" fractionDigits="2" defaultValue="0"/></td>
                <td data-type="1" data-is-data="true" data-total-level="西药" data-total="${report.western_medicine_fee}">
                    <tags:numberLabel value="${report.COST03}" fractionDigits="2" defaultValue="0"/></td>
                <%--<td data-type="1" data-is-data="true" data-total-level="耗材" data-total="${report.consumables_fee}">
                    <tags:numberLabel value="${report.consumables_fee}" fractionDigits="2" defaultValue="0"/></td>--%>
                <td data-type="1" data-is-data="true" data-total-level="诊查费" data-total="${report.inspecting_fee}">
                    <tags:numberLabel value="${report.diagnosticAmount}" fractionDigits="2" defaultValue="0"/></td>
                <td data-type="1" data-is-data="true" data-total-level="检查费" data-total="${report.inspection_fee}">
                    <tags:numberLabel value="${report.inspectionAmount}" fractionDigits="2" defaultValue="0"/></td>
                <td data-type="1" data-is-data="true" data-total-level="化验费" data-total="${report.laboratory_fee}">
                    <tags:numberLabel value="${report.COST06}" fractionDigits="2" defaultValue="0"/></td>
                <td data-type="1" data-is-data="true" data-total-level="放射费" data-total="${report.radiation_fee}">
                    <tags:numberLabel value="${report.COST07}" fractionDigits="2" defaultValue="0"/></td>
                <td data-type="1" data-is-data="true" data-total-level="治疗费" data-total="${report.treatment_fee}">
                    <tags:numberLabel value="${report.COST08}" fractionDigits="2" defaultValue="0"/></td>
                <td data-type="1" data-is-data="true" data-total-level="手术费" data-total="${report.operation_fee}">
                    <tags:numberLabel value="${report.COST09}" fractionDigits="2" defaultValue="0"/></td>
                <td data-type="1" data-is-data="true" data-total-level="输血费" data-total="${report.blood_fee}">
                    <tags:numberLabel value="${report.COST10}" fractionDigits="2" defaultValue="0"/></td>
                <td data-type="1" data-is-data="true" data-total-level="床位费" data-total="${report.bed_fee}">
                    <tags:numberLabel value="${report.COST11}" fractionDigits="2" defaultValue="0"/></td>
                <td data-type="1" data-is-data="true" data-total-level="护理费" data-total="${report.nursing_fee}">
                    <tags:numberLabel value="${report.COST12}" fractionDigits="2" defaultValue="0"/></td>
                <td data-type="1" data-is-data="true" data-total-level="麻醉费" data-total="${report.anesthesia_fee}">
                    <tags:numberLabel value="${report.COST13}" fractionDigits="2" defaultValue="0"/></td>
                <td data-type="1" data-is-data="true" data-total-level="其他" data-total="${report.other_fee}">
                    <tags:numberLabel value="${report.COST99}" fractionDigits="2" defaultValue="0"/></td>
                <%--<td>
                    <c:if test="${(report.chinese_medicine_fee > 0 || report.medicine_fee >0 || report.western_medicine_fee>0 || report.inspecting_fee>0 || report.inspection_fee>0
 							|| report.laboratory_fee> 0 || report.radiation_fee>0 )}"><a class="ihmPopChart"
                                                                                          href="javascript:void(0)">图表</a></c:if>
                </td>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div id="ihm_pop" style="display:none">
    <div>
        <%-- 		<table>
                    <colgroup>
                        <col style="min-width:120px;width: 15%;"/>
                        <col style="min-width:400px;width: 85%;"/>
                    </colgroup>
                    <tr>
                        <td class="righttd">指标:</td>
                        <td>
                            <input type="radio" name="staticItem" id="staticItem01" value="1" class="checkboxGroup" checked="checked" onclick="hospitalCostsList.organData()"/><label for="staticItem01">收费分类图表</label>
                            <input type="radio" name="staticItem" id="staticItem02" value="2" class="checkboxGroup" onclick="hospitalCostsList.organData()"/><label for="staticItem02">基药图表</label>
                        </td>
                    </tr>
                </table> --%>
    </div>
    <div id="ihm_pop-chart-con" style="width: 800px;height:400px"></div>
</div>
<input type="hidden" id="chart_title" value="">
<input type="hidden" id="this_data" value="">
<input type="hidden" id="categories" value="">
<input type="hidden" id="seriesname" value="">
<input type="hidden" id="seriesname" value="">
<input type="hidden" id="yAxisText" value="">
<input type="hidden" id=orgName value="">

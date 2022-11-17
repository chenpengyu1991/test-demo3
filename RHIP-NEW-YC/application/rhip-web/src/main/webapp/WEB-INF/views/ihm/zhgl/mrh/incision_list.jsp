<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="com.founder.rhip.mdm.common.OrgGenreCode" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<c:set var="HOSPITAL" value="<%=OrgGenreCode.HOSPITAL.getValue()%>"/>
<c:set var="CENTRE" value="<%=OrgGenreCode.CENTRE.getValue()%>"/>
<c:set var="STATION" value="<%=OrgGenreCode.STATION.getValue()%>"/>
<div id='currentSearch'>
    <input type="hidden" id="resultGenreCode" value="${resultGenreCode}">
    <input type="hidden" id="resultOrganCode" value="${resultOrganCode}">
    <input type="hidden" id="resultSuperOrganCode" value="${resultSuperOrganCode}">
    <input type="hidden" id="resultGbCode" value="${resultGbCode}">
    <input type="hidden" id="resultRangeType" value="${resultRangeType}">
    <input type="hidden" id="resultMonthDate" value="${resultMonthDate}">
    <input type="hidden" id="resultRangeQuarter" value="${resultRangeQuarter}">
    <input type="hidden" id="resultQuarterDate" value="${resultQuarterDate}">
    <input type="hidden" id="resultYearType" value="${resultYearType}">
    <input type="hidden" id="resultYearDate" value="${resultYearDate}">
</div>
<div>
    <input type="hidden" id="chart_orgcode" value="">
    <input type="hidden" id="chart_title" value="">
    <input type="hidden" id="this_data" value="">
    <input type="hidden" id="categories" value="">
    <input type="hidden" id="seriesname" value="">
</div>
<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <c:choose>
                <c:when test="${genreCode == HOSPITAL || genreCode == CENTRE}">
                    <col style="min-width:120px;width: 9%;"/>
                    <col style="min-width:120px;width: 9%;"/>
                </c:when>
                <c:when test="${genreCode == STATION}">
                    <col style="min-width:80px;width: 6%;"/>
                    <col style="min-width:80px;width: 6%;"/>
                    <col style="min-width:80px;width: 6%;"/>
                </c:when>
                <c:otherwise>
                    <col style="min-width:100px;width: 18%;"/>
                </c:otherwise>
            </c:choose>
            <col style="min-width:80px;width: 9%;"/>
            <col style="min-width:80px;width: 9%;"/>
            <col style="min-width:80px;width: 9%;"/>
            <col style="min-width:80px;width: 9%;"/>
            <col style="min-width:80px;width: 9%;"/>
            <col style="min-width:80px;width: 9%;"/>
            <col style="min-width:80px;width: 9%;"/>
            <col style="min-width:80px;width: 9%;"/>
            <col style="min-width:80px;width: 9%;"/>
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
            <th rowspan="2">切口等级Ⅰ/愈合类型甲人次数</th>
            <th rowspan="2">切口等级Ⅰ/愈合类型乙人次数</th>
            <th rowspan="2">切口等级Ⅰ/愈合类型丙人次数</th>
            <th rowspan="2">切口等级Ⅱ/愈合类型甲人次数</th>
            <th rowspan="2">切口等级Ⅱ/愈合类型乙人次数</th>
            <th rowspan="2">切口等级Ⅱ/愈合类型丙人次数</th>
            <th rowspan="2">切口等级Ⅲ/愈合类型甲人次数</th>
            <th rowspan="2">切口等级Ⅲ/愈合类型乙人次数</th>
            <th rowspan="2">切口等级Ⅲ/愈合类型丙人次数</th>
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
        </tr>
        </thead>
        <tbody>
        <c:forEach var="report" items="${reports}" varStatus="status">
            <tr>
                <c:set var="gbGroup" value="${report.GB_CODE== 'grouping'}"></c:set>
                <c:set var="parentGroup" value="${report.PARENT_CODE== 'grouping'}"></c:set>
                <c:set var="organGroup" value="${report.ORGAN_CODE== 'grouping'}"></c:set>
                <c:set var="colCount" value="0"></c:set>
                <c:if test="${gbGroup}"><c:set var="colCount" value="${colCount+1}"></c:set></c:if>
                <c:if test="${parentGroup}"><c:set var="colCount" value="${colCount+1}"></c:set></c:if>
                <c:if test="${organGroup}"><c:set var="colCount" value="${colCount+1}"></c:set></c:if>
                <c:choose>
                    <c:when test="${gbGroup}">
                        <td colspan="${colCount}" class="centertd"><b><ehr:tip>合计</ehr:tip></b></td>
                    </c:when>
                    <c:when test="${parentGroup}">
                        <td><ehr:tip><ehr:dic dicmeta="FS990001" code="${report.GB_CODE}"/></ehr:tip></td>
                        <td colspan="${colCount}" class="centertd"><b><ehr:tip>合计</ehr:tip></b></td>
                    </c:when>
                    <c:when test="${organGroup}">
                        <td><ehr:tip><ehr:dic dicmeta="FS990001" code="${report.GB_CODE}"/></ehr:tip></td>
                        <c:if test="${genreCode != HOSPITAL && genreCode != CENTRE}">
                            <td><ehr:tip><ehr:org code="${report.PARENT_CODE}"/></ehr:tip></td>
                        </c:if>
                        <td class="centertd"><b><ehr:tip>合计</ehr:tip></b></td>
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${genreCode == HOSPITAL || genreCode == CENTRE}">
                                <c:if test="${not empty report.GB_CODE && !gbGroup}">
                                    <td><ehr:tip><ehr:dic dicmeta="FS990001" code="${report.GB_CODE}"/></ehr:tip></td>
                                </c:if>
                                <c:if test="${not empty report.ORGAN_CODE && !organGroup}">
                                    <td data-is-orgcode="true" data-orgcode="${report.ORGAN_CODE}"><ehr:tip><ehr:org
                                            code="${report.ORGAN_CODE}"/></ehr:tip></td>
                                </c:if>
                            </c:when>
                            <c:when test="${genreCode == STATION}">
                                <c:if test="${not empty report.GB_CODE && !gbGroup}">
                                    <td><ehr:tip><ehr:dic dicmeta="FS990001" code="${report.GB_CODE}"/></ehr:tip></td>
                                </c:if>
                                <c:if test="${not empty report.PARENT_CODE && !parentGroup}">
                                    <td><ehr:tip><ehr:org code="${report.PARENT_CODE}"/></ehr:tip></td>
                                </c:if>
                                <c:if test="${not empty report.ORGAN_CODE && !organGroup}">
                                    <td data-is-orgcode="true" data-orgcode="${report.ORGAN_CODE}"><ehr:tip><ehr:org
                                            code="${report.ORGAN_CODE}"/></ehr:tip></td>
                                </c:if>
                            </c:when>
                            <c:otherwise>
                                <c:if test="${not empty report.GB_CODE && !gbGroup}">
                                    <td data-is-orgcode="true" data-orgcode="${report.GB_CODE}"><ehr:tip><ehr:dic
                                            dicmeta="FS990001" code="${report.GB_CODE}"/></ehr:tip></td>
                                </c:if>
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>
                <td data-is-data="true" data-total-level="0" data-total="${report.ONE_A}"><tags:numberLabel
                        value="${report.ONE_A}" defaultValue="0"/></td>
                <td data-is-data="true" data-total-level="0" data-total="${report.ONE_B}"><tags:numberLabel
                        value="${report.ONE_B}" defaultValue="0"/></td>
                <td data-is-data="true" data-total-level="0" data-total="${report.ONE_C}"><tags:numberLabel
                        value="${report.ONE_C}" defaultValue="0"/></td>
                <td data-is-data="true" data-total-level="0" data-total="${report.TWO_A}"><tags:numberLabel
                        value="${report.TWO_A}" defaultValue="0"/></td>
                <td data-is-data="true" data-total-level="0" data-total="${report.TWO_B}"><tags:numberLabel
                        value="${report.TWO_B}" defaultValue="0"/></td>
                <td data-is-data="true" data-total-level="0" data-total="${report.TWO_C}"><tags:numberLabel
                        value="${report.TWO_C}" defaultValue="0"/></td>
                <td data-is-data="true" data-total-level="0" data-total="${report.THREE_A}"><tags:numberLabel
                        value="${report.THREE_A}" defaultValue="0"/></td>
                <td data-is-data="true" data-total-level="0" data-total="${report.THREE_B}"><tags:numberLabel
                        value="${report.THREE_B}" defaultValue="0"/></td>
                <td data-is-data="true" data-total-level="0" data-total="${report.THREE_C}"><tags:numberLabel
                        value="${report.THREE_C}" defaultValue="0"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

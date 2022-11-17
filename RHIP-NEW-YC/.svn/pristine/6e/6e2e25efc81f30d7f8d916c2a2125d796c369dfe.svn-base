<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.mdm.common.OrgGenreCode" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<c:set var="HOSPITAL" value="<%=OrgGenreCode.HOSPITAL.getValue()%>" />
<c:set var="CENTRE" value="<%=OrgGenreCode.CENTRE.getValue()%>" />
<div style="height: 400px;">
    <div class="repeattable">
    <div >
    <div id="dmlisttableTopDiv" class="paddingright17" style="overflow-x: scroll">
        <table class="layui-table x-admin-sm-table-list-middle" style="width: 2100px;">
            <colgroup>
                <col style="width: 60px;"/>
                <col style="width: 100px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
            </colgroup>
            <thead>
            <c:if test="${not empty reports}">
                <tr style="text-align: center;">
                    <td style="border:none;"></td>
                    <td style="border:none;" colspan="30">
                        <h1 style="font-size:150%;margin: 10px 0px 10px 0px">
                            <c:choose>
                                <c:when test="${not empty organCode}">
                                    <ehr:org  code="${organCode}"/>
                                </c:when>
                                <c:when test="${not empty gbCode}">
                                    <ehr:dic dicmeta="FS990001" code="${gbCode}"/>
                                </c:when>
                            </c:choose>
                            ${currentYear}年十八种住院重点疾病监测指标报表
                        </h1>
                    </td>
                    <td style="border:none;"></td>
                </tr>
            </c:if>
            <tr>
                <th rowspan="2">序号</th>
                <th rowspan="2">疾病名称</th>
                <th colspan="6">1季度</th>
                <th colspan="6">2季度</th>
                <th colspan="6">3季度</th>
                <th colspan="6">4季度</th>
                <th colspan="6">全年</th>
            </tr>
            <tr>
                <th>例数</th>
                <th>死亡</th>
                <th>15日内再住院率</th>
                <th>31日内再住院率</th>
                <th>日</th>
                <th>均费</th>
                <th>例数</th>
                <th>死亡</th>
                <th>15日内再住院率</th>
                <th>31日内再住院率</th>
                <th>日</th>
                <th>均费</th>
                <th>例数</th>
                <th>死亡</th>
                <th>15日内再住院率</th>
                <th>31日内再住院率</th>
                <th>日</th>
                <th>均费</th>
                <th>例数</th>
                <th>死亡</th>
                <th>15日内再住院率</th>
                <th>31日内再住院率</th>
                <th>日</th>
                <th>均费</th>
                <th>例数</th>
                <th>死亡</th>
                <th>15日内再住院率</th>
                <th>31日内再住院率</th>
                <th>日</th>
                <th>均费</th>
            </tr>
            </thead>
        </table>
        <table style="width: 2100px;" class="layui-table x-admin-sm-table-list-middle" >
            <colgroup>
                <col style="width: 60px;"/>
                <col style="width: 100px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
            </colgroup>
            <tbody>
                <c:set var="rowCountNum" value="1"></c:set>
                <c:forEach var="report" items="${reports}" varStatus="status">
                    <c:set var="rowCount" value="1"></c:set>

                    <c:if test="${(status.index + 1) == '3'}"> <c:set var="rowCount" value="2"></c:set></c:if>
                    <c:if test="${(status.index + 1) == '4'}"> <c:set var="rowCount" value="-1"></c:set></c:if>
                    <c:if test="${(status.index + 1) == '10'}"> <c:set var="rowCount" value="4"></c:set></c:if>
                    <c:if test="${(status.index + 1) == '11'}"> <c:set var="rowCount" value="-1"></c:set></c:if>
                    <c:if test="${(status.index + 1) == '12'}"> <c:set var="rowCount" value="-1"></c:set></c:if>
                    <c:if test="${(status.index + 1) == '13'}"> <c:set var="rowCount" value="-1"></c:set></c:if>
                    <tr>
                        <c:if test="${rowCount != '-1'}">
                            <td rowspan="${rowCount}" class="centertd"><ehr:tip>${rowCountNum}</ehr:tip></td>
                        </c:if>
                        <c:if test="${rowCount != '-1' || rowCount != '1'}">
                            <c:set var="rowCountNum" value="${rowCountNum + rowCount}"></c:set>
                        </c:if>
                        <td><ehr:tip>${report.diseases_name}</ehr:tip></td>
                        <td><tags:numberLabel value="${report.CASE_NUM_1}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.CASE_DEATH_NUM_1}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.FIFTEEN_RATE1}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.MONTH_RATE1}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.AVER_DAY1}" fractionDigits="2" defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.AVER_FEE1}"  fractionDigits="2" defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.CASE_NUM_2}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.CASE_DEATH_NUM_2}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.FIFTEEN_RATE2}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.MONTH_RATE2}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.AVER_DAY2}" fractionDigits="2" defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.AVER_FEE2}"  fractionDigits="2" defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.CASE_NUM_3}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.CASE_DEATH_NUM_3}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.FIFTEEN_RATE3}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.MONTH_RATE3}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.AVER_DAY3}" fractionDigits="2" defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.AVER_FEE3}"  fractionDigits="2" defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.CASE_NUM_4}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.CASE_DEATH_NUM_4}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.FIFTEEN_RATE4}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.MONTH_RATE4}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.AVER_DAY4}" fractionDigits="2" defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.AVER_FEE4}"  fractionDigits="2" defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.SUM_CASE_NUM}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.SUM_CASE_DEATH_NUM}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.SUM_FIFTEEN_RATE}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.SUM_MONTH_RATE}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.SUM_AVER_DAY}" fractionDigits="2" defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.SUM_AVER_FEE}"  fractionDigits="2" defaultValue="0" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <%-- <div class="paddingright17" id="dmlisttableDiv" style="overflow-x: scroll">
     <!-- <div id="dmlisttableDiv" class="contentfixed218" style="width: 2100px;overflow-x: auto; margin-left: -2px;"> -->
        <table style="width: 2100px;" class="layui-table x-admin-sm-table-list-middle" >
            <colgroup>
                <col style="width: 60px;"/>
                <col style="width: 100px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
                <col style="width: 60px;"/>
            </colgroup>
            <tbody>
                <c:set var="rowCountNum" value="1"></c:set>
                <c:forEach var="report" items="${reports}" varStatus="status">
                    <c:set var="rowCount" value="1"></c:set>

                    <c:if test="${(status.index + 1) == '3'}"> <c:set var="rowCount" value="2"></c:set></c:if>
                    <c:if test="${(status.index + 1) == '4'}"> <c:set var="rowCount" value="-1"></c:set></c:if>
                    <c:if test="${(status.index + 1) == '10'}"> <c:set var="rowCount" value="4"></c:set></c:if>
                    <c:if test="${(status.index + 1) == '11'}"> <c:set var="rowCount" value="-1"></c:set></c:if>
                    <c:if test="${(status.index + 1) == '12'}"> <c:set var="rowCount" value="-1"></c:set></c:if>
                    <c:if test="${(status.index + 1) == '13'}"> <c:set var="rowCount" value="-1"></c:set></c:if>
                    <tr>
                        <c:if test="${rowCount != '-1'}">
                            <td rowspan="${rowCount}" class="centertd"><ehr:tip>${rowCountNum}</ehr:tip></td>
                        </c:if>
                        <c:if test="${rowCount != '-1' || rowCount != '1'}">
                            <c:set var="rowCountNum" value="${rowCountNum + rowCount}"></c:set>
                        </c:if>
                        <td><ehr:tip>${report.diseases_name}</ehr:tip></td>
                        <td><tags:numberLabel value="${report.CASE_NUM_1}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.CASE_DEATH_NUM_1}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.FIFTEEN_RATE1}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.MONTH_RATE1}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.AVER_DAY1}" fractionDigits="2" defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.AVER_FEE1}"  fractionDigits="2" defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.CASE_NUM_2}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.CASE_DEATH_NUM_2}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.FIFTEEN_RATE2}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.MONTH_RATE2}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.AVER_DAY2}" fractionDigits="2" defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.AVER_FEE2}"  fractionDigits="2" defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.CASE_NUM_3}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.CASE_DEATH_NUM_3}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.FIFTEEN_RATE3}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.MONTH_RATE3}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.AVER_DAY3}" fractionDigits="2" defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.AVER_FEE3}"  fractionDigits="2" defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.CASE_NUM_4}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.CASE_DEATH_NUM_4}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.FIFTEEN_RATE4}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.MONTH_RATE4}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.AVER_DAY4}" fractionDigits="2" defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.AVER_FEE4}"  fractionDigits="2" defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.SUM_CASE_NUM}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.SUM_CASE_DEATH_NUM}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.SUM_FIFTEEN_RATE}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.SUM_MONTH_RATE}"  defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.SUM_AVER_DAY}" fractionDigits="2" defaultValue="0" /></td>
                        <td><tags:numberLabel value="${report.SUM_AVER_FEE}"  fractionDigits="2" defaultValue="0" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>  --%>
    </div>
    </div>
</div>
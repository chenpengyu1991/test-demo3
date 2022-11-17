<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<style>
    .repeattable table td {padding-left: 0; text-align: center}
</style>
<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
                <col style="min-width:70px;width: 7%;">
                <col style="min-width:60px;width: 4%;">
                <col style="min-width:30px;width: 3%;">
                <col style="min-width:30px;width: 3%;">
                <col style="min-width:140px;width: 15%;">
                <col style="min-width:100px;width: 4%;">
                <col style="min-width:100px;width: 4%;">
                <col style="min-width:30px;width: 4%;">
                <col style="min-width:30px;width: 4%;">
                <col style="min-width:30px;width: 4%;">
                <col style="min-width:30px;width: 4%;">
                <col style="min-width:30px;width: 4%;">
                <col style="min-width:60px;width: 8%;">
                <col style="min-width:80px;width: 12%;">
                <col style="min-width:60px;width: 5%;">
                <col style="min-width:60px;width: 9%;">
                <col style="min-width:60px;width: 6%;">
        </colgroup>
        <thead>
            <tr>
                <th rowspan="2" class="centerth">日期</th>
                <th rowspan="2" class="centerth">姓名</th>
                <th rowspan="2" class="centerth">性别</th>
                <th rowspan="2" class="centerth">年龄</th>
                <th rowspan="2" class="centerth">现住址</th>
                <th colspan="7" class="centerth">可疑症状</th>
                <th rowspan="2" class="centerth">病人来源</th>
                <th rowspan="2" class="centerth">胸透/胸片结果</th>
                <th rowspan="2" class="centerth">查痰结果</th>
                <th rowspan="2" class="centerth">初步诊断</th>
                <th rowspan="2" class="centerth">处理情况</th>
            </tr>
            <tr>
                <th class="centerth">咳嗽、咳痰≥2周</th>
                <th class="centerth">咳嗽、咳痰＜2周</th>
                <th class="centerth">咯血</th>
                <th class="centerth">发热</th>
                <th class="centerth">盗汗</th>
                <th class="centerth">胸痛</th>
                <th class="centerth">其他</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="suspect" items="${suspectList}" varStatus="status">
            <tr>
                <td><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${suspect.tbDto.modifySurveyDate}"/></ehr:tip></td>
                <td><ehr:tip>${suspect.tbDto.name}</ehr:tip></td>
                <td><ehr:tip><ehr:dic code="${suspect.tbDto.gender}" dicmeta="GBT226112003"/></ehr:tip></td>
                <td><ehr:tip>${suspect.tbDto.age}</ehr:tip></td>
                <td><ehr:tip><ehr:dic dicmeta="FS990001" code="${transfe.tbDtor.patownShip}"/><ehr:dic dicmeta="FS990001" code="${suspect.tbDto.pastreet}"/>${suspect.tbDto.pahouseNumber}</ehr:tip>
                </td>
                <td><c:if test="${fn:contains(suspect.tbDto.originalSymptom, '1')}">√</c:if></td>
                <td><c:if test="${fn:contains(suspect.tbDto.originalSymptom, '2')}">√</c:if></td>
                <td><c:if test="${fn:contains(suspect.tbDto.originalSymptom, '3')}">√</c:if></td>
                <td><c:if test="${fn:contains(suspect.tbDto.originalSymptom, '4')}">√</c:if></td>
                <td><c:if test="${fn:contains(suspect.tbDto.originalSymptom, '5')}">√</c:if></td>
                <td><c:if test="${fn:contains(suspect.tbDto.originalSymptom, '6')}">√</c:if></td>
                <td><c:if test="${fn:contains(suspect.tbDto.originalSymptom, '99')}">√</c:if></td>
                <td style="text-align: center"><ehr:tip><ehr:dic code="${suspect.tbDto.caseSource}" dicmeta="IDM00214"/></ehr:tip></td>
                <td style="text-align: center"><ehr:tip><ehr:dic code="${suspect.tbDto.chestXrays}" dicmeta="IDM00216"/></ehr:tip></td>
                <td style="text-align: center"><ehr:tip><ehr:dic code="${suspect.tbDto.phlegmPcr}" dicmeta="PH00004"/></ehr:tip></td>
                <td style="text-align: center"><ehr:tip><ehr:dic code="${suspect.tbDto.tentativeDiagnosis}" dicmeta="IDM00216"/></ehr:tip></td>
                <td style="text-align: center"><ehr:tip><ehr:dic code="${suspect.tbDto.handlingWay}" dicmeta="IDM00217"/></ehr:tip></td>
            </tr>
        </c:forEach>
        <tr>
            <ehr:pagination action="statistics.search" colspan="18"/>
        </tr>
        </tbody>
    </table>
</div>

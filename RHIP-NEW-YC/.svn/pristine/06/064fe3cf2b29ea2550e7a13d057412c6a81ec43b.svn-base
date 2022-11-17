<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable" id="tsListPart">
    <table id="tsList">
        <colgroup>
        	<col style="width:120px;"/>
            <col style="width:70px;"/>
            <col style="width:65px;"/>
            <col style="width:35px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:40px;"/>
            <col style="width:22px;"/>
            <col style="width:22px;"/>
            <col style="width:22px;"/>
            <col style="width:22px;"/>
            <col style="width:22px;"/>
            <col style="width:22px;"/>
            <col style="width:22px;"/>
            <col style="width:22px;"/>
            <col style="width:22px;"/>
            <col style="width:22px;"/>
            <col style="width:22px;"/>
            <col style="width:22px;"/>
            <col style="width:22px;"/>
            <col style="width:22px;"/>
            <col style="width:22px;"/>
            <col style="width:70px;"/>
        </colgroup>
        <thead>
        <tr>
        	<th rowspan="2" class="centerth">单位名称</th>
            <th rowspan="2" class="centerth">病例编号</th>
            <th rowspan="2" class="centerth">患者姓名</th>
            <th rowspan="2" class="centerth">性别</th>
            <th rowspan="2" class="centerth">出生年月</th>
            <th rowspan="2" class="centerth">发病日期</th>
            <th rowspan="2" class="centerth">就诊日期</th>
            <th rowspan="2" class="centerth">采样日期</th>
            <th rowspan="2" class="centerth">体温℃</th>
            <th rowspan="2" class="centerth">门<br>诊<br>病<br>例</th>
            <th rowspan="2" class="centerth">住<br>院<br>病<br>例</th>
            <th colspan="5" class="centerth">临床诊断</th>
            <th colspan="8" class="centerth">标本种类</th>
            <th rowspan="2" class="centerth">实验室结果</th>
        </tr>
        <tr>
            <th class="centerth" style="line-height: 18px;">手<br>足<br>口<br>病</th>
            <th class="centerth" style="line-height: 18px;">疱<br>疹<br>性<br>咽<br>峡<br>炎</th>
            <th class="centerth" style="line-height: 18px;">无<br>菌<br>性<br>脑<br>膜<br>炎</th>
            <th class="centerth" style="line-height: 18px;">脑<br>干<br>脑<br>炎</th>
            <th class="centerth" style="line-height: 18px;">其<br>他</th>
            <th class="centerth" style="line-height: 18px;">咽<br>拭<br>子</th>
            <th class="centerth" style="line-height: 18px;">疱<br>内<br>渗<br>出<br>液</th>
            <th class="centerth" style="line-height: 18px;">粪<br>便</th>
            <th class="centerth" style="line-height: 18px;">肛<br>拭<br>子</th>
            <th class="centerth" style="line-height: 18px;">脑<br>脊<br>液</th>
            <th class="centerth" style="line-height: 18px;">急<br>性<br>期<br>血<br>清</th>
            <th class="centerth" style="line-height: 18px;">恢<br>复<br>期<br>血<br>清</th>
            <th class="centerth" style="line-height: 18px;">其<br>它</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="ts" items="${tsList}" varStatus="status">
            <tr id="${ts.id}">
            	<td><ehr:tip><ehr:org code="${ts.createUnit}"/></ehr:tip></td>
                <td><ehr:tip>${ts.mediRecordNum}</ehr:tip></td>
                <td><ehr:tip>${ts.name}</ehr:tip></td>
                <td class="centertd"><ehr:dic dicmeta="GBT226112003" code="${ts.gender}"/></td>
                <td class="centertd"><fmt:formatDate value="${ts.birthday}" pattern="yyyy/MM/dd"/></td>
                <td class="centertd"><fmt:formatDate value="${ts.attackDt}" pattern="yyyy/MM/dd"/></td>
                <td class="centertd"><fmt:formatDate value="${ts.treatDt}" pattern="yyyy/MM/dd"/></td>
                <td class="centertd"><fmt:formatDate value="${ts.sampleDt}" pattern="yyyy/MM/dd"/></td>
                <td><ehr:tip>${ts.temperature}</ehr:tip></td>
                <td class="centertd"><c:if test="${ts.outpatient == 1}">√</c:if></td>
                <td class="centertd"><c:if test="${ts.hospitalization == 1}">√</c:if></td>
                <td class="centertd"><c:if test="${ts.diagnosisHfmd == 1}">√</c:if></td>
                <td class="centertd"><c:if test="${ts.diagnosisAngina == 1}">√</c:if></td>
                <td class="centertd"><c:if test="${ts.diagnosisMeningitis == 1}">√</c:if></td>
                <td class="centertd"><c:if test="${ts.diagnosisEncephalitis == 1}">√</c:if></td>
                <td class="centertd"><c:if test="${ts.diagnosisOther == 1}">√</c:if></td>
                <td class="centertd"><c:if test="${ts.throatSwab == 1}">√</c:if></td>
                <td class="centertd"><c:if test="${ts.percolate == 1}">√</c:if></td>
                <td class="centertd"><c:if test="${ts.excrement == 1}">√</c:if></td>
                <td class="centertd"><c:if test="${ts.anusSwab == 1}">√</c:if></td>
                <td class="centertd"><c:if test="${ts.csf == 1}">√</c:if></td>
                <td class="centertd"><c:if test="${ts.acuteSerum == 1}">√</c:if></td>
                <td class="centertd"><c:if test="${ts.convalescentSerum == 1}">√</c:if></td>
                <td class="centertd"><c:if test="${ts.other == 1}">√</c:if></td>
                <td title="${ts.labResult}">${ts.labResult}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <table>
        <tr>
            <ehr:pagination action="takeSampleSearch.searchTakeSample"/>
        </tr>
    </table>
</div>

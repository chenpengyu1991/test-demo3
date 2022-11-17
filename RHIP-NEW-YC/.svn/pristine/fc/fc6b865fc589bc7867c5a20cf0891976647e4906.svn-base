<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<style>
    .repeattable table td {padding-left: 0; text-align: center}
</style>
<div class="repeattable">
    <table>
        <colgroup>
            <col style="min-width:20px; width: 4%;"/>
            <col style="min-width:60px; width: 9%;"/>
            <col style="min-width:20px; width: 4%;"/>
            <col style="min-width:20px; width: 4%;"/>
            <col style="min-width:85px; width: 12%;"/>
            <col style="min-width:60px; width: 9%;"/>
            <col style="min-width:35px; width: 12%;"/>
            <col style="min-width:40px; width: 12%;"/>
            <col style="min-width:35px; width: 3%;"/>
            <col style="min-width:35px; width: 15%;"/>
            <col style="min-width:35px; width: 8%;"/>
            <col style="min-width:45px; width: 8%;"/>
        </colgroup>
        <thead>
            <tr>
                <th rowspan="2">序号</th>
                <th rowspan="2" class="centerth">密切接触者姓名</th>
                <th rowspan="2" class="centerth">性别</th>
                <th rowspan="2" class="centerth">年龄</th>
                <th rowspan="2" class="centerth">详细住址</th>
                <th colspan="3" class="centerth">接触的现症麻风病人信息</th>
                <th colspan="2" class="centerth">麻风病阳性体症</th>
                <th rowspan="2" class="centerth">检查医生姓名</th>
                <th rowspan="2" class="centerth">检查日期</th>
            </tr>
            <tr>
                <th class="centerth">姓名</th>
                <th class="centerth">所在县区</th>
                <th class="centerth">与接触者关系</th>
                <th class="centerth">无</th>
                <th class="centerth">如有，初步诊断结果</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="cc" items="${ccList}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td><ehr:tip>${cc.closeName}</ehr:tip></td>
                <td><ehr:tip><ehr:dic code="${cc.sex}" dicmeta="GBT226112003"/></ehr:tip></td>
                <td><ehr:tip>${cc.age}</ehr:tip></td>
                <td><ehr:tip>${cc.address}</ehr:tip></td>
                <td><ehr:tip>${cc.patientName}</ehr:tip></td>
                <td><ehr:tip><ehr:dic code="${cc.acceptTown}" dicmeta="FS990001"/> </ehr:tip></td>
                <td><ehr:dic code="${cc.closeType}" dicmeta="IDM00249"/> </td>
                <td><ehr:tip><c:if test="${cc.positiveSigns == '2'}">√</c:if></ehr:tip></td>
                <td><ehr:tip>${cc.diagnosisResultDetail}</ehr:tip></td>
                <td><ehr:tip>${cc.dorctorName}</ehr:tip></td>
                <td><ehr:tip><fmt:formatDate value="${cc.registDt}" pattern="yyyy/MM/dd"/></ehr:tip></td>
            </tr>
        </c:forEach>
        <tr>
            <ehr:pagination action="statistics.search" colspan="13"/>
        </tr>
        </tbody>
    </table>
</div>

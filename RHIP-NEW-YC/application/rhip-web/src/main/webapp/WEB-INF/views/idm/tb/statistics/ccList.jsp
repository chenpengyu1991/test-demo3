<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<style>
    .repeattable table td {padding-left: 0; text-align: center}
</style>
<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="width:55px;"/>
            <col style="width:60px;"/>
            <col style="width:55px;"/>
            <col style="width:35px;"/>
            <col style="width:35px;"/>
            <col style="width:35px;"/>
            <col style="width:35px;"/>
            <col style="width:60px;"/>
            <col style="width:35px;"/>
            <col style="width:35px;"/>
            <col style="width:35px;"/>
            <col style="width:45px;"/>
            <col style="width:35px;"/>
            <col style="width:60px;"/>
            <col style="width:70px;"/>
        </colgroup>
        <thead>
            <tr>
                <th colspan="2">涂阳患者</th>
                <th colspan="3" class="centerth">接触者</th>
                <th colspan="2" class="centerth">接触者类型</th>
                <th colspan="3" class="centerth">筛查</th>
                <th colspan="3" class="centerth">检查日期及结果</th>
                <th rowspan="3" class="centerth">诊断</th>
                <th rowspan="3" class="centerth">新确诊患者登记号</th>
            </tr>
            <tr>
                <th rowspan="2" class="centerth">姓名</th>
                <th rowspan="2" class="centerth">登记号</th>

                <th rowspan="2" class="centerth">姓名</th>
                <th rowspan="2" class="centerth">性别</th>
                <th rowspan="2" class="centerth">年龄</th>

                <th rowspan="2" class="centerth">家属</th>
                <th rowspan="2" class="centerth">非家属</th>
                <th rowspan="2" class="centerth">日期</th>
                <th colspan="2" class="centerth">症状</th>

                <th rowspan="2" class="centerth">PPD</th>
                <th rowspan="2" class="centerth">X光片</th>
                <th rowspan="2" class="centerth">痰涂片</th>

            </tr>
            <tr>
                <th class="centerth">有</th>
                <th class="centerth">无</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="cc" items="${ccList}" varStatus="status">
            <tr>
                <td><ehr:tip>${cc.patientName}</ehr:tip></td>
                <td><ehr:tip>${cc.registNo}</ehr:tip></td>
                <td><ehr:tip>${cc.closeName}</ehr:tip></td>
                <td><ehr:tip><ehr:dic code="${cc.sex}" dicmeta="GBT226112003"/></ehr:tip></td>
                <td><ehr:tip>${cc.age}</ehr:tip></td>
                <td><ehr:tip><c:if test="${cc.closeType == '1'}">√</c:if></ehr:tip></td>
                <td><ehr:tip><c:if test="${cc.closeType == '2'}">√</c:if></ehr:tip></td>
                <td><ehr:tip><fmt:formatDate value="${cc.checkDt}" pattern="yyyy/MM/dd"/></ehr:tip></td>
                <td><ehr:tip><c:if test="${cc.checkSympton == '1'}">√</c:if></ehr:tip></td>
                <td><ehr:tip><c:if test="${cc.checkSympton == '2'}">√</c:if></ehr:tip></td>
                <td><ehr:tip><ehr:dic code="${cc.ppd}" dicmeta="CV0300404"/></ehr:tip></td>
                <td><ehr:tip><ehr:dic code="${cc.x}" dicmeta="FS10039"/></ehr:tip></td>
                <td><ehr:tip><ehr:dic code="${cc.pic}" dicmeta="PH00022"/></ehr:tip></td>
                <td><ehr:tip><ehr:dic code="${cc.diagnosisResult}" dicmeta="IDM00254"/></ehr:tip></td>
                <td><ehr:tip>${cc.newRegistNo}</ehr:tip></td>
            </tr>
        </c:forEach>
        <tr>
            <ehr:pagination action="statistics.search" colspan="15"/>
        </tr>
        </tbody>
    </table>
</div>

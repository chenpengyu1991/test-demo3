<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<style>
    .repeattable table td {padding-left: 0; text-align: center}
</style>
<div class="repeattable" >
    <table>
        <colgroup>
            <col style="width:40px; width: 4%;"/>
            <col style="width:80px; width: 8%;"/>
            <col style="width:40px; width: 4%;"/>
            <col style="min-width:120px; width: 16%;"/>
            <col style="width:30px; width: 4%;"/>
            <col style="width:100px; width: 8%;"/>
            <col style="width:40px; width: 4%;"/>
            <col style="width:40px; width: 4%;"/>
            <col style="width:40px; width: 4%;"/>
            <col style="width:40px; width: 4%;"/>
            <col style="width:40px; width: 4%;"/>
            <col style="width:40px; width: 12%;"/>
            <col style="width:80px; width: 12%;"/>
            <col style="width:60px; width: 12%;"/>
        </colgroup>
        <thead>
            <tr>
                <th rowspan="2">序号</th>
                <th rowspan="2" class="centerth">患者姓名</th>
                <th rowspan="2" class="centerth">性别</th>
                <th rowspan="2" class="centerth">详细住址</th>
                <th colspan="2" class="centerth">麻风反应</th>
                <th colspan="6" class="centerth">溃疡</th>
                <th rowspan="2" class="centerth">检查医生姓名</th>
                <th rowspan="2" class="centerth">随访日期</th>
            </tr>
            <tr>
                <th class="centerth">无</th>
                <th class="centerth">如有，麻风反应</th>
                <th class="centerth">手</th>
                <th class="centerth">小腿</th>
                <th class="centerth">踝</th>
                <th class="centerth">足底</th>
                <th class="centerth">趾</th>
                <th class="centerth">其它</th>

            </tr>
        </thead>
        <tbody>
        <c:forEach var="fr" items="${frList}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td><ehr:tip>${fr.name}</ehr:tip></td>
                <td><ehr:tip><ehr:dic code="${fr.gender}" dicmeta="GBT226112003"/></ehr:tip></td>
                <td><ehr:tip>${fr.paAddress}</ehr:tip></td>
                <td><ehr:tip><c:if test="${fr.leprosy == '2'}">√</c:if></ehr:tip></td>
                <td><ehr:dic code="${fr.leprosyType}" dicmeta="IDM00317"/> </td>
                <td><ehr:tip><ehr:dic code="${fr.ulcerHand}" dicmeta="IDM00280"/> </ehr:tip></td>
                <td><ehr:tip><ehr:dic code="${fr.ulcerLeg}" dicmeta="IDM00280"/></ehr:tip></td>
                <td><ehr:tip><ehr:dic code="${fr.ulcerAnkle}" dicmeta="IDM00280"/></ehr:tip></td>
                <td><ehr:tip><ehr:dic code="${fr.ulcerFoot}" dicmeta="IDM00280"/></ehr:tip></td>
                <td><ehr:tip><ehr:dic code="${fr.ulcerToe}" dicmeta="IDM00280"/></ehr:tip></td>
                <td><ehr:tip>${fr.ulcerOther}</ehr:tip></td>
                <td><ehr:tip><ehr:user userCode="${fr.checkUser}"/> </ehr:tip></td>
                <td><ehr:tip><fmt:formatDate value="${fr.visitDt}" pattern="yyyy/MM/dd"/></ehr:tip></td>
            </tr>
        </c:forEach>
        <tr>
            <ehr:pagination action="statistics.search" colspan="15"/>
        </tr>
        </tbody>
    </table>
</div>

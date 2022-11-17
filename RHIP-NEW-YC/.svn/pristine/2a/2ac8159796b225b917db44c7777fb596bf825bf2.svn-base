<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="repeattable" id="transferListPart">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:80px;width: 10%;"/>
            <col style="min-width:50px;width: 10%;"/>
            <col style="min-width:50px;width: 10%;"/>
            <col style="min-width:160px;width: 20%;"/>
            <col style="min-width:110px;width: 15%;"/>
            <col style="min-width:95px;width: 15%;"/>
            <col style="min-width:80px;width: 10%;"/>
            <col style="min-width:80px;width: 10%;"/>
            <col/>
        </colgroup>
        <thead>
            <tr>
                <th class="centerth">病人姓名</th>
                <th class="centerth">性别</th>
                <th class="centerth">年龄</th>
                <th class="centerth">现住址</th>
                <th class="centerth">电话</th>
                <th class="centerth">转诊原因</th>
                <th class="centerth">转诊医师</th>
                <th class="centerth">转诊日期</th>
                <%--<th class="centerth">备注</th>--%>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="transfer" items="${transferList}" varStatus="status">
            <tr>
                <td><ehr:tip>${transfer.tbDto.name}</ehr:tip></td>
                <td class="centertd"><ehr:tip><ehr:dic code="${transfer.tbDto.gender}" dicmeta="GBT226112003"/></ehr:tip></td>
                <td class="centertd"><ehr:tip>${transfer.tbDto.age}</ehr:tip></td>
                <td><ehr:tip><ehr:dic dicmeta="FS990001" code="${transfe.tbDtor.patownShip}"/><ehr:dic dicmeta="FS990001" code="${transfer.tbDto.pastreet}"/>${transfer.tbDto.pahouseNumber}</ehr:tip>
                </td>
                <td><ehr:tip>${transfer.tbDto.phoneNumber}</ehr:tip></td>
                <td><ehr:tip><ehr:dic code="${transfer.tbDto.diagnosisReason}" dicmeta="IDM00218"/></ehr:tip></td>
                <td><ehr:tip><ehr:user userCode="${transfer.tbDto.transferTreatmentDoctor}"/></ehr:tip></td>
                <td class="centertd"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${transfer.tbDto.transferTreatmentDt}"/></ehr:tip></td>
                <%--<td></td>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <table>
        <tr>
            <ehr:pagination action="statistics.search"/>
        </tr>
    </table>
</div>

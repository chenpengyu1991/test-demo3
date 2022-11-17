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
            <col style="width:60px;"/>
            <col style="width:35px;"/>
            <col style="width:60px;"/>
            <col style="width:180px;"/>
            <col style="width:60px;"/>
            <col style="width:80px;"/>
            <col style="width:190px;"/>
            <col style="width:80px;"/>
            <col style="width:40px;"/>
            <col style="width:40px;"/>
            <col style="width:40px;"/>
            <col style="width:40px;"/>
            <col style="width:60px;"/>
            <col style="width:80px;"/>
        </colgroup>
        <thead>
            <tr>
                <th rowspan="2" class="centerth">姓名</th>
                <th rowspan="2" class="centerth">性别</th>
                <th rowspan="2" class="centerth">年龄(周岁)</th>
                <th rowspan="2" class="centerth">现住址</th>
                <th rowspan="2" class="centerth">病人分类</th>
                <th rowspan="2" class="centerth">始治日期</th>
                <th rowspan="2" class="centerth">治疗方案</th>
                <th rowspan="2" class="centerth">管理方式</th>
                <th colspan="4" class="centerth">查痰结果</th>
                <th rowspan="2" class="centerth">转归</th>
                <th rowspan="2" class="centerth">转归日期</th>
            </tr>
            <tr>
                <th class="centerth">第2月</th>
                <th class="centerth">第5月</th>
                <th class="centerth">第6月</th>
                <th class="centerth">第8月</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="mgnt" items="${mgntList}" varStatus="status">
            <tr>
                <td><ehr:tip>${mgnt.tbDto.name}</ehr:tip></td>
                <td><ehr:tip><ehr:dic code="${mgnt.tbDto.gender}" dicmeta="GBT226112003"/></ehr:tip></td>
                <td><ehr:tip>${mgnt.tbDto.age}</ehr:tip></td>
                <td><ehr:tip><ehr:dic dicmeta="FS990001" code="${mgnt.tbDto.patownShip}"/><ehr:dic dicmeta="FS990001" code="${mgnt.tbDto.pastreet}"/>${mgnt.tbDto.pahouseNumber}</ehr:tip>
                </td>
                <td style="text-align: center"><ehr:tip>
                    <c:if test="${mgnt.tbDto.thisType == '1'}"><ehr:dic dicmeta="IDM00248" code="${mgnt.tbDto.thisType}"/></c:if>
                    <c:if test="${mgnt.tbDto.thisType == '99'}"><ehr:dic dicmeta="IDM00241" code="${mgnt.tbDto.thisTypeF}"/></c:if>
                </ehr:tip></td>
                <td><ehr:tip><fmt:formatDate value="${mgnt.tbDto.thisDt}" pattern="yyyy/MM/dd"/></ehr:tip></td>
                <td><ehr:tip>
                    <c:if test="${mgnt.tbDto.chemotherapy == '1'}"><ehr:dic dicmeta="IDM00222" code="${mgnt.tbDto.chemotherapy}"/>&nbsp;<ehr:dic dicmeta="IDM00330" code="${mgnt.tbDto.chemotherapyF}"/></c:if>
                    <c:if test="${mgnt.tbDto.chemotherapy == '2'}"><ehr:dic dicmeta="IDM00222" code="${mgnt.tbDto.chemotherapy}"/>&nbsp;<ehr:dic dicmeta="IDM00331" code="${mgnt.tbDto.chemotherapyS}"/></c:if>
                    <c:if test="${mgnt.tbDto.chemotherapy == '3'}"><ehr:dic dicmeta="IDM00222" code="${mgnt.tbDto.chemotherapy}"/>&nbsp;<ehr:dic dicmeta="IDM00332" code="${mgnt.tbDto.chemotherapyT}"/></c:if>
                    <c:if test="${mgnt.tbDto.chemotherapy == '99'}"><ehr:dic dicmeta="IDM00222" code="${mgnt.tbDto.chemotherapy}"/>&nbsp;${mgnt.tbDto.chemotherapyOther}</c:if>
                </ehr:tip></td>
                <td><ehr:tip><ehr:dic dicmeta="IDM00243" code="${mgnt.tbDto.manageType}"/></ehr:tip></td>
                <td><ehr:dic dicmeta="CV0300404" code="${mgnt.tbDto.sputumResultS}"/></td>
                <td><ehr:dic dicmeta="CV0300404" code="${mgnt.tbDto.sputumResultFi}"/></td>
                <td><ehr:dic dicmeta="CV0300404" code="${mgnt.tbDto.sputumResultSi}"/></td>
                <td><ehr:dic dicmeta="CV0300404" code="${mgnt.tbDto.sputumResultE}"/></td>
                <td><ehr:dic dicmeta="IDM00244" code="${mgnt.tbDto.outcomeCode}"/></td>
                <td><ehr:tip><fmt:formatDate value="${mgnt.tbDto.stopReasonDt}" pattern="yyyy/MM/dd"/></ehr:tip></td>
            </tr>
        </c:forEach>
        <tr>
            <ehr:pagination action="statistics.search" colspan="14"/>
        </tr>
        </tbody>
    </table>
</div>

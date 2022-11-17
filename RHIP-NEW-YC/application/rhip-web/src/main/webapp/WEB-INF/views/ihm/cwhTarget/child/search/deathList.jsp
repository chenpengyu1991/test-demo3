<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:150px;width: 20%;"/>
            <col style="min-width:80px;"/>
            <col style="min-width:80px;"/>
            <col style="min-width:80px;"/>
        </colgroup>
        <thead>
        <tr>
            <th>镇</th>
            <%--<th>2-5岁儿童人数</th>--%>
            <%--<th>2-5岁儿童死亡人数</th>--%>
            <th>婴儿死亡率(‰)</th>
            <th>2-5岁儿童死亡率(‰)</th>
            <th>5岁以下儿童死亡率(‰)</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="childDeath" items="${childDeathList}" varStatus="status">
            <tr>
                <td class="centertd"><ehr:dic dicmeta="FS990001" code="${childDeath.gbCode}"/></td>
                <td class="centertd">${childDeath.newbornMortality}</td>
                <td class="centertd">${childDeath.babyMortality}</td>
                <td class="centertd">${childDeath.underFiveMortality}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
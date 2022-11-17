<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%--检验人数统计--%>
<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:80px;"/>
            <col style="min-width:50px;"/>
        </colgroup>
        <thead>
        <tr>
            <th>机构</th>
            <th>检验人数</th>
        </tr>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="exam" items="${examCountList}" varStatus="status">
            <tr>
                <td class="centertd"><ehr:tip>${exam.ORGAN_NAME}</ehr:tip></td>
                <td class="centertd"><tags:numberLabel value="${exam.NUM}" defaultValue="0" align="center"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
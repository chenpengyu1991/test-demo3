<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:150px;width: 15%;"/>
            <col style="min-width:80px;width: 10%;"/>
            <col style="min-width:80px;width: 15%;"/>
            <col style="min-width:80px;"/>
            <col style="min-width:80px;width: 15%;"/>
            <col style="min-width:80px;width: 12%;"/>
        </colgroup>

        <%--儿童登记管理--%>
        <thead>
        <tr>
            <th>姓名</th>
            <th>性别</th>
            <th>出生日期</th>
            <th>建档机构</th>
            <th>建档日期</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="child" items="${childList}" varStatus="status">
            <tr>
                <td class="centertd"><ehr:tip>${child.name}</ehr:tip></td>
                <td class="centertd"><ehr:tip><ehr:dic code="${child.sexCode}" dicmeta="GBT226112003"></ehr:dic></ehr:tip></td>
                <td class="centertd"><ehr:tip><fmt:formatDate value="${child.birthday}" pattern="yyyy/MM/dd"></fmt:formatDate></ehr:tip></td>
                <td class="centertd">${child.createOrganName}</td>
                <td class="centertd"><fmt:formatDate value="${child.inputDate}" pattern="yyyy/MM/dd"/></td>
                <td class="centertd">
                    <a href='#' onclick="childSearch.viewHealthCard(${child.id})" class='layui-btn layui-btn-normal layui-btn-xs' title="查看" style="color: #FFF;" ><i class="layui-icon">&#xe615;</i>查看</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <ehr:pagination action="childSearch.search" colspan="6"/>
        </tr>
        </tbody>

    </table>
</div>
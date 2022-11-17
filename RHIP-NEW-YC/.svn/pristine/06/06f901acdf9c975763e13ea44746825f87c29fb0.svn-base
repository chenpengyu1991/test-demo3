<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:150px;width: 12%;"/>
            <col style="min-width:80px;width: 8%;"/>
            <col style="min-width:80px;width: 12%;"/>
            <col style="min-width:80px;width: 18%;"/>
            <col style="min-width:80px;"/>
            <col style="min-width:80px;width: 12%;"/>
            <col style="min-width:80px;width: 8%;"/>
        </colgroup>

        <%--儿童健康体检数据--%>
        <thead>
        <tr>
            <th>姓名</th>
            <th>性别</th>
            <th>出生日期</th>
            <th>体检年龄</th>
            <th>体检机构</th>
            <th>体检时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="child" items="${childList}" varStatus="status">
            <tr>
                <td class="centertd"><ehr:tip>${child.name}</ehr:tip></td>
                <td class="centertd"><ehr:tip><ehr:dic code="${child.gender}" dicmeta="GBT226112003"></ehr:dic></ehr:tip></td>
                <td class="centertd"><ehr:tip><fmt:formatDate value="${child.birthday}" pattern="yyyy/MM/dd"></fmt:formatDate></ehr:tip></td>
                <td class="centertd">${child.cPhysicalExamAge}</td>
                <td class="centertd"><ehr:tip>${child.checkOrganName}</ehr:tip></td>
                <td class="centertd"><fmt:formatDate value="${child.checkDate}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
                <td class="centertd">
                    <a href='#' onclick="childSearch.viewHealthExamination(${child.id})" class='layui-btn layui-btn-normal layui-btn-xs' title="查看" style="color: #FFF;" ><i class="layui-icon">&#xe615;</i>查看</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <ehr:pagination action="childSearch.search" colspan="7"/>
        </tr>
        </tbody>
    </table>
</div>
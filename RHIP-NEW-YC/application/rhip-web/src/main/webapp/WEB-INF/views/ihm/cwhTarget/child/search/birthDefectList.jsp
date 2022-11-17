<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:150px;width: 10%;"/>
            <col style="min-width:80px;width: 10%;"/>
            <col style="min-width:80px;width: 10%;"/>
            <col style="min-width:80px;"/>
            <col style="min-width:80px;width: 12%;"/>
            <col style="min-width:80px;width: 20%;"/>
            <col style="min-width:80px;width: 8%;"/>
        </colgroup>

        <%--出生缺陷登记--%>
        <thead>
        <tr>
            <th>母亲姓名</th>
            <th>新生儿性别</th>
            <th>出生日期</th>
            <th>出生缺陷类别</th>
            <th>缺陷确诊时间</th>
            <th>填报单位</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="child" items="${childList}" varStatus="status">
            <tr>
                <td class="centertd"><ehr:tip>${child.name}</ehr:tip></td>
                <td class="centertd"><ehr:tip><ehr:dic code="${child.neonatalGender}" dicmeta="GBT226112003"></ehr:dic></ehr:tip></td>
                <td class="centertd"><ehr:tip><fmt:formatDate value="${child.deliveryDate}"
                                                              pattern="yyyy/MM/dd"></fmt:formatDate></ehr:tip></td>
                <td class="centertd"><ehr:dic dicmeta="CV0501016" code="${child.birthDefectType}"></ehr:dic></td>
                <td class="centertd"><ehr:dic dicmeta="CV0501015" code="${child.definiteTimeType}"></ehr:dic></td>
                <td class="centertd">${child.fillUnitName}</td>
                <td class="centertd">
                    <a href='#' onclick="childSearch.viewBirthDefect(${child.id})" class='layui-btn layui-btn-normal layui-btn-xs' title="查看" style="color: #FFF;" ><i class="layui-icon">&#xe615;</i>查看</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <ehr:pagination action="childSearch.search" colspan="7"/>
        </tr>
        </tbody>
    </table>

</div>
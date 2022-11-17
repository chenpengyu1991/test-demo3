<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="width: 15%;"/>
            <col style="width: 15%;"/>
            <col style="width: 15%;"/>
            <col style="width: 15%;"/>
            <col style="width: 15%;"/>
            <col style="width: 10%;"/>
        </colgroup>

        <%--新生儿随访--%>
        <thead>
        <tr>
            <th>姓名</th>
            <th>性别</th>
            <th>出生日期</th>
            <th>访视医师姓名</th>
            <th>访视日期</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="child" items="${childList}" varStatus="status">
            <tr>
                <td class="centertd"><ehr:tip>${child.neonatusName}</ehr:tip></td>
                <td class="centertd"><ehr:tip><ehr:dic code="${child.neonatalGender}" dicmeta="GBT226112003"></ehr:dic></ehr:tip></td>
                <td class="centertd"><ehr:tip><fmt:formatDate value="${child.neonatusBirthday}" pattern="yyyy/MM/dd"></fmt:formatDate></ehr:tip></td>
                <td class="centertd">
                <ehr:staff-name staffCode="${child.supervisionDoctor}"/>
                </td>
                <td class="centertd"><fmt:formatDate value="${child.visitDate}" pattern="yyyy/MM/dd"/></td>
                <td class="centertd">
                    <a href='#' onclick="childSearch.viewNeonatalVisit(${child.id})" class='layui-btn layui-btn-normal layui-btn-xs' title="查看" style="color: #FFF;" ><i class="layui-icon">&#xe615;</i>查看</a>
                    <%--<a href="#" onclick="childSearch.editViewNeonatalVisit(${child.id})" class='layui-btn layui-btn-xs' title="修改" style="color: #FFF;" ><i class="layui-icon">&#xe642;</i>修改</a>
                    <a href="#" onclick="childSearch.deleteViewNeonatalVisit(${child.id})" class='layui-btn layui-btn-danger layui-btn-xs' title="删除" style="color: #FFF;" ><i class="layui-icon">&#xe640;</i>删除</a>--%>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <ehr:pagination action="childSearch.search" colspan="6"/>
        </tr>
        </tbody>
    </table>
</div>
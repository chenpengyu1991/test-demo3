<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="repeattable">
    <table  class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:80px;width: 10%;"/>
            <col style="min-width:150px;width: 18%;"/>
            <col style="min-width:80px;width: 12%;"/>
            <col style="min-width:80px;width: 15%;"/>
            <col style="min-width:80px;width: 12%;"/>
            <col style="min-width:80px;"/>
            <col style="min-width:80px;width: 10%;"/>
        </colgroup>
        <thead>
        <tr>
            <th>姓名</th>
            <th>身份证号</th>
            <th>出生日期</th>
            <th>分娩时间</th>
            <th>分娩方式</th>
            <th>助产机构</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="woman" items="${womanList}" varStatus="status">
            <tr>
                <td class="centertd"><ehr:tip>${woman.name}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${woman.idCard}</ehr:tip></td>
                <td class="centertd"><ehr:tip><fmt:formatDate value="${woman.birthday}" pattern="yyyy/MM/dd"></fmt:formatDate></ehr:tip></td>
                <td class="centertd"><ehr:tip><fmt:formatDate value="${woman.deliveryDate}" pattern="yyyy/MM/dd HH:mm"></fmt:formatDate></ehr:tip></td>
                <td class="centertd"><ehr:dic code="${woman.deliveryWay}" dicmeta="CV0210003"></ehr:dic></td>
                <td class="centertd"><ehr:tip>${woman.createOrganName}</ehr:tip></td>
                <td class="centertd">
                    <a href='#' onclick="womanSearch.delivery(${woman.personId})"
                       class='layui-btn layui-btn-normal layui-btn-xs' title="查看" style="color: #FFF;" ><i class="layui-icon">&#xe615;</i>查看</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <table>
        <tr>
            <ehr:pagination action="womanSearch.search"/>
        </tr>
    </table>
</div>
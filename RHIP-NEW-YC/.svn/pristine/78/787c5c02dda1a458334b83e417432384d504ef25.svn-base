<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<table class="layui-table x-admin-sm-table-list-middle">
    <colgroup>
        <col style="min-width:150px;width: 20%;"/>
        <col style="min-width:80px;width: 20%;"/>
        <col style="min-width:80px;width: 20%;"/>
        <col style="min-width:80px;width: 20%;"/>
        <col style="min-width:80px;width: 20%;"/>
    </colgroup>
    <thead>
        <tr>
            <th>本人姓名</th>
            <th>身份证号</th>
            <th>检查机构</th>
            <th>检查日期</th>
            <th>操作</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="woman" items="${womanDiseaseCensusList}" varStatus="status">
            <tr>
                <td class="centertd"><ehr:tip>${woman.name}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${woman.idCard}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${woman.createOrganName}</ehr:tip></td>
                <td class="centertd"><ehr:tip><fmt:formatDate value="${woman.checkDate}" pattern="yyyy/MM/dd"></fmt:formatDate></ehr:tip></td>
                <td class="centertd">
                    <a href="javascript:void(0);" onclick="womanSearch.getWomanDiseaseCensus('${woman.id}')" title="查看" class="layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe615;</i>查看</a>&nbsp;&nbsp;
                </td>
            </tr>
        </c:forEach>
        <tr>
            <ehr:pagination action="womanSearch.search" colspan="5"/>
        </tr>
    </tbody>
</table>

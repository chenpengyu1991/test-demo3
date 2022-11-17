<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width: 100px; width: 10%;">
            <col style="min-width: 260px; width: 30%;">
            <col style="min-width: 360px; width: 50%;">
            <col style="min-width: 360px; width: 10%;">
        </colgroup>
        <thead>
        <tr>
            <th class="centerth">年份</th>
            <th class="centerth">疾病名称</th>
            <th class="centerth">机构名称</th>
            <th class="centerth">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="setup" items="${setups.list}" varStatus="status">
            <tr>
                <td class="centertd" title="${setup.setYear}">${setup.setYear}</td>
                <td title="${setup.infectiousName}">${setup.infectiousName}</td>
                <td title="<ehr:org code='${setup.caseOrganCode}' />"><ehr:org code="${setup.caseOrganCode}" /></td>
                <td class="centertd">
                <a href="javascript:void(0);" onclick="setup.deleteSet(${setup.id})" class="layui-btn layui-btn-danger layui-btn-xs" style="color: #FFF;font-size: 12px;" title="删除"><i class="layui-icon"></i>删除</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <ehr:pagination action="setup.search" colspan="4"/>
        </tr>
        </tbody>
    </table>

    <%-- <table>
        <tr>
            <ehr:pagination action="setup.search" />
        </tr>
    </table> --%>

</div>


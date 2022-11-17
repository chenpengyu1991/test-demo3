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
            <col style="min-width:80px;width: 15%;"/>
            <col style="min-width:80px;width: 20%;"/>
            <col style="min-width:80px;width: 15%;"/>
            <col style="min-width:80px;width: 20%;"/>
            <col style="min-width:80px;width: 15%;"/>
            <col style="min-width:80px;width: 15%;"/>
        </colgroup>
        <thead>
        <tr>
            <th>本人姓名</th>
            <th>产妇恢复</th>
            <th>身份证号</th>
            <%--<th>健康指导</th>--%>
            <th>处理</th>
            <th>检查机构</th>
            <th>检查日期</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="woman" items="${womanList}" varStatus="status">
            <tr>
                <td class="centertd"><ehr:tip>${woman.name}</ehr:tip></td>
                <td class="centertd">
                    <c:if test="${!empty woman.classifyFlag}">
                        <c:out value='${woman.classifyFlag eq "1" ? "未恢复" : "已恢复"}'/>
                    </c:if>
                </td>
                <td align="center">${woman.idCard}</td>
                <%--<td class="centertd" id="label0" onmouseover="showTooltip(this);" onmouseout='hideTooltip(this);'>
                    <ehr:dic code="${woman.healthGuidanceClass}" dicmeta="CV0600219"></ehr:dic> ${woman.healthGuidanceDesc}</td>--%>
                <td class="centertd">
                    <c:if test='${woman.finalMark eq "0"}'>结案</c:if>
                    <c:if test='${woman.finalMark eq "1"}'>转诊</c:if>
                </td>
                <td class="centertd"><ehr:tip>${woman.createOrganName}</ehr:tip></td>
                <td class="centertd"><ehr:tip><fmt:formatDate value="${woman.supervisionDate}" pattern="yyyy/MM/dd"></fmt:formatDate></ehr:tip></td>
                <td class="centertd">
                	<a href="javascript:void(0);"  onclick="womenHealth.postpartum1(${woman.id})" title="查看" class="layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe615;</i>查看</a>
                 <%--   <c:if test="${curCode eq woman.createOrganCode}">
                    <a href="javascript:void(0)" onclick="womanSearch.modifyPostpartum(${woman.id})"
                       class="person-link-btn">修改</a>
                    <a href="javascript:void(0)" onclick="womanSearch.deletePostpartum(${woman.id})"
                       class="person-link-btn">刪除</a>
                    </c:if>--%>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

<%--    <table>
        <tr>
            <ehr:pagination action="womanSearch.search"/>
        </tr>
    </table>--%>
</div>
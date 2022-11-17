<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:150px;width: 16%;"/>
            <col style="min-width:80px;width: 20%;"/>
            <col style="min-width:80px;width: 20%;"/>
            <col style="min-width:80px;width: 16%;"/>
            <col style="min-width:80px;width: 20%;"/>
        </colgroup>
        <thead>
        <tr>
            <th>本人姓名</th>
            <th>身份证号</th>
            <th>随访机构</th>
            <th>随访日期</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="woman" items="${postnatalFollowupList}" varStatus="status">
            <tr>
                <td class="centertd"><ehr:tip>${woman.name}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${woman.idCard}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${woman.createOrganName}</ehr:tip></td>
                <td class="centertd"><ehr:tip><fmt:formatDate value="${woman.visitDate}" pattern="yyyy/MM/dd"></fmt:formatDate></ehr:tip></td>
                <td class="centertd">
                	<a href="javascript:void(0);"  onclick="womenHealth.getPostnatalFollowup(${woman.id})" title="查看"class="layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;" ><i class="layui-icon">&#xe615;</i>查看</a>
<%--                    <c:if test="${woman.createOrganCode eq curCode}">
                    <a href="javascript:void(0)" onclick="womanSearch.modifyPostnatalFollowup(${woman.id})"
                       class="person-link-btn">修改</a>
                    <a href="javascript:void(0)" onclick="womanSearch.deletePostnatalFollowup(${woman.id})"
                       class="person-link-btn">删除</a>
                    </c:if>--%>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

<%--      <table>
        <tr>
            <ehr:pagination action="womanSearch.search"/>
        </tr>
    </table>--%>
</div>
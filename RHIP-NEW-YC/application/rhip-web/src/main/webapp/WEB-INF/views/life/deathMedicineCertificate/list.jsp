<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="repeattable">
<input type="hidden" id="pageIndex" value="${page.currentPage}">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:150px;width: 20%;"/>
            <col style="min-width:80px;width: 30%;"/>
            <col style="min-width:80px;width: 15%;"/>
            <col style="min-width:80px;width: 15%;"/>
            <col style="min-width:80px;width: 20%;"/>
        </colgroup>
        <thead>
        <tr>
            <th>姓名</th>
            <th>身份证</th>
            <th>死亡日期</th>
            <th>是否结案</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody  class="tbody">
        <c:forEach var="deathMedicineCertificate" items="${deathMedicineCertificateList}" varStatus="status">
            <tr>
                <td class="centertd"><ehr:tip>${deathMedicineCertificate.name}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${deathMedicineCertificate.idcard}</ehr:tip></td>
                <td class="centertd"><fmt:formatDate value="${deathMedicineCertificate.deathDate}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
                <td class="centertd">
                    <c:choose>
                        <c:when test="${'1' eq deathMedicineCertificate.cancelStatus}">
                            已结案
                        </c:when>
                        <c:otherwise>
                            未结案
                        </c:otherwise>
                    </c:choose>
                </td>
                <td class="centertd">
                    <%-- <a href="javascript:void(0)" onclick="deathMedicineCertificateSearch.view(${deathMedicineCertificate.id})"
                       class="person-link-btn">查看</a> --%>
                    <%--<a href="javascript:void(0)" onclick="deathMedicineCertificateSearch.view(${deathMedicineCertificate.id})"
                       class="person-link-btn"  title="查看"><i class="layui-icon">&#xe615;</i></a>--%>
                    <a class="layui-btn layui-btn-normal layui-btn-xs" href="#" onclick="deathMedicineCertificateSearch.view(${deathMedicineCertificate.id})" title="查看" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe640;</i>查看</a>&nbsp;
                    <c:if test="${'0' eq deathMedicineCertificate.cancelStatus}">
                        <%-- <a href="javascript:void(0)" onclick="deathMedicineCertificateSearch.update(${deathMedicineCertificate.id})"  class="person-link-btn">修改</a> --%>
                        <%--<a href="javascript:void(0)" onclick="deathMedicineCertificateSearch.update(${deathMedicineCertificate.id})"  class="person-link-btn" title="修改"><i class="layui-icon">&#xe642;</i></a>--%>&nbsp;
                        <a class="layui-btn layui-btn-xs" href="#" onclick="deathMedicineCertificateSearch.update(${deathMedicineCertificate.id})" title="修改" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe640;</i>修改</a>&nbsp;
                        <%-- <a href="javascript:void(0)" onclick="deathMedicineCertificateSearch.del(${deathMedicineCertificate.id})"
                        class="person-link-btn">删除</a> --%>
                        <%--<a href="javascript:void(0)" onclick="deathMedicineCertificateSearch.del(${deathMedicineCertificate.id})"
                        class="person-link-btn" title="删除"><i class="layui-icon">&#xe640;</i></a>--%>
                        <a class="layui-btn layui-btn-danger layui-btn-xs" href="#" onclick="deathMedicineCertificateSearch.del(${deathMedicineCertificate.id})" title="删除" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe640;</i>删除</a>&nbsp;
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <ehr:pagination action="deathMedicineCertificateSearch.search" colspan="5"/>
        </tr>
        </tbody>
    </table>
   <%--  <table>
        <tr>
            <ehr:pagination action="deathMedicineCertificateSearch.search"/>
        </tr>
    </table> --%>
</div>
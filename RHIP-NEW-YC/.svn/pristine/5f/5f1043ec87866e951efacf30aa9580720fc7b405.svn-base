<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="repeattable x-admin-sm">
<input type="hidden" id="pageIndex" value="${page.currentPage}">
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
            <th>姓名</th>
            <th>根本死因</th>
            <th>死亡日期</th>
            <th>填报机构</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="deathMedicineCertificate" items="${deathMedicineCertificateList}" varStatus="status">
            <tr>
                <td class="centertd"><ehr:tip>${deathMedicineCertificate.name}</ehr:tip></td>
                <td class="centertd">
                	<c:if test="${empty deathMedicineCertificate.deathReason}">无</c:if>
                	<c:if test="${not empty deathMedicineCertificate.deathReason}"><ehr:tip>${deathMedicineCertificate.deathReason}</ehr:tip></c:if>
                </td>
                <td class="centertd"><fmt:formatDate value="${deathMedicineCertificate.deathDate}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate></td>
                <td class="centertd"><ehr:tip>${deathMedicineCertificate.fillOrganName}</ehr:tip></td>
                <td class="centertd">
                    <a href="javascript:void(0)" title="查看" class="basicIndex layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;" onclick="deathMedicineCertificateSearch.view(${deathMedicineCertificate.id})" class="basicIndex"><i class="layui-icon"></i>查看</a>
                	<ehr:authorize ifAnyGranted="0204,0304,0404">
                		<c:if test="${currentLoginInfo.organization.organName eq deathMedicineCertificate.fillOrganName}">
		                	<a href="javascript:void(0)" title="修改" onclick="deathMedicineCertificateSearch.edit(${deathMedicineCertificate.id})" class="personModify layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon"></i>修改</a>
                            <a href="javascript:void(0)" title="删除" style="color: #FFF;font-size: 12px;" onclick="deathMedicineCertificateSearch.deleteChild(${deathMedicineCertificate.id})" class="layui-btn layui-btn-danger layui-btn-xs"><i class="layui-icon"></i>删除</a>
               			</c:if>
               		</ehr:authorize>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <ehr:pagination action="deathMedicineCertificateSearch.search" colspan="5"/>
        </tr>
        </tbody>
    </table>
    <%-- <table>
        <tr>
            <ehr:pagination action="deathMedicineCertificateSearch.search"/>
        </tr>
    </table> --%>
</div>
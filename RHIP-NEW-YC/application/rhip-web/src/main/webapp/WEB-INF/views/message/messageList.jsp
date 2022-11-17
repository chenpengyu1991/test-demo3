<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-small">
        <colgroup>
            <col style="min-width:80px;"/>
            <col style="min-width:80px;width: 15%;"/>
            <col style="min-width:80px;width: 15%;"/>
            <col style="min-width:80px;width: 20%;"/>
            <c:if test="${personal == '1'}"><col style="min-width:80px;width: 10%;"/></c:if>
            <col style="min-width:80px;width: 10%;"/>
        </colgroup>
        <%--医学出生证明--%>
        <thead>
        <tr>
            <th>主题</th>
            <th>发布时间</th>
            <th>发布人</th>
            <th>接受单位</th>
            <c:if test="${personal == '1'}"><th>状态</th></c:if>
            <th>查看</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="message" items="${messages}" varStatus="status">
            <tr>
                <td class="centertd"><ehr:tip>${message.title}</ehr:tip></td>
                <td class="centertd"><ehr:tip><fmt:formatDate value="${message.createDate}" pattern="yyyy/MM/dd HH:mm"></fmt:formatDate></ehr:tip></td>
                <td class="centertd"><ehr:tip><ehr:user userCode="${message.createUserCode}"></ehr:user></ehr:tip></td>
                <td class="centertd"><ehr:tip><ehr:org code="${message.receivingUnit}"></ehr:org></ehr:tip></td>
                <c:if test="${personal == '1'}"><td class="centertd"><ehr:tip>${message.status == '1'?'已读':'未读'}</ehr:tip></td></c:if>
                <c:if test="${personal == '1'}"><td class="centertd"><a href="javascript:void(0);" onclick="messageSearch.view('${message.messageId}')">查看</a></td></c:if>
                <c:if test="${personal != '1'}"><td class="centertd"><a href="javascript:void(0);" onclick="messageSearch.view('${message.id}')">查看</a></td></c:if>
            </tr>
        </c:forEach>
        <tr>
        	<c:if test="${personal == '1'}">
	            <ehr:pagination action="messageSearch.search" colspan="6"/>
        	</c:if>
        	<c:if test="${personal ne '1'}">
	            <ehr:pagination action="messageSearch.search" colspan="5"/>
        	</c:if>
        </tr>
        </tbody>
    </table>
    <%-- <table>
        <tr>
            <ehr:pagination action="messageSearch.search"/>
        </tr>
    </table> --%>
</div>
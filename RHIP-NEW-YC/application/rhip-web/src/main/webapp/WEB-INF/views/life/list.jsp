<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ADMIN"  value="<%=RoleType.ADMIN.getValue()%>" />

<div class="repeattable">
<input type="hidden" id="pageIndex" value="${page.currentPage}">
    <table id="life_event_tb" class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:150px;width: 16%;"/>
            <col style="min-width:80px;width: 20%;"/>
            <col style="min-width:80px;width: 16%;"/>
            <col style="min-width:80px;width: 13%;"/>
            <col style="min-width:80px;width: 20%;"/>
            <col style="min-width:80px;width: 8%;"/>
            <col/>
        </colgroup>
        <thead>
        <tr>
            <th>姓名</th>
            <th>身份证</th>
            <th>死亡日期</th>
            <th>人群分类</th>
            <th>录入机构</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="life" items="${lifeList}" varStatus="status">
            <tr>
                <td class="centertd"><ehr:tip>${life.name}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${life.idcard}</ehr:tip></td>
                <td class="centertd"><fmt:formatDate value="${life.deathDate}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
                <td class="centertd">
                    <ehr:dic dicmeta="FS990023" code="${life.personType}"/>
                </td>
                <td class="centertd"><ehr:org code="${life.inputOrgancode}"/></td>
                <td class="centertd">
                    <ehr:dic dicmeta="PH00035" code="${life.cancelStatus}"/>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${'0' == life.cancelStatus}">

                        </c:when>
                        <c:when test="${'1' == life.cancelStatus}">
                            <ehr:authorize ifAnyGranted="${ADMIN}">
                                <%--<c:if test="${loginUserName eq life.updateUser}">--%>
                                    <a href="javascript:void(0)" id="personOffActive${life.id}" data-id="${life.id}" data-filing-flag="${life.filingFlag}">激活</a>
                                <%--</c:if>--%>
                            </ehr:authorize>
                            <ehr:authorize ifNotGranted="${ADMIN}">
                                <c:if test="${life.filingFlag ne 0}">
                                    <a href="javascript:void(0)" id="personOffActive${life.id}" data-id="${life.id}" data-filing-flag="${life.filingFlag}">激活</a>
                                </c:if>
                            </ehr:authorize>
                        </c:when>
                    </c:choose>
                    <a href="javascript:void(0)" id="view${life.id}" data-id="${life.id}" data-filing-flag="${life.filingFlag}">查看</a>
                  <%--<a class="report-link" href="javascript:void(0)" data-id="${life.id}">查看</a>--%>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        <tr>
            <ehr:pagination action="lifeEventSearch.search" colspan="7"/>
        </tr>
    </table>

   <%--  <table>
        <tr>
            <ehr:pagination action="lifeEventSearch.search"/>
        </tr>
    </table> --%>
</div>
<%--
  Created by IntelliJ IDEA.
  User: chen.q
  Date: 15-7-2
  Time: 上午10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>

<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">

        <thead>
        <tr>
            <th>
                <ehr:dic dicmeta="FS990016" code="16"/>
            </th>
            <th>
                <ehr:dic dicmeta="FS990016" code="18"/>
            </th>
        </tr>
        </thead>
        <tbody class="tbody">
        <c:forEach items="${remindStWithoutOrgList}" var="remindStWithoutOrg">
            <c:if test="${remindStWithoutOrg.ctype eq '16'}">
                <c:set var="num1" value="${remindStWithoutOrg.countNum}"/>
            </c:if>
            <c:if test="${remindStWithoutOrg.ctype eq '18'}">
                <c:set var="num2" value="${remindStWithoutOrg.countNum}"/>
            </c:if>
        </c:forEach>
        <tr>
            <td style="text-align: center ">
                ${empty num1 ? 0 : num1}
            </td>
            <td style="text-align: center ">
                ${empty num2 ? 0 : num2}
            </td>
        </tr>
        </tbody>
    </table>

</div>


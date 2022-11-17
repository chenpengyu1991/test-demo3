<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="repeattable">
    <table id="person_record_table">
        <colgroup>
            <col style="width: 10%"/>
            <col style="width: 10%"/>
            <col style="width: 20%"/>
            <col style="width: 15%"/>
            <col style="width: 10%"/>
            <col style="width: 10%"/>
            <col style="width: 15%"/>
        </colgroup>
        <thead>
        <tr>
            <th>用户编码</th>
            <th>用户名</th>
            <th>高压</th>
            <th>低压</th>
            <th>血压状态</th>
            <th>心率</th>
            <th>测量时间</th>

        </tr>
        </thead>
        <tbody class="tbody">
        <c:forEach items="${userList}" var="user" varStatus="status">
            <tr>
                <td class="centertd">
                    <ehr:tip>${user.userId}</ehr:tip>
                </td>
                <td class="centertd">
                    <ehr:tip>${user.userName}</ehr:tip>
                </td>
                <td class="centertd">
                    <ehr:tip>${user.sbp}</ehr:tip>
                </td>
                <td class="centertd">
                    <ehr:tip>${user.dbp}</ehr:tip>
                </td>
                <td class="centertd"
                        <c:choose>
                            <c:when test="${user.status eq '正常'}">bgcolor="#7fffd4"</c:when>
                            <c:when test="${user.status eq '低血压'}">bgcolor="yellow"</c:when>
                            <c:when test="${user.status eq '正常高线'}">bgcolor="#f4a460"</c:when>
                            <c:when test="${user.status eq '高血压'}">bgcolor="red"</c:when>
                            <c:when test="${user.status eq ''}"></c:when>
                            <c:otherwise>bgcolor="#A9A9A9"</c:otherwise>
                        </c:choose>
                >
                    <ehr:tip>${user.status}</ehr:tip>
                </td>
                <td class="centertd">
                    <ehr:tip>${user.heartRate}</ehr:tip>
                </td>
                <td class="centertd">
                    <ehr:tip>${user.checkDate}</ehr:tip>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <ehr:paging />
</div>


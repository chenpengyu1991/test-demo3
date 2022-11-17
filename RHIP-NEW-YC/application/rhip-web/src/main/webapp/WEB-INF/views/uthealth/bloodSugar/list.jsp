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
        </colgroup>
        <thead>
        <tr>
            <th>用户编码</th>
            <th>用户名</th>
            <th>血糖</th>
            <th>血糖级别</th>
            <th>测量状态</th>
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
                    <ehr:tip>${user.bloodSugar}</ehr:tip>
                </td>
                <td class="centertd"
                        <c:choose>
                            <c:when test="${user.bloodSugarLevelName eq '偏低'}">bgcolor="#ffe4c4"</c:when>
                            <c:when test="${user.bloodSugarLevelName eq '低血糖'}">bgcolor="yellow"</c:when>
                            <c:when test="${user.bloodSugarLevelName eq '正常'}">bgcolor="#7fffd4"</c:when>
                            <c:when test="${user.bloodSugarLevelName eq '高血糖'}">bgcolor="red"</c:when>
                            <c:otherwise>bgcolor="#A9A9A9"</c:otherwise>
                        </c:choose>
                >
                    <ehr:tip>${user.bloodSugarLevelName}</ehr:tip>
                </td>
                <td class="centertd">
                    <ehr:tip>${user.bodyStatus}</ehr:tip>
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


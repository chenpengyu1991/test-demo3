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
        </colgroup>
        <thead>
        <tr>
            <th>用户编码</th>
            <th>用户名</th>
            <th>呼吸率</th>
            <th>呼吸率级别</th>
            <th>检测日期</th>

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
                    <ehr:tip>${user.breathFreq}</ehr:tip>
                </td>
                <td class="centertd"
                        <c:choose>
                            <c:when test="${user.breathFreqLevelName eq '呼吸过快'}">bgcolor="yellow"</c:when>
                            <c:when test="${user.breathFreqLevelName eq '正常'}">bgcolor="#7fffd4"</c:when>
                            <c:otherwise>bgcolor="#A9A9A9"</c:otherwise>
                        </c:choose>
                >
                    <ehr:tip>${user.breathFreqLevelName}</ehr:tip>
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


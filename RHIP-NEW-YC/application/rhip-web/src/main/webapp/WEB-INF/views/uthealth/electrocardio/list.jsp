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
            <col style="width: 5%"/>
            <col style="width: 5%"/>
            <col style="width: 5%"/>
            <col style="width: 5%"/>
            <col style="width: 5%"/>
            <col style="width: 15%"/>
            <col style="width: 15%"/>
        </colgroup>
        <thead>
        <tr>
            <th>用户编码</th>
            <th>用户名</th>
            <th>漏博次数</th>
            <th>停搏次数</th>
            <th>心率不齐次数</th>
            <th>心率过快次数</th>
            <th>心率过慢次数</th>
            <th>开始时间</th>
            <th>结束时间</th>
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
                    <ehr:tip>${user.leakCount}</ehr:tip>
                </td>
                <td class="centertd">
                    <ehr:tip>${user.stopCount}</ehr:tip>
                </td>
                <td class="centertd">
                    <ehr:tip>${user.irregularCount}</ehr:tip>
                </td>
                <td class="centertd">
                    <ehr:tip>${user.fastCount}</ehr:tip>
                </td>
                <td class="centertd">
                    <ehr:tip>${user.slowCount}</ehr:tip>
                </td>
                <td class="centertd">
                    <ehr:tip>${user.beginDate}</ehr:tip>
                </td>
                <td class="centertd">
                    <ehr:tip>${user.endDate}</ehr:tip>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <ehr:paging />
</div>


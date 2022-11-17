<%--
  Created by IntelliJ IDEA.
  User: jingqiu
  Date: 17-4-18
  Time: 下午3:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
    <table>
        <colgroup>
            <col style="width: 15%"/>
            <col style="width: 20%"/>
            <col style="width: 10%"/>
            <col style="width: 10%"/>
            <col style="width: 25%"/>
            <col />
        </colgroup>
        <thead>
        <tr>
            <th>姓名</th>
            <th>身份证号</th>
            <th>调查员</th>
            <th>调查日期</th>
            <th>地址</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="question" items="${questionList}">
            <tr>
                <td>${question.personName}</td>
                <td>${question.idNo}</td>
                <td>${question.surveyer}</td>
                <td><fmt:formatDate value="${question.surveyDt}" pattern="yyyy-MM-dd"/></td>
                <td>${question.address}</td>
                <td>
                    <a href="javascript:void(0)" onclick="question135.editQuestion('${question.id}', 2)">修改</a>
                    <a href="javascript:void(0)" onclick="question135.deleteQuestion('${question.id}', 2)">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        <ehr:pagination action="question135.search" colspan="6" />
    </table>
</div>

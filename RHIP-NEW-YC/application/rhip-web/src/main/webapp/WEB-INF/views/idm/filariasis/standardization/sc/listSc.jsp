<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable" id="scList" style="width:300px; float: left;margin-right: 10px;margin-left: 10px">
    <table id="ccList" class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="width:30%"/>
            <col style="width:40%"/>
            <col/>
        </colgroup>
        <thead>
        <tr>
            <th class="centerth">检查人</th>
            <th class="centerth">检查日期</th>
            <th class="centerth">满意度</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="sc" items="${scList}" varStatus="status">
            <tr onclick="filStandard.clickScRow(this)" id="${sc.id}">
                <td><ehr:user userCode="${sc.checkUser}"/></td>
                <td><fmt:formatDate value="${sc.supervisorDt}" pattern="yyyy/MM/dd" /></td>
                <td><ehr:dic dicmeta="IDM00292" code="${sc.satisfaction}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <table class="mini">
        <tr>
            <ehr:pagination-mini action="filStandard.searchScList"/>
        </tr>
    </table>
</div>
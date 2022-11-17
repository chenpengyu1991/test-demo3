<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<%--健康档案指标--%>
<div class="repeattable">
    <table>
        <colgroup>
        	<col style="min-width:120px;width: 25%;"/>
        	<col style="min-width:120px;width: 25%;"/>
        	<col style="min-width:120px;width: 25%;"/>
        	<col style="min-width:120px;width: 25%;"/>
        </colgroup>
        <thead>
        <tr>
            <th>姓名</th>
            <th>个人健康档案建档工作量</th>
            <th>三星档案建档量</th>
            <th>档案更新数</th>
        </tr>
        </thead>
        <tbody><c:forEach var="summary" items="${summaryList}" varStatus="status">
            <tr>
                <td><ehr:tip><ehr:staff-name staffCode="${summary.INPUTER_ID}"></ehr:staff-name></ehr:tip></td>
                <td><tags:numberLabel value="${summary.PCOUNT}" defaultValue="0" align="center" /></td>
                <td><tags:numberLabel value="${summary.THREECOUNT}" defaultValue="0" align="center" /></td>
                <td><tags:numberLabel value="${summary.FCOUNT}" defaultValue="0" align="center" /></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <table>
        <tr>
            <c:if test="${!empty summaryList}">
                <ehr:pagination action="performanceSearch.search"/>
            </c:if>
        </tr>
    </table>
</div>
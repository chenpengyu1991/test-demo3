<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<%--医疗考核-门诊摘要(挂号)--%>
<div class="repeattable">
    <table>
        <colgroup>
        	<col style="min-width:160px;width: 30%;"/>
        	<col style="min-width:160px;width: 15%;"/>
        	<col style="min-width:160px;width: 30%;"/>
        	<col/>
        </colgroup>
        <thead>
        <tr>
            <th>医疗机构</th>
            <th>工号</th>
            <th>姓名</th>
            <th>挂号量</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="summary" items="${summaryList}" varStatus="status">
            <tr>
            	<td><ehr:tip><ehr:org  code="${summary.organCode}"/></ehr:tip></td>
            	<td class="centertd"><ehr:tip>${summary.doctorNo}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${summary.doctorName}</ehr:tip></td>
                <td><tags:numberLabel value="${summary.registerNum}" defaultValue="0" align="center" /></td>
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
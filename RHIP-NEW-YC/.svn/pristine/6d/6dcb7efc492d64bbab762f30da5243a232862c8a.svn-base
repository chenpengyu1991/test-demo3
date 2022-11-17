<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="repeattable">
	<table id="serviceTable">
		<colgroup>
	        <col style="min-width:60px;width: 15%;"/>
			<col style="min-width:150px;width:25%;"/>
	        <col style="min-width:40px;width: 10%;"/>
	        <col style="min-width:80px;width: 20%;"/>
	        <col style="min-width:80px;width: 25%;"/>
	        <col style="min-width:80px;width: 25%;"/>
	        <col style="min-width:80px;width: 15%;"/>
	        <col style="min-width:80px;width: 20%;"/>
		</colgroup>
		<thead>
			<tr>
			    <th>姓名</th>
				<th>身份证号码</th>
				<th>体检状态</th>
				<th>体检日期</th>
                <th>迁出机构</th>
				<th>迁入机构</th>
				<th>操作者</th>
				<th>迁移时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="elderphyexamLog" items="${elderphyexamLogList}" varStatus="status">
				<tr>
				    <td style="text-align:center">${elderphyexamLog.name}</td>
				    <td style="text-align:center"><ehr:tip>${elderphyexamLog.idcard}</ehr:tip></td>
				    <td>
				     <c:if test="${elderphyexamLog.examStatus eq 1}">已体检</c:if>
				     <c:if test="${elderphyexamLog.examStatus eq 0}">未体检</c:if>
				    </td>
                    <td>
                    <fmt:formatDate value='${elderphyexamLog.examYear}' pattern='yyyy/MM/dd'/>
                    </td>
					<td><ehr:tip><ehr:org code="${elderphyexamLog.inputOrganCode}"/></ehr:tip></td>
                    <td><ehr:tip><ehr:org code="${elderphyexamLog.currentOrganCode}"/></ehr:tip></td>
                    <td style="text-align:center">${elderphyexamLog.operator}</td>
                    <td style="text-align:center">
                    <fmt:formatDate value='${elderphyexamLog.recordChangeTime}' pattern='yyyy/MM/dd'/>
                    </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="orgtransferLogSearch.search" />
		</tr>
	</table>
</div>
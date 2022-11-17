<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
	<table id="reportTable">
		<colgroup>
			<col style="width: 20%"/>
			<col style="width: 20%"/>
			<col style="width: 15%"/>
			<col style="width: 15%"/>
			<col style="width: 15%"/>
			<col style="width: 15%"/>
		</colgroup>
		<caption><b>病媒生物监测――鼠密度监测汇总表</b><br/></caption>
		<thead>
		<tr>
			<td colspan="6" style="border: none;background-color: #ffffff">
				监测时间：
				<fmt:formatDate value="${beginDate}" pattern="yyyy年MM月dd日"/><c:if test="${beginDate eq null}"> ~ </c:if>
				至
				<fmt:formatDate value="${endDate}" pattern="yyyy年MM月dd日"/><c:if test="${endDate eq null}"> ~ </c:if>
				<br/>
				监测乡镇：<ehr:dic code="${townShip}" dicmeta="FS990001"/>
			</td>
		</tr>
		<tr>
			<th>环境类型</th>
			<th>监测点</th>
			<th>有效夹数(只)</th>
			<th>捕鼠总数(只)</th>
			<th>鼠密度(%)</th>
			<th>鼠种代码</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="row" items="${report}">
			<tr>
				<td><ehr:dic code="${row.ENV}" dicmeta="DMBC00001"/></td>
				<td><ehr:dic code="${townShip}" dicmeta="FS990001"/></td>
				<td>${row.TRAPS}</td>
				<td>${row.RATS}</td>
				<td>${row.DENSITY}</td>
				<td title="${row.SPECIES}">${row.SPECIES}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
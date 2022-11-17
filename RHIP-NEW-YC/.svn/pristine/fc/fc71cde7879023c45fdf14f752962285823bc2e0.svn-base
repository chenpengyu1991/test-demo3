<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="repeattable">
	<table id="reportTable">
		<colgroup>
			<col style="width: 20%"/>
			<col style="width: 20%"/>
			<col style="width: 20%"/>
			<col style="width: 20%"/>
			<col style="width: 20%"/>
		</colgroup>
		<caption><b>病媒生物监测――苍蝇监测汇总表</b><br/></caption>
		<thead>
		<tr>
			<td colspan="5" style="border: none;background-color: #ffffff">
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
			<th>蝇笼数</th>
			<th>捕蝇数量</th>
			<th>密度(只/笼)</th>
			<th>蝇种类代码</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="row" items="${report}">
			<tr>
				<td><ehr:dic code="${row.ENV}" dicmeta="DMBC00007"/></td>
				<td>${row.CAGE}</td>
				<td>${row.TOTAL}</td>
				<td>${row.DENSITY}</td>
				<td title="${row.SPECIES}">${row.SPECIES}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
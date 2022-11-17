<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%--<div id="diseaseControlDiv" style="height: 535px;overflow: auto"></div>--%>

<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:70px;width: 10%;"/>
			<col style="min-width:50px;width: 8%;"/>
			<col style="min-width:50px;width: 8%;"/>
			<col style="min-width:80px;width: 10%;"/>
			<col style="min-width:100px;width: 10%;"/>
			<col style="min-width:100px;width: 14%;"/>
			<col style="min-width:100px;width: 10%;"/>
			<col style="min-width:80px;width: 10%;"/>
			<col style="min-width:80px;width: 10%;"/>
			<col style="min-width:60px;width: 10%;"/>
		</colgroup>
		<thead>
		<tr>
			<th>姓名</th>
			<th>性别</th>
			<th>年龄</th>
			<th>疾病名称</th>
			<th>疾病类型</th>
			<th>上报单位</th>
			<th>职业</th>
			<th>发病日期</th>
			<th>诊断时间</th>
			<th>录入时间</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="report" items="${reports.list}" varStatus="status">
			<tr>
				<td title="${report.name}"><a href="javascript:void(0)" onclick="brwControl.detail(${report.id})"class="person-link-btn">${report.name}</a></td>
				<td class="centertd"><ehr:dic dicmeta="GBT226112003" code="${report.gender}" /></td>
				<td title="${report.age}" class="centertd">${report.age}<ehr:dic dicmeta="IDM00003" code="${report.ageUnit}" /></td>
				<td title="${report.infectiousName}">${report.infectiousName}</td>
				<td><ehr:tip><ehr:dic dicmeta="CV0501002" code="${report.caseCategory}"/></ehr:tip></td>
				<td title="${report.fillOrganName}">${report.fillOrganName}</td>
				<td class="centertd"><ehr:dic  dicmeta="GBT6565" code="${report.occupation}" /></td>
				<td class="centertd"><fmt:formatDate value="${report.pathogenesisDate}" pattern="yyyy/MM/dd" /></td>
				<td class="centertd"><ehr:tip><fmt:formatDate value="${report.diagnosisDate}" pattern="yyyy/MM/dd HH:mm:ss" /></ehr:tip></td>
				<td class="centertd"><fmt:formatDate value="${report.fillDate}" pattern="yyyy/MM/dd" /></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<table>
		<tr>
			<ehr:pagination action="brwControl.search" />
		</tr>
	</table>
</div>
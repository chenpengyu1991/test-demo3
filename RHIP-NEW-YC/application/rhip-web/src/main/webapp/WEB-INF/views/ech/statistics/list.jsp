<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<div class="repeattable">
	<table id="echStatisticsTable" class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:200px;width: 20%;"/>
	        <col style="min-width:100px;width: 20%;"/>
			<col style="min-width:100px;width: 20%;"/>
			<col style="min-width:100px;width: 20%;"/>
			<col style="min-width:100px;width: 20%;"/>
		</colgroup>
		<thead>
			<tr>
                <th>机构名称</th>
				<th>老年人管理人数</th>
				<th>老年人已辨识人数</th>
                <th>老年人管理服务率(%)</th>
                <th>完成中医药保健指导人数</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="statistic" items="${statistics}" varStatus="status">
				<tr>
                    <td><ehr:org  code="${statistic.orgCode}"/></td>
                    <td align="right">${statistic.householdNum}</td>
                    <td align="right">${statistic.manageNum}</td>
                    <td class="centertd"><tag:numberLabel value="${statistic.manageRate*100}"  fractionDigits="2" /></td>
                    <td align="right">${statistic.tcmNum}</td>
				</tr>
			</c:forEach>
			<tr>
	            <td class="centertd"><b>合计</b></td>
	            <td align="right">${total.householdNum}</td>
	            <td align="right">${total.manageNum}</td>
	            <td class="centertd"><tag:numberLabel value="${total.manageRate*100}"  fractionDigits="2" /></td>
	            <td align="right">${total.tcmNum}</td>
			</tr>
		</tbody>
	</table>
</div>
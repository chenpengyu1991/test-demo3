<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="repeattable">
	<table>
		<colgroup>
			<col style="width:30px;" />
			<col style="width:40px;" />
			<col style="width:40px;" />
			<col style="width:30px;" />
			<col style="width:30px;" />
			<col style="width:30px;" />
			<col style="width:30px;" />
			<col style="width:40px;" />
		</colgroup>
		<thead>
			<tr>
				<th>监测点编号</th>
				<th>水厂名称</th>
				<th>所在乡镇</th>
				<th>水厂类型</th>
				<th>监测类型</th>
				<th>供水规模</th>
				<th>调查日期</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="monitor" items="${monitorList}">
				<tr>
					<td><a href="javascript:void(0)" onclick="epWaterIodineMonitorSearch.view('${monitor.id}')"><ehr:tip value="${monitor.monitorId}"/></a></td>
					<td>${monitor.factoryName}</td>
					<td><ehr:dic dicmeta="FS990001" code="${monitor.gbCode}" /></td>
                    <td><ehr:dic dicmeta="FS10265" code="${monitor.monitorType}" /></td>
                    <td><ehr:dic dicmeta="FS10264" code="${monitor.factoryType}" /></td>
					<td><ehr:tip value="${monitor.waterSupplyScale}万吨/天"/></td>
					<td><fmt:formatDate value="${monitor.investigateTime}" pattern="yyyy/MM/dd"/></td>
					<td style="text-align: center">
						<a href="javascript:void(0)" onclick="epWaterIodineMonitorSearch.edit('${monitor.id}')">修改</a>
						<a href="javascript:void(0)" onclick="epWaterIodineMonitorSearch.remove('${monitor.id}')">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<tr>
			<ehr:pagination action="epWaterIodineMonitorSearch.search"  />
		</tr>
	</table>
	<input type="hidden" id="_indexPage" value="${indexPage}" />
</div>
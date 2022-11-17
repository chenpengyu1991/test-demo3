<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ep/iodineNutrition/monitorList.js"></script>
<div class="repeattable">
	<table>
		<colgroup>
			<col style="width:30px;" />
			<col style="width:40px;" />
			<col style="width:20px;" />
			<col style="width:20px;" />
			<col style="width:80px;" />
			<col style="width:60px;" />
			<col style="width:50px;" />
			<col style="width:40px;" />
			<col style="width:80px;" />
		</colgroup>
		<thead>
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>身份证</th>
				<th>抽样点</th>
				<th>人群类别</th>
				<th>调查日期</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="monitor" items="${monitorList}">
				<tr>
					<td><a href="javascript:void(0)" onclick="epIodineNutritionMonitorSearch.view('${monitor.id}')"><ehr:tip value="${monitor.surveyNo}" /></a></td>
					<td>${monitor.name}</td>
					<td><ehr:dic dicmeta="GBT226112003" code="${monitor.gender}" /></td>
					<td>${monitor.age}</td>
					<td>${monitor.idCard}</td>
					<td><span name="monitor_sampling" samplingId="${monitor.samplingId}"></span></td>
					<td><ehr:dic dicmeta="FS10273" code="${monitor.crowd}" /></td>
					<td><fmt:formatDate value="${monitor.investigateTime}" pattern="yyyy/MM/dd"/></td>
					<td style="text-align: center">
						<a href="javascript:void(0)" onclick="epIodineNutritionMonitorSearch.edit('${monitor.id}')">修改</a>
						<a href="javascript:void(0)" onclick="epIodineNutritionMonitorSearch.remove('${monitor.id}')">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<tr>
			<ehr:pagination action="epIodineNutritionMonitorSearch.search"  />
		</tr>
	</table>
	<input type="hidden" id="_indexPage" value="${indexPage}" />
</div>
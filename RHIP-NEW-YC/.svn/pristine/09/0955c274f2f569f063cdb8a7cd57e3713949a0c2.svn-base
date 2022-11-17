<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script type="text/javascript">
$(function() {
		$("span[name='operateTime']").each(function() {
			$(this).html(util.formatOperateTime($(this).html()));
		});
		
});
</script>
<div class="repeattable">
<table class="layui-table x-admin-sm-table-list-small">
	<thead>
	<tr>
		<th width="150px">操作时间</th>
		<th width="100px">操作者</th>
		<th width="100px">操作类型</th>
	</tr>
	</thead>
	<c:forEach items="${logList}" var="medicine" varStatus="status">
		<tr>
			<td><span name="operateTime" onclick="medicineSearch.showMedicineLog('${medicine.operateTime}')">${medicine.operateTime}</span></td>
			<td>${medicine.operator}</td>
			<td>${medicine.operateType}</td>
		</tr>
	</c:forEach>
</table>
<table>
	<tr>
		<ehr:pagination action="medicineSearch.searchLog" />
	</tr>
</table>
<input type="hidden" id="medicineCode_log" value="${medicineCode}" />
</div>
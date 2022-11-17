<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<script type="text/javascript">
	$(function() {
		var option = {
			currentPage : ${page.currentPage},
			totalPages : ${page.totalPages},
			totalRows : ${page.totalRows},
			pageSize : ${page.pageSize},
			contextPath : contextPath,
			callback : staffDetail.search
		};
		$("#logPagination").pagination(option);
		staffLogList.atStart();
	});
</script>
<table id="logList" class="repeattable layui-table x-admin-sm-table-list-small">
	<tr>
		<th width="30px"></th>
		<th width="150px">操作时间</th>
		<th width="100px">操作者</th>
		<th width="100px">操作类型</th>
		<th width="100px">人员主索引</th>
		<th width="120px">所在机构</th>
		<th>本地系统标识</th>
	</tr>
	<c:forEach var="log" items="${logList}" varStatus="status">
		<tr>
			<td><input type="checkbox" name="check" class="chk_selectone" value="${log.staffCode}:${log.updateTime}"/></td>
			<td><a name="updateTime" href="#" onclick="staffDetail.viewLogDetail(${log.staffCode},'${log.updateTime}')">${log.updateTime}</a></td>
			<td>${log.updatePerson}</td>
			<td>${log.operateType}</td>
			<td>${log.smpiId}</td>
			<td>${log.organCode}</td>
			<td>${log.localId}</td>
		</tr>
	</c:forEach>
</table>
<div id="logPagination"></div>
<input type="hidden" id="indexPage" value="${indexPage}" />
<div style="text-align: center">
	<!-- <input id="compareBtn" type="button" value="比较" /> -->
	<button class="layui-btn layui-btn-sm"  id="compareBtn">比较</button>
</div>
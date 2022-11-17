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
			callback : personDetail.search
		};
		$("#logPagination").pagination(option);
		personLogList.atStart();
	});
</script>
<table id="logList" class="repeattable layui-table x-admin-sm-table-list-middle" style="text-align: center">
	<tr>
		<th width="30px"></th>
		<th width="150px">操作时间</th>
		<th width="100px">操作者</th>
		<th width="100px">操作类型</th>
		<th width="100px">个人主索引</th>
		<th width="120px">系统域名称</th>
		<th>个人本地系统标识</th>
	</tr>
	<c:forEach var="log" items="${logList}" varStatus="status">
		<tr>
			<td><input type="checkbox" name="check" class="chk_selectone" value="${log.personId}:${log.updateTime}"/></td>
			<td><a name="updateTime" href="#" onclick="personDetail.viewLogDetail(${log.personId},'${log.updateTime}')">${log.updateTime}</a></td>
			<td>${log.updatePerson}</td>
			<td>${log.operateType}</td>
			<td>${log.pmpiId}</td>
			<td>${log.domainId}</td>
			<td>${log.localId}</td>
		</tr>
	</c:forEach>
</table>
<div id="logPagination"></div>
<input type="hidden" id="indexPage" value="${indexPage}" />
<div style="text-align: center">
	<button class="layui-btn layui-btn-sm" id="compareBtn"><i class="layui-icon">&#xe615;</i>比较</button>
</div>
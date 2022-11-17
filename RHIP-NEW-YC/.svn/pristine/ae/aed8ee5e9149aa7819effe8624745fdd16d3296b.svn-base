<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<script type="text/javascript">
//	$(function() {
//		staffList.atStart();
//	});
</script>
<div class="repeattable">
	<table id="staffList">
		<thead>
		<tr>
			<th width="25%">姓名</th>
			<th width="30%">身份证号码</th>
			<th width="20%">性别</th>
			<th width="25%">操作</th>
		</tr>
		</thead>
		<c:forEach var="staff" items="${staffList}" varStatus="status">
			<tr class="${(status.index % 2 == 0) ? 'even' : 'odd'}">
				<td style="text-align:center;">${staff.name}</td>
				<td style="text-align:left;">${staff.idCard}</td>
				<td style="text-align:center;"><ehr:dic dicmeta="GBT226112003" code="${staff.gender}"/></td>
				<td style="text-align:center;">
					<a href="#" onclick="srEdit.selectStaffRow('${staff.name}','${staff.idCard}')">选定</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<table>
		<tr>
			<ehr:pagination action="staffSearch1.search" />
		</tr>
	</table>
	<input type="hidden" id="indexPage" value="${indexPage}" />
</div>

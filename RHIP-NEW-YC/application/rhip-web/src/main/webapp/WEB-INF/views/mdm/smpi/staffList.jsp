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
	<table id="staffList" class="layui-table x-admin-sm-table-list-middle">
		<thead>
		<tr>
			<th width="10%">姓名</th>
			<th width="15%">身份证号码</th>
			<th width="5%">性别</th>
			<th width="10%">本人电话</th>
			<th width="30%">所在机构</th>
			<th width="30%">操作</th>
		</tr>
		</thead>
		<c:forEach var="staff" items="${staffList}" varStatus="status">
			<tr class="${(status.index % 2 == 0) ? 'even' : 'odd'}">
				<td class="centertd" title="${staff.name}"><a href="#" onclick="staffList.showStaffDetail(${staff.staffCode},'${staff.idCard}')">${staff.name}</a></td>
				<%-- <td style="text-align:left;" title="${staff.name}">${staff.name}</td> --%>
				<td class="centertd">${staff.idCard}</td>
				<td class="centertd"><ehr:dic dicmeta="GBT226112003" code="${staff.gender}"/></td><td>${staff.mobile}</td>
				<td>
					<c:forEach var="staffOrg" items="${staff.staffOrgs}" varStatus="status">
						<div><ehr:org code="${staffOrg.organCode}"/></div>
					</c:forEach>
				</td>
				<td class="centertd">
					<%-- <a href="#" onclick="staffEdit.editStaff(${staff.staffCode})">修改</a> --%>
					<a href="#" onclick="staffEdit.editStaff(${staff.staffCode})" title="修改" class="layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe642;</i>修改</a>&nbsp;
					<c:if test="${staff.status ne 0}">
						<%-- <a href="#" onclick="staffEdit.changeStatus(this,'${staff.staffCode}', 0)">禁用</a> --%>
						<a href="#" onclick="staffEdit.changeStatus(this,'${staff.staffCode}', 0)" class="layui-btn layui-btn-danger layui-btn-xs" title="禁用" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#x1006;</i>禁用</a>&nbsp;
					</c:if>
					<c:if test="${staff.status eq 0}">
						<%-- <a href="#" onclick="staffEdit.changeStatus(this,'${staff.staffCode}', 1)">启用</a> --%>
						<a href="#" onclick="staffEdit.changeStatus(this,'${staff.staffCode}', 1)" title="启用" class="layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe605;</i>启用</a>
					</c:if>

				</td>
			</tr>
		</c:forEach>
		<tr>
			<ehr:pagination action="staffSearch.search" colspan="6"/>
		</tr>
	</table>
	<%-- <table>
		<tr>
			<ehr:pagination action="staffSearch.search" />
		</tr>
	</table> --%>
	<input type="hidden" id="indexPage" value="${indexPage}" />
</div>

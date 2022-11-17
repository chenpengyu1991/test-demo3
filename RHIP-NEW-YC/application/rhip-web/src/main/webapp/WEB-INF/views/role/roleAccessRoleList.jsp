<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="repeattable">
    <table id="role-access-role-list-result" class="layui-table x-admin-sm-table-list-small">
		<thead> 
			<tr>
                <th style="width: 10%">编号</th>
				<th style="width: 40%">角色</th>
				<th style="width: 40%">描述</th>
			</tr>
		</thead>
		<tbody> 
			<c:forEach var="role" items="${roles}" varStatus="status">
				<tr  class="role-access-access-setting" data-role-desc="${role.description}" data-role-id="${role.id}" data-role-code="${role.roleCode}">
                    <td class="centertd">${status.count}</td>
					<td>${role.name}</td>
					<td>${role.description}</td>
				</tr>
			</c:forEach> 
	   <tr>
	   	<td colspan="3">
	   		<ehr:paging action="roleAccess.searchRole" />
	   	</td>
	   </tr>
		</tbody> 
	</table>
    <%-- <ehr:paging action="roleAccess.searchRole" /> --%>
</div>

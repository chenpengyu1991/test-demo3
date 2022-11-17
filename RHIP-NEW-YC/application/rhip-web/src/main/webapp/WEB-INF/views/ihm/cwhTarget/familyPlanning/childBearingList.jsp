<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<table class="layui-table x-admin-sm-table-list-middle">
	<colgroup>
		<col style="width: 20%;"/>
		<col style="width: 30%;"/>
		<col style="width: 30%;"/>
		<col style="width: 20%;"/>
	</colgroup>
	<thead>
		<tr>
			<th>姓名</th>
			<th>身份证号</th>
			<th>机构</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="childBearing" items="${childBearingList}" varStatus="status">
			<tr>
				<td style="text-align: center">${childBearing.name}</td>
				<td style="text-align: center">${childBearing.id_card}</td>
				<td style="text-align: center">${childBearing.create_organ_name}</td>
				<td style="text-align: center">
					<a href="javascript:void(0);" onclick="fpSearch.childBearingDetail('${childBearing.id}')" title="查看" class="layui-btn layui-btn-normal layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe615;</i>查看</a>&nbsp;&nbsp;
				</td>
			</tr>
		</c:forEach>
		<tr>
			<ehr:pagination action="fpSearch.search" colspan="4"/>
		</tr>
	</tbody>
</table>


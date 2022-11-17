<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script
	src="${pageContext.request.contextPath}/js/views/oh/enterprise/equipmentList.js"
	type="text/javascript"></script>
<input type="hidden" id="enterpriseId" name="enterpriseId"
	value="${enterpriseId}">
<div class="toolbar">
	<a href="javascript:void(0)" onclick="javascript:enterpriseAdd.returnSearch()"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
	<c:if test="${type == 'add'}">
		<a href="javascript:equipmentList.initAdd()"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
	</c:if>
	<c:if test="${type == 'edit'}">
		<a href="javascript:equipmentList.initAdd()"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
	</c:if>
</div>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width: 60px; width: 10%;" />
			<col style="min-width: 120px; width: 22%;" />
			<col style="min-width: 40px; width: 15%;" />
			<col style="min-width: 100px; width: 15%;" />
			<col style="min-width: 100px; width: 10%;" />
			<col style="min-width: 100px; width: 10%;" />
			<col style="min-width: 100px; width: 18%;" />
		</colgroup>
		<thead>
			<tr>
				<th >序号</th>
				<th >车间</th>
				<th >设备名称</th>
				<th >设备型号</th>
				<th >功率</th>
				<th >台数</th>
				<th >操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="equipment" items="${equipment.list}"
				varStatus="status">
				<tr>
					<td title="${equipment.seqNo}" class="centertd">${equipment.seqNo}</td>
					<td title="${equipment.workshopName}">${equipment.workshopName}</td>
					<td title="${equipment.equipmentName}">${equipment.equipmentName}</td>
					<td title="${equipment.model}">${equipment.model}</td>
					<td><ehr:tip>${equipment.powerl}</ehr:tip></td>
					<td class="righttd" title="${equipment.count}">${equipment.count}</td>
					<td class="centertd">
						<c:if test="${type != 'view'}">
							<a href="javascript:void(0);"  onclick="equipmentList.initEdit('${equipment.id}')" title="修改"><i class="layui-icon">&#xe642;</i></a>&nbsp;&nbsp;
							<a href="javascript:void(0);"  onclick="equipmentList.del('${equipment.id}')" title="删除"><i class="layui-icon">&#xe640;</i></a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<table>
		<tr>
			<ehr:pagination action="equipmentList.search" />
		</tr>
	</table>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag"%>
<script src="${pageContext.request.contextPath}/js/views/oh/radiologyDepDoc/fsfhqk/qtfhcsList.js" type="text/javascript"></script>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width:4%;"/>
			<col style="width:10%;"/>
			<col style="width:15%;"/>
			<col style="width:26%;"/>
			<col style="width:20%;">
		</colgroup>
		<thead>
			<tr>
				<th class="centerth">序号</th>
				<th class="centerth">分类</th>
				<th class="centerth">警示标识/报警仪名称</th>
				<th class="centerth">安装位置</th>
				<th class="centerth">数量</th>
				<th class="centerth">操作</th>
			</tr>
		</thead>
		<tbody class="tbody">
			<c:forEach items="${infoRecords}" var="record" varStatus="status">
				<tr>
					<td class="centertd">
					    <ehr:serial-number index="${status.index }" currentPage="${page.currentPage }" pageSize="${page.pageSize }"></ehr:serial-number>
					</td>
					<td class="centertd" title="<ehr:dic dicmeta="OH00005" code="${record.type}"></ehr:dic>"><ehr:dic dicmeta="OH00005" code="${record.type}"></ehr:dic></td>
					<td title="${record.name}">${record.name}</td>
					<td title="${record.caution}">${record.caution}</td>
					<td class="righttd" title="${record.count}">${record.count}</td>
					<td class="centertd">
						<a href="javascript:void(0);" class="qtfhcsListModify" onclick="fsfhqk.updateCautionAlarmRecord('${record.id}')" title="修改"><i class="layui-icon">&#xe642;</i></a>&nbsp;&nbsp;
						<a href="javascript:void(0);" class="qtfhcsListDelete"  onclick="fsfhqk.deleteCautionAlarmRecord('${record.id}')" title="删除"><i class="layui-icon">&#xe640;</i></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		<ehr:pagination action="fsfhqk.searchCautionAlarm" colspan="6" />
	</table>
</div>


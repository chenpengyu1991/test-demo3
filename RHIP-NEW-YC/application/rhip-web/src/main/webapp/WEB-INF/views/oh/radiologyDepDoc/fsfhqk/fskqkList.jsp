<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag"%>
<script src="${pageContext.request.contextPath}/js/views/oh/radiologyDepDoc/fsfhqk/fskqkList.js" type="text/javascript"></script>
<div>
	<div class="repeattable">
		<table id="machineHouseArea_record_table" class="layui-table x-admin-sm-table-list-middle">
			<colgroup>
				<col style="width:4%;"/>
				<col style="width:7%;">
				<col style="width:15%;"/>
				<col style="width:5%;"/>
				<col style="width:5%;"/>
				<col style="width:5%;"/>
				<col style="width:6%;"/>
				<col style="width:6%;"/>
				<col style="width:6%;"/>
				<col style="width:6%;"/>
				<col style="width:6%;"/>
				<col style="width:6%;"/>
				<col style="width:6%;"/>
				<col style="width:7%;">
				<col style="width:10%;"/>
			</colgroup>
			<thead>
				<tr>
					<th class="centerth">序号</th>
					<th class="centerth">分类</th>
					<th class="centerth">场所名称</th>
					<th class="centerth">长(m)</th>
					<th class="centerth">宽(m)</th>
					<th class="centerth">高(m)</th>
					<th class="centerth">面积(㎡)</th>
					<th class="centerth">四周墙体</th>
					<th class="centerth">机房顶</th>
					<th class="centerth">防护大门</th>
					<th class="centerth">防护小门</th>
					<th class="centerth">窗户</th>
					<th class="centerth">机房地面</th>
					<th class="centerth">防护铅玻璃</th>
					<th class="centerth">操作</th>
				</tr>
			</thead>
			<tbody class="tbody">
				<c:forEach items="${infoRecords}" var="record" varStatus="status">
					<tr>
						<td class="centertd">
						    <ehr:serial-number index="${status.index }" currentPage="${page.currentPage }" pageSize="${page.pageSize }"></ehr:serial-number>
						</td>
						<td class="centertd" title="<ehr:dic dicmeta="OH00006" code="${record.type }"></ehr:dic>">
						    <ehr:dic dicmeta="OH00006" code="${record.type }"></ehr:dic>
						</td>
						<td title="${record.name }">${record.name }</td>
						<td class="righttd" title="${record.length }">${record.length }</td>
						<td class="righttd" title="${record.width }">${record.width }</td>
						<td class="righttd" title="${record.height }">${record.height }</td>
						<td class="righttd" title="${record.area }">${record.area }</td>
						<td title="${record.aroundWall }">${record.aroundWall }</td>
						<td title="${record.roof }">${record.roof }</td>
						<td title="${record.gate }">${record.gate }</td>
						<td title="${record.wicket }">${record.wicket }</td>
						<td title="${record.windows }">${record.windows }</td>
						<td title="${record.ground }">${record.ground }</td>
						<td title="${record.leadGlass }">${record.leadGlass }</td>
						<td class="centertd">
							<a href="javascript:void(0);" class="fskqkListModify" onclick="fsfhqk.updateMachineRoomRecord('${record.id}')" title="修改"><i class="layui-icon">&#xe642;</i></a>&nbsp;&nbsp;
							<a href="javascript:void(0);" class="fskqkListDelete" onclick="fsfhqk.deleteMachineRoomRecord('${record.id}')" title="删除"><i class="layui-icon">&#xe640;</i></a>
						</td>
					<tr>
				</c:forEach>
			</tbody>
			<ehr:pagination action="fsfhqk.searchMachineRoom" colspan="15" />
		</table>
	</div>
</div>

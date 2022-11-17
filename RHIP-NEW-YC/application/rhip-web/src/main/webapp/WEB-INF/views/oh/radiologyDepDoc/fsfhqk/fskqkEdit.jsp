<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/oh/radiologyDepDoc/fsfhqk/fskqkEdit.js" type="text/javascript"></script>
<input id="ohMachineRoomOperationType" type="hidden" value="${ohMachineRoomOperationType }">
<div>
	<div class="postcontent">
		<form method="post" id="machineRoom_form">
			<input name="id" type="hidden" value="${record.id }">
			<input name="isDelete" type="hidden" value="0">
			<input id="typeValue" name="typeValue" type="hidden" value="${record.type}">
				<fieldset class="layui-elem-field">
					<legend>放射科情况</legend>
					<table style="width: 99%" class="posttable">
						<tbody>
						<colgroup>
							<col width="40%" />
							<col width="40%" />
						<colgroup>
						<tr>
						    <th><label>机房类别</label></th>
						    <td><ehr:dic-radio dicmeta="OH00006" id="type" name="type" value="${record.type}" onchange="fskqkEdit.typeChange()"></ehr:dic-radio></td>
						</tr>
						<tr>
							<th><label id="name">机房名称:</label></th>
							<td><input type="text" class="x-layui-input" name="name" value="${record.name}" reg='{"maxlength":"16"}'></td>
						</tr>
						<tr>
							<th><label>长(m):</label></th>
							<td><tag:numberInput reg="{'min':0,'max':9999.9}" id="length" point="point" name="length" value="${record.length}" style="width: 80px" /></td>
						</tr>
						<tr>
							<th><label>宽(m):</label></th>
							<td><tag:numberInput reg="{'min':0,'max':9999.9}" id="width" point="point" name="width" value="${record.width}" style="width: 80px" /></td>
						</tr>
						<tr>
							<th><label>高(m):</label></th>
							<td><tag:numberInput reg="{'min':0,'max':9999.9}" id="height" point="point" name="height" value="${record.height}" style="width: 80px" /></td>
						</tr>
						<tr>
							<th><label>面积(㎡):</label></th>
							<td><tag:numberInput reg="{'min':0,'max':9999.9}" id="area" point="point" name="area" value="${record.area}" style="width: 80px" /></td>
						</tr>
						<tr>
							<th><label>四周墙体:</label></th>
							<td><input type="text" class="x-layui-input" name="aroundWall" value="${record.aroundWall }" reg='{"maxlength":"16"}'><td>
						</tr>
						<tr>
							<th><label>机房顶:</label></th>
							<td><input type="text" class="x-layui-input" name="roof" value="${record.roof}" reg='{"maxlength":"16"}'></td>
						</tr>
						<tr>
							<th><label>防护大门:</label></th>
							<td><input type="text" class="x-layui-input" name="gate" value="${record.gate}" reg='{"maxlength":"16"}'></td>
                        </tr>
                        <tr>
							<th><label>防护小门:</label></th>
							<td><input type="text" class="x-layui-input" name="wicket" value="${record.wicket}" reg='{"maxlength":"16"}'></td>
						</tr>
						<tr>
							<th><label>窗户:</label></th>
							<td><input type="text" class="x-layui-input" name="windows" value="${record.windows}" reg='{"maxlength":"16"}'></td>
                        </tr>
                        <tr>
							<th><label>机房地面:</label></th>
							<td><input type="text" class="x-layui-input" name="ground" value="${record.ground}" reg='{"maxlength":"16"}'></td>
						</tr>
						<tr>
							<th><label>防护铅玻璃:</label></th>
							<td><input type="text" class="x-layui-input" name="leadGlass" value="${record.leadGlass}" reg='{"maxlength":"16"}'></td>
                        </tr>
						</tbody>
					</table>
				</fieldset>
		</form>
		<div style="text-align: center">
			<a id="saveRecord" href="javascript:fskqkEdit.save()" ><button class="layui-btn layui-btn-sm">保存</button></a>
			<a id="cancleRecord" href="javascript:fskqkEdit.cancle()" ><button class="layui-btn layui-btn-sm">关闭</button></a>
		</div>
	</div>
</div>

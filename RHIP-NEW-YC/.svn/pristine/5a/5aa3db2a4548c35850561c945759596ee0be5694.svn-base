<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag"%>
<script src="${pageContext.request.contextPath}/js/views/oh/radiologyDepDoc/fsfhqk/qtfhcsEdit.js" type="text/javascript"></script>

<input id="ohCautionAlarmOperationType" type="hidden" value="${ohCautionAlarmOperationType }">
<div>
	<div class="postcontent">
		<form method="post" id="cautionAlarm_form">
			<input name="id" type="hidden" value="${record.id }">
			<input name="isDelete" type="hidden" value="0">
			<input id="typeValue" type="hidden" value="${record.type }">
				<fieldset class="layui-elem-field">
					<legend>其他防护措施</legend>
					<table style="width: 99%" class="posttable">
						<tbody>
						<colgroup>
							<col width="40%" />
							<col width="60%" />
						<colgroup>
						<tr>
						    <th><label>分类</label></th>
						    <td><ehr:dic-radio dicmeta="OH00005" id="type" name="type" value="${record.type}" onchange="qtfhcsEdit.typeChange()"></ehr:dic-radio></td>
						</tr>
						<tr>
							<th><label id="name" class="required">警示标识/报警仪名称:</label></th>
							<td><input type="text" class="x-layui-input" name="name" value="${record.name}" reg='{"required":"true","maxlength":"16"}'></td>
						</tr>
						<tr>
							<th><label>安装位置:</label></th>
							<td><input type="text" class="x-layui-input" name="caution" value="${record.caution}" reg='{"maxlength":"16"}'></td>
						</tr>
						<tr>
							<th><label class="required">数量:</label></th>
							<td><input type="text" class="x-layui-input" name="count" value="${record.count}" reg='{"required":"true","maxlength":"2","regex":"^\\d+$"}' tip="请输入数字"></td>
						</tr>
						</tbody>
					</table>
				</fieldset>
		</form>
		<div style="text-align: center">
			<a id="saveRecord" href="javascript:qtfhcsEdit.save()" ><button class="layui-btn layui-btn-sm">保存</button></a>
			<a id="cancleRecord" href="javascript:qtfhcsEdit.cancle()" ><button class="layui-btn layui-btn-sm">关闭</button></a>
		</div>
	</div>
</div>

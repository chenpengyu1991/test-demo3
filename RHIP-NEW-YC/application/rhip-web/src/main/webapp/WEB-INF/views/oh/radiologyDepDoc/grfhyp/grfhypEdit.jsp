<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag"%>
<script src="${pageContext.request.contextPath}/js/views/oh/radiologyDepDoc/grfhyp/grfhypEdit.js" type="text/javascript"></script>
<input id="ohProtectiveEquipmentOperationType" type="hidden" value="${ohProtectiveEquipmentOperationType }">
<div>
	<div class="postcontent">
		<form method="post" id="protectiveEquipment_form">
			<input name="id" type="hidden" value="${record.id }">
			<input name="isDelete" type="hidden" value="0">
				<fieldset class="layui-elem-field">
					<legend>个人防护用品</legend>
					<table style="width: 99%" class="posttable">
						<tbody>
						<colgroup>
							<col width="40%" />
							<col width="60%" />
						<colgroup>
						<tr>
							<th><label class="required">个人防护用品名称:</label></th>
							<td><input type="text" class="x-layui-input" name="name" value="${record.name}" reg='{"required":"true","maxlength":"16"}'></td>
						</tr>
						<tr>
							<th><label>防护铅当量:</label></th>
							<td><input type="text" class="x-layui-input" name="leadEquivalent" value="${record.leadEquivalent}" reg='{"maxlength":"16"}'></td>
						</tr>
						<tr>
							<th><label class="required">数量:</label></th>
							<td><input type="text" class="x-layui-input" name="count" value="${record.count}" reg='{"required":"true","maxlength":"8","regex":"^\\d+$"}' tip="请输入数字"></td>
						</tr>
						</tbody>
					</table>
				</fieldset>
		</form>
		<div style="text-align: center">
			<a id="saveRecord" href="javascript:grfhypEdit.save()" ><button class="layui-btn layui-btn-sm">保存</button></a>
			<a id="cancleRecord" href="javascript:grfhypEdit.cancle()" ><button class="layui-btn layui-btn-sm">关闭</button></a>
		</div>
	</div>
</div>

<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script type="text/javascript">
$(function() {
	/* $("#cancelButton").click(function(e) {
		e.preventDefault();
		var dialogId = $("#d2");
		if (dialogId.length == 1) {
			$.removeDialog("d2");
		} else {
			$.removeDialog("d1");
		}
	}); */
	
	$("#cancelButton").click(function(e) {
		layer.closeAll();
	});
});
</script>

<div>
	<div style="padding-left: 15px; padding-right: 15px; width: auto;">
		<fieldset class="layui-elem-field">
			<legend>药物基本信息:</legend>
			<table class="formtable">
				<tr>
					<th>药物级别</th>
					<td><ehr:dic dicmeta="FS10242" code="${medicine.levelCode}" /></td>
				</tr>
				<tr>
					<th>申报编码</th>
					<td>${medicine.medicineCode}</td>
				</tr>
				<tr>
					<th>通用名</th>
					<td>${medicine.commonName}</td>
				</tr>
				<tr>
					<th>商品名</th>
					<td>${medicine.productName}</td>
				</tr>
				<tr>
					<th>类别一级</th>
					<td>${medicine.categoryNameOne}</td>
				</tr>
				<tr>
					<th>类别二级</th>
					<td>${medicine.categoryNameTwo}</td>
				</tr>
				<tr>
					<th>类别三级</th>
					<td>${medicine.categoryNameThree}</td>
				</tr>
				<tr>
					<th>规格</th>
					<td>${medicine.specification}</td>
				</tr>
				<tr>
					<th>剂型</th>
					<td>${medicine.dosage}</td>
				</tr>
				<tr>
					<th>单位</th>
					<td>${medicine.unit}</td>
				</tr>
				<tr>
					<th>包装材质</th>
					<td>${medicine.material}</td>
				</tr>
				<tr>
					<th>转换比</th>
					<td>${medicine.packageSize}</td>
				</tr>
				<tr>
					<th>生产企业</th>
					<td>${medicine.manufactory}</td>
				</tr>
				<tr>
					<th>状态</th>
					<td>
						<c:if test="${medicine.status eq -1}">作废</c:if>
						<c:if test="${medicine.status eq 1}">有效</c:if>
					</td>
				</tr>
			</table>
		</fieldset>
		<p style="margin-top: 15px;" align="center">
			<!-- <input type="button" id="cancelButton" name="save" value="关 闭" class="btnopr" /> -->
			<button class="layui-btn layui-btn-sm" id="cancelButton">关闭</button>
		</p>
	</div>
</div>

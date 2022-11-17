<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script type="text/javascript">
$(function() {
	var validate = $("#medicineForm").easyValidate();
	$("#saveButton").click(function(e) {
		e.preventDefault();
		if (validate.validateForm()) {
			$("#medicineForm").submitFormGetJson({
				url : "/mdmMedicine/save",
				callback : submitCallback,
				param : {
					type : $("#type").val()
				}
			});
		}
	});
	
	var options = {
			selectFirst: false,
			minChars: 0,
			dataType: "json",
			formatItem: formatItem,
			parse: parse
		};
	var url = contextPath + "/mdmMedicine/getCategoryNameOne";
	$("#categoryNameOne_input").autocomplete(url, options);
	
	var url2 = contextPath + "/mdmMedicine/getCategoryNameTwo";
	$("#categoryNameTwo_input").autocomplete(url2, options);
	
	var url3 = contextPath + "/mdmMedicine/getCategoryNameThree";
	$("#categoryNameThree_input").autocomplete(url3, options);
	
	var url4 = contextPath + "/mdmMedicine/getDosage";
	$("#dosage_input").autocomplete(url4, options);
	
	$("#cancelButton").click(function(e) {
		layer.closeAll();
		/* $.removeDialog("d1"); */
	});
}); 

function formatItem(row) { 
	return row; 
}

function parse(data) {
	var parsed = [];
	//var rows = eval(data);
	var rows = data;
	if (rows && rows.length > 0) {
		for (var i=0; i < rows.length; i++) {
			var row = rows[i];
			if (row) {
				parsed[parsed.length] = {
					data: row,
					value: row,
					result: row
				};
			}
		}
	}
	return parsed;
}

function submitCallback(data) {
	layer.alert(data.message, {icon:0,title:'提示'}, function(){
		if (data.result) {
			/* $.removeDialog("d1"); */
			layer.closeAll();
			medicineSearch.search($("#indexPage").val());
		}
	});
}

function log(data) {
	$("#messageDiv").append("<span>" + data + "</span>");
}

</script>

<div>
	<div style="padding-left: 15px; padding-right: 15px; width: auto;">
		<form:form id="medicineForm" modelAttribute="medicine">
			<fieldset class="layui-elem-field">
				<legend>药物基本信息:</legend>
				<table class="formtable">
					<tr>
						<th><label class="required">药物级别</label></th>
						<td>
							<form:select path="levelCode" reg='{"required":"true"}' cssClass="x-layui-input">
								<form:option value="">==请选择==</form:option>
								<ehr:dicItems dicmeta="FS10242" value="${medicine.levelCode}"></ehr:dicItems>
							</form:select>
						</td>
					</tr>
					<tr>
						<th><label class="required">申报编码</label></th>
						<td>
							<c:if test="${empty medicine.medicineCode}">
								<form:input path="medicineCode" reg='{"required":"true"}' cssClass="x-layui-input" />
								<input type="hidden" id="type" value="add" />
							</c:if>
							<c:if test="${not empty medicine.medicineCode}">
								${medicine.medicineCode}
								<form:hidden path="medicineCode" cssClass="x-layui-input" />
								<input type="hidden" id="type" value="edit" />
							</c:if>
						</td>
					</tr>
					<tr>
						<th><label class="required">通用名</label></th>
						<td><form:input path="commonName" reg='{"required":"true"}' cssClass="x-layui-input" /></td>
					</tr>
					<tr>
						<th>商品名</th>
						<td><form:input path="productName" cssClass="x-layui-input" /></td>
					</tr>
					<tr>
						<th><label class="required">类别一级</label></th>
						<td><form:input path="categoryNameOne" id="categoryNameOne_input" reg='{"required":"true"}'  cssClass="x-layui-input" /></td>
					</tr>
					<tr>
						<th><label class="required">类别二级</label></th>
						<td><form:input path="categoryNameTwo" id="categoryNameTwo_input" reg='{"required":"true"}' cssClass="x-layui-input" /></td>
					</tr>
					<tr>
						<th><label class="required">类别三级</label></th>
						<td><form:input path="categoryNameThree" id="categoryNameThree_input" reg='{"required":"true"}' cssClass="x-layui-input" /></td>
					</tr>
					<tr>
						<th><label class="required">规格</label></th>
						<td><form:input path="specification" reg='{"required":"true"}' cssClass="x-layui-input" /></td>
					</tr>
					<tr>
						<th><label class="required">剂型</label></th>
						<td><form:input path="dosage" id="dosage_input" reg='{"required":"true"}' cssClass="x-layui-input" /></td>
					</tr>
					<tr>
						<th>单位</th>
						<td><form:input path="unit" cssClass="x-layui-input" /></td>
					</tr>
					<tr>
						<th>包装材质</th>
						<td><form:input path="material" cssClass="x-layui-input" /></td>
					</tr>
					<tr>
						<th><label class="required">转换比</label></th>
						<td><form:input path="packageSize" reg='{"required":"true","digits":"true"}' cssClass="x-layui-input" /></td>
					</tr>
					<tr>
						<th><label class="required">生产企业</label></th>
						<td><form:input path="manufactory" reg='{"required":"true"}'  cssClass="x-layui-input" /></td>
					</tr>
				</table>
			</fieldset>
		</form:form>
		<p style="margin-top: 15px;" align="center">
			<!-- <input type="button" id="saveButton" value="保 存" class="btnopr" /> --> 
			<button class="layui-btn layui-btn-sm" id="saveButton">保存</button>
			<!-- <input type="button" id="cancelButton" value="关 闭" class="btnopr" /> -->
			<button class="layui-btn layui-btn-sm" id="cancelButton">关闭</button>
		</p>
		<div id="messageDiv" style="margin: 5px;"></div>
	</div>
</div>

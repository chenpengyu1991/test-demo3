<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
$(function() {
	var validate = $("#dictionaryForm").easyValidate();
	$("#saveButton").click(function() {
		if (validate.validateForm()) {
			$("#dictionaryForm").submitFormGetJson({
				url : "/mdmDictionary/saveDicMate",
				callback : submitCallback,
				param : {
					type : $("#type").val()
				}
			});
		}
	});
	
	$("#cancelButton").click(function() {
		/* $.removeDialog("d1"); */
		layer.closeAll();
	});
	
}); 

function submitCallback(data) {
	var index = layer.alert(data.message, {icon:0,title:'提示'}, function(){
		if (data.result) {
			/* $.removeDialog("d1"); */
			layer.close(index);
			layer.close(index-1);//编辑或创建窗口
			dictionarySearch.search($("#indexPage").val());
		}	
	});
}
</script>

<div>
	<div style="padding-left: 15px; padding-right: 15px; width: auto;">
		<form:form id="dictionaryForm" modelAttribute="dictionary">
			<fieldset class="layui-elem-field">
				<legend>字典基本信息:</legend>
				<table class="formtable">
					<tr>
						<th><label class="required">字典编码</label></th>
						<td>
							<c:if test="${empty dictionary.dicCode}">
								<form:input path="dicCode" reg='{"required":"true"}' cssClass="x-layui-input" />
								<input type="hidden" id="type" value="add" />
							</c:if>
							<c:if test="${not empty dictionary.dicCode}">
								${dictionary.dicCode}
								<form:hidden path="dicCode" />
								<input type="hidden" id="type" value="edit" />
							</c:if>
						</td>
					</tr>
					<tr>
						<th><label class="required">字典名称</label></th>
						<td><form:input path="dicName" reg='{"required":"true"}' cssClass="x-layui-input" /></td>
					</tr>
					<tr>
						<th><label class="required">字典分类</label></th>
						<td>
							<form:select path="categoryId" reg='{"required":"true"}'  cssClass="x-layui-input" >
								<form:option value="" label="==请选择=="/>
								<form:options items="${categoryList}" itemLabel="itemName" itemValue="itemCode"/>
							</form:select>
						</td>
					</tr>
					<tr>
						<th>描述</th>
						<td><form:input path="describe" cssClass="x-layui-input" /></td>
					</tr>
				</table>
			</fieldset>
		</form:form>
		<p style="margin-top: 15px;" align="center">
			<!-- <input type="button" id="saveButton" name="save" value="保 存" class="btnopr" /> --> 
			<button class="layui-btn layui-btn-sm" id="saveButton">保存</button>
			<!-- <input type="button" id="cancelButton" name="save" value="关 闭" class="btnopr" /> -->
			<button class="layui-btn layui-btn-sm" id="cancelButton">关闭</button>
		</p>
		<div id="messageDiv" style="margin: 5px;"></div>
	</div>
</div>

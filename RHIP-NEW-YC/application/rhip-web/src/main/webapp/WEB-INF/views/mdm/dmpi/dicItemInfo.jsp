<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
$(function() {
	var validate = $("#dicItemForm").easyValidate();
	$("#saveButton").click(function(e) {
		e.preventDefault();
		if (validate.validateForm()) {
			$("#dicItemForm").submitFormGetJson({
				url : "/mdmDictionary/saveDicItem",
				callback : submitCallback,
				param : {
					type : $("#type").val()
				}
			});
		}
	});
	
	$("#cancelButton").click(function(e) {
		e.preventDefault();
		layer.closeAll();
		/* $.removeDialog("d1"); */
	});
	
	
}); 

function submitCallback(data) {
	layer.alert(data.message, {icon:0,title:'提示'}, function(){
		if (data.result) {
			/* $.removeDialog("d1"); */
			layer.closeAll();
			dicItemSearch.itemSearch($("#items_indexPage").val());
		}	
	});
}
</script>

<div>
	<div style="padding-left: 15px; padding-right: 15px; width: auto;">
		<form:form id="dicItemForm" modelAttribute="dicItem">
			<fieldset class="layui-elem-field">
				<legend>字典项信息:</legend>
				<table class="formtable">
					<tr>
						<th><label class="required">项目编码</label></th>
						<td>
							<c:if test="${empty dicItem.itemCode}">
								<form:input path="itemCode" reg='{"required":"true"}' cssClass="x-layui-input" />
								<input type="hidden" id="type" value="add" />
							</c:if>
							<c:if test="${not empty dicItem.itemCode}">
								${dicItem.itemCode}
								<form:hidden path="itemCode" />
								<input type="hidden" id="type" value="edit" />
							</c:if>
						</td>
					</tr>
					<tr>
						<th><label class="required">项目名称</label></th>
						<td>
							<form:input path="itemName" reg='{"required":"true"}' cssClass="x-layui-input" />
							<form:hidden path="dicCode" value="${dicCode}"/>
						</td>
					</tr>
				</table>
			</fieldset>
		</form:form>
		<p style="margin-top: 15px;" align="center">
			<!-- <input type="button" id="saveButton" name="save" value="保 存" class="btnopr" />  -->
			<button class="layui-btn layui-btn-sm" id="saveButton">保存</button>
			<!-- <input type="button" id="cancelButton" name="save" value="关 闭" class="btnopr" /> -->
			<button class="layui-btn layui-btn-sm" id="cancelButton">关闭</button>
		</p>
		<div id="messageDiv" style="margin: 5px;"></div>
	</div>
</div>

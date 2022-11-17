<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script type="text/javascript">
$(function() {
	var validate = $("#diseaseForm").easyValidate();
	$("#saveButton").click(function(e) {
		e.preventDefault();
		if (validate.validateForm()) {
			$("#diseaseForm").submitFormGetJson({
				url : "/mdmDisease/save",
				callback : submitCallback,
				param : {
					type : $("#type").val()
				}
			});
		}
	});
	
	$("#cancelButton").click(function() {
		layer.closeAll();
		/* $.removeDialog("d1"); */
	});
});

function submitCallback(data) {
	layer.alert(data.message, {icon:0,title:'提示'}, function(){
		if (data.result) {
			/* $.removeDialog("d1"); */
			layer.closeAll();
			diseaseSearch.search($("#indexPage").val());
		}
	});
}
</script>

<div>
	<div style="padding-left: 15px; padding-right: 15px; width: auto;">
	  <form:form id="diseaseForm" modelAttribute="disease">
		<fieldset class="layui-elem-field">
			<legend>疾病信息:</legend>
			<table class="formtable">
				<tr>
					<th><label class="required">主要编码</label></th>
					<td>
						<c:if test="${empty disease.icd10main}">
							<form:input path="icd10main" reg='{"required":"true"}'  />
							<input type="hidden" id="type" value="add" />
						</c:if>
						<c:if test="${not empty disease.icd10main}">
							${disease.icd10main}
							<form:hidden path="icd10main" />
							<input type="hidden" id="type" value="edit" />
						</c:if>
					</td>
				</tr>
				<tr>
					<th>附加编码</th>
					<td><form:input path="icd10ext" /></td>
				</tr>
				<tr>
					<th><label class="required">疾病名称</label></th>
					<td><form:input path="diseaseName" reg='{"required":"true"}' /></td>
				</tr>
			</table>
		</fieldset>
	  </form:form>
	  <p style="margin-top: 15px;" align="center">
	  	<button class="layui-btn layui-btn-sm" id="saveButton">保存</button>
		<!-- <input type="button" id="saveButton" value="保 存" class="btnopr" />  -->
		<!-- <input type="button" id="cancelButton" value="关 闭" class="btnopr" /> -->
		<button class="layui-btn layui-btn-sm" id="cancelButton">关闭</button>
	  </p>
	</div>
</div>

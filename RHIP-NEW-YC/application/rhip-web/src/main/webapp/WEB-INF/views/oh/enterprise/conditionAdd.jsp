<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script type="text/javascript">
var organizationInfoEdit = (function() {
	var validate = null;
	$(function() {
		validate = $("#conditionForm").easyValidate();
		$("#cancelButton").click(function() {
			layer.closeAll();
		});
		
		$("#saveButton").click(function() {
			if (validate.validateForm()) {
				//$("#hidden_address").val($("#address_county").html()+$("#address_townShip").find("option:selected").text()+$("#address_detail").val());
				$("#conditionForm").submitFormGetJson({
					url : "/oh/enterpriseDoc/saveCondition",
					callback : submitCallback,
					param : {
						type : $("#conditionForm #type").val()
					}
				});
			}
		});
		
	});	
	
	function submitCallback(data) {
		if (data.result) {
			var index = layer.alert(data.message, {icon:0,title:'提示'}, function() {
				/*$.removeDialog("healthEducationResource");*/
				layer.closeAll();
				$("#condition_btn").click();
			});
		} else {
			layer.alert(data.message, {icon:0,title:'提示'});
		}
	}
	
})();
	
</script>
<div>
	<div class="postcontent">
	  <form:form id="conditionForm" modelAttribute="condition" >
	  	<form:hidden path="enterpriseInfoId" />
	  	<form:hidden path="id" />
	  	<form:hidden path="isDelete" value="0" />
	  	<input type="hidden" id="type" value="${type}" />
		<fieldset class="layui-elem-field">
			<legend>职业卫生基本情况:</legend>
			<table class="formtable">
				<tr>
					<th ><label class="required">职工总数</label></th>
					<td><form:input path="employeeNum" reg='{"required":"true","digits":"true","maxlength":"11"}'/></td>
				</tr>
				<tr>
					<th ><label class="required">女工总数</label></th>
					<td><form:input path="workingwomanNum" reg='{"required":"true","digits":"true","maxlength":"11"}'/></td>
				</tr>
				<tr>
					<th><label class="required">生产工人数</label></th>
					<td><form:input path="workerNum" reg='{"required":"true","digits":"true","maxlength":"11"}' /></td>
				</tr>
				<tr>
					<th>粉尘接触人数</th>
					<td><form:input path="dustNum"  reg='{"digits":"true","maxlength":"11"}' /></td>
				</tr>
				<tr>
					<th>毒物接触人数</th>
					<td><form:input path="poisonNum"  reg='{"digits":"true","maxlength":"11"}' /></td>
				</tr>
				<tr>
					<th>物理因素</th>
					<td><form:input path="physicalFactorNum"  reg='{"digits":"true","maxlength":"11"}' /></td>
				</tr>
				<tr>
					<th>其他</th>
					<td><form:input path="otherNum"  reg='{"digits":"true","maxlength":"11"}' /></td>
				</tr>
			</table>
		</fieldset>
		</form:form>
		<p style="margin-top: 15px;" align="center">
			<a id="saveButton" href="javascript:void(0)" ><button class="layui-btn layui-btn-sm">保存</button></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a id="cancelButton" href="javascript:void(0)" ><button class="layui-btn layui-btn-sm">关闭</button></a>
		</p>
	</div>
</div>

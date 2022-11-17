<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script type="text/javascript">
var organizationInfoEdit = (function() {
	var validate = null;
	$(function() {
		validate = $("#equipmentForm").easyValidate();
		$("#cancelButton").click(function() {
			layer.closeAll();
		});
		
		$("#saveButton").click(function() {
			if (validate.validateForm()) {
				//$("#hidden_address").val($("#address_county").html()+$("#address_townShip").find("option:selected").text()+$("#address_detail").val());
				$("#equipmentForm").submitFormGetJson({
					url : "/oh/enterpriseDoc/saveEquipment",
					callback : submitCallback,
					param : {
						type : $("#equipmentForm #type").val()
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
				$("#equipment_btn").click();
			});
		} else {
			layer.alert(data.message, {icon:0,title:'提示'});
		}
	}
	
})();
	
</script>
<div>
	<div class="postcontent">
	  <form:form id="equipmentForm" modelAttribute="equipment" >
	  	<form:hidden path="enterpriseInfoId" />
	  	<form:hidden path="id" />
	  	<form:hidden path="isDelete" value="0" />
	  	<input type="hidden" id="type" value="${type}" />
		<fieldset class="layui-elem-field">
			<legend>主要生产设备:</legend>
			<table class="formtable">
				<tr>
					<th>序号</th>
					<td><form:input path="seqNo" reg='{"maxlength":"20"}'/></td>
				</tr>
				<tr>
					<th><label class="required">车间</label></th>
					<td><form:input path="workshopName" reg='{"required":"true","maxlength":"20"}'/></td>
				</tr>
				<tr>
					<th><label class="required">设备名称</label></th>
					<td><form:input path="equipmentName" reg='{"required":"true","maxlength":"20"}'/></td>
				</tr>
				<tr>
					<th>型号</th>
					<td><form:input path="model" reg='{"maxlength":"20"}' /></td>
				</tr>
				<tr>
					<th>功率</th>
					<td><form:input path="powerl" reg='{"maxlength":"20"}' /></td>
				</tr>				
				<tr>
					<th><label class="required">台数</label></th>
					<td><form:input path="count" reg='{"required":"true","digits":"true","maxlength":"5"}' /></td>
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

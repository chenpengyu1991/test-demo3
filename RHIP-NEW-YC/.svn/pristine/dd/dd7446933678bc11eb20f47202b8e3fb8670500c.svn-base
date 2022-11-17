<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script type="text/javascript">
var organizationInfoEdit = (function() {
	var validate = null;
	$(function() {
		validate = $("#chemicalsUsedForm").easyValidate();
		$("#cancelButton").click(function() {
			layer.closeAll();
		});
		
		$("#saveButton").click(function() {
			if (validate.validateForm()) {
				//$("#hidden_address").val($("#address_county").html()+$("#address_townShip").find("option:selected").text()+$("#address_detail").val());
				$("#chemicalsUsedForm").submitFormGetJson({
					url : "/oh/enterpriseDoc/saveChemicalsUsed",
					callback : submitCallback,
					param : {
						type : $("#chemicalsUsedForm #type").val()
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
				$("#chemicals_used_btn").click();
			});
		} else {
			layer.alert(data.message, {icon:0,title:'提示'});
		}
	}
	
})();
	
</script>
<div>
	<div class="postcontent">
	  <form:form id="chemicalsUsedForm" modelAttribute="chemicalsUsed" >
	  	<form:hidden path="enterpriseInfoId" />
	  	<form:hidden path="id" />
	  	<form:hidden path="isDelete" value="0" />
	  	<input type="hidden" id="type" value="${type}" />
		<fieldset class="layui-elem-field">
			<legend>使用化学物质:</legend>
			<table class="formtable">
				<tr>
					<th ><label class="required">车间</label></th>
					<td><form:input path="workshopName" reg='{"required":"true","maxlength":"50"}'/></td>
				</tr>
				<tr>
					<th ><label class="required">化学物质名称</label></th>
					<td><form:input path="chemicalName" reg='{"required":"true","maxlength":"50"}'/></td>
				</tr>
				<tr>
					<th>来源</th>
					<td><form:input path="source"  reg='{"maxlength":"50"}' /></td>
				</tr>
				<tr>
					<th ><label class="required">年产量/使用量</label></th>
					<td><form:input path="harvestUsageAmount" reg='{"required":"true","maxlength":"20"}'/></td>
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

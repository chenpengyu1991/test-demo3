<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script type="text/javascript">
var organizationInfoEdit = (function() {
	var validate = null;
	$(function() {
		validate = $("#contactSituationForm").easyValidate();
		$("#cancelButton").click(function() {
			layer.closeAll();
		});
		
		$("#saveButton").click(function() {
			if (validate.validateForm()) {
				//$("#hidden_address").val($("#address_county").html()+$("#address_townShip").find("option:selected").text()+$("#address_detail").val());
				$("#contactSituationForm").submitFormGetJson({
					url : "/oh/enterpriseDoc/saveContactSituation",
					callback : submitCallback,
					param : {
						type : $("#contactSituationForm #type").val()
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
				$("#contact_situation_btn").click();
			});
		} else {
			layer.alert(data.message, {icon:0,title:'提示'});
		}
	}
	
})();
	
</script>
<div>
	<div class="postcontent">
	  <form:form id="contactSituationForm" modelAttribute="contactSituation" >
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
					<th ><label class="required">岗位</label></th>
					<td><form:input path="position" reg='{"required":"true","maxlength":"50"}'/></td>
				</tr>
				<tr>
					<th ><label class="required">危害因素</label></th>
					<td><form:input path="hazardFactorsName" reg='{"required":"true","maxlength":"20"}'/></td>
				</tr>
				<tr>
					<th><label class="required">接触人数（男）</label></th>
					<td><form:input path="manNum" reg='{"required":"true","digits":"true","maxlength":"5"}'  /></td>
				</tr>
				<tr>
					<th><label class="required">接触人数（女）</label></th>
					<td><form:input path="womanNum" reg='{"required":"true","digits":"true","maxlength":"5"}' /></td>
				</tr>
				<tr>
					<th>防护措施</th>
					<td><form:input path="safeguardProcedures" reg='{"maxlength":"50"}'/></td>
				</tr>
				<tr>
					<th>个人防护措施</th>
					<td><form:input path="protectiveMeasures" reg='{"maxlength":"100"}'/></td>
				</tr>
				<tr>
					<th>日接触时间</th>
					<td><form:input path="dayContactTime" reg='{"maxlength":"100"}'/></td>
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

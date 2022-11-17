<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link href="${pageContext.request.contextPath}/js/fineuploader/fineuploader-3.4.1.css" rel="stylesheet"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/fineuploader/jquery.fineuploader-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}/js/views/he/upload/upload.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() {
	healthEducationUpload.uploadFile("miniUrl","/he/upload/uploadFile/ohjcshyt","/he/upload/deleteFile/ohjcshyt");
});

var organizationInfoEdit = (function() {
	var validate = null;
	$(function() {
		validate = $("#testItemsForm").easyValidate();
		$("#cancelButton").click(function() {
			layer.closeAll();
		});
		
		$("#saveButton").click(function() {
			if (validate.validateForm()) {
				//$("#hidden_address").val($("#address_county").html()+$("#address_townShip").find("option:selected").text()+$("#address_detail").val());
				$("#testItemsForm").submitFormGetJson({
					url : "/oh/enterpriseDoc/saveTestItem",
					callback : submitCallback,
					param : {
						type : $("#testItemsForm #type").val()
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
				$("#test_items_btn").click();
			});
		} else {
			layer.alert(data.message, {icon:0,title:'提示'});
		}
	}
	
})();
	
</script>
<div >
	<div class="postcontent">
	  <form:form id="testItemsForm" modelAttribute="testItem" >
	  	<form:hidden path="enterpriseInfoId" />
	  	<form:hidden path="id" />
	  	<form:hidden path="isDelete" value="0" />
	  	<input type="hidden" id="type" value="${type}" />
		<fieldset class="layui-elem-field">
			<legend>监测点示意图:</legend>
			<table class="formtable">
				<tr>
					<th>编号</th>
					<td><form:input path="code" reg='{"maxlength":"20"}'/></td>
				</tr>
				<tr>
					<th width="30%"> <label class="required">岗位（应测点）</label></th>
					<td><form:input path="position" reg='{"required":"true","maxlength":"20"}'/></td>
				</tr>
				<tr>
					<th ><label class="required">应测项目</label></th>
					<td><form:input path="testItem"  reg='{"required":"true","maxlength":"20"}' /></td>
				</tr>
				<tr>
					<th><label class="required">采机时机说明</label></th>
					<td><form:input path="explain" reg='{"required":"true","maxlength":"50"}'/></td>
				</tr>
				<tr>
					<th><label class="required">车间</label></th>
					<td ><form:input path="workshopName" reg='{"required":"true","maxlength":"20"}'/></td>
				</tr>
				<tr>
					<th>制图日期</th>
					<td>
						<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="drawDate" id="drawDate" value="<fmt:formatDate value='${testItem.drawDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
					</td>
				</tr>
				<tr>
					<th>示意图</th>
					<td style="width: 80px;"><div id="miniUrl"></div>
					<span style="color: blue;">附件支持jpeg, jpg, gif, png格式，单个附件请控制在5M之内</span>
					<form:hidden path="miniUrl" />
					</td>
					<!-- <th>示意图</th>
					<td><input type="file" name="miniUrl"  /></td> -->
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

<script type="text/javascript">
	layui.use('laydate', function(){
		var laydate = layui.laydate;

		laydate.render({
			elem: '#drawDate'
			,format: 'yyyy/MM/dd'
			,max:0
			,trigger: 'click'
			,value: new Date()
		});
	});
</script>
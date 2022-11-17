<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script type="text/javascript">
var departmentInfoEdit = (function() {
	$(function() {
		var validate = $("#editForm").easyValidate();
		$("#cancelButton").click(function(e) {
			e.preventDefault();
			layer.closeAll();
		});
		
		$("#saveButton").click(function(e) {
			e.preventDefault();
			if (validate.validateForm()) {
				$("#editForm").submitFormGetJson({
					url : "/mdmDepartment/save",
					callback : submitCallback,
					param : {
						type : $("#type").val()
					}
				});
			}
		});
		
	});
	
	function submitCallback(data) {
		layer.alert(data.message, {icon:0,title:'提示'}, function(){
			if (data.result) {
				layer.closeAll();
				departmentSearch.search($("#indexPage").val());
			}
		});
	}
	
	return {
		
	};
})();
</script>

<div>
	<div style="padding-left: 15px; padding-right: 15px; width: auto;">
	  <form:form id="editForm" modelAttribute="department">
		<fieldset class="layui-elem-field">
			<legend>基本信息:</legend>
			<table class="formtable">
				<tr>
					<th><label>机构名称</label></th>
					<td><label><ehr:org code="${department.organCode}" /></label></td>
				</tr>
				<tr>
					<th><label class="required">科室编码</label></th>
					<td>
						<c:if test="${empty department.deptCode}">
							<form:input path="deptCode" reg='{"required":"true"}' />
							<input type="hidden" id="type" value="add" />
						</c:if>
						<c:if test="${not empty department.deptCode}">
							${department.deptCode}
							<form:hidden path="deptCode" />
							<input type="hidden" id="type" value="edit" />
						</c:if>
					</td>
				</tr>
				<tr>
					<th><label class="required">科室名称</label></th>
					<td><form:input path="deptName" size="40" reg='{"required":"true"}' />
						    <form:hidden path="organCode" /></td>
				</tr>
				<tr>
					<th>电话</th>
					<td><form:input path="tel" reg='{"phone":"true"}'  /></td>
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
	</div>
</div>

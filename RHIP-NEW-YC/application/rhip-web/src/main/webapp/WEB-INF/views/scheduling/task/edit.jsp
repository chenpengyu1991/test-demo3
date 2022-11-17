<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<div class="toolbar">
		<a href="javascript:void(0)" id="scheduling-task-update-btn" ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
	</div>
	<div class="postcontent">
		<form id="scheduling-task-edit-form">
			<input type="hidden" value="${task.name}" name="taskName">
				<fieldset class="layui-elem-field">
					<legend>任务信息</legend>
					<table class="formtable">
						<tr>
							<th><label class="required">任务实例</label></th>
							<td><select style="min-width: 180px" reg='{"required":"true","maxlength":"60"}' name="taskBeanName">
									<option value="">请选择</option>
									<c:forEach items="${taskNames}" var="name">
										<option value="${name}" ${task.beanName eq name ?'selected':'' } data-cron="${taskDeatils[name].cron}" data-description="${taskDeatils[name].description}">${name}${taskDeatils[name].description}</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<th><label class="required">任务描述</label></th>
							<td><input class="x-layui-input" reg='{"required":"true","maxlength":"80"}' value="${task.description }" type="text" name="taskDescription" /></td>
						</tr>
						<tr>
							<th><label>参数</label></th>
							<td><textarea class="x-layui-input" rows="5" name="param" >${task.param}</textarea></td>
						</tr>
					</table>
				</fieldset>
		</form>
	</div>
</div>
<script type="text/javascript">
	!(function() {
		var validate;
		$(function() {
			validate = $("#scheduling-task-edit-form").easyValidate();
			$("#scheduling-task-update-btn").click(function() {
				var result = validate.validateForm();
				if (!result)
				{
					return;
				}

				$("#scheduling-task-edit-form").submitFormGetJson({
					url : "/task/updateTask",
					callback : submitCallback,
				});
			});

		});

		function submitCallback(data) {
			if(true==data){
				layer.alert("保存成功！", {icon:0,title:'提示'}, function(index) {
					$.removeDialog("d1");
					taskSearch.refresh();
					layer.closeAll();
				});
			}else{
				layer.alert("保存失败！", {icon:0,title:'提示'});
			}
			
		}
	})();
</script>
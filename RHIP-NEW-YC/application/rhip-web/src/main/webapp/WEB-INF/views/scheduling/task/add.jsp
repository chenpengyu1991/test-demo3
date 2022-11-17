<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<div class="toolbar">
		<a href="javascript:void(0)" id="scheduling-task-add-btn" ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
	</div>
	<div class="postcontent">
		<form id="scheduling-task-form">
				<fieldset class="layui-elem-field">
					<legend>任务信息</legend>
					<table class="formtable">
						<tr>
							<th><label class="required">任务实例</label></th>
							<td><select style="min-width: 180px" reg='{"required":"true","maxlength":"60"}' name="taskBeanName">
									<option value="">请选择</option>
									<c:forEach items="${taskNames}" var="name">
										<option value="${name}" data-cron="${taskDeatils[name].cron}" data-description="${taskDeatils[name].description}">${name}${taskDeatils[name].description}</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<th><label class="required">任务描述</label></th>
							<td><input class="x-layui-input" reg='{"required":"true","maxlength":"80"}' type="text" name="taskDescription" /></td>
						</tr>
						<tr>
							<th><label>参数</label></th>
							<td><textarea class="x-layui-input" rows="5" reg='{"maxlength":"500"}' name="param"></textarea></td>
						</tr>
						<tr>
							<th><label title="执行计划,可以不填">cronExpression</label></th>
							<td><input class="x-layui-input" reg='{"maxlength":"30","remote":"${pageContext.request.contextPath}/task/isValidCronExpression"}' type="text"
								name="cronExpression"
							/></td>
						</tr>
					</table>
					<jsp:include page="cronExpression.jsp"></jsp:include>
				</fieldset>
		</form>
	</div>
</div>
<script type="text/javascript">
	!(function() {
		var validate;
		$(function() {
			validate = $("#scheduling-task-form").easyValidate();
			$("#scheduling-task-add-btn").click(function() {
				var result = validate.validateForm();
				if (!result)
				{
					return;
				}

				$("#scheduling-task-form").submitFormGetJson({
					url : "/task/save",
					callback : submitCallback
				});
			});
			$("#scheduling-task-form").find("select").change(function() {
				var $selectedOption = $(this).find("option:selected");
				if ($selectedOption.val())
				{
					var desc = $selectedOption.data("description");
					 $("#scheduling-task-form").find("input[name='taskDescription']").val(desc);
					var cron = $selectedOption.data("cron");
					 $("#scheduling-task-form").find("input[name='cronExpression']").val(cron);
				}
			});
		});

		function submitCallback(data) {
			if (true == data)
			{
				layer.alert("添加成功！", {icon:0,title:'提示'}, function(index) {
					$.removeDialog("d1");
					taskSearch.refresh();
					layer.closeAll();
				});
			} else
			{
				layer.alert("添加失败！", {icon:0,title:'提示'});
			}

		}
	})();
</script>
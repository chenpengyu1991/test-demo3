<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<link href="${pageContext.request.contextPath}/js/fineuploader/fineuploader-3.4.1.css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/fineuploader/jquery.fineuploader-3.4.1.js"></script>
<div class="section">
	<div class="toolbar">
		<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">系统管理</a>
		        <a href="javascript:void(0)">任务调度</a>
		        <a>
		          <cite>任务管理</cite></a>
		      </span>
		</div>
	</div>
	<div class="searchbox searchSection x-admin-sm">
		<form id="searchForm">
			<table id="searchTable">
				<colgroup>
					<col style="width: 10%">
					<col style="width: 40%">
					<col style="width: 50%">
				</colgroup>
				<tbody>
					<tr>
						<td class="coltext">任务描述</td>
						<td class="colinput"><input type="text" name="taskDescription" style="width: 150px;" /></td>
						<td class="righttd">
							<button class="layui-btn layui-btn-sm" id="btnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
						</td>
					</tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td class="colbottom"><span class="ico-bottom" onclick="toggle(this,'searchTable')">&nbsp;</span></td>
				</tr>
			</table>
		</form>
	</div>
	<div class="toolbarSection">
		<a href="javascript:void(0)" id="btnAdd"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
		<a href="javascript:void(0)" id="btnExport"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导出</button></a>
		<a href="javascript:void(0)" id="btnImport"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe62f;</i>导入</button></a>
	</div>
	<div id="listDiv"></div>
</div>
<script type="text/javascript">
	var taskSearch = (function() {
		$(function() {
			$("#searchForm").onEnter(search, 1);
			$("#btnSearch").click(function(e) {
				e.preventDefault();
				search(1);
			});
			$("#btnAdd").click(function() {
				addTask();
			});
			$("#btnExport").click(exportList);
			$("#btnImport").click(importList);
			search(1);
		});

		var currentIndexPage = 1;

		function search(indexPage) {
			currentIndexPage = indexPage;
			var searchObj = {
				url : "/task/listResult",
				insertDiv : "listDiv",
				param : {
					indexPage : indexPage
				}
			};
			$("#searchForm").submitFormLoadHtml(searchObj);
		}

		function refresh() {
			search(currentIndexPage);
		}

		function addTask() {

			$.post(contextPath+"/task/add",
					function(ret){
						layui.use(['layer'], function() {
							var layer = layui.layer
							layer.open({
								type: 1,
								id:'d1',
								area: ['650px', '430px'],
								title:'增加任务',
								content: ret
							});
						});
					});
		}

		function viewTask(taskName) {
			$.post(contextPath+"/task/getTask",
					{
						taskName : taskName
					},
					function(ret){
						layui.use(['layer'], function() {
							var layer = layui.layer
							layer.open({
								type: 1,
								id:'d1',
								area: ['800px', '500px'],
								title:'查看任务',
								content: ret
							});
						});
					});
		}

		function runTask(taskName) {
			var option = {
				url : "/task/run",
				param : {
					taskName : taskName
				},
				callback : function(data) {
					if (true == data)
					{
						layer.alert("执行成功！", {icon:0,title:'提示'}, function(index) {
							refresh();
							layer.close(index);
						});
					} else
					{
						layer.alert("执行失败！", {icon:0,title:'提示'});
					}
				}
			};
			$.getJsonByUrl(option);
		}
		
		function sendCommond(url, param, message, callback) {
			var p = param || {};
			var option = {
				url : url,
				param : p,
				callback : function(data) {
					if (true == data)
					{
						layer.alert(message+"成功！", {icon:0,title:'提示'}, function(index) {
							if (callback)
							{
								callback();
							}
							layer.close(index);
						});
					} else
					{
						layer.alert(message+"失败！", {icon:0,title:'提示'});
					}
				}
			};
			$.getJsonByUrl(option);
		}

		function pauseTask(taskName) {
			sendCommond( "/task/pause",{
				taskName : taskName
			},"暂停",refresh);
			
		}

		function resumeTask(taskName) {
			sendCommond( "/task/resume",{
				taskName : taskName
			},"恢复",refresh);
		}

		function editTask(taskName) {
			$.post(contextPath+"/task/editTask",
					{
						taskName : taskName
					},
					function(ret){
						layui.use(['layer'], function() {
							var layer = layui.layer
							layer.open({
								type: 1,
								id:'d1',
								area: ['650px', '400px'],
								title:'修改任务',
								content: ret
							});
						});
					});
		}

		function removeTask(jobName) {
			layer.confirm("确定删除吗？", {icon:2, title:'确认提示'}, function(index) {
				var option = {
					url : "/task/remove",
					param : {
						jobName : jobName
					},
					callback : function(data) {
						if (true == data)
						{
							layer.alert("删除成功！", {icon:0,title:'提示'}, function(index) {
								refresh();
								layer.close(index);
							});
						} else
						{
							layer.alert("删除失败！", {icon:0,title:'提示'});
						}
					}
				};
				$.getJsonByUrl(option);
				layer.close(index);
			});
		}
		
		function exportList(){
			window.open(contextPath+"/task/export");
		}
		
		function importList(){
			$.post(contextPath+"/task/importPage",
					function(ret){
						layui.use(['layer'], function() {
							var layer = layui.layer
							layer.open({
								type: 1,
								id:'scheduling-task-import-dia',
								area: ['400px', '200px'],
								title:'导入任务',
								content: ret
							});
						});
					});
		}

		return {
			search : search,
			runTask : runTask,
			removeTask : removeTask,
			viewTask : viewTask,
			editTask : editTask,
			refresh : refresh,
			pauseTask : pauseTask,
			resumeTask : resumeTask

		};
	})();
</script>
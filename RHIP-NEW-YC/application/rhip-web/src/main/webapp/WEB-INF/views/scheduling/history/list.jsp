<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<div class="section">
	<div class="toolbar">
	
		<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">系统管理</a>
		        <a href="javascript:void(0)">任务调度</a>
		        <a>
		          <cite>历史记录</cite></a>
		      </span>
		</div>
	</div>
	<div class="searchbox searchSection x-admin-sm">
		<form id="searchForm">
			<table id="searchTable">
				<colgroup>
					<col style="width: 10%">
					<col style="width: 20%">
					<col style="width: 20%">
				</colgroup>
				<tbody>
					<tr>
						<td class="coltext">任务描述</td>
						<td class="colinput"><input type="text" name="taskDescription" style="width: 150px;" /></td>
						<td class="lefttd">
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
	<div id="listDiv"></div>
</div>
<script type="text/javascript">
	var taskHistorySearch = (function() {
		$(function() {
			$("#searchForm").onEnter(search, 1);
			$("#btnSearch").click(function(e) {
				e.preventDefault();
				search(1);
			});
			search(1);
		});

		var currentIndexPage = 1;

		function search(indexPage) {
			currentIndexPage = indexPage;
			var searchObj = {
				url : "/task/history/listResult",
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
		
		function showDetailException(target){
			var $a=$(target);
			var message=$a.text();
			layer.alert(message, {icon:0,title:'提示'});
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

		return {
			search : search,
			refresh : refresh,
			showDetailException:showDetailException,
			viewTask:viewTask
		};
	})();
</script>
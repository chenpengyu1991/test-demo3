<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<jsp:include page="../layouts/load-js-css-resources.jsp"></jsp:include>

<div class="section">
	<div class="toolbar">
	
		<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">系统管理</a>
		        <a>
		          <cite>系统参数</cite>
                </a>
		      </span>
		</div>
	</div>
	<div class="searchbox searchSection x-admin-sm">
		<form id="searchForm">
			<table id="searchTable">
				<colgroup>
					<col style="width: 8%">
					<col style="width: 20%">
					<col style="width: 8%">
                    <col style="width: 20%">
                    <col style="width: 5%">
					<col style="width: 20%">
					<col style="width: 20%">
				</colgroup>
				<tbody>
					<tr>
						<td class="coltext">参数名称</td>
						<td class="colinput"><input type="text" name="name" style="width: 150px;" /></td>
						<td class="coltext">描述</td>
                        <td class="colinput" colspan="3"><input type="text" name="description" style="width: 150px;" /></td>
<%--						<td class="coltext">值</td>
                        <td class="colinput"><input type="text" name="value" style="width: 150px;" /></td>--%>
						<td class="lefttd">
							<button class="layui-btn layui-btn-sm" id="btnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
						</td>
					</tr>
				</tbody>
			</table>
			<table>
				<tr>
					<td class="colbottom"><span class="ico-bottom" onclick="toggle(this,'sysConfigSearch')">&nbsp;</span></td>
				</tr>
			</table>
		</form>
	</div>
	<div class="toolbarSection">
		<a id="sys-config-add-btn">
			<button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button>
		</a>
	</div>
	<div id="listDiv">
		<jsp:include page="list.jsp"></jsp:include>
	</div>
</div>
<script type="text/javascript">
	var sysConfigSearch = (function() {
		$(function() {
			$("#searchForm").onEnter(search, 1);
			$("#btnSearch").click(function(e) {
				e.preventDefault();
				search(1);
			});

			$("#sys-config-add-btn").click(function(e) {
				e.preventDefault();
				modifyConfig("新增参数配置",{});
			});
			$("#listDiv").on("click", ".modifyConfigBtn", function() {
				var id = $(this).attr("data-id");
				if (!id)
				{
					return;
				}
				var param={id:id};
				modifyConfig("修改参数配置",param);
			});

			search(1);
		});

		var currentIndexPage = 1;

		function search(indexPage) {
			currentIndexPage = indexPage;
			var searchObj = {
				url : "/standParameterCfg/list",
				insertDiv : "listDiv",
				param : {
					indexPage : indexPage
				}
			};
			$("#searchForm").submitFormLoadHtml(searchObj);
		}

		function modifyConfig(titleName,param) {
			$.post(contextPath+"/standParameterCfg/modifyConfig",
					param,
					function(ret){
						layui.use(['layer'], function() {
							var layer = layui.layer
							layer.open({
								type: 1,
								id:'d1',
								area: ['800px', '500px'],
								title:titleName,
								content: ret
							});
						});
					});
		}
		return {
			search : search
		};
	})();
</script>
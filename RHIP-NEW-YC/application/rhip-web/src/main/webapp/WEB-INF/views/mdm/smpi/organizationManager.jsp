<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<script type="text/javascript">
var organizationManager = (function(){
	$(function() {
		$("#organizationList").click(function(e) {
			e.preventDefault();
			baseLayoutLoad.pushMainContent("/mdmOrganization/search");
		});
		$("#publishVersion").click(function() {
			var index = layer.confirm("确定发布新版本吗？", {icon:1, title:'确认提示'}, function(){
				layer.close(index);
				var params = {
						url : "/mdmOrganization/publishVersion",
						callback : publishVersionCallback
				};
				$.getJsonByUrl(params);
			});
		});
		$("#download").click(function(e) {
			e.preventDefault();
			location.href = contextPath + "/mdmOrganization/downLoadCurrent";
		});
		$("#upload").click(function(e) {
			e.preventDefault();
		    var file = $("#importFile").val();
			if(file == null || file == "") {
				layer.alert("请选择需要导入的文件！", {icon:0,title:'提示'});
				return;
			}
			if (file.indexOf(".csv") < 0) {
				layer.alert("导入文件必须是CSV格式！", {icon:0,title:'提示'});
				return;
			}
			
			$("#waitMessage").show();
			$("#upload").hide();
			$.ajaxFileUpload({
	            url: contextPath+"/mdmOrganization/upload",
	            secureuri:false,
	            fileElementId:'importFile',
	            dataType: 'json',
	            success: uploadCallback,
	            error: function (data, status, e) {layer.alert(e, {icon:0,title:'提示'});}
			});
		});
	});

	function uploadCallback(data) {
		layer.alert(data.message, {icon:0,title:'提示'}, function(index){
			$("#waitMessage").hide();
			$("#upload").show();
			layer.close(index);
		});
	}

	function publishVersionCallback(data) {
		layer.alert(data.message, {icon:0,title:'提示'}, function(index){
			if (data.result) {
				$("#currentVersion").html(data.version);
			}
			layer.close(index);
		});
	}

	function downTemplate() {
		location.href = contextPath + "/mdmOrganization/downTemplate";
	}
	
	return {
        downTemplate : downTemplate
	};
})();


</script>

<div class="section">
	<table class="formtable">
		<tr>
			<th>导出最新版</th>
			<td>
				<!-- <input type="button" value="导出"  id="download" class="btnopr" /> -->
				<button class="layui-btn layui-btn-sm" id="download">导出</button>
			</td>
		</tr>
		<tr>
			<th>导入机构</th>
			<td>
				<input name="file" type="file" id="importFile" style="width: 300px;" />
			</td>
		</tr>
		<tr>
			<th></th>
			<td>
				<!-- <input type="button" value="导入"  id="upload" class="btnopr" /> -->
				<button class="layui-btn layui-btn-sm" id="upload">导入</button>
				<span id="waitMessage" style="display:none;color:green;">导入处理中，请稍等...</span>
			</td>
		</tr>
		<tr>
			<th>导入帮助</th>
			<td><a href="javascript:void(0)" onclick="organizationManager.downTemplate()">下载模板</a></td>
		</tr>
	</table>
</div>

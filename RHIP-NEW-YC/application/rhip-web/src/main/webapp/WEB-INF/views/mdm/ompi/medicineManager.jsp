<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<script type="text/javascript">
var madicineManager = (function(){
	$(function() {
		$("#medicineList").click(function() {
			baseLayoutLoad.pushMainContent("/mdmMedicine/search");
		});
		$("#publishVersion").click(function() {
			layer.confirm("确定发布新版本吗？", {icon:1, title:'确认提示'}, function(){
				var params = {
						url : "/mdmMedicine/publishVersion",
						callback : publishVersionCallback
				};
				$.getJsonByUrl(params);
			});
		});
		$("#download").click(function() {
			location.href = contextPath + "/mdmMedicine/downLoadCurrent";
		});
		$("#upload").click(function() {
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
	            url: contextPath+"/mdmMedicine/upload",
	            secureuri:false,
	            fileElementId:'importFile',
	            dataType: 'json',
	            success: uploadCallback,
	            error: function (data, status, e) {layer.alert(e, {icon:0,title:'提示'});}
			});
		});
	});

	function uploadCallback(data) {
		layer.alert(data.message, {icon:0,title:'提示'}, function(){
			$("#waitMessage").hide();
			$("#upload").show();
		});
	}

	function publishVersionCallback(data) {
		layer.alert(data.message, {icon:0,title:'提示'}, function(){
			if (data.result) {
				$("#currentVersion").html(data.version);
			}
		});
	}

	function downTemplate() {
		location.href = contextPath + "/mdmMedicine/downTemplate";
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
			<th>导入药物</th>
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
			<td><a href="javascript:void(0)" onclick="madicineManager.downTemplate()">下载模板</a></td>
		</tr>
	</table>
</div>

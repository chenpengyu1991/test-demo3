<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<script type="text/javascript">
var viewImport = (function(){
	$(function() {
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
	            url: contextPath+"/mdmDictionary/upload",
	            secureuri:false,
	            fileElementId:'importFile',
	            data : {dicCode : $("#diccode_upload").val()},
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
	
	function downTemplate(dicCode) {
		location.href = contextPath + "/mdmDictionary/downTemplate?dicCode=" + dicCode;
	}
	
	return {
		downTemplate : downTemplate
	};
})();
</script>

<div>
	<table class="formtable">
        <colgroup>
            <col style="width: 30%;">
            <col style="width: 70%;">
        </colgroup>
		<tr>
			<th>编码</th>
			<td>${dictionary.dicCode}</td>
		</tr>
		<tr>
			<th>名称</th>
			<td>${dictionary.dicName}</td>
		</tr>
		<tr>
			<th>导入</th>
			<td>
				<input name="file" type="file" id="importFile" style="width: 300px;" />
				<input name="dicCode"  id="diccode_upload"  type="hidden" value="${dictionary.dicCode}" />
			</td>
		</tr>
		<tr>
			<th></th>
			<td>
				<!-- <input type="button" value="导入"  id="upload" class="btnopr" /> -->
				<button class="layui-btn layui-btn-sm" id="upload">保存</button>
				<span id="waitMessage" style="display:none;color:green;">导入处理中，请稍等...</span>
			</td>
		</tr>
		<tr>
			<th>导入帮助</th>
			<td><a href="javascript:void(0)" onclick="viewImport.downTemplate('${dictionary.dicCode}')">下载模板</a></td>
		</tr>
	</table>
</div>

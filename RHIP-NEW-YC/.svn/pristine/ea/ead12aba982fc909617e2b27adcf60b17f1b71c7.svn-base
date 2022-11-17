<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<script type="text/javascript">
var viewImport = (function(){
	$(function() {
		$("#upload").click(function() {
		    var file = $("#importFile").val();
			if(file == null || file == "") {
				layui.use('layer', function(){
        			var layer = layui.layer;
        			layer.alert("请选择需要导入的文件！", {icon:0,title:'提示'});
        		});
				return;
			}
			
			if (file.indexOf(".xls") < 0 && file.indexOf(".xlsx") < 0) {
				layui.use('layer', function(){
        			var layer = layui.layer;
        			layer.alert("导入文件必须是xls或xlsx格式！", {icon:0,title:'提示'});
        		});
				return;
			}
			
			$("#waitMessage").show();
			$("#upload").hide();
			$.ajaxFileUpload({
	            url: contextPath+"/life/upload",
	            secureuri:false,
	            fileElementId:'importFile',
	            data : {},
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
	
	function downTemplate(format) {
		location.href = contextPath + "/life/downTemplate?format="+format;
	}
	
	return {
		downTemplate : downTemplate
	};
})();
</script>

<div>
	<table class="formtable">
        <colgroup>
            <col style="width: 25%;">
            <col style="width: 35%;">
            <col style="width: 40%;">
        </colgroup>
		<tr>
			<th>导入</th>
			<td colspan="2">
				<input name="file" type="file" id="importFile" style="width: 300px;" />
			</td>
		</tr>
		<tr>
			<th></th>
			<td>
				<%-- <input type="button" value="导入"  id="upload" class="btnopr" /> --%>
				<button class="layui-btn layui-btn-sm" id="upload"><i class="layui-icon">&#xe62f;</i>导入</button>
				<span id="waitMessage" style="display:none;color:green;">导入处理中，请稍等...</span>
			</td>
			<td/>
		</tr>
		<tr>
			<th>导入帮助</th>
			<td><a href="javascript:void(0)" onclick="viewImport.downTemplate('xls')">下载模板（xls）</a></td>
			<td><a href="javascript:void(0)" onclick="viewImport.downTemplate('xlsx')">下载模板（xlsx）</a></td>
		</tr>
	</table>
</div>

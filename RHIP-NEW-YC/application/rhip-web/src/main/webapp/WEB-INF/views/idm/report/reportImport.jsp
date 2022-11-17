<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<script type="text/javascript">
var viewImport1 = (function(){
	$(function() {
		$("#upload").click(function() {
		    var file = $("#importFile").val();
			if(file == null || file == "") {
				layer.alert("请选择需要导入的文件！", {icon:0,title:'提示'});
				return;
			}
			if (file.indexOf(".xls") < 0) {
				layer.alert("导入文件必须是xls格式！", {icon:0,title:'提示'});
				return;
			}
			
			$("#waitMessage").show();
			$("#upload").hide();
			$.ajaxFileUpload({
	            url: contextPath+"/idm/report/upload",
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
	
	function downTemplate() {
		location.href = contextPath + "/idm/report/downTemplate";
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
			<th>导入</th>
			<td>
				<input name="file" type="file" id="importFile" style="width: 300px;" />
			</td>
		</tr>
		<tr>
			<th></th>
			<td>
				<input type="button" value="导入"  id="upload" class="btnopr" />
				<span id="waitMessage" style="display:none;color:green;">导入处理中，请稍等...</span>
			</td>
		</tr>
		<tr>
			<th>导入帮助</th>
			<td><a href="javascript:void(0)" onclick="viewImport1.downTemplate()">下载模板</a></td>
		</tr>
	</table>
</div>

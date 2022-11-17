
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="margin-left: 5px;margin-top: 5px;">请选择任务调度配置XML文件导入</div>
<div style="padding-left: 10px;padding-top: 10px;">
	<div id="scheduling-task-upload-div" style="position: relative"></div>
</div>
<script type="text/javascript">
	!(function() {

		$(function() {
			initUploadFile("scheduling-task-upload-div", "/task/import");
		});

		function errorHandler(event, id, fileName, reason, xhr) {
			layer.alert(reason, {icon:0,title:'提示'});
			return true;
		}

		function completeHadnler(event, id, name, response) {

			if (response.success)
			{
				layer.alert("导入成功！", {icon:0,title:'提示'}, function(index){
					close();
					layer.close(index);
				});
			}
		}

		function close() {
			$.removeDialog("scheduling-task-import-dia");
			taskSearch.refresh();
		}

		function initUploadFile(id, uploadURL) {
			$("#" + id).fineUploader({
				request : {
					endpoint : contextPath + uploadURL
				},
				validation : {
					allowedExtensions : [ 'xml' ],
					sizeLimit : 5227520
				// 5 MB = 5 * 1024 * 1024 bytes
				},
				retry : {
					showButton : true
				},
				deleteFile : {
					enabled : false
				},
				display : {
					fileSizeOnSubmit : true,
					prependFiles : false
				},

				text : {
					uploadButton : "选择文件",
					waitingForResponse : "上传中",
					failedUpload : "导入失败",
					deleteFile : "删除"
				}
			}).on('error', errorHandler).on("complete", completeHadnler);
		}

	})();
</script>
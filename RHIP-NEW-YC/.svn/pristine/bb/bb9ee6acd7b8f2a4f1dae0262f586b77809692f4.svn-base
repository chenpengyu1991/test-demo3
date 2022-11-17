var healthEducationUpload = (function() {
	function uploadFile(id, uploadURL, deleteURL) {

		$("#"+id).fineUploader({
			request: {
				endpoint: contextPath + uploadURL
			},
			validation: {
				allowedExtensions: ['jpeg', 'jpg', 'gif', 'png','doc','docx','xls','xlsx','ppt','pptx','txt','pdf','exe'],
                itemLimit: 5,
				sizeLimit: 10485760 // 10 MB = 10 * 1024 * 1024 bytes
			},
			retry: {
				showButton: true
			},
			deleteFile: {
				enabled: true,
				endpoint: contextPath + deleteURL
			},
			text: {
				uploadButton: "上传附件",
				waitingForResponse: "上传中",
				failedUpload: "上传失败",
				deleteFile: "删除"
			}
		});
	}

	function uploadOrganizationLinkFile(id, uploadURL, deleteURL) {

		$("#"+id).fineUploader({
			request: {
				endpoint: contextPath + uploadURL
			},
			validation: {
				allowedExtensions: ['bmp', 'jpeg', 'jpg', 'png'],
				sizeLimit: 2097152 // 2 MB = 2 * 1024 * 1024 bytes
			},
			retry: {
				showButton: true
			},
			deleteFile: {
				enabled: true,
				endpoint: contextPath + deleteURL
			},
			text: {
				uploadButton: "上传附件",
				waitingForResponse: "上传中",
				failedUpload: "上传失败",
				deleteFile: "删除"
			}
		});
	}

	function viewAttchement(id, divId, orgCode, fileResource) {
		if ($.isEmpty(id)) {
			return;
		}
		var searchObj = {
			url : "/he/upload/viewAttchement/"+id,
			insertDiv : divId,
			param : {
				divId : divId,
				orgCode : orgCode,
				fileResource : fileResource
			}
		};
		$("#"+divId).submitFormLoadHtml(searchObj);
	}

	function deleteAttchement(attId, id, orgCode, divId, fileResource) {
		if ($.isEmpty(id)) {
			return;
		}

		var index = layer.confirm("确认删除?", {icon:2, title:'确认提示'}, function() {
			$.getJsonByUrl({
				url : "/he/upload/deleteAttachment/"+attId,
				callback : function(data) {
					if (data.result) {
						viewAttchement(id, divId, orgCode, fileResource);
					} else {
						layui.use('layer', function() {
							var layer = layui.layer;
							layer.alert(data.message, {icon:0,title:'提示'});
						});
					}
				}
			});
			layer.close(index);
		});
	}

	function download(id) {
		document.location.href=contextPath + "/he/upload/download/" + id;
	}

	function deleteFile(attId) {

		var index = layer.confirm("确认删除?", {icon:2, title:'确认提示'}, function() {
			$.getJsonByUrl({
				url : "/he/upload/deleteAttachment/"+attId,
				callback : function(data) {
					if (data.result) {
						$("#"+attId+"-div").remove();
					} else {
						layui.use('layer', function() {
							var layer = layui.layer;
							layer.alert(data.message, {icon:0,title:'提示'});
						});
					}
				}
			});
			layer.close(index);
		});
	}

	return {
		uploadFile : uploadFile,
		uploadOrganizationLinkFile : uploadOrganizationLinkFile,
		download : download,
		viewAttchement:viewAttchement,
		deleteAttchement:deleteAttchement,
		deleteFile:deleteFile
	};
})();

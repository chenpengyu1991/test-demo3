var anorectaImport = (function() {
	$(function() {
		var  uploader = new qq.FineUploader({
			element: $('#importFile')[0],
			request: {
				endpoint: contextPath + "/idm/case/uploadAnorecta"
			},
			failedUploadTextDisplay: {
				mode: 'custom',
				maxChars: 80,
				responseProperty: 'message',
				enableTooltip: true
			},
			validation: {
				allowedExtensions: ['xls', 'xlsx']
			},
			multiple: false,
			text: {
				uploadButton: "导入",
				waitingForResponse: "导入中",
				failedUpload: "导入失败"
			},
			callbacks: {
				onComplete: function(id, name, responseJSON) {
					if (responseJSON.success) {
						$(".qq-upload-success:last").append("<span>" + responseJSON.msg + "</span>");
					}
					//$(".qq-upload-success:last").append("<span>" + responseJSON.message + "</span>");
				}
			}
		});
	});
	
	
	function downloadTemplet() {
		location.href = contextPath + "/idm/case/downloadAnorectaTemplet";
	}

	return {
		downloadTemplet : downloadTemplet
	};
})();
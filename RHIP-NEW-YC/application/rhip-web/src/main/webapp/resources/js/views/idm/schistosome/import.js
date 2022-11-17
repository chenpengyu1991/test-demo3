var schHistoricalImport = (function() {
	$(function() {
        $("#downloadTemplet").click(function() {
        	downloadTemplet();
        });
        
		var  uploader = new qq.FineUploader({
			element: $('#importFile')[0],
			request: {
				endpoint: contextPath + "/idm/schistosome/advanced/uploadHistorical"
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
					$(".qq-upload-success:last").append("<span>" + responseJSON.msg + "</span>");
					if (responseJSON.success) {
						//刷新页面中的子表数据;
						advancedSearch.advancedSearch();
					}
				}
			}
		});
	});
	function downloadTemplet() {
		location.href = contextPath + "/idm/schistosome/advanced/downloadHistoricalTemplet";
	}

	return {
		downloadTemplet : downloadTemplet
	};
})();
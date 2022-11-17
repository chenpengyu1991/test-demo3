var hmFissureSealantImport = (function() {
	$(function() {
		$("#year").val(new Date().getFullYear());
		var uploader = new qq.FineUploader({
			element: $('#importFile')[0],
			request: {
				endpoint: contextPath + "/hm/fissureSealant/upload"
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
				onSubmit: function() {
					if ($("#selectSchoolForStu").val() == "") {
						layer.alert("请选择学校！", {icon:0,title:'提示'});
						return false;
					}
					if ($("#year").val() == "") {
						layer.alert("请选择年份！", {icon:0,title:'提示'});
						return false;
					}
					if ($("#mNumber").val() == "") {
						layer.alert("请填写男生数！", {icon:0,title:'提示'});
						return false;
					}
					if ($("#fNumber").val() == "") {
						layer.alert("请填写女生数！", {icon:0,title:'提示'});
						return false;
					}
					this.setParams({
						year: $("#year").val(),
						mnumber: $("#mNumber").val(),
						fnumber: $("#fNumber").val(),
						schoolCode: $("#selectSchoolForStu").val(),
						schoolName : $("#selectSchoolForStu option:selected").text()
					});
				},
				onComplete: function(id, name, responseJSON) {
					$(".qq-upload-success:last").append("<span>" + responseJSON.message + "</span>");
					if (responseJSON.success) {
						//hmFissureSealantSearch._report();
					}
				}
			}
		});
	});
	
	function downloadTemplet() {
		location.href = contextPath + "/hm/fissureSealant/downloadFissureSealantTemplet";
	}

	return {
		downloadTemplet : downloadTemplet
	};
})();
var hmStudentExamImport = (function() {
	$(function() {
		var studentUploader = new qq.FineUploader({
			element: $('#importStudentFile')[0],
			request: {
				endpoint: contextPath + "/hm/studentExam/uploadStudent"
			},
			validation: {
				allowedExtensions: ['xls', 'xlsx']
			},
			multiple: false,
			text: {
				uploadButton: "导入学生",
				waitingForResponse: "导入中"
			},
			failedUploadTextDisplay: {
				mode: 'custom',
				maxChars: 100,
				responseProperty: 'message',
				enableTooltip: true
			},
			callbacks: {
				onSubmit: function() {
					if ($("#selectSchoolForStu").val() == "") {
						layer.alert("请选择学校！", {icon:0,title:'提示'});
						return false;
					}
					if ($("input:radio[name='actionType']:checked").length == 0) {
						layer.alert("请选择操作方式！", {icon:0,title:'提示'});
						return false;
					}
					this.setParams({
						actionType: $("input:radio[name='actionType']:checked").val(),
						schoolCode: $("#selectSchoolForStu").val(),
						schoolName : $("#selectSchoolForStu option:selected").text()
					});
				},
				onComplete: function(id, name, responseJSON) {
					if (responseJSON.success) {
						$("#importStudentFile .qq-upload-success:last").append("<span>" + responseJSON.message + "</span>");
					}
				}
			}
		});
	});
	
	function downloadTemplet() {
		location.href = contextPath + "/hm/studentExam/downloadStudentTemplet";
	}

	return {
		downloadTemplet : downloadTemplet
	};
})();
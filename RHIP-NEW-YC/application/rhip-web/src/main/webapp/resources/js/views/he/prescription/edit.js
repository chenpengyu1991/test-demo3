var healthEducationPrescriptionEdit = (function() {
	var ue
	$(function () {
		ue = UE.getEditor('editor');
		UE.getEditor('editor').focus();

		//健康教育宣传保存
		$("#save-btn").click(save);
		$("#back-btn").click(returnSearch);

		if ($("#operatorType").val() == '1') {
			$("#save-btn").attr("hidden", "hidden");
		}
	});

	function save() {
		$("#content").val(ue.getContent());
		var validate = $("#healthEducationPrescriptionForm").easyValidate();

		var result = validate.validateForm();
		if (!result) {
			return;
		} else {
			$("#healthEducationPrescriptionForm").submitFormGetJson({
				url: "/he/prescription/save",
				callback: function (data) {
					if (data.result) {
						layer.alert("健康教育处方保存成功！", {icon:0,title:'提示'}, function (index) {
							returnSearch();
							layer.close(index);
						});
					} else {
						layer.alert("健康教育处方保存失败！", {icon:0,title:'提示'});
					}
				}
			});
		}
	}

	function submitCallback(data) {
		if (data.result) {
			layer.alert("保存成功!", {icon:0,title:'提示'}, function (index) {
				$.removeDialog("healthEducationPrescription");
				healthEducationPrescriptionSearch.search(1);
				layer.close(index);
			});
		} else {
			layer.alert("保存失败！", {icon:0,title:'提示'});
		}
	}

	function returnSearch() {
		if (contentChanged) {
			msgUtil.backConfirm(function () {
				returnfunction();
			});
		} else {
			returnfunction();
		}
	}

	function returnfunction() {
		$("#operationDiv").empty();
		$("#mainSearchDiv").show();
		healthEducationPrescriptionSearch.search($("#currentPage").val());
	}

	return {};
})();

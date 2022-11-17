var infectMonitorAdd = (function() {
	var validate = $("#infectMonitorEditForm").easyValidate();
	$(function() {
		if ($("#operation").val() == "view") {
			$("#infectMonitorEditForm input").each(function() {
				$(this).attr("disabled", "disabled");
			})
			$("#infectMonitorEditForm select").each(function() {
				$(this).attr("disabled", "disabled");
			})
		} else {
			enableChangeConfirm();
			$("#save").click(saveMonitor);
		}
		searchDetail(1);
		$("#back").click(function() {
			baseLayoutLoad.popMainContent();
			disableChangeConfirm();
			infectMonitorSearch.search(1);
		});
	});

	function searchDetail(idxPage) {
		var monitorId = $("#id").val();
		if (monitorId == null) {
			monitorId = "";
		}
		var operation = $("#operation").val()
		if (idxPage == null) {
			idxPage = $("#idxPage").val();
		}
		var option = {
			url : "/dmbc/medicalInst/infectDetail/list",
			insertDiv : "detailList",
			param : {
				monitorId : monitorId,
				idxPage : idxPage,
				operation : operation
			}
		}
		$.loadHtmlByUrl(option);
	}

	function saveMonitor() {
		var check = validate.validateForm();
		if (!check) {
			return;
		}
		var option = {
			url : "/dmbc/medicalInst/infectMonitor/save",
			callback : (function(result) {
				if (result.success) {
					$("#id").val(result.monitor.id);
					$("#createBy").val(result.monitor.createBy);
					$("#createTime").attr("date", result.monitor.createTime);
				}
				layer.alert(result.message, {icon:0,title:'提示'});
				searchDetail(1);
			})
		}
		$("#infectMonitorEditForm").submitFormGetJson(option);
	}

	return {
		searchDetail : searchDetail
	}
})();
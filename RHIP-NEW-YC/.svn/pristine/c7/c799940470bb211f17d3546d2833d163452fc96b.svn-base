var infectDetailAdd = (function() {
	var validate = $("#editInfectDetailForm").easyValidate();
	$(function() {
		if ($("#detailOperation").val() == "view") {
			$("#editInfectDetailForm input").each(function() {
				$(this).attr("disabled", "disabled");
			})
		} else {
			$("#saveDetail").click(saveDetail);
			$("#infectionPart input").each(function() {
				$(this).blur(getTotal);
			})
		}
	})

	function saveDetail() {
		if (!validate.validateForm()) {
			return;
		}
		//补零
		$("#infectionPart input").each(function() {
			if ($(this).val() == "") {
				$(this).val("0");
			}
		})
		var option = {
			url : "/dmbc/medicalInst/infectDetail/save",
			callback : (function(result) {
				layer.alert(result.message, {icon:0,title:'提示'});
				if (result.success) {
					$.removeDialog("infectDetailDialog");
					infectMonitorAdd.searchDetail();
				}
			})
		};
		$("#editInfectDetailForm").submitFormGetJson(option);
	}

	function getTotal() {
		var total = 0;
		$("#infectionPart input").each(function() {
			if ($(this).attr("name") != "total") {
				total += $(this).val() * 1;
			}
		});
		$("#infectionPart input[name='total']").val(total);
	}
})();
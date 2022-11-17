!(function() {
	var validate = null;
	$(function() {
		validate = $("#hsa-input-form").easyValidate();
		// 保存记录界面
		$("#hsa-location-inspiron-save-btn").click(function(){
			save();
		});
		
		$("#hsa-location-inspiron-out-save-btn").click(function(){
			save(function(){
				backToLocationList();
			});
		});

		$("#hsa-location-inspiron-in-save-btn").click(function(){
			save(function(){
				locationInspRecordList.refreshList();
				hsaLocationInspListView.add();
			});
		});
		
		$("#hsa-location-inspiron-back-btn").click(function(){
			backToLocationList(); 
		});
		
		
		$("#hsa-guide-type").change(openGuideTable);
		$("#hsa-guide-type").change();

		$("input[name='isGuide']").click(openGuideContent);
		$("input[name='isReport']").click(openReportContent);

		$("#infoTypeCode").change(openSusOccDisease);

		// 点击巡查指导checkbox事件
		$("input[type='checkbox']", "#hsa-guide-content").on("click", function(event) {
			var $this = $(this);
			var target = $this.data("target");
			var target1 = $this.data("target1");
			var target2 = $this.data("target2");
			var target3 = $this.data("target3");
			var target4 = $this.data("target4");
			if ($this.prop("checked")) {
				$("#" + target).show();
				$("#" + target1).show();
			} else {
				$("#" + target).hide().find("input[type='radio']").val([ '5' ]);
				$("#" + target1).hide().find("input[type='radio']").val([ '5' ]);
			}
			if (target2 && target3) {
				if ($this.prop("checked")) {
					$("#" + target2).prop("readonly", false);
					$("#" + target3).prop("readonly", false);
				} else {
					$("#" + target2).val("");
					$("#" + target3).val("");
					$("#" + target2).prop("readonly", true);
					$("#" + target3).prop("readonly", true);
				}
			}
			if (target4) {
				if ($this.prop("checked")) {
					$("#" + target4).prop("readonly", false);
				} else {
					$("#" + target4).prop("readonly", true);
					$("#" + target4).val("");
				}
			}
		});
		showSusOccDi();
		$("#townCodeId", "#hsa-record-input-add").attr("disabled", true);
		openGuideTable();
		if ($("#has-insprecord-flag").val() == "view") {
			$("#hsa-record-input-add").find("input[type='checkbox']").attr("disabled", true);
			$("#hsa-record-input-add").find("input[type='radio']").attr("disabled", true);
			$("#hsa-record-input-add").find("input[type='text']").attr("disabled", true);
			$(".disabledInfoContent").attr("disabled", "disabled");
			$("#hsa-guide-type", "#hsa-record-input-add").attr("disabled", true);
		}
		validate.addExtension("cuValidate", customValidate);// 方法名,方法
	});

	function backToLocationList() {
		$("#hsa-record-location-input-add").hide();
		$("#hsa-record-locationList-box").show();
		hsaInspRecordLocationList.search(1);
	}
	
	function showSusOccDi() {
		var infoTypeCode = $("#infoTypeCode").val();
		if (infoTypeCode == "4") {
			$("#hideSusOccDisease").show();
		} else {
			$("#hideSusOccDisease").hide();
		}
	}

	function openGuideTable() {
		var val = $("#hsa-guide-type").val();
		switch (val) {
		case "1":
			$("#hsa-guide-food").show().find("input").prop("disabled", false);
			$("#hsa-guide-water").hide().find("input").prop("disabled", true);
			$("#hsa-guide-idp").hide().find("input").prop("disabled", true);
			$("#hsa-guide-plocation").hide().find("input").prop("disabled", true);
			break;
		case "2":
			$("#hsa-guide-food").hide().find("input").prop("disabled", true);
			$("#hsa-guide-water").show().find("input").prop("disabled", false);
			$("#hsa-guide-idp").hide().find("input").prop("disabled", true);
			$("#hsa-guide-plocation").hide().find("input").prop("disabled", true);
			break;
		case "3":
			$("#hsa-guide-food").hide().find("input").prop("disabled", true);
			$("#hsa-guide-water").hide().find("input").prop("disabled", true);
			$("#hsa-guide-idp").show().find("input").prop("disabled", false);
			$("#hsa-guide-plocation").hide().find("input").prop("disabled", true);
			break;
		case "4":
			$("#hsa-guide-food").hide().find("input").prop("disabled", true);
			$("#hsa-guide-water").hide().find("input").prop("disabled", true);
			$("#hsa-guide-idp").hide().find("input").prop("disabled", true);
			$("#hsa-guide-plocation").show().find("input").prop("disabled", false);
			break;
		default:
			$("#hsa-guide-food").hide();
			$("#hsa-guide-water").hide();
			$("#hsa-guide-idp").hide();
			$("#hsa-guide-plocation").hide();
			break;
		}
	}

	function openSusOccDisease() {
		var val = $(this).val();
		if (val == "4") {
			$("#hideSusOccDisease").show();
		} else {
			$("#hideSusOccDisease").hide();
		}
	}

	function openGuideContent() {
		var val = $(this).val();
		if (val == 1) {
			$("#hsa-guide-content").show();
		} else {
			$("#hsa-guide-content").hide();
		}
	}

	function openReportContent() {
		var val = $(this).val();
		if (val == 1) {
			$("#hsa-report-record-content").show();
		} else {
			$("#hsa-report-record-content").hide();
			$("#discoveryDate").attr("value", "");
			$("#infoTypeCode").attr("value", "");
			$("#infoContent").attr("value", "");
			$("#hideSusOccDisease").hide();
		}
	}

	function save(callbackFunction) {
		var result = validate.validateForm();
		if (!result) {
			return;
		}

		$("#hsa-input-form").submitFormGetJson({
			url : "/hsa/inspRecord/save",
			callback : function(data) {
				if ("success" == data) {
					layer.alert("保存成功！", {icon:0,title:'提示'});
					if(callbackFunction){
						callbackFunction();
					}
				}else{
					layer.alert("保存失败！", {icon:0,title:'提示'});
				}
					
			}
		});
	}

	function customValidate(name, $input) {
		var value = $input.filter(":checked").val();
		if (value != 5) {
			return true;
		} else {
			return false;
		}
	}

})();
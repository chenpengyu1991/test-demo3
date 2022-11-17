var hbpPlanInfo = (function() {
	var validate = null;
	$(function() {
		validate = $("#hbpPlanForm").easyValidate();
		$("#txtSbp").change(doBindValue);
		$("#txtDbp").change(doBindValue);
		$("#tableLinstener").find(".level1").change(doBindValue);
		$("#tableLinstener").find(".level2").change(doBindValue);
		$("#tableLinstener").find(".level3").change(doBindValue);
		//$("#hbpYear").val(new Date().getFullYear());
		$("input[name='radioRbgLevel']").attr("disabled", "disabled");
		$("input[name='radioWx']").attr("disabled", "disabled");
		$("input[name='radioDiseLevel']").attr("disabled", "disabled");
		$("#personHbpName").val($("#hiddenPersonName").val());
		// 高血压保存事件
		$("#cdm-plan-list-hbp-save-btn").click(function() {
			result = validate.validateForm();
			if (result == true) {
				saveHbpPlan();
			}
		});

		// 高血压返回事件
		$("#cdm-plan-list-hbp-back-btn").click(function() {
			back();
		});
		doBindValue();
	});
	// 高血压保存
	function saveHbpPlan() {
		$("#hbpPlanForm").submitFormGetJson({
			url : "/cdm/standardization/insertPlanInfo",
			callback : function(data) {
				if ("success" == data) {
					layer.alert("保存成功！", {icon:0,title:'提示'}, function(index) {
						refresh();
						layer.close(index);
					});
				} else if ("before" == data||"after"==data) {
					layer.alert("只能建立当年度保健计划！", {icon:0,title:'提示'});
				} else if ("less" == data) {
					layer.alert("当前时间为上一年保健计划范围内！", {icon:0,title:'提示'});
                } else if ("repeat" == data) {
                	layer.alert("该年度保健计划已经存在！", {icon:0,title:'提示'});
                } else if ("havaFollowup" == data) {
                	layer.alert("该年度已经存在随访记录不得修改保健计划！", {icon:0,title:'提示'});
				} else if ("yearModify" == data) {
					layer.alert("不可以修改保健计划年度！", {icon:0,title:'提示'});
                } else {
                	layer.alert("保存失败！", {icon:0,title:'提示'});
				}
			}
		});
	}

	function refresh() {
		cdmplanInfoTabMain.searchMain(1);
	}
	// function refreshAdd(){
	// var searchObj={
	// url : "/cdm/standardization/inputHbpPlanForm",
	// insertDiv:"cdm-plan-input-hbp",
	// param:{
	// id:$("#cdmPlanHiddenId").val()
	// }
	// };
	// $.loadHtmlByUrl(searchObj);
	// }
	// 返回事件
	function back() {
		$("#cdm-plan-input-hbp").hide();
		$("#cdm-plan-list-hbp-box").show();
	}

	function doBindValue() {
		var ssyLevel = calHbpLevelValue();
		$("input[name='radioRbgLevel']").val([ ssyLevel ]);
		$("#radioRbgLevelHidden").val(ssyLevel);
		level1Total = $("#tableLinstener").find(".level1:checked").length;
		level2Total = $("#tableLinstener").find(".level2:checked").length;
		level3Total = $("#tableLinstener").find(".level3:checked").length;
		// 根据心血管疾病的选择项目给心血管疾病等级赋值并且给相应的hidden赋值
		if (level1Total == 0 && level2Total == 0 && level3Total == 0) {
			$("input[name='radioDiseLevel']").val([ 2 ]);
			$("#radioDiseLevelHidden").val([ 2 ]);
		}
		if (level1Total > 0) {
			$("input[name='radioDiseLevel']").val([ 2 ]);
			$("#radioDiseLevelHidden").val([ 2 ]);
		}
		if (level2Total > 0) {
			$("input[name='radioDiseLevel']").val([ 3 ]);
			$("#radioDiseLevelHidden").val([ 3 ]);
		}
		if (level3Total > 0) {
			$("input[name='radioDiseLevel']").val([ 4 ]);
			$("#radioDiseLevelHidden").val([ 4 ]);
		}

		// 根据根据心血管疾病的选择项目和高血压分级给高血压危险分层赋值并且给相应的hidden赋值
		if ($('input:radio[name="radioRbgLevel"]:checked').val() == 1) {
			if (level1Total == 0) {
				$("input[name='radioWx']").val([ 1 ]);
				$("#radioWxHidden").val([ 1 ]);
			}
			if (level1Total >= 1 && level1Total <= 2) {
				$("input[name='radioWx']").val([ 2 ]);
				$("#radioWxHidden").val([ 2 ]);
			}
			if (level1Total >= 3) {
				$("input[name='radioWx']").val([ 3 ]);
				$("#radioWxHidden").val([ 3 ]);
			}
			if (level2Total > 0) {
				$("input[name='radioWx']").val([ 3 ]);
				$("#radioWxHidden").val([ 3 ]);
			}
			if (level3Total > 0) {
				$("input[name='radioWx']").val([ 4 ]);
				$("#radioWxHidden").val([ 4 ]);
			}
		} else if ($('input:radio[name="radioRbgLevel"]:checked').val() == 2) {
			if (level1Total == 0) {
				$("input[name='radioWx']").val([ 2 ]);
				$("#radioWxHidden").val([ 2 ]);
			}
			if (level1Total >= 1 && level1Total <= 2) {
				$("input[name='radioWx']").val([ 2 ]);
				$("#radioWxHidden").val([ 2 ]);
			}
			if (level1Total >= 3) {
				$("input[name='radioWx']").val([ 3 ]);
				$("#radioWxHidden").val([ 3 ]);
			}
			if (level2Total > 0) {
				$("input[name='radioWx']").val([ 3 ]);
				$("#radioWxHidden").val([ 3 ]);
			}
			if (level3Total > 0) {
				$("input[name='radioWx']").val([ 4 ]);
				$("#radioWxHidden").val([ 4 ]);
			}
		} else if ($('input:radio[name="radioRbgLevel"]:checked').val() == 3) {
			if (level1Total == 0) {
				$("input[name='radioWx']").val([ 3 ]);
				$("#radioWxHidden").val([ 3 ]);
			}
			if (level1Total >= 1 && level1Total <= 2) {
				$("input[name='radioWx']").val([ 4 ]);
				$("#radioWxHidden").val([ 4 ]);
			}
			if (level1Total >= 3) {
				$("input[name='radioWx']").val([ 4 ]);
				$("#radioWxHidden").val([ 4 ]);
			}
			if (level2Total > 0) {
				$("input[name='radioWx']").val([ 4 ]);
				$("#radioWxHidden").val([ 4 ]);
			}
			if (level3Total > 0) {
				$("input[name='radioWx']").val([ 4 ]);
				$("#radioWxHidden").val([ 4 ]);
			}
		}
		// 根据危险分层对每次随访次数赋值
		//$("#annualVisitTimes").val($('input:radio[name="radioWx"]:checked').val() == 1 ? '4' : $('input:radio[name="radioWx"]:checked').val() == 2 ? '6' : '12');
		//2017.8.14客户提出的需求变更28.   慢病管理-高血压&糖尿病保健计划：分层：低、中、高、很高，默认的随访次数都是4次
		$("#annualVisitTimes").val('4');
	}
	function calHbpLevelValue() {
		var sbp = $("#txtSbp").val();
		var dbp = $("#txtDbp").val();
		var level = 1;
		if (sbp) {
			if (sbp >= 180) {
				level = 3;
				return level;
			} else if (sbp >= 160) {
				level = 2;
			} else if (sbp >= 140) {
				level = 1;
			}
		}

		if (dbp) {
			if (dbp >= 110) {
				level = 3;
				return level;
			} else if (dbp >= 100) {
				level = 2;
				return level;
			} else if (level < 2 && dbp >= 90) {
				level = 1;
				return level;
			}
		}
		return level;

	}

	return {
		doBindValue : doBindValue,
		refresh : refresh

	};
})();
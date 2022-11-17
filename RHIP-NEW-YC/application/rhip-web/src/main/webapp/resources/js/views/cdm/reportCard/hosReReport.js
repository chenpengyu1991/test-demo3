//医院报卡上报
var dmHosReportCard = (function() {
	var validate = null;
	$(function() {
		validate = $("#report-input-form").easyValidate();
		// 保存按钮
		$("#report-input-save-btn").on("click", save);
		$("#report-input-back-btn").on("click", back);
		init();
	});

	function init() {
		$("#dis-select-box input").on("click", function(event) {
			var name = $(this).attr("name");
			var targetBoxId = name + "-box";
			if ($(this).prop("checked"))
			{
				$("#" + targetBoxId).show();
			} else
			{
				$("#" + targetBoxId).hide();
			}
		});

		// 人员户籍类型切换
		$("input[name='personInfo.householdType']").on("click", function() {
			if ("2" == $(this).val())
			{
				$("#hr-address-select").find("select").attr("disabled", "disabled");
				$("#hr-address-select").hide();
			} else
			{
				$("#hr-address-select").find("select").removeAttr("disabled");
				$("#hr-address-select").show();
			}
		});

		// 地址变化
		$("select[name='personInfo.pastreet']").on("change villageChange", function() {
			$(this).multiselect('refresh');
			var prefix = $("select[name='personInfo.patownShip']").find("option[value!='']:selected").text();
			prefix += $(this).find("option[value!='']:selected").text();
			$("#text_pahouseNumber_prefix").text(prefix);
		});

		// 地址变化
		$("select[name='personInfo.hrstreet']").on("change villageChange", function() {
			$(this).multiselect('refresh');
			var prefix = $("select[name='personInfo.hrtownShip']").find("option[value!='']:selected").text();
			prefix += $(this).find("option[value!='']:selected").text();
			$("#text_hrhouseNumber_prefix").text(prefix);
		});

		if ($("input[name='tumorFlag']").prop("checked"))
		{
			addIcd10AutoComplete();
		}

		$("select[multiple]").each(function() {
			$(this).multiselect({
				header : false,
				noneSelectedText : '请选择诊断依据',
				selectedList : 13
			});
		});

	}

	function addIcd10AutoComplete() {
		$.getJsonByUrl({
			url : "/cdm/reportcard/complete/disease",
			param : {
				inputValue : "C"
			},
			callback : function(data) {
				var hbpDiagnosedOrganCode = $("#tumorIcd10Code");
				if (hbpDiagnosedOrganCode.length > 0)
				{
					hbpDiagnosedOrganCode.autocomplete(data, {
						minChars : 0,
						width : 250,
						max : 100,
						autoFill : false,
						matchContains : true,
						formatItem : function(row, i, max) {
							return row.diseaseName + "[" + row.icd10main + "]";
						},
						formatMatch : function(row, i, max) {
							return row.diseaseName + " " + row.icd10main;
						},
						formatResult : function(row) {
							return row.icd10main;
						}
					}).result(function(event, data, formatted){
                            $("input[name='tumorType']").val(data.diseaseName);
                        });
				}
			}
		});
	}

	function reload() {
		 $("#report-input-form")[0].reset();
		 $("#report-input-save-btn").attr("disabled", true);
		back();
		if(userOperationLogSearch&&userOperationLogSearch.searchReportRecord){
			 userOperationLogSearch.searchReportRecord();
		}
	}

	function back() {
	      $("#top_all").show();
	      $("#cdm-re-report-input-main").hide();
	}

	function save(event) {
		var selectedIitems = $("#dis-select-box").find("input:checked");
		if (selectedIitems.length < 1)
		{
			layer.alert("请至少上报一种慢病！", {icon:0,title:'提示'});
			return;
		}

		// 清除身份证输入框的提示
		var $idcard = $("#cdm_report_idcard");
		// 如果没有身份证,需要清理已经存在的personid
		// 重要!,否则会认认为是更新
		if (!$idcard.val())
		{
			$('#cdm_report_personId').val("");
			$('#cdm_person_personId').val("");
		}

		// 验证
		var result = validate.validateForm();
		if (!result)
		{
			return;
		}

		// 保存
		$("#report-input-form").submitFormGetJson({
			url : "/cdm/reportcard/hosReSave",
			param : {},
			wait:true,
			callback : function(data) {
				if ("success" == data)
				{
					layer.alert("上报成功", {icon:0,title:'提示'}, function(index){
						reload();
						layer.close(index);
					});
				} else
				{
					layer.alert("上报失败！", {icon:0,title:'提示'});
				} 
			}
		});

	}

	function closeWin() {

		window.opener = null;
		// window.opener=top;
		window.open("", "_self");
		window.close();
	}
})();
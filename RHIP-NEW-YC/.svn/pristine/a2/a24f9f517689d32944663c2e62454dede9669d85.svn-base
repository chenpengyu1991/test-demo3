//医院报卡上报
//这个可以修改,最好删除,用hosReport代替放在jsp
var hosReport_require = (function() {
	var validate = null;
		$(function(){
			validate = $("#report-input-form").easyValidate();
			// 保存按钮
			$("#report-input-save-btn").on("click", save);
			init();
		});

	function init()
	{
		$("#dis-select-box input").on("click", function(event)
		{
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
		$("input[name='personInfo.householdType']").on("click", function()
		{
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
		$("select[name='personInfo.pastreet']").on("change villageChange", function()
		{
			$(this).multiselect('refresh');
			var prefix = $("select[name='personInfo.patownShip']").find("option[value!='']:selected").text();
			prefix += $(this).find("option[value!='']:selected").text();
			$("#text_pahouseNumber_prefix").text(prefix);
		});

		// 地址变化
		$("select[name='personInfo.hrstreet']").on("change villageChange", function()
		{
			$(this).multiselect('refresh');
			var prefix = $("select[name='personInfo.hrtownShip']").find("option[value!='']:selected").text();
			prefix += $(this).find("option[value!='']:selected").text();
			$("#text_hrhouseNumber_prefix").text(prefix);
		});

		addIcd10AutoComplete();

		$("select[multiple]").each(function()
		{
			$(this).multiselect({
				header : false,
				noneSelectedText : '请选择诊断依据',
				selectedList : 13
			});
		});

		$("select").not("select[multiple]").multiselect({
			multiple: false,
			header : false,
			noneSelectedText: "",
			selectedList: 1
		});

		$("select").not("select[multiple]").data("validate",true);


	}

	function addIcd10AutoComplete(){
		$.getJsonByUrl({
			url: "/cdm/reportcard/complete/disease",
			param : {inputValue:"C"},
			callback : function(data)
			{
				var hbpDiagnosedOrganCode = $("#tumorIcd10Code");
				if (hbpDiagnosedOrganCode.length > 0){
					hbpDiagnosedOrganCode.autocomplete(data, {
						minChars: 0,
						width:250,
						max: 100,
						autoFill: false,
						matchContains: true,
						formatItem: function(row, i, max) {
							return  row.diseaseName + "[" + row.icd10main + "]";
						},
						formatMatch: function(row, i, max) {
							return row.diseaseName + " " + row.icd10main;
						},
						formatResult: function(row) {
							return row.icd10main;
						}
					}).result(function(event, data, formatted){
                            $("input[name='tumorType']").val(data.diseaseName);
                        });
				}
			}
		});
	}

	// 保存成功后清空报卡信息,且不再可以保存
	function reload()
	{
		$("#report-input-form")[0].reset();
		$("#report-input-save-btn").attr("disabled", true);
	}

	var saved=false;
	
	function save(event)
	{
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
		
		if(saved){
			layer.alert("已上报，请稍等!", {icon:0,title:'提示'});
			return;
		}

		saved=true;
		
		// 保存
		$("#report-input-form").submitFormGetJson({
			url : "/cdm/reportcard/hossave",
			param : {},
			callback : function(data)
			{
				var $result=$("#report-result") ;
				if ("success" == data)
				{
					layer.alert("上报成功！", {icon:0,title:'提示'});
					reload();
					$result.val("1");

				} else if ("error" == data)
				{
					layer.alert("上报失败！", {icon:0,title:'提示'});
					$result.val("-1");
					saved=false;
				} else
				{
					$result.val("1");
					var tip = "";
					if (!data[0])
					{
						tip += "糖尿病 ";
					}
					if (!data[1])
					{
						tip += "冠心病 ";
					}
					if (!data[2])
					{
						tip += "脑卒中 ";
					}
					if (!data[3])
					{
						tip += "肿瘤 ";
					}
					tip += "已经报卡";
					layer.alert(tip, {icon:0,title:'提示'});
				}
			}
		});
		
		setTimeout(function(){
			//closeWin() ;
		},2000);
	}

	function closeWin() 
	{

		window.opener = null;
		// window.opener=top;
		window.open("", "_self");
		window.close();
	}
})();
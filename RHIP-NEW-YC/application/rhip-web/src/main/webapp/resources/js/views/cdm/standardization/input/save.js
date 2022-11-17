var dmManageInput = (function()
{
	var validate = null;
	var target={
			"diComSmokingFlag":"#diComSmokingDailyNum",
			"diComDrinkingFlag":"#diComDrinkingdailyNum",
			diCcomCoronaryFlag:"#diCcomCoronaryDisDate,#diCcomCoronaryTreatment",
			diCcomHbpFlag:"#diCcomHbpDisDate,#diCcomHbpTreatment",
			diCcomHbcFlag:"#diCcomHbcDisDate,#diCcomHbcTreatment",
			diCcomRetyFlag:"#diCcomRetyDisDate,#diCcomRetypTreatment",
			diCcomNerveFlag:"#diCcomNerveDisDate,#diCcomNerveTreatment",
			diCcomStrokeFlag:"#diCcomStrokeDisDate,#diCcomStrokeTreatment",
			diCcomFootFlag:"#diCcomFootDisDate,#diCcomFootTreatment",
			diCcomKidneyFlag:"#diCcomKidneyDisDate,#diCcomKidneyTreatment",
			diRtInsulinFlag:"#diRtInsulinDailyCount,#diRtInsulinPerDose",
			diRtHypDrugsFlag:"#diRtHypDrugsDailyCount,#diRtHypDrugsperDose",
			diRtPhyActivityFlag:"#diRtPhyActivityWeekCount,#diRtPhyActivityTime"
	};
	$(function()
	{
		validate = $("#health-card-form").easyValidate();
		// 保存按钮
		$("#health-card-save-btn").on("click", save);
		$("#health-card-back-btn").on("click", back);
		addDisSwitch();
		$("select[multiple]").each(function()
		{
			$(this).multiselect({
				header : false,
				noneSelectedText : '请选择诊断方式',
				selectedList : 13
			});
		});
		toggleDisable(target);
	});
	function queryPerson(input)
	{
		if (validate.validate("personInfo.idcard"))
		{
			$("#health-card-form").submitFormGetJson({
				url : "/cdm/reportcard/load",
				insertDiv : "report-card-main",
				callback : function(data)
				{
					setPersonData(data);
				}
			});
		}
	}

	function addDisSwitch()
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

	}

	function back()
	{
		$("#cdm-manage-input-box").hide();
		$("#cdm-manage-list-box").show();
	}
	
	function toggleDisable(target){
		for(var btn in target){
			$("input[name="+btn+"]").on("click",function(){
				var name=$(this).attr("name");
				if ("1" == $(this).val())
				{
					$(target[name]).attr("disabled", "disabled").each(function(){
						validate.removeError($(this).attr("name"));
					}).val("");
				} else
				{
					$(target[name]).removeAttr("disabled");
				}
			});
		}
	}

	function save(event)
	{
		// 验证
		var result = validate.validateForm();
		if (!result)
		{
			// layer.alert("请根据提示正确输入！");
			return;
		}
		// 保存
		$("#health-card-form").submitFormGetJson({
			url : "/cdm/standardization/save",
			param : {},
			wait:true,
			callback : function(data)
			{
				if (data == "success")
				{
					layer.alert("保存成功！", {icon:0,title:'提示'}, function(index)
					{
						back();
						search(1);
						layer.close(index);
					});
				} else
				{
					layer.alert("保存失败！", {icon:0,title:'提示'});
				}

			}
		});
	}
	
	 function isNumber(val) {
	        if (val) {
	            return val.match(/(\d+)|(^(\d+.\d+)$)/);
	        }
	        return true;
	    }
	function search(indexPage) {
        if ((!checkAge())||(!checkSelectedDisType())) {
            return;
        }
        var searchObj = {
            url: "/cdm/standardization/healthCardList",
            insertDiv: "diseaseInfo",
            param: {
                pageIndex: indexPage
            }
        };
        $("#form_search").submitFormLoadHtml(searchObj);
    }
	
	
	function checkAge() {
        var startAge = $("#startAge").val();
        if (!isNumber(startAge)) {
            $("#startAge").val("");
            layer.alert("请输入正确的年龄段！", {icon:0,title:'提示'});
            return false;
        }
        var endAge = $("#endAge").val();
        if (!isNumber(endAge)) {
            $("#endAge").val("");
            layer.alert("请输入正确的年龄段！", {icon:0,title:'提示'});
            return false;
        }
        if (startAge && endAge && Number(startAge) > Number(endAge)) {
        	layer.alert("开始年龄不能大于结束年龄！", {icon:0,title:'提示'});
            return false;
        }
        return true;
    }


    function checkSelectedDisType() {
        var $form = $("#form_search");
        var isManagedFlag = $form.find("input[name='isManagedFlag']:checked").val();
        var managedDateStart = $form.find("input[name='managedDateStart']").val();
        var managedDateEnd = $form.find("input[name='managedDateEnd']").val();

        if (isManagedFlag || managedDateEnd || managedDateStart) {
            var selectedDisType = $form.find("#disTypeSelect").val();
            if (selectedDisType) {
                if ($.isArray(selectedDisType) && selectedDisType.length > 1) {
                	layer.alert("查询管理状态和纳入管理时间时只能选择一种患病类型！", {icon:0,title:'提示'});
                    return false;
                }
            } else {
            	layer.alert("查询管理状态和纳入管理时间时需要选择一种患病类型！", {icon:0,title:'提示'});
                return false;
            }
        }
        return true;
    }

})();
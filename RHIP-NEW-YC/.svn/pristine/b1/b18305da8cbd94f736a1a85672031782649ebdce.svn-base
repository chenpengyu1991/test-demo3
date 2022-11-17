//报卡查看和审核
var dmAppReportCard = (function()
{
	var errorMsg = {
		"0" : "报卡信息获取失败 ",
		"1" : "报卡信息获取失败 ",
		"3" : "糖尿病已经管理 ",
		"4" : "脑卒中已经管理 ",
		"5" : "冠心病已经管理 ",
		"6" : "肿瘤已经管理 ",
		"7" : "报卡已经管理,请刷新重试 "
	};
	var validate = $("#report-input-form").easyValidate();
	$(function()
	{
		// 保存按钮
		$("#report-input-save-btn").on("click", save);
		$("#report-input-back-btn").on("click", back);

		// 人员户籍类型切换
		$("input[name='personInfo.householdType']").on("click", function()
		{
			$("#hrstreet").val("");
        	$("#hrcounty").val("");
        	$("#hrtownShip").val("");
        	$("#text_hrhouseNumber").val("");
        	$("#text_hrhouseNumber_prefix").text("");
			if ("2" == $(this).val() || "4" == $(this).val())
			{
				$("#hr-address-select").find("select").attr("disabled", "disabled").hide();
				$("#text_hrhouseNumber_prefix").hide();
			} else
			{
				$("#hr-address-select").find("select").removeAttr("disabled").show();
				$("#text_hrhouseNumber_prefix").show();
				$("#hr-address-select").removeClass("hide");
			}
		});

		displayPaAddress();
		displayHrAddress();
		
		// 现地址变化
		$("select[name='personInfo.patownShip']").on("change streetChange", function(){
			changeHouseNumber('personInfo.patownShip',null,null,'text_pahouseNumber_prefix','text_pahouseNumber', null);
		});
		$("select[name='personInfo.pastreet']").on("change villageChange", function(){
			changeHouseNumber('personInfo.patownShip','personInfo.pastreet',null,'text_pahouseNumber_prefix','text_pahouseNumber', null);
		});
		
		$("select[name='personInfo.paGroup']").on("change groupChange", function(){
			changeHouseNumber('personInfo.patownShip','personInfo.pastreet','personInfo.paGroup','text_pahouseNumber_prefix', null, 'displayPaAddress');
		});
		
		//  户籍地址变化
		$("select[name='personInfo.hrtownShip']").on("change streetChange", function(){
			changeHouseNumber('personInfo.hrtownShip',null,null,'text_hrhouseNumber_prefix','text_hrhouseNumber', null);
		});
		$("select[name='personInfo.hrstreet']").on("change villageChange", function(){
			changeHouseNumber('personInfo.hrtownShip','personInfo.hrstreet',null,'text_hrhouseNumber_prefix','text_hrhouseNumber', null);
		});
		$("select[name='personInfo.hrGroup']").on("change groupChange", function(){
			changeHouseNumber('personInfo.hrtownShip','personInfo.hrstreet','personInfo.hrGroup','text_hrhouseNumber_prefix', null, 'displayHrAddress');
		});


		$("select[multiple]").each(function()
		{
			$(this).multiselect({
				header : false,
				noneSelectedText : '请选择诊断依据',
				selectedList : 13
			});
		});
		addIcd10AutoComplete();
		$(".app-op-box").each(function()
		{
			var selelct = $(this).data("target");
			if ($("#" + selelct).length > 0)
			{
				$(".app-op-box").find("input[type='radio']").on("click", function()
				{
					var $this = $(this);
					var target = $this.data("target");
					if ($(this).val() == "3")
					{
						$("#" + target).show();
					} else
					{
						$("#" + target).hide();
					}
				});
			}
		});

		$("#save-to-manage-btn").on("click", saveToMange);

	});

	function changeHouseNumber(townShip, street, group, houseNumber_prefix, houseNumber, methodName){
		var prefix = $("select[name='" + townShip + "']").find("option[value!='']:selected").text();
		if(street != null){
			prefix += " " + $("select[name='" + street + "']").find("option[value!='']:selected").text();
		}
		if(group != null){
			prefix += " " + $("select[name='" + group + "']").find("option[value!='']:selected").text();
		}
		$("#"+houseNumber_prefix).text(prefix);
		if(houseNumber != null){
			$("#" + houseNumber).attr("reg", '{"required":"true","maxlength":23}');
        	if($.isEmpty($("#" + houseNumber).val())){
        		$("#" + houseNumber).attr("class", "lose");
        	}
		}else{
			if (!$.isEmpty(methodName))
			{
				var callback = eval(methodName);
				callback();
			}
		}
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
                            $("#tumorIcd10Name").val(data.diseaseName);
                        });
				}
			}
		});
	}


	function save(event)
	{

		var $idcard = $("#cdm_report_idcard");
		if ($idcard.val() == $idcard.attr("placeholder"))
		{
			$idcard.val("");
		}

		// 验证
		validate = $("#report-input-form").easyValidate();
		var result = validate.validateForm();
		if (!result)
		{
			return;
		}

		// 保存
		$("#report-input-form").submitFormGetJson({
			url : "/cdm/reportcard/app",
			param : {},
			wait : true,
			callback : function(data)
			{
				layui.use('layer', function(){
					var layer = layui.layer;
					if(data=="success"){
						var index = layer.alert("操作成功！", {icon:0,title:'提示'}, function() {
							layer.close(index);
							back();
							reportCardList.refresh();
						});
					}else{
						layer.alert(data, {icon:0,title:'提示'});
					}
				});
			}
		});
	}

	function displayPaAddress() {
        var town = $("#pacounty option:selected").text();
        var street = $("#patownShip option:selected").text();
        var village = $("#pastreet option:selected").text();
        if(!$.isEmpty($("#pastreet option:selected").val())) {
            $("#text_pahouseNumber").removeAttr("reg");
            $("#text_pahouseNumber").removeClass("lose");
        }else{
        	$("#text_pahouseNumber").attr("reg", '{"required":"true","maxlength":23}');
        	if($.isEmpty($("#text_pahouseNumber").val())){
        		$("#text_pahouseNumber").attr("class", "lose");
        	}
        }
    }
    
    function displayHrAddress() {
        var town = $("#hrcounty option:selected").text();
        var street = $("#hrtownShip option:selected").text();
        var village = $("#hrstreet option:selected").text();
        if(!$.isEmpty($("#hrstreet option:selected").val())) {
            $("#text_hrhouseNumber").removeAttr("reg");
            $("#text_hrhouseNumber").removeClass("lose");
        }else {
        	$("#text_hrhouseNumber").attr("reg", '{"required":"true","maxlength":23}');
        	if($.isEmpty($("#text_hrhouseNumber").val())){
        		$("#text_hrhouseNumber").attr("class", "lose");
        	}
        }
    }
    
	function saveToMange(event)
	{
		var selectedValue = $("input[name='personInfo.id']").val();
		if (selectedValue)
		{
			var option = {
				url : "/cdm/standardization/manage",
				param : {
					personId : selectedValue
				},
				wait : true,
				callback : function(data)
				{
					if (data.constructor == Array && data.length > 0)
					{
						var tip = "";
						for ( var i = 0, size = data.length; i < size; i++)
						{
							tip += errorMsg[data[i]] + "\n";
						}
						layer.alert(tip, {icon:0,title:'提示'});
					} else
					{
						$("#list_view").hide();
						$("#input_view").hide();
						$("#manage_view").show();
						$("#manage_view").html(data);
					}
				}
			};
			$.getJsonByUrl(option);
		}
	}

	function back(event)
	{
		$("#list_view").show();
		$("#input_view").hide();
	}
})();
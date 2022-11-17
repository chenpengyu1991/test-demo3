//纳入管理卡
var dmManageInput = (function() {
	var errorMsg = {
		"0" : "纳入信息不全 ",
		"1" : "报卡信息获取失败 ",
		"7" : "管理卡纳入已经管理 ",
		"8" : "获取待纳入报卡信息出错 ",
		"9" : "更新报卡状态出错 ",
		"10" : "保存失败 ",
		 "11":"该身份证关联人员已经在其他社区被管理",
		"12":"该人员已经被注销"
	};
	var disErrorMsg = {
		"2" : "高血压 ",
		"3" : "糖尿病 ",
		"4" : "脑卒中 ",
		"5" : "冠心病 ",
		"6" : "肿瘤 "
	};
	var target = {
		"diComSmokingFlag" : "#diComSmokingDailyNum",
		"diComDrinkingFlag" : "#diComDrinkingdailyNum",
		diCcomCoronaryFlag : "#diCcomCoronaryDisDate,#diCcomCoronaryTreatment",
		diCcomHbpFlag : "#diCcomHbpDisDate,#diCcomHbpTreatment",
		diCcomHbcFlag : "#diCcomHbcDisDate,#diCcomHbcTreatment",
		diCcomRetyFlag : "#diCcomRetyDisDate,#diCcomRetypTreatment",
		diCcomNerveFlag : "#diCcomNerveDisDate,#diCcomNerveTreatment",
		diCcomStrokeFlag : "#diCcomStrokeDisDate,#diCcomStrokeTreatment",
		diCcomFootFlag : "#diCcomFootDisDate,#diCcomFootTreatment",
		diCcomKidneyFlag : "#diCcomKidneyDisDate,#diCcomKidneyTreatment",
		diRtInsulinFlag : "#diRtInsulinDailyCount,#diRtInsulinPerDose",
		diRtHypDrugsFlag : "#diRtHypDrugsDailyCount,#diRtHypDrugsperDose",
		diRtPhyActivityFlag : "#diRtPhyActivityWeekCount,#diRtPhyActivityTime"
	};
	
	var validate = null;
	$(function() {
		validate = $("#health-card-form").easyValidate();
		// 保存按钮
		$("#health-card-save-btn").on("click", save);
		$("#health-card-back-btn").on("click", backToAppPage);
		addDisSwitch();

		$("input[name='hbpSbp']").on("blur", calHbpLevel);
		$("input[name='hbpDbp']").on("blur", calHbpLevel);

//		if (!$("select[name='hbpManageLevel']").val()){
//			calHbpLevel();
//		}

		/*$("select[multiple]").each(function() {
			$(this).multiselect({
				header : false,
				noneSelectedText : '请选择诊断方式',
				selectedList : 13
			});
		});*/
		toggleDisable(target);
	});
	
	function toggleDisable(target) {
		for ( var btn in target) {
			$("input[name=" + btn + "]").on("click", function() {
				var name = $(this).attr("name");
				if ("1" == $(this).val()) {
					$(target[name]).attr("disabled", "disabled").each(function() {
						validate.removeError($(this).attr("name"));
					}).val("");
				} else {
					$(target[name]).removeAttr("disabled");
				}
			});
		}
	}

	function addDisSwitch() {
		$("#dis-select-box input").on("click", function(event) {
			var name = $(this).attr("name");
			var targetBoxId = name + "-box";
			if ($(this).prop("checked")) {
				$("#" + targetBoxId).show();
			} else {
				$("#" + targetBoxId).hide();
			}
		});

		// 人员户籍类型切换
		$("input[name='personInfo.householdType']").on("click", function()
		{
			if ("2" == $(this).val())
			{
				$("#hr-address-select").find("select").attr("disabled", "disabled").hide();
				$("#text_hrhouseNumber_prefix").hide();
			} else
			{
				$("#hr-address-select").find("select").removeAttr("disabled").show();
				$("#text_hrhouseNumber_prefix").show();
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
		
		var option={
				url:"/mdmOrganization/organationTree",
				unSelecteType:['0']
		};
		var opb = {
				url:"/mdmOrganization/organationSelect",
				feild : {
					value : "organCode",
					lable : "organName"
				}
			};
		
		var hbpDiagnosedOrganCode=$("#hbpDiagnosedOrganCode");
		if(hbpDiagnosedOrganCode.length>0){
			hbpDiagnosedOrganCode.selectBox(opb);
			hbpDiagnosedOrganCode.initTreeSelect(option);
		}
		
		var diDiagnosedOrganCode=$("#diDiagnosedOrganCode");
		if(diDiagnosedOrganCode.length>0){
			diDiagnosedOrganCode.selectBox(opb);
			diDiagnosedOrganCode.initTreeSelect(option);
		}
		


	}

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
    
	function back() {
		$("#list_view").show();
		$("#manage_view").hide();
	}
	
	function backToAppPage(){
		$("#list_view").hide();
		$("#manage_view").hide();
		$("#input_view").show();
	}

	function save(event) {

		var hbpDiagnosedOrganCode  =$("input[name='hbpDiagnosedOrganCode']").val();
		if(!hbpDiagnosedOrganCode){
			$("#hbpDiagnosedOrganCode").val("");
		}

		var diDiagnosedOrganCode  =$("input[name='diDiagnosedOrganCode']").val();
		if(!diDiagnosedOrganCode){
			$("#diDiagnosedOrganCode").val("");
		}

		// 验证
		validate = $("#health-card-form").easyValidate();
		var result = validate.validateForm();
		if (!result) {
			return;
		}
		// 保存
		$("#health-card-form").submitFormGetJson({
			url : "/cdm/standardization/doManage",
			wait:true,
			callback : function(data) {
				if (data&&data.constructor == Array && data.length > 0) {
					layer.alert(getErrorMsg(data), {icon:0,title:'提示'});
				} else {
					layer.alert("纳入成功！", {icon:0,title:'提示'}, function(index) {
						back();
						reportCardList.refresh();
						layer.close(index);
					});
				}
			}
		});
	}

	function getErrorMsg(data) {
		var tip = "";
		var tmp = "";
		for ( var i = 0, size = data.length; i < size; i++) {
			tmp = disErrorMsg[data[i]];
			if (tmp) {
				tip += tmp;
			}
		}
		if (tip) {
			tip += "已经管理!<br >";
		}
		for ( var i = 0, size = data.length; i < size; i++) {
			tmp = errorMsg[data[i]];
			if (tmp) {
				tip += tmp + "!<br >";
			}
		}
		return tip;
	}
	function calHbpLevel()
	{
		var value = calHbpLevelValue();
		//console.log(value);
		$("select[name='hbpManageLevel']").val(value);
	}

	function calHbpLevelValue()
	{
		var sbp = $("input[name='hbpSbp']").val();
		var dbp = $("input[name='hbpDbp']").val();
		var level = 0;
		if (sbp){
			if (sbp >= 180){
				level = 3;
				return level;
			} else if (sbp >= 160){
				level = 2;
			} else if (sbp >= 140){
				level = 1;
			}
		}

		if (dbp){
			if (dbp >= 110){
				level = 3;
				return level;
			} else if (dbp >= 100){
				level = 2;
				return level;
			} else if (level < 2 && dbp >= 90){
				level = 1;
				return level;
			}
		}
		return level;
	}
	
})();











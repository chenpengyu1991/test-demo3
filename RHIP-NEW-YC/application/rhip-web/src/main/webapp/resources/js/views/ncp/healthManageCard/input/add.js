//新增管理卡
var dmManageAdd = (function ()
{
    var errorMsg = {
        "0": "纳入信息不全 ",
        "1": "报卡信息获取失败 ",
        "7": "管理卡纳入已经管理 ",
        "8": "获取待纳入报卡信息出错 ",
        "9": "更新报卡状态出错 ",
        "10": "保存失败 ",
        "11": "该身份证关联人员已经在其他社区被管理",
        "12": "该人员已经被注销"
    };
    var disErrorMsg = {
        "2": "高血压 ",
        "3": "糖尿病 ",
        "4": "脑卒中 ",
        "5": "冠心病 ",
        "6": "肿瘤 "
    };

    var target = {
        diComSmokingFlag: "#diComSmokingDailyNum",
        diComDrinkingFlag: "#diComDrinkingdailyNum",
        diCcomCoronaryFlag: "#diCcomCoronaryDisDate,#diCcomCoronaryTreatment",
        diCcomHbpFlag: "#diCcomHbpDisDate,#diCcomHbpTreatment",
        diCcomHbcFlag: "#diCcomHbcDisDate,#diCcomHbcTreatment",
        diCcomRetyFlag: "#diCcomRetyDisDate,#diCcomRetypTreatment",
        diCcomNerveFlag: "#diCcomNerveDisDate,#diCcomNerveTreatment",
        diCcomStrokeFlag: "#diCcomStrokeDisDate,#diCcomStrokeTreatment",
        diCcomFootFlag: "#diCcomFootDisDate,#diCcomFootTreatment",
        diCcomKidneyFlag: "#diCcomKidneyDisDate,#diCcomKidneyTreatment",
        diRtInsulinFlag: "#diRtInsulinDailyCount,#diRtInsulinPerDose",
        diRtHypDrugsFlag: "#diRtHypDrugsDailyCount,#diRtHypDrugsperDose",
        diRtPhyActivityFlag: "#diRtPhyActivityWeekCount,#diRtPhyActivityTime"
    };
    var validate = null;
    var oldPersonIdCard = null;
    $(function ()
    {// 保存按钮
        $("#health-card-save-btn").on("click", save);
        $("#health-card-back-btn").on("click", back);
        $("input[name='hbpSbp']").on("blur", calHbpLevel);
        $("input[name='hbpDbp']").on("blur", calHbpLevel);

        if (!$("select[name='hbpManageLevel']").val()){
            calHbpLevel();
        }
        //地址三级不是必输项
        $("#pastreet").removeAttr("reg");
        $("#hrstreet").removeAttr("reg");

        addDisSwitch();
        $.Placeholder.init({
            query: "#idcard2",
            callback: queryPerson
        });
        $("select[multiple]").each(function ()
        {
            $(this).multiselect({
                header: false,
                noneSelectedText: '请选择诊断方式',
                selectedList: 13
            });
        });

        var option = {
            url: "/mdmOrganization/organationTree",
            unSelecteType: ['0']
        };
        var opb = {
            url: "/mdmOrganization/organationSelect",
            feild: {
                value: "organCode",
                lable: "organName"
            }
        };

        var hbpDiagnosedOrganCode = $("#hbpDiagnosedOrganCode");
        if (hbpDiagnosedOrganCode.length > 0){
            hbpDiagnosedOrganCode.selectBox(opb);
            hbpDiagnosedOrganCode.initTreeSelect(option);
        }

        var diDiagnosedOrganCode = $("#diDiagnosedOrganCode");
        if (diDiagnosedOrganCode.length > 0){
            diDiagnosedOrganCode.selectBox(opb);
            diDiagnosedOrganCode.initTreeSelect(option);
        }

        addIcd10AutoComplete();
        toggleDisable(target);

        $("#check-submit-btn1").on("click", function () {

            StartRead();
            $("#idcard2").val(GT2ICROCX.CardNo);
        });

        // 其它诊断单位 切换
        $("#hbpOtherDiagnosisOrganFlag").click(function() {
            diagnosisOrganChange("hbp");
        });
        diagnosisOrganChange("hbp");
        $("#diOtherDiagnosisOrganFlag").click(function() {
            diagnosisOrganChange("di");
        });
        diagnosisOrganChange("di");
        validate = $("#health-card-form").easyValidate();
        //民族
        var nationValue = $("input[name='personInfo.nation']:checked").val();;
        if('99' == nationValue){
            $("#otherNationDesc").show();
        }
        //新冠肺炎类型  为确诊病例时显示 县内治疗 县外治疗
        var patientTypeValue = $("input[name='patientType']:checked").val();;
        if('2' == patientTypeValue){
            $("#xwzl").show();
        }
    });

    // 诊断机构切换实现
    function diagnosisOrganChange(spanName) {
        if($('input[name="' + spanName + 'OtherDiagnosisOrganFlag"]:visible:checked').val() == '2'){
            $("#" + spanName + "DiagnosedSpanId").hide();
            $("#" + spanName + "DiagnosedNameSpanId").show();
            //$("#" + spanName + "FileAddTrId").show();
            $("#" + spanName + "FileViewTrId").show();
        } else {
            $("#" + spanName + "DiagnosedSpanId").show();
            $("#" + spanName + "DiagnosedNameSpanId").hide();
            //$("#" + spanName + "FileAddTrId").hide();
            $("#" + spanName + "FileViewTrId").hide();
        }
    }

    function StartRead()//开始读卡
    {
        if (GT2ICROCX.GetState() == 0){
            GT2ICROCX.ReadCard()
        }
    }



    function addDisSwitch()
    {

        $("#dis-select-box input").on("click", function (event)
        {
            var name = $(this).attr("name");
            var targetBoxId = name + "-box";
            if ($(this).prop("checked")){
                $("#" + targetBoxId).show();
            } else {
                $("#" + targetBoxId).hide();
            }
        });

        // 人员户籍类型切换
        $("input[name='personInfo.householdType']").on("click", function ()
        {
        	$("#hrstreet").val("");
        	$("#hrcounty").val("");
        	$("#hrtownShip").val("");
        	$("#text_hrhouseNumber_prefix").text("");
            if ("2" == $(this).val()||"4" == $(this).val()){
                $("#hr-address-select").find("select").attr("disabled", "disabled").hide();
                $("#hr-address-select").hide();
                $("#text_hrhouseNumber_prefix").hide();
            } else {
                $("#hr-address-select").find("select").removeAttr("disabled").show();
                $("#hr-address-select").show();
                $("#text_hrhouseNumber_prefix").show();
            }
        });
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

    function toggleDisable(target)
    {
        for (var btn in target) {
            $("input[name=" + btn + "]").on("click", function ()
            {
                var name = $(this).attr("name");
                if ("1" == $(this).val()){
                    $(target[name]).attr("disabled", "disabled").each(function ()
                    {
                        validate.removeError($(this).attr("name"));
                    }).val("");
                } else {
                    $(target[name]).removeAttr("disabled");
                }
            });
        }
    }

    function back()
    {   
        $("#ncp-manage-input-box").hide();
        $("#ncp-manage-list-box").show();
        $('#evaluateEdit').empty();
        $('#evaluateEdit').hide();
        $('#evaluateSearch').show();
    }

    function doSave() {
        // 保存
        if ($("#inputOrganName").val() != null) {
            $("#health-card-form").submitFormGetJson({
                url: "/ncp/healthManageCard/save",
                param: {},
                wait: true,
                callback: function (data) {
                	
                	layui.use('layer', function(){
            			var layer = layui.layer;
            			
            			if (data && data.constructor == Array && data.length > 0) {
            				layer.alert(getErrorMsg(data), {icon:0,title:'提示'});
            			} else {
            				var index = layer.alert("提交成功", {icon:0,title:'提示'}, function () {
            					layer.close(index);
            					back();
            					healthCardList.search(1);
            				});
            			}
            		});
                }
            });
        }
    }
    function save(event)
    {   
    	var flag=0;
    	validate = $("#health-card-form").easyValidate();
        var result = validate.validateForm();
        if (!result){
            return;
        }
        var edit = $("#edit").val();debugger;
        if(edit){
            doSave();
        } else {
            $.getJsonByUrl({
                url: "/ncp/healthManageCard/load",
                param: {
                    "personInfo.idcard": $.trim($("#idcard2").val()).toUpperCase(),
                    "ncpPatientId":$("#disid").val()
                },
                callback: function (data)
                {
                    if(data!=null){
                        $("#manageFlag").val("");
                         if(data.filingFlag=="9"){
                            layer.alert("该人员已结案，请先激活再建管理卡！", {icon:0,title:'提示'});
                        }else if(data.filingFlag!="1" && data.filingFlag!="5"){
                            layer.alert("此人员尚未建档，请先给此人员创建健康档案！", {icon:0,title:'提示'});
                        }else if(data.manageFlag=="1" || data.manageFlag=="2"){
                            $("#manageFlag").val(data.manageFlag);
                            layer.alert("该人员已经建过管理卡，不能重复创建！", {icon:0,title:'提示'});
                        }else if(!data.subOrg&&data.inputOrganCode!=$("[name='managementOrg']").val()){
                            layer.alert("此人员管理机构不属于当前机构，请先迁入再建管理卡！", {icon:0,title:'提示'});
                        }else{
                            // 保存
                             doSave();
                        }
                    }else{
                        layer.alert("此人员尚未建档，请先给此人员创建健康档案！", {icon:0,title:'提示'});
                    }
                }
            });
        }
        
        
//        if($("#filingFlag").val()!="1" && $("#filingFlag").val()!="5"){
//        	layer.alert("此人员尚未建档，请先给此人员创建健康档案！");
//            return;
//        }if($("#filingFlag").val()=="9"){
//        	layer.alert("该人员已结案，请先激活再建管理卡");
//        	return;
//        }if($("#manageFlag").val()=="1" || $("#manageFlag").val()=="2"){
//        	layer.alert("该人员已经建过管理卡，不能重复创建！");
//        	return;
//        }
//        if($("[name='managementOrg']").val()!=$("#inputOrganCode").val()){
//        	layer.alert("此人员管理机构不属于当前机构，请先迁入再建管理卡！");
//            return;
//        }
        
       
    }



    /**
     * 如果从健康档案中弹出的页面需要更新健康档案基本信息
     */
    function updatePersonInfo(){
        //婚姻状况
        var marriageValue = $("select[name='personInfo.marriage']").val();
        $(":radio[name='PersonalBasicInfoDTO.personInfo.marriage'][value='" + marriageValue +"']").attr("checked", "checked");
        //职业
        var occupationValue = $("select[name='personInfo.occupation']").val();
        $("select[name='PersonalBasicInfoDTO.personInfo.occupation']").val(occupationValue);
        //民族
        var nationValue = $("input[name='personInfo.nation']:checked").val();
        $(":radio[name='PersonalBasicInfoDTO.personInfo.nation'][value='" + nationValue +"']").attr("checked", "checked");
        if('99' == nationValue){
            //如果选择其他，则赋值其他输入框
            var otherNationDesc = $("input[name='personInfo.otherNationDesc']").val();
            $("input[name='PersonalBasicInfoDTO.personInfo.otherNationDesc']").val(otherNationDesc);
            $("input[name='PersonalBasicInfoDTO.personInfo.otherNationDesc']").show();
        }else{
            $("input[name='PersonalBasicInfoDTO.personInfo.otherNationDesc']").val("");
            $("input[name='PersonalBasicInfoDTO.personInfo.otherNationDesc']").hide();
        }
        //文化程度
        var educationValue = $("select[name='personInfo.education']").val();
        $("select[name='PersonalBasicInfoDTO.personInfo.education']").val(educationValue);
        //工作单位
        var unitNameValue = $("input[name='personInfo.unitName']").val();
        $("input[name='PersonalBasicInfoDTO.personInfo.unitName']").val(unitNameValue);
        
        //冠心病确诊时间
        var coronaryDiagnosisDate = $("input[name='coronaryDiagnosisDate']").val();
        $("input[name='PersonalBasicInfoDTO.gxbDate']").val(coronaryDiagnosisDate);
        //脑卒中确诊时间
        var strokeDiagnosisDate = $("input[name='strokeDiagnosisDate']").val();
        $("input[name='PersonalBasicInfoDTO.nzzDate']").val(strokeDiagnosisDate);
        //高血压确诊时间
        var hbpDiagnosedDate = $("input[name='hbpDiagnosedDate']").val();
        $("input[name='PersonalBasicInfoDTO.gxyDate']").val(hbpDiagnosedDate);
        //糖尿病确诊时间
        var diDiagnosedDate = $("input[name='diDiagnosedDate']").val();
        $("input[name='PersonalBasicInfoDTO.tnbDate']").val(diDiagnosedDate);
        
        var tumorIcdTenCode = $("input[name='tumorIcdTenCode']").val();
        if(/^C.*$/.test(tumorIcdTenCode)){//C开头的恶性肿瘤，要把信息带到健康档案第二页
        	$("input[name='PersonalBasicInfoDTO.exzl']").attr("checked", true);
	        //肿瘤确诊时间
	        var tumorDiagnosisDate = $("input[name='tumorDiagnosisDate']").val();
	        $("input[name='PersonalBasicInfoDTO.exzlDate']").val(tumorDiagnosisDate);
	        //肿瘤肿瘤病名
	        var tumorType = $("input[name='tumorType']").val();
	        $("input[name='PersonalBasicInfoDTO.exzlName']").val(tumorType);
        }else{
        	$("input[name='PersonalBasicInfoDTO.exzl']").attr("checked", false);
        }
        //本人电话
        var phoneNumber = $("input[name='personInfo.phoneNumber']").val();
        $("#phoneNumber_text").text(phoneNumber);
        $("input[name='PersonalBasicInfoDTO.personInfo.phoneNumber']").val(phoneNumber);
        //常住类型
        var householdType = $("input[name='personInfo.householdType']:checked").attr("data-label");
        $("#householdType_text").text(householdType);
        //性别
        var genderValue = $("input[name='personInfo.gender']:checked").val();
        $(":radio[name='PersonalBasicInfoDTO.personInfo.gender'][value='" + genderValue +"']").attr("checked", "checked");
    }
    
    function getErrorMsg(data)
    {
        var tip = "";
        var tmp = "";
        for (var i = 0, size = data.length; i < size; i++) {
            tmp = disErrorMsg[data[i]];
            if (tmp){
                tip += tmp;
            }
        }
        if (tip){
            tip += "已经管理!<br >";
        }
        for (var i = 0, size = data.length; i < size; i++) {
            tmp = errorMsg[data[i]];
            if (tmp){
                tip += tmp + "!<br >";
            }
        }
        return tip;
    }

    function queryPerson(input)
    {
        var idCard = $("#idcard2").val();
        if (idCard){
            idCard = $.trim(idCard);
        }
        if (validate.validate("personInfo.idcard") && oldPersonIdCard != idCard){
            oldPersonIdCard = idCard;
            $.getJsonByUrl({
                url: "/ncp/healthManageCard/load",
                param: {
                    "personInfo.idcard": idCard.toUpperCase(),
                    "ncpPatientId":$("#disid").val()
                },
                wait: true,
                callback: function (data)
                {	
                	if(data!=null){
                		$("#manageFlag").val("");
	                	 if(data.filingFlag=="9"){
	                    	layer.alert("该人员已结案，请先激活再建管理卡！", {icon:0,title:'提示'});
	                    }else if(data.filingFlag!="1" && data.filingFlag!="5"){
	                    	layer.alert("此人员尚未建档，请先给此人员创建健康档案！", {icon:0,title:'提示'});
	                    }else if(data.manageFlag=="1" || data.manageFlag=="2"){
	                    	$("#manageFlag").val(data.manageFlag);
	                    	layer.alert("该人员已经建过管理卡，不能重复创建！", {icon:0,title:'提示'});
	                    }else if(!data.subOrg&&data.inputOrganCode!=$("[name='managementOrg']").val()){
	                    	layer.alert("此人员管理机构不属于当前机构，请先迁入再建管理卡！", {icon:0,title:'提示'});
	                    }else{
	                    	setPersonData(data, idCard);
	                    }
                	}else{
                		layer.alert("此人员尚未建档，请先给此人员创建健康档案！", {icon:0,title:'提示'});
                	}
                }
            });
        }

    }

    function setPersonData(data, idcard)
    {
        if (data)
        {  
        	$('#filingFlag').val(data.filingFlag);
            $('#personId').val(data.id);
            $('#idcard2').val(data.idcard);
            $('#cdm_report_name').val(data.name);
            $('input[name="personInfo.gender"]').val([data.gender]);
            // var birthday = new Date(data.birthday);
            // $('#birthday').val(format(birthday, "yyyy/MM/dd"));
            $('#birthday').val(data.birthdayStr);
            $('#marriage').val(data.marriage||'20');
            $('#occupation').val(data.occupation);
            if(!$.isEmpty(data.nation)){
                $('input[name="personInfo.nation"]').val([data.nation]);
            }else{
                $('input[name="personInfo.nation"]').val(['01']);
            }
            if(data.nation == '99') {
            	$('#otherNationDesc').show();
                $('#otherNationDesc').val(data.otherNationDesc);
            }
            $('#education').val(data.education);
            $('input[name="personInfo.householdType"]').val([data.householdType]);
            $('#phoneNumber').val(data.phoneNumber);
            if (data.householdType == "2") {
                $("input[name='personInfo.householdType']:eq(1)").attr("checked", true);
                $("#homeTr").css("display", "none");
               // $("#hr-address-select").find("select").attr("disabled", "disabled");
                $("#hr-address-select").hide();
            }else if (data.householdType == "4") {
                $("input[name='personInfo.householdType']:eq(2)").attr("checked", true);
                $("#homeTr").css("display", "none");
                $("#hr-address-select").hide();
                //$("#hr-address-select").find("select").attr("disabled", "disabled");
            }else if (data.householdType == "1") {
                $("input[name='personInfo.householdType']:eq(0)").attr("checked", true);
                $("#homeTr").css("display", "none");
                //$("#hr-address-select").find("select").removeAttr("disabled");
                $("#hr-address-select").removeClass("hide");
                $("#hr-address-select").show();
                $("#text_hrhouseNumber_prefix").show();
            }
            var iddStreet2 ;
            var iddStreet;
            if(data.hrtownShip!=null){
                $("#hrcounty").val(data.hrtownShip);
                iddStreet2 = $("#hrcounty").attr("idd").replace('townId', '');
            }
            if(data.patownShip!=null){
                $("#pacounty").val(data.patownShip);
                iddStreet=$("#pacounty").attr("idd").replace('townId', '');
            }
            orgUtil.getStreetOpting(iddStreet2, data.hrstreet, 'displayHrAddress', data.hrGroup);
            setTimeout(function () {
            	orgUtil.getStreetOpting(iddStreet, data.pastreet, 'displayPaAddress', data.paGroup);
            }, 500);
            $("#text_hrhouseNumber_prefix").text(data.hrAddressDetail);
            $("#text_pahouseNumber_prefix").text(data.paAddressDetail);

            $('#pahouseNumber').val(data.pahouseNumber);
            $('#hrhouseNumber').val(data.hrhouseNumber);

            $('#unitName').val(data.unitName);
            $('#inputOrganName').val(data.inputOrganName);
            $('#inputOrganCode').val(data.inputOrganCode);
            $("#hrcounty").val(data.hrtownShip);
        } else
        {
            $('#cdm_report_personId').val("");
            $('#cdm_person_personId').val("");
            // $('#cdm_report_idcard').val("");
            $('#cdm_report_name').val("");
            // 根据身份证计算生日和性别
            try
            {
                var idcard= $('#dcard2').val();
                $('#birthday').val(IC.getBirthday(idcard));
                $('input[name="personInfo.gender"]').val([IC.getGender(idcard)]);
            } catch (e)
            {
                $('#birthday').val("");
                $('input[name="personInfo.gender"]').val(['']);
            }
            $('#marriage').val("20");
            $('#occupation').val("");
            $('#nation').val("");
            $('#education').val("");
            $('input[name="personInfo.householdType"]').val([ '1' ]);
            $('#phoneNumber').val("");
            $('#hrtownShip').val("");
            $('#patownShip').val("");

            $('#pastreet').val("");
            $('#hrstreet').val("");

            $("#text_hrhouseNumber_prefix").text("");
            $("#text_pahouseNumber_prefix").text("");

            $('#pahouseNumber').val("");
            $('#hrhouseNumber').val("");
            $('#unitName').val("");
            $('#inputOrganName').val("");
            $('#inputOrganCode').val("");
        }
        //$("input[name='personInfo.householdType']:checked").click();

    }

    function calHbpLevel()
    {
        var value = calHbpLevelValue();
        $("select[name='hbpManageLevel']").val(value);
    }

    function calHbpLevelValue()
    {
        //debugger;
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
    function displayHrAddress() {
        var town = $("#hrcounty option:selected").text();
        var street = $("#hrtownShip option:selected").text();
        var village = $("#hrstreet option:selected").text();
        if(!$.isEmpty($("#hrstreet option:selected").val())) {
            $("#hrhouseNumber").removeAttr("reg");
            $("#hrhouseNumber").removeClass("lose");
        }else {
        	$("#hrhouseNumber").attr("reg", '{"required":"true","maxlength":23}');
        	if($.isEmpty($("#hrhouseNumber").val())){
        		$("#hrhouseNumber").attr("class", "lose");
        	}
        }
    }

    function displayPaAddress() {
        var town = $("#pacounty option:selected").text();
        var street = $("#patownShip option:selected").text();
        var village = $("#pastreet option:selected").text();
        if(!$.isEmpty($("#pastreet option:selected").val())) {
            $("#pahouseNumber").removeAttr("reg");
            $("#pahouseNumber").removeClass("lose");
        }else{
        	$("#pahouseNumber").attr("reg", '{"required":"true","maxlength":23}');
        	if($.isEmpty($("#pahouseNumber").val())){
        		$("#pahouseNumber").attr("class", "lose");
        	}
        }
    }
    function doBack() {
        $("#beforeSaveDiv").show();
        $("#mbglk").hide();
        addPersonInfo.backSave();
    }

    return {
        displayHrAddress: displayHrAddress,
        displayPaAddress: displayPaAddress
    };
})();
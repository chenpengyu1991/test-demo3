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
        "12": "该人员已经被注销",
        "13": "该人员未在本社区建档,请先建档"
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
        $("#health-card-back-btn").on("click", function () {
            layer.confirm("确认离开？",function(index){
                layer.close(index);
                back();
            });
        });

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
        /*$("select[multiple]").each(function ()
        {
            $(this).multiselect({
                header: false,
                noneSelectedText: '请选择诊断方式',
                selectedList: 13
            });
        });*/

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
            $("#cdmOtherNationDesc").show();
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
        $("#cdm-manage-input-box").hide();
        $("#cdm-manage-list-box").show();
        $('#evaluateEdit').empty();
        $('#evaluateEdit').hide();
        $('#evaluateSearch').show();
    }

    function save(event)
    {
        var selectedIitems = $("#dis-select-box").find("input:checked");
        if (selectedIitems.length < 1){
        	layui.use('layer', function(){
				var layer = layui.layer;
				layer.alert("请至选择一种慢病！", {icon:0,title:'提示'});
			});
           /* layer.alert("请至选择一种慢病！");*/
            return;
        }

        var hbpDiagnosedOrganCode  =$("input[name='hbpDiagnosedOrganCode']").val();
        if(!hbpDiagnosedOrganCode){
            $("#hbpDiagnosedOrganCode").val("");
        }

        var diDiagnosedOrganCode  =$("input[name='diDiagnosedOrganCode']").val();
        if(!diDiagnosedOrganCode){
            $("#diDiagnosedOrganCode").val("");
        }
        if(!$.isEmpty($("#pastreet option:selected").val())) {
            $("#text_pahouseNumber").removeAttr("reg");
            $("#text_pahouseNumber").removeClass("lose");
        }
        if(!$.isEmpty($("#hrstreet option:selected").val())) {
            $("#text_hrhouseNumber").removeAttr("reg");
            $("#text_hrhouseNumber").removeClass("lose");
        }
        // 验证
        validate = $("#health-card-form").easyValidate();
        var result = validate.validateForm();
        if (!result){
            // layer.alert("请根据提示正确输入！");
            return;
        }
        // add by Kevin Ro 2019-03-01
        /* var hbpFlag = $("input[name='hbpFlag']").prop("checked");
        var diFlag = $("input[name='diFlag']").prop("checked");

        if(hbpFlag  && !diFlag) { // 只选中了高血压
            if($("#cdmCardHbpFile ul li").length < 1) {
                msgUtil.alert("高血压附件不能为空！");
                return;
            }
        } else if(!hbpFlag && diFlag) { // 只选中糖尿病
            if($("#cdmCardDiFile_1 ul li").length < 1) {
                layer.alert("糖尿病附件不能为空！");
                return;
            }
        }*/ /*else { // 两个都没选
            if($("#cdmCardHbpFile ul li").length < 1 || $("#cdmCardDiFile_1 ul li").length < 1) {
                layer.alert("附件不能为空！");
                return;
            }
        }*/
        // 保存
        $("#health-card-form").submitFormGetJson({
            url: "/cdm/standardization/add",
            param: {},
            wait: true,
            callback: function (data)
            {
                var layer = layui.layer;
                if(data && data.isManagedByOtherOrg){
                    layer.alert(data.isManagedByOtherOrg + "<br >",{icon:0,title:'提示'}, function (index){
                        layer.close(index);
                    });
                }else if (data&&data.constructor == Array && data.length > 0){
                    // var tip = "";
                    // for ( var i = 0, size = data.length; i < size; i++) {
                    // tip += errorMsg[data[i]] + "\n";
                    // }
                    layer.alert(getErrorMsg(data),{icon:0,title:'提示'}, function (index){
                        layer.close(index);
                    });

                } else {
                    var index = layer.alert("提交成功！", {icon:0,title:'提示'}, function ()
                    {
                        layer.close(index);
                    	updatePersonInfo();
                        back();
                        doBack();
                        /*if("undefined" != typeof(healthCardList)){
                            healthCardList.search(1);
                        }*/
						search(1);
                    });

                }
            }
        });
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
 function isNumber(val) {
	        if (val) {
	            return val.match(/(\d+)|(^(\d+.\d+)$)/);
	        }
	        return true;
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
                url: "/cdm/standardization/load",
                param: {
                    "personInfo.idcard": idCard.toUpperCase()
                },
                wait: true,
                callback: function (data)
                {
                    var layer = layui.layer;
                    if (data == null){//如果没建档先建管理卡，需提示先建档才能创建管理卡
                        layer.alert("人员在本社区未建档，请先建档！",{icon:0,title:'提示'}, function (index){
                            layer.close(index);
                        });
                    }else {
                        setPersonData(data, idCard);
                    }
                }
            });
        }

    }

    function setPersonData(data, idcard)
    {
         //debugger;

        if (data){
            $("#dis-personid").val(data.id);
            $("#dis-person-id").val(data.id);
            $('#idcard2').val(data.idcard);
            $('#name').val(data.name);
            $('input[name="personInfo.gender"]').val([data.gender]);
            $('#cdmInputBirthday').val(data.birthdayStr);
            $('#marriage').val(data.marriage);
            $('#occupation').val(data.occupation);
            if(!$.isEmpty(data.nation)){
                $('input[name="personInfo.nation"]').val([data.nation]);
            }else{
                $('input[name="personInfo.nation"]').val(['01']);
            }
            if(data.nation == '99') {
                $('#cdmOtherNationDesc').show();
                $('#cdmOtherNationDesc').val(data.otherNationDesc);
            }
            $('#education').val(data.education);
            $('input[name="personInfo.householdType"]').val([ data.householdType ]);
			$("input[name='personInfo.householdType']:checked").click();
            $('#phoneNumber').val(data.phoneNumber);

            if (data.householdType == "2") {
                $("input[name='personInfo.householdType']:eq(1)").attr("checked", true);
                $("#homeTr").css("display", "none");
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

           orgUtil.getStreetOpting(iddStreet, data.pastreet, '', data.paGroup);
            setTimeout(function () {
                orgUtil.getStreetOpting(iddStreet2, data.hrstreet, '', data.hrGroup);
            }, 500);

            $("#text_hrhouseNumber_prefix").text(data.hrAddressDetail);
            $("#text_pahouseNumber_prefix").text(data.paAddressDetail);

            $('#text_pahouseNumber').val(data.pahouseNumber);
            $('#text_hrhouseNumber').val(data.hrhouseNumber);

            $('#unitName').val(data.unitName);
            $('#inputOrganName').val(data.inputOrganName);
            $('#inputOrganNameTxt').text(data.inputOrganName);
            $('#inputOrganCode').val(data.inputOrganCode);

            var dmManagedFlag=data.dmManagedFlag;
            if(dmManagedFlag&&$.isArray(dmManagedFlag)){
                $("input[name='hbpFlag']","#dis-select-box").prop("disabled",dmManagedFlag[0]);
                $("input[name='diFlag']","#dis-select-box").prop("disabled",dmManagedFlag[1]);
                $("input[name='strokeFlag']","#dis-select-box").prop("disabled",dmManagedFlag[2]);
                $("input[name='coronaryFlag']","#dis-select-box").prop("disabled",dmManagedFlag[3]);
                $("input[name='tumorFlag']","#dis-select-box").prop("disabled",dmManagedFlag[4]);
            }

            var personManagedFlag=data.personManagedFlag;
            var managedByOtherOrg = data.managedByOtherOrg;
            if($.isArray(personManagedFlag)){
                if($.inArray("12", personManagedFlag)!=-1){
                	layer.alert("该患者已经被注销！", {icon:0,title:'提示'});
                }else if(managedByOtherOrg && $.inArray("11", personManagedFlag)!=-1){
                	layer.alert(managedByOtherOrg, {icon:0,title:'提示'});
                }
            }

        } else {
            $("#dis-personid").val("");
            $("#dis-person-id").val("");
            $('#name').val("");
            try {
                var idcard = $("#idcard2").val();
                $('#cdmInputBirthday').val(IC.getBirthday(idcard));
                $('input[name="personInfo.gender"]').val([IC.getGender(idcard)]);
            } catch (e) {
                $('#cdmInputBirthday').val("");
                $('input[name="personInfo.gender"]').val([""]);
            }
            $('#marriage').val("");
            $('#occupation').val("");
            $('#nation').val("01");
            $('#education').val("");
            $('input[name="personInfo.householdType"]').val([ '1' ]);
            $('#phoneNumber').val("");
            $("select[name='personInfo.patownShip']").val("");
            $("select[name='personInfo.hrtownShip']").val("");
            $("select[name='personInfo.pastreet']").val("");
            $("select[name='personInfo.hrstreet']").val("");
            $("select[name='personInfo.paGroup']").val("");
            $("select[name='personInfo.hrGroup']").val("");
            $("#text_hrhouseNumber_prefix").text("");
            $("#text_pahouseNumber_prefix").text("");
            $("input[name='personInfo.pahouseNumber']").val("");
            $("input[name='personInfo.hrhouseNumber']").val("");
            $('#unitName').val("");
            $('#inputOrganName').val("");
            $('#inputOrganCode').val("");
            $("input[name='hbpFlag']","#dis-select-box").prop("disabled",false);
            $("input[name='diFlag']","#dis-select-box").prop("disabled",false);
            $("input[name='strokeFlag']","#dis-select-box").prop("disabled",false);
            $("input[name='coronaryFlag']","#dis-select-box").prop("disabled",false);
            $("input[name='tumorFlag']","#dis-select-box").prop("disabled",false);
        }
        
        // $('#idcard').attr("readonly",true);



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
            $("#text_hrhouseNumber").removeAttr("reg");
            $("#text_hrhouseNumber").removeClass("lose");
        }else {
        	$("#text_hrhouseNumber").attr("reg", '{"required":"true","maxlength":23}');
        	if($.isEmpty($("#text_hrhouseNumber").val())){
        		$("#text_hrhouseNumber").attr("class", "lose");
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

    function doBack() {
        $("#beforeSaveDiv").show();
        $("#mbglk").hide();
        //addPersonInfo.backSave();
    }

    return {
        displayHrAddress: displayHrAddress,
        displayPaAddress: displayPaAddress
    };
})();
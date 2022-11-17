//新增管理卡
var dmManageAddHis = (function () {
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
    $(function () {
    	var contextPath = "${pageContext.request.contextPath}";
    	 $.ajaxSetup({
             contentType: "application/x-www-form-urlencoded; charset=utf-8"
         });
    	
        validate = $("#health-card-form").easyValidate();
        // 保存按钮
        $("#health-card-save-btn-external").on("click", saveExternal);

        $("input[name='hbpSbp']").on("blur", calHbpLevel);
        $("input[name='hbpDbp']").on("blur", calHbpLevel);

        if (!$("select[name='hbpManageLevel']").val()) {
            calHbpLevel();
        }

        addDisSwitch();
        $.Placeholder.init({
            query: "#idcard",
            callback: queryPerson
        });
        //if ($.isEmpty($("#exFlag").val())) {
            queryPerson();
        //}
        $("select[multiple]").each(function () {
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


    });

    function addDisSwitch() {

        $("#dis-select-box input").on("click", function (event) {
            var name = $(this).attr("name");
            var targetBoxId = name + "-box";
            if ($(this).prop("checked")) {
                $("#" + targetBoxId).show();
            } else {
                $("#" + targetBoxId).hide();
            }
        });

        // 人员户籍类型切换
        $("input[name='personInfo.householdType']").on("click", function () {
            if ("2" == $(this).val()) {
                $("#hr-address-select").find("select").attr("disabled", "disabled").hide();
                $("#text_hrhouseNumber_prefix").hide();
            } else {
                $("#hr-address-select").find("select").removeAttr("disabled").show();
                $("#text_hrhouseNumber_prefix").show();
            }
        });

        // 地址变化
        $("select[name='personInfo.pastreet']").on("change villageChange", function () {
            var prefix = $("select[name='personInfo.patownShip']").find("option[value!='']:selected").text();
            prefix += $(this).find("option[value!='']:selected").text();
            $("#text_pahouseNumber_prefix").text(prefix);
        });

        // 地址变化
        $("select[name='personInfo.hrstreet']").on("change villageChange", function () {
            var prefix = $("select[name='personInfo.hrtownShip']").find("option[value!='']:selected").text();
            prefix += $(this).find("option[value!='']:selected").text();
            $("#text_hrhouseNumber_prefix").text(prefix);
        });

    }

    function addIcd10AutoComplete() {
        $.getJsonByUrl({
            url: "/cdm/reportcard/complete/disease",
            param: {inputValue: "C"},
            callback: function (data) {
                var hbpDiagnosedOrganCode = $("#tumorIcd10Code");
                if (hbpDiagnosedOrganCode.length > 0) {
                    hbpDiagnosedOrganCode.autocomplete(data, {
                        minChars: 0,
                        width: 250,
                        max: 100,
                        autoFill: false,
                        matchContains: true,
                        formatItem: function (row, i, max) {
                            return row.diseaseName + "[" + row.icd10main + "]";
                        },
                        formatMatch: function (row, i, max) {
                            return row.diseaseName + " " + row.icd10main;
                        },
                        formatResult: function (row) {
                            return row.icd10main;
                        }
                    }).result(function (event, data, formatted) {
                        $("input[name='tumorType']").val(data.diseaseName);
                    });
                }
            }
        });
    }

    function toggleDisable(target) {
        for (var btn in target) {
            $("input[name=" + btn + "]").on("click", function () {
                var name = $(this).attr("name");
                if ("1" == $(this).val()) {
                    $(target[name]).attr("disabled", "disabled").each(function () {
                        validate.removeError($(this).attr("name"));
                    }).val("");
                } else {
                    $(target[name]).removeAttr("disabled");
                }
            });
        }
    }

    function saveExternal(event) {
        //验证
        if (validateCardForm()) {
            // 保存
            $("#health-card-form").submitFormGetJson({
                url: "/primaryCare/cdm/hmCard/save",
                param: {},
                wait: true,
                callback: function (data) {
                    if(data && data.isManagedByOtherOrg){
                        layer.alert(data.isManagedByOtherOrg + "!<br >",{icon:0,title:'提示'}, function (index){
                            layer.close(index);
                        });
                    }else if (data && data.constructor == Array && data.length > 0) {
                    	layer.alert(getErrorMsg(data), {icon:0,title:'提示'});
                    } else {
                    	layer.alert("提交成功！", {icon:0,title:'提示'});
                    }
                }
            });
        }
    }

    function validateCardForm() {
        var selectedIitems = $("#dis-select-box").find("input:checked");
        if (selectedIitems.length < 1) {
        	layer.alert("请至选择一种慢病！", {icon:0,title:'提示'});
            return false;
        }

        var hbpDiagnosedOrganCode = $("input[name='hbpDiagnosedOrganCode']").val();
        if (!hbpDiagnosedOrganCode) {
            $("#hbpDiagnosedOrganCode").val("");
        }

        var diDiagnosedOrganCode = $("input[name='diDiagnosedOrganCode']").val();
        if (!diDiagnosedOrganCode) {
            $("#diDiagnosedOrganCode").val("");
        }

        // 验证
        var result = validate.validateForm();
        if (!result) {
            // layer.alert("请根据提示正确输入！");
            return false;
        }
        return true;
    }

    function getErrorMsg(data) {
        var tip = "";
        var tmp = "";
        for (var i = 0, size = data.length; i < size; i++) {
            tmp = disErrorMsg[data[i]];
            if (tmp) {
                tip += tmp;
            }
        }
        if (tip) {
            tip += "已经管理!<br >";
        }
        for (var i = 0, size = data.length; i < size; i++) {
            tmp = errorMsg[data[i]];
            if (tmp) {
                tip += tmp + "!<br >";
            }
        }
        return tip;
    }

    function queryPerson(input) {
        var idCard = $("#idcard").val();
        if (idCard) {
            idCard = $.trim(idCard);
        }
        if (validate.validate("personInfo.idcard") && oldPersonIdCard != idCard) {
            oldPersonIdCard = idCard;
            $.getJsonByUrl({
                url: "/primaryCare/cdm/hmCard/load",
                param: {
                    "personInfo.idcard": idCard.toUpperCase(),
                    "orgCode": $("#orgCode").val()
                },
                wait: true,
                callback: function (data) {
                    setPersonData(data, idCard);
                }
            });
        }

    }

    function setPersonData(data, idcard) {
        // debugger;
        if (data) {
            $("#dis-personid").val(data.id);
            $("#dis-person-id").val(data.id);
            $('#idcard').val(data.idcard);
            $('#name').val(data.name);
            $('input[name="personInfo.gender"]').val([data.gender]);
            $('#birthday').val(data.birthdayStr);
            $('#marriage').val(data.marriage);
            $('#occupation').val(data.occupation);
            if (data.nation) {
                $('#nation').val(data.nation);
            } else {
                $('#nation').val('01');
            }
            $('#education').val(data.education);
            $('input[name="personInfo.householdType"]').val([data.householdType]);
            $('#phoneNumber').val(data.phoneNumber);
            $("select[name='personInfo.patownShip']").val(data.patownShip);
            $("select[name='personInfo.hrtownShip']").val(data.hrtownShip);
            // var patownShipIdd = $("select[name='personInfo.patownShip']").attr("idd");
            // if (patownShipIdd)
            //     getVillageOpting(patownShipIdd.replace("townId", ""), "pastreet", data.pastreet);
            // var hrtownShipIdd = $("select[name='personInfo.hrtownShip']").attr("idd");
            // if (hrtownShipIdd)
            //     getVillageOpting(hrtownShipIdd.replace("townId", ""), "hrstreet", data.hrstreet);
            $("input[name='personInfo.pahouseNumber']").val(data.pahouseNumber);
            $("input[name='personInfo.hrhouseNumber']").val(data.hrhouseNumber);
            $('#unitName').val(data.unitName);
            $('#inputOrganName').val(data.inputOrganName);
            $('#inputOrganCode').val(data.inputOrganCode);
            var dmManagedFlag = data.dmManagedFlag;
            if (dmManagedFlag && $.isArray(dmManagedFlag)) {
                $("input[name='hbpFlag']", "#dis-select-box").prop("disabled", dmManagedFlag[0]);
                $("input[name='diFlag']", "#dis-select-box").prop("disabled", dmManagedFlag[1]);
                $("input[name='strokeFlag']", "#dis-select-box").prop("disabled", dmManagedFlag[2]);
                $("input[name='coronaryFlag']", "#dis-select-box").prop("disabled", dmManagedFlag[3]);
                $("input[name='tumorFlag']", "#dis-select-box").prop("disabled", dmManagedFlag[4]);
            }

            var personManagedFlag = data.personManagedFlag;
            var managedByOtherOrg = data.managedByOtherOrg;
            if ($.isArray(personManagedFlag)) {
                if ($.inArray("12", personManagedFlag) != -1) {
                	layer.alert("该患者已经被注销！", {icon:0,title:'提示'});
                } else if (managedByOtherOrg && $.inArray("11", personManagedFlag) != -1) {
                	layer.alert(managedByOtherOrg, {icon:0,title:'提示'});
                }
            }

        } else {
            $("#dis-personid").val("");
            $("#dis-person-id").val("");
            $('#name').val("");
            try {
                var idcard = $("#idcard").val();
                $('#birthday').val(IC.getBirthday(idcard));
                $('input[name="personInfo.gender"]').val([IC.getGender(idcard)]);
            } catch (e) {
                $('#birthday').val("");
                $('input[name="personInfo.gender"]').val([""]);
            }
            $('#marriage').val("");
            $('#occupation').val("");
            $('#nation').val("01");
            $('#education').val("");
            $('input[name="personInfo.householdType"]').val(['1']);
            $('#phoneNumber').val("");
            $("select[name='personInfo.patownShip']").val("");
            $("select[name='personInfo.hrtownShip']").val("");
            $("select[name='personInfo.pastreet']").val("");
            $("select[name='personInfo.hrstreet']").val("");
            $("#text_hrhouseNumber_prefix").text("");
            $("#text_pahouseNumber_prefix").text("");
            $("input[name='personInfo.pahouseNumber']").val("");
            $("input[name='personInfo.hrhouseNumber']").val("");
            $('#unitName').val("");
            $('#inputOrganName').val("");
            $('#inputOrganCode').val("");
            $("input[name='hbpFlag']", "#dis-select-box").prop("disabled", false);
            $("input[name='diFlag']", "#dis-select-box").prop("disabled", false);
            $("input[name='strokeFlag']", "#dis-select-box").prop("disabled", false);
            $("input[name='coronaryFlag']", "#dis-select-box").prop("disabled", false);
            $("input[name='tumorFlag']", "#dis-select-box").prop("disabled", false);
        }
        $("input[name='personInfo.householdType']:checked").click();
        // $('#idcard').attr("readonly",true);


    }

    function calHbpLevel() {
        var value = calHbpLevelValue();
        $("select[name='hbpManageLevel']").val(value);
    }

    function calHbpLevelValue() {
        //debugger;
        var sbp = $("input[name='hbpSbp']").val();
        var dbp = $("input[name='hbpDbp']").val();
        var level = 0;
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
})();
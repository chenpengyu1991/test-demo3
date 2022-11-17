//报卡上报
var dmReportCard = (function()
{
    var validate = null;
    var oldPersonIdCard = null;
    $(function()
    {
        //默认为已婚
        $('#marriage').val("20");
        // 输入身份证自动查询相关信息
        $.Placeholder.init({
            query : "#cdm_report_idcard",
            callback : queryPerson
        });
        // 保存按钮
        $("#report-input-save-btn").on("click", save);
        //地址三级不是必输项
        $("#pastreet").removeAttr("reg");
        $("#hrstreet").removeAttr("reg");
        addDisSwitch();
        // 其它诊断单位 切换
        $("#otherDiagnosisOrganFlag").click(diagnosisOrganChange);
        $("#isSecondaryId").change(isSecondary);
        //isSecondary();
        diagnosisOrganChange();
        addIcd10AutoComplete();

        $("#check-submit-btn").on("click", function () {
            StartRead();
        });

        validate = $("#report-input-form").easyValidate();
    });

    function StartRead()//开始读卡
    {
        if (GT2ICROCX.GetState() == 0){
            GT2ICROCX.ReadCard()
        }

        //GT2ICROCX.ReadCard() //循环读卡

        $("#cdm_report_idcard").val(GT2ICROCX.CardNo);
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

    // 诊断机构切换实现
    function diagnosisOrganChange()
    {
        if($('input[name="otherDiagnosisOrganFlag"]:visible:checked').val() == '2'){
            $("#otherDiagnosisOrganName").show();
            $("#diagnosisOrganCode").hide();
            $("#diagnosisOrganCode").val("");
            // add by Kevin Ro 2018-10-11
            /*$("#dis-select-box input").each(function() {
                var name = $(this).attr("name");
                var targetBoxId = name + "Tr";
                if ($(this).prop("checked")) {
                    $("#" + targetBoxId).show();
                } else {
                    $("#" + targetBoxId).hide();
                }
            })*/
        } else {
            $("#otherDiagnosisOrganName").hide();
            $("#diagnosisOrganCode").show();
            /*$("#dis-select-box input").each(function() {
                var name = $(this).attr("name");
                var targetBoxId = name + "Tr";
                $("#" + targetBoxId).hide();
            })*/
        }
    }

    // 是否继发
    function isSecondary() {
        if($('input[name="isSecondary"]:visible:checked').val() == '1'){
            loadTumorHistory();
        } else {
            $("#secondaryDivId").hide();
            $("input[name='secondaryId']").val("");
        }
    }

    function loadTumorHistory(){
        var tumorDialog = {
            id :"tumorDialogId",
            url:"/cdm/reportcard/tumor/history",
            height : 280,
            width : 400,
            title : "请选择继发源",
            param:{
                idcard: $("#cdm_report_idcard").val()
            }
        };
        $.dialog(tumorDialog);
    }

    // 根据输入的身份证设置相关信息
    function queryPerson(input)
    {
        var idCard = $("#cdm_report_idcard").val();
        if(idCard){
            idCard=$.trim(idCard);
        }
        if (validate.validate("personInfo.idcard") && oldPersonIdCard != idCard)
        {
            oldPersonIdCard = idCard;
            $.getJsonByUrl({
                url : "/cdm/reportcard/load",
                param : {
                    "personInfo.idcard" : idCard.toUpperCase()
                },
                wait : true,
                callback : function(data)
                {
                    setPersonData(data);
                }
            });
        }

    }

    // 设置人员信息
    function setPersonData(data)
    {
        if (data)
        {
            $('#cdm_report_personId').val(data.id);
            $('#cdm_person_personId').val(data.id);
            $('#cdm_report_idcard').val(data.idcard);
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
                $("#hr-address-select").find("select").attr("disabled", "disabled");
                $("#hr-address-select").hide();
            }else if (data.householdType == "4") {
                $("input[name='personInfo.householdType']:eq(2)").attr("checked", true);
                $("#homeTr").css("display", "none");
                $("#hr-address-select").find("select").attr("disabled", "disabled");
                $("#hr-address-select").hide();
            }else if (data.householdType == "1") {
                $("input[name='personInfo.householdType']:eq(0)").attr("checked", true);
                $("#homeTr").css("display", "none");
                $("#hr-address-select").find("select").removeAttr("disabled");
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

            orgUtil.getStreetOpting(iddStreet, data.pastreet, 'displayPaAddress', data.paGroup);
            setTimeout(function () {
                orgUtil.getStreetOpting(iddStreet2, data.hrstreet, 'displayHrAddress', data.hrGroup);
            }, 500);
            $("#text_hrhouseNumber_prefix").text(data.hrAddressDetail);
            $("#text_pahouseNumber_prefix").text(data.paAddressDetail);

            $('#pahouseNumber').val(data.pahouseNumber);
            $('#hrhouseNumber').val(data.hrhouseNumber);

            $('#unitName').val(data.unitName);
            $('#inputOrganName').val(data.inputOrganName);
            $('#inputOrganCode').val(data.inputOrganCode);
            if(data.isShowTumor) {
                $("#secondaryTrId").show();
            }

        } else
        {
            $('#cdm_report_personId').val("");
            $('#cdm_person_personId').val("");
            // $('#cdm_report_idcard').val("");
            $('#cdm_report_name').val("");
            // 根据身份证计算生日和性别
            try
            {
                var idcard= $('#cdm_report_idcard').val();
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
        $("input[name='personInfo.householdType']:checked").click();

    }

    function addDisSwitch()
    {
        // 疾病选择切换
        $("#dis-select-box input").on("click", function(event)
        {
            //var val = $('input[name="otherDiagnosisOrganFlag"]:visible:checked').val();
            var name = $(this).attr("name");
            var targetBoxId = name + "-box";
            var attachBoxId = name + "Tr";
            if ($(this).prop("checked"))
            {
                $("#" + targetBoxId).show();
                $("#" + attachBoxId).show();
               /* if(val == '2') { // 对应的附件上传是否显示
                    $("#" + attachBoxId).show();
                } else {
                    $("#" + attachBoxId).hide();
                }*/
            } else
            {
                $("#" + targetBoxId).hide();
                $("#" + attachBoxId).hide();
            }
        });

        // 人员户籍类型切换
        $("input[name='personInfo.householdType']").on("change", function()		
        {
        	$("#hrstreet").val("");
        	$("#hrcounty").val("");
        	$("#hrtownShip").val("");
        	$("#text_hrhouseNumber_prefix").text("");
            if ("1" != $(this).val())
            {

                $("#hr-address-select").find("select").attr("disabled", "disabled");
                $("#text_hrhouseNumber_prefix").hide();
                $("#hr-address-select").hide();
            } else
            {
                $("#hr-address-select").find("select").removeAttr("disabled");
                $("#hr-address-select").removeClass("hide");
                $("#hr-address-select").show();
                $("#text_hrhouseNumber_prefix").show();
            }
        });
        // 现地址变化
		$("select[name='personInfo.patownShip']").on("change streetChange", function(){
			changeHouseNumber('personInfo.patownShip',null,null,'text_pahouseNumber_prefix','pahouseNumber', null);
		});
		$("select[name='personInfo.pastreet']").on("change villageChange", function(){
			changeHouseNumber('personInfo.patownShip','personInfo.pastreet',null,'text_pahouseNumber_prefix','pahouseNumber', null);
		});
		
		$("select[name='personInfo.paGroup']").on("change groupChange", function(){
			changeHouseNumber('personInfo.patownShip','personInfo.pastreet','personInfo.paGroup','text_pahouseNumber_prefix', null, 'displayPaAddress');
		});
		//  户籍地址变化
		$("select[name='personInfo.hrtownShip']").on("change streetChange", function(){
			changeHouseNumber('personInfo.hrtownShip',null,null,'text_hrhouseNumber_prefix','hrhouseNumber', null);
		});
		$("select[name='personInfo.hrstreet']").on("change villageChange", function(){
			changeHouseNumber('personInfo.hrtownShip','personInfo.hrstreet',null,'text_hrhouseNumber_prefix','hrhouseNumber', null);
		});
		$("select[name='personInfo.hrGroup']").on("change groupChange", function(){
			changeHouseNumber('personInfo.hrtownShip','personInfo.hrstreet','personInfo.hrGroup','text_hrhouseNumber_prefix', null, 'displayHrAddress');
		});

        // 诊断依据初始化
        $("select[multiple]").each(function()
        {
            $(this).multiselect({
                header : false,
                noneSelectedText : '请选择诊断依据',
                selectedList : 13
            });
        });

        //慢病管理-报卡时：诊断依据为“病理”时，“病理类型”提示要输入，但非必填项
        var flag = true;
        $("#tumorDiagnosisDepends").change(function() {
            var tumorDiagnosisDepends = $("#tumorDiagnosisDepends").val();
            if(flag && !$.isEmpty(tumorDiagnosisDepends) && tumorDiagnosisDepends.indexOf('10') != -1) {
                flag = false;
                layer.alert("请输入'病理类型'！", {icon:0,title:'提示'});
            } else if(!$.isEmpty(tumorDiagnosisDepends) && tumorDiagnosisDepends.indexOf('10') == -1){
                flag = true;
            }
        });

        // 死亡信息切换
        $("#report-type-select-box ").on("click", ".report-type-switch", function()
        {
            if ("2" == $(this).val())
            {
                $("#death-info-box").show();
                $("#alloc-info-box").hide();
            } else
            {
                $("#death-info-box").hide();
                $("#alloc-info-box").show();
            }
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
    
    // 重新加载报卡页面
    function reload()
    {
        baseLayoutLoad.loadMenuContent(contextPath + '/cdm/reportcard/report');
    }

    // 保存报卡
    function save(event)
    {
        // 获取已经选择上报的疾病数量
        var selectedIitems = $("#dis-select-box").find("input:checked");
        if (selectedIitems.length < 1)
        {
        	layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("请至少上报一种慢病！", {icon:0,title:'提示'});
    		});
            return;
        }

        // 清除身份证输入框的提示
        var $idcard = $("#cdm_report_idcard");
        if ($idcard.val() == $idcard.attr("placeholder"))
        {
            $idcard.val("");
        }
        // 如果没有身份证,需要清理已经存在的personid
        // 重要!,否则会认认为是更新
        if (!$idcard.val())
        {
            $('#cdm_report_personId').val("");
            $('#cdm_person_personId').val("");
        }
        if(!$.isEmpty($("#pastreet option:selected").val())) {
            $("#pahouseNumber").removeAttr("reg");
            $("#pahouseNumber").removeClass("lose");
        }
        if(!$.isEmpty($("#hrstreet option:selected").val())) {
            $("#hrhouseNumber").removeAttr("reg");
            $("#hrhouseNumber").removeClass("lose");

        }
        // 验证
        validate = $("#report-input-form").easyValidate();
        var result = validate.validateForm();
        if (!result)
        {
            return;
        }

        if($('input[name="isSecondary"]:visible:checked').val() == '1' && $.isEmpty($("input[name='secondaryId']").val())){
        	layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert(" 在肿瘤中请选择继发的继发源！", {icon:0,title:'提示'});
    		});
            return;
        }
       
        // //通用js检查附件是否上传
        // if(!checkAttachment())
        //     return;
        // 保存
        $("#report-input-form").submitFormGetJson({
            url : "/cdm/reportcard/save",
            param : {},
            wait : true,
            callback : function(data)
            {
                if ("success" == data)
                {
                	layui.use('layer', function(){
            			var layer = layui.layer;
            			var index = layer.alert("上报成功！", {icon:0,title:'提示'}, function() {
            				layer.close(index);
            				reload();
            			});
            		});
                } else if ("error" == data)
                {
                	layui.use('layer', function(){
            			var layer = layui.layer;
            			
            			layer.alert("上报失败！", {icon:0,title:'提示'});
            		});
                    
                } else if(data && typeof data != "string")
                {
                    var tip = "";
                    if (undefined != data.hbpIsNotDuplicateReport && !data.hbpIsNotDuplicateReport)
                    {
                        tip += "高血压 ";
                    }
                    if (undefined != data.diIsNotDuplicateReport && !data.diIsNotDuplicateReport)
                    {
                        tip += "糖尿病 ";
                    }
                    if (undefined != data.coronaryIsNotDuplicateReport && !data.coronaryIsNotDuplicateReport)
                    {
                        tip += "冠心病 ";
                    }
                    if (undefined != data.strokeIsNotDuplicateReport && !data.strokeIsNotDuplicateReport)
                    {
                        tip += "脑卒中 ";
                    }
                    if (undefined != data.tumorIsNotDuplicateReport && !data.tumorIsNotDuplicateReport)
                    {
                        tip += "肿瘤 ";
                    }

                    tip += "已经报卡或管理!";
                    layui.use('layer', function(){
            			var layer = layui.layer;
            			
            			layer.alert(tip, {icon:0,title:'提示'});
            		});
                }else{
                	layui.use('layer', function(){
            			var layer = layui.layer;
            			
            			if(data){
            				layer.alert(data, {icon:0,title:'提示'});
            			}else{
            				layer.alert("未知错误！", {icon:0,title:'提示'});
            			}
            			
            		});

                }
            }
        });
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

    return {
        displayHrAddress: displayHrAddress,
        displayPaAddress: displayPaAddress
    };
})();
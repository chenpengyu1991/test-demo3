var addPhyExam = (function () {
    var isExamClick = false;
    var validate = null;
    $(function () {
        validate = $("#phyExamForm").easyValidate();
        validate.addExtension("symptomVali", symptomVali);
        validate.addExtension("dentitionAnomalyVali", dentitionAnomalyVali);
        validate.addExtension("missingToothVali", missingToothVali);
        validate.addExtension("decayedToothVali", decayedToothVali);
        validate.addExtension("dentureToothVali", dentureToothVali);
        validate.addExtension("breastAnomalyVali", breastAnomalyVali);
        validate.addExtension("cvascularVali", cvascularVali);
        validate.addExtension("kidneyDiseaseVali", kidneyDiseaseVali);
        validate.addExtension("heartDiseaseVali", heartDiseaseVali);
        validate.addExtension("arteryDiseaseVali", arteryDiseaseVali);
        validate.addExtension("eyeDiseasesVali", eyeDiseasesVali);
        validate.addExtension("otherTrainWayVali", otherTrainWayVali);
        validate.addExtension("FastingBloodVali", FastingBloodVali);
        validate.addExtension("healthGuidanceVali", healthGuidanceVali);
        validate.addExtension("riskFactorVali", riskFactorVali);
        validate.addExtension("EatingHabitsVali", EatingHabitsVali);
        validate.addExtension("quitDrinkingVali", quitDrinkingVali);
        validate.addExtension("wineTypesVali", wineTypesVali);
        validate.addExtension("electrocardiogramVali", electrocardiogramVali);
        validate.addExtension("fecalOccultBloodVali", fecalOccultBloodVali);
        validate.addExtension("hBsAgVali", hBsAgVali);
        validate.addExtension("CXRVali", CXRVali);
        // validate.addExtension("BUltrasonVali",BUltrasonVali);
        validate.addExtension("cervicalSmearVali", cervicalSmearVali);
        validate.addExtension("healthAbnormalVali", healthAbnormalVali);

        showst("symptomFlag", "ttb1");
        showst("symptomOther", "symptomOtherDesc");
        showst("occupationExposureFlag", "ttb2");
        showst("dustProtectionFlag", "dustProtectionDesc");
        showst("radiationProtectionFlag", "radiationProtectionDesc");
        showst("physicsProtectionFlag", "physicsProtectionDesc");
        showst("chemistryProtectionFlag", "chemistryProtectionDesc");
        showst("otherProtectionFlag", "otherProtectionDesc");
        showst("dentitionAnomalyFlag", "ttb7");
        showst("missingTooth", "ttb3");
        showst("decayedTooth", "ttb4");
        showst("dentureTooth", "ttb5");
        showst("fundusOculiAnomalyFlag", "fundusOculiAnomalyDesc");
        showst("skinCheckResult", "skinCheckDesc");
        showst("scleraCheckResult", "scleraCheckDesc");
        showst("lymphNodeCheckResult", "lymphNodeCheckDesc");
        showst("lungsAnomalySound", "lungsAnomalyDesc");
        showst("lungsRaleFlag", "lungsRaleDesc");
        showst("heartMurmurFlag", "heartMurmurDesc");
        showst("abdominalTendernessFlag", "abdominalTendernessDesc");
        showst("abdominalMassFlag", "abdominalMassDesc");
        showst("liverFlag", "liverDesc");
        showst("splenomegalyFlag", "splenomegalyDesc");
        showst("abdominalVoicedFlag", "abdominalVoicedDesc");
        showst("breastAnomalyFlag", "ttb8");
        showst("breastOther", "breastOtherDesc");
        showst("vulvaAnomalyFlag", "vulvaAnomalyDesc");
        showst("vaginaAnomalyFlag", "vaginaAnomalyDesc");
        showst("cervicalAnomalyFlag", "cervicalAnomalyDesc");
        showst("corpusAnomalyFlag", "corpusAnomalyDesc");
        showst("accessoriesAnomalyFlag", "accessoriesAnomalyDesc");
        showst("ecgAnomalyFlag", "ecgAnomalyDesc");
        showst("chestXAnomalyfFlag", "chestXAnomalyfDesc");
        /*showst("bmodeAnomalyfFlag","bmodeAnomalyfDesc");
         showst("bmodeOtherAnomalyfFlag","bmodeOtherAnomalyfDesc");*/
        showst("cervicalSmearAnomalyfFlag", "cervicalSmearAnomalyfDesc");
        showst("cvascularFlag", "ttb9");
        showst("kidneyDiseaseFlag", "ttb10");
        showst("heartDiseaseFlag", "ttb11");
        showst("arteryDiseaseFlag", "ttb12");
        showst("eyeDiseasesFlag", "ttb13");
        showst("hospitalizedHistoryFlg", "ttb20");
        showst("familyBedHistoryFlg", "ttb21");
        showst("drugHistoryFlag", "ttb22");
        showst("vaccinationInfoFlg", "ttb23");
        showst("healthEvaluateAnomalyFlg", "ttb30");
        showst("covascularOther", "cvascularOtherDesc");
        showst("kidneyOther", "kidneyOtherDesc");
        showst("heartOther", "heartOtherDesc");
        showst("arteryOther", "arteryOtherDesc");
        showst("eyeOther", "eyeOtherDesc");
        showst("nervousDiseasesFlag", "nervousDiseasesDesc");
        showst("healthOther", "healthOtherDesc");
        showst("riskWeightReduction", "riskWeightTarget");
        showst("guideVaccination", "guideVaccinationDesc");
        showst("riskOther", "riskOtherDesc");
        showst("drinkOther", "drinkOtherDesc");
        showst("nodrinkId", "quitDrinkAgeDesc");
        showst("cognitionScreenResult", "cognitionScreenScore");
        showst("emotionScreenResult", "depressionScore");

        initContentStyle("PersonalPhyExamDTO.physiqueExamination.smodeStatusCode", "smokePerDaySpan:beginSmokeAgeSpan:endSmokeAgeSpan", 1);
        initContentStyle("PersonalPhyExamDTO.physiqueExamination.trainFrequencyTypeCode", "exerciseTypeSpan:keepTimeSpan:exerciseTimeSpan", 4);
        initContentStyle("PersonalPhyExamDTO.physiqueExamination.drinkFrequency", "wineTypeSpan:isDrunkSpan:beginDrinkingAgeSpan:isEndDrinkingSpan:drinkingPerDaySpan", 1);

        checkRadio("PersonalPhyExamDTO.physiqueExamination.lipAppearanceCehckResult");
        checkRadio("PersonalPhyExamDTO.physiqueExamination.hearDetectResult");
        checkRadio("PersonalPhyExamDTO.physiqueExamination.pharynxCheckResult");
        checkRadio("PersonalPhyExamDTO.physiqueExamination.motorFuncState");
        checkRadio("PersonalPhyExamDTO.physiqueExamination.cardioverter");
        checkRadio("PersonalPhyExamDTO.physiqueExamination.legsEdemaCheckResult");
        checkRadio("PersonalPhyExamDTO.physiqueExamination.arteriopalmus", 1);//足背动脉搏动:未触及
        checkRadio("PersonalPhyExamDTO.physiqueExamination.arteriopalmus", 2);//足背动脉搏动:触及双侧对称

        toggleOther('PersonalPhyExamDTO.physiqueExamination.dreCheckResultType', 'dreCheckResultTypeSpan', 9);

        //保存后血压超标值显示红色
        var leftUp = $("input[id='leftBloodUp']").val();
        if (parseInt(leftUp) > parseInt(300)) {
            $("#leftBloodUp").css("color", "red")
        } else {
            $("#leftBloodUp").css("color", "black")
        }

        var leftBloodDown = $("input[id='leftBloodDown']").val();
        if (parseInt(leftBloodDown) > parseInt(200)) {
            $("#leftBloodDown").css("color", "red")
        } else {
            $("#leftBloodDown").css("color", "black")
        }

        var rightBloodUp = $("input[id='rightBloodUp']").val();
        if (parseInt(rightBloodUp) > parseInt(300)) {
            $("#rightBloodUp").css("color", "red")
        } else {
            $("#rightBloodUp").css("color", "black")
        }

        var rightBloodDown = $("input[id='rightBloodDown']").val();
        if (parseInt(rightBloodDown) > parseInt(200)) {
            $("#rightBloodDown").css("color", "red")
        } else {
            $("#rightBloodDown").css("color", "black")
        }

        //IE8的indexOf方法
        if (!Array.prototype.indexOf) {
            Array.prototype.indexOf = function (elt) {
                var len = this.length >>> 0;
                var from = Number(arguments[1]) || 0;
                from = (from < 0)
                    ? Math.ceil(from)
                    : Math.floor(from);
                if (from < 0)
                    from += len;
                for (; from < len; from++) {
                    if (from in this &&
                        this[from] === elt)
                        return from;
                }
                return -1;
            };
        }
        if ($("#personBMIId").val() != "" && $("#personBMIId").val() < 24) {
            $("#riskWeightReduction").attr("disabled", true);
            $("#riskWeightReduction").removeAttr("checked");
            $("#riskWeightTarget").hide();
            $("#riskWeightReduction").next().attr("disabled", true);
            $("#riskWeightReduction").next().css("color", "grey");
        } else {
            $("#riskWeightReduction").removeAttr("disabled");
            $("#riskWeightReduction").next().removeAttr("disabled");
            $("#riskWeightReduction").next().css("color", "");
            if ($("#personBMIId").val() >= 24) {
                $("#riskWeightReduction").attr("checked", true);
                $("#riskWeightTarget").show();
            }
        }

        $("input[name='PersonalPhyExamDTO.physiqueExamination.trainingWay']").on("click", function () {
            dic_other("PersonalPhyExamDTO.physiqueExamination.trainingWay", "other_train_way_span", "PersonalPhyExamDTO.physiqueExamination.otherTrainingWay");
        });
        $("input[name='PersonalPhyExamDTO.physiqueExamination.dietHunsuEquilibrium']").on("click", function () {
            if ($("input[name='PersonalPhyExamDTO.physiqueExamination.dietHunsuEquilibrium']").is(':checked') == true) {
                $("input[name='PersonalPhyExamDTO.physiqueExamination.riskDiet']").attr("disabled", true);
                $("input[name='PersonalPhyExamDTO.physiqueExamination.riskDiet']").next().attr("disabled", true);
                $("input[name='PersonalPhyExamDTO.physiqueExamination.riskDiet']").next().css("color", "grey");
            } else {
                $("input[name='PersonalPhyExamDTO.physiqueExamination.riskDiet']").removeAttr("disabled");
                $("input[name='PersonalPhyExamDTO.physiqueExamination.riskDiet']").next().removeAttr("disabled");
                $("input[name='PersonalPhyExamDTO.physiqueExamination.riskDiet']").next().css("color", "");
            }
        });

        //一体机数据页面
        $("#yitiji").click(function (e) {
            e.preventDefault();
            var idcard = $("#idCard").val();
            var name = $("#person_name").val();
            $.post(contextPath + "/cdm/standardization/followup/yshare/search",
                {
                    idcard: idcard,
                    name: name,
                    module: "tj"
                },
                function (ret) {
                    layui.use(['layer'], function () {
                        var layer = layui.layer
                        layer.open({
                            type: 1,
                            id: 'ytjDialogId',
                            area: ['970px', '400px'],
                            title: '一体机检查记录',
                            content: ret
                        });
                    });
                });
        });

        $("#health_Info").on("click", function () {
            $("#bloodPressureSource").hide();
            $("#bloodSugarSource").hide();
            var IDNumber = $("input[name='PersonalPhyExamDTO.personInfo.idcard']").val();
            var url = "http://30.1.3.252:8076/WebService/GetHealthInfoByIDNumber?License=e861d0cb-5d86-42ea-b4c7-8a68e0cb6dbf&IDNumber=" + IDNumber + "&type=BPBGBWBH";

            $.getJsonByUrl({
                url: "/personRecord/healthInfo",
                wait: true,
                param: {url: url},
                callback: function (data) {
                    if (data.error) {
                        layui.use('layer', function () {
                            var layer = layui.layer;
                            layer.alert(data.error, {icon: 0, title: '提示'});
                        });
                        return;
                    }
                    $("#personHeightId").val(data.strsg.substring(data.strsg.indexOf("身高|") + 3, data.strsg.length));
                    $("#personWeightId").val(data.strtz.substring(data.strtz.indexOf("体重|") + 3, data.strtz.length));
                    $("#bloodGlucoseLeft").val(data.strxt.substring(data.strxt.indexOf("血糖|") + 3, data.strxt.length));
                    var left = data.strxy.substring(data.strxy.indexOf("血压|") + 3, data.strxy.length).split("|");
                    $("#leftBloodUp").val(left[0]);
                    $("#leftBloodDown").val(left[1]);
                    $("input[name='PersonalPhyExamDTO.physiqueExamination.rightSbp']").val(left[0]);
                    $("input[name='PersonalPhyExamDTO.physiqueExamination.rightDbp']").val(left[1]);
                    if (left.length == 3) {
                        $("input[name='PersonalPhyExamDTO.physiqueExamination.pulseRate']").val(left[2]);
                    }


                }
            });
        });
        $("input").keypress(function (event) {
            var $inp = $("input:text");
            var key = event.which;
            if (key == 13) {
                event.preventDefault();
                var nxtIdx = $inp.index(this) + 1;
                $(":input:text:eq(" + nxtIdx + ")").focus();
            }
        });

        $("#ehrId").on("change", function () {
            loadPersonPhysicalExam('edit');
        });

        $("#cancel_phyExam").on("click", function (e) {
            e.preventDefault();
            loadPersonPhysicalExam('edit');
        });

        $("#add_phyExam").on("click", function (e) {
            e.preventDefault();
            loadPersonPhysicalExam('add');
        });

        $("#person-phyexam-pre-btn").on("click", function (e) {
            e.preventDefault();
            var personId = $("#personId").val();
            //先检查有无做过体检
            $.getJsonByUrl({
                url: "/personRecord/hasExam",
                param: {personId: personId},
                callback: function (data) {
                    if (!$.isEmpty(data)) {
                        loderPrePhyExam(data);
                    } else {
                        layer.alert("未查询到上一次体检信息！", {icon: 0, title: '提示'});
                    }
                }
            });


        });

        $("#save_phyExam").on("click", function (e) {
            e.preventDefault();
            var flag = true;
            var num = 0;

            /** if($("#idElder").val()=="true"){
			 	//中医体质非必填
				 if($("#CMedicine").is(":hidden")){
					 msgUtil.alert("中医体质辨识必须填写！");
					 return false;
				 }
				 var inputs=$("#CMedicine").find("input[type='radio']:checked");
				 var inputValue = "";
				 if(inputs.length==0){
					 msgUtil.alert("中医体质辨识必须填写！");
					 return false;
				 }
				 var prompt = "";
				 var jug = null;
				 $("#RoutineBloodTest input").each(function(){
					 var vl=$(this).val();
					 if(vl !="") {jug =1;}
				 });
				 if(jug != 1){prompt = "血常规";}
				 var urinalysis = null;
				 $("#urinalysis input").each(function(){
					 var vl=$(this).val();
					 if(vl !="") {urinalysis = 1;}
				 });
				 if(urinalysis != 1){prompt = prompt+"、尿常规";}
				 var liver = null;
				 $("#liver input").each(function(){
					 var vl=$(this).val();
					 if(vl !="") {liver = 1;}
				 });
				 if(liver != 1){prompt = prompt+"、肝功能";}
				 var kidney = null;
				 $("#kidney input").each(function(){
					 var vl=$(this).val();
					 if(vl !="") {kidney = 1;}
				 });
				 if(kidney != 1){prompt = prompt+"、肾功能";}
				 var bloodFat = null;
				 $("#bloodFat input").each(function(){
					 var vl=$(this).val();
					 if(vl !="") {bloodFat = 1;}
				 });
				 if(bloodFat != 1){prompt = prompt+"、血脂";}
				 var ECG=$("#ECG").find("input[type='radio']:checked");
				 if(ECG.length==0){prompt = prompt+"、心电图检测";}
				 /*var BUltrason=$("#BUltrason").find("input[type='radio']:checked");
				 if(BUltrason.length==0){prompt = prompt+"、B超";}
				 if(prompt != ""){
					 prompt=prompt.substring(1,prompt.length)
					 msgUtil.alert(prompt+"未填写！");
				 }
			 }**/


            $("input[name='PersonalPhyExamDTO.physiqueExamination.hemoglobinValue']")
                .parent().parent().parent().parent().find("input[type='text']").not(':hidden').each(function () {
                if ($(this).val() == "") {
                    flag = false;
                }

            });
            if ($('input:radio[name="PersonalPhyExamDTO.physiqueExamination.ecgAnomalyFlag"]:checked').val() == undefined) {
                flag = false;

            }
            if ($('input:radio[name="PersonalPhyExamDTO.physiqueExamination.fecalOccultBlood"]:checked').val() == undefined) {
                flag = false;

            }
            if ($('input:radio[name="PersonalPhyExamDTO.physiqueExamination.hbsagDetectResult"]:checked').val() == undefined) {
                flag = false;
            }
            if ($('input:radio[name="PersonalPhyExamDTO.physiqueExamination.chestXAnomalyfFlag"]:checked').val() == undefined) {
                flag = false;
            }
            /* 去除提示
			 if($("#idElder").val()!="true") {
				 if (flag == false) {
					 msgUtil.alert("待检验检查完成，请填入相关体检项目！");
				 }
			 }*/
            save();
            isExamClick = true;
        });
        $("#bloodGlucoseLeft").on("blur", function () {
            if ($("#bloodGlucoseLeft").val() != "" || $("#bloodGlucoseRight").val() != "") {
                $("#bloodSugarSource").show();
            } else {
                $("#bloodSugarSource").hide();
            }
        });
        $("#bloodGlucoseRight").on("blur", function () {
            if ($("#bloodGlucoseLeft").val() != "" || $("#bloodGlucoseRight").val() != "") {
                $("#bloodSugarSource").show();
            } else {
                $("#bloodSugarSource").hide();
            }
        });
        $("input[name='PersonalPhyExamDTO.physiqueExamination.leftDbp']").on("blur", function () {
            if ($("#leftBloodUp").val() != "" || $("#leftBloodDown").val() != "" || $("#rightBloodUp").val() != "" || $("#rightBloodDown").val() != "") {
                $("#bloodPressureSource").show();
            } else {
                $("#bloodPressureSource").hide();
            }
        });
        $("input[name='PersonalPhyExamDTO.physiqueExamination.rightDbp']").on("blur", function () {
            if ($("#leftBloodUp").val() != "" || $("#leftBloodDown").val() != "" || $("#rightBloodUp").val() != "" || $("#rightBloodDown").val() != "") {
                $("#bloodPressureSource").show();
            } else {
                $("#bloodPressureSource").hide();
            }
        });
        $("input[name='PersonalPhyExamDTO.physiqueExamination.leftSbp']").on("blur", function () {
            if ($("#leftBloodUp").val() != "" || $("#leftBloodDown").val() != "" || $("#rightBloodUp").val() != "" || $("#rightBloodDown").val() != "") {
                $("#bloodPressureSource").show();
            } else {
                $("#bloodPressureSource").hide();
            }
        });
        $("input[name='PersonalPhyExamDTO.physiqueExamination.rightSbp']").on("blur", function () {
            if ($("#leftBloodUp").val() != "" || $("#leftBloodDown").val() != "" || $("#rightBloodUp").val() != "" || $("#rightBloodDown").val() != "") {
                $("#bloodPressureSource").show();
            } else {
                $("#bloodPressureSource").hide();
            }
        });
        var trainingWayCode = $("#text_trainingWay").val();
        if (trainingWayCode.indexOf("14") != -1) {
            $("#other_train_way_span").css("display", "inline");
        } else {
            $("#other_train_way_span").css("display", "none");
        }
//         $("#addEch").on("click" ,function(){
//        	 checkEchStatus();
//         });
//
//         $("#addEchOldPeople").on("click" ,function(){
//        	 checkEchOldPeopleStatus();
//         });

        $("#addDepressed").on("click", function (e) {
            e.preventDefault();
//        	 checkDepressedStatus();
            var personId = $("input[name='PersonalPhyExamDTO.personInfo.id']").val();
            addDepressed(personId);
        });

        $("#addOldDepressed").on("click", function (e) {
            e.preventDefault();
//        	 checkOldDepressedStatus();
            var personId = $("#personId").val();
            var physicalExamCode = $("[name='physicalExamCode']").val();
            addOldDepressed(personId, physicalExamCode);
        });

        //健康评价-血压异常
        $("#leftBloodDown").blur(function () {
            countBoold();
        });
        $("#leftBloodUp").blur(function () {
            countBoold();
        });
        $("#rightBloodDown").blur(function () {
            countBoold();
        });
        $("#rightBloodUp").blur(function () {
            countBoold();
        });
        //空腹血糖是否异常
        $("#bloodGlucoseLeft").blur(function () {
            bloodGlucoseLeft();
        });
        $("#bloodGlucoseRight").blur(function () {
            bloodGlucoseLeft();
        });


        //查体-眼底
        $("input[id='fundusOculiAnomalyFlag']").click(function () {
            var first = $("#healthAbnormal3").val();
            if (first != "") {
                if (first.indexOf("眼底异常;") >= 0) {
                    $("#healthAbnormal3").val(first);
                } else {
                    $("#healthAbnormal3").val(first + "眼底异常;");
                }
            } else {
                $("input[id='healthEvaluateAnomalyFlgN']").removeAttr("checked");
                $("input[id='healthEvaluateAnomalyFlg']").attr("checked", "checked");
                $("input[id='healthEvaluateAnomalyFlg']").click();
                $("#healthAbnormal3").val(first + "眼底异常;");
            }
        });
        $("input[id='fundusOculiAnomalyFlagWJ']").click(function () {
            eye();
        });
        $("input[id='fundusOculiAnomalyFlagZC']").click(function () {
            eye();
        });
        //查体项-皮肤
        $("input[id='skinCH']").click(function () {
            skinAbnormal();
        });
        $("input[id='skinCB']").click(function () {
            skinAbnormal();
        });
        $("input[id='skinFQ']").click(function () {
            skinAbnormal();
        });
        $("input[id='skinHR']").click(function () {
            skinAbnormal();
        });
        $("input[id='skinSS']").click(function () {
            skinAbnormal();
        });
        $("input[id='skinCheckResult']").click(function () {
            skinAbnormal();
        });
        $("input[id='skinZC']").click(function () {
            skinAbnormalZC();
        });
        //查体—巩膜
        $("input[id='scleraHR']").click(function () {
            sclera();
        });
        $("input[id='scleraBlood']").click(function () {
            sclera();
        });
        $("input[id='scleraCheckResult']").click(function () {
            sclera();
        });
        $("input[id='scleraZC']").click(function () {
            scleraZC();
        });
        //查体-淋巴结
        $("input[id='lymphNodeCheckResult']").click(function () {
            lymphNode();
        });
        $("input[id='lymphNodeWY']").click(function () {
            lymphNode();
        });
        $("input[id='lymphNodeSG']").click(function () {
            lymphNode();
        });
        $("input[id='lymphNodeZC']").click(function () {
            lymphNodeZC();
        });
        //查体-肺-桶状胸异常
        $("input[id='barrelChest']").click(function () {
            lung();
        });
        $("input[id='barrelChestZC']").click(function () {
            lungZC();
        });
        //查体-肺-呼吸音
        $("input[id='lungsAnomalySound']").click(function () {
            lung();
        });
        $("input[id='lungsAnomalySoundZC']").click(function () {
            lungZC();
        });
        //查体-肺-罗音
        $("input[id='lungsRaleFlag']").click(function () {
            lung();
        });
        $("input[id='lungsRaleFlagS']").click(function () {
            lung();
        });
        $("input[id='lungsRaleFlagG']").click(function () {
            lung();
        });
        $("input[id='lungsRaleZC']").click(function () {
            lungZC();
        });
        //查体-心脏
        $("input[id='cardioverter']").eq(1).click(function () {
            heart();
        });
        $("input[id='cardioverter']").eq(2).click(function () {
            heart();
        });
        $("input[id='cardioverter']").eq(0).click(function () {
            heartZC();
        });
        $("input[id='heartMurmurFlag']").click(function () {
            heart();
        });
        $("input[id='heartMurmurFlagZC']").click(function () {
            heartZC();
        });
        //查体-腹部-压痛
        $("input[id='abdominalTendernessFlag']").click(function () {
            Abdomen();
        });
        $("input[id='abdominalTendernessFlagZC']").click(function () {
            AbdomenZC();
        });
        //腹部-包块
        $("input[id='abdominalMassFlag']").click(function () {
            Abdomen();
        });
        $("input[id='abdominalMassFlagZC']").click(function () {
            AbdomenZC();
        });
        //腹部-肝大
        $("input[id='liverFlag']").click(function () {
            Abdomen();
        });
        $("input[id='liverFlagZC']").click(function () {
            AbdomenZC();
        });
        //腹部-脾大
        $("input[id='splenomegalyFlag']").click(function () {
            Abdomen();
        });
        $("input[id='splenomegalyFlagZC']").click(function () {
            AbdomenZC();
        });
        //移动性浊音
        $("input[id='abdominalVoicedFlag']").click(function () {
            Abdomen();
        });
        $("input[id='abdominalVoicedFlagZC']").click(function () {
            AbdomenZC();
        });
        //查体-下肢水肿
        $("input[id='legsEdema']").eq(1).click(function () {
            legsEdema();
        });
        $("input[id='legsEdema']").eq(2).click(function () {
            legsEdema();
        });
        $("input[id='legsEdema']").eq(3).click(function () {
            legsEdema();
        });
        $("input[id='legsEdema']").eq(0).click(function () {
            legsEdemaZC();
        });
        //查体-足背动脉搏动
        $("input[id='arteriopalmus']").eq(1).click(function () {
            arteriopalmusZC();
        });
        $("input[id='arteriopalmus']").eq(2).click(function () {
            arteriopalmus();
        });
        $("input[id='arteriopalmus']").eq(3).click(function () {
            arteriopalmus();
        });
        $("input[id='arteriopalmus']").eq(0).click(function () {
            arteriopalmus();
        });
        //查体-肛门指诊
        $("input[id='dre']").eq(0).click(function () {
            dreZC();
        });
        $("input[id='dre']").eq(2).click(function () {
            dre();
        });
        $("input[id='dre']").eq(3).click(function () {
            dre();
        });
        $("input[id='dre']").eq(4).click(function () {
            dre();
        });
        $("input[id='dre']").eq(1).click(function () {
            dre();
        });
        $("input[id='dreWJ']").click(function () {
            dreZC();
        });
        //查体-乳腺
        $("input[id='breastAnomalyFlag']").click(function () {
            breastAnomaly();
        });
        $("input[id='breastAnomaly']").click(function () {
            breastAnomalyZC();
        });
        $("input[id='breastAnomalyZC']").click(function () {
            breastAnomalyZC();
        });
        //查体-妇科-外阴
        $("input[id='vulvaAnomalyFlag']").click(function () {
            Gynaecology();
        });
        $("input[id='vulvaAnomaly']").click(function () {
            GynaecologyZC();
        });
        $("input[id='vulvaAnomalyZC']").click(function () {
            GynaecologyZC();
        });
        //查体-妇科-阴道
        $("input[id='vaginaAnomalyFlag']").click(function () {
            Gynaecology();
        });
        $("input[id='vaginaAnomaly']").click(function () {
            GynaecologyZC();
        });
        $("input[id='vaginaAnomalyZC']").click(function () {
            GynaecologyZC();
        });
        //查体-妇科-宫颈
        $("input[id='cervicalAnomalyFlag']").click(function () {
            Gynaecology();
        });
        $("input[id='cervicalAnomaly']").click(function () {
            GynaecologyZC();
        });
        $("input[id='cervicalAnomalyZC']").click(function () {
            GynaecologyZC();
        });
        //查体-妇科-宫体
        $("input[id='corpusAnomalyFlag']").click(function () {
            Gynaecology();
        });
        $("input[id='corpusAnomaly']").click(function () {
            GynaecologyZC();
        });
        $("input[id='corpusAnomalyZC']").click(function () {
            GynaecologyZC();
        });
        //查体-妇科-附件
        $("input[id='accessoriesAnomaly']").click(function () {
            GynaecologyZC();
        });
        $("input[id='accessoriesAnomalyZC']").click(function () {
            GynaecologyZC();
        });
        $("input[id='accessoriesAnomalyFlag']").click(function () {
            Gynaecology()
        });
        //判断是否勾选另外13项异常，若勾选显示下面的input框
        changeCheck();
        if ($("#loadPrePhyExamClick").val()) {//如果点击过上一次体检信息按钮 按钮置灰
            $("#person-phyexam-pre-btn").attr("disabled", true);
            $("#person-phyexam-pre-btn").addClass('layui-btn-disabled');
        }

        $("#button_print").click(function (e) {
            e.preventDefault();

            var val1 = $('input:radio[name="PersonalPhyExamDTO.physiqueExamination.symptomFlag"]:checked').val();
            if (val1 == "1") {
                $("#ttb1").show();
            } else {
                $("#ttb1").hide();
            }

            var val2 = $('input:radio[name="PersonalPhyExamDTO.physiqueExamination.occupationExposureFlag"]:checked').val();
            if (val2 == "1") {
                $("#ttb2").show();
            } else {
                $("#ttb2").hide();
            }

            var val3 = $('input:radio[name="PersonalPhyExamDTO.hospitalizedHistoryFlg"]:checked').val();
            if (val3 == "1") {
                $("#ttb20").show();
            } else {
                /*$("#ttb20").each(function () {
                    $(this).hide();
                });*/
                $("[class*=hospitalized_history]").each(function () {
                    $(this).hide();
                })
            }

            var val4 = $('input:radio[name="PersonalPhyExamDTO.familyBedHistoryFlg"]:checked').val();
            if (val4 == "1") {
                $("#ttb21").show();
            } else {
                /*$("#ttb21").hide();*/
                $("[class*=bed_history]").each(function () {
                    $(this).hide();
                })
            }

            var val5 = $('input:radio[name="PersonalPhyExamDTO.drugHistoryFlag"]:checked').val();
            if (val5 == "1") {
                $("#ttb22").show();
            } else {
                $("#ttb22").hide();
            }

            var val6 = $('input:radio[name="PersonalPhyExamDTO.vaccinationInfoFlg"]:checked').val();
            if (val6 == "1") {
                $("#ttb23").show();
            } else {
                // $("#ttb23").hide();
                $("[class*=vaccination_info]").each(function () {
                    $(this).hide();
                })
            }

            var val7 = $('input:radio[name="PersonalPhyExamDTO.healthEvaluateAnomalyFlg"]:checked').val();
            if (val7 == "1") {
                $("#ttb30").show();
            } else {
                $("#ttb30").hide();
            }

            var reportClass = $("#printDiv").attr("class");
            $("#printDiv").removeClass();
            $("#printDiv").jqprint(
                {
                    debug: false, //如果是true则可以显示iframe查看效果（iframe默认高和宽都很小，可以再源码中调大），默认是false
                    importCSS: true, //true表示引进原来的页面的css，默认是true。（如果是true，先会找$("link[media=print]")，若没有会去找$("link")中的css文件）
                    printContainer: true, //表示如果原来选择的对象必须被纳入打印（注意：设置为false可能会打破你的CSS规则）。
                    operaSupport: true//表示如果插件也必须支持歌opera浏览器，在这种情况下，它提供了建立一个临时的打印选项卡。默认是true
                });
            $("#printDiv").addClass(reportClass);
        });
    });

    function changeCheck() {

        $('input:checkbox[name="PersonalPhyExamDTO.physiqueExamination.healthEvaluateCheck"]').each(function () {
            var delId = 'tjycDesc' + $(this).val();
            var delSpanId = 'tjycDescSpan' + $(this).val();
            if ($(this).attr("checked")) {
                if ($("#" + delId).length == 0) {
                    var html = '<span  style="display: inline-block;width: 100%;" id="' + delSpanId + '">异常 ';
                    html += '<input type="text" reg=\'{"dependOn":"healthEvaluateAnomalyFlg","extension":["healthAbnormalVali","请至少填写一项"],"maxlength":"100"}\' style="width: 80%;" value="' + $(this).parent().text() + '"' + 'id="tjycDesc' + $(this).val() + '"></span>';
                    $("#tjyc").append(html);
                }
            } else {
                if ($("#" + delId).length > 0) {
                    // $("#"+delId).remove() ;
                    $("#" + delSpanId).remove();
                }
            }

        });
    }

    function loadPersonPhysicalExam(operateType) {
        var ehrId = $("#ehrId").val();
        $.loadHtmlByUrl({
            url: contextPath + "/personRecord/addPersonPhyExam",
            insertDiv: "basic_physical_examination",
            param: {
                ehrId: ehrId,
                operateType: operateType
            }
        });
    }

    function loderPrePhyExam(ehrId) {
        var index = layer.confirm("确定要覆盖页面上所有数据吗？", {icon: 1, title: '确认提示'}, function () {
            $("#basic_physical_examination").empty();
            var loadHtmlByUrlOption = {
                url: contextPath + "/personRecord/addPersonPhyExam",
                insertDiv: "basic_physical_examination",
                param: {ehrId: ehrId, operateType: 'loadPrePhyexam', loadPrePhyexamFlag: "load"}
            };
            $.loadHtmlByUrl(loadHtmlByUrlOption);
            layer.close(index);
        });

    }

    //判断是否空腹血糖
    function bloodGlucoseLeft() {
        var reg = /血糖异常(.*?)([\;,])/;
        debugger;
        var left = $("input[id='bloodGlucoseLeft']").val();
        var right = $("input[id='bloodGlucoseRight']").val();
        var first = $("#healthAbnormal1").val();
        if (parseInt(left) >= parseInt(7) || parseInt(right) >= parseInt(140)) {
            var excepVal = "";
            if (parseInt(left) >= parseInt(7))
                excepVal += left + "mmol/L";
            if (parseInt(right) >= parseInt(140))
                excepVal += right + "mmol/L";
            $("input[id='healthEvaluateAnomalyFlgN']").removeAttr("checked");
            $("input[id='healthEvaluateAnomalyFlg']").attr("checked", "checked");
            $("input[id='healthEvaluateAnomalyFlg']").click();
            if (first.indexOf("血糖异常") >= 0) {
                first = first.replace(reg, "");
            }
            $("#healthAbnormal1").val(first + "血糖异常(" + excepVal + ");");
        } else {
            if (first.indexOf("血糖异常") >= 0) {
                first = first.replace(reg, "");
                $("#healthAbnormal1").val(first);
                var first1 = $("#healthAbnormal2").val();
                var first2 = $("#healthAbnormal3").val();
                var first3 = $("#healthAbnormal4").val();
                if (first == "" && first1 == "" && first2 == "" && first3 == "") {
                    $("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
                    $("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
                    $("input[id='healthEvaluateAnomalyFlgN']").click();
                }

            }
        }
    }


    //健康评价-血压异常
    function countBoold() {
        var leftUp = $("input[id='leftBloodUp']").val();
        var leftDown = $("input[id='leftBloodDown']").val();
        var rightUp = $("input[id='rightBloodUp']").val();
        var rightDown = $("input[id='rightBloodDown']").val();
        var first = $("#healthAbnormal1").val();
        debugger;
        var reg = /血压异常(.*?)([\;,])/;
        if (parseInt(leftUp) > parseInt(140) || parseInt(leftUp) < parseInt(90) || parseInt(leftDown) > parseInt(90) || parseInt(leftDown) < parseInt(60)
            || parseInt(rightUp) > parseInt(140) || parseInt(rightUp) < parseInt(90) || parseInt(rightDown) > parseInt(90) || parseInt(rightDown) < parseInt(60)) {
            var excepVal = "";
            if (parseInt(leftUp) > parseInt(140) || parseInt(leftUp) < parseInt(90) || parseInt(leftDown) > parseInt(90) || parseInt(leftDown) < parseInt(60))
                excepVal += "左侧:" + leftUp + "/" + leftDown + "mmHg";
            if (parseInt(rightUp) > parseInt(140) || parseInt(rightUp) < parseInt(90) || parseInt(rightDown) > parseInt(90) || parseInt(rightDown) < parseInt(60))
                excepVal += "右侧:" + rightUp + "/" + rightDown + "mmHg";
            $("input[id='healthEvaluateAnomalyFlgN']").removeAttr("checked");
            $("input[id='healthEvaluateAnomalyFlg']").attr("checked", "checked");
            $("input[id='healthEvaluateAnomalyFlg']").click();
            if (first.indexOf("血压异常") >= 0) {
                first = first.replace(reg, "");
            }
            $("#healthAbnormal1").val(first + "血压异常(" + excepVal + ");");
        } else {
            if (first.indexOf("血压异常") >= 0) {
                first = first.replace(reg, "");
                $("#healthAbnormal1").val(first);
                var first1 = $("#healthAbnormal2").val();
                var first2 = $("#healthAbnormal3").val();
                var first3 = $("#healthAbnormal4").val();
                if (first == "" && first1 == "" && first2 == "" && first3 == "") {
                    $("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
                    $("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
                    $("input[id='healthEvaluateAnomalyFlgN']").click();
                }

            }
        }
    }

    //健康评价-眼底
    function eye() {
        var first = $("#healthAbnormal3").val();
        if (first != "") {
            if (first.indexOf("眼底异常;") >= 0) {
                first = first.replace("眼底异常;", "");
                $("#healthAbnormal3").val(first);
                var first1 = $("#healthAbnormal2").val();
                var first2 = $("#healthAbnormal3").val();
                var first3 = $("#healthAbnormal4").val();
                if (first == "" && first1 == "" && first2 == "" && first3 == "") {
                    $("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
                    $("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
                    $("input[id='healthEvaluateAnomalyFlgN']").click();
                }
            }
        } else {
            var first1 = $("#healthAbnormal2").val();
            var first2 = $("#healthAbnormal3").val();
            var first3 = $("#healthAbnormal4").val();
            if (first1 == "" && first2 == "" && first3 == "") {
                $("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
                $("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
                $("input[id='healthEvaluateAnomalyFlgN']").click();
            }
        }
    }

    //查体-皮肤异常
    function skinAbnormal() {
        var first = $("#healthAbnormal3").val();
        if (first != "") {
            if (first.indexOf("皮肤异常;") >= 0) {
                $("#healthAbnormal3").val(first);
            } else {
                $("#healthAbnormal3").val(first + "皮肤异常;");
            }
        } else {
            $("input[id='healthEvaluateAnomalyFlgN']").removeAttr("checked");
            $("input[id='healthEvaluateAnomalyFlg']").attr("checked", "checked");
            $("input[id='healthEvaluateAnomalyFlg']").click();
            $("#healthAbnormal3").val(first + "皮肤异常;");
        }
    }

    function skinAbnormalZC() {
        var first = $("#healthAbnormal3").val();
        if (first != "") {
            if (first.indexOf("皮肤异常;") >= 0) {
                first = first.replace("皮肤异常;", "");
                $("#healthAbnormal3").val(first);
                var first1 = $("#healthAbnormal2").val();
                var first2 = $("#healthAbnormal3").val();
                var first3 = $("#healthAbnormal4").val();
                if (first == "" && first1 == "" && first2 == "" && first3 == "") {
                    $("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
                    $("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
                    $("input[id='healthEvaluateAnomalyFlgN']").click();
                }
            }
        } else {
            var first1 = $("#healthAbnormal2").val();
            var first2 = $("#healthAbnormal3").val();
            var first3 = $("#healthAbnormal4").val();
            if (first1 == "" && first2 == "" && first3 == "") {
                $("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
                $("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
                $("input[id='healthEvaluateAnomalyFlgN']").click();
            }
        }
    }

    //查体-巩膜异常
    function sclera() {
        var first = $("#healthAbnormal3").val();
        if (first != "") {
            if (first.indexOf("巩膜异常;") >= 0) {
                $("#healthAbnormal3").val(first);
            } else {
                $("#healthAbnormal3").val(first + "巩膜异常;");
            }
        } else {
            $("input[id='healthEvaluateAnomalyFlgN']").removeAttr("checked");
            $("input[id='healthEvaluateAnomalyFlg']").attr("checked", "checked");
            $("input[id='healthEvaluateAnomalyFlg']").click();
            $("#healthAbnormal3").val(first + "巩膜异常;");
        }
    }

    //查体-巩膜正常
    function scleraZC() {
        var first = $("#healthAbnormal3").val();
        if (first != "") {
            if (first.indexOf("巩膜异常;") >= 0) {
                first = first.replace("巩膜异常;", "");
                $("#healthAbnormal3").val(first);
                var first1 = $("#healthAbnormal2").val();
                var first2 = $("#healthAbnormal3").val();
                var first3 = $("#healthAbnormal4").val();
                if (first == "" && first1 == "" && first2 == "" && first3 == "") {
                    $("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
                    $("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
                    $("input[id='healthEvaluateAnomalyFlgN']").click();
                }
            }
        } else {
            var first1 = $("#healthAbnormal2").val();
            var first2 = $("#healthAbnormal3").val();
            var first3 = $("#healthAbnormal4").val();
            if (first1 == "" && first2 == "" && first3 == "") {
                $("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
                $("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
                $("input[id='healthEvaluateAnomalyFlgN']").click();
            }
        }
    }

    //查体-淋巴结异常
    function lymphNode() {
        var first = $("#healthAbnormal3").val();
        if (first != "") {
            if (first.indexOf("淋巴结异常;") >= 0) {
                $("#healthAbnormal3").val(first);
            } else {
                $("#healthAbnormal3").val(first + "淋巴结异常;");
            }
        } else {
            $("input[id='healthEvaluateAnomalyFlgN']").removeAttr("checked");
            $("input[id='healthEvaluateAnomalyFlg']").attr("checked", "checked");
            $("input[id='healthEvaluateAnomalyFlg']").click();
            $("#healthAbnormal3").val(first + "淋巴结异常;");
        }
    }

    //查体-淋巴结正常
    function lymphNodeZC() {
        var first = $("#healthAbnormal3").val();
        if (first != "") {
            if (first.indexOf("淋巴结异常;") >= 0) {
                first = first.replace("淋巴结异常;", "");
                $("#healthAbnormal3").val(first);
                var first1 = $("#healthAbnormal1").val();
                var first2 = $("#healthAbnormal3").val();
                var first3 = $("#healthAbnormal4").val();
                if (first == "" && first1 == "" && first2 == "" && first3 == "") {
                    $("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
                    $("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
                    $("input[id='healthEvaluateAnomalyFlgN']").click();
                }
            }
        } else {
            var first1 = $("#healthAbnormal1").val();
            var first2 = $("#healthAbnormal3").val();
            var first3 = $("#healthAbnormal4").val();
            if (first1 == "" && first2 == "" && first3 == "") {
                $("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
                $("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
                $("input[id='healthEvaluateAnomalyFlgN']").click();
            }
        }
    }

    //查体-肺-桶状胸异常
    function lung() {
        var first = $("#healthAbnormal3").val();
        if (first != "") {
            if (first.indexOf("肺异常;") >= 0) {
                $("#healthAbnormal3").val(first);
            } else {
                $("#healthAbnormal3").val(first + "肺异常;");
            }
        } else {
            $("input[id='healthEvaluateAnomalyFlgN']").removeAttr("checked");
            $("input[id='healthEvaluateAnomalyFlg']").attr("checked", "checked");
            $("input[id='healthEvaluateAnomalyFlg']").click();
            $("#healthAbnormal3").val(first + "肺异常;");
        }
    }

    function lungZC() {
        var first = $("#healthAbnormal3").val();
        if (first != "") {
            if (first.indexOf("肺异常;") >= 0) {
                var barrel = $("input[id='barrelChestZC']")[0].checked;
                var lungsAnomaly = $("input[id='lungsAnomalySoundZC']")[0].checked;
                var lungsRale = $("input[id='lungsRaleZC']")[0].checked;
                if (barrel && lungsAnomaly && lungsRale) {
                    first = first.replace("肺异常;", "");
                }
                $("#healthAbnormal3").val(first);
                var first1 = $("#healthAbnormal1").val();
                var first2 = $("#healthAbnormal3").val();
                var first3 = $("#healthAbnormal4").val();
                if (first == "" && first1 == "" && first2 == "" && first3 == "") {
                    $("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
                    $("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
                    $("input[id='healthEvaluateAnomalyFlgN']").click();
                }
            }
        } else {
            var first1 = $("#healthAbnormal2").val();
            var first2 = $("#healthAbnormal3").val();
            var first3 = $("#healthAbnormal4").val();
            if (first1 == "" && first2 == "" && first3 == "") {
                $("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
                $("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
                $("input[id='healthEvaluateAnomalyFlgN']").click();
            }
        }
    }

    //心脏异常
    function heart() {
        var first = $("#healthAbnormal3").val();
        if (first != "") {
            if (first.indexOf("心脏异常;") >= 0) {
                $("#healthAbnormal3").val(first);
            } else {
                $("#healthAbnormal3").val(first + "心脏异常;");
            }
        } else {
            $("input[id='healthEvaluateAnomalyFlgN']").removeAttr("checked");
            $("input[id='healthEvaluateAnomalyFlg']").attr("checked", "checked");
            $("input[id='healthEvaluateAnomalyFlg']").click();
            $("#healthAbnormal3").val(first + "心脏异常;");
        }
    }

    //心脏正常
    function heartZC() {
        var first = $("#healthAbnormal3").val();
        if (first != "") {
            if (first.indexOf("心脏异常;") >= 0) {
                var cardioverter = $("input[id='cardioverter']")[0].checked;
                var heart = $("input[id='heartMurmurFlagZC']")[0].checked;
                if (cardioverter && heart) {
                    first = first.replace("心脏异常;", "");
                }
                $("#healthAbnormal3").val(first);
                var first1 = $("#healthAbnormal1").val();
                var first2 = $("#healthAbnormal3").val();
                var first3 = $("#healthAbnormal4").val();
                if (first == "" && first1 == "" && first2 == "" && first3 == "") {
                    $("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
                    $("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
                    $("input[id='healthEvaluateAnomalyFlgN']").click();
                }
            }
        } else {
            var first1 = $("#healthAbnormal1").val();
            var first2 = $("#healthAbnormal3").val();
            var first3 = $("#healthAbnormal4").val();
            if (first == "" && first1 == "" && first2 == "" && first3 == "") {
                $("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
                $("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
                $("input[id='healthEvaluateAnomalyFlgN']").click();
            }
        }
    }

    //腹部异常
    function Abdomen() {
        var first = $("#healthAbnormal3").val();
        if (first != "") {
            if (first.indexOf("腹部异常;") >= 0) {
                $("#healthAbnormal3").val(first);
            } else {
                $("#healthAbnormal3").val(first + "腹部异常;");
            }
        } else {
            $("input[id='healthEvaluateAnomalyFlgN']").removeAttr("checked");
            $("input[id='healthEvaluateAnomalyFlg']").attr("checked", "checked");
            $("input[id='healthEvaluateAnomalyFlg']").click();
            $("#healthAbnormal3").val(first + "腹部异常;");
        }
    }

    //腹部正常
    function AbdomenZC() {
        var first = $("#healthAbnormal3").val();
        if (first != "") {
            if (first.indexOf("腹部异常;") >= 0) {
                var abdominalVoiced = $("input[id='abdominalTendernessFlagZC']")[0].checked;
                var splenomegaly = $("input[id='abdominalMassFlagZC']")[0].checked;
                var liver = $("input[id='splenomegalyFlagZC']")[0].checked;
                var abdominalMass = $("input[id='liverFlagZC']")[0].checked;
                var abdominalTenderness = $("input[id='abdominalVoicedFlagZC']")[0].checked;
                if (abdominalVoiced && splenomegaly && liver && abdominalMass && abdominalTenderness) {
                    first = first.replace("腹部异常;", "");
                }
                $("#healthAbnormal3").val(first);
                var first1 = $("#healthAbnormal2").val();
                var first2 = $("#healthAbnormal1").val();
                var first3 = $("#healthAbnormal4").val();
                if (first == "" && first1 == "" && first2 == "" && first3 == "") {
                    $("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
                    $("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
                    $("input[id='healthEvaluateAnomalyFlgN']").click();
                }
            }
        } else {
            var first1 = $("#healthAbnormal2").val();
            var first2 = $("#healthAbnormal1").val();
            var first3 = $("#healthAbnormal4").val();
            if (first == "" && first1 == "" && first2 == "" && first3 == "") {
                $("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
                $("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
                $("input[id='healthEvaluateAnomalyFlgN']").click();
            }
        }
    }

    //下肢水肿异常
    function legsEdema() {
        var first = $("#healthAbnormal3").val();
        if (first != "") {
            if (first.indexOf("下肢水肿异常;") >= 0) {
                $("#healthAbnormal3").val(first);
            } else {
                $("#healthAbnormal3").val(first + "下肢水肿异常;");
            }
        } else {
            $("input[id='healthEvaluateAnomalyFlgN']").removeAttr("checked");
            $("input[id='healthEvaluateAnomalyFlg']").attr("checked", "checked");
            $("input[id='healthEvaluateAnomalyFlg']").click();
            $("#healthAbnormal3").val(first + "下肢水肿异常;");
        }
    }

    //下肢水肿正常
    function legsEdemaZC() {
        var first = $("#healthAbnormal3").val();
        if (first != "") {
            if (first.indexOf("下肢水肿异常;") >= 0) {
                first = first.replace("下肢水肿异常;", "");
                $("#healthAbnormal3").val(first);
                var first1 = $("#healthAbnormal2").val();
                var first2 = $("#healthAbnormal1").val();
                var first3 = $("#healthAbnormal4").val();
                if (first == "" && first1 == "" && first2 == "" && first3 == "") {
                    $("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
                    $("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
                    $("input[id='healthEvaluateAnomalyFlgN']").click();
                }
            }
        } else {
            var first1 = $("#healthAbnormal2").val();
            var first2 = $("#healthAbnormal1").val();
            var first3 = $("#healthAbnormal4").val();
            if (first == "" && first1 == "" && first2 == "" && first3 == "") {
                $("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
                $("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
                $("input[id='healthEvaluateAnomalyFlgN']").click();
            }
        }
    }

    //查体-足背动脉搏动异常
    function arteriopalmus() {
        var first = $("#healthAbnormal3").val();
        if (first != "") {
            if (first.indexOf("足背动脉搏动异常;") >= 0) {
                $("#healthAbnormal3").val(first);
            } else {
                $("#healthAbnormal3").val(first + "足背动脉搏动异常;");
            }
        } else {
            $("input[id='healthEvaluateAnomalyFlgN']").removeAttr("checked");
            $("input[id='healthEvaluateAnomalyFlg']").attr("checked", "checked");
            $("input[id='healthEvaluateAnomalyFlg']").click();
            $("#healthAbnormal3").val(first + "足背动脉搏动异常;");
        }
    }

    //查体-足背动脉搏动正常
    function arteriopalmusZC() {
        var first = $("#healthAbnormal3").val();
        if (first != "") {
            if (first.indexOf("足背动脉搏动异常;") >= 0) {
                first = first.replace("足背动脉搏动异常;", "");
                $("#healthAbnormal3").val(first);
                var first1 = $("#healthAbnormal2").val();
                var first2 = $("#healthAbnormal1").val();
                var first3 = $("#healthAbnormal4").val();
                if (first == "" && first1 == "" && first2 == "" && first3 == "") {
                    $("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
                    $("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
                    $("input[id='healthEvaluateAnomalyFlgN']").click();
                }
            }
        } else {
            var first1 = $("#healthAbnormal2").val();
            var first2 = $("#healthAbnormal1").val();
            var first3 = $("#healthAbnormal4").val();
            if (first1 == "" && first2 == "" && first3 == "") {
                $("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
                $("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
                $("input[id='healthEvaluateAnomalyFlgN']").click();
            }
        }
    }

    //查体-肛门指诊异常
    function dre() {
        var first = $("#healthAbnormal3").val();
        if (first != "") {
            if (first.indexOf("肛门指诊异常;") >= 0) {
                $("#healthAbnormal3").val(first);
            } else {
                $("#healthAbnormal3").val(first + "肛门指诊异常;");
            }
        } else {
            $("input[id='healthEvaluateAnomalyFlgN']").removeAttr("checked");
            $("input[id='healthEvaluateAnomalyFlg']").attr("checked", "checked");
            $("input[id='healthEvaluateAnomalyFlg']").click();
            $("#healthAbnormal3").val(first + "肛门指诊异常;");
        }
    }

    //查体-肛门指诊正常
    function dreZC() {
        var first = $("#healthAbnormal3").val();
        if (first != "") {
            if (first.indexOf("肛门指诊异常;") >= 0) {
                first = first.replace("肛门指诊异常;", "");
                $("#healthAbnormal3").val(first);
                var first1 = $("#healthAbnormal2").val();
                var first2 = $("#healthAbnormal3").val();
                var first3 = $("#healthAbnormal1").val();
                if (first == "" && first1 == "" && first2 == "" && first3 == "") {
                    $("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
                    $("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
                    $("input[id='healthEvaluateAnomalyFlgN']").click();
                }
            }
        } else {
            var first1 = $("#healthAbnormal2").val();
            var first2 = $("#healthAbnormal3").val();
            var first3 = $("#healthAbnormal1").val();
            if (first1 == "" && first2 == "" && first3 == "") {
                $("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
                $("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
                $("input[id='healthEvaluateAnomalyFlgN']").click();
            }
        }
    }

    //查体-乳腺异常
    function breastAnomaly() {
        var first = $("#healthAbnormal3").val();
        if (first != "") {
            if (first.indexOf("乳腺异常;") >= 0) {
                $("#healthAbnormal3").val(first);
            } else {
                $("#healthAbnormal3").val(first + "乳腺异常;");
            }
        } else {
            $("input[id='healthEvaluateAnomalyFlgN']").removeAttr("checked");
            $("input[id='healthEvaluateAnomalyFlg']").attr("checked", "checked");
            $("input[id='healthEvaluateAnomalyFlg']").click();
            $("#healthAbnormal3").val(first + "乳腺异常;");
        }
    }

    //查体-乳腺正常
    function breastAnomalyZC() {
        var first = $("#healthAbnormal3").val();
        if (first != "") {
            if (first.indexOf("乳腺异常;") >= 0) {
                first = first.replace("乳腺异常;", "");
                $("#healthAbnormal3").val(first);
                var first1 = $("#healthAbnormal2").val();
                var first2 = $("#healthAbnormal3").val();
                var first3 = $("#healthAbnormal1").val();
                if (first == "" && first1 == "" && first2 == "" && first3 == "") {
                    $("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
                    $("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
                    $("input[id='healthEvaluateAnomalyFlgN']").click();
                }
            }
        } else {
            var first1 = $("#healthAbnormal2").val();
            var first2 = $("#healthAbnormal3").val();
            var first3 = $("#healthAbnormal1").val();
            if (first1 == "" && first2 == "" && first3 == "") {
                $("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
                $("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
                $("input[id='healthEvaluateAnomalyFlgN']").click();
            }
        }
    }

    //查体-妇科异常
    function Gynaecology() {
        var first = $("#healthAbnormal3").val();
        if (first != "") {
            if (first.indexOf("妇科异常;") >= 0) {
                $("#healthAbnormal3").val(first);
            } else {
                $("#healthAbnormal3").val(first + "妇科异常;");
            }
        } else {
            $("input[id='healthEvaluateAnomalyFlgN']").removeAttr("checked");
            $("input[id='healthEvaluateAnomalyFlg']").attr("checked", "checked");
            $("input[id='healthEvaluateAnomalyFlg']").click();
            $("#healthAbnormal3").val(first + "妇科异常;");
        }
    }

    //查体-妇科正常
    function GynaecologyZC() {
        var first = $("#healthAbnormal3").val();
        if (first != "") {
            if (first.indexOf("妇科异常;") >= 0) {
                var accessories = $("input[name='PersonalPhyExamDTO.physiqueExamination.accessoriesAnomalyFlag']")[2].checked;
                var corpus = $("input[name='PersonalPhyExamDTO.physiqueExamination.corpusAnomalyFlag']")[2].checked;
                var cervical = $("input[name='PersonalPhyExamDTO.physiqueExamination.cervicalAnomalyFlag']")[2].checked;
                var vagina = $("input[name='PersonalPhyExamDTO.physiqueExamination.vaginaAnomalyFlag']")[2].checked;
                var vulva = $("input[name='PersonalPhyExamDTO.physiqueExamination.vulvaAnomalyFlag']")[2].checked;
                if (!accessories && !corpus && !cervical && !vagina && !vulva) {
                    first = first.replace("妇科异常;", "");
                }
                $("#healthAbnormal3").val(first);
                var first1 = $("#healthAbnormal2").val();
                var first2 = $("#healthAbnormal3").val();
                var first3 = $("#healthAbnormal1").val();
                if (first == "" && first1 == "" && first2 == "" && first3 == "") {
                    $("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
                    $("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
                    $("input[id='healthEvaluateAnomalyFlgN']").click();
                }
            }
        } else {
            var first1 = $("#healthAbnormal2").val();
            var first2 = $("#healthAbnormal3").val();
            var first3 = $("#healthAbnormal4").val();
            if (first1 == "" && first2 == "" && first3 == "") {
                $("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
                $("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
                $("input[id='healthEvaluateAnomalyFlgN']").click();
            }
        }
    }

    /**
     * 弹出体质辨识画面
     */
    function addEch(personId, examRecordId) {
        $.post(contextPath + '/ech/manage/report/init', {
                personId: personId,
                examRecordId: examRecordId,
                editflag: 'edit',
                sourceFlag: '2'
            },
            function (ret) {
                layer.open({
                    type: 1,
                    id: 'echDialog',
                    area: ['1000px', '650px'],
                    title: '老年人中医药健康管理服务记录表',
                    content: ret,
                    success: function (layero, index) {
                        $('#iden_index').val(index);
                    }
                });
            });
    }


    function addDepressed(personId) {
        $.post(contextPath + '/personRecord/addDepressed', {
                personId: personId,
                editflag: 'edit',
                sourceFlag: '2',
                ehrId: $("#currentEhrId").val()
            },
            function (ret) {
                layer.open({
                    type: 1,
                    id: 'depressedDialog',
                    area: ['700px', '650px'],
                    title: '老年人抑郁量表',
                    content: ret
                });
            });
    }

    function addOldDepressed(personId, physicalExamCode) {
        $.post(contextPath + '/hm/manage/addDepressed', {
                physicalExamCode: physicalExamCode,
                personId: personId,
                editflag: 'edit',
                sourceFlag: '2',
                ehrId: $("input[name='ehrId']").val()
            },
            function (ret) {
                layer.open({
                    type: 1,
                    id: 'depressedDialog',
                    area: ['700px', '650px'],
                    title: '老年人抑郁量表',
                    content: ret
                });
            });
    }

//     /**
//      * 是否能够体质辨识检查
//      */
//     function checkEchStatus(){
//     	var personId =$("input[name='PersonalPhyExamDTO.personInfo.id']").val();
//		$.getJsonByUrl({
//            url : "/personRecord/checkEchStatus",
//            wait : true,
//            param:{personId:personId},
//            callback : function(data) {
//               if($.isEmpty(data.examRecordId)){
//				   addEch(personId, "");
//                }else{
//                	addEch(personId, data.examRecordId);
//                }
//            }
//         });
//     }
//     function checkEchOldPeopleStatus(){
//
//      	var personId =$("#personId").val();
// 		$.getJsonByUrl({
//             url : "/personRecord/checkEchStatus",
//             wait : true,
//             param:{personId:personId},
//             callback : function(data) {
//                if($.isEmpty(data.examRecordId)){
//					addEch(personId, "");
//                 }else{
//                 	addEch(personId, data.examRecordId);
//                 }
//             }
//          });
//      }
//
//     function checkDepressedStatus(){
//      	var personId =$("input[name='PersonalPhyExamDTO.personInfo.id']").val();
// 		$.getJsonByUrl({
//             url : "/personRecord/checkEchStatus",
//             wait : true,
//             param:{personId:personId},
//             callback : function(data) {
//                if($.isEmpty(data.examRecordId)){
// 				    addDepressed(personId, "");
//                 }else{
//                 	addDepressed(personId,data.examRecordId);
//                 }
//             }
//          });
//      }
//     function checkOldDepressedStatus(){
//       	var personId =$("#personId").val();
//  		$.getJsonByUrl({
//              url : "/personRecord/checkEchStatus",
//              wait : true,
//              param:{personId:personId},
//              callback : function(data) {
//                 if($.isEmpty(data.examRecordId)){
//  				    addOldDepressed(personId, "");
//                  }else{
//                  	addOldDepressed(personId,data.examRecordId);
//                  }
//              }
//           });
//       }
    function symptomVali() {
        var inputs = $("#ttb1").find("input[type='checkbox']");
        var selecteds = inputs.filter(":checked");
        if (selecteds.length > 0) {
            inputs.each(function () {
                $(this).parent().removeClass("lose");
            });
            return true;
        } else {
            inputs.each(function () {
                $(this).parent().addClass("lose");
            });
            return false;
        }
    }

    function eyeDiseasesVali() {
        var inputs = $("#ttb13").find("input[type='checkbox']");
        var selecteds = inputs.filter(":checked");
        if (selecteds.length > 0) {
            inputs.each(function () {
                $(this).parent().removeClass("lose");
            });
            return true;
        } else {
            inputs.each(function () {
                $(this).parent().addClass("lose");
            });
            return false;
        }
    }

    function heartDiseaseVali() {
        var inputs = $("#ttb11").find("input[type='checkbox']");
        var selecteds = inputs.filter(":checked");
        if (selecteds.length > 0) {
            inputs.each(function () {
                $(this).parent().removeClass("lose");
            });
            return true;
        } else {
            inputs.each(function () {
                $(this).parent().addClass("lose");
            });
            return false;
        }
    }

    function EatingHabitsVali() {
        var inputs = $("#eatingHabits").find("input[type='checkbox']");
        var selecteds = inputs.filter(":checked");
        if (selecteds.length > 0) {
            inputs.each(function () {
                $(this).parent().removeClass("lose");
            });
            return true;
        } else {
            inputs.each(function () {
                $(this).parent().addClass("lose");
            });
            return false;
        }
    }

    function quitDrinkingVali() {
        var inputs = $("#isEndDrinkingSpan").find("input[type='radio']");
        var selecteds = inputs.filter(":checked");
        if (selecteds.length > 0) {
            inputs.each(function () {
                $(this).parent().removeClass("lose");
            });
            return true;
        } else {
            inputs.each(function () {
                $(this).parent().addClass("lose");
            });
            return false;
        }
    }

    function wineTypesVali() {
        var inputs = $("#wineTypeSpan").find("input[type='checkbox']");
        var selecteds = inputs.filter(":checked");
        if (selecteds.length > 0) {
            inputs.each(function () {
                $(this).parent().removeClass("lose");
            });
            return true;
        } else {
            inputs.each(function () {
                $(this).parent().addClass("lose");
            });
            return false;
        }
    }

    function electrocardiogramVali() {
        var inputs = $("#ECG").find("input[type='radio']");
        var selecteds = inputs.filter(":checked");
        if (selecteds.length > 0) {
            inputs.each(function () {
                $(this).parent().removeClass("lose");
            });
            return true;
        } else {
            inputs.each(function () {
                $(this).parent().addClass("lose");
            });
            return false;
        }
    }

    function fecalOccultBloodVali() {
        var inputs = $("#fecalOccultBlood").find("input[type='radio']");
        var selecteds = inputs.filter(":checked");
        if (selecteds.length > 0) {
            inputs.each(function () {
                $(this).parent().removeClass("lose");
            });
            return true;
        } else {
            inputs.each(function () {
                $(this).parent().addClass("lose");
            });
            return false;
        }
    }

    function hBsAgVali() {
        var inputs = $("#hBsAg").find("input[type='radio']");
        var selecteds = inputs.filter(":checked");
        if (selecteds.length > 0) {
            inputs.each(function () {
                $(this).parent().removeClass("lose");
            });
            return true;
        } else {
            inputs.each(function () {
                $(this).parent().addClass("lose");
            });
            return false;
        }
    }

    function CXRVali() {
        var inputs = $("#CXR").find("input[type='radio']");
        var selecteds = inputs.filter(":checked");
        if (selecteds.length > 0) {
            inputs.each(function () {
                $(this).parent().removeClass("lose");
            });
            return true;
        } else {
            inputs.each(function () {
                $(this).parent().addClass("lose");
            });
            return false;
        }
    }

    function BUltrasonVali() {
        var inputs = $("#BUltrason").find("input[type='radio']");
        var selecteds = inputs.filter(":checked");
        if (selecteds.length > 0) {
            inputs.each(function () {
                $(this).parent().removeClass("lose");
            });
            return true;
        } else {
            inputs.each(function () {
                $(this).parent().addClass("lose");
            });
            return false;
        }
    }

    function cervicalSmearVali() {
        var inputs = $("#cervicalSmear").find("input[type='radio']");
        var selecteds = inputs.filter(":checked");
        if (selecteds.length > 0) {
            inputs.each(function () {
                $(this).parent().removeClass("lose");
            });
            return true;
        } else {
            inputs.each(function () {
                $(this).parent().addClass("lose");
            });
            return false;
        }
    }

    function arteryDiseaseVali() {
        var inputs = $("#ttb12").find("input[type='checkbox']");
        var selecteds = inputs.filter(":checked");
        if (selecteds.length > 0) {
            inputs.each(function () {
                $(this).parent().removeClass("lose");
            });
            return true;
        } else {
            inputs.each(function () {
                $(this).parent().addClass("lose");
            });
            return false;
        }
    }

    function kidneyDiseaseVali() {
        var inputs = $("#ttb10").find("input[type='checkbox']");
        var selecteds = inputs.filter(":checked");
        if (selecteds.length > 0) {
            inputs.each(function () {
                $(this).parent().removeClass("lose");
            });
            return true;
        } else {
            inputs.each(function () {
                $(this).parent().addClass("lose");
            });
            return false;
        }
    }

    function breastAnomalyVali() {
        var inputs = $("#ttb8").find("input[type='checkbox']");
        var selecteds = inputs.filter(":checked");
        if (selecteds.length > 0) {
            inputs.each(function () {
                $(this).parent().removeClass("lose");
            });
            return true;
        } else {
            inputs.each(function () {
                $(this).parent().addClass("lose");
            });
            return false;
        }
    }

    function cvascularVali() {
        var inputs = $("#ttb9").find("input[type='checkbox']");
        var selecteds = inputs.filter(":checked");
        if (selecteds.length > 0) {
            inputs.each(function () {
                $(this).parent().removeClass("lose");
            });
            return true;
        } else {
            inputs.each(function () {
                $(this).parent().addClass("lose");
            });
            return false;
        }
    }

    function riskFactorVali() {
        var inputs = $("#ttbRisk").find("input[type='checkbox']");
        var selecteds = inputs.filter(":checked");
        if (selecteds.length > 0) {
            inputs.each(function () {
                $(this).parent().removeClass("lose");
            });
            return true;
        } else {
            inputs.each(function () {
                $(this).parent().addClass("lose");
            });
            return false;
        }
    }

    function healthGuidanceVali() {
        var inputs = $("#ttbhealth").find("input[type='checkbox']");
        var selecteds = inputs.filter(":checked");
        if (selecteds.length > 0) {
            inputs.each(function () {
                $(this).parent().removeClass("lose");
            });
            return true;
        } else {
            inputs.each(function () {
                $(this).parent().addClass("lose");
            });
            return false;
        }
    }

    function dentitionAnomalyVali() {
        var inputs = $("#ttb7").find("input[type='checkbox']");
        var selecteds = inputs.filter(":checked");
        if (selecteds.length > 0) {
            inputs.each(function () {
                $(this).parent().removeClass("lose");
            });
            return true;
        } else {
            inputs.each(function () {
                $(this).parent().addClass("lose");
            });
            return false;
        }
    }

    function missingToothVali() {
        var inputs = $("#ttb3").find("input");
        var inputValue = "";
        inputs.each(function () {
            inputValue += $(this).val();
        });
        if (inputValue != "") {
            $(this).parent().removeClass("lose");
            return true;
        } else {
            $(this).parent().addClass("lose");
            return false;
        }
    }

    function FastingBloodVali() {
        var inputs = $("#ttb15").find("input");
        var inputValue = "";
        inputs.each(function () {
            inputValue += $(this).val();
        });
        if (inputValue != "") {
            $(this).parent().removeClass("lose");
            return true;
        } else {
            $(this).parent().addClass("lose");
            return false;
        }
    }


    function decayedToothVali() {
        var inputs = $("#ttb4").find("input");
        var inputValue = "";
        inputs.each(function () {
            inputValue += $(this).val();
        });
        if (inputValue != "") {
            $(this).parent().removeClass("lose");
            return true;
        } else {
            $(this).parent().addClass("lose");
            return false;
        }
    }

    function dentureToothVali() {
        var inputs = $("#ttb5").find("input");
        var inputValue = "";
        inputs.each(function () {
            inputValue += $(this).val();
        });
        if (inputValue != "") {
            $(this).parent().removeClass("lose");
            return true;
        } else {
            $(this).parent().addClass("lose");
            return false;
        }
    }

    function otherTrainWayVali() {
        var inputValue = "";
        if ($("input[name='PersonalPhyExamDTO.physiqueExamination.trainingWay']:last").is(":checked")) {
            inputValue = $("input[name='PersonalPhyExamDTO.physiqueExamination.otherTrainingWay']").val();

            if (inputValue != "") {
                $(this).parent().removeClass("lose");
                return true;
            } else {
                $(this).parent().addClass("lose");
                return false;
            }
        } else {
            return true;
        }
    }


    function healthAbnormalVali() {
        var inputs = $("#ttb30").find("input");
        var inputValue = "";
        inputs.each(function () {
            inputValue += $(this).val();
        });
        if (inputValue != "") {
            $(this).parent().removeClass("lose");
            return true;
        } else {
            $(this).parent().addClass("lose");
            return false;
        }
    }

    //没有选中的情况下，如果没有第2个参数，则选中第一个radio；如果有，则选中参数指定的radio
    function checkRadio() {
        var args = Array.prototype.slice.call(arguments);
        if (typeof (args[1]) == "undefined") {
            if ($("input[name='" + args[0] + "']:checked").val() == null) {
                $("input[name='" + args[0] + "']:first").attr("checked", true);
            }
        } else {
            if ($("input[name='" + args[0] + "']:checked").val() == null) {
                $("input[name='" + args[0] + "']:eq(" + args[1] + ")").attr("checked", true);
            }
        }
    }

    $("#personHeightId").on("blur", function () {
        caculateBMI();
        if ($("#personBMIId").val() != "" && $("#personBMIId").val() < 24) {
            $("#riskWeightReduction").attr("disabled", true);
            $("#riskWeightReduction").removeAttr("checked");
            $("#riskWeightTarget").hide();
            $("#riskWeightReduction").next().attr("disabled", true);
            $("#riskWeightReduction").next().css("color", "grey");
        } else {
            $("#riskWeightReduction").removeAttr("disabled");
            $("#riskWeightReduction").next().removeAttr("disabled");
            $("#riskWeightReduction").next().css("color", "");

            if ($("#personBMIId").val() >= 24) {
                $("#riskWeightReduction").attr("checked", true);
                $("#riskWeightTarget").show();
            }
        }
    });

    $("#personWeightId").on("blur", function () {
        caculateBMI();
        if ($("#personBMIId").val() != "" && $("#personBMIId").val() < 24) {
            $("#riskWeightReduction").attr("disabled", true);
            $("#riskWeightReduction").removeAttr("checked");
            $("#riskWeightTarget").hide();
            $("#riskWeightReduction").next().attr("disabled", true);
            $("#riskWeightReduction").next().css("color", "grey");
        } else {
            $("#riskWeightReduction").removeAttr("disabled");
            $("#riskWeightReduction").next().removeAttr("disabled");
            $("#riskWeightReduction").next().css("color", "");

            if ($("#personBMIId").val() >= 24) {
                $("#riskWeightReduction").attr("checked", true);
                $("#riskWeightTarget").show();
            }
        }
    });

    //一般状况里的血压值超出正常值需有特定黄色标识
    $("#leftBloodUp").on("blur", function () {
        var leftUp = $("input[id='leftBloodUp']").val();
        if (parseInt(leftUp) > parseInt(300)) {
            $("#leftBloodUp").css("color", "red")
        } else {
            $("#leftBloodUp").css("color", "black")
        }
    });

    $("#leftBloodDown").on("blur", function () {
        var leftBloodDown = $("input[id='leftBloodDown']").val();
        if (parseInt(leftBloodDown) > parseInt(200)) {
            $("#leftBloodDown").css("color", "red")
        } else {
            $("#leftBloodDown").css("color", "black")
        }
    });

    $("#rightBloodUp").on("blur", function () {
        var rightBloodUp = $("input[id='rightBloodUp']").val();
        if (parseInt(rightBloodUp) > parseInt(300)) {
            $("#rightBloodUp").css("color", "red")
        } else {
            $("#rightBloodUp").css("color", "black")
        }
    });

    $("#rightBloodDown").on("blur", function () {
        var rightBloodDown = $("input[id='rightBloodDown']").val();
        if (parseInt(rightBloodDown) > parseInt(200)) {
            $("#rightBloodDown").css("color", "red")
        } else {
            $("#rightBloodDown").css("color", "black")
        }
    });

    //根据身高、体重计算BMI值
    function caculateBMI() {
        var height = ($("#personHeightId").val()) * 0.01;
        var weight = $("#personWeightId").val();
        if (height && weight) {
            var bmi = (weight / (height * height)).toFixed(1);
            $("#personBMIId").attr("value", bmi);
            var first = $("#healthAbnormal2").val();
            var a = '体重过轻(' + bmi + "kg/㎡);";
            var b = '体重过重(' + bmi + "kg/㎡);";
            var c = '肥胖(' + bmi + "kg/㎡);";
            var d = '非常肥胖(' + bmi + "kg/㎡);";
            var abReg = /^体重.*;$/;
            var cReg = /^肥胖.*;$/;
            var dReg = /^非常肥胖.*;$/;
            first = first.replace(abReg, '').replace(cReg, '').replace(dReg, '');

            if (bmi < 18.5) {
                $("input[id='healthEvaluateAnomalyFlgN']").removeAttr("checked");
                $("input[id='healthEvaluateAnomalyFlg']").attr("checked", "checked");
                $("input[id='healthEvaluateAnomalyFlg']").click();
                $("#healthAbnormal2").val(first + a);
            } else if (bmi >= 24 && bmi < 28) {
                $("input[id='healthEvaluateAnomalyFlgN']").removeAttr("checked");
                $("input[id='healthEvaluateAnomalyFlg']").attr("checked", "checked");
                $("input[id='healthEvaluateAnomalyFlg']").click();
                $("#healthAbnormal2").val(first + b);
            } else if (bmi >= 28 && bmi < 32) {
                $("input[id='healthEvaluateAnomalyFlgN']").removeAttr("checked");
                $("input[id='healthEvaluateAnomalyFlg']").attr("checked", "checked");
                $("input[id='healthEvaluateAnomalyFlg']").click();
                $("#healthAbnormal2").val(first + c);
            } else if (bmi >= 32) {
                $("input[id='healthEvaluateAnomalyFlgN']").removeAttr("checked");
                $("input[id='healthEvaluateAnomalyFlg']").attr("checked", "checked");
                $("input[id='healthEvaluateAnomalyFlg']").click();
                $("#healthAbnormal2").val(first + d);
            } else {
                $("#healthAbnormal2").val(first);
                if ($("#healthAbnormal1").val() == '' && $("#healthAbnormal2").val() == '' && $("#healthAbnormal3").val() == '' && $("#healthAbnormal4").val() == '') {
                    $("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
                    $("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
                    $("input[id='healthEvaluateAnomalyFlgN']").click();
                }
            }
        } else {
            $("#personBMIId").attr("value", "");
        }
    }

    $("#personWaostline").on("blur", function () {
        caculateWHR();
    });

    $("#personHip").on("blur", function () {
        caculateWHR();
    });

    function caculateWHR() {
        var waostline = $("#personWaostline").val();
        var hip = $("#personHip").val();
        if (waostline && hip && hip != 0) {
            var whr = (waostline / hip).toFixed(1);
            $("#whrValue").attr("value", whr);
        } else {
            $("#whrValue").attr("value", "");
        }
    }

    function save() {
        var result = validate.validateForm();
        if (!result) {
            return false;
        }
        $("input[name='PersonalPhyExamDTO.physiqueExamination.tcmPeacefulQuality']").removeAttr("disabled");
        $("input[name='PersonalPhyExamDTO.physiqueExamination.tcmQiQuality']").removeAttr("disabled");
        $("input[name='PersonalPhyExamDTO.physiqueExamination.tcmYangQuality']").removeAttr("disabled");
        $("input[name='PersonalPhyExamDTO.physiqueExamination.tcmYinDeficiency']").removeAttr("disabled");
        $("input[name='PersonalPhyExamDTO.physiqueExamination.tcmPhlegmWetness']").removeAttr("disabled");
        $("input[name='PersonalPhyExamDTO.physiqueExamination.tcmHeatMedium']").removeAttr("disabled");
        $("input[name='PersonalPhyExamDTO.physiqueExamination.tcmBloodQuality']").removeAttr("disabled");
        $("input[name='PersonalPhyExamDTO.physiqueExamination.tcmQiStagnation']").removeAttr("disabled");
        $("input[name='PersonalPhyExamDTO.physiqueExamination.tcmSpecialQuality']").removeAttr("disabled");
        $("#save_phyExam").html('<button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>正在保存...</button>');
        $("#phyExamForm").submitFormGetJson({
            url: "/personRecord/savePersonPhyExam",
            param: {
                ehrId: $("#ehrId").val()
            },
            callback: function (data) {
                $("#save_phyExam").html('<button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button>');
                if (data.indexOf("success") > -1) {
                    $("#basic_physical_examination_status").removeClass("person_record_todo");
                    $("#basic_physical_examination_status").addClass("person_recoed_complete");
                    $("#basic_physical_examination_li").children(":first").html("&#xe605;");
                    loadPersonPhysicalExam();
                    if (isExamClick) {
                        layer.alert("保存成功！", {icon: 0, title: '提示'});
                    }
                    if (personRecordPagination.saveClick) {
                        personRecordPagination.saveClick();
                    }
                } else {
                    layer.alert("保存失败！", {icon: 0, title: '提示'});
                }
            }
        });
        return true;
    }

    function showst(checkId, someId) {
        if ($("#" + checkId).attr("checked") == "checked") {
            $("#" + someId).show();
        }
    }

    function checkSelected(err, radioId, container, otherId, otherInputId, msg) {
        if ($("#" + radioId).prop("checked")) {
            var selectedIitems = $("#" + container + " input:checked");

            if (selectedIitems.length < 1) {
                err = null == err ? {} : err;
                err[radioId] = msg + ":请选择一项";
                showTip(radioId, true);
            } else {
                showTip(radioId, false);
                return checkSelOtherInput(err, otherId, otherInputId, msg);
            }
        } else {
            showTip(radioId, false);
        }
        return err;
    }

    function checkSelOtherInput(err, otherId, otherInputId, msg) {
        if ($("#" + otherId).prop("checked")) {
            //	alert(msg);
            var val = $("#" + otherInputId).val();
            if (val) {
                //	alert(val);
                showTip(otherId, false);
            } else {
                showTip(otherId, true);
                err = null == err ? {} : err;
                err[otherId] = msg + ":请输入值";
            }
        } else {
            showTip(otherId, false);
        }
        return err;
    }

    function checkSelOtherInputs(err, otherId, container, msg) {
        if ($("#" + otherId).prop("checked")) {
            var inputWithValues = $("#" + container + " input[value!='']");
            if (inputWithValues.length < 1) {
                err = null == err ? {} : err;
                err[otherId] = msg + ":请输入值";
                showTip(otherId, true);
            } else {
                showTip(otherId, false);
            }
        } else {
            showTip(otherId, false);
        }
        return err;
    }

    function showErrInfo(err) {
        $("#person_px_info_errbox").show();
        $("#person_px_info_errbox").empty();
        var element = null;
        for (element in err) {
            if (err.hasOwnProperty(element)) {
                var errinfo = "<a href='#" + element + "' >" + err[element] + "</a><br />";
                $("#person_px_info_errbox").append(errinfo);
            }
        }

    }

    function hideErrInfo() {
        $("#person_px_info_errbox").empty();
        $("#person_px_info_errbox").hide();
    }

    function showTip(elementId, show) {
        if (show) {
            $("#" + elementId).parent().addClass("errbox");
        } else {
            $("#" + elementId).parent().removeClass("errbox");
        }
    }


    function checkFromToEndDate(start, end, elementId, err, msg) {

        var currentDate = new Date();
        var startDate = null;
        var endDate = null;
        if (start) {
            startDate = new Date(start);
            if (startDate > currentDate) {
                err = null == err ? {} : err;
                msg += "开始时间不能大于当前时间";
                err[elementId] = msg;
                showTip(elementId, true);
                return err;
            }
        }

        if (end) {
            endDate = new Date(end);
            if (endDate > currentDate) {
                err = null == err ? {} : err;
                msg += "结束时间不能大于当前时间";
                err[elementId] = msg;
                showTip(elementId, true);
                return err;
            }
        }

        if (start && end) {
            if (startDate > endDate) {
                err = null == err ? {} : err;
                msg += "开始时间不能大于结束时间";
                err[elementId] = msg;
                showTip(elementId, true);
                return err;
            }
        }
        //多个错误信息公用一个id，有错误就显示
        showTip(elementId, false);
        return err;
    }

    function setContentStyle(obj, ids, disabledVal) {
        if (obj.name == 'PersonalPhyExamDTO.physiqueExamination.smodeStatusCode') {
            var val = $('input:radio[name="PersonalPhyExamDTO.physiqueExamination.smodeStatusCode"]:checked').val();
            if (val == '1') {

                $("input[name='PersonalPhyExamDTO.physiqueExamination.riskQuitSmoking']").attr("disabled", true);
                $("input[name='PersonalPhyExamDTO.physiqueExamination.riskQuitSmoking']").next().attr("disabled", true);
                $("input[name='PersonalPhyExamDTO.physiqueExamination.riskQuitSmoking']").next().css("color", "grey");
            } else {
                $("input[name='PersonalPhyExamDTO.physiqueExamination.riskQuitSmoking']").removeAttr("disabled");
                $("input[name='PersonalPhyExamDTO.physiqueExamination.riskQuitSmoking']").next().removeAttr("disabled");
                $("input[name='PersonalPhyExamDTO.physiqueExamination.riskQuitSmoking']").next().css("color", "");
            }

        }
        if (obj.name == 'PersonalPhyExamDTO.physiqueExamination.drinkFrequency') {
            var val = $('input:radio[name="PersonalPhyExamDTO.physiqueExamination.drinkFrequency"]:checked').val();
            if (val == '1') {
                $("input[name='PersonalPhyExamDTO.physiqueExamination.riskHealthDrink']").attr("disabled", true);
                $("input[name='PersonalPhyExamDTO.physiqueExamination.riskHealthDrink']").next().attr("disabled", true);
                $("input[name='PersonalPhyExamDTO.physiqueExamination.riskHealthDrink']").next().css("color", "grey");
            } else {
                $("input[name='PersonalPhyExamDTO.physiqueExamination.riskHealthDrink']").removeAttr("disabled");
                $("input[name='PersonalPhyExamDTO.physiqueExamination.riskHealthDrink']").next().removeAttr("disabled");
                $("input[name='PersonalPhyExamDTO.physiqueExamination.riskHealthDrink']").next().css("color", "");
            }

        }
        var array = ids.split(":");
        if (disabledVal == obj.value) {
            if (null != array && array.length > 0) {
                for (var i = 0; i < array.length; i++) {
                    $("#" + array[i]).attr("disabled", "disabled");
                    $("#" + array[i]).removeClass("lose");
                    $("#" + array[i] + " input").attr("disabled", "disabled");
                    $("#" + array[i] + " input").removeClass("lose");
                    $("#" + array[i] + " input[type='text']").val("");
                    $("#" + array[i] + " input[type='text']").removeClass("lose");
                    $("#" + array[i] + " input[type='radio']").removeAttr("checked");
                    $("#" + array[i] + " input[type='radio']").parent().removeClass("lose");
                    $("#" + array[i] + " input[type='checkbox']").removeAttr("checked");
                    $("#" + array[i] + " input[type='checkbox']").parent().removeClass("lose");
                }
            }
        } else {
            if (null != array && array.length > 0) {
                for (var i = 0; i < array.length; i++) {
                    $("#" + array[i]).removeAttr("disabled");
                    $("#" + array[i] + " input").removeAttr("disabled");
                }
            }
        }
    }

    function initContentStyle(name, ids, disabledVal) {

        if (name == 'PersonalPhyExamDTO.physiqueExamination.drinkFrequency') {
            var val = $('input:radio[name="PersonalPhyExamDTO.physiqueExamination.drinkFrequency"]:checked').val();
            if (val == disabledVal) {
                $("input[name='PersonalPhyExamDTO.physiqueExamination.riskHealthDrink']").attr("disabled", true);
                $("input[name='PersonalPhyExamDTO.physiqueExamination.riskHealthDrink']").next().attr("disabled", true);
                $("input[name='PersonalPhyExamDTO.physiqueExamination.riskHealthDrink']").next().css("color", "grey");
            } else {
                $("input[name='PersonalPhyExamDTO.physiqueExamination.riskHealthDrink']").removeAttr("disabled");
                $("input[name='PersonalPhyExamDTO.physiqueExamination.riskHealthDrink']").next().removeAttr("disabled");
                $("input[name='PersonalPhyExamDTO.physiqueExamination.riskHealthDrink']").next().css("color", "");
            }

        }

        if (name == 'PersonalPhyExamDTO.physiqueExamination.smodeStatusCode') {
            var val = $('input:radio[name="PersonalPhyExamDTO.physiqueExamination.smodeStatusCode"]:checked').val();
            if (val == disabledVal) {

                $("input[name='PersonalPhyExamDTO.physiqueExamination.riskQuitSmoking']").attr("disabled", true);
                $("input[name='PersonalPhyExamDTO.physiqueExamination.riskQuitSmoking']").next().attr("disabled", true);
                $("input[name='PersonalPhyExamDTO.physiqueExamination.riskQuitSmoking']").next().css("color", "grey");
            } else {
                $("input[name='PersonalPhyExamDTO.physiqueExamination.riskQuitSmoking']").removeAttr("disabled");
                $("input[name='PersonalPhyExamDTO.physiqueExamination.riskQuitSmoking']").next().removeAttr("disabled");
                $("input[name='PersonalPhyExamDTO.physiqueExamination.riskQuitSmoking']").next().css("color", "");
            }

        }
        var array = ids.split(":");
        $("input[name='" + name + "']").each(function () {
            if ($(this).val() == disabledVal && this.checked && null != array && array.length > 0) {
                for (var i = 0; i < array.length; i++) {
                    $("#" + array[i]).attr("disabled", "disabled");
                    $("#" + array[i] + " input").attr("disabled", "disabled");
                    //0146501: 【健康档案】个人体检表 体育锻炼选择不锻炼 和 饮酒情况选择从不 保存再选别的选项点保存为空
                    /*$("#"+array[i]+" input").val("");*/
                }
            }
        });
    }

    function dic_other(dicName, hiddenId, otherName) {
        if ($("input[name='" + dicName + "']:last").is(":checked")) {
            $("#" + hiddenId).css("display", "inline");
        } else {
            $("input[name='" + otherName + "']").attr("value", "");
            $("#" + hiddenId).css("display", "none");
        }
    }

    function isExamClicked() {
        isExamClick = false;
    }

    function calculateAssessment() {
        var score = toNumber($(":checked[name='PersonalPhyExamDTO.physiqueExamination.eatingAssessment']").val()) + toNumber($(":checked[name='PersonalPhyExamDTO.physiqueExamination.cleaningAssessment']").val())
            + toNumber($(":checked[name='PersonalPhyExamDTO.physiqueExamination.clothingAssessment']").val()) + toNumber($(":checked[name='PersonalPhyExamDTO.physiqueExamination.defecationAssessment']").val())
            + toNumber($(":checked[name='PersonalPhyExamDTO.physiqueExamination.exerciseAssessment']").val());
        if (score >= 0 && score <= 3) {
            $(":radio[name='PersonalPhyExamDTO.physiqueExamination.lifeAbilitySelfAssessment'][value='1']").click();
        } else if (score >= 4 && score <= 8) {
            $(":radio[name='PersonalPhyExamDTO.physiqueExamination.lifeAbilitySelfAssessment'][value='2']").click();
        } else if (score >= 9 && score <= 18) {
            $(":radio[name='PersonalPhyExamDTO.physiqueExamination.lifeAbilitySelfAssessment'][value='3']").click();
        } else {
            $('input:radio[name="PersonalPhyExamDTO.physiqueExamination.lifeAbilitySelfAssessment"]').eq(3).click();
            $(":radio[name='PersonalPhyExamDTO.physiqueExamination.lifeAbilitySelfAssessment'][value='4']").click();
        }
    }

    function toNumber(num) {
        var n = parseInt(num);
        if (isNaN(n)) {
            return 0;
        } else {
            return n;
        }
    }

    return {
        save: save,
//         check:check,
        setContentStyle: setContentStyle,
        initContentStyle: initContentStyle,
        isExamClicked: isExamClicked,
        calculateAssessment: calculateAssessment,
        changeCheck: changeCheck
    };
})();

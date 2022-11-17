var cdmPersonPhyExamAdd = (function()
{

	var validate = null;
	$(function() {
		showst("symptomFlag", "ttb1");
		showst("symptomOther", "symptomOtherDesc");
		showst("cognitionScreenResult", "cognitionScreenScore");
		showst("emotionScreenResult", "depressionScore");
		showst("occupationExposureFlag", "occupationExposureDiv");

		showst("dustProtectionFlag", "dustProtectionDesc");
		showst("radiationProtectionFlag", "radiationProtectionDesc");
		showst("physicsProtectionFlag", "physicsProtectionDesc");
		showst("chemistryProtectionFlag", "chemistryProtectionDesc");
		showst("otherProtectionFlag", "otherProtectionDesc");

		showst("dentitionAnomalyFlag", "dentitionAnomalyDiv");
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

		showst("breastAnomalyFlag", "breastAnomalySpan");
		showst("breastOther", "breastOtherDesc");
		showst("vulvaAnomalyFlag", "vulvaAnomalyDesc");
		showst("vaginaAnomalyFlag", "vaginaAnomalyDesc");

		showst("cervicalAnomalyFlag", "cervicalAnomalyDesc");
		showst("corpusAnomalyFlag", "corpusAnomalyDesc");
		showst("accessoriesAnomalyFlag", "accessoriesAnomalyDesc");

		showst("ecgAnomalyFlag", "ecgAnomalyDesc");
		showst("chestXAnomalyfFlag", "chestXAnomalyfDesc");
		showst("bmodeAnomalyfFlag", "bmodeAnomalyfDesc");
		showst("bmodeOtherAnomalyfFlag", "bmodeOtherAnomalyfDesc");
		showst("cervicalSmearAnomalyfFlag", "cervicalSmearAnomalyfDesc");
		
		showst("cvascularFlag", "cvascularDiv");
		showst("kidneyDiseaseFlag", "kidneyDiseaseDiv");
		showst("heartDiseaseFlag", "heartDiseaseDiv");
		showst("arteryDiseaseFlag", "arteryDiseaseDiv");
		showst("eyeDiseasesFlag", "eyeDiseasesDiv");
		showst("hospitalizedHistoryFlg", "hospitalizedHistoryDiv");
		showst("familyBedHistoryFlg", "familyBedHistoryDiv");
		showst("drugHistoryFlag", "drugHistoryDiv");
		showst("vaccinationInfoFlg", "vaccinationInfoDiv");

		showst("covascularOther", "cvascularOtherDesc");
		showst("kidneyOther", "kidneyOtherDesc");
		showst("heartOther", "heartOtherDesc");
		showst("arteryOther", "arteryOtherDesc");
		showst("eyeOther", "eyeOtherDesc");
		showst("nervousDiseasesFlag", "nervousDiseasesDesc");
		showst("healthOther", "healthOtherDesc");
		
		showst("riskWeightReduction", "riskWeightReductionSpan");
		showst("guideVaccination", "guideVaccinationSpan");
		showst("riskOther", "riskOtherDesc");

		showst("drinkOther", "drinkOtherDesc");
		showst("nodrinkId", "quitDrinkAgeDesc");

		showst("hypertensionFlag", "hypertensionDesc");
		showst("diabetesMellitusFlag", "diabetesMellituDesc");

		showst("diabetesMellitusFlag", "hypertensionLevelTr");
		showst("hypertensionFlag", "hypertensionFlag");
		showst("healthEvaluateAnomalyFlg", "ttb30");

		toggleOther('dreCheckResultType','dreCheckResultTypeSpan',9);
		
		$("#hm-phyexam-add-back-view-btn").on("click", back);
		var $form = $("#hm-person-phyexam-view-form");
		$form.find("input[type='text']").prop("disabled", true);
		$form.find("input[type='radio']").prop("disabled", true);
		$form.find("input[type='checkbox']").prop("disabled", true);
		$form.find("select").prop("disabled", true);

		var trainingWayCode = $("#text_trainingWay").val();
		if(trainingWayCode.indexOf("14") != -1){
			$("#other_train_way_span").css("display","inline");
		}else {
			$("#other_train_way_span").css("display","none");
		}
        // checkExam();

        $("#old-phyexam-print-btn").click(function(){
            $("#hm-phyexam-main").jqprint(
                {
                    debug: false, //如果是true则可以显示iframe查看效果（iframe默认高和宽都很小，可以再源码中调大），默认是false
                    importCSS: true, //true表示引进原来的页面的css，默认是true。（如果是true，先会找$("link[media=print]")，若没有会去找$("link")中的css文件）
                    printContainer: true, //表示如果原来选择的对象必须被纳入打印（注意：设置为false可能会打破你的CSS规则）。
                    operaSupport: true//表示如果插件也必须支持歌opera浏览器，在这种情况下，它提供了建立一个临时的打印选项卡。默认是true
                });
        });
	});

	function showst(checkId, someId){
		if ($("#" + checkId).attr("checked") == "checked"){
			$("#" + someId).show();
		}
	}

	function back(){
		$("#hm-person-phyexam-list-box").show();
		$("#hm-person-phyexam-input-box").hide();
	}

    /**
	 * 检查“辅助检查”值是否异常
     */
	function checkExam(){
		//血红蛋白
        checkUnusual('hemoglobinValue',"110","160","");
        //白细胞
        checkUnusual('leukocyteCount',"4","10","");
        //血小板
        checkUnusual('plateletCount',"100","300","");
        //尿蛋白
        checkUnusual('urineProQuantitativeValue',"","","阴性");
        //尿糖
        checkUnusual('urineSugQuantitativeValue',"","","阴性");
        //尿酮体
        checkUnusual('ketQuantitativeValue',"","","阴性");
        //尿潜血
        checkUnusual('eryQuantitativeValue',"","","阴性");
        //空腹血糖
        checkUnusual('fpgMmol',"4","6.4","");
        //尿微量血蛋白
        checkUnusual('urineMicroTongAlbumin',"0","20","");
        //糖化血红蛋白
        checkUnusual('hgb',"4。8","6","");
        //血清谷丙转氨酶
        checkUnusual('serumGptValue',"0","32","");
        //血清谷草转氨酶
        checkUnusual('serumAstValue',"0","31","");
        //白蛋白浓度
        checkUnusual('albuminConcentration',"35","50","");
        //总胆红素
        checkUnusual('totalBilirubin',"1.71","26","");
        //结合胆红素
        checkUnusual('conjugatedBilirubin',"0","6.8","");
        //血清肌酐
        checkUnusual('creatinine',"44","106","");
        //血尿素氮
        checkUnusual('bloodUreaNitrogenValue',"1.7","8.3","");
        //血钾浓度
        checkUnusual('potassiumConcentration',"3.5","5.5","");
        //血钠浓度
        checkUnusual('sodiumConcentration',"135","145","");
        //总胆固醇
        checkUnusual('tc',"3","5.2","");
        //甘油三酯
        checkUnusual('triglycerideValue',"0.45","1.7","");
        //血清低密度脂蛋白胆固醇
        checkUnusual('ldlcDetectValue',"2.07","3.12","");
        //血清高密度脂蛋白胆固醇
        checkUnusual('hdlcDetectValue',"0.94","2.0","");
        //尿蛋白
        checkUnusual('urineProQuantitativeValue',"","","-");
		//尿糖
        checkUnusual('urineSugQuantitativeValue',"","","-");
		//尿酮体
        checkUnusual('ketQuantitativeValue',"","","-");
		//尿潜血
        checkUnusual('eryQuantitativeValue',"","","-");
	}
    /**
	 * 如果体检项目异常，则突出显示
     * @param elementId
     * @param minValue
     * @param maxValue
     * @param normalValue
     */
	function checkUnusual(element,minValue,maxValue,normalValue){
		//如果正常值不为空，则判断正常值
		if(!$.isEmpty(normalValue)){
			//radio控件
			var elementVal = $('input:radio[name="' + element +'"]:checked').val();
			if(elementVal != normalValue){
                $('input:radio[name="' + element +'"]').addClass('unusual');
			}else {
                $('input:radio[name="' + element +'"]').removeClass('unusual');
			}
			//input控件
			elementVal = $('input[name="' + element +'"]').val();
            if(elementVal != normalValue && (!$.isEmpty(elementVal))){
                $('input[name="' + element +'"]').addClass('unusual');
            }else{
                $('input[name="' + element +'"]').removeClass('unusual');
			}
		}else{
            var elementVal = $('input[name="' + element +'"]').val();
            if(!$.isEmpty(elementVal)){
				if(parseFloat(elementVal) < parseFloat(minValue) || parseFloat(elementVal) > parseFloat(maxValue) ){
					$('input[name="' + element +'"]').addClass('unusual');
				}else {
					$('input[name="' + element +'"]').removeClass('unusual');
				}
            }
		}
	}
})();
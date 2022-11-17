var dmPhyExamView=(function ()
{
	$(function ()
	{
		$("#cdm-phyexam-view-back-btn").on("click", back);
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

		showst("healthEvaluateAnomalyFlag", "ttb30");

		toggleOther('dreCheckResultType','dreCheckResultTypeSpan',9);
		
		var $form = $("#cdm-person-phyexam-view-form");
		$form.find("input").prop("readonly", true);
		$form.find("input[type='radio']").prop("disabled", true);
		$form.find("input[type='checkbox']").prop("disabled", true);

        //保存后血压超标值显示红色
        var leftUp = $("input[id='leftBloodUp']").val();
        if(parseInt(leftUp)>parseInt(300)){
            $("#leftBloodUp").css("color","red")
        }else {
            $("#leftBloodUp").css("color","black")
        }

        var leftBloodDown = $("input[id='leftBloodDown']").val();
        if(parseInt(leftBloodDown)>parseInt(200)){
            $("#leftBloodDown").css("color","red")
        } else {
            $("#leftBloodDown").css("color","black")
        }

        var rightBloodUp = $("input[id='rightBloodUp']").val();
        if(parseInt(rightBloodUp)>parseInt(300)){
            $("#rightBloodUp").css("color","red")
        }else {
            $("#rightBloodUp").css("color","black")
        }

        var rightBloodDown = $("input[id='rightBloodDown']").val();
        if(parseInt(rightBloodDown)>parseInt(200)){
            $("#rightBloodDown").css("color","red")
        }else {
            $("#rightBloodDown").css("color","black")
        }
	});


	function showst(checkId, someId)
	{
		if ($("#" + checkId).prop("checked")){
			$("#" + someId).show();
		}
	}

	function back()
	{
		$("#cdm-person-phyexam-list-box").show();
		$("#cdm-person-phyexam-input-box").hide();
	}


})();
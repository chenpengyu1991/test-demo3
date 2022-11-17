var cdmPersonPhyExamAdd = (function()
{

	var validate = null;
	var isIndex=$("#cdm-person-phyexam-index-add").val();
	$(function()
	{
		validate = $("#cdm-person-phyexam-form").easyValidate();
		validate.addExtension("healthGuidanceVali",healthGuidanceVali);
		validate.addExtension("riskFactorVali",riskFactorVali);
		validate.addExtension("FastingBloodVali",FastingBloodVali);
		enableChangeConfirm();
		$("#cdm-phyexam-add-back-btn").on("click", function () {
			layer.confirm("确认离开？",{icon:1, title:'确认提示'},function(index){
				layer.close(index);
				doBack();
			});
		});
		$("#cdm-phyexam-add-save-btn").on("click", save);

		$("input[name='leftSbp']").on("blur", calHbpLevel);
		$("input[name='leftDbp']").on("blur", calHbpLevel);

		calHbpLevel();

		showst("symptomFlag", "ttb1");
		showst("symptomOther", "symptomOtherDesc");
		showst("cognitionScreenResult", "cognitionScreenScore");
		showst("emotionScreenResult", "depressionScore");
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
		showst("bmodeAnomalyfFlag", "bmodeAnomalyfDesc");
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

		showst("hypertensionFlag", "hypertensionDesc");
		showst("diabetesMellitusFlag", "diabetesMellituDesc");

		showst("healthEvaluateAnomalyFlag", "ttb30");

		showst("diabetesMellitusFlag", "hypertensionLevelTr");
		showst("hypertensionFlag", "hypertensionFlag");
		initContentStyle("smodeStatusCode","smokePerDaySpan:beginSmokeAgeSpan:endSmokeAgeSpan",1);
		initContentStyle("trainFrequencyTypeCode","exerciseTypeSpan:keepTimeSpan:exerciseTimeSpan",4);
		initContentStyle("drinkFrequency","wineTypeSpan:isDrunkSpan:beginDrinkingAgeSpan:isEndDrinkingSpan:drinkingPerDaySpan",1);
		initContentStyle("dietHunsuEquilibrium","",1);
		validate.addExtension("otherTrainWayVali",otherTrainWayVali);

		toggleOther('dreCheckResultType','dreCheckResultTypeSpan',9);
		
		$("#cdm-phyexam-pre-btn").on("click", function(){			
			var personId = $("#personId").val();
			//先检查有无做过体检
			$.getJsonByUrl({
				url : "/cdm/standardization/phyExamination/hasExam",
				param: {personId: personId},
				callback : function(data){
					if(!$.isEmpty(data)){
						loderPrePhyExam(data);
					}else {
						layer.alert("未查询到上一次体检信息！", {icon:0,title:'提示'});
					}
				}
			});


		});
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
		
		$("input[name='trainingWay']").on("click", function(){
			dic_other("trainingWay", "other_train_way_span", "otherTrainingWay");
		});

		$("input").keypress(function(event)
		{
			var $inp = $("input:text");
			var key = event.which;
			if (key == 13)
			{
				event.preventDefault();
				var nxtIdx = $inp.index(this) + 1;
				$(":input:text:eq(" + nxtIdx + ")").focus();
			}
		});

		var option = {
			url : "/mdmOrganization/organationTree",
			unSelecteType : [ '0' ]
		};
		var opb = {
			url : "/mdmOrganization/organationSelect",
			feild : {
				value : "organCode",
				lable : "organName"
			}
		};

		var examinationOrganCode = $("#examinationOrganCode");
		if (examinationOrganCode.length > 0)
		{
			examinationOrganCode.selectBox(opb);
			examinationOrganCode.initTreeSelect(option);
		}
		var trainingWayCode = $("#text_trainingWay").val();
		if(trainingWayCode.indexOf("14") != -1){
			$("#other_train_way_span").css("display","inline");
		}else {
			$("#other_train_way_span").css("display","none");
		}

        $("#addEch").on("click" ,function(){
            checkEchStatus();
        });

		//健康评价-血压异常
		$("#leftBloodDown").blur(function () {
			countBoold();
		});
		$("#leftBloodUp").blur(function () {
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
			var first = $("input[id='healthAbnormal3']").val();
			if(first != ""){
				if(first.indexOf("眼底异常;") >= 0){
					$("#healthAbnormal3").val(first);
				}else{
					$("#healthAbnormal3").val(first+"眼底异常;");
				}
			}else {
				$("input[id='healthEvaluateAnomalyFlgN']").removeAttr("checked");
				$("input[id='healthEvaluateAnomalyFlg']").attr("checked","checked");
				$("input[id='healthEvaluateAnomalyFlg']").click();
				$("#healthAbnormal3").val(first+"眼底异常;");
			}
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
		$("input[id='liverFlagZC']").click(function () {
			Abdomen();
		});
		$("input[id='liverFlag']").click(function () {
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
		var isAnomaly = $("input[id='healthEvaluateAnomalyFlgN']")[0].checked;
		if(!isAnomaly){
			$("input[id='healthEvaluateAnomalyFlg']").click();
		}
		var isNeverDrink = $("input[name='drinkFrequency']")[0].checked;
		if(!isNeverDrink){
			$("#wineTypeSpan").removeAttr("disabled");
			$("#wineTypeSpan input").removeAttr("disabled");
			$("#isDrunkSpan").removeAttr("disabled");
			$("#isDrunkSpan input").removeAttr("disabled");
			$("#beginDrinkingAgeSpan").removeAttr("disabled");
			$("#beginDrinkingAgeSpan input").removeAttr("disabled");
			$("#isEndDrinkingSpan").removeAttr("disabled");
			$("#isEndDrinkingSpan input").removeAttr("disabled");
			$("#drinkingPerDaySpan").removeAttr("disabled");
			$("#drinkingPerDaySpan input").removeAttr("disabled");
		}
		//健康评价 设置 无法修改
		/*$("input[id='healthEvaluateAnomalyFlgN']").attr("disabled",true);*/
		/*$("input[id='healthEvaluateAnomalyFlg']").attr("disabled",true);*/
		$("input[name='dietHunsuEquilibrium']").on("click" ,function(){ 
	         if($("input[name='dietHunsuEquilibrium']").is(':checked')==true){
	        	 $("input[name='riskDiet']").attr("disabled",true);
	 			$("input[name='riskDiet']").next().attr("disabled",true);
	 			$("input[name='riskDiet']").next().css("color","grey");
	 		}else{
	     		$("input[name='riskDiet']").removeAttr("disabled");
	 			$("input[name='riskDiet']").next().removeAttr("disabled");
	 			$("input[name='riskDiet']").next().css("color","");
	     	}
	     });
		$("input[name='drinkFrequency']").on("click" ,function(){ 
	         if($("input[name='drinkFrequency']:checked").val()=='1'){
	        	 $("input[name='riskHealthDrink']").attr("disabled",true);
	 			$("input[name='riskHealthDrink']").next().attr("disabled",true);
	 			$("input[name='riskHealthDrink']").next().css("color","grey");
	 		}else{
	     		$("input[name='riskHealthDrink']").removeAttr("disabled");
	 			$("input[name='riskHealthDrink']").next().removeAttr("disabled");
	 			$("input[name='riskHealthDrink']").next().css("color","");
	     	}
	     });
		$("input[name='smodeStatusCode']").on("click" ,function(){ 
	         if($("input[name='smodeStatusCode']:checked").val()=='1'){
	        	 $("input[name='riskQuitSmoking']").attr("disabled",true);
	    			$("input[name='riskQuitSmoking']").next().attr("disabled",true);
	    			$("input[name='riskQuitSmoking']").next().css("color","grey");
	    		}else{
	        		$("input[name='riskQuitSmoking']").removeAttr("disabled");
	    			$("input[name='riskQuitSmoking']").next().removeAttr("disabled");
	    			$("input[name='riskQuitSmoking']").next().css("color","");
	        	}
	     });
		//高血压中医药健康管理
		$("#addHbp").click(function () {
			CMJudge('HBP');
		});
		//糖尿病中医药健康管理
		$("#addDM").click(function () {
			CMJudge('DM');
		});
	});

	function healthGuidanceVali() {
		var inputs=$("#ttbhealth").find("input[type='checkbox']");
		var selecteds=inputs.filter(":checked");
		if(selecteds.length>0){
			inputs.each(function(){
				$(this).parent().removeClass("lose");
			});
			return true;
		}else{
			inputs.each(function(){
				$(this).parent().addClass("lose");
			});
			return false;
		}
	}

	function riskFactorVali() {
		var inputs=$("#ttbRisk").find("input[type='checkbox']");
		var selecteds=inputs.filter(":checked");
		if(selecteds.length>0){
			inputs.each(function(){
				$(this).parent().removeClass("lose");
			});
			return true;
		}else{
			inputs.each(function(){
				$(this).parent().addClass("lose");
			});
			return false;
		}
	}
	
	function FastingBloodVali(){
		var inputs=$("#ttb15").find("input");
		var inputValue = "";
		inputs.each(function(){
			inputValue += $(this).val();
		});
		if(inputValue != ""){
			$(this).parent().removeClass("lose");
			return true;
		}else {
			$(this).parent().addClass("lose");
			return false;
		}
	}
	
	//弹出高血压中医药健康管理判断框
	function CMJudge(cdType) {
		var title = null;
		if(cdType=='HBP'){
			title = "高血压中医药健康管理";
		}else {
			title = "糖尿病中医药健康管理";
		}
        var personId =$("input[name='personId']").val();
        var ehrId =$("input[name='ehrId']").val();
		var CMDialog = {
			url : "/cdm/standardization/phyExamination/CMJudge",
			height : 600,
			width : 600,
			title : title ,
			id :"CMDialog",
			param : {
				/*param:param,*/
				cdType:cdType,
                personId:personId,
                ehrId:ehrId
			}
		};
		$.dialog(CMDialog);
	}
	//健康评价-血压异常
	function countBoold() {
		debugger;
		var leftUp = $("input[id='leftBloodUp']").val();
		var leftDown = $("input[id='leftBloodDown']").val();
		var first = $("input[id='healthAbnormal1']").val();
		if(parseInt(leftUp)>parseInt(140) || parseInt(leftDown)>parseInt(90) || parseInt(leftUp)<parseInt(90) || parseInt(leftDown)<parseInt(60)){
			$("input[id='healthEvaluateAnomalyFlgN']").removeAttr("checked");
			$("input[id='healthEvaluateAnomalyFlg']").attr("checked","checked");
			$("input[id='healthEvaluateAnomalyFlg']").click();
			if(first.indexOf("血压异常;") >= 0){
				$("#healthAbnormal1").val(first);
			}else{
				$("#healthAbnormal1").val(first+"血压异常;");
			}
		}else{
			if(first.indexOf("血压异常;") >= 0){
				first = first.replace("血压异常;","");
				$("#healthAbnormal1").val(first);
				var first1 = $("input[id='healthAbnormal2']").val();
				var first2 = $("input[id='healthAbnormal3']").val();
				var first3 = $("input[id='healthAbnormal4']").val();
				if(first == "" && first1=="" && first2=="" && first3==""){
					$("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
					$("input[id='healthEvaluateAnomalyFlgN']").attr("checked","checked");
					$("input[id='healthEvaluateAnomalyFlgN']").click();
				}

			}
		}
	}

	//判断是否空腹血糖
	function bloodGlucoseLeft() {
		var left = $("input[id='bloodGlucoseLeft']").val();
		var right = $("input[id='bloodGlucoseRight']").val();
		var first = $("input[id='healthAbnormal1']").val();
		if(parseInt(left)>=parseInt(7) || parseInt(right)>=parseInt(140)){
			$("input[id='healthEvaluateAnomalyFlgN']").removeAttr("checked");
			$("input[id='healthEvaluateAnomalyFlg']").attr("checked","checked");
			$("input[id='healthEvaluateAnomalyFlg']").click();
			if(first.indexOf("血糖异常;") >= 0){
				$("#healthAbnormal1").val(first);
			}else{
				$("#healthAbnormal1").val(first+"血糖异常;");
			}
		}else{
			if(first.indexOf("血糖异常;") >= 0){
				first = first.replace("血糖异常;","");
				$("#healthAbnormal1").val(first);
				var first1 = $("input[id='healthAbnormal2']").val();
				var first2 = $("input[id='healthAbnormal3']").val();
				var first3 = $("input[id='healthAbnormal4']").val();
				if(first == "" && first1=="" && first2=="" && first3==""){
					$("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
					$("input[id='healthEvaluateAnomalyFlgN']").attr("checked","checked");
					$("input[id='healthEvaluateAnomalyFlgN']").click();
				}

			}
		}
	}

	//健康评价-眼底
	function eye() {
		var first = $("input[id='healthAbnormal3']").val();
		if(first != ""){
			if(first.indexOf("眼底异常;") >= 0){
				first = first.replace("眼底异常;","");
				$("#healthAbnormal3").val(first);
				var first1 = $("input[id='healthAbnormal2']").val();
				var first2 = $("input[id='healthAbnormal3']").val();
				var first3 = $("input[id='healthAbnormal4']").val();
				if(first == "" && first1=="" && first2=="" && first3==""){
					$("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
					$("input[id='healthEvaluateAnomalyFlgN']").attr("checked","checked");
					$("input[id='healthEvaluateAnomalyFlgN']").click();
				}
			}
		}else {
			var first1 = $("input[id='healthAbnormal2']").val();
			var first2 = $("input[id='healthAbnormal3']").val();
			var first3 = $("input[id='healthAbnormal4']").val();
			if(first1=="" && first2=="" && first3=="") {
				$("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
				$("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
				$("input[id='healthEvaluateAnomalyFlgN']").click();
			}
		}
	}

	//查体-皮肤异常
	function skinAbnormal() {
		var first = $("input[id='healthAbnormal3']").val();
		if(first != ""){
			if(first.indexOf("皮肤异常;") >= 0){
				$("#healthAbnormal3").val(first);
			}else{
				$("#healthAbnormal3").val(first+"皮肤异常;");
			}
		}else {
			$("input[id='healthEvaluateAnomalyFlgN']").removeAttr("checked");
			$("input[id='healthEvaluateAnomalyFlg']").attr("checked","checked");
			$("input[id='healthEvaluateAnomalyFlg']").click();
			$("#healthAbnormal3").val(first+"皮肤异常;");
		}
	}
	function skinAbnormalZC() {
		var first = $("input[id='healthAbnormal3']").val();
		if(first != ""){
			if(first.indexOf("皮肤异常;") >= 0){
				first = first.replace("皮肤异常;","");
				$("#healthAbnormal3").val(first);
				var first1 = $("input[id='healthAbnormal2']").val();
				var first2 = $("input[id='healthAbnormal3']").val();
				var first3 = $("input[id='healthAbnormal4']").val();
				if(first == "" && first1=="" && first2=="" && first3==""){
					$("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
					$("input[id='healthEvaluateAnomalyFlgN']").attr("checked","checked");
					$("input[id='healthEvaluateAnomalyFlgN']").click();
				}
			}
		}else {
			var first1 = $("input[id='healthAbnormal2']").val();
			var first2 = $("input[id='healthAbnormal3']").val();
			var first3 = $("input[id='healthAbnormal4']").val();
			if(first1=="" && first2=="" && first3=="") {
				$("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
				$("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
				$("input[id='healthEvaluateAnomalyFlgN']").click();
			}
		}
	}

	//查体-巩膜异常
	function sclera() {
		var first = $("input[id='healthAbnormal3']").val();
		if(first != ""){
			if(first.indexOf("巩膜异常;") >= 0){
				$("#healthAbnormal3").val(first);
			}else{
				$("#healthAbnormal3").val(first+"巩膜异常;");
			}
		}else {
			$("input[id='healthEvaluateAnomalyFlgN']").removeAttr("checked");
			$("input[id='healthEvaluateAnomalyFlg']").attr("checked","checked");
			$("input[id='healthEvaluateAnomalyFlg']").click();
			$("#healthAbnormal1").val(first+"巩膜异常;");
		}
	}
	//查体-巩膜正常
	function scleraZC() {
		var first = $("input[id='healthAbnormal3']").val();
		if(first != ""){
			if(first.indexOf("巩膜异常;") >= 0){
				first = first.replace("巩膜异常;","");
				$("#healthAbnormal3").val(first);
				var first1 = $("input[id='healthAbnormal2']").val();
				var first2 = $("input[id='healthAbnormal3']").val();
				var first3 = $("input[id='healthAbnormal4']").val();
				if(first == "" && first1=="" && first2=="" && first3==""){
					$("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
					$("input[id='healthEvaluateAnomalyFlgN']").attr("checked","checked");
					$("input[id='healthEvaluateAnomalyFlgN']").click();
				}
			}
		}else {
			var first1 = $("input[id='healthAbnormal2']").val();
			var first2 = $("input[id='healthAbnormal3']").val();
			var first3 = $("input[id='healthAbnormal4']").val();
			if(first1=="" && first2=="" && first3=="") {
				$("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
				$("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
				$("input[id='healthEvaluateAnomalyFlgN']").click();
			}
		}
	}
	//查体-淋巴结异常
	function lymphNode() {
		var first = $("input[id='healthAbnormal3']").val();
		if(first != ""){
			if(first.indexOf("淋巴结异常;") >= 0){
				$("#healthAbnormal3").val(first);
			}else{
				$("#healthAbnormal3").val(first+"淋巴结异常;");
			}
		}else {
			$("input[id='healthEvaluateAnomalyFlgN']").removeAttr("checked");
			$("input[id='healthEvaluateAnomalyFlg']").attr("checked","checked");
			$("input[id='healthEvaluateAnomalyFlg']").click();
			$("#healthAbnormal3").val(first+"淋巴结异常;");
		}
	}
	//查体-淋巴结正常
	function lymphNodeZC() {
		var first = $("input[id='healthAbnormal3']").val();
		if(first != ""){
			if(first.indexOf("淋巴结异常;") >= 0){
				first = first.replace("淋巴结异常;","");
				$("#healthAbnormal3").val(first);
				var first1 = $("input[id='healthAbnormal1']").val();
				var first2 = $("input[id='healthAbnormal3']").val();
				var first3 = $("input[id='healthAbnormal4']").val();
				if(first == "" && first1=="" && first2=="" && first3==""){
					$("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
					$("input[id='healthEvaluateAnomalyFlgN']").attr("checked","checked");
					$("input[id='healthEvaluateAnomalyFlgN']").click();
				}
			}
		}else {
			var first1 = $("input[id='healthAbnormal1']").val();
			var first2 = $("input[id='healthAbnormal3']").val();
			var first3 = $("input[id='healthAbnormal4']").val();
			if(first1=="" && first2=="" && first3=="") {
				$("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
				$("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
				$("input[id='healthEvaluateAnomalyFlgN']").click();
			}
		}
	}

	//查体-肺-桶状胸异常
	function lung() {
		var first = $("input[id='healthAbnormal3']").val();
		if(first != ""){
			if(first.indexOf("肺异常;") >= 0){
				$("#healthAbnormal3").val(first);
			}else{
				$("#healthAbnormal3").val(first+"肺异常;");
			}
		}else {
			$("input[id='healthEvaluateAnomalyFlgN']").removeAttr("checked");
			$("input[id='healthEvaluateAnomalyFlg']").attr("checked","checked");
			$("input[id='healthEvaluateAnomalyFlg']").click();
			$("#healthAbnormal3").val(first+"肺异常;");
		}
	}
	function lungZC() {
		var first = $("input[id='healthAbnormal3']").val();
		if(first != ""){
			if(first.indexOf("肺异常;") >= 0){
				var barrel = $("input[id='barrelChestZC']")[0].checked;
				var lungsAnomaly = $("input[id='lungsAnomalySoundZC']")[0].checked;
				var lungsRale= $("input[id='lungsRaleZC']")[0].checked;
				if(barrel && lungsAnomaly && lungsRale){
					first = first.replace("肺异常;","");
				}
				$("#healthAbnormal3").val(first);
				var first1 = $("input[id='healthAbnormal1']").val();
				var first2 = $("input[id='healthAbnormal3']").val();
				var first3 = $("input[id='healthAbnormal4']").val();
				if(first == "" && first1=="" && first2=="" && first3==""){
					$("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
					$("input[id='healthEvaluateAnomalyFlgN']").attr("checked","checked");
					$("input[id='healthEvaluateAnomalyFlgN']").click();
				}
			}
		}else {
			var first1 = $("input[id='healthAbnormal2']").val();
			var first2 = $("input[id='healthAbnormal3']").val();
			var first3 = $("input[id='healthAbnormal4']").val();
			if(first1=="" && first2=="" && first3=="") {
				$("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
				$("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
				$("input[id='healthEvaluateAnomalyFlgN']").click();
			}
		}
	}

	//心脏异常
	function heart() {
		var first = $("input[id='healthAbnormal3']").val();
		if(first != ""){
			if(first.indexOf("心脏异常;") >= 0){
				$("#healthAbnormal3").val(first);
			}else{
				$("#healthAbnormal3").val(first+"心脏异常;");
			}
		}else {
			$("input[id='healthEvaluateAnomalyFlgN']").removeAttr("checked");
			$("input[id='healthEvaluateAnomalyFlg']").attr("checked","checked");
			$("input[id='healthEvaluateAnomalyFlg']").click();
			$("#healthAbnormal3").val(first+"心脏异常;");
		}
	}
	//心脏正常
	function heartZC() {
		var first = $("input[id='healthAbnormal3']").val();
		if(first != ""){
			if(first.indexOf("心脏异常;") >= 0){
				var cardioverter = $("input[id='cardioverter']")[0].checked;
				var heart = $("input[id='heartMurmurFlagZC']")[0].checked;
				if(cardioverter && heart){
					first = first.replace("心脏异常;","");
				}
				$("#healthAbnormal3").val(first);
				var first1 = $("input[id='healthAbnormal1']").val();
				var first2 = $("input[id='healthAbnormal3']").val();
				var first3 = $("input[id='healthAbnormal4']").val();
				if(first == "" && first1=="" && first2=="" && first3==""){
					$("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
					$("input[id='healthEvaluateAnomalyFlgN']").attr("checked","checked");
					$("input[id='healthEvaluateAnomalyFlgN']").click();
				}
			}
		}else {
			var first1 = $("input[id='healthAbnormal1']").val();
			var first2 = $("input[id='healthAbnormal3']").val();
			var first3 = $("input[id='healthAbnormal4']").val();
			if(first == "" && first1=="" && first2=="" && first3=="") {
				$("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
				$("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
				$("input[id='healthEvaluateAnomalyFlgN']").click();
			}
		}
	}

	//腹部异常
	function Abdomen() {
		var first = $("input[id='healthAbnormal3']").val();
		if(first != ""){
			if(first.indexOf("腹部异常;") >= 0){
				$("#healthAbnormal3").val(first);
			}else{
				$("#healthAbnormal3").val(first+"腹部异常;");
			}
		}else {
			$("input[id='healthEvaluateAnomalyFlgN']").removeAttr("checked");
			$("input[id='healthEvaluateAnomalyFlg']").attr("checked","checked");
			$("input[id='healthEvaluateAnomalyFlg']").click();
			$("#healthAbnormal3").val(first+"腹部异常;");
		}
	}
	//腹部正常
	function AbdomenZC() {
		var first = $("input[id='healthAbnormal3']").val();
		if(first != ""){
			if(first.indexOf("腹部异常;") >= 0){
				var abdominalVoiced = $("input[id='abdominalTendernessFlagZC']")[0].checked;
				var splenomegaly = $("input[id='abdominalMassFlagZC']")[0].checked;
				var liver = $("input[id='splenomegalyFlagZC']")[0].checked;
				var abdominalMass = $("input[id='liverFlagZC']")[0].checked;
				var abdominalTenderness = $("input[id='abdominalVoicedFlagZC']")[0].checked;
				if(abdominalVoiced && splenomegaly && liver && abdominalMass && abdominalTenderness){
					first = first.replace("腹部异常;","");
				}
				$("#healthAbnormal3").val(first);
				var first1 = $("input[id='healthAbnormal2']").val();
				var first2 = $("input[id='healthAbnormal1']").val();
				var first3 = $("input[id='healthAbnormal4']").val();
				if(first == "" && first1=="" && first2=="" && first3==""){
					$("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
					$("input[id='healthEvaluateAnomalyFlgN']").attr("checked","checked");
					$("input[id='healthEvaluateAnomalyFlgN']").click();
				}
			}
		}else {
			var first1 = $("input[id='healthAbnormal2']").val();
			var first2 = $("input[id='healthAbnormal1']").val();
			var first3 = $("input[id='healthAbnormal4']").val();
			if(first == "" && first1=="" && first2=="" && first3=="") {
				$("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
				$("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
				$("input[id='healthEvaluateAnomalyFlgN']").click();
			}
		}
	}
	//下肢水肿异常
	function legsEdema() {
		var first = $("input[id='healthAbnormal3']").val();
		if(first != ""){
			if(first.indexOf("下肢水肿异常;") >= 0){
				$("#healthAbnormal3").val(first);
			}else{
				$("#healthAbnormal3").val(first+"下肢水肿异常;");
			}
		}else {
			$("input[id='healthEvaluateAnomalyFlgN']").removeAttr("checked");
			$("input[id='healthEvaluateAnomalyFlg']").attr("checked","checked");
			$("input[id='healthEvaluateAnomalyFlg']").click();
			$("#healthAbnormal3").val(first+"下肢水肿异常;");
		}
	}
	//下肢水肿正常
	function legsEdemaZC() {
		var first = $("input[id='healthAbnormal3']").val();
		if(first != ""){
			if(first.indexOf("下肢水肿异常;") >= 0){
				first = first.replace("下肢水肿异常;","");
				$("#healthAbnormal3").val(first);
				var first1 = $("input[id='healthAbnormal2']").val();
				var first2 = $("input[id='healthAbnormal1']").val();
				var first3 = $("input[id='healthAbnormal4']").val();
				if(first == "" && first1=="" && first2=="" && first3==""){
					$("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
					$("input[id='healthEvaluateAnomalyFlgN']").attr("checked","checked");
					$("input[id='healthEvaluateAnomalyFlgN']").click();
				}
			}
		}else {
			var first1 = $("input[id='healthAbnormal2']").val();
			var first2 = $("input[id='healthAbnormal1']").val();
			var first3 = $("input[id='healthAbnormal4']").val();
			if(first == "" && first1=="" && first2=="" && first3=="") {
				$("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
				$("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
				$("input[id='healthEvaluateAnomalyFlgN']").click();
			}
		}
	}
	//查体-足背动脉搏动异常
	function arteriopalmus() {
		var first = $("input[id='healthAbnormal3']").val();
		if(first != ""){
			if(first.indexOf("足背动脉搏动异常;") >= 0){
				$("#healthAbnormal3").val(first);
			}else{
				$("#healthAbnormal3").val(first+"足背动脉搏动异常;");
			}
		}else {
			$("input[id='healthEvaluateAnomalyFlgN']").removeAttr("checked");
			$("input[id='healthEvaluateAnomalyFlg']").attr("checked","checked");
			$("input[id='healthEvaluateAnomalyFlg']").click();
			$("#healthAbnormal3").val(first+"足背动脉搏动异常;");
		}
	}
	//查体-足背动脉搏动正常
	function arteriopalmusZC() {
		var first = $("input[id='healthAbnormal3']").val();
		if(first != ""){
			if(first.indexOf("足背动脉搏动异常;") >= 0){
				first = first.replace("足背动脉搏动异常;","");
				$("#healthAbnormal3").val(first);
				var first1 = $("input[id='healthAbnormal2']").val();
				var first2 = $("input[id='healthAbnormal1']").val();
				var first3 = $("input[id='healthAbnormal4']").val();
				if(first == "" && first1=="" && first2=="" && first3==""){
					$("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
					$("input[id='healthEvaluateAnomalyFlgN']").attr("checked","checked");
					$("input[id='healthEvaluateAnomalyFlgN']").click();
				}
			}
		}else {
			var first1 = $("input[id='healthAbnormal2']").val();
			var first2 = $("input[id='healthAbnormal1']").val();
			var first3 = $("input[id='healthAbnormal4']").val();
			if(first1=="" && first2=="" && first3=="") {
				$("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
				$("input[id='healthEvaluateAnomalyFlgN']").attr("checked", "checked");
				$("input[id='healthEvaluateAnomalyFlgN']").click();
			}
		}
	}
	function dic_other(dicName, hiddenId, otherName){
		if($("input[name='" + dicName + "']:last").is(":checked")){
			$("#" + hiddenId).css("display","inline");
		}else {
			$("input[name='" + otherName + "']").attr("value", "");
			$("#" + hiddenId).css("display","none");
		}
	}

	function otherTrainWayVali(){
		var inputValue = "";
		if($("input[name='trainingWay']:last").is(":checked")){
			inputValue = $("input[name='otherTrainingWay']").val();

			if(inputValue != ""){
				$(this).parent().removeClass("lose");
				return true;
			}else {
				$(this).parent().addClass("lose");
				return false;
			}
		}else {
			return true;
		}
	}

	function initContentStyle(name, ids,disabledVal)
	{
		var array = ids.split(":");
		if(name=="trainFrequencyTypeCode"){
			$("input[name='" + name + "']").each(function()
					{
						if ($(this).val() == 4 && this.checked && null != array && array.length > 0)
						{
							for ( var i = 0; i < array.length; i++)
							{
								$("#" + array[i]).attr("disabled", "disabled");
								$("#" + array[i] + " input").attr("disabled", "disabled");
								$("#" + array[i] + " input").val("");
							}
						}
					});
		}else{
			$("input[name='" + name + "']").each(function()
					{
						if ($(this).val() == 4 && this.checked && null != array && array.length > 0)
						{
							for ( var i = 0; i < array.length; i++)
							{
								$("#" + array[i]).attr("disabled", "disabled");
								$("#" + array[i] + " input").attr("disabled", "disabled");
								$("#" + array[i] + " input").val("");
							}
						}
					});
			
		}
		
		
		if(name=='dietHunsuEquilibrium'){
    		var val=$('input[name="dietHunsuEquilibrium"]:checked').val();
    		if(val==disabledVal){
    			
    			$("input[name='riskDiet']").attr("disabled",true);
    			$("input[name='riskDiet']").next().attr("disabled",true);
    			$("input[name='riskDiet']").next().css("color","grey");
    		}else{
        		$("input[name='riskDiet']").removeAttr("disabled");
    			$("input[name='riskDiet']").next().removeAttr("disabled");
    			$("input[name='riskDiet']").next().css("color","");
        	}
    		
    	}
		if(name=='drinkFrequency'){
    		var val=$('input:radio[name="drinkFrequency"]:checked').val();
    		if(val==disabledVal){
    			$("input[name='riskHealthDrink']").attr("disabled",true);
    			$("input[name='riskHealthDrink']").next().attr("disabled",true);
    			$("input[name='riskHealthDrink']").next().css("color","grey");
    		}else{
        		$("input[name='riskHealthDrink']").removeAttr("disabled");
    			$("input[name='riskHealthDrink']").next().removeAttr("disabled");
    			$("input[name='riskHealthDrink']").next().css("color","");
        	}
    		
    	}
    	
    	if(name=='smodeStatusCode'){
    		var val=$('input:radio[name="smodeStatusCode"]:checked').val();
    		if(val==disabledVal){
    			
    			$("input[name='riskQuitSmoking']").attr("disabled",true);
    			$("input[name='riskQuitSmoking']").next().attr("disabled",true);
    			$("input[name='riskQuitSmoking']").next().css("color","grey");
    		}else{
        		$("input[name='riskQuitSmoking']").removeAttr("disabled");
    			$("input[name='riskQuitSmoking']").next().removeAttr("disabled");
    			$("input[name='riskQuitSmoking']").next().css("color","");
        	}
    		
    	}
		
	}

	function setContentStyle(obj,ids){
		var array=ids.split(":");
		if(obj.name=="trainFrequencyTypeCode"){
			if("4"==obj.value){
				if(null!=array&&array.length>0){
					for(var i=0;i<array.length;i++){
						$("#"+array[i]).attr("disabled","disabled");
						$("#"+array[i]+" input").attr("disabled","disabled");
						$("#"+array[i]+" input[type='text']").val("");
						$("#"+array[i]+" input[type='radio']").removeAttr("checked");
					}
				}
			}else{
				if(null!=array&&array.length>0){
					for(var i=0;i<array.length;i++){
						$("#"+array[i]).removeAttr("disabled");
						$("#"+array[i]+" input").removeAttr("disabled");
					}
				}
			}
		}else{
			if("1"==obj.value){
				if(null!=array&&array.length>0){
					for(var i=0;i<array.length;i++){
						$("#"+array[i]).attr("disabled","disabled");
						$("#"+array[i]+" input").attr("disabled","disabled");
						$("#"+array[i]+" input[type='text']").val("");
						$("#"+array[i]+" input[type='radio']").removeAttr("checked");
					}
				}
			}else{
				if(null!=array&&array.length>0){
					for(var i=0;i<array.length;i++){
						$("#"+array[i]).removeAttr("disabled");
						$("#"+array[i]+" input").removeAttr("disabled");
					}
				}
			}
		}
		
		
	}

	// 如果没有选中，则选中第一个选项
	function checkFirstRadio(radioName)
	{
		if ($("input[name='" + radioName + "']:checked").val() == null)
		{
			$("input[name='" + radioName + "']:first").attr("checked", true);
		}
	}

	$("#personHeightId").on("blur", function()
	{
		caculateBMI();
		reduction();
	});

	$("#personWeightId").on("blur", function()
	{
		caculateBMI();
		reduction();
	});

	function reduction(){
		if($("#personBMIId").val()!=""&&$("#personBMIId").val()<24){
		   	 $("#riskWeightReduction").attr("disabled",true);
		   	 $("#riskWeightReduction").removeAttr("checked");
		   	 $("#riskWeightTarget").hide();
		   	 $("#riskWeightReduction").next().attr("disabled",true);
		   	 $("#riskWeightReduction").next().css("color","grey");
	    }else{
		   	 $("#riskWeightReduction").removeAttr("disabled");
		   	 $("#riskWeightReduction").next().removeAttr("disabled");
		   	 $("#riskWeightReduction").next().css("color","");
		   	 
		   	 if($("#personBMIId").val()>=24){
		   		 $("#riskWeightReduction").attr("checked",true);
		   		 $("#riskWeightTarget").show();
		   	 }
	    }
	}
	
	// 根据身高、体重计算BMI值
	function caculateBMI()
	{
		var height = ($("#personHeightId").val());
		var weight = $("#personWeightId").val();

		if (height && weight&&$.isNumeric(height)&&$.isNumeric(weight))
		{
			height=height*0.01;
			var bmi = (weight / (height * height)).toFixed(1);
			$("#personBMIId").attr("value", bmi);
			
			var first = $("input[id='healthAbnormal2']").val();
    		var a = '体重过轻;';
    		var b = '体重过重;';
    		var c = '肥胖;';
    		var d = '非常肥胖;';
	    	first = first.replace(a,'').replace(b,'').replace(d,'').replace(c,'');
    		
	    	if(bmi<18.5){
    			$("input[id='healthEvaluateAnomalyFlgN']").removeAttr("checked");
				$("input[id='healthEvaluateAnomalyFlg']").attr("checked","checked");
				$("input[id='healthEvaluateAnomalyFlg']").click();
				$("#healthAbnormal2").val(first+a);
    		}else if(bmi>=24 && bmi<28){
    			$("input[id='healthEvaluateAnomalyFlgN']").removeAttr("checked");
				$("input[id='healthEvaluateAnomalyFlg']").attr("checked","checked");
				$("input[id='healthEvaluateAnomalyFlg']").click();
				$("#healthAbnormal2").val(first+b);
    		}else if(bmi>=28 && bmi <32){
    			$("input[id='healthEvaluateAnomalyFlgN']").removeAttr("checked");
				$("input[id='healthEvaluateAnomalyFlg']").attr("checked","checked");
				$("input[id='healthEvaluateAnomalyFlg']").click();
				$("#healthAbnormal2").val(first+c);
    		}else if(bmi>=32){
    			$("input[id='healthEvaluateAnomalyFlgN']").removeAttr("checked");
				$("input[id='healthEvaluateAnomalyFlg']").attr("checked","checked");
				$("input[id='healthEvaluateAnomalyFlg']").click();
				$("#healthAbnormal2").val(first+d);
    		}else{
    			$("#healthAbnormal2").val(first);
    			if($("#healthAbnormal1").val()=='' && $("#healthAbnormal2").val()==''&& $("#healthAbnormal3").val()==''&& $("#healthAbnormal4").val()==''){
    				$("input[id='healthEvaluateAnomalyFlg']").removeAttr("checked");
    				$("input[id='healthEvaluateAnomalyFlgN']").attr("checked","checked");
    				$("input[id='healthEvaluateAnomalyFlgN']").click();
    			}
    		}
		} else
		{
			$("#personBMIId").attr("value", "");
		}
	}

	$("#personWaostline").on("blur", function()
	{
		caculateWHR();
	});

	$("#personHip").on("blur", function()
	{
		caculateWHR();
	});

	function caculateWHR()
	{
		var waostline = $("#personWaostline").val();
		var hip = $("#personHip").val();
		if (waostline && hip&&$.isNumeric(waostline)&&$.isNumeric(hip)&&hip != 0)
		{
			var whr = (waostline / hip).toFixed(1);
			$("#whrValue").attr("value", whr);
		} else
		{
			$("#whrValue").attr("value", "");
		}
	}

	//
	// （SBP140-159mmHg和/或DBP90-99mmHg）
	// 高血压2级
	// （SBP160-179mmHg和/或DBP100-109mmHg）
	// 高血压3级（SBP≥180mmHg和/或DBP≥110mmHg）

	function calHbpLevel()
	{
		var value = calHbpLevelValue();
		$("input[name='hypertensionLevel']").val([ value ]);
	}
	function calHbpLevelValue()
	{
		var sbp = $("input[name='leftSbp']").val();
		var dbp = $("input[name='leftDbp']").val();
		var level = 0;
		if (sbp)
		{
			if (sbp >= 180)
			{
				level = 3;
				return level;
			} else if (sbp >= 160)
			{
				level = 2;
			} else if (sbp >= 140)
			{
				level = 1;
			}
		}

		if (dbp)
		{
            if (dbp >= 110)
            {
                level = 3;
                return level;
            } else if (dbp >= 100)
            {
                level = 2;
                return level;
            } else if (level<2&&dbp >= 90)
            {
                level = 1;
                return level;
            }
		}
		return level;

	}

	function showst(checkId, someId)
	{
		if ($("#" + checkId).attr("checked") == "checked")
		{
			$("#" + someId).show();
		}

	}

	function back()
	{
		if (contentChanged)
		{
			 layui.use('layer', function() {
	    			var layer = layui.layer;
	    			var index = layer.confirm('确认离开?', {icon:1, title:'确认提示'}, function(){
	    				layer.close(index);
	    				doBack();
					});
	    			
	    		});
			/*msgUtil.backConfirm(doBack) ;*/
		}else{
			doBack()
		}
	}

	function doBack(){
		if(isIndex){
			$("#cdm-manage-list-box").show();
			$("#cdm-manage-input-box").hide();
		}else{
			$("#cdm-person-phyexam-list-box").show();
			$("#cdm-person-phyexam-input-box").hide();
		}

	}

    function refresh() {
        if (isIndex) {
            if (cmdPhyExaminationList && $.isFunction(cmdPhyExaminationList.refresh)) {
                cmdPhyExaminationList.refresh();
            }
        } else {
            if (cmdPersonPhyExaminationList && $.isFunction(cmdPersonPhyExaminationList.refresh)) {
                cmdPersonPhyExaminationList.refresh();
            }
        }
        back();
    }

	function save()
	{
		/*$("input[id='healthEvaluateAnomalyFlgN']").attr("disabled",false);*/
		/*$("input[id='healthEvaluateAnomalyFlg']").attr("disabled",false);*/
		var org=$("input[name='examinationOrganCode']").val();

		if(!org){
			$("#examinationOrganCode").val("");
		}
		var result = validate.validateForm();
		if (!result)
		{
			return;
		}
		/* 中医体质辨识非必输 del by bagen
		if($("#idElder").val()=="true"){
			 if($("#CMedicine").is(":hidden")){
				 layer.alert("中医体质辨识必须填写！");
				 return false;
			 }
			 var inputs=$("#CMedicine").find("input[type='radio']:checked");
			 var inputValue = "";
			 if(inputs.length==0){
				 layer.alert("中医体质辨识必须填写！");
				 return false;
			 }
		 }*/
		 //中医体质辨识
		$("input[name='tcmPeacefulQuality']").removeAttr("disabled");
		$("input[name='tcmQiQuality']").removeAttr("disabled");
		$("input[name='tcmYangQuality']").removeAttr("disabled");
		$("input[name='tcmYinDeficiency']").removeAttr("disabled");
		$("input[name='tcmPhlegmWetness']").removeAttr("disabled");
		$("input[name='tcmHeatMedium']").removeAttr("disabled");
		$("input[name='tcmBloodQuality']").removeAttr("disabled");
		$("input[name='tcmQiStagnation']").removeAttr("disabled");
		$("input[name='tcmSpecialQuality']").removeAttr("disabled");
		//高血压中医管理
		$("input[name='hyinEmptyYangHyper']").removeAttr("disabled");
		$("input[name='hqiBloodEmpty']").removeAttr("disabled");
		$("input[name='hphlegmBloodStasis']").removeAttr("disabled");
		$("input[name='hspermDeficiency']").removeAttr("disabled");
		$("input[name='hyangEmpty']").removeAttr("disabled");
		$("input[name='hanOffset']").removeAttr("disabled");
		//糖尿病中医管理
		$("input[name='dyinEmptyHot']").removeAttr("disabled");
		$("input[name='dqiYinEmpty']").removeAttr("disabled");
		$("input[name='dyinYangEmpty']").removeAttr("disabled");
		//获取健康评价异常数据
		var healthAbnormal1 = $("#healthAbnormal1").val();
		var healthAbnormal2 = $("#healthAbnormal2").val();
		var healthAbnormal3 = $("#healthAbnormal3").val();
		var healthAbnormal4 = $("#healthAbnormal4").val();
		var nodrink=$("input[name='nodrink']:checked").val();
		// 保存
		$("#cdm-person-phyexam-form").submitFormGetJson({
			url : "/cdm/standardization/phyExamination/save",
			param : {
				healthAbnormal1:healthAbnormal1,
				healthAbnormal2:healthAbnormal2,
				healthAbnormal3:healthAbnormal3,
				healthAbnormal4:healthAbnormal4,
				nodrink:nodrink
			},
			wait : true,
			callback : function(data)
			{
				if (data == true)
				{
					layer.alert("保存成功！", {icon:0,title:'提示'}, function(index) {
						refresh();
						layer.close(index);
					});
					disableChangeConfirm();
				} else
				{
					layer.alert("保存失败！", {icon:0,title:'提示'});
				}
			}
		});

	}

    /**
     * 是否能够体质辨识检查
     */
    function checkEchStatus(){
        var personId =$("input[name='personId']").val();
        $.getJsonByUrl({
            url : "/personRecord/checkEchStatus",
            wait : true,
            param:{personId:personId},
            callback : function(data) {
				if($.isEmpty(data.examRecordId)){
					addEch(personId, "");
				}else{
					addEch(personId, data.examRecordId);
				}
            }
        });
    }
	function loderPrePhyExam(ehrId) {
		var index = layer.confirm("确定要覆盖页面上所有数据吗？", {icon:2, title:'确认提示'}, function(){
			var personId = $("#personId").val();
			$("#cdm-phyexam-main").empty();
			debugger;
			var loadHtmlByUrlOption = {
				url: "/cdm/standardization/phyExamination/edit",
				insertDiv: "cdm-phyexam-main",
				param: {personId: personId,loadPrePhyexamFlag:"load",ehrId:ehrId}
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
			$("#cdm-phyexam-pre-btn").attr("disabled",true);
			$("#cdm-phyexam-pre-btn").addClass('layui-btn-disabled');
			layer.close(index);
		});
	}
    /**
     * 弹出体质辨识画面
     */
    function addEch(personId, examRecordId){
        /*var echDialog = {
            url : "/ech/manage/report/init",
            height : 650,
            width : 1000,
            title : "老年人中医药健康管理服务记录表" ,
            id :"echDialog",
            param : {
                personId: personId,
                examRecordId:examRecordId,
                editflag:'edit',
                sourceFlag:'2'
            }
        };
        $.dialog(echDialog);*/
        
        $.post(contextPath+'/ech/manage/report/init',{
        	personId: personId,
            examRecordId:examRecordId,
            editflag:'edit',
            sourceFlag:'2'}, 
		function(ret){
			  layer.open({
				  type: 1,
				  id:'echDialog',
				  area: ['1000px', '650px'],
				  title:'老年人中医药健康管理服务记录表',
				  content: ret,
    			  success: function(layero, index){
  				    $('#iden_index').val(index);
  				  }
			  });
    	});
    }

    //一般状况里的血压值超出正常值需有特定黄色标识
    $("#leftBloodUp").on("blur", function(){
        var leftUp = $("input[id='leftBloodUp']").val();
        if(parseInt(leftUp)>parseInt(300)){
            $("#leftBloodUp").css("color","red")
        }else {
            $("#leftBloodUp").css("color","black")
        }
    });

    $("#leftBloodDown").on("blur", function(){
        var leftBloodDown = $("input[id='leftBloodDown']").val();
        if(parseInt(leftBloodDown)>parseInt(200)){
            $("#leftBloodDown").css("color","red")
        } else {
            $("#leftBloodDown").css("color","black")
        }
    });

    $("#rightBloodUp").on("blur", function(){
        var rightBloodUp = $("input[id='rightBloodUp']").val();
        if(parseInt(rightBloodUp)>parseInt(300)){
            $("#rightBloodUp").css("color","red")
        }else {
            $("#rightBloodUp").css("color","black")
        }
    });

    $("#rightBloodDown").on("blur", function(){
        var rightBloodDown = $("input[id='rightBloodDown']").val();
        if(parseInt(rightBloodDown)>parseInt(200)){
            $("#rightBloodDown").css("color","red")
        }else {
            $("#rightBloodDown").css("color","black")
        }
    });

	return {
		setContentStyle:setContentStyle,
		initContentStyle:initContentStyle
	};
})();
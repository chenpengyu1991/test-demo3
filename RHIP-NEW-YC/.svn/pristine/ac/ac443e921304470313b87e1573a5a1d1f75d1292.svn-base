var cdmPersonPhyExamAdd = (function()
{
	var isIndex=$("#hm-person-phyexam-index-add").val();
	var isInfo=$("#isInfo").val();
	
	var validate = null;
	$(function()
	{
		validate = $("#hm-person-phyexam-form").easyValidate();
		validate.addExtension("healthGuidanceVali",healthGuidanceVali);
		validate.addExtension("riskFactorVali",riskFactorVali);
		validate.addExtension("FastingBloodVali",FastingBloodVali);
		enableChangeConfirm();
		$("#hm-phyexam-add-back-btn").on("click", function () {
			layer.confirm("确认离开？",function(index){
				layer.close(index);
				back();
			});
		});
		$("#hm-phyexam-add-save-btn").on("click", save);

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

		showst("healthEvaluateAnomalyFlg", "ttb30");
		showst("diabetesMellitusFlag", "hypertensionLevelTr");
		showst("hypertensionFlag", "hypertensionFlag");

		initContentStyle("smodeStatusCode","smokePerDaySpan:beginSmokeAgeSpan:endSmokeAgeSpan",1);
		initContentStyle("trainFrequencyTypeCode","exerciseTypeSpan:keepTimeSpan:exerciseTimeSpan",4);
		initContentStyle("drinkFrequency","wineTypeSpan:isDrunkSpan:beginDrinkingAgeSpan:isEndDrinkingSpan:drinkingPerDaySpan",1);
		initContentStyle("dietHunsuEquilibrium","",1);
		validate.addExtension("otherTrainWayVali",otherTrainWayVali);

		toggleOther('dreCheckResultType','dreCheckResultType_Span',9);
		$("#hm-phyexam-pre-btn").on("click", function(){
			var personId = $("#personid_prephyexam").val();
			//先检查有无做过体检
			$.getJsonByUrl({
				url : "/hm/manage/hasExam",
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

		$("input[name='trainingWay']").on("click", function(){
			dic_other("trainingWay", "other_train_way_span", "otherTrainingWay");
		});
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
		
		
		var trainingWayCode = $("#text_trainingWay").val();
		if(trainingWayCode.indexOf("14") != -1){
			$("#other_train_way_span").css("display","inline");
		}else {
			$("#other_train_way_span").css("display","none");
		}

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

		checkExam();
	});

	//检查输入项是否符合正常值范围=====start===
	//血红蛋白
	$("#hemoglobinValue").on("blur", function()
	{
		checkUnusual('hemoglobinValue',"110","160","");
	});
	//白细胞
	$("#leukocyteCount").on("blur", function()
	{
		checkUnusual('leukocyteCount',"4","10","");
	});

	//血小板
	$("#plateletCount").on("blur", function()
	{
		checkUnusual('plateletCount',"100","300","");
	});

	//尿蛋白
	$("#urineProQuantitativeValue").on("blur", function()
	{
		checkUnusual('urineProQuantitativeValue',"","","-");
	});

	//尿糖
	$("#urineSugQuantitativeValue").on("blur", function()
	{
		checkUnusual('urineSugQuantitativeValue',"","","-");
	});

	//尿酮体
	$("#ketQuantitativeValue").on("blur", function()
	{
		checkUnusual('ketQuantitativeValue',"","","-");
	});

	//尿潜血
	$("#eryQuantitativeValue").on("blur", function()
	{
		checkUnusual('eryQuantitativeValue',"","","-");
	});

	//空腹血糖
	$("#bloodGlucoseLeft").on("blur", function()
	{
		checkUnusual('fpgMmol',"4","6.4","");
	});

	//尿微量血蛋白
	$("#urineMicroTongAlbumin").on("blur", function()
	{
		checkUnusual('urineMicroTongAlbumin',"0","20","");
	});

	//糖化血红蛋白
	$("#hgb").on("blur", function()
	{
		checkUnusual('hgb',"4。8","6","");
	});

	//血清谷丙转氨酶
	$("#serumGptValue").on("blur", function()
	{
		checkUnusual('serumGptValue',"0","32","");
	});

	//血清谷草转氨酶
	$("#serumAstValue").on("blur", function()
	{
		checkUnusual('serumAstValue',"0","31","");
	});

	//白蛋白浓度
	$("#albuminConcentration").on("blur", function()
	{
		checkUnusual('albuminConcentration',"35","50","");
	});

	//总胆红素
	$("#totalBilirubin").on("blur", function()
	{
		checkUnusual('totalBilirubin',"1.71","26","");
	});

	//结合胆红素
	$("#conjugatedBilirubin").on("blur", function()
	{
		checkUnusual('conjugatedBilirubin',"0","6.8","");
	});

	//血清肌酐
	$("#creatinine").on("blur", function()
	{
		checkUnusual('creatinine',"44","106","");
	});

	//血尿素氮
	$("#bloodUreaNitrogenValue").on("blur", function()
	{
		checkUnusual('bloodUreaNitrogenValue',"1.7","8.3","");
	});

	//血钾浓度
	$("#potassiumConcentration").on("blur", function()
	{
		checkUnusual('potassiumConcentration',"3.5","5.5","");
	});

	//血钠浓度
	$("#sodiumConcentration").on("blur", function()
	{
		checkUnusual('sodiumConcentration',"135","145","");
	});

	//总胆固醇
	$("#tc").on("blur", function()
	{
		checkUnusual('tc',"3","5.2","");
	});

	//甘油三酯
	$("#triglycerideValue").on("blur", function()
	{
		checkUnusual('triglycerideValue',"0.45","1.7","");
	});

	//血清低密度脂蛋白胆固醇
	$("#ldlcDetectValue").on("blur", function()
	{
		checkUnusual('ldlcDetectValue',"2.07","3.12","");
	});

	//血清高密度脂蛋白胆固醇
	$("#hdlcDetectValue").on("blur", function()
	{
		checkUnusual('hdlcDetectValue',"0.94","2.0","");
	});

//检查输入项是否符合正常值范围=====end===

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

	function dic_other(dicName, hiddenId, otherName){
		if($("input[name='" + dicName + "']:last").is(":checked")){
			$("#" + hiddenId).css("display","inline");
		}else {
			$("input[name='" + otherName + "']").attr("value", "");
			$("#" + hiddenId).css("display","none");
		}
	}

	function initContentStyle(name, ids,disabledVal)
	{
		var array = ids.split(":");

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
    		
    	} else if(name=='drinkFrequency'){
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
    		
    	} else if(name=='smodeStatusCode'){
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
    		
    	} else {
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
	}

	function setContentStyleSport(obj,ids){
		var array=ids.split(":");
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
	}
	function setContentStyle(obj,ids){
		var array=ids.split(":");
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
			var bmi = (weight / (height * height)).toFixed(2);
			$("#personBMIId").attr("value", bmi);
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
		} else{
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
		if(isInfo){
			$("#hm-manage-list-box").show();
			$("#hm-manage-input-box").hide();
		}else{
			$("#hm-person-phyexam-list-box").show();
			$("#hm-person-phyexam-input-box").hide();
		}
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
		
		// if($("#CMedicine").is(":hidden")){
		// 	 msgUtil.alert("中医体质辨识必须填写！");
		// 	 return false;
		//  }
/*
		var description = "";
		for (var i = 0; i < 4; i++) {
			var des = $("#anomalyDesc" + i).val();
			if (des != "") {
				description += des + ";";
			}
		}
		if (description != "") {
			description = description.substring(0, description.length - 1);
		}*/
		$("input[name='tcmPeacefulQuality']").removeAttr("disabled");
		$("input[name='tcmQiQuality']").removeAttr("disabled");
		$("input[name='tcmYangQuality']").removeAttr("disabled");
		$("input[name='tcmYinDeficiency']").removeAttr("disabled");
		$("input[name='tcmPhlegmWetness']").removeAttr("disabled");
		$("input[name='tcmHeatMedium']").removeAttr("disabled");
		$("input[name='tcmBloodQuality']").removeAttr("disabled");
		$("input[name='tcmQiStagnation']").removeAttr("disabled");
		$("input[name='tcmSpecialQuality']").removeAttr("disabled");
		// 保存
		var healthAbnormal1 = $("#healthAbnormal1").val();
		var healthAbnormal2 = $("#healthAbnormal2").val();
		var healthAbnormal3 = $("#healthAbnormal3").val();
		var healthAbnormal4 = $("#healthAbnormal4").val();
		$("#hm-person-phyexam-form").submitFormGetJson({
			url : "/hm/manage/save",
			wait : true,
			param:{
				healthAbnormal1:healthAbnormal1,
				healthAbnormal2:healthAbnormal2,
				healthAbnormal3:healthAbnormal3,
				healthAbnormal4:healthAbnormal4
				/*anomalyDesc: description*/
			},
			callback : function(data)
			{
				layui.use('layer', function(){
        			var layer = layui.layer;
        			if (data == true)
        			{
        				var index = layer.alert("保存成功！", {icon:0,title:'提示'}, function() {
        					layer.close(index);
        					doBack();
        					if(isInfo){
        						hmManageSearch.search(1);
        					}else{
        						hmPersonPhyExaminationList.search(1);
        					}
        				});
        			} else
        			{
        				layer.alert("保存失败！", {icon:0,title:'提示'});
        			}
        			
        		});
			}
		});

	}

	/*function calculateAssessment() {
		var score = toNumber($(":checked[name='eatingAssessment']").val()) + toNumber($(":checked[name='cleaningAssessment']").val())
			+ toNumber($(":checked[name='clothingAssessment']").val()) + toNumber($(":checked[name='defecationAssessment']").val())
			+ toNumber($(":checked[name='exerciseAssessment']").val());
		if (score >= 0 && score <= 3) {
			$(":radio[name='lifeAbilitySelfAssessment'][value='1']").attr("checked", "checked");
		} else if (score >= 4 && score <= 8) {
			$(":radio[name='lifeAbilitySelfAssessment'][value='2']").attr("checked", "checked");
		} else if (score >= 9 && score <= 18) {
			$(":radio[name='lifeAbilitySelfAssessment'][value='3']").attr("checked", "checked");
		} else {
			$(":radio[name='lifeAbilitySelfAssessment'][value='4']").attr("checked", "checked");
		}
	}*/
	
	
	function calculateAssessment() {
		var score = toNumber($(":checked[name='eatingAssessment']").val()) + toNumber($(":checked[name='cleaningAssessment']").val())
			+ toNumber($(":checked[name='clothingAssessment']").val()) + toNumber($(":checked[name='defecationAssessment']").val())
			+ toNumber($(":checked[name='exerciseAssessment']").val());
		if (score >= 0 && score <= 3) {
			$(":radio[name='lifeAbilitySelfAssessment'][value='1']").click();
		} else if (score >= 4 && score <= 8) {
			$(":radio[name='lifeAbilitySelfAssessment'][value='2']").click();
		} else if (score >= 9 && score <= 18) {
			$(":radio[name='lifeAbilitySelfAssessment'][value='3']").click();
		} else {
			$('input:radio[name="lifeAbilitySelfAssessment"]').eq(3).click();
			$(":radio[name='lifeAbilitySelfAssessment'][value='4']").click();
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

	function loderPrePhyExam(ehrId) {
		var index = layer.confirm("确定要覆盖页面上所有数据吗？", {icon:2, title:'确认提示'}, function(){
			var personId = $("#personid_prephyexam").val();
			$("#hm-phyexam-main").empty();
			var loadHtmlByUrlOption = {
				url: "/hm/manage/edit",
				insertDiv: "hm-phyexam-main",
				param: {personId: personId,loadPrePhyexamFlag:"load",ehrId:ehrId}
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
			$("#hm-phyexam-pre-btn").attr("disabled",true);
			$("#hm-phyexam-pre-btn").addClass('layui-btn-disabled');
			layer.close(index);
		});
	}


	return {
		setContentStyleSport:setContentStyleSport,
		setContentStyle:setContentStyle,
		initContentStyle:initContentStyle,
		calculateAssessment: calculateAssessment
	};
})();
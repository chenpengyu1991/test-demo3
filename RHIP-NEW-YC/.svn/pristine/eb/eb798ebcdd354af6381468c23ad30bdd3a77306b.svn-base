var rabies = (function() {
	$(function() {
		caseEdit.toggerAddress();
		//toggleOnes('infectionSourceRoute.afterWounding','afterWoundingDiv','2,3,4,5,99');
		/*2.6.2处理单位*/
		$(":input[name='exposureHistory.handlingUnit']").change(function() {
			toggleOtherSC('exposureHistory.handlingUnit', 'handlingUnit', 99);
		});
		toggleOtherSC('exposureHistory.handlingUnit', 'handlingUnit', 99);
		/*2.3暴露方式*/
		$(":input[name='exposureHistory.exposureWay']").change(function() {
			toggleOtherSC('exposureHistory.exposureWay', 'exposureWayOther', 99);
		});
		toggleOtherSC('exposureHistory.exposureWay', 'exposureWayOther', 99);
		/*5. 职业：*/
		$(":input[name='generalCondition.occupation']").change(function() {
			toggleOtherSC('generalCondition.occupation', 'occupationOther', 'CV020120299');
		});
		toggleOtherSC('generalCondition.occupation', 'occupationOther', 'CV020120299');
		/* 暴露及伤口处理情况 */
		$(":input[name='exposureHistory.woundManagement']").change(function() {
			toggleOtherSCByClass('exposureHistory.woundManagement', 'wound', 1);
            toggleOtherSC('exposureHistory.woundManagement', 'idmWoundManagement',1);
		});
		toggleOtherSCByClass('exposureHistory.woundManagement', 'wound', 1);
        toggleOtherSC('exposureHistory.woundManagement', 'idmWoundManagement',1);
		/*免疫史*/
		$(":input[name='exposureHistory.immunizationHistory']").change(function(){
			hideClassByClass('exposureHistory.immunizationHistory', 'immunizationHistory', 1);
		});
		hideClassByClass('exposureHistory.immunizationHistory', 'immunizationHistory', 1);
		/*暴露后抗血清注射*/
		$(":input[name='exposureHistory.antiserumInjection']").change(function(){
			hideClassByClass('exposureHistory.antiserumInjection', 'antiserumInjection', 1);
            toggleOther('exposureHistory.antiserumInjection', 'idmAntiserumInjection', 2);
		});
		hideClassByClass('exposureHistory.antiserumInjection', 'antiserumInjection', 1);
        toggleOther('exposureHistory.antiserumInjection', 'idmAntiserumInjection', 2);
		/*暴露后人用狂犬病疫苗注射*/
		$(":input[name='exposureHistory.rabiesVaccination']").change(function(){
			hideClassByClass('exposureHistory.rabiesVaccination', 'rabiesVaccination', 1);
			toggleOtherSC('exposureHistory.rabiesVaccinationUnit','rabiesVaccinationUnitOther',99);
            toggleOther('exposureHistory.rabiesVaccination','idmRabiesVaccination',2);
		});
		hideClassByClass('exposureHistory.rabiesVaccination', 'rabiesVaccination', 1);
        toggleOther('exposureHistory.rabiesVaccination','idmRabiesVaccination',2);
		/*是否加强注射*/
		$(":input[name='exposureHistory.rabiesVaccinationReinforced']").change(function(){
			hideClassByClass('exposureHistory.rabiesVaccinationReinforced', 'rabiesVaccinationReinforced', 1);
		});
		hideClassByClass('exposureHistory.rabiesVaccinationReinforced', 'rabiesVaccinationReinforced', 1);
		/*注射单位*/
		$(":input[name='exposureHistory.rabiesVaccinationUnit']").change(function(){
			toggleOtherSC('exposureHistory.rabiesVaccinationUnit','rabiesVaccinationUnitOther',99);
		});
		toggleOtherSC('exposureHistory.rabiesVaccinationUnit','rabiesVaccinationUnitOther',99);
		/* 4.3诊断单位 */
		$(":input[name='clinicalManifestations.orgDiagnosticsSelect']").change(function() {
			toggleOtherSC('clinicalManifestations.orgDiagnosticsSelect', 'orgDiagnosticsWrite', 99);
		});
        toggleOtherSC('clinicalManifestations.orgDiagnosticsSelect', 'orgDiagnosticsWrite', 99);
		/*6.1动物种类：*/
		$(":input[name='infectionSourceRoute.animalCategory']").change(function() {
			toggleOtherSC('infectionSourceRoute.animalCategory', 'animalCategoryOther', 99);
		});
		toggleOtherSC('infectionSourceRoute.animalCategory', 'animalCategoryOther', 99);
		/*6.2伤人动物来源：*/
		$(":input[name='infectionSourceRoute.animalSource']").change(function() {
			toggleOtherSC('infectionSourceRoute.animalSource', 'animalOther', 99);
		});
		toggleOtherSC('infectionSourceRoute.animalSource', 'animalOther', 99);
		/*6.3若为家养动物，是否接种兽用狂犬病疫苗：*/
		$(":input[name='infectionSourceRoute.hydrophobiaVaccine']").change(function() {
			hideClassByClass('infectionSourceRoute.hydrophobiaVaccine', 'hydrophobiaVaccineDt', 1);
		});
		hideClassByClass('infectionSourceRoute.hydrophobiaVaccine', 'hydrophobiaVaccineDt', 1);
		/*6.4动物伤人原因：*/
		$(":input[name='infectionSourceRoute.woundCause']").change(function() {
			toggleOtherSC('infectionSourceRoute.woundCause','woundCauseOther',99);
		});	
		toggleOtherSC('infectionSourceRoute.woundCause','woundCauseOther',99);
		/*6.6伤人后：
		$(":input[name='infectionSourceRoute.afterWounding']").change(function() {
			toggleOtherSC('infectionSourceRoute.afterWounding', 'afterWoundingOther', 99);
		});	
		toggleOtherSC('infectionSourceRoute.afterWounding', 'afterWoundingOther', 99);*/
		/*6.6.2动物死后处理方式：*/
		/*$(":input[name='infectionSourceRoute.afterDeathWay']").change(function() {
			toggleOtherSC('infectionSourceRoute.afterDeathWay','afterDeathWayOther',99);
		});*/
		
		/*toggleOtherSC('infectionSourceRoute.afterDeathWay','afterDeathWayOther',99);*/
		/*3.2.4有无过敏：*/
		$(":input[name='exposureHistory.irritability']").change(function() {
			hideClassByClass('exposureHistory.irritability', 'irritabilityDetail', 1);
		});
		hideClassByClass('exposureHistory.irritability', 'irritabilityDetail', 1);
        /*6.6伤人后*/
        $(":input[name='infectionSourceRoute.afterWounding']").change(function() {
           hideOtherSCByClass('infectionSourceRoute.afterWounding','afterDeathWay');
        });
        hideOtherSCByClass('infectionSourceRoute.afterWounding','afterDeathWay');
        $(":input[name='infectionSourceRoute.afterWounding']").change(function() {
            hideOtherSCByClass('infectionSourceRoute.afterWounding','afterDeathWay');
        });
        hideOtherSCByClass('infectionSourceRoute.afterWounding','afterDeathWay');
        $(":input[name='infectionSourceRoute.afterWounding']").change(function() {
            hideOtherSCByClass('infectionSourceRoute.afterWounding','afterDeathWay');
        });
        hideOtherSCByClass('infectionSourceRoute.afterWounding','afterDeathWay');
        /*2.6.3处理方式（可多选）*/
        $(":input[name='exposureHistory.handlingWay']").change(function() {
            toggleOtherCK('exposureHistory.handlingWay','idmHandlingWayOther', 99);
        });
        toggleOtherCK('exposureHistory.handlingWay','idmHandlingWayOther', 99);
        toggleOther('exposureHistory.immuneProcedure','immuneProcedureOtherDiv',2);
        toggleOnes('infectionSourceRoute.afterWounding','afterWoundingDiv','2,3,4,5,99');
    });

	/*
	 * 选择其他时，显示其他输入框 radioName：radio的name otherClass:otherClass,将要隐藏的类内容
	 * code:code之为radio的选择值时候，那么就执行隐藏
	 */
	function hideClassByClass(name, otherClass, code) {
		var raValue = $('input[name="' + name + '"]:checked').val();
		if (raValue == code) {
			$("." + otherClass).show();
			$("." + otherClass).find("input").each(function() {
				$(this).show();
			});
		} else {
			$("." + otherClass).hide();
			$("." + otherClass).find("input[type=text]").each(function() {
				$(this).val('');
			});
			$("." + otherClass).find("input[type=radio]").each(function() {
				$(this).attr("checked", false);
			});
			$("." + otherClass).find("input[type=checkbox]").each(function() {
				$(this).attr("checked", false);
			});
			$("." + otherClass).find("select").each(function() {
				$(this).val('');
			});
		}
	}

    /*选择所选项时候，隐藏一类元素
     * sCName:select的name
     * otherClass:class,其他类输入框等放在其中
     * code:当前选中的选中值等于code时显示otheClass
     */

    function hideOtherSCByClass(sCName,otherClass){
        var raValue = $("select[name=\'" + sCName + "\']").find("option:selected").val();
        if(raValue == 2 || raValue == 4 || raValue == 5) {
            $("." + otherClass).show();
            $("." + otherClass).find("input").each(function() {
                $(this).show();
            });
        }else{
            $("." + otherClass).hide();
            $("." + otherClass).find("input[type=text]").each(function(){
                $(this).val('');
            });
            $("." + otherClass).find("input[type=radio]").each(function(){
                $(this).attr("checked",false);
            });
            $("." + otherClass).find("input[type=checkbox]").each(function(){
                $(this).attr("checked",false);
            });
            $("." + otherClass).find("select").each(function(){
                $(this).val('');
            })
        }
    }
    
    /*
     * 选择其他时，显示其他输入框 radioName：radio的name otherId:DivId,其他输入框等放在Div中
     * code:当当前选中的radio的值与是code包含的任意值时显示otherId
     */
    function toggleOnes(radioName, otherId, code)
    {
    	var raValue = $('input[name="' + radioName + '"]:visible:checked').val();
    	if (code.indexOf(raValue) != -1)
    	{
    		$("#" + otherId).show();
    		$("#" + otherId).find("input").each(function()
    		{
    			$(this).show();
    		});
    	} else
    	{
    		$("#" + otherId).hide();
    		$("#" + otherId).find("input[type=text]").each(function()
    		{
    			$(this).val('');
    		});
    		$("#" + otherId).find("input[type=radio]").each(function()
    		{
    			$(this).attr("checked", false);
    		});
    		$("#" + otherId).find("input[type=checkbox]").each(function()
    		{
    			$(this).attr("checked", false);
    		});
    		$("#" + otherId).find("select").each(function()
    		{
    			$(this).val('');
    		});
    	}	
    }
    return {
        toggleOnes:toggleOnes
    };
})();
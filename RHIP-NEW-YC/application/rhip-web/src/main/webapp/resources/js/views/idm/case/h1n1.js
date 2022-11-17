var h1n1Case = (function() {
	$(function() {
        $.Placeholder.init({query:"#idCard",callback:function(element){
        	idCard.queryPerson($(element).val());
        }});
		toggleOtherSCH1n1();
		toggleOther('generalCondition.unitFlag','unitNameTb',1);
		toggleOther('clinicalManifestations.fever','temperature',1);
		toggleOther('pastHistory.pregnancyFlg','gestation',1);
		toggleOther('pastHistory.influenzaVaccine','influenzaVaccineDate',1);
		toggleOther('pastHistory.smokeFlg','smokeDayCount',1);
		
		toggleOther('attackCondition.takeAntiviralDrug','takeAntiviralDrugTr',1);
		toggleOther('attackCondition.antiviralDrugName','antiviralDrugOther',99);
		toggleOther('attackCondition.takeTamiflu','takeTamifluTr',1);
		toggleOther('attackCondition.sideEffect','sideEffectExpression',1);
		toggleOther('attackCondition.takeOtherAntiviralDrug','otherAntiviralDrugName',1);
		toggleOther('attackCondition.assistedVentilation','assistedVentilationType',1);
		toggleOther('attackCondition.assistedVentilationType','assistedVentilationOther',99);
		toggleOther('attackCondition.takeAntibiotic','antibioticName',1);
		toggleOther('exposureHistory.caseArea','caseAreaAddr',1);
		toggleOtherCK('exposureHistory.contactWay','contactWayOther',99);
		toggleOther('exposureHistory.conservatoryMeasureWay','conservatoryMeasureWayOther',99);
		toggleOtherCK('epidemicFocusClose.isGoPlace','pubPlaNameAddr',99);
		toggleOther('epidemicFocusClose.isAgenda','isAgendaTr',1);
		toggleOther('epidemicFocusClose.isContacts','isContactsTr',1);
		toggleOther('otherCondition.cureFlg','cureDate',1);
		toggleOther('otherCondition.deathFlg','deathTime',1);
		toggleOther('otherCondition.inpatientFlg','inpatientFlgTd',1);
		toggleOtherCK('epidemicFocusClose.trafficToolsBefore','trafficToolsBeOthTr',99);
		toggleOther('clinicalManifestations.otherSelect','otherSpan',1);
		toggleOther('pastHistory.pnuImuneFlg','pnuImuneDate',1);
		toggleOther('epidemicFocusClose.isFeverRespiratory','isFeverRespiratoryNum',1);
		toggleOtherSC('generalCondition.occupation','occupationOtherPart','CV020120299');
		toggleOther('exposureHistory.conservatoryMeasure','conservatoryMeasureWay',1);
		
        caseEdit.toggerAddress();
		showInput();
		initChange();
	});
	function initChange(){
		$("#nationality_h1n1").change(toggleOtherSCH1n1);
		$("#floatPopulation_h1n1").change(caseEdit.toggerAddress);
		$("input[name='generalCondition.unitFlag']").change(function(){
			toggleOther('generalCondition.unitFlag','unitNameTb',1);
		});
		$("input[name='generalCondition.occupation']").change(function(){
			toggleOtherSC('generalCondition.occupation','occupationOtherPart','CV020120299');
		});
		$("input[name='clinicalManifestations.fever']").change(function(){
			toggleOther('clinicalManifestations.fever','temperature',1)
		});
		$("input[name='clinicalManifestations.otherSelect']").change(function(){
			toggleOther('clinicalManifestations.otherSelect','otherSpan',1);
		});
		$("input[name='pastHistory.pregnancyFlg']").change(function(){
			toggleOther('pastHistory.pregnancyFlg','gestation',1);
		});
		$("input[name='pastHistory.smokeFlg']").change(function(){
			toggleOther('pastHistory.smokeFlg','smokeDayCount',1);
		});
		$("input[name='pastHistory.pnuImuneFlg']").change(function(){
			toggleOther('pastHistory.pnuImuneFlg','pnuImuneDate',1);
		});
		$("input[name='pastHistory.influenzaVaccine']").change(function(){
			toggleOther('pastHistory.influenzaVaccine','influenzaVaccineDate',1)
		});
		$("input[name='attackCondition.takeAntiviralDrug']").change(function(){
			toggleOther('attackCondition.takeAntiviralDrug','takeAntiviralDrugTr',1);
		});
		$("input[name='attackCondition.antiviralDrugName']").change(function(){
			toggleOther('attackCondition.antiviralDrugName','antiviralDrugOther',99)
		});
		$("input[name='attackCondition.takeTamiflu']").change(function(){
			toggleOther('attackCondition.takeTamiflu','takeTamifluTr',1);
		});
		$("input[name='attackCondition.sideEffect']").change(function(){
			toggleOther('attackCondition.sideEffect','sideEffectExpression',1)
		});
		$("input[name='attackCondition.takeOtherAntiviralDrug']").change(function(){
			toggleOther('attackCondition.takeOtherAntiviralDrug','otherAntiviralDrugName',1);
		});
		$("input[name='attackCondition.assistedVentilation']").change(function(){
			toggleOther('attackCondition.assistedVentilation','assistedVentilationType',1);
		});
		$("input[name='attackCondition.assistedVentilationType']").change(function(){
			toggleOther('attackCondition.assistedVentilationType','assistedVentilationOther',99);
		});
		$("input[name='attackCondition.takeAntibiotic']").change(function(){
			toggleOther('attackCondition.takeAntibiotic','antibioticName',1)
		});
		$("input[name='exposureHistory.caseArea']").change(function(){
			toggleOther('exposureHistory.caseArea','caseAreaAddr',1);
		});
		$("input[name='exposureHistory.contactWay']").change(function(){
			toggleOtherCK('exposureHistory.contactWay','contactWayOther',99)
		});
		$("input[name='exposureHistory.conservatoryMeasure']").change(function(){
			toggleOther('exposureHistory.conservatoryMeasure','conservatoryMeasureWay',1);
		});
		$("input[name='exposureHistory.conservatoryMeasureWay']").change(function(){
			toggleOther('exposureHistory.conservatoryMeasureWay','conservatoryMeasureWayOther',99);
		});
		$("input[name='exposureHistory.hnLab']").change(function(){
			toggleOther('exposureHistory.hnLab','conservatoryMeasureLab',1);
		});
		$("input[name='epidemicFocusClose.isGoPlace']").change(function(){
			toggleOtherCK('epidemicFocusClose.isGoPlace','pubPlaNameAddr',99);
		});
		$("input[name='epidemicFocusClose.isAgenda']").change(function(){
			toggleOther('epidemicFocusClose.isAgenda','isAgendaTr',1);
		});
		$("input[name='epidemicFocusClose.trafficToolsBefore']").change(function(){
			toggleOtherCK('epidemicFocusClose.trafficToolsBefore','trafficToolsBeOthTr',99)
		});
		$("input[name='epidemicFocusClose.isContacts']").change(function(){
			toggleOther('epidemicFocusClose.isContacts','isContactsTr',1);
		});
		$("input[name='epidemicFocusClose.isFeverRespiratory']").change(function(){
			toggleOther('epidemicFocusClose.isFeverRespiratory','isFeverRespiratoryNum',1);
		});
		$("input[name='otherCondition.cureFlg']").change(function(){
			toggleOther('otherCondition.cureFlg','cureDate',1);
		});
		
		$("input[name='otherCondition.deathFlg']").change(function(){
			toggleOther('otherCondition.deathFlg','deathTime',1);
		});
		$("input[name='otherCondition.inpatientFlg']").change(function(){
			toggleOther('otherCondition.inpatientFlg','inpatientFlgTd',1);
		});
		$("input[name='diagnosis.diagnosisType']").change(function(){
			showInput();
		});
	}
	function showInput() {
		var diagnosisType = $("input[name='diagnosis.diagnosisType']:checked").val();
		if(diagnosisType=='1'){
			$("#doubtfulDtT").show();
			$("#diagnosisDtT").hide();
			$("#excludeDtT").hide();
			$("#diagnosisDtT").val('');
			$("#excludeDtT").val('');
			$("#diagnosisDiseaseT").val('');
		} else if(diagnosisType=='2'){
			$("#doubtfulDtT").hide();
			$("#diagnosisDtT").show();
			$("#excludeDtT").hide();
			$("#doubtfulDtT").val('');
			$("#excludeDtT").val('');
			$("#diagnosisDiseaseT").val('');
		} else if(diagnosisType=='3'){
			$("#doubtfulDtT").hide();
			$("#diagnosisDtT").hide();
			$("#excludeDtT").show();
			$("#doubtfulDtT").val('');
			$("#diagnosisDtT").val('');
		}
	}
	
	function toggleOtherSCH1n1(){
	    var raValue = $("select[name=\'generalCondition.nationality\']").find("option:selected").val();
	    if(raValue == 44){
	        $("#nation").show();
	        $("#nationOther").hide();
	    }else{
    	   $("#nationOther").show();
	       $("#nation").hide();
	    }
	}
	
	return {
		showInput:showInput,
		toggleOtherSCH1n1:toggleOtherSCH1n1
	};
})();





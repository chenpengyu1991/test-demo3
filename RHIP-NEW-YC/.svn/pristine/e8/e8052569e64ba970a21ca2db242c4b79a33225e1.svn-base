
var hcvCase = (function() {
	$(function() {
		 /*职业*/
		toggleOtherSC('generalCondition.occupation','spanOccupation','CV020120299');
		 /*婚姻状况*/
		toggleOther('generalCondition.marriage','divMarriage','20');
		 /*乙肝疫苗接种史*/
		 toggleOther('epidemiologicalSurvey.hepatitisBVaccine','trHepatitis','1');
		 /*住院*/
		 toggleInHospital();
		 /*手术*/
		 toggleOperation();	
		 /*受血史*/
		 toggleReBlood();	
		 /*献血史*/
		 toggleDoBlood();
		 /*静脉输液*/
		 toggleOther('exposureHistory.ivt','divIvtUnit','1');
		 /*针灸治疗*/
		 toggleOther('exposureHistory.acupuncture','divAcupuncture','1');
		 /*肌肉、静脉注射*/
		 toggleInjection();
		 /*预防接种*/
		 toggleVaccination();
		 /*家庭内乙肝病人或HBV携带者*/
		 toggleOther('exposureHistory.hbv','divHbv','1');
         /*拔牙*/
         toggleOther('exposureHistory.tooth','toothPart',1);
         caseEdit.toggerAddress()
	});
	/*住院*/
	function toggleInHospital(){
		toggleOther('exposureHistory.inHospital','trInHospital1','1');
		toggleOther('exposureHistory.inHospital','trInHospital2','1');
	}
	/*手术*/
	function toggleOperation(){
		toggleOther('exposureHistory.operation','trOperation1','1');	
		toggleOther('exposureHistory.operation','trOperation2','1');	
	}
	
	/*受血史*/
	function toggleReBlood(){
		toggleOther('exposureHistory.receptionBloodHistory','trBloodHistory1','1');	
		toggleOther('exposureHistory.receptionBloodHistory','trBloodHistory2','1');	
	}
	
	/*献血史*/
	function toggleDoBlood(){
		toggleOther('exposureHistory.donateBloodHistory','trDonateHistory1','1');
		toggleOther('exposureHistory.donateBloodHistory','trDonateHistory2','1');
	}
	
	/*肌肉、静脉注射*/
	function toggleInjection(){
		toggleOther('exposureHistory.intravenousInjection','trInjection1','1');
		toggleOther('exposureHistory.intravenousInjection','trInjection2','1');
	}
	
	 /*预防接种*/
	function toggleVaccination(){
		 toggleOther('exposureHistory.vaccination','trVaccination1','1');
		 toggleOther('exposureHistory.vaccination','trVaccination2','1');		 
	}
	return {
		toggleInHospital:toggleInHospital,
		toggleOperation:toggleOperation,
		toggleReBlood:toggleReBlood,
		toggleDoBlood:toggleDoBlood,
		toggleInjection:toggleInjection,
		toggleVaccination:toggleVaccination
	};
})();


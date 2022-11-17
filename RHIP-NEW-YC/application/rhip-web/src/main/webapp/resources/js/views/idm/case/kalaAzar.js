
var anthraxCase = (function() {
	
	$(function() {
        $.Placeholder.init({query:"#idCard",callback:function(element){
            idCard.queryPerson($(element).val());
        }});
		toggleOther('clinicalManifestations.anthraxCarb','anthraxCarbNum',1);
		toggleOther('clinicalManifestations.malEdema','malEdemaParts',1);
		toggleOther('clinicalManifestations.anthraxClinManifThr','bleedingVolume',4);
		toggleOther('epidemiologicalSurvey.anthrax','anthraxDt',1);
		toggleOther('epidemiologicalSurvey.anthraxVaccination','anthraxVaccinationDt',1);
		toggleOtherSC('generalCondition.occupation','occupationOtherPart','CV020120299');
		toggleOther('epidemiologicalSurvey.wildlifeContactHistory','contactWildlife',1);
        toggleOther('epidemiologicalSurvey.outHistory','outHistoryTd',1);
		caseEdit.toggerAddress();
	});
})();





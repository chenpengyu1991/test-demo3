
var rubellaCase = (function() {
	$(function() {
		caseEdit.toggerAddress();
		toggleOther('generalCondition.floatPopulation','spanHrhouseNumber',2);
		toggleOther('clinicalManifestations.fever','divFever','1');
		toggleOther('epidemiologicalSurvey.eruptionContact','divContact','1');
		toggleOther('attackCondition.isDeath','isDeath','1');
		toggleOther('otherCondition.caseType','caseType','3');
		toggleOther('epidemiologicalSurvey.measlesOutbreakCase','measlesOutbreakCase','2');
		
	});
	return {};
})();


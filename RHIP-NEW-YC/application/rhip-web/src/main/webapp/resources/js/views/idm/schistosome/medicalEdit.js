var medicalEdit = (function() {
	$(function() { 
		enableChangeConfirm();
		toggleOther('clinicalManifestations.isComplications','complications',1);
		toggleOtherCK('pastHistory.firstDiagnosisReason','firstDiagnosisReason',99);
		toggleOther('pastHistory.alimentaryCanal','alimentaryCanal',1);
		toggleOther('pastHistory.ascites','ascites',1);
		toggleOtherCK('clinicalManifestations.otherSelect','clinicalOtherId',1);
		toggleOther('otherCondition.caseTypeLast','caseTypeLast',1);	
        idmCommon.displayPaAddress();
        idmCommon.toggerAddress();
        schCommon.diabaleForm('reexamineMain');
	});
 	return {
	};
})();
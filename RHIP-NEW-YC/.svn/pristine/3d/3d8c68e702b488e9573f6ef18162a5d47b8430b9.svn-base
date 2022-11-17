var laxCase = (function() {
    $(function() {
        toggleOther('clinicalManifestations.fever','feverFromAdd',1);
        toggleOther('otherCondition.outcomeCode','deatha',4);
        toggleOtherSC('generalCondition.occupation','occupationPart','CV020120299');
        caseEdit.toggerAddress();
        $("input[name='clinicalManifestations.fever']").change(function(){
        	toggleOther('clinicalManifestations.fever','feverFromAdd',1);
		});
		$("input[name='generalCondition.floatPopulation']").change(function(){
			caseEdit.toggerAddress();
		});
		$("input[name='generalCondition.occupation']").change(function(){
			toggleOtherSC('generalCondition.occupation','occupationPart','CV020120299');
		});
    });
})();
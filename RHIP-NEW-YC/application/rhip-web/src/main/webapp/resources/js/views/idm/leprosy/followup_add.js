var followupAdd = (function() {
	$(function() {
        toggleOther('leprosy','leprosyType','1');
        toggleOtherSC('cureScheme','cureSchemeOther','99');
        toggleOther('neuritis1Drug','neuritis1DrugOth','99');
        toggleOther('neuritis2Drug','neuritis2DrugOth','99');
        toggleOther('neuritis3Drug','neuritis3DrugOth','99');
        toggleOther('reaction1Drug','reaction1DrugOth','99');
        toggleOther('reaction2Drug','reaction2DrugOth','99');
        toggleOther('reaction3Drug','reaction3DrugOth','99');
        toggleOtherSC('uneffectDrug','uneffectDrugOther','99');
        toggleOther('cureStep','cureStepOther','99');
        toggleOtherSC('dieReason','dieReasonOther','99');
	});
})();

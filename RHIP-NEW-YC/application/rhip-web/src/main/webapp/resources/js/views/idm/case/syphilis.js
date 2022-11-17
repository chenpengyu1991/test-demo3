var syphilisCase = (function() {
    $(function() {
        $.Placeholder.init({query:"#idCard",callback:function(element){
            idCard.queryPerson($(element).val());
        }});
        toggleOtherSC('generalCondition.occupation','occupationOtherPart','CV020120299');
        toggleOther('clinicalManifestations.otherThanSpotPimples','appearances',1);
        toggleOther('epidemiologicalSurvey.outHistory','outHistoryAddr',1);
        toggleOther('pastHistory.vdHistory','vdName',1);
        toggleOther('pastHistory.vdHistory','vdDatePart',1);
        toggleOther('pastHistory.spouseVdHistory','spouseVdName',1);
        toggleOther('pastHistory.spouseVdHistory','spouseVdDatePart',1);
        toggleOther('epidemiologicalSurvey.extramaritalSex','useCondom',1);
        toggleOther('epidemiologicalSurvey.extramaritalSex','lastExtramaritalSexDays',1);
        caseEdit.toggerAddress();
    });

    return {
    };
})();
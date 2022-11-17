var laxCase = (function() {
    $(function() {
        $.Placeholder.init({query:"#idCard",callback:function(element){
            idCard.queryPerson($(element).val());
        }});
        toggleOther('clinicalManifestations.diarrhea','diarrheaPart',1);
        toggleOther('clinicalManifestations.vomit','vomitPart',1);
        toggleOther('clinicalManifestations.fever','feverPart',1);
        toggleOther('clinicalManifestations.stomachache','stomachachePart',1);
        toggleOther('infectionSourceRoute.sameDisease','sameDiseasePart',1);
        toggleOther('infectionSourceRoute.outHistory','outHistoryPart',1);
        toggleOther('infectionSourceRoute.outBackFood','outBackFoodPart',1);
        toggleOther('infectionSourceRoute.stranger','strangerPart',1);
        toggleOther('infectionSourceRoute.strangerSameDisease','strangerSameDiseasePart',1);
        toggleOther('infectionSourceRoute.contactSimilerPatient','contactSimilerPatientPart',1);
        toggleOther('beforeDiseaseDiet.eatSeaProducts','eatSeaProductsPart',1);
        toggleOther('beforeDiseaseDiet.suspiciousFood','suspiciousFoodPart',1);
        toggleOther('beforeDiseaseDiet.outsideDiningHistory','outsideDiningHistoryPart',1);
        toggleOtherSC('generalCondition.occupation','occupationOtherPart','CV020120299');
        toggleOther('beforeDiseaseDiet.edibleMethod','edibleMethodPart',99);
        toggleOther('beforeDiseaseDiet.dinnerHistory','dinnerHistoryPart',1);
        toggleOther('beforeDiseaseDiet.coldFood','suspiciousFoodPart1',1);
        toggleOther('beforeDiseaseDiet.cookedFoodColdEat','suspiciousFoodPart2',1);
        toggleOther('clinicalManifestations.fxFounder','fxOther',99);
        caseEdit.toggerAddress();
    });
})();

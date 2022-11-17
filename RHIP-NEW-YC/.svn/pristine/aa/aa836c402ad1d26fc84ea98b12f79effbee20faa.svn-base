var conjunctivitisCase = (function() {
    $(function() {
        $.Placeholder.init({query:"#idCard",callback:function(element){
            idCard.queryPerson($(element).val());
        }});
        toggleOtherSC('generalCondition.occupation','occupationOtherPart','CV020120299');
        toggleOther('epidemiologicalSurvey.bus','busPart',1);
        toggleOther('epidemiologicalSurvey.texi','texiNum',1);
        toggleOther('epidemiologicalSurvey.elevator','elevatorNum',1);
        toggleOther('epidemiologicalSurvey.restaurant','restaurantNum',1);
        toggleOther('epidemiologicalSurvey.ballroom','ballroomNum',1);
        toggleOther('epidemiologicalSurvey.cybercafe','cybercafeNum',1);
        toggleOther('epidemiologicalSurvey.bowling','bowlingNum',1);
        toggleOther('epidemiologicalSurvey.contactPatients','relationPatient',1);
        toggleOther('epidemiologicalSurvey.tel','telKind',1);
        toggleOther('epidemiologicalSurvey.computer','pcKind',1);
        caseEdit.toggerAddress();
    });

    /*隐藏、显示地址*/
//    function toggerAddress(){
//        debugger;
//        var value=$('input[name="generalCondition.patientAttribute"]:checked').val();
//
//        if('1' == value){
//            $("#pavillage_address").removeAttr("disabled");
//            $("#hrvillage_address").removeAttr("disabled");
//            $("#pastreet_address").removeAttr("disabled");
//            $('#patown_address').removeAttr("disabled");
//            $('#hrtown_address').removeAttr("disabled");
//            $('#spanPaNumber').text("门牌号");
//            $('#spanHrNumber').text("门牌号");
//            $('#pahouseNumber').attr({"style":"width:180px"});
//            $('#hrhouseNumber').attr({"style":"width:180px"});
//        }else{
//            $("#pavillage_address").attr("disabled", "disabled");
//            $("#pastreet_address").attr("disabled", "disabled");
//            $("#hrvillage_address").attr("disabled", "disabled");
//            $("#patown_address").attr("disabled", "disabled");
//            $("#hrtown_address").attr("disabled", "disabled");
//            $('#spanPaNumber').text("");
//            $('#spanHrNumber').text("");
//            $('#pahouseNumber').attr({'style':'width:90%'});
//            $('#hrhouseNumber').attr({'style':'width:90%'});
//        }
//        toggleOther('generalCondition.patientAttribute','pavillage_address','1');
//        toggleOther('generalCondition.patientAttribute','pastreet_address','1');
//        toggleOther('generalCondition.patientAttribute','patown_address','1');
//    }

    return {
//        toggerAddress:toggerAddress
    };
})();
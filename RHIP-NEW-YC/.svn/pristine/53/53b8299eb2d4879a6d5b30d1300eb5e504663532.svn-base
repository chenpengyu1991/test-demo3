var morbilliCase = (function() {
    $(function() {
//        var outbreakNo = $("#outbreakNoVal").val();
//        $("#outbreakNo1").val(outbreakNo.substr(0,6));
//        $("#outbreakNo2").val(outbreakNo.substr(6,4));
//        $("#outbreakNo3").val(outbreakNo.substr(10,3));
        $.Placeholder.init({query:"#idCard",callback:function(element){
            idCard.queryPerson($(element).val());
        }});

        toggleOther('clinicalManifestations.isComplications','complications',1);
        toggleOther('epidemiologicalSurvey.collectiveUnit','collectiveUnitName',1);
        toggleOther('clinicalManifestations.fever','hotDate',1);
        toggleOther('clinicalManifestations.rash','rashDate',1);
        toggleOther('epidemiologicalSurvey.dysenteryBeenHospital','dysenteryBeenHospitalName',1);
        toggleOther('epidemiologicalSurvey.labConfirmedCase','mrOther',99);
        //toggleOther('epidemiologicalSurvey.newOutbreak','outbreakNo',1);
        toggleOther('labExamine.serumSpecimenF','stomachachePart',1);
        toggleOther('labExamine.serumSpecimenF','serumSpecimenDtF',1);
        toggleOther('labExamine.serumSpecimenF','serumSpecimenS',1);
        toggleOther('labExamine.serumSpecimenS','serumSpecimenDtS',1);
        toggleOther('labExamine.etiologySpecimens','etiologySpecimensPart',1);
        toggleOther('labExamine.nasopharyngealSwab','nasopharyngealSwabDate',1);
        toggleOther('labExamine.urineAliquot','urineAliquotDate',1);
        toggleOther('labExamine.otherSpecimen','otherSpecimenDate',1);
        toggleOther('otherCondition.finalDiagnosis','outcomeCodeOther',99);
        toggleOther('epidemiologicalSurvey.local','otherLocal',99);
        toggleOther('generalCondition.hrPlace','otherHrPlace',99);
        toggleMeaslesvaccine('epidemiologicalSurvey.measlesvaccineIngredientsNum');
        toggleRubellavaccine('epidemiologicalSurvey.rubellavaccineIngredientsNum');
        toggleOtherCK('clinicalManifestations.complications','fxOtherMZ',99);
        caseEdit.toggerAddress();
    });

    /*隐藏、显示地址*/
//    function toggerAddress(){
//        var value=$('input[name="generalCondition.patientAttribute"]:checked').val();
//
//        if('1' == value){
//            $("#pavillage_address").removeAttr("disabled");
//            $("#hrvillage_address").removeAttr("disabled");
//            $('#patown_address').removeAttr("disabled");
//            $('#hrtown_address').removeAttr("disabled");
//            $('#spanPaNumber').text("门牌号");
//            $('#spanHrNumber').text("门牌号");
//            $('#pahouseNumber').attr({"style":"width:180px"});
//            $('#hrhouseNumber').attr({"style":"width:180px"});
//        }else{
//            $("#pavillage_address").attr("disabled", "disabled");
//            $("#hrvillage_address").attr("disabled", "disabled");
//            $("#patown_address").attr("disabled", "disabled");
//            $("#hrtown_address").attr("disabled", "disabled");
//            $('#spanPaNumber').text("详细地址");
//            $('#spanHrNumber').text("详细地址");
//            $('#pahouseNumber').attr({'style':'width:90%'});
//            $('#hrhouseNumber').attr({'style':'width:90%'});
//        }
//        toggleOther('generalCondition.patientAttribute','pavillage_address','1');
//        toggleOther('generalCondition.patientAttribute','patown_address','1');
//        toggleOther('generalCondition.patientAttribute','hrvillage_address','1');
//        toggleOther('generalCondition.patientAttribute','hrtown_address','1');
//    }

    function toggleMeaslesvaccine(radioName){
        var raValue = $('input[name="' + radioName+ '"]:checked').val();
        if(raValue == 1 || raValue == 4){
            $("#mvImmunizationHistory").hide();
            $("#mvLastInoculateDt").hide();

        }
        if(raValue == 2){
            $("#mvImmunizationHistory").show();
            $("#mvLastInoculateDt").hide();

        }
        if(raValue == 3){
            $("#mvImmunizationHistory").show();
            $("#mvLastInoculateDt").show();

        }
    }

    function toggleRubellavaccine(radioName){
        var raValue = $('input[name="' + radioName+ '"]:checked').val();
        if(raValue == 1 || raValue == 4){
            $("#rvImmunizationHistory").hide();
            $("#rvLastInoculateDt").hide();

        }
        if(raValue == 2){
            $("#rvImmunizationHistory").show();
            $("#rvLastInoculateDt").hide();

        }
        if(raValue == 3){
            $("#rvImmunizationHistory").show();
            $("#rvLastInoculateDt").show();

        }
    }

    return {
        toggleMeaslesvaccine : toggleMeaslesvaccine,
        toggleRubellavaccine:toggleRubellavaccine
    };
})();
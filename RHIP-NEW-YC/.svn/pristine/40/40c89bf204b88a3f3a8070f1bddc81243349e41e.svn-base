var encephalitisBCase = (function() {
    $(function() {
        $.Placeholder.init({query:"#idCard",callback:function(element){
            idCard.queryPerson($(element).val());
        }});
       
        toggleOther('generalCondition.outgoRange','rangeOtherProvinces',3);
        toggleOther('attackCondition.outDiagnosis','outDiagnosisOther',99);
        toggleOther('clinicalManifestations.fever','feverLimits',1);
        toggleOther('clinicalManifestations.vomit','bloodyVomit',1);
        toggleOtherSC('epidemiologicalSurvey.unvaccinatedReason','unvaccinatedReasonOther',99);
        toggleOther('labExamine.serumCollectFlg','serumCollectPart',1);
        toggleOther('labExamine.firstSerum','firstSerumPart',1);
        toggleOther('labExamine.secondSerum','secondSerumPart',1);
        toggleOther('labExamine.csfCheck','csfCheckPart',1);
        toggleOther('labExamine.jeViralIsolation','jeViralIsolationPart',1);
        toggleOther('clinicalManifestations.deathReason','deathReasonOther',99);
        toggleOther('clinicalManifestations.outcome','outcomeOtherSelect',99);
//        toggleOtherSC('clinicalManifestations.deathReason','deathReasonOther',99);
        toggleOtherSC('clinicalManifestations.followInvestWay','followInvestWayOther',99);
        toggleinoculate('epidemiologicalSurvey.inoculateHistory');
        toggleOther('epidemiologicalSurvey.inoculateNum','inoculateNum',99);
        showHRplace('generalCondition.hrPlace');
        toggerAddress();
    });

    /*隐藏、显示地址*/
    function toggerAddress(){
        var value=$('input[name="generalCondition.patientAttribute"]:checked').val();

        if('1' == value){
            $("#pavillage_address").removeAttr("disabled");
//            $("#hrvillage_address").removeAttr("disabled");
            $('#patown_address').removeAttr("disabled");
//            $('#hrtown_address').removeAttr("disabled");
            $('#spanPaNumber').text("门牌号");
            $('#spanHrNumber').text("门牌号");
            $('#pahouseNumber').attr({"style":"width:180px"});
            $('#hrhouseNumber').attr({"style":"width:180px"});
        }else{
            $("#pavillage_address").attr("disabled", "disabled");
//            $("#hrvillage_address").attr("disabled", "disabled");
            $("#patown_address").attr("disabled", "disabled");
//            $("#hrtown_address").attr("disabled", "disabled");
            $('#spanPaNumber').text("详细地址");
            $('#spanHrNumber').text("详细地址");
            $('#pahouseNumber').attr({'style':'width:90%'});
            $('#hrhouseNumber').attr({'style':'width:90%'});
        }
        toggleOther('generalCondition.patientAttribute','pavillage_address','1');
        toggleOther('generalCondition.patientAttribute','patown_address','1');
//        toggleOther('generalCondition.patientAttribute','hrvillage_address','2');
//        toggleOther('generalCondition.patientAttribute','hrtown_address','2');
    }

    function toggleinoculate(radioName){
        var raValue = $('input[name="' + radioName+ '"]:checked').val();
        if(raValue == 1){
            $("#inoculatePart").show();

            $("#unvaccinatedReasonPart").hide();
            $("#unvaccinatedReasonPart").find("select").each(function(){
                $(this).val('');
            });
            $("#unvaccinatedReasonPart").find("input[type=text]").each(function(){
                $(this).val('');
            });
        }
        if(raValue == 2){
            $("#inoculatePart").hide();
            $("#inoculatePart").find("input[type=text]").each(function(){
                $(this).val('');
            });
            $("#inoculatePart").find("input[type=radio]").each(function(){
                $(this).attr("checked",false);
            });
            $("#inoculatePart").find("input[type=checkbox]").each(function(){
                $(this).attr("checked",false);
            });

            $("#unvaccinatedReasonPart").show();
        }
        if(raValue == 4){
            $("#inoculatePart").hide();
            $("#unvaccinatedReasonPart").hide();
            $("#inoculatePart").find("input[type=text]").each(function(){
                $(this).val('');
            });
            $("#inoculatePart").find("input[type=radio]").each(function(){
                $(this).attr("checked",false);
            });
            $("#inoculatePart").find("input[type=checkbox]").each(function(){
                $(this).attr("checked",false);
            });
            $("#unvaccinatedReasonPart").find("select").each(function(){
                $(this).val('');
            });
            $("#unvaccinatedReasonPart").find("input[type=text]").each(function(){
                $(this).val('');
            });
        }
    }

    function showHRplace(radioName){
        var raValue = $('input[name="' + radioName+ '"]:checked').val();
        if(raValue == 1){
            $("#hrPart").show();
            $("#residenceTime").hide();
//            $("#hrhouseNumberID").attr("style","width:200px;");
            $("#hrhouseNumberID").css("width","200px")
        }else{
            $("#hrPart").hide();
            $("#residenceTime").show();
            $("#hrPart").find("select").each(function(){
                $(this).val('');
            });
//            $("#hrhouseNumberID").attr("style","width:200px;");
            $("#hrhouseNumberID").css("width","400px")
        }
    }
    return {
        toggerAddress:toggerAddress,
        toggleinoculate:toggleinoculate,
        showHRplace:showHRplace
    };
})();
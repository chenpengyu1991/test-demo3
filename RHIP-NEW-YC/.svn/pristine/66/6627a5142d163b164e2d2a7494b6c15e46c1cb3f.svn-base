var hbvCase = (function() {
    $(function() {
        toggleOther('epidemiologicalSurvey.hepatitisBVaccine','hepatitisBVaccinePart',2);
        toggleOther('epidemiologicalSurvey.hepatitisBVaccine','hbs',2);
        toggleOther('epidemiologicalSurvey.hepatitisBImmunoglobulin','hepatitisBImmunoglobulinDt',2);
        toggleOther('epidemiologicalSurvey.aimmugen','aimmugenPart',2);
        toggleOther('epidemiologicalSurvey.hepatitisAGammaGlobulin','hepatitisAGammaGlobulinDt',1);
        toggleOtherCK('epidemiologicalSurvey.diagnosisLiverCategory','chHepatitisOther',99);
        toggleOtherCK('exposureHistory.hepatitisBPatientCategory','hepatitisBPatientOther',99);
        toggleOther('exposureHistory.hepatitisBPatientContact','hepatitisBPatientCategory',1);
        toggleOther('exposureHistory.bloodSample','bloodSampleFrequency',1);
        toggleOther('epidemiologicalSurvey.hepatitis','diagnosisLiverCategory',1);
        toggleHav('epidemiologicalSurvey.aimmugenNum');
        togglehepatitisBVaccine('epidemiologicalSurvey.hepatitisBVaccineNum');
        toggleOther('labExamine.hbvSign','hbvSignDiv',1);
        caseEdit.toggerAddress();
    });
    function togglehepatitisBVaccine(radioName){
        var raValue = $('input[name="' + radioName+ '"]:checked').val();
        if(raValue == 5){
            $("#hepatitisBVaccineL").hide();
            $("#hepatitisBVaccineDt1").hide();
            $("#hepatitisBVaccineDt2").hide();
            $("#hepatitisBVaccineDt3").hide();
        }
        if(raValue == 1){
            $("#hepatitisBVaccineL").show();
            $("#hepatitisBVaccineDt1").show();
            $("#hepatitisBVaccineDt2").hide();
            $("#hepatitisBVaccineDt3").hide();
        }
        if(raValue == 2){
            $("#hepatitisBVaccineL").show();
            $("#hepatitisBVaccineDt1").show();
            $("#hepatitisBVaccineDt2").show();
            $("#hepatitisBVaccineDt3").hide();
        }
        if(raValue == 3){
            $("#hepatitisBVaccineL").show();
            $("#hepatitisBVaccineDt1").show();
            $("#hepatitisBVaccineDt2").show();
            $("#hepatitisBVaccineDt3").show();
        }
        if(raValue == 4){
            $("#hepatitisBVaccineL").show();
            $("#hepatitisBVaccineDt1").show();
            $("#hepatitisBVaccineDt2").show();
            $("#hepatitisBVaccineDt3").show();
        }
    }

    function toggleHav(radioName){
        var raValue = $('input[name="' + radioName+ '"]:checked').val();
        if(raValue == 1){
            $("#aimmugenDt").show();
            $("#aimmugenDt1").show();
            $("#aimmugenDt2").hide();
        }
        if(raValue == 2){
            $("#aimmugenDt").show();
            $("#aimmugenDt1").show();
            $("#aimmugenDt2").show();
        }
        if(raValue == 3){
            $("#aimmugenDt").hide();
            $("#aimmugenDt1").hide();
            $("#aimmugenDt2").hide();
        }
    }
    return {
        togglehepatitisBVaccine:togglehepatitisBVaccine,
        toggleHav:toggleHav
    };
})();
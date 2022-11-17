var gonorrheaCase = (function() {
    $(function() {
        $.Placeholder.init({query:"#idCard",callback:function(element){
            idCard.queryPerson($(element).val());
        }});

        toggleOtherSC('generalCondition.occupation','occupationOtherPart','CV020120299');
        toggleOther('epidemiologicalSurvey.outHistory','outHistoryAddr',1);
        toggleOther('pastHistory.vdHistory','vdName',1);
        toggleOther('pastHistory.vdHistory','vdDatePart',1);
        toggleOther('pastHistory.spouseVdHistory','spouseVdName',1);
        toggleOther('pastHistory.spouseVdHistory','spouseVdDatePart',1);
        toggleOther('epidemiologicalSurvey.extramaritalSex','useCondom',1);
        toggleOther('epidemiologicalSurvey.extramaritalSex','lastExtramaritalSexDays',1);
        caseEdit.toggerAddress();
    });

    function changeSelect(){
        inputValue = $('input[name="generalCondition.floatPopulation"]:checked').val();
        if(2 == inputValue){
            var address = '';
            if($('#town_address').find('option:selected').val() != ''){
                address = $('#town_address').find('option:selected').text();
            }
            if($('#village_address').find('option:selected').val() != ''){
                address = address + $('#village_address').find('option:selected').text();
            }
            address = address + $("#pahouseNumber").val();
            $("#hrhouseNumber").val(address);
        }else{
            $("#hrhouseNumber").val("");
        }
    }
    return {
        changeSelect : changeSelect
    };
})();
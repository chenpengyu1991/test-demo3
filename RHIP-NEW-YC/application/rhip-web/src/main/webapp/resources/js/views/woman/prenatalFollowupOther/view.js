var pFOAdd = (function() {
    $(function() {
        init();
        $("#pFOBackViewId").on("click", doBack);
        var $form = $("#pFOAddFromId");
        $form.find("input[type='text']").prop("disabled", true);
        $form.find("input[type='radio']").prop("disabled", true);
        $form.find("input[type='checkbox']").prop("disabled", true);
        $form.find("select").prop("disabled", true);
    });

    function init() {
        toggleOther('classifySignTwo','classifyDescTwoId',2);
        toggleOther('classifySignThree','classifyDescThreeId',2);
        toggleOther('classifySignFour','classifyDescFourId',2);
        toggleOther('classifySignFive','classifyDescFiveId',2);
        toggleOtherCK('healthGuidanceClassTwo','healthGuidanceClassDescTwoId',99);
        toggleOtherCK('healthGuidanceClassThree','healthGuidanceClassDescThreeId',99);
        toggleOtherCK('healthGuidanceClassFour','healthGuidanceClassDescFourId',99);
        toggleOtherCK('healthGuidanceClassFive','healthGuidanceClassDescFiveId',99);
        toggleOther('referralFlagTwo','referralFlagTwoId',2);
        toggleOther('referralFlagThree','referralFlagThreeId',2);
        toggleOther('referralFlagFour','referralFlagFourId',2);
        toggleOther('referralFlagFive','referralFlagFiveId',2);
        toggleOtherCK('tcmHealthSignTwo','tcmHealthSignDescTwoId',99);
        toggleOtherCK('tcmHealthSignThree','tcmHealthSignDescThreeId',99);
        toggleOtherCK('tcmHealthSignFour','tcmHealthSignDescFourId',99);
        toggleOtherCK('tcmHealthSignFive','tcmHealthSignDescFiveId',99);
    }

    function doBack(){
        $("#pFOSearchDivId").show();
        $("#pFODetailDiv").hide();
    }
})();




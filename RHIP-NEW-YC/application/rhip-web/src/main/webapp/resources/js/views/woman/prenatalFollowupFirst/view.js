var pFPAdd = (function() {
    $(function() {
        $("#pFPBackViewId").on("click", doBack);
        var $form = $("#pFPAddFromId");
        $form.find("input[type='text']").prop("disabled", true);
        $form.find("input[type='radio']").prop("disabled", true);
        $form.find("input[type='checkbox']").prop("disabled", true);
        $form.find("select").prop("disabled", true);
    });

    function doBack(){
        $("#pFPSearchDivId").show();
        $("#pFPDetailDiv").hide();
    }

})();




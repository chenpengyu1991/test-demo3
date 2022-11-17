var diPlanInfoView = (function () {

    $(function () {
        $("#cdm-plan-list-di-back-btn").click(function () {
            back();
        });
    });

    function back() {
        debugger;
        $("#cdm-plan-input-di").hide();
        $("#cdm-plan-list-di-box").show();
    }

})();
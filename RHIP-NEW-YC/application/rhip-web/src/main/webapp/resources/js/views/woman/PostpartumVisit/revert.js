var addPostnatalFollowUp = (function() {
    $(function() {
        $("#revert").on("click", doBack);
    });

    function doBack() {
        $("#pFOUpDiv").hide();
        $("#pFollowupId").show();
    }
})();

var addPostnatalFollowUp = (function() {
    $(function() {
        $("#revert").on("click", doBack);
    });

    function doBack() {
        $("#insertPostForT").hide();
        $("#postForTwo").show();
    }
})();

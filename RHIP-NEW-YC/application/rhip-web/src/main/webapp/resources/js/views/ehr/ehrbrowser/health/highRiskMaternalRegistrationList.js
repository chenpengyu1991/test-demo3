var highRiskMaternalRegistrationList = (function(){
    $(function(){
        getHighRiskMaternalRegistrationDetail($(".gwcfdj:first").val());
    });

    function getHighRiskMaternalRegistrationDetail(id){
        var loadByUrl = {
            url : "/ehrbrowser/health/highRiskMaternalRegistration",
            insertDiv : "highRiskMaternalRegistrationDiv",
            param : {
                id : id
            }
        };
        $.loadHtmlByUrl(loadByUrl);
    }

    return {
        getHighRiskMaternalRegistrationDetail : getHighRiskMaternalRegistrationDetail
    };
})();
var getReception = (function () {

    $(function () {
        var haveDate = $("#outpatientInfos").val();
        if(haveDate != 0){
            viewReception($(".personId:first").val(),$(".ehrId:first").val());
        }
    });

    //获取单个接诊记录
    function viewReception(personId, ehrId){
        var loadByUrl = {
            url : "/ehrbrowser/basic/reception",
            insertDiv : "receptionViewDiv",
            param : {
                personId: personId,
                ehrId: ehrId
            }
        };
        $.loadHtmlByUrl(loadByUrl);
    }

    return{
        viewReception:viewReception,
    }
})();
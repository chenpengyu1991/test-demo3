var basicConsultation = (function () {


    $(function () {
        getConsultation($(".consultation:first").val());
    });


    //获取单个会诊记录
    function getConsultation(id){
        var isView = $("#isView").val();
        var loadByUrl = {
            url : "/personRecord/getConsultation",
            insertDiv : "consultationDiv",
            param : {
                id : id,
                isView : isView
            }
        };
        $.loadHtmlByUrl(loadByUrl);
    }

    return {
        getConsultation:getConsultation

    };
})();
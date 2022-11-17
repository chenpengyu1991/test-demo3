var jcReport  = (function() {
    $(function() {
        search(1);
        $("#ch_search_btn").click(function(e) {
            e.preventDefault();
        	search(1);
        });
        $("#ch_downExcel_btn").click(function(e) {
            e.preventDefault();
            downLoad();
        });

    });

    function search(pageIndex){
        if($.isEmpty(pageIndex)){
            pageIndex = $('#tagContent1').find('#pageIndex').val();
        }
        var searchObj = {
            url : "/idm/schistosome/report/jcList",
            insertDiv : "jcReportDiv",
            param : {
                pageIndex : $.isEmpty(pageIndex)?1:pageIndex
            },
            callback : function(data) {
                $('#tagContent4').find('#pageIndex').val(pageIndex);
            }
        };
        $("#jcReportSearchForm1").submitFormLoadHtml(searchObj);
    }

    function downLoad(){
        location.href = contextPath + "/idm/schistosome/report/jcReport"+"?" + $('#jcReportSearchForm1').formSerialize();
    }





return {
    search:search,
    downLoad:downLoad
};
})();

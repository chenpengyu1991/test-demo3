var population = (function () {
    $(function () {
       $("#populationSearch").click(function () {
          search(); 
       });
        search();
    });

    function search() {
        var searchObj = {
            url : "/population/list",
            insertDiv : "populationListDiv"
        };
        $("#populationForm").submitFormLoadHtml(searchObj);
    }
    function changeReportType(){
        var countType = $('input:radio[name="countType"]:checked').val();
        if(countType == '1'){//按年
            $('#Year').show();
            $('#Quarter').hide();
        }else if(countType == '2'){//按季度
            $('#Year').show();
            $('#Quarter').show();
        }
    }
    return {
        changeReportType:changeReportType
    };
})();

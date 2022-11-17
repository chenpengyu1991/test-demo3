$(function() {
    validate = $("#outOrgReStatisticsForm").easyValidate();
    //alert(validate);
    $("#outOrgReStatisticsForm").onEnter(getOutOrgReStatistics,1);
    $("#ourOrgRemindStatisticsBtnSearch").click(function(e) {
    	e.preventDefault();
        getOutOrgReStatistics(1);
    });
    initForm();
});
function getOutOrgReStatistics(indexPage){
    changeRangeType();
    indexPage = (isEmpty(indexPage)?$("#pageIndex").val():indexPage);
    var searchObj = {
        url : "/ihm/remind/statistics/withoutorglist",
        insertDiv : "resultDiv",
        param : {
            indexPage : indexPage
        },
        callback : function(data) {
            // $("#pageIndex").val(indexPage);
        }
    };
    $("#outOrgReStatisticsForm").submitFormLoadHtml(searchObj);
};
function initForm(){
    $('#rangeType').on("change",function(){
        changeRangeType();
    });
    changeRangeType();
}
function changeRangeType(){
    var yearType = $('input[name="yearType"]:checked').val();
    if(isEmpty(yearType)){
        $('input[name="yearType"]:eq(0)').attr("checked",'checked');
    }
    var rangeType = $('#rangeType').val();
    if(rangeType == '1'){
        $('#byMonth').show();
        $('#byQuarter').hide();
        $('#byYear').hide();
        $('#byRange').hide();
    }else if(rangeType == '2'){
        $('#byMonth').hide();
        $('#byQuarter').show();
        $('#byYear').hide();
        $('#byRange').hide();
    }else if(rangeType == '3'){
        $('#byMonth').hide();
        $('#byQuarter').hide();
        $('#byYear').show();
        $('#byRange').hide();
    }else if(rangeType == '4'){
        $('#byMonth').hide();
        $('#byQuarter').hide();
        $('#byYear').hide();
        $('#byRange').show();
        $('#beginDate').val($('#beginDate4').val());
        $('#endDate').val($('#endDate4').val());
    }
}
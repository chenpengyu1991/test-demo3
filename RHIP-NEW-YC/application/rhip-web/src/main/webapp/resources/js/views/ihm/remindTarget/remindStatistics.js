$(function() {
    validate = $("#RemindStatisticsForm").easyValidate();
    //alert(validate);
    $("#RemindStatisticsForm").onEnter(getRemindStatistics,1);
    $("#remindStatisticsBtnSearch").click(function(e) {
    	e.preventDefault();
        getRemindStatistics(1);
    });
    initForm();
});
function getRemindStatistics(indexPage){
    changeOrgType();
    changeRangeType();
    indexPage = (isEmpty(indexPage)?$("#pageIndex").val():indexPage);
    var searchObj = {
        url : "/ihm/remind/statistics/list",
        insertDiv : "resultDiv",
        param : {
            indexPage : indexPage
        },
        callback : function(data) {
            // $("#pageIndex").val(indexPage);
        }
    };
    $("#RemindStatisticsForm").submitFormLoadHtml(searchObj);
};


function initForm(){
    $('#centre1').on("change",function(){
        $('#superOrganCode').val(this.value);
    });
    $('#town1').on("change",function(){
        $('#gbCode').val(this.value);
    });
    $('#centre2').on("change",function(){
        $('#superOrganCode').val(this.value);
    });
    $('#town2').on("change",function(){
        $('#gbCode').val(this.value);
    });
    $('#station2').on("change",function(){
        $('#organCode').val(this.value);
    });
    $('#genreCode').on("change",function(){
        changeOrgType();
    });
    $('#rangeType').on("change",function(){
        changeRangeType();
    });
    changeOrgType();
    changeRangeType();
}
function changeOrgType(){
    var genreCode = $('#genreCode').val();
    if(genreCode == 'A1'){
        $('#byHospital').show();
        $('#byCentre').hide();
        $('#byStation').hide();
        $('#byTown').hide();
        getCurrentOrgCode(0);
    }else if(genreCode == 'B1'){
        $('#byHospital').hide();
        $('#byCentre').show();
        $('#byStation').hide();
        $('#byTown').hide();
        getCurrentOrgCode(1);
    }else if(genreCode == 'B2'){
        $('#byHospital').hide();
        $('#byCentre').hide();
        $('#byStation').show();
        $('#byTown').hide();
        getCurrentOrgCode(2);
    }else if(genreCode == '0'){
        $('#byHospital').hide();
        $('#byCentre').hide();
        $('#byStation').hide();
        $('#byTown').show();
        getCurrentOrgCode(3);
    }else if(genreCode == '46714114-9'){
        $('#byHospital').hide();
        $('#byCentre').hide();
        $('#byStation').hide();
        $('#byTown').hide();
        getCurrentOrgCode(3);
    }
}
function getCurrentOrgCode(index){
    $('#gbCode').val($('#town' + index).val());
    if(index==0){
        $('#superOrganCode').val($('#organCode' + index).val());
    }else if(index == '46714114-9'){
        $('#superOrganCode').val($('#genreCode').val());
        $('#genreCode').val('R2');
    }else if(index != 3){
        $('#superOrganCode').val($('#centre' + index).val());
        $('#organCode').val($('#station' + index).val());
    }else{
        $('#superOrganCode').val("");
        $('#organCode').val("");
    }
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
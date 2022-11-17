
$(function() {

   validate = $("#reportCountForm").easyValidate();
    //alert("999");
    $("#reportCountForm").onEnter(searchCountReportRecord,1);
    $("#cardBtnSearch").click(function(e) {
    	e.preventDefault();
        searchCountReportRecord(1);
    });
    $("#back").click(function(e) {
    	e.preventDefault();
        back();
    });
    initForm();
});
function searchCountReportRecord(indexPage){
    changeOrgType();
    changeRangeType();
    indexPage = (isEmpty(indexPage)?$("#pageIndex").val():indexPage);
    //alert(indexPage);
    var searchObj = {
        url : "/ihm/card/monitor/list",
        insertDiv : "resultDiv",
        param : {
            indexPage : indexPage
        },
        callback : function(data) {
           // $("#pageIndex").val(indexPage);
        }
    };
    $("#reportCountForm").submitFormLoadHtml(searchObj);
};




    function recordsPerform(indexPage) {
        var createBegin = new Date($("#beginTime").val());
        var createEnd = new Date($("#endTime").val());

        if (createBegin > createEnd) {
            msgUtil.alert("接种开始时间不能大于接种结束时间");
        } else {
            var searchObj = {
                url : "/system/log/list",
                insertDiv : "userOperationLogList",
                param : {
                    indexPage : indexPage
                }
            };
            $("#form_search").submitFormLoadHtml(searchObj);
        }
    }



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
    	$('#superOrganCode').val("");
        $('#gbCode').val(this.value);
    });
    $('#station2').on("change",function(){
        $('#organCode').val(this.value);
    });
    $('#organCode0').on("change",function(){
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

function back() {
	$("#mainContent").show();
	$("#reportCardMonitorList").hide();
	location.reload();
}
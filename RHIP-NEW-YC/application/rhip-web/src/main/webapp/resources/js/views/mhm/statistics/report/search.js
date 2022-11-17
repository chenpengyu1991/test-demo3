var mhmReportSearch = (function() {
	var validate=null;
	$(function() { 	
		validate = $("#reportSearchForm").easyValidate();
        $("#reportBtnSearch").click(function(e) {
        	e.preventDefault();
        	searchReport();
        });	
        $("#reportExport").click(function(e) {
        	e.preventDefault();
        	exportReport();
        });	 
        searchReport();
        $("#reportSearchForm").onEnter(searchReport, 1);
	});

	function exportReport(){
    	var townName = $("select[name='townCode']").find("option[value!='']:selected").text();
		var centerName = $("select[name='centerCode']").find("option[value!='']:selected").text();
		var stationName = $("select[name='stationCode']").find("option[value!='']:selected").text();
    	var orgName = townName + ($.isEmpty(centerName)?"":"-" + centerName) + ($.isEmpty(stationName)?"":"-" + stationName);
    	var reportYear = $('#reportYearId').val();
    	var reportQuarter = $("select[name='reportQuarter']").find("option[value!='']:selected").text();;
    	var reportMonth = $('#reportMonthId').val();
    	reportMonth = reportMonth.replace("/","-");
    	var mhmReportType = $("input[name=mhmReprtType]:checked").val();
    	var dateName = "";
    	if(mhmReportType == 1){
    		dateName = reportYear;
    	}else if(mhmReportType == 2){
    		dateName = reportYear + ($.isEmpty(reportQuarter)?"":"-" + reportQuarter) ;
    	}else if(mhmReportType == 3){
    		dateName = ($.isEmpty(reportMonth)?"":reportMonth);
    	}
    	searchReport("false");
    	$("#reportTable").exportExcel("精神卫生报表管理-" + orgName + "(" + dateName + ")");

        //记录日志
        $("#reportSearchForm").submitFormGetJson({
            url:"/mhm/statistics/report/operationLog"
        });
	}
	/*查询*/
	function searchReport(asyncFlag) {
		var result=validate.validateForm();
    	if(!result){
    		return;
    	}  		
		var searchObj = {
			url : "/mhm/statistics/report/list",
			insertDiv : 'reportResultDiv',
			param : {},
			async : $.isEmpty(asyncFlag)?true:false,
			callback : function() {
            }
		};
		$("#reportSearchForm").submitFormLoadHtml(searchObj);
	};


	function changeReportType(){
		var mhmReprtType = $('input:radio[name="mhmReprtType"]:checked').val();
		if(mhmReprtType == '1'){//按年
			$('#reportYearId').show();
			$('#reportQuarter').hide();
			$('#reportMonthId').hide();
		}else if(mhmReprtType == '2'){//按季度
			$('#reportYearId').show();
			$('#reportQuarter').show();
			$('#reportMonthId').hide();
		}else if(mhmReprtType == '3'){//按月
			$('#reportYearId').hide();
			$('#reportQuarter').hide();
			$('#reportMonthId').show();
		}
	}	
	return {
		changeReportType:changeReportType
	};
})();
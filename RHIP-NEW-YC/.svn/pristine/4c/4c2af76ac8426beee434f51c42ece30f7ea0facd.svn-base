var interviewSearch = (function() {
	$(function() { 	
        $("#interviewBtnSearch").click(function() {
        	searchInterview();
        });	
        $("#interviewExport").click(function() {
        	var reportName = $('#reportNameId').val();
        	$("#interviewtable").exportExcel(reportName);
        });	 
        $("#interviewEdit").click(function() {
        	editReport();
        });        
        $("#interviewSave").click(function() {
        	saveReport();
        });        
        if($('#RoleTypeId').val() != 'FYK'){
        	$("#fillOrganCodeId option[value='']").remove();//删除‘请选择’，中心统计时，必须选择一个单位
        }  
        searchInterview();
        $("#interviewSearchForm").onEnter(searchInterview, 1);
	});
	function editReport(){
		statisticsCommon.changeReportStatus('edit','interviewList');
		$("#interviewEdit").hide();
        $("#interviewSave").show();
	}
	/*传染病管理月报表-传染病访视查询*/
	function searchInterview() {
		var searchObj = {
			url : "/idm/statistics/report/monthReport/interviewList",
			insertDiv : 'interviewResultDiv',
			param : {},
			callback : function() {
				changeButtonStatus();
            }
		};
		$("#interviewSearchForm").submitFormLoadHtml(searchObj);
	};
	function changeButtonStatus(){
		var editReport = $('#interviewList').find("[id^='editReport']");
		if(editReport.length > 0){
			$("#interviewEdit").show();
			$("#interviewSave").hide();
		}else{
			$("#interviewEdit").hide();
			$("#interviewSave").hide();
		}
	}
	function saveReport(){
		var validate = $("#interviewForm").easyValidate();
    	var result=validate.validateForm();
    	if(!result){
    		return;
    	} 
		$("#interviewForm").submitFormGetJson({
			url : "/idm/statistics/report/monthReport/interviewSave",
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("保存失败！", {icon:0,title:'提示'});
                }else {
                    layer.alert("保存成功！", {icon:0,title:'提示'});
            		$("#interviewEdit").show();
                    $("#interviewSave").hide();
                    searchInterview();
                    return false;
                }
            },
            wait:true
		});     	
	}	
	return {
	};
})();
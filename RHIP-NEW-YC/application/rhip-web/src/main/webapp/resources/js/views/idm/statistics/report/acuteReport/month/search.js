var acuteMonthSearch = (function() {
	$(function() { 	
        $("#acuteMonthBtnSearch").click(function() {
        	searchAcuteMonth();
        });	
        $("#acuteMonthExport").click(function() {
        	$("#acuteMonthtable").exportExcel("急性传染病防治月报表");
        });	 
        $("#acuteMonthEdit").click(function() {
        	editReport();
        });        
        $("#acuteMonthSave").click(function() {
        	saveReport();
        });     
        if($('#RoleTypeId').val() != 'FYK'){
        	$("#fillOrganCodeId option[value='']").remove();//删除‘请选择’，中心统计时，必须选择一个单位
        }else{
			$("#acuteMonthEdit").hide();
			$("#acuteMonthSave").hide();
        }
        searchAcuteMonth();
        $("#acuteMonthSearchForm").onEnter(searchAcuteMonth, 1);
	});
	function editReport(){
		statisticsCommon.changeReportStatus('edit','acuteMonthList');
		$("#acuteMonthEdit").hide();
        $("#acuteMonthSave").show();
	}
	/*急性传染病防治月报表查询*/
	function searchAcuteMonth() {
		var searchObj = {
			url : "/idm/statistics/report/acuteReport/monthList",
			insertDiv : 'acuteMonthResultDiv',
			param : {},
			callback : function() {
				if($('#RoleTypeId').val() != 'FYK'){
					changeButtonStatus();
				}
            }
		};
		$("#acuteMonthSearchForm").submitFormLoadHtml(searchObj);
	};
	function changeButtonStatus(){
		var editReport = $('#acuteMonthList').find("[id^='editReport']");
		if(editReport.length > 0){
			$("#acuteMonthEdit").show();
			$("#acuteMonthSave").hide();
		}else{
			$("#acuteMonthEdit").hide();
			$("#acuteMonthSave").hide();
		}
	}
	function saveReport(){
		var validate = $("#acuteMonthForm").easyValidate();
    	var result=validate.validateForm();
    	if(!result){
    		return;
    	} 
		$("#acuteMonthForm").submitFormGetJson({
			url : "/idm/statistics/report/acuteReport/monthSave",
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("保存失败！", {icon:0,title:'提示'});
                }else {
                    layer.alert("保存成功！", {icon:0,title:'提示'});
            		$("#acuteMonthEdit").show();
                    $("#acuteMonthSave").hide();
                    searchAcuteMonth();
                    return false;
                }
            },
            wait:true
		});     	
	}	

	return {
	};
})();
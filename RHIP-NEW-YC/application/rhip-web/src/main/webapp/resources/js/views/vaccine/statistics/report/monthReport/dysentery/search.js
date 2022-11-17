var dysenterySearch = (function() {
	$(function() { 	
        $("#dysenteryBtnSearch").click(function() {
        	searchDysentery();
        });	
        $("#dysenteryExport").click(function() {
        	var reportName = $('#reportNameId').val();
        	$("#dysenterytable").exportExcel(reportName);
        });	 
        $("#dysenteryEdit").click(function() {
        	editReport();
        });        
        $("#dysenterySave").click(function() {
        	saveReport();
        });        
        if($('#RoleTypeId').val() != 'JKYFJZ'){
        	$("#fillOrganCodeId option[value='']").remove();//删除‘请选择’，中心统计时，必须选择一个单位
        }    
        searchDysentery();
        $("#dysenterySearchForm").onEnter(searchDysentery, 1);
	});
	function editReport(){
		statisticsCommon.changeReportStatus('edit','dysenteryList');
		$("#dysenteryEdit").hide();
        $("#dysenterySave").show();
	}
	/*传染病管理月报表-细菌性痢疾流调查询*/
	function searchDysentery() {
		var searchObj = {
			url : "/idm/statistics/report/monthReport/dysenteryList",
			insertDiv : 'dysenteryResultDiv',
			param : {},
			callback : function() {
				changeButtonStatus();
            }
		};
		$("#dysenterySearchForm").submitFormLoadHtml(searchObj);
	};
	function changeButtonStatus(){
		var editReport = $('#dysenteryList').find("[id^='editReport']");
		if(editReport.length > 0){
			$("#dysenteryEdit").show();
			$("#dysenterySave").hide();
		}else{
			$("#dysenteryEdit").hide();
			$("#dysenterySave").hide();
		}
	}
	function saveReport(){
		var validate = $("#dysenteryForm").easyValidate();
    	var result=validate.validateForm();
    	if(!result){
    		return;
    	} 
		$("#dysenteryForm").submitFormGetJson({
			url : "/idm/statistics/report/monthReport/dysenterySave",
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("保存失败！", {icon:0,title:'提示'});
                }else {
                    layer.alert("保存成功！", {icon:0,title:'提示'});
            		$("#dysenteryEdit").show();
                    $("#dysenterySave").hide();
                    searchDysentery();
                    return false;
                }
            },
            wait:true
		});     	
	}	
	return {
	};
})();
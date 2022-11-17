var rabiesSearch = (function() {
	$(function() { 	
        $("#rabiesBtnSearch").click(function() {
        	searchRabies();
        });	
        $("#rabiesExport").click(function() {
        	var reportName = $('#reportNameId').val();
        	$("#rabiestable").exportExcel(reportName);
        });	 
        $("#rabiesEdit").click(function() {
        	editReport();
        });        
        $("#rabiesSave").click(function() {
        	saveReport();
        });        
        if($('#RoleTypeId').val() != 'FYK'){
        	$("#fillOrganCodeId option[value='']").remove();//删除‘请选择’，中心统计时，必须选择一个单位
        }  
        searchRabies();
        $("#rabiesSearchForm").onEnter(searchRabies, 1);
	});
	function editReport(){
		statisticsCommon.changeReportStatus('edit','rabiesList');
		$("#rabiesEdit").hide();
        $("#rabiesSave").show();
	}
	/*传染病管理月报表-狂犬病防治查询*/
	function searchRabies() {
		var searchObj = {
			url : "/idm/statistics/report/monthReport/rabiesList",
			insertDiv : 'rabiesResultDiv',
			param : {},
			callback : function() {
				changeButtonStatus();
            }
		};
		$("#rabiesSearchForm").submitFormLoadHtml(searchObj);
	};
	function changeButtonStatus(){
		var editReport = $('#rabiesList').find("[id^='editReport']");
		if(editReport.length > 0){
			$("#rabiesEdit").show();
			$("#rabiesSave").hide();
		}else{
			$("#rabiesEdit").hide();
			$("#rabiesSave").hide();
		}
	}
	function saveReport(){
		var validate = $("#rabiesForm").easyValidate();
    	var result=validate.validateForm();
    	if(!result){
    		return;
    	} 
		$("#rabiesForm").submitFormGetJson({
			url : "/idm/statistics/report/monthReport/rabiesSave",
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("保存失败！", {icon:0,title:'提示'});
                }else {
                    layer.alert("保存成功！", {icon:0,title:'提示'});
            		$("#rabiesEdit").show();
                    $("#rabiesSave").hide();
                    searchRabies();
                    return false;
                }
            },
            wait:true
		});     	
	}	

	return {
	};
})();
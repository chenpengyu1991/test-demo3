var acuteYearSearch = (function() {
	$(function() { 	
        $("#acuteYearBtnSearch").click(function() {
        	searchAcuteYear();
        });	
        $("#acuteYearExport").click(function() {
        	$("#acuteYeartable").exportExcel("急性传染病防治年报表");
        });	 
        if($('#RoleTypeId').val() != 'FYK'){
        	$("#fillOrganCodeId option[value='']").remove();//删除‘请选择’，中心统计时，必须选择一个单位
        }else{
			$("#acuteMonthEdit").hide();
			$("#acuteMonthSave").hide();
        }
        searchAcuteYear();
        $("#acuteYearSearchForm").onEnter(searchAcuteYear, 1);
	});

	/*急性传染病防治年报表查询*/
	function searchAcuteYear() {
		var searchObj = {
			url : "/idm/statistics/report/acuteReport/yearList",
			insertDiv : 'acuteYearResultDiv',
			param : {}
		};
		$("#acuteYearSearchForm").submitFormLoadHtml(searchObj);
	};
	return {
	};
})();
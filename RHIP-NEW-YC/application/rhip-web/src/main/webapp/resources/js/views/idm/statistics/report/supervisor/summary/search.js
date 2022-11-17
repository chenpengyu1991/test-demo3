var summarySearch = (function() {
	$(function() { 	
        $("#summaryBtnSearch").click(function() {
        	searchSummary();
        });	
        $("#supervisorExport").click(function() {
        	$("#supervisortable").exportExcel("江苏省传染病管理及督导汇总表");
        });	      
        if($('#RoleTypeId').val() != 'FYK'){
        	$("#reportUnitCodeId option[value='']").remove();//删除‘请选择’，中心统计时，必须选择一个单位
        } 
        searchSummary();
        $("#summarySearchForm").onEnter(searchSummary, 1);
	});
	/*传染病管理及督导画面查询*/
	function searchSummary() {
		var summaryType = $('input:radio[name="summaryType"]:checked').val();
		var searchObj = {
			url : "/idm/statistics/report/supervisor/summaryList",
			insertDiv : 'summaryResultDiv',
			param : {summaryType:summaryType}
		};
		$("#summarySearchForm").submitFormLoadHtml(searchObj);
	};
	
	function changeSummaryType(){
		var summaryType = $('input:radio[name="summaryType"]:checked').val();
		if(summaryType == '1'){
			$('#reportMonthId').show();
			$('#reportYearId').hide();
			$('#summaryTypeTextId').text("填报月份");
		}else{
			$('#reportMonthId').hide();
			$('#reportYearId').show();	
			$('#summaryTypeTextId').text("填报年份");
		}
	}
	return {
		searchSummary:searchSummary,
		changeSummaryType:changeSummaryType
	};
})();
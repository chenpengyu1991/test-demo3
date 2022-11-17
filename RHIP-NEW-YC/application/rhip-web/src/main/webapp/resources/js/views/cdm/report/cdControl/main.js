var cdControl_main = (function() {
		$(function() {
			$("#cdm-hbp-manage-month-report-btn").on("click", function(event) {
				selectTag("tagContent0", this);
				getHbpManageMonthReport();
			});
			$("#hmmr_searchButton").click(function(e) {
				e.preventDefault();
				getHbpManageMonthReport();
			});
			$("#cdControlhiddeSearch").click(function(){
				toggle(this,'hiddeSearch');
			});
			// 导出绑定
			$("#cdm-hbpManageMonthReport-export").on("click", function(event) {
				event.preventDefault();
				$("#cdm-hbpManageMonthReport-table").exportExcel();
			});
			getHbpManageMonthReport();
		});

	function getHbpManageMonthReport() {
		var option = {
			url : '/cdm/statistics/manageMonthReport',
			insertDiv : 'hbpManageMonthReport_result'
		};
		$("#hbpManageMonthReportForm").submitFormLoadHtml(option);
	}
	function toggle(obj, tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	}
	
	return {
		toggle : toggle,
		getHbpManageMonthReport:getHbpManageMonthReport
	};
})();
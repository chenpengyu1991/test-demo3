!(function() {
	$(function() {
		$("#hsa-report-service-report-serach-form").keypress(function(e) {
			var key = e.which;
			if (key == 13)
			{
				search(1);
			}
		});

		$("#hsa-report-service-report-serach-btn").click(function(e) {
			e.preventDefault();
			search(1);
		});
		$("#hsa-report-service-report-export-btn").click(function(e) {
			e.preventDefault();
			$("#hsa-report-service-report-result-table").exportExcel();
		});
		search(1);
	});


	function back() {
		$("#hsa-report-service-report-content").show();
		$("#hsa-report-service-report-result-content").hide();
	}

	function showInput() {
		$("#hsa-report-service-report-content").hide();
		$("#hsa-report-service-report-result-content").show();
	}

	function search(indexPage) {
		var searchObj = {
			url : "/hsa/inspRecord/report/serviceReportResult",
			insertDiv : "hsa-report-service-report-result-content",
			param : {
				indexPage : indexPage,
			}
		};
		$("#hsa-report-service-report-serach-form").submitFormLoadHtml(searchObj);
	}

})();
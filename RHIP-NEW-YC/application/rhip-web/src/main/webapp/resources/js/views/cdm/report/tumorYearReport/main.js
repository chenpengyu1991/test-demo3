var tumorYearReport_main = (function() {
		$(function() {
			$("#gengerForm").click(function() {
				toggle(this,'cdm-year-report-tumor-genger-form-table');
			});
			$("#ageForm").click(function() {
				toggle(this,'cdm-year-report-tumor-age-form-table');
			});
			$("#deathGengerForm").click(function() {
				toggle(this,'cdm-year-report-tumor-death-genger-form-table');
			});
			$("#deathAgeForm").click(function() {
				toggle(this,'cdm-year-report-tumor-death-age-form-table');
			});
			$("#cdm-year-report-tumor-gender-btn").on("click", function(event) {
				selectTag("tagContent0", this);
				tumorYearReportsByGenger();
			});
			// tab 切换初始化
			$("#cdm-year-report-tumor-age-btn").on("click", function(event) {
				selectTag("tagContent1", this);
				tumorYearReportByAge();
			});
			$("#cdm-year-report-tumor-death-genger-btn").on("click",
					function(event) {
						selectTag("tagContent2", this);
						tumorDeathYearReportsByGenger();
					});
			$("#cdm-year-report-tumor-death-age-btn").on("click",
					function(event) {
						selectTag("tagContent3", this);
						tumorDeathYearReportByAge();
					});

			tumorYearReportsByGenger();

			// 导出按钮绑定

			$("#cdm-year-report-tumor-genger-export")
					.on(
							"click",
							function(event) {
								event.preventDefault();
								$("#cdm-year-report-tumor-genger-result")
										.exportExcel();
							});

			$("#cdm-year-report-tumor-age-export").on("click", function(event) {
				event.preventDefault();
				$("#cdm-year-report-tumor-age-result").exportExcel();
			});

			$("#cdm-year-report-tumor-death-genger-export").on(
					"click",
					function(event) {
						event.preventDefault();
						$("#cdm-year-report-tumor-death-genger-result")
								.exportExcel();
					});

			$("#cdm-year-report-tumor-death-age-export").on(
					"click",
					function(event) {
						event.preventDefault();
						$("#cdm-year-report-tumor-death-age-result")
								.exportExcel();
					});

			// 查询按钮绑定
			$("#cdm-year-report-tumor-genger-form .layui-btn").on("click",
					function(event) {
						event.preventDefault();
						tumorYearReportsByGenger();
					});
			$("#cdm-year-report-tumor-age-form .layui-btn").on("click",
					function(event) {
						event.preventDefault();
						tumorYearReportByAge();
					});
			$("#cdm-year-report-tumor-death-genger-form .layui-btn").on(
					"click", function(event) {
						event.preventDefault();
						tumorDeathYearReportsByGenger();
					});
			$("#cdm-year-report-tumor-death-age-form .layui-btn").on("click",
					function(event) {
				event.preventDefault();
						tumorDeathYearReportByAge();
					});

		});
	function tumorYearReportsByGenger() {
		getResult("cdm-year-report-tumor-genger-form",
				"/cdm/statistics/tumorYearReport/byGengerReslut",
				"cdm-year-report-tumor-genger-content");
	}

	function tumorYearReportByAge() {
		getResult("cdm-year-report-tumor-age-form",
				"/cdm/statistics/tumorYearReport/byAgeReslut",
				"cdm-year-report-tumor-age-content");
	}

	function tumorDeathYearReportsByGenger() {
		getResult("cdm-year-report-tumor-death-genger-form",
				"/cdm/statistics/tumorYearReport/deathByGengerReslut",
				"cdm-year-report-tumor-death-genger-content");
	}

	function tumorDeathYearReportByAge() {
		getResult("cdm-year-report-tumor-death-age-form",
				"/cdm/statistics/tumorYearReport/deathByAgeReslut",
				"cdm-year-report-tumor-death-age-content");
	}

	function getResult(form, url, insertDiV) {
		var option = {
			url : url,
			insertDiv : insertDiV
		};
		$("#" + form).submitFormLoadHtml(option);
	}

	function toggle(obj, tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	}

	return {
		toggle : toggle,
		tumorYearReportsByGenger:tumorYearReportsByGenger,
		tumorYearReportByAge:tumorYearReportByAge,
		tumorDeathYearReportsByGenger:tumorDeathYearReportsByGenger,
		tumorDeathYearReportByAge:tumorDeathYearReportByAge
	};

})();
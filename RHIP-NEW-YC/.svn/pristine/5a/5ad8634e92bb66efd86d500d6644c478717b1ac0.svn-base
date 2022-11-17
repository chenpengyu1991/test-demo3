var cdmYearReport = (function()
{
	$(function()
	{
		$("#cdm-year-report-cdm-age-btn").on("click", function(event)
		{
			selectTag("tagContent1", this);
			getAgeResult();
		});
		// tab切换>显示档案统计
		$("#cdm-year-report-cdm-gender-btn").on("click", function(event)
		{
			selectTag("tagContent0", this);
			getGengerResult();
		});

		$("#cdm-year-report-cdm-genger-export").on("click", function(event)
		{
			event.preventDefault();
			$("#cdm-year-report-cdm-genger-result").exportExcel();
		});

		$("#cdm-year-report-cdm-age-export").on("click", function(event)
		{
			event.preventDefault();
			$("#cdm-year-report-cdm-age-result").exportExcel();
		});

		$("#cdm-year-report-cdm-genger-search").on("click", function(event)
		{
			event.preventDefault();
			getGengerResult();
		});
		$("#cdm-year-report-cdm-age-search").on("click", function(event)
		{
			event.preventDefault();
			getAgeResult();
		});

		getGengerResult();
	});

	function getGengerResult()
	{
		var option = {
			url : '/cdm/statistics/cdYearReport/byGengerReslut',
			insertDiv : 'cdm-year-report-cdm-genger-content'
		};
		$("#cdm-year-report-cdm-genger-form").submitFormLoadHtml(option);
	}

	function getAgeResult()
	{
		var option = {
			url : '/cdm/statistics/cdYearReport/byAgeReslut',
			insertDiv : 'cdm-year-report-cdm-age-content'
		};
		$("#cdm-year-report-cdm-age-form").submitFormLoadHtml(option);
	}
	function toggle(obj, tableId)
	{
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	}
	
	return {
		toggle : toggle,
		getGengerResult:getGengerResult,
		getAgeResult:getAgeResult
	};

})();
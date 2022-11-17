/**
 * 慢病工作统计
 * @author liuk
 */

var cdmWorkStatistics = (function()
{
	function initTab(callback) {
		var $bar = $("#tags");
		$bar.find("a").on("click", function(event) {
			var $this = $(this);
			var target = $this.data("target");
			$bar.find("li.selectTag").removeClass("selectTag");
			$this.parent().addClass("selectTag");
			$("#tagContent").find(".tab-content").hide();
			$("#" + target).show();
			if(callback){
				callback(target);
			}
		});
	}
	
	$(function()
	{
		
		var $bar = $("#tags");
		
		initTab();
		
		// tab切换绑定
		$("#cdm-work-statistics-cdMonthResult-btn").on("click", function(event)
		{
			//electTag("tagContent0", this);
			cdMsReport();
		});
		$("#cdm-work-statistics-tuMonthResult-btn").on("click", function(event)
		{
			//selectTag("tagContent1", this);
			tumorMsReport();
		});
		$("#cdm-work-statistics-tumorPathologyResult-btn").on("click", function(event)
		{
			//selectTag("tagContent2", this);
			event.preventDefault();
			getTumorPathologyResult();
		});
		$("#cdm-work-statistics-manageAndFollowupResult-btn").on("click", function(event)
		{
			event.preventDefault();
			//selectTag("tagContent3", this);
			getManageAndFollowup();
		});
		$("#cdm-work-statistics-cdQuarterlyResult-btn").on("click", function(event)
		{
			event.preventDefault();
			//selectTag("tagContent4", this);
			cdSeasonReport();
		});
		$("#cdm-work-statistics-tuQuarterlyResult-btn").on("click", function(event)
		{
			event.preventDefault();
			//selectTag("tagContent5", this);
			tumorSeasonReport();
		});

		// search绑定
		$("#tumorPathologySearchButton").click(function(event)
		{
			event.preventDefault();
			getTumorPathologyResult();
		});

		$("#mafr_SearchButton").click(function(event)
		{
			event.preventDefault();
			getManageAndFollowup();
		});

		/*$("#cdm-ms-report-cd-form .search_btn").on("click", function(event)
		{
			event.preventDefault();
			cdMsReport();
		});*/
		
		$("#cdm-month-statistics-search").on("click", function(event)
		{
			event.preventDefault();
			cdMsReport();
		});
		
		

		/*$("#cdm-season-report-cd-form .search_btn").on("click", function(event)
		{
			event.preventDefault();
			cdSeasonReport();
		});*/
		
		$("#cdm-season-statistics-search").on("click", function(event)
		{
			event.preventDefault();
			cdSeasonReport();
		});

		/*$("#cdm-ms-report-tumor-form .search_btn").on("click", function(event)
		{
			event.preventDefault();
			tumorMsReport();
		});*/
		
		$("#tumor-month-statistics-search").on("click", function(event)
		{
			event.preventDefault();
			tumorMsReport();
		});

		/*$("#cdm-season-report-tumor-form .search_btn").on("click", function(event)
		{
			event.preventDefault();
			tumorSeasonReport();
		});*/
		
		$("#tumor-season-statistics-search").on("click", function(event)
		{
			event.preventDefault();
			tumorSeasonReport();
		});
		

		// 导出绑定
		$("#cdm-season-report-cd-export").on("click", function(event)
		{
			event.preventDefault();
			$("#cdm-season-report-cd-result").exportExcel();
		});

		$("#cdm-ms-report-cd-export").on("click", function(event)
		{
			event.preventDefault();
			$("#cdm-ms-report-cd-result").exportExcel();
		});

		$("#cdm-season-report-tumor-export").on("click", function(event)
		{
			event.preventDefault();
			$("#cdm-season-report-tumor-result").exportExcel();
		});

		$("#cdm-ms-report-tumor-export").on("click", function(event)
		{
			event.preventDefault();
			$("#cdm-ms-report-tumor-result").exportExcel();
		});

		$("#cdm-report-manageAndFollowup-export").on("click", function(event)
		{
			event.preventDefault();
			$("#cdm-report-manageAndFollowup-result").exportExcel();
		});
		$("#cdm-report-tumorPathology-export").on("click", function(event)
		{
			event.preventDefault();
			$("#cdm-report-tumorPathology-result").exportExcel();
		});
		cdMsReport();
		
		$bar.find("a:first").click();
		
	});
	// 纳入与随访
	function getManageAndFollowup()
	{
		var beginAge = $("#mafr_beginAge").val();
		var endAge = $("#mafr_endAge").val();
		var beginDate = new Date(beginAge);
		var endDate = new Date(endAge);
		if(beginDate>endDate){
			layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
			return false;
		}

		var option = {
			url : '/cdm/statistics/manageAndFollowup',
			insertDiv : 'manageAndFollowup_result',
			param : {

			}
		};
		$("#manageAndfFollowupForm").submitFormLoadHtml(option);
	}
	// 肿瘤病理
	function getTumorPathologyResult()
	{
		var beginAge = $("#pathologyBeginDate").val();
		var endAge = $("#pathologyEndDate").val();
		var beginDate = new Date(beginAge);
		var endDate = new Date(endAge);
		if(beginDate>endDate){
			layui.use('layer', function(){
				var layer = layui.layer;
				
				layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
			});
			return false;
		}
		var option = {
			url : '/cdm/statistics/tumorPathologyResult',
			insertDiv : 'tumorPathology_result',
		};
		$("#tumorPathologyForm").submitFormLoadHtml(option);
	}

	// 慢病月报
	function cdMsReport()
	{
		getResult("cdm-ms-report-cd-form", "/cdm/statistics/workStatistics/cdMoSeReport/reslut", "cdm-ms-report-cd-content");
	}
	// 慢病季报
	function cdSeasonReport()
	{
		getResult("cdm-season-report-cd-form", "/cdm/statistics/workStatistics/cdSeasonReport/reslut", "cdm-season-report-cd-content");
	}
	// 肿瘤月报
	function tumorMsReport()
	{
		getResult("cdm-ms-report-tumor-form", "/cdm/statistics/workStatistics/tumorMonthReport/reslut", "cdm-ms-report-tumor-content");
	}
	// 肿瘤季报
	function tumorSeasonReport()
	{
		getResult("cdm-season-report-tumor-form", "/cdm/statistics/workStatistics/tumorSeasonReport/reslut", "cdm-season-report-tumor-content");
	}

	// 查询通用方法
	function getResult(form, url, insertDiV)
	{
		var option = {
			url : url,
			insertDiv : insertDiV
		};
		$("#" + form).submitFormLoadHtml(option);
	}

	function toggle(obj, tableId)
	{
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	}
	return {
		toggle : toggle,
		cdMsReport:cdMsReport,
		cdSeasonReport:cdSeasonReport,
		tumorMsReport:tumorMsReport,
		tumorSeasonReport:tumorSeasonReport,
		getTumorPathologyResult:getTumorPathologyResult,
		getManageAndFollowup:getManageAndFollowup
	};
})();
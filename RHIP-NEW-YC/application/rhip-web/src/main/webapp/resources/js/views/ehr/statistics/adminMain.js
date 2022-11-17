var statisticsMain = (function()
{
	var starResultUrl = contextPath + "/star/statistics/result";
	var starJsonResultUrl = contextPath + "/star/statistics/result/json";
	var recordResultUrl = contextPath + "/star/record/statistics/result";
	var recordJsonResultUrl = contextPath + "/star/record/statistics/result/json";
	var townJsonResultUrl = contextPath + "/star/record/statistics/twonorgs";
	var orgs = null;
	var towns = null;
	var recordChar = null; // 图表实例
	var starChar = null;
	// 显示方式 图标或者表格
	var recordStatus = 1;
	var starStatus = 1;
	// 星级统计显示字段
	var starProper = {
		"personCount" : "应建档数",
		"recordCount" : "总档案数",
		"oneStarRecordCount" : "一星档案数",
		"twoStarRecordCount" : "二星档案数",
		"threeStarRecordCount" : "三星档案数",

		"recordOccupancy" : "总建档率",
		"oneStarRecordOccupancy" : "一星建档率",
		"twoStarRecordOccupancy" : "二星建档率",
		"threeStarRecordOccupancy" : "三星建档率",

		"recordIntegrity" : "总完整率",
		"oneStarRecordIntegrity" : "一星完整率",
		"twoStarRecordIntegrity" : "二星完整率",
		"threeStarRecordIntegrity" : "三星完整率",

		"twoAboveStarRecordCount" : "二星以上档案数",
		"twoAboveStarRecordOccupancy" : "二星以上建档率",
		"twoAboveStarRecordIntegrity" : "二星以上完整率"
	};

	// 档案统计显示字段
	var recordProper = {
		"personCount" : "常住人口",
		"recordCount" : "建档数",
		"recordOccupancy" : "建档率",

		"householdPersonCount" : "户籍人口",
		"householdRecordCount" : "户籍建档数",
		"householdRecordOccupancy" : "户籍建档率",

		"unhouseholdPersonCount" : "非户籍人口",
		"unhouseholdRecordCount" : "非户籍建档数",
		"unhouseholdPecordOccupancy" : "非户籍建档率"
	};

	$(function()
	{
		// tab切换
		/*$("#star_statistics_btn").on("click", function(event)
		{
			selectTag("tagContent0", this);
		});*/
		// tab切换>显示档案统计
		/*$("#record_statistics_btn").on("click", function(event)
		{
			selectTag("tagContent1", this);
			// 第一次打开档案统计,执行查询
			if (!$("#record_statistics_btn").hasClass("loaded"))
			{
				getRecordResult();
				initTown("record_twon_se", "record_org_se");
			}

		});*/

		// 星级条件切换
		$("#time_range_con").on("click", "input", function(event)
		{
			$(".time_range_targets").hide();
			var idVal = $(this).attr("id");
			var targetIdVal = idVal.replace("_btn", "_target");
			$("#" + targetIdVal).show();
		});

		// 星级统计执行搜索
		$("#star_statistics_search_btn").on("click", function(event)
		{
			event.preventDefault();
			getStarResult();
		});

		// 档案统计执行搜索
		$("#record_statistics_search_btn").on("click", function(event)
		{
			event.preventDefault();
			getRecordResult();
		});
		// 获取镇>中心和院下拉框数据,并初始化
		//getTwonOrgSelectData();

		// 数据显示方式切换,并获取数据
		$("#record_table_ra").on("click", function(event)
		{
			updateRecordStatus(0);
		});
		// 数据显示方式切换,并获取数据
		$("input[name='record_chart_toggle']").on("click", function(event)
		{
			updateRecordStatus(parseInt($(this).val()));
		});

		$("input[name='star_chart_toggle']").on("click", function(event)
		{
			updateStarStatus(parseInt($(this).val()));
		});

		getStarResult();

		// 预先new出图表
		starChar = showChart(starChar, buildHighChartDataSource(null, starProper), "星级统计", "star_statistics_chart");
		recordChar = showChart(recordChar, buildHighChartDataSource(null, recordProper), "档案统计", "record_statistics_chart");

	});

	// 获取星级统计数据

	function getStarResult()
	{
		if (starCheck())
		{
			// 判断显示方式
			if (starStatus === 0)
			{
				$("#star_statistics_con").show();
				$("#star_statistics_chart").hide();
				getStarResultForTable();
			} else
			{
				$("#star_statistics_con").hide();
				$("#star_statistics_chart").show();
				getStarResultForChart();
			}
		}
	}

	function getStarResultForTable()
	{
		$("#star_statistics_from").submitFormLoadHtml({
			url : starResultUrl,
			insertDiv : "star_statistics_con"
		});
	}

	function getStarResultForChart()
	{
		getJson("star_statistics_from", "star_statistics_chart", starJsonResultUrl, starChar, function(data)
		{
			var res = buildHighChartDataSource(data, starProper);
			starChar = showChart(starChar, res, "星级统计", "star_statistics_chart");
		});
	}

	// 获取档案统计数据

	function getRecordResult()
	{
		if (recordCheck())
		{
			// 判断显示方式
			if (recordStatus === 0)
			{
				$("#record_statistics_con").show();
				$("#record_statistics_chart").hide();
				getRecordResultForTable();
			} else
			{
				$("#record_statistics_con").hide();
				$("#record_statistics_chart").show();
				getRecordResultForChart();
			}
		}
		// 执行一次后,标记切换tab时不再查询
		$("#record_statistics_btn").addClass("loaded");
	}

	function getRecordResultForTable()
	{
		$("#record_statistics_from").submitFormLoadHtml({
			url : recordResultUrl,
			insertDiv : "record_statistics_con"
		});
	}

	function getRecordResultForChart()
	{
		getJson("record_statistics_from", "record_statistics_chart", recordJsonResultUrl, recordChar, function(data)
		{
			var res = buildHighChartDataSource(data, recordProper);
			recordChar = showChart(recordChar, res, "档案统计", "record_statistics_chart");
		});
	}

	function updateRecordStatus(status)
	{
		if (recordStatus != status)
		{
			recordStatus = status;
			getRecordResult();
		}
	}

	function updateStarStatus(status)
	{
		if (starStatus != status)
		{
			starStatus = status;
			getStarResult();
		}
	}

	// ==========统计图表 start=================//

	function buildHighChartDataSource(data, proper)
	{
		var series = [];
		var categories = [];
		if (data && data.length > 1)
		{
			var len = data.length;
			for ( var key in proper)
			{
				var column = {};
				var name = proper[key];
				column.name = name;
				var datas = [];
				for ( var j = 0; j < len - 1; j++)
				{
					datas[j] = data[j][key];
				}
				column.data = datas;
				series.push(column);
			}

			var titleRowLen = 4;

			for ( var j = 0; j < data.length - 1; j++)
			{
				var title = data[j].title;
				categories[j] = split(title, titleRowLen, "");
			}

		} else
		{
			for ( var key in proper)
			{
				var column = {};
				var name = proper[key];
				column.name = name;
				column.data = [ 0 ];// 给默认值0,否则highchart不会构造列,造成null引用
				series.push(column);
			}
			categories[0] = "";
		}
		return {
			"series" : series,
			"categories" : categories
		};
	}

	function showChart(chart, dataSource, title, renderTo)
	{
		if (null != chart)
		{
			if (dataSource && dataSource.series)
			{
				for ( var j = 0; j < dataSource.series.length; j++)
				{
					chart.series[j].setData(dataSource.series[j].data, false);
				}
				chart.xAxis[0].setCategories(dataSource.categories, false);

			} else
			{
				for ( var j = 0; j < chart.series.length; j++)
				{
					chart.series[j].setData([ 0 ], false);
				}
				chart.xAxis[0].setCategories([ "" ], false);
			}
			chart.redraw();
			chart.hideLoading();
			return chart;
		}
		var option = {
			chart : {
				renderTo : renderTo,
				type : 'column',
				width : $("#tagContent").width(),
				style : {
					margin : '0 auto'
				}
			},
			credits : {
				enabled : false
			},
			legend : {
				itemHiddenStyle : {
					color : '#999'
				}
			},
			title : {
				text : title
			},
			xAxis : {
				categories : [],
				labels:{
					y:80,
					rotation:-55,
				}
			},
			yAxis : {
				title : {
					text : ''
				}
			},
			exporting : {
				enabled : false
			},
			lang : {
				numericSymbols : 'null'
			},
			tooltip : {
				formatter : function()
				{
					var s = this.series.name + ': ';
					if (this.y > 0 && this.y < 1)
					{
						var num = new Number(this.y * 100);
						s += num.toFixed(2) + "%";
					} else
					{
						s += Highcharts.numberFormat(this.y, 0);
					}

					return s;
				}
			},
			series : []
		};
		if (dataSource)
		{
			option.series = dataSource.series;
			option.xAxis.categories = dataSource.categories;
		}
		chart = new Highcharts.Chart(option);
		// 默认显示前2个
		var length = chart.series.length;
		for ( var j = 2; j < length; j++)
		{
			var series = chart.series[j];
			series.hide();
		}
		return chart;
	}

	function getJson(formId, targetId, url, chart, callback)
	{
		if (chart)
		{
			chart.showLoading("数据加载中...");
		} else
		{
			$("#" + targetId).empty();
			$("#" + targetId).append(loadingSource);
		}
		$("#" + formId).submitFormGetJson({
			url : url,
			callback : callback
		});
	}

	function filterSeries(chart, arr)
	{
		if (arr)
		{
			var length = arr.length;
			var seriesLength = chart.series.length;
			for ( var i = 2; i < length; i++)
			{
				var index = arr[i];
				if (index < seriesLength)
				{
					chart.series[index].hide();
				}
			}
		}
	}

	// ==========统计图表 end=================//

	function starCheck()
	{
		if ($("#ranget_time_btn").prop("checked"))
		{
			return dateRangeCheck("starStartDate", "starEndDate");
		}
		return true;
	}

	function recordCheck()
	{
		return dateRangeCheck("recordStartDate", "recordEndDate") && ageRangeCheck("recordStartAge", "recordEndAge");
	}

	function dateRangeCheck(startId, endId)
	{
		var startDateVal = $("#" + startId).val();
		var endDateVal = $("#" + endId).val();
		if (startDateVal && endDateVal)
		{
			var startDate = new Date(startDateVal);
			var endDate = new Date(endDateVal);
			if (null == startDate || null == endDate)
			{
				layer.alert("请填写正确的日期！", {icon:0,title:'提示'});
				return false;
			} else if (startDate > endDate)
			{
				layer.alert("开始日期不能大于结束日期！", {icon:0,title:'提示'});
				return false;
			}
		}
		return true;
	}

	function ageRangeCheck(startId, endId)
	{
		var startAgeVal = $("#" + startId).val();
		var endAgeVal = $("#" + endId).val();
		if (startAgeVal && endAgeVal)
		{
			var startAge = parseInt(startAgeVal);
			var endAge = parseInt(endAgeVal);
			if (startAge > endAge)
			{
				layer.alert("开始年龄不能大于结束年龄！", {icon:0,title:'提示'});
				return false;
			}
		}
		return true;
	}

	function split(msg, num, s)
	{
		var len = msg.length;

		if (len <= num)
		{
			return msg;
		} else
		{
			var res = "";
			while (len > num)
			{
				res += msg.substring(0, num) + s;
				msg = msg.substring(num, len);
				len = msg.length;
			}
			res += msg;
			return res;
		}

	}

	// ========镇选中心和远的级联下拉框 start========//

	function getTwonOrgSelectData(){
		//if ($("#star_twon_se").length > 0 && $("#star_org_se").length > 0){
			$.getJsonByUrl({
				url : townJsonResultUrl,
				callback : function(data){
					orgs = data.orgs;
					towns = data.towns;
					initTown("star_twon_se", "star_org_se");
				}
			});
		//}
	}

	function initTown(townSelectId, orgSelectId){
		var key = null;
		var $townSelect = $("#" + townSelectId);
		$townSelect.empty();
		$townSelect.append("<option value='' >请选择</option>");
		var gbcodes = [];
		for (key in towns){
			gbcodes.push(key);
		}
		// 增加排序
		gbcodes.sort();
		for (key in gbcodes){
			key = gbcodes[key];
			$townSelect.append("<option title=" + towns[key] + " value='" + key + "'  >" + towns[key] + "</option>");
		}
		$townSelect.on("change", function(e){
			$("#" + orgSelectId).hide();
			setOrgSelect($townSelect.val(), orgSelectId);
		});
		showSelectTip(townSelectId);
		showSelectTip(orgSelectId);
	}

	function setOrgSelect(key, orgSelectId){
		var $orgSelect = $("#" + orgSelectId);
		$orgSelect.empty();
		if (key){
			var data = orgs[key];
			$orgSelect.attr("title", "");
			if (data){
				$.each(data, function(index, item){
					if (0 === index)
					{
						$orgSelect.attr("title", item.value);
					}
					$orgSelect.append("<option title=" + item.value + " value='" + item.key + "'  >" + item.value + "</option>");
				});
				$orgSelect.show();
				return;
			}
		}
		$orgSelect.append("<option value='' >请选择</option>");
	}

	function showSelectTip(selectId)
	{
		var $target = $("#" + selectId);
		$target.on("change", function()
		{
			var value = $target.find('option:selected').text() || "";
			$target.attr("title", value);
		});
	}
	
	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	};
	
	return {
		toggle : toggle,
		getRecordResult:getRecordResult,
		initTown:initTown
	};

	// ========镇选中心和远的级联下拉框 end========//

})();
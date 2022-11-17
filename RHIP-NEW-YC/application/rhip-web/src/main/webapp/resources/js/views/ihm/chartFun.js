define(function(){
	/**
	 * 柱状图
	 * @param result
     */
	function getBarChartOption(result){
		var title = result.title;
		var subtitle = result.subTitle;

		var option = {
			title : {
				text: title,
				subtext: subtitle,
			},
			tooltip : {
				trigger: 'axis'
			},
			toolbox: {
				show : true,
				feature : {
					mark : {show: true},
					dataView : {show: true, readOnly: false},
					restore : {show: true},
					saveAsImage : {show: true}
				}
			},
			legend: {
				data:result.legendJSON
			},
			calculable : true,
			xAxis : [
				{
					type : 'category',
					axisLabel:{
						interval:0,
						rotate:35,
						margin:2,
						textStyle:{
							color:"#222"
						}
					},
					data : result.xAxisJSON
				}
			],
			yAxis : [
				{
					type : 'value'
				}
			],
			series : result.seriesJSON
		};
		return option;
	}

	/**
	 * 折线图
	 * @param result
	 */
	function getLineChartOption(result){
		var title = result.title;
		var subtitle = result.subTitle;

		var option = {
			title : {
				text: title,
				subtext: subtitle,
			},
			tooltip : {
				trigger: 'axis'
			},
			legend: {
				data:result.legendJSON
			},
			calculable : true,
			xAxis : [
				{
					type : 'category',
					axisLabel:{
						interval:0,
						rotate:45,
						margin:2,
						textStyle:{
							color:"#222"
						}
					},
					data : result.xAxisJSON
				}
			],
			yAxis : [
				{
					type : 'value',
					axisLabel: {
						formatter: '{value} '+ result.unit
					}
				}
			],
			series : result.seriesJSON
		};
		return option;
	}

	/**
	 * 仪表盘图
	 * @param result
	 */
	function getGaugeChartOption(result){
		var title = result.title;
		var subtitle = result.subTitle;
		var max = result.max == null?100:result.max;
		var option = {
			tooltip : {
				formatter: "{a} <br/>{b} : {c}"+ result.unit
			},
			toolbox: {
				feature: {
					restore: {},
					saveAsImage: {}
				}
			},
			series: [
				{
					name: title,
					type: 'gauge',
					max:max,
					center: ['50%', '50%'],    // 默认全局居中
					detail: {formatter:'{value}'+ result.unit},
					data: result.seriesJSON
				}
			]
		};
		return option;
	}

	function getRadarOption(result){
		var title = result.title;
		var option = {
			title: {
				text: title
			},
			tooltip: {
				trigger: 'axis'
			},
			legend: {
				x: 'center',
				data:[]
			},
			radar: result.radarJSON,
			series:result.seriesJSON
		};
		return option;
	}

	function getYcategoryOption(result){
		var title = result.title;
		var subtitle = result.subTitle;

		var extraTooltip1 = "";
		var extraTooltip2 = "";
		var extraTooltip3 = "";
		var tooltip1 = "";
		var tooltip2 = "";
		var tooltip3 = "";
		if(!$.isEmpty(result.extraTooltipJSON)){
			if(result.extraTooltipJSON.length == 1){
				extraTooltip1 = result.extraTooltipJSON[0];
			}else if(result.extraTooltipJSON.length == 2){
				extraTooltip1 = result.extraTooltipJSON[0];
				extraTooltip2 = result.extraTooltipJSON[1];
			}else if(result.extraTooltipJSON.length == 3){
				extraTooltip1 = result.extraTooltipJSON[0];
				extraTooltip2 = result.extraTooltipJSON[1];
				extraTooltip3 = result.extraTooltipJSON[2];
			}
		}
		if(!$.isEmpty(result.tooltipJSON)){
			if(result.tooltipJSON.length == 1){
				tooltip1 = result.tooltipJSON[0];
			}else if(result.tooltipJSON.length == 2){
				tooltip1 = result.tooltipJSON[0];
				tooltip2 = result.tooltipJSON[1];
			}else if(result.tooltipJSON.length == 3){
				tooltip1 = result.tooltipJSON[0];
				tooltip2 = result.tooltipJSON[1];
				tooltip3 = result.tooltipJSON[2];
			}
		}
		var tooltipFormatter = "{b}<br/>{a0} " + extraTooltip1 + "：{c0} " + tooltip1;
		if(result.seriesJSON.length == 2){
			tooltipFormatter = "{b}<br/>{a0} " + extraTooltip1 + "：{c0} " + tooltip1 + "<br/>{a1} " + extraTooltip2 + "：{c1} " + tooltip2;
		}
		if(result.seriesJSON.length == 3){
			tooltipFormatter = "{b}<br/>{a0} " + extraTooltip1 + "： {c0} " + tooltip1 + "<br/>{a1} " + extraTooltip2 + "：{c1} " + tooltip2 + "<br/>{a2} " + extraTooltip3 + "：{c2} " + tooltip3;
		}
		var option = {
			title : {
				text: title,
				subtext: subtitle,
			},
			tooltip : {
				trigger: 'axis',
				formatter: tooltipFormatter
			},
            toolbox: {
                show : true,
                feature : {
                    dataView : {show: true, readOnly: false},
                    restore : {show: true},
                    saveAsImage : {show: true}
                }
            },
			legend: {
				data:result.legendJSON
			},
			calculable : true,
			xAxis : [
				{
					type : 'category',
					axisLabel:{
						interval:0,
						rotate:35,
						margin:2,
						textStyle:{
							color:"#222"
						}
					},
					data : result.xAxisJSON
				}
			],
			grid: {
				left:100,
				right:100,
				top: 80,
				bottom: 150
			},
			yAxis : result.yAxisJSON,
			series : result.seriesJSON
		};
		return option;
	}
	
	function getYcategoryTimeLineBarOption(result){
		var option = {
			baseOption: {
				timeline: {
					axisType: 'category',
					autoPlay: false,
					playInterval: 2000,
					currentIndex:result.currentIndex,
					data: result.timeLineJSON,
					label: {
						formatter : function(s) {
							return /*(new Date(s)).getFullYear()*/s;
						}
					}
				},
				toolbox: {
					show : true,
					feature : {
						mark : {show: true},
						dataView : {show: true, readOnly: false},
						restore : {show: true},
						saveAsImage : {show: true}
					}
				},
				title: {
					subtext: ''
				},
				tooltip: {},
				legend: {
					x: 'center',
					data: [result.legendJSON]
				},
				calculable : true,
				grid: {
					top: 60,
					bottom: 100
				},
				xAxis: [
					{
						'type':'category',
						'axisLabel':{
							interval:0,
							rotate:25,
							margin:2,
							textStyle:{
								color:"#222"
							}
						},
						'data':result.xAxisJSON,
						splitLine: {show: false}
					}
				],
				yAxis: result.yAxisJSON,
				series: result.seriesJSON
			},
			options: result.optionJSON
		};
		return option;
	}
	//显示饼图
	function getPieChartOption(result,radius){
		var title = result.title;
		var subtitle = result.subTitle;
		radius = $.isEmpty(radius)?'70%':radius
		var option = {
			title : {
				text: title,
				subtext: subtitle,
				x:'center'
			},
			tooltip : {
				trigger: 'item',
				formatter: "{a} <br/>{b} : {c} ({d}%)"
			},
			legend: {
				orient: 'vertical',
				left: '2%',
				data: result.legendJSON
			},
			grid: {
				left: '2%',
				right: '2%',
				bottom: '1%',
				top:'2%'
			},
			series : [
				{
					name: title,
					type: 'pie',
					radius :  [0, radius],
					center: ['50%', '50%'],
					data:result.seriesJSON,
					itemStyle: {
						emphasis: {
							shadowBlur: 10,
							shadowOffsetX: 0,
							shadowColor: 'rgba(0, 0, 0, 0.5)'
						}
					}
				}
			]
		};
		return option;
	}

	/**
	 * 排名
	 * @param result
     */
	function getRankingBarOption(result){
		var title = result.title;
		var subtitle = result.subTitle;

		var option = {
			title : {
				text: title,
				subtext: subtitle,
			},
			tooltip : {
				trigger: 'axis',
				formatter: "{a} <br/>{b} : {c}"
			},
			toolbox: {
				show : true,
				feature : {
					mark : {show: true},
					dataView : {show: true, readOnly: false},
					restore : {show: true},
					saveAsImage : {show: true}
				}
			},
			legend: {
				data:result.legendJSON
			},
			calculable : true,
			xAxis : [
				{
					type : 'value',
					axisLabel: {
						formatter: '{value} '+ result.unit
					}
				}
			],
			grid: {
				left:120,
				right:80,
				top: 80,
				bottom: 100
			},
			yAxis : {
				type : 'category',
				axisLabel:{
					rotate:35,
					margin:2,
					textStyle:{
						color:"#222"
					}
				},
				data : result.yAxisJSON
			},
			series : result.seriesJSON
		};
		return option;
	}

	return{
		getBarChartOption:getBarChartOption,
		getLineChartOption:getLineChartOption,
		getGaugeChartOption:getGaugeChartOption,
		getRadarOption:getRadarOption,
		getYcategoryOption:getYcategoryOption,
		getYcategoryTimeLineBarOption:getYcategoryTimeLineBarOption,
		getPieChartOption:getPieChartOption,
		getRankingBarOption:getRankingBarOption
	};
});

define(function(){
	//显示饼图
	function getPieChartOption(result){
		var title = result.title;
		var subtitle = result.subTitle;
		var option = {
			title : {
				text: title,
				subtext: subtitle,
				x:'right' ,
                y: 'top',
                textStyle: {
                    fontSize: 14,
                    color: '#00BFFF'          // 主标题文字颜色
                },
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
					radius :  [0, '65%'],
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

	//显示环形图
	function getCirclineChartOption(result){
		var title = result.title;
		var option = {
			tooltip: {
				trigger: 'item',
				formatter: "{a} <br/>{b}: {c} ({d}%)"
			},
			legend: {
				orient: 'vertical',
				x: 'left',
				data:result.legendJSON
			},
			series: [
				{
					name:title,
					type:'pie',
					radius: ['50%', '70%'],
					avoidLabelOverlap: false,
					label: {
						normal: {
							show: false,
							position: 'center'
						},
						emphasis: {
							show: true,
							textStyle: {
								fontSize: '30',
								fontWeight: 'bold'
							}
						}
					},
					labelLine: {
						normal: {
							show: false
						}
					},
					data:result.seriesJSON
				}
			]
		};
		return option;
	}

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
                left:'right'
            },
			tooltip : {
				trigger: 'axis'
			},
            grid: {
                bottom:100
            },
			legend: {
				data:result.legendJSON,
                orient: 'horizontal', // 'vertical'
                x: 'left', // 'center' | 'left' | {number},
                y: 'top', // 'center' | 'bottom' | {number}

            },
			calculable : true,
			xAxis : [
				{
					type : 'category',
					axisLabel:{
						interval:0,
						rotate:28,
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
     * 多轴柱状图
     * @param result
     */
    function getMulYAxisBarChartOption(result){
        var title = result.title;
        var subtitle = result.subTitle;

        var option = {
            title : {
                text: title,
                subtext: subtitle,
                left:'right'
            },
            tooltip : {
                trigger: 'axis'
            },
            grid: {
                bottom:100
            },
            legend: {
                data:result.legendJSON,
                orient: 'horizontal', // 'vertical'
                x: 'left', // 'center' | 'left' | {number},
                y: 'top', // 'center' | 'bottom' | {number}

            },
            calculable : true,
            xAxis : [
                {
                    type : 'category',
                    axisLabel:{
                        interval:0,
                        rotate:28,
                        margin:2,
                        textStyle:{
                            color:"#222"
                        }
                    },
                    data : result.xAxisJSON
                }
            ],
            yAxis : result.yAxisJSON,
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
		var option = {
			tooltip : {
				trigger: 'item',
				axisPointer : {            // 坐标轴指示器，坐标轴触发有效
					type : 'line'        // 默认为直线，可选为：'line' | 'shadow'
				},
				formatter: function (params, ticket, callback) {
					console.log(params);
					//x轴名称
					var name = params.name;
					//图表title名称
					var seriesName = params.seriesName;
					//值
					var value = Math.abs(params.value);
					return seriesName + '<br />' + '年龄:' + name + '<br />' + '人口:' + value
				}
			},
			legend: {
				data:result.legendJSON
			},
			grid: {
				left: '3%',
				right: '4%',
				bottom: '3%',
				containLabel: true
			},
			xAxis : [
				{
					type : 'value',
					axisLabel : {
						formatter: function (value){return Math.abs(value);}
					}
				}
			],
			yAxis : [
				{
					type : 'category',
					axisTick : {show: true},
					data : result.categoriesJSON
				}
				,{
					type : 'category',
					axisTick : {show: true},
					data : result.categoriesJSON
				}
			],
			series :result.seriesJSON
		};
		return option;
	}
	
	function getTimeLineBarOption(result){
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
				yAxis: [
					{
						type: 'value',
						name: result.yAxis
					}
				],
				series: [
					{name: result.legendJSON, type: 'bar'}
				]
			},
			options: result.optionJSON
		};
		return option;
	}

	function getTimeLinePieOption(result){
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
				title: {
					subtext: result.subTitleJSON
				},
				tooltip: {},
				legend: {
					x: 'right',
					data: result.legendJSON
				},
				calculable : true,
				grid: {
					top: 100,
					bottom: 100
				},
				series: [
					{
						name: result.seriesNameJSON,
						type: 'pie',
						radius :  '70%',
						center: ['50%', '50%'],
						itemStyle: {
							emphasis: {
								shadowBlur: 10,
								shadowOffsetX: 0,
								shadowColor: 'rgba(0, 0, 0, 0.5)'
							}
						}
					}
				]
			},
			options: result.optionJSON
		};
		return option;
	}
	
	return{
		getPieChartOption: getPieChartOption,
		getBarChartOption:getBarChartOption,
        getMulYAxisBarChartOption:getMulYAxisBarChartOption,
		getLineChartOption:getLineChartOption,
		getGaugeChartOption:getGaugeChartOption,
		getCirclineChartOption:getCirclineChartOption,
		getRadarOption:getRadarOption,
		getYcategoryOption:getYcategoryOption,
		getTimeLineBarOption:getTimeLineBarOption,
		getTimeLinePieOption:getTimeLinePieOption
	};
});

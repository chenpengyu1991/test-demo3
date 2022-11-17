define(function(){
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
			toolbox: {
				show: true,
				feature: {
					saveAsImage: {}
				}
			},
			grid: {
				left: '10',
				right: '10',
				bottom: '30',
				containLabel: true
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

	return{
		getLineChartOption:getLineChartOption
	};
});

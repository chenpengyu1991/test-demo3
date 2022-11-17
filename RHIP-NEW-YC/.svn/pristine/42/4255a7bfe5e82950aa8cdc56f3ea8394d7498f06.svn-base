var populationIndexChart = (function() {

	$(document).ready(
		function() {
			var male = getNumVal("male");
			var female = getNumVal("female");
			openChart(male, female);
		});

	function openChart(maleData, femaleData) {
		var max = 0;
		var i = 0;
		for (; i < maleData.length; i++) {
			var value = maleData[i] || 0;
			if (value > max) {
				max = value;
			}
			maleData[i] = 0 - value;
		}

		for (i = 0; i < femaleData.length; i++) {
			var value = femaleData[i] || 0;
			if (value > max) {
				max = value;
			}
		}

		var categories = ['0-5', '5-10', '10-15', '15-20',
			'20-25', '25-30', '30-35', '35-40', '40-45',
			'45-50', '50-55', '55-60', '60-65', '65-70',
			'70-75', '75-80', '80-85', '85-90', '90+'];
		var chart = new Highcharts.Chart(
			{
				chart: {
					renderTo: "chartContainer",
					type: 'bar',
					marginLeft: 40,
					marginRight: 40,
					width: 870,
					height: 510
				}, credits: {
				enabled: false
			}, exporting: {
				enabled: false
			},
				title: {
					text: '人口金字塔'
				},
				subtitle: {
					text: ''
				},
				xAxis: [
					{
						categories: categories,
						reversed: false,
						labels: {
							step: 1
						}
					},
					{ // mirror axis on right side
						opposite: true,
						reversed: false,
						categories: categories,
						linkedTo: 0,
						labels: {
							step: 1
						}
					}
				],
				yAxis: {
					title: {
						text: null
					}, labels: {
						formatter: function () {
							return (Math.abs(this.value) );
						}
					}, max: max,
					min: 0 - max

				},

				plotOptions: {
					series: {
						stacking: 'normal'
					}
				},

				tooltip: {
					formatter: function () {
						return  this.series.name + '<br/>年龄:' + this.point.category + '<br/>' +
							'人口: ' + Highcharts.numberFormat(Math.abs(this.point.y), 0);
					}
				},

				series: [
					{
						name: '男',
						data: maleData
					},
					{
						name: '女',
						data: femaleData
					}
				]
			});
	};

	function getNumVal(inputVal) {
		var val = $("#" + inputVal).val();
		var result = val.split(",");
		for(var i = 0; i<result.length; i++){
			if (isNaN(result[i])) {
				result[i] = 0;
			}
			result[i] = parseInt(result[i]);
		}
		return result;
	}
	
	function viewPolulationDetail() {
		$("#populationChart").hide();
		$("#populationDetail").show();
		var options = {
                url: contextPath + "/ihm/ehr/population/search",
                param : {from : 'ihm'},
                insertDiv: "populationDetail"
            };
            $.loadHtmlByUrl(options);
	}

	return {
		viewPolulationDetail:viewPolulationDetail
	}
})();

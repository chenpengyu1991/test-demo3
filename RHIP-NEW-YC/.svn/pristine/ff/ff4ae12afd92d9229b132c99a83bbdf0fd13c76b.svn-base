var communityMajorCrowd = (function() {

	$(function() {
		init();
		$("input[name=RadioGroup5_other]").on("click", function() {
			getMajorCrowdList();
		});
	});

	function init() {
		getMajorCrowdList();
	}

	function getMajorCrowdList() {
		var statisticsDate = $("input[name=RadioGroup5_other]:checked").val();
		var param = {
			url : contextPath + "/haStatistics/getCommunityMajorCrowdList",
			param : {
				'statisticsDate' : statisticsDate
			},
			checkRepeat : true,
			callback : callback
		};
		$.getJsonByUrl(param);
	}

	function callback(data) {
		var hrSixChild = 0;
		var hrFertileWoman = 0;
		var hrSixoToSixf = 0;
		var hrGreatSixf = 0;
		var unhrSixChild = 0;
		var unhrFertileWoman = 0;
		var unhrSixoToSixf = 0;
		var unhrGreatSixf = 0;
		for ( var i = 0; i < data.length; i++) {
			hrSixChild += parseInt(data[i]['hrSixChild']);
			hrFertileWoman += parseInt(data[i]['hrFertileWoman']);
			hrSixoToSixf += parseInt(data[i]['hrSixoToSixf']);
			hrGreatSixf += parseInt(data[i]['hrGreatSixf']);
			unhrSixChild += parseInt(data[i]['unhrSixChild']);
			unhrFertileWoman += parseInt(data[i]['unhrFertileWoman']);
			unhrSixoToSixf += parseInt(data[i]['unhrSixoToSixf']);
			unhrGreatSixf += parseInt(data[i]['unhrGreatSixf']);
		}
		Highcharts.setOptions({
			lang : {
				numericSymbols : null
			}
		});
		var chart = new Highcharts.Chart({
			chart : {
				renderTo : 'majorCrowdChart'
			},
			credits : {
				enabled : false
			},
			title : {
				text : '重点人群'
			},
			xAxis : {
				categories : [ '0~6岁儿童', '育龄妇女', '≥60岁老人', '≥65岁老人' ]
			},
			yAxis : {
				title : {
					text : '人'
				}
			},
			exporting : {
				enabled : false
			},
			lang : {
				numericSymbols : 'null'
			},
			tooltip : {
				formatter : function() {
					var s;
					s = '' + this.series.name + ': '
							+ Highcharts.numberFormat(this.y, 0);
					return s;
				}
			},
			series : [{
						type : 'column',
						name : '户籍',
						data : [ hrSixChild, hrFertileWoman, hrSixoToSixf,hrGreatSixf ]
					},
					{
						type : 'column',
						name : '非户籍',
						data : [ unhrSixChild, unhrFertileWoman,unhrSixoToSixf, unhrGreatSixf ]
					}]
		});

	}

})();
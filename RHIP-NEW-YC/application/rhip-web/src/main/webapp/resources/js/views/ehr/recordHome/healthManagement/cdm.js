var cdcCdm = (function() {

	$(function() {

		getIdmStatistics(2);

		$("input[name=RadioGroup5_other]").on("click", function() {
			getIdmStatistics($("input[name=RadioGroup5_other]:checked").val());
		});
	});

	function getIdmStatistics(statisticsDate) {
		$.getJsonByUrl({
			url : "/haStatistics/centerIdmStatistics",
			param : {
				'statisticsDate' : statisticsDate
			},
			callback : callback
		});
	}

	function callback(data) {
		var hrHbp = 0;
		var hrDi = 0;
		var hrTumor = 0;
		var hrCoronary = 0;
		var hrStroke = 0;
		var unhrHbp = 0;
		var unhrDi = 0;
		var unhrTumor = 0;
		var unhrCoronary = 0;
		var unhrStroke = 0;
		for ( var i = 0; i < data.length; i++) {
			if (data[i]['HOUSEHOLD_TYPE'] == 1) {
				hrHbp += parseInt(data[i]['HBP_TOTAL']);
				hrDi += parseInt(data[i]['DI_TOTAL']);
				hrTumor += parseInt(data[i]['TUMOR_TOTAL']);
				hrStroke += parseInt(data[i]['STROKE_TOTAL']);
				hrCoronary += parseInt(data[i]['CORONARY_TOTAL']);
			} else if (data[i]['HOUSEHOLD_TYPE'] == 2) {
				unhrHbp += parseInt(data[i]['HBP_TOTAL']);
				unhrDi += parseInt(data[i]['DI_TOTAL']);
				unhrTumor += parseInt(data[i]['TUMOR_TOTAL']);
				unhrStroke += parseInt(data[i]['STROKE_TOTAL']);
				unhrCoronary += parseInt(data[i]['CORONARY_TOTAL']);
			}
		}
		Highcharts.setOptions({
			lang : {
				numericSymbols : null
			}
		});
		var chart = new Highcharts.Chart({
			chart : {
				renderTo : 'cdmChart'
			},
			credits : {
				enabled : false
			},
			title : {
				text : '慢病管理'
			},
			xAxis : {
				categories : [ '高血压', '糖尿病', '肿瘤', '冠心病', '脑卒中' ]
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
			series : [ {
				type : 'column',
				name : '户籍',
				data : [ hrHbp, hrDi, hrTumor, hrCoronary, hrStroke ]
			}, {
				type : 'column',
				name : '非户籍',
				data : [ unhrHbp, unhrDi, unhrTumor, unhrCoronary, unhrStroke ]
			} ]
		});
	}
	return {getIdmStatistics:getIdmStatistics}
})();
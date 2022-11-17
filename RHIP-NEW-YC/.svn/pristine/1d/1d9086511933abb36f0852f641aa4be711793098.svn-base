var homePage = (function() {
	var chart;
	function getNumVal(inputVal) {
		var val = $("#" + inputVal).val();
		if (isNaN(val)) {
			return 0;
		}
		return parseInt(val);
	}
	$(document).ready(
			function() {
				var children = getNumVal("children");
				var woman = getNumVal("woman");
				var old = getNumVal("old");
				var oldder = getNumVal("oldder");
				var children_ = getNumVal("children_");
				var woman_ = getNumVal("woman_");
				var old_ = getNumVal("old_");
				var oldder_ = getNumVal("oldder_");

				Highcharts.setOptions({
					lang : {
						numericSymbols : null
					}
				});
				chart = new Highcharts.Chart({
					chart : {
						renderTo : 'chartContainer'
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
									+ Highcharts.numberFormat(this.y,0);
							return s;
						}
					},
					series : [ {
						type : 'column',
						name : '户籍',
						data : [ children, woman, old, oldder ]
					}, {
						type : 'column',
						name : '非户籍',
						data : [ children_, woman_, old_, oldder_ ]
					} ]
				});
			});
	
	$("#popDis").on("click", function(event) {
		event.preventDefault();
		var dialogObj = {
			url : contextPath + "/populace/popDistribution",
			title : "人口分布",
			height : '600px',
			width : '900px'
		};
		jQuery.dialog(dialogObj);
	});
	$(function(){
		$("#popStatics").click(popTarget);
	});
	function popTarget() {
		var dialogObj = {
				url : contextPath + "/populace/popTarget",
				title : "人口统计",
				height : '600px',
				width : '1000px'
			};
			jQuery.dialog(dialogObj);
	}
})();

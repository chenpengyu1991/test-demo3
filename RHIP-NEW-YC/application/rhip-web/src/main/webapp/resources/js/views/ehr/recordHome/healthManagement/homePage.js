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
				var phb = getNumVal("phb");
				var di = getNumVal("di");
				var mental = getNumVal("mental");
				var children = getNumVal("children");
				/*var woman = getNumVal("woman");
				var old = getNumVal("old");*/
				var oldder = getNumVal("oldder");
				var phb_ = getNumVal("phb_");
				var di_ = getNumVal("di_");
				var mental_ = getNumVal("mental_");
				var children_ = getNumVal("children_");
				/*var woman_ = getNumVal("woman_");
				var old_ = getNumVal("old_");*/
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
						/*categories : [ '0~6岁儿童', '育龄妇女', '≥60岁老人', '≥65岁老人' ]*/
						categories : [ '0~6岁儿童', '高血压患者', '糖尿病患者', '精神疾病患者', '≥65岁老人' ]
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
						/*data : [ children, woman, old, oldder ]*/
						data:[ children, phb, di, mental, oldder ]
					}, {
						type : 'column',
						name : '非户籍',
						/*data : [ children_, woman_, old_, oldder_ ]*/
						data:[ children_, phb_, di_, mental_, oldder_ ]
					} ]
				});
				
				$("#popDis").on("click", function(event) {
					event.preventDefault();
					/*var dialogObj = {
			url : contextPath + "/populace/healthManagementPop",
			title : "人口分布",
			height : 500,
			width : 900
		};
		jQuery.dialog(dialogObj);*/
					$.post(contextPath+'/populace/healthManagementPop', function(ret){
						layui.use(['layer'], function() {
							var layer = layui.layer
							layer.open({
								type: 1,
								id:'poplationDistribute',
								area: ['980px', '650px'],
								title:"人口分布",
								content: ret
							});
						});
					});
				});
			});
	
})();

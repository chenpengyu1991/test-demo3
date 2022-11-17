define(['./chartFun'],function(chartFun){
	var chartBGObj = null;
	var chartBPObj = null;
	var chartOHTObj = null;
	var chartWOObj = null;
	var chartBFObj = null;
	var chartECGObj = null;

	function load() {
		$(function(){
			initForm();
			$("#returnSearch").click(function () {
				returnSearch();
			});

		});
	}

	/**
	 * 初始化ECHART对象
	 */
	function initForm(){
		debugger;
		require(['echarts.min'],function (ec) {
			var chartBGEle = document.getElementById('chartBG');
			chartBGObj = ec.init(chartBGEle, 'shine');
			getCharts(chartBGObj,'/uthealth/user/userBG');

			var chartBPEle = document.getElementById('chartBP');
			chartBPObj = ec.init(chartBPEle, 'shine');
			getCharts(chartBPObj,'/uthealth/user/userBP');

			var chartOHTEle = document.getElementById('chartOHT');
			chartOHTObj = ec.init(chartOHTEle, 'shine');
			getCharts(chartOHTObj,'/uthealth/user/userOHT');

			var chartWOEle = document.getElementById('chartWO');
			chartWOObj = ec.init(chartWOEle, 'shine');
			getCharts(chartWOObj,'/uthealth/user/userWO');

			var chartBFEle = document.getElementById('chartBF');
			chartBFObj = ec.init(chartBFEle, 'shine');
			getCharts(chartBFObj,'/uthealth/user/userBF');

			var chartECGEle = document.getElementById('chartECG');
			chartECGObj = ec.init(chartECGEle, 'shine');
			getCharts(chartECGObj,'/uthealth/user/userECG');

		});
	};


	function getCharts(chartObj,url){
		var userId = $('#userId').val();
		chartObj.showLoading({
			text: '数据获取中',
			effect: 'whirling'
		});
		var params = {
			"url" : url,
			"callback" : function(result){
				initChart(chartObj,result);
			},
			"param" :{
				userId:userId
			}
		};
		$.getJsonByUrl(params);
	}

	function initChart(chartObj,result){
		var option  = chartFun.getLineChartOption(result);
		chartObj.setOption(option, true);
		//取消载入提示
		chartObj.hideLoading();
		$(chartObj).resize();
	};
	function returnSearch(){
		$('#searchDiv').show();
		$('#detailDiv').empty();
	}
	return{
    	load: load,
		returnSearch:returnSearch
    };
});

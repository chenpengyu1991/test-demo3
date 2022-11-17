define(['../chartFun'],function(chartFun){
	var chartEatingHabitsObj = null;
	var chartTrainFrequencyObj = null;
	var chartSmodeStatusObj = null;
	var chartDrinkFrequencyObj = null;

	function load() {
		$(function(){
			initForm();
		});
	}

	/**
	 * 初始化ECHART对象
	 */
	function initForm(){
		debugger;
		require(['echarts','echarts.shine'],function (ec) {
			var chartEatingHabitsEle = document.getElementById('chartEatingHabits');
			chartEatingHabitsObj = ec.init(chartEatingHabitsEle, 'shine');
			getCharts(chartEatingHabitsObj,'/ihm/lifeway/eatingHabits');

			var chartTrainFrequencyEle = document.getElementById('chartTrainFrequency');
			chartTrainFrequencyObj = ec.init(chartTrainFrequencyEle, 'shine');
			getCharts(chartTrainFrequencyObj,'/ihm/lifeway/trainFrequency');

			var chartSmodeStatusEle = document.getElementById('chartSmodeStatus');
			chartSmodeStatusObj = ec.init(chartSmodeStatusEle, 'shine');
			getCharts(chartSmodeStatusObj,'/ihm/lifeway/smodeStatus');

			var chartDrinkFrequencyEle = document.getElementById('chartDrinkFrequency');
			chartDrinkFrequencyObj = ec.init(chartDrinkFrequencyEle, 'shine');
			getCharts(chartDrinkFrequencyObj,'/ihm/lifeway/drinkFrequency');
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
		var option  = chartFun.getPieChartOption(result,"66%");
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
    	load: load
    };
});

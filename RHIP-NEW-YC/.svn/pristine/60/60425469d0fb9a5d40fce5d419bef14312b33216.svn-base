define(['../chartFun'],function(chartFun) {
	var validate=null;
	var chartObj = null;
	function load(){
		$(function() {
			validate = $("#targetSearchForm").easyValidate();
			$("#targetSearchForm").onEnter(initEchart, 1);
			$("#btnSearch").click(function() {
				initEchart();
			});
			initEchart();
		});
	};

	function initEchart() {
		ihmCommon.changeRangeType();
		var result=validate.validateForm();
		if(!result){
			return;
		}
		require(['echarts','echarts.shine'],function (ec) {
			// 基于准备好的dom，初始化echarts图表
			var chartEle = document.getElementById('chartDiv');
			chartObj = ec.init(chartEle, 'shine');
			var charUrl = $('#chartUrl').val();
			getChartData(chartObj,charUrl);
		});
	}

	function getChartData(chartObj,url){
		$('#nodata').hide();
		$('#chartDiv').show();
		chartObj.showLoading({
			text: '数据获取中',
			effect: 'whirling'
		});
		var postData = $('#targetSearchForm').serializeObject();
		var params = {
			"url" : url,
			"callback" : function(result){
				//取消载入提示
				chartObj.hideLoading();
				if(isEmpty(result.seriesJSON) || isEmpty(result.legendJSON) ){
					$('#nodata').show();
					$('#chartDiv').hide();
					return;
				}else{
					$('#nodata').hide();
					$('#chartDiv').show();
				}
				var option = chartFun.getPieChartOption(result);
				chartObj.setOption(option, true);
				$(chartObj).resize();
			},
			"param" :postData
		};
		$.getJsonByUrl(params);
	}

	function initForm(){
		ihmCommon.changeRangeType();
	}
	return {
		load:load
	};
});

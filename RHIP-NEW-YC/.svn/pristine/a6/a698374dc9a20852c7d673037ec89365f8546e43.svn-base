define(['../chartFun'],function(chartFun) {
	function load(){
		$(function() {
			$("#btnSearch").click(function() {
				initEchart();
			});
			initEchart();
		});
	};

	function initEchart() {
		$('#nodata').hide();
		$('#resultDiv').show();
		ihmCommon.changeRangeType();
			require(['echarts','echarts.shine'],function (ec) {
			// 基于准备好的dom，初始化echarts图表
			var chartEle = document.getElementById('resultDiv');
			var echartsObj = ec.init(chartEle, 'shine');
			echartsObj.showLoading({
				text: '数据获取中',
				effect: 'whirling'
			});
			var postData = $('#targetSearchForm').serializeObject();
			var params = {
				"url" : '/ihm/diagnosis/rankingChart',
				"callback" : function(result){
					//取消载入提示
					echartsObj.hideLoading();
					if(isEmpty(result.yAxisJSON)){
						$('#nodata').show();
						$('#resultDiv').hide();
						return;
					}else{
						$('#nodata').hide();
						$('#resultDiv').show();
					}
					var option = chartFun.getRankingBarOption(result);
					echartsObj.setOption(option, true);
					$(echartsObj).resize();
				},
				"param" :postData
			};
			$.getJsonByUrl(params);
		});
	}
	return {
		load:load
	};
});
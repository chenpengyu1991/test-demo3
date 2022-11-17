var ihmDiagnosisSearch = (function() {
	$(function() {
		$("#btnSearch").click(function(e) {
			e.preventDefault();
			initEchart();
		});
		initEchart();
	});

	function initEchart() {
		$('#nodata').hide();
		$('#resultDiv').show();
		ihmCommon.changeRangeType();
			// 基于准备好的dom，初始化echarts图表
			var chartEle = document.getElementById('resultDiv');
			var echartsObj = echarts.init(chartEle, 'shine');
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
					var option = chartFun2.getRankingBarOption(result);
					echartsObj.setOption(option, true);
					$(echartsObj).resize();
				},
				"param" :postData
			};
			$.getJsonByUrl(params);
	}
	
})();

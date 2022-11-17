var equipmentMain = (function() {
	$(function() {
        getEquipmentData();
        $("#viewDetail").click(function() {
            viewDetail();
        });

    });
	/**
     * 查看详细
     */
    function viewDetail(){
        $('#equipmentMain').hide();
        $('#detail').show();
        var loadHtmlByUrlOption = {
            url : "/ihm/equipment/detail",
            param : {},
            checkRepeat : true,
            insertDiv : "detail",
            errorDiv: "",
            okDiv:""
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    }

    function getEquipmentData() {
        var params = {
            "url" : '/ihm/equipment/getEquipmentDate',
            "callback" : afterSearch,
            "param" :{}
        };
        $.getJsonByUrl(params);
    }

    function afterSearch(result) {
        $('#equipmentNum').find('.box-content').text(result['equipmentNum']);
        $('#equipmentNumOne').find('.box-content').text(result['equipmentNumOne']);
        $('#equipmentNumTwo').find('.box-content').text(result['equipmentNumTwo']);
            var chartEle = document.getElementById('equipmentChart');
            var myChart = echarts.init(chartEle, 'shine');
            myChart.showLoading({
                text: '数据获取中',
                effect: 'whirling'
            });
            var option = chartFun2.getPieChartOption(result);
            myChart.setOption(option, true);
            //取消载入提示
            myChart.hideLoading();
            $(myChart).resize();
            $(window).resize(function() {
                $(myChart).resize();
            });
    }
	return {
		
	};
})();
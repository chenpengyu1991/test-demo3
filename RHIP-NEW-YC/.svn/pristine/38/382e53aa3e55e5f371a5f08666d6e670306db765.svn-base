var bedMain = (function() {
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
        $('#bedMain').hide();
        $('#detail').show();
        var loadHtmlByUrlOption = {
            url : "/ihm/bed/detail",
            param : {},
            checkRepeat : true,
            insertDiv : "detail",
            errorDiv: "",
            okDiv:""
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    }

    function getEquipmentData() {
        var chartEle = document.getElementById('bedChart');
        myChart = echarts.init(chartEle, 'shine');
        myChart.showLoading({
            text: '数据获取中',
            effect: 'whirling'
        });
        var params = {
            "url" : '/ihm/bed/getBedDate',
            "callback" : afterSearch,
            "param" :{}
        };
        $.getJsonByUrl(params);

    }

    function afterSearch(result) {
        $('#bedCount').find('.box-content').text(result['bedCount']);
        $('#openBedCount').find('.box-content').text(result['openBedCount']);
        var option = chartFun2.getYcategoryOption(result);
        myChart.setOption(option, true);
        //取消载入提示
        myChart.hideLoading();
        $(myChart).resize();
        $(window).resize(function() {
            $(myChart).resize();
        });
        /*require(['echarts','echarts.shine'],function (ec) {
            var chartEle = document.getElementById('bedChart');
            var myChart = ec.init(chartEle, 'shine');
            myChart.showLoading({
                text: '数据获取中',
                effect: 'whirling'
            });
            var option = chartFun.getYcategoryOption(result);
            myChart.setOption(option, true);
            //取消载入提示
            myChart.hideLoading();
            $(myChart).resize();
            $(window).resize(function() {
                $(myChart).resize();
            });
        });*/
    }
	return {
		
	};
})();
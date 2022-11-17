var hrMain = (function() {
	$(function() {
        getStaffData();
        $("#viewDetail").click(function() {
            viewDetail();
        });

    });
	/**
     * 查看详细
     */
    function viewDetail(){
        $('#staffMain').hide();
        $('#detail').show();
        var loadHtmlByUrlOption = {
            url : "/ihm/hr/detail",
            param : {},
            checkRepeat : true,
            insertDiv : "detail",
            errorDiv: "",
            okDiv:""
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    }

    function getStaffData() {
        var params = {
            "url" : '/ihm/hr/getStaffCyTypeDate',
            "callback" : afterSearch,
            "param" :{}
        };
        $.getJsonByUrl(params);
    }

    function afterSearch(result) {
        $('#CY_TYPE1').find('.box-content').text(result['CY_TYPE1']);
        $('#CY_TYPE2').find('.box-content').text(result['CY_TYPE2']);
        $('#CY_TYPE3').find('.box-content').text(result['CY_TYPE3']);
        $('#CY_TYPE4').find('.box-content').text(result['CY_TYPE4']);
        $('#CY_TYPE5').find('.box-content').text(result['CY_TYPE5']);
        $('#CY_TYPE6').find('.box-content').text(result['CY_TYPE6']);
        var chartEle = document.getElementById('staffChart');
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
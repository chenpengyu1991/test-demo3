define(['../../chartFun'],function(chartFun) {

    function load(){
        $(function(){
            getOrgData();
            $("#viewDetail").click(function() {
                viewDetail();
            });
            $("#orgReturn").click(function() {
                $('#orgMain').show();
                $('#detail').hide();
            });
        });
    }


    function getOrgData() {
        var params = {
            "url" : '/ihm/organization/getOrganizationDate',
            "callback" : afterSearch,
            "param" :{}
        };
        $.getJsonByUrl(params);
    }

    function afterSearch(result) {
        $('#A1_ORG').find('.box-content').text(result['A1_ORG']);
        $('#B1_ORG').find('.box-content').text(result['B1_ORG']);
        $('#B2_ORG').find('.box-content').text(result['B2_ORG']);
        $('#D400_ORG').find('.box-content').text(result['D400_ORG']);
        $('#L_ORG').find('.box-content').text(result['L_ORG']);
        $('#R2_ORG').find('.box-content').text(result['R2_ORG']);
        require(['echarts','echarts.shine'],function (ec) {
            var chartEle = document.getElementById('orgChart');
            var myChart = ec.init(chartEle, 'shine');
            myChart.showLoading({
                text: '数据获取中',
                effect: 'whirling'
            });
            var option = chartFun.getPieChartOption(result);
            myChart.setOption(option, true);
            //取消载入提示
            myChart.hideLoading();
            $(myChart).resize();
            $(window).resize(function() {
                $(myChart).resize();
            });
        });
    }
	return {
        load:load
	};
});
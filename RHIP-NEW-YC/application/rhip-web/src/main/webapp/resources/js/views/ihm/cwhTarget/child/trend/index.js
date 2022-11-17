define(['../../../chartFun'],function(chartFun) {
    var validate=null;
    function load(){
        $(function() {
            validate = $("#searchForm").easyValidate();
            $("#searchForm").onEnter(initEchart, 1);
            $("#btnSearch").click(function() {
                initEchart();
            });
        });
    };

    function initEchart() {
        var result=validate.validateForm();
        if(!result){
            return;
        }
        require(['echarts','echarts.shine'],function (ec) {
            // 基于准备好的dom，初始化echarts图表
            var chartEle = document.getElementById('childChartDiv');
            var echartsObj = ec.init(chartEle, 'shine');
            echartsObj.showLoading({
                text: '数据获取中',
                effect: 'whirling'
            });
            var postData = $('#searchForm').serializeObject();
            var params = {
                "url" : '/ihm/neonateAnalyse/trendChart',
                "callback" : function(result){
                    //取消载入提示
                    echartsObj.hideLoading();
                    if(isEmpty(result.xAxisJSON)){
                        $('#nodata').show();
                        $('#childChartDiv').hide();
                        return;
                    }else{
                        $('#nodata').hide();
                        $('#childChartDiv').show();
                    }
                    var option = chartFun.getYcategoryOption(result);
                    echartsObj.setOption(option, true);
                    $(echartsObj).resize();
                    initChartEvent(echartsObj,result.year);
                },
                "param" :postData
            };
            $.getJsonByUrl(params);
        });
    }

    function initChartEvent(chartObj,year){
        chartObj.on('click', function (params) {
            if (params.componentType == 'series' && params.value != 0) {
                showDetail(params.dataIndex,year,params.seriesIndex);
            }

        });
    }

    function showDetail(dataIndex,year,seriesIndex){
        $("#top_all").hide();
        var  month = dataIndex;
        $.loadHtmlByUrl({
            url : "/ihm/neonateAnalyse/detail",
            insertDiv :"trendDetailDiv",
            param : {
                year:year,
                month:month,
                chartType:seriesIndex + 1
            },
            wait:true
        });
        $("#trendDetailDiv").show();
    }

    return {
        load:load
    };
});



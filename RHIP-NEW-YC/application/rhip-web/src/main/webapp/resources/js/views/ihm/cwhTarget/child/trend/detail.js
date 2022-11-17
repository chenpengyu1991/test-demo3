define(['../../../chartFun'],function(chartFun) {

    function load(){
        $(function() {
            $("#returnMain").click(function() {
                returnMain();
            });
            $("input[name=RadioGroup5]").on("click",function(){
                var type =$("input[name=RadioGroup5]:checked").val();
                initEchart(type);
            });
            initEchart(2);
        });
    };

    /**
     * type 1:按年，2：按月
     * @param type
     */
    function initEchart(type) {
        require(['echarts','echarts.shine'],function (ec) {
            // 基于准备好的dom，初始化echarts图表
            var chartEle = document.getElementById('detailChartDiv');
            var echartsObj = ec.init(chartEle, 'shine');
            echartsObj.showLoading({
                text: '数据获取中',
                effect: 'whirling'
            });
            var url = "";
            if("1" == $('#chartType').val()){
                //新生儿性别构成
                url = '/ihm/neonateAnalyse/genderComposeChart';
            }else{
                //新生儿出生缺陷构成
                url = '/ihm/neonateAnalyse/defectTypeChart';
            }
            var params = {
                "url" : url,
                "callback" : function(result){
                    //取消载入提示
                    echartsObj.hideLoading();
                    var option = chartFun.getPieChartOption(result);
                    echartsObj.setOption(option, true);
                    $(echartsObj).resize();
                },
                param :{
                    beginDate:$('#beginDate').val(),
                    endDate:$('#endDate').val(),
                    subTitle:$('#subTitle').val(),
                    type:type
                }
            };
            $.getJsonByUrl(params);
        });
    }
    function returnMain(){
        $("#trendDetailDiv").empty();
        $("#top_all").show();
    }
    return {
        load:load,
        returnMain:returnMain
    };
});



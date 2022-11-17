define(['../chartFun'],function(chartFun) {
    var validate=null;
    function load(){
        $(function() {
            validate = $("#trendSearchForm").easyValidate();
            $("#trendSearchForm").onEnter(initEchart, 1);
            $("#trendBtnSearch").click(function() {
                initEchart();
            });
            initEchart();
        });
    };



    function initForm(){
        $('#nodata').hide();
        $('#trendChartDiv').show();

        $('#centre1').on("change",function(){
            $('#superOrganCode').val(this.value);
        });
        $('#town1').on("change",function(){
            $('#gbCode').val(this.value);
        });
        $('#centre2').on("change",function(){
            $('#superOrganCode').val(this.value);
        });
        $('#town2').on("change",function(){
            $('#gbCode').val(this.value);
        });
        $('#station2').on("change",function(){
            $('#organCode').val(this.value);
        });
        $('#genreCode').on("change",function(){
            changeOrgType();
        });
        $('#rangeType').on("change",function(){
            changeRangeType();
        });

        changeOrgType();
        changeRangeType();
    }
    function initEchart() {
        var result=validate.validateForm();
        if(!result){
            return;
        }
        initForm();
        require(['echarts.min'],function (ec) {
            // 基于准备好的dom，初始化echarts图表
            var chartEle = document.getElementById('trendChartDiv');
            var echartsObj = ec.init(chartEle, 'shine');
            echartsObj.showLoading({
                text: '数据获取中',
                effect: 'whirling'
            });
            var postData = $('#trendSearchForm').serializeObject();
            var params = {
                "url" : '/ihm/realname/trend/chart',
                "callback" : function(result){
                    //取消载入提示
                    echartsObj.hideLoading();
                    if($.isEmpty(result.xAxisJSON)){
                        $('#nodata').show();
                        $('#trendChartDiv').hide();
                        return;
                    }else{
                        $('#nodata').hide();
                        $('#trendChartDiv').show();
                    }
                    var option = chartFun.getYcategoryOption(result);
                    echartsObj.setOption(option, true);
                    $(echartsObj).resize();
                    //initChartEvent(echartsObj,result.year);
                },
                "param" :postData
            };
            $.getJsonByUrl(params);
        });
    }

    function changeRangeType(){
        var yearType = $('input[name="yearType"]:checked').val();
        if($.isEmpty(yearType)){
            $('input[name="yearType"]:eq(0)').attr("checked",'checked');
        }
        var rangeType = $('#rangeType').val();
        if(rangeType == '1'){
            $('#byMonth').show();
            $('#byQuarter').hide();
            $('#byYear').hide();
            $('#byRange').hide();
        }else if(rangeType == '2'){
            $('#byMonth').hide();
            $('#byQuarter').show();
            $('#byYear').hide();
            $('#byRange').hide();
        }else if(rangeType == '3'){
            $('#byMonth').hide();
            $('#byQuarter').hide();
            $('#byYear').show();
            $('#byRange').hide();
        }else if(rangeType == '4'){
            $('#byMonth').hide();
            $('#byQuarter').hide();
            $('#byYear').hide();
            $('#byRange').show();
            $('#beginDate').val($('#beginDate4').val());
            $('#endDate').val($('#endDate4').val());
        }
    }
    function changeOrgType(){
        var genreCode = $('#genreCode').val();
        if(genreCode == 'A100'){
            $('#byHospital').show();
            $('#byCentre').hide();
            $('#byStation').hide();
            $('#byTown').hide();
            getCurrentOrgCode(0);
        }else if(genreCode == 'B100'){
            $('#byHospital').hide();
            $('#byCentre').show();
            $('#byStation').hide();
            $('#byTown').hide();
            getCurrentOrgCode(1);
        }else if(genreCode == 'B200'){
            $('#byHospital').hide();
            $('#byCentre').hide();
            $('#byStation').show();
            $('#byTown').hide();
            getCurrentOrgCode(2);
        }else if(genreCode == '0'){
            $('#byHospital').hide();
            $('#byCentre').hide();
            $('#byStation').hide();
            $('#byTown').show();
            getCurrentOrgCode(3);
        }else if(genreCode == '46714114-9'){
            $('#byHospital').hide();
            $('#byCentre').hide();
            $('#byStation').hide();
            $('#byTown').hide();
            getCurrentOrgCode(3);
        }
    }

    function getCurrentOrgCode(index){
        $('#gbCode').val($('#town' + index).val());
        if(index==0){
            $('#superOrganCode').val($('#organCode' + index).val());
        }else if(index == '46714114-9'){
            $('#superOrganCode').val($('#genreCode').val());
            $('#genreCode').val('R2');
        }else if(index != 3){
            $('#superOrganCode').val($('#centre' + index).val());
            $('#organCode').val($('#station' + index).val());
        }else{
            $('#superOrganCode').val("");
            $('#organCode').val("");
        }
    }

 /*   function initChartEvent(chartObj,year){
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
    }*/

    return {
        load:load
    };
});



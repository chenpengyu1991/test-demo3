var communityDistribution = (function(){
    $(function() {
        loadingCommunityDistribution();
        $("input[name=RadioGroup5]").on("click",function(){
            loadingCommunityDistribution();
        });
    });

    function showSearchJsp(){
        $("#chartDivId").empty();
        $("#searchDivId").empty();

        var loadHtml={
            url: "/healthRecord/read/searchData",
            insertDiv:"searchDivId",
            param:{
                fromHome:true
            }
        };
        $.loadHtmlByUrl(loadHtml);
    }

    function loadingCommunityDistribution() {
        var statisticsDate =$("input[name=RadioGroup5]:checked").val();
        $.getJsonByUrl({
            url : "/healthRecord/read/getHealthReadChart",
            param : {'statisticsDate' : statisticsDate},
            checkRepeat : true,
            callback : function(data){
                var str = [];
                var total = 0;
                for(var i =0; i < data.length; i++) {
                    var obj = {};
                    obj["name"] = data[i]['ORGANNAME'];
                    obj["y"] = data[i]['COUNTNUM'];
                    //total += data[i]['hrArchiveNew'];
                    str.push(obj);
                }
                //$("#totalRecord").html(total);
                chart = new Highcharts.Chart({
                    chart: {
                        renderTo: 'healthReadChart',
                        defaultSeriesType: 'pie'
                    },
                    title : {
                        text : '健康档案调阅统计'
                    },
                    xAxis: {
                        categories: []
                    },
                    yAxis: {
                    },
                    exporting : {
                        enabled : false
                    },
                    credits : {
                        enabled : false
                    },
                    legend: {
                        layout: 'vertical',
                        floating: true,
                        backgroundColor: '#FFFFFF',
                        align: 'right',
                        verticalAlign: 'top',
                        y: 60,
                        x: -60
                    },
                    tooltip: {
                        formatter: function() {
                            return '<b>'+ this.series.name +'</b><br/>'+
                                this.point.name + '：' + this.y;
                        }
                    },
                    plotOptions:{
                        pie:{
                            allowPointSelect:true,
                            cursor:'pointer',
                            dataLabels:{
                                enabled:true,
                                color:'#000000',
                                connectorColor:'#000000',
                                formatter:function(){
                                    return'<b>'+this.point.name+'</b>: '+this.y + '次(' + Math.round(this.percentage * 100) / 100+' %)';
                                }
                            }
                        }
                    },
                    series: [{
                        data: str,
                        name : '调阅数'
                    }]
                });
            }
        });

    }
    return {
        showSearchJsp : showSearchJsp
    };
})();
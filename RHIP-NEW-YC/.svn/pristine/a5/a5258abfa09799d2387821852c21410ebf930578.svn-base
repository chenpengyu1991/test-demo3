!(function () {

    $(function () {
        var personId = $("#ehrbrw_hbp_chart_person_id").val();
        getDate(personId);
    });

    function getDate(personId) {
        $.getJsonByUrl({
            url: "/ehrbrowser/hbpdata",
            param: {
                'personId': personId
            },
            checkRepeat: false,
            callback: callback
        });
    }

    function formatDate(date) {
        if (date) {
            return date.pattern("yyyy/MM/dd");
        }
        return "";
    }

    function callback(data) {
        if (null == data) {
            return;
        }
        var sp = data.sp;
        var dp = data.dp

        Highcharts.setOptions({
            lang: {
                resetZoom: "重置图表",
                resetZoomTitle: "重置图表到1:1"
            }
        });

        var chart = new Highcharts.Chart(
            {chart: {
                zoomType: 'x',
                renderTo: "ehrbrw-index-hbp-chart",
                backgroundColor: '#FFFFFF', //设置图表背景色为白色
                marginLeft: 40,
                marginRight: 40
            }, credits: {
                enabled: false
            },
                title: {
                    text: '血压',
                    x: -20 //center
                },
                subtitle: {
                    text: '舒张压和收缩压',
                    x: -20
                },
                xAxis: {
                    type: "datetime",
                    title: false,
                    startOnTick: true,
                    endOnTick: true,
                    showLastLabel: true,
                    tickInterval:  7 * 24 * 3600 * 1000,
                    labels: {
                        formatter: function () {
                            return formatDate(new Date(this.value));
                        }
                    }
                },
                yAxis: {
                    title: {
                        text: ''
                    },
                    showFirstLabel:false
                },
                tooltip: {
                    formatter: function() {
                        if(this.x){
                            var value =""+this.series.name +":"+ (this.point.config[1]||"");
                            var type="<br />类型：" +(this.point.config[2] ||"无");
                            var time="<br />时间：" +formatDate(new Date( this.point.config[0]));
                            var org ="<br />机构："+( this.point.config[3]||"无");
                            return value+type+time + org;
                        }
                        return "";
                    }
                },
                exporting : {
                    enabled : false
                },
                series: [
                    {
                        name: '收缩压',
                        data: sp
                    },
                    {
                        name: '舒张压',
                        data: dp
                    }
                ]
            }
        );
    }
})();
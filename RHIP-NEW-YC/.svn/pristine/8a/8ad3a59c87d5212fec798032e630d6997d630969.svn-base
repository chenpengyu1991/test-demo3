var symptomList = (function() {
	$(function() {
//		$(".ihmSymptomPopChart").click(function() {
//	        openChart();
//	    });
    });

    function openChart(organCode, gbCode) {
        var yearDate = $('#beginDate3').val();
        $.getJsonByUrl({
            url : "/report/rpSymptom/yearData",
            wait:true,
            param:{organCode:organCode,gbCode:gbCode},
            callback : viewChart
        });
    };

    function viewChart(data){
        Highcharts.setOptions({
            lang: {
                resetZoom: "重置图表",
                resetZoomTitle: "重置图表到1:1"
            }
        });

        var chart = new Highcharts.Chart(
            {chart: {
                zoomType: 'x',
                renderTo: "idmSymptomType_pop-chart-con",
                backgroundColor: '#FFFFFF', //设置图表背景色为白色
                marginLeft: 40,
                marginRight: 40
            }, credits: {
                enabled: false
            },
                title: {
                    text: '发病趋势曲线',
                    x: -20 //center
                },
                subtitle: {
                    text: '',
                    x: -20
                },
                xAxis: {
                    type: "datetime",
                    title: false,
                    startOnTick: true,
                    endOnTick: true,
                    showLastLabel: true,
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
                            var value ="<br />"+this.series.name +": "+ (this.point.config[1]||"0");
                            var time="时间：" +formatDate(new Date( this.point.config[0]));
                            return time+value;
                        }
                        return "";
                    }
                },
                exporting : {
                    enabled : false
                },
                series: [
                    {name: '症状:发热 人数',data: data.dataA1},
                    {name: '症状:全身性疼痛 人数',data: data.dataA2},
                    {name: '症状:不适和疲劳 人数',data: data.dataA3},
                    {name: '症状:淋巴结增大 人数',data: data.dataA4},
                    {name: '症状:口呼吸 人数',data: data.dataA5},
                    {name: '症状:喷嚏 人数',data: data.dataA6},
                    {name: '症状:咽痛 人数',data: data.dataA7},
                    {name: '症状:咳嗽 人数',data: data.dataA8},
                    {name: '症状:痰异常 人数',data: data.dataA9},
                    {name: '症状:呼吸时胸痛 人数',data: data.dataA10},
                    {name: '症状:呼吸困难 人数',data: data.dataA11},
                    {name: '症状:恶心和呕吐 人数',data: data.dataA12},
                    {name: '症状:腹痛 人数',data: data.dataA13},
                    {name: '症状:腹泻 人数',data: data.dataA14},
                    {name: '症状:便稀、便秘 人数',data: data.dataA15},
                    {name: '症状:胃气胀 人数',data: data.dataA16},
                    {name: '症状:食欲缺乏 人数',data: data.dataA17},
                    {name: '症状:皮疹、斑疹 人数',data: data.dataA18},
                    {name: '症状:丘疹性荨麻疹 人数',data: data.dataA19},
                    {name: '症状:荨麻疹 人数',data: data.dataA20},
                    {name: '症状:多形性红斑 人数',data: data.dataA21},
                    {name: '症状:自发性瘀班 人数',data: data.dataA22},
                    {name: '症状:紫癜 人数',data: data.dataA23},
                    {name: '症状:水疱疹 人数',data: data.dataA24},
                    {name: '症状:呕血 人数',data: data.dataA25},
                    {name: '症状:鼻出血 人数',data: data.dataA26},
                    {name: '症状:咯血 人数',data: data.dataA27},
                    {name: '症状:血尿 人数',data: data.dataA28},
                    {name: '症状:胃肠出血 人数',data: data.dataA29},
                    {name: '症状:大便潜血 人数',data: data.dataA30},
                    {name: '症状:阴道出血 人数',data: data.dataA31},
                    {name: '症状:头痛 人数',data: data.dataA32},
                    {name: '症状:头晕和眩晕 人数',data: data.dataA33},
                    {name: '症状:昏迷 人数',data: data.dataA34},
                    {name: '症状:发热性惊厥 人数',data: data.dataA35},
                    {name: '症状:震颤 人数',data: data.dataA36},
                    {name: '症状:手足搐搦 人数',data: data.dataA37},
                    {name: '症状:共济失调 人数',data: data.dataA38},
                    {name: '症状:异常反射 人数',data: data.dataA39},
                    {name: '症状:痛性痉挛和痉挛 人数',data: data.dataA40},
                    {name: '症状:视物模糊 人数',data: data.dataA41},
                    {name: '症状:复视 人数',data: data.dataA42},
                    {name: '症状:发声困难 人数',data: data.dataA43},
                    {name: '症状:言语障碍 人数',data: data.dataA44},
                    {name: '症状:吞咽困难 人数',data: data.dataA45},
                    {name: '症状:口干 人数',data: data.dataA46},
                    {name: '症状:肌无力 人数',data: data.dataA47},
                    {name: '症状:无尿、少尿 人数',data: data.dataA48},
                    {name: '症状:多汗 人数',data: data.dataA49},
                    {name: '症状:皮肤发红 人数',data: data.dataA50},
                    {name: '症状:腰痛 人数',data: data.dataA51},
                    {name: '症状:眼痛 人数',data: data.dataA52},
                    {name: '症状:结膜出血 人数',data: data.dataA53}
                ]
            }
        );

        $('#idmSymptomType_pop-chart-con').dialog({
            width: 850,
            height: 480,
            modal: true,
            resizable: false,
            title: "症状趋势曲线"
        });
    }

    //function openChart(btn) {
    //
     //   var value1 = $(btn).parent().parent().find("td:eq(1)").text();
     //   //viewChart(btn);
	//	var yearDate = $('#beginDate3').val();
	//	$.getJsonByUrl({
     //       url : "/ihm/medical/symptom/data",
     //       wait:true,
     //       param:{yearDate:yearDate,yearType:"1"},
     //       callback : viewChart
    	//});
	//};
	//

//    function viewChart(data){
//        Highcharts.setOptions({
//            lang: {
//                resetZoom: "重置图表",
//                resetZoomTitle: "重置图表到1:1"
//            }
//        });
//
//        var chart = new Highcharts.Chart(
//            {
//                chart: {
//                zoomType: 'x',
//                renderTo: "ihmSymptom_pop-chart-con",
//                backgroundColor: '#FFFFFF', //设置图表背景色为白色
//                marginLeft: 40,
//                marginRight: 40
//            }, credits: {
//                enabled: false
//            },
//                title: {
//                    text: '监测症状统计',
//                    x: -20 //center
//                },
//                subtitle: {
//                    text: '',
//                    x: -20
//                },
//                xAxis: {
////                    type: "datetime",
////                    title: false,
////                    startOnTick: true,
////                    endOnTick: true,
////                    showLastLabel: true,
////                    labels: {
////                        formatter: function () {
////                            return formatDate(new Date(this.value));
////                        }
////                    }
//                    categories: ['2013', '2014']
//                },
//                yAxis: {
//                    title: {
//                        text: '人次'
//                    },
//                    showFirstLabel:true
//                },
////                tooltip: {
////                    formatter: function() {
////                        if(this.x){
////                            var value =""+this.series.name +":"+ (this.point.config[1]||"0");
////                            var time="<br />时间：" +formatDate(new Date( this.point.config[0]));
////                            return value+time;
////                        }
////                        return "";
////                    }
////                },
//                exporting : {
//                    enabled : false
//                },
//                series: [
//                	{name: '发热',data: [0,Number($(data).parent().parent().find("td:eq(1)").text())]},
//                    {name: '全身性疼痛',data: [0,Number($(data).parent().parent().find("td:eq(2)").text())]},
//                    {name: '不适和疲劳',data: [0,Number($(data).parent().parent().find("td:eq(3)").text())]},
//                    {name: '淋巴结增大',data: [0,Number($(data).parent().parent().find("td:eq(4)").text())],visible: false},
//                    {name: '口呼吸',data: [0,Number($(data).parent().parent().find("td:eq(5)").text())],visible: false},
//                    {name: '喷嚏',data: [0,Number($(data).parent().parent().find("td:eq(6)").text())],visible: false},
//                    {name: '咽痛',data: [0,Number($(data).parent().parent().find("td:eq(7)").text())],visible: false},
//                    {name: '咳嗽',data: [0,Number($(data).parent().parent().find("td:eq(8)").text())],visible: false},
//                    {name: '痰异常',data: [0,Number($(data).parent().parent().find("td:eq(9)").text())],visible: false},
//                    {name: '呼吸时胸痛',data: [0,Number($(data).parent().parent().find("td:eq(10)").text())],visible: false},
//                    {name: '呼吸困难',data: [0,Number($(data).parent().parent().find("td:eq(11)").text())],visible: false},
//                    {name: '恶心和呕吐',data: [0,Number($(data).parent().parent().find("td:eq(12)").text())],visible: false},
//                    {name: '腹痛',data: [0,Number($(data).parent().parent().find("td:eq(13)").text())],visible: false},
//                    {name: '腹泻',data: [0,Number($(data).parent().parent().find("td:eq(14)").text())],visible: false},
//                    {name: '便稀、便秘',data: [0,Number($(data).parent().parent().find("td:eq(15)").text())],visible: false},
//                    {name: '胃气胀',data: [0,Number($(data).parent().parent().find("td:eq(16)").text())],visible: false},
//                    {name: '食欲缺乏',data: [0,Number($(data).parent().parent().find("td:eq(17)").text())],visible: false},
//                    {name: '皮疹、斑疹',data: [0,Number($(data).parent().parent().find("td:eq(18)").text())],visible: false},
//                    {name: '丘疹性荨麻疹',data: [0,Number($(data).parent().parent().find("td:eq(19)").text())],visible: false},
//                    {name: '荨麻疹',data: [0,Number($(data).parent().parent().find("td:eq(20)").text())],visible: false},
//                    {name: '多形性红斑',data: [0,Number($(data).parent().parent().find("td:eq(21)").text())],visible: false},
//                    {name: '自发性瘀班',data: [0,Number($(data).parent().parent().find("td:eq(22)").text())],visible: false},
//                    {name: '紫癜',data: [0,Number($(data).parent().parent().find("td:eq(23)").text())],visible: false},
//                    {name: '水疱疹',data: [0,Number($(data).parent().parent().find("td:eq(24)").text())],visible: false},
//                    {name: '呕血',data: [0,Number($(data).parent().parent().find("td:eq(25)").text())],visible: false},
//                    {name: '鼻出血',data: [0,Number($(data).parent().parent().find("td:eq(26)").text())],visible: false},
//                    {name: '咯血',data: [0,Number($(data).parent().parent().find("td:eq(27)").text())],visible: false},
//                    {name: '血尿',data: [0,Number($(data).parent().parent().find("td:eq(28)").text())],visible: false},
//                    {name: '胃肠出血',data: [0,Number($(data).parent().parent().find("td:eq(29)").text())],visible: false},
//                    {name: '大便潜血',data: [0,Number($(data).parent().parent().find("td:eq(30)").text())],visible: false},
//                    {name: '阴道出血',data: [0,Number($(data).parent().parent().find("td:eq(31)").text())],visible: false},
//                    {name: '头痛',data: [0,Number($(data).parent().parent().find("td:eq(32)").text())],visible: false},
//                    {name: '头晕和眩晕',data: [0,Number($(data).parent().parent().find("td:eq(33)").text())],visible: false},
//                    {name: '昏迷',data: [0,Number($(data).parent().parent().find("td:eq(34)").text())],visible: false},
//                    {name: '发热性惊厥',data: [0,Number($(data).parent().parent().find("td:eq(35)").text())],visible: false},
//                    {name: '震颤',data: [0,Number($(data).parent().parent().find("td:eq(36)").text())],visible: false},
//                    {name: '手足搐搦',data: [0,Number($(data).parent().parent().find("td:eq(37)").text())],visible: false},
//                    {name: '共济失调',data: [0,Number($(data).parent().parent().find("td:eq(38)").text())],visible: false},
//                    {name: '异常反射',data: [0,Number($(data).parent().parent().find("td:eq(39)").text())],visible: false},
//                    {name: '痛性痉挛和痉挛',data: [0,Number($(data).parent().parent().find("td:eq(40)").text())],visible: false},
//                    {name: '视物模糊',data: [0,Number($(data).parent().parent().find("td:eq(41)").text())],visible: false},
//                    {name: '复视',data: [0,Number($(data).parent().parent().find("td:eq(42)").text())],visible: false},
//                    {name: '发声困难',data: [0,Number($(data).parent().parent().find("td:eq(43)").text())],visible: false},
//                    {name: '言语障碍',data: [0,Number($(data).parent().parent().find("td:eq(44)").text())],visible: false},
//                    {name: '吞咽困难',data: [0,Number($(data).parent().parent().find("td:eq(45)").text())],visible: false},
//                    {name: '口干',data: [0,Number($(data).parent().parent().find("td:eq(46)").text())],visible: false},
//                    {name: '肌无力',data: [0,Number($(data).parent().parent().find("td:eq(47)").text())],visible: false},
//                    {name: '无尿、少尿',data: [0,Number($(data).parent().parent().find("td:eq(48)").text())],visible: false},
//                    {name: '多汗',data: [0,Number($(data).parent().parent().find("td:eq(49)").text())],visible: false},
//                    {name: '皮肤发红',data: [0,Number($(data).parent().parent().find("td:eq(50)").text())],visible: false},
//                    {name: '腰痛',data: [0,Number($(data).parent().parent().find("td:eq(51)").text())],visible: false},
//                    {name: '眼痛',data: [0,Number($(data).parent().parent().find("td:eq(52)").text())],visible: false},
//                    {name: '结膜出血',data: [0,Number($(data).parent().parent().find("td:eq(53)").text())],visible: false}
//                ]
//            }
//        );
//
//		$('#ihmSymptom_pop-chart-con').dialog({
//                width: 830,
//                height: 480,
//                modal: true,
//                resizable: false,
//                title: "监测症状统计"
//        });
//    }

        function formatDate(date) {
        if (date) {
            return date.pattern("yyyy/MM");
        }
        return "";
    }
    
	return {
        openChart:openChart
	};
})();
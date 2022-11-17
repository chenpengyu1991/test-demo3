var abChartList = (function() {
    $(function() {
        $(".ihmSymptomPopChart").click(function() {
            openChart();
        });
    });

    function openChart(organCode, gbCode) {
        var yearDate = $('#beginDate3').val();
        $.getJsonByUrl({
            url : "/report/rpDiseases/yearData",
            wait:true,
            param:{organCode:organCode,gbCode:gbCode},
            callback : viewChart
        });
    };


    function viewChart(ret){
		var option = {
		    title : {
		        text: '近12个月发病趋势曲线',
		         x:'center'
		    },
		    tooltip : {
		        trigger: 'axis'
		    },
		    legend: {
		        data:['ICD-10(A开头的疾病)人数','ICD-10(B开头的疾病)人数'],
		        y:'bottom'
		    },
		    toolbox: {
		        show : true,
		        feature : {
		            mark : {show: true},
		            dataView : {show: true, readOnly: false},
		            magicType : {show: true, type: ['line', 'bar']},
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		    calculable : true,
		    xAxis : [
		        {
		            type : 'category',
		            boundaryGap : false,
		            data : ret.range
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value',
		            axisLabel : {
		                formatter: '{value}'
		            }
		        }
		    ],
		    series : [
		        {
		            name:'ICD-10(A开头的疾病)人数',
		            type:'line',
		            data:ret.aDestRet,
		            markPoint : {
		                data : [
		                    {type : 'max', name: '最大值'},
		                    {type : 'min', name: '最小值'}
		                ]
		            },
		            markLine : {
		                data : [
		                    {type : 'average', name: '平均值'}
		                ]
		            }
		        },
		        {
		            name:'ICD-10(B开头的疾病)人数',
		            type:'line',
		            data:ret.bDestRet,
		            markPoint : {
		                data : [
		                    {type : 'max', name: '最大值'},
		                    {type : 'min', name: '最小值'}
		                ]
		            },
		            markLine : {
		                data : [
		                    {type : 'average', name : '平均值'}
		                ]
		            }
		        }
		    ]
		};
        var idmEchart = document.getElementById('idmDiseaseType_pop-chart-con');
		require(
	    [
	        'echarts',
	        'echarts/chart/bar',
	        'echarts/chart/line'
	    ], 
	    function (ec) {
			var myChart = ec.init(idmEchart);
	        myChart.setOption(option);
	    	window.onresize = myChart.resize;
	    });     

        $('#idmDiseaseType_pop-chart-con').dialog({
            width: 980,
            height: 580,
            modal: true,
            resizable: false,
            title: "近12个月发病趋势曲线"
        });
    }


    return {
        openChart:openChart
    };
})();
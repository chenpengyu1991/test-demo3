<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<script type="text/javascript">
$("#diseaseEChart").html(loadingSource);
$("#performanceSearchForm").submitFormGetJson({
url : "/report/rpDiseases/list",
callback:function(ret){
			if ($.isEmpty(ret) || ret.length == 0) {
				$("#diseaseEChart").text("无相关数据！");
				return;
			}
			var strs = [];
			var dataRet = [];
			for(var i =0; i < ret.length; i++) {
				strs[i] = ret[i].DISEASECODE;
				dataRet[i] = {value:ret[i].DISEASENUM, name:ret[i].DISEASECODE};
			}
			option = {
			    title : {
			        text: '前十种疾病统计',
			        x:'center'
			    },
			    tooltip : {
			        trigger: 'item',
			        formatter: "{a} <br/>{b} : {c} ({d}%)"
			    },
			    legend: {
			        orient : 'vertical',
			        x : 'left',
			        data:strs
			    },
			    toolbox: {
			        show : true,
			        feature : {
			            mark : {show: true},
			            dataView : {show: true, readOnly: false},
			            magicType : {
			                show: true, 
			                type: ['pie', 'funnel'],
			                option: {
			                    funnel: {
			                        x: '25%',
			                        width: '50%',
			                        funnelAlign: 'left',
			                        max: 1548
			                    }
			                }
			            },
			            restore : {show: true},
			            saveAsImage : {show: true}
			        }
			    },
			    calculable : true,
			    series : [
			        {
			            name:'前十种疾病统计',
			            type:'pie',
			            radius : '55%',
			            center: ['50%', '60%'],
			            data:dataRet
			        }
			    ]
			};
		var diseaseEChart = document.getElementById('diseaseEChart');
		require(
	    [
	        'echarts',
	        'echarts/chart/pie',
	        'echarts/chart/funnel'
	    ], 
	    function (ec) {
			var myChart = ec.init(diseaseEChart);
	        myChart.setOption(option);
	    	window.onresize = myChart.resize;
	    });
					
		}

})
</script>
<div id="diseaseEChart" style="min-width:700px;height:400px"></div>
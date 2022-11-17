define(function() {
	function load() {
		$(function(){
			var loadingImg = "<span><img src='" + contextPath + "/images/AjaxLoader16.gif' style='vertical-align:top;'/></span>";
			$("#healthListEcharts").append(loadingImg);
			$("#technicalListEcharts").append(loadingImg);
			$("#daTargetEcharts").append(loadingImg);
			getChartData();
			getChartData1();
		});
	}

	function getChartData(){
	 $.getJsonByUrl({
		 	url : "/ihm/hr/listEcharts",			
			callback :function callback(data){
				var health = data["health"];
				var practice = data["practice"];
				var healthDataArray = new Array();
				var practiceDataArray = new Array();
				for(var i=1; i<13; i++){
					var healthCount = health["COUNT"+i];
					var practiceCount = practice["COUNT"+i];
					if(out == undefined){
						break;
					}
					healthDataArray.push(healthCount);
					practiceDataArray.push(practiceCount);
				}
				technicalListEchartsOption = {
				    title : {
				        text: '全市医疗机构执业职称统计',
				        textStyle:{fontSize: 18},
				        x: 'center'
				    },
				    tooltip : {
				        trigger: 'axis'
				    },
				    toolbox: {
				        show : true,
				        feature : {
				            mark : {show: false},
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
				            data : ['正高','副高','中级','师级（助理）','士级','其他','临床','公卫','中医','口腔'],
				            splitLine:{ show:false },
				        }
				    ],
				    yAxis : [
				        {
				            type : 'value',
				            splitLine:{ show:false }
				        }
				    ],
				    series : [
				        {
				            name:'人数',
				            type:'bar',
				            barWidth: 25,  
				            data:practiceDataArray,
				            markPoint : {
				                data : [
				                    {type : 'max', name: '最大值'},
				                    {type : 'min', name: '最小值'}
				                ]
				            }
				        }
				    ]
				};
		        var technicalListEcharts = document.getElementById('technicalListEcharts');
				require(
			    [
			        'echarts',
			        'echarts/chart/bar',
			        'echarts/chart/line'
			    ], 
			    function (ec) {
					var myChart = ec.init(technicalListEcharts);
			        myChart.setOption(technicalListEchartsOption);
			    	window.onresize = myChart.resize;
			    }); 
			    
				healthListEchartsOption = {
				    title : {
				        text: '全市医疗机构卫生人员统计',
				        textStyle:{fontSize: 18},
				        x: 'center'
				    },
				    tooltip : {
				        trigger: 'axis'
				    },
				    legend: {
				        data:[],
				        y:'bottom'
				    },
				    toolbox: {
				        show : true,
				        feature : {
				            mark : {show: false},
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
				            data : ['卫生人员','卫生技术人员','执业(助理)医师','注册护士','卫生监督员','管理人员','在编','事业人事代理','占编劳动合同','编外人员','退休返聘','乡村医生'],
				            axisLabel: { rotate: 30},
				            splitLine:{ show:false }
						}
				    ],
				    yAxis : [
				        {
				            type : 'value',
				            splitLine:{ show:false }
				        }
				    ],
				    series : [
				        {
				            name:'人数',
				            type:'bar',
				            data: healthDataArray,
				            barWidth: 25,  
				            markPoint : {
				                data : [
				                    {type : 'max', name: '最大值'},
				                    {type : 'min', name: '最小值'}
				                ]
				            }
				        }
				    ]
				};
				var healthListEcharts = document.getElementById('healthListEcharts');
				require(
			    [
			        'echarts',
			        'echarts/chart/bar',
			        'echarts/chart/line'
			    ], 
			    function (ec) {
					var myChart = ec.init(healthListEcharts);
			        myChart.setOption(healthListEchartsOption);
			    	window.onresize = myChart.resize;}
			    )}
		})	
	 }
	
	function getChartData1(){
		 $.getJsonByUrl({
			 	url : "/ihm/da/changelistEcharts",			
				callback :function callback(data){
					var STORAGEIN = data["STORAGEIN"];
					var STORAGEOUT = data["STORAGEOUT"];
					var PHARMACYIN = data["PHARMACYIN"];
					var PHARMACYOUT = data["PHARMACYOUT"];
					var STORAGE = data["STORAGE"];
					var PHARMACY = data["PHARMACY"];
					var year = data["year"];
					
					var healthDataArray = new Array();
					healthDataArray.push(STORAGEIN);
					healthDataArray.push(STORAGEOUT);
					healthDataArray.push(PHARMACYIN);
					healthDataArray.push(PHARMACYOUT);
					healthDataArray.push(STORAGE);
					healthDataArray.push(PHARMACY);
					daTargetEchartsOption = {
					    title : {
					        text: '全市' + year + '年基药出入库统计',
					        textStyle:{fontSize: 18},
					        x: 'center'
					    },
					    tooltip : {
					        trigger: 'axis'
					    },
					    toolbox: {
					        show : true,
					        feature : {
					            mark : {show: false},
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
					            data : ['药库入库量','药库出库量','药房入库量','药房出库量','药库库存量','药房库存量'],
					            splitLine:{ show:false }
					        }
					    ],
					    yAxis : [
					        {
					            type : 'value',
					            splitLine:{ show:false }
					        }
					    ],
					    series : [
					        {
					            name:'数量',
					            type:'bar',
					            data:healthDataArray,
					            markPoint : {
					                data : [
					                    {type : 'max', name: '最大值'},
					                    {type : 'min', name: '最小值'}
					                ]
					            }
					        }
					    ]
					};
			        var daTargetEcharts = document.getElementById('daTargetEcharts');
					require(
				    [
				        'echarts',
				        'echarts/chart/bar',
				        'echarts/chart/line'
				    ], 
				    function (ec) {
						var myChart = ec.init(daTargetEcharts);
				        myChart.setOption(daTargetEchartsOption);
				    	window.onresize = myChart.resize
				    }); 
			  }
		})	
	}
return {
		load: load
	 }
});
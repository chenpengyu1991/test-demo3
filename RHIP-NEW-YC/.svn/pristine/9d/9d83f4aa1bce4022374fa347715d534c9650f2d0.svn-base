define(function() {
	function load() {
		 $(function() {
		 	$("#chartContainer").html(loadingSource);
		 	$("#townDistributeChart").html(loadingSource);
		 	$("#archiveManagementChart").html(loadingSource);
		 	$("#cdmChart").html(loadingSource);
		 	// 人口统计图表
		 	calcPoplulaceEcharts();
		 	// 档案统计图表
			calcArchiveEcharts();
		 	totalRecord();
		 	$("input[name=RadioGroup5]").on("click",function(){
        		calcArchiveManageEcharts();
		 	});
		 	
		 	$("#popDis").on("click", function(event) {
				event.preventDefault();
				/*var dialogObj = {
					url : contextPath + "/populace/popDistribution",
					title : "人口分布",
					height : 500,
					width : 900
				};
				jQuery.dialog(dialogObj);*/
				 $.post(contextPath+'/populace/popDistribution', function(ret) {
		            	layui.use(['layer'], function() {
		            		  var layer = layui.layer
		            		  layer.open({
		            			  type: 1,
		            			  id:'populaceDistribution',
		            			  area: ['980px', '600px'],
		            			  title:'人口分布',
		            			  content: ret
		            		  });
		            		});
		            	});
			});
			$("#popStatics").click(popTarget);
			// 档案管理
			calcArchiveManageEcharts();
			// 慢病统计图表
			calcCDMManageEcharts(2);
			$("input[name=RadioGroup5_other]").on("click", function() {
				calcCDMManageEcharts($("input[name=RadioGroup5_other]:checked").val());
			});
		 });
		 function calcPoplulaceEcharts() {

			var phb = getNumVal("phb");
			var di = getNumVal("di");
			var mental = getNumVal("mental");
	 		/*var children = getNumVal("children");
			var woman = getNumVal("woman");
			var old = getNumVal("old");*/
			var oldder = getNumVal("oldder");
			var phb_ = getNumVal("phb_");
			var di_ = getNumVal("di_");
			var mental_ = getNumVal("mental_");
			var oldder_ = getNumVal("oldder_");
			var populaceEChartOption = {
				title : {
					text: '重点人群',
					x:'center'
				},
				tooltip : {
					trigger: 'axis'
				},
				legend: {
					data:['户籍','非户籍'],
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
						/*data : ['0~6岁儿童', '育龄妇女', '≥60岁老人', '≥65岁老人']*/
						data : ['高血压患者', '糖尿病患者', '精神疾病患者', '≥65岁老人']
					}
				],
				yAxis : [
					{
						type : 'value'
					}
				],
				series : [
					{
						name:'户籍',
						type:'bar',
						/*data:[ children, woman, old, oldder ],*/
						data:[ phb, di, mental, oldder ],
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
						name:'非户籍',
						type:'bar',
						/*data:[ children_, woman_, old_, oldder_ ],*/
						data:[ phb_, di_, mental_, oldder_ ],
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
			
			$("#chartContainer").html("");
			var chartContainer = document.getElementById('chartContainer');
			require(
			[
				'echarts.min'
			],
			function (ec) {
				var myChart = ec.init(chartContainer);
				myChart.setOption(populaceEChartOption);
				window.onresize = myChart.resize;
			});
		}
		
		function calcArchiveEcharts() {

		 $.getJsonByUrl({
			 	url : "/haStatistics/getTownDistributionList",
				param : null,
				checkRepeat : true,
				callback : function(ret) {
					var dataRet = [];
					var strs = [];
					for(var i =0; i < ret.length; i++) {
						strs[i] = ret[i]['townName'];
						dataRet[i] = {value:ret[i]['hrArchiveNew'], name:strs[i]};
					}
					var archiveOption = {
						title : {
							text: '档案统计',
							x:'center'
						},
						tooltip : {
							trigger: 'item',
							formatter: "{a} <br/>{b} : {c}份 ({d}%)"
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
								name:'档案数',
								type:'pie',
								radius : '55%',
								center: ['58%', '60%'],
								data:dataRet
							}]
						};
					$("#townDistributeChart").html("");
					var townDistributeEChart = document.getElementById('townDistributeChart');
					require(
					[
						'echarts.min'
					],
					function (ec) {
						var myChart = ec.init(townDistributeEChart);
						myChart.setOption(archiveOption);
						window.onresize = myChart.resize;
					});
			 	}
		 });
	}
	
		
		}
		
		function totalRecord() {
		 $.getJsonByUrl({
			 url : "/haStatistics/allCreatePerson",
				callback : function(data){
					$("#totalRecord").html(data);
				}
		 });
 		}
 		
 		function popTarget() {
			/*var dialogObj = {
					url : contextPath + "/populace/popTarget",
					title : "人口统计",
					height : 600,
					width : 1000
				};
			jQuery.dialog(dialogObj);*/
			
			 $.post(contextPath+'/populace/popTarget', function(ret){
	            	layui.use(['layer'], function() {
	            		  var layer = layui.layer
	            		  layer.open({
	            			  type: 1,
	            			  id:'populaceStatistics',
	            			  area: ['1000px', '600px'],
	            			  title:'人口统计',
	            			  content: ret
	            		  });
	            		});
	            	});
		}
		function getNumVal(inputVal) {
		var val = $("#" + inputVal).val();
		if (isNaN(val)) {
			return 0;
		}
		return parseInt(val);
	}
		function calcArchiveManageEcharts() {
			 var statisticsDate =$("input[name=RadioGroup5]:checked").val();
			 $.getJsonByUrl({
				 	url : "/haStatistics/getAdminArchiveManagementList",
					param : {'statisticsDate' : statisticsDate},
					checkRepeat : true,
					callback : function(data){
						var hrArchiveNew = data["hrArchiveNew"];
						var hrArchiveTotal = data["hrArchiveTotal"];
						var hrOneStar = data["hrOneStar"];
						var hrTwoStar = data["hrTwoStar"];
						var hrThreeStar = data["hrThreeStar"];
						var hrArchiveCancel = data["hrArchiveCancel"];
						var hrArchiveEmigration = data["hrArchiveEmigration"];
						var unhrArchiveNew = data["unhrArchiveNew"];
						var unhrArchiveTotal = data["unhrArchiveTotal"];
						var unhrOneStar = data["unhrOneStar"];
						var unhrTwoStar = data["unhrTwoStar"];
						var unhrThreeStar = data["unhrThreeStar"];
						var unhrArchiveCancel = data["unhrArchiveCancel"];
						var unhrArchiveEmigration = data["unhrArchiveEmigration"];
						
						var archiveManageEChartOption = {
					    title : {
					        text: '档案管理',
					        x:'center'
					    },
					    tooltip : {
					        trigger: 'axis'
					    },
					    legend: {
					        data:['户籍','非户籍'],
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
					            data : [ '新增个人档案', '档案更新份数', '一星档案', '二星档案', '三星档案', '档案结案', '档案迁移']
					        }
					    ],
					    yAxis : [
					        {
					            type : 'value'
					        }
					    ],
					    series : [
					        {
					            name:'户籍',
					            type:'bar',
					            data:[ hrArchiveNew, hrArchiveTotal, hrOneStar, hrTwoStar, hrThreeStar, hrArchiveCancel, hrArchiveEmigration],
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
					            name:'非户籍',
					            type:'bar',
					            data:[ unhrArchiveNew, unhrArchiveTotal, unhrOneStar, unhrTwoStar, unhrThreeStar, unhrArchiveCancel, unhrArchiveEmigration],
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
	                    $("#archiveManagementChart").html("");
	                    var archiveManagementChart = document.getElementById('archiveManagementChart');
						require(
						[
							'echarts.min'
						],
						function (ec) {
							var myChart = ec.init(archiveManagementChart);
							myChart.setOption(archiveManageEChartOption);
							window.onresize = myChart.resize;
						});
				 	}
			 	});
			}
		
		function calcCDMManageEcharts(statisticsDate) {
			$.getJsonByUrl({
			url : "/haStatistics/adminIdmStatistics",
			param : {
				'statisticsDate' : statisticsDate
			},
			callback : function(data) {
				var hrHbp = 0;
				var hrDi = 0;
				var hrTumor = 0;
				var hrCoronary = 0;
				var hrStroke = 0;
				var unhrHbp = 0;
				var unhrDi = 0;
				var unhrTumor = 0;
				var unhrCoronary = 0;
				var unhrStroke = 0;
				for ( var i = 0; i < data.length; i++) {
					if (data[i]['HOUSEHOLD_TYPE'] == 1) {
						hrHbp += parseInt(data[i]['HBP_TOTAL']);
						hrDi += parseInt(data[i]['DI_TOTAL']);
						hrTumor += parseInt(data[i]['TUMOR_TOTAL']);
						hrStroke += parseInt(data[i]['STROKE_TOTAL']);
						hrCoronary += parseInt(data[i]['CORONARY_TOTAL']);
					} else if (data[i]['HOUSEHOLD_TYPE'] == 2) {
						unhrHbp += parseInt(data[i]['HBP_TOTAL']);
						unhrDi += parseInt(data[i]['DI_TOTAL']);
						unhrTumor += parseInt(data[i]['TUMOR_TOTAL']);
						unhrStroke += parseInt(data[i]['STROKE_TOTAL']);
						unhrCoronary += parseInt(data[i]['CORONARY_TOTAL']);
					}
				}
									
					var cdmManageEChartOption = {
				    title : {
				        text: '慢病管理',
				        x:'center'
				    },
				    tooltip : {
				        trigger: 'axis'
				    },
				    legend: {
				        data:['户籍','非户籍'],
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
				            data : [ '高血压', '糖尿病', '肿瘤', '冠心病', '脑卒中' ]
				        }
				    ],
				    yAxis : [
				        {
				            type : 'value'
				        }
				    ],
				    series : [
				        {
				            name:'户籍',
				            type:'bar',
				            data:[ hrHbp, hrDi, hrTumor, hrCoronary, hrStroke ],
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
				            name:'非户籍',
				            type:'bar',
				            data:[ unhrHbp, unhrDi, unhrTumor, unhrCoronary, unhrStroke ],
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
                $("#cdmChart").html("");
		        var cdmChart = document.getElementById('cdmChart');
				require(
			    [
                    'echarts.min'
			    ], 
			    function (ec) {
					var myChart = ec.init(cdmChart);
			        myChart.setOption(cdmManageEChartOption);
			    	window.onresize = myChart.resize;
			    });  	
					
				}
		 });
		}
		
		
		return {
		load: load,
		calcArchiveManageEcharts:calcArchiveManageEcharts,
		calcCDMManageEcharts:calcCDMManageEcharts
	}
	}
);

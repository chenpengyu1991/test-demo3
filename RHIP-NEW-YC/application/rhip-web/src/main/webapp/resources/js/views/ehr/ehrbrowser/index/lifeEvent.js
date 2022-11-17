var ehrLifeEvent = (function() {
	
	var eventId;
	var eventTypeId;
	
	$(function(){
		var personId = $("#hiddenPersonId").val();
		getLifeEvent(personId);
	});
	
	function getLifeEvent(personId) {
		$.getJsonByUrl({
			url : "/ehrbrowser/basic/lifeEvent",
			param : {
				'personId' : personId
			},
            checkRepeat: false,
			callback : callback
		});
	}

    function formatDate(date){
        if(date){
            return date.pattern("yyyy/MM/dd");
        }
     return "";
    }
	
	function callback(data){
		var outArray = data["10"];
		var inArray = data["20"];
		var examArray = data["30"];
		
		var hpbArray = data["50"];
		var diArray = data["60"];
		var strokeArray = data["70"];
		var coronaryArray = data["80"];
		var tumorArray = data["90"];
		var caccinationInfoArray = data["100"];
		var deathArray = data["110"];
		var birthArray = data["120"];

		Highcharts.setOptions({
	        lang:{
	        	resetZoom : "重置图表",
	        	resetZoomTitle : "重置图表到1:1"
	        }
	    });
		
		var chart = new Highcharts.Chart({
			chart: {
                type: 'scatter',
                zoomType: 'xy',
                renderTo : "lifeEventChart",
                backgroundColor: '#FFFFFF', //设置图表背景色为白色
                marginLeft: 40,
                marginRight: 40
            },
            credits : {
				enabled : false
			},
            title: {
                text: '生命周期'
            },
            xAxis: {
                type:"datetime",
                title:false,
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
                    text:false
                },
                gridLineWidth: 1,//设置横向分区线宽度
                lineColor:'#FFFEEE',//设置y轴颜色
                labels: {
                    enabled: false
                },
                   plotBands: [{
                    from: 0,
                    to: 400000,
                    color: 'rgba(255, 0, 0, 0.1)',
                    label: {
                        style: {
                            color: '#606060'
                        }
                    }
                }, {
                    from: 400000,
                    to: 1000000,
                    color: 'rgba(0, 255, 0, 0.1)',
                    label: {
                        style: {
                            color: '#606060'
                        }
                    }
                }, {
                    from: 1000000,
                    to: 1800000,
                    color: 'rgba(0, 0, 255, 0.1)',
                    label: {
                        style: {
                            color: '#606060'
                        }
                    }
                }]
            },
            plotOptions: {
                scatter: {
                    marker: {
                        radius: 5,
                        states: {
                            hover: {
                                enabled: true,
                                lineColor: 'rgb(100,100,100)'
                            }
                        }
                    },
                    states: {
                        hover: {
                            marker: {
                                enabled: false
                            }
                        }
                    }
                },
                series: {
                	cursor: 'pointer',
    	            events: {
                        click: clickEvent
                    }
	            }
            },
			exporting : {
				enabled : false
			},
            tooltip: {
                formatter: function() {
            		if(this.x){
            			eventId = this.point.config[2];
            			eventTypeId = this.point.config[1];
            			var org =  this.point.config[3] != null ? this.point.config[3] : "无";
            			return "类型：" + this.series.name + "<br/>" +
            				   "时间：" +formatDate(new Date( this.point.config[0]))+ "<br/>" +
            				   "机构：" + org;
            		}
                    return "";
                }
            },
			series: [{
                name: '门诊',
                data: outArray
            }, {
                name: '住院',
                data: inArray
            }, {
                name: '体检',
                data: examArray
            }, {
                name: '高血压随访',
                data: hpbArray
            }, {
                name: '糖尿病随访',
                data: diArray
            }, {
                name: '脑卒中随访',
                data: strokeArray
            }, {
                name: '冠心病随访',
                data: coronaryArray
            }, {
                name: '肿瘤随访',
                data: tumorArray
            },{
                name:"预防接种",
                data:caccinationInfoArray
            },{
                name:"出生记录",
                data:birthArray
            },{
                name:"死亡记录",
                data:deathArray
            }]
		});
	}
	
	function clickEvent(){
        //y值去掉后5位作为类别
        var type= eventTypeId.toString();
        if(type==null||type.length<6){
            return;
        }
        type=type.substr(0,type.length-5);
		var typeIdArray = [type];
		
		if(typeIdArray[0] == 1){
			/*var lifeEvent = {
				url : contextPath + "/outpatient/drugReport/" + eventId,
				height : 500,
				width : 650,
				title : "处方",
			};
			$.dialog(lifeEvent);*/
			
			$.post(contextPath+"/outpatient/drugReport/" + eventId,
	 				function(ret){
	             	layui.use(['layer'], function() {
	             		  var layer = layui.layer
	             		  layer.open({
	             			  type: 1,
	             			  id:'lifeEventPrescriptionDialog',
	             			  area: ['850px', '500px'],
	             			  title:"处方",
	             			  content: ret
	             		  });
	             		});
	             	});
    	}else if(typeIdArray[0] == 2){
    		/*var lifeEvent = {
				url : contextPath + "/inpatient/chart/" + eventId,
				height : 630,
				width : 800,
				title : "临床图表",
			};
			$.dialog(lifeEvent);*/
			$.post(contextPath+"/inpatient/chart/" + eventId,
 				function(ret){
             	layui.use(['layer'], function() {
             		  var layer = layui.layer
             		  layer.open({
             			  type: 1,
             			  id:'lifeEventClinicDiagramDialog',
             			  area: ['900px', '630px'],
             			  title:"临床图表",
             			  content: ret
             		  });
             		});
             	});
		}else if(typeIdArray[0] == 5 || typeIdArray[0] == 6 || typeIdArray[0] == 7|| typeIdArray[0] == 8|| typeIdArray[0] == 9){
			var title = "";
			var type = 0;
			switch(typeIdArray[0]){
				case "5" : title = "高血压随访";type = 1;break;
				case "6" : title = "糖尿病随访";type = 2;break;	
				case "7" : title = "脑卒中随访";type = 3;break;	
				case "8" : title = "冠心病随访";type = 4;break;	
				case "9" : title = "肿瘤随访";type = 5;break;
			}
    		/*var lifeEvent = {
				url : contextPath + "/ehrbrowser/management/followUpDetail",
				height : 600,
				width : 750,
				param : {
					id : eventId,
					type : type
				},
				title : title
			};
			$.dialog(lifeEvent);*/
			
			$.post(contextPath+'/ehrbrowser/management/followUpDetail',
 	        		{  id : eventId,
				       type : type
 				     }, 
 				function(ret){
             	layui.use(['layer'], function() {
             		  var layer = layui.layer
             		  layer.open({
             			  type: 1,
             			  id:'lifeEventFollowupVisitDialog',
             			  area: ['750px', '600px'],
             			  title:title,
             			  content: ret
             		  });
             		});
             	});
		} else if (typeIdArray[0] == 10){
            //预防接种
			/*var vaccineDialog = {
	 			id :"vaccineDialogBr",
	             url : "/ehrbrowser/basic/injectVaccine",
	             height : 400,
	             width : 700,
	             title : "疫苗注射",
	             param : {
	            	 id: eventId
	 			}
	         };
	         $.dialog(vaccineDialog);*/
	         
	         $.post(contextPath+'/ehrbrowser/basic/injectVaccine',
 	        		{  id: eventId
 				     }, 
 				function(ret){
             	layui.use(['layer'], function() {
             		  var layer = layui.layer
             		  layer.open({
             			  type: 1,
             			  id:'lifeEventPlanVaccinationDialog',
             			  area: ['700px', '400px'],
             			  title:'疫苗注射',
             			  content: ret
             		  });
             		});
             	});
        } else if(typeIdArray[0] == 11){
			/*var userDialog = {
		 			id :"personCancelDialogBr",
		             url : "/ehrbrowser/basic/death/detail",
		             height : 400,
		             width : 700,
		             title : "死亡记录",
		             param : {
		            	 personId: $("#hiddenPersonId").val()
		 			}
		         };
		         $.dialog(userDialog);*/
		         
		         $.post(contextPath+'/ehrbrowser/basic/death/detail',
	    	        		{ personId:$("#hiddenPersonId").val()
	    				     }, 
	    				function(ret){
	                	layui.use(['layer'], function() {
	                		  var layer = layui.layer
	                		  layer.open({
	                			  type: 1,
	                			  id:'lifeEventBirthCertDialog',
	                			  area: ['700px', '400px'],
	                			  title:'死亡记录',
	                			  content: ret
	                		  });
	                		});
	                	});
		} else if(typeIdArray[0] == 12){
			/*var dialog = {
		            url : "/ehrbrowser/health/ownBornDetail",
		            param : {personId:$("#hiddenPersonId").val()},
		            height : 550,
		            width : 750,
		            title : "出生医学证明" ,
		            id :"dialog"
		        };
		        $.dialog(dialog);*/
		        
		        $.post(contextPath+'/ehrbrowser/health/ownBornDetail',
    	        		{ personId:$("#hiddenPersonId").val()
    				     }, 
    				function(ret){
                	layui.use(['layer'], function() {
                		  var layer = layui.layer
                		  layer.open({
                			  type: 1,
                			  id:'lifeEventBirthCertDialog',
                			  area: ['750px', '550px'],
                			  title:'出生医学证明',
                			  content: ret
                		  });
                		});
                	});
    	}else if (typeIdArray[0] == 3){
    		/*var dialog = {
		            url : "/ehrbrowser/basic/physicalExam",
		            param : {id: eventId},
		            height : 550,
		            width : 750,
		            title : "体检报告" ,
		            id :"dialog"
		        };
		        $.dialog(dialog);*/
		        
		        $.post(contextPath+'/ehrbrowser/basic/physicalExam',
    	        		{ id: eventId
    				     }, 
    				function(ret){
                	layui.use(['layer'], function() {
                		  var layer = layui.layer
                		  layer.open({
                			  type: 1,
                			  id:'lifeEventPhysicalExamDialog',
                			  area: ['750px', '550px'],
                			  title:'体检报告',
                			  content: ret
                		  });
                		});
                	});
        }
	}
	
})();
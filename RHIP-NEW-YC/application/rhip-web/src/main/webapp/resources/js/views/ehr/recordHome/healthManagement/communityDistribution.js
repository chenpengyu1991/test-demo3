var communityDistribution = (function(){
	
	 $(function() {
	        //档案管理
			loadingCommunityDistribution();
	    });
	 
	 function loadingCommunityDistribution() {
		 $.getJsonByUrl({
			 	url : "/haStatistics/getCommunityDistributionList1",
				param : null,
				checkRepeat : true,
				callback : function(data){
					var str = [];
					var total = 0;
					for(var i =0; i < data.length; i++) {
						var obj = {};
						obj["name"] = data[i]['townName'];
						obj["y"] = data[i]['hrArchiveNew'];
						total += data[i]['hrArchiveNew'];
						str.push(obj);
					}
					$("#totalRecord").html(total);
					chart = new Highcharts.Chart({
				        chart: {
				            renderTo: 'communityDistributeChart',
				            defaultSeriesType: 'pie'
				        },
				        title : {
							text : '档案统计'
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
			                            return'<b>'+this.point.name+'</b>: '+this.y + '份(' + Math.round(this.percentage)+' %)';
			                        }
			                    }
			                }
			            },
				        series: [{
				            data: str,
				            name : '档案数'
				        }]
				    });
       }
		 });
		 
//		 $.getJsonByUrl({
//			 	url : "/healthManagement/getArchiveManagementList",
//				param : null,
//				checkRepeat : true,
//				callback : function(data){
//					var archiveManagementVo = data["archiveManagementVo"];
//					for(var i = 0; i < archiveManagementVo.length; i++) {
//						$("#archiveTable").append("<tr><td>").append(archiveManagementVo["HOUSEHOLD_TYPE_SUM"]).append("</td></tr>");
//						;
//					}
//                }
//		 });
	 }
	 
	// inArray的jQuery源码
	 inArray = function( elem, array ) {
		 var rtn = null;
		 $.each(array,function(key,value){
			 if(key == elem) {
				 rtn = value;
				 return true;
		     }
		 });
		 return rtn;
	 };
	 
	 buildArchiveTable = function(value) {
			if(value) {
				return "<td>" + value + "</td>";
			}
			else {
				return "<td>0</td>";
			}
	 };

})();
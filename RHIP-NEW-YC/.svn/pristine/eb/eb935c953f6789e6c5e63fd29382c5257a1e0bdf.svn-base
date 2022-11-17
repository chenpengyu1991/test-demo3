var popChart = (function() {
    $(function() {
    	if($('#rangeType').val() == '3'){
    		$('#chartType2').attr("disabled","disabled");
    	}
    	refresh();
    });
    
    
    /**
     * 显示图表(同比、环比)
     */
    function refresh(){
    	var chartType = $('input[name="chartType"]:checked').val(); //指标类型,同比:1,环比:2
    	var thisData = $('#this_data').data('chartData');
    	var categories = $('#categories').data('chartData');
    	var title = $('#chart_title').data('chartData');
    	var seriesname = $('#seriesname').data('chartData');
    	
    	var staticItem = $('input[name="staticItem"]:checked').val(); //指标种类
		var dataIndex = parseInt(staticItem);
			    	
    	var compareData = [];
    	//同比或者环比
    	var url = "/pam/organ/serviceCapacity/yearOnYear";//同比
	    if(chartType == "2"){//环比
	    	url = "/pam/organ/serviceCapacity/monthOnMonth";
	    	compareData = $('#compare_month_data').data('chartData');
	    }else{
	    	compareData = $('#compare_year_data').data('chartData');
	    }
    	if($.isEmpty(compareData)){//如果为空,则从服务器获取数据同比、环比数据
    		compareData = [];
	    	//查询条件
    		var orgCode = $('#chart_orgcode').data('chartData');
	    	var resultGenreCode = $('#resultGenreCode').val();
	    	var resultOrganCode = $('#resultOrganCode').val();
	    	var resultSuperOrganCode = $('#resultSuperOrganCode').val();
	    	var resultGbCode = $('#resultGbCode').val();
	    	var resultRangeType = $('#resultRangeType').val();
	    	var resultMonthDate = $('#resultMonthDate').val();
	    	var resultRangeQuarter = $('#resultRangeQuarter').val();
	    	var resultQuarterDate = $('#resultQuarterDate').val();
	    	var resultYearType = $('#resultYearType').val();
	    	var resultYearDate = $('#resultYearDate').val();
	    	if(resultGenreCode == "0"){
	    		resultGbCode = orgCode;
	    	}else if (resultGenreCode == "A1" || resultGenreCode == "B1"){
	    		resultSuperOrganCode = orgCode;
	    	}else if (resultGenreCode == "B2"){
	    		resultOrganCode = orgCode;
	    	} 
	    	compareData = ['0','0','0','0','0','0','0']
			$.getJsonByUrl({
	            url : url,
	            wait:true,
	            param:{
	            	genreCode:resultGenreCode,
	            	organCode:resultOrganCode,
	            	superOrganCode:resultSuperOrganCode,
	            	gbCode:resultGbCode,
	            	rangeType:resultRangeType,
	            	monthDate:resultMonthDate,
	            	rangeQuarter:resultRangeQuarter,
	            	quarterDate:resultQuarterDate,
	            	yearType:resultYearType,
					yearDate:resultYearDate
	            },
	            callback : function(data) {
	            	compareData[0] = data['OUTPATIENTCOUNT'];
	            	compareData[1] = data['AVGDAYS'];
	            	compareData[2] = data['OUTPATIENTCOST'];
	            	compareData[3] = data['INPATIENTCOST'];
	            	compareData[4] = data['AMOUNTRATE'];
	//            	compareData[0] = data['outpatientCount'];	
	            	compareData[5] = data['PRESCRIPTIONRATE'];
	            	compareData[6] = data['PRESCRIPTIONTOTALAVG'];
            	
				    if(chartType == "2"){//环比
				    	$('#compare_month_data').data('chartData',compareData);
				    }else{
				    	$('#compare_year_data').data('chartData',compareData);
				    }

			    	if(staticItem !='-1'){//全部指标
			    		thisData = thisData.slice(dataIndex,dataIndex+1);
			    		compareData = compareData.slice(dataIndex,dataIndex+1);
			    		categories = categories.slice(dataIndex,dataIndex+1);
			    	}
			    	openChart(thisData, compareData,categories,title,chartType,seriesname);				    

	            }
	    	});	    	
    	}else{//已经统计过,不需要再次查询服务器
			if(staticItem !='-1'){//全部指标
	    		thisData = thisData.slice(dataIndex,dataIndex+1);
	    		compareData = compareData.slice(dataIndex,dataIndex+1);
	    		categories = categories.slice(dataIndex,dataIndex+1);
	    	}
			openChart(thisData, compareData,categories,title,chartType,seriesname);    		
    	}
    };
    
    function openChart(thisData, compareData,categories,title,chartType,seriesname) {
        var max = 0;
        var i = 0;
        for (; i < thisData.length; i++) {
            var value = thisData[i] || 0;
            value = Math.abs(value);
            if (value > max) {
                max = value;
            }
            if(value == 0){
            	thisData[i] = null;
            }else{
            	thisData[i] = 0 - value;
            }
        }

        for (i = 0; i < compareData.length; i++) {
            var value = compareData[i] || 0;
            if (value > max) {
                max = value;
            }
            if(value == 0){
            	compareData[i] = null;
            }
        }
        if(max == 0){
        	max = 1;
        }
        var chart = new Highcharts.Chart(
                {
                    chart: {
                        renderTo: "pop-chart-con",
                        type: 'bar',
                        marginLeft: 90,
                        marginRight: 90,
                        width: 780,
                        height: 400
                    }, credits: {
                    enabled: false
                }, exporting: {
                    enabled: false
                },
                    title: {
                        text: title
                    },
                    subtitle: {
                        text: ''
                    },
                    xAxis: [
                        {
                            categories: categories,
                            reversed: false,
                            labels: {
                                step: 1
                            },
                            showEmpty:false
                        },
                        { // mirror axis on right side
                            opposite: true,
                            reversed: false,
                            categories: categories,
                            linkedTo: 0,
                            labels: {
                                step: 1
                            },
                            showEmpty:false
                        }
                    ],
                    yAxis: {
                        title: {
                            text: null
                        }, labels: {
                            formatter: function () {
                            	return (Math.abs(this.value) );
                            }
                        }, max: max,
                        min: 0 - max,
                        showEmpty: false
                    },

                    plotOptions: {
                        series: {
                            stacking: 'normal',
                            minPointLength:5
                            
                        },
                        bar:{pointWidth:25}
                    },

                    tooltip: {
                        formatter: function () {
                            return  this.series.name + '<br/>' + this.point.category + ':<br/>' +
                                    Highcharts.numberFormat(Math.abs(this.point.y), 2);
                        }
                    },

                    series: [
                        {
                            name: seriesname,
                            data: thisData
                        },
                        {
                            name: chartType==1?'同比':'环比',
                            data: compareData
                        }
                    ]
                });
    };
	return {
		refresh:refresh
	};
})();




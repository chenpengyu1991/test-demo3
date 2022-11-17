var ihmPopChart = (function() {
    $(function() {
    });
    
    function openHighchart(divId,type){
    	$('#' + divId).width('800px');
    	$('#' + divId).height('400px');
		var thisData = $('#this_data').data('chartData');
    	var categories = $('#categories').data('chartData');
    	var title = $('#chart_title').data('chartData');
    	var seriesname = $('#seriesname').data('chartData');
		var yAxisText = $('#yAxisText').data('chartData');
		var orgName = $('#orgName').data('chartData');
		chart = new Highcharts.Chart({
	        chart: {
	            renderTo: divId,
	            defaultSeriesType: 'pie'
	        },
	        title : {
				text : '<b>' + orgName + '</b>' + ' ' + title
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
	                return '<b>'+ this.series.name +'</b><br/>'+this.point.name + '：' + this.y;
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
                            return type == 'disease' ? '<b>'+this.point.name+'</b>: '+ this.y + '例'  : '<b>'+this.point.name+'</b>: '+ this.y + '元(' + Math.round(this.percentage) + ' %)';
                        }
                    }
                }
            },
	        series: [{
	            data: thisData,
	            name : seriesname
	        }]
	    });
    }
	return {
		openHighchart:openHighchart
	};
})();




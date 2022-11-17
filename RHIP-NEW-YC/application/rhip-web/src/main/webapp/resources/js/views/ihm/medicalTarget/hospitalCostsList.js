var hospitalCostsList = (function() {
	var $link = null;
	$(function() {
		$(".ihmPopChart").click(function() {
			$link = $(this);
	        openChart();
	    });          
    });

	function openChart() {
		organData();
		
		$('#ihm_pop').dialog({
                width: 830,
                height: 480,
                modal: true,
                resizable: false,
                title: "医院费用信息分布",
                close: function() {$('input[name="staticItem"]:eq(0)').attr("checked",'checked');}
        });
	};
	

	function organData(){
		/**
	     * chartType=1:收费分类图表,type=2:基药,非基药图表
	     */		
//		var chartType = $('input[name="staticItem"]:checked').val(); //指标类型,收费分类:1,基药:2
		
		var charDivId = "ihm_pop-chart-con";
		var $tds = $link.parentsUntil("tr").siblings();
        var thisData = [];
        var orgName = "";
        $tds.each(function () {
        	var obj = {};
            var $td = $(this);
//            if ($td.data("isData") && $td.data("type") == chartType) {
                var level = $td.data("total-level");
                var total = $td.data("total");
                if($.isEmpty(total)){
                	total = 0;
                }
                obj['name'] = level;
                obj['y'] = total;
                thisData.push(obj);
 //           }
            if ($td.data("isOrgcode")) {
                orgName = $td.find('label').text();
            }
        });	
        $('#this_data').data('chartData',thisData);
        var categories;
 //       if(chartType == '1'){
        	categories = ['中药', '中成药', '西药','诊查费','检查费','化验费','放射费','治疗费','手术费','输血费','床位费','护理费','麻醉费','其他'];
 //       }else{
  //      	categories = ['基药','非基药'];
  //      }
        $('#categories').data('chartData',categories);
        $('#chart_title').data('chartData','医院费用信息分布');
        $('#seriesname').data('chartData',getSeriesName());
        $('#yAxisText').data('chartData','元');
         $('#orgName').data('chartData',orgName);
        ihmPopChart.openHighchart(charDivId);
	}
    function getSeriesName(){
    	var rangeType = $('#rangeType').val();
    	var seriesname;
    	switch(rangeType){
    		 case "1"://按月
    		 	seriesname = $('#beginDate1').val();
    		 	break;
    		 case "2"://按季度
    		 	seriesname = $('#beginDate2').val() + " 第" + $('#rangeQuarter').val() + " 季度";
    		 	break;
    		 case "3"://按年
    		 	var yearType = $('input[name="yearType"]:checked').val();
    		 	seriesname = $('#beginDate3').val() + (yearType == '1'?" 全年":yearType == '2'?" 上半年":" 下半年");
    		 	break;
    		 case "4"://按时间段
    		 	seriesname = '从 ' + $('#beginDate4').val() + ' 到  ' + $('#endDate4').val();
    		 	break;    		 	
    	}
    	return seriesname;
    }	
	return {
		organData:organData
	};
})();
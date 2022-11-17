var rabiesReportSearch = (function() {
	$(function() {
        $("#rabiesReportSearchForm").onEnter(searchRabiesReport, 1);
        $("#rabiesReportBtnSearch").click(function(e) {
            e.preventDefault();
        	searchRabiesReport();
        });
        searchRabiesReport();

        $("#rabiesExport").click(function() {
            var reportName = $('#reportNameId').val();
            $("#rabiestable").exportExcel(reportName);
        });
        initDate()
	});

    function initDate() {
        layui.use('laydate', function(){
            var laydate = layui.laydate;
            laydate.render({
                elem: '#fillBeginDateId'
                ,format: 'yyyy/MM/dd'
                ,max:0
            });
            laydate.render({
                elem: '#fillEndDateId'
                ,format: 'yyyy/MM/dd'
                ,max:0
            });
        });
    }

	/*传染病管理月报表-狂犬病防治查询*/
	function searchRabiesReport() {
		var searchObj = {
			url : "/vaccine/statistics/report/monthReport/rabiesList",
			insertDiv : 'rabiesResultDiv',
			param : {}
		};
		$("#rabiesReportSearchForm").submitFormLoadHtml(searchObj);
	};

	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	}
	
	return {
		toggle:toggle
	};
})();
var pneumoniaReportSearch = (function() {
	$(function() {
        searchPneumoniaReport();
        $("#pneumoniaReportBtnSearch").click(function(e) {
            e.preventDefault();
        	searchPneumoniaReport();
        });
        $("#pneumoniaReportSearchForm").onEnter(searchPneumoniaReport, 1);
        $("#pneumoniaExport").click(function() {
            var reportName = $('#reportNameId').val();
            $("#pneumoniatable").exportExcel(reportName);
        });
        initDate();
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
	function searchPneumoniaReport() {
		var searchObj = {
			url : "/inoculation/reportResult",
			insertDiv : 'pneumoniaResultDiv',
			param : {}
		};
		$("#pneumoniaReportSearchForm").submitFormLoadHtml(searchObj);
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
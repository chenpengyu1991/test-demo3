var takeSampleSearch = (function() {
	$(function() { 
		/*查询*/
        $("#takeSampleBtnSearch").click(function() {
        	searchTakeSample(1);
        });
        /*导出*/
        $("#takeSampleExport").click(function() {
        	takeSampleDown();
        });
        if($('#RoleTypeId').val() != 'FYK'){
        	$("#reportUnitCodeId option[value='']").remove();//删除‘请选择’，中心统计时，必须选择一个单位
        }        
        searchTakeSample(1);
        $("#takeSampleSearchForm").onEnter(searchTakeSample, 1);
	});
	/*手足口病采样登记查询*/
	function searchTakeSample(pageIndex) {
		pageIndex = ($.isEmpty(pageIndex)?$('#tagContent3').find("#pageIndex").val():pageIndex);
		var searchObj = {
			url : "/idm/statistics/report/takeSample/list",
			insertDiv : 'takeSampleResultDiv',
			param : {indexPage:pageIndex},
            callback : function(data) {
            	$('#tagContent3').find("#pageIndex").val(pageIndex);
            }
		};
		$("#takeSampleSearchForm").submitFormLoadHtml(searchObj);
	};
	
    function takeSampleDown(){
    	location.href = contextPath + "/idm/statistics/report/takeSample/downExcel?" + $('#takeSampleSearchForm').formSerialize();
    }
	return {
		searchTakeSample:searchTakeSample
	};
})();
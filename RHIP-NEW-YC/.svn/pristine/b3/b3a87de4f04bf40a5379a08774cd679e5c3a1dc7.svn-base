define(['../fileManage/search'],function(fileManagerSearch) {
	function load() {
		$(function() {
			$("#returnBtn").click(returnBtn);
		});
	}
	
	function returnBtn(){
		$("#detailDivFile").empty();
        $("#top_allFile").show();
		fileManagerSearch.searchFile(1);			
	}
	
	return {
		load: load
	};
});

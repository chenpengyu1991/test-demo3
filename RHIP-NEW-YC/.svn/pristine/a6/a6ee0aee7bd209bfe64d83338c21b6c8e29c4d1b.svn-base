var exportTable = (function() {
	
	function addColumns(){
		if($("input[type='checkbox']").is(':checked')){
			$("#warmTips").hide();
		}else{
			$("#warmTips").show();
			return;
		}
		var searchObj = {
				url : "/idm/case/exportTable",
				insertDiv : "resultDiv"
			};
		$("#exportSearch").submitFormLoadHtml(searchObj);
	}

	function exportList(){
		$("#exportTable").exportExcel("导出个案报表");
		
	}
	
	return {
		addColumns : addColumns,
		exportList : exportList
	};
})();


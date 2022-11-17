var hsaLocationInspListView = (function() {
	$(function() {
		/* 返回 */
		$("#hsa-input-back-btn").click(function() {
			back();
		});
		// 新增
		$("#hsa-input-add-btn").click(function() {
			$("#hsa-inspRecord-table").find("tr.listtrselect").removeClass("listtrselect");
			add();
		});
		

	});

	function back() {
		$("#hsa-record-location-input-add").hide();
		$("#hsa-record-locationList-box").show();
		hsaInspRecordLocationList.search(1);
	}



	function add() {
		var loadHtmlByUrlOption = {
			url : "/hsa/inspRecord/addByLocationModify",
			param : {
				id : $("#hiddenLocationId").val(),
				type : $("#hiddenInspType").val()
			},
			callback : function() {
//				validate = $("#hsa-input-form").easyValidate();
			},
			insertDiv : "hsa-location-input-add",
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}
return{
	add:add
};
})();
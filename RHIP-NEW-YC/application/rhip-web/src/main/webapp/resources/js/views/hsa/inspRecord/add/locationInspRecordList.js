var locationInspRecordList = (function()
{
	$(function()
	{
		$("#hsa-inspRecord-table tbody tr").on("click",function(){
			var locId=$(this).data("locationId");
			if(locId){
				selectItemList(locId);
			}
		});
	});
	function refreshList(){
		var loadHtmlByUrlOption = {
				url : "/hsa/inspRecord/addByLocationInputList",
				param : {
					id : $("#hiddenLocationId").val()
				},
				insertDiv : "hsa-location-input-list",
				callback : function(data) {
					$("#hsa-inspRecord-table").find("tr.listtrselect").removeClass("listtrselect");
				}
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		
	}
	
	function selectItemList(id) {
		var loadHtmlByUrlOption = {
			url : "/hsa/inspRecord/addLocationSearchOrModify",
			param : {
				id : id
			},
			callback : function() {
				validate = $("#hsa-input-form").easyValidate();
			},
			insertDiv : "hsa-location-input-add"
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}
	
	

	return{
		refreshList:refreshList,
		selectItemList:selectItemList
	};
})();
var hsaInspRecordLocationList =(function()
{
	$(function() { 
		 search(1);
	 //添加回车监听事件
	 $('form').keypress(function (e) {
	     var key = e.which;
	     if (key == 13) {
	    	 search(1);
	     }
	 });
	 /*查询*/
	    $("#hsa-inspRecord-locationList-search_btn").click(function(e) {
	     e.preventDefault();
//	    	if(!checkDate()){
//	    		return;
//	    	}
	        search(1);
	    });
	
	    //新增
	   $("#hsa-inspRecord-addLocation-btn").click(function() {
		   addLocationCard();
	    });
		 
		  //点击超链接新增信息
		 $("#hsa-record-result-locationList").on("click", ".hsa-location-listdatagrid-modify-link",function(event){
				event.preventDefault();
				$("#hsa-record-locationList-box").hide();
				$("#hsa-record-location-input-add").show();
				var loadHtmlByUrlOption = {
					url : "/hsa/inspRecord/addByLocation",
					insertDiv : "hsa-record-location-input-add",
					param:{
							id:$(this).data("id"),
							type:$("#hsa-insp-record-type").val()
					}
				};
				$.loadHtmlByUrl(loadHtmlByUrlOption);
			});
		 
		  //点击超链接查看信息
		 $("#hsa-record-result-locationList").on("click", ".hsa-location-listdatagrid-view-link",function(event){
				event.preventDefault();
				$("#hsa-record-locationList-box").hide();
				$("#hsa-record-location-input-add").show();
				var loadHtmlByUrlOption = {
					url : "/hsa/inspRecord/addLocationSearch",
					insertDiv : "hsa-record-location-input-add",
					param:{
							id:$(this).data("id"),
							type:$("#hsa-insp-record-type").val()
					}
				};
				$.loadHtmlByUrl(loadHtmlByUrlOption);
			});
		 
		 //点击超链接查看信息
		 $("#hsa-record-result-locationList").on("click", ".hsa-location-modify-link",function(event){
				event.preventDefault();
				$("#hsa-record-locationList-box").hide();
				$("#hsa-record-location-input-add").show();
				var loadHtmlByUrlOption = {
					url : "/hsa/inspRecord/getLocInfoForUpdate",
					insertDiv : "hsa-record-location-input-add",
					param:{
						locationId:$(this).data("id")
					}
				};
				$.loadHtmlByUrl(loadHtmlByUrlOption);
			});
	});
	
	function checkDate(){
		var startDate=$("#hsa-startDate").val();
		var endDate=$("#hsa-endDate").val();
		if(startDate&&endDate&&startDate > endDate){
			layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
			return false;
		}
		return true;
	}
	
	function addLocationCard(event)
	{
		$("#hsa-record-locationList-box").hide();
		$("#hsa-record-location-input-add").show();
		var loadHtmlByUrlOption = {
			url : "/hsa/inspRecord/addLocationInfo",
			insertDiv : "hsa-record-location-input-add"
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}
	
	 //查询列表
	function search(indexPage) { 
		var searchObj = {
				url : "/hsa/inspRecord/locationListResult",
				insertDiv : "hsa-record-result-locationList",
			param : {
				indexPage : indexPage,
				type:$("#hsa-insp-record-type").val()
			}
		};
		$("#form_search").submitFormLoadHtml(searchObj);
	}
	
	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	}
	return {
		search : search,
		toggle : toggle
	};
})();
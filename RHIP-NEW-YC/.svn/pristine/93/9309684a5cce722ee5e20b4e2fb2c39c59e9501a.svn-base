var recordSearch = (function(){
	
	$(function(){
		$("#recordSearchQuery").click(function() {
			searchRecord(1);
		});
		$("#recordSearchForm").onEnter(function(){
			searchRecord(1);
		})
		searchRecord(1)
	});
	
	function searchRecord(indexPage){
		
		var createBegin = new Date($("#beginTime").val());
		var createEnd = new Date($("#endTime").val());

		if (createBegin > createEnd) {
			layer.alert("接种开始时间不能大于接种结束时间！", {icon:0,title:'提示'});
		}
		
		else{
        var searchObj = {
            url : "/system/log/recordList",
            insertDiv : "recordList",
            param : {
                indexPage : indexPage
            }
        };
        	$("#recordSearchForm").submitFormLoadHtml(searchObj);
		}
	}
	

	
	return {
	search:searchRecord
	
	}
})();
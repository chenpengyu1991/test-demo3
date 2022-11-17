define(['../organizationLink/search'],function(searchLink) {
	function load() {
		$(function() {
			$("#returnContact").click(returnSearch);
		});
	}
	
	function returnSearch(){
		if(contentChanged){
			msgUtil.backConfirm(function(){
				returnfunction();
			});
		} else {
			returnfunction();
		}
	}
	
	function returnfunction() {
		$("#infoDivLink").empty();
        $("#top_allLink").show();
        searchLink.searchLink($("#currentPage").val());	
	}
	
	
	return {
		load: load
	};
});

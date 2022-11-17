var accountInfoShowPage = (function() {
	function cancle(){
		$.removeDialog("checkDialog");
	}
	$("#returnContact").click(returnSearch);
	
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
		$("#frequentDetails").empty();
        $("#top_allLink").show();
        accountInfoSearch($("#currentPage").val());	
	}
	
	return {
		cancle:cancle,
		returnSearch:returnSearch
	};
})();
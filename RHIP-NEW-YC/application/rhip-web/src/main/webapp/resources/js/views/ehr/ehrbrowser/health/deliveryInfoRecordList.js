var deliveryInfoRecord = (function(){
	$(function(){
        getDeliveryInfoRecordList($(".WhYcfbjFmxx:first").val());
	});
	
	function getDeliveryInfoRecordList(id){
		var loadByUrl = {
			url : "/ehrbrowser/health/deliveryInfoRecordDetail",
			insertDiv : "WhYcfbjFmxxDiv",
			param : {
				id : id
			}
		};
		$.loadHtmlByUrl(loadByUrl);
	}
	
	return {
        getDeliveryInfoRecordList : getDeliveryInfoRecordList
	};
})();
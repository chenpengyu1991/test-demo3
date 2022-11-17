var qtfhcsList = (function() {
	var operationType = $("#operationType").val();
	$(function(){
		if(operationType=='1'){
			$(".qtfhcsListModify").hide();
			$(".qtfhcsListDelete").hide();
		}
	});
})();

var hmVerifyList = (function() {
	$(function() { 
            util.checkBoxAll("checkAllRecords","personId");
	});
	
	function confirmPerson(personId) {
		var params = {
				url : "/hm/verify/confirm",
				callback : confirmCallback,
				insertDiv : "hmVerifyList_" + personId,
				param : {
					personIds : personId
				}
		};
		$.getJsonByUrl(params);
		
	}
	
	function cancelConfirmPerson(personId) {
		var params = {
				url : "/hm/verify/cancelConfirm",
				callback : confirmCallback,
				insertDiv : "hmVerifyList_" + personId,
				param : {
					personIds : personId
				}
		};
		$.getJsonByUrl(params);
	}
	
	function confirmCallback(data) {
		layer.alert(data.message, {icon:0,title:'提示'});
		if (data.success) {
			hmVerifySearch.search($("#currentPage").val());
		}
	}

	return {
		confirmPerson : confirmPerson,
		cancelConfirmPerson : cancelConfirmPerson
	};
})();
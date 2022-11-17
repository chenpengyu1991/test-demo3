var verifyCheck = (function() {
	function doCheck(id){
		$.getJsonByUrl({
			url : "/personRecord/verify/doCheck",
			param : {
				id : id
			},
			callback : function(model) {
				if(model.success){
					layer.alert("审核成功！", {icon:0,title:'提示'});
					verifySearch.search(1);
				}else{
					layer.alert("审核失败！", {icon:0,title:'提示'});
				}
			}
		});
	}
	function backToSearch(){
		$("#checkDiv").empty();
		$("#mainSearchDiv").show();
	}
	return {
		doCheck:doCheck,
		backToSearch:backToSearch
	};
})();

var verifyList = (function() {
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
					cancel();
				}else{
					layer.alert("审核失败！", {icon:0,title:'提示'});
				}
			}
		});
	}
	
	function check(id,checkFlag){
		if(id){
			var option = {
					url : "/personRecord/verify/check",
					id : "checkDialog",
					height : 540,
					weight : 30,
					width : "65%",
					param : {
						id : id,
						operatorType:checkFlag
					},
					title : "健康档案信息审核"
			};
			$.dialog(option);
		}
	}
	function cancel(){
		$.removeDialog("checkDialog");
	}			
	return {
		check:check,
		doCheck:doCheck,
		cancel:cancel
	};
})();

var reserveList = (function() {
	
	function view(id){
		window.location.href= contextPath + "/userSpace/reserve/view/" + id;
		
			
	}
	
	function cancel(id){
		msgUtil.confirm("你确定要取消本次预约？",function(){
		/*if(confirm("你确定要取消本次预约")){*/
			docancel(id);
		});
	}
	
	function docancel(id){
		var option = {
			url : "/userSpace/reserve/cancel",
			param :{
				regId:id
			},
			callback:function(data){
				if(data == "ok"){
					msgUtil.alert("取消预约成功");
					reserveSearch.search(1);
					return;
				}else if(data == "fail"){
					msgUtil.alert("取消预约失败");
					return;
				}else{
					msgUtil.alert("取消预约失败：" + data);
				}
			}
		};
		$.getJsonByUrl(option);
	}
	
	return {
		view : view,
		cancel : cancel
	};
})();
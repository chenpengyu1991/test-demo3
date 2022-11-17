var reserveList = (function() {
	
	function view(id){
		var option = {
			id : "viewDialogId",
			title : "查看预约挂号",
			url : "/portal/reserve/view",
			param :{
				regId:id
			},
			width : 800,
			height : 500
		};
		$.dialog(option);
	}

    function print(id){
        var url = contextPath + "/portal/reserve/print?regId=" + id;
        util.printPage(url);
    }

	function cancel(id){
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm('你确定要取消本次预约', {icon:1, title:'确认提示'}, function(index){
				docancel(id);
				layer.close(index);
			});
		});
	}
	
	function docancel(id){
		var option = {
			url : "/portal/reserve/cancel",
			param :{
				regId:id
			},
			callback:function(data){
				if(data == "ok"){
					layer.alert("取消预约成功！", {icon:0,title:'提示'});
					reserveSearch.search(1);
					return;
				}else if(data == "fail"){
					layer.alert("取消预约失败！", {icon:0,title:'提示'});
					return;
				}else{
					layer.alert("取消预约失败：" + data, {icon:0,title:'提示'});
				}
			}
		};
		$.getJsonByUrl(option);
	}
	
	return {
		view : view,
		cancel : cancel,
        print : print
	};
})();
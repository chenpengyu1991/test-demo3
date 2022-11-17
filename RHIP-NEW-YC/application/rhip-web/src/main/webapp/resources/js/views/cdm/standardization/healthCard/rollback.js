var rollbackHM = (function() {
	$("#save").click(function() {
		var id = $("#id").val();
		var validate = $("#rollbackForm").easyValidate();
		if (!$.isEmpty($('input[name="hbpFlag"]:visible:checked').val()) || !$.isEmpty($('input[name="diFlag"]:visible:checked').val())||
            !$.isEmpty($('input[name="tumorFlag"]:visible:checked').val()) || !$.isEmpty($('input[name="coronaryFlag"]:visible:checked').val())||
            !$.isEmpty($('input[name="strokeFlag"]:visible:checked').val())) {
			$("#rollbackForm").submitFormGetJson({
				url : "/cdm/standardization/delete",
				callback : submitCallback
			});
		} else {
			layui.use('layer', function() {
    			var layer = layui.layer;
    			layer.alert("请至少选一个需要撤销的慢病类型！", {icon:0,title:'提示'})
    		});
		    /*msgUtil.alert("请至少选一个需要撤销的慢病类型！")*/
        }
	});
    function deleteCard(event) {
        event.preventDefault();
        var id = $(this).data("disid");
        if (id) {
            var option = {
                url: "/cdm/standardization/delete/" + id,
                callback: refreshList,
                wait: true
            };
            
            layui.use('layer', function() {
    			var layer = layui.layer;
    			var index = layer.confirm('撤销管理卡将删除其相关的全部信息,确定撤销?', {icon:2, title:'确认提示'}, function(){
    				layer.close(index);
    				 $.getJsonByUrl(option);
				});
    			
    		});
           /* layer.confirm("撤销管理卡将删除其相关的全部信息,确定撤销?", function (index) {
                $.getJsonByUrl(option);
                layer.close(index);
            });*/
        }
    }
	function submitCallback(data) {
        var indexPage = $("#currentPage").val();
        layui.use('layer', function() {
			var layer = layui.layer;
			
			if (data == true) {
				var index = layer.alert("撤销成功！", {icon:0,title:'提示'}, function() {
					/*$.removeDialog("rollbackDiv");*/
					layer.closeAll();
					healthCardList.search(1);
				});
			} else {
				/*msgUtil.alert("撤销失败！");*/
				layer.alert("撤销失败！", {icon:0,title:'提示'});
			}
			
		});
        
	}
})();
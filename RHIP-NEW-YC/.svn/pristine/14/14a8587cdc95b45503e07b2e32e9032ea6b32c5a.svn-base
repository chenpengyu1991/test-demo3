var rollbackHM = (function() {
	$("#save").click(function() {
		var id = $("#id").val();
		var validate = $("#rollbackForm").easyValidate();
		if (!$.isEmpty($('input[name="hbpFlag"]:visible:checked').val()) || !$.isEmpty($('input[name="diFlag"]:visible:checked').val())||
            !$.isEmpty($('input[name="tumorFlag"]:visible:checked').val()) || !$.isEmpty($('input[name="coronaryFlag"]:visible:checked').val())||
            !$.isEmpty($('input[name="strokeFlag"]:visible:checked').val())) {
			$("#rollbackForm").submitFormGetJson({
				url : "/cdm/standardization/renew",
				callback : submitCallback
			});
		} else {
			layui.use('layer', function() {
    			var layer = layui.layer;
    			layer.alert("请至少选一个需要恢复的慢病类型！", {icon:0,title:'提示'});
    		});
		    /*msgUtil.alert("请至少选一个需要恢复的慢病类型！")*/
        }
	});

	function submitCallback(data) {
        var indexPage = $("#currentPage").val();
        layui.use('layer', function() {
			var layer = layui.layer;
			if (data == true) {
				var index = layer.alert("恢复成功！", {icon:0,title:'提示'}, function() {
					/*$.removeDialog("renewDiv");*/
					layer.closeAll();
					cdmStandardizationCancel.search(1);
				});
			} else {
				layer.alert("恢复失败！", {icon:0,title:'提示'});
			}
			
		});
	}
})();
var food = (function() {
    $(function() {
        enableChangeConfirm();
        $("#save").click(save);

    });
    function save(event) {
    	event.preventDefault();
            var option = {
                url : "/fdm/reportCard/saveFoodTest",
                callback : (function(result) {
    	    			layer.alert(result.message, {icon:0,title:'提示'});
    	    			if (result.success) {
    	    				layer.alert("保存成功！", {icon:0,title:'提示'}, function(index) {
    	    					layer.closeAll();
    	    					fdReportCardSearch.back();
    	    					fdReportCardSearch.search(1);
    	    					layer.close(index);
    	    				});
    	    			}
                })
            };
            $("#editForm").submitFormGetJson(option);
        }


    return {
        save : save
    }
})();

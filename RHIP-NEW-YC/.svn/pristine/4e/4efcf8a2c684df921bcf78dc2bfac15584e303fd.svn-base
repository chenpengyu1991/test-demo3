var financeEdit = (function() {
	var validate = $("#editForm").easyValidate();
	$(function() {
		enableChangeConfirm();
		$("#back").click(back);
		$("#save").click(save);
	});

    function save() {
        var type = $("#type").val();
        if (validate.validateForm()) {
            var option = {
                url : "/finance/save" + type,
                callback : (function(result) {
                	layer.alert(result.message, {icon:0,title:'提示'});
                    if (result.success) {
                        back();
                        layer.alert("保存成功！", {icon:0,title:'提示'});
                    }
                }),
                wait : true
            };
            $("#editForm").submitFormGetJson(option);
        }
    }

	function back() {
		disableChangeConfirm();
        financeSearch.search();
	}

	return {
		back : back ,
        save : save
	}
})();
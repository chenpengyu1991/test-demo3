var brwIdmRole = (function() {
    $(function() {
        $("#confirmId").click(function(e) {
            e.preventDefault();
            save();
        });
    });

    function save() {
        var roleNames = $("input[name='roleNames']:checked").val();
        // if($.isEmpty(roleNames)) {
        // 	layer.alert("至少选择一个角色！", {icon:0,title:'提示'});
        //     return;
        // }

        var index = layer.confirm("你确定要修改吗？", {icon:1, title:'确认提示'}, function(){
            $("#brwIdmRoleForm").submitFormGetJson({
                url : "/ehrbrowser/service/brwIdmRole/save",
                wait : true,
                callback:function(data){
                    if(data.indexOf('success') > -1) {
                        layui.use('layer', function() {
                        	var layer = layui.layer;
                        	layer.alert("保存成功！", {icon:0,title:'提示'});
                        });
                    } else {
                        layui.use('layer', function() {
                        	var layer = layui.layer;
                        	layer.alert("保存失败！", {icon:0,title:'提示'});
                        });
                    }

                }
            });
            layer.close(index);
        });

    }

	return {
		save: save
	};
})();




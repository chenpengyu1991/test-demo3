var brwAnonymousSet = (function() {
    $(function() {

        $("#confirmId").click(function(e) {
            e.preventDefault();
            confirm();
        });

        $("#saveId").click(function(e) {
            e.preventDefault();
            save();
        });
    });

    function confirm(){
        var roleNames = $("input[name='roleNames']:checked").val();
        //if(isEmpty(roleNames)) {
        //    msgUtil.alert("至少选择一个角色！");
        //    return;
        //}

        $("#brwAnonymousSetFormDiv").hide();
        $("#confirmId").hide();

        $("#brwAnonymousSetPwdFormDiv").show();
        $("#saveId").show();
        $("#roleNamePwd").val("");

    }
    function save() {
        var roleNames = $("input[name='roleNames']:checked").val();
        //if(isEmpty(roleNames)) {
        //    msgUtil.alert("至少选择一个角色！");
        //    return;
        //}
        if($("#roleNamePwd").val().length==0){
        	layer.alert("密码不能为空！", {icon:0,title:'提示'});
            return;
        }

        var index = layer.confirm("你确定要修改吗？", {icon:1, title:'确认提示'},function(){
            $("#brwAnonymousSetForm").submitFormGetJson({
                url : "/ehrbrowser/service/anonymousSet/save",
                wait : true,
                param:{roleNamePwd:$("#roleNamePwd").val()},
                callback:function(data){
                    if(data.indexOf('success') > -1) {
                        layui.use('layer', function() {
                        	var layer = layui.layer;
                        	layer.alert("保存成功！", {icon:0,title:'提示'});
                        });
                        $("#brwAnonymousSetFormDiv").show();
                        $("#confirmId").show();

                        $("#brwAnonymousSetPwdFormDiv").hide();
                        $("#saveId").hide();
                    } else if(data.indexOf('error') > -1) {
                        layui.use('layer', function() {
                        	var layer = layui.layer;
                        	layer.alert("密码不正确，请重试！", {icon:0,title:'提示'});
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
        confirm: confirm,
		save: save
	};
})();




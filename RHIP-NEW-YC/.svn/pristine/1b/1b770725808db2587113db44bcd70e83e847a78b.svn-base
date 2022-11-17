var userSearch = (function() {

	$(function(){
		//分页绑定函数
		//pageUtil.bind("listDiv",searchUser);
		searchUser(1);
		$("#userFormId").onEnter(searchUser, 1);
		$("#userSearchBut").click(function(e) {
            e.preventDefault();
			searchUser(1);
		});

		$("#userSearchSpanId").click(function(){
			toggle(this,'useSearchTableId');
		});
		$("#userAddButId").click(function(e){
            e.preventDefault();
			dialog(0);
		});
	});

	
	function getOrgCode() {
		var organCode = $("#searchStation").val();
		if ($.isEmpty(organCode)) {
			organCode = $("#searchCenter").val();
		}
		if ($.isEmpty(organCode)) {
			organCode = $("#searchTown").val();
		}
		return organCode;
	}
	
    function searchUser(indexPage) {
		$("#searchOrganCode").val(getOrgCode());
		var url = contextPath + "/user/list";
		var searchObj = {
				 url : url,
				 insertDiv : "listDiv",
				 param : {indexPage : indexPage},
				callback: function() {
					/*为listDiv中a的添加click事件*/
					initLinkClick('modifyUser',dialog, {userCode:"data-userCode"});
					initLinkClick('doableUser',doable, {userCode:"data-userCode",flag:"data-status"});
					initLinkClick('deleteUser',delUser, {userCode:"data-userCode"});
					initLinkClick('passwordUser',psdUpdate, {userCode:"data-userCode"});
				}
			 };
		$("#userFormId").formPost(searchObj);
	
	}
	
	function dialog(userCode) {
		var title = "添加用户";
        if(userCode != 0){
            title = "修改用户";
        }
        $.post(contextPath+'/user/add',
            { userCode:userCode},
            function(ret){
                layui.use(['layer'], function() {
                    var layer = layui.layer
                    layer.open({
                        type: 1,
                        id:'userDialog',
                        area: ['850px', '450px'],
                        title:title,
                        content: ret,
                        success: function(layero, index){
                            $('#add_index').val(index);
                        }
                    });
                });
            });
	}
	
	function doable(userCode,flag) {
	    if(flag == 1) {
	    	flag = 0;
	    }else{
	    	flag = 1;
	    }
	    $.getJsonByUrl({
	    	url : "/user/status",
            callback:function(data){
	   			if(data == 'success'){
	   				searchUser($("#currentPage").val());
	   				if (flag == 0) {
	   					layer.alert("禁用用户成功！", {icon:0,title:'提示'});
	   				}else{
	   					layer.alert("启用用户成功！", {icon:0,title:'提示'});
	   				}
	   			}else if(data == 'fail'){
	   				if (flag == 0) {				
	   					layer.alert("禁用用户失败！", {icon:0,title:'提示'});
	   				}else{
	   					layer.alert("启用用户失败！", {icon:0,title:'提示'});
	   				}
	   			}else if(data == 'deleteSelf'){
   					layer.alert("禁用用户失败！用户不能禁用自己！", {icon:0,title:'提示'});
	   			}
   		    },
	    	param:{
	    		userCode:userCode,
	    		status:flag
	    	}
	     });
	}
	
	
	function delUser(userCode) {
		layer.confirm("确认删除?", {icon:2, title:'确认提示'}, function(index) {
			deleteDo(userCode);
			layer.close(index);
		});
	}
    
	function psdUpdate(userCode){
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm('你确定要重置密码吗？', {icon:2, title:'确认提示'}, function(index){
				$.getJsonByUrl({
					url:"/user/psdUpdate",
					param:{
						userCode:userCode
					},
					callback:function(data){
						if(data == 1){
							layer.alert("密码重置成功！", {icon:0,title:'提示'});
						}else{
							layer.alert("用户重置失败！", {icon:0,title:'提示'});
						}
					}
				});
				layer.close(index);
			});
		});
	}
	
	function deleteDo(userCode){
		$.getJsonByUrl({
	    	url : contextPath + "/user/delete",
            callback:function(data){
    			if (data == "success") {
    				searchUser($("#currentPage").val());
    				layer.alert("用户删除成功！", {icon:0,title:'提示'});
    			} else if (data == "fail") {
    				layer.alert("用户删除失败！", {icon:0,title:'提示'});
    			}else if (data == "deleteSelf") {
    				layer.alert("用户删除失败！不能删除自己！", {icon:0,title:'提示'});
    			} else {
    			    var errors = parseJson(data);
    				$("#msgError").html(errors);
    				$("#msgOK").hide();
    				$("#msgError").show();
    			}
    		},
	    	param:{
	    		userCode:userCode
	    	}
	     });
	}

    return{
    	searchUser: searchUser
    };
})();
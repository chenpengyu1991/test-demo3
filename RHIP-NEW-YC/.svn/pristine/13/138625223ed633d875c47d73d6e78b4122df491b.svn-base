var healthCheckMain = (function() {
	$(function() {
        healthCheckList(1);
		$("#tj_return").click(function(e) {
			e.preventDefault();
			layui.use('layer', function(){
				var layer = layui.layer;
				layer.confirm('确认离开？', {icon:1, title:'确认提示'}, function(){
					layer.closeAll();
					followupSearch.search(2);
				});
			});
		});

	});
	/*健康体检列表查询*/
	function healthCheckList(pageIndex) {
        pageIndex = ($.isEmpty(pageIndex)?$('#tagContent10').find("#pageIndex").val():pageIndex);
        var statusId = $('#statusId').val();
		var searchObj = {
			url : "/mhm/healthCheck/list",
			insertDiv : 'healthCheckListDiv',
			param : {
				statusId: statusId,
				pageIndex : pageIndex
			},
//			wait:true,
            callback : function(data) {
            	$('#tagContent10').find("#pageIndex").val(pageIndex);
            	add(statusId, '');
               /* $('#healthCheck tr').eq(1).addClass('listtrselect');*/
            }
		};
		$("#healthCheckListForm").submitFormLoadHtml(searchObj);
	};

	/*
	 * 添加或修改健康体检
	 * */
	function add(statusId, id){
		if($.isEmpty(statusId)) {
			statusId = $("input[name='statusId']").val();
		}
		
        // if(contentChanged){
        // 	msgUtil.backConfirm(function(){
        // 		addHealthCheck(statusId, id);
		// 	});
        // }else{
        	addHealthCheck(statusId, id);
        // }
	}
    /*
     * 新增健康体检画面
     * */
    function addHealthCheck(statusId, id){
    	disableChangeConfirm();
		var pageIndex = $('#tagContent10').find("#pageIndex").val();
		$.loadHtmlByUrl({
			url : "/mhm/healthCheck/edit",
			insertDiv :"healthCheckDiv",
			param : {
				statusId: statusId,
				id: id,
				pageIndex: pageIndex
				},
//			wait:true,
			callback : function(data) {
				$('#tagContent10').find("#pageIndex").val(pageIndex);
            }
		});
		if(!$.isEmpty(id)) {
			$("#addE").show();
	        $("#updateE").show();
	        $("#deleteE").show();
	        $("#saveE").hide();
		} else {
			$("#updateE").hide();
            $("#addE").hide();
            $("#deleteE").hide();
	        $("#saveE").show();
		}
		$("#healthCheckDiv").show();
    };

    /*
     * 保存健康体检
     * */
    function save(){
        var validate=null;
        validate = $("#healthCheckForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        $("#healthCheckForm").submitFormGetJson({
            url : "/mhm/healthCheck/save",
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("保存失败！", {icon:0,title:'提示'});
                }else {
                    layer.alert("保存成功！", {icon:0,title:'提示'});
                    disableChangeConfirm();
                    healthCheckList();
                    return false;
                }
            },
            wait:true
        });    	
    }
    
    /*
     * 删除健康体检
     * */
    function deleteHealthCheck(){
    	layui.use('layer', function(){
    		var layer = layui.layer;
    		layer.confirm("删除健康体检", {icon:2, title:'确认提示'}, function(index){
		        $("#healthCheckForm").submitFormGetJson({
		            url : "/mhm/healthCheck/delete",
		            param : {
						eventId: $('#healthCheckForm').find("#eventId").val()
						},
					wait:true,
		            callback : function(data) {
		                if (data.indexOf("fail") > -1) {
		                	layer.alert("删除失败！", {icon:0,title:'提示'});
		                }else {
		                	layer.alert("删除成功！", {icon:0,title:'提示'});
	                        healthCheckList();
		                    return false;
		                }
		            }
		        });  
		        layer.close(index);
	    	});
	    });		
    }
 	return {
        healthCheckList:healthCheckList,
 		add:add,
		save:save,
		deleteHealthCheck:deleteHealthCheck
	};
})();
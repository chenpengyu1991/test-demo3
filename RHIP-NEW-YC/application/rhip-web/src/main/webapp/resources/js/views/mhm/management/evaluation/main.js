var evaluationMain = (function() {
	$(function() { 
		evaluationList(1);
	});
	/*效果评估列表查询*/
	function evaluationList(pageIndex) {
        pageIndex = ($.isEmpty(pageIndex)?$('#tagContent6').find("#pageIndex").val():pageIndex);
        var statusId = $('#statusId').val();
		var searchObj = {
			url : "/mhm/management/evaluation/list",
			insertDiv : 'evaluationListDiv',
			param : {
				statusId: statusId,
				pageIndex : pageIndex
			},
//			wait:true,
            callback : function(data) {
            	$('#tagContent6').find("#pageIndex").val(pageIndex);
            	add(statusId, '');
                /*$('#evaluationList tr').eq(1).addClass('listtrselect');*/
            }
		};
		$("#evaluationListForm").submitFormLoadHtml(searchObj);
	};

	/*
	 * 添加或修改效果评估
	 * */
	function add(statusId, id){
		if($.isEmpty(statusId)) {
			statusId = $("input[name='statusId']").val();
		}
		
        // if(contentChanged){
        // 	msgUtil.backConfirm(function(){
        // 		addEvaluation(statusId, id);
		// 	});
        // }else{
        	addEvaluation(statusId, id);
        // }
	}
    /*
     * 新增效果评估画面
     * */
    function addEvaluation(statusId, id){
    	disableChangeConfirm();
		var pageIndex = $('#tagContent6').find("#pageIndex").val();
		$.loadHtmlByUrl({
			url : "/mhm/management/evaluation/edit",
			insertDiv :"evaluationDiv",
			param : {
				statusId: statusId,
				id: id,
				pageIndex: pageIndex
				},
//			wait:true,
			callback : function(data) {
				$('#tagContent6').find("#pageIndex").val(pageIndex);
            }
		});

        var bringIntoMode = $("select[name='mhmOtherInfo.bringIntoMode']").find("option[value!='']:selected").val();
        if(!$.isEmpty(id)) {
            //1是基础管理，2是个案管理
            if(bringIntoMode==2){
                $("#addEvaluation").show();
                $("#updateEvaluation").show();
                $("#deleteEvaluation").show();
            }else{
                $("#addEvaluation").hide();
                $("#updateEvaluation").hide();
                $("#deleteEvaluation").hide();
            }
	        $("#saveEvaluation").hide();
		} else {
			$("#updateEvaluation").hide();
            $("#addEvaluation").hide();
            $("#deleteEvaluation").hide();
            //1是基础管理，2是个案管理
            if(bringIntoMode==2){
                $("#saveEvaluation").show();
            }else{
                $("#saveEvaluation").hide();
            }
		}
		$("#evaluationDiv").show();
    };

    /*
     * 保存效果评估
     * */
    function save(){
        var validate=null;
        validate = $("#evaluationForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        $("#evaluationForm").submitFormGetJson({
            url : "/mhm/management/evaluation/save",
            param : {statusId : $('#statusId').val()},
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                	layui.use('layer', function(){
            			var layer = layui.layer;
            			layer.alert("保存失败！", {icon:0,title:'提示'});
            		});
                    /*layer.alert("保存失败！");*/
                }else {
                	layui.use('layer', function(){
            			var layer = layui.layer;
            			layer.alert("保存成功！", {icon:0,title:'提示'}, function() {
            				disableChangeConfirm();
            				evaluationList();
            				layer.closeAll();
            			});
            		});
                    /*layer.alert("保存成功！");
                    disableChangeConfirm();
                    evaluationList();*/
                    return false;
                }
            },
            wait:true
        });    	
    }
    
    /*
     * 删除效果评估
     * */
    function deleteEvaluation(){
    	/*msgUtil.confirm("删除效果评估",function(){
	        $("#evaluationForm").submitFormGetJson({
	            url : "/mhm/management/evaluation/delete",
	            param : {
					eventId: $('#evaluationForm').find("#eventId").val()
					},
				wait:true,
	            callback : function(data) {
	                if (data.indexOf("fail") > -1) {
	                    layer.alert("删除失败！");
	                }else {
	                    layer.alert("删除成功！");
	                    evaluationList();
	                    return false;
	                }
	            }
	        });  
    	});*/
    	
    	layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm('删除效果评估？', {icon:2, title:'确认提示'}, function(){
				 $("#evaluationForm").submitFormGetJson({
			            url : "/mhm/management/evaluation/delete",
			            param : {
							eventId: $('#evaluationForm').find("#eventId").val()
							},
						wait:true,
			            callback : function(data) {
			                if (data.indexOf("fail") > -1) {
			                	layer.alert("删除失败！", {icon:0,title:'提示'});
			                }else {
			                	layer.alert("删除成功！", {icon:0,title:'提示'}, function() {
			                		layer.closeAll();
			                		casePlanList();
			                	});
			                    return false;
			                }
			            }
			        });  
			});
		});
    }
 	return {
 		evaluationList:evaluationList,
 		add:add,
		save:save,
		deleteEvaluation:deleteEvaluation
	};
})();
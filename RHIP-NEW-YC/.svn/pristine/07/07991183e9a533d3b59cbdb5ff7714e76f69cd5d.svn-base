var casePlanMain = (function() {
	$(function() { 
		casePlanList(1);
	});
	/*个案管理计划列表查询*/
	function casePlanList(pageIndex) {
        pageIndex = ($.isEmpty(pageIndex)?$('#tagContent5').find("#pageIndex").val():pageIndex);
        var statusId = $('#statusId').val();
		var searchObj = {
			url : "/mhm/management/caseplan/list",
			insertDiv : 'casePlanListDiv',
			param : {
				statusId: statusId,
				pageIndex : pageIndex
			},
//			wait:true,
            callback : function(data) {
            	$('#tagContent5').find("#pageIndex").val(pageIndex);
            	add(statusId, '');
               /* $('#casePlanList tr').eq(1).addClass('listtrselect');*/
            }
		};
		$("#casePlanListForm").submitFormLoadHtml(searchObj);
	};

	/*
	 * 添加或修改个案管理计划
	 * */
	function add(statusId, id){
		if($.isEmpty(statusId)) {
			statusId = $("input[name='statusId']").val();
		}
        // if(contentChanged){
		// 	layui.use('layer', function() {
		// 		var layer = layui.layer;
		// 		var index = layer.confirm('确认离开?', {icon:1, title:'确认提示'}, function(){
		// 			layer.close(index);
		// 			addCasePlan(statusId, id);
		// 		});
		//
		// 	});
        // }else{
        	addCasePlan(statusId, id);
        // }
	}
    /*
     * 新增个案管理计划画面
     * */
    function addCasePlan(statusId, id){
    	disableChangeConfirm();
		var pageIndex = $('#tagContent5').find("#pageIndex").val();
		$.loadHtmlByUrl({
			url : "/mhm/management/caseplan/edit",
			insertDiv :"casePlanDiv",
			param : {
				statusId: statusId,
				id: id,
				pageIndex: pageIndex
				},
//			wait:true,
			callback : function(data) {
				$('#tagContent5').find("#pageIndex").val(pageIndex);
            }
		});

        var bringIntoMode = $("select[name='mhmOtherInfo.bringIntoMode']").find("option[value!='']:selected").val();
        if(!$.isEmpty(id)) {
            //1是基础管理，2是个案管理
            if(bringIntoMode==2){
                $("#addCase").show();
                $("#updateCase").show();
                $("#deleteCase").show();
            }else{
                $("#addCase").hide();
                $("#updateCase").hide();
                $("#deleteCase").hide();
            }
            $("#saveCase").hide();
        } else {
			$("#updateCase").hide();
            $("#addCase").hide();
            $("#deleteCase").hide();
            //1是基础管理，2是个案管理
            if(bringIntoMode==2){
                $("#saveCase").show();
            }else{
                $("#saveCase").hide();
            }
		}
		$("#casePlanDiv").show();
    };

    /*
     * 保存个案管理计划
     * */
    function save(){
        var validate=null;
        validate = $("#casePlanForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        $("#caseDetailJson").val(util.Obj2str(mhmCommon.getTablesData('caseDetailId', [], [], '')));
        $("#casePlanForm").submitFormGetJson({
            url : "/mhm/management/caseplan/save",
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                	layui.use('layer', function(){
            			var layer = layui.layer;
            			layer.alert("保存失败！", {icon:0,title:'提示'});
            		});
                }else {
                	layui.use('layer', function(){
            			var layer = layui.layer;
            			layer.alert("保存成功！", {icon:0,title:'提示'}, function() {
            				disableChangeConfirm();
            				casePlanList();
            				layer.closeAll();
            			});
            		});
                    /*msgUtil.alert("保存成功！");*/
                    return false;
                }
            },
            wait:true
        });    	
    }
    
    /*
     * 删除个案管理计划
     * */
    function deleteCasePlan(){
    	/*msgUtil.confirm("删除个案管理计划",function(){
	        $("#casePlanForm").submitFormGetJson({
	            url : "/mhm/management/caseplan/delete",
	            param : {
					eventId: $('#casePlanForm').find("#eventId").val()
					},
				wait:true,
	            callback : function(data) {
	                if (data.indexOf("fail") > -1) {
	                    msgUtil.alert("删除失败！");
	                }else {
	                    msgUtil.alert("删除成功！");
	                    casePlanList();
	                    return false;
	                }
	            }
	        });  
    	});*/
    	
    	layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm('删除个案管理计划？', {icon:2, title:'确认提示'}, function(){
				 $("#casePlanForm").submitFormGetJson({
			            url : "/mhm/management/caseplan/delete",
			            param : {
							eventId: $('#casePlanForm').find("#eventId").val()
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
 		casePlanList:casePlanList,
 		add:add,
		save:save,
		deleteCasePlan:deleteCasePlan
	};
})();
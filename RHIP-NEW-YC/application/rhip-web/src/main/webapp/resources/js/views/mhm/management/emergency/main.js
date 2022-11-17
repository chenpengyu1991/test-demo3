var emergencyMain = (function() {
	$(function() { 
		emergencyList(1);
	});
	/*应急处置列表查询*/
	function emergencyList(pageIndex) {
        pageIndex = ($.isEmpty(pageIndex)?$('#tagContent7').find("#pageIndex").val():pageIndex);
        var statusId = $('#statusId').val();
		var searchObj = {
			url : "/mhm/management/emergency/list",
			insertDiv : 'emergencyListDiv',
			param : {
				statusId: statusId,
				pageIndex : pageIndex
			},
//			wait:true,
            callback : function(data) {
            	$('#tagContent7').find("#pageIndex").val(pageIndex);
            	add(statusId, '');
               /* $('#emergencyList tr').eq(1).addClass('listtrselect');*/
            }
		};
		$("#emergencyListForm").submitFormLoadHtml(searchObj);
	};

	/*
	 * 添加或修改应急处置
	 * */
	function add(statusId, id){
		if($.isEmpty(statusId)) {
			statusId = $("input[name='statusId']").val();
		}
		
        // if(contentChanged){
        // 	msgUtil.backConfirm(function(){
        // 		addEmergency(statusId, id);
		// 	});
        // }else{
        	addEmergency(statusId, id);
        // }
	}
    /*
     * 新增应急处置画面
     * */
    function addEmergency(statusId, id){
    	disableChangeConfirm();
		var pageIndex = $('#tagContent7').find("#pageIndex").val();
		$.loadHtmlByUrl({
			url : "/mhm/management/emergency/edit",
			insertDiv :"emergencyDiv",
			param : {
				statusId: statusId,
				id: id,
				pageIndex: pageIndex
				},
//			wait:true,
			callback : function(data) {
				$('#tagContent7').find("#pageIndex").val(pageIndex);
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
		$("#emergencyDiv").show();
    };

    /*
     * 保存应急处置
     * */
    function save(){
        var validate=null;
        validate = $("#emergencyForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        $("#emergencyForm").submitFormGetJson({
            url : "/mhm/management/emergency/save",
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("保存失败！", {icon:0,title:'提示'});
                }else {
                    layer.alert("保存成功！", {icon:0,title:'提示'});
                    disableChangeConfirm();
                    emergencyList();
                    return false;
                }
            },
            wait:true
        });    	
    }
    
    /*
     * 删除应急处置
     * */
    function deleteEmergency(){
    	layui.use('layer', function(){
    		var layer = layui.layer;
    		layer.confirm("删除应急处置", {icon:2, title:'确认提示'}, function(index){
		        $("#emergencyForm").submitFormGetJson({
		            url : "/mhm/management/emergency/delete",
		            param : {
						eventId: $('#emergencyForm').find("#eventId").val()
						},
					wait:true,
		            callback : function(data) {
		                if (data.indexOf("fail") > -1) {
		                	layer.alert("删除失败！", {icon:0,title:'提示'});
		                }else {
		                	layer.alert("删除成功！", {icon:0,title:'提示'});
		                    emergencyList();
		                    return false;
		                }
		            }
		        });  
		        layer.close(index);
	    	});
	    });		
    }
 	return {
 		emergencyList:emergencyList,
 		add:add,
		save:save,
		deleteEmergency:deleteEmergency
	};
})();
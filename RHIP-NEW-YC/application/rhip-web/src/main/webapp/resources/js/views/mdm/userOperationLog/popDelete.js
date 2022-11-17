var userOperationLogPopDelete = (function() {
    $(function() {
        toggleOther('deleteContent','deleteContentOtherId','99');
        
        $("#deleteBtn").click(function(e) {
        	e.preventDefault();
        	deleteReportRecord();
        });
        
        $("#cancelBtn").click(function(e) {
        	e.preventDefault();
        	closePopUp();
        });
    });

    /**
     * 关闭删除原因页面
     * @param dialogId
     */
    function closePopUp(){
        /*$.removeDialog (dialogId);*/
    	layui.use('layer', function(){
			var layer = layui.layer;
			layer.closeAll();
		});
    }

    /**
     * 删除报卡监控记录
     */
    function deleteReportRecord(){
        validate = $("#deleteContentForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        /*var deleteContent = $("#deleteContentId").val();
    	msgUtil.confirm("删除报卡监控记录",function(){
	        $("#deleteContentForm").submitFormGetJson({
	            url : "/system/log/report/deleteReportRecord",
	            callback : function(data) {
	                if (data.indexOf("fail") > -1) {
	                    msgUtil.alert("删除失败！");
	                }else {
	                    msgUtil.alert("删除成功！");
                        userOperationLogSearch.searchReportRecord();
                        closePopUp('deleteContentDialog');
	                    return false;
	                }
	            },
//	            param : {reportRecordId:reportRecordId,deleteContent:deleteContent},
	            wait:true
	        });
    	});*/
    	
    	layui.use('layer', function(){
			var layer = layui.layer;
			var index = layer.confirm('删除报卡监控记录?', {icon:2, title:'确认提示'}, function(){
				$("#deleteContentForm").submitFormGetJson({
		            url : "/system/log/report/deleteReportRecord",
		            callback : function(data) {
		                if (data.indexOf("fail") > -1) {
		                	layer.close(index);
		                	layer.alert("删除失败！", {icon:0,title:'提示'});
		                }else {
		                	layer.alert("删除成功！", {icon:0,title:'提示'}, function() {
		                		layer.closeAll();
		                		userOperationLogSearch.searchReportRecord();
		                	});
		                    return false;
		                }
		            },
		            wait:true
		        });
			});
		});
    }

	return {
		deleteReportRecord:deleteReportRecord,
        closePopUp:closePopUp
	};
})();
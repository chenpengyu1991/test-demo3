var drugUseEdit = (function() {
    $(function() {
        init();
    });
    function init(){
        $("#returnSearch").click(function(e) {
            e.preventDefault();
        	returnSearch();
        });
        $("#popuDrugUse").click(function(e) {
        	e.preventDefault();
        	popuDrugUse();
        });        
    }

    function popuDrugUse(drugUseId) {
    	var statusId = $('#statusId').val();
	    /*var drugUseDialog = {
	            url : "/mhm/useDrug/popuDrugUse",
	            height : 650,
	            width : 800,
	            title : "发药登记" ,
	            id :"drugUseDialog",
            	param:{drugUseId:drugUseId,statusId:statusId}	            
	        };
		$.dialog(drugUseDialog);*/
		
		$.post(contextPath+'/mhm/useDrug/popuDrugUse',
        		{  drugUseId:drugUseId,statusId:statusId
			     }, 
			function(ret){
        	layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'drugUseDialog',
        			  area: ['800px', '450px'],
        			  title:'发药登记',
        			  content: ret
        		  });
        		});
        	});
    };
    /**
     * 发药登记信息删除
     */
	function deleteDrugUse(drugUseId){
		/*msgUtil.confirm("删除发药登记信息",function(){
	        $("#drugListForm").submitFormGetJson({
	            url : "/mhm/useDrug/deleteDrugUse",
	            callback : function(data) {
	                if (data.indexOf("fail") > -1) {
	                    msgUtil.alert("删除失败！");
	                }else {
	                    msgUtil.alert("删除成功！");
	                    drugUseSearch.searchDrugList();
	                    return false;
	                }
	            },
	            param : {drugUseId:drugUseId},
	            wait:true
	        });  
    	});	*/
		
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm('删除发药登记信息？', {icon:2, title:'确认提示'}, function(){
				 $("#drugListForm").submitFormGetJson({
			            url : "/mhm/useDrug/deleteDrugUse",
			            param : {drugUseId:drugUseId},
						wait:true,
			            callback : function(data) {
			                if (data.indexOf("fail") > -1) {
			                	layer.alert("删除失败！", {icon:0,title:'提示'});
			                }else {
			                	layer.alert("删除成功！", {icon:0,title:'提示'}, function() {
			                		layer.closeAll();
			                		 drugUseSearch.searchDrugList();
			                	});
			                    return false;
			                }
			            }
			        });  
			});
		});
	}
    function returnSearch(){
		disableChangeConfirm();
        $("#drugUseDetailDiv").empty();
        drugUseSearch.searchDrugUse();
        $("#drugUse_top_all").show();
    }

	return {
        returnSearch:returnSearch,
        popuDrugUse:popuDrugUse,
        deleteDrugUse:deleteDrugUse
	};
})();




var drugSearch = (function() {
    $(function() {
        init();
    });

    function init(){
        $("#drugBtnSearch").click(function(e) {
        	e.preventDefault();
        	search();
        });
        $("#addDrug").click(function(e) {
        	e.preventDefault();
        	add();
        });
        $("#drugSearch").onEnter(search, 1);
        search(1);
    }

    function search(pageIndex) {
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var searchObj = {
            url : "/mhm/drug/list",
            insertDiv : "drugResultDiv",
            param : {
                pageIndex : pageIndex
            },
//            wait:true,
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
        };
        $("#drugSearchForm").submitFormLoadHtml(searchObj);
    };

    function add(id){
        $("#top_all").hide();
        $.loadHtmlByUrl({
            url : "/mhm/drug/add",
            insertDiv :"drugDetailDiv",
            param : {id:id}
        });
        $("#drugDetailDiv").show();
    }

    /**
     * 没有被使用的药品，可以删除
     */
	function deleteDrug(id){
		/*msgUtil.confirm("删除治疗记录",function(){
	        $("#drugSearchForm").submitFormGetJson({
	            url : "/mhm/drug/delete",
	            callback : function(data) {
	                if (data.indexOf("fail") > -1) {
	                	layui.use('layer', function(){
	    	    			var layer = layui.layer;
	    	    			layer.alert("删除失败！");
	    	    		});
	                }else {
	                	layui.use('layer', function(){
	    	    			var layer = layui.layer;
	    	    			layer.alert("删除成功！", function() {
	    	    				layer.closeAll();
	    	    				search();
	    	    			});
	    	    		});
	                    return false;
	                }
	            },
	            param : {id:id},
	            wait:true
	        });  
    	});	*/
		
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm('删除治疗记录？', {icon:2, title:'确认提示'}, function(){
				$("#drugSearchForm").submitFormGetJson({
		            url : "/mhm/drug/delete",
		            callback : function(data) {
		                if (data.indexOf("fail") > -1) {
		                	layui.use('layer', function(){
		    	    			var layer = layui.layer;
		    	    			layer.alert("删除失败！", {icon:0,title:'提示'});
		    	    		});
		                }else {
		                	layui.use('layer', function(){
		    	    			var layer = layui.layer;
		    	    			layer.alert("删除成功！", {icon:0,title:'提示'}, function() {
		    	    				layer.closeAll();
		    	    				search();
		    	    			});
		    	    		});
		                    return false;
		                }
		            },
		            param : {id:id},
		            wait:true
		        });  
			});
		});
	}
    function returnSearch(){
 		disableChangeConfirm();
        $("#drugDetailDiv").empty();
        search();
        $("#top_all").show();
    }

	return {
        search:search,
        add:add,
        returnSearch:returnSearch,
		deleteDrug:deleteDrug
	};
})();




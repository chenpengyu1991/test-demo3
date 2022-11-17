var reexamineMain = (function() {
	$(function() { 
		reexamineList(1);
		
		$("#reexamineReturn").click(function(e) {
			e.preventDefault();
			returnSearch();
		});
		
		$("#reexamineAdd").click(function(e) {
			e.preventDefault();
			add();
		});
		
		$("#reexamineUpdate").click(function(e) {
			e.preventDefault();
			save();
		});
		
		$("#reexamineSave").click(function(e) {
			e.preventDefault();
			save();
		});
		$("#reexamineDelete").click(function(e) {
			e.preventDefault();
			deleteReexamine();
		});
	});
	/*复查登记列表查询*/
	function reexamineList(pageIndex) {
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var idmId = $('#idmId').val();
		var searchObj = {
			url : "/idm/schistosome/advanced/reexamine/list",
			insertDiv : 'reexamineListDiv',
//			wait:true,
			param : {
				indexPage : pageIndex,
				idmId:idmId
			},
            callback : function(data) {
                $("#pageIndex").val(pageIndex);
                var singleId = $('#reexamineList tr').eq(1).find('#singleTrId').val();
                var idmId = $('#idmId').val();
                addReexamine(idmId,singleId);
                $('#reexamineList tr').eq(1).addClass('listtrselect');
            }
		};
		$("#reexamineListForm").submitFormLoadHtml(searchObj);
	};
    function search(){
        disableChangeConfirm();
        $("#advanceddetailDiv").empty();
        var pageIndex = $("#pageIndex").val();
        reexamineList(pageIndex);
        $("#advanced_top_all").show();
    };	
    function add(idmId,singleId){
		if (contentChanged)
		{
			 layui.use('layer', function() {
	    			var layer = layui.layer;
	    			var index = layer.confirm('确认离开?', {icon:1, title:'确认提示'}, function(){
	    				layer.close(index);
	    				addReexamine(idmId,singleId);
					});
	    			
	    		});
		}else{
			addReexamine(idmId,singleId);
		}
    }
    /*
     * 新增复查登记画面
     * */
    function addReexamine(idmId,singleId){
		var pageIndex = $("#pageIndex").val();
		$.loadHtmlByUrl({
			url : "/idm/schistosome/advanced/reexamine/edit",
			insertDiv :"reexamineDiv",
//			wait:true,
			param : {
				pageIndex:pageIndex,
				idmId:idmId,
				singleId:singleId},
			callback : function(data) {
	                $("#pageIndex").val(pageIndex);
                    initForm();
                    changeBtStatus($.isEmpty(singleId)?'add':'edit');
	            }
		});
		$("#reexamineDiv").show();
    };

    /*
     * 保存复查登记
     * */
    function save(){
        var validate=null;
        validate = $("#reexamineForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        $("#reexamineForm").submitFormGetJson({
            url : "/idm/schistosome/advanced/reexamine/save",
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layui.use('layer', function() {
                    	var layer = layui.layer;
                    	layer.alert("保存失败！", {icon:0,title:'提示'});
                    });
                }else {
                    layui.use('layer', function() {
                    	var layer = layui.layer;
                    	layer.alert("保存成功！", {icon:0,title:'提示'});
                    });
                    var pageIndex = $("#pageIndex").val();
                    reexamineList(pageIndex);
                    return false;
                }
            },
            wait:true
        });    	
    }
    
    /*
     * 删除复查登记
     * */
    function deleteReexamine(){
    	var singleId = $('#singleId').val();
    	layui.use('layer', function(){
    		var layer = layui.layer;
    		layer.confirm("删除治疗记录", {icon:2, title:'确认提示'}, function(index){
		        $("#reexamineForm").submitFormGetJson({
		            url : "/idm/schistosome/advanced/reexamine/delete",
		            callback : function(data) {
		                if (data.indexOf("fail") > -1) {
		                	layer.alert("删除失败！", {icon:0,title:'提示'});
		                }else {
		                	layer.alert("删除成功！", {icon:0,title:'提示'});
		                    var pageIndex = $("#pageIndex").val();
		                    reexamineList(pageIndex);
		                    return false;
		                }
		            },
		            param : {singleId:singleId},
		            wait:true
		        });  
		        layer.close(index);
	    	});
	    });		
    }
	function returnSearch(){
       /* if(contentChanged){
        	msgUtil.backConfirm(function(){
				search();
			});        	
        }else{
        	search();
        }*/
        // if(contentChanged){
        	layer.confirm("确定离开？", {icon:1, title:'确认提示'}, function(index){
        		layer.close(index);
				search();
			});        	
        // }else{
        // 	search();
        // }
	} 
	
	function initForm(){
		var bEndProcedure = schCommon.checkEndProcedure();
		if(bEndProcedure){
    		$("#reexamineAdd").hide();
            $("#reexamineUpdate").hide();
            $("#reexamineDelete").hide();
            $("#reexamineSave").hide();
			$("#reexamineForm").diabaleForm();
		}		
	}


	function changeBtStatus(type){
		if(type=='add'){
			$("#reexamineAdd").hide();
			$("#reexamineUpdate").hide();
			$("#reexamineDelete").hide();
			$("#reexamineSave").show();
			$("#reexamineReturn").show();
		}else{
			$("#reexamineAdd").show();
			$("#reexamineUpdate").show();
			$("#reexamineDelete").show();
			$("#reexamineSave").hide();
			$("#reexamineReturn").show();
		}
	}

 	return {
 		returnSearch:returnSearch,
 		reexamineList:reexamineList,
 		add:add,
 		addReexamine:addReexamine,
		save:save,
		deleteReexamine:deleteReexamine
	};
})();
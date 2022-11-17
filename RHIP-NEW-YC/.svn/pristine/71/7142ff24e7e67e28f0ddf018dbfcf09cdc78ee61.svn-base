var acographyMain = (function() {
	$(function() { 
		acographyList(1);
	});
	/*治疗记录列表查询*/
	function acographyList(pageIndex) {
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var idmId = $('#idmId').val();
		var searchObj = {
			url : "/idm/schistosome/acography/list",
			insertDiv : 'acographyListDiv',
//			wait:true,
			param : {
				indexPage : pageIndex,
				idmId:idmId
			},
            callback : function(data) {
                $("#pageIndex").val(pageIndex);
                var singleId = $('#acographyList tr').eq(1).find('#singleTrId').val();
                var idmId = $('#idmId').val();
                addAcography(idmId,singleId);
                $('#acographyList tr').eq(1).addClass('listtrselect');
            }
		};
		$("#acographyListForm").submitFormLoadHtml(searchObj);
	};

	function add(idmId,singleId){
        if(contentChanged){
			layer.confirm("确认离开？",function(index){
				layer.close(index);
				addAcography(idmId,singleId);
			});
        }else{
        	addAcography(idmId,singleId);
        }
	}
    /*
     * 新增治疗记录画面
     * */
    function addAcography(idmId,singleId){
    	disableChangeConfirm();
		var pageIndex = $("#pageIndex").val();
		$.loadHtmlByUrl({
			url : "/idm/schistosome/acography/edit",
			insertDiv :"acographyDiv",
//			wait:true,
			param : {
				pageIndex:pageIndex,
				idmId:idmId,
				singleId:singleId},
			callback : function(data) {
	                $("#pageIndex").val(pageIndex);
	                schCommon.changeBtStatus($.isEmpty(singleId)?'add':'edit');
	            }
		});
		$("#acographyDiv").show();
    };

    /*
     * 保存治疗记录
     * */
    function save(){
        var validate=null;
        validate = $("#acographyForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        $("#acographyForm").submitFormGetJson({
            url : "/idm/schistosome/acography/save",
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("保存失败！", {icon:0,title:'提示'});
                }else {
                    layer.alert("保存成功！", {icon:0,title:'提示'});
                    disableChangeConfirm();
                    var pageIndex = $("#pageIndex").val();
                    acographyList(pageIndex);
                    return false;
                }
            },
            wait:true
        });    	
    }
    
    /*
     * 删除治疗记录
     * */
    function deleteAcography(){
    	layui.use('layer', function(){
    		var layer = layui.layer;
    		layer.confirm("删除治疗记录", {icon:2, title:'确认提示'}, function(index){
		        $("#acographyForm").submitFormGetJson({
		            url : "/idm/schistosome/acography/delete",
		            wait:true,
		            callback : function(data) {
		                if (data.indexOf("fail") > -1) {
		                	layer.alert("删除失败！", {icon:0,title:'提示'});
		                }else {
		                	layer.alert("删除成功！", {icon:0,title:'提示'});
		                    var pageIndex = $("#pageIndex").val();
		                    acographyList(pageIndex);
		                    return false;
		                }
		            }
		        });  
		        layer.close(index);
	    	});
	    });		
    }
 	return {
 		acographyList:acographyList,
 		add:add,
		save:save,
		deleteAcography:deleteAcography
	};
})();
var medicalMain = (function() {
	$(function() { 
		medicalList(1);
	});
	/*体检列表查询*/
	function medicalList(pageIndex) {
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var idmId = $('#idmId').val();
		var searchObj = {
			url : "/idm/schistosome/advanced/medical/list",
			insertDiv : 'medicalMainListDiv',
//			wait:true,
			param : {
				indexPage : pageIndex,
				idmId:idmId
			},
            callback : function(data) {
                $("#pageIndex").val(pageIndex);
                var singleId = $('#medicalList tr').eq(1).find('#singleTrId').val();
                var idmId = $('#idmId').val();
                addMedical(idmId,singleId);
                $('#medicalList tr').eq(1).addClass('listtrselect');
            }
		};
		$("#medicalMainListForm").submitFormLoadHtml(searchObj);
	};
    function search(){
        disableChangeConfirm();
        $("#advanceddetailDiv").empty();
        var pageIndex = $("#pageIndex").val();
        medicalList(pageIndex);
        $("#advanced_top_all").show();
    };	
    function add(idmId,singleId){
        /*if(contentChanged){
        	msgUtil.backConfirm(function(){
        		addMedical(idmId,singleId);
			});        	
        }else{
        	addMedical(idmId,singleId);
        }*/

		if (contentChanged)
		{
			 layui.use('layer', function() {
	    			var layer = layui.layer;
	    			var index = layer.confirm('确认离开?', {icon:1, title:'确认提示'}, function(){
	    				layer.close(index);
	    				addMedical(idmId,singleId);
					});
	    			
	    		});
		}else{
			addMedical(idmId,singleId);
		}    	
    }
    /*
     * 新增体检画面
     * */
    function addMedical(idmId,singleId){
		var pageIndex = $("#pageIndex").val();
		$.loadHtmlByUrl({
			url : "/idm/schistosome/advanced/medical/edit",
			insertDiv :"medicalDiv",
//			wait:true,
			param : {
				pageIndex:pageIndex,
				idmId:idmId,
				singleId:singleId},
			callback : function(data) {
	                $("#pageIndex").val(pageIndex);
                    initForm();
                    schCommon.changeBtStatus($.isEmpty(singleId)?'add':'edit');
	            }
		});
		$("#medicalDiv").show();
    };

    /*
     * 保存体检
     * */
    function save(){
        var validate=null;
        validate = $("#medicalForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        formatDate();
        $("#medicalForm").submitFormGetJson({
            url : "/idm/schistosome/advanced/medical/save",
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
                    disableChangeConfirm();
                    var pageIndex = $("#pageIndex").val();
                    medicalList(pageIndex);
                    return false;
                }
            },
            wait:true
        });    	
    }
    
    /*
     * 删除体检
     * */
    function deleteMedical(){
    	var singleId = $('#singleId').val();
    	layui.use('layer', function(){
    		var layer = layui.layer;
    		layer.confirm("删除治疗记录",function(index){
		        $("#medicalForm").submitFormGetJson({
		            url : "/idm/schistosome/advanced/medical/delete",
		            callback : function(data) {
		                if (data.indexOf("fail") > -1) {
		                	layer.alert("删除失败！", {icon:0,title:'提示'});
		                }else {
		                	layer.alert("删除成功！", {icon:0,title:'提示'});
		                    var pageIndex = $("#pageIndex").val();
		                    medicalList(pageIndex);
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
        if(contentChanged){
        	msgUtil.backConfirm(function(){
				search();
			});        	
        }else{
        	search();
        }
	} 
	
	function initForm(){
		var bEndProcedure = schCommon.checkEndProcedure();
		if(bEndProcedure){
    		$("#add").hide();
            $("#update").hide();
            $("#delete").hide();
            $("#save").hide();
			$("#medicalForm").diabaleForm();
		}		
	}
    function formatDate(){

        var firstDiagnosisDt =  $('#firstDiagnosisDt').val();
        if(!$.isEmpty(firstDiagnosisDt)){
        	firstDiagnosisDt = firstDiagnosisDt + '/01/01';
            $('#firstDiagnosisDtHidden').val(firstDiagnosisDt);
        } 
       
        var firstWxdiagnosisDt =  $('#firstWxdiagnosisDt').val();
        if(!$.isEmpty(firstWxdiagnosisDt)){
        	firstWxdiagnosisDt = firstWxdiagnosisDt + '/01/01';
            $('#firstWxdiagnosisDtHidden').val(firstWxdiagnosisDt);
        }    
        
        var cureDate =  $('#cureDate').val();
        if(!$.isEmpty(cureDate)){
        	cureDate = cureDate + '/01/01';
            $('#cureDateHidden').val(cureDate);
        }        
    }	
 	return {
 		returnSearch:returnSearch,
 		medicalList:medicalList,
 		add:add,
 		addMedical:addMedical,
		save:save,
		deleteMedical:deleteMedical
	};
})();
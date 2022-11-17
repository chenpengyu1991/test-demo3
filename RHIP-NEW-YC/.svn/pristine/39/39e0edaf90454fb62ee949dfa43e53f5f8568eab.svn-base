var surveyMain = (function() {
	$(function() { 
		surveyList(1);
		
		$("#surveryReturn").click(function(e) {
			e.preventDefault();
			returnSearch();
		});
		
		$("#surveryAdd").click(function(e) {
			e.preventDefault();
			var idmIdVal =$("#idmId").val();
			add(idmIdVal);
		});
		
		$("#surveyUpdate").click(function(e) {
			e.preventDefault();
			save();
		});
		
		$("#surverySave").click(function(e) {
			e.preventDefault();
			save();
		});
		
		$("#surveyDelete").click(function(e) {
			e.preventDefault();
			deleteSurvey();
		});
		
	});
	/*调查记录列表查询*/
	function surveyList(pageIndex) {
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var idmId = $('#idmId').val();
		var searchObj = {
			url : "/idm/schistosome/advanced/survey/list",
			insertDiv : 'surveyListDiv',
//			wait:true,
			param : {
				indexPage : pageIndex,
				idmId:idmId
			},
            callback : function(data) {
                $("#pageIndex").val(pageIndex);
                var singleId = $('#surveyList tr').eq(1).find('#singleTrId').val();
                var idmId = $('#idmId').val();
                addSurvey(idmId,singleId);
                $('#surveyList tr').eq(1).addClass('listtrselect');
            }
		};
		$("#surveyListForm").submitFormLoadHtml(searchObj);
	};
    function search(){
        disableChangeConfirm();
        $("#advanceddetailDiv").empty();
        var pageIndex = $("#pageIndex").val();
        surveyList(pageIndex);
        $("#advanced_top_all").show();
    };	
    function add(idmId,singleId){
       /* if(contentChanged){
        	msgUtil.backConfirm(function(){
        		addSurvey(idmId,singleId);
			});        	
        }else{
        	addSurvey(idmId,singleId);
        }   */
       addSurvey(idmId,singleId);
    }
    /*
     * 新增调查画面
     * */
    function addSurvey(idmId,singleId){
		var pageIndex = $("#pageIndex").val();
		$.loadHtmlByUrl({
			url : "/idm/schistosome/advanced/survey/edit",
			insertDiv :"surveyDiv",
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
		$("#surveyDiv").show();
    };

    /*
     * 保存调查记录
     * */
    function save(){
		var idCard = $('#surveyidCard').val();
		if(idCard == '输入身份证获取个人信息'){
			 $('#surveyidCard').val('');
		}    	
        var validate=null;
        validate = $("#surveyForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        formatDate();//格式化日期字段
        $("#surveyForm").submitFormGetJson({
            url : "/idm/schistosome/advanced/survey/save",
            wait:true,
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("保存失败！", {icon:0,title:'提示'});
                }else {
                    layer.alert("保存成功！", {icon:0,title:'提示'});
                    disableChangeConfirm();
                    var pageIndex = $("#pageIndex").val();
                    surveyList(pageIndex);
                    return false;
                }
            },
            wait:true
        });    	
    }
    
    function formatDate(){

        var lastEtiologyDt =  $('#lastEtiologyDtDisplay').val();
        if(!$.isEmpty(lastEtiologyDt)){
        	lastEtiologyDt = lastEtiologyDt + '/01';
            $('#lastEtiologyDtId').val(lastEtiologyDt);
        } 
       
        var firstWxdiagnosisDt =  $('#firstWxdiagnosisDtDisplay').val();
        if(!$.isEmpty(firstWxdiagnosisDt)){
        	firstWxdiagnosisDt = firstWxdiagnosisDt + '/01';
            $('#firstWxdiagnosisDtId').val(firstWxdiagnosisDt);
        }         
    }
    
    /*
     * 删除调查记录
     * */
    function deleteSurvey(){
    	var singleId = $('#singleId').val();
    	layui.use('layer', function(){
    		var layer = layui.layer;
    		layer.confirm("删除治疗记录", {icon:2, title:'确认提示'}, function(index){
		        $("#surveyForm").submitFormGetJson({
		            url : "/idm/schistosome/advanced/survey/delete",
		            callback : function(data) {
		                if (data.indexOf("fail") > -1) {
		                	layer.alert("删除失败！", {icon:0,title:'提示'});
		                }else {
		                	layer.alert("删除成功！", {icon:0,title:'提示'});
		                    var pageIndex = $("#pageIndex").val();
		                    surveyList(pageIndex);
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
      /*  if(contentChanged){
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
    		$("#surveryAdd").hide();
            $("#surveyUpdate").hide();
            $("#surveyDelete").hide();
            $("#surverySave").hide();
            $("#surveyForm input[data-inputtype]").removeAttr("onfocus");
			$("#surveyForm").diabaleForm();
		}		
	}

	function changeBtStatus(type){
		debugger;
		if(type=='add'){
			$("#surveryAdd").hide();
			$("#surveyUpdate").hide();
			$("#surveyDelete").hide();
			$("#surverySave").show();
			$("#surveryReturn").show();
		}else{
			$("#surveryAdd").show();
			$("#surveyUpdate").show();
			$("#surveyDelete").show();
			$("#surverySave").hide();
			$("#surveryReturn").show();
		}
	}
 	return {
 		returnSearch:returnSearch,
 		surveyList:surveyList,
 		add:add,
		save:save,
		deleteSurvey:deleteSurvey
	};
})();
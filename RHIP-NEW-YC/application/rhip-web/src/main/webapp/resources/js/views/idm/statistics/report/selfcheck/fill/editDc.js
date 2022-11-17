var selfFillDcEdit = (function() {
	var validate=null;
	$(function() { 
		 validate = $("#selfFillForm").easyValidate();
		 enableChangeConfirm();
		 var type = $('#tagContent2').find('#type').val();
        if('view' == type){
            $("#selfFillForm").diabaleForm();
            $('#tagContent2').find('#reportMonthSelfId').removeAttr("onfocus");
            $('#tagContent2').find('#reportDateId').removeAttr("onfocus");
            $('.required').removeClass("required");
        }
        $("#addInfectious").click(function() {
            var infectiousDialog = {
                    url : "/idm/statistics/report/selfcheck/editInfectious",
                    height : 250,
                    width : 700,
                    title : "新增传染病" ,
                    id :"infectiousDialog"
                };
            $.dialog(infectiousDialog);
        });
        $('#reportMonthSelfId').on("onDatePickerChanged",function(){
        	existFill();
        });        
	});
    function popupInfectious(btn, type){
        var param = '';
        if("edit" == type){
            var extendDiv = btn.parentNode.parentNode;
            var rowIndex = extendDiv.rowIndex;
            var trData = {};
            $(extendDiv).find("td").each(function(tdindex,tditem){
                var inputValue = $(tditem).text();
                if('' != inputValue){
                    trData[$(this).attr("field")] = inputValue;
                }
            });
            var trDataStr =  "[" + util.Obj2str(trData) + "]";
            param = {trData:trDataStr, rowIndex:rowIndex, type:'edit'};
        }
        var infectiousDialog = {
                url : "/idm/statistics/report/selfcheck/editInfectious",
                height : 250,
                width : 700,
                title : "新增传染病" ,
                id :"infectiousDialog",
                param:param
            };
        $.dialog(infectiousDialog);
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
    function search(){
        disableChangeConfirm();
    	var type = $('#tagContent2').find('#type').val();
        if('add' == type){
        	$("#selfcheck_top_all").show();
        	$('#spanSelfFill1Id').removeClass("active");
        	$('#spanSelfListId').attr("class", "active"); 
        	$("#selfcheck_detailDiv").hide();
        	reportSelfCheckIndex.loadFillSearch();
        }else{
            $("#fillSelfdetailDiv").empty();
            selfFillSearch.search();
            $("#fillSelfTopAll").show();
        }        
    }
     /*
     * 执行情况自查-传染病报告 提交保存
     * */
    function fillSubmit(){
    	var result=validate.validateForm();
    	if(!result){
    		return;
    	} 
    	var scDcTableData = util.Obj2str(idmCommon.getTablesData('scDcTable', [], [], null));
    	$("#listScDcJsonId").val(scDcTableData);
		$("#selfFillForm").submitFormGetJson({
			url : "/idm/statistics/report/selfcheck/saveFill",
			param : {type:'1'},
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("保存失败！", {icon:0,title:'提示'});
                }else {
                    layer.alert("保存成功！", {icon:0,title:'提示'});
                    search();
                    return false;
                }
            },
            wait:true
		});    	
    }
    function formatDate(){
        var reportMonth =  $('#tagContent2').find('#reportMonthId').val();
        if(!$.isEmpty(reportMonth)){
        	reportMonth = reportMonth + '/01';
        	$('#tagContent2').find('#reportMonthId').val(reportMonth);
        } 
    }
    /*
     * 检测该月份是否已经填报
     * */
    function existFill(){
    	 var reportMonth =  $('#reportMonthSelfId').val();
    	 var reportMonthOld = $('#tagContent2').find('#reportMonthOldId').val();
    	 var departmentCode = $('#tagContent2').find('#departmentCodeId').val();
    	 if(reportMonth == reportMonthOld){
    		 return;
    	 }
    	 if($.isEmpty(departmentCode)){
    		 return;
    	 }
    	 var reportUnitCode = $('#tagContent2').find('#reportUnitCodeId').val();
         if(!$.isEmpty(reportMonth) && !$.isEmpty(reportUnitCode)){
         	reportMonth = reportMonth + '/01';
    		$.getJsonByUrl({
    			url : "/idm/statistics/report/selfcheck/queryFill",
    			callback : function(data) {
    				checkReportMonth(data.count);
    			},
    			param : {
    				reportMonth:reportMonth,
    				reportUnitCode:reportUnitCode,
    				departmentCode:departmentCode,
    				type:'1'},
    			wait:true
    		}); 
         }     	
    }
    
    function checkReportMonth(count){
    	$('#reportMonthSelfFlag').val(count);
        if(count > 0){
			validate.addError('reportMonthSelf',"该月份已经填报，不允许重复");
            validate.addCheckElement('reportMonthSelf',{"compare":["reportMonthSelfFlag","le","该月份已经填报，不允许重复"]})
        }else{
			validate.removeError('reportMonthSelf');
            validate.removeCheckElement('reportMonthSelf');
        }
    }
    
    
 	return {
 		popupInfectious:popupInfectious,
 		returnSearch:returnSearch,
 		fillSubmit:fillSubmit,
 		existFill:existFill
	};
})();
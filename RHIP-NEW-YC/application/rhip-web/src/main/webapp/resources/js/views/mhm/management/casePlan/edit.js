var casePlanEdit = (function() {
	$(function() {
        $("#addDetailId").click(function() {
        	popupDetail();	
        });		
		enableChangeConfirm();
		toggleOtherSC('mhmCase.untreatedReason','mh00016Id','99');//如未治，未治原因
		toggleOtherCK('mhmCase.adverseReaction','divDrugAdverseReaction','13');//药物不良反应
		toggleOtherSC('mhmCase.recoveryPlace','MH00037Id','99');//康复地点
		toggleOther('mhmCase.income','PH00002Id','1');//劳动收入水平
	});
  
	function popupDetail(btn, type){
        var param = '';
        if("edit" == type){
            var extendDiv = btn.parentNode.parentNode;
            var rowIndex = extendDiv.rowIndex;
            var trData = {};
            $(extendDiv).find("td").each(function(tdindex,tditem){
                var inputValue = $(tditem).text();
                inputValue = inputValue.replace(/\t/g,'');//制表符替换
                inputValue = inputValue.replace(/\n/g,'');//换行替换                
                if('' != inputValue){
                    trData[$(this).attr("field")] = inputValue;
                }
            });
            var trDataStr =  "[" + util.Obj2str(trData) + "]";
            param = {trData:trDataStr, rowIndex:rowIndex, type:'edit'};
        }

        $.post(contextPath+"/mhm/management/caseplan/popDetail",
            param,
            function(ret){
                layui.use(['layer'], function() {
                    var layer = layui.layer
                    layer.open({
                        type:1,
                        id:'detialDialog',
                        area: ['700px', '250px'],
                        title:("edit" == type?"修改":"新增") + "个案管理明细计划单" ,
                        content: ret
                    });
                });
            });

	}

 	return {
 		popupDetail:popupDetail
	};
})();
var detailEdit = (function() {
	$(function() {
        layui.use('laydate', function(){
            var laydate = layui.laydate;
            laydate.render({
                elem: '#finishTimeId'
                ,format: 'yyyy/MM/dd'
                ,max: 0
                , trigger: 'click'
            });

        });
	});
	/*保存*/
	function save(type){
		var validate = $("#detailForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
		var html = fillData();
        if('edit' == type){
            var rowIndex = $('#rowIndex').val();
            html = html.replace("</tr>", "");
            html = html.replace("<tr>", "");
            $("#caseDetailId tr").eq(rowIndex).html(html);
        }else{
            $("#caseDetailId").append(html);
        }  
        contentChanged = true;
//	    mhmCommon.closePopUp('detialDialog');	
	    mhmCommon.closeLayUiDialog();
	}
	
	function fillData(){
        var detailObj = mhmCommon.getPopObj('detailChildTable');
        var detailShowFields = ['definiteQuestion', 'setGoal', 'takeStrategy','personLiable','finishTime'];
        var detailHideFields = [];
        var detailShowValues = [detailObj.definiteQuestion,detailObj.setGoal,detailObj.takeStrategy,detailObj.personLiable,detailObj.finishTime];
        var detailHideValues = [];
        var editMethod = "casePlanEdit.popupDetail(this,'edit')";
        return mhmCommon.generateTrHtml(detailShowFields, detailHideFields, detailShowValues, detailHideValues, editMethod);
	}
 	return {
 		save:save
	};
})();
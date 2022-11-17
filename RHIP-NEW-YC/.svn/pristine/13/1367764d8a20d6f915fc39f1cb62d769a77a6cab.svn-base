var cardCrEdit = (function() {
	$(function() {
        layui.use('laydate', function(){
            var laydate = layui.laydate;
            laydate.render({
                elem: '#changeDtId'
                ,format: 'yyyy/MM/dd'
                ,max: 0
                , trigger: 'click'
            });
        });
	});
	/*添加信息变更记录*/
	function saveCr(type){
		var validate = $("#crForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
		var html = fillData();
        if('edit' == type){
            var rowIndex = $('#rowIndex').val();
            html = html.replace("</tr>", "");
            html = html.replace("<tr>", "");
            $("#crTable tr").eq(rowIndex).html(html);
        }else{
            $("#crTable").append(html);
        }  
        contentChanged = true;
        closeDialog();
	}
	
	function fillData(){
        var crObj = idmCommon.getPopObj('crChildTable');
        var crShowFields = ['changeContent', 'changeDt', 'changeUser'];
        var crHideFields = ['changeUser'];
        var crShowValues = [crObj.changeContent,crObj.changeDt,crObj.changeUser];
        var crHideValues = [crObj.changeUser];
        var editMethod = "cardEdit.popupCr(this,'edit')";
        return idmCommon.generateTrHtml(crShowFields, crHideFields, crShowValues, crHideValues, editMethod);
	}


	function closeDialog() {
        layer.close(layer.index);
    }
 	return {
 		saveCr:saveCr,
        closeDialog:closeDialog

	};
})();
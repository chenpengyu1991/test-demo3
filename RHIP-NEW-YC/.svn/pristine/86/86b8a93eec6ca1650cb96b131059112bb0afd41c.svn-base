var tumorAdd = (function() {

	function closeDialog(){
		$.removeDialog ('tumorDialogId');
	}

	function saveOptionData(type, rowIndex){
		var validate = $("#tumorFormId").easyValidate();
		var result = validate.validateForm();
		if (!result) {
			layer.alert("请选择继发源！", {icon:0,title:'提示'});
			return;
		}
		getPopObj('tumorTableId');
		closeDialog();
	}

	function fillOptionRowData(){
		var obj = getPopObj('tumorTableId');
		var isDefaultValue = '';
		var showFields = ['roleName'];
		var hideFields = ['roleCode'];

		var showValues = [obj.roleName];
		var hideValues = [ obj.roleCode];
		return generateTrHtml(showFields, hideFields, showValues, hideValues, '');
	}

	function getPopObj(tableId){
		$("#" + tableId).find("input").each(function(index, obj) {
			if(obj.type == "radio"){
				if($(this).is(":checked")){
					$("#secondaryDivId").show();
					$("#secondaryId").val($(this).attr("data-id"));
					$("#tumorIcdTenCodeTdId").html($(this).val());
					$("#tumorTypeTdId").html($(this).attr("data-tumor-type"));
					$("#tumorAccidentDateTdId").html($(this).attr("data-tumor-accident-date"));
					$("#tumorDiagnosisDateTdId").html($(this).attr("data-tumor-diagnosis-date"));
				}
			}
		});

	}

	/**
	 *
	 * @param showFields 显示的字段
	 * @param hideFields 隐藏的字段
	 * @param showValues 显示字段的值
	 * @param hideValues 隐藏字段的值
	 * @param editMethod 修改的方法
	 * @returns {string} 新增的一条子表记录的html
	 */

	function generateTrHtml(showFields, hideFields, showValues, hideValues, editMethod){
		var html = '';
		for(var i=0; i<showFields.length; i++){
			html +=  showValues[i];
		}
		for(var i=0; i<hideFields.length; i++){
			html += '<input type="type" name="' + hideFields[i] +'" style="display: none" value="' + hideValues[i] + '"/>';
		}
		return html;
	}

	return {
		closeDialog: closeDialog,
		saveOptionData: saveOptionData
	};
})();
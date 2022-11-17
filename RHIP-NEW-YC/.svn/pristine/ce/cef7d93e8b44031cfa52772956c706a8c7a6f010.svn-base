var userRoleAdd = (function() {

    $(function(){
        $("#saveContact").click(function(e){
            e.preventDefault();
            saveOptionData();
        });

        $("#cancelContact").click(function(e){
            e.preventDefault();
            closeDialog();
        });
        
        $("#saveUserRoleBtn").click(function(e) {
        	e.preventDefault();
        	saveOptionData('add',$("#row_index").val());
        })
    });

	function closeDialog(){
		layer.close(layer.index); 
        /*layer.close($('#role_index').val());*/
	}

	function saveOptionData(){
		var validate = $("#userRoleFormId").easyValidate();
		var result = validate.validateForm();
		if (!result) {
			layer.alert("请选择所拥有的角色！", {icon:0,title:'提示'});
			return;
		}
		var html = fillOptionRowData();
		$("#td" + $("#organCodeId").val()).html((html));
        /*layer.close($('#role_index').val());*/
		layer.close(layer.index); 
	}

	function fillOptionRowData(){
		var obj = getPopObj('userRoleTableId');
		var isDefaultValue = '';
		var showFields = ['roleName'];
		var hideFields = ['roleCode'];

		var showValues = [obj.roleName];
		var hideValues = [ obj.roleCode];
		//不能同时设置医院-结核病 医院-定点传染病医院 角色BUG0153756: 【肺结核健康管理】结防所账号进入，报异常
        var reg1 = RegExp(/0320/);
        var reg2 = RegExp(/0309/);
		if(reg1.test(hideValues)&&reg2.test(hideValues)){
            layer.alert("不能同时勾选医院-结核病,医院-定点传染病医院 角色！", {icon:0,title:'提示'});
            return;
		}
		return generateTrHtml(showFields, hideFields, showValues, hideValues, '');
	}

	function getPopObj(tableId){
		var popObj = {};
		var roleName = '';
		var roleCode = '';
		$("#" + tableId).find("input").each(function(index, obj) {
			if(obj.type == "checkbox"){
				if($(this).is(":checked")){
					roleCode = roleCode + $(this).val() +  ",";
					roleName = roleName +$(this).attr("data") +  "&nbsp";
				}
			}
		});
		popObj['roleCode'] = roleCode;
		popObj['roleName'] = roleName;
		return popObj;
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
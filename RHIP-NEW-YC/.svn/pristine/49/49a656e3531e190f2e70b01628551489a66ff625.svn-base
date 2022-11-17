var healthEducationResourceEdit = (function() {
	$(function() {
		var validate = $("#healthEducationResourceForm").easyValidate();
		$("#healthEducationResourceSaveButton").click(function(e) {
			e.preventDefault();
			if (validate.validateForm()) {
				$("#healthEducationResourceForm").submitFormGetJson({
					url : "/he/resource/save",
					callback : submitCallback
				});
			}
		});
	});


	function submitCallback(data) {
		layui.use('layer', function(){
			var layer = layui.layer;
			if (data.result) {
				var index = layer.alert(data.message, {icon:0,title:'提示'}, function() {
					/*$.removeDialog("healthEducationResource");*/
					layer.closeAll();
					healthEducationResourceSearch.search(1);
				});
			} else {
				layer.alert(data.message, {icon:0,title:'提示'});
			}
			
		});
	}
	
	function addOtherDevice() {
		if ($("#healthEducationResourceForm #deviceName").val() == '99') {
			//$("#deviceName").parent().append("<input type=\"text\" id=\"otherDeviceName\" name=\"otherDeviceName\" style=\"width:120px;\" reg='{\"required\":\"true\"}' />");
			$("#otherDeviceName").show();
		} else {
			$("#otherDeviceName").hide().val("");
		}
	}
	
	function addOtherMaterial() {
		if ($("#healthEducationResourceForm #materialType").val() == '99') {
			$("#otherMaterialName").show();
		} else {
			$("#otherMaterialName").hide().val("");
		}
	}
	
	return {
		addOtherDevice : addOtherDevice,
		addOtherMaterial : addOtherMaterial
	};
})();

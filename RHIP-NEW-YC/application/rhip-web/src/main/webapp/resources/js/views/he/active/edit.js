var healthEducationActiveEdit = (function() {
	$(function() {

		$("#healthEducationActiveBackButton").on("click", function () {
			layer.confirm("确认离开？",function(index){
				layer.close(index);
				doBack();
			});
		});

		var $educationPersonType=$("#healthEducationActiveForm #educationPersonType");

		$educationPersonType.multiselect({
			header : false,
			noneSelectedText : '请选择',
			selectedList : 2,
			minWidth : "auto"
		});
		
		//强制校验
		$educationPersonType.data("validate",true);
		
		var validate = $("#healthEducationActiveForm").easyValidate();
		$("#healthEducationActiveSaveButton").click(function(e) {
			e.preventDefault();
			if (validate.validateForm()) {
				$("#healthEducationActiveForm").submitFormGetJson({
					url : "/he/active/save",
					callback : submitCallback
				});
			}
		});
		$("#healthEducationActiveBackButton").click(function(){
			$.removeDialog("healthEducationActive");
		});
	});

	function doBack(){
		$("#heActiveSearchDivId").show();
		$("#heActiveDetailDivId").hide();
	}

	function submitCallback(data) {
		/*if (data.result) {
			msgUtil.alert(data.message, function() {
				$.removeDialog("healthEducationActive");
				healthEducationActiveSearch.search(1);
			});
		} else {
			msgUtil.alert(data.message);
		}*/
		
		layui.use('layer', function(){
			var layer = layui.layer;
			if (data.result) {
				var index = layer.alert(data.message, {icon:0,title:'提示'}, function() {
					doBack();
					layer.closeAll();
					healthEducationActiveSearch.search(1);
				});

			} else {
				layer.alert(data.message, {icon:0,title:'提示'});
			}
			
		});
	}
	
	function addOtherActiveType() {
		var val=$("#healthEducationActiveForm #activeType").val();
		if (val== '99') {
			$("#otherActiveType").show();
			//$("#activeType").parent().append("<input type=\"text\" id=\"otherActiveType\" name=\"otherActiveType\" style=\"width:125px;\" reg='{\"required\":\"true\"}' />");
			$('#activeTips').text('提供活动照片、签到及相关书面材料等等');
		} else if (val == '1') {
			$("#otherActiveType").hide().val("");
			$('#activeTips').text('提供讲座照片、签到、讲稿、通知等附件');
		} else if (val == '2') {
			$("#otherActiveType").hide().val("");
			$('#activeTips').text('提供活动照片、通知、小结等附件');
		} else {
			$("#otherActiveType").hide().val("");
			$('#activeTips').text('提供活动照片、签到及相关书面材料等等');
		}
		
		
	}
	
	function addOtherPersonType() {
		var personType = $("#healthEducationActiveForm #educationPersonType").val();
		if (!$.isEmpty(personType) && String(personType).indexOf("99") >= 0) {
			$("#otherPersonType").show();
		//	$("#educationPersonType").parent().append("<input type=\"text\" id=\"otherPersonType\" name=\"otherPersonType\" style=\"width:125px;\" reg='{\"required\":\"true\"}' />");
		} else {
			$("#otherPersonType").hide().val("");
		}
	}
	
	function addOtherBusinessType() {
		if ($("#healthEducationActiveForm #businessType").val() == '99') {
			$("#otherBusinessType").show();
		} else {
			$("#otherBusinessType").hide().val("");
		}
	}
 	
	function addOtherMaterialType() {
		if ($("#healthEducationActiveForm #materialType").val() == '99') {
			$("#otherMaterialType").show();
		} else {
			$("#otherMaterialType").hide().val("");
		}
	}
	
	return {
		addOtherActiveType:addOtherActiveType,
		addOtherPersonType:addOtherPersonType,
		addOtherBusinessType:addOtherBusinessType,
		addOtherMaterialType:addOtherMaterialType
	};
})();

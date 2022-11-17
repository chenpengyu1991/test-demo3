var hmFissureSealantInfoEdit = (function() {
	var validate = $("#infoEditForm").easyValidate();
	$(function() {
		//enableChangeConfirm();
		$("#save").click(function() {
			var result = validate.validateForm();
			if (!result) {
				//msgUtil.alert("请根据提示正确填写");
				return;
			}
			var option = {
				url : "/hm/fissureSealant/save",
				callback : function(result) {
					layer.alert(result.message, {icon:0,title:'提示'});
					if (result.success) {
						$.removeDialog("d1");
						hmFissureSealantQuerySearch.search($("#_indexPage").val());
					}
				}
			};
			$("#infoEditForm").submitFormGetJson(option);
		});
	});
	return {
		
	};
})();
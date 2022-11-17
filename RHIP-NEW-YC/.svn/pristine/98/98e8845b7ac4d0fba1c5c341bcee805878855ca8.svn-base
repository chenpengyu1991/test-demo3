var epWaterIodineMonitorInfoEdit = (function() {
	var validate = $("#infoEditForm").easyValidate();
	$(function() {
		enableChangeConfirm();
		$("#back").click(function() {
			baseLayoutLoad.popMainContent();
			epWaterIodineMonitorSearch.search($("#_indexPage").val());
			disableChangeConfirm();
		});
		$("#save").click(function() {
			var result = validate.validateForm();
			if (!result) {
				//layer.alert("请根据提示正确填写");
				return;
			}
			var option = {
				url : "/ep/waterIodine/monitor/save",
				callback : function(result) {
					layer.alert(result.message, {icon:0,title:'提示'});
					if (result.success) {
						disableChangeConfirm();
						var id = $("input[name='id']").val();
						if (id.length > 0) {
							baseLayoutLoad.popMainContent();
							epWaterIodineMonitorSearch.search($("#_indexPage").val());
						} else {
							var param = {
									investigator : $("input[name='investigator']").val(),
									investigateUnit : $("input[name='investigateUnit']").val(),
									investigateTime : $("input[name='investigateTime']").val()
								};
								baseLayoutLoad.refreshMainContent("/ep/waterIodine/monitor/edit", param);
						}
					}
				}
			};
			$("#infoEditForm").submitFormGetJson(option);
		});
	});
	
	return {
		
	};
})();
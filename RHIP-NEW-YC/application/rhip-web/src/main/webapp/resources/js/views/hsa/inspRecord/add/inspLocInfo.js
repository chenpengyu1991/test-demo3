!(function()
{
	var validate = null;

	$(function()
	{
		validate = $("#hsa-add-location-form").easyValidate();
		$("#hsa-save-LocInfo-btn").on("click", save);
		$("#hsa-back-locInfo-btn").on("click", backToList);
	});

	function back()
	{
		$("#hsa-record-locationList-box").show();
		$("#hsa-record-location-input-add").hide();
		if(hsaInspRecordLocationList){
			hsaInspRecordLocationList.search(1);
		}
	}

	function save(event)
	{
		// 验证
		var result = validate.validateForm();
		if (!result)
		{
			// msgUtil.alert("请根据提示正确输入！");
			return;
		}
		// 保存
		$("#hsa-add-location-form").submitFormGetJson({
			url : "/hsa/inspRecord/saveLocInfo",
			param : {},
			wait : true,
			callback : function(data)
			{
				if ("dul" == data)
				{
					layer.alert("本体代码重复！", {icon:0,title:'提示'});
				} else if (data == true)
				{
					layer.alert("保存成功！", {icon:0,title:'提示'}, function()
					{
						back();
					});
				} else
				{
					layer.alert("保存失败！", {icon:0,title:'提示'});
				}

			}
		});
	}

	function backToList()
	{
		$("#hsa-record-location-input-add").hide();
		$("#hsa-record-locationList-box").show();
		hsaInspRecordLocationList.search(1);
	}
})();
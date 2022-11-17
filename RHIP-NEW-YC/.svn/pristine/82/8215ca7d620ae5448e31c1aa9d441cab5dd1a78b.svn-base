var hsaInspRecordAdd = (function()
{
	$(function()
	{
		/* 返回 */
		$("#hsa-input-back-btn").click(function()
		{
			back();
		});
		
		var $form=$("#hsa-input-form");
		
		$form.find("input").prop("disabled",true);
		$form.find("select").prop("disabled",true);
		$form.find(".required").removeClass("required");

		// 确认记录界面
		$("#hsa-input-confirm-btn").click(function()
		{
			var id = $("#has-insprecord-id").val();
			var index = layer.confirm("是否确认？", {icon:1, title:'确认提示'}, function()
			{
				$("#hsa-record-input-add").hide();
				$("#hsa-record-list-box").show();
				var loadHtmlByUrlOption = {
					url : "/hsa/inspRecord/updateInspRecord",
					param : {
						id : id
					},
					callback : function(data)
					{
						var layer = layui.layer;	
						if (data == "success")
						{
							var index = layer.alert("确认成功！", {icon:0,title:'提示'}, function() {
								hsaInspRecordList.search(1)
								layer.close(index);
							});
						} else
						{
							layer.alert("确认失败！", {icon:0,title:'提示'});
						}
					}
				};
				$.loadHtmlByUrl(loadHtmlByUrlOption);
				layer.close(index);
			});
		});
	});

	function back()
	{
		$("#hsa-record-input-add").hide();
		$("#hsa-record-list-box").show();
		hsaInspRecordList.search(1);
	}

	return {};
})();
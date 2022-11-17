var hsaInspRecordAdd = (function()
{
	$(function()
	{
		healthEducationUpload.uploadOrganizationLinkFile("linkInspFile","/he/upload/uploadFile/inspectionRecord","/he/upload/deleteFile/inspectionRecord");
		healthEducationUpload.uploadOrganizationLinkFile("linkHsoFile","/he/upload/uploadFile/healthSupervisionOpinion","/he/upload/deleteFile/healthSupervisionOpinion");
		
		/* 返回 */
		$("#hsa-input-back-btn").click(function(e)
		{
			e.preventDefault();
			back();
		});
		
		HsaCommon.makeFormViewOnly($("#hsa-input-form"));

		// 确认记录界面
		$("#hsa-input-confirm-btn").click(function()
		{
			var id = $("#has-insprecord-id").val();
			/*layer.confirm("是否确认？", function(index)
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
						if (data == "success")
						{
							msgUtil.alert("确认成功！", hsaInspRecordList.search(1));
						} else
						{
							msgUtil.alert("确认失败！");
						}
					}
				};
				$.loadHtmlByUrl(loadHtmlByUrlOption);
				layer.close(index);
			});*/
			
			
			layui.use('layer', function(){
				var layer = layui.layer;
				layer.confirm('是否确认？', {icon:1, title:'确认提示'}, function(index){
					$("#hsa-record-input-add").hide();
					$("#hsa-record-list-box").show();
					var loadHtmlByUrlOption = {
						url : "/hsa/inspRecord/updateInspRecord",
						param : {
							id : id
						},
						callback : function(data)
						{
							if (data == "success")
							{
								layer.alert("确认成功！", {icon:0,title:'提示'}, function(){
									layer.closeAll();
									hsaInspRecordList.search(1)
								} 
								);
							} else
							{
								layer.alert("确认失败！", {icon:0,title:'提示'});
							}
						}
					};
					$.loadHtmlByUrl(loadHtmlByUrlOption);
				});
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
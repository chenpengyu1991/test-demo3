var organImport = (function() {
	debugger;
	$(function() {
		var organUploader = new qq.FineUploader({
			element: $('#importFile')[0],
			request: {
				endpoint: contextPath + "/mdmOrganization/upload"
			},
			validation: {
				allowedExtensions: ['csv']
			},
			multiple: false,
			text: {
				uploadButton: "导入文件",
				waitingForResponse: "导入中..."
			},
			callbacks: {
				onSubmit: function() {

				},
				onComplete: function(id, name, responseJSON) {
					$(".qq-upload-success:last").append("<span>" + responseJSON.msg + "</span>");
					if (responseJSON.success) {
					}
				}
			}
		});

		$("#organizationList").click(function() {
			baseLayoutLoad.pushMainContent("/mdmOrganization/search");
		});
		$("#publishVersion").click(function() {
			layui.use('layer', function(){
				var layer = layui.layer;
				layer.confirm("确定发布新版本吗？", {icon:1, title:'确认提示'}, function(index){
					var params = {
						url : "/mdmOrganization/publishVersion",
						callback : publishVersionCallback
					};
					$.getJsonByUrl(params);
					layer.close(index);
				});
			});		
		});
		$("#download").click(function() {
			location.href = contextPath + "/mdmOrganization/downLoadCurrent";
		});


	});

	function uploadCallback(data) {
		layer.alert(data.message, {icon:0,title:'提示'}, function(index){
			$("#waitMessage").hide();
			$("#upload").show();
			layer.close(index);
		});
	}

	function publishVersionCallback(data) {
		layer.alert(data.message, {icon:0,title:'提示'}, function(index){
			if (data.result) {
				$("#currentVersion").html(data.version);
			}
			layer.close(index);
		});
	}

	function downTemplate() {
		location.href = contextPath + "/mdmOrganization/downTemplate";
	}

	return {
		downTemplate : downTemplate
	};
})();
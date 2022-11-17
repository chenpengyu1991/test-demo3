var epMonitorEdit = (function() {
	var validate;
	$(function() {
		validate = $("#editForm").easyValidate();
		$("#save").click(function() {
			if (validate.validateForm()) {
				var option = {
					url: "/ep/iodate/saveMonitorRecord",
					wait: true,
					callback: submitCallback
				}
				$("#editForm").submitFormGetJson(option);
			}
		});
		$("#monitorTown1").change(function() {
			var option = {
				url : "/ep/iodate/getMonitorVillages",
				param : {
					gbCode : $("#monitorTown1").val()
				},
				callback : (function(list) {
					var html = '<option value="">请选择</option>';
					for (var i = 0; i < list.length; i++) {
						html += '<option value="'+list[i][1]+'">'+list[i][0]+'</option>';
					}
					$("#monitorVillage1").empty();
					$("#monitorVillage1").append(html);
				})
			}
			$.getJsonByUrl(option);
		});
		$("#monitorTown2").change(function() {
			var option = {
				url : "/ep/iodate/getMonitorVillages",
				param : {
					gbCode : $("#monitorTown2").val()
				},
				callback : (function(list) {
					var html = '<option value="">请选择</option>';
					for (var i = 0; i < list.length; i++) {
						html += '<option value="'+list[i][1]+'">'+list[i][0]+'</option>';
					}
					$("#monitorVillage2").empty();
					$("#monitorVillage2").append(html);
				})
			}
			$.getJsonByUrl(option);
		});
	});

	function del(obj, id) {
		var index = layer.confirm("是否删除该记录？", {icon:2, title:'确认提示'}, function() {
			var option = {
				url : "/ep/iodate/deleteMonitorRecord",
				param : {
					id : id
				},
				callback : submitCallback
			}
			$(obj).html(loadingSource);
			$.getJsonByUrl(option);
			layer.close(index);
		});
	}
function save(layerIndex) {
        if (validate.validateForm()) {
            var option = {
                url: "/ep/iodate/saveMonitorRecord",
                wait: true,
                callback: function(result) {
                    if (result.success) {
                       
						layui.use('layer', function(){
						    			var layer = layui.layer;
						    			var index = layer.alert("保存成功！", {icon:0,title:'提示'}, function() {
						    				 epMonitorSearch.search($("#indexPage").val());
						 					layer.closeAll(); 
						    			});
						    		});	
					
					
					
                        //如果设定了yes回调，需进行手工关闭
                    } else {
                        layui.notice.error(result.message);
                    }
                }
            }
            $("#editForm").submitFormGetJson(option);
        }
    }
	function detail(id) {
		var functionName = $("#functionName").val();
		var functionCode = $("#functionCode").val();
		var title, height, width, dialogId;
		title = "查看" + functionName;
		if (functionCode == "iodineContent") {
			height = '450px';
		} else {
			height = '580px';
		}
		width = '900px';
		/*var dialogParams = {
			url : "/ep/iodate/viewMonitorRecord",
			title : title,
			height : height,
			width : width,
			param : {
				functionCode : functionCode,
				id : id
			}
		};
		$.dialog(dialogParams);*/
		
		$.post(contextPath+'/ep/iodate/viewMonitorRecord', {
			functionCode : functionCode,
			id : id
		},
		function(ret) {
		  layer.open({
			  type: 1,
			  id:'viewMonitorRecord',
			  area: [width, height],
			  title:title,
			  content: ret
		  });
		});
		
	}

	function submitCallback(result) {
		layer.alert(result.message, {icon:0,title:'提示'}, function(index){
			if (result.success) {
				$.removeDialog($("#dialogId").val());
				epMonitorSearch.search($("#indexPage").val());
			}
			layer.closeAll();
		});
	}

	function revalidate() {
		validate = $("#editForm").easyValidate();
	}

	return {
		del : del,
		detail : detail,
		revalidate : revalidate,
		save:save
	}
})();
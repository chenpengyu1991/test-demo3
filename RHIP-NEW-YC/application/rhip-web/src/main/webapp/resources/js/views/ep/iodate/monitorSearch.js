var epMonitorSearch = (function() {
	$(function() {
		$("#addBtn").click(function(e) {
			e.preventDefault();
			if ($("#functionCode").val() == "monitorRecord") {
				edit("add");
			} else {
				edit("select");
			}
		});
		$("#searchBtn").click(function(e) {
			e.preventDefault();
			search(1);
		});
		$("#searchForm").onEnter(search, 1);
		$("#menubox li a").click(function(){
			var type = $(this).data("type");
			edit("add", "", type);
		});
		$("#searchTown").change(function() {
			var option = {
				url : "/ep/iodate/getMonitorVillages",
				param : {
					gbCode : $("#searchTown").val()
				},
				callback : (function(list) {
					var html = '<option value="">请选择</option>';
					for (var i = 0; i < list.length; i++) {
						html += '<option value="'+list[i][1]+'">'+list[i][0]+'</option>';
					}
					$("#searchVillage").empty();
					$("#searchVillage").append(html);
				})
			}
			$.getJsonByUrl(option);
		});
		search(1)
	});

	function search(indexPage) {
		var option = {
			url : "/ep/iodate/monitorList",
			insertDiv : "listDiv",
			param : {
				indexPage : indexPage,
			}
		};
		$("#searchForm").submitFormLoadHtml(option);
	}

	/*function edit(action, id, surveyType) {
		var functionName = $("#functionName").val();
		var functionCode = $("#functionCode").val();
		var title, height, width, dialogId;
		if (action == "select") {
			$("#menubox").show();
			$(document).on("click", closeMenu);
		} else {
			//新增修改页面
			if (action == "add") {
				title = "新建" + functionName;
			} else {
				title = "修改" + functionName;
			}
			if (functionCode == "iodineContent") {
				height = '450px';
			} else {
				height = '580px';
			}
			width = '980px';
			dialogId = functionCode + "Dialog";
			$.post(contextPath+"/ep/iodate/editMonitorRecord",
				{
					functionCode : functionCode,
					id : id,
					surveyType : surveyType
				},
				function(ret){
					layui.use(['layer'], function() {
						var layer = layui.layer
						layer.open({
							type: 1,
							id:dialogId,
							area: [width, height],
							title:title,
							content: ret
						});
					});
				});
		}
	}*/
function edit(action, id, surveyType) {
		var functionName = $("#functionName").val();
		var functionCode = $("#functionCode").val();
		var title, height, width, dialogId;
		if (action == "select") {
			$("#menubox").show();
			$(document).on("click", closeMenu);
		} else {
			//新增修改页面
			if (action == "add") {
				title = "新建" + functionName;
			} else {
				title = "修改" + functionName;
			}
			if (functionCode == "iodineContent") {
				height = '480px';
			} else {
				height = '600px';
			}
			width = '1000px';
			dialogId = functionCode + "Dialog";
            var url = '/ep/iodate/editMonitorRecord';
            $.loadHtmlByUrl({
                url: url,
                param : {
                    functionCode : functionCode,
                    id : id,
                    surveyType : surveyType
                },
                wait: true,
                callback: function (data) {
                    layer.open({
                        type: 1,
                        id:dialogId,
                        area: [width, height],
                        title:title,
                        content :data,
                        zIndex: layer.zIndex, //重点1
                        btn: ['保存', '关闭'],
                        yes: function(index, layero){
                            epMonitorEdit.save(index);
                        }
                        ,btn2: function(index, layero){
                            layer.close(index); //如果设定了yes回调，需进行手工关闭
                        }
                    });
                }
            });
		}
	}
	function closeMenu(e) {
		if (e.target.id != "addBtn") {
			$("#menubox").hide();
			$(document).off("click", closeMenu);
		}
	}

	return {
		search : search,
		edit : edit
	}
})();
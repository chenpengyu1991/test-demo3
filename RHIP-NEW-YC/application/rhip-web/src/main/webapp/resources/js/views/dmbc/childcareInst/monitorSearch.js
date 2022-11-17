var dmbcChildcareInstMonitorSearch = (function() {
	$(function() {
			$("#searchForm").onEnter(search, 1);
            $("#btnSearch").click(function() {
                search(1);
            });
            $("#btnAdd").click(function() {
            	add();
            });
            search(1);
	});

	function search(indexPage) { 
		var searchObj = {
			url : "/dmbc/childcareInst/monitorList",
			insertDiv : "resultDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#searchForm").submitFormLoadHtml(searchObj);
	};
	
	function add(){
		var dialogParams = {
			id :  "d1",
			url : "/dmbc/childcareInst/monitorEdit",
			title : "添加监测记录",
			height : 450,
			width : 500,
			param : {
			}
		};
		$.dialog(dialogParams);
	}
	
	function view(id){
		var dialogParams = {
				id :  "d1",
				url : "/dmbc/childcareInst/monitorView",
				title : "显示监测记录",
				height : 450,
				width : 500,
				param : {
					id : id
				}
			};
			$.dialog(dialogParams);
	}
	
	function edit(id){
		var dialogParams = {
				id :  "d1",
				url : "/dmbc/childcareInst/monitorEdit",
				title : "添加监测记录",
				height : 450,
				width : 500,
				param : {
					id : id
				}
			};
			$.dialog(dialogParams);
	}
	
	function remove(id){
		var index = layer.confirm("确认删除此监测记录？", {icon:2, title:'确认提示'}, function() {
			var option = {
					url : "/dmbc/childcareInst/monitorDelete",
					param : {
						id : id
					},
					callback : function(result) {
						layui.use('layer', function() {
							var layer = layui.layer;
							layer.alert(result.message, {icon:0,title:'提示'});
						});
						if (result.success) {
							search($("#_indexPage").val());
						}
					}
				};
				$.getJsonByUrl(option);

			layer.close(index);
		});
	}

	return {
        search : search,
        view : view,
        edit : edit,
        remove : remove
	};
})();

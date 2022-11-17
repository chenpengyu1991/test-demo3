var hmManageList = (function() {
	function viewReport(recordId, operate) {
		var dialogParams = {
			id : "physicalExamReportDialog",
			url : "/hm/manage/report",
			height : 650,
			width : 950,
			title : "体检报告",
			param : {
				recordId : recordId,
				operate : operate
			}
		};
		$.dialog(dialogParams);
	}

	function add(physicalExamRecordId, personId) {
		if (!personId){
			return;
		}
		$("#hm-manage-list-box").hide();
		$("#hm-manage-input-box").show();

		var loadHtmlByUrlOption = {
			url: "/hm/manage/addPhy",
			insertDiv: "hm-manage-input-box",
			param: {
				personId: personId,
				physicalExamRecordId: physicalExamRecordId
			}
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}

	function view(physicalExamRecordId, personId) {
		if (!personId){
			return;
		}
		$("#hm-manage-list-box").hide();
		$("#hm-manage-input-box").show();

		var loadHtmlByUrlOption = {
			url: "/hm/manage/view",
			insertDiv: "hm-manage-input-box",
			param: {
				personId: personId,
				physicalExamRecordId: physicalExamRecordId,
				status:"1"
			}
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}

	function deleteExam(physicalExamRecordId){
		if(physicalExamRecordId){
			var index = layer.confirm("确认删除？", {icon:2, title:'确认提示'}, function() {
				$.getJsonByUrl({
					url:"/hm/manage/delete",
					callback:function(data){
						if (data == "success") {
							hmManageSearch.search(1);
							layui.use('layer', function() {
								var layer = layui.layer;
								layer.alert("删除成功！", {icon:0,title:'提示'});
							});
						} else if (data == "fail") {
							layui.use('layer', function() {
								var layer = layui.layer;
								layer.alert("删除失败！", {icon:0,title:'提示'});
							});
						}
					},
					param: {
						physicalExamRecordId: physicalExamRecordId
					}
				});
				layer.close(index);
			});
		}
	}
	return {
		viewReport: viewReport,
		add: add,
		view: view,
		deleteExam: deleteExam
	}
})();
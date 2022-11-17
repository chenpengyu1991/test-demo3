var hmManageList = (function() {
	$(function() {
		// 查看体检信息
		$("#reportListDiv").on("click", ".phy-link", personPhyList);
	});
	
	function personPhyList(event){
		event.preventDefault();
		var personId=$(this).data("personid");
		if(!personId){
			return;
		}
		$("#hm-manage-list-box").hide();
		$("#hm-manage-input-box").show();
		var loadHtmlByUrlOption = {
			url : "/hm/manage/perPhyList",
			insertDiv : "hm-manage-input-box",
			param:{personId:personId}
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}
	
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

//	function add(physicalExamRecordId, personId) {
//		if (!personId){
//			return;
//		}
//		$("#hm-manage-list-box").hide();
//		$("#hm-manage-input-box").show();
//
//		var loadHtmlByUrlOption = {
//			url: "/hm/manage/addPhy",
//			insertDiv: "hm-manage-input-box",
//			param: {
//				personId: personId,
//				physicalExamRecordId: physicalExamRecordId
//			}
//		};
//		$.loadHtmlByUrl(loadHtmlByUrlOption);
//	}

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

	function deleteExam(personId,examNumber){
		if(personId){
			/*layer.confirm("确认删除？", function(index) {
				$.getJsonByUrl({
					url:"/hm/manage/delete",
					callback:function(data){
						if (data == "success") {
							hmManageSearch.search(1);
							msgUtil.alert("删除成功！");
						} else if (data == "fail") {
							msgUtil.alert("删除失败！");
						}
					},
					param: {
						personId: personId,
						examNumber:examNumber
					}
				});
				layer.close(index);
			});*/
			
			layui.use('layer', function() {
    			var layer = layui.layer;
    			var index = layer.confirm('确认删除？', {icon:2, title:'确认提示'}, function(){
    				layer.close(index);
    				$.getJsonByUrl({
    					url:"/hm/manage/delete",
    					callback:function(data){
    						if (data == "success") {
    							var index2 = layer.alert("删除失败！", {icon:0,title:'提示'}, function() {
    								layer.colse(index2);
    								hmManageSearch.search(1);
    							});
    							/*msgUtil.alert("删除成功！");*/
    						} else if (data == "fail") {
    							layer.alert("删除失败！", {icon:0,title:'提示'});
    						}
    					},
    					param: {
    						personId: personId,
    						examNumber:examNumber
    					}
    				});
				});
    			
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
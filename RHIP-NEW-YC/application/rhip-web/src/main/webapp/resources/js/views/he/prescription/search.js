var healthEducationPrescriptionSearch = (function() {
	$(function() {
		var wgzx = $("#wgzx").val();
		if(wgzx == '04'){
			$("select[name='gbcode']").append("<option title='健康教育所' value='_999'>健康教育所</option>");
		}

		/*健康教育处方查询*/
		$("#healthEducationPrescriptionSearchForm").onEnter(search, 1);
		$("#healthEducationPrescriptionBtnSearch").click(function () {
			search(1);
		});
		search(1);
		/*添加健康教育活动*/
		$("#prescriptionAdd").click(function () {
			add('3')
		});
	});

	function search(indexPage) { 
		var createBeginTime = new Date($("#createBeginTime").val());
		var createEndTime = new Date($("#createEndTime").val());

		if (createBeginTime > createEndTime) {
			layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
			return;
		} 
		var searchObj = {
			url : "/he/prescription/list",
			insertDiv : "healthEducationPrescriptionResultDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#healthEducationPrescriptionSearchForm").submitFormLoadHtml(searchObj);
	};

	function add(operatorType) {
		$("#mainSearchDiv").hide();
		var option = {
			url: "/he/prescription/add",
			insertDiv: "operationDiv",
			param: {
				operatorType: operatorType
			}
		};
		$.loadHtmlByUrl(option);
		$("#operationDiv").show();
	};

	function viewHealthEducationPrescription(id, operatorType) {

		$("#mainSearchDiv").hide();
		var option = {
			url: "/he/prescription/detail/" + id,
			insertDiv: "operationDiv",
			param: {
				operatorType: operatorType
			}
		};
		$.loadHtmlByUrl(option);
		$("#operationDiv").show();
	}

	function editHealthEducationPrescription(id, operatorType) {
		$("#mainSearchDiv").hide();
		var option = {
			url: "/he/prescription/edit/" + id,
			insertDiv: "operationDiv",
			param: {
				operatorType: operatorType
			}
		};
		$.loadHtmlByUrl(option);
		$("#operationDiv").show();
	}

	function deleteHealthEducationPrescription(id) {
		if (!id) {
			return;
		}

		var index = layer.confirm("确认删除?", {icon:2, title:'确认提示'}, function () {
			$.getJsonByUrl({
				url: "/he/prescription/delete/" + id,
				callback: function (data) {
					if (data.result) {
						healthEducationPrescriptionSearch.search(1);
					} else {
						layui.use('layer', function() {
							var layer = layui.layer;
							layer.alert("删除失败！", {icon:0,title:'提示'});
						});
					}
				}
			});
			layer.close(index);
		});
	}

	function publish(id) {
		var index = layer.confirm("确认发布该记录？", {icon:2, title:'确认提示'}, function () {
			$.getJsonByUrl({
				url: "/he/prescription/status",
				param: {
					id: id,
					operation: "publish"
				},
				callback: function (data) {
					var layer = layui.layer;
					if (data == "1") {
						var index = layer.alert("发布成功！", {icon:0,title:'提示'}, function() {
							search($("#currentPage").val())
							layer.close(index);
						});
						return;
					} else {
						var index = layer.alert("发布失败！", {icon:0,title:'提示'}, function () {
							search($("#currentPage").val())
							layer.close(index);
						});
					}
				}
			});
			layer.close(index);
		});
	};

	function unpublish(id) {
		var index = layer.confirm("确认撤销该记录？", {icon:2, title:'确认提示'}, function () {
			$.getJsonByUrl({
				url: "/he/prescription/status",
				param: {
					id: id,
					operation: "unpublish"
				},
				callback: function (data) {
					var layer = layui.layer;
					if (data == "1") {
						var index = layer.alert("撤销成功！", {icon:0,title:'提示'}, function () {
							search($("#currentPage").val())
							layer.close(index);
						});
						return;
					}
					var index = layer.alert("撤销失败！", {icon:0,title:'提示'}, function () {
						search($("#currentPage").val())
						layer.close(index);
					});
				}
			});
			layer.close(index);
		});
	};

	return {
		search: search,
		viewHealthEducationPrescription: viewHealthEducationPrescription,
		editHealthEducationPrescription: editHealthEducationPrescription,
		deleteHealthEducationPrescription: deleteHealthEducationPrescription,
		unpublish: unpublish,
		publish: publish
	};
})();
var hmStudentExamSchoolSearch = (function() {
	$(function() { 
        $("#searchForm").onEnter(search, 1);
        $("#btnSearch").click(function() {
            search(1);
        });
        search(1);

		$("#btnAdd").click(function() {
			var dialogParams = {
					id : "d1",
					url : "/hm/studentExam/schoolInfoEdit",
					height : 350,
					width : 550,
					title : "创建学校"
			};
			$.dialog(dialogParams);
		});
	});

	function search(indexPage) {
		var searchObj = {
			url : "/hm/studentExam/schoolList",
			insertDiv : "listDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#searchForm").submitFormLoadHtml(searchObj);
	};
	
	function viewSchool(schoolId) {
		var dialogParams = {
				id : "d1",
				url : "/hm/studentExam/viewSchool",
				param : {schoolId : schoolId},
				height : 350,
				width : 550,
				title : "查看学校"
		};
		$.dialog(dialogParams);
	}
	
	function editSchool(schoolId) {
		var dialogParams = {
				id : "d1",
				url : "/hm/studentExam/schoolInfoEdit",
				param : {schoolId : schoolId},
				height : 350,
				width : 550,
				title : "修改学校"
		};
		$.dialog(dialogParams);
	}
	
	function deleteSchool(schoolId) {
		var index = layer.confirm("确认删除该学校信息？", {icon:2, title:'确认提示'}, function() {
			var option = {
				url : "/hm/studentExam/deleteSchool",
				param : {
					schoolId : schoolId
				},
				callback : function(result) {
					layui.use('layer', function() {
						var layer = layui.layer;
						layer.alert(result.message, {icon:0,title:'提示'});
					});
					if (result.success) {
						search(1);
					}
				}
			};
			$.getJsonByUrl(option);
			layer.close(index);
		});
	}

	return {
		search : search,
		viewSchool : viewSchool,
		editSchool : editSchool,
		deleteSchool : deleteSchool
	};
})();
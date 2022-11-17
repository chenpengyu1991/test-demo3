var hmStudentExamList = (function() {
	$(function() { 
            util.checkBoxAll("checkAllStudents","studentExamId");
	});

	function editStudentExam(studentExamId) {
		baseLayoutLoad.pushMainContent("/hm/studentExam/updateExamReport", {studentExamId : studentExamId});
	}

	function deleteStudentExam(studentExamId) {
		var index = layer.confirm("确认删除该学生体检信息？", {icon:2, title:'确认提示'}, function() {
			var option = {
				url : "/hm/studentExam/deleteStudentExam",
				param : {
					studentExamId : studentExamId
				},
				callback : function(result) {
					var layer = layui.layer;
					if (result != 0) {
						var index = layer.alert("删除成功！", {icon:0,title:'提示'}, function() {
							hmStudentExamSearch.search(1)
							layer.close(index);
						});
					} else {
						layer.alert("删除失败！", {icon:0,title:'提示'});
					}
				}
			}
			$.getJsonByUrl(option);
			layer.close(index);
		});
	}
	
	function deleteStudentInfo(studentId) {
		var index = layer.confirm("确认删除该学生名单？", {icon:2, title:'确认提示'}, function() {
			var option = {
				url : "/hm/studentExam/deleteStudentInfo",
				param : {
					studentId : studentId
				},
				callback : function(result) {
					layui.use('layer', function() {
						var layer = layui.layer;
						layer.alert(result.message, {icon:0,title:'提示'});
					});
					if (result.success) {
						hmStudentSearch.search(1);
					}
				}
			};
			$.getJsonByUrl(option);
			layer.close(index);
		});
	}

	function viewStudentExam(studentExamId) {
		baseLayoutLoad.pushMainContent("/hm/studentExam/viewStudentExam", {ids : studentExamId});
	}

	function printStudentExam(studentExamId) {
		var url = contextPath + "/hm/studentExam/printStudentExam?ids=" + studentExamId;
		util.printPage(url);
		//hmStudentExamSearch.search($("#_indexPage").val());
	}

	return {
		editExam : editStudentExam,
		deleteExam : deleteStudentExam,
		viewExam : viewStudentExam,
		printExam : printStudentExam,
		deleteStudentInfo : deleteStudentInfo
	};
})();
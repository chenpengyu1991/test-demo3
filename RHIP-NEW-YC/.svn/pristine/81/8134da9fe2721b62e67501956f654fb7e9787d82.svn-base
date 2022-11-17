var hmStudentSearch = (function() {
	$(function() { 
        $("#searchForm").onEnter(search, 1);
        $("#btnSearch").click(function() {
            search(1);
        });
        search(1);

		$("#btnImport").click(function() {
			var dialogParams = {
					id : "d1",
					url : "/hm/studentExam/studentImport",
					height : 350,
					width : 550,
					title : "导入"
			};
			$.dialog(dialogParams);
		});
	});

	function search(indexPage) {
		if ($("#year").val() == "") {
			layer.alert("年份必须输入！", {icon:0,title:'提示'});
			return;
		}
		var searchObj = {
			url : "/hm/studentExam/studentList",
			insertDiv : "listDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#searchForm").submitFormLoadHtml(searchObj);
	};

	return {
		search : search
	};
})();
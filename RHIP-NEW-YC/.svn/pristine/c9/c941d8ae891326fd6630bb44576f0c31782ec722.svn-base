var hmStudentExamSearch = (function() {
	$(function() { 
        $("#searchForm").onEnter(search, 1);
        $("#btnSearch").click(function() {
            search(1);
        });
        search(1);

		$("#btnAdd").click(function() {
			baseLayoutLoad.pushMainContent("/hm/studentExam/addExamReport");
		});
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
		$("#btnPrint").click(function() {
			var ids = "";
			$("input[chkRef=studentExamId]").each(function() {
				if($(this).prop("checked") == true) {
					ids += $(this).val() + ",";
				}
			});
			/*$("input[type=checkbox][chkRef='studentExamId']:checked").each(function() {
				alert($(this).val());
				ids += $(this).val() + ",";
			});*/
			if (ids == "") {
				layer.alert("请选择要打印的学生！", {icon:0,title:'提示'});
				return;
			}
			hmStudentExamList.printExam(ids);
		});
		$("#btnExport").click(function() {
			if ($.isEmpty($("#selectSchool").val()) && $.isEmpty($("#type").val())) {
				layer.alert("请选择学校！", {icon:0,title:'提示'});
				return;
			}
			var option={
					url : "/hm/studentExam/excel",
					param : {}
			};
			$("#searchForm").exportListExcel(option);
		});
	});

	function search(indexPage) {
		if (($("#beginDate").val() == "" && $("#endDate").val() != "") || ($("#beginDate").val() != "" && $("#endDate").val() == "")) {
			layer.alert("体检日期范围不完整！", {icon:0,title:'提示'});
			return;
		}
		var searchObj = {
			url : "/hm/studentExam/list",
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
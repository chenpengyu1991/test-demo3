var hmFissureSealantSearch = (function() {
	$(function() { 
		var now = new Date();
		$("#beginDate").val(now.getFullYear() + "/01/01");
		$("#endDate").val(now.pattern("yyyy/MM/dd"));
        $("#reportForm").onEnter(_report, 1);
        $("#btnSearch").click(function() {
        	_report();
        });
        
		$("#back").click(function() {
			baseLayoutLoad.popMainContent();
		});
        
        $("#btnReportExport").click(function() {
	        var table = $("#reportDiv table");
	        if (table.length > 0) {
	        	$("#hm_fissureSealant_report").exportExcel();
	        } else {
	        	layer.alert("没有数据，请先查询。", {icon:0,title:'提示'});
	        }
        });
        
        $("input:checkbox[name='areaTypeInput']").change(function() {
        	querySchool();
        });
        
        $("#areaTypeInputAll").change(function() {
        	setTimeout(querySchool,100);
        });
        
        $("input:checkbox[name='typeInput']").change(function() {
        	querySchool();
        });
        
        $("#typeInputAll").change(function() {
        	setTimeout(querySchool,100);
        });
        
        util.checkBoxAll("areaTypeInputAll", "areaTypeInput");
        util.checkBoxAll("typeInputAll", "typeInput");
        util.checkBoxAll("schoolInputAll", "schoolCode");
        /*
        $("#btnViewImport").click(function() {
        	showImport();
        });
        */
        $("#btnExportSchool").click(function() {
        	var schoolListDiv = $("#schoolListDiv");
        	var isHidden = schoolListDiv.css('display') == 'none';
        	if (isHidden) {
        		schoolListDiv.show();
        		$(this).html("关闭");
        	} else {
        		schoolListDiv.hide();
        		$(this).html("展开");
        	}
        });
        
        $("input:checkbox[name='schoolCode']").change(function() {
        	showCheckSchool();
        });
        $("#schoolInputAll").change(function() {
        	setTimeout(showCheckSchool,100);
        });
	});
	
	function showCheckSchool() {
		var html = '<b>选择学校：</b>';
		$("input:checkbox[name='schoolCode']:checked").each(function() {
			html += '<span style="margin-left:5px">' + $(this).parent().text() + ';</span>';
		});
		$("#checkSchoolShowDiv").empty();
		$("#checkSchoolShowDiv").html(html);
	}
	
	function querySchool() {
		var areaTypeInputCode = "";
		$("input:checkbox[name='areaTypeInput']:checked").each(function() {
			areaTypeInputCode = areaTypeInputCode + $(this).val() + ",";
		});
		var typeInputCode = "";
		$("input:checkbox[name='typeInput']:checked").each(function() {
			typeInputCode = typeInputCode + $(this).val() + ",";
		});
		var option = {
				url : "/hm/fissureSealant/querySchoolList",
				callback : querySchoolCallback,
				param : {
					areaType : areaTypeInputCode,
					type : typeInputCode
				}
		};
		$.getJsonByUrl(option);
	}
	
	function querySchoolCallback(data) {
		if (data.success) {
			var schoolInputDiv = $("#schoolInputDiv");
			var schoolList = data.schools;
			var school;
			var table = $("<table />");
			table.append('<colgroup><col style="width:16%;" /><col style="width:16%;" /><col style="width:16%;" /><col style="width:16%;" /><col style="width:16%;" /><col style="width:16%;" /></colgroup>');
			var tr;
			for (var index = 0; index < schoolList.length; index++) {
				school = schoolList[index];
				if (index%6 == 0) {
					tr = $("<tr />");
					table.append(tr);
				}
				tr.append('<td><input type="checkbox" chkRef="schoolCode" name="schoolCode" value="'+school.schoolCode+'" />  '+school.name+'</td>');
			}
			schoolInputDiv.empty();
			schoolInputDiv.append(table);
			$("#schoolInputAll").attr("checked", false);
			$("#checkSchoolShowDiv").html('<b>选择学校：</b>');
			$("input:checkbox[name='schoolCode']").change(function() {
	        	showCheckSchool();
	        });
		}
	}
	/*
	function showImport() {
		var dialogParams = {
				id : "d1",
				url : "/hm/fissureSealant/showImport",
				param : {},
				height : 200,
				width : 750,
				title : "数据导入"
		};
		$.dialog(dialogParams);
	}
*/
	function _report() {
		/*
		var beginDate = $("#beginDate").val();
		var endDate = $("#endDate").val();
		if ((!$.isEmpty(beginDate) && $.isEmpty(endDate))
				|| ($.isEmpty(beginDate) && !$.isEmpty(endDate))) {
			msgUtil.alert("封闭日期范围输入不完整");
			return;
		}
		if (!$.isEmpty(beginDate) && !$.isEmpty(endDate)) {
			if (beginDate > endDate) {
				msgUtil.alert("调查日期范围开始日期不能大于截止日期！");
				return;
			}
		}
		*/
		var selectSchoolCode = $("input:checkbox[name='schoolCode']:checked");
		if (selectSchoolCode.length == 0) {
			layer.alert("请至少选择一个学校！", {icon:0,title:'提示'});
			return;
		}
		var searchObj = {
			url : "/hm/fissureSealant/report",
			insertDiv : "reportDiv",
			param : {}
		};
		$("#reportForm").submitFormLoadHtml(searchObj);
	};

	return {
		_report : _report
	};
})();
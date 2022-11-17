var hmStudentExamReportSearch = (function() {
	var validate = null;
	$(function() { 
		validate = $("#reportSearchForm").easyValidate();
		//$("#reportExamYear").val(new Date().getFullYear());
        $("#reportSearchForm").onEnter(_report, 1);
        $("#btnReportSearch").click(function() {
        	_report();
        });
        
        $("#btnReportExport").click(function() {
	        var table = $("#reportListDiv table");
	        if (table.length > 0) {
		        $("#hm_studentExam_report").exportExcel();
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
        	queryGrade();
        });
        
        $("#typeInputAll").change(function() {
        	setTimeout(querySchool,100);
        	setTimeout(queryGrade,100);
        });
        
        util.checkBoxAll("areaTypeInputAll", "areaTypeInput");
        util.checkBoxAll("typeInputAll", "typeInput");
        util.checkBoxAll("schoolInputAll", "schoolCode");
        util.checkBoxAll("gradeInputAll", "gradeCode");
        
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
        
        $("#btnExportGrade").click(function() {
        	var gradeListDiv = $("#gradeListDiv");
        	var isHidden = gradeListDiv.css('display') == 'none';
        	if (isHidden) {
        		gradeListDiv.show();
        		$(this).html("关闭");
        	} else {
        		gradeListDiv.hide();
        		$(this).html("展开");
        	}
        });
        $("input:checkbox[name='gradeCode']").change(function() {
        	showCheckGrade();
        });
        $("#gradeInputAll").change(function() {
        	setTimeout(showCheckGrade,100);
        });
	});
	
	function showCheckGrade() {
		var html = '<b>选择班级：</b>';
		$("input:checkbox[name='gradeCode']:checked").each(function() {
			html += '<span style="margin-left:5px">' + $(this).parent().text() + ';</span>';
		});
		$("#checkGradeShowDiv").html(html);
	}
	
	function showCheckSchool() {
		var html = '<b>选择学校：</b>';
		$("input:checkbox[name='schoolCode']:checked").each(function() {
			html += '<span style="margin-left:5px">' + $(this).parent().text() + ';</span>';
		});
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
		//alert("areaTypeInputCode=[" + areaTypeInputCode + "],typeInputCode=[" + typeInputCode +"]");
		var option = {
				url : "/hm/studentExam/querySchoolList",
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
			//schoolInputDiv.empty();
			schoolInputDiv.html(table);
			$("#schoolInputAll").attr("checked", false);
			$("#checkSchoolShowDiv").html('<b>选择学校：</b>');
			$("input:checkbox[name='schoolCode']").change(function() {
	        	showCheckSchool();
	        });
		}
	}

	/**
	 * 根据学校类型查询年级
	 */
	function queryGrade() {
		var grade1 = 'A04,A05,A06,A07,A08,A09';//小学年级
		var grade2 = 'A10,A11,A12,A24';//初中
		var grade3 = 'A13,A14,A15';//高中 
		var grade4 = 'B13,B14,B15,B16,B17,B18,B19';//职高 
		var areaTypeInputCode = "";
		$("input:checkbox[name='areaTypeInput']:checked").each(function() {
			areaTypeInputCode = areaTypeInputCode + $(this).val() + ",";
		});
		var gradeCodes = "";
		$("input:checkbox[name='typeInput']:checked").each(function() {
			if($(this).val()=='01'){//小学
				gradeCodes += $.isEmpty(gradeCodes)?"":",";
				gradeCodes += grade1;
			}else if($(this).val()=='02'){//初中
				gradeCodes += $.isEmpty(gradeCodes)?"":",";
				gradeCodes += grade2;
			}else if($(this).val()=='03'){//高中
				gradeCodes += $.isEmpty(gradeCodes)?"":",";
				gradeCodes += grade3;
			}else if($(this).val()=='04'){//职高 
				gradeCodes += $.isEmpty(gradeCodes)?"":",";
				gradeCodes += grade4;
			}else if($(this).val()=='05'){//完中 
				gradeCodes += $.isEmpty(gradeCodes)?"":",";
				gradeCodes += grade2;
				gradeCodes += $.isEmpty(gradeCodes)?"":",";
				gradeCodes += grade3;				
			}else if($(this).val()=='06'){// 九年一贯制 
				gradeCodes += $.isEmpty(gradeCodes)?"":",";
				gradeCodes += grade1;
				gradeCodes += $.isEmpty(gradeCodes)?"":",";
				gradeCodes += grade2;
			}			
		});
		var option = {
				url : "/hm/studentExam/queryGradeList",
				callback : queryGradeCallback,
				param : {
					itemCodes : gradeCodes
				}
		};
		$.getJsonByUrl(option);
	}
	
	/**
	 * 根据学校类型查询年级后，页面展示
	*/
	function queryGradeCallback(data) {
		if (data.success) {
			var gradeInputDiv = $("#gradeInputDiv");
			var gradeList = data.gradeCodes;
			var grade;
			var table = $("<table />");
			table.append('<colgroup><col style="width:16%;" /><col style="width:16%;" /><col style="width:16%;" /><col style="width:16%;" /><col style="width:16%;" /><col style="width:16%;" /></colgroup>');
			var tr;
			for (var index = 0; index < gradeList.length; index++) {
				grade = gradeList[index];
				if (index%6 == 0) {
					tr = $("<tr />");
					table.append(tr);
				}
				tr.append('<td><input type="checkbox" chkRef="gradeCode" name="gradeCode" value="'+grade.itemCode+'" />  '+grade.itemName+'</td>');
			}
			//schoolInputDiv.empty();
			gradeInputDiv.html(table);
			$("#gradeInputAll").attr("checked", false);
			$("#checkGradeShowDiv").html('<b>选择年级：</b>');
		}
	}
	
	function _report() {
//      需求变更修改，可以不选择学校统计，2014-03-05
//		var selectSchoolCode = $("input:checkbox[name='schoolCode']:checked");
//		if (selectSchoolCode.length == 0) {
//			msgUtil.alert("请至少选择一个学校");
//			return;
//		}
    	var result=validate.validateForm();
    	if(!result){
    		return;
    	}		
		var searchObj = {
			url : "/hm/studentExam/report",
			insertDiv : "reportListDiv"
		};
		$("#reportSearchForm").submitFormLoadHtml(searchObj);
	};

	return {
		
	};
})();
var examSpecialJS = (function(){
	$(function() {
		SearcjExamSpecial(1);
			
		$("#search_btn").on("click", function(){
			SearcjExamSpecial(1);
		});
		
		$("#examSpecialSearchForm").onEnter(function(){
			SearcjExamSpecial(1);
		});
		
		$("#analyze_btn").on("click", function(){
			var analyzeOption = {
				id : "analyzeSearchDialog",
				url : contextPath + "/physicalExam/analyzeDialog",
				height : 400,
				width : 650,
				title : "指标分析",
				param:{
	                beginDate:$('#beginDateId').val(),
					endDate:$('#endDateId').val(),
					phyExamOrg:$("input[name='phyExamOrg']").val(),
					phyType:$('#phyType').val(),
					name:$('#name').val(),
					idcard  :$('#idcard').val()
				}
			};
			$.dialog(analyzeOption);
		});
		
		$("#examSearchListDiv").on("click", ".examLinkClass", function(event){
			event.preventDefault();
			$.dialog({
				url : $(this).attr("href"),
				title : "体检专项报告",
				height : 600,
				weight : 650
			});
		});
		
		var option = {
				url: "/mdmOrganization/organationTree",
				unSelecteType: []
			};
			var opb = {
				url: "/mdmOrganization/organationSelect",
				feild: {
					value: "organCode",
					lable: "organName"
				}
			};

		
		var hbpDiagnosedOrganCode = $("#phyExamOrg");
		if (hbpDiagnosedOrganCode.length > 0){
			hbpDiagnosedOrganCode.selectBox(opb);
			hbpDiagnosedOrganCode.initTreeSelect(option);
		}

		var diDiagnosedOrganCode = $("#phyExamOrg");
		if (diDiagnosedOrganCode.length > 0){
			diDiagnosedOrganCode.selectBox(opb);
			diDiagnosedOrganCode.initTreeSelect(option);
		}
		
		$("#examSearchListDiv").on("click", ".cd-view-link",viewCd );
        $("#examSearchListDiv").on("click", ".hm-view-link",viewHm );


    });
	
	function SearcjExamSpecial(indexPage) {
		var beginDate = new Date($("#beginDateId").val());
		var endDate = new Date($("#endDateId").val());
		if(beginDate > endDate){
			layer.alert("结束时间不能小于起始时间！", {icon:0,title:'提示'});
			return;
		}
	//	$("#phyExamOrg").attr("phyExamOrg_name","phyExamOrg");
		$("#examSpecialSearchForm").submitFormLoadHtml({
			url : contextPath + "/physicalExam/list",
			param : {
				pageIndex : indexPage
			},
			insertDiv : "examSearchListDiv"
		});
	}
	
	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	};
	
	function viewStudentExam(personId, ehrId) {
		$.dialog({
			url : contextPath + "/hm/studentExam/viewStudentExam/"+ personId + "/" + ehrId,
			title : "学生体检",
			height : 600,
			weight : 650
		});
	}
	
	function viewCd()
	{
		var personId = $(this).data("personid");
		var ehrId = $(this).data("ehrid");
		$.dialog({
			url : contextPath + "/cdm/standardization/phyExamination/externalView",
			title : "慢病体检",
			height : 600,
			width : 950,
			param :{
				personId: personId, 
				ehrId: ehrId
			}
		});
		
	}

    /**
     * 老年人体检
     */
    function viewHm(){
        var physicalExamCode = $(this).data("physicalexamcode");
        var personId = $(this).data("personId");
        $.dialog({
            url : contextPath + "/hm/manage/report",
            title : "老年人体检",
            height : 600,
            width : 950,
            param :{
                examNumber: physicalExamCode,
                personId:personId,
                operate: "view"
            }
        });
    }

    function examAnalyze(indexPage) {
        $("#examSpecialSearchForm").submitFormLoadHtml({
            url :  contextPath + "/physicalExam/analyze/list",
            insertDiv : "examSearchListDiv",
            param:{
                indexPage : indexPage,
                weight:$('#weight').val(),
				hepatitisB:$('#hepatitisB').val(),
				bloodfat  :$('#bloodfat').val()
            },
            callback : function(){
                $.removeDialog("analyzeSearchDialog");
            }
        });
    }

	return {
		searcjExamSpecial : SearcjExamSpecial,
		viewExam : viewStudentExam,
		toggle : toggle,
        examAnalyze : examAnalyze
	};
})();
var ehrbrowserServiceIndex = (function () {
    var medicalindex_url = contextPath + "/ehrbrowser/service/result";
    var indexDataRangeForm = "data-range-form";
    $(function () {
        // 时间段切换
        $(".daterange-radio").bind("click", function (event) {
            search(1, medicalindex_url, indexDataRangeForm, "medical_index_content");
        });

        $("#ehrservice-list-organ-code-select").multiselect({
            header: false,
            noneSelectedText: '请选择机构',
            selectedList: 3
        });

        // 更多
        $("#medical_index_content").on("click", ".index_medical_more_btn", function (event) {
            event.preventDefault();
            var personId = $("#ehrbrowser_person_id_input").val();
            // alert(personId);
           /* var dialogObj = {
                url: $(this).attr("href"),
                title: $(this).attr("title"),
                param: {
                    personId: personId
                }
            };
            $.dialog(dialogObj);*/
            var title = $(this).attr("title");
            $.post($(this).attr("href"), {personId: personId}, function(ret){
        		layui.use(['layer'], function() {
        			var layer = layui.layer
        			layer.open({
        				type: 1,
        				id:'moreHealthEvent',
        				area: ['850px', '450px'],
        				title: title,
        				content: ret
        			});
        		});
        	});
        });

        // 检验报告单
        $("#medical_index_content").on("click", ".exam_report_btn", function (event) {
            event.preventDefault();
            openExamReport($(this), null);
        });
        // 检查报告单
        $("#medical_index_content").on("click", ".study_report_btn", function (event) {
            event.preventDefault();
            openStudyReport($(this), null);
        });
        // 临床图表
        $("#medical_index_content").on("click", ".inhos_chart_btn", function (event) {
            event.preventDefault();
            openDrugInpatientChart($(this), null);
        });
        // 处方
        $("#medical_index_content").on("click", ".drug_report_btn", function (event) {
            event.preventDefault();
            openDrugReport($(this), null);
        });

        // 慢病体检
        $("#medical_index_content").on("click", ".cd_exam_btn", function (event) {
            event.preventDefault();
            openCdExam($(this), null);
        });

        // 学生体检
        $("#medical_index_content").on("click", ".student_exam_btn", function (event) {
            event.preventDefault();
            openStudentExam($(this), null);
        });
        // 其它类型体检
        $("#medical_index_content").on("click", ".other_exam_btn", function (event) {
            event.preventDefault();
            openOtherExam($(this), null);
        });


        // 默认显示
        $(".daterange-radio:first").click();

        initOrgSelect();

    });


    function initOrgSelect() {
        var personId = $("#ehrbrowser_person_id_input").val();
        $.loadHtmlByUrl({
            url: "/ehrbrowser/service/relationOrganCodes",
            param: {
                personId: personId
            },
            insertDiv: "ehrservice-list-organ-code-select-content",
            callback: function () {
                var $select = $("#ehrservice-list-organ-code-select");
                $select.multiselect({
                    header: false,
                    noneSelectedText: '请选择机构',
                    selectedList: 3
                });

                $select.change(function () {
                    search(1, medicalindex_url, indexDataRangeForm, "medical_index_content");
                });

            }
        });
    }


    function search(indexPage, url, form, target) {
        $("#" + form).submitFormLoadHtml({
            url: url,
            insertDiv: target,
            param: {
                indexPage: indexPage,
                personId: $("#ehrbrowser_person_id_input").val()
            }
        });
    }

    // 检验报告单
    function openExamReport($this, param) {
        openReport($this, param, 900, 600, 'examDialog');
    }

    // 检查报告单
    function openStudyReport($this, param) {
        openReport($this, param, 900, 600, 'studyDialog');
    }

    // 处方
    function openDrugReport($this, param) {
        openReport($this, param, 1000, 600, 'outpatientPrescriptionDialog');
    }

    // 体检
    function openCdExam($this, param) {
        openReport($this, param, 1000, 500, 'physicalExamDialog');
    }

    // 学生体检
    function openStudentExam($this, param) {
        openReport($this, param, 800, 650, 'studentExamDialog');
    }

    // 其它类型体检
    function openOtherExam($this, param) {
        openReport($this, param, 800, 650, 'otherPhsicalExamDialog');
    }

    // 临床图表
    function openDrugInpatientChart($this, param) {
        openReport($this, param, 900, 630, 'inpatientChartDialog');
    }

    function openReport($this, param, width, height, id) {
        /*var dialogObj = {
            url: $this.attr("href"),
            title: $this.attr("title") || $this.text(),
        };
        if (param) {
            dialogObj.param = param;
        }
        if (width) {
            dialogObj.width = width;
        }
        if (height) {
            dialogObj.height = height;
        }
        $.dialog(dialogObj);*/
        var title = $this.attr("title") || $this.text();
        $.post($this.attr("href"), param, function(ret){
    		layui.use(['layer'], function() {
    			var layer = layui.layer
    			layer.open({
    				type: 1,
    				id:id,
    				area: [width+'px', height+'px'],
    				title: title,
    				content: ret
    			});
    		});
    	});
        return false;
    }

    function initCollspse(parentId) {
        $("#" + parentId + " .f-collspse-btn").on("click", function () {
            var $this = $(this);
            var btnId = $this.attr("id");
            if (btnId) {
                var $targetId = $("#" + parentId + " #" + btnId.replace("-btn-", "-target-"));
                if ($targetId.hasClass("f-collapse-in")) {
                    $("#" + parentId + " .f-collapse-in").removeClass("f-collapse-in");
                } else {
                    $("#" + parentId + " .f-collapse-in").removeClass("f-collapse-in");
                    $targetId.addClass("f-collapse-in");
                }
                ;
            }
        });
    }
 
    function sameDiease(personId, diseaseCode,  diseaseName, indexPage){
    	$.loadHtmlByUrl({
    		url : "/ehrbrowser/service/sameDisease",
    		insertDiv :"content",
    		param:{
    			personId: personId,
    			diseaseCode: diseaseCode,
    			diseaseName: diseaseName,
    			indexPage : indexPage
    		}
    	});
    }

    //disease(疾病),surgery(手术),drugAllergy(过敏),vaccinationInfo(接种),hospitalized(住院),transBlood(输血)
    /**
     * 加载既往史（每次只加载一个）
     */
    function loadHealthHistory(type,containerId){
        if($('#' + containerId).find('table').length === 0) {
            var options = {
                url: contextPath + "/ehrbrowser/basic/healthHistoryContent",
                param: {
                    personId: $("#ehrbrowser_person_id_input").val(),
                    historyType: type
                },
                insertDiv: containerId
            };
            $.loadHtmlByUrl(options);
        }
    }

    return {
        openReportByA: openReport,
        openExamReport: openExamReport,
        openStudyReport: openStudyReport,
        openDrugReport: openDrugReport,
        openDrugInpatientChart: openDrugInpatientChart,
        initCollspse: initCollspse,
        openCdExam: openCdExam,
        openStudentExam: openStudentExam,
        openOtherExam: openOtherExam,
        sameDiease: sameDiease,
        loadHealthHistory:loadHealthHistory
    };

})();

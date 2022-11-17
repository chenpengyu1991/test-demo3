var emrIndex = (function() {
	$(function() {/*
		处方查询
		$("#tag1").on("click", function(event)
		{	
			selectTagl("tagContent1", this);
			loadPrescriptions();
		});
		检查查询
		$("#tag2").on("click", function(event)
		{
			selectTagl("tagContent1", this);
			loadInspect();
		});
		检验查询
		$("#tag3").on("click", function(event)
		{
			selectTagl("tagContent1", this);
			loadExam();
		});
		入院记录查询
		$("#tag4").on("click", function(event)
		{
			selectTagl("tagContent1", this);
			loadBeHospital();
		});
		出院小结查询
		$("#tag5").on("click", function(event)
		{	
			selectTagl("tagContent1", this);
			loadLeaveHospital();
		});
		病案首页查询
		$("#tag6").on("click", function(event)
		{
			selectTagl("tagContent1", this);
			loadCase();
		});
		loadPrescriptions();
	*/});

	function loadPrescriptions() {
		var loadHtmlByUrlOption = {
			url : "/ihm/emr/prescription",
			param : {},
			checkRepeat : true,
			insertDiv : "tagContent1",
			errorDiv: "",
			okDiv:""
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	};

    function loadBeHospital() {
        var loadHtmlByUrlOption = {
            url : "/ihm/emr/beHospital",
            param : {},
            insertDiv : "tagContent1",
            errorDiv: "",
            okDiv:""
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    };
    
    function loadLeaveHospital() {
        var loadHtmlByUrlOption = {
            url : "/ihm/emr/leaveHospital",
            param : {},
            insertDiv : "tagContent1",
            errorDiv: "",
            okDiv:""
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    };
    
    function loadCase() {
        var loadHtmlByUrlOption = {
            url : "/ihm/emr/case",
            param : {},
            insertDiv : "tagContent1",
            errorDiv: "",
            okDiv:""
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    };
    
    function loadInspect() {
		var loadHtmlByUrlOption = {
			url : "/ihm/emr/inspect",
			param : {},
			checkRepeat : true,
			insertDiv : "tagContent1",
			errorDiv: "",
			okDiv:""
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	};
	
	function loadExam() {
		var loadHtmlByUrlOption = {
			url : "/ihm/emr/exam",
			param : {},
			checkRepeat : true,
			insertDiv : "tagContent1",
			errorDiv: "",
			okDiv:""
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	};
	return {
		loadPrescriptions : loadPrescriptions,
		loadLeaveHospital : loadLeaveHospital,
		loadBeHospital : loadBeHospital,
		loadCase : loadCase,
		loadInspect : loadInspect,
		loadExam :loadExam
	};
})();


var ehrbrowserServiceIndex = (function () {
    // 检验报告单
    function openExamReport($this, param) {
        openReport($this, param, 900, 500);
    }

    function openReport($this, param, width, height) {
        var dialogObj = {
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
        $.dialog(dialogObj);
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

    return {
        openReportByA: openReport,
        openExamReport: openExamReport,
        initCollspse: initCollspse,
    };

})();
var followupSearch = (function() {
	$(function() {
		$(".jsws-followup-link").removeAttr("style");
        searchFollowup(1);
        $("#followupSearch").onEnter(searchFollowup, 1);
        mhmCommon.addIcd10AutoComplete("mhmIcd10Code");
        $("#searchFollowupButton").click(function(e) {
        	e.preventDefault();
			$(".jsws-followup-link").removeAttr("style");
			searchFollowup(1);
        });
		$("#jsws-followup-links").on("click", ".jsws-followup-link", changeToFullowup);
    });

	function changeToFullowup() {
		debugger;
		$(".jsws-followup-link").removeAttr("style");
		var $this = $(this);
		$this.attr("style", "color:black");
		var flag = $this.data("followupflag");
		$("#followupStatus").val(flag);
		searchFollowupByFlag(1, {
			followupFlag : flag,
			searchSource:'1'
		});
	}

	function searchFollowupByFlag(pageIndex, param) {
		var p = {
			pageIndex : pageIndex
		};
		if (param)
		{
			p = $.extend(p, param);
		}
		var searchObj = {
			url : "/mhm/mentalFollowUp/list",
			insertDiv : "followupResultDiv",
			param : p
		};
		$("#form_search").submitFormLoadHtml(searchObj);
	}

	function searchFollowup(pageIndex) {
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
		var searchObj = {
			url : "/mhm/mentalFollowUp/list",
			insertDiv : 'followupResultDiv',
			param : {
                pageIndex : pageIndex
			},
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
		};
		$("#followupSearchForm").submitFormLoadHtml(searchObj);
	};

	function search(){
		disableChangeConfirm();
		$("#followupDetailDiv").empty();
		// $("#searchSource").val(type);
		// searchFollowup();
		$("#followup_top_all").show();
	}

    function loadFollowupDetail(statusId){

		var loadHtmlByUrlOption = {
			url : "/mhm/followUp/main",
			param : {statusId:statusId,searchType:"1"},
			checkRepeat : true,
			insertDiv : "followupDetailDiv",
			errorDiv: "",
			okDiv:""
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
    }

	function loadPhysicExam(statusId){
		var loadHtmlByUrlOption = {
			url : "/mhm/healthCheck/main",
			param : {statusId:statusId,searchType:"1"},
			checkRepeat : true,
			insertDiv : "followupDetailDiv",
			errorDiv: "",
			okDiv:""
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}

    function editFollowup(statusId){
        $("#followupResultDiv").show();
		loadFollowupDetail(statusId);
        $("#followup_top_all").hide();
    }

	function editPhysicExam(statusId){
		$("#followupResultDiv").show();
		loadPhysicExam(statusId);
		$("#followup_top_all").hide();
	}
	return {
		search:search,
		searchFollowup:searchFollowup,
		editFollowup:editFollowup,
		editPhysicExam:editPhysicExam
	};
})();
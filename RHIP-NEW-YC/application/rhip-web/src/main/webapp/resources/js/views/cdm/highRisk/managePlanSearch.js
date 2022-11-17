var managePlanSearch = (function() {
		$(function() {
			//分页绑定函数
			//pageUtil.bind("managePlanResult",addManagePlanResult);
			addManagePlanResult(1);
			
		});

	
	function addManagePlanResult(indexPage) {
		var searchObj = {
			url : "/cdm/highrisk/managePlanResult",
			insertDiv : "managePlanResult",
			param : {
				indexPage : indexPage
			},
		    callback: function() {
			  initLinkClick('managePlanSelect',selectManagePlan, ["data-id"]);
		}
		};
		$("#managePlanForm").submitFormLoadHtml(searchObj);
	}
	function selectManagePlan(id, year) {
		var loadHtmlByUrlOption = {
			url : "/cdm/highrisk/managePlanResult",
			param : {
				indexPage : 1,
				id : id,
				year : year
			},
			insertDiv : "managePlanResult"
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}

    function getPreFollowUpDetail(id){
        var loadByUrl = {
            url : "/cdm/highrisk/manageResult",
            insertDiv : "managePlanResult",
            param : {
                id : id
            }
        };
        $.loadHtmlByUrl(loadByUrl);
    }
	return {
		load : load ,
		addManagePlanResult : addManagePlanResult,
        getPreFollowUpDetail:getPreFollowUpDetail
	};
})();
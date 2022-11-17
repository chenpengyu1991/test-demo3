var vaccineTargetSearch = (function() {
	var validate=null;
	$(function() {
		// 高级查询条件显示控制
		$("#perAdvanceSearchVaccineBtn").click(function(e) {
			e.preventDefault();
			controlAdvanceSearchSection($(this));
		});

    	validate = $("#vaccineSearchForm").easyValidate();
    	$("#vaccineSearchForm").onEnter(vaccineSearch, 1);
        $("#vaccineBtnSearch").click(function(e) {
			e.preventDefault();
			vaccineSearch(1);
        });
    });
	
    function vaccineSearch(pageIndex) {
    	var result=validate.validateForm();
    	if(!result){
    		return;
    	}    	
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var searchObj = {
            url : $("#queryPath").val(),
            insertDiv : "vaccineDiv",
            param : {
                indexPage : pageIndex
            },
            callback : function(data) {
            	$("#vaccinePageIndex").val(pageIndex);
            }
        };
        $("#vaccineSearchForm").submitFormLoadHtml(searchObj);
    };
    
    function loadDetailDialog(url, vaccinationCode, title, height, width){
		// var detail = {
		// 		url : url,
		// 		id : "detailDialog",
		// 		height : height,
		// 		weight : 30,
		// 		width : width,
		// 		title : title,
		// 		param : {
        //                  vaccinationCode: vaccinationCode,
        //                  id:vaccinationCode
        //                 }
		// };
		// $.dialog(detail);
		$.post(contextPath+url, {"id":vaccinationCode,"vaccinationCode":vaccinationCode}, function(ret){
			layer.open({
				type: 1,
				id:'detailDialog',
				area: [width, height],
				weight : 30,
				title: title,
				content: ret
			});
		});
	};

	function controlAdvanceSearchSection(btn) {
		$(".advanceSearchSection").toggle();
		if (btn.text().indexOf('高级') !== -1) {
			btn.html('<i class="iconfont">&#x60011;</i>简单');
		} else {
			btn.html('<i class="iconfont">&#x60010;</i>高级');
		}
	}

	return {
		vaccineSearch:vaccineSearch,
		loadDetailDialog:loadDetailDialog
	};
})();




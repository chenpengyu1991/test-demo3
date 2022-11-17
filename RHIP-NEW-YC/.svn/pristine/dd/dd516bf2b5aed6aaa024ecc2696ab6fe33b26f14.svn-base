var reportSelfCheckIndex = (function() {
	$(function() {

        /*填写， 法定传染病*/
        $("#selfFill1Id").click(function(e) {
        	statisticsCommon.changeActive('selfCheckId','selfFill1Id');
        	addFillDc("add");
        });
        /*填写， 新生儿接种*/
        $("#selfFill2Id").click(function(e) {
        	statisticsCommon.changeActive('selfCheckId','selfFill2Id');
        	addFillNeonate("add");
        });       
        /*查看*/
        $("#selfListId").click(function() {
        	statisticsCommon.changeActive('selfCheckId','selfListId');
        	loadFillSearch();        	
        });
        /*汇总*/
        $("#selfSummaryId").click(function() {
        	statisticsCommon.changeActive('selfCheckId','selfSummaryId');
        	loadSummarySearch();
        });
        initFormByRole();

	});
	
    /*
     * 1、如果防疫科登录，默认画面是查看
     * 2、其他角色登录默认是填写画面
     * */	
	function initFormByRole(){
		var roleType = $('#tagContent2').find('#RoleTypeId').val();
		if(roleType == 'FYK'){
			$('#spanSelfListId').attr("class", "active"); 
			loadFillSearch();
		}else{
	        addFillDc("add");
		}
	}	
	/*加载查看*/
	function loadFillSearch() {
		$("#selfcheck_top_all").show();
		$("#selfcheck_detailDiv").hide();
		var loadHtmlByUrlOption = {
			url : "/idm/statistics/report/selfcheck/fillSearch",
			param : {},
			checkRepeat : true,
			insertDiv : "selfcheckSearchDiv",
			errorDiv: "",
			okDiv:""
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	};	
	/*加载汇总查询*/
	function loadSummarySearch() {
		$("#selfcheck_top_all").show();
		$("#selfcheck_detailDiv").hide();
		var loadHtmlByUrlOption = {
			url : "/idm/statistics/report/selfcheck/summarySearch",
			param : {},
			checkRepeat : true,
			insertDiv : "selfcheckSearchDiv",
			errorDiv: "",
			okDiv:""
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	};
	
    /*
     * 新增  法定传染病报告  画面
     * type,'add':新增，'view':查看
     * addType,'1':法定传染病，'2':新生儿产房接种
     * */
    function addFillDc(type,id,addType){
		$("#selfcheck_top_all").hide();
		var urlStr = 'addFillDc';
		if(addType == '2'){
			urlStr = 'addFillNeonate';
		}
		$.loadHtmlByUrl({
			url : "/idm/statistics/report/selfcheck/" + urlStr,
			insertDiv :"selfcheck_detailDiv",
			param : {type:type,id:id}
		});
		$("#selfcheck_detailDiv").show();
    };
    /*
     * 新增  新生儿产房接种 画面
     * type,'add':新增，'view':查看
     * */
    function addFillNeonate(type,id){
		$("#selfcheck_top_all").hide();
		$.loadHtmlByUrl({
			url : "/idm/statistics/report/selfcheck/addFillNeonate",
			insertDiv :"selfcheck_detailDiv",
			param : {type:type,id:id}
		});
		$("#selfcheck_detailDiv").show();
    }; 	
	return {
		addFillDc:addFillDc,
		addFillNeonate:addFillNeonate,
		loadFillSearch:loadFillSearch
	};
})();
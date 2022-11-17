var reportIndex = (function() {
	$(function() {
        /*填写*/
        $("#supervisorFillId").click(function() {
        	statisticsCommon.changeActive('supervisorId','supervisorFillId');
        	addFill('add');
        });		
        /*查看*/
        $("#supervisorListId").click(function() {
    		statisticsCommon.changeActive('supervisorId','supervisorListId');
        	loadFillSearch();       	
        });
        /*汇总*/
        $("#supervisorSummaryId").click(function() {
    		statisticsCommon.changeActive('supervisorId','supervisorSummaryId');
        	loadSummarySearch();      	
        });
        initFormByRole();
        
	});
    /*
     * 1、如果防疫科登录，默认画面是查看
     * 2、其他角色登录默认是填写画面
     * */	
	function initFormByRole(){
		var roleType = $('#tagContent1').find('#RoleTypeId').val();
		if(roleType == 'FYK'){
			$('#spanSupervisorListId').attr("class", "active"); 
			loadFillSearch();
		}else{
			addFill('add');
		}
	}
	/*加载查看*/
	function loadFillSearch() {
		var loadHtmlByUrlOption = {
			url : "/idm/statistics/report/supervisor/fillSearch",
			param : {},
			checkRepeat : true,
			insertDiv : "supervisorSearchDiv",
			errorDiv: "",
			okDiv:""
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	};	
	/*加载汇总查询*/
	function loadSummarySearch() {
		var loadHtmlByUrlOption = {
			url : "/idm/statistics/report/supervisor/summarySearch",
			param : {},
			checkRepeat : true,
			insertDiv : "supervisorSearchDiv",
			errorDiv: "",
			okDiv:""
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	};
	
    /*
     * 新增传染病管理及督导画面
     * type,'add':新增，'view':查看
     * */
    function addFill(type,id){
		$.loadHtmlByUrl({
			url : "/idm/statistics/report/supervisor/addFill",
			insertDiv :"supervisorSearchDiv",
			param : {type:type,id:id}
		});
    };	
	return {
		loadFillSearch:loadFillSearch
	};
})();
var fillSearch = (function() {
	$(function() { 	
        $("#fillBtnSearch").click(function() {
        	searchFill(1);
        });	
        if($('#RoleTypeId').val() != 'FYK'){
        	$("#reportUnitCodeId option[value='']").remove();//删除‘请选择’，中心统计时，必须选择一个单位
        } 
        searchFill(1);
        $("#fillSearchForm").onEnter(searchFill, 1);
	});
	/*传染病管理及督导画面查询*/
	function searchFill(pageIndex) {
        pageIndex = ($.isEmpty(pageIndex)?$('#tagContent1').find("#pageIndex").val():pageIndex);
		var searchObj = {
			url : "/idm/statistics/report/supervisor/fillList",
			insertDiv : 'fillResultDiv',
			param : {indexPage:pageIndex},
            callback : function(data) {
            	$('#tagContent1').find("#pageIndex").val(pageIndex);
            }
		};
		$("#fillSearchForm").submitFormLoadHtml(searchObj);
	};
    function search(){
        disableChangeConfirm();
        $("#filldetailDiv").empty();
        searchFill();
        $("#fillTopAll").show();
    }

    function returnSearch(){
        if(contentChanged){
            msgUtil.backConfirm(function(){
                search();
            });
        }else{
            search();
        }
    };	
    /*
     * 新增传染病管理及督导画面
     * type,'add':新增，'view':查看
     * */
    function addFill(type,id){
		$("#fillTopAll").hide();
		$.loadHtmlByUrl({
			url : "/idm/statistics/report/supervisor/addFill",
			insertDiv :"filldetailDiv",
			param : {type:type,id:id}
		});
		$("#filldetailDiv").show();
    };
	return {
		searchFill:searchFill,
        search:search,
        returnSearch:returnSearch,
        addFill:addFill
	};
})();
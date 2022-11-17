var selfFillSearch = (function() {
	$(function() { 	
        $("#selfFillBtnSearch").click(function() {
        	searchFill(1);
        });	
        if($('#RoleTypeId').val() != 'FYK'){
        	$("#reportUnitCodeId option[value='']").remove();//删除‘请选择’，中心统计时，必须选择一个单位
        } 
        searchFill(1);
        $("#fillSelfSearchForm").onEnter(searchFill, 1);
      
	});
	/*传染病管理及督导画面查询*/
	function searchFill(pageIndex) {
        pageIndex = ($.isEmpty(pageIndex)?$('#tagContent2').find("#pageIndex").val():pageIndex);
		var searchObj = {
			url : "/idm/statistics/report/selfcheck/fillList",
			insertDiv : 'fillSelfResultDiv',
			param : {indexPage:pageIndex},
            callback : function(data) {
            	$('#tagContent2').find("#pageIndex").val(pageIndex);
            }
		};
		$("#fillSelfSearchForm").submitFormLoadHtml(searchObj);
	};
    function search(){
        disableChangeConfirm();
        $("#fillSelfdetailDiv").empty();
        searchFill();
        $("#fillSelfTopAll").show();
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
     * 新增  法定传染病报告  画面
     * type,'add':新增，'view':查看
     * addType,'1':法定传染病，'2':新生儿产房接种
     * */
    function addFillDc(type,id,addType){
    	$("#selfcheck_detailDiv").empty();
		$("#fillSelfTopAll").hide();
		var urlStr = 'addFillDc';
		if(addType == '2'){
			urlStr = 'addFillNeonate';
		}
		$.loadHtmlByUrl({
			url : "/idm/statistics/report/selfcheck/" + urlStr,
			insertDiv :"fillSelfdetailDiv",
			param : {type:type,id:id}
		});
		$("#fillSelfdetailDiv").show();
    };
    /*
     * 新增  新生儿产房接种 画面
     * type,'add':新增，'view':查看
     * */
    function addFillNeonate(type,id){
    	$("#selfcheck_detailDiv").empty();
		$("#fillSelfTopAll").hide();
		$.loadHtmlByUrl({
			url : "/idm/statistics/report/selfcheck/addFillNeonate",
			insertDiv :"fillSelfdetailDiv",
			param : {type:type,id:id}
		});
		$("#fillSelfdetailDiv").show();
    };    
	return {
		searchFill:searchFill,
        search:search,
        returnSearch:returnSearch,
        addFillDc:addFillDc,
        addFillNeonate:addFillNeonate
	};
})();
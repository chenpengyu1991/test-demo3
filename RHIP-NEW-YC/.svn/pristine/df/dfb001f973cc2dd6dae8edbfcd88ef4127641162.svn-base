var standardSearch = (function() {
    var validate=null;
	$(function() { 	
        $("#standardBtnSearch").click(function() {
        	searchStandard(1);
        });	
        $("#standardSearchForm").onEnter(searchStandard, 1);
		searchStandard(1);
        
        $("#fgDown").click(function() {
        	fgDown();
        });	        
	});
	/*管理画面查询*/
	function searchStandard(pageIndex) {
        validate = $("#standardSearchForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var standardType = $('#standardType').val();
		var listName = 'list';
		if(standardType == '5'){
			listName = 'fglist';
		}
        if(standardType == '6'){
            listName = 'aiList';
        }
        pageIndex = ($.isEmpty(pageIndex)?$('#tagContent2').find("#pageIndex").val():pageIndex);
		var searchObj = {
			url : "/idm/malaria/standard/" + listName,
			insertDiv : 'standard_ResultDiv',
			param : {
				indexPage : pageIndex,standardType:standardType
			},
//            wait : true,
            callback : function(data) {
            	$('#tagContent2').find("#pageIndex").val(pageIndex);
            }
		};
		$("#standardSearchForm").submitFormLoadHtml(searchObj);
	};
    function search(){
        disableChangeConfirm();
        $("#standard_detailDiv").empty();
        searchStandard();
        $("#standard_top_all").show();
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
	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	};
	/*添加服药登记*/
	function addDrugreg(idmId,logoff) {
		var pageIndex = $("#pageIndex").val();
		$("#standard_top_all").hide();
		$.loadHtmlByUrl({
			url : "/idm/malaria/standard/addDrugreg",
			insertDiv :"standard_detailDiv",
//            wait : true,
			param : {pageIndex:pageIndex,
				idmId:idmId,logoff:logoff}
		});
		$("#standard_detailDiv").show();		
	};
	/*添加间日疟休止期服药登记*/
	function addRestDrugreg(idmId,logoff) {
		$("#standard_top_all").hide();
		$.loadHtmlByUrl({
			url : "/idm/malaria/standard/addRestDrugreg",
			insertDiv :"standard_detailDiv",
//            wait : true,
			param : {idmId:idmId,logoff:logoff}
		});
		$("#standard_detailDiv").show();		
	};	
    /*添加疫点处理*/
    function addEpidemicFocus(idmId,logoff) {
        $("#standard_top_all").hide();
        $.loadHtmlByUrl({
            url : "/idm/malaria/standard/initEditEpidemicFocus",
            insertDiv :"standard_detailDiv",
//            wait : true,
            param : {idmId:idmId,logoff:logoff}
        });
        $("#standard_detailDiv").show();
    };
    /*添加疫点处理*/
    function addVisit(idmId,logoff) {
        $("#standard_top_all").hide();
        $.loadHtmlByUrl({
            url : "/idm/malaria/standard/initVisit",
            insertDiv :"standard_detailDiv",
//            wait : true,
            param : {idmId:idmId,logoff:logoff}
        });
        $("#standard_detailDiv").show();
    };
    /*添加主动侦查*/
    function addAi() {
        $("#standard_top_all").hide();
        $.loadHtmlByUrl({
            url : "/idm/malaria/standard/initAddAi",
            insertDiv :"standard_detailDiv",
//            wait : true,
            param : {}
        });
        $("#standard_detailDiv").show();
    };
    /*添加重点人群新增画面*/
    function addFg(id) {
        $("#standard_top_all").hide();
        $.loadHtmlByUrl({
            url : "/idm/malaria/standard/addFg",
            insertDiv :"standard_detailDiv",
//            wait:true,
            param : {id:id}
        });
        $("#standard_detailDiv").show();
    };    
    function fgDown(){
    	location.href = contextPath + "/idm/malaria/standard/downFgExcel?" + $('#standardSearchForm').formSerialize();;
    }

    function aiDown(){
        location.href = contextPath + "/idm/malaria/standard/downAiExcel";
        location.href = contextPath + "/idm/malaria/standard/downAiExcel?" + $('#standardSearchForm').formSerialize();
    }

	return {
		searchStandard:searchStandard,
        search:search,
        returnSearch:returnSearch,
		toggle:toggle,
        addEpidemicFocus:addEpidemicFocus,
        addVisit:addVisit,
        addDrugreg:addDrugreg,
        addRestDrugreg:addRestDrugreg,
        addAi:addAi,
        addFg:addFg,
        fgDown:fgDown,
        aiDown:aiDown
	};
})();
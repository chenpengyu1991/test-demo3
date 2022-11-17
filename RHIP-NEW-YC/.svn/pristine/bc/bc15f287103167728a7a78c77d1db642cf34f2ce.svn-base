var schCasesSearch = (function() {
	$(function() {
        $("#check-submit-btn1").on("click", function (e) {
            e.preventDefault();
        	StartRead();
        });
		caseSearch();
        $("#caseBtnSearch").click(function(e) {
        	e.preventDefault();
        	caseSearch(1);
        });
        $("#caseBtnExport").click(function(e) {
        	e.preventDefault();
        	caseDown();
        });	  
        
        $("#caseSearchForm").onEnter(caseSearch, 1);
	});
    function StartRead()//开始读卡
    {
        if (GT2ICROCX.GetState() == 0){
            GT2ICROCX.ReadCard()
        }

        //GT2ICROCX.ReadCard() //循环读卡
        $("#idCardcase").val(GT2ICROCX.CardNo);
    }
	/*个案调查画面查询*/
	function caseSearch(pageIndex) {
		var currentPage = $('#tagContent2').find("#pageIndex").val();
		if($.isEmpty(currentPage)){
			currentPage = 1;
		}
        pageIndex = ($.isEmpty(pageIndex)?currentPage:pageIndex);		
		var searchObj = {
			url : "/idm/schistosome/case/list",
			insertDiv : 'caseResultDiv',
			param : {pageIndex:pageIndex},
//			wait:true,
            callback : function(data) {
            	$('#tagContent2').find("#pageIndex").val(pageIndex);
            }
		};
		$("#caseSearchForm").submitFormLoadHtml(searchObj);
	};
    function search(){
        disableChangeConfirm();
        $("#casedetailDiv").empty();
        caseSearch();
        $("#case_top_all").show();
    };
    
    function returnSearch(){
        // if(contentChanged){
			layer.confirm("确认离开？",function(index){
				layer.close(index);
				search();
			});
        // }else{
        // 	search();
        // }
    }
    /*
     * 新增个案调查画面
     * type,'add':新增，'view':查看
     * logoff:0:正常，1：注销
     * */
    function addCase(type,logoff){
		$("#case_top_all").hide();
		$.loadHtmlByUrl({
			url : "/idm/schistosome/case/edit",
			insertDiv :"casedetailDiv",
			param : {type:type,logoff:logoff},
			wait:true
		});
		$("#casedetailDiv").show();
    };
	function editCase(idmId,logoff) { 
		$("#case_top_all").hide();
		$.loadHtmlByUrl({
			url : '/idm/schistosome/case/edit',
			insertDiv :"casedetailDiv",
            param : {idmId:idmId,logoff:logoff}
		});
		$("#casedetailDiv").show();
	};
	function viewRegister(id,type) { 
		$("#case_top_all").hide();
		$.loadHtmlByUrl({
			url : '/idm/schistosome/case/viewRegister',
			insertDiv :"casedetailDiv",
            param : {type:type,
				idmId:id}
		});
		$("#casedetailDiv").show();
	};
	
	function initTreatment(idmId,logoff){
		$("#case_top_all").hide();
		$.loadHtmlByUrl({
			url : '/idm/schistosome/acography/initTreatment',
			insertDiv :"casedetailDiv",
            param : {idmId:idmId,logoff:logoff}
		});
		$("#casedetailDiv").show();		
	}
    function caseDown(){
    	location.href = contextPath + "/idm/schistosome/case/downExcel?" + $('#caseSearchForm').formSerialize();
    }	
	return {
		returnSearch:returnSearch,
		search:search,
		caseSearch:caseSearch,
		editCase:editCase,
		addCase:addCase,
		viewRegister:viewRegister,
		initTreatment:initTreatment
	};
})();
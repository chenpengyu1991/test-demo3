var transfertreat = (function() {
	var idmRecord = '';
	$(function() {
		validate = $("#tbFormTransfertreat").easyValidate();
        idmCommon.toggerAddress();
        idmCommon.initAdress();
		
		$.Placeholder.init({query:"#idCard",callback:function(element){
			tbCommon.queryPerson($(element).val(), validate);
		}});
		
		toggleOtherCK('diagnosis.diagnosisReason','transferTreatmentAccording','3');
        $("#transfertreatBtnSearch").click(function(e) {
            e.preventDefault();
        	search(1);
        });
        
        $("#transfertreatSearch").onEnter(search, 1);
        search(1);

        $("#traceSearch").onEnter(searchTrace, 1);

        $("#check-submit-btn").on("click", function (e) {
            e.preventDefault();
        	StartRead();
            $("#idcard").val(GT2ICROCX.CardNo);
        });
        $("#check-submit-btn1").on("click", function (e) {
            e.preventDefault();
        	StartRead();
            $("#idCard").val(GT2ICROCX.CardNo);
        });
	});
	
	function StartRead()//开始读卡
    {
        if (GT2ICROCX.GetState() == 0){
            GT2ICROCX.ReadCard()
        }
    }

	function search(indexPage) { 
		var searchObj = {
				url : "/idm/tb/confirmed/transfertreat/list",
				insertDiv : "listDivTransfertreat",
//                wait : true,
				param : {
					indexPage : indexPage
				}
			};
		$("#transfertreatSearchForm").submitFormLoadHtml(searchObj);
	};
	
	function loadSearchPage() {
		$("#top_allTransfertreat").hide();
    	$.loadHtmlByUrl({
			url : '/idm/tb/confirmed/trace/search',
			insertDiv :'traceDiv',
            wait : true,
			callback:function() {
				$("#traceBtnSearch").click(function(e) {
	                e.preventDefault();
	            	searchTrace(1);
        		});
				$("#traceDiv").show();
				searchTrace(1);
				
			}
		});
    }
	
	function searchTrace(indexPage) {
		
		var searchObj = {
				url : "/idm/tb/confirmed/trace/list",
				insertDiv : "listDivTrace",
                wait : true,
				param : {
					indexPage : indexPage
				}
			};
		$("#traceSearchForm").submitFormLoadHtml(searchObj);
	};
	
	function searchTemp(pageIndex){
		if($.isEmpty(pageIndex)) {
			 pageIndex = $("#pageIndex").val();
		}
		disableChangeConfirm();
        var pageIndex = $("#pageIndex").val();
		$("#detailDivTransfertreat").empty();
		$("#traceDiv").empty();
		pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
		search(pageIndex);
		$("#top_allTransfertreat").show();		
	}	
	
	function addTraceRecord(idmId,placeStatus,date) {
		idmRecord = idmId;
		if(placeStatus == '4' || placeStatus=='') {
			$.getJsonByUrl({
				 url : "/idm/tb/confirmed/trace/add",
                 wait : true,
				 checkRepeat:false,
				 callback:function(data){
					 if(data.indexOf("success") != -1) {
						 layer.alert(date+"日对此患者进行追踪！", {icon:0,title:'提示'});
					 }
					 getTraceRecord();

				 },
				 param:{idmId:idmId}
			});
		} else {
			getTraceRecord();
		}
		
	}
	
	function getTraceRecord() {
		
		$.post(contextPath+"/idm/tb/confirmed/traceRecode/search",{idmId : idmRecord},
		function(ret) {
    	layui.use(['layer'], function() {
    		  var layer = layui.layer
    		  layer.open({
    			  type: 1,
    			  id:'wonmenHealth',
    			  area: ['1000px', '700px'],
    			  title:'追踪记录',
    			  content: ret
    		  });
    		});
    	});
		//searchRecord(1);
	}
	
	function searchRecord(indexPage) {
		$.loadHtmlByUrl({
			url : "/idm/tb/confirmed/traceRecode/list",
			 insertDiv : "listDiv",
            wait : true,
			 param : {
					indexPage : indexPage,
					idmId : idmRecord
			 }
		});
	}
	
	function initPrint(singleId) {
		/*$("#top_allTransfertreat").hide();
		var pageIndex = $("#currentPageTransfertreat").val();
		$.loadHtmlByUrl({
			url : "/idm/tb/confirmed/print",
			insertDiv :"detailDivTransfertreat",
            wait : true,
			param : {
				singleId: singleId,
				pageIndex: pageIndex
			}
		});
		$("#detailDivTransfertreat").show();*/
		var url = contextPath + "/idm/tb/confirmed/print?singleId=" + singleId;
		util.printPage(url);
	}
	
	function print(){
		var url = contextPath + "/hm/studentExam/printStudentExam?ids=" + studentExamId;
		util.printPage(url);
    	$("#printPage").jqprint();
    }
	
	return {
        search: search,
        searchTemp:searchTemp,
        addTraceRecord:addTraceRecord,
        initPrint: initPrint,
        print: print,
        searchTrace: searchTrace,
        loadSearchPage: loadSearchPage,
        searchTrace:searchTrace,
        searchRecord: searchRecord
	};
})();

/*$(document).ready(function () { 
	//按钮样式切换 
	$("#transfertreatBtnSearch").hover( 
		function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
		}, 
		function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
		} 
	); 
	$("#traceBtnSearch").hover( 
			function () { 
			$(this).removeClass("search_btn").addClass("search_btn_h"); 
			}, 
			function () { 
			$(this).removeClass("search_btn_h").addClass("search_btn"); 
			} 
		);
});*/
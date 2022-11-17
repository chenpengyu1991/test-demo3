var reportSearch = (function() {
	$(function() {
		// 高级查询条件显示控制
		$("#perAdvanceSearchConditionBtn").click(function(e) {
			e.preventDefault();
			controlAdvanceSearchSection($(this));
		});

		/*报卡查询*/
		$("#idmReportSearchBtn").click(function(e) {
			e.preventDefault();
			search(1);
		});
		$("#caseExport").click(function(e) {
			e.preventDefault();
			reportExport();
		});
	   $("#caseInport").click(function(e) {
		   e.preventDefault();
		   reportImport('12');
	   });
		search(1);
		$("#reportSearch").onEnter(search, 1);
		$('#reportStatus').change(function(){
			reportStatusChange();
		});
		//util.checkBoxAll("reportChk","reportChkRef");
	});

	function search(indexPage) { 
		var searchObj = {
			url : "/idm/report/reportList",
			insertDiv : "reportResultDiv",
//			wait:true,
			param : {
				indexPage : indexPage
			}
		};
		$("#reportSearchForm").submitFormLoadHtml(searchObj);
	};

	function add() { 
		var pageIndex = $("#currentPage").val();
		$("#top_all").hide();
		$.loadHtmlByUrl({
			url : "/idm/report/add",
			insertDiv :"detailDiv",
			param : {pageIndex:pageIndex}
		});
		$("#detailDiv").show();
		
	};
	function edit(id) { 
		$("#top_all").hide();
        var pageIndex = $("#currentPage").val();
		$.loadHtmlByUrl({
			url : '/idm/report/edit/'+ id  ,
			insertDiv :"detailDiv",
            param : {pageIndex:pageIndex},
            wait : true
        });
		$("#detailDiv").show();
	};

    function caseIndex(id,idmId,infectiousCode,name,type){
        $("#top_all").hide();
        var pageIndex = $("#currentPage").val();
        $.loadHtmlByUrl({
            url : "/idm/case/caseIndex",
            insertDiv :"detailDiv",
            param : {id:id, idmId:idmId, infectiousCode:infectiousCode, pageIndex:pageIndex,name:name,type:type},
            wait : true
        });
        $("#detailDiv").show();

    };

	/*个案填写*/
	function caseAdd(id,idmId,infectiousCode) {
		$("#top_all").hide();
        var pageIndex = $("#currentPage").val();
		$.loadHtmlByUrl({
			url : "/idm/case/initAdd",
			insertDiv :"caseDetailDiv",
			param : {id:id, idmId:idmId, infectiousCode:infectiousCode, pageIndex:pageIndex},
            wait : true
        });
		$("#caseDetailDiv").show();
		
	};
	/*个案编辑*/
	function caseEdit(idmId,infectiousCode) {
		$("#top_all").hide();
        var pageIndex = $("#currentPage").val();
		$.loadHtmlByUrl({
			url : "/idm/case/initEdit",
			insertDiv :"caseDetailDiv",
			param : {idmId : idmId, infectiousCode:infectiousCode, pageIndex:pageIndex},
            wait : true
        });
		$("#caseDetailDiv").show();
	};
	
	function print(id) { 
		$("#top_all").hide();
		$.loadHtmlByUrl({
			url : '/idm/report/print/'+ id  ,
			insertDiv :"detailDiv",
			wait:true
		});
		$("#detailDiv").show();
	};

    function detail(id) {
        $("#top_all").hide();
        $.loadHtmlByUrl({
            url : '/idm/report/detail/'+ id  ,
            insertDiv :"detailDiv"
        });
        $("#detailDiv").show();
    };

	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	};
	/*
	 * 如果报卡状态为未审核
	 * 禁止选择个案状态
	 * */
	function reportStatusChange(){
		var reportStatus = $('#reportStatus').val();
		if(reportStatus == '1'){
			$('#caseStatus').val('');
			$('#caseStatus').attr("disabled","disabled");
		}else{
			$('#caseStatus').removeAttr('disabled');
		}
	}
	
	 function addLeporsyReport(reportId, statusId) {
		$("#top_all").hide();
		var pageIndex = $("#currentPage").val();
		$.loadHtmlByUrl({
			url : "/idm/report/init",
			insertDiv :"detailDiv",
			wait:true,
			param : {
				reportId: reportId,
				pageIndex: pageIndex,
				statusId: statusId
			}
		});
		$("#detailDiv").show();
	   }
	 
	 /**
	 * 与后台交互保存数据
	 */
	function submitLeprosy(type) {
		$("#leprosyFormSuspected").submitFormGetJson({
			url : '/idm/leprosy/save',
			wait:true,
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("麻风疑似上报失败！", {icon:0,title:'提示'});
                } else {
                    layer.alert("麻风疑似上报成功！", {icon:0,title:'提示'});
                    reportEdit.search();
                    return false;
                }
            },
            param : {
            	type:"1",
            	statusId: statusId
            }
		});
	}
	 /**
	 * 查询传染病
	 * type:1 按分类查询
	 * type:2 按名称查询
	 */	
    function querySearchInfection() {
        var infectionType = $('#searchType').val();
        if(infectionType == 'L'){
            $("#searchInfectiousCode").hide();
            return;
        }
         //默认为甲乙丙
         infectionType = $.isEmpty(infectionType)?"J":infectionType;
        $("#searchInfectiousCode option").remove();
        $("#searchInfectiousCode").append('<option value="">' + "请选择" + '</option>');
        $.getJsonByUrl({
            url : "/idm/report/queryInfections",
            param : {type:'IDM00400'+infectionType},
            wait:true,
            callback : function(data) {

                /*将KEY放入数组，数组排序后，通过遍历数组，排序输出*/
                var keyArr = [];
                $.each(data, function(key, val){
                    keyArr[keyArr.length] = key;
                });
                keyArr.sort();
                $.each(keyArr, function(i, key){
                    $("#searchInfectiousCode").append('<option value="'+ key +'">' + data[key] + '</option>');
                });
                $("#searchInfectiousCode").show();
            }
        });
    };	
    function changeInfectious(type){
    	$('#searchType').val('');
    	 $("#searchInfectiousCode option").remove();
    	if(type == '1'){
    		$('#searchType').show();
    	}else{
    		$('#searchType').hide();
    	}
    	querySearchInfection();
    }
    function reportImport(infectiousCode){
        var dialogParams = {
            id : "d1",
            url : "/idm/report/historyReportImport",
            param : {infectiousCode:infectiousCode},
            height : 200,
            width : 750,
            title : "数据导入"
        };
        $.dialog(dialogParams);
    }
    function reportExport(){
        location.href = contextPath + "/idm/report/historyReportExport?" + $('#reportSearchForm').formSerialize();
    }
	return {
        reportExport:reportExport,
        search : search,
        add:add,
        caseAdd:caseAdd,
        caseEdit:caseEdit,
        print:print,
        detail:detail,
        edit:edit,
        toggle:toggle,
        caseIndex:caseIndex,
        addLeporsyReport: addLeporsyReport,
        submitLeprosy: submitLeprosy,
        querySearchInfection:querySearchInfection,
        changeInfectious:changeInfectious
	};
})();

$(document).ready(function () { 
	//按钮样式切换 
	$("#reportBtnSearch").hover( 
		function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
		}, 
		function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
		} 
	); 

});

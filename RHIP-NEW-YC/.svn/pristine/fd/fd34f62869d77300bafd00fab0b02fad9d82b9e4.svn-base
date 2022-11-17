var reportSearch = (function() {
	$(function() { 
            searchHistory(1);
            $('#reportStatus').change(function(){
            	reportStatusChange();
            });
            
            $("#idmReportHistorySearchBtn").on("click", function (e) {
            	e.preventDefault();
            	searchHistory(1);
            });
	});

	function searchHistory(indexPage) { 
		var fillBeginDate = $("#fillBeginDate").val();
		var fillEndDate = $("#fillEndDate").val();
		var beginDate = new Date(fillBeginDate);
		var endDate = new Date(fillEndDate);
		if(beginDate>endDate){
			layui.use('layer', function(){
				var layer = layui.layer;
				
				layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
			});
			return;
		}
		var searchObj = {
			url : "/idm/report/historyReportList",
			insertDiv : "reportResultDiv",
//			wait:true,
			param : {
				indexPage : indexPage
			}
		};
		$("#reportSearchForm").submitFormLoadHtml(searchObj);
	};

    /*
     * 如果报卡状态为未审核
     * 禁止选择个案状态
     */
    function reportStatusChange(){
        var reportStatus = $('#reportStatus').val();
        if(reportStatus == '1'){
            $('#caseStatus').val('');
            $('#caseStatus').attr("disabled","disabled");
        }else{
            $('#caseStatus').removeAttr('disabled');
        }
    }
    
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
	return {
        toggle:toggle,
        querySearchInfection:querySearchInfection,
        changeInfectious:changeInfectious,
        searchHistory:searchHistory
	};
})();

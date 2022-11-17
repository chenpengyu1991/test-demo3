var followupStatistics= (function() {
    $(function() {
        search(1);
        addNameAutoComplete("input[name='inputerName']");

        $("#inputerName").result(function(event, data, formatted) {
            //如选择后给其他控件赋值，触发别的事件等等
            if(data==undefined)
                $("#staffCodeId").val("");
            else
                $("#staffCodeId").val(data.staffCode);
        });
        $("#ehr-person-export-btn").click(function(e) {
        	e.preventDefault();
            exportList();
        });
        
        $("#statisticsSearchId").click(function(e)
        		{
        			e.preventDefault();
        			search(1);
        		});
        
        $("#statisticsSearchId2").click(function(e)
        		{
        			e.preventDefault();
        			search(1);
        		});
        
    	})
    function search(indexPage) {
        searchCheck(function() {
            $("#form_search").submitFormLoadHtml({
                url : "/cdm/standardization//statistics/list",
                insertDiv : "list_datagrid",
                param : {
                    pageIndex : indexPage
                }
            });
        });
    }

    function exportList() {
        var option={
            url:"/cdm/standardization/statistics/export",
            param:{
                orgCode : $("#orgCode").val()
            }
        };
        searchCheck(function() {
            $("#form_search").exportListExcel(option);
        });
    }

    function searchCheck(callback) {
        var startDateStr=$("input[name='beginDate']").val();
        var endDateStr=$("input[name='endDate']").val();
        if($.isEmpty(startDateStr) || $.isEmpty(endDateStr)) {
        	layer.alert("查询日期不能为空！", {icon:0,title:'提示'});
            $("#beginDateId").val("");
            $("#endDateId").val("");
        } else if(startDateStr > endDateStr){
        	layer.alert("开始日期不能大于结束日期！", {icon:0,title:'提示'});
            $("#beginDateId").val("");
            $("#endDateId").val("");
        } else{
            var startDate=parseDate(startDateStr);
            var startYear=startDate.getFullYear();
            var endDate=parseDate(endDateStr);
            var endYear=endDate.getFullYear();
            if(startYear != endYear) {
            	layer.alert("查询日期区间不能跨年！", {icon:0,title:'提示'});
                $("#beginDateId").val("");
                $("#endDateId").val("");
                return;
            }
            callback();
        }
    }

    function addNameAutoComplete(query) {
        $.getJsonByUrl({
            url : "/staff/getStaffLogListByOrg",
            param : {

            },
            callback : function(data) {
                var $nameInput = $(query);
                $nameInput.autocomplete(data, {
                    minChars : 0,
                    width : 250,
                    max : 100,
                    autoFill : false,
                    mustMatch:true,
                    matchContains : true,
                    formatItem : function(row, i, max) {
                        return row.name;
                    },
                    formatMatch : function(row, i, max) {
                        return row.name + row.staffCode;
                    },
                    formatResult : function(row) {
                        return row.name;
                    }

                });
            }
        });
    }
    function changeSearchType(){
        var searchType = $('input:radio[name="searchType"]:checked').val();
        if(searchType == '1'){
            $('#orgFollowupTrId').show();
            $('#villageFollowupTrId').hide();
        }else if(searchType == '2'){
            $('#orgFollowupTrId').hide();
            $('#villageFollowupTrId').show();
        }
    }
    return {
        pagination: search,
        changeSearchType: changeSearchType
    };

})();

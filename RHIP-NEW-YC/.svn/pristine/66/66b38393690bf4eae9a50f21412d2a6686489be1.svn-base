var personRecordPagination = (function(){
    var isSaved = false;
    var currentPage = 1;
    var SelectedAbleTable = function(contextId, tableId) {
        this.tableSe = "#" + tableId;
        this.contextSe = "#" + contextId;
    };

    SelectedAbleTable.prototype = {
        trSeletedClass : "listtrselect",
        trSeletedSe : " .listtrselect ",
        trSe : " tbody tr ",
        init : function() {
            $(this.contextSe).on(
                "click",
                this.tableSe + this.trSe,
                this,
                function(e) {
                    var outer = e.data;
                    $(outer.tableSe + outer.trSe).removeClass(
                        outer.trSeletedClass);
                    $(this).addClass(outer.trSeletedClass);
                });
        },
        getSelectedTr : function() {
            return $("table tr").filter(this.trSeletedSe);
        }
    };
    var tables = new SelectedAbleTable("list_datagrid", "person_record_table");


    function refresh() {
        if (isSaved)
        {
            personSearch(currentPage);
            isSaved = false;
        }
        var removeSessionOption = {
            url : "/personRecord/removeSession"
        };
        $.getJsonByUrl(removeSessionOption);
    }
    function personSearch(indexPage) {
        var ageBegin = parseInt($("#beginAge").val());
        var ageEnd = parseInt($("#endAge").val());

        var createBegin = new Date($("#createBeginDate").val());
        var createEnd = new Date($("#createEndDate").val());

        var updateBegin = new Date($("#updateBeginDate").val());
        var updateEnd = new Date($("#updateEndDate").val());



        var url = '/regionRecord/result';

        if(updateBegin > updateEnd){
        	layer.alert("更新开始时间不能大于建档结束时间！", {icon:0,title:'提示'});
            return;
        }

        if (ageBegin > ageEnd && createBegin > createEnd) {
        	layer.alert("开始年龄不能大于结束年龄\n建档开始时间不能大于建档结束时间！", {icon:0,title:'提示'});
            $("#beginAge").val("");
            $("#endAge").val("");
            $("#createBeginDate").val("");
            $("#createEndDate").val("");
        } else if (createBegin > createEnd) {
        	layer.alert("建档开始时间不能大于建档结束时间！", {icon:0,title:'提示'});
            $("#createBeginDate").val("");
            $("#createEndDate").val("");
        } else if (ageBegin > ageEnd) {
        	layer.alert("开始年龄不能大于结束年龄！", {icon:0,title:'提示'});
            $("#beginAge").val("");
            $("#endAge").val("");
        } else {
            $("#form_search").submitFormLoadHtml({
                url : url,
                insertDiv:"list_datagrid",
                param:{
                    organCode : $("#nowAddressCode").val(),
                    indexPage: indexPage
                }
            });
        }
    }

    $("#sys_mdm_btn").click(function(){
        $.getJsonByUrl({
            url : "/region/tongbuToMDM",
            callback:function(data){
            	layer.alert(data, {icon:0,title:'提示'});
            }
        });
    } );

    function toggle(obj,tableId) {
        $(obj).toggleClass("ico-top");
        $(obj).toggleClass("ico-bottom");
        $("#" + tableId).toggle();
    };

    function exportList() {
        var option={
            url:"/regionRecord/export"
        };
        searchCheck(function() {
        	$("#form_search").exportListExcel(option);
        });
    }
    function searchCheck(callback) {

        var ageBegin = parseInt($("#beginAge").val());
        var ageEnd = parseInt($("#endAge").val());

        var createBegin = new Date($("#createBeginDate").val());
        var createEnd = new Date($("#createEndDate").val());

        var updateBegin = new Date($("#updateBeginDate").val());
        var updateEnd = new Date($("#updateEndDate").val());

        if (updateBegin > updateEnd)
        {
        	layer.alert("更新开始时间不能大于建档结束时间！", {icon:0,title:'提示'});
            return;
        }

        if (ageBegin > ageEnd && createBegin > createEnd)
        {
        	layer.alert("开始年龄不能大于结束年龄\n建档开始时间不能大于建档结束时间！", {icon:0,title:'提示'});
            $("#beginAge").val("");
            $("#endAge").val("");
            $("#createBeginDate").val("");
            $("#createEndDate").val("");
        } else if (createBegin > createEnd)
        {
        	layer.alert("建档开始时间不能大于建档结束时间！", {icon:0,title:'提示'});
            $("#createBeginDate").val("");
            $("#createEndDate").val("");
        } else if (ageBegin > ageEnd)
        {
        	layer.alert("开始年龄不能大于结束年龄！", {icon:0,title:'提示'});
            $("#beginAge").val("");
            $("#endAge").val("");
        } else
        {
            callback();
        }
    }
    return {
        pagination:personSearch,
        toggle:toggle
    };
})();


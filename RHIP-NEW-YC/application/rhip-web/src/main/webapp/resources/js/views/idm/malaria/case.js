var malariaCase = (function() {
    $(function() {
        searchCase();
        var type = $('#tagContent1').find('#type').val();
        $("#caseSearchForm").onEnter(searchCase, 1);
    });

    function searchCase(pageIndex){
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var searchObj = {
            url : "/idm/malaria/case/list",
            insertDiv : "caseResultDiv",
            param : {
                indexPage : pageIndex
            },
//            wait : true,
            callback : function(data) {
            	$('#tagContent1').find('#pageIndex').val(pageIndex);
            }
        };
        $("#caseSearchForm").submitFormLoadHtml(searchObj);
    }

    function search(){
        disableChangeConfirm();
        var pageIndex = $('#tagContent1').find('#pageIndex').val();
        $("#detailDiv2").empty();
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        searchCase(pageIndex);
        $("#top_all2").show();
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
     * singleId:事件表ID
     * logoff:档案注销状态
     * */
    function initAdd(singleId,logoff){
        enableChangeConfirm();
        $("#top_all2").hide();

        $.loadHtmlByUrl({
            url : "/idm/malaria/case/initAdd",
            insertDiv :"detailDiv2",
//            wait : true,
            param : {singleId:singleId,logoff:logoff}
        });
        $("#detailDiv").show();
    }

    function initEdit(singleId, type,logoff){
        enableChangeConfirm();
        $("#top_all2").hide();
        $.loadHtmlByUrl({
            url : "/idm/malaria/case/initEdit",
            insertDiv :"detailDiv2",
//            wait : true,
            param : {singleId:singleId,type:type,logoff:logoff}
        });
        $("#detailDiv2").show();
    }
    function caseDownLoad(){
    	location.href = contextPath + "/idm/malaria/case/downMalariaCaseExcel?" + $('#caseSearchForm').formSerialize();
    }	
    return {
        searchCase:searchCase,
        returnSearch:returnSearch,
        initAdd:initAdd,
        initEdit:initEdit,
        search:search,
        caseDownLoad:caseDownLoad
    };
})();
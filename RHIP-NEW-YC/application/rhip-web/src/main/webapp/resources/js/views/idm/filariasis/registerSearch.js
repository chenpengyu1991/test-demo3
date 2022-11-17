var filRegSearch = (function() {
    var validate=null;
	$(function() {

        $("#registerBtnSearch").click(function(e) {
            e.preventDefault();
            searchRegister(1);
        });

        $("#registerSearchForm").onEnter(searchRegister, 1);

        searchRegister();
    });

    function initAddReg(){
        var pageIndex = $("#pageIndex").val();
        $("#register_top_all").hide();
        $.loadHtmlByUrl({
            url : "/idm/filariasis/reg/initAddRegister",
            insertDiv :"registerDetailDiv",
            param : {
                pageIndex:$.isEmpty(pageIndex)?1:pageIndex,
                type: 'add'
            }
        });
        $("#registerDetailDiv").show();
    }

    function searchRegister(pageIndex){
        if($.isEmpty(pageIndex)){
            pageIndex = $('#tagContent0').find('#pageIndex').val();
        }
        var searchObj = {
            url : "/idm/filariasis/reg/registerList",
            insertDiv : 'registerResultDiv',
            param : {
                pageIndex : $.isEmpty(pageIndex)?1:pageIndex
            },
            callback : function(data) {
                $('#tagContent0').find('#pageIndex').val(pageIndex);
            }
        };
        $("#registerSearchForm").submitFormLoadHtml(searchObj);
    }

    function initEditReg(singleId){
        $("#register_top_all").hide();
        $.loadHtmlByUrl({
            url : "/idm/filariasis/reg/initAddRegister",
            insertDiv :"registerDetailDiv",
            param : {singleId:singleId,type:'edit'}
        });
        $("#registerDetailDiv").show();
    }

    return {
        initAddReg:initAddReg,
        initEditReg:initEditReg,
        searchRegister:searchRegister
    };

})();

var filariasisCase = (function() {
    var validate=null;
    $(function() {
        validate = $("#caseForm").easyValidate();
        searchCase();
        toggleOther('pastHistory.microfilariaCheck','microfilariaCheckPart',2);
        toggleOther('attackCondition.lymphatic','lymphaticPart',1);
        toggleOther('attackCondition.lymphedema','lymphedemaPart',1);
        toggleOther('attackCondition.chyluria','chyluriaPart',1);
        toggleOther('attackCondition.tunicaVaginali','tunicaVaginaliPart',1);

        $("#caseBtnSearch").click(function(e) {
            e.preventDefault();
            searchCase();
        });

        $("#caseSearchForm").onEnter(searchCase, 1);
        idmCommon.displayPaAddress();
        enableChangeConfirm();
        initAdress();
    });

    function initAdress() {
        $("select[name='generalCondition.paGroup']").change(idmCommon.displayPaAddress);
        //地址三级不是必输项
        $("select[name='generalCondition.paGroup']").removeAttr("reg");
    }

    function caseSubmit(type) {
        var message = '';
        if('add' == type){
            message = '保存';
        }
        if('edit' == type){
            message = '修改';
        }
        var result=validate.validateForm();
        if(!result){
            return;
        }
        //时间类型,格式转成"yyyy/MM/dd"
        var breakOutDt =  $('#breakOutDt').val();
        if((!$.isEmpty(breakOutDt)) && breakOutDt.length == 4){
            var breakOutDtYMD = breakOutDt + '/01/01';
            $('#breakOutDt').val(breakOutDtYMD);
        }
        var lastBreakOutDt =  $('#lastBreakOutDt').val();
        if(undefined != lastBreakOutDt && lastBreakOutDt != '' && lastBreakOutDt.length == 7){
            var lastBreakOutDtYMD = lastBreakOutDt + '/01';
            $('#lastBreakOutDt').val(lastBreakOutDtYMD);
        }

        var chyluriaDt =  $('#chyluriaDt').val();
        if((!$.isEmpty(chyluriaDt)) && chyluriaDt.length == 4){
            var chyluriaDtYMD = chyluriaDt + '/01/01';
            $('#chyluriaDt').val(chyluriaDtYMD);
        }
        var chyluriaLastDt =  $('#chyluriaLastDt').val();
        if(undefined != chyluriaLastDt && chyluriaLastDt != '' && chyluriaLastDt.length == 7){
            var chyluriaLastDtYMD = chyluriaLastDt + '/01';
            $('#chyluriaLastDt').val(chyluriaLastDtYMD);
        }

        var tunicaVaginaliDt =  $('#tunicaVaginaliDt').val();
        if(undefined != tunicaVaginaliDt && tunicaVaginaliDt != '' && tunicaVaginaliDt.length == 7){
            var tunicaVaginaliDtYMD = tunicaVaginaliDt + '/01';
            $('#tunicaVaginaliDt').val(tunicaVaginaliDtYMD);
        }
        debugger;
        var idmId = $("#idmIdCase").val();
        var singleId = $("#singleIdCase").val();
        $("#caseForm").submitFormGetJson({
            url : "/idm/filariasis/case/saveCase",
            wait : true,
            param: {
                type: type,
                idmId : idmId,
                singleId : singleId
            },
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                	layer.alert("个案"+message+"失败！", {icon:0,title:'提示'});
                }else {
                	layer.alert("个案"+message+"成功！", {icon:0,title:'提示'});
                    search();
                    return false;
                }
            }
        });
    };

    function searchCase(pageIndex){
        if($.isEmpty(pageIndex)){
            pageIndex = $('#tagContent2').find('#pageIndex').val();
        }
        var searchObj = {
            url : "/idm/filariasis/case/caseList",
            insertDiv : "caseListDiv",
//            wait : true,
            param : {
                pageIndex : $.isEmpty(pageIndex)?1:pageIndex
            },
            callback : function(data) {
                $('#tagContent2').find('#pageIndex').val(pageIndex);
        }
        };
        $("#caseSearchForm").submitFormLoadHtml(searchObj);
    }

    function initCaseDetail(singleId,idmId, type,logoff){
        $.loadHtmlByUrl({
            url : "/idm/filariasis/case/initCaseDetail",
//            wait : true,
            insertDiv :"caseDetailDiv",
            param : {singleId:singleId,idmId:idmId, type:type, logoff:logoff}
        });
        $("#topAll").hide();
    }

    function search(){
        disableChangeConfirm();
        var pageIndex = $('#tagContent1').find('#pageIndex').val();
        $("#caseDetailDiv").empty();
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        searchCase(pageIndex);
        $("#topAll").show();
    }

    function returnSearch(){
        /*if(contentChanged){
            msgUtil.backConfirm(function(){
                search();
            });
        }else{
            search();
        }*/


		// if (contentChanged)
		// {
			 layui.use('layer', function() {
	    			var layer = layui.layer;
	    			var index = layer.confirm('确认离开?', {icon:1, title:'确认提示'}, function(){
	    				layer.close(index);
	    				search();
					});
	    			
	    		});
			/*msgUtil.backConfirm(doBack) ;*/
		// }else{
		// 	search();
		// }
    };

    function caseDownLoad(){
        location.href = contextPath + "/idm/malaria/case/downMalariaCaseExcel?" + $('#caseSearchForm').formSerialize();

    }

    return {
        caseSubmit:caseSubmit,
        searchCase:searchCase,
        returnSearch:returnSearch,
        caseDownLoad:caseDownLoad,
        initCaseDetail:initCaseDetail
    };
})();
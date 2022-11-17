var frts = (function() {
    $(function () {
        var tab = $("#tab").val();
        if ('case' == tab) {
            caseSelected();
        }
        if ('fr' == tab) {
            frSelected();
        }
        if ('ts' == tab) {
            tsSelected();
        }
    });

    function selectTag(selfObj){
        $('#tags').find('li').each(function(){
            $(this).removeClass('selectTag');
        });

        selfObj.parentNode.className = "selectTag";
        $('#tagContent').find("[id^='tagContent']").each(function(){
            $(this).hide();
        });

    }

    function caseSelected(){
        var id = $("#idI").val();
        var idmId = $("#idmIdI").val();
        var infectiousCode = $("#infectiousCodeI").val();
        var type = $("#typeI").val();
        var logoff = $("#logoffI").val();
        var pageIndex = $("#pageIndexI").val();
        var repeat = $("#repeat").val();
        if(type == 1){
            caseSearch.caseAdd(id, idmId, infectiousCode, logoff);
        }else if(type == 3 ){
        	if(repeat == 1){
        		repeatSearch.caseView(idmId, infectiousCode, logoff);
        	}else {
        		caseSearch.caseView(idmId, infectiousCode, logoff);	
        	}
        }else{
            caseSearch.caseEdit(idmId, infectiousCode, logoff);
        }
    }

    function frSelected(){
        var idmId = $("#idmIdI").val();
        var name = $("#nameI").val();
        var logoff = $("#logoffI").val();

        $.loadHtmlByUrl({
            url : "/idm/frts/initFr",
            insertDiv :"caseDetailDiv",
            param : {singleId:idmId,name:name,logoff:logoff}
        });
        $("#caseDetailDiv").show();
    }

    function tsSelected(){
        var idmId = $("#idmIdI").val();
        var name = $("#nameI").val();
        var infectiousCode = $("#infectiousCode").val();
        var logoff = $("#logoffI").val();
        $.loadHtmlByUrl({
            url : "/idm/frts/initTs",
            insertDiv :"caseDetailDiv",
            param : {singleId:idmId,name:name,infectiousCode:infectiousCode,logoff:logoff}
        });
        $("#caseDetailDiv").show();
    }

    function saveFr(type){
        var validate=null;
        validate = $("#frForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var singleId = $("#singleIdFr").val();
        var infectiousCode= $("#infectiousCode").val();
        if(infectiousCode == "311"){
        	 var frListStr = getDataForTable('frTable', singleId);
             if($.isEmpty(frListStr)){
            	 layer.alert("请填写随访信息！", {icon:0,title:'提示'});
                 return false;
             }
             $("#listFrJson").val(util.Obj2str(frListStr));
        }
        $("#frForm").submitFormGetJson({
            url : "/idm/frts/saveFr",
            param : {
                type : type
            },
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                	layer.alert("保存失败！", {icon:0,title:'提示'});
                }else {
                    disableChangeConfirm();
                    layer.alert("保存成功！", {icon:0,title:'提示'});
                    frSearch.search(1);
                    return;
                }
            }
        });
    }

    function getDataForTable(tableId, singleId){
        var tableData = [];
        $("#"+tableId+" tr").each(function(trindex,tritem){
            if(trindex > 1){
                var trData = {};
                $(tritem).find("td").each(function(tdindex,tditem){
                    trData['idmId'] = singleId;
                    var inputValue = $(tditem).text();
                    inputValue = inputValue.replace(/\t/g,'');//制表符替换
                    inputValue = inputValue.replace(/\n/g,'');//换行替换
                    if('' != inputValue && "undefined" !=inputValue && undefined !=inputValue ){
                        trData[$(this).attr("field")] = inputValue;
                    }
                    trData['flag'] = 0;
                });
                tableData.push(trData);
            }
        });
        return tableData;
    }

    function initAdd(){
        $("#toEmpty").find("input[type=text]").each(function(){
            $(this).val('');
        });
        $("#toEmpty").find("input[type=radio]").each(function(){
            $(this).attr("checked",false);
        });
        $("#toEmpty").find("input[type=checkbox]").each(function(){
            $(this).attr("checked",false);
        });
        $("#toEmpty").find("select").each(function(){
            $(this).val('');
        });
        $("#toEmpty").find("textarea").each(function(){
            $(this).val('');
        });
        $(".listtrselect").removeClass("listtrselect");
        $("#xinzeng").hide();
        $("#xiugai").hide();
        $("#shanchu").hide();
        $("#baocun").show();
    }

    function clickRow(selectRow, flag){
        var infectiousCode = $("#infectiousCode").val();
        var id = $(selectRow).attr("id");
        var url = '';
        if('fr' == flag){
            url = '/idm/frts/initFrDetail';
        }
        if('ts' == flag){
            url = '/idm/frts/initTsDetail';
        }
        $.loadHtmlByUrl({
            url : url,
            insertDiv :"subDetailDiv",
            param : {
                id: id,
                infectiousCode : infectiousCode
            }
        });
        $("#xinzeng").show();
        $("#xiugai").show();
        $("#shanchu").show();
        $("#baocun").hide();
    }

    function saveTs(type){
        var validate=null;
        var infectiousCode = $("#infectiousCode").val();
        var singleId = $("#singleId").val();
        validate = $("#tsForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        $("#tsForm").submitFormGetJson({
            url : "/idm/frts/saveTs",
            param : {
                type : type,
                infectiousCode : infectiousCode
            },
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                	layer.alert("保存失败！", {icon:0,title:'提示'});
                }else {
                	layer.alert("保存成功！", {icon:0,title:'提示'});
                    tsSearch.initTs(singleId, infectiousCode, 0);
                    disableChangeConfirm();
                    return ;
                }
            }
        });
    }

    function searchFrList(pageIndex){
        var singleId = $("#singleId").val();
        $.loadHtmlByUrl({
            url : "/idm/frts/searchFrList",
            insertDiv :"frListPart",
            param : {
                pageIndex: pageIndex,
                singleId : singleId
            }
        });
    }

    function searchTsList(pageIndex){
        var singleId = $("#singleId").val();
        $.loadHtmlByUrl({
            url : "/idm/frts/searchTsList",
            insertDiv :"tsListPart",
            param : {
                pageIndex: pageIndex,
                singleId : singleId
            }
        });
    }

    function deleteFr(flag){
    	var index = layer.confirm("确定删除？", {icon:2, title:'确认提示'}, function(){
            var subId = $("#subId").val();
            $("#frForm").submitFormGetJson({
                url : "/idm/frts/deleteFr",
                param:{
                    id:subId
                },
                callback : function(data) {
                    if (data.indexOf("fail") > -1) {
                        layui.use('layer', function() {
                        	var layer = layui.layer;
                        	layer.alert("删除失败！", {icon:0,title:'提示'});
                        });
                    }else {
                        layui.use('layer', function() {
                        	var layer = layui.layer;
                        	layer.alert("删除成功！", {icon:0,title:'提示'});
                        });
                        frSelected();
                        return false;
                    }
                }
            });
            layer.close(index);
        });
    }

    function deleteTs(flag){
    	var index = layer.confirm("确定删除？", {icon:2, title:'确认提示'}, function(){
            var subId = $("#subId").val();
            $("#ccForm").submitFormGetJson({
                url : "/idm/frts/deleteTs",
                param:{
                    id:subId
                },
                callback : function(data) {
                    if (data.indexOf("fail") > -1) {
                        layui.use('layer', function() {
                        	var layer = layui.layer;
                        	layer.alert("删除失败！", {icon:0,title:'提示'});
                        });
                    }else {
                        layui.use('layer', function() {
                        	var layer = layui.layer;
                        	layer.alert("删除成功！", {icon:0,title:'提示'});
                        });
                        tsSelected();
                        return false;
                    }
                }
            });
            layer.close(index);
        });
    }

    return {
        selectTag : selectTag,
        caseSelected : caseSelected,
        frSelected : frSelected,
        tsSelected : tsSelected,
        searchFrList : searchFrList,
        searchTsList : searchTsList,
        saveFr : saveFr,
        initAdd : initAdd,
        clickRow : clickRow,
        saveTs : saveTs,
        deleteFr : deleteFr,
        deleteTs : deleteTs
    };
})();
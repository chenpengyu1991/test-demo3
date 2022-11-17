var cardEdit = (function() {
	var validate=null;
	$(function() {
		 validate = $("#cardForm").easyValidate();
		 var endProcedure = schCommon.checkEndProcedure();
		 if(endProcedure){
				$("#cardForm").diabaleForm();
				$('#diagnosisDtId').removeAttr("onfocus");
		 }
		 enableChangeConfirm();
        $("#addCr").click(function(e) {
            e.preventDefault();
            $.post(contextPath+"/idm/schistosome/advanced/card/addcr",
                { indexPage : 1
                },
                function(ret){
                    layui.use(['layer'], function() {
                        var layer = layui.layer
                        layer.open({
                            type:1,
                            id:'crDialog',
                            area: ['700px', '250px'],
                            title:'新增信息变更',
                            content: ret
                        });
                    });
                });
        });
        $("#addRr").click(function(e) {
            e.preventDefault();
            $.post(contextPath+"/idm/schistosome/advanced/card/addrr",
                { indexPage : 1
                },
                function(ret){
                    layui.use(['layer'], function() {
                        var layer = layui.layer
                        layer.open({
                            type:1,
                            id:'rrDialog',
                            area: ['800px', '350px'],
                            title:'新增治疗救助',
                            content: ret
                        });
                    });
                });
        });
        
        $("#manageCardReturn").click(function(e) {
        	e.preventDefault();
        	returnSearch();
        });

        $("#manageCardSave").click(function(e) {
            e.preventDefault();
            cardSubmit();
        });
        idmCommon.displayPaAddress();
        idmCommon.toggerAddress();
        schCommon.diabaleForm('cardForm');
	});

	function returnSearch(){
        // if(contentChanged){
      	layer.confirm("确认离开？", {icon:1, title:'确认提示'}, function(index){
                layer.close(index);
                search();
            });
        // }else{
        // 	search();
        // }
	}
    function search(){
        disableChangeConfirm();
        $("#advanceddetailDiv").empty();
        var pageIndex = $("#pageIndex").val();
        advancedSearch.search(pageIndex);
        $("#advanced_top_all").show();
    }
    
    /*
     * 变更信息子画面弹出
     * */
    function popupCr(btn, type){
        var param = '';
        if("edit" == type){
            var extendDiv = btn.parentNode.parentNode;
            var rowIndex = extendDiv.rowIndex;
            var trData = {};
            $(extendDiv).find("td").each(function(tdindex,tditem){
                var inputValue = $(tditem).text();
                inputValue = inputValue.replace(/\t/g,'');//制表符替换
                inputValue = inputValue.replace(/\n/g,'');//换行替换                
                if('' != inputValue){
                    trData[$(this).attr("field")] = inputValue;
                }
            });
            var trDataStr =  "[" + util.Obj2str(trData) + "]";
            param = {trData:trDataStr, rowIndex:rowIndex, type:'edit'};
        }
        $.post(contextPath+"/idm/schistosome/advanced/card/addcr",
            param,
            function(ret){
                layui.use(['layer'], function() {
                    var layer = layui.layer
                    layer.open({
                        type:1,
                        id:'crDialog',
                        area: ['700px', '250px'],
                        title:'新增信息变更',
                        content: ret
                    });
                });
            });
    } 
 
    /*
     * 治疗记录子画面弹出
     * */
    function popupRr(btn, type){
        var param = '';
        if("edit" == type){
            var extendDiv = btn.parentNode.parentNode;
            var rowIndex = extendDiv.rowIndex;
            var trData = {};
            $(extendDiv).find("td").each(function(tdindex,tditem){
                var inputValue = $(tditem).text();
                inputValue = inputValue.replace(/\t/g,'');//制表符替换
                inputValue = inputValue.replace(/\n/g,'');//换行替换                  
                if('' != inputValue){
                    trData[$(this).attr("field")] = inputValue;
                }
            });
            var trDataStr =  "[" + util.Obj2str(trData) + "]";
            param = {trData:trDataStr, rowIndex:rowIndex, type:'edit'};
        }
        $.post(contextPath+"/idm/schistosome/advanced/card/addrr",
            param,
            function(ret){
                layui.use(['layer'], function() {
                    var layer = layui.layer
                    layer.open({
                        type:1,
                        id:'rrDialog',
                        area: ['800px', '350px'],
                        title:'新增治疗救助',
                        content: ret
                    });
                });
            });
    } 
    /*
     * 管理卡提交保存
     * */
    function cardSubmit(){
    	var result=validate.validateForm();
    	if(!result){
    		return;
    	} 
    	formatDate();
    	var idmId = $('#idmId').val();
    	var crTableData = util.Obj2str(idmCommon.getTablesData('crTable', [], [], idmId));
    	var rrTableData = util.Obj2str(idmCommon.getTablesData('rrTable', [], [], idmId));
    	$("#listCrJsonId").val(crTableData);
    	$("#listRrJsonId").val(rrTableData);
		$("#cardForm").submitFormGetJson({
			url : "/idm/schistosome/advanced/card/save",
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("管理卡保存失败！", {icon:0,title:'提示'});
                }else {
                    layer.alert("管理卡保存成功！", {icon:0,title:'提示'});
                    search();
                    return false;
                }
            },
            wait:true
		});    	
    }
    function formatDate(){
        var diagnosisDt =  $('#diagnosisDtId').val();
        if(!$.isEmpty(diagnosisDt)){
            diagnosisDt = diagnosisDt + '/01';
            $('#diagnosisDtId').val(diagnosisDt);
        } 
    }    
 	return {
 		returnSearch:returnSearch,
 		popupCr:popupCr,
 		popupRr:popupRr,
 		cardSubmit:cardSubmit
	};
})();
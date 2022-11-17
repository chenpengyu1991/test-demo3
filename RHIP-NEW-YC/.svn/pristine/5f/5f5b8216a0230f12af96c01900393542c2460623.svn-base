var items = (function() {
	$(function() {
		$("#returnItembtnId").click(returnSearch);
		$("#xinzeng").click(initAddItem);
		$("#xiugai").click(updateItem);
		$("#baocun").click(saveItem);
		$("#shanchu").click(deleteItem);
        $("#kaiqixiugai").click(startUpdateItem );
        $("#kaiqibaocun").click(startSurvey);
	});
	
	function initSurveyItem() {
        $("#top_allSurvey").hide();
        var pageIndex = $("#pageIndex").val();
        pageIndex = ($.isEmpty(pageIndex)? 1 : pageIndex);
        
        $.loadHtmlByUrl({
            url : "/survey/item/add",
            insertDiv :"nextDetailDivSurvey",
            param : {
				surveyId : $("#surveyIdItem").val(),
                type: $("#typeId").val(),
                surveyStatus: $("#surveyStatusId").val()
			}
        });
		$("#detailDivSurvey").hide();
		$("#nextDetailDivSurvey").show();
	};
	
	function searchSurveyItem(pageIndex){
        $.loadHtmlByUrl({
            url : "/survey/surveyItems",
            insertDiv :"surveyItemsList",
            wait : true,
            param : {
            	surveyId: $("#surveyId").val(),
                pageIndex: pageIndex
            }
        });
        $("#detailDivStandardization").show();
    }
	
    function initAddItem(){
        $("#itemFormId").find("input[type=text]").each(function(){
            $(this).val('');
        });
        $("#itemFormId").find("input[type=radio]").each(function(){
            $(this).attr("checked",false);
        });
        $("#itemFormId").find("input[type=checkbox]").each(function(){
            $(this).attr("checked",false);
        });
        $("#itemFormId").find("select").each(function(){
            $(this).val('');
        });
        $("#optionTable tbody").remove();
        
        $("#xinzeng").hide();
        $("#xiugai").hide();
        $("#kaiqixiugai").hide();
        $("#shanchu").hide();
        if($("#surveyStatusId").val() == '0') {
            $("#kaiqibaocun").show();
        }
        $("#baocun").show();
    }


    function startSurvey() {
        $("#surveyStatusId").val("2");
        saveItem();
    }

    function saveItem(){
        var validate=null;
        validate = $("#itemFormId").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        $("#optionListJson").val(util.Obj2str(idmCommon.getTablesData('optionTable', [], [], '')));
        $("#itemFormId").submitFormGetJson({
            url : contextPath + "/survey/item/save",
            wait : true,
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("保存失败！", {icon:0,title:'提示'});
                }else {
                    layer.alert("保存成功！", {icon:0,title:'提示'});
                    initSurveyItem();
                    return false;
                }
            }
        });
    }

    function clickRow(selectRow){
        var id = $(selectRow).attr("id");
        var type = $("#typeId").val();
        $.loadHtmlByUrl({
            url : "/survey/itemDetail",
            insertDiv :"itemDiv",
            param : {
                id: id,
                type : type
            },
            callback: function() {
                $("#xinzeng").show();
                $("#xiugai").show();
                $("#shanchu").show();
                if($("#surveyStatusId").val() == '0') {
                    $("#kaiqixiugai").show();
                }
                $("#kaiqibaocun").hide();
                $("#baocun").hide();
            }
        });

    }

    function searchPollText(indexPage){
    	var type = $("#typeId").val();
        $.loadHtmlByUrl({
            url : "/survey/pollTextList",
            insertDiv :"itemDiv",
            /*wait : true,*/
            param : {
            	itemId: $("#itemId").val(),
            	indexPage: indexPage,
            	type : type
            }
        });
    }
    
    function optionDeleteRefresh(){
        var id = $("#itemId").val();
        $.loadHtmlByUrl({
            url : "/survey/itemDetail",
            insertDiv :"itemDiv",
            param : {
                id: id
            },
            callback: function() {
                $("#xinzeng").show();
                $("#xiugai").show();
                $("#shanchu").show();
                if($("#surveyStatusId").val() == '0') {
                    $("#kaiqixiugai").show();
                }
                $("#kaiqibaocun").hide();
                $("#baocun").hide();
            }
        });

    }
    
    function deleteItem(){
    	layui.use('layer', function(){
    		var layer = layui.layer;
    		layer.confirm('确定删除该调查项？', {icon:2, title:'确认提示'}, function(index){
    			$("#itemFormId").submitFormGetJson({
                    url : "/survey/deleteItem",
                    wait : true,
                    param:{
                        id: $("#itemId").val()
                    },
                    callback : function(data) {
                        if (data.indexOf("fail") > -1) {
                        	layer.alert("删除失败！", {icon:0,title:'提示'});
                        }else {
                            layer.alert("删除成功！", {icon:0,title:'提示'}, function(index2) {
                            	searchSurveyItem(1);
                                initAddItem();
                            	layer.close(index2);
                            });
                        }
                    }
                });
    			layer.close(index);
    		});
    	});
    }

    function optionDelete(id) {
    	layui.use('layer', function(){
    		var layer = layui.layer;
    		layer.confirm('你确定要删除此条数据吗？', {icon:2, title:'确认提示'}, function(index){
    			$("#itemFormId").submitFormGetJson({
                    url : "/survey/deleteOption",
                    wait : true,
                    param:{
                        id: id
                    },
                    callback : function(data) {
                        if (data.indexOf("fail") > -1) {
                        	layer.alert("删除失败！", {icon:0,title:'提示'});
                        }else {
                            layer.alert("删除成功！", {icon:0,title:'提示'}, function(index2) {
                            	optionDeleteRefresh();
                            	layer.close(index2);
                            });
                        }
                    }
                });
    			layer.close(index);
    		});
    	});
    }
    
    function startUpdateItem() {
        $("#surveyStatusId").val("2");
        updateItem();
    }

    function updateItem(){
        var validate=null;
        validate = $("#itemFormId").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        $("#optionListJson").val(util.Obj2str(idmCommon.getTablesData('optionTable', [], [], '')));
        $("#itemFormId").submitFormGetJson({/*itemFormId*/
            url : "/survey/updateItem",
            wait : true,
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("修改失败！");
                }else {
                    layer.alert("修改成功！");
                    initSurveyItem();
                    return false;
                }
            }
        });
    }
    
    function popup(btn, type){
    	var itemId = $("#itemId").val();
        var param = '';
        var labelTypeCode = $("input[name='labelTypeCode']:visible:checked").val();

        if("edit" == type){
            var extendDiv = btn.parentNode.parentNode;
            var rowIndex = extendDiv.rowIndex;
            var trData = {};
            $(extendDiv).find("td").each(function(tdindex,tditem){
                var inputValue = $.trim($(tditem).text());
                if('' != inputValue){
                    trData[$(this).attr("field")] = inputValue;
                }
            });
            var trDataStr =  "[" + util.Obj2str(trData) + "]";
            param = {trData:trDataStr, rowIndex:rowIndex, type:'edit',itemId:itemId,labelTypeCode:labelTypeCode};
        } else {
        	 param = {itemId:itemId,labelTypeCode:labelTypeCode};
        }
        
        var eddDialog = {
            url : "/survey/option/add",
            height : 280,
            width : 800,
            title : "添加选项",
            id :"optionDialog",
            param:param
        };
        $.dialog(eddDialog);
    }
    
    function closePopUp(){
        $.removeDialog ('optionDialog');
    }
    
    function saveOptionData(type,rowIndex){
        var validate = $("#addOptionForm").easyValidate();
        var result = validate.validateForm();
        if(!result){
            return;
        }
        var html = fillOptionRowData();
        if('edit' == type){
            html = html.replace("</tr>", "");
            html = html.replace("<tr>", "");
            $("#optionTable tr").eq(rowIndex).html(html);
        }else{
            $("#optionTable").append(html);
        }
        closePopUp();
    }

    function fillOptionRowData(){
        var obj = idmCommon.getPopObj('popOptionTable');
        var showFields = ['item', 'value', 'isDefaultValue'];
        var hideFields = ['id', 'itemId', 'isDefault'];
        if(obj.isDefault=='1') {
            obj.isDefault='否';
        } else {
            obj.isDefault='是';
        }
        var showValues = [obj.item, obj.value, obj.isDefault];
        var hideValues = [obj.id, obj.itemId, obj.isDefault];
        var editMethod = "items.popup(this, 'edit')";
      
        return idmCommon.generateTrHtml(showFields, hideFields, showValues, hideValues, editMethod);
    }
    
    function returnSearch(){
		if(contentChanged){
			msgUtil.backConfirm(function(){
				$("#detailDivSurvey").show();
		        $("#nextDetailDivSurvey").hide();
		        $("#top_allSurvey").hide();
			});
		}else{
			$("#detailDivSurvey").show();
	        $("#top_allSurvey").hide();
	        $("#nextDetailDivSurvey").hide();
		}
	}
    
	return {
		clickRow: clickRow,
		popup: popup,
		searchSurveyItem: searchSurveyItem,
		saveOptionData: saveOptionData,
		closePopUp: closePopUp,
		searchPollText : searchPollText,
        optionDelete: optionDelete
	};
})();

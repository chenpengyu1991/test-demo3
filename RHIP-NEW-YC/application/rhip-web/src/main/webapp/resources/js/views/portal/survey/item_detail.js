/**
 * Created by haiyingjiang on 15/8/24.
 */
var itemDetail = (function() {
    $(function() {
        isShowOption();
    });

    /**
     * 标签类型若为Text 则不需要显示添加option的div
     */
    function isShowOption() {
        var labelTypeCode = $("input[name='labelTypeCode']:visible:checked").val();
        if(labelTypeCode == 'text') {
            $("#optionDivId").hide();
        } else {
            $("#optionDivId").show();
        }
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

    function OptionDelete(id) {
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
        var isDefaultValue = '';
        var showFields = ['value', 'item', 'isDefaultValue'];
        var hideFields = ['id', 'itemId', 'isDefault'];
        if(obj.isDefault=='1') {
            isDefaultValue='否';
        } else {
            isDefaultValue='是';
        }
        var showValues = [obj.value, obj.item, isDefaultValue];
        var hideValues = [obj.id, obj.itemId, obj.isDefault];
        var editMethod = "items.popup(this, 'edit')";
        return idmCommon.generateTrHtml(showFields, hideFields, showValues, hideValues, editMethod);
    }

    return {
        popup: popup,
        saveOptionData: saveOptionData,
        closePopUp: closePopUp,
        isShowOption: isShowOption
    };
})();


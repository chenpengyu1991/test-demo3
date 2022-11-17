var followup = (function() {
	var singleIdTemp = '';
	
	$(function() {
        toggleOther('leprosy','leprosyType','1');
		search(1);
        $("#followupBtnSearch").click(function() {
            search(1);
        });
        
        $("#followupSearchForm").onEnter(search, 1);
	});
	
	function search(indexPage) { 
		var searchObj = {
				url : "/idm/leprosy/followup/list",
//                wait : true,
				insertDiv : "listDivFollowup",
				param : {
					indexPage : indexPage
				}
			};
		$("#followupSearchForm").submitFormLoadHtml(searchObj);
	};
	
	function searchTemp(pageIndex){
		if($.isEmpty(pageIndex)) {
			 pageIndex = $("#pageIndex").val();
		}
		disableChangeConfirm();
		$("#detailDivFollowup").empty();
		pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
		search(pageIndex);
		$("#top_allFollowup").show();		
	}	
	
	function initFrs(singleId, logoff) {
		singleIdTemp = singleId;
        $("#top_allFollowup").hide();
        var pageIndex = $("#currentPageFollowup").val();
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        $.loadHtmlByUrl({
            url : "/idm/leprosy/initFollowup",
//            wait : true,
            insertDiv :"detailDivFollowup",
            param : {
                singleId: singleId,
                logoff: logoff,
                pageIndex: pageIndex
            }
        });
        $("#detailDivFollowup").show();
	};
	
	function initFrsTemp(singleId, diagnosis) {
		singleIdTemp = singleId;
        $("#top_allFollowup").hide();
        var pageIndex = $("#currentPageFollowup").val();
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        $.loadHtmlByUrl({
            url : "/idm/leprosy/initFollowup",
            wait : true,
            insertDiv :"detailDivFollowup",
            param : {
                singleId: singleId,
                pageIndex: pageIndex
            },
            callback:function() {
            	 if(diagnosis == '5' || diagnosis == '6') {
                 	$("#xinzeng").hide();
                     $("#xiugai").hide();
                     $("#shanchu").hide();
                     $("#baocun").hide();
                 }
            }
        });
        $("#detailDivFollowup").show();
	};
	
	function addFr(){
        var validate=null;
        validate = $("#frForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        $("#listCcJson").val(util.Obj2str(idmCommon.getTablesData('contanctTable', [], [], '')));
        $("#frForm").submitFormGetJson({
            url : "/idm/leprosy/followup/save",
            wait : true,
            callback : function(data) {
            	
                if (data.indexOf("fail") > -1) {
                    layer.alert("保存失败！", {icon:0,title:'提示'});
                }else {
                    layer.alert("保存成功！", {icon:0,title:'提示'});
                    initFrs(singleIdTemp,'');
                    return false;
                }
            }
        });
    }

    function clickRow(selectRow){
        var id = $(selectRow).attr("id");
        $.loadHtmlByUrl({
            url : "/idm/leprosy/followupDetail",
//            wait : true,
            insertDiv :"detailDiv",
            param : {
                id: id
            },
            callback:function() {
            	$("#xinzeng").show();
                $("#xiugai").show();

                $("#shanchu").show();
                $("#baocun").hide();
           }
        });
    }
    
    function deleteFr(){
    	var index = layer.confirm("确定删除该接触者？", {icon:2, title:'确认提示'}, function(){
            var frId = $("#frId").val();
            var singleId = $("#singleIdFollow").val();
            wait : true,
            $("#frForm").submitFormGetJson({
                url : "/idm/leprosy/deleteFollowup",
                param:{
                    id:frId
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
                        initFrs(singleId,'');
                        return false;
                    }
                }
            });
            layer.close(index);
        });
    }

    function updateFr(){
        var validate=null;
        validate = $("#frForm").easyValidate();
        $("#listCcJson").val(util.Obj2str(idmCommon.getTablesData('contanctTable', [], [], '')));
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var singleId = $("#singleIdFollow").val();
        $("#frForm").submitFormGetJson({
            url : "/idm/leprosy/followupUpdate",
            wait : true,
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("修改失败！", {icon:0,title:'提示'});
                }else {
                    layer.alert("修改成功！", {icon:0,title:'提示'});
                    initFrs(singleId,'');
                    return false;
                }
            }
        });
    }

    function initAddFr(nowDate){
    	var singleId = $("#singleIdFollow").val();
        $("#frForm").find("input[type=text]").each(function(){
            $(this).val('');
        });
        $("#frForm").find("input[type=radio]").each(function(){
            $(this).attr("checked",false);
        });
        $("#frForm").find("input[type=checkbox]").each(function(){
            $(this).attr("checked",false);
        });
        $("#frForm").find("select").each(function(){
            $(this).val('');
        });
        $(".listtrselect").removeClass("listtrselect");
        $("#xiugai").hide();
        $("#xinzeng").hide();
        $("#shanchu").hide();
        $("#baocun").show();
        $("#singleIdFollow").val(singleId);
        $("input[name='diagnosis']").val('7');
        $("input[name='diagnosis']").attr("checked",true);
        toggleOther('leprosy','leprosyType','1');
        $("input[name='visitDt']").val(nowDate);
    }
    
    function searchFollowList(pageIndex) {
    	if($.isEmpty(pageIndex)) {
			 pageIndex = $("#pageIndex").val();
		}
    	$.loadHtmlByUrl({
            url : "/idm/leprosy/followupList",
            insertDiv :"followupsList",
            wait : true,
            param : {
                singleId: singleIdTemp,
                pageIndex: pageIndex
            }
        });
    }
    
    function popup(btn, type, followupId){
        var param = '';
        if("edit" == type){
            var extendDiv = btn.parentNode.parentNode;
            var rowIndex = extendDiv.rowIndex;
            var trData = {};
            $(extendDiv).find("td").each(function(tdindex,tditem){
                var inputValue = $(tditem).text();
                if('' != inputValue){
                    trData[$(this).attr("field")] = inputValue;
                }
            });
            var trDataStr =  "[" + util.Obj2str(trData) + "]";
            param = {trData:trDataStr, rowIndex:rowIndex, type:'edit',followupId:followupId};
        } else {
        	 param = {followupId:followupId};
        }
        
        var eddDialog = {
            url : "/idm/leprosy/followup/contact/add",
            height : 280,
            width : 800,
            title : "密切接触者（家属）健康检查",
            id :"contactDialog",
            param:param
        };
        $.dialog(eddDialog);
    }
    
    function saveCcData(type,rowIndex){
        validate = $("#contactForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        debugger;
        var html = fillCcRowData();
        if('edit' == type){
            html = html.replace("</tr>", "");
            html = html.replace("<tr>", "");
            $("#contanctTable tr").eq(rowIndex).html(html);
        }else{
            $("#contanctTable").append(html);
        }
        
        idmCommon.closePopUp('contactDialog');
    }

    function fillCcRowData(){
    	var obj = idmCommon.getPopObj('popContactTable');
    	var sexText="";
		if(obj.sex == '1'){
			sexText = "男";
		}else{
			sexText = "女";
		}
		var diagnosisResultText="";
		if(obj.diagnosisResult == '1'){
			diagnosisResultText = "排除麻风";
		} else if(obj.diagnosisResult == '2') {
			diagnosisResultText = "疑似麻风";
		} else {
			diagnosisResultText = "麻风";
		}
		var closeDetailText="";
		if(obj.closeType == '1'){
			closeDetailText = $("#closeDetail").find("option:selected").text();
		}else{
			closeDetailText = $("#checkSympton").find("option:selected").text();
		}
		if(closeDetailText == "请选择"){ 
			closeDetailText = "";
		}
        var showFields = ['closeName', 'sexText', 'birthday', 'closeDetailText', 'closeMonths', 'closeFrequency', 'diagnosisResultText'];
        var hideFields = ['sex', 'diagnosisResult','closeType', 'closeDetail', 'checkSympton'];
        var showValues = [obj.closeName, sexText, obj.birthday, closeDetailText, obj.closeMonths, obj.closeFrequency, diagnosisResultText];
        var hideValues = [obj.sex, obj.diagnosisResult,obj.closeType, $("#closeDetail").find("option:selected").val(), $("#checkSympton").find("option:selected").val()];
        var editMethod = "followup.popup(this, 'edit','')";
        return idmCommon.generateTrHtml(showFields, hideFields, showValues, hideValues, editMethod);
    }
    
    function changeType(radioName){
        var raValue = $('input[name="' + radioName+ '"]:checked').val();
        if(raValue == 1){
            $("#closeDetailId").show();
            $("#checkSymptonId").hide();
        }else if(raValue == 2){
            $("#closeDetailId").hide();
            $("#checkSymptonId").show();
        }
    }
    
	return {
        search: search,
        searchTemp : searchTemp,
        initFrs: initFrs,
        addFr: addFr,
        clickRow: clickRow,
        deleteFr: deleteFr,
        updateFr: updateFr,
        initAddFr: initAddFr,
        searchFollowList: searchFollowList,
        popup: popup,
        saveCcData: saveCcData,
        changeType: changeType
	};
	
})();

$(document).ready(function () { 
	//按钮样式切换 
	$("#followupBtnSearch").hover( 
		function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
		}, 
		function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
		} 
	); 

});
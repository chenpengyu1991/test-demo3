var ndyFuyao = (function() {
	var title = "";
	$(function() { 
        search(1);
        $("#ndyFuyaoBtnSearch").click(function(e) {
            e.preventDefault();
        	search(1);
        });
        $("#check-submit-btnNdy2").on("click", function (e) {
            e.preventDefault();
        	StartRead();
        });
        $("#ndyFuyaoSearch").onEnter(search, 1);
        
	});
    function StartRead()//开始读卡
    {
        if (GT2ICROCX.GetState() == 0){
            GT2ICROCX.ReadCard()
        }

        //GT2ICROCX.ReadCard() //循环读卡
        $("#idCardNdy2").val(GT2ICROCX.CardNo);
    }
    function ndyQz(id){
    	layui.use('layer', function(){
    		var layer = layui.layer;
    		layer.confirm("确认此人是耐多药患者?", {icon:1, title:'确认提示'}, function(index) {
	            $.getJsonByUrl({
	                url : "/idm/tb/ndy/confirm/" + id,
	                callback : function(data) {
	                    if (data.result)
	                    {
	                        search(1);
	                    } else
	                    {
	                    	layer.alert("操作失败！", {icon:0,title:'提示'});
	                    }
	                }
	            });
	            layer.close(index);
	    	});
	    });		
    }
	function search(indexPage) {
		var searchObj = {
				url : "/idm/tb/ndy/list",
				insertDiv : "listDivNdyFuyao",
//                wait : true,
				param : {
					indexPage : indexPage,
                    fuyao : "1"
				}
			};
        $("#ndyFuyaoSearchForm").submitFormLoadHtml(searchObj);
	};
	
	function searchTemp(pageIndex){
		if($.isEmpty(pageIndex)) {
			 pageIndex = $("#pageIndex").val();
		}
		disableChangeConfirm();
		$("#detailDivNdy").empty();
		pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
		search(pageIndex);
		$("#top_allNdy").show();
	}	
	
	function initChild(singleId, logoff) {
		$("#top_allStandardization").hide();
		var pageIndex = $("#currentPageStandardization").val();
		$.loadHtmlByUrl({
			url : "/idm/tb/ndy/init",
			insertDiv :"detailDivNdy",
//            wait : true,
			param : {
				pageIndex: pageIndex,
				singleId: singleId,
				logoff: logoff
			}
		});
		$("#detailDivNdy").show();
	}

    function initFuwuChild(singleId, logoff) {
        $("#top_allStandardization").hide();
        var pageIndex = $("#currentPageStandardization").val();
        $.loadHtmlByUrl({
            url : "/idm/tb/management/initFuwu",
            insertDiv :"detailDivNdy",
//            wait : true,
            param : {
                pageIndex: pageIndex,
                singleId: singleId,
                logoff: logoff
            }
        });
        $("#detailDivNdy").show();
    }

    function initDrug(singleId,patientName, logoff) {
        $("#top_allStandardization").hide();
        var pageIndex = $("#currentPageStandardization").val();
        $.loadHtmlByUrl({
            url : "/idm/tb/management/initDrug",
            insertDiv :"detailDivNdy",
//            wait : true,
            param : {
                pageIndex: pageIndex,
                singleId: singleId,
                logoff: logoff,
                patientName:patientName
            }
        });
        $("#detailDivNdy").show();
    }

    function initNdyDrug(singleId,patientName, logoff,type,drugCardId) {
        var url = "/idm/tb/ndy/initNdyList";
        if('add' == type||'edit'==type)
            url = "/idm/tb/management/initNdyDrug";
        $("#top_allStandardization").hide();
        var pageIndex = $("#currentPageStandardization").val();
        $.loadHtmlByUrl({
            url : url,
            insertDiv :"detailDivNdy",
//            wait : true,
            param : {
                pageIndex: pageIndex,
                singleId: singleId,
                logoff: logoff,
                patientName:patientName,
                drugCardId:drugCardId
            }
        });
        $("#detailDivNdy").show();
    }

	function saveChild(type,methodName) {
		var searchTemp = eval(methodName);
		$("#listFrJson").val(util.Obj2str(idmCommon.getTablesData('frTable', [], [], '')));
		$("#listDdJson").val(util.Obj2str(idmCommon.getTablesData('ddTable', [], [], '')));
		$("#listSdJson").val(util.Obj2str(idmCommon.getTablesData('sdTable', [], [], '')));
		
		$("#tbFormList").submitFormGetJson({
			url : '/idm/tb/management/save',
            wait : true,
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                	layer.alert("保存失败！", {icon:0,title:'提示'});
                }else {
                	layer.alert("保存成功！", {icon:0,title:'提示'});
                    //close(typeTb);
                    searchTemp();
                }
            }
		});
	}
	/*
	function close(typeTb) {
		if(typeTb == "1") {
			 idmCommon.closePopUp('sdDialog');
		} else if(typeTb == "3") {
			 idmCommon.closePopUp('frDialog');
		} else if(typeTb == "4") {
			 idmCommon.closePopUp('ddDialog');
		}
	}*/
	
	function popup(btn, type, tableId,singleId){
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
            param = {trData:trDataStr, rowIndex:rowIndex, type:'edit',singleId:singleId};
        } else {
        	 param = {singleId:singleId};
        }
        
        var eddDialog = {
            url : "/idm/tb/management/add",
            height : 480,
            width : 800,
            title : getTitle(tableId),
            id :tableId+"Dialog",
            param:param
        };
        $.dialog(eddDialog);
    }

    function popupEdit(id,singleId,tableId){
        param = {id:id,singleId:singleId};
        var eddDialog = {
            url : "/idm/tb/management/edit",
            height : 480,
            width : 800,
            title : getTitle(tableId),
            id :tableId+"Dialog",
            param:param
        };
        $.dialog(eddDialog);
    }

    function trDiscontinued(statusId,singleId,tableId){
        param = {statusId:statusId,singleId:singleId};
        var eddDialog = {
            url : "/idm/tb/management/trDiscontinued",
            height : 480,
            width : 800,
            title : getTitle(tableId),
            id :tableId+"Dialog",
            param:param
        };
        $.dialog(eddDialog);
    }

    //服务记录删除
    function delFw(id){
    	layui.use('layer', function(){
    		var layer = layui.layer;
    		layer.confirm("你确定要删除此条数据吗？", {icon:2, title:'确认提示'}, function(index){
	            $.getJsonByUrl({
	                url : "/idm/tb/management/deleteServiceRecord/" + id,
	                callback : function(data) {
	                    if (data.result)
	                    {
	                        var idmId = $("#idmId").val();
	                        initFuwuChild(idmId,'0');
	                    } else
	                    {
	                    	layer.alert("删除失败！", {icon:0,title:'提示'});
	                    }
	                }
	            });
	            layer.close(index);
    		});
    	});		
    }

    //耐多药服药记录删除
    function delNdy(drugId,idmId,patName,logoff){
    	layui.use('layer', function(){
    		var layer = layui.layer;
    		layer.confirm("你确定要删除此条数据吗？", {icon:2, title:'确认提示'}, function(index){
	            $.getJsonByUrl({
	                url : "/idm/tb/management/deleteNdy/" + drugId+"/"+idmId,
	                callback : function(data) {
	                    if (data.result)
	                    {
	                        initNdyDrug(idmId,patName,logoff);
	                    } else
	                    {
	                    	layer.alert("删除失败！", {icon:0,title:'提示'});
	                    }
	                }
	            });
	            layer.close(index);
	    	});
	    });		
    }

	function getTitle(tableId) {
		if(tableId == "sd") {
			title = "督导服药";
		} else if(tableId == "fr") {
			title = "访视记录";
		} else if(tableId == "dd") {
			title = "用药延误记录";
		}else if(tableId == "fw") {
            title = "随访记录";
        }else if(tableId == "trd") {
            title = "随访记录-停止治疗";
        }
		return title;
	}
	
    function saveFrData(type,rowIndex){
        validate = $("#addFrForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var html = fillFrRowData();
        if('edit' == type){
            html = html.replace("</tr>", "");
            html = html.replace("<tr>", "");
            $("#frTable tr").eq(rowIndex).html(html);
        }else{
            $("#frTable").append(html);
        }
        idmCommon.closePopUp('frDialog');
    }

    function fillFrRowData(){
        var obj = idmCommon.getPopObj('popFrTable');
        var showFields = ['visitDt', 'visitContent', 'visitInstStr', 'visitByIdStr'];
        var hideFields = ['idmId', 'visitInst', 'visitById'];
        var showValues = [obj.visitDt, obj.visitContent, obj.visitInstStr, obj.visitByIdStr];
        var hideValues = [obj.idmId, obj.visitInst, obj.visitById];
        var editMethod = "standardization.popup(this, 'edit','fr'," + obj.idmId + ")";
      
        return idmCommon.generateTrHtml(showFields, hideFields, showValues, hideValues, editMethod);
    }
    
    function saveDdData(type,rowIndex){
        validate = $("#addDdForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var html = fillDrRowData();
        if('edit' == type){
//            var rowIndex = $("#rowIndex").val();
            html = html.replace("</tr>", "");
            html = html.replace("<tr>", "");
            $("#ddTable tr").eq(rowIndex).html(html);
        }else{
            $("#ddTable").append(html);
        }
        idmCommon.closePopUp('ddDialog');
    }
    
    function fillDrRowData(){
        var obj = idmCommon.getPopObj('popDdTable');
        var showFields = ['recordDate', 'repairTreatNumber', 'brokenNum', 'leakageNum','leakageReason'];
        var hideFields = ['idmId'];
        var showValues = [obj.recordDate, obj.repairTreatNumber, obj.brokenNum, obj.leakageNum, obj.leakageReason];
        var hideValues = [obj.idmId];
        var editMethod = "standardization.popup(this, 'edit','dd'," + obj.idmId + ")";
        return idmCommon.generateTrHtml(showFields, hideFields, showValues, hideValues, editMethod);
    }

    function saveServiceRecord(){
        $("#addFrForm").submitFormGetJson({
            url : "/idm/tb/management/saveServiceRecord",
            callback : submitCallback
        });
    }

    function submitCallback(data) {
        if (data.result) {
        	layer.alert('保存成功!', {icon:0,title:'提示'}, function(index) {
                /*$.removeDialog("healthEducationResource");
                 healthEducationResourceSearch.search(1);*/
                var idmId = $("#idmId").val();
                initFuwuChild(idmId,'0');
                idmCommon.closePopUp('fwDialog');
                layer.close(index);
            });
        } else {
        	layer.alert(data.message, {icon:0,title:'提示'});
        }
    }

    function saveDiscontinued(){
        $("#addFrForm").submitFormGetJson({
            url : "/idm/tb/management/saveDiscontinued",
            callback : saveDiscontinuedCallback
        });
    }

    function saveDiscontinuedCallback(data){
        if (data.result) {
        	layer.alert("保存成功！", {icon:0,title:'提示'}, function(index) {
                idmCommon.closePopUp('trdDialog');
                layer.close(index);
            });
        } else {
        	layer.alert(data.message, {icon:0,title:'提示'});
        }
    }

    function firstVistChange(){
        var selVal = $("#firstVist").val();
        if(selVal==1){
            $("[name='firstTr']").each(function (){
                $(this).show();
            });
            $("[name='firstHide']").each(function (){
                $(this).hide();
            });
        }else if(selVal==2){ //非首次
            $("[name='firstTr']").each(function (){
                $(this).hide();
            });
            $("[name='firstHide']").each(function (){
                $(this).show();
            });
        }
    }
	return {
        search: search,
        searchTemp: searchTemp,
        initChild: initChild,
        popup: popup,
        saveFrData: saveFrData,
        saveDdData: saveDdData,
        saveChild: saveChild,
        initDrug:initDrug,
        initNdyDrug:initNdyDrug,
        initFuwuChild:initFuwuChild,
        saveServiceRecord:saveServiceRecord,
        popupEdit:popupEdit,
        delFw:delFw,
        delNdy:delNdy,
        trDiscontinued:trDiscontinued,
        saveDiscontinued:saveDiscontinued,
        firstVistChange:firstVistChange,
        ndyQz:ndyQz
	};
})();
$(document).ready(function () { 
	//按钮样式切换 
	$("#ndyBtnSearch").hover(
		function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
		}, 
		function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
		} 
	); 

});
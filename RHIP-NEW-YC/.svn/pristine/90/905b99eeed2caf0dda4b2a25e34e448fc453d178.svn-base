var frSearch = (function() {
	$(function() {
        // 高级查询条件显示控制
        $("#perAdvanceSearchConditionBtn").click(function(e) {
            e.preventDefault();
            controlAdvanceSearchSection($(this));
        });

        $("#check-submit-btn").on("click", function () {
            StartRead();
        });
        $("#frSearchButton").on("click", function (e) {
        	e.preventDefault();
        	search(1);
        });
        search(1);
        $("#reportSearchForm").onEnter(search, 1);
//        queryInfection();
	});

    // 组合39种疾病的下拉内容
    function queryInfection() {
        $("#infectiousCode").append('<option value="">' + "请选择" + '</option>');

        $.getJsonByUrl({
            url : "/idm/set/queryInfection",
//            wait:true,
            callback : function(data) {
                $.each(data,function(key,values){
                    $("#infectiousCode").append('<option value="'+ key +'">' + values + '</option>');
                });
            }
        });
    };
    function StartRead()//开始读卡
    {
        if (GT2ICROCX.GetState() == 0){
            GT2ICROCX.ReadCard()
        }

        //GT2ICROCX.ReadCard() //循环读卡
        $("#idCard").val(GT2ICROCX.CardNo);
    }

	function search(indexPage) {
        if($.isEmpty(indexPage)){
            indexPage = $.isEmpty($("#pageIndexI").val())?1:$("#pageIndexI").val();
        }
        $("#pageIndex").val(indexPage);
            var searchObj = {
			url : "/idm/frts/frList",
			insertDiv : "caseResultDiv",
			param : {
				indexPage : indexPage
			}
		};
        $("#detailDiv").hide();
        $("#top_all").show();
		$("#reportSearchForm").submitFormLoadHtml(searchObj);
	};

	function add() { 
		var pageIndex = $("#currentPage").val();
		$("#top_all").hide();
		$.loadHtmlByUrl({
			url : "/idm/report/add",
			insertDiv :"detailDiv",
			param : {pageIndex:pageIndex},
            wait : true
		});
		$("#detailDiv").show();
		
	};
	function edit(id) { 
		$("#top_all").hide();
        var pageIndex = $("#currentPage").val();
		$.loadHtmlByUrl({
			url : '/idm/report/edit/'+ id  ,
			insertDiv :"detailDiv",
            param : {pageIndex:pageIndex},
            wait : true
        });
		$("#detailDiv").show();
	};

    function frIndex(id,idmId,infectiousCode,name,type,logoff){
        $("#top_all").hide();
        var pageIndex = $("#currentPage").val();
        $.loadHtmlByUrl({
            url : "/idm/frts/frIndex",
            insertDiv :"detailDiv",
            param : {id:id, idmId:idmId, infectiousCode:infectiousCode, pageIndex:pageIndex,name:name,type:type,logoff:logoff}
        });
        $("#detailDiv").show();

    };

    function initFr(singleId, name , logoff){
        $("#top_all").hide();
//        var idmId = $("#idmIdI").val();
//        var name = $("#nameI").val();
//        var logoff = $("#logoffI").val();

        $.loadHtmlByUrl({
            url : "/idm/frts/initFr",
            insertDiv :"detailDiv",
            param : {singleId:singleId,name:name,logoff:logoff}
        });
        $("#detailDiv").show();
    }

	/*个案填写*/
	function caseAdd(id,idmId,infectiousCode, logoff) {
		$("#top_all").hide();
        var pageIndex = $("#currentPage").val();
		$.loadHtmlByUrl({
			url : "/idm/case/initAdd",
			insertDiv :"caseDetailDiv",
			param : {id:id, idmId:idmId, infectiousCode:infectiousCode, pageIndex:pageIndex, logoff: logoff}
        });
		$("#caseDetailDiv").show();
		
	};
	/*个案编辑*/
	function caseEdit(idmId,infectiousCode, logoff) {
		$("#top_all").hide();
        var pageIndex = $("#currentPage").val();
		$.loadHtmlByUrl({
			url : "/idm/case/initEdit",
			insertDiv :"caseDetailDiv",
			param : {idmId : idmId, infectiousCode:infectiousCode, pageIndex:pageIndex, logoff:logoff},
            wait : true
        });
		$("#caseDetailDiv").show();
	};
	
	function print(id) { 
		$("#top_all").hide();
		$.loadHtmlByUrl({
			url : '/idm/report/print/'+ id  ,
			insertDiv :"detailDiv"
		});
		$("#detailDiv").show();
	};
	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	};

    function returnSearch(){
        var pageIndex = $("#pageIndex").val();
        // $("#detailDiv").empty();
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        // if(contentChanged){
            layui.use('layer', function () {
                var layer = layui.layer;
                var index = layer.confirm('确认离开？', {icon:1, title:'确认提示'}, function (index) {
                    layer.close(index);
                    search(pageIndex);
                });
            });
        // }else{
        //     search(pageIndex);
        // }
    };

    function popupFr(){
        var frDialog = {
            url : "/idm/frts/popFr",
            height : 250,
            width : 800,
            title : "随访记录",
            id :"frDialog"
        };
        $.dialog(frDialog);
    }

    function popupFr(btn, type){
        var param;
        if("edit" == type){
            var extendDiv = btn.parentNode.parentNode;
            var rowIndex = extendDiv.rowIndex;
            var trData = {};
            $(extendDiv).find("td").each(function(tdindex,tditem){
                var inputValue = $(tditem).text()
                if('' != inputValue){
                    trData[$(this).attr("field")] = inputValue;
                }
            });
            var trDataStr =  "[" + util.Obj2str(trData) + "]";
            param = {trData:trDataStr, rowIndex:rowIndex, type:'edit'};
        }
        var ehDialog = {
            url : "/idm/frts/popFr",
            height : 250,
            width : 800,
            title : "随访记录",
            id : "frDialog",
            param:param
        };
        $.dialog(ehDialog);
    }

    function saveFrData(type){
        validate = $("#addFrForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var html = fillFrRowData();
        if('edit' == type){
            var rowIndex = $('#rowIndex').val();
            html = html.replace("</tr>", "");
            html = html.replace("<tr>", "");
            $("#frTable tr").eq(rowIndex).html(html);
        }else{
            $("#frTable").append(html);
        }
        idmCommon.closePopUp('frDialog');
    }

    function fillFrRowData(){
        var frObj = idmCommon.getPopObj('popFrTable');
        frObj['rash'] = getSelectVal('rash');
        frObj['rashStr'] = getSelectText('rash');
        frObj['diseaseProgress'] = getSelectVal('diseaseProgress');
        frObj['diseaseProgressStr'] = getSelectText('diseaseProgress');

        var frShowFields = ['visitDt', 'temperature', 'rashStr', 'otherSymptom', 'diseaseProgressStr', 'transferUnit', 'comments'];
        var frHideFields = ['rash', 'diseaseProgress'];
        var frShowValues = [frObj.visitDt, frObj.temperature, frObj.rashStr, frObj.otherSymptom, frObj.diseaseProgressStr, frObj.transferUnit, frObj.comments];
        var frHideValues = [frObj.rash, frObj.diseaseProgress];
        var editMethod = "frSearch.popupFr(this, 'edit')";
        return idmCommon.generateTrHtml(frShowFields, frHideFields, frShowValues, frHideValues, editMethod);
    }

    function getSelectText(selName) {
        if(!$.isEmpty($("select[name="+selName+"]").find("option:selected").val())){
            return $("select[name="+selName+"]").find("option:selected").text();
        }else{
            return '';
        }
    }

    function getSelectVal(selName) {
        if(!$.isEmpty($("select[name="+selName+"]").find("option:selected").val())){
            return $("select[name="+selName+"]").find("option:selected").val();
        }else{
            return '';
        }
    }

	return {
        search : search,
        returnSearch : returnSearch,
        add:add,
        caseAdd:caseAdd,
        caseEdit:caseEdit,
        print:print,
        edit:edit,
        toggle:toggle,
        frIndex:frIndex,
        initFr:initFr,
        popupFr:popupFr,
        saveFrData:saveFrData
	};
})();

$(document).ready(function () { 
	//按钮样式切换 
	$("#reportBtnSearch").hover( 
		function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
		}, 
		function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
		} 
	); 

});

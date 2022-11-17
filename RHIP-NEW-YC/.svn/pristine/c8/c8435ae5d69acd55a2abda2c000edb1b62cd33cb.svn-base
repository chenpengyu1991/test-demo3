var filStandard = (function () {
    var validate = null;
    $(function () {

        validate = $("#caseForm").easyValidate();
        // searchFollowup();

        $("#followupSearchBtn").click(function(e) {
            e.preventDefault();
            searchFollowup(1);
        });
        $("#scFlag1").val(0);
        // searchFollowup(1);
        $("#followUpSearch").onEnter(search, 1);
        searchFollowup();
        displayPaAddress();
        init('currentUnit', 'R200,B100,J100', [0]);//市级医院,卫生院

    });

    function caseSubmit(type) {
        var result = validate.validateForm();
        if (!result) {
            return;
        }
        //时间类型,格式转成"yyyy/MM/dd"
        var breakOutDt = $('#breakOutDt').val();
        if ((!$.isEmpty(breakOutDt)) && breakOutDt.length == 4) {
            var breakOutDtYMD = breakOutDt + '/01/01';
            $('#breakOutDt').val(breakOutDtYMD);
        }
        var lastBreakOutDt = $('#lastBreakOutDt').val();
        if (undefined != lastBreakOutDt && lastBreakOutDt != '' && lastBreakOutDt.length == 7) {
            var lastBreakOutDtYMD = lastBreakOutDt + '/01';
            $('#lastBreakOutDt').val(lastBreakOutDtYMD);
        }

        var chyluriaDt = $('#chyluriaDt').val();
        if ((!$.isEmpty(chyluriaDt)) && chyluriaDt.length == 4) {
            var chyluriaDtYMD = chyluriaDt + '/01/01';
            $('#chyluriaDt').val(chyluriaDtYMD);
        }
        var chyluriaLastDt = $('#chyluriaLastDt').val();
        if (undefined != chyluriaLastDt && chyluriaLastDt != '' && chyluriaLastDt.length == 7) {
            var chyluriaLastDtYMD = chyluriaLastDt + '/01';
            $('#chyluriaLastDt').val(chyluriaLastDtYMD);
        }

        var tunicaVaginaliDt = $('#tunicaVaginaliDt').val();
        if (undefined != tunicaVaginaliDt && tunicaVaginaliDt != '' && tunicaVaginaliDt.length == 7) {
            var tunicaVaginaliDtYMD = tunicaVaginaliDt + '/01';
            $('#tunicaVaginaliDt').val(tunicaVaginaliDtYMD);
        }

        var idmId = $("#idmId").val();
        var singleId = $("#singleId").val();
        $("#caseForm").submitFormGetJson({
            url: "/idm/filariasis/case/saveCase",
            wait: true,
            param: {
                type: type,
                idmId: idmId,
                singleId: singleId
            },
            callback: function (data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("个案保存失败！", {icon:0,title:'提示'});
                } else {
                    layer.alert("个案保存成功！", {icon:0,title:'提示'});
                    search();
                    return false;
                }
            }
        });
    };

    function searchFollowup(pageIndex) {
        $("#scFlag1").val('0');
        if ($.isEmpty(pageIndex)) {
            pageIndex = $('#tagContent2').find('#pageIndex').val();
        }
        var searchObj = {
            url: "/idm/filariasis/standard/standardList",
            insertDiv: "standardListDiv",
//            wait : true,
            param: {
                pageIndex: $.isEmpty(pageIndex) ? 1 : pageIndex,
                scFlag1: '0'
            },
            callback: function (data) {
                $('#tagContent2').find('#pageIndex').val(pageIndex);
                $("#topAll3").show();
                $("#DetailDiv").empty();
                $("#drugRegId").addClass("active");
                $("#interview").removeClass("active");
            }
        };
        $("#followUpSearchForm").submitFormLoadHtml(searchObj);
    }

    function initFollowUp(singleId, lymphedema, chyluria, logoff) {
        $.loadHtmlByUrl({
            url: "/idm/filariasis/standard/initFollowUp",
//            wait : true,
            insertDiv: "DetailDiv",
            param: {singleId: singleId, lymphedema: lymphedema, chyluria: chyluria, logoff: logoff}
        });
        $("#topAll3").hide();
    }

    function search(pageIndex) {
        var scFlag = $("#scFlag1").val();
        disableChangeConfirm();
        $("#DetailDiv").empty();

        if ('1' == scFlag) {
            searchSc(pageIndex);
        } else {
            searchFollowup(pageIndex);
        }

        $("#topAll3").show();
    }

    function returnSearch() {
        // if (contentChanged) {
            /*msgUtil.backConfirm(function () {
                search();
            });*/
            layer.confirm("确定离开？", {icon:1, title:'确认提示'}, function(index) {
                layer.close(index);
            	search();
            });
        // } else {
        //     search();
        // }
    };

    function caseDownLoad() {
        location.href = contextPath + "/idm/malaria/case/downMalariaCaseExcel?" + $('#caseSearchForm').formSerialize();

    }

    function saveFr(type) {
        var validate = null;
        validate = $("#frForm").easyValidate();
        var result = validate.validateForm();
        if (!result) {
            return;
        }
        var singleId = $("#singleId").val();
        var lymphedema = $("#lymphedema").val();
        var chyluria = $("#chyluria").val();
        var listLcJson = util.Obj2str(idmCommon.getTablesData('lcTable', [], [], ''));
        $("#listLcJson").val(listLcJson);
        $("#frForm").submitFormGetJson({
            url: "/idm/filariasis/standard/saveFollowUp",
            wait: true,
            param: {
                type: type
            },
            callback: function (data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("保存失败！", {icon:0,title:'提示'});
                } else {
                    layer.alert("保存成功！", {icon:0,title:'提示'});
                    initFollowUp(singleId, lymphedema, chyluria);
                    return false;
                }
            }
        });
    }

    function initAddFr() {
//        $("#frDetailDiv").find("input[type=text]").each(function(){
//            $(this).val('');
//        });
//        $("#frDetailDiv").find("input[type=radio]").each(function(){
//            $(this).attr("checked",false);
//        });
//        $("#frDetailDiv").find("input[type=checkbox]").each(function(){
//            $(this).attr("checked",false);
//        });
//        $("#frDetailDiv").find("select").each(function(){
//            $(this).val('');
//        });
//
//        $("#lcTable").find("tr").each(function(trindex,tritem){
//            if(trindex > 1){
//                $(this).remove();
//            }
//        })
//
//        $("#reasonContent").val('');
//        $("#suggestion").val('');
//        $(".listtrselect").removeClass("listtrselect");
//        $("#xinzeng").hide();
//        $("#xiugai").hide();
////        $("#shanchu").hide();
//        $("#baocun").show();
        var singleId = $("#singleId").val();
        var lymphedema = $("#lymphedema").val();
        var chyluria = $("#chyluria").val();
        initFollowUp(singleId, lymphedema, chyluria);
    }

    function clickRow(selectRow) {
        var id = $(selectRow).attr("id");
        var lymphedema = $("#lymphedema").val();
        var chyluria = $("#chyluria").val();
        $.loadHtmlByUrl({
            url: "/idm/filariasis/standard/initFollowUpDetail",
//            wait : true,
            insertDiv: "detailDiv",
            param: {
                id: id,
                lymphedema: lymphedema,
                chyluria: chyluria
            }
        });
        $("#xinzeng").show();
        $("#xiugai").show();
//        $("#shanchu").show();
        $("#baocun").hide();
    }

    function popupLc(btn, type) {
        var lymphedema = $("#lymphedema").val();
        var chyluria = $("#chyluria").val();
        var param = {total: lymphedema + chyluria};
        if ("edit" == type) {
            var extendDiv = btn.parentNode.parentNode;
            var rowIndex = extendDiv.rowIndex;
            var trData = {};
            $(extendDiv).find("td").each(function (tdindex, tditem) {
                var inputValue = $(tditem).text()
                if ('' != inputValue) {
                    trData[$(this).attr("field")] = inputValue;
                }
            });
            var trDataStr = "[" + util.Obj2str(trData) + "]";
            param = {trData: trDataStr, rowIndex: rowIndex, type: 'edit', total: lymphedema + chyluria};
        }
       /* var lcDialog = {
            url: "/idm/filariasis/standard/popupLc",
            height: 220,
            param: param,
            width: 700,
            title: "自我照料和医生建议",
            id: "lcDialog"
        };
        $.dialog(lcDialog);*/
        
        $.post(contextPath+'/idm/filariasis/standard/popupLc',
        		param,
			function(ret){
        		  layer.open({
        			  type: 1,
        			  id:'lcDialog',
        			  area: ['700px', '220px'],
        			  title:'自我照料和医生建议',
        			  content: ret
        		  });
        	});
    }

    function saveLcData(type) {
        validate = $("#addLcForm").easyValidate();
        var result = validate.validateForm();
        if (!result) {
            return;
        }
        var html = fillLcRowData();
        if ('edit' == type) {
            var rowIndex = $('#rowIndex').val();
            html = html.replace("</tr>", "");
            html = html.replace("<tr>", "");
            $("#lcTable tr").eq(rowIndex).html(html);
        } else {
            $("#lcTable").append(html);
        }
        /*idmCommon.closePopUp('lcDialog');*/
        layer.close(layer.index);
    }

    function fillLcRowData() {
        var lcObj = idmCommon.getPopObj('popLcTable');
//        lcObj['mindEvaluateStr'] = getRadioValue('mindEvaluate');
        var recommendType = $("#recommend").val();
        var recommendStr = $("#recommend").find("option:selected").text();

        var mindEvaluate = lcObj.mindEvaluate;
        var mindEvaluate1 = '';
        var mindEvaluate2 = '';
        var mindEvaluate3 = '';
        if (1 == mindEvaluate) {
            mindEvaluate1 = '√';
        }
        if (2 == mindEvaluate) {
            mindEvaluate2 = '√';
        }
        if (3 == mindEvaluate) {
            mindEvaluate3 = '√';
        }

        var lcShowFields = ['recommendStr', 'mindEvaluate1', 'mindEvaluate2', 'mindEvaluate3', 'existingProblem', 'suggest'];
        var lcHideFields = ['recommendType', 'mindEvaluate'];
        var lcShowValues = [recommendStr, mindEvaluate1, mindEvaluate2, mindEvaluate3, lcObj.existingProblem, lcObj.suggest];
        var lcHideValues = [recommendType, mindEvaluate];
        var editMethod = "filStandard.popupLc(this, 'edit')";
        return idmCommon.generateTrHtml(lcShowFields, lcHideFields, lcShowValues, lcHideValues, editMethod);
    }

    function getRadioValue(radioName) {
        var val = $("input[name=" + radioName + "]:checked").data("label");
        return val;
    }

    function isSelected() {
        var type = $("#frType").val();
        var selectVal = $("#recommend").val();
        if (selectVal.length == 1) {
            selectVal = "0" + selectVal;
        }
        var downItems = '';
        $("#lcTable tr").each(function (trindex, tritem) {
            if (trindex > 1) {
                $(tritem).find("td").each(function (tdindex, tditem) {
                    if (6 == tdindex) {
                        var text = $(tditem).text();
                        if (text.length == 1) {
                            text = "0" + text;
                        }
                        downItems = downItems + text + ",";
                    }

                });
            }
        });
        if ('add' == type) {
            if (downItems.indexOf(selectVal + ",") != -1) {
                layer.alert("该方法已填写，请重新选择！", {icon:0,title:'提示'});
                $("#recommend").val('');
                return false;
            }
        }
        if ('edit' == type) {

            var recommendType = $("#recommendType").val();
            downItems = downItems.replace(recommendType);
//            if(downItems.split(selectVal).length-1 > 1){
            if (downItems.indexOf(selectVal + ",") != -1) {
                layer.alert("该方法已填写，请重新选择！", {icon:0,title:'提示'});
                $("#recommend").val('');
                return false;
            }
        }

    }

    function initSc(singleId, logoff) {
        $.loadHtmlByUrl({
            url: "/idm/filariasis/standard/initListSc",
//            wait : true,
            insertDiv: "DetailDiv",
            param: {singleId: singleId, logoff: logoff}
        });
        $("#topAll3").hide();
    }

    function searchSc(pageIndex) {
        $("#scFlag1").val('1');
        if ($.isEmpty(pageIndex)) {
            pageIndex = $('#tagContent2').find('#pageIndex').val();
        }
        var searchObj = {
            url: "/idm/filariasis/standard/standardList",
            insertDiv: "standardListDiv",
//            wait : true,
            param: {
                pageIndex: $.isEmpty(pageIndex) ? 1 : pageIndex,
                scFlag1: '1'
            },
            callback: function (data) {
                $('#tagContent2').find('#pageIndex').val(pageIndex);
                $("#topAll3").show();
                $("#DetailDiv").empty();
                $("#drugRegId").removeClass("active");
                $("#interview").addClass("active");
            }
        };
        $("#followUpSearchForm").submitFormLoadHtml(searchObj);
    }

    function initAddSc() {
//        $("#scDetailDiv").find("input[type=text]").each(function(){
//            $(this).val('');
//        });
//        $("#scDetailDiv").find("input[type=radio]").each(function(){
//            $(this).attr("checked",false);
//        });
//        $("#scDetailDiv").find("input[type=checkbox]").each(function(){
//            $(this).attr("checked",false);
//        });
//        $("#scDetailDiv").find("select").each(function(){
//            $(this).val('');
//        });
//        $(".listtrselect").removeClass("listtrselect");
//        $("#xinzeng").hide();
//        $("#xiugai").hide();
////        $("#shanchu").hide();
//        $("#baocun").show();
        var singleId = $("#singleId").val();
        initSc(singleId);
    }

    function saveSc(type) {
        var validate = null;
        validate = $("#scForm").easyValidate();
        var result = validate.validateForm();
        if (!result) {
            return;
        }
        var singleId = $("#singleId").val();
        var lymphedema = $("#lymphedema").val();
        var chyluria = $("#chyluria").val();
        var listLcJson = util.Obj2str(idmCommon.getTablesData('lcTable', [], [], ''));
        $("#listLcJson").val(listLcJson);
        $("#scForm").submitFormGetJson({
            url: "/idm/filariasis/standard/saveSc",
            wait: true,
            param: {
                type: type
            },
            callback: function (data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("保存失败！", {icon:0,title:'提示'});
                } else {
                    layer.alert("保存成功！", {icon:0,title:'提示'});
                    initSc(singleId);
                    return false;
                }
            }
        });
    }

    function clickScRow(selectRow) {
        var id = $(selectRow).attr("id");
        $.loadHtmlByUrl({
            url: "/idm/filariasis/standard/initScDetail",
            insertDiv: "detailDiv",
//            wait : true,
            param: {
                id: id
            }
        });
        $("#xinzeng").show();
        $("#xiugai").show();
//        $("#shanchu").show();
        $("#baocun").hide();
    }

    function searchFollowUpList(pageIndex, singleId) {
        var singleId = $("#frForm").find('#singleId').val();
        $.loadHtmlByUrl({
            url: "/idm/filariasis/standard/searchFollowUpList",
            insertDiv: "contactsList",
            wait: true,
            param: {singleId: singleId, pageIndex: pageIndex}
        });
        $("#topAll3").hide();
    }

    function searchScList(pageIndex, singleId) {
        var singleId = $("#scForm").find('#singleId').val();
        $.loadHtmlByUrl({
            url: "/idm/filariasis/standard/searchScList",
            wait: true,
            insertDiv: "scList",
            param: {singleId: singleId, pageIndex: pageIndex}
        });
        $("#topAll3").hide();
    }

    function displayPaAddress() {
        $("select[name='pastreet']").on("change villageChange", function () {
            var prefix = $("select[name='patownShip']").find("option[value!='']:selected").text();
            prefix += $(this).find("option[value!='']:selected").text();
            $("#tempPaValue").text(prefix);
        });
    }

    /**
     * 初始化机构控件
     * orgId:控件ID
     * orgType:机构类型
     * unSelectType:不能选择的机构类型
     */
    function init(orgId, orgType, unSelectType) {
        //机构下拉树设置
        var option = {
            url: "/mdmOrganization/organationTree",
            unSelecteType: unSelectType,  //下来树不能类型：0：镇，B1:中心，B2:站
            param: {organType: orgType}  //查询机构类型,逗号分割
        };
        //机构自动检索设置
        var opb = {
            url: "/mdmOrganization/organationSelect",
            feild: {
                value: "organCode",
                lable: "organName"
            },
            param: {organType: orgType}  //查询机构类型,逗号分割
        };

        var hospitalCode = $("#" + orgId);
        if (hospitalCode.length > 0) {
            //初始化自动检索
            hospitalCode.selectBox(opb);
            //初始化下拉树
            hospitalCode.initTreeSelect(option);
        }
    }

    return {
        caseSubmit: caseSubmit,
        searchFollowup: searchFollowup,
        returnSearch: returnSearch,
        search: search,
        caseDownLoad: caseDownLoad,
        initFollowUp: initFollowUp,
        saveFr: saveFr,
        initAddFr: initAddFr,
        clickRow: clickRow,
        popupLc: popupLc,
        saveLcData: saveLcData,
        isSelected: isSelected,
        searchSc: searchSc,
        initSc: initSc,
        initAddSc: initAddSc,
        saveSc: saveSc,
        clickScRow: clickScRow,

        searchFollowUpList: searchFollowUpList,
        searchScList: searchScList,

        displayPaAddress: displayPaAddress
    };
})();
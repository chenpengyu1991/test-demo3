
var typhiaCase = (function() {
	var cultureTitle = '培养（细菌型别）';
	var grubersTitle = '肥达氏反应';
	var cellTitle = '白细胞计数、分类';
	var url = "/idm/case/typhia/child";
	var height = '250';
	var width = '800';
	$(function() {
		addClickMethod();
        initMethod();
	});

	/**
	 * 页面加载时需要执行的函数
	 */
	function initMethod() {
		caseEdit.toggerAddress();
		 toggleOther('otherCondition.inpatientFlg','inpatientFlgTd',1);
         toggleOther('clinicalManifestations.fever','heatingDurationTd',1);
         toggleOther('beforeDiseaseDiet.drinkingHistory','waterType',1);
         toggleOther('beforeDiseaseDiet.coldFood','coldFoodName',1);
         toggleOther('beforeDiseaseDiet.cookedFoodColdEat','cookedFoodName',1);
         toggleOther('beforeDiseaseDiet.outsideDiningHistory','eatPlace',1);
         toggleOther('beforeDiseaseDiet.meals','mealPNum',1);
         toggleOther('epidemiologicalSurvey.inoculateHistory','lastInoculateDt',1);
         toggleOtherSC('generalCondition.occupation','occupationPart','CV020120299');
         toggleOther('epidemiologicalSurvey.stranger','strangerFromAddr',1);
         toggleOther('epidemiologicalSurvey.outHistory','outHistoryTd',1);
         toggleOther('infectionSourceRoute.stranger','strangerFromAddrd',1);
         toggleOtherCK('clinicalManifestations.complications','complications','21');
	}
	
	/**
	 * 给按钮添加响应事件
	 */
	function addClickMethod(){
		$("#addCultureList").click(function() {
            var cultureDialog = {
                url : url,
                height : height,
                width : width,
                title : cultureTitle,
                id :"cultureDialog",
                param:{typeChild:'culture'}
            };
            $.dialog(cultureDialog);
        });
        $("#addGrubersList").click(function() {
            var grubersDialog = {
       		 url : url,
                height : height,
                width : width,
                title : grubersTitle,
                id :"grubersDialog",
                param:{typeChild:'grubers'}
            };
            $.dialog(grubersDialog);
        });
        $("#addCellList").click(function() {
            var cellDialog = {
       		 url : url,
                height : height,
                width : width,
                title : cellTitle ,
                id :"cellDialog",
                param:{typeChild:'cell'}
            };
            $.dialog(cellDialog);
        });
	}
	
    function addCultureList(){
        validate = $("#addCulture").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var html = fillCultureRowData();
        $("#cultureTable").append(html);
        caseEdit.closePopUp('cultureDialog');
    }

    function addGrubersList(){
        validate = $("#addGrubers").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }

        var html = fillGrubersRowData();
        $("#grubersTable").append(html);
        caseEdit.closePopUp('grubersDialog');
    }
    
    function addCellList(){
        validate = $("#addCell").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }

        var html = fillCellRowData();
        $("#cellTable").append(html);
        caseEdit.closePopUp('cellDialog');
    }
    
    function editCultureList(){
        validate = $("#addCulture").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var rowIndex = $('#rowIndex').val();
        var html = fillCultureRowData();
        html = html.replace("</tr>", "");
        html = html.replace("<tr>", "");
        $("#cultureTable tr").eq(rowIndex).html(html);
        caseEdit.closePopUp('cultureDialog');
    }
    
    function editGrubersList(){
        validate = $("#addGrubers").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var rowIndex = $('#rowIndex').val();
        var html = fillGrubersRowData();
        html = html.replace("</tr>", "");
        html = html.replace("<tr>", "");
        $("#grubersTable tr").eq(rowIndex).html(html);
        caseEdit.closePopUp('grubersDialog');
    }
    
    function editCellList(){
        validate = $("#addCell").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var rowIndex = $('#rowIndex').val();
        var html = fillCellRowData();
        html = html.replace("</tr>", "");
        html = html.replace("<tr>", "");
        $("#cellTable tr").eq(rowIndex).html(html);
        caseEdit.closePopUp('cellDialog');
    }
    
    function editTr(editBtn, part){
        var id = 'cultureDialog';
        var title = cultureTitle;
        var typeChild = 'culture';
        
        if('cellList' == part){
        	id = 'cellDialog';
	        title = cultureTitle;
	        typeChild= 'cell';
        } else if('grubersList' == part) {
            id = 'grubersDialog';
            title = grubersTitle;
            typeChild= 'grubers';
        }
        
        var extendDiv = editBtn.parentNode.parentNode;
        var rowIndex = extendDiv.rowIndex;
        var trData = {};
        $(extendDiv).find("td").each(function(tdindex,tditem){
            var inputValue = $(tditem).text();
            if('' != inputValue){
                trData[$(this).attr("field")] = inputValue;
            }
        });
        var trDataStr =  "[" + util.Obj2str(trData) + "]";
        var efcDialog = {
            url : url,
            height : height,
            width : width,
            title : title,
            id :id,
            param:{typeChild:typeChild, trData:trDataStr, rowIndex:rowIndex, type:'edit'}
        };
        $.dialog(efcDialog);
    }

    function fillCultureRowData(){
        var activeObj = {};
        getActiveValue(activeObj, 'popCultureTable');

        var html = '<tr>';
        html += '<td field="cultureDt" title="'+activeObj.cultureDt+'">'+activeObj.cultureDt+'</td>';
        html += '<td field="blood" title="'+activeObj.blood+'">'+activeObj.blood+'</td>';
        html += '<td field="dung" title="'+activeObj.dung+'">'+activeObj.dung+'</td>';
        html += '<td field="urine" title="'+activeObj.urine+'">'+activeObj.urine+'</td>';
        html += '<td field="other" title="'+activeObj.other+'">'+activeObj.other+'</td>';
        html += '<td class="btnsublist" field="btn"> <a href="javascript:void(0)" onclick="typhiaCase.editTr(this, \'cultureList\')">修改</a>' +
            ' <a href="javascript:void(0)"  onclick="caseEdit.removeTr(this)">删除</a></td>';
        html += '</tr>';
        return html;
    }

    function fillGrubersRowData(){
        var bddObj = {};
        getActiveValue(bddObj, 'popGrubersTable');

        var html = '<tr>';
        html += '<td field="grubersReactionDt" title="'+bddObj.grubersReactionDt+'">'+bddObj.grubersReactionDt+'</td>';
        html += '<td field="o" title="'+bddObj.o+'">'+bddObj.o+'</td>';
        html += '<td field="h" title="'+bddObj.h+'">'+bddObj.h+'</td>';
        html += '<td field="a" title="'+bddObj.a+'">'+bddObj.a+'</td>';
        html += '<td field="b" title="'+bddObj.b+'">'+bddObj.b+'</td>';
        html += '<td field="c" title="'+bddObj.c+'">'+bddObj.c+'</td>';
        html += '<td class="btnsublist" field="btn"> <a href="javascript:void(0)" onclick="typhiaCase.editTr(this, \'grubersList\')">修改</a>' +
            ' <a href="javascript:void(0)"  onclick="caseEdit.removeTr(this)">删除</a></td>';
        html += '</tr>';
        return html;
    }
    
    function fillCellRowData(){
        var bddObj = {};
        getActiveValue(bddObj, 'popCellTable');

        var html = '<tr>';
        html += '<td field="cellCategoryDt" title="'+bddObj.cellCategoryDt+'">'+bddObj.cellCategoryDt+'</td>';
        html += '<td field="totality" title="'+bddObj.totality+'">'+bddObj.totality+'</td>';
        html += '<td field="neutrophilcell" title="'+bddObj.neutrophilcell+'">'+bddObj.neutrophilcell+'</td>';
        html += '<td field="lymphocyte" title="'+bddObj.lymphocyte+'">'+bddObj.lymphocyte+'</td>';
        html += '<td field="eosinophils" title="'+bddObj.eosinophils+'">'+bddObj.eosinophils+'</td>';
        html += '<td field="otherResult" title="'+bddObj.otherResult+'">'+bddObj.otherResult+'</td>';
        html += '<td class="btnsublist" field="btn"> <a href="javascript:void(0)" onclick="typhiaCase.editTr(this, \'cellList\')">修改</a>' +
            ' <a href="javascript:void(0)"  onclick="caseEdit.removeTr(this)">删除</a></td>';
        html += '</tr>';
        return html;
    }
    
    function getActiveValue(patientObj, tableId){
        $("#" + tableId).find("input").each(function(ind, obj) {
            if (obj.type == "text") {
                var inputValue = $(this).val();
                patientObj[$(this).attr("id")] = inputValue;
            }
        });

    }
    
    return {
    	addCultureList : addCultureList,
        editCultureList : editCultureList,
        addGrubersList : addGrubersList,
        editGrubersList : editGrubersList,
        addCellList : addCellList,
        editCellList : editCellList,
        editTr : editTr
    };
})();





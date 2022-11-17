
var hiwhpaiCase = (function() {
	$(function() {
        $.Placeholder.init({query:"#idCard",callback:function(element){
            idCard.queryPerson($(element).val());
        }});
        toggleOther('caseInformation.isNetworkReport','networkPart',1);
        toggleOther('attackCondition.selfMedication','medicationType',1);
        toggleOther('exposureHistory.isDieAnimal','isDieAnimalPart',1);
        toggleOther('exposureHistory.isDieLive','isDieLivePart',1);
//        toggleOther('exposureHistory.isDieHn','isDieHnPart',1);
        toggleOther('exposureHistory.isDisinfect','disinfectDate',1);
        toggleOther('exposureHistory.isPat','isPatPart',1);
        toggleOther('clinicalManifestations.fever','feverPart',1);
        toggleOther('hygienicCondition.kitchenCuttingBoard','procRawMeatAfter',2);
        toggleOther('hygienicCondition.isKnow','fromType',1);
        toggleOther('hygienicCondition.isDisinfectFamly','disinfectFamlyDate',1);
        toggleOther('hygienicCondition.isSmoke','spliffNum',1);
        toggleOther('hygienicCondition.tiv','tivLastInoculateDate',1);
        toggleOther('hygienicCondition.immunoglobulin','immLastInoculateDate',1);
        toggleContactAnimal('exposureHistory.contactAnimal');
        toggleOther('exposureHistory.dieAnimalCategory','dieAnimalCategoryPart',1);
        toggleOther('exposureHistory.feverPatientContact','feverPatientContactPact',1);
        toggleOther('otherCondition.finalDiagnosis','clinicalCaseExcludeName',3);
        toggleOutcome('otherCondition.outcomeCode');
        toggleOther('exposureHistory.hnLabWeek','conservatoryMeasureLabWeek',1);
        toggleOtherCK('exposureHistory.animalContactWay','boilCategory',5);
        caseEdit.toggerAddress();
	});
    function toggleContactAnimal(radioName){
        var raValue = $('input[name="' + radioName+ '"]:checked').val();
        if(raValue == 1){
            $("#contactAnimalCategoryPart").show();
            $("#publicPlace").hide();

            $("#publicPlace").find("input[type=radio]").each(function(){
                $(this).attr("checked",false);
            });
            $("#publicPlace").find("input[type=checkbox]").each(function(){
                $(this).attr("checked",false);
            });
        }
        if(raValue == 2){
            $("#contactAnimalCategoryPart").hide();
            $("#publicPlace").show();

            $("#contactAnimalCategoryPart").find("input[type=radio]").each(function(){
                $(this).attr("checked",false);
            });
            $("#contactAnimalCategoryPart").find("input[type=checkbox]").each(function(){
                $(this).attr("checked",false);
            });
        }
        if(raValue == 4){
            $("#contactAnimalCategoryPart").hide();
            $("#publicPlace").hide();

            $("#contactAnimalCategoryPart").find("input[type=radio]").each(function(){
                $(this).attr("checked",false);
            });
            $("#contactAnimalCategoryPart").find("input[type=checkbox]").each(function(){
                $(this).attr("checked",false);
            });
            $("#publicPlace").find("input[type=radio]").each(function(){
                $(this).attr("checked",false);
            });
            $("#publicPlace").find("input[type=checkbox]").each(function(){
                $(this).attr("checked",false);
            });
        }
    }

    function toggleOutcome(radioName){
        var raValue = $('input[name="' + radioName+ '"]:checked').val();
        if(1 == raValue){
            $("#outhosDate").show();
            $("#deathPart").hide();
            $("#deathPart").find("input[type=text]").each(function(){
                $(this).val('');
            });
        }
        if(4 == raValue){
            $("#outhosDate").hide();
            $("#deathPart").show();
            $("#outhosDate").find("input[type=text]").each(function(){
                $(this).val('');
            });
        }
        if(99 == raValue){
            $("#outhosDate").hide();
            $("#deathPart").hide();
            $("#outhosDate").find("input[type=text]").each(function(){
                $(this).val('');
            });
            $("#deathPart").find("input[type=text]").each(function(){
                $(this).val('');
            });
        }
    }

    function popupAc(btn, type){
        var param = '';
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
        var acDialog = {
            url : "/idm/case/hiwhpai/popupAc",
            height : 220,
            width : 800,
            title : "就诊情况" ,
            id :"acDialog",
            param:param
        };
        $.dialog(acDialog);
    }
    function saveAcData(type){
        validate = $("#addAcForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var html = fillAcRowData();
        if('edit' == type){
            var rowIndex = $('#rowIndex').val();
            html = html.replace("</tr>", "");
            html = html.replace("<tr>", "");
            $("#acTable tr").eq(rowIndex).html(html);
        }else{
            $("#acTable").append(html);
        }
        caseEdit.closePopUp('acDialog');
    }
    function fillAcRowData(){
        var acObj = caseEdit.getPopObj('popAcTable');
        acObj['lapseStr'] = getRadioValue('lapse');
        acObj['quarantineStr'] = getRadioValue('quarantine');

        var acShowFields = ['treatmentUnit', 'treatmentDt', 'treatDays', 'diagnosisResult', 'quarantineStr', 'inhospitalDt', 'outpatientNo', 'lapseStr'];
        var acHideFields = ['lapse', 'quarantine'];
        var acShowValues = [acObj.treatmentUnit, acObj.treatmentDt, acObj.treatDays, acObj.diagnosisResult, acObj.quarantineStr, acObj.inhospitalDt, acObj.outpatientNo, acObj.lapseStr];
        var acHideValues = [acObj.lapse, acObj.quarantine];
        var editMethod = "hiwhpaiCase.popupAc(this, 'edit')";
        return caseEdit.generateTrHtml(acShowFields, acHideFields, acShowValues, acHideValues, editMethod);
    }

    function popupEfc(btn, type){
        var param = '';
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
        var efcDialog = {
            url : "/idm/case/hiwhpai/popupEfc",
            height : 220,
            width : 800,
            title : "密切接触者情况" ,
            id :"efcDialog",
            param:param
        };
        $.dialog(efcDialog);
    }
    function saveEfcData(type){
        validate = $("#addEfcForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var html = fillEfcRowData();
        if('edit' == type){
            var rowIndex = $('#rowIndex').val();
            html = html.replace("</tr>", "");
            html = html.replace("<tr>", "");
            $("#efcTable tr").eq(rowIndex).html(html);
        }else{
            $("#efcTable").append(html);
        }
        caseEdit.closePopUp('efcDialog');
    }

    function fillEfcRowData(){
        var efcObj = caseEdit.getPopObj('popEfcTable');
        efcObj['sexStr'] = getRadioValue('sex');

        var efcShowFields = ['name', 'sexStr', 'relation', 'tel'];
        var efcHideFields = ['sex'];
        var efcShowValues = [efcObj.name, efcObj.sexStr, efcObj.relation, efcObj.tel];
        var efcHideValues = [efcObj.sex];
        var editMethod = "hiwhpaiCase.popupEfc(this, 'edit')";
        return caseEdit.generateTrHtml(efcShowFields, efcHideFields, efcShowValues, efcHideValues, editMethod);
    }

    function popupEh(btn, type, seq){
        var url, title, height = 220;
        var url = "/idm/case/hiwhpai/popupEh";
        var param = {seq:seq};
        if(1 == seq){
            title = "动物饲养/病死情况";
        }
        if(2 == seq){
            title = "家禽饲养户人员情况";
        }
        if(3 == seq){
            title = "居住地养殖场情况";
        }
        if(4 == seq){
            title = "H5N1型禽流感病毒分离或PCR情况";
        }
        if(5 == seq){
            title = "有病死动物后情况";
        }
        if(6 == seq){
            title = "发病前2周内与发热病人接触情况";
        }
        if(7 == seq){
            title = "病例旅行史";
        }
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
            param = {trData:trDataStr, rowIndex:rowIndex, type:'edit', seq:seq};
        }
        var ehDialog = {
            url : url,
            height : height,
            width : 800,
            title : title,
            id :"ehDialog",
            param:param
        };
        $.dialog(ehDialog);
    }
    function saveEhData(type,seq){
        var formId = 'addEh' + seq + 'Form';
        var popTable = 'popEh' + seq + 'Table';
        var parentTable = 'eh' + seq + 'Table';

        validate = $("#" + formId).easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        if(1 == seq){
            var html = fillEh1RowData(popTable);
        }
        if(2 == seq){
            var html = fillEh2RowData(popTable);
        }
        if(3 == seq){
            var html = fillEh3RowData(popTable);
        }
        if(4 == seq){
            var html = fillEh4RowData(popTable);
        }
        if(5 == seq){
            var html = fillEh5RowData(popTable);
        }
        if(6 == seq){
            var html = fillEh6RowData(popTable);
        }
        if(7 == seq){
            var html = fillEh7RowData(popTable);
        }
        if('edit' == type){
            var rowIndex = $('#rowIndex').val();
            html = html.replace("</tr>", "");
            html = html.replace("<tr>", "");
            $("#"+parentTable+" tr").eq(rowIndex).html(html);
        }else{
            $("#" + parentTable).append(html);
        }
        caseEdit.closePopUp('ehDialog');
    }
    function fillEh1RowData(popTable){
        var eh1Obj = caseEdit.getPopObj(popTable);

        var eh1ShowFields = ['farmName', 'animalType',  'animalNum', 'dieNum', 'dieDt', 'processMode', 'processDt', 'processNum'];
        var eh1HideFields = [];
        var eh1ShowValues = [eh1Obj.farmName, eh1Obj.animalType, eh1Obj.animalNum, eh1Obj.dieNum, eh1Obj.dieDt, eh1Obj.processMode, eh1Obj.processDt, eh1Obj.processNum];
        var eh1HideValues = [];
        var editMethod = "hiwhpaiCase.popupEh(this, 'edit', 1)";
        return caseEdit.generateTrHtml(eh1ShowFields, eh1HideFields, eh1ShowValues, eh1HideValues, editMethod);
    }
    function fillEh2RowData(popTable){
        var eh2Obj = caseEdit.getPopObj(popTable);

        var eh2ShowFields = ['familyNum', 'peopleNum',  'permanentPopulation', 'fowlFamilyNum', 'fowlPeopleNum', 'dieFowlNum', 'dieFowlPeopleNum', 'exceptionNum'];
        var eh2HideFields = [];
        var eh2ShowValues = [eh2Obj.familyNum, eh2Obj.peopleNum, eh2Obj.permanentPopulation, eh2Obj.fowlFamilyNum, eh2Obj.fowlPeopleNum, eh2Obj.dieFowlNum, eh2Obj.dieFowlPeopleNum, eh2Obj.exceptionNum];
        var eh2HideValues = [];
        var editMethod = "hiwhpaiCase.popupEh(this, 'edit', 2)";
        return caseEdit.generateTrHtml(eh2ShowFields, eh2HideFields, eh2ShowValues, eh2HideValues, editMethod);
    }

    function fillEh3RowData(popTable){
        var eh3Obj = caseEdit.getPopObj(popTable);

        var eh3ShowFields = ['farmName', 'animalType',  'dieNum'];
        var eh3HideFields = [];
        var eh3ShowValues = [eh3Obj.farmName, eh3Obj.animalType, eh3Obj.dieNum];
        var eh3HideValues = [];
        var editMethod = "hiwhpaiCase.popupEh(this, 'edit', 3)";
        return caseEdit.generateTrHtml(eh3ShowFields, eh3HideFields, eh3ShowValues, eh3HideValues, editMethod);
    }

    function fillEh4RowData(popTable){
        var eh4Obj = caseEdit.getPopObj(popTable);

        var eh4ShowFields = ['pcr', 'sampleAddr',  'sampleDt', 'separateDt', 'separateUnit'];
        var eh4HideFields = [];
        var eh4ShowValues = [eh4Obj.pcr, eh4Obj.sampleAddr, eh4Obj.sampleDt, eh4Obj.separateDt, eh4Obj.separateUnit];
        var eh4HideValues = [];
        var editMethod = "hiwhpaiCase.popupEh(this, 'edit', 4)";
        return caseEdit.generateTrHtml(eh4ShowFields, eh4HideFields, eh4ShowValues, eh4HideValues, editMethod);
    }

    function fillEh5RowData(popTable){
        var eh5Obj = caseEdit.getPopObj(popTable);
        eh5Obj['sexStr'] = getRadioValue('sex');

        var eh5ShowFields = ['name', 'sexStr',  'age', 'clinicalManifestation', 'saveDieDt', 'contact', 'comments'];
        var eh5HideFields = ['sex'];
        var eh5ShowValues = [eh5Obj.name, eh5Obj.sexStr, eh5Obj.age, eh5Obj.clinicalManifestation, eh5Obj.saveDieDt, eh5Obj.contact, eh5Obj.comments];
        var eh5HideValues = [eh5Obj.sex];
        var editMethod = "hiwhpaiCase.popupEh(this, 'edit', 5)";
        return caseEdit.generateTrHtml(eh5ShowFields, eh5HideFields, eh5ShowValues, eh5HideValues, editMethod);
    }

    function fillEh6RowData(popTable){
        var eh6Obj = caseEdit.getPopObj(popTable);

        var eh6ShowFields = ['name', 'attackDt',  'clinicalManifestation', 'diagnosis', 'contactDtLast', 'contactTypeRate', 'contactAddr'];
        var eh6HideFields = [];
        var eh6ShowValues = [eh6Obj.name, eh6Obj.attackDt, eh6Obj.clinicalManifestation, eh6Obj.diagnosis, eh6Obj.contactDtLast, eh6Obj.contactTypeRate, eh6Obj.contactAddr];
        var eh6HideValues = [];
        var editMethod = "hiwhpaiCase.popupEh(this, 'edit', 6)";
        return caseEdit.generateTrHtml(eh6ShowFields, eh6HideFields, eh6ShowValues, eh6HideValues, editMethod);
    }

    function fillEh7RowData(popTable){
        var eh7Obj = caseEdit.getPopObj(popTable);

        var eh7ShowFields = ['travelBegin', 'travelDt',  'travelAddr', 'condition'];
        var eh7HideFields = [];
        var eh7ShowValues = [eh7Obj.travelBegin, eh7Obj.travelDt, eh7Obj.travelAddr, eh7Obj.condition];
        var eh7HideValues = [];
        var editMethod = "hiwhpaiCase.popupEh(this, 'edit', 7)";
        return caseEdit.generateTrHtml(eh7ShowFields, eh7HideFields, eh7ShowValues, eh7HideValues, editMethod);
    }

     function popupHc(btn, type, seq){
        var url, title, height = 220;
        var url = "/idm/case/hiwhpai/popupHc";
        var param = {seq:seq};
        if(1 == seq){
            title = "病例家中病死动物情况";
        }
        if(2 == seq){
            title = "环境/病死禽畜采样情况";
        }
        if(3 == seq){
            title = "家中禽类饲养情况";
        }
        if(4 == seq){
            title = "病例家庭成员及与病死动物接触情况";
        }
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
            param = {trData:trDataStr, rowIndex:rowIndex, type:'edit', seq:seq};
        }
        var hcDialog = {
            url : url,
            height : height,
            width : 800,
            title : title,
            id :"hcDialog",
            param:param
        };
        $.dialog(hcDialog);
    }
    function saveHcData(type,seq){
        var formId = 'addHc' + seq + 'Form';
        var popTable = 'popHc' + seq + 'Table';
        var parentTable = 'hc' + seq + 'Table';

        validate = $("#" + formId).easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        if(1 == seq){
            var html = fillHc1RowData(popTable);
        }
        if(2 == seq){
            var html = fillHc2RowData(popTable);
        }
        if(3 == seq){
            var html = fillHc3RowData(popTable);
        }
        if(4 == seq){
            var html = fillHc4RowData(popTable);
        }

        if('edit' == type){
            var rowIndex = $('#rowIndex').val();
            html = html.replace("</tr>", "");
            html = html.replace("<tr>", "");
            $("#"+parentTable+" tr").eq(rowIndex).html(html);
        }else{
            $("#" + parentTable).append(html);
        }
        caseEdit.closePopUp('hcDialog');
    }

    function fillHc1RowData(popTable){
        var hc1Obj = caseEdit.getPopObj(popTable);

        var hc1ShowFields = ['animalType', 'animalNum', 'dieNum', 'dieDt', 'dieReason', 'processMode'];
        var hc1HideFields = [];
        var hc1ShowValues = [hc1Obj.animalType, hc1Obj.animalNum, hc1Obj.dieNum, hc1Obj.dieDt, hc1Obj.dieReason, hc1Obj.processMode];
        var hc1HideValues = [];
        var editMethod = "hiwhpaiCase.popupHc(this, 'edit', 1)";
        return caseEdit.generateTrHtml(hc1ShowFields, hc1HideFields, hc1ShowValues, hc1HideValues, editMethod);
    }
    function fillHc2RowData(popTable){
        var hc2Obj = caseEdit.getPopObj(popTable);

        var hc2ShowFields = ['sampleType', 'sampleDt', 'sampleAddr', 'sampleNum', 'detectionResult', 'detectionUnit'];
        var hc2HideFields = [];
        var hc2ShowValues = [hc2Obj.sampleType, hc2Obj.sampleDt, hc2Obj.sampleAddr, hc2Obj.sampleNum, hc2Obj.detectionResult, hc2Obj.detectionUnit];
        var hc2HideValues = [];
        var editMethod = "hiwhpaiCase.popupHc(this, 'edit', 2)";
        return caseEdit.generateTrHtml(hc2ShowFields, hc2HideFields, hc2ShowValues, hc2HideValues, editMethod);
    }
    function fillHc3RowData(popTable){
        var hc3Obj = caseEdit.getPopObj(popTable);
        hc3Obj['activityRange'] = getCheckBoxCodes("activityRange");
        hc3Obj['dungRange'] = getCheckBoxCodes("dungRange");
        hc3Obj['activityRangeDetail'] = getCheckBoxText("activityRange");
        hc3Obj['dungRangeDetail'] = getCheckBoxText("dungRange");

        var hc3ShowFields = ['animalType', 'animalNum',  'animalDt', 'activityRangeDetail', 'dungRangeDetail'];
        var hc3HideFields = ['activityRange', 'dungRange'];
        var hc3ShowValues = [hc3Obj.animalType, hc3Obj.animalNum, hc3Obj.animalDt, hc3Obj.activityRangeDetail, hc3Obj.dungRangeDetail];
        var hc3HideValues = [hc3Obj.activityRange, hc3Obj.dungRange];
        var editMethod = "hiwhpaiCase.popupHc(this, 'edit', 3)";
        return caseEdit.generateTrHtml(hc3ShowFields, hc3HideFields, hc3ShowValues, hc3HideValues, editMethod);
    }

    function fillHc4RowData(popTable){
        var hc4Obj = caseEdit.getPopObj(popTable);
        hc4Obj['sexStr']=getRadioValue("sex");
        hc4Obj['attackStr']=getRadioValue("attack");
        hc4Obj['dieAnimalType'] = getCheckBoxCodes("dieAnimalType");
        hc4Obj['dieAnimalTypeDetail'] = getCheckBoxText("dieAnimalType");
        var hc4ShowFields = ['name', 'sexStr',  'age', 'attackStr', 'dieAnimalCategory', 'dieAnimalTypeDetail'];
        var hc4HideFields = ['sex', 'attack', 'dieAnimalType'];
        var hc4ShowValues = [hc4Obj.name, hc4Obj.sexStr, hc4Obj.age, hc4Obj.attackStr, hc4Obj.dieAnimalCategory, hc4Obj.dieAnimalTypeDetail];
        var hc4HideValues = [hc4Obj.sex, hc4Obj.attack, hc4Obj.dieAnimalType];
        var editMethod = "hiwhpaiCase.popupHc(this, 'edit', 4)";
        return caseEdit.generateTrHtml(hc4ShowFields, hc4HideFields, hc4ShowValues, hc4HideValues, editMethod);
    }


    function popupLe(btn, type, seq){
        var url, title, height = 220;
        var url = "/idm/case/hiwhpai/popupLe";
        var param = {seq:seq};
        if(1 == seq){
            title = "血常规检查";
        }
        if(2 == seq){
            title = "Ｘ线检查";
        }
        if(3 == seq){
            title = "CT检查";
        }
        if(4 == seq){
            title = "病原学和血清学检查";
        }
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
            param = {trData:trDataStr, rowIndex:rowIndex, type:'edit', seq:seq};
        }
        var leDialog = {
            url : url,
            height : height,
            width : 800,
            title : title,
            id :"leDialog",
            param:param
        };
        $.dialog(leDialog);
    }
    function saveLeData(type,seq){
        var formId = 'addLe' + seq + 'Form';
        var popTable = 'popLe' + seq + 'Table';
        var parentTable = 'le' + seq + 'Table';

        validate = $("#" + formId).easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        if(1 == seq){
            var html = fillLe1RowData(popTable);
        }
        if(2 == seq){
            var html = fillLe2RowData(popTable);
        }
        if(3 == seq){
            var html = fillLe3RowData(popTable);
        }
        if(4 == seq){
            var html = fillLe4RowData(popTable);
        }

        if('edit' == type){
            var rowIndex = $('#rowIndex').val();
            html = html.replace("</tr>", "");
            html = html.replace("<tr>", "");
            $("#"+parentTable+" tr").eq(rowIndex).html(html);
        }else{
            $("#" + parentTable).append(html);
        }
        caseEdit.closePopUp('leDialog');
    }

    function fillLe1RowData(popTable){
        var le1Obj = caseEdit.getPopObj(popTable);

        var le1ShowFields = ['routineBloodTestDt', 'wbc', 'n', 'l', 'detectionUnit'];
        var le1HideFields = [];
        var le1ShowValues = [le1Obj.routineBloodTestDt, le1Obj.wbc, le1Obj.n, le1Obj.l, le1Obj.detectionUnit];
        var le1HideValues = [];
        var editMethod = "hiwhpaiCase.popupLe(this, 'edit', 1)";
        var html = caseEdit.generateTrHtml(le1ShowFields, le1HideFields, le1ShowValues, le1HideValues, editMethod);
        return html;
        return html;
    }

    function fillLe2RowData(popTable){
        var le2Obj = caseEdit.getPopObj(popTable);

        var le2ShowFields = ['xDt', 'resultContent', 'detectionUnit'];
        var le2HideFields = [];
        var le2ShowValues = [le2Obj.xDt, le2Obj.resultContent, le2Obj.detectionUnit];
        var le2HideValues = [];
        var editMethod = "hiwhpaiCase.popupLe(this, 'edit', 2)";
        var html = caseEdit.generateTrHtml(le2ShowFields, le2HideFields, le2ShowValues, le2HideValues, editMethod);
        return html;
    }

    function fillLe3RowData(popTable){
        var le3Obj = caseEdit.getPopObj(popTable);

        var le3ShowFields = ['ctDt', 'resultContent', 'detectionUnit'];
        var le3HideFields = [];
        var le3ShowValues = [le3Obj.ctDt, le3Obj.resultContent, le3Obj.detectionUnit];
        var le3HideValues = [];
        var editMethod = "hiwhpaiCase.popupLe(this, 'edit', 3)";
        var html = caseEdit.generateTrHtml(le3ShowFields, le3HideFields, le3ShowValues, le3HideValues, editMethod);
        return html;
    }

    function fillLe4RowData(popTable){
        var le4Obj = caseEdit.getPopObj(popTable);

        var le4ShowFields = ['sampleType', 'collectDt', 'method', 'checkResult', 'detectionUnit', 'checkFt'];
        var le4HideFields = [];
        var le4ShowValues = [le4Obj.sampleType, le4Obj.collectDt, le4Obj.method, le4Obj.checkResult, le4Obj.detectionUnit, le4Obj.checkFt];
        var le4HideValues = [];
        var editMethod = "hiwhpaiCase.popupLe(this, 'edit', 4)";
        var html = caseEdit.generateTrHtml(le4ShowFields, le4HideFields, le4ShowValues, le4HideValues, editMethod);
        return html;
    }

    function getRadioValue(radioName){
        var val = $("input[name="+radioName+"]:checked").data("label");
        return val;
    }

    function getCheckBoxCodes(chkName) {
        var str="";
       /* $("input[name="+chkName+"]:checkbox").each(function(){
            if($(this).attr("checked")){
                str += $(this).val()+","
            }
        })*/
        $("input[name="+chkName+"]:checked").each(function(){          
             str += $(this).val()+","
        })
        str = str.substring(0,str.length-1);
        return str;
    }

    function getCheckBoxText(chkName) {
        var str="";
        $("input[name="+chkName+"]:checked").each(function(){
        	str += $(this).parent("label").eq(0).text()+",";
            /*if($(this).attr("checked")){
                str += $(this).nextAll("label").eq(0).text()+",";
            }*/
        })
        str = str.substring(0,str.length-1);
        return str;
    }

    return {
        toggleContactAnimal:toggleContactAnimal,
        toggleOutcome:toggleOutcome,

        popupAc:popupAc,
        saveAcData:saveAcData,

        popupEfc:popupEfc,
        saveEfcData:saveEfcData,

        popupEh:popupEh,
        saveEhData:saveEhData,

        popupHc:popupHc,
        saveHcData:saveHcData,

        popupLe:popupLe,
        saveLeData:saveLeData
    };
})();





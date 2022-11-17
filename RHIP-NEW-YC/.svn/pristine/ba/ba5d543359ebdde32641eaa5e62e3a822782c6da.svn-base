var letopspirosisCase = (function(){
	$(function(){
		$("#addLeList").click(function() {
			var leDialog = {
				url : "/idm/case/leptospirosis/contact",
				height : 180,
				width : 800,
				title : "实验室检查",
				id : "leDialog",
				param : {
					id : "leDialog"
				}
			};
			$.dialog(leDialog);
		});
		
		/*8.入院诊断：*/
		$(":input[name='attackCondition.inhosDiagnosis']").change(function(){
			toggleOther('attackCondition.inhosDiagnosis', 'inhosDiagnosisOther', 99);
		});
		toggleOther('attackCondition.inhosDiagnosis', 'inhosDiagnosisOther', 99);
		/*11.出院诊断*/
		$(":input[name='attackCondition.outDiagnosis']").change(function(){
			toggleOtherSC('attackCondition.outDiagnosis', 'outDiagnosisOther', 99);
		});
		toggleOtherSC('attackCondition.outDiagnosis', 'outDiagnosisOther', 99);
		/*13.转归：*/
		$(":input[name='otherCondition.outcomeCode']").change(function(){
			toggleOther('otherCondition.outcomeCode', 'otherConditionDeathTime', 4);
		});
		toggleOther('otherCondition.outcomeCode', 'otherConditionDeathTime', 4);
		/* 发病前1月内接触可疑疫水：*/
		$(":input[name='epidemiologicalSurvey.oneMonthDoubtfulWater']").change(function(){
			hideClassByClass('epidemiologicalSurvey.oneMonthDoubtfulWater', 'oneMonthDoubtfulWater', 1);
		});
		/*发病前1月内是否接触鼠类：*/
		$(":input[name='epidemiologicalSurvey.oneMonthMouse']").change(function(){
			hideClassByClass('epidemiologicalSurvey.oneMonthMouse','oneMonthMouse', 1);
			toggleOther('epidemiologicalSurvey.oneMonthMouseContact', 'otherPublicPlace', 99);
		});
		hideClassByClass('epidemiologicalSurvey.oneMonthMouse','oneMonthMouse', 1);
		/*如是 ，接触方式：*/
		$(":input[name='epidemiologicalSurvey.oneMonthMouseContact']").change(function(){
			toggleOther('epidemiologicalSurvey.oneMonthMouseContact', 'otherPublicPlace', 99);
		});
		toggleOther('epidemiologicalSurvey.oneMonthMouseContact', 'otherPublicPlace', 99);
		/*发病前1月内是否接触其它动物及其排泄物*/
		$(":input[name='epidemiologicalSurvey.oneMonthMouseAnimal']").change(function(){
			hideClassByClass('epidemiologicalSurvey.oneMonthMouseAnimal','oneMonthMouseAnimal', 1);
		});
		hideClassByClass('epidemiologicalSurvey.oneMonthMouseAnimal','oneMonthMouseAnimal', 1);
		/*钩体病疫苗预防接种史：*/
		$(":input[name='epidemiologicalSurvey.leptospirosisVaccination']").change(function(){
			hideClassByClass('epidemiologicalSurvey.leptospirosisVaccination','leptospirosisVaccination', 1);
		});
		hideClassByClass('epidemiologicalSurvey.leptospirosisVaccination','leptospirosisVaccination', 1);
		/*既往是否患过此病：*/
		$(":input[name='epidemiologicalSurvey.pph']").change(function(){
			hideClassByClass('epidemiologicalSurvey.pph','epidemiologicalSurveyPph', 1);
		});
		hideClassByClass('epidemiologicalSurvey.pph','epidemiologicalSurveyPph', 1);
		/*是否用激素治疗：*/
		$(":input[name='otherCondition.hormonotherapyFlg']").change(function(){
			hideClassByClass('otherCondition.hormonotherapyFlg','antibacterials', 2);
		});
		hideClassByClass('otherCondition.hormonotherapyFlg','antibacterials', 2);
        /*5 职业*/
        $(":input[name='generalCondition.occupation']").change(function() {
             toggleOtherSC('generalCondition.occupation', 'occupationOther', 'CV020120299');
        });
        toggleOtherSC('generalCondition.occupation', 'occupationOther', 'CV020120299');


        toggleOther('clinicalManifestations.fever', 'feverPart', 1);
        toggleOther('epidemiologicalSurvey.oneMonthDoubtfulWater', 'oneMonthDoubtfulWaterFromAddrd', 1);
        toggleOtherCK('otherCondition.modeInfection','modeInfection',99);
        toggleOtherCK('clinicalManifestations.urine', 'urine', 5);

    });
	
	//取消关闭对话框
	function closePopUp(dialogId) {
		$.removeDialog(dialogId);
	}
	
	//弹出框添加
	function addLeList() {
		var validate = $("#addContact").easyValidate();
		var result = validate.validateForm();
		if (!result) {
			return;
		}

		var html = fillLeRowData();
		$("#leTable").append(html);
		closePopUp('leDialog');
	}
	
	function fillLeRowData() {
		var labExam = {};
		getLabExamData(labExam, 'popLeTable');
		switch(labExam.checkItem){
			case "1":
				labExam.checkItemStr = "白细胞计数(全血)";
				break;
			case "2":
				labExam.checkItemStr = "血培养(全血)";
				break;
			case "3":
				labExam.checkItemStr = "抗体测定(血清)";
				break;
			case "4":
				labExam.checkItemStr = "尿常规(尿)";
				break;
			case "5":
				labExam.checkItemStr = "尿常规(尿)";
				break;
			case "6":
				labExam.checkItemStr = "脑脊液常规(脑脊液)";
				break;
			default:
				break;
		}
//		if(labExam.checkItem == "1"){
//			labExam.sampleStr = '唾液';
//		} 
//		if(labExam.checkItem == "2"){
//			labExam.sampleStr = '脑脊液';
//		} 
		
		var leTable = $("#leTable");
		var html = '<tr>';
		html += '<td field="checkItemStr" title="'+labExam.checkItemStr+'">' + labExam.checkItemStr + '</td>';
		html += '<td field="checkItem" style="display:none;" title="'+labExam.checkItem+'">' + labExam.checkItem
		+ '</td>';
		html += '<td field="sampleDyFirst" title="'+labExam.sampleDyFirst+'">' + labExam.sampleDyFirst + '</td>';
		html += '<td field="sampleResultFirst" title="'+labExam.sampleResultFirst+'">' + labExam.sampleResultFirst + '</td>';
		html += '<td field="sampleDySecond" title="'+labExam.sampleDySecond+'">' + labExam.sampleDySecond + '</td>';
		html += '<td field="sampleResultSecond" title="'+labExam.sampleResultSecond+'">' + labExam.sampleResultSecond + '</td>';
		html += '<td class="btnsublist" field="btn">' +
            '<a href="javascript:void(0)" onclick="letopspirosisCase.editTr(this, ' + '\'leList\'' + ')">修改</a>&nbsp;' +
            '<a href="javascript:void(0)" onclick="letopspirosisCase.removeRe(this)">删除</a>' +
            '</td>';
		html += '</tr>';
		return html;
	}
	
	function getLabExamData(labExam, tableId) {
		$("#" + tableId).find(":input").each(function(ind, obj) {
			if (obj.type == "text") {
				var inputValue = $(this).val();
				labExam[$(this).attr("id")] = inputValue;
			}
//			if (obj.type == "radio") {
//				var sexVal = $("input[name='sex']").getValue();
//				labExam['sex'] = sexVal;
//			}
			if (obj.type == 'select-one') {
				var sampleVal = $(this).val();
				labExam['checkItem'] = sampleVal;
			}
		});
	}
	
	//列表删除数据
	function removeRe(btn) {
		var extendDiv = btn.parentNode.parentNode;
		$(extendDiv).remove();
	}
	//列表修改数据
	function editTr(editBtn, part) {
		var url = '/idm/case/leptospirosis/contact';
		var id = 'leDialog';
		var title = '实验室检查';
		var extendDiv = editBtn.parentNode.parentNode;
		var rowIndex = extendDiv.rowIndex;
		var trData = {};
		$(extendDiv).find("td").each(function(tdindex, tditem) {
			var inputValue = $(tditem).text();
			if ('' != inputValue) {
				trData[$(this).attr("field")] = inputValue;
			}
		});
		var trDataStr = "[" + util.Obj2str(trData) + "]";
		var dialogs = {
			url : url,
			height : 180,
			width : 800,
			title : title,
			id : id,
			param : {
				trData : trDataStr,
				rowIndex : rowIndex,
				type : 'edit',
				id : id
			}
		};
		$.dialog(dialogs);
	}
	
	//弹出框修改
	function editLeList() {
		validate = $("#addContact").easyValidate();
		var result = validate.validateForm();
		if (!result) {
			return;
		}
		var rowIndex = $('#rowIndex').val();
		var html = fillLeRowData();
		html = html.replace("</tr>", "");
		html = html.replace("<tr>", "");
		$("#leTable tr").eq(rowIndex).html(html);
		closePopUp('leDialog');
	}
	
	
	/*
	 * 选择其他时，显示其他输入框 radioName：radio的name otherClass:otherClass,将要隐藏的类内容
	 * code:code之为radio的选择值时候，那么就执行隐藏
	 */
	function hideClassByClass(name, otherClass, code) {
		raValue = $('input[name="' + name + '"]:checked').val();
		if (raValue == code) {
			$("." + otherClass).show();
			$("." + otherClass).find("input").each(function() {
				$(this).show();
			});
		} else {
			$("." + otherClass).hide();
			$("." + otherClass).find("input[type=text]").each(function() {
				$(this).val('');
			});
			$("." + otherClass).find("input[type=radio]").each(function() {
				$(this).attr("checked", false);
			});
			$("." + otherClass).find("input[type=checkbox]").each(function() {
				$(this).attr("checked", false);
			});
			$("." + otherClass).find("select").each(function() {
				$(this).val('');
			});
		}
	}
	
	return {
		closePopUp : closePopUp,
		addLeList : addLeList,
		removeRe : removeRe,
		editTr : editTr,
		editLeList : editLeList
	}
})();
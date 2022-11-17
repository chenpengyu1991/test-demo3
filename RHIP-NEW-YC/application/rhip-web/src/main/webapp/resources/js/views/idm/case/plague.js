var plagueCase = (function() {
	$(function() {
       /* toggleOtherSC('generalCondition.occupation','occupationForAdd','CV020120299');*/
        toggleOther('clinicalManifestations.lymphadenectasis','lymphadenectasisForAdd',1);
        toggleOther('epidemiologicalSurvey.outHistory','outHistoryFromAdd',1);

		$("#addLeList").click(function() {
			var leDialog = {
				url : "/idm/case/plague/contact",
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

        caseEdit.toggerAddress();
	});

	function popEfc(){
		var efcDialog = {
				url : "/idm/case/plague/contact",
				height : 180,
				width : 800,
				title : "密切接触者登记",
				id : "efcDialog",
				param : {
					id : "efcDialog"
				}
			};
			$.dialog(efcDialog);		
	}
	
	function closePopUp(dialogId) {
		$.removeDialog(dialogId);
	}

	function addLeList() {
		validate = $("#addContact").easyValidate();
		var result = validate.validateForm();
		if (!result) {
			return;
		}

		var html = fillLeRowData();
		$("#leTable").append(html);
		closePopUp('leDialog');
	}

	function addEfcList() {
		validate = $("#addContacted").easyValidate();
		var result = validate.validateForm();
		if (!result) {
			return;
		}
		var html = fillEfcRowData();
		$("#efcTable").append(html);
		closePopUp('efcDialog');
	}

	function fillLeRowData() {
		var labExam = {};
		getLabExamData(labExam, 'popLeTable');
		if(labExam.sampleId == "1"){
			labExam.sampleStr = '唾液';
		} 
		if(labExam.sampleId == "2"){
			labExam.sampleStr = '脑脊液';
		} 
		if(labExam.sampleId == "3"){
			labExam.sampleStr = '尿液';
		} 
		if(labExam.sampleId == "4"){
			labExam.sampleStr = '鼻咽洗液';
		}
		var leTable = $("#leTable");
		var html = '<tr>';
        html += '<td field="leDt" title="'+labExam.leDt+'">' + labExam.leDt + '</td>';
        html += '<td field="sampleStr" title="'+labExam.sampleStr+'">' + labExam.sampleStr + '</td>';
		html += '<td field="sampleId" style="display:none;" title="'+labExam.sampleId+'">' + labExam.sampleId
		+ '</td>';
		html += '<td field="other" title="'+labExam.other+'">' + labExam.other + '</td>';
		html += '<td field="method" title="'+labExam.method+'">' + labExam.method + '</td>';
		html += '<td field="checkResult" title="'+labExam.checkResult+'">' + labExam.checkResult + '</td>';
		html += '<td class="btnsublist" field="btn">' +
            '<a href="javascript:void(0)" onclick="plagueCase.editTr(this, ' + '\'leList\'' + ')">修改</a>&nbsp;' +
            '<a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>' +
            '</td>';
		html += '</tr>';
		return html;
	}

	function fillEfcRowData() {
		var labExam = {};
		getLabExamData(labExam, 'popEfcTable');

		if (labExam.sex == '1') {
			labExam.sexStr = '男';
		} else if (labExam.sex == '2') {
			labExam.sexStr = '女';
		} else {
			labExam.sexStr = '';
		}

		var efcTable = $("#efcTable");
		var html = '<tr>';
		html += '<td field="name" title="'+labExam.name+'">' + labExam.name + '</td>';
		html += '<td field="sexStr" title="'+labExam.sexStr+'">' + labExam.sexStr + '</td>';
		html += '<td field="sex" style="display:none;" title="'+labExam.sex+'">' + labExam.sex
				+ '</td>';
		html += '<td field="age" title="'+labExam.age+'">' + labExam.age + '</td>';
		html += '<td field="unitAddr" title="'+labExam.unitAddr+'">' + labExam.unitAddr + '</td>';
		html += '<td field="contactType" title="'+labExam.contactType+'">' + labExam.contactType + '</td>';
		html += '<td class="btnsublist" field="btn">' +
            '<a href="javascript:void(0)" onclick="plagueCase.editTr(this, ' + '\'efcList\'' + ')">修改</a>&nbsp;' +
            '<a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>' +
            '</td>';
        html += '</tr>';
		return html;
	}

    function getLabExamData(labExam, tableId) {
		$("#" + tableId).find(":input").each(function(ind, obj) {
			var inputValue = $(this).val();
			labExam[$(this).attr("id")] = inputValue;
			/*if (obj.type == "text") {
				var inputValue = $(this).val();
				labExam[$(this).attr("id")] = inputValue;
			}
			if (obj.type == "radio") {
				var sexVal = $("input[name='sex']").getValue();			
				labExam['sex'] = sexVal;		
			}*/
			if (obj.type == 'select-one') {
				var sampleVal = $(this).val();
				labExam['sampleId'] = sampleVal;
			}
		});
	}

	function editTr(editBtn, part) {
		var url = '/idm/case';
		var id = '';
		var title = '';
		if ('leList' == part) {
			url = url + '/plague/contact';
			id = 'leDialog';
			title = '实验室检查';

		}
		if ('efcList' == part) {
			url = url + '/plague/contact';
			id = 'efcDialog';
			title = '密切接触者登记';
		}
		var extendDiv = editBtn.parentNode.parentNode;
		var rowIndex = extendDiv.rowIndex;
		var trData = {};
		$(extendDiv).find("td").each(function(tdindex, tditem) {
			var inputValue = $(tditem).text()
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
	// 修改实验室列表
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
	// 修改接触者列表
	function editEfcList() {
		validate = $("#addContacted").easyValidate();
		var result = validate.validateForm();
		if (!result) {
			return;
		}
		var rowIndex = $('#rowIndex').val();
		var html = fillEfcRowData();
		html = html.replace("</tr>", "");
		html = html.replace("<tr>", "");
		$("#efcTable tr").eq(rowIndex).html(html);
		closePopUp('efcDialog');
	}

	return {
		closePopUp : closePopUp,
		addLeList : addLeList,
		editTr : editTr,
		editLeList : editLeList,
		addEfcList : addEfcList,
		editEfcList : editEfcList,
		popEfc:popEfc
	};
})();
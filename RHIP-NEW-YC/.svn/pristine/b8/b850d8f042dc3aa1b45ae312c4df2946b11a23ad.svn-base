var caseImport = (function() {
	$(function() {
		debugger;
		var infectiousCode = $('#infectiousCodeId').val();
		var idmId = $('#idmId').val();
		var  uploader = new qq.FineUploader({
			element: $('#importFile')[0],
			request: {
				endpoint: contextPath + "/idm/case/import/uploadContacted?infectiousCode=" + infectiousCode + "&idmId=" + idmId
			},
			failedUploadTextDisplay: {
				mode: 'custom',
				maxChars: 80,
				responseProperty: 'message',
				enableTooltip: true
			},
			validation: {
				allowedExtensions: ['xls', 'xlsx']
			},
			multiple: false,
			text: {
				uploadButton: "导入",
				waitingForResponse: "导入中",
				failedUpload: "导入失败"
			},
			callbacks: {
				onSubmit: function() {
					saveEfcTable();
				},
				onComplete: function(id, name, responseJSON) {
					$(".qq-upload-success:last").append("<span>" + responseJSON.message + "</span>");
					if (responseJSON.success) {
						//刷新页面中的子表数据;
						refreshList();
					}
				}
			}
		});
	});
	
	function saveEfcTable(){
		debugger;
		var idmId = $("#idmId").val();
		var caseStatus = $('#caseStatusId').val();
		var infectiousCode = $('#infectiousCodeId').val();
        var efcTableIds = ['efcTable'];
        var efcFlags = ['0'];
		if(infectiousCode == '2011'){
			efcTableIds = ['familyTable'];
	        efcFlags = ["6"];
	        $("#efcList").val(util.Obj2str(idmCommon.getTablesData(null, efcTableIds, efcFlags, idmId)));
		}else if(infectiousCode == '2012'){
			efcTableIds = ['workOrgTable'];
	        efcFlags = ["7"];	
	        $("#efcList").val(util.Obj2str(idmCommon.getTablesData(null, efcTableIds, efcFlags, idmId)));
		}else if(infectiousCode == '3111'){
			efcTableIds = ['esTable'];
			$("#esList").val(util.Obj2str(idmCommon.getTablesData(null, efcTableIds, efcFlags, idmId)));
		}else{
			efcTableIds = ['efcTable'];
			$("#efcList").val(util.Obj2str(idmCommon.getTablesData(null, efcTableIds, efcFlags, idmId)));
		}
		$("#caseForm").submitFormGetJson({
			url : '/idm/case/import/save',
			param:{idmId:idmId,caseStatus:caseStatus,infectiousCode:infectiousCode}
		});		 
	}
	function refreshList(){
		debugger;
		var infectiousCode = $('#infectiousCodeId').val();
		var insertDiv = 'contactedList';
		if(infectiousCode == '2011'){
			insertDiv = 'contactedFamilyList';
		}else if(infectiousCode == '2012'){
			insertDiv = 'contactedWorkOrgList';
		}else if(infectiousCode == '3111'){
			insertDiv = 'contactList';
		}
		
		var idmId = $('#idmId').val();
		var searchObj = {
				url : "/idm/case/import/contactedList",
				insertDiv : insertDiv,
				param : {
					idmId : idmId,infectiousCode:infectiousCode
				}
			};
			$("#caseForm").submitFormLoadHtml(searchObj);
	}
	function downloadTemplet(infectiousCode) {
		location.href = contextPath + "/idm/case/import/downloadContactedTemplet?infectiousCode=" + infectiousCode;
	}

	return {
		downloadTemplet : downloadTemplet
	};
})();
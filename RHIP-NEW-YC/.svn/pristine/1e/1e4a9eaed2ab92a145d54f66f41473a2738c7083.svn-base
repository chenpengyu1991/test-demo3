var treatment = (function() {

	var message ="";
	var successMes="";
	var failMes="";
	
	$(function() { 
		validate = $("#tbFormTreatment").easyValidate();
        toggleOtherCK('diagnosis.complicationMulti','complicationOtherTR','99');
        toggleOther('clinicalManifestations.expectoration','symptomDuration','1');
        toggleOther('otherCondition.thisType','thisType1TR','99');
        toggleOtherSC('otherCondition.thisType1','thisTypeOtherTR','99');
        toggleOther('diagnosis.diagnosisAccording','diagnosisReasonMultiTR','2');
        toggleOtherCK('diagnosis.diagnosisReasonMulti','diagnosisOtherTR','99');
        toggleOther('otherCondition.chemotherapy','chemotherapy1','1');
        toggleOther('otherCondition.chemotherapy','chemotherapy2','2');
        toggleOther('otherCondition.chemotherapy','chemotherapy3','3');
        toggleOther('otherCondition.caseSource','caseSourceOther','99');
        search(1);
		// 高级查询条件显示控制
		$("#perAdvanceSearchConditionBtn").click(function(e) {
			e.preventDefault();
			controlAdvanceSearchSection($(this));
		});
        $("#treatmentBtnSearch").click(function(e) {
            e.preventDefault();
        	search(1);
        });
        $("#treatmentSearch").onEnter(search, 1);
        idmCommon.toggerAddress();
        idmCommon.initAdress();
        $("#check-submit-btn3").on("click", function (e) {
            e.preventDefault();
        	StartRead();
        });
	});
	
	function StartRead()//开始读卡
    {
        if (GT2ICROCX.GetState() == 0){
            GT2ICROCX.ReadCard()
        }
        $("#idcard3").val(GT2ICROCX.CardNo);
    }

	function search(indexPage) {
        $("#searchOrganCode").val(getOrgCode());
		var searchObj = {
				url : "/idm/tb/treatment/list",
				insertDiv : "listDivTreatment",
//                wait : true,
				param : {
					indexPage : indexPage
				}
			};
			$("#treatmentSearchForm").submitFormLoadHtml(searchObj);
	};

    function getOrgCode() {
        var organCode = $("#searchStation").val();
        if ($.isEmpty(organCode)) {
            organCode = $("#searchCenter").val();
        }
        if ($.isEmpty(organCode)) {
            organCode = $("#searchTown").val();
        }
        return organCode;
    }

	function searchTemp(pageIndex){
		if($.isEmpty(pageIndex)) {
			 pageIndex = $("#pageIndex").val();
		}
		disableChangeConfirm();
        var pageIndex = $("#pageIndex").val();
		$("#detailDivTreatment").empty();
		pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
		search(pageIndex);
		$("#top_allTreatment").show();		
	}	
	
	/*接受或拒绝或作废*/
	function updateSpecialStatus(idmId, singleId, specialStatus, patientName) {
		getMessage(specialStatus, patientName);
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm(message, {icon:1, title:'确认提示'}, function(index){
				$.getJsonByUrl({
					 url : "/idm/tb/treatment/update",
	                 wait : true,
					 checkRepeat:false,
					 callback:function(data){
						 if (data.indexOf("fail") > -1) {
								layer.alert(failMes, {icon:0,title:'提示'});
			                }else {
			                	layer.alert(successMes, {icon:0,title:'提示'});
			                	search($("#currentPage").val());
			                }
					 },
					 param:{
						 idmId: idmId,
						 singleId: singleId,
						 specialStatus: specialStatus
					 }
				});
				layer.close(index);
			});
		});		
	}
	
	/**
	 * 获取 确认 成功 失败 提示信息
	 */
	function getMessage(specialStatus, patientName) {
    	if (specialStatus == 7) {
    		message = '您确认要接受' + patientName + '患者治疗管理吗？';
    		successMes = '成功接受此报卡';
    		failMes = '接受此报卡失败';
    	} else if (specialStatus == 8){
    		message = '您确认要退回' + patientName + '患者治疗管理吗？';
    		successMes = '成功退回此报卡';
    		failMes = '退回此报卡失败';
    	} else if (specialStatus == 9) {
    		message = '您确认要作废' + patientName + '患者治疗管理吗？';
    		successMes = '成功作废此报卡';
    		failMes = '作废此报卡失败';
    	}
	}
	
	function selectTreatment(familyId) {
		if (!$.isEmpty(familyId)) {
			$("table[name='cardTable']").css("border-color", "#BBB");
			$("#sm_cnt" + familyId).css("border-color", "blue");
			$("#familyId").val(familyId);
		}
	}
	
	function initAssign(idmId,singleId) {
		var pageIndex = $("#currentPageTreatment").val();
		var dialogObj = {
			url : "/idm/tb/treatment/init/assign",
			width:"500",
			height:"150",
			id :'assignDialog',
			param : {
				idmId : idmId,
				singleId: singleId,
				pageIndex: pageIndex
			 },
		     title : "结核病人登记治疗管理卡分派"
		};

		$.dialog(dialogObj);
	}
	
	function saveAssign() {
		if($.isEmpty($("#orgCode").val())) {
			layer.alert("请选择纳入机构！", {icon:0,title:'提示'});
			return;
		}
		$("#tbForm").submitFormGetJson({
			url : '/idm/tb/treatment/assign/save',
            wait : true,
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                	layer.alert("保存失败！", {icon:0,title:'提示'});
                }else {
                	layer.alert("分派成功！", {icon:0,title:'提示'});
					$.removeDialog("assignDialog");
					searchTemp();
                }
            }
		});
	}

	function closePopUp(dialogId){
        $.removeDialog (dialogId);
    }
	
	return {
        search: search,
        updateSpecialStatus: updateSpecialStatus,
        selectTreatment:selectTreatment,
        initAssign: initAssign,
        saveAssign:saveAssign,
        closePopUp: closePopUp,
        searchTemp:searchTemp,
        getOrgCode:getOrgCode
	};
})();


/*$(document).ready(function () { 
	//按钮样式切换 
	$("#treatmentBtnSearch").hover( 
		function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
		}, 
		function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
		} 
	); 

});*/
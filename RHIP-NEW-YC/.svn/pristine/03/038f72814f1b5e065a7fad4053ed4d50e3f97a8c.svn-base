var deathMedicineCertificateSearch1 = (function() {
	var validation;
	$(function(){
		// 补卡默认选中
		var isAdd = $("#isAddUpdateHid").val();
		if(isAdd == '1') {
			$("#isAdd").attr("checked",'checked');
			$("#isAdd").val("1");
		}
		// 动态加载分类编号
		ajaxLoadCategoryNo();
		$("#categoryNoSelect").on("change", selectCategoryNo);
		deathSiteRadio();
		$("input[name='deathSite']").on("click", deathSiteRadio);
		noTreatReasonOtherRadio();
		$("input[name='noTreatReason']").on("click", noTreatReasonOtherRadio);
		validation = $('#childrenForm').easyValidate();
		$("#button_save").on("click", save);
		$("#childDeathSaveBack").on("click", function () {
			layer.confirm("确认离开？",function(index){
				layer.close(index);
				doBack();
			});
		});
	});
	
	function ajaxLoadCategoryNo() {
		var categoryNo = $("input[name='categoryNo']").val();
		$.getJsonByUrl({
			url : contextPath + "/childDeathReport/queryCategoryNo",
			checkRepeat : false,
			callback : function(data)
			{
				$("#categoryNoSelect").html("");
				$("#categoryNoSelect").append(data);
			},
			param : {
				categoryNo : categoryNo
			}
		});
	}
	
	/**
	 * 分类编号change事件
	 */
	function selectCategoryNo() {
		var val = $("#categoryNoSelect").val();
		$("input[name='categoryNo']").val(val);
	}
	/**
	 * 死亡地点其他输入框
	 */
	function deathSiteRadio() {
		var value = $("#deathSiteOtherMarkHid").val();
		var str = '<input type="text" style="width:80px;" reg=\'{"required":true}\' name="deathSiteOtherMark" value="'+value+'"/>';
		var deathSite = $("input[name='deathSite']:checked").val();
		if(deathSite == '4') { // 选中其他事件，需要显示其他输入框
			//$("#deathSiteOtherMarkSpan").css("display","block");
			$(str).insertBefore($("input[name='deathSite']").get(4));
		} else {
			//$("#deathSiteOtherMarkSpan").css("display","none");
			$("input[name='deathSiteOtherMark']").remove();
		}
	}
	/**
	 * 未治疗或未就医主要原因其他输入框
	 */
	function noTreatReasonOtherRadio() {
		var value = $("#noTreatReasonOtherHid").val();
		var str = '<input type="text" style="width:80px;" reg=\'{"required":true}\' name="noTreatReasonOther" value="'+value+'"/>';
		var deathSite = $("input[name='noTreatReason']:checked").val();
		if(deathSite == '6') { // 选中其他事件，需要显示其他输入框
			//$("#noTreatReasonOtherSpan").css("display","block");
			$(str).insertBefore($("input[name='noTreatReason']").get(6));
		} else {
			//$("#noTreatReasonOtherSpan").css("display","none");
			$("input[name='noTreatReasonOther']").remove();
		}
	}
	/**
	 * 保存事件
	 */
	function save() {
		var result = validation.validateForm();
        if (!result) {
            return;
        }
        if($("#isAdd").is(":checked")) { // 选中
        	$("#isAdd").val("1");
        } else { // 未选中
        	$("#isAdd").val("");
        }
        $('#childrenForm').submitFormGetJson({
            url: "/childDeathReport/save",
            wait: true,
            callback: function(result) {
                if (result.success) {
                	layer.alert("保存成功！", {icon:0,title:'提示'});
                    deathMedicineCertificateSearch.search(1);
                    doBack();
                } else {
                	layer.alert("保存失败！", {icon:0,title:'提示'});
                }
            }
        });
	}
	
	function doBack(){
        $("#childDeathListDiv").show();
        $("#childDeathDiv").hide();
    }
	
	function displayPaAddress() {
		
	}
	
	return {
		ajaxLoadCategoryNo : ajaxLoadCategoryNo,
		selectCategoryNo : selectCategoryNo,
		deathSiteRadio : deathSiteRadio,
		noTreatReasonOtherRadio : noTreatReasonOtherRadio,
		save : save,
		doBack : doBack,
		displayPaAddress:displayPaAddress
	};
})();
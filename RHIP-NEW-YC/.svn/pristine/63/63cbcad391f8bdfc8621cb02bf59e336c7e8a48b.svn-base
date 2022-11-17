!(function() {
	var validate = null;

	$(function() {

		$("#hsa-save-LocInfo-btn").on("click", save);
		$("#hsa-back-locInfo-btn").on("click", function () {
			layer.confirm("确认离开？",function(index){
				layer.close(index);
				backToList();
			});
		});
		$("#hsa-export-btn").on("click", hsaExport);

		if ($("#hsa-save-LocInfo-btn").length < 1)
		{
			var $form = $("#hsa-add-location-form");
			HsaCommon.makeFormViewOnly($form);
		} else
		{
			validate = $("#hsa-add-location-form").easyValidate();
		}
		
		HsaCommon.initSelect("#hsa-inspection-location-add-healthProfessional", "#hsa-inspection-location-add-mainBusinessCode", "/hsa/inspRecord/getMfCode");


	});

	//0165734: 【卫生计生监督协管】基础档案管理里的查看“地点信息”页面需要添加导出功能
	function hsaExport(){
        $("#hsaAddressTable").exportExcel("基础档案管理-地点信息");
    }

	function back() {
		$("#hsa-record-locationList-box").show();
		$("#hsa-record-location-input-add").hide();
		if (hsaLocationList&&hsaLocationList.search)
		{
			hsaLocationList.search(1);
		}
	}

	function save(event) {
		var result = validate.validateForm();
		if (!result)
		{
			return;
		}
		$("#hsa-add-location-form").submitFormGetJson({
			url : "/hsa/inspRecord/saveLocInfo",
			param : {},
			wait : true,
			callback : function(data) {
				
				layui.use('layer', function(){
	    			var layer = layui.layer;
	    			
	    			if ("dul" == data)
	    			{
	    				layer.alert("机构代码重复！", {icon:0,title:'提示'});
	    			} else if (data == true)
	    			{
	    				layer.alert("保存成功！", {icon:0,title:'提示'}, function() {
	    					layer.closeAll();
	    					back();
	    				});
	    			} else
	    			{
	    				layer.alert("保存失败！", {icon:0,title:'提示'});
	    			}
	    		});
				

			}
		});
	}

	function backToList() {
		$("#hsa-record-location-input-add").hide();
		$("#hsa-record-locationList-box").show();
	//	hsaLocationList.search(1);
	}
})();
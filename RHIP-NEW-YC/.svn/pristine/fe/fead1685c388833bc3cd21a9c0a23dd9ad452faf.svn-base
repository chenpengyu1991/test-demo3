!(function() {
	var validate = null;
	var validateDeal = null;
	var validateVisit = null;

	$(function() {
		$("#hsa-report-record-save-btn").on("click", save);
		$("#hsa-report-record-deal-btn").on("click", deal);
		$("#hsa-report-record-visit-btn").on("click", visit);
		$("#hsa-report-record-back-btn").on("click", function () {
			layer.confirm("确认离开？",function(index){
				layer.close(index);
				back();
			});
		});
		$("select[id='infoTypeCodeSel']").change(infoTypeCodeSelChanged);
		//新增食源性疾病报卡
		$("#addCard").click(function(e) {
			e.preventDefault();
			addCard();
		});
		validate = $("#hsa-report-record-form").easyValidate();
		validateDeal = $("#hsa-report-record-deal-form").easyValidate();
		validateVisit = $("#hsa-report-record-visit-form").easyValidate();
		var $form = $("#hsa-report-record-form");
		var infoTypeCode = $("select[id='infoTypeCodeSel']").val();
		if(infoTypeCode == '9'){
			$("#addCard").show();
		}else {
			$("#addCard").hide();
		}
	});

	function infoTypeCodeSelChanged(event) {
		var $this = $(this);
		var val = $this.val();
		if(val == '9'){
			$("#addCard").show();
		}else{
			$("#addCard").hide();
		}
	}

	//新增报卡
	function addCard() {
		$.loadHtmlByUrl({
			url : "/fdm/reportCard/initAddReport",
			insertDiv :"hsa-record-card-add",
			param : {addFrom:"bgdj"}
		});
		$("#hsa-record-card-add").show();
		$("#hsa-report-record-input-content").hide();
	}

	function back() {
		$("#hsa-report-record-content").show();
		$("#hsa-report-record-input-content").hide();
	}

	function refresh() {
		back();
		if (hsaReportRecordList && hsaReportRecordList.search)
		{
			hsaReportRecordList.search(1);
		}
	}

	function showInput() {
		$("#hsa-report-record-content").hide();
		$("#hsa-report-record-input-content").show();
	}

	function save(event) {
		event.preventDefault();
		var result = validate.validateForm();
		if (!result)
		{
			return;
		}
		doSave("#hsa-report-record-form", "/hsa/inspRecord/saveReportRecord", "保存", null);
	}

	function deal(event) {
		event.preventDefault();
		var result = validateDeal.validateForm();
		if (!result)
		{
			return;
		}
		doSave("#hsa-report-record-deal-form", "/hsa/inspRecord/dealReportRecord", "处理", colseDealOrVisit);
	}
	function visit(event) {
		event.preventDefault();
		var result = validateVisit.validateForm();
		if (!result)
		{
			return;
		}
		doSave("#hsa-report-record-visit-form", "/hsa/inspRecord/visitReportRecord", "回访", colseDealOrVisit);
	}

	function colseDealOrVisit() {
		$.removeDialog("hsa-report-record-app-dialog");
	}

	function doSave(form, url, message, callback) {
		$(form).submitFormGetJson({
			url : url,
			param : {},
			wait : true,
			callback : function(data) {
				if (data == true)
				{
					layui.use('layer', function(){
    	    			var layer = layui.layer;
    	    			layer.alert(message + "成功！", {icon:0,title:'提示'}, function() {
    	    				layer.closeAll();
    						callback && callback();
    						refresh();
    					});
    	    		});
					/*msgUtil.alert(message + "成功", function() {
						callback && callback();
						refresh();
					});*/
				} else
				{
					layui.use('layer', function(){
    	    			var layer = layui.layer;
    	    			layer.alert(message + "失败！", {icon:0,title:'提示'});
    	    		});
					/*msgUtil.alert(message + "失败");*/
				}

			}
		});
	}

})();
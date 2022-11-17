define(['views/ihm/weightSet/search'], function(weightSearch){
	function load() {
		$(function() {
			$("#backId").click(returnSearch);
			$("#saveId").click(save);
			$("#weightSetSearchChildId").click(search);
		});
	}

	function save() {
		var validate = $("#editFormWeight").easyValidate();
        var result = validate.validateForm();
        if (!result) {
            return;
        }
        if($.isEmpty($("#organCodeId").val())) {
        	$("#organCodeId").val($("#centerCodeId").val());
        	if($.isEmpty($("#centerCodeId").val())) {
            	layer.alert("请选择机构！", {icon:0,title:'提示'});
            	return;
            }
        }
        
		if (validate.validateForm()) {
			var option = {
				url : "/report/rpWeight/save",
				callback : (function(result) {
					if (result.success) {
                        weightSearch.search();
                        layer.alert("保存成功！", {icon:0,title:'提示'});
					} else {
						layer.alert(result.message, {icon:0,title:'提示'});
					}
				}),
				wait : true
			};
			$("#editFormWeight").submitFormGetJson(option);
		}
	}

	function returnSearch(){
		$("#top_all_weight").show();
		$("#detailDivWeight").hide();
	}
	function search(pageIndex){
		var searchObj = {
			url : "/report/rpWeight/child/list",
			insertDiv : "childListDiv",
			callback : function(data) {
				$("#pageIndex").val(pageIndex);
			}
		};
		$("#editFormWeight").submitFormLoadHtml(searchObj);
	}
	return{
		load: load
	}
})
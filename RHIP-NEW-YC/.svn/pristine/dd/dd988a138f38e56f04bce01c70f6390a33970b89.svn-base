var healthEducationResourceRecordEdit = (function() {
	$(function() {
		$("#healthEducationResourceRecordForm #contentType").multiselect({
			header : false,
			noneSelectedText : '请选择',
			selectedList : 2,
			minWidth : "auto"
		});

		//强制校验
		$("#healthEducationResourceRecordForm #contentType").data("validate",true);
		var validate = $("#healthEducationResourceRecordForm").easyValidate();
		$("#healthEducationResourceRecordSaveButton").click(function(e) {
			e.preventDefault();
			if (validate.validateForm()) {
				$("#healthEducationResourceRecordForm").submitFormGetJson({
					url : "/he/record/save",
					callback : submitCallback
				});
			}
		});
	});

	function editHealthEducationResourceRecord(id) {
		var type = $("#searchType").val();
		var t = "";
		if (type == 1) {
			t = "修改宣传阵地使用情况";
		} else if (type == 2) {
			t = "修改健康资料发放情况";
		}
		
		/*编辑健康教育资源*/
		/*var dialogParams = {
				id : "healthEducationResourceRecord",
				url : "/he/record/edit/"+type,
				param : {
					id : id
				},
				height : h,
				width : 800,
				title : t
		};
		$.dialog(dialogParams);*/
		
		
		$.post(contextPath+"/he/record/edit/"+type,
	    		{ id : id
			     }, 
			function(ret){
	    	layui.use(['layer'], function() {
	    		  var layer = layui.layer
	    		  layer.open({
	    			  type: 1,
	    			  id:'healthEducationResourceRecord',
	    			  area: ['900px', '380px'],
	    			  title:t,
	    			  content: ret
	    		  });
	    		});
	    	});
	}

	function deletehealthEducationResourceRecord(id) {
		if (!id) {
			return;
		}
		
		/*layer.confirm("确认删除?",function(index) {
			$.getJsonByUrl({
				url : "/he/record/delete/"+id,
				callback : function(data) {
					if (data.result) {
						healthEducationResourceRecordSearch.search(1);
					} else {
						msgUtil.alert("删除失败！");
					}
				}
			});
			layer.close(index);
		});*/
		
		layui.use('layer', function(){
			var layer = layui.layer;
			var index = layer.confirm('确认删除?', {icon:2, title:'确认提示'}, function(){
				$.getJsonByUrl({
					url : contextPath + "/he/record/delete/"+id,
					callback : function(data) {
						if (data.result) {
							layer.close(index);
							healthEducationResourceRecordSearch.search(1);
						} else {
							layer.alert("删除失败！", {icon:0,title:'提示'});
						}
					}
				});
			});
		});
	}

	function submitCallback(data) {
		/*if (data.result) {
			msgUtil.alert(data.message, function() {
				$.removeDialog("healthEducationResourceRecord");
				healthEducationResourceRecordSearch.search(1);
			});
		} else {
			msgUtil.alert(data.message);
		}*/
		
		layui.use('layer', function(){
			var layer = layui.layer;
			if (data.result) {
				var index = layer.alert(data.message, {icon:0,title:'提示'}, function() {
					layer.closeAll();
					healthEducationResourceRecordSearch.search(1);
				});
			} else {
				layer.alert(data.message, {icon:0,title:'提示'});
			}
			
		});
	}
	
	function addOtherMaterialType() {
		if ($("#healthEducationResourceRecordForm #materialType").val() == '99') {
			$("#otherMaterialType").show();
		} else {
			$("#otherMaterialType").hide().val("");
		}
	}
	
	function addOtherContentType() {
		var contentType = $("#healthEducationResourceRecordForm #contentType").val();
		if (!$.isEmpty(contentType) && String(contentType).indexOf('99') >= 0) {
			$("#otherContentType").show();
		} else {
			$("#otherContentType").hide().val("");
		}
	}
	
	return {
		editHealthEducationResourceRecord : editHealthEducationResourceRecord,
		deletehealthEducationResourceRecord : deletehealthEducationResourceRecord,
		addOtherMaterialType:addOtherMaterialType,
		addOtherContentType:addOtherContentType
	};
})();

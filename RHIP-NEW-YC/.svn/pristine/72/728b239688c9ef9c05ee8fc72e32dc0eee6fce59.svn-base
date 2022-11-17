var healthPromoteUnitEdit = (function() {
	$(function() {
		var validate = $("#healthPromoteUnitForm").easyValidate();
		$("#healthPromoteUnitSaveButton").click(function(e) {
			e.preventDefault();
			if (validate.validateForm()) {
				$("#healthPromoteUnitForm").submitFormGetJson({
					url : "/he/promoteunit/save",
					callback : submitCallback
				});
			}
		});
	});

	function editHealthPromoteUnit(id) {
		/*编辑健康督查信息*/
		/*var dialogParams = {
				id : "healthPromoteUnit",
				url : "/he/promoteunit/edit/"+id,
				height : 400,
				width : 600,
				title : "修改健康促进单位"
		};
		$.dialog(dialogParams);*/
		
		$.post(contextPath+"/he/promoteunit/edit/"+id,
				{id : id},
				function(ret){
		    	layui.use(['layer'], function() {
		    		  var layer = layui.layer
		    		  layer.open({
		    			  type: 1,
		    			  id:'edithealthPromoteUnitDialog',
		    			  area: ['600px', '400px'],
		    			  title:"修改健康促进单位",
		    			  content: ret
		    		  });
		    		});
		    	});
	}

	function deleteHealthPromoteUnit(id) {
		if (isEmpty(id)) {
			return;
		}
		
		/*layer.confirm("确认删除?",function(index) {
			$.getJsonByUrl({
				url : "/he/promoteunit/delete/"+id,
				callback : function(data) {
					if (data.result) {
						healthPromoteUnitSearch.search(1);
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
					url : contextPath + "/he/promoteunit/delete/" + id,
					callback : function(data) {
						if (data.result) {
							layer.close(index);
							healthPromoteUnitSearch.search(1);
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
			msgUtil.alert("保存成功!", function() {
				$.removeDialog("healthPromoteUnit");
				healthPromoteUnitSearch.search(1);
			});
		} else {
			msgUtil.alert("保存失败!");
		}*/
		
		layui.use('layer', function(){
			var layer = layui.layer;
			if (data.result) {
				var index = layer.alert("保存成功！", {icon:0,title:'提示'}, function() {
					layer.closeAll();
					healthPromoteUnitSearch.search(1);
				});
			} else {
				layer.alert("保存失败！", {icon:0,title:'提示'});
			}
			
		});
	}
	
	function addOtherUnitType() {
		if ($("#healthPromoteUnitForm #type").val() == '99') {
			//$("#type").parent().append("<input type=\"text\" id=\"otherType\" name=\"otherType\" style=\"width:140px;\" reg='{\"required\":\"true\"}' />");
			$("#otherType").show();
		} else {
			$("#otherType").hide().val("");
		}
	}
	
	function addOtherUnitLevel() {
		if ($("#healthPromoteUnitForm #unitLevel").val() == '99') {
			//$("#unitLevel").parent().append("<input type=\"text\" id=\"otherUnitLevel\" name=\"otherUnitLevel\" style=\"width:140px;\" reg='{\"required\":\"true\"}' />");
			$("#otherUnitLevel").show();
		} else {
			$("#otherUnitLevel").hide().val("");
		}
	}
	
	return {
		editHealthPromoteUnit : editHealthPromoteUnit,
		deleteHealthPromoteUnit : deleteHealthPromoteUnit,
		addOtherUnitType:addOtherUnitType,
		addOtherUnitLevel:addOtherUnitLevel
	};
})();

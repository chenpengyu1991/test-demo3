var healthEducationResourceMediaEdit = (function() {
	$(function() {
        // healthEducationUpload.uploadFile("heRecordFile","/he/upload/uploadFile/jjdj","/he/upload/deleteFile/jjdj");
		var validate = $("#healthEducationResourceMediaForm").easyValidate();
		$("#healthEducationResourceMediaSaveButton").click(function(e) {
			e.preventDefault();
			if (validate.validateForm()) {
				$("#healthEducationResourceMediaForm").submitFormGetJson({
					url : "/he/resource/media/save",
					callback : submitCallback
				});
			}
		});
	});

	function editHealthEducationResourceMedia(id) {

		/*编辑健康教育资源*/
		/*var dialogParams = {
				id : "healthEducationResourceMedia",
				url : "/he/resource/media/edit",
				param : {
					id : id
				},
				height : 350,
				width : 900,
				title : "编辑影像播放信息"
		};
		$.dialog(dialogParams);*/
		
		$.post(contextPath+"/he/resource/media/edit",
        		{ id : id
			     }, 
			function(ret){
        	layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'editHealthEducationResourceMediaDialog',
        			  area: ['900px', '350px'],
        			  title:"编辑影像播放信息",
        			  content: ret
        		  });
        		});
        	});
	}

	function viewHealthEducationResource(id) {
       /* var dialogParams = {
            id : "healthEducationResourceMedia",
            url : "/he/resource/media/view",
            param : {
                id : id
            },
            height : 350,
            width : 900,
            title : "查看影像播放信息"
        };
        $.dialog(dialogParams);*/
        
        $.post(contextPath+"/he/resource/media/view",
        		{ id : id
			     }, 
			function(ret){
        	layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'viewHealthEducationResourceMediaDialog',
        			  area: ['900px', '350px'],
        			  title:"查看影像播放信息",
        			  content: ret
        		  });
        		});
        	});
	}

	function deleteHealthEducationResourceMedia(id) {
		if (!id) {
			return;
		}
		
		/*layer.confirm("确认删除?",function(index) {
			$.getJsonByUrl({
				url : "/he/resource/media/delete/"+id,
				callback : function(data) {
					if (data.result) {
                        healthEducationResourceMediaSearch.search(1);
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
					url : contextPath + "/he/resource/media/delete/"+id,
					callback : function(data) {
						if (data.result) {
							layer.close(index);
							healthEducationResourceMediaSearch.search(1);
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
				$.removeDialog("healthEducationResourceMedia");
                healthEducationResourceMediaSearch.search(1);
			});
		} else {
			msgUtil.alert(data.message);
		}*/
		
		layui.use('layer', function(){
			var layer = layui.layer;
			if (data.result) {
				var index = layer.alert(data.message, {icon:0,title:'提示'}, function() {
					layer.closeAll();
					healthEducationResourceMediaSearch.search(1);
				});
			} else {
				layer.alert(data.message, {icon:0,title:'提示'});
			}
			
		});
	}
	
	return {
        editHealthEducationResourceMedia : editHealthEducationResourceMedia,
        deleteHealthEducationResourceMedia : deleteHealthEducationResourceMedia,
        viewHealthEducationResource : viewHealthEducationResource
	};
})();

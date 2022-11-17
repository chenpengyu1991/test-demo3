var familySearch = (function() {
	var pageNumber = 1;
	var isSaved = false;
	$(function() { 
		// tab切换
		/*$("#tag1").on("click", function(event)
		{
			selectTag("tagContent0", this);
			$("#selectFlagInput").attr("value", 0);
			if($("#familySearchOtherBtn").length > 0) {
				searchOther(pageNumber); 
			};
			if($("#familySearchSQBtn").length > 0) {
				searchSQ(pageNumber);
			};
		});
		$("#tag2").on("click", function(event)
		{
			selectTag("tagContent1", this);
			$("#selectFlagInput").attr("value", 1);
			if($("#familySearchOtherBtn").length > 0) {
				searchOther(pageNumber); 
			};
			if($("#familySearchSQBtn").length > 0) {
				searchSQ(pageNumber);
			};
		});*/
		
		if ($("#familySearchOtherBtn").length > 0) {
			searchOther(1); 
		};
		
		if ($("#familySearchSQBtn").length > 0) {
			searchSQ(1);
		};
			
            /*非社区查询*/
            $("#searchOtherFamilyRecord").onEnter(searchOther, 1);
            $("#familySearchOtherBtn").click(function(e) {
            	e.preventDefault();
                searchOther(1);
            });

            /*社区查询*/
            $("#searchSQFamilyRecord").onEnter(searchSQ, 1);
            $("#familySearchSQBtn").click(function(e) {
            	e.preventDefault();
                searchSQ(1);
            });

            $("#familyAdd").click(function() { 
                /*var familyDialog = {
                	id:"familyDialog",
                    url : "/family/add",
                    height : 560,
                    width : 950,
                    param : {
                        indexPage : 1
                    },
                    title : "创建家庭档案",
                    close:refresh
                };
                $.dialog(familyDialog);*/
            	$.post(contextPath+'/family/add',
    	        		{ indexPage : 1
    				     }, 
    				function(ret){
                	layui.use(['layer'], function() {
                		  var layer = layui.layer
                		  layer.open({
                			  type: 1,
                			  id:'familyEhrAdd',
                			  area: ['943px', '650px'],
                			  title:'创建家庭档案',
                			  content: ret
                		  });
                		});
                	});
            });

		$("#familyRecordListDiv").on("click",".familyLookUp", function(){
			var familyId=$("#familyId").val();
			if ($.isEmpty(familyId)) {
				layui.use('layer', function(){
	    			var layer = layui.layer;
	    			layer.alert("请先选择家庭！", {icon:0,title:'提示'});
	    		});
				return false;
			}
			var statusVal=$("#status"+familyId).val();
			if (statusVal==1) {
				layui.use('layer', function(){
	    			var layer = layui.layer;
	    			layer.alert("此家庭不能操作，请重新选择！", {icon:0,title:'提示'});
	    		});
				return false;
			}
			/*var familylookUpDialog = {
				url : "/family/lookUp",
				id:"familylookUpDialog",
				height : 560,
				width : 950,
				param : {
					indexPage : 1,
					id:$("#familyId").val()
				},
				title : "查看家庭档案",
				close:refresh
			};
			$.dialog(familylookUpDialog);*/
	        $.post(contextPath+'/family/lookUp',
	        		{indexPage : 1,
				     id:$("#familyId").val()
				     }, 
				function(ret){
            	layui.use(['layer'], function() {
            		  var layer = layui.layer
            		  layer.open({
            			  type: 1,
            			  id:'familyEhrLookUp',
            			  area: ['950px', '560px'],
            			  title:'查看家庭档案',
            			  content: ret
            		  });
            		});
            	});
		});

		$("#familyRecordListDiv").on("click",".familyUpdate", function(){
            	var familyId=$("#familyId").val();
				if ($.isEmpty(familyId)) { 
					layui.use('layer', function(){
		    			var layer = layui.layer;
		    			layer.alert("请先选择家庭！", {icon:0,title:'提示'});
		    		});
                    return false;
                }
                var statusVal=$("#status"+familyId).val();
                if (statusVal==2||statusVal==1) {
                	layui.use('layer', function(){
    	    			var layer = layui.layer;
    	    			layer.alert("此家庭不能操作，请重新选择！", {icon:0,title:'提示'});
    	    		});
                    return false;
                } 
                /*var familyUpdateDialog = {
                    url : "/family/update",
                    id:"familyUpdateDialog",
                    height : 560,
                    width : 950,
                    param : {
                        indexPage : 1,
                        id:$("#familyId").val()
                    },
                    title : "修改家庭档案",
                    close:refresh
                };
                $.dialog(familyUpdateDialog);*/
                $.post(contextPath+'/family/update',
    	        		{ indexPage : 1,
                          id:$("#familyId").val()
    				     }, 
    				function(ret){
                	layui.use(['layer'], function() {
                		  var layer = layui.layer
                		  layer.open({
                			  type: 1,
                			  id:'familyEhrUpdate',
                			  area: ['960px', '620px'],
                			  title:'修改家庭档案',
                			  content: ret
                		  });
                		});
                	});
            }); 
            $("#familyRecordListDiv").on("click",".familyOff", function() {
						var familyId=$("#familyId").val();
						if ($.isEmpty(familyId)) {
							layui.use('layer', function(){
		    	    			var layer = layui.layer;
		    	    			layer.alert("请先选择家庭！", {icon:0,title:'提示'});
		    	    		});
		                    return false;
		                }
						var statusVal=$("#status"+familyId).val();
		                if (statusVal==2||statusVal==1) {
		                	layui.use('layer', function(){
		    	    			var layer = layui.layer;
		    	    			layer.alert("此家庭不能操作，请重新选择！", {icon:0,title:'提示'});
		    	    		});
		                    return false;
		                } 
						/*var cancelFmilyDialog = {
							id:"cancelFmilyDialog",
		                    url : "/family/cancel/view",
		                    height : 310,
							width : 450,
		                    param : { 
		                    	familyId:familyId,
		                    	status:statusVal
		                    },
		                    title : "结案家庭档案"
		                };
		                $.dialog(cancelFmilyDialog);*/
		                $.post(contextPath+'/family/cancel/view',
		    	        		{ familyId:familyId,
	                    	      status:statusVal
		    				     }, 
		    				function(ret){
		                	layui.use(['layer'], function() {
		                		  var layer = layui.layer
		                		  layer.open({
		                			  type: 1,
		                			  id:'familyEhrCancel',
		                			  area: ['450px', '310px'],
		                			  title:'结案家庭档案',
		                			  content: ret
		                		  });
		                		});
		                	});
					});
            
            $("#familyRecordListDiv").on("click",".familyOffBack", function() {
            	var familyId=$("#familyId").val();
				var statusVal=$("#status"+familyId).val();
				if(familyId != null){
					if(statusVal == 1 || statusVal == 3){
						/*layer.confirm("是否撤销？",function(index){
							$.getJsonByUrl({
								url : contextPath + "/family/familyOffBack",
								param : {
									familyId : familyId,
									status : statusVal
								},
								callback : function(data){
									if(data == 0){
										searchSQ(1);
									}else {
										layer.alert("撤销失败！");
									}
								}
							});
							layer.close(index);
    					});*/
						layui.use('layer', function(){
							var layer = layui.layer;
							layer.confirm('是否撤销？', {icon:1, title:'确认提示'}, function(index){
								$.getJsonByUrl({
									url : contextPath + "/family/familyOffBack",
									param : {
										familyId : familyId,
										status : statusVal
									},
									callback : function(data){
										if(data == 0){
											layer.closeAll();
											searchSQ(1);
										}else {
											layer.alert("撤销失败！", {icon:0,title:'提示'});
										}
									}
								});
							});
						});
					}
				}
            });
            
            $("#familyApprove").click(function(){
            	var familyId=$("#familyId").val();
                if ($.isEmpty(familyId)) {
                	layer.alert("请先选择家庭！", {icon:0,title:'提示'});
                    return false;
                }
                var statusVal=$("#status"+familyId).val();
                if (statusVal!=1) {
                	layer.alert("此家庭不能操作，请重新选择！", {icon:0,title:'提示'});
                    return false;
                } 
                var cancelFmilyDialog = {
						id:"cancelFmilyDialog",
	                    url : "/family/cancel/view",
	                    height : 310,
						width : 450,
	                    param : { 
	                    	familyId:familyId,
	                    	status:statusVal
	                    },
	                    title : "审核家庭档案"
	                };
	                $.dialog(cancelFmilyDialog); 
            }); 
            
	});

	function searchSQ(indexPage) {
		pageNumber = indexPage;
    	var divName = null;
    	if($("#selectFlagInput").val() == 0){
    		divName = "familyRecordListDiv";
    	}else {
    		divName = "familyRecordCardDiv";
    	}
		var searchObj = {
			url : "/family/list/sq",
			insertDiv : divName,
			param : {
				indexPage : pageNumber,
				selectFlagName : $("#selectFlagInput").val()
			}
		};
		$("#searchSQFamilyRecord").submitFormLoadHtml(searchObj);
	};
	
	function selectFamily(familyId) {
		if (!$.isEmpty(familyId)) {
			$("table[name='cardTable']").css("border-color", "#BBB");
			$("#sm_cnt" + familyId).css("border-color", "blue");
			$("#familyId").val(familyId);
		}
	}

    function searchOther(indexPage) {
    	pageNumber = indexPage;
    	var divName = null;
    	if($("#selectFlagInput").val() == 0){
    		divName = "familyRecordListDiv";
    	}else {
    		divName = "familyRecordCardDiv";
    	}
        var searchObj = {
            url : "/family/list/other",
            insertDiv : divName,
            param : {
                indexPage : pageNumber
            }
        };
        $("#searchOtherFamilyRecord").submitFormLoadHtml(searchObj);
    };
    
    function refresh(){
		if(isSaved){
			searchSQ(pageNumber);
			isSaved = false;
		}
	}
    
	function saveClick(){
		isSaved = true;
	}
    
    function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	};
	
	function viewList() {
		$("#selectFlagInput").attr("value", 0);
		if($("#familySearchOtherBtn").length > 0) {
			searchOther(pageNumber); 
		};
		if($("#familySearchSQBtn").length > 0) {
			searchSQ(pageNumber);
		};
	}

	function viewCard() {
		$("#selectFlagInput").attr("value", 1);
		if($("#familySearchOtherBtn").length > 0) {
			searchOther(pageNumber); 
		};
		if($("#familySearchSQBtn").length > 0) {
			searchSQ(pageNumber);
		};
	}
	
	return {
        searchSQ : searchSQ,
        searchOther:searchOther,
        toggle : toggle,
        selectFamily : selectFamily,
        refresh : refresh,
		saveClick : saveClick,
		viewList : viewList,
		viewCard : viewCard
	};
})();
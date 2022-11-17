var personRecordPagination = (function() {
	var isSaved = false;
	var currentPage = 1;
	var SelectedAbleTable = function(contextId, tableId) {
		this.tableSe = "#" + tableId;
		this.contextSe = "#" + contextId;
	};

	SelectedAbleTable.prototype = {
		trSeletedClass : "listtrselect",
		trSeletedSe : " .listtrselect ",
		trSe : " tbody tr ",
		init : function() {
			$(this.contextSe).on("click", this.tableSe + this.trSe, this, function(e) {
				var outer = e.data;
				$(outer.tableSe + outer.trSe).removeClass(outer.trSeletedClass);
				$(this).addClass(outer.trSeletedClass);
			});
		},
		getSelectedTr : function() {
			return $("table tr").filter(this.trSeletedSe);
		}
	};
	var tables = new SelectedAbleTable("list_datagrid", "person_record_table");

	$(function() {
        $("#form_search #groupClassification").multiselect({
            header : false,
            noneSelectedText : '请选择',
            selectedList : 4,
            minWidth : "auto"
        });

		personSearch(1);
		tables.init();
		
		// 高级查询条件显示控制
		 $("#perAdvanceSearchConditionBtn").click(function(e) {
	            e.preventDefault();
	            controlAdvanceSearchSection($(this));
	        });
		//体检列表页面高级按钮点击事件
		$("#tjgjBtn").click(function(e) {
			e.preventDefault();
			controltjAdvanceSearchSection($(this));
		});

		$("#ehr-person-export-btn").click(function() {
			exportList();
		});

		$("#personAdd").click(function() {
			/*var personAdd = {
				url : contextPath + "/personRecord/addPersonRecordIni",
				height : 650,
				width : 900,
				param : {
					indexPage : 1
				},
				title : "创建个人健康档案",
				close : refresh
			};
			$.dialog(personAdd);*/
			/*$.post(contextPath + "/personRecord/addPersonRecordIni",{indexPage : 1}, function(ret){
				layui.use(['layer'], function() {
	        		  var layer = layui.layer
	        		  layer.open({
	        			  type: 1,
	        			  id:'createPersonEhr',
	        			  area: ['1000px', '600px'],
	        			  title:"创建个人健康档案",
	        			  content: ret,
						  end : function() {
								personSearch(1);
						  }

	        		  });
	        		});
	        	});
			*/
			$("#top_all").hide();
			$("#list_datagrid").hide();
			$.loadHtmlByUrl({
				url : '/personRecord/addPersonRecordIni',
				insertDiv :"detailDiv",
	            param : {pageIndex:1},
	            wait : true
	        });
			$("#detailDiv").show();
			
		});
		
		

		$("#dataBaAdd").click(function() {
			$.ajaxFileUpload({
				url: contextPath+"/personRecord/daBaseImport",
				secureuri:false,
				wait:true,
				data : {},
				dataType: 'json',
				success: uploadCallback,
				error: function (data, status, e) {layer.alert(e, {icon:0,title:'提示'});}
			});
		});
		function uploadCallback(data) {
			layer.alert(data.message, {icon:0,title:'提示'}, function(index){
				$("#dataBaAdd").show();
				layer.close(index);
			});
		}

		$("#list_datagrid").on("click", ".readRecord", function() {
			var selectedTr = tables.getSelectedTr();
			var personId = selectedTr.find("td .selected_value:first").val();
			/*var readRecord = {
				url : contextPath + "/personRecord/readRecord",
				height : 400,
				width : 900,
				param : {
					recordPersonId : personId
				},
				title : "调阅记录"
			};
			$.dialog(readRecord);*/
			$.post(contextPath + "/personRecord/readRecord",{recordPersonId:personId}, function(ret){
				layui.use(['layer'], function() {
	        		  var layer = layui.layer
	        		  layer.open({
	        			  type: 1,
	        			  id:'personBasicBrowse',
	        			  area: ['900px', '400px'],
	        			  title:"调阅记录",
	        			  content: ret
	        		  });
	        		});
	        	});
		});

        $("#list_datagrid").on("click", ".basicIndex", function(event) {
            event.preventDefault();
            var $this = $(this);
            var personId=$this.data("personId");
            if(personId){
                /*var dialogObj = {
                    url : "/ehrbrowser/basic/basicIndex",
                    height : 610,
                    width : 800,
                    param:{
                        personId:personId
                    },
                    title : "档案查看"
                };
                $.dialog(dialogObj);*/
            	/*$.post(contextPath + "/ehrbrowser/basic/basicIndex",{personId:personId}, function(ret){
    				layui.use(['layer'], function() {
    	        		  var layer = layui.layer
    	        		  layer.open({
    	        			  type: 1,
    	        			  id:'personBasicBrowse',
    	        			  area: ['850px', '620px'],
    	        			  title:"档案查看",
    	        			  content: ret
    	        		  });
    	        		});
    	        	});*/
            	
            	$("#top_all").hide();
    			$("#list_datagrid").hide();
    			$.loadHtmlByUrl({
    				url : '/ehrbrowser/basic/basicIndex',
    				insertDiv :"detailDiv",
    	            param : {personId:personId},
    	            wait : true
    	        });
    			$("#detailDiv").show();
            }
        });

		$("#list_datagrid").on("click", ".viewModifyTrace", function() {
			var selectedTr = tables.getSelectedTr();
			var personId = selectedTr.find("td .selected_value:first").val();
			if (personId != null)
			{
				var personId = selectedTr.find("td .selected_value:first").val();
				var personName = selectedTr.find("td .person-link-btn:first").html();

				if (personId)
				{
					/*var viewModifyTrace = {
						url : contextPath + "/personRecord/showModifyTrace",
						height : 400,
						width : 900,
						param : {
							modifyPersonId : personId
						},
						title : personName + "的档案修改痕迹浏览"
					};
					$.dialog(viewModifyTrace);*/
					
					$.post(contextPath+'/personRecord/showModifyTrace', {modifyPersonId : personId}, function(ret){
	            		layui.use(['layer'], function() {
	            			var layer = layui.layer
	            			layer.open({
	            				type: 1,
	            				id:'modifyPersonBasicTrace',
	            				area: ['1020px', '580px'],
	            				title:personName + "的档案修改痕迹浏览",
	            				content: ret
	            			});
	            		});
	            	});
				}
			} else
			{
				layui.use('layer', function(){
        			var layer = layui.layer;
        			layer.alert("请选中一行！", {icon:0,title:'提示'});
        		});
			}
			
		});

		$("#list_datagrid").on("click", ".personOffBack", function() {
			var selectedTr = tables.getSelectedTr();
			var personId = selectedTr.find("td .selected_value:first").val();
			if (personId != null)
			{
				var filingFlag = selectedTr.find("td .selected_value_off:first").val();
				if (filingFlag == 2 || filingFlag == 3)
				{
					var index = layer.confirm("是否撤销？", {icon:1, title:'确认提示'}, function() {
						$.getJsonByUrl({
							url : contextPath + "/personRecord/personOffBack",
							param : {
								personId : personId,
								filingFlag : filingFlag
							},
							callback : function(data) {
								if (data == 1)
								{
									personRecordPagination.pagination(1);
								} else
								{
									layui.use('layer', function() {
										var layer = layui.layer;
										layer.alert("迁出失败！", {icon:0,title:'提示'});
									});
								}
							}
						});
						layer.close(index);
					});
				}
			}
		});

		$("#list_datagrid").on("click", ".personOffActive", function() {
			var selectedTr = tables.getSelectedTr();
			var personId = selectedTr.find("td .selected_value:first").val();
			if (personId != null)
			{
				var filingFlag = selectedTr.find("td .selected_value_off:first").val();
				if (filingFlag == 9)
				{
					var index = layer.confirm("确认激活该档案？", {icon:1, title:'确认提示'}, function() {
						$.getJsonByUrl({
							url : contextPath + "/personRecord/personOffActive",
							param : {
								personId : personId,
								filingFlag : filingFlag
							},
							callback : function(data) {
								if (data == 1)
								{
									layui.use('layer', function() {
										var layer = layui.layer;
										layer.alert("激活成功！", {icon:0,title:'提示'});
									});
									personRecordPagination.pagination(1);

								} else
								{
									layui.use('layer', function() {
										var layer = layui.layer;
										layer.alert("激活失败！", {icon:0,title:'提示'});
									});
								}
							}
						});
						layer.close(index);
					});
				}
			}
		});

		//从健康体检菜单的列表 点击体检按钮 进入体检tab
		$("#list_datagrid").on("click", ".personPhysicalExam", function() {
			var selectedTr = tables.getSelectedTr();
			var personId = selectedTr.find("td .selected_value:first").val();
			if (personId != null)
			{
					$("#top_all").hide();
					$("#list_datagrid").hide();
					$.loadHtmlByUrl({
						url : '/personRecord/addPersonRecordIni',
						insertDiv :"detailDiv",
						param : {personId : personId,
							urlFromPhysicalExam:'urlFromPhysicalExam',
							indexPage : 1},
						wait : true
					});
					$("#detailDiv").show();

			} else
			{
				layui.use('layer', function(){
					var layer = layui.layer;
					layer.alert("请选中一行！", {icon:0,title:'提示'});
				});
			}
		});

		//从健康体检菜单的列表 点击打印体检编号按钮
		$("#list_datagrid").on("click", ".printPhysicalExamNum", function() {
			var selectedTr = tables.getSelectedTr();
			var personId = selectedTr.find("td .selected_value:first").val();
			if (personId != null)
			{
				//检查有无做过体检
				$.getJsonByUrl({
					url : "/personRecord/getPhysicalExamList",
					param: {personId: personId},
					callback : function(data){
						// if(data.result == '0'){
						// 	layer.alert("未查询到体检记录，请先添加体检记录！", {icon:0,title:'提示'});
						// }else if(data.result == '1'){
						    //跳转到打印编号页面
                            $("#top_all").hide();
                            $("#list_datagrid").hide();
                            $.loadHtmlByUrl({
                                url : '/personRecord/tjbhPrint',
                                insertDiv :"detailDiv",
                                param : {personId : personId},
                                wait : true
                            });
                            $("#detailDiv").show();
						// }else {
						// layer.alert("请选择时间！", {icon:0,title:'提示'});
						// }
					}
				});

			} else
			{
				layui.use('layer', function(){
					var layer = layui.layer;
					layer.alert("请选中一行！", {icon:0,title:'提示'});
				});
			}
		});

		$("#list_datagrid").on("click", ".personModify", function() {
			var selectedTr = tables.getSelectedTr();
			var personId = selectedTr.find("td .selected_value:first").val();
			if (personId != null)
			{
				var filingFlag = selectedTr.find("td .selected_value_off:first").val();
				if (filingFlag == 9)
				{
					layer.alert("该人员已结案,不能修改！", {icon:0,title:'提示'});
					return;
				}
				if (filingFlag == 2)
				{
					layer.alert("该人员正在审核中,不能修改！", {icon:0,title:'提示'});
					return;
				}
				if (personId)
				{
					var title = $(this).attr("class") === "personModify" ? "修改个人健康档案" : "创建个人健康档案";
					/*var personModify = {
						url : contextPath + "/personRecord/addPersonRecordIni",
						height : 660,
						width : 900,
						param : {
							indexPage : 1,
							personId : personId
						},
						title : title,
						close : refresh
					};
					$.dialog(personModify);*/
					/*$.post(contextPath+"/personRecord/addPersonRecordIni", {personId : personId,indexPage : 1}, function(ret){
	            		layui.use(['layer'], function() {
	            			var layer = layui.layer
	            			layer.open({
	            				type: 1,
	            				id:'modifyOrCreatePersonEhr',
	            				area: ['1100px', '600px'],
	            				title:title,
	            				content: ret,
								end : function() {
									personSearch(1);
						  		}
	            			});
	            		});
	            	});*/
					
					$("#top_all").hide();
					$("#list_datagrid").hide();
					$.loadHtmlByUrl({
						url : '/personRecord/addPersonRecordIni',
						insertDiv :"detailDiv",
			            param : {personId : personId,
			            	     indexPage : 1},
			            wait : true
			        });
					$("#detailDiv").show();
				}
			} else
			{
				layui.use('layer', function(){
        			var layer = layui.layer;
        			layer.alert("请选中一行！", {icon:0,title:'提示'});
        		});
			}
		});

		$("#list_datagrid").on("click", ".personOff", function() {
			var selectedTr = tables.getSelectedTr();
			var personId = selectedTr.find("td .selected_value:first").val();
			var personName = selectedTr.find("td .person-link-btn:first").text();
			var idCard = selectedTr.find("td .person-idcard:first").val();
			layui.use('layer', function(){
    			var layer = layui.layer;
    			
				if (personId != null) {
					var filingFlag = selectedTr.find("td .selected_value_off:first").val();
					
					if (filingFlag == 9)
					{
						layer.alert("该人员已结案,不能重复结案！", {icon:0,title:'提示'});
						return;
					}
					if (filingFlag == 2)
					{
						layer.alert("该人员正在审核中,不能结案！", {icon:0,title:'提示'});
						return;
					}
					if (filingFlag == 0)
					{
						layer.alert("该人员尚未建档,不能结案！", {icon:0,title:'提示'});
						return;
					}
					if (personId)
					{
						$("#personId").val(personId);
						var statusVal = $("#status" + personId).val();
						if (statusVal == 9 || statusVal == 2)
						{
							layer.alert("此家庭不能操作，请重新选择！", {icon:0,title:'提示'});
							return false;
						}
						/*var offDialog = {
								id : "offDialog",
								url : contextPath + "/personRecord/offPersonRecord",
								height : 410,
								width : 500,
								param : {
									personId : personId,
									personName : personName,
									status : statusVal,
									idCard : idCard
								},
								title : "结案个人健康档案"
						};
						$.dialog(offDialog);*/
						
						$.post(contextPath+"/personRecord/offPersonRecord", 
							{personId : personId,
							personName : personName,
							status : statusVal,
							idCard : idCard}, 
							function(ret){
		            		layui.use(['layer'], function() {
		            			var layer = layui.layer
		            			layer.open({
		            				type: 1,
		            				id:'offPersonRecord',
		            				area: ['700px', '480px'],
		            				title:"结案个人健康档案",
		            				content: ret
		            			});
		            		});
		            	});
						
					}
				} else
				{
					layer.alert("请选中一行！", {icon:0,title:'提示'});
				}
			});
		});

		$("#per_search_btn").click(function(event) {
			event.preventDefault();
			personSearch(1);
		});

		// 健康档案浏览器
		$("#list_datagrid").on("click", ".person-link-btn", function(event) {
			// alert(this);
			event.preventDefault();
			var $this = $(this);
			/*var dialogObj = {
				url : $this.attr("href"),
				height : 654,
				width : 1000
			};
			$.dialog(dialogObj);
			return false;*/
			
			/*$.post($this.attr("href"), function(ret){
				layui.use(['layer'], function() {
	        		  var layer = layui.layer
	        		  layer.open({
	        			  type: 1,
	        			  id:'personEhrBrowse',
	        			  area: ['1100px', '630px'],
	        			  title:"健康档案",
	        			  content: ret
	        		  });
	        		});
	        	});*/
			
			$("#top_all").hide();
			$("#list_datagrid").hide();
			$.loadHtmlByUrl({
				url : $this.attr("href"),
				insertDiv :"detailDiv",
	            param : {pageIndex:1,
	            	     viewType:'ehr' // 用来判断页面上面是否显示返回按钮
	            	    },
	            wait : true
	        });
			$("#detailDiv").show();
		});

		// Enter查询
		$("#form_search").onEnter(function() {
			personSearch(1);
		});

		$("#idCard").keyup(function() {
			var idCardValue = $("#idCard").val();
			$("#idCard").attr("value", idCardValue.toUpperCase());
		});

		$("#ehr-person-import-btn").click(function() {
			importExcel(1);
		});

		$("#list_datagrid").on("click", ".personMoveOut", function() {
			var selectedTr = tables.getSelectedTr();
			var personId = selectedTr.find("td .selected_value:first").val();
			if (personId != null) {
				var filingFlag = selectedTr.find("td .selected_value_off:first").val();
				if (filingFlag == 9) {
            		layer.alert("该人员已注销,不能迁出！", {icon:0,title:'提示'});
					return;
				}
				if (filingFlag == 2) {
            		layer.alert("该人员正在审核中,不能迁出！", {icon:0,title:'提示'});
					return;
				}
				if (personId) {
									/*layer.confirm("您确定要迁出此档案？", function (index) {
										$.getJsonByUrl({
											url: contextPath + "/personRecord/moveOut",
											param: {
												personId: personId
											}, callback: function (data) {
												if (data == 1) {
													personRecordPagination.pagination(1);
												} else {
													layer.alert("撤销失败");
												}
											}
										});
										layer.close(index);
									});*/
									
									layui.use('layer', function(){
										var layer = layui.layer;
										layer.confirm('您确定要迁出此档案？', {icon:1, title:'确认提示'}, function(index){
											$.getJsonByUrl({
												url: contextPath + "/personRecord/moveOut",
												param: {
													personId: personId
												}, callback: function (data) {
													if (data == 1) {
														personRecordPagination.pagination(1);
													} else {
														layer.alert("撤销失败！", {icon:0,title:'提示'});
													}
												}
											});
											layer.close(index);
										});
									});
				}
			} else {
        		layer.alert("请选中一行！", {icon:0,title:'提示'});
			}
		});
	});

	function importExcel() {
		var excelDialog = {
			id : "personRecordImportExcelDialog",
			url : "/personRecord/importExcel",
			height : 150,
			width : 500,
			title : "导入数据",
			param : {
			}
		};
		$.dialog(excelDialog);
	}

	function personSearch(indexPage) {
		currentPage = indexPage;
		var urlFromPhysicalExam =$("#urlFromPhysicalExam").val();
		searchCheck(function() {
			$("#form_search").submitFormLoadHtml({
				url : "/personRecord/result",
				insertDiv : "list_datagrid",
				param : {
					pageIndex : indexPage,
					urlFromPhysicalExam:urlFromPhysicalExam
				}
			});
		});
	}

	function searchCheck(callback) {

		var ageBegin = parseInt($("#beginAge").val());
		var ageEnd = parseInt($("#endAge").val());

		var createBegin = new Date($("#createBeginDate").val());
		var createEnd = new Date($("#createEndDate").val());

		var updateBegin = new Date($("#updateBeginDate").val());
		var updateEnd = new Date($("#updateEndDate").val());

		if (updateBegin > updateEnd)
		{
			layer.alert("更新开始时间不能大于建档结束时间！", {icon:0,title:'提示'});
			return;
		}

		if (ageBegin > ageEnd && createBegin > createEnd)
		{
			layer.alert("开始年龄不能大于结束年龄\n建档开始时间不能大于建档结束时间！", {icon:0,title:'提示'});
			$("#beginAge").val("");
			$("#endAge").val("");
			$("#createBeginDate").val("");
			$("#createEndDate").val("");
		} else if (createBegin > createEnd)
		{
			layer.alert("建档开始时间不能大于建档结束时间！", {icon:0,title:'提示'});
			$("#createBeginDate").val("");
			$("#createEndDate").val("");
		} else if (ageBegin > ageEnd)
		{
			layer.alert("开始年龄不能大于结束年龄！", {icon:0,title:'提示'});
			$("#beginAge").val("");
			$("#endAge").val("");
		} else
		{
			callback();
		}
	}

	function exportList() {
		//layer.alert("开发中...");
		//return;
		var option={
				url:"/personRecord/export"
		};
		searchCheck(function() {
			$("#form_search").exportListExcel(option);
		});
	}

	function refresh() {
		if (isSaved)
		{
			personSearch(currentPage);
			isSaved = false;
		}
		var removeSessionOption = {
			url : "/personRecord/removeSession"
		};
        $.getJsonByUrl(removeSessionOption);
	}
	function saveClick() {
		isSaved = true;
	}

	function closeOffDialog() {
		// alert(123);
	}

	function toggle(obj, tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	}
	
	 function returnSearch(currentPageIndex) {
		 layer.confirm("确认离开？",function(index){
			 layer.close(index);
			 $("#detailDiv").empty();
			 if(currentPageIndex !=""){
				 personSearch(currentPageIndex);
			 }else {
				 personSearch(1);
			 }

			 $("#top_all").show();
			 $("#list_datagrid").show();
		 });
	    }

	function controltjAdvanceSearchSection(btn) {
		$(".tjAdvanceSearchSection").toggle();
		if (btn.text().indexOf('高级') !== -1) {
			btn.html('<i class="iconfont">&#x60011;</i>简单');
		} else {
			btn.html('<i class="iconfont">&#x60010;</i>高级');
		}
	}

	return {
		pagination : personSearch,
		refresh : refresh,
		saveClick : saveClick,
		closeOffDialog : closeOffDialog,
		toggle : toggle,
		returnSearch:returnSearch
	};
})();

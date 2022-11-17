var staffSearch = (function() {
	function atStart() {
		search(1);
		$("#searchCondition").onEnter(search, 1);
		$("#searchButton").click(function(e) {
			e.preventDefault();
			search(1);
		});
		$("#addBtn").click(function(e) {
			e.preventDefault();
			staffEdit.editStaff('');
		});
	}

	function getOrgCode() {
		var organCode = $("#searchStation").val();
		if($.isEmpty(organCode)) {
			organCode = $("#searchCenter").val();
		}
		if($.isEmpty(organCode)) {
			organCode = $("#searchTown").val();
		}
		return organCode;
	}

	function search(indexPage) {
        $("#searchOrganCode").val(getOrgCode());
		var searchObj = {
			url : "/staff/staffList",
			insertDiv : "resultDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#searchCondition").submitFormLoadHtml(searchObj);
	}

	function closeDialog(dialogId) {
		$.removeDialog(dialogId);
	}

	return {
		atStart : atStart,
		search : search
	};
})();

var staffList = (function() {
	function atStart() {
		$("#mergeBtn").click(function(){
			staffMergeSplit.merge();
		});
		$("#splitBtn").click(function(){
			staffMergeSplit.split();
		});
	}

	function showStaffMainDetail(smpiId) {
		/*var dialogParams = {
			id : "staffMainInfoDialog",
			url : "/staff/staffMainInfo",
			height : 650,
			width : 950,
			title : "人员详细信息",
			param : {
				smpiId : smpiId
			}
		};
		$.dialog(dialogParams);*/
		
		$.post(contextPath+'/staff/staffMainInfo',
				{
			     smpiId : smpiId
				},
				function(ret){
	        		  layer.open({
	        			  type: 1,
	        			  id:'staffMainInfoDialog',
	        			  area: ['950px', '650px'],
	        			  title:'人员详细信息',
	        			  content: ret
	        		  });
	        	});
	}

	function showStaffDetail(staffCode, idCard) {
		/*var dialogParams = {
			id : "staffInfoDialog",
			url : "/staff/staffInfo",
			height : 650,
			width : 950,
			title : "人员本地系统详细信息",
			param : {
				staffCode : staffCode,
                idCard : idCard
			}
		};
		$.dialog(dialogParams);*/
		
		$.post(contextPath+'/staff/staffInfo',
				{
				staffCode : staffCode,
	            idCard : idCard
				},
				function(ret){
	        		  layer.open({
	        			  type: 1,
	        			  id:'staffInfoDialog',
	        			  area: ['950px', '650px'],
	        			  title:'人员本地系统详细信息',
	        			  content: ret
	        		  });
	        	});
	}

	var selectTrObj;

	function showLinkStaffs(clicked, smpiId) {
		selectTrObj = $(clicked).closest("tr");
		var img = $(clicked).closest("img");
		var flag = $(clicked).attr("flg");
		//alert(flag);
		if (flag == "expandDown") {
			var link = $("#staffList tr[smpiId='"+smpiId+"']");
			if (link.val() != undefined) {
				link.show();
			} else {
				$(clicked).submitFormGetJson({
					url : "/staff/linkStaffSearch",
					callback : showSelectResult,
					param : {
						smpiId : smpiId
					}
				});
			}
			changeExpandImg(clicked, flag);
		} else if (flag == "expandUp") {
			changeExpandImg(clicked, flag);
			$("#staffList tr[smpiId='"+smpiId+"']").hide();
		};
	}

	function changeExpandImg(clicked, flag) {
		$(clicked).empty();
		var img;
		if (flag == "expandDown") {
			img = '<img src="'+contextPath+'/images/btn/expandUp.png"/>';
			$(clicked).attr("flg", "expandUp");
		} else {
			img = '<img src="'+contextPath+'/images/btn/expandDown.png"/>';
			$(clicked).attr("flg", "expandDown");
		}
		$(clicked).append(img);
	}

	function showSelectResult(list) {
		//alert(dump_obj(list));
		if (list == null) {
			layer.alert("没有找到相关联的人员！", {icon:0,title:'提示'});
			/*layer.alert("没有找到相关联的人员");*/
			return;
		}
		var html = '';
		for (var i in list) {
			html += '<tr smpiId="'+getStaffVal(list[i].smpiId)+'">'
				+ '<td style="text-align:center;">'
				+ '<input type="checkbox" name="'+getStaffVal(list[i].smpiId)+'" class="chk_selectone" checkLevel="staff" onclick="staffList.allSelected(this)" value="'+list[i].staffCode+'"/>'
				+ '</td>'
				+ '<td></td>'
				+ '<td style="text-align:center;">'+getStaffVal(list[i].idCard)+'</td>'
				+ '<td style="text-align:center;" title="'+getStaffVal(list[i].name)+'"><a href="#" onclick="staffList.showStaffDetail('+list[i].staffCode+')">'+getStaffVal(list[i].name)+'</td>'
				+ '<td style="text-align:center;">'+getStaffVal(list[i].gender)+'</td>'
				+ '<td style="text-align:center;">'+getStaffVal(list[i].mobile)+'</td>'
				+ '<td title="'+getStaffVal(list[i].organCode)+'">'+getStaffVal(list[i].organCode)+'</td>'
				+ '<td title="'+getStaffVal(list[i].deptCode)+'">'+getStaffVal(list[i].deptCode)+'</td>'
				+ '<td title="'+getStaffVal(list[i].localId)+'">'+getStaffVal(list[i].localId)+'</td>'
				+ '<td style="text-align: center"><a href="#" onclick="staffEdit.editStaff('+list[i].staffCode+')">修改</a></td>'
				+ '</tr>';
		}
		$(selectTrObj).after(html);
	}

	function getStaffVal(property) {
		var val = "";
		if (property) {
			val = property;
		}
		return val;
	}

	function allSelected(chk) {
		var name = $(chk).attr("name");
		var allCheckbox = $("#staffList input[name='" + name + "']");
		for (var i = 0; i < allCheckbox.length; i++) {
			if (!allCheckbox[i].checked) {
				$("#staffList :checkbox[value='" + name + "']").attr("checked", false);
				return;
			}
		}
		$("#staffList :checkbox[value='" + name + "']").attr("checked", true);
	}

	return {
		atStart : atStart,
		showLinkStaffs : showLinkStaffs,
		showStaffMainDetail : showStaffMainDetail,
		showStaffDetail : showStaffDetail,
		allSelected : allSelected
	}
})();

var staffDetail = (function() {
	var staffCode;
	function setStaffCode(code) {
		staffCode = code;
	}

	function atStart() {
		$("#tab1").click(function() {
			selectTag("tagContent0", this);
			/*$("#tab1_c").show();
			$("#tab2_c").hide();
			$("#tab2").attr("class", "tab_t");
			$("#tab1").attr("class", "tab_t link");*/
		});
		$("#tab2").click(function() {
			selectTag("tagContent1", this);
			/*$("#tab2_c").show();
			$("#tab1_c").hide();
			$("#tab1").attr("class", "tab_t");
			$("#tab2").attr("class", "tab_t link");*/
		});
        $("#tab3").click(function() {
            selectTag("tagContent2", this);
            /*$("#tab2_c").show();
             $("#tab1_c").hide();
             $("#tab1").attr("class", "tab_t");
             $("#tab2").attr("class", "tab_t link");*/
        });
		search(1);
		searchSr(1);
	}

	function search(indexPage) {
		var searchObj = {
			url : "/staff/staffLogList",
			insertDiv : "logListDiv",
			param : {
				indexPage : indexPage,
				staffCode : staffCode
			}
		};
		$("#searchCondition").submitFormLoadHtml(searchObj);
	}

	function viewLogDetail(staffCode, updateTime) {
		/*var dialogParams = {
			id : "logInfoDialog",
			url : "/staff/viewLogDetail",
			height : 650,
			width : 850,
			title : "人员记录跟踪详细信息",
			param : {
				staffCode : staffCode,
				updateTime : updateTime
			}
		};
		$.dialog(dialogParams);*/
		
		$.post(contextPath+'/staff/viewLogDetail',
				{
				staffCode : staffCode,
				updateTime : updateTime
				},
				function(ret){
	        		  layer.open({
	        			  type: 1,
	        			  id:'logInfoDialog',
	        			  area: ['850px', '650px'],
	        			  title:'人员记录跟踪详细信息',
	        			  content: ret
	        		  });
	        	});
	}

    function searchSr(pageIndex) {
        var searchObj = {
            url : "/sr/list",
            insertDiv : "srDiv",
            param : {
                pageIndex : pageIndex,
                idCard : $("#idCardForSr").val(),
                type : "onlyView"
            }
        };
        $("#searchCondition").submitFormLoadHtml(searchObj);
    }

	return {
		setStaffCode : setStaffCode,
		atStart : atStart,
		search : search,
		viewLogDetail : viewLogDetail
	}
})();

var staffLogList = (function() {
	function atStart() {
		$("#compareBtn").click(function() {
			compare();
		});
		$("a[name='updateTime']").each(function() {
			$(this).html(util.formatOperateTime($(this).html()));
		});
	}

	function compare() {
		var checkboxes = $("#logList tr td :checkbox");
		var compareList = '';
		var checked = 0;
		for (var i in checkboxes) {
			if (checkboxes[i].checked) {
				if (compareList != '') {
					compareList += ',';
				}
				compareList += checkboxes[i].value;
				checked++;
			}
		}
		if (checked == 0) {
			layer.alert("请选择需要比较的记录！", {icon:0,title:'提示'});
			/*layer.alert("请选择需要比较的记录");*/
			return;
		} else if (checked > 2) {
			layer.alert("不能选择超过两条记录！", {icon:0,title:'提示'});
			/*layer.alert("不能选择超过两条记录");*/
			return;
		}
		/*var dialogParams = {
			url : "/staff/compareLogDetail",
			height : 650,
			width : 850,
			title : "记录跟踪详细信息比较",
			param : {
				params : compareList
			}
		};
		$.dialog(dialogParams);*/
		
		$.post(contextPath+'/staff/compareLogDetail',
				{
				params : compareList
				},
				function(ret){
	        		  layer.open({
	        			  type: 1,
	        			  id:'logInfoDialog',
	        			  area: ['850px', '650px'],
	        			  title:'记录跟踪详细信息比较',
	        			  content: ret
	        		  });
	        	});
	}

	return {
		atStart : atStart
	}
})();

var staffMergeSplit = (function() {
	function confirmStart() {
		$("#smpiSelect").change(function() {
			var searchObj = {
				url : "/staff/staffMainInfo",
				insertDiv : "staffMainDetailDiv",
				param : {
					smpiId : $("#smpiSelect").val()
				}
			};
			$("#smpiSelect").submitFormLoadHtml(searchObj);
		});
		$("#doMergeBtn").click(function() {
			doMerge();
		});
		$("#cancelMergeBtn").click(function() {
			cancelMerge();
		});
	}

	var mergeStaffIds;

	function merge() {
		var staffs = $("#staffList :checked[checkLevel='staff']");
		if (staffs.length < 2) {
			layer.alert("请选择至少两条要合并的记录！", {icon:0,title:'提示'});
			return;
		}
		var ids = new Array();
		var smpiIds = new Array();
		for (var i = 0; i < staffs.length; i++) {
			ids[i] = $(staffs[i]).val();
			smpiIds[i] = $(staffs[i]).attr("name");
		}
		mergeStaffIds = ids.toString();
		smpiIds = $.unique(smpiIds);
		smpiIds = $.unique(smpiIds);
		if (smpiIds.length < 2) {
			layer.alert("请选择不同最佳记录的人员进行合并！", {icon:0,title:'提示'});
			return;
		}
		/*var dialogParams = {
			id : "mergeDialog",
			url : "/staff/mergeConfirm",
			height : 650,
			width : 950,
			title : "合并确认",
			param : {
				staffCodes : ids.toString(),
				smpiIds : smpiIds.toString()
			}
		};
		$.dialog(dialogParams);*/
		
		$.post(contextPath+'/staff/mergeConfirm',
				{
				staffCodes : ids.toString(),
				smpiIds : smpiIds.toString()
				},
				function(ret){
	        		  layer.open({
	        			  type: 1,
	        			  id:'mergeDialog',
	        			  area: ['950px', '650px'],
	        			  title:'合并确认',
	        			  content: ret
	        		  });
	        	});
	}

	function doMerge() {
		var params = {
			url : "/staff/merge",
			callback : afterMerge,
			param :{
				smpiId : $("#smpiSelect").val(),
				staffCodes : mergeStaffIds
			}
		};
		$.getJsonByUrl(params);
	}

	function afterMerge(i) {
		mergeStaffIds = null;
		/*$.removeDialog("mergeDialog");*/
		
		var index = layer.alert("合并成功！", {icon:0,title:'提示'}, function() {
			layer.close(index);
			layer.close(index-1);
			staffSearch.search(1);
		});
	}

	function cancelMerge() {
		$.removeDialog("mergeDialog");
	}

	function split() {
		var staffs = $("#staffList :checked[checkLevel='staff']");
		if (staffs.length < 1) {
			layer.alert("请选择要拆分的记录！", {icon:0,title:'提示'});
			return;
		}
		var ids = new Array();
		var smpiIds = new Array();
		for (var i = 0; i < staffs.length; i++) {
			ids[i] = $(staffs[i]).val();
			smpiIds[i] = $(staffs[i]).attr("name");
		}
		smpiIds = $.unique(smpiIds);
		if (smpiIds.length > 1) {
			layer.alert("只能拆分同一条最佳记录下的人！", {icon:0,title:'提示'});
			return;
		}
		var sbrs = $("#staffList :checked[checkLevel='staffMain']");
		if (sbrs.length > 0) {
			layer.alert("不能拆分最佳记录下的全部人员！", {icon:0,title:'提示'});
			return;
		}
			layer.confirm("确认要拆分这些记录吗？", {icon:1, title:'确认提示'}, function(index) {
				var params = {
					url : "/staff/split",
					callback : afterSplit,
					param :{
						staffIds : ids.toString()
					}
				};
				$.getJsonByUrl(params);
				layer.close(index);
			});
	}

	function afterSplit(i) {
		staffSearch.search(1);
	}

	return {
		confirmStart : confirmStart,
		merge : merge,
		split : split
	};
})();

var staffEdit = (function() {
	var saveStatus = "";
	function editStart() {
		var validate = $("#staffEditForm").easyValidate();
		// $("#selectTown").change(function() {
		// 	var organCode = $("#selectTown").val();
		// 	$("#organCode").val(organCode);
		// });

        // $("#selectTown").change(function() {
        //     if($("#selectTown").val().indexOf("_") > -1) {
        //         $("#organCode").val('');
        //     } else {
        //         $("#organCode").val($("#selectTown").val());
        //     }
        // });

		$("#selectCenter").change(function() {
			var organCode = $("#selectCenter").val();
			$("#organCode").val(organCode);
			getDeptList(organCode);
		});
		$("#selectStation").change(function() {
			var organCode = $("#selectStation").val();
			if($.isEmpty(organCode)){
				organCode = $("#selectCenter").val();
			}
			$("#organCode").val(organCode);
			getDeptList(organCode);
		});
		$("#organCode").change(function() {
			getDeptList($("#organCode").val());
		});
		$("#idcard").blur(function() {
			checkIdCard($("#idcard").val());
		});
		$("#save").click(function(e) {
			e.preventDefault();
			var result = validate.validateForm();
			if($.isEmpty($("#selectCenter").val())){//一定要选所在机构 即二级下拉框必须不为空
				layer.alert("请选择所在机构！", {icon:0,title:'提示'});
				return;
			}
			if (!result) {
				return;
			}

            var listHonor = getTableData('honorTable');
            $("#honorString").val(util.Obj2str(listHonor));
			var option = {
				url : "/staff/registStaff",
				wait : true,
				param: {
					staffOrgStr: util.Obj2str(getTablesTextData('staffOrgTable', [], [], ''))
				},
				callback : (function(data) {
	                    if(data == 1) {
	                    	var index = layer.alert("保存成功！", {icon:0,title:'提示'}, function() {
	                    		layer.close(index);
								$("#staffCreateDiv").empty();
	                    		staffSearch.search($("#indexPage").val());
								$("#staffSearchDiv").show();
	                    	});
						} else if (data == 2) {
							var index = layer.alert("保存成功，因机构变动，该医务人员关联用户的“用户名”及“角色”信息可能存在变动;\n" +
	                            "请确认并更正相关信息！", {icon:0,title:'提示'}, function() {
								layer.close(index);
								layer.close(index-1);//staffEditDialog
								var staffCode = $("#staffCode").val();
								userDialog(staffCode);
								staffSearch.search($("#indexPage").val());
							});
						} else if (data == 0) {
							layer.alert("保存失败！", {icon:0,title:'提示'});
						} else if (data == 3) {
							layer.alert("此医务人员已存在，请重新确认！", {icon:0,title:'提示'});
						}else {
							layer.alert(data, {icon:0,title:'提示'});
						}
				})
			};
			$("#staffEditForm").submitFormGetJson(option);
		});
		$("#close").click(function() {
			layer.confirm("确认离开？",function(index){
				layer.close(index);
				$("#staffCreateDiv").empty();
				$("#staffSearchDiv").show();
			});
		});
	}

	function userDialog(staffCode) {
       /* var userDialog = {
            id :"userDialog",
            url : "/user/add",
            height : 480,
            width : 900,
            title : "添加用户",
            param : {
                staffCode:staffCode
            }
        };

        if(staffCode != 0){
            userDialog.title = "修改用户";
        }

        $.dialog(userDialog);*/
        
        
        
        $.post(contextPath+'/user/add',
				{
        		staffCode:staffCode
				},
				function(ret) {
	        		  layer.open({
	        			  type: 1,
	        			  id:'userDialog',
	        			  area: ['900px', '480px'],
	        			  title:staffCode != 0 ? "修改用户" : "添加用户",
	        			  content: ret
	        		  });
	        	});
    }
	/**
	 * 获取td中的text的值
	 * @param singleId
	 * @param tableIds
	 * @param flags
	 * @param idmId
	 * @returns {Array}
	 */
	function getTablesTextData(singleId, tableIds, flags, idmId){
		var tableData = [];
		tableData = getArrayDataForTable(singleId, tableData, 0, idmId);
		for(var i=0; i<tableIds.length; i++ ){
			tableData = getArrayDataForTable(tableIds[i], tableData,flags[i], idmId);
		}
		return tableData;
	}

	function getArrayDataForTable(tableId, tableData,flag, idmId){
		$("#"+tableId+" tr").each(function(trindex,tritem){
			if(trindex > 0){
				var trData = {};
				$(tritem).find("td").each(function(tdindex,tditem){
//                    trData['idmId'] = idmId;
					var inputValue = $(tditem).text();
					inputValue = inputValue.replace(/\t/g,'');//制表符替换
					inputValue = inputValue.replace(/\n/g,'');//换行替换
					if('' != inputValue && "undefined" !=inputValue && undefined !=inputValue ){
						trData[$(this).attr("field")] = inputValue;
					}
					trData['flag'] = flag;
				});
				tableData.push(trData);
			}
		});
		return tableData;
	}
	
	function checkIdCard(idCard) {
		if ($("#staffCode").val() == "") {
			var option = {
				url : "/staff/checkIdCard",
				param : {
					idCard : idCard,
					organCode : $("#organCode").val()
				},
				callback : (function(data) {
					if (data == 0) {
						layer.alert("此机构下已存在该医务人员，请重新确认！", {icon:0,title:'提示'});
					} else {
					}
				})
			};
			$.getJsonByUrl(option);
		}
	}

	function getDeptList(organCode) {
		var option = {
			url : "/staff/getDept",
			param : {
				organCode : organCode
			},
			callback : showDeptList
		};
		$.getJsonByUrl(option);
	}

	function showDeptList(list) {
		var select = $("#deptSelect");
		select.empty();
		var html = '<option value="">请选择</option>';
		for (var i in list) {
			html += '<option value="' + list[i].deptCode+ '">' + list[i].deptName + '</option>';
		}
		$(select).append(html);
	}

	function editStaff(staffCode) {
		/*var title = '修改医务人员';
		if($.isEmpty(staffCode)) {
            title = '新增医务人员';
		}
		var dialogParams = {
			id : "staffEditDialog",
			url : "/staff/staffEdit",
			height : 550,
			width : 900,
			title : title,
			param : {
				staffCode : staffCode
			}
		};
		$.dialog(dialogParams);*/
		
/*		$.post(contextPath+'/staff/staffEdit',
				{
			    staffCode : staffCode
				},
				function(ret){
	        		  layer.open({
	        			  type: 1,
	        			  id:'staffEditDialog',
	        			  area: ['950px', '650px'],
	        			  title:title,
	        			  content: ret
	        		  });
	        	});*/
		$("#staffSearchDiv").hide();
		$.loadHtmlByUrl({
			url : contextPath+'/staff/staffEdit',
			param : {staffCode : staffCode},
			insertDiv :"staffCreateDiv",
			wait:true
		});

	}

	function changeStatus(obj, staffCode, status) {
		var alertMsg;
		if (status == 0) {
			alertMsg = "是否禁用该人员？";
		} else {
			alertMsg = "是否启用该人员？";
		}
			var index = layer.confirm(alertMsg, {icon:1, title:'确认提示'}, function(index) {
				var option = {
					url : "/staff/changeStatus",
					param : {
						staffCode : staffCode,
						status : status
					},
					callback : function(data) {
						layer.close(index);
						if (data != 0) {
							staffSearch.search($("#indexPage").val());
						} else {
							layer.alert("操作失败！", {icon:0,title:'提示'}, function() {
								layer.closeAll();
								staffSearch.search($("#indexPage").val());
							});
						}
					}
				};
				$(obj).html(loadingSource);
				$.getJsonByUrl(option);
			});
	}

	function getOrgCode() {
		var organCode = $("#staffEditForm input[name='organCode'][ref='staffOrganTree']").val()
		if ($.isEmpty(organCode)) {
			organCode = $("#organCode").val();
		}
		return organCode;
	}

	function changeOrgan() {
		util.showHideDiv("organName");
		util.showHideDiv("changeOrgan");
		$("#changeOrganStatus").val("1");
	}

    /*新增一条个人荣誉*/
    function addHonor(){
        var html = '<tr>';
        html += '<th width="15%">个人荣誉</th>';
        html += '<td><input type="text" name="honorContent' + '" reg=\'{"maxlength":"20"}\' style="width:90%"/></td>';
        html += '<th>授予时间</th>';
        html += '<td><input type="text" name="honorDate' + '" reg=\'{"maxlength":"20"}\' style="width:90%"/></td>';
        html += '<th>授予单位</th>';
        html += '<td><input type="text" name="honorUnit' + '" reg=\'{"maxlength":"20"}\' style="width:90%"/></td>';
        html += '<th>执业地点</th>';
        html += '<td><input type="text" name="honorAddr' + '" reg=\'{"maxlength":"20"}\' style="width:90%"/></td>';
        html += '<td><a href="javascript:void(0)" onclick="staffEdit.removeTr(this)" title="删除"><i class="layui-icon" style="font-weight: normal;">&#xe640;</i></a></td>';
        html += '</tr>';
        $("#honorTable").append(html);
    }

    function removeTr(rmBtn){
    		var index = layer.confirm("你确定要删除此条数据吗？", {icon:2, title:'确认提示'}, function(index){
	            var extendDiv = rmBtn.parentNode.parentNode;
	            $(extendDiv).remove();
	            layer.close(index);
	    	});
    }

    function getTableData(tableId){
        var tableData = [];
        $("#"+tableId+" tr").each(function(trindex,tritem){
            {
                var trData = {};
                $(tritem).find("td").each(function(tdindex,tditem){
                    var inputValue = $(tditem).find('input').val();
                    if('' != inputValue && "undefined" != inputValue && undefined != inputValue){
                        inputValue = inputValue.replace(/\t/g,'');//制表符替换
                        inputValue = inputValue.replace(/\n/g,'');//换行替换
                        trData[$(this).find("input").attr("name")] = inputValue;
                    }
                });
                tableData.push(trData);
            }
        });
        return tableData;

    }

	function popup(btn, type){
		var param = '';
		var itemCode = $("input[name='itemCode']:visible:checked").val();
		var timeValue = $("#itemid").val();

		if("edit" == type){
			var extendDiv = btn.parentNode.parentNode;
			var rowIndex = extendDiv.rowIndex;
			var trData = {};
			$(extendDiv).find("td").each(function(tdindex,tditem){
				var inputValue = $.trim($(tditem).text());
				if('' != inputValue){
					trData[$(this).attr("field")] = inputValue;
				}
			});
			var trDataStr =  "[" + util.Obj2str(trData) + "]";
			param = {trData:trDataStr, rowIndex:rowIndex, type:'edit'};
		} else {
			param = {type:'add'};
		}
		popDialog(param);
	}

	function popDialog(param) {
		$("#staffOrgDivId").show();
		var url = "/staff/org/add";
		var loadHtmlByUrlOption = {
			url : url,
			param: param,
			insertDiv : "staffOrgDivId"
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}

	return {
		editStart : editStart,
		editStaff : editStaff,
		changeStatus : changeStatus,
		changeOrgan : changeOrgan,
        addHonor : addHonor,
		popup : popup,
        removeTr : removeTr
	};
})();


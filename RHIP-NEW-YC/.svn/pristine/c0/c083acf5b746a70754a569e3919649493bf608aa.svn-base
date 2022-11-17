var personCommon = (function() {
	/*function closeDialog(dialogId) {
		$.removeDialog(dialogId);
	}
	return {
		closeDialog : closeDialog
	}*/
})();

var personSearch = (function(){
	function atStart() {
		search(1);
		$("#searchCondition").onEnter(search, 1);
		$("#searchButton").click(function(e){
			e.preventDefault();
			search(1);
		});
		$("#mergeBtn").click(function(e){
			e.preventDefault();
			personMergeSplit.merge();
		});
		$("#splitBtn").click(function(e){
			e.preventDefault();
			personMergeSplit.split();
		});
	};

	function search(indexPage) {
		var check = checkCondition();
		if (check != null) {
			layer.alert(check, {icon:0,title:'提示'});
			return;
		}
		var searchObj = {
			url : "/person/personList",
			insertDiv : "resultDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#searchCondition").submitFormLoadHtml(searchObj);
	}

	function checkCondition() {
		var idCardNo = $("#idCardInput").val();
		var idCardType = $("#idCardSelect").val();
		if (idCardNo != "" && idCardType == "") {
			return "请选择证件类型";
		}
	}

	return {
		search : search,
		atStart : atStart
	}
})();

var personList = (function() {
	function atStart() {
		$("#mergeBtn").click(function(e){
			e.preventDefault();
			personMergeSplit.merge();
		});
		$("#splitBtn").click(function(e){
			e.preventDefault();
			personMergeSplit.split();
		});
	};

	function showSBRDetail(pmpiId) {
		$.post(contextPath+'/person/bestRecordInfo', {
			pmpiId : pmpiId
		},
		function(ret) {
		  layer.open({
			  type: 1,
			  id:"sbrInfoDialog",
			  area: ['950px', '650px'],
			  title:'个人详细信息',
			  content: ret
		  });
		});
	}

	function showPersonDetail(personId) {
		$.post(contextPath+'/person/personInfo', {
			personId : personId
		},
		function(ret) {
		  layer.open({
			  type: 1,
			  id:"personInfoDialog",
			  area: ['950px', '650px'],
			  title:'个人本地系统详细信息',
			  content: ret
		  });
		});
	}

	var selectTrObj;


	function showLinkPersons(clicked, pmpiId) {
		selectTrObj = $(clicked).closest("tr");
		var img = $(clicked).closest("img");
		var flag = $(clicked).attr("flg");
		//alert(flag);
		if (flag == "expandDown") {
			var link = $("#personList tr[pmpiId='"+pmpiId+"']");
			if (link.val() != undefined) {
				link.show();
			} else {
				$(clicked).submitFormGetJson({
					url : "/person/linkPersonSearch",
					callback : showSelectResult,
					param : {
						pmpiId : pmpiId
					}
				});
			}
			changeExpandImg(clicked, flag);
		} else if (flag == "expandUp") {
			changeExpandImg(clicked, flag);
			$("#personList tr[pmpiId='"+pmpiId+"']").hide();
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

	function getPersonVal(property) {
		var val = "";
		if (property) {
			val = property;
		}
		return val;
	}


	function showSelectResult(list) {
		//alert(dump_obj(list));
		if (list == null) {
			layer.alert("没有找到相关联的个人");
			return;
		}
		var html = '';
		for (var i in list) {
			html += '<tr pmpiId="'+getPersonVal(list[i].pmpiId)+'">'
			+ '<td style="text-align:center;">'
			+ '<input type="checkbox" name="'+getPersonVal(list[i].pmpiId)+'" class="chk_selectone" checkLevel="person" onclick="personList.allSelected(this)" value="'+list[i].personId+'"/>'
			+ '</td>'
			+ '<td></td>'
			+ '<td style="text-align:center;">'+getPersonVal(list[i].idCard)+'</td>'
			+ '<td style="text-align:center;">'+getPersonVal(list[i].otherCardType)+'</td>'
			+ '<td style="text-align:center;">'+getPersonVal(list[i].otherCardNo)+'</td>'
			+ '<td style="text-align:center;" title="'+getPersonVal(list[i].name)+'"><a href="#" onclick="personList.showPersonDetail('+list[i].personId+')">'+getPersonVal(list[i].name)+'</td>'
			+ '<td style="text-align:center;">'+getPersonVal(list[i].gender)+'</td>'
			+ '<td style="text-align:center;">'+getPersonVal(list[i].birthday)+'</td>'
			+ '<td style="text-align:center;">'+getPersonVal(list[i].phoneNumber)+'</td>'
		    + '<td style="text-align:center;" title="'+getPersonVal(list[i].paProvince)+getPersonVal(list[i].paCity)+getPersonVal(list[i].paCounty)+getPersonVal(list[i].paTownship)+getPersonVal(list[i].paStreet)+getPersonVal(list[i].paHouseNumber)+'">'
	            +getPersonVal(list[i].paProvince)+getPersonVal(list[i].paCity)+getPersonVal(list[i].paCounty)+getPersonVal(list[i].paTownshipStr)+getPersonVal(list[i].paStreetStr)+getPersonVal(list[i].paHouseNumber)+'</td>'
			+ '</tr>';
		}
		$(selectTrObj).after(html);
	}

	function allSelected(chk) {
		var name = $(chk).attr("name");
		var allCheckbox = $("#personList input[name='" + name + "']");
		for (var i = 0; i < allCheckbox.length; i++) {
			if (!allCheckbox[i].checked) {
				$("#personList :checkbox[value='" + name + "']").attr("checked", false);
				return;
			}
		}
		$("#personList :checkbox[value='" + name + "']").attr("checked", true);
	}

	return {
		atStart : atStart,
		showLinkPersons : showLinkPersons,
		showSBRDetail : showSBRDetail,
		showPersonDetail : showPersonDetail,
		allSelected : allSelected
	}
})();

var personDetail = (function() {
	var personId;

	function setPersonId(id) {
		personId = id;
	}

	function atStart() {
		$("#tab1").click(function() {
			selectTag("tagContent0", this);
			/*
			$("#tab1_c").show();
			$("#tab2_c").hide();
			$("#tab2").attr("class", "tab_t");
			$("#tab1").attr("class", "tab_t link");
			*/
		});
		$("#tab2").click(function() {
			selectTag("tagContent1", this);
			/*
			$("#tab2_c").show();
			$("#tab1_c").hide();
			$("#tab1").attr("class", "tab_t");
			$("#tab2").attr("class", "tab_t link");
			*/
		});
		search(1);
	}

	function search(indexPage) {
		var searchObj = {
			url : "/person/personLogList",
			insertDiv : "logListDiv",
			param : {
				indexPage : indexPage,
				personId : personId
			}
		};
		$("#logListDiv").submitFormLoadHtml(searchObj);
	}

	function viewLogDetail(personId, updateTime) {
		$.post(contextPath+'/person/viewLogDetail', {
			personId : personId,
			updateTime : updateTime
		},
		function(ret) {
		  layer.open({
			  type: 1,
			  id:"logInfoDialog",
			  area: ['950px', '650px'],
			  title:'个人记录跟踪详细信息',
			  content: ret,
			  success:function(layero,index){
				  $("#closelogInfoBtn").click(function() {
						layer.close(index);
				  });
			  }
		  });
		});
	}

	return {
		setPersonId : setPersonId,
		atStart : atStart,
		search : search,
		viewLogDetail : viewLogDetail
	}
})();

var personLogList = (function () {
	function atStart() {
		$("#compareBtn").click(function(e) {
			e.preventDefault();
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
			return;
		} else if (checked > 2) {
			layer.alert("不能选择超过两条记录！", {icon:0,title:'提示'});
			return;
		}
		
		$.post(contextPath+'/person/compareLogDetail', {
			params : compareList
		},
		function(ret) {
		  layer.open({
			  type: 1,
			  area: ['950px', '650px'],
			  title:'记录跟踪详细信息比较',
			  content: ret
		  });
		});
	}

	return {
		atStart : atStart
	}
})();

var personMergeSplit = (function() {
	function confirmStart() {
		$("#pmpiSelect").change(function() {
			var searchObj = {
				url : "/person/bestRecordInfo",
				insertDiv : "sbrDetailDiv",
				param : {
					pmpiId : $("#pmpiSelect").val()
				}
			};
			$("#pmpiSelect").submitFormLoadHtml(searchObj);
		});
		$("#doMergeBtn").click(function() {
			doMerge();
		});
	}

	var mergePersonIds;

	function merge() {
		var persons = $("#personList :checked[checkLevel='person']");
		if (persons.length < 2) {
			layer.alert("请选择至少两条要合并的记录！", {icon:0,title:'提示'});
			return;
		}
		var ids = new Array();
		var pmpiIds = new Array();
		for (var i = 0; i < persons.length; i++) {
			ids[i] = $(persons[i]).val();
			pmpiIds[i] = $(persons[i]).attr("name");
		}
		mergePersonIds = ids.toString();
		pmpiIds = $.unique(pmpiIds);
		pmpiIds = $.unique(pmpiIds);
		if (pmpiIds.length < 2) {
			layer.alert("请选择不同最佳记录的个人进行合并！", {icon:0,title:'提示'});
			return;
		}
		
		$.post(contextPath+'/person/mergeConfirm', {
			personIds : ids.toString(),
			pmpiIds : pmpiIds.toString()
		},
		function(ret) {
		  layer.open({
			  type: 1,
			  id:'mergeDialog',
			  area: ['950px', '650px'],
			  title:'合并确认',
			  content: ret,
			  success:function(layero,index){
				  $("#cancelMergeBtn").click(function() {
						layer.close(index);
				  });
			  }
		  });
		});
	}

	function doMerge() {
		var params = {
			url : "/person/merge",
			callback : afterMerge,
			param :{
				pmpiId : $("#pmpiSelect").val(),
				personIds : mergePersonIds
			}
		};
		$.getJsonByUrl(params);
	}

	function afterMerge(i) {
		mergePersonIds = null;
		layer.alert("合并成功", {icon:0,title:'提示'}, function(index) {
			layer.closeAll();
			personSearch.search(1);
		});
	}

	function split() {
		var persons = $("#personList :checked[checkLevel='person']");
		if (persons.length < 1) {
			layer.alert("请选择要拆分的记录！", {icon:0,title:'提示'});
			return;
		}
		var ids = new Array();
		var pmpiIds = new Array();
		for (var i = 0; i < persons.length; i++) {
			ids[i] = $(persons[i]).val();
			pmpiIds[i] = $(persons[i]).attr("name");
		}
		pmpiIds = $.unique(pmpiIds);
		if (pmpiIds.length > 1) {
			layer.alert("只能拆分同一条最佳记录下的人！", {icon:0,title:'提示'});
			return;
		}
		var sbrs = $("#personList :checked[checkLevel='sbr']");
		if (sbrs.length > 0) {
			layer.alert("不能拆分最佳记录下的全部个人！", {icon:0,title:'提示'});
			return;
		}
		layer.confirm("确认要拆分这些记录吗？", {icon:1, title:'确认提示'}, function(index) {
			var params = {
				url : "/person/split",
				callback : afterSplit,
				param :{
					personIds : ids.toString()
				}
			};
			$.getJsonByUrl(params);
			layer.close(index);
		});
	}

	function afterSplit(i) {
		personSearch.search(1);
	}

	return {
		confirmStart : confirmStart,
		merge : merge,
		split : split
	}
})();

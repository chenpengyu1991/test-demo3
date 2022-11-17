var editRecord = (function() {
	var id = $("#id").val();
	var operationType = $("#operationType").val();
	$(function() {
		yyjbqk();//默认加载医院基本情况
		//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
		layui.use('element', function(){
			var element = layui.element;
			//一些事件监听
			element.on('tab(ohRadiolopyDepDocTab)', function(data){
				if (data.index == 0) {
					yyjbqk();
				} else if(data.index ==1) {
					yyfssbqk(1);
				} else if(data.index ==2) {
					fsfhqk();
				} else if(data.index ==3) {
					grfhyp(1);
				} else if(data.index ==4) {
					grjlda(1);
				} else if(data.index ==5) {
					pxqk(1);
				}
			});
		});
	});

	// 查询医院基本信息
	function yyjbqk() {
		changSelected('yyjbqkLi');
		$.loadHtmlByUrl({
			url : "/oh/radiologicalProtectionReport/hospitalInfo",
			insertDiv : "tagContent",
			param : {
				id : id,
				operationType : operationType
			}
		});
	}
	// 查询医院放射设备情况
	function yyfssbqk(indexPage) {
		changSelected('yyfssbqkLi');
		$.loadHtmlByUrl({
			url : "/oh/radiologicalProtectionReport/radiologicalApparatus",
			insertDiv : "tagContent",
			param : {
				indexPage : indexPage,
				hospitalId : id,
			}
		});
	}

	// 查询医院放射防护情况
	function fsfhqk() {
		changSelected('fsfhqkLi');
		$.loadHtmlByUrl({
			url : "/oh/radiologicalProtectionReport/radiologicalProtection",
			insertDiv : "tagContent",
			param : {
				hospitalId : id,
			}
		});
	}

	// 个人防护用品
	function grfhyp(indexPage) {
		changSelected('grfhypLi');
		$.loadHtmlByUrl({
			url : "/oh/radiologicalProtectionReport/protectiveEquipment",
			insertDiv : "tagContent",
			param : {
				indexPage : indexPage,
				hospitalId : id,
			}
		});
	}

	// 个人剂量档案
	function grjlda(indexPage) {
		changSelected('grjldaLi');
		$.loadHtmlByUrl({
			url : "/oh/radiologicalProtectionReport/personalDose",
			insertDiv : "tagContent",
			param : {
				indexPage : indexPage,
				hospitalId : id,
			}
		});
	}

	// 培训情况
	function pxqk(indexPage) {
		changSelected('pxqkLi');
		$.loadHtmlByUrl({
			url : "/oh/radiologicalProtectionReport/training",
			insertDiv : "tagContent",
			param : {
				indexPage : indexPage,
				hospitalId : id,
			}
		});
	}

	function changSelected(selectedLiId) {
		var selectLiArray = ['yyjbqkLi','yyfssbqkLi','fsfhqkLi','grfhypLi','fsfhjcLi','grjldaLi','pxqkLi'];
		selectLiArray.splice($.inArray(selectedLiId, selectLiArray), 1);
		for ( var i = 0; i < selectLiArray.length; i++) {
			$("#"+selectLiArray[i]).removeClass('selectTag');
		}
		$("#"+selectedLiId).addClass('selectTag');
	}
	// 保存记录
	function save() {
		var validate = $("#hospitalInfo_form").easyValidate();
		var result = validate.validateForm();
		if (!result) {
			return;
		}
		$("#hospitalInfo_form").submitFormLoadHtml({
			url : "/oh/radiologicalProtectionReport/hospitalInfo/save",
			param : {
				id : id,
				operationType : operationType
			},
			callback : function(data) {
				if (data == '1') {
					layer.alert("保存成功！", {icon:0,title:'提示'}, function(){
						$.removeDialog("hospitalInfoEdit");
						layer.closeAll();
					});
					return;
				} else {
					layer.alert("保存失败！", {icon:0,title:'提示'});
					return;
				}
			}
		});
	}

	// 取消
	function cancle() {
		backToSearch();
	}

	function backToSearch() {
		$("#mainSearchDiv").show();
		$("#record_edit").empty();
	}

	return {
		yyfssbqk : yyfssbqk,
		fsfhqk : fsfhqk,
		grfhyp : grfhyp,
		grjlda : grjlda,
		pxqk : pxqk,
		save : save,
		cancle : cancle,
		backToSearch : backToSearch
	};
})();

//预防接种首页查询
var inoculationIndex = (function() {

	$(function() {
		$("#inoculation_Search_Btn").click(function() {
			search(1);
		});
		$("#form_search").onEnter(function() {
			search(1);
		});
		search(1);
	
        });


	function excel() {
		var option={
				url : "/inoculation/excel",
				param : {}
		};
		$("#form_search").exportListExcel(option);
	}
	 
	function search(indexPage) {
			var searchObj = {
				url : "/inoculation/list",
				insertDiv : "inoculationList",
				param : {
					indexPage : indexPage
				}
			}
			$("#form_search").submitFormLoadHtml(searchObj);
		}
	
	function viewInoculation(id) {
		var viewDetail = {
				id : "viewInoculationDialog",
				url : "/inoculation/view",
				param : {
					id : id,
				},
				height : 350,
				width : 900,
				title : "预约接种信息"
		};
		$.dialog(viewDetail);
	}
	
	function addInoculation() {
		var addDetail = {
				id : "addInoculationDialog",
				url : "/inoculation/add",
				param : {
				
				},
				height : 350,
				width : 900,
				title : "新增预约接种信息"
		};
		$.dialog(addDetail);
	}
	
	function saveInoculation() {
		var vaccineType = $("#vaccineType").val();
		if ($("#inoculationInvalidFlag").val() == "1" && vaccineType =="1" ) {
			layer.alert("该患者在5年内预约过,请核实情况再操作！", {icon:0,title:'提示'});
			return;
		}
		if ($("#vaccineType1").val() == "1" && vaccineType =="1") {
			layer.alert("患者必须年满65周岁且未满85周岁！", {icon:0,title:'提示'});
			return;
		}
		if ($("#vaccineType3").val() == "1" && vaccineType =="3") {
			layer.alert("患者必须年满6个月！", {icon:0,title:'提示'});
			return;
		}
		if ($("#vaccineType4").val() == "1" && vaccineType== "4") {
			layer.alert("患者必须年满3周岁！", {icon:0,title:'提示'});
			return;
		}
		var validate = $("#addInoculationForm").easyValidate();
		if (validate.validateForm()) {
		
		$("#addInoculationForm").submitFormGetJson({
				url : "/inoculation/save",
				param : {
				
				},
				callback : function(data){
					if (data.result) {
						layer.alert(data.message, {icon:0,title:'提示'}, function(index) {
							$.removeDialog("addInoculationDialog");
							search(1);
							layer.close(index);
						});
					} else {
						layer.alert(data.message, {icon:0,title:'提示'});
					}
				}
			});
		}
	}

	function deleteInoculation(id){
		if (id) {
			var index = layer.confirm("删除预约信息，确认删除？", {icon:2, title:'确认提示'}, function() {
				var deleteDetail = {
						url : "/inoculation/delete",
						param : {
							id : id
						},
						callback : function(data) {
							if (data == "1") {
								layer.alert("删除成功！", {icon:0,title:'提示'}, function(index){
									search($("#currentPage").val());
									layer.close(index);
								});
								return;
							}
							layer.alert("删除失败！", {icon:0,title:'提示'}, function(index){
								search($("#currentPage").val());
								layer.close(index);
							});
						}
					};
				$.getJsonByUrl(deleteDetail);

				layer.close(index);
			});
		}
	}

	function finishInoculation(id){
		if (id) {
			layui.use('layer', function(){
				var layer = layui.layer;
				layer.confirm('确认该病人已接种？', {icon:1, title:'确认提示'},function(index){
					var finishDetail = {
						url : "/inoculation/finishInoculation",
						param : {
							id : id
						},
						callback : function(data) {
							if (data == "1") {
								layer.alert("标记成功！", {icon:0,title:'提示'}, function(index2) {
									search($("#currentPage").val());
									layer.close(index2);
									layer.close(index);
								});	
								return;
							}
							layer.alert("标记失败！", {icon:0,title:'提示'}, function(index2) {
								search($("#currentPage").val());
								layer.close(index2);
								layer.close(index);
							});		
						}
					};
					$.getJsonByUrl(finishDetail);
				});
			});
		}
	}
	
	function giveUpInoculation(id){
		if (id) {
			layui.use('layer', function(){
				var layer = layui.layer;
				layer.confirm('确认该病人放弃接种？', {icon:1, title:'确认提示'}, function(index){
					var giveUpDetail = {
						url : "/inoculation/giveUpInoculation",
						param : {
							id : id
						},
						callback : function(data) { 
							if (data == "1") {
								layer.alert("标记成功！", {icon:0,title:'提示'}, function(index2) {
									search($("#currentPage").val());
									layer.close(index2);
								});			
								return;
							}
							layer.alert("标记失败！", {icon:0,title:'提示'}, function(index2) {
								search($("#currentPage").val());
								layer.close(index2);
							});	
						}
					};
					$.getJsonByUrl(giveUpDetail);
					layer.close(index);
				});
			});
		}
	}
	return {
		search : search,
		excel : excel,
		viewInoculation : viewInoculation,
		saveInoculation : saveInoculation,
		addInoculation : addInoculation,
		deleteInoculation : deleteInoculation,
		finishInoculation : finishInoculation,
		giveUpInoculation : giveUpInoculation
	};
})();


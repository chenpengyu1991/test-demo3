var yyjbqk = (function() {
	$(function() { 
		initAutoSel();
	});
	// 保存记录
	function save() {
		var validate = $("#hospitalInfo_form").easyValidate();
		var result = validate.validateForm();
		if (!result) {
			return;
		}
		$("#hospitalInfo_form").submitFormLoadHtml({
			url : "/oh/radiologicalProtectionReport/hospitalInfo/save",
			callback : function(data) {
				if (data == '1') {
					layer.alert("保存成功！", {icon:0,title:'提示'}, function(){
						$.removeDialog("hospitalInfoEdit");
						mainPage.search(1);
						layer.closeAll();
					});
					return;
				} else {
					layer.alert("保存失败！", {icon:0,title:'提示'});
					layer.closeAll();
					return;
				}
			}
		});
	}

	function initAutoSel(){
		var options = {
				url : contextPath + "/oh/radiologicalProtectionReport/autoComSel",
				feild:{
					value:"organName",
					lable:"organName"
				},submitEdit:true,
				selectFun:function(data){
					if($(data).attr("address")!='null')
						$("#addr").val($(data).attr("address"));
					if($(data).attr("gradeCode")!='null')
						$("#hLevel").val($(data).attr("gradeCode"));
					if($(data).attr("artificialPerson")!='null')
						$("#legalRepr").val($(data).attr("artificialPerson"));
					
					if($(data).attr("tel")!='null')
						$("#phone").val($(data).attr("tel"));
					
				}
			};
			$("#hospitalName").selectBox(options);

	}
	
	function cancle(){
		layer.closeAll();
	}
	
	return{
		save : save,
		cancle : cancle,
		initAutoSel : initAutoSel
	};

})();

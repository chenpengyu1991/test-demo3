var reserveAdd = (function() {
    var validate = null;
	$(function() {
		$.Placeholder.init({
			query : "#idCard",
			callback : function(element) {
				getPatientInfo();
			}
		});

		validate = $("#reserveFrom").easyValidate();
		
		$("#pastreet").bind("change",function(){
			displayPaAddress();
		});
    });
	
	function getPatientInfo() {
		$("#firstFlg").hide();
		validate = $("#reserveFrom").easyValidate();
		var result = validate.validate("idcard");
		if (!result) {
			return;
		}
		var idCard = $("#idCard").val();
		
		$.getJsonByUrl({
			url:"/portal/reserve/getPerson",
			param:{
				idCard:idCard
			},
			callback:function(data){
				if(data.idcard == null){
					layer.alert("系统中无此患者信息，请手动输入患者相关信息！", {icon:0,title:'提示'});
				}
				$("#personId").val(data.id);
				$("#idcard").val(data.idcard);
				$("#name").val(data.name);
				$("#gender").val(data.gender);
				$("#unitName").val(data.unitName);
				$("#phoneNumber").val(data.phoneNumber);
				$("#idcardHos").val(data.idcardHos);
				$("#idcardFarm").val(data.idcardFarm);
				$("#patownShip").val(data.patownShip);
				var idd = $("#patownShip").attr("idd").replace('townId', '');
				getVillageOpting(idd,"pastreet",data.pastreet);
				$("#pahouseNumber").val(data.pahouseNumber);
				
				if(data.birthday != null){
					var preHit = new Date();
					preHit.setTime(data.birthday);
					$("#birthday").val(preHit.pattern("yyyy/MM/dd"));
				}
			}
		});
	}

	var resultObj = {
		repeat:"该用户已预约此科室医生",
		over:"该用户今天已预约三次，不能再进行预约",
		full:"对不起，该科室医生已约满",
		fail:"提交预约失败，建议重新登录再尝试预约"
	};
	
	function save() {

        var result = validate.validateForm();
        if (!result) {
            return;
        }
        
        var scheduleId = $("#scheduleId").val();
        
        if($.isEmpty(scheduleId)){
        	alert("请先选择要预约的医院、科室、医生");
        	return;
        }

		var option = {
			url : "/portal/reserve/save",
			callback:function(data){
				var result = resultObj[data];
				if(result == null){
					layer.alert("预约成功！", {icon:0,title:'提示'});
					backToSearch();
					reserveSearch.search(1);
					return;
				}
				layer.alert(result, {icon:0,title:'提示'});
			}
		};
		
		$("#reserveFrom").submitFormGetJson(option);
	}

	function backToSearch(){
		$("#mainSearchDiv").show();
		$("#addDiv").empty();
	}
	
	function select() {
		var success = $("#success").val();
		var startTime = $("#startTime").val();
		var endTime = $("#endTime").val();
		if (success) {
			layer.alert("请于"+startTime+"点到"+endTime+"点进行预约挂号！", {icon:0,title:'提示'});
		} else {
			var option = {
					id : "schDialogId",
					title : "挂号排班资源",
					url : "/portal/reserve/schedule",
					width : 900,
					height : 500
			};
			$.dialog(option);
		}
	}

	
	function displayPaAddress() {
		
		var town = $("#patownShip option:selected").text();
		var village = $("#pastreet option:selected").text();
		var result = '';
		if (town != '请选择')
		result = town;
		if (village != '请选择')
		result = result + village;
		$("#cccc").text(result);
		$("#paAddressDetail").val(result);
   }
	
	return {
		save : save,
		select : select,
		backToSearch:backToSearch,
		displayPaAddress:displayPaAddress
	};
})();
var savePneumoniaPage = (function(){
	var validate=null;
	//点击保存按钮
	$(function(){
		$.Placeholder.init({
			query : "#idCardTxt",
			callback : function(element) {
				getPatientInfo();
			}
		});
		validate = $("#vaccine_pneumonia_save").easyValidate();
		$("#pneumoniaSave").click(function(e){
            e.preventDefault();
			if($("#idCardTxt").val()=="输入身份证获取个人信息！")
				$("#idCardTxt").val("");
			var result=validate.validateForm();
        	if(!result){
        		return;
        	}
			vaccineSave();
		});
		
        $("#pneumoniaBack").click(function(e) {
            e.preventDefault();
			layer.confirm("确认离开？",function(index){
				layer.close(index);
				layer.closeAll();
				$("#vaccineDivIdSearch").show();
				$("#vaccineDivIdDetail").hide();
			});
        });
        mainPageH.toggerAddress();
	});
	
	//显示保存结果 ---待定
	function vaccineSave(){
		if ($("#pneumoniaVaccFlagId").val() == "1" ) {
			layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("该患者在5年内接种过,无需再接种！", {icon:0,title:'提示'});
    		});
			/*msgUtil.alert("该患者在5年内接种过,无需再接种！");*/
			return;
		}
		$("#vaccine_pneumonia_save").submitFormLoadHtml({
            url : "/ph/pneumonia/save",
            callback :function(data){
            	layui.use('layer',function(){
				var layer=layui.layer;
				if (data == "1"){
                    layer.alert("保存成功！", {icon:0,title:'提示'}, function (){
					mainPageH.search(1);
					layer.closeAll();
					$("#vaccineDivIdSearch").show();
					$("#vaccineDivIdDetail").hide();
					})
                } else {
                    layer.alert("保存失败！", {icon:0,title:'提示'});
                }
				})
            	
			}
        });
	}
	
	// 获取患者信息
	function getPatientInfo() {
		$("#firstFlg").hide();
		validate = $("#vaccine_pneumonia_save").easyValidate();
		var result = validate.validate("VaccinationDetailsDTO.suffererBaseInfoDTO.idCard");
		if (!result) {
			return;
		}
		var idCard = $("#idCardTxt").val().trim();
		$("#vaccine_pneumonia_save").submitFormGetJson({
			url : "/hospital/records/flush",
			param :{
				idCard:idCard,
				immuType:"4"  // 添加23价疫苗接种类型 需要判断5年内是否接种过  添加人：高飞  添加日期：20180403
			},
			callback : function(data){
				var birthday = (IC.getBirthday(idCard)).substring(0,4);
				if(birthday){
					var age =(new Date().getFullYear())-parseInt(birthday, 10);
				}
				$("#ageTxt").val(age);
				if($.isEmpty(data)){
					$("#pneumoniaVaccFlagId").val(""); 
					$("#nameTxt").val("");
	                $("#genderTxt").val("");
	                $("#phoneNumberTxt").val("");
	                layui.use('layer', function(){
	        			var layer = layui.layer;
	        			layer.alert("系统不存在该患者,点击保存提交患者信息！", {icon:0,title:'提示'});
	        		});
	                /*msgUtil.alert("系统不存在该患者,点击保存提交患者信息");*/
	                return;
				}
				// 判断是否5年内接种过
				if (data.pneumoniaVaccFlag == "1") {
					layui.use('layer', function(){
	        			var layer = layui.layer;
	        			layer.alert("该患者在5年内接种过,无需再接种！", {icon:0,title:'提示'});
	        		});
					/*msgUtil.alert("该患者在5年内接种过,无需再接种！");*/
					$("#pneumoniaVaccFlagId").val("1"); // 用来保存的时候判断
	                return;
				}
				if (data.ageFlag == "1") {
					layui.use('layer', function(){
	        			var layer = layui.layer;
	        			layer.alert("患者必须年满65周岁且未满85周岁，否则自费！", {icon:0,title:'提示'});
	        		});
					/*msgUtil.alert("患者必须年满65周岁且未满85周岁，否则自费！");*/
				}
                var iddStreet;
                $('#town_address').val(data.patownShip);
                if(data.patownShip!=null){
                    $("#town_address").val(data.patownShip);
                    iddStreet=$("#town_address").attr("idd").replace('townId', '');
                }
                orgUtil.getStreetOpting(iddStreet, data.pastreet, '', data.paGroup);
				$("#nameTxt").val(data.name);
				$("#genderTxt").val(data.gender);
				$("#phoneNumberTxt").val(data.phoneNumber);
				$("#text_pahouseNumber").val(data.pahouseNumber);
				$("#vaccineHistory").text(data.vaccineHistory);
				$("#diseaseHistory").text(data.diseaseHistory);
				$('input[@type=radio][name="VaccinationDetailsDTO.vaccinationMgmt.householdType"][value=' + data.householdType + ']').attr("checked",true);
				$('input[@type=radio][name="VaccinationDetailsDTO.vaccinationMgmt.domicileFalg"][value=' + data.domicileFalg + ']').attr("checked",true);
				mainPageH.toggerAddress();
				$("#pneumoniaVaccFlagId").val(""); // 5年内没有查询到记录，清空标记
				$("#ageFlagId").val(""); // 病人年满65周岁且未满85周岁，清空标记
			}
		});
	}
})();
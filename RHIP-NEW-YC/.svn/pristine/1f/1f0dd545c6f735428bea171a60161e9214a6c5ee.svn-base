var saveInfluenzaPage = (function(){
	var validate=null;
	
	//点击保存按钮
	$(function(){
		
		$.Placeholder.init({
			query : "#idCardTxt",
			callback : function(element) {
				getPatientInfo();
			}
		});
		
		validate = $("#vaccine_influenza_save").easyValidate();
		
		$("#influenzaSave").click(function(e){
            e.preventDefault();
            if($("#idCardTxt").val()=="输入身份证获取个人信息！")
				$("#idCardTxt").val("");
			var result = validate.validateForm();
        	if(!result){
        		return;
        	}
			vaccineSave();
		});

        $("#influenzaBack").click(function() {
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
		$("#vaccine_influenza_save").submitFormLoadHtml({
            url : "/ph/influenza/save",
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
	function getPatientInfo() {
		$("#firstFlg").hide();
		validate = $("#vaccine_influenza_save").easyValidate();
		var result = validate.validate("VaccinationDetailsDTO.suffererBaseInfoDTO.idCard");
		if (!result) {
			return;
		}
		var idCard = $("#idCardTxt").val().trim();
		$("#vaccine_influenza_save").submitFormGetJson({
			url : "/hospital/records/flush",
			param :{
				idCard:idCard
			},
			callback : function(data){
				var birthday = (IC.getBirthday(idCard)).substring(0,4);
				if(birthday){
					var age =(new Date().getFullYear())-parseInt(birthday, 10);
				}
				$("#ageTxt").val(age);
				if($.isEmpty(data)){
                    $("#nameTxt").val("");
                    $("#genderTxt").val("");
                    $("#phoneNumberTxt").val("");
                    layui.use('layer', function() {
            			var layer = layui.layer;
            			layer.alert("系统不存在该患者,点击保存提交患者信息！", {icon:0,title:'提示'});
               		});
                    return;
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
				$('input[@type=radio][name="VaccinationDetailsDTO.vaccinationMgmt.householdType"][value=' + data.householdType + ']').attr("checked",true);
				mainPageH.toggerAddress();				
			}
		});
	};
	
})();
var deathMedicineCertificateAdd = (function() {

	$(function(){
		$("#idcard").blur(function(){
			queryPerson();
		});

		$("#saveUpdate").click(function(){
			save("reportUpdateForm");
		});

        $("#saveAdd").click(function(){
            save("reportAddForm");
        });

		$("#backAdd").click(function(){
            layer.confirm("确认离开？",function(index){
                layer.close(index);
                back();
            });
		});
		$("#backUpdate").click(function(){
			back();
		});
        initDate();
	});
	
    function initDate() {
        layui.use('laydate', function(){
            var laydate = layui.laydate;
            laydate.render({
                elem: '#birthday'
                ,format: 'yyyy/MM/dd'
                ,max: 0
            });
            laydate.render({
                elem: '#inputDate'
                ,format: 'yyyy/MM/dd'
                ,max: 0
            });
            laydate.render({
                elem: '#deathDate'
                ,format: 'yyyy/MM/dd'
                ,max: 0
				,done:function (value) {
       				if(!$.isEmpty(value)){
       					$("#deathDate").removeClass("lose");
       				}else{
       					$("#deathDate").addClass("lose");
       				}
       			}
            });
            laydate.render({
                elem: '#fillTime'
                ,format: 'yyyy/MM/dd'
                ,max: 0
            });
            laydate.render({
                elem: '#surveyTime'
                ,format: 'yyyy/MM/dd'
                ,max: 0
            });
        });
    }

	function back() {
		$("#search").show();
  		$("#detailDivId").hide();
	}

	function add(){
        $("#search").hide();
		$("#detailDivId").show();
		var followupStatus = $("#followupStatus").val();
		var loadHtmlByUrlOption = {
			url :  "/life/deathMedicineCertificate/add",
			insertDiv : "detailDivId"
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}
	
	function queryPerson() {
        var idCard = $("#idcard").val();
        if (idCard) {
            idCard = $.trim(idCard);
        }else{
        	return;
        }
    
        $.getJsonByUrl({
            url: "/life/deathMedicineCertificate/queryPersonInfo",
            param: {
                "idcard": idCard.toUpperCase()
            },
            wait: true,
            callback: function (data) {
            	 if (data.msg !=null) {
                     layer.alert(data.msg, {icon:0,title:'提示'});
                 }else{
                	 setPersonData(data, idCard);
                     $("#saveAdd").click(function(){
                         save("reportAddForm");
                     });
                 }
            }
        });
     

    }

    function setPersonData(data, idcard) {
        if (data.id !=null) {
            $("#dis-personid").val(data.id);
            $("#dis-person-id").val(data.id);
            $('#idcard').val(data.idcard);
            $('#name').val(data.name);
            $('#inputName').val(data.inputName);
            $('#inputDate').val(data.inputDateStr);
            $("input[name='gender']").val(data.gender);
            $('#birthday').val(data.birthdayStr); 
            $('#healthFileNo').val(data.healthFileNo);
            $('#marriage').val(data.marriage);
            $('#occupation').val(data.occupation);
            if (data.nation) {
                $('#nation').val(data.nation);
            } else {
                $('#nation').val('01');
            }
            $('#education').val(data.education);
            $('#householdType').val([data.householdType]);
            $('#unitName').val(data.unitName);
            $('#age').val(data.age);
            $('#pahouseNumber').val(data.pahouseNumber);
            $("select[name='patownShip']").val(data.patownShip);
            var iddStreet;
             if(data.patownShip!=null){
                 $("#town_address").val(data.patownShip);
                 iddStreet=$("#town_address").attr("idd").replace('townId', '');
             }
            orgUtil.getStreetOpting(iddStreet, data.pastreet, '', data.paGroup);
        }else {
            //layer.alert("该患者已经结案或者未建档!");
            var birthday = IC.getBirthday(idcard);
            var gender = IC.getGender(idcard);
            var age = getAge(birthday);
            $('#age').val(age);
            $('#birthday').val(birthday);
            //$('#gender').val([gender]);
            //$("input[name='gender'][value='+gender+']").attr("checked",true);
            $('#idcard').val(idcard);
        }  

    }
    
    function save(reportForm){
    	validate = $("#"+reportForm).easyValidate();
        var result = validate.validateForm();
        if (!result) {
            return false;
        }
		$("#"+reportForm).submitFormGetJson({
            url : "/life/deathMedicineCertificate/save",
            wait : true,
            callback : function(data) {
                if (data.result > 0) {
                    layer.alert("保存成功！", {icon:0,title:'提示'});
                }else{
                	 layer.alert("该人员不能登记！", {icon:0,title:'提示'});
                }
            }
		})
	}
    /*根据出生日期获取年龄*/
    function getAge(strDate){
        if($.isEmpty($.trim(strDate))){
            return;
        }
        var age;
        var aDate=new Date();
        var thisYear=aDate.getFullYear();
        var thisMonth=aDate.getMonth()+1;
        var thisDay=aDate.getDate();
        var brith=parseDate(strDate);
        brithy=brith.getFullYear();
        brithm=brith.getMonth()+1;
        brithd=brith.getDate();
        if(thisYear-brithy<0){
            layer.alert("输入错误！", {icon:0,title:'提示'});
            age="";
        }else{
            if(thisMonth-brithm<0){
                age = thisYear-brithy-1;
            }
            else{
                if(thisDay-brithd>=0){
                    age = thisYear-brithy;
                }
                else{
                    age = thisYear-brithy-1;
                }
            }
        }
        return age;
    }

	return {
		save : save,
		add : add,
		queryPerson : queryPerson
	};
})();
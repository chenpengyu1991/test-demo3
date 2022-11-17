var idCard = (function() {
    function queryPerson(idCard) {
    	var validate = $("#caseForm").easyValidate();
        if (validate.validate("generalCondition.idcard")){
            $.getJsonByUrl({
                url : "/idm/report/queryPerson",
                callback : function(data) {
                    if(!$.isEmpty(data)){
                        if(data.flag){
                            setPersonData(data);
                            setAge(data.Idcard);
                        }else{
                            setIcData(data.Idcard);
                            setAge(data.Idcard);
                        }
                    }
                },
                param:{idCard:idCard}
            });
        }
    };

    function setPersonData(data){
        $("input[name=\'generalCondition.idCard\']:eq(0)").val(data.Idcard);
        $("input[name=\'generalCondition.name\']:eq(0)").val(data.Name); //姓名

        if($.isEmpty(data.Birthday)){
            var birthday = IC.getBirthday(data.Idcard);
            $("input[name=\'generalCondition.birthday\']:eq(0)").val(birthday); //出生日期
        }else{
            $("input[name=\'generalCondition.birthday\']:eq(0)").val(data.Birthday);  //出生日期
        }
        var gender;
        if($.isEmpty(data.Gender)){
            gender = IC.getGender(data.Idcard);
        }else{
            gender = data.Gender;
        }
        $('input[type=radio][name=\'generalCondition.gender\'][value=' + gender + ']').attr("checked",true);//性别
        $("input[name=\'generalCondition.unitName\']:eq(0)").val(data.UnitName); //工作单位
        $("input[name=\'generalCondition.phoneNumber\']:eq(0)").val(data.PhoneNumber); //联系电话
        $('#occupationId').val(data.Occupation); //职业
        toggleOtherSC('generalCondition.occupation','occupationOtherPart','CV020120299');

    };

    /*如果获取患者信息失败，根据身份证号码获取性别、出生日期*/
    function setIcData(idCard){
        var gender = IC.getGender(idCard);
        if(!$.isEmpty(gender)){
            $('input[type=radio][name=\'generalCondition.gender\'][value=' + gender + ']').attr("checked",true);//性别
        }
        var birthday = IC.getBirthday(idCard);
        if(!$.isEmpty(birthday)){
            $("input[name=\'generalCondition.birthday\']:eq(0)").val(birthday); //出生日期
        }

    }
    /*解析日期字符串*/
    function parseDate(str){

        if(str.match(/^\d{4}[\/\/\s+]\d{1,2}[\/\/\s+]\d{1,2}$/)){
            return new Date(str.replace(/[\-\/\s+]/i,'/'));
        }else if(str.match(/^\d{8}$/)){
            return new Date(str.substring(0,4)+'/'+str.substring(4,6)+'/'+str.substring(6));
        }else{
        	layer.alert('date parse error', {icon:0,title:'提示'});
        }
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

    function setAge(idNo){
        var idCardBirthDay = IC.getBirthday(idNo);
        var lastedAge = getAge(idCardBirthDay);
        $("#age").val(lastedAge);
        $("input[name=ageUnit]:eq(0)").attr("checked",'checked');
        $("input[name=\'generalCondition.ageUnit\']:eq(0)").attr("checked",'checked');
    }

	return {
        queryPerson:queryPerson
	};
})();




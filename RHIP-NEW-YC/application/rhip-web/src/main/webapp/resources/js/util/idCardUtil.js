var idCardUtil = (function() {
    var area = {
        11: "北京",
        12: "天津",
        13: "河北",
        14: "山西",
        15: "内蒙古",
        21: "辽宁",
        22: "吉林",
        23: "黑龙江",
        31: "上海",
        32: "江苏",
        33: "浙江",
        34: "安徽",
        35: "福建",
        36: "江西",
        37: "山东",
        41: "河南",
        42: "湖北",
        43: "湖南",
        44: "广东",
        45: "广西",
        46: "海南",
        50: "重庆",
        51: "四川",
        52: "贵州",
        53: "云南",
        54: "西藏",
        61: "陕西",
        62: "甘肃",
        63: "青海",
        64: "宁夏",
        65: "新疆",
        71: "台湾",
        81: "香港",
        82: "澳门",
        91: "国外"
    };

    var Wi = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1]; // 加权因子   
    var ValideCode = [1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2]; // 身份证验证位值.10代表X 
    var idcard18regex = new RegExp("^[0-9]{18}$|^[0-9]{17}[xX]$");
    var idcard15regex = new RegExp("^[0-9]{15}$");

    //检查15和18格式
    //检查地区和生日
    //18检查校验位
    function IdCardValidate(idCard) {
        idCard = trim(idCard.replace(/ /g, ""));
        if (idcard18regex.test(idCard)) {
            var a_idCard = idCard.split(""); 
            if (checkAreaCode(idCard) && isValidityBrithBy18IdCard(idCard) && isTrueValidateCodeBy18IdCard(a_idCard)) {
                return true;
            } else {
                return false;
            }
        } else if (idcard15regex.test(idCard)) {
            return checkAreaCode(idCard) && isValidityBrithBy15IdCard(idCard);
        } else {
            return false;
        }
    }

    //判断地区
    function checkAreaCode(idCard) {
        if (area[parseInt(idCard.substr(0, 2))]) {
            return true;
        }
        return false;
    }


    function isTrueValidateCodeBy18IdCard(a_idCard) {
        var sum = 0; // 声明加权求和变量   
        if (a_idCard[17].toLowerCase() == 'x') {
            a_idCard[17] = 10; // 将最后位为x的验证码替换为10方便后续操作   
        }
        if (a_idCard[17] == getValideCode(a_idCard)) {
            return true;
        } else {
            return false;
        }
    }

    function getValideCode(a_idCard){
        var sum = 0; // 声明加权求和变量
        for (var i = 0; i < 17; i++) {
            sum += Wi[i] * a_idCard[i]; // 加权求和
        }
        valCodePosition = sum % 11; // 得到验证码所位置
        return  ValideCode[valCodePosition];
    }

    function conver15CardTo18(idcard){
        if(!IdCardValidate(idcard)){
            return null;
        }
        var card = idcard.substr(0, 6)+ '19'+idcard.substr(6, idcard.length - 6);
        var vCode=  getValideCode(card.split(""));
        if(vCode===10){
            return      card+"X";
        }
        return card+""+vCode;
    }


    function maleOrFemalByIdCard(idCard) {
        if (idCard.length == 15) {
            if (idCard.substring(14, 15) % 2 == 0) {
                return 'female';
            } else {
                return 'male';
            }
        } else if (idCard.length == 18) {
            if (idCard.substring(14, 17) % 2 == 0) {
                return 'female';
            } else {
                return 'male';
            }
        } else {
            return null;
        }
    }

    function isValidityBrithBy18IdCard(idCard18) {
        var year = idCard18.substring(6, 10);
        var month = idCard18.substring(10, 12);
        var day = idCard18.substring(12, 14);
        return checkDate(year, month, day);
    }

    function isValidityBrithBy15IdCard(idCard15) {
        var year = "19" + idCard15.substring(6, 8);
        var month = idCard15.substring(8, 10);
        var day = idCard15.substring(10, 12);
        return checkDate(year, month, day);
    }

    function checkDate(year, month, day) {
        var temp_date = new Date(year, parseFloat(month) - 1, parseFloat(day));
        if (temp_date.getFullYear() != parseFloat(year) || temp_date.getMonth() != parseFloat(month) - 1 || temp_date.getDate() != parseFloat(day)) {
            return false;
        } else {
        	var d = new Date();
			if (Date.parse(d) > Date.parse(temp_date)) {//时间戳对比
				return true;
			}
            return false;
        }
    }

    function trim(str) {
        return str.replace(/(^\s*)|(\s*$)/g, "");
    }

    return {
        check: IdCardValidate   ,
        covert15To18:conver15CardTo18
    };

})();
/**  
 * 身份证15位编码规则：dddddd yymmdd xx p   
 * dddddd：地区码   
 * yymmdd: 出生年月日   
 * xx: 顺序类编码，无法确定   
 * p: 性别，奇数为男，偶数为女  
 * <p />  
 * 身份证18位编码规则：dddddd yyyymmdd xxx y   
 * dddddd：地区码   
 * yyyymmdd: 出生年月日   
 * xxx:顺序类编码，无法确定，奇数为男，偶数为女   
 * y: 校验码，该位数值可通过前17位计算获得  
 * <p />  
 * 18位号码加权因子为(从右到左) Wi = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2,1 ]  
 * 验证位 Y = [ 1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2 ]   
 * 校验位计算公式：Y_P = mod( ∑(Ai×Wi),11 )   
 * i为身份证号码从右往左数的 2...18 位; Y_P为脚丫校验码所在校验码数组位置  
 *   
 */
//var res= idCardUtil.check("310333198709085000");
//var res= idCardUtil.covert15To18("320323870908500");
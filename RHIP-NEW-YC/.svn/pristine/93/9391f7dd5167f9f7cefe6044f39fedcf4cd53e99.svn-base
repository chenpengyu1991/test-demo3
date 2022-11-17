/**
 * 
 */
var IC = {
	/**
	 * @description 通过身份证号码获取出生年月日
	 * @param idCard
	 *            身份证号码
	 * @return yyyy/MM/dd
	 */
	getBirthday : function(idCard)
	{
		var year, month, day;
		// 身份证为15位或者18位
		if (idCard.length == 15)
		{
			year = idCard.substring(6, 8);
			month = idCard.substring(8, 10);
			day = idCard.substring(10, 12);
		} else
		{
			year = idCard.substring(6, 10);
			month = idCard.substring(10, 12);
			day = idCard.substring(12, 14);
		}
		// 按照yyyy-MM-dd自动补齐
		if (year.length == 2)
			year = "19" + year;
		if (month.indexOf("0") == 0)
			month = month.substring(1);
		if (day.indexOf("0") == 0)
			day = day.substring(1);
		var date = year + "/" + month + "/" + day;
		return util.isDate(date) ? date : "";
	},
	/**
	 * @description 通過身份證號碼自動獲得性別
	 * @param idCard
	 *            身份证号码
	 * @return string
	 */
	getGender : function(idCard)
	{
		var gender;
		// 身份证为15位或者18位
		if (idCard.length == 15)
		{
			gender = idCard.substr(14, 1);
		} else
		{
			gender = idCard.substr(16, 1);
		}
		if ($.isNumber(gender))
		{
			return gender % 2 == 1 ? '1' : '2';// 按国家编码1:男 2:女
		} else
		{
			return "";
		}
	}
};
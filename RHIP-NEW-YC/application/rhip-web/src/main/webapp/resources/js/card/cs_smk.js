//进行市民卡读卡
function readCsSmk(){
	try{
		CsSmkActive.ReadCardInfo();
	}catch(e){
	}finally{
		var csSmkInfoStr = CsSmkActive.ReadOutInfo();
		if($.trim(csSmkInfoStr)!=''){
			var csSmkInfoArr = parsedCsSmkInfoStrToArr(csSmkInfoStr);
			var csSmkObj = new Object();
			csSmkObj.smCardNum = getCsSmkField(csSmkInfoArr,getCsSmkMapping(),'市民卡号');
			csSmkObj.ckrlxbs = getCsSmkField(csSmkInfoArr,getCsSmkMapping(),'持卡人类型标识');
			csSmkObj.RFU = getCsSmkField(csSmkInfoArr,getCsSmkMapping(),'RFU');
			csSmkObj.name = getCsSmkField(csSmkInfoArr,getCsSmkMapping(),'持卡人姓名');
			csSmkObj.IDCardNum = getCsSmkField(csSmkInfoArr,getCsSmkMapping(),'持卡人证件号码');
			csSmkObj.IDCardType = getCsSmkField(csSmkInfoArr,getCsSmkMapping(),'持卡人证件类型');
			csSmkObj.exeLength = getCsSmkField(csSmkInfoArr,getCsSmkMapping(),'应用信息长度');
			csSmkObj.gender = getCsSmkField(csSmkInfoArr,getCsSmkMapping(),'性别');
			csSmkObj.nation = getCsSmkField(csSmkInfoArr,getCsSmkMapping(),'民族');
			csSmkObj.birthday = getCsSmkField(csSmkInfoArr,getCsSmkMapping(),'出生日期');
			csSmkObj.nationality = getCsSmkField(csSmkInfoArr,getCsSmkMapping(),'国籍');
			csSmkObj.phone = getCsSmkField(csSmkInfoArr,getCsSmkMapping(),'固定电话');
			csSmkObj.mobile = getCsSmkField(csSmkInfoArr,getCsSmkMapping(),'移动电话');
			csSmkObj.address = getCsSmkField(csSmkInfoArr,getCsSmkMapping(),'通讯地址');
			csSmkObj.company = getCsSmkField(csSmkInfoArr,getCsSmkMapping(),'单位名称');
			if($.trim(csSmkObj.smCardNum)==''){
				//如果读取得卡号为空也返回错误
				return 'error';
			}else{
				return csSmkObj;
			}
		}else{
			return 'error';
		}
	}
}

//获取信息
function getCsSmkField(resultArr,cardMapping,objId){
	var index = cardMapping[objId];
	var x = index.split(':')[0];
	var y = index.split(':')[1];
	return resultArr[x][y];
}

//市民卡信息结果映射
function getCsSmkMapping(){
	var mappingMap = {
			市民卡号:'0:0',
			持卡人类型标识:'1:0',
			RFU:'1:1',
			持卡人姓名:'1:2',
			持卡人证件号码:'1:3',
			持卡人证件类型:'1:4',
			应用信息长度:'1:5',
			性别:'1:6',
			民族:'1:7',
			出生日期:'1:8',
			国籍:'1:9',
			固定电话:'1:10',
			移动电话:'1:11',
			通讯地址:'1:12',
			单位名称:'1:13'
			};
	return mappingMap;
}

//解析市民卡信息
function parsedCsSmkInfoStrToArr(outString){
	var resultArr = new Array();
	var one = outString.split('~~');
	for(var i=0;i<one.length;i++){
		if(one[i].length>0){
			var two = one[i].split(',');
			resultArr[i] = new Array();
			for(var j=0;j<two.length;j++){
				resultArr[i][j]=two[j];
			}
		}else{
			resultArr[i] = new Array();
			resultArr[i][0]='';
		}
	}
	return resultArr;
}
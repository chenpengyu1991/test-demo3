
var loadingSource = "<span><img src='" + contextPath + "/images/loading.gif' style='vertical-align:top;'/></span>";

function logout(){
    var url = contextPath + "/manage/logout";
    window.location.href = url;
}

var dataOptions = {
		closeText: '关闭',
		prevText: '&#x3c;上月',
		nextText: '下月&#x3e;',
		currentText: '今天',
		monthNamesShort: ['一月','二月','三月','四月','五月','六月',
		'七月','八月','九月','十月','十一月','十二月'],
		monthNames: ['一','二','三','四','五','六',
		'七','八','九','十','十一','十二'],
		dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],
		dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],
		dayNamesMin: ['日','一','二','三','四','五','六'],
		weekHeader: '周',
		firstDay: 1,
		isRTL: false,
		yearRange: '1890:2020',
		showMonthAfterYear: true,
		yearSuffix: '<span>年</span>',
		changeMonth: true,
		changeYear: true,
		dateFormat: 'yy/mm/dd'
};

function showSmsDialog(noticeIds){
	if(noticeIds ==""){
		return;
	}
	var nextId = "";
	var idArray = noticeIds.split(",");
	
	if(idArray.length == 0){
		return;
	}
	var noticeId = idArray[0];
	if(idArray.length > 1){
		nextId = idArray.splice(1,idArray.length-1).toString();
	}
	$.postRepeat(contextPath + "/sms/sendConfig",{noticeId:noticeId}, function(data){
		if(data == 1){
			$("#smsDiv").remove();
			$("#MainBody").append("<div id=\"smsDiv\" />");
			var url = contextPath + "/sms/dialog?noticeId=" + noticeId + "&nextId=" + nextId;
			var title = "短信发送";
			loadDialogUnit(url,"smsDiv",title,400,600,"","top");
		}else{
			showSmsDialog(nextId);
		}
	});
}

function splitError(errorMsg){
	errorMsg = errorMsg +"";
	var htm = "";
	var er = errorMsg.split(",");
	for(var i=0; i< er.length;i++){
		if(i == 0){
			htm = er[i];
		}else{
			htm = htm + "<br/>" + er[i];
		}
	}
	return htm;
}

function loadHtml3(url,formName,divName,indexPage) {
	$("#"+divName).html(loadingSource);
	var queryString="";
	if (!isEmpty(formName)) {
		queryString = "&"+queryString+$("#"+formName).formSerialize()+"&date="+new Date().getMilliseconds()+"&indexPage="+indexPage;
		decodeURIComponent(queryString,true);
	}else{
		queryString = "&date="+new Date().getMilliseconds();
	}
	$("#"+divName).load(url+queryString,function(response, status, xhr){
		if(xhr.status == "403"){
			window.location.reload();
	        return true;
		}
		trAddClass();
	});	
}

function loadHtml2(url,formName,divName,indexPage) {
	$("#"+divName).html(loadingSource);
	var queryString="";
	if (!isEmpty(formName)) {
		queryString = "?"+queryString+$("#"+formName).formSerialize()+"&date="+new Date().getMilliseconds()+"&indexPage="+indexPage;
		decodeURIComponent(queryString,true);
	}else{
		queryString = "?date="+new Date().getMilliseconds();
	}
	$("#"+divName).load(url+queryString,function(response, status, xhr){
		if(xhr.status == "403"){
			window.location.reload();
	        return true;
		}
		trAddClass();
	});	
}
function loadHtml(url,formName,divName,indexPage) {
	$("#"+divName).html(loadingSource);
	var queryString="";
	if (!isEmpty(formName)) {
		queryString = "?"+queryString+$("#"+formName).formSerialize()+"&date="+new Date().getMilliseconds();
		decodeURIComponent(queryString,true);
	}else{
		queryString = "?date="+new Date().getMilliseconds();
	}
	
	queryString = isEmpty(indexPage) ? queryString : queryString+"&indexPage="+indexPage;
	$("#"+divName).load(url+queryString,function(response, status, xhr){
		if(xhr.status == "403"){
			window.location.reload();
	        return true;
		}
		goDiv(divName);//scroll(0,document.body.scrollHeight);
		trAddClass();
	});
}

function trAddClass(){
	$("input:submit, input:button, button").addClass("button");
	$('table.repeattable tr:odd').not(".pagefoot").addClass("listtradd");
	$('table.repeattable tr:even').not(".pagefoot").addClass("listtreven");
	$('table.repeattable tr').not(".pagefoot").hover(
		function () {
			$(this).addClass("listtrhover");
		},
		function () {
			$(this).removeClass("listtrhover");
		}
	);
}

function loadSimpleHtml(url,divName,delay) {
	$("#"+divName).html(loadingSource);
	var queryString = "&date="+new Date().getMilliseconds();
	var urlFinal = url.indexOf("?") == -1? url+"?"+queryString: url+"&"+queryString;
	if(delay != null){
		setTimeout(function(){
			$("#"+divName).load(urlFinal,function(response, status, xhr){
				if(xhr.status == "403"){
					window.location.reload();
			        return true;
				}
				trAddClass();
			});	
		},delay);
	}else{
		$("#"+divName).load(urlFinal,function(response, status, xhr){
			if(xhr.status == "403"){
				window.location.reload();
		        return true;
			}
			trAddClass();
		});	
	}
}

function loadCallbackSimpleHtml(url,divName, callback) {
	$("#"+divName).html(loadingSource);
	var queryString = "&date="+new Date().getMilliseconds();
	var urlFinal = url.indexOf("?") == -1? url+"?"+queryString: url+"&"+queryString;
	$("#"+divName).load(urlFinal,function(response, status, xhr){
		if(xhr.status == "403"){
			window.location.reload();
	        return true;
		}
		callback();
		trAddClass();
	});	
}

function loadContent(url){
	loadCallbackSimpleHtml(url,"Main",function(){
		initFun();
	});
}

function loadChildContent(url){
	loadSimpleHtml(url,"Main");
}

function cancelToMain(){
	var mainUrl = $("#menuUrlHid").val();
	loadContent(mainUrl);
	goTop();
}

function cancelToMainUrl(url){
	$("#menuUrlHid").val(url);
	loadContent(url);
	goTop();
}

function savePreUrl(url){
	$("#preUrlHid").val(url);
}

function toPre(){
	cancelToMainUrl($("#preUrlHid").val());
}


//############################utils####################################//
function isEmptyByInputId(inputId){
	return $.trim($("#"+inputId).val()).length == 0;	
}

function isEmpty(source){
	
	if(undefined == source){
		return true;
	}
	
	if(null == source){
		return true;
	}
	
	if("" == source){
		return true;
	}
	
}

//verify string is blank
function isBlank(val){
	if(!val) return false; 
    var strP=/^\s*$/; 
    if(!strP.test(val)) return false; 
   
    return true; 
}

function trim(val) {
	return val.replace(/(^\s*)|(\s*$)/g, "");
}

//verify positive integer, above zero\s
function isNumber(oNum){ 
    if(!oNum) return false; 
    var strP=/^[1-9]\d*$/; 
    if(!strP.test(oNum)) return false; 
    try{ 
        if(parseFloat(oNum)!=oNum) return false; 
    } 
    catch(ex){ 
        return false; 
    } 
    return true; 
}

function isDate(str)
{
    var d = new Date(str);
    return !isNaN(d);
   /* var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/;
    var result = d.match(reg);
    if(result == null){return false};
    var dt = new Date(result[1],result[3]-1,result[4]);
    if(Number(dt.getFullYear())!=Number(result[1])){return false;}    
    if(Number(dt.getMonth())+1!=Number(result[3])){return false;}    
    if(Number(dt.getDate())!=Number(result[4])){return false;}
 	return true;
*/
}

//verify float
function isFloat(oNum){ 
    if(!oNum) return false; 
    var strP=/^\d+(\.\d+)?$/; 
    if(!strP.test(oNum)) return false; 
    try{ 
        if(parseFloat(oNum)!=oNum) return false; 
    } 
    catch(ex){ 
        return false; 
    } 
    return true; 
}

function selectAllItemsForMultiTable(tableId, value, name) {
	if (name == 'checked') {
		if (value) {
			$('#'+tableId+' input[type=checkbox][checked=""]').trigger('click');
		} else {
			$('#'+tableId+' input[type=checkbox]').trigger('click');
		}
	}
}

function redirect(url){
	document.location.href=url;
}

function openWin(src, width, height){
	window.open(src,'打印','width=' + width + 'px,height='+ height + 'px,top=0,left=0,help:yes,status=yes,toolbar=yes,menubar=yes,location=yes,scrollbars=yes,resizable=no'); 
} 
function parseJson(data){
	var errorArr = eval('(' + data + ')').error;
	var errors = "";
	for(var i=0;i<errorArr.length;i++){
		errors += errorArr[i]+"</br>";
	}
	return errors;
}



function printsetup(){ 
	 // 打印页面设置  页面需引入  <OBJECT  classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" height=0  id=wb  name=wb  width=3></OBJECT>
	 wb.execwb(8,1);  
} 

function printpreview(){
	 // 打印页面预览
	 wb.execwb(7,1);  
 }  
	 
function printit(div) {
	msgUtil.confirm("确定打印吗？",function(){
		document.getElementById(div).style.display = "none";
		wb.execwb(6, 6);
	});
	document.getElementById(div).style.display = "";
}  

function closeWin() {
	window.opener=null;window.open('','_self');window.close();
}

function goTop() {
	 $('html, body').animate({scrollTop:0}, 'slow'); 
}

function goDiv(div) {
	var a =  $("#"+div).offset().top-200;
	$("html,body").animate({scrollTop:a}, 'slow');   
}

function goBottom() {
	window.scrollTo(0, document.documentElement.scrollHeight-document.documentElement.clientHeight); 
}

// --------------------elb function--------------------//

var elb = function() {};

elb.searchTooltip = function(obj, tooltipVal) {
	var u = $(obj);
	u.val(tooltipVal);
	u.css("color", "#999");
	u.focus(function() {
				if (u.val() == tooltipVal) {
					u.val("");
					u.css("color", "#333");
				}
			});
	u.blur(function() {
				if (u.val() == "") {
					u.val(tooltipVal);
					u.css("color", "#999");
				}
			});
}

// --------------------elb function--------------------//


function showDialog(div,title,height,width,okFun,po) {
	if(po != null){
		position = po;
	}else{
		position = "middle";
	}
	if (isEmpty(div)) return;
	if (isEmpty(height)) height = 400;
	if (isEmpty(width)) width = 500;
	$("#"+div).dialog("destroy");
	$("#"+div).dialog( {
		position:position,
		height:height,
		width:width,
		resizable:false,
		modal: true,
		overlay: { backgroundColor: '#000', opacity: 0.5 },
		open: function() {
				$("#"+div).attr("style","width:"+width+"px;heigth:"+height+"px;");
				
				$("#"+div).dialog('option', 'title', title);
		},
		close: function(){
			if(okFun != "" && okFun!= null){
				okFun();
			}
		}
	});
}

function loadDialog(url,divName,title,height,width,okFun) {
	
	$("#"+divName).html(loadingSource);
	$("#"+divName).load(url+"?date="+new Date().getMilliseconds(),function(response, status, xhr){
		if(xhr.status == "403"){
			window.location.reload();
	        return true;
		}
		trAddClass();
	});
	
	showDialog(divName,title,height,width,okFun);
}

function loadDialogUnit(url,divName,title,height,width,okFun,po) {
	
	$("#"+divName).html(loadingSource);
	$("#"+divName).load(url+"&date="+new Date().getMilliseconds(),function(response, status, xhr){
		if(xhr.status == "403"){
			window.location.reload();
	        return true;
		}
		trAddClass();
	});
	
	showDialog(divName,title,height,width,okFun,po);
}


function postAjax(url,formId, successFun, failFun, otherFun){
	$.postRepeat(contextPath + url,$("#"+formId).serialize(),  function(data){
		if (data == "success") {
			$('#'+formId).clearForm();
			successFun();
			goTop();
		} else if (data == "fail") {
			failFun();
		}else {
			var dataM = eval('(' + data + ')');
			if (!isEmpty(dataM)) {
				errors = dataM;
			} else {
		    	errors = parseJson(data);
			}
			
			if(!isEmpty(data.url)){
				cancelToMainUrl(data.url);
				return;
			}
			errors.error = splitError(errors.error + "");
			otherFun(errors);
		}
	},"html");
}

function initAdd(locationPath) {
	window.location.href = contextPath + locationPath;
	
}

function hideSearch(divId){
	//if (isEmpty($(".repeattable").html())) {
		//return;
	//}
	$("#"+divId).hide();
	$("#searchOperatorArea").show();
	$("#msgOK").hide();
	$("#msgError").hide();	
}
function openSearch(divId){
	$("#"+divId).show();
	//$("#searchOperatorArea").hide();
	$("#msgOK").hide();
	$("#msgError").hide();	
}

function doCancel(divId) {
	$("#msgOK").hide();
	$("#msgError").hide();
	$("#"+divId).html("");
	goTop();
}

/*function enterEven(action,param){
	document.onkeydown = function(e){ 
	    var ev = document.all ? window.event : e;
	    if(ev.keyCode==13) {
	    	ev.returnValue = false;
	    	this.func = new Function(action+"("+param+")");	    
	    	this.func();
	    }
	}
}*/

/**
 * 指定表单响应回车事件
 * @action function 名字
 * @formId 表单Id的值
 * @param function 参数
 */
function enterEven(action,formId,param){
	var searchForm = document.getElementById(formId);
	if (isEmpty(searchForm)) {
		return;
	}
	searchForm.onkeydown = function(e){ 
		var ev = document.all ? window.event : e;
	    if(ev.keyCode==13) {
	    	ev.returnValue = false;
	    	this.func = new Function(action+"("+param+")");	    
	    	this.func();
	    }
	}
}

function getDate() {
	if ($("#certTypeId").val() != '01') return false;
	if (isEmpty($("#certnoId").val())) return false;
	if ($("#certnoId").val().length !=15 && $("#certnoId").val().length !=18) return false;
	var date = IC.getBirthday($("#certnoId").val());
	var gendar = IC.getGender($("#certnoId").val());
	if (!isEmpty(date)) {
		$("#birthDate").val(date);
	}
	if (!isEmpty(gendar)) {
		$("select[name='gender'] option").each(function(index){
			if (gendar == $(this).val()) {
				$(this).attr("selected","selected");
			}
		});
	}
}

function chkAll(obj) {
	var allCheck = document.getElementsByTagName("input");
	for ( var i = 0; i < allCheck.length; i++) {
		if (allCheck[i].type == "checkbox") {
			allCheck[i].checked = obj.checked;
		}
	}
}

function doChk(obj) {
	var allCheck = document.getElementsByName("check");
	var tag = 'Y';
	for ( var i = 0; i < allCheck.length; i++) {
		if (allCheck[i].type == "checkbox" && allCheck[i].checked == false) {
			tag = 'N';
			break;
		}
	}
	if(tag == 'N'){
		document.getElementById("checkAllId").checked = false;
	}else{
		document.getElementById("checkAllId").checked = true;
	}
}


var IC = {
        /**
         * @description 通过身份证号码获取出生年月日
         * @param idCard 身份证号码
         * @return yyyy/MM/dd
         */
        getBirthday : function(idCard) {
                var year, month, day;
                // 身份证为15位或者18位
                if (idCard.length == 15) {
                        year = idCard.substring(6, 8);
                        month = idCard.substring(8, 10);
                        day = idCard.substring(10, 12);
                } else {
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
                return isDate(date) ? date : "";
        },
        /**
         * @description 通過身份證號碼自動獲得性別
         * @param idCard  身份证号码
         * @return string
         */
        getGender : function(idCard) {
                var gender;
                // 身份证为15位或者18位
                if (idCard.length == 15) {
                        gender = idCard.substr(14, 1);
               } else {
                        gender = idCard.substr(16, 1);
                }
                if (isNumber(gender)) {
                	return gender % 2 == 1 ? '1' : '2';//按国家编码1:男 2:女
                }else{
                	return "";
                }
        }
};


/**
 * 比如取“方正abc"字符串长度，一般结果为：5 用此代码取值为：7
 * @param strTemp
 * @returns sum
 */
function fucCheckLength(strTemp) {
	var i, sum;
	sum = 0;
	for (i = 0; i < strTemp.length; i++) {
		if ((strTemp.charCodeAt(i) >= 0) && (strTemp.charCodeAt(i) <= 255))
			sum = sum + 1;
		else
			sum = sum + 2;
	}
	return sum;
}

function getVillageOpting(radom,village_id,pastreet, methodName) {
	var gbCode =  $("select[idd='townId"+radom +"']").val();
	showTitle("townId"+radom);
	$.getJsonByUrl({
		 url : contextPath+"/organization/json",
		 checkRepeat:false,
		 callback:function(data){
			 //删除option
			 var i = 0;
			 while($("select[idd='villageId"+radom +"'] option").length>0 && i <= $("select[idd='villageId"+radom +"'] option").length) {
				 $("select[idd='villageId"+radom +"'] option:last").remove();
				 i=0;
			 }
			 if(data != "empty") {
				 $("select[idd='villageId"+radom +"']").append(data);
			 } else {
				 $("select[idd='villageId"+radom +"']").append("<option value=\"\">请选择</option>");
			 }
			 
			 if(!isEmpty(methodName)) {
				 var callback = eval(methodName);
				 if(!isEmpty(callback)){
					 callback();
				 }
			 }
			 
			 //派发事件
			 $("select[idd='villageId"+radom +"']").trigger("villageChange");
			 
			 //显示默认选中的值
			 showTitle("villageId"+radom);
			//给站添加事件  当期值变化时  显示title
			$("select[idd='villageId"+radom +"']").change(function(){
				showTitle("villageId"+radom);
			});
			 if(!$.isEmpty(village_id) && !$.isEmpty(pastreet)){
				 $('#' + village_id).val(pastreet);
			 }
		 },
		 param:{gbCode:gbCode}
	});
}
function getCentreOpting(radom) {
	var gbCode =  $("select[idd='townsId"+radom +"']").val();
	$.getJsonByUrl({
		 url : contextPath+"/organization/centre",
		 callback:function(data){
			 //删除option
			 var i = 0;
			 while($("select[idd='centreId"+radom +"'] option").length>0 && i <= $("select[idd='centreId"+radom +"'] option").length) {
				 $("select[idd='centreId"+radom +"'] option:last").remove();
				 i=0;
			 }
			 if(data != "empty") {
				 $("select[idd='centreId"+radom +"']").append("<option value=\"\">请选择</option>" + data);
			 } else {
				 $("select[idd='centreId"+radom +"']").append("<option value=\"\">请选择</option>");
			 }
			 $("select[idd='centreId"+radom +"']").show();
			 getStationOptingTemp(radom);
			 if(gbCode == '') {
				 $("select[idd='centreId"+radom +"']").hide();
				 $("select[idd='stationId"+radom +"']").hide();
			 }
		 },
		 param:{gbCode:gbCode}
	});
}


function getStationOpting(radom) {
	getStationOptingTemp(radom);
	$("select[idd='stationId"+radom +"']").show();
}


function getStationOptingTemp(radom) {
	var supOrganCode =  $("select[idd='centreId"+radom +"']").val();
	$.getJsonByUrl({
		 url : contextPath+"/organization/station",
		 callback:function(data){
			 //删除option
			 var i = 0;
			 while($("select[idd='stationId"+radom +"'] option").length>0 && i <= $("select[idd='stationId"+radom +"'] option").length) {
				 $("select[idd='stationId"+radom +"'] option:last").remove();
				 i=0;
			 }
			 if(data != "empty") {
				 $("select[idd='stationId"+radom +"']").append("<option value=\"\">请选择</option>" + data);
			 } else {
				 $("select[idd='stationId"+radom +"']").append("<option value=\"\">请选择</option>");
			 }
			 if(supOrganCode == '') {
				 $("select[idd='stationId"+radom +"']").hide();
			 }
		 },
		 param:{supOrganCode:supOrganCode}
	});
}
/**
 * 在select中显示title根据自定义属性idd
 */
function showTitle(idd){
	var $target = $("select[idd='" + idd +"']");
	$target.attr("title", $target.find('option:selected').text());
}

/**
 * 在select中显示title
 */
function showTitleByName(name){
	var $target = $("select[name='" + name +"']");
	$target.attr("title", $target.find('option:selected').text());
}

function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}

/*
 * 选择其他时，显示其他输入框
 * radioName：radio的name
 * otherId:DivId,其他输入框等放在Div中
 * code:当当前选中的radio的值与code相等时显示otherId
 * */
function toggleOther(radioName,otherId,code){
	var raValue = $('input[name="' + radioName+ '"]:checked').val();
	if(raValue == code){
		$("#" + otherId).show();
		$("#" + otherId).find("input").each(function(){
			$(this).show();
		});
	}else{
		$("#" + otherId).hide();
		$("#" + otherId).find("input[type=text]").each(function(){
			$(this).val('');
		});
        $("#" + otherId).find("input[type=radio]").each(function(){
            $(this).attr("checked",false);
        });
        $("#" + otherId).find("input[type=checkbox]").each(function(){
            $(this).attr("checked",false);
        });
	}
}

/*
 * 选择其他时，显示其他输入框
 * checkBoxName:checkbox的name
 * otherId:DivId,其他输入框等放在其中
 * code:checkbox当前选中的的值包含code时显示otherId
 * */
function toggleOtherCK(checkBoxName,otherId,code){
    var raValue = '';
    $('input[name="' + checkBoxName+ '"]:checked').each(function(){
        raValue += $(this).val()+","
    });
    if(raValue.indexOf(code) != -1){
        $("#" + otherId).show();
    }else{
        $("#" + otherId).hide();
        $("#" + otherId).find("input[type=text]").each(function(){
            $(this).val('');
        });
        $("#" + otherId).find("input[type=radio]").each(function(){
            $(this).attr("checked",false);
        });
        $("#" + otherId).find("input[type=checkbox]").each(function(){
            $(this).attr("checked",false);
        });
    }
}

/*
 * 选择其他时，显示其他输入框
 * sCName:select的name
 * otherId:DivId,其他输入框等放在其中
 * code:当前选中的选中值等于code时显示otherId
 * */

function toggleOtherSC(sCName,otherId,code){
//    var raValue = $('input[name="' + radioName+ '"]:checked').val();
//    var raValue = $("select[name="+ sCName +"] option[selected]").val();
    var raValue = $("select[name=\'" + sCName + "\']").find("option:selected").val();
    if(raValue == code){
        $("#" + otherId).show();
    }else{
        $("#" + otherId).hide();
        $("#" + otherId).find("input[type=text]").each(function(){
            $(this).val('');
        });
        $("#" + otherId).find("input[type=radio]").each(function(){
            $(this).attr("checked",false);
        });
        $("#" + otherId).find("input[type=checkbox]").each(function(){
            $(this).attr("checked",false);
        });
    }
}

/* 对象转成json/json数组*/
function Obj2str(o) {
    if (o == undefined) {
        return "";
    }
    var r = [];
    if (typeof o == "string")
        return "\""
            + o.replace(/([\"\\])/g, "\\$1").replace(/(\n)/g, "\\n")
            .replace(/(\r)/g, "\\r").replace(/(\t)/g, "\\t") + "\"";
    if (typeof o == "object") {
        if (!o.sort) {
            for ( var i in o)
                r.push("\"" + i + "\":" + Obj2str(o[i]));
            if (!!document.all
                && !/^\n?function\s*toString\(\)\s*\{\n?\s*\[native code\]\n?\s*\}\n?\s*$/
                .test(o.toString)) {
                r.push("toString:" + o.toString.toString());
            }
            r = "{" + r.join() + "}";
        } else {
            for ( var i = 0; i < o.length; i++)
                r.push(Obj2str(o[i]));
            r = "[" + r.join() + "]";
        }
        return r;
    }
    return o.toString().replace(/\"\:/g, '":""');
}


function onDatePickerChanged(dp){
	$(this).trigger("onDatePickerChanged");
}

/**
 * 为链接添加click事件
 * @param idPre <a id=idpre/>
 * @param fun 响应的函数
 * @param param 响应函数的参数
 */
function initLinkClick(idPre, fun, param) {
	$("a[id^='" + idPre + "']").each(function(){
		  $(this).click(function() {
		  	// 拷贝传人的参数，因为需要修改参数的值
		  	var target = util.cloneJsonObj(param);
		  	
	  		for (i in target) {
	  			 target[i] = $(this).attr(target[i]);
	  		}
		  	
		  	var args = [];
	        for (var property in target)   
	        {   
	            // 绑定property,可以通过函数本身调用
	            fun[property] = target[property];   
	            // 把参数值按照顺序放入到数组中，通过apply传入
	            args.push(target[property]);   
	        }   
	 
		    // 动态调用函数，把参数值数组传入
		    fun.apply(this,args);   

		  });
		});
}

/**
 * 清空form
 * @param formId
 */
function clear(formId) {

	var formObj = document.getElementById(formId);
	for(var i=0; i<formObj.elements.length; i++){
		if(formObj.elements[i].type == "text"){
			formObj.elements[i].value = "";
		} else if(formObj.elements[i].type == "select-one"){
			formObj.elements[i].options[0].selected = true;
		} else if(formObj.elements[i].type == "textarea"){
			formObj.elements[i].value = "";
		} else if(formObj.elements[i].type == "password"){
			formObj.elements[i].value = "";
		} else if(formObj.elements[i].type == "radio"){
			formObj.elements[i].checked = false;
		} else if(formObj.elements[i].type == "checkbox"){
			formObj.elements[i].checked = false;
		}
	}
}
/**
 * left navigation bar selection effect
 */


$(function() {
	$(".sidemenu").each(function(i){
		if($(this).children().eq(0).text() == $(".location").children().eq(1).text()){
			$(this).addClass("cur");
		}
  });
});

/**
 * 兼容IE8的console的定义
 */
window.console = window.console || (function(){
	var c = {}; c.log = c.warn = c.debug = c.info = c.error = c.time = c.dir = c.profile = c.clear = c.exception = c.trace = c.assert = function(){};
	return c;
})();
/*$(".sidemenu").click(function(){
	$(".sidemenu").each(function(i){
		  $(this).removeClass("cur");
    });
	$(this).addClass("cur");
});*/
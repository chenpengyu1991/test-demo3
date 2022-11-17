
var loadingSource = "<span>&nbsp;&nbsp;&nbsp;<img src='../resources/images/loading.gif' style='vertical-align:top;'/></span>";
//隔行变色
$(document).ready(
		function() {
			$('table.repeattable tbody tr:odd').addClass("l-odd");
			$('table.repeattable tbody tr:even').addClass("l-even");
			resizeFrame();
			
});

//上此选中行的id  
var lastLineId = "";  	
function rowclick(obj){
    //移除上次选中行的class:selected  
    if (lastLineId != "") {  
    	 if(lastLineId % 2 == 1)//奇数
    		 $("#" + lastLineId).addClass("l-odd");  
    	  else//偶数
    		  $("#" + lastLineId).addClass("l-even");  
   	
        $("#" + lastLineId).removeClass("l-selected");  
    }  
    //给当前点击行添加class:selected  
    $(obj).removeClass("l-odd");  
    $(obj).removeClass("l-even");  
    $(obj).addClass("l-selected");  
    //更新上次选中行  
    lastLineId = $(obj).attr("id");      	
}

function ckclick(obj){
	if ($(obj).attr('checked')==undefined){
		$(obj).parent("td").parent("tr").removeClass("l-grid-row-over"); 	
	}else
   		$(obj).parent("td").parent("tr").addClass("l-grid-row-over"); 
}

//================================
//添加附件
function openAttachmentDialog(consultationId)
{
	var path= contextPath+"/attachment/add?consultationId="+consultationId;
	 attachmentDialog = $.ligerDialog.open({
		height : 160,
		width : 400,
		title : '上传文件',
		isDrag : true,
		url : path
	});
	 return attachmentDialog;
}

function loadHtml2(url,formName,divName,indexPage) {
	$("#"+divName).html(loadingSource);
	var queryString="";
	if (!isEmpty(formName)) {
		queryString = "?"+queryString+$("#"+formName).formSerialize()+"&date="+new Date().getMilliseconds()+"&indexPage="+indexPage;
		//queryString = decodeURIComponent(queryString,true);
	}else{
		queryString = "?date="+new Date().getMilliseconds();
	}
	$("#"+divName).load(url+queryString,function(response, status, xhr){
		if(xhr.status != "200"){
			var url= contextPath+"/access/error";
			redirect(url);
	        return true;
		}
	});	
}

function loadHtml(url,formName,divName) {
	$("#"+divName).html(loadingSource);
	var queryString="";
	if (!isEmpty(formName)) {
		queryString = "?"+queryString+$("#"+formName).formSerialize()+"&date="+new Date().getMilliseconds();
		decodeURIComponent(queryString,true);
	}else{
		queryString = "?date="+new Date().getMilliseconds();
	}
	$("#"+divName).load(url);
	$("#"+divName).load(url+queryString,function(response, status, xhr){
		if(xhr.status == "403"){
			window.location.reload();
	        return true;
		}
		$("input:submit, input:button, button").addClass("button");
		$('table.repeattable tr:odd').not(".pagefoot").css("background", "#fdfeff");
		$('table.repeattable tr:even').not(".pagefoot").css("background", "#f6fbfd");
	});
}

function loadSimpleHtml(url,divName) {
	$("#"+divName).html(loadingSource);
	var queryString = "&date="+new Date().getMilliseconds();
	var urlFinal = url.indexOf("?") == -1? url+"?"+queryString: url+"&"+queryString;
	$("#"+divName).load(urlFinal,function(response, status, xhr){
		if(xhr.status == "403"){
			window.location.reload();
	        return true;
		}
	});	
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
	});	
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

function resizeFrame() {
	var mainHeight = $("#CNMain").height();
	var minHeight = 600;
	if (mainHeight > minHeight) {
		$(window.parent.document).find("#mainFrame").height(mainHeight);
		$(window.parent.document).find("#leftFrame").height(mainHeight);
	} else {
		$(window.parent.document).find("#mainFrame").height(minHeight);
		$(window.parent.document).find("#leftFrame").height(minHeight);
	}

}

function getPageGo(index){
	if (isEmpty(index))
		index = "1";
	var pageIndex = parseInt(index);
	return pageIndex;
}

function validationNumber(obj,maxNum){
	 //判断输入的数字是否超过设置的最大值
	  if ((maxNum!=undefined) && (maxNum.constructor==Number) && (obj.value > maxNum))
	  {
		  obj.value="";
	  }
}


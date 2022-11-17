	var loadingSource = "<span><img src='" + contextPath + "/images/loading.gif' style='vertical-align:top;'/></span>";

/* 标识页面是否有内容改变 */
var contentChanged = false;

function chooseOrg() {
    window.location.href = contextPath + "/access/chooseOrg";
}

function getBaseUrl() {
    var protocol = window.location.protocol;
    var host = window.location.host;
    return protocol + "//" + host + contextPath;
}

function getIndexUrl() {
    return getBaseUrl();
}

/* 启用退出时，提示未保存 */
function enableChangeConfirm()
{
	$(":input").change(function()
	{
		contentChanged = true;
	});
	$("select").change(function()
	{
		contentChanged = true;
	});
	$("textarea").change(function()
	{
		contentChanged = true;
	});
}

/* 禁用退出时，提示未保存 */
function disableChangeConfirm()
{
	contentChanged = false;
	$(":input").unbind('change');
	$("select").unbind('change');
	$("textarea").unbind('change');
}

function trAddClass()
{
	$("input:submit, input:button, button").addClass("button");
	$('table.repeattable tr:odd').not(".pagefoot").addClass("listtradd");
	$('table.repeattable tr:even').not(".pagefoot").addClass("listtreven");
	$('table.repeattable tr').not(".pagefoot").hover(function()
	{
		$(this).addClass("listtrhover");
	}, function()
	{
		$(this).removeClass("listtrhover");
	});
}

// ############################utils####################################//
function isEmptyByInputId(inputId)
{
	return $.trim($("#" + inputId).val()).length == 0;
}



function selectAllItemsForMultiTable(tableId, value, name)
{
	if (name == 'checked')
	{
		if (value)
		{
			$('#' + tableId + ' input[type=checkbox][checked=""]').trigger('click');
		} else
		{
			$('#' + tableId + ' input[type=checkbox]').trigger('click');
		}
	}
}

function redirect(url)
{
	document.location.href = url;
}

function openWin(src, width, height)
{
	window.open(src, '打印', 'width=' + width + 'px,height=' + height + 'px,top=0,left=0,help:yes,status=yes,toolbar=yes,menubar=yes,location=yes,scrollbars=yes,resizable=no');
}
function parseJson(data)
{
	var errorArr = eval('(' + data + ')').error;
	var errors = "";
	for ( var i = 0; i < errorArr.length; i++)
	{
		errors += errorArr[i] + "</br>";
	}
	return errors;
}

function printsetup()
{
	// 打印页面设置 页面需引入 <OBJECT classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"
	// height=0 id=wb name=wb width=3></OBJECT>
	wb.execwb(8, 1);
}

function printpreview()
{
	// 打印页面预览
	wb.execwb(7, 1);
}

function printit(div)
{
	/*layer.confirm("确定打印吗？", function(index){
		document.getElementById(div).style.display = "none";
		wb.execwb(6, 6);
		layer.close(index);
	});*/
	var index = layer.confirm("确定打印吗？", {icon:1, title:'确认提示'}, function() {
		document.getElementById(div).style.display = "none";
		wb.execwb(6, 6);
		layer.close(index);
	});
	document.getElementById(div).style.display = "";
}

function closeWin()
{
	window.opener = null;
	window.open('', '_self');
	window.close();
}

function goTop()
{
	$('html, body').animate({
		scrollTop : 0
	}, 'slow');
}

function goDiv(div)
{
	var a = $("#" + div).offset().top - 200;
	$("html,body").animate({
		scrollTop : a
	}, 'slow');
}

function goBottom()
{
	window.scrollTo(0, document.documentElement.scrollHeight - document.documentElement.clientHeight);
}

function initAdd(locationPath)
{
	window.location.href = contextPath + locationPath;

}

/**
 * 指定表单响应回车事件
 * 
 * @action function 名字
 * @formId 表单Id的值
 * @param function
 *            参数
 */
function enterEven(action, formId, param)
{
	var searchForm = document.getElementById(formId);
	if ($.isEmpty(searchForm))
	{
		return;
	}
	searchForm.onkeydown = function(e)
	{
		var ev = document.all ? window.event : e;
		if (ev.keyCode == 13)
		{
			ev.returnValue = false;
			this.func = new Function(action + "(" + param + ")");
			this.func();
		}
	}
}
/**
 * 根据身份证获取出生日期
 */
function getDate()
{
	if ($("#certTypeId").val() != '01')
		return false;
	if ($.isEmpty($("#certnoId").val()))
		return false;
	if ($("#certnoId").val().length != 15 && $("#certnoId").val().length != 18)
		return false;
	var date = IC.getBirthday($("#certnoId").val());
	var gendar = IC.getGender($("#certnoId").val());
	if (!$.isEmpty(date))
	{
		$("#birthDate").val(date);
	}
	if (!$.isEmpty(gendar))
	{
		$("select[name='gender'] option").each(function(index)
		{
			if (gendar == $(this).val())
			{
				$(this).attr("selected", "selected");
			}
		});
	}
}
//TODO 替换为Util中的
function chkAll(obj)
{
	var allCheck = document.getElementsByTagName("input");
	for ( var i = 0; i < allCheck.length; i++)
	{
		if (allCheck[i].type == "checkbox")
		{
			allCheck[i].checked = obj.checked;
		}
	}
}

function doChk(obj)
{
	var allCheck = document.getElementsByName("check");
	var tag = 'Y';
	for ( var i = 0; i < allCheck.length; i++)
	{
		if (allCheck[i].type == "checkbox" && allCheck[i].checked == false)
		{
			tag = 'N';
			break;
		}
	}
	if (tag == 'N')
	{
		document.getElementById("checkAllId").checked = false;
	} else
	{
		document.getElementById("checkAllId").checked = true;
	}
}

/**
 * 在select中显示title
 */
function showTitleByName(name)
{
	var $target = $("select[name='" + name + "']");
	$target.attr("title", $target.find('option:selected').text());
}

/*
 * 选择其他时，显示其他输入框 radioName：radio的name otherId:DivId,其他输入框等放在Div中
 * code:当当前选中的radio的值与code相等时显示otherId
 */
function toggleOther(radioName, otherId, code)
{
	var raValue = $('input[name="' + radioName + '"]:visible:checked').val();
	if (raValue == code)
	{
		$("#" + otherId).show();
		$("#" + otherId).find("input").each(function()
		{
			$(this).show();
		});
	} else
	{
		$("#" + otherId).hide();
		$("#" + otherId).find("input[type=text]").each(function()
		{
			$(this).val('');
		});
		$("#" + otherId).find("input[type=radio]").each(function()
		{
			$(this).attr("checked", false);
		});
		$("#" + otherId).find("input[type=checkbox]").each(function()
		{
			$(this).attr("checked", false);
		});
		$("#" + otherId).find("select").each(function()
		{
			$(this).val('');
		});
	}
}

/*
 * 选择其他时，显示其他输入框 checkBoxName:checkbox的name otherId:DivId,其他输入框等放在其中
 * code:checkbox当前选中的的值包含code时显示otherId
 */
function toggleOtherCK(checkBoxName, otherId, code)
{
	var raValue = '';
	$('input[name="' + checkBoxName + '"]:visible:checked').each(function()
	{
		raValue += $(this).val() + ",";
	});
	if (raValue.indexOf(code) != -1)
	{
		$("#" + otherId).show();
	} else
	{
		$("#" + otherId).hide();
		$("#" + otherId).find("input[type=text]").each(function()
		{
			$(this).val('');
		});
		$("#" + otherId).find("input[type=radio]").each(function()
		{
			$(this).attr("checked", false);
		});
		$("#" + otherId).find("input[type=checkbox]").each(function()
		{
			$(this).attr("checked", false);
		});
		$("#" + otherId).find("select").each(function()
		{
			$(this).val('');
		});
	}
}

/*
 * 选择其他时，显示其他输入框 sCName:select的name otherId:DivId,其他输入框等放在其中
 * code:当前选中的选中值等于code时显示otherId
 */

function toggleOtherSC(sCName, otherId, code)
{
	var raValue = $("select[name=\'" + sCName + "\']:visible").find("option:selected").val();
	if (raValue == code)
	{
		$("#" + otherId).show();
	} else
	{
		$("#" + otherId).hide();
		$("#" + otherId).find("input[type=text]").each(function()
		{
			$(this).val('');
		});
		$("#" + otherId).find("input[type=radio]").each(function()
		{
			$(this).attr("checked", false);
		});
		$("#" + otherId).find("input[type=checkbox]").each(function()
		{
			$(this).attr("checked", false);
		});
		$("#" + otherId).find("select").each(function()
		{
			$(this).val('');
		});
	}
}
/*
 * 选择所选项时候，隐藏一类元素 sCName:select的name otherClass:class,其他类输入框等放在其中
 * code:当前选中的选中值等于code时显示otheClass
 */

function toggleOtherSCByClass(sCName, otherClass, code)
{
	var raValue = $("select[name=\'" + sCName + "\']").find("option:selected").val();
	if (raValue == code)
	{
		$("." + otherClass).hide();
		$("." + otherClass).find("input[type=text]").each(function()
		{
			$(this).val('');
		});
		$("." + otherClass).find("input[type=radio]").each(function()
		{
			$(this).attr("checked", false);
		});
		$("." + otherClass).find("input[type=checkbox]").each(function()
		{
			$(this).attr("checked", false);
		});
		$("." + otherClass).find("select").each(function()
		{
			$(this).val('');
		})
	} else
	{
		$("." + otherClass).show();
	}
}

function upCaseIdcard(input)
{
	var $input=$(input);
	var value = $input.val();
	if (value)
	{
		var newValue=value.toUpperCase();
		if(newValue!=value){
			$input.val(newValue);
		}
	}
}

function removeSpace(input)
{
    var $input=$(input);
    var value = $input.val();
    if (value)
    {
    	//去除所有空格
       // var newValue=value.replace(/\s+/g,"");
        //去除两头空格
        var newValue=value.replace( /^\s+|\s+$/g,"");
        if(newValue!=value){
            $input.val(newValue);
        }
    }
}
/**
 * 日期控件 派发事件
 * @param dp
 */
function onDatePickerChanged(dp)
{
	$(this).trigger("onDatePickerChanged");
	childDeathReport();
}

/**
 * added by Kevin Ro 2017-3-27
 * 儿童死亡报告卡-当选择出生日期和死亡日期的时候自动计算当前孩子的年龄，岁，月，天，时，分，秒
 * @param dp
 */
function childDeathReport() {
	// 死亡日期
	var childDeathDate = $("#childDeathDate").val();
	// 出生日期
	var childBirthday = $("#childBirthday").val();
	if(childDeathDate != "" || childBirthday != "") { // 都不为空的情况
		if(childBirthday != "" && childDeathDate != "") { // 出生日期不为空
			var childDeathDateTime = Date.parse(new Date(childDeathDate)); // 死亡日期时间戳
			var childBirthdayTime = Date.parse(new Date(childBirthday)); // 出生日期时间戳
			var timeMinus = childDeathDateTime - childBirthdayTime;
			if(timeMinus < 0) { // 此时死亡日期小于了出生日期，格式不对
				layui.use('layer', function() {
           			var layer = layui.layer;
           			layer.alert("死亡日期不能小于出生日期！", {icon:0,title:'提示'});
              	});
				$("#childDeathDate").val(""); // 清空死亡日期;
				$("input[name='ageSui']").val("");//岁
				$("input[name='ageMonth']").val("");//月
				$("input[name='ageDay']").val("");//天
				$("input[name='ageHour']").val("");//时
				$("input[name='ageSecond']").val("");//分
				return;
			} else { // 输入正确了，就要计算时间了
				var year = "";
				if(timeMinus < (1000*60*60*24*365)) year = 0;
				else year = parseInt(timeMinus/(1000*60*60*24*365)); // 年(岁)
				var stamp = timeMinus%(1000*60*60*24*365); // 还有多少秒
				var month = parseInt(stamp/(1000*60*60*24*30)); // 月
				stamp = stamp%(1000*60*60*24*30);
				var day = parseInt(stamp/(1000*60*60*24)); // 天
				stamp = stamp%(1000*60*60*24); // 时
				var second = parseInt(stamp/(1000*60*60)); // 时
				stamp = stamp%(1000*60*60);
				var minus = parseInt(stamp/(1000*60)); // 分
				// 设置年龄
				$("input[name='ageSui']").val(year);//岁
				$("input[name='ageMonth']").val(month);//月
				$("input[name='ageDay']").val(day);//天
				$("input[name='ageHour']").val(second);//时
				$("input[name='ageSecond']").val(minus);//分
			}
		} else  { 
			if(childBirthday == "") {
				layui.use('layer', function() {
           			var layer = layui.layer;
           			layer.alert("出生日期不能为空！", {icon:0,title:'提示'});
              	});
//				msgUtil.alert("出生日期不能为空！");
			}
			if(childDeathDate == "") {
				layui.use('layer', function() {
           			var layer = layui.layer;
           			layer.alert("死亡日期不能为空！", {icon:0,title:'提示'});
              	});
//				msgUtil.alert("死亡日期不能为空！");
			}
			$("input[name='ageSui']").val("");//岁
			$("input[name='ageMonth']").val("");//月
			$("input[name='ageDay']").val("");//天
			$("input[name='ageHour']").val("");//时
			$("input[name='ageSecond']").val("");//分
			return;
		}
	}
}

function onpagebarclick(param)
{
	$(this).trigger("pagebarclick");
}


/**
 * 查询页面的查询条件DIV的隐藏与展现
 * @param obj
 * @param tableId
 */
function toggle(obj,tableId) {
	$(obj).toggleClass("ico-top");
	$(obj).toggleClass("ico-bottom");
	$("#" + tableId).toggle();
};

//健康档案打开方法
//通过基本信息id tag响应函数
function openEhrBrwById(id) {
   /* var dialogObj = {
        url :"/ehrbrowser/index/"+id,
        height : 654,
        width : 1000
    };*/
    /*$.dialog(dialogObj);*/
    $.post(contextPath+"/ehrbrowser/index/"+id,{region:1,cdm:1},//去掉健康档案浏览器上面的返回按钮{region:1,cdm:1}
		function(ret) {
    	layui.use(['layer'], function() {
    		  var layer = layui.layer
    		  layer.open({
    			  type: 1,
    			  id:'ehrViewByPersonId',
    			  area: ['1000px', '590px'],
    			  title:'健康档案',
    			  content: ret
    		  });
    		});
    	});
}

//通过身份证 tag响应函数
function openEhrBrwByIdCard(idCard) {
    /*var dialogObj = {
        url :"/ehrbrowser/index/idCard/"+idCard,
        height : 654,
        width : 1000
    };
    $.dialog(dialogObj);*/
	 $.post(contextPath+"/ehrbrowser/index/idCard/"+idCard,
				function(ret) {
		    	layui.use(['layer'], function() {
		    		  var layer = layui.layer
		    		  layer.open({
		    			  type: 1,
		    			  id:'ehrViewByIdcard',
		    			  area: ['1000px', '590px'],
		    			  title:'健康档案',
		    			  content: ret
		    		  });
		    		});
		    	});
}

//增加无权限强制跳转
$(document).ajaxError(function (event, jqxhr, settings, exception) {
    if (jqxhr.status == '401' || jqxhr.status == '403') {
    	layui.use('layer', function(){
			var layer = layui.layer;
			var index = layer.alert("登录超时!请重新登录系统", {icon:0,title:'提示'}, function() {
				 layer.close(index);
				 top.location.href = logoutServeceUrl;
	             /*location.href = logoutServeceUrl;*/
		        });
		});
        /*msgUtil.alert("登录超时!请重新登录系统",function(){
           location.href = logoutServeceUrl;
        });*/
    }else{
        //todo
    }
});

/**
 * 在select中显示title根据自定义属性idd
 */
function showTitle(idd)
{
	var $target = $("select[idd='" + idd + "']");
	$target.attr("title", $target.find('option:selected').text());
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

function setAge(idNo){
	var idCardBirthDay = IC.getBirthday(idNo);
	var lastedAge = getAge(idCardBirthDay);
	return lastedAge;
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
	var brithy=brith.getFullYear();
	var brithm=brith.getMonth()+1;
	var brithd=brith.getDate();
	if(thisYear-brithy<0){
		layui.use('layer', function() {
   			var layer = layui.layer;
   			layer.alert("输入错误!", {icon:0,title:'提示'});
      	});
		age="";
	}else{
        if(thisMonth-brithm < 0){
            age = thisYear-brithy-1;
        } else if (thisMonth-brithm == 0){
            if(thisDay-brithd>=0){
                age = thisYear-brithy;
            } else {
                age = thisYear-brithy-1;
            }
        } else {
            age = thisYear-brithy;
        }
	}
	return age;
}

/*解析日期字符串*/
function parseDate(str){

	if(str.match(/^\d{4}[\/\/\s+]\d{1,2}[\/\/\s+]\d{1,2}$/)){
		return new Date(str.replace(/[\-\/\s+]/i,'/'));
	}else if(str.match(/^\d{8}$/)){
		return new Date(str.substring(0,4)+'/'+str.substring(4,6)+'/'+str.substring(6));
	}else{
		layui.use('layer', function() {
   			var layer = layui.layer;
   			layer.alert("date parse error", {icon:0,title:'提示'});
      	});
	}
}

	function isEmpty(source) {

		if (undefined == source) {
			return true;
		}

		if (null == source) {
			return true;
		}

		if ("" == source) {
			return true;
		}
	}
	
	function controlAdvanceSearchSection(btn) {
		 $(".advanceSearchSection").toggle();
    	   if (btn.text().indexOf('高级') !== -1) {
    		  btn.html('<i class="iconfont">&#x60011;</i>简单');
    	   } else {
    		  btn.html('<i class="iconfont">&#x60010;</i>高级');
    	   }
	}
	
	/**
	 * 提示框
	 * @param msg 提示信息
	 * @param action 提示之后执行的事件
	 * @param index 弹出框索引
	 * @param pageNo 分页查询页码
	 */
	function myAlert(msg, action, index, pageNo) {
		layer.alert(msg, {icon:0,title:'提示'}, function(){
			if (isEmpty(index)) {
				layer.closeAll();
			} else {
				layer.close(index);
			}
			if (!isEmpty(action)) {
				if (isEmpty(pageNo)) {
					action();
				} else {
					action(pageNo)
				}
			}
		});
	}
	
	/**
	 * 确认对话框
	 * @param msg 提示信息
	 * @param action 确认之后执行的事件
	 * @param index 弹出框索引
	 * @param pageNo 分页查询页码
	 * @param type 提示框类型 1:一般操作确认提示  2:删除确认提示
	 */
	function myConfirm(msg, action, index, pageNo, type) {
		//1:确认提示 2:删除提示
		layer.confirm(msg, {icon: type == 1 ? 0 : 2, title:'确认提示'}, function() {
			if (isEmpty(index)) {
				layer.closeAll();
			} else {
				layer.close(index);
			}
			if (!isEmpty(action)) {
				if (isEmpty(pageNo)) {
					action();
				} else {
					action(pageNo)
				}
			}
		})
	}

	/**
	 * 日期输入时，自动格式化
	 */
	function autoFormatDate(element){
		var cleave = new Cleave('#' + element, {
			date: true,
			delimiter: '/',
			datePattern: ['Y', 'm', 'd']
		});
	}
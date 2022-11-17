var addPersonCover = (function () {

    function myfunction(){
        //加载xml中ISSOnline_server的ip和port
        //loadXml("<%=basePath%>"+"webapp/xml/BaseISSOnlineServer.xml");
        //加载指纹标记和指纹模板数据到页面
        loadFPDataTemplate("[]", "[]");
        var browserFlag = "";
        //存放国际化元素数组
        var paramArray = new Array();
        //获取浏览器类型
        browserFlag = getBrowserType();
        paramArray[0] = '指纹';
        paramArray[1] = '指纹数:';
        paramArray[2] = '确认保存当前修改吗?';
        paramArray[3] = '采集指纹';
        paramArray[4] = '请安装指纹驱动或启动该服务!';
        paramArray[5] = '0';
        paramArray[6] = '指纹数:';
        paramArray[7] = '验证';
        //检查驱动
        checkDriver(paramArray, browserFlag, false);
    }

    var isCoverClick = false;
    var validate = null;
    var flag = null;
    $(function () {
        myfunction();
    	showst("poverty","quitDrinkAgeDesc");
		showst("disabled", "disabledDesc");
        var babyCardNo = $("#babyCardNo").val();
        if(!$.isEmpty(babyCardNo)){
            $("#babyCardNoShow").show();
        }
        var msg = $("#firstFlg").val();

        if (!$.isEmpty(msg)) {
            layui.use('layer', function() {
       			var layer = layui.layer;
       			layer.alert(msg, {icon:0,title:'提示'});
          	});
        }
        if ($("#firstFlg").length > 0) {
            $("#two1").attr("class", "hover");
            $("#two2").attr("class", "");
            $("#two3").attr("class", "");
            $("firstFlg").remove();
        }
        
		// 现地址变化
		$("select[name='PersonInfoDTO.personInfo.patownShip']").on("change streetChange", function(){ 
			changeHouseNumber('PersonInfoDTO.personInfo.patownShip',null,null,'tempPaValue', 'orgPaName','text_pahouseNumber', null);
		});
		$("select[name='PersonInfoDTO.personInfo.pastreet']").on("change villageChange", function(){
			changeHouseNumber('PersonInfoDTO.personInfo.patownShip','PersonInfoDTO.personInfo.pastreet',null,'tempPaValue', 'orgPaName','text_pahouseNumber', null);
		});
		
		$("select[name='PersonInfoDTO.personInfo.paGroup']").on("change groupChange", function(){
			changeHouseNumber('PersonInfoDTO.personInfo.patownShip','PersonInfoDTO.personInfo.pastreet','PersonInfoDTO.personInfo.paGroup','tempPaValue', 'orgPaName', null, 'displayPaAddress');
		});
		
		//  户籍地址变化
		$("select[name='PersonInfoDTO.personInfo.hrtownShip']").on("change streetChange", function(){
			changeHouseNumber('PersonInfoDTO.personInfo.hrtownShip',null,null,'tempHrValue', 'orgHrName','text_hrhouseNumber', null);
		});
		$("select[name='PersonInfoDTO.personInfo.hrstreet']").on("change villageChange", function(){
			changeHouseNumber('PersonInfoDTO.personInfo.hrtownShip','PersonInfoDTO.personInfo.hrstreet',null,'tempHrValue','orgHrName','text_hrhouseNumber', null);
		});
		$("select[name='PersonInfoDTO.personInfo.hrGroup']").on("change groupChange", function(){
			changeHouseNumber('PersonInfoDTO.personInfo.hrtownShip','PersonInfoDTO.personInfo.hrstreet','PersonInfoDTO.personInfo.hrGroup','tempHrValue','orgHrName', null, 'displayHrAddress');
		});
		
        //地址三级不是必输项
        $("#village_address").removeAttr("reg");
        $("#homeVillage_address").removeAttr("reg");

        $("#button_save").click(function (e) {
            e.preventDefault();
            var filingflag = $("#filingFlag").val();
            var otherIdcardType = $("#otherIdcardType option:checked").val();
            if($.isEmpty(otherIdcardType)){
                otherIdcardType = $("#otherIdcardType").val();
            }
            var idcard = ($("input[name='PersonInfoDTO.personInfo.idcard']").val());

            if(filingflag == 0){
                if(otherIdcardType == 9 && !(idcard.length == 15 || idcard.length == 18)){
                    flag = 1;
                }
            }else {
                if($.isEmpty(idcard) && otherIdcardType !=5){
                    flag = 1;
                }
            }
            saveCover();
            isCoverClick = true;
        });

        $("#censusRadios input").click(function () {
        	$("#homeVillage_address").val("");
        	$("#homeTown_address").val("");
        	$("#homeStreet_address").val("");
        	$("#tempHrValue").text("");
            if ("2" === $("#censusRadios input:checked").val() || "4" === $("#censusRadios input:checked").val()) {
                if($.isEmpty($("#text_hrhouseNumber").attr("reg"))){
                    $("#text_hrhouseNumber").attr("reg",'{"required":"true"}');
                }
                if($.isEmpty($("#hjdzbcxx").attr("class"))){
                    $("#hjdzbcxx").attr("class",'required');
                }
            	$("#homeTr").hide();
                $("#homeSpan").hide();
            } else {
                $("#homeTr").show();
                $("#homeSpan").show();
                $("#hjdzbcxx").removeAttr('class');
                $("#text_hrhouseNumber").removeAttr("reg");
                $("#text_hrhouseNumber").removeAttr("class");
            }
        });

        $("#text_idcard").keyup(function () {
            var idCardValue = $("#text_idcard").val();
            $("#text_idcard").attr("value", idCardValue.toUpperCase());
        });

        $("#text_idcard").on("blur", function () {
            var idCardValue = $.trim($("#text_idcard").val());
            if($("#otherIdcardType option:checked").val() == 9) {
                idCardValue = $("#text_idcard").val().replace(/-/g,'');
            }
            /*var idCardType = $.trim($("#otherIdcardType").val());*/
            var inputOrganCodeValue = $("#text_inputOrganCode").val();
            var otherIdcardType = $("#otherIdcardType option:checked").val();
            if ((idCardValue.length == 15 || idCardValue.length == 18 || otherIdcardType != 0)) {
                $.getJsonByUrl({
                    url: "/personRecord/getPersonByIdcard",
                    param: {
                        idCard: idCardValue,
                        otherIdcardType: otherIdcardType
                    },
                    callback: function (data) {
                        if (data != null) {
                            var filingFlag = data.filingFlag;
                            var personId = data.id;
                            var organCode = data.inputOrganCode;
                            var organName = data.inputOrganName;
                            if(otherIdcardType == 0 || otherIdcardType == 9) {
                                $("#text_idcard").val(data.idcard);
                            } else {
                                $("#text_idcard").val(data.otherIdcard);
                            }
                            if(data.babyCardNo){
                                $("#babyCardNoShowText").show();
                                $("#babyCardNoText").val(data.babyCardNo);
                                $("#babyCardNoText").attr("readonly",true);
                            }
                            if(otherIdcardType == 9){
                                $("#text_idcard").removeAttr('reg');
                            }
                            if(!$.isEmpty(organCode)){
                            if (organCode == inputOrganCodeValue) {
                                if (filingFlag == 1) {
                                    layui.use('layer', function() {
                               			var layer = layui.layer;
                               			layer.alert("人员在本社区已建档！", {icon:0,title:'提示'});
                                  	});
                                    $.loadHtmlByUrl({
                                        url: "/personRecord/addPersonRecordIni",
                                        insertDiv: "beforeSaveDiv",
                                        param: {
                                            personId: personId
                                        }
                                    });
                                    setCover(data);
                                }else if (filingFlag == 5) {
                                    $.getJsonByUrl({
                                        url : contextPath + "/personRecord/moveInCheck",
                                        param : {
                                            personId : personId
                                        }, callback : function(data1) {
                                            /*if (data1 == '1') {
                                                layer.alert("该人员距离上次迁档还不足三个月，无法迁入！");
                                                return;
                                            }else {*/
	                                        	var index = layer.confirm("人员已迁出，确认迁入本社区？", {icon:1, title:'确认提示'}, function() {
	                                        		$.loadHtmlByUrl({
                                                        url: "/personRecord/addPersonRecordIni",
                                                        insertDiv: "beforeSaveDiv",
                                                        param: {
                                                            personId: personId
                                                        }
                                                    });
                                                    setCover(data);
                                                    $("#text_recordStatus").val(1);
	                        						layer.close(index);
	                        					});
                                                /*layer.confirm("人员已迁出，确认迁入本社区？", function (index) {
                                                    $.loadHtmlByUrl({
                                                        url: "/personRecord/addPersonRecordIni",
                                                        insertDiv: "beforeSaveDiv",
                                                        param: {
                                                            personId: personId
                                                        }
                                                    });
                                                    setCover(data);
                                                    $("#text_recordStatus").val(1);
                                                    layer.close(index);
                                                });*/
                                            // }
                                        }
                                    });
                                } else if (filingFlag == 2) {
                                    layui.use('layer', function() {
                               			var layer = layui.layer;
                               			layer.alert("人员注销审核中，请先撤销！", {icon:0,title:'提示'});
                                  	});
//        							layer.confirm("人员在审核中,确认撤销？", function(index){
//            							$.getJsonByUrl({
//            								url : contextPath + "/personRecord/personOffBack",
//            								param : {
//            									personId : personId,
//            									filingFlag : filingFlag
//            								},
//            								callback : function(data){
//            									if(data == 1){
//            										layer.alert("撤销成功,");
//            									}else {
//            										layer.alert("撤销失败");
//            									}
//            								}
//            							});
//                                    layer.close(index);
//            						});
                                } else if (filingFlag == 9) {
                                    layui.use('layer', function() {
                               			var layer = layui.layer;
                               			layer.alert("人员在本社区已注销，请先激活！", {icon:0,title:'提示'});
                                  	});
                                } else if (filingFlag == 0) {
                                    $.loadHtmlByUrl({
                                        url: "/personRecord/addPersonRecordIni",
                                        insertDiv: "beforeSaveDiv",
                                        param: {
                                            personId: personId
                                        }
                                    });
                                    setCover(data);
                                }
                            } else {
                                if (filingFlag == 2 || filingFlag == 9) {
                                    layui.use('layer', function() {
                               			var layer = layui.layer;
                               			layer.alert("人员档案在["+organName+"]已结案,无法操作！", {icon:0,title:'提示'});
                                  	});
                                } else if (filingFlag == 0) {
                                    setCover(data);
                                } else if (filingFlag == 1 || filingFlag == 3) {
                                    layui.use('layer', function() {
                               			var layer = layui.layer;
                               			layer.alert("人员已建档,请联系"+organName+"进行档案迁出！", {icon:0,title:'提示'});
                                  	});
                                } else if (filingFlag == 5) {
                                    $.getJsonByUrl({
                                        url : contextPath + "/personRecord/moveInCheck",
                                        param : {
                                            personId : personId
                                        }, callback : function(data2) {
                                            /*if (data2 == '1') {
                                                layer.alert("该人员距离上次迁档还不足三个月，无法迁入！");
                                                return;
                                            }else {*/
	                                        	var index = layer.confirm("人员已迁出，确认迁入本社区？", {icon:1, title:'确认提示'}, function() {
	                                        		$.loadHtmlByUrl({
                                                        url: "/personRecord/addPersonRecordIni",
                                                        insertDiv: "beforeSaveDiv",
                                                        param: {
                                                            personId: personId
                                                        }
                                                    });
                                                    setCover(data);
                                                    $("#text_recordStatus").val(1);
	                                        		layer.close(index);
	                                        	});
                                                /*layer.confirm("人员已迁出，确认迁入本社区？", function (index) {
                                                    $.loadHtmlByUrl({
                                                        url: "/personRecord/addPersonRecordIni",
                                                        insertDiv: "beforeSaveDiv",
                                                        param: {
                                                            personId: personId
                                                        }
                                                    });
                                                    setCover(data);
                                                    $("#text_recordStatus").val(1);
                                                    layer.close(index);
                                                });*/
                                            // }
                                        }
                                    });
                                }
                            }
                            }else {
                                setCover(data);
                            }
                        }
                    }
                });
            }
        });
        
        $("#button_print").click(function(e){
        	e.preventDefault();
        	var reportClass=$("#printDiv").attr("class");
        	$("#printDiv tr").addClass("printtrcss");
//			$("#printDiv").removeClass();
        	$("#printDiv").jqprint(
        			{
        			     debug: false, //如果是true则可以显示iframe查看效果（iframe默认高和宽都很小，可以再源码中调大），默认是false
        			     importCSS: true, //true表示引进原来的页面的css，默认是true。（如果是true，先会找$("link[media=print]")，若没有会去找$("link")中的css文件）
        			     printContainer: true, //表示如果原来选择的对象必须被纳入打印（注意：设置为false可能会打破你的CSS规则）。
        			     operaSupport: true//表示如果插件也必须支持歌opera浏览器，在这种情况下，它提供了建立一个临时的打印选项卡。默认是true
        			});
        	$("#printDiv").addClass(reportClass);
//        	$("#printDiv tr").removeClass("printtrcss");
        });

        if ("1" === $("#censusRadios input:checked").val()) {
            $("#hjdzbcxx").removeAttr('class');
            $("#text_hrhouseNumber").removeAttr("reg");
        }

    });

    /*function deleteOption() {
        $("#houseHoldList").find("option").remove();
        $("#houseHoldList").append("<option>请选择</option>");
    }

    function deleteHrOption() {
        $("#HrhouseHoldList").find("option").remove();
        $("#HrhouseHoldList").append("<option>请选择</option>");
    }*/
    function showst(checkId,someId) {
        if ($("#" +checkId).attr("checked") == "checked"){
        	$("#"+someId).show();
        }
    }
    function saveCover(fn) {
        //去除警告
        $("#firstFlg").remove();
        if(!$.isEmpty($("#village_address option:selected").val())) {
            $("#text_pahouseNumber").removeAttr("reg");
            $("#text_pahouseNumber").removeClass("lose");
        }
        if(!$.isEmpty($("#homeVillage_address option:selected").val())) {
            $("#text_hrhouseNumber").removeAttr("reg");
            $("#text_hrhouseNumber").removeClass("lose");
        }
        validate = $("#coverForm").easyValidate();
        var result = validate.validateForm();
        if (!result) {
            return false;
        }
        if($("#otherIdcardType option:checked").val() == 9) {
            $("#text_idcard").val($("#text_idcard").val().replace(/-/g,''));
        }
        var personId = $("#text_personId").val();
        var nowAddressCode = $("#nowAddressCode").val();
        var householderAddressCode = $("#householderAddressCode").val();
        $("#button_save").html('<button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>正在保存...</button>');
        $("#coverForm").submitFormGetJson({
            url: "/personRecord/saveCover",
            insertDiv: "basic_cover",
            param: {
                indexPage: 1,
                personId: personId,
                nowAddressCode: nowAddressCode,
                householderAddressCode: householderAddressCode
            },
            callback: function (data) {
                if (data.indexOf("duplicateIdCard") > -1) {
                	layer.alert("证件号已存在！", {icon:0,title:'提示'});
                    return false;
                } else if (data.indexOf("hadOff") > -1) {
                	layer.alert("人员已注销，请先激活！", {icon:0,title:'提示'});
                    return false;
                } else if (data.indexOf("checkFlag") > -1) {
                	layer.alert("人员审核中，请先激活！", {icon:0,title:'提示'});
                    return false;
                } else if (data.indexOf("ehrNoError") > -1) {
                	layer.alert("档案编码生成异常,请联系管理员！", {icon:0,title:'提示'});
                    return false;
                }
                /*$("#basic_cover_status").removeClass("person_record_todo");
                $("#basic_cover_status").addClass("person_recoed_complete");*/
                $("#basic_cover_li").children(":first").html("&#xe605;");
                $("#save_cover_mark").val(1);//保存成功标记，用来在tab中切换判断
                $("#button_save").html('<button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button>');
                if (isCoverClick) {
                	layer.alert("保存成功！", {icon:0,title:'提示'})
                    /**if (data.indexOf("isElder") > -1) {
                        layer.alert("\<p>保存成功！\</p>\&nbsp;\&nbsp;\&nbsp;\&nbsp;\&nbsp;\&nbsp;需要做年度体检，必检验项目含血常规、尿常规、肝功能（血清谷草转氨酶、血清谷丙转氨酶和总胆红素）、肾功能（血清肌酐和尿素氮）、空腹血糖、血脂、心电图检测和腹部B超！");
                    }else if(flag == 1){
                        layer.alert("\<p>保存成功！\</p>\&nbsp;\&nbsp;\&nbsp;\&nbsp;\&nbsp;\&nbsp;只有宝宝卡号的儿童，无法关联查看医院以及社区的相关医疗数据，请尽快补录身份证号！");
                    }**/
                    //$("#basic_cover_li").click();
                    $("#basic_cover").empty();
                    $("#basic_cover").append(data);
                    $("#ehr_modify_personId").val($("#text_personId").val());
                } else if (fn != undefined) {
                    $("#button_save").html('<button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button>');
                    fn();
                }
                if (personRecordPagination.saveClick) {
                    personRecordPagination.saveClick();
                }
            }
        });
        return true;
    }

    function setCover(data) {
        if (data.healthFileNoHtml) {
            $("#personHealthFileNo").empty();
            $("#personHealthFileNo").append(data.healthFileNoHtml);
        }
        $("#text_personId").val(data.id);
		$("#ehr_modify_personId").val(data.id);
        $("#text_name").val(data.name);
        $("#text_gender").val(data.gender);
        $("#tempPaValue").text(data.paAddressDetail);
        $("#tempHrValue").text(data.hrAddressDetail);

        $("#text_pahouseNumber").val(data.pahouseNumber);
        if (data.householdType == "2") {
            $("input[name='PersonInfoDTO.personInfo.householdType']:eq(1)").attr("checked", true);
            $("#homeTr").css("display", "none");
        }
        if (data.householdType == "4") {
            $("input[name='PersonInfoDTO.personInfo.householdType']:eq(1)").attr("checked", true);
            $("#homeTr").css("display", "none");
        }
        var iddStreet2 ;
        var iddStreet;

        if(data.hrtownShip!=null){
            $("#homeTown_address").val(data.hrtownShip);
            iddStreet2 = $("#homeTown_address").attr("idd").replace('townId', '');
        }
        if(data.patownShip!=null){
            $("#town_address").val(data.patownShip);
            iddStreet=$("#town_address").attr("idd").replace('townId', '');
        }

        orgUtil.getStreetOpting(iddStreet, data.pastreet, '', data.paGroup);
        setTimeout(function () {
            orgUtil.getStreetOpting(iddStreet2, data.hrstreet, '', data.hrGroup);
        }, 500);

        $("#text_hrhouseNumber").val(data.hrhouseNumber);
        $("#text_phoneNumber").val(data.phoneNumber);
        $("#text_guardianPhoneOne").val(data.guardianPhoneOne);
        if(data.inputDate!=null)
            $("#text_inputDate").val(dateFormat(data.inputDate));
        $("#orgHrName").val(data.hrAddressDetail);
        $("#orgPaName").val(data.paAddressDetail);
        $("#text_remarks").val(data.remarks);
        $("#text_starUpdateDate").val(data.starUpdateDate);

        if(data.star >= 2) {
            $("#createOrganNameTd").html(data.createOrganName);
            $("#createIdTd").html(data.createName);
            $("#createDateTd").html(dateFormat(data.createDate));
        }
    }

    function timeFormat(ms){
    	var d = new Date(ms);
        return d.format('yyyy/MM/dd hh:mm:ss');
    }
    
    Date.prototype.format = function(format) {
        var date = {
               "M+": this.getMonth() + 1,
               "d+": this.getDate(),
               "h+": this.getHours(),
               "m+": this.getMinutes(),
               "s+": this.getSeconds(),
               "q+": Math.floor((this.getMonth() + 3) / 3),
               "S+": this.getMilliseconds()
        };
        if (/(y+)/i.test(format)) {
               format = format.replace(RegExp.$1, (this.getFullYear() + '').substr(4 - RegExp.$1.length));
        }
        for (var k in date) {
               if (new RegExp("(" + k + ")").test(format)) {
                      format = format.replace(RegExp.$1, RegExp.$1.length == 1
                             ? date[k] : ("00" + date[k]).substr(("" + date[k]).length));
               }
        }
        return format;
 };
    
    function dateFormat(ms) {
        var d = new Date();
        d.setTime(ms);
        var y = d.getFullYear();
        var m = d.getMonth() + 1;
        var mstr = m.toString();
        if (mstr.length < 2) {
            mstr = "0" + mstr;
        }
        var da = d.getDate();
        var dstr = da.toString();
        if (dstr.length < 2) {
            dstr = "0" + dstr;
        }
        return y + "/" + mstr + "/" + dstr;
    }

    function displayHrAddress() {
        var town = $("#homeTown_address option:selected").text();
        var street = $("#homeStreet_address option:selected").text();
        var village = $("#homeVillage_address option:selected").text();
        if(!$.isEmpty($("#homeVillage_address option:selected").val())) {
            $("#text_hrhouseNumber").removeAttr("reg");
            $("#text_hrhouseNumber").removeClass("lose");
        }else{
        	$("#text_hrhouseNumber").attr("reg", '{"required":"true","maxlength":23}');
        	if($.isEmpty($("#text_hrhouseNumber").val())){
        		$("#text_hrhouseNumber").attr("class", "lose");
        	}
        }
    }

    function displayPaAddress() {
        var town = $("#town_address option:selected").text();
        var street = $("#street_address option:selected").text();
        var village = $("#village_address option:selected").text();
        if(!$.isEmpty($("#village_address option:selected").val())) {
            $("#text_pahouseNumber").removeAttr("reg");
            $("#text_pahouseNumber").removeClass("lose");
        }else{
        	$("#text_pahouseNumber").attr("reg", '{"required":"true","maxlength":23}');
        	if($.isEmpty($("#text_pahouseNumber").val())){
        		$("#text_pahouseNumber").attr("class", "lose");
        	}
        }
    }
    
	function changeHouseNumber(townShip, street, group, tempValue, orgName, houseNumber, methodName){
		var prefix = $("select[name='" + townShip + "']").find("option[value!='']:selected").text();
		if(street != null){
			prefix += " " + $("select[name='" + street + "']").find("option[value!='']:selected").text();
		}
		if(group != null){
			prefix += " " + $("select[name='" + group + "']").find("option[value!='']:selected").text();
		}
		$("#"+tempValue).text(prefix);
		$("#"+orgName).text(prefix);
		if(houseNumber != null){
			$("#" + houseNumber).attr("reg", '{"required":"true","maxlength":23}');
        	if($.isEmpty($("#" + houseNumber).val())){
        		$("#" + houseNumber).attr("class", "lose");
        	}
		}else{
			if (!$.isEmpty(methodName))
			{
				var callback = eval(methodName);
				callback();
			}
		}
	}
	
    /*function displayhouseHold() {
        var town = $("#town_address option:selected").text();
        var street = $("#street_address option:selected").text();
        var village = $("#village_address option:selected").text();
        var houseHold = $("#houseHoldList option:selected").text();
        if (houseHold != '请选择') {
            var temp = town + street + village + houseHold;
            var org = town + street + village + houseHold;
        } else {
            var temp = town + street + village;
            var org = town + street + village;
        }
        $("#tempPaValue").text(temp);
        $("#orgPaName").val(org);
    }*/


    function isCoverClicked() {
        isCoverClick = false;
    }

    function isUnCreatePerson() {
        var personId = $("#text_personId").val();
        if (personId) {
            return true;
        } else {
            return false;
        }
    }

    function  changeIdType(id) {
        $("#text_idcard").unbind("keyup mouseout");
        $("#text_idcard").keyup(function () {
            var idCardValue = $("#text_idcard").val();
            $("#text_idcard").attr("value", idCardValue.toUpperCase());
        });
        if (!$("#text_personId").val()) {
            if ("0" == id) {
                $("#text_idcard").removeAttr('reg');
                $("#text_idcard").attr('reg', '{"required":"true","idCard":"true"}');
            } else if("9" == id){
                $("#text_idcard").removeAttr('reg');
                $("#text_idcard").attr('reg', '{"required":"true","regex":"lineAndNumbers"}');
                $('#text_idcard').on('keyup mouseout',function(e){
                    var ev = document.all ? window.event : e;
                    //删除键不触发此事件
                    if(ev.keyCode != 8) {
                        $("#text_idcard").val($("#text_idcard").val().replace(/-/,''));
                        $("#text_idcard").val($("#text_idcard").val().replace(/\D+/g,'').replace(/(\d{4})/g,'$1-').trim());
                    }
                });
            } else{
                $("#text_idcard").removeAttr('reg');
                $("#text_idcard").attr('reg', '{"required":"true","regex":"lettersAndNumbers"}');
            }
        }else {//personID存在值
            if ("0" == id) {
                $("#text_idcard").removeAttr('reg');
                $("#text_idcard").attr('reg', '{"required":"true","idCard":"true"}');
            }
            if("5" == id){
                $("#text_idcard").removeAttr('reg');
                $("#text_idcard").attr('reg', '{"required":"true"}');
            }
        }
        var filingflag = $("#filingFlag").val();
        if(filingflag == 0 && !$.isEmpty(filingflag)){
            var otherIdcardType = $("#otherIdcardType option:checked").val();
            var babyCardNoText = ($("input[name='PersonInfoDTO.personInfo.babyCardNo']").val());
            var babyCardNo = $("#babyCardNo").val();
            if(otherIdcardType == 9 && $.isEmpty(babyCardNo)){
                $("#babyCardNoShowText").show();
            }else if(otherIdcardType == 0 && $.isEmpty(babyCardNoText)){
                $("#babyCardNoShowText").hide();
            }
        }
    }

    return {
        displayHrAddress: displayHrAddress,
        displayPaAddress: displayPaAddress,
        isCoverClicked: isCoverClicked,
        saveCover: saveCover,
        isUnCreatePerson: isUnCreatePerson,
        changeIdType: changeIdType
    };
})();
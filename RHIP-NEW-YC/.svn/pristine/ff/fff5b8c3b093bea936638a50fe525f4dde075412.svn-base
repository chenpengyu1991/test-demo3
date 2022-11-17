var addPersonInfo = (function(){
    var isInfoClick = false
    var validate=$("#personInfoForm").easyValidate();
    validate.addExtension("exposeHistoryVali",exposeHistoryVali);
    validate.addExtension("deformityVali",deformityVali);
    validate.addExtension("diseaseHistoryVali",diseaseHistoryVali);
    $(function(){

        //家族史
        toggleOtherCK('PersonalBasicInfoDTO.fatherStr','fatherStrDescSpan','99');
        toggleOtherCK('PersonalBasicInfoDTO.motherStr','motherStrDescSpan','99');
        toggleOtherCK('PersonalBasicInfoDTO.brotherStr','brotherStrDescSpan','99');
        toggleOtherCK('PersonalBasicInfoDTO.childStr','childStrDescSpan','99');
        toggleOtherCK('PersonalBasicInfoDTO.drugAllergyHistoryStr','drugAllergyHistoryDescSpan',9);

        if($("#nation").val() != '01' && !$.isEmpty($("#nation").val()) && $("#nation").val() != '1'){
            $("#otherNationDesc").show();
        }
        //银川不默认 血型和RH类型
        /*checkRadio("PersonalBasicInfoDTO.personInfo.aboBloodType", 4);
        checkRadio("PersonalBasicInfoDTO.personInfo.rhBloodType", 2);*/

        showst("deformityHistoryOther","deformityHistoryDesc");

        if ($("#firstFlg").length>0) {
            $("#two1").attr("class","hover");
            $("#two2").attr("class","");
            $("#two3").attr("class","");
            $("firstFlg").remove();
        }

        $("#button_save").click(function(e) {
            e.preventDefault();
            exzlChange();//过滤恶性肿瘤名称必填验证
            var r = mbbkReportCheck();//BUG0158233 bug0170947:
            if(!r){
                showMbGl();
                return;
            }
            savePersonInfo();
            isInfoClick = true;
        });

        $(".flag").each(function(){
            var idVal = $(this).attr("id");
            var idArr = idVal.split("_");

            if("Flag2"===idArr[1]){
                $(this).click(function(){
                    $("#"+idArr[0]+"Span").show();
                });
            }

            if("Flag1"===idArr[1]){
                $(this).click(function(){
                    $("#"+idArr[0]+"Span").hide();
                });
            }
        });

        //新增手术
        var surgeryIndex = $("#surSize").val();
        var OnClickHtml = "WdatePicker({skin:'whyGreen',dateFmt:'yyyy/MM/dd'})";
        $("#addSurgeryHistory").click(function() {
            var lastSurgery = $("#surgeryHistorySpan span:last");
            var surgeryNameRule = {"dependOn":"surgeryHistory_Flag2","required":true,"maxlength":33};
            var surgeryDateRule = {"dependOn":"surgeryHistory_Flag2","required":true};
            var surgeryName = "PersonalBasicInfoDTO.surgeryHistoryList[" + surgeryIndex + "].opsName";
            var surgeryDate = "PersonalBasicInfoDTO.surgeryHistoryList[" + surgeryIndex + "].opsDate";
            var newSurgery = "<br/><span>名称 <input type='text' class='ap_req_value_input' name=" + surgeryName + " style='width: 25%'/> &emsp; 时间 <input name=" + surgeryDate + " style='padding-left:0px;width:90px;display:inline-block' type='text' class='layui-input datetime' /> &emsp;</span>";
            lastSurgery.append(newSurgery);
            validate.addCheckElement(surgeryName,surgeryNameRule);
            validate.addCheckElement(surgeryDate,surgeryDateRule);
            surgeryIndex ++;
            timeAddClass();
        });

        //新增外伤
        var traumaIndex = $("#traSize").val();
        $("#addTraumaHistory").click(function() {
            var lastTrauma = $("#traumaHistorySpan span:last");
            var traumaNameRule = {"dependOn":"traumaHistory_Flag2","required":true,"maxlength":33};
            var traumaDateRule = {"dependOn":"traumaHistory_Flag2","required":true};
            var traumaName = "PersonalBasicInfoDTO.traumaHistoryList[" + traumaIndex + "].opsName";
            var traumaDate = "PersonalBasicInfoDTO.traumaHistoryList[" + traumaIndex + "].opsDate";
            var newTrauma = "<br/><span>名称 <input type='text' class='ap_req_value_input' name=" + traumaName + " style='width: 25%'/> &emsp; 时间 <input name=" + traumaDate + " style='padding-left:0px;width:90px;display:inline-block' type='text' class='layui-input datetime' /> &emsp;</span>";
            lastTrauma.append(newTrauma);
            validate.addCheckElement(traumaName,traumaNameRule);
            validate.addCheckElement(traumaDate,traumaDateRule);
            traumaIndex ++;
            timeAddClass();
        });

        //新增输血
        var bloodIndex = $("#bloSize").val();
        $("#addBloodHistory").click(function() {
            var lastBlood = $("#transBloodHistorySpan span:last");
            var bloodReasonRule = {"dependOn":"transBloodHistory_Flag2","required":true,"maxlength":33};
            var bloodDateRule = {"dependOn":"transBloodHistory_Flag2","required":true};
            var bloodReason = "PersonalBasicInfoDTO.transBloodHistoryList[" + bloodIndex + "].bloodReason";
            var bloodDate = "PersonalBasicInfoDTO.transBloodHistoryList[" + bloodIndex + "].bloodDate";
            var newBlood = "<br/><span>原因 <input type='text' class='ap_req_value_input' name=" + bloodReason + " style='width: 25%'/> &emsp; 时间 <input name=" + bloodDate + " style='padding-left:0px;width:90px;display:inline-block' type='text' class='layui-input datetime'/> &emsp;</span>";
            lastBlood.append(newBlood);
            validate.addCheckElement(bloodReason,bloodReasonRule);
            validate.addCheckElement(bloodDate,bloodDateRule);
            bloodIndex ++;
            timeAddClass();
        });
        //新增遗传病
        var familyHeredityIndex = $("#familyHereditySize").val();
        $("#addFamilyHeredityHistory").click(function() {
            var lastFamilyHeredity = $("#familyHeredityHistorySpan span:last");
            var familyHeredityNameRule = {"dependOn":"familyHeredityHistory_Flag2","required":true,"maxlength":33};
            var familyHeredityName = "PersonalBasicInfoDTO.familyHeredityHistoryList[" + familyHeredityIndex + "].heredityhistory";
            var newFamilyHeredity = "<br/><span>疾病名称 <input type='text'  class='ap_req_value_input' name=" + familyHeredityName + " style='width: 24%'/> &emsp;</span>";
            lastFamilyHeredity.append(newFamilyHeredity);
            validate.addCheckElement(familyHeredityName,familyHeredityNameRule);
            familyHeredityIndex ++;
        });

        //删除手术
        $("#delSurgeryHistory").click(function(){
            if(surgeryIndex != 1){
                var index = surgeryIndex - 1;
                validate.removeCheckElement("PersonalBasicInfoDTO.surgeryHistoryList[" + index + "].opsName");
                validate.removeCheckElement("PersonalBasicInfoDTO.surgeryHistoryList[" + index + "].opsDate");
                $("#surgeryHistorySpan span:last").remove();
                $("#surgeryHistorySpan br:last").remove();
                surgeryIndex --;
            }
        });

        //删除外伤
        $("#delTraumaHistory").click(function(){
            if(traumaIndex != 1){
                var index = traumaIndex - 1;
                validate.removeCheckElement("PersonalBasicInfoDTO.traumaHistoryList[" + index + "].opsName");
                validate.removeCheckElement("PersonalBasicInfoDTO.traumaHistoryList[" + index + "].opsDate");
                $("#traumaHistorySpan span:last").remove();
                $("#traumaHistorySpan br:last").remove();
                traumaIndex --;
            }
        });

        //删除输血
        $("#delBloodHistory").click(function(){
            if(bloodIndex != 1){
                var index = bloodIndex - 1;
                validate.removeCheckElement("PersonalBasicInfoDTO.transBloodHistoryList[" + index + "].opsName");
                validate.removeCheckElement("PersonalBasicInfoDTO.transBloodHistoryList[" + index + "].opsDate");
                $("#transBloodHistorySpan span:last").remove();
                $("#transBloodHistorySpan br:last").remove();
                bloodIndex --;
            }
        });

        //删除遗传病
        $("#delFamilyHeredityHistory").click(function(){
            if(familyHeredityIndex != 1){
                var index = familyHeredityIndex - 1;
                var familyHeredityName = "PersonalBasicInfoDTO.familyHeredityHistoryList[" + index + "].heredityhistory";
                validate.removeCheckElement(familyHeredityName);
                $("#familyHeredityHistorySpan span:last").remove();
                $("#familyHeredityHistorySpan br:last").remove();
                familyHeredityIndex --;
            }
        });
        $("#button_print").click(function(e){
            e.preventDefault();
            var reportClass=$("#printDiv").attr("class");
            $("#printDiv").removeClass();
            $("#printDiv").jqprint(
                {
                    debug: false, //如果是true则可以显示iframe查看效果（iframe默认高和宽都很小，可以再源码中调大），默认是false
                    importCSS: true, //true表示引进原来的页面的css，默认是true。（如果是true，先会找$("link[media=print]")，若没有会去找$("link")中的css文件）
                    printContainer: true, //表示如果原来选择的对象必须被纳入打印（注意：设置为false可能会打破你的CSS规则）。
                    operaSupport: true//表示如果插件也必须支持歌opera浏览器，在这种情况下，它提供了建立一个临时的打印选项卡。默认是true
                });
            $("#printDiv").addClass(reportClass);
        });

        $("#lastMenstrualDateId").on("blur", function () {
            var lastMenstrualDateStr = $("#lastMenstrualDateId").val();
            if (lastMenstrualDateStr){
                var lastMenstrualDate = parseStrToDate(lastMenstrualDateStr);
                lastMenstrualDate = dateAdd('m', 9, lastMenstrualDate );
                lastMenstrualDate = dateAdd('d', 7, lastMenstrualDate );
                var y = lastMenstrualDate.getFullYear();
                var m = lastMenstrualDate.getMonth() + 1;
                var d = lastMenstrualDate.getDate();
                var estimatedDueDate = y+'/'+m+'/'+d;
                $("#estimatedDueDateId").val(estimatedDueDate);
            }
        });


        //当‘医疗费用支付方式’选择‘新型农村合作医疗’时，‘生活环境’设为必输项
        expenseInfoChange('03');
        exzlChange();//既往史中的选择恶性肿瘤需要提供文本输入框，输入病名
        zybChange();//既往史中的选择职业病需要提供文本输入框，输入病名
        isMaternal();//是否孕产妇
        showMaternal();
        timeAddClass();
    });

    //糖尿病标记
    var diFlag = null;
    //高血压标记
    var hbpFlag = null;
    // 脑卒中
    var strokeFlag = null;
    //冠心病
    var coronaryFlag = null;
    //肿瘤
    var tumorFlag = null;

    function showMbGl(){
        //婚姻
        var hy = $("input:radio[name='PersonalBasicInfoDTO.personInfo.marriage']:checked").val();
        //民族
        var mz = $("input:radio[name='PersonalBasicInfoDTO.personInfo.nation']:checked").val();
        //少数名族
        var othermz = $("#otherNationDesc").val();
        //职业
        var zhiye = $("#occupation").val();
        //文化程度
        var whcd = $("#education").val();
        //工作单位
        var unitName=$("#unitName").val();
        // 既往史-有疾病史，高血压确诊日期
        var gxyDate = $("input[name='PersonalBasicInfoDTO.gxyDate']").val();
        // 糖尿病日期
        var tnbDate = $("input[name='PersonalBasicInfoDTO.tnbDate']").val();
        //冠心病
        var gxbDate = $("input[name='PersonalBasicInfoDTO.gxbDate']").val();
        //脑卒中
        var nzzDate = $("input[name='PersonalBasicInfoDTO.nzzDate']").val();
        layui.use('layer', function(){
            var layer = layui.layer;
            layer.confirm('请先创建慢病管理卡？', {icon:1, title:'确认提示'}, function(index){
                $("#beforeSaveDiv").hide();
                $("#mbglk").show();
                layer.close(index);
                var loadHtmlByUrlOption = {
                    url: "/cdm/standardization/input",
                    param:{
                        personId:$("#personId").val(),
                        personRecordFlag:1,
                        diFlag:diFlag,
                        hbpFlag:hbpFlag,
                        strokeFlag:strokeFlag,
                        coronaryFlag:coronaryFlag,
                        tumorFlag:tumorFlag,
                        hy:hy,
                        mz:mz,
                        othermz:othermz,
                        zhiye:zhiye,
                        whcd:whcd,
                        unitName:unitName,
                        gxyDate:gxyDate,
                        tnbDate:tnbDate,
                        gxbDate:gxbDate,
                        nzzDate:nzzDate,
                        exzlDate:$("input[name='PersonalBasicInfoDTO.exzlDate']").val(),//肿瘤诊断日期
                        judge:1,
                        exzlName:$("input[name='PersonalBasicInfoDTO.exzlName']").val()//肿瘤名称
                    },
                    insertDiv: "mbglk"
                };
                $.loadHtmlByUrl(loadHtmlByUrlOption);
            });
        });
    }
    function mbbkReportCheck(){//返回true检查通过 不弹出慢病管理提示
        var diseaseHistoryVal = $("input[name='PersonalBasicInfoDTO.diseaseHistoryFlag']:checked").val();
        if(diseaseHistoryVal==1)
            return true;
        var gxyVal = $("input[name='PersonalBasicInfoDTO.gxy']").is(":checked");
        var tnbVal = $("input[name='PersonalBasicInfoDTO.tnb']").is(":checked");
        var gxbVal = $("input[name='PersonalBasicInfoDTO.gxb']").is(":checked");
        var nzzVal = $("input[name='PersonalBasicInfoDTO.nzz']").is(":checked");
        var exzlVal = $("input[name='PersonalBasicInfoDTO.exzl']").is(":checked");
        var isNotManageOrgVal = $("#isNotManageOrg").val();
        if(isNotManageOrgVal)//当前登录机构和档案管理机构不一致时 不弹出慢病管理卡
            return true;
        if(!gxyVal&&!tnbVal&&!gxbVal&&!nzzVal&&!exzlVal)
            return true;
        var idcard =  $("input[name='PersonalBasicInfoDTO.personInfo.idcard']").val();
        var rs;
        $.urlPost({
            url : "/cdm/standardization/bkjc/" + idcard+"/"+gxyVal+"/"+tnbVal+"/"+nzzVal+"/"+gxbVal+"/"+exzlVal,
            async:false,
            callback : function(data) {
                if (data.result=='1')
                {
                    diFlag=data.diFlag;
                    hbpFlag=data.hbpFlag;
                    strokeFlag=data.strokeFlag;
                    coronaryFlag=data.coronaryFlag;
                    tumorFlag=data.tumorFlag;
                    rs = false;
                } else
                {
                    rs=true;
                }
            }
        });
        return rs;
    }

    function savePersonInfo(fn){
        var result = validate.validateForm();
        if(!result){
            return false;
        }
        var isElder = $("#isElder").val();
        var option = "保存成功";
        /**if(isElder == '1'){
			option = "保存成功！请做年度体检，必检检验项目含血常规、尿常规、肝功能（血清谷草转氨酶、血清谷丙转氨酶和总胆红素）、肾功能（血清肌酐和尿素氮）、空腹血糖、血脂、心电图检测和腹部B超。";
		}**/
        /**if($("#guideIntoChronicDiseaseFlagId").val() == '1' &&
         $.isEmpty($('input[name="PersonalBasicInfoDTO.gxy"]:visible:checked').val()) &&
         $.isEmpty($('input[name="PersonalBasicInfoDTO.tnb"]:visible:checked').val()) &&
         $.isEmpty($('input[name="PersonalBasicInfoDTO.zxjsb"]:visible:checked').val())){
            layer.alert("此患者已纳入纳入慢性病患者健康管理,但既往史中无高血压、糖尿病、严重精神障碍");
        }**/
        $("#person_info_errbox").empty();
        $("#button_save").html('<button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>正在保存...</button>');
        $("#personInfoForm").submitFormGetJson({
            url: "/personRecord/savePersonBasicInfo",
            insertDiv: "beforeSaveDiv",
            callback: function () {
                //todo
                /*$("#basic_info_status").removeClass("person_record_todo");
                $("#basic_info_status").addClass("person_recoed_complete");*/
                $("#basic_info_li").children(":first").html("&#xe605;");
                $("#save_person_info_mark").val(1);//保存成功标记，用来在tab中切换判断
                $("#button_save").html('<button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button>');
                if (isInfoClick || $("#cdm_card_save_mark").val() == "1") { // 点击人员基本信息tab或慢病管理卡保存成功之后调用
                    layer.alert(option, {icon:0,title:'提示'});
                    $("#cdm_card_save_mark").val("");// 还原标记位
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

    function exposeHistoryVali(){
        var inputs=$("#exposeHistorySpan").find("input");
        var selecteds=inputs.filter(":checked");
        if(selecteds.length>0){
            inputs.each(function(){
                $(this).parent().removeClass("lose");
            });
            return true;
        }else{
            inputs.each(function(){
                $(this).parent().addClass("lose");
            });
            return false;
        }
    }

    function deformityVali(){
        var inputs=$("#deformitySpan").find("input");
        var selecteds=inputs.filter(":checked");
        if(selecteds.length>0){
            inputs.each(function(){
                $(this).parent().removeClass("lose");
            });
            return true;
        }else{
            inputs.each(function(){
                $(this).parent().addClass("lose");
            });
            return false;
        }
    }

    function diseaseHistoryVali(){
        var inputs=$("#diseaseHistorySpan").find("input");
        var selecteds=inputs.filter(":checked");
        if(selecteds.length>0){
            inputs.each(function(){
                $(this).parent().removeClass("lose");
            });
            return true;
        }else{
            inputs.each(function(){
                $(this).parent().addClass("lose");
            });
            return false;
        }
    }

    function check(){
        var errorList=null;
        $(".selectedFlag").each(function(){
            if($(this).prop("checked")){
                var idVal = $(this).attr("id");
                var idArr = idVal.split("_");
                var selectedIitems=$("#"+idArr[0]+"Span  input:checked");
                //alert(selectedIitems.length);
                if(selectedIitems.length<1){
                    $(this).parent().addClass("errbox");
                    if(null==errorList){
                        errorList={};
                    }
                    errorList[idVal]=$(this).parent().prev().text()+"请选择一项";
                }else{
                    $(this).parent().removeClass("errbox");
                }
            }else{
                $(this).parent().removeClass("errbox");
            };
        });
        $(".selectedInputFlag").each(function(){
            if($(this).prop("checked")){
                var idVal = $(this).attr("id");
                var idArr = idVal.split("_");
                var selectedIitems=$("#"+idArr[0]+"Span  .ap_req_value_input[value!='']");
                if(selectedIitems.length<1){
                    if(null==errorList){
                        errorList={};
                    }
                    errorList[idVal]=$(this).parent().prev().text()+"请输入名称";
                    $(this).parent().addClass("errbox");
                } else{
                    $(this).parent().removeClass("errbox");
                }
            }else{
                $(this).parent().removeClass("errbox");
            }
        });


        return errorList;
    }

    //没有选中的情况下，如果没有第2个参数，则选中第一个radio；如果有，则选中参数指定的radio
    function checkRadio(){
        var args = Array.prototype.slice.call(arguments);
        if(typeof(args[1]) == "undefined"){
            if($("input[name='" + args[0] + "']:checked").val() == null){
                $("input[name='" + args[0] + "']:first").attr("checked", true);
            }
        }else {
            if($("input[name='" + args[0] + "']:checked").val() == null){
                $("input[name='" + args[0] + "']:eq(" + args[1] + ")").attr("checked", true);
            }
        }
    }

    function showst(checkId,someId) {
        if ($("#" +checkId).attr("checked") == "checked"){
            $("#"+someId).show();
        }
    }

    /**
     * 当‘医疗费用支付方式’选择‘新型农村合作医疗’时，‘生活环境’设为必输项
     * @param code 新型农村合作医疗的编码
     */
    function expenseInfoChange(code) {
        var raValue = '';
        $('input[name="PersonalBasicInfoDTO.expenseInfoStr"]:visible:checked').each(function()
        {
            raValue += $(this).val() + ",";
        });
        //选择了新型农村合作医疗
        if (raValue.indexOf(code) != -1)
        {
            //将‘生活环境’设为必输项
            validate.addCheckElement('PersonalBasicInfoDTO.personInfo.outWindType',{"required":"true"});
            validate.addCheckElement('PersonalBasicInfoDTO.personInfo.fuel',{"required":"true"});
            validate.addCheckElement('PersonalBasicInfoDTO.personInfo.water',{"required":"true"});
            validate.addCheckElement('PersonalBasicInfoDTO.personInfo.hastoilet',{"required":"true"});
            validate.addCheckElement('PersonalBasicInfoDTO.personInfo.fowlType',{"required":"true"});
        }else{
            //将‘生活环境’取消必输项
            validate.removeCheckElement('PersonalBasicInfoDTO.personInfo.outWindType');
            validate.removeCheckElement('PersonalBasicInfoDTO.personInfo.fuel');
            validate.removeCheckElement('PersonalBasicInfoDTO.personInfo.water');
            validate.removeCheckElement('PersonalBasicInfoDTO.personInfo.hastoilet');
            validate.removeCheckElement('PersonalBasicInfoDTO.personInfo.fowlType');
        }
    }

    /**
     * 恶心肿瘤选择时，需要输入具体疾病名称
     * @param code
     */
    function exzlChange() {
        var code='205';
        var raValue = '';
        $('input[name="PersonalBasicInfoDTO.exzl"]:visible:checked').each(function()
        {
            raValue += $(this).val() + ",";
        });
        //选择了新型农村合作医疗
        if (raValue.indexOf(code) != -1)
        {
            //$('#exzlNameSpan').show();
            //将‘肿瘤名称设为必输项目’设为必输项
            validate.addCheckElement('PersonalBasicInfoDTO.exzlName',{"required":"true","maxlength":"50"});
        }else{
            //$('#exzlNameSpan').hide();
            //将‘肿瘤名称设为必输项目’取消必输项
            validate.removeCheckElement('PersonalBasicInfoDTO.exzlName');
        }
    }

    /**
     * 职业病选择时，需要输入具体疾病名称
     * @param code
     */
    function zybChange() {
        var code='213';
        var raValue = '';
        $('input[name="PersonalBasicInfoDTO.zyb"]:visible:checked').each(function()
        {
            raValue += $(this).val() + ",";
        });
        if (raValue.indexOf(code) != -1)
        {
            //$('#exzlNameSpan').show();
            //将‘职业病名称设为必输项目’设为必输项
            validate.addCheckElement('PersonalBasicInfoDTO.zybName',{"required":"true","maxlength":"50"});
        }else{
            //$('#exzlNameSpan').hide();
            //将‘职业病名称设为必输项目’取消必输项
            validate.removeCheckElement('PersonalBasicInfoDTO.zybName');
        }
    }

    function isMaternal(){
        var maternalFlag = $('input:radio[name="PersonalBasicInfoDTO.personInfo.maternalFlag"]:checked').val();
        if(maternalFlag == '1'){
            $('#maternalTrId').hide();
            $('#lastMenstrualDateId').val('');
            $('#estimatedDueDateId').val('');
        }else if(maternalFlag == '2'){
            $('#maternalTrId').show();
        }
    }

    function dateAdd(interval, number, date) {
        switch (interval) {
            case "y": {
                date.setFullYear(date.getFullYear() + number);
                return date;
                break;
            }
            case "q": {
                date.setMonth(date.getMonth() + number * 3);
                return date;
                break;
            }
            case "m": {
                date.setMonth(date.getMonth() + number - 1);
                return date;
                break;
            }
            case "w": {
                date.setDate(date.getDate() + number * 7);
                return date;
                break;
            }
            case "d": {
                date.setDate(date.getDate() + number);
                return date;
                break;
            }
            case "h": {
                date.setHours(date.getHours() + number);
                return date;
                break;
            }
            case "mi": {
                date.setMinutes(date.getMinutes() + number);
                return date;
                break;
            }
            case "s": {
                date.setSeconds(date.getSeconds() + number);
                return date;
                break;
            }
            default: {
                date.setDate(date.getDate() + number);
                return date;
                break;
            }
        }
    }

    function parseStrToDate(strDate) {
        var date = eval('new Date(' + strDate.replace(/\d+(?=-[^-]+$)/,
            function(a) {
                return parseInt(a, 10) - 1;
            }).match(/\d+/g) + ')');
        return date;
    }


    function showMaternal(){
        var gender = $('input:radio[name="PersonalBasicInfoDTO.personInfo.gender"]:checked').val();
        if(gender != '1'){
            $('#maternalThId').show();
            $('#maternalTdId').show();
        }else{
            $('#maternalThId').hide();
            $('#maternalTdId').hide();
            $('#maternalTrId').hide();
            $("input[name='PersonalBasicInfoDTO.personInfo.maternalFlag'][value='1']").attr("checked",true);
            $('#lastMenstrualDateId').val('');
            $('#estimatedDueDateId').val('');
        }
    }

    function backSave(){
        exzlChange();//过滤恶性肿瘤名称必填验证
        // var r = mbbkReportCheck();
        // if(!r){
        //     showMbGl();
        //     return;
        // }
        $("#cdm_card_save_mark").val(1); // 慢病管理卡保存成功之后调用标记
        savePersonInfo();
    }

    function isInfoClicked() {
        isInfoClick = false;
    }

    function timeAddClass() {
        layui.use('laydate', function () {
            var laydate = layui.laydate;
            //核心方法
            lay('.datetime').each(function () {
                laydate.render({
                    elem: this,
                    format: 'yyyy/MM/dd',
                    trigger: 'click',
                    done: function (value, date) {
                        $(".datetime").each(function () {
                            if ($(this).val() != '') {
                                $(this).removeClass("lose");
                            } else {
                                $(this).addClass("lose");
                            }
                        });
                    }
                });
            });
        });
    }
    return {
        savePersonInfo:savePersonInfo,
        mbbkReportCheck:mbbkReportCheck,
        showMbGl:showMbGl,
        expenseInfoChange:expenseInfoChange,
        exzlChange:exzlChange,
        zybChange:zybChange,
        isMaternal:isMaternal,
        showMaternal: showMaternal,
        backSave:backSave,
        isInfoClicked:isInfoClicked
    };

})();
var addConsultation = (function () {
    var isCoverClick = false;
    var validate = null;
    var flag = null;
    $(function () {
        var msg = $("#firstFlg").val();

        if (!$.isEmpty(msg)) {
       		layer.alert(msg, {icon:0,title:'提示'});
        }
        if ($("#firstFlg").length > 0) {
            $("#two1").attr("class", "hover");
            $("#two2").attr("class", "");
            $("#two3").attr("class", "");
            $("#two4").attr("class", "");
            $("#two5").attr("class", "");
            $("#two6").attr("class", "");
            $("firstFlg").remove();
        }
        toggleOrgAndName();
    });


    //获取单个会诊记录
    function getConsultation(id){
        var loadByUrl = {
            url : "/personRecord/getConsultation",
            insertDiv : "consultationDiv",
            param : {
                id : id
            }
        };
        $.loadHtmlByUrl(loadByUrl);
    }

    //新增会诊记录
    $("#button_add").click(function (e) {
    	e.preventDefault();
        $.loadHtmlByUrl({
            url : contextPath + "/personRecord/addConsultation",
            insertDiv :"basic_consultation_view",
            param:{
                isNew : "Y"
            }
        });
    });

    //保存会诊记录
    $("#button_save").click(function (e) {
    	e.preventDefault();
        var orgAndNameJosn = getOrgNameJosn();
        $("#consulationOrgAndName").val(orgAndNameJosn);
        saveConsultation();
    });

    function saveConsultation(fn){
        validate = $("#consultationForm").easyValidate();
        var result = validate.validateForm();
        if(!result){
            return false;
        }
        var option = "保存成功";

        $("#consultationForm").submitFormGetJson({
            url: "/personRecord/saveConsultation",
            insertDiv: "personal_basicinfo_content",
            callback: function () {
                /*$("#basic_consultation_status").removeClass("person_record_todo");
                $("#basic_consultation_status").addClass("person_recoed_complete");*/
            	layer.alert(option, {icon:0,title:'提示'});
            	$("#basic_consultation_view_li").children(":first").html("&#xe605;");
                $.loadHtmlByUrl({
                    url : contextPath + "/personRecord/addConsultation",
                    insertDiv :"personal_basicinfo_content",
                    param:null
                });
            }
        });
        return true;
    }

    //增加一个会诊机构
    $("#addOrgAndDoc").click(function() {
        var size = $("#orgAndDoc span").size();
        size++;
        var newTrauma = "<span><input type='text' name='orgName' style='width: 50%'/> | "+
                        "<input type='text' name='docName"+size+"' style='width: 15%'/> "+
                        "<input type='text' name='docName"+size+"' style='width: 15%'/> "+
                        "<input type='text' name='docName"+size+"' style='width: 15%'/> "+
                        "<br/></span>";
        $("#orgAndDoc").append(newTrauma);
    });

    //删除一个会诊机构
    $("#delOrgAndDoc").click(function() {
        var size = $("#orgAndDoc span").size();
        if (size != 1){
            $("#orgAndDoc span:last").remove();
        }else{
            layer.alert("至少有一个会诊医疗卫生机构！", {icon:0,title:'提示'});
        }
    });

    //获取会诊医生及其所在医疗卫生机构并拼接成json
    function getOrgNameJosn(){
        var orgAndNames = [];
        $("input[name='orgName']").each(function(i){
            var orgAndNameObj = {};
            var index = i+1;
            var docName = 'docName'+index;
            var docNames = [];
            var orgName = $(this).val();
            orgAndNameObj['key'] = orgName;
            $("input[name="+docName+"]").each(function(j){
                docNames.push($(this).val());
            });
            orgAndNameObj['value'] = docNames;
            if (orgName != "" && docNames.length > 0){
                orgAndNames.push(orgAndNameObj);
            }
        });
        var orgAndNameJosn = JSON.stringify(orgAndNames);
        return orgAndNameJosn;
    }

    //获取后台json显示到页面
    function toggleOrgAndName(){
        var consulationOrgAndName = $("#consulationOrgAndName").val();
        var newTrauma;

        if (!$.isEmpty(consulationOrgAndName)  && consulationOrgAndName != "[]"){
            try {
                var jsObject = JSON.parse(consulationOrgAndName);

                $.each(jsObject, function(idx, obj) {
                    var index = idx+1;
                    newTrauma = "<span><input type='text' name='orgName' value='"+obj.key+"' style='width: 50%'/> | "+
                                "<input type='text' name='docName"+index+"' value='"+obj.value[0]+"' style='width: 15%'/> "+
                                "<input type='text' name='docName"+index+"' value='"+obj.value[1]+"' style='width: 15%'/> "+
                                "<input type='text' name='docName"+index+"' value='"+obj.value[2]+"' style='width: 15%'/> "+
                                "<br/></span>";
                    $("#orgAndDoc").append(newTrauma);
                });
            }catch (e) {
                alert(e);
            }
        }else {
            var newTrauma = "<span><input type='text' name='orgName' style='width: 50%'/> | "+
                            "<input type='text' name='docName"+1+"' style='width: 15%'/> "+
                            "<input type='text' name='docName"+1+"' style='width: 15%'/> "+
                            "<input type='text' name='docName"+1+"' style='width: 15%'/> "+
                            "<br/></span>";
            $("#orgAndDoc").append(newTrauma);
        }
	}

    return {
        getOrgNameJosn: getOrgNameJosn,
        getConsultation:getConsultation

    };
})();
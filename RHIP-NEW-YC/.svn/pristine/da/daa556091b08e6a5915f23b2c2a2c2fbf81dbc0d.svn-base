var contact = (function() {
	var singleIdTemp = '';
	$(function() {
	});

	function initContacts(singleId, patientName, registerNum, logoff) {
		singleIdTemp = singleId;
        $("#top_allStandardization").hide();
        var pageIndex = $("#pageIndex").val();
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        $.loadHtmlByUrl({
            url : "/idm/tb/management/initContacts",
//            wait : true,
            insertDiv :"detailDivStandardization",
            param : {
                singleId : singleId,
                patientName : patientName,
                registerNum : registerNum,
                logoff: logoff,
                pageIndex: pageIndex
            }
        });
        $("#detailDivStandardization").show();
	};

    function addCc(){
        var validate=null;
        validate = $("#ccForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var patientName = $("#patientNameCC").val();
        var registNo = $("#registNoCC").val();
        $("#ccForm").submitFormGetJson({
            url : "/idm/tb/management/addContacts",
            wait : true,
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("保存失败！", {icon:0,title:'提示'});
                }else {
                    layer.alert("保存成功！", {icon:0,title:'提示'});
                    initContacts(singleIdTemp, patientName, registNo);
                    return false;
                }
            }
        });
    }

    function clickRow(selectRow){
        var id = $(selectRow).attr("id");
        $.loadHtmlByUrl({
            url : "/idm/tb/management/contactDetail",
//            wait : true,
            insertDiv :"detailDiv",
            param : {
                id: id
            }
        });
        $("#xinzeng").show();
        $("#xiugai").show();
        $("#shanchu").show();
        $("#baocun").hide();
    }

    function changeType(radioName){
        var raValue = $('input[name="' + radioName+ '"]:checked').val();
        if(raValue == 1){
            $("#closeDetail1").show();
            $("#closeDetail2").hide();
            $("#closeDetail1").removeAttr("disabled");
            $("#closeDetail2").attr("disabled","disabled");

        }else if(raValue == 2){
            $("#closeDetail1").hide();
            $("#closeDetail2").show();
            $("#closeDetail1").attr("disabled","disabled");
            $("#closeDetail2"). removeAttr("disabled");
        }else{
            $("#closeDetail1").hide();
            $("#closeDetail2").hide();
            $("#closeDetail1").attr("disabled","disabled");
            $("#closeDetail2").attr("disabled","disabled");
        }
    }

    function deleteCc(){
    	layui.use('layer', function(){
    		var layer = layui.layer;
    		layer.confirm("确定删除该接触者？", {icon:2, title:'确认提示'}, function(index){
	            var ccId = $("#ccId").val();
	            var singleId = $("#singleId").val();
	            var patientName = $("#patientNameCC").val();
	            var registNo = $("#registNoCC").val();
	            $("#ccForm").submitFormGetJson({
	                url : "/idm/tb/management/deleteContacts",
	                wait : true,
	                param:{
	                    id:ccId
	                },
	                callback : function(data) {
	                    if (data.indexOf("fail") > -1) {
	                    	layer.alert("删除失败！", {icon:0,title:'提示'});
	                    }else {
	                    	layer.alert("删除成功！", {icon:0,title:'提示'});
	                        initContacts(singleId, patientName, registNo);
	                        return false;
	                    }
	                }
	            });
	            layer.close(index);
    		});
    	});		
    }

    function updateCc(){
        var validate=null;
        validate = $("#ccForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var singleId = $("#singleId").val();
        var patientName = $("#patientNameCC").val();
        var registNo = $("#registNoCC").val();
        $("#ccForm").submitFormGetJson({
            url : "/idm/tb/management/updateContacts",
            wait : true,
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("修改失败！", {icon:0,title:'提示'});
                }else {
                    layer.alert("修改成功！", {icon:0,title:'提示'});
                    initContacts(singleId, patientName, registNo);
                    return false;
                }
            }
        });
    }

    function initAddCc(){
        var patientNameFr = $("#patientNameFr").val();
        var registNoFr = $("#registNoFr").val();
        $("#ccForm").find("input[type=text]").each(function(){
            $(this).val('');
        });
        $("#ccForm").find("input[type=radio]").each(function(){
            $(this).attr("checked",false);
        });
        $("#ccForm").find("input[type=checkbox]").each(function(){
            $(this).attr("checked",false);
        });
        $("#ccForm").find("select").each(function(){
            $(this).val('');
        });
        $(".listtrselect").removeClass("listtrselect");
        $("#patientNameFr").val(patientNameFr);
        $("#registNoFr").val(registNoFr);

        $("#closeDetail1").hide();
        $("#closeDetail2").hide();
        $("#xinzeng").hide();
        $("#xiugai").hide();
        $("#shanchu").hide();
        $("#baocun").show();
    }

    function search(pageIndex){
        $.loadHtmlByUrl({
            url : "/idm/tb/management/getContacts",
            insertDiv :"contactsList",
            wait : true,
            param : {
                singleId: singleIdTemp,
                pageIndex: pageIndex
            }
        });
        $("#detailDivStandardization").show();
    }

    function contactsExport(){
        var searchObj = {
            url : "/idm/tb/management/contacts/downExcel",
            param:{singleId : $("#singleId").val()}
        };
        $("#ccForm").exportListExcel(searchObj);
    }

	return {
        search:search,
        initContacts: initContacts,
        addCc:addCc,
        updateCc:updateCc,
        clickRow:clickRow,
        changeType:changeType,
        deleteCc:deleteCc,
        initAddCc:initAddCc,
        contactsExport : contactsExport
	};
})();

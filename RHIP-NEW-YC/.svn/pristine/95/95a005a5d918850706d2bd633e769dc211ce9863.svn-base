var contact = (function() {
	var singleIdTemp = '';
	
	$(function() { 
        search(1);
        $("#contactBtnSearch").click(function() {
            search(1);
        });
        $("#contactSearchForm").onEnter(search, 1);
        
	});

	function search(indexPage) { 
		var searchObj = {
				url : "/idm/leprosy/contact/list",
				insertDiv : "listDivContact",
//                wait : true,
				param : {
					indexPage : indexPage
				}
			};
		$("#contactSearchForm").submitFormLoadHtml(searchObj);
	};
	
	function searchTemp(pageIndex){
		if($.isEmpty(pageIndex)) {
			 pageIndex = $("#pageIndex").val();
		}
		disableChangeConfirm();
		$("#detailDivContact").empty();
		pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
		search(pageIndex);
		$("#top_allContact").show();		
	}	
	
	function searchContactList(pageIndex) {
    	if($.isEmpty(pageIndex)) {
			 pageIndex = $("#pageIndex").val();
		}
    	$.loadHtmlByUrl({
            url : "/idm/leprosy/contactList",
            wait : true,
            insertDiv :"contactsList",
            param : {
                singleId: singleIdTemp,
                pageIndex: pageIndex
            }
        });
    }

	 function changeType(radioName){
	        var raValue = $('input[name="' + radioName+ '"]:checked').val();
	        if(raValue == 1){
	            $("#closeDetail1").show();
	            $("#closeDetail2").hide();
	            $("#checkSympton").val('');

	        }else if(raValue == 2){
	            $("#closeDetail1").hide();
	            $("#closeDetail2").show();
	            $("#closeDetail").val('');
	        }
	    }
	 function initCcs(singleId, logoff) {
		 	singleIdTemp = singleId;
	        $("#top_allContact").hide();
	        var pageIndex = $("#currentPageContact").val();
	        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
	        $.loadHtmlByUrl({
	            url : "/idm/leprosy/initContact",
//                wait : true,
	            insertDiv :"detailDivContact",
	            param : {
	                singleId: singleId,
	                logoff: logoff,
	                pageIndex: pageIndex
	            }
	        });
	        $("#detailDivContact").show();
		};
		function addCc(){
	        var validate=null;
	        validate = $("#ccForm").easyValidate();
	        var result=validate.validateForm();
	        if(!result){
	            return;
	        }
	        $("#ccForm").submitFormGetJson({
	            url : "/idm/leprosy/contact/save",
                wait : true,
	            callback : function(data) {
	                if (data.indexOf("fail") > -1) {
	                	layer.alert("保存失败！", {icon:0,title:'提示'});
	                }else {
	                	layer.alert("保存成功！", {icon:0,title:'提示'});
	                    initCcs(singleIdTemp,'');
	                    return false;
	                }
	            }
	        });
	    }

	    function clickRow(selectRow){
	        var id = $(selectRow).attr("id");
	        $.loadHtmlByUrl({
	            url : "/idm/leprosy/contact/add",
//                wait : true,
	            insertDiv :"detailDiv",
	            param : {
	                id: id,
	                singleId: $("#singleIdContact").val()
	            }
	        });
	        $("#xinzeng").show();
	        $("#xiugai").show();

	        $("#shanchu").show();
	        $("#baocun").hide();
	    }
	    
	    function deleteCc(){
	    	var index = layer.confirm("确定删除该接触者？", {icon:2, title:'确认提示'}, function(){
	            var ccId = $("#ccId").val();
	            var singleId = $("#singleIdContact").val();
	            $("#ccForm").submitFormGetJson({
	                url : "/idm/leprosy/contact/delete",
                    wait : true,
	                param:{
	                    id:ccId
	                },
	                callback : function(data) {
	                    if (data.indexOf("fail") > -1) {
	                        layui.use('layer', function() {
	                        	var layer = layui.layer;
	                        	layer.alert("删除失败！", {icon:0,title:'提示'});
	                        });
	                    }else {
	                        layui.use('layer', function() {
	                        	var layer = layui.layer;
	                        	layer.alert("删除成功！", {icon:0,title:'提示'});
	                        });
	                        initCcs(singleId,'');
	                        return false;
	                    }
	                }
	            });
	            layer.close(index);
	        });
	    }

	    function updateCc(){
	        var validate=null;
	        validate = $("#ccForm").easyValidate();
	        var result=validate.validateForm();
	        if(!result){
	            return;
	        }
	        var singleId = $("#singleIdContact").val();
	        $("#ccForm").submitFormGetJson({
	            url : "/idm/leprosy/contact/update",
                wait : true,
	            callback : function(data) {
	                if (data.indexOf("fail") > -1) {
	                	layer.alert("修改失败！", {icon:0,title:'提示'});
	                }else {
	                	layer.alert("修改成功！", {icon:0,title:'提示'});
	                    initCcs(singleId,'');
	                    return false;
	                }
	            }
	        });
	    }

	    function initAddCc(){
	    	var singleId = $("#singleIdContact").val();
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
	        $("#xiugai").hide();
            $("#xinzeng").hide();
            $("#shanchu").hide();
	        $("#baocun").show();
	        $("#closeDetail1").hide();
	        $("#closeDetail2").hide();
	        $("#singleId").val(singleId);
	        toggleOther('positiveSigns','diagnosisResult','1');

	    }
	return {
        search: search,
        searchTemp: searchTemp,
        changeType:changeType,
        initCcs: initCcs,
        addCc: addCc,
        clickRow: clickRow,
        deleteCc: deleteCc,
        updateCc: updateCc,
        initAddCc: initAddCc,
        searchContactList: searchContactList
	};
})();
$(document).ready(function () { 
	//按钮样式切换 
	$("#contactBtnSearch").hover( 
		function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
		}, 
		function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
		} 
	); 

});
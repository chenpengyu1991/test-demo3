var malariaIndex = (function() {
    var validate=null;
    $(function() {
		// tab切换
		$("#tag1").on("click", function(event)
		{	
			selectTag("tagContent0", this);
			searchRegister();
		});
		$("#tag2").on("click", function(event)
		{
			selectTag("tagContent1", this);
		});
		$("#tag3").on("click", function(event)
		{
			selectTag("tagContent2", this);
			StandardIndex();
		});	
		
        $("#registerBtnSearch").click(function() {
        	searchRegister(1);
        });
        $("#registerBtnExport").click(function() {
        	exportRegister();
        });    
        $("#registerSearchForm").onEnter(searchRegister, 1);
        
        initIndex();
	});
	function searchRegister(index) {
		var pageIndex = $.isEmpty(index)?$('#tagContent0').find("#pageIndex").val():index;
        validate = $("#registerSearchForm").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
		var searchObj = {
			url : "/idm/malaria/register/list",
			insertDiv : 'registerResultDiv',
			param : {
				indexPage : pageIndex
			},
//            wait : true,
            callback : function(data) {
            	$('#tagContent0').find('#pageIndex').val(pageIndex);
            }
		};
		$("#registerSearchForm").submitFormLoadHtml(searchObj);
	};

	/*加载管理首页*/
	function StandardIndex() {
		//参数
		var loadHtmlByUrlOption = {
			url : "/idm/malaria/standard/index",
			param : null,
			checkRepeat : true,
			insertDiv : "tagContent2",
			errorDiv: "",
//            wait : true,
			okDiv:""
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	};
	function addRegister(type) {
		var pageIndex = $("#pageIndex").val();
		$("#register_top_all").hide();
		$.loadHtmlByUrl({
			url : "/idm/malaria/register/addRegister",
			insertDiv :"registerdetailDiv",
//            wait : true,
			param : {
				pageIndex:pageIndex,
				type:type}
		});
		$("#registerdetailDiv").show();		
	};	
	function editRegister(id,idmId,type) { 

		$("#register_top_all").hide();
        var pageIndex = $("#pageIndex").val();
		$.loadHtmlByUrl({
			url : '/idm/malaria/register/edit/'+ id  ,
			insertDiv :"registerdetailDiv",
//            wait : true,
            param : {
            	pageIndex:pageIndex,
				type:type,
				idmId:idmId}
		});
		$("#registerdetailDiv").show();
	};
	/*
	 * 一键通过
	 * */
	function distribution(){
		var ids ="";    
		var names = "";
		$('input[name="check"]:checked').each(function(){    
			ids += $(this).val() + ',';  
			names += $(this).nextAll('input').eq(0).val() + ',';
		});  
		ids = ids.substring(0, ids.lastIndexOf(','));
		names = names.substring(0, names.lastIndexOf(','));
		if(ids.length==0){
			layer.alert('请选择需要分配的患者！', {icon:0,title:'提示'});
			return false;
		}
		var dislogObj = {
				url : contextPath + "/idm/malaria/register/initDistribution",
				param : {ids:ids,names:names},
                height : 250,
                width : 700,				
				title : "血检分配",
                id :"disDialog"
			};
		$.dialog(dislogObj);	
	}
	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	};	
	function exportRegister(){
		location.href = contextPath + "/idm/malaria/downRegisterExcel?" + $('#registerSearchForm').formSerialize();
	}
	function initIndex(){
		var registerFlag = $('#registerFlagId').val();
		var manageFlag = $('#manageFlagId').val();
		if(!$.isEmpty(registerFlag)){
			searchRegister();
		}else if(!$.isEmpty(manageFlag)){
			$("#tag2").click();
		}
	}
	/**
	 * 根据人员注销状态，禁用表单
	 * logoff:0 正常，logoff:1 注销
	 */
	function diabaleForm(formId){
		var logoff = $('#' + formId).find('#logoff').val();
		if('1' == logoff){
			idmCommon.diabaleForm(formId);
		}
	}
	return {
		searchRegister:searchRegister,
		addRegister:addRegister,
		editRegister:editRegister,
		distribution:distribution,
		toggle:toggle,
		diabaleForm:diabaleForm
	};
})();
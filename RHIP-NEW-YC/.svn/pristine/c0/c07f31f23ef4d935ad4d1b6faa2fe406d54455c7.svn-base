var registerSearch = (function() {
	$(function() {
		// 高级查询条件显示控制
		$("#perAdvanceSearchConditionBtn").click(function(e) {
			e.preventDefault();
			controlAdvanceSearchSection($(this));
		});

        $("#check-submit-btn").on("click", function (e) {
            e.preventDefault();
        	StartRead();
        });
		registerSearch();
        $("#registerBtnSearch").click(function(e) {
        	e.preventDefault();
        	registerSearch(1);
        });	
        $("#registerBtnExport").click(function(e) {
        	e.preventDefault();
        	registerDown();
        });	 
        
        $("#registerSearchForm").onEnter(registerSearch, 1);
	});
    function StartRead()//开始读卡
    {
        if (GT2ICROCX.GetState() == 0){
            GT2ICROCX.ReadCard()
        }

        //GT2ICROCX.ReadCard() //循环读卡
        $("#idCard2").val(GT2ICROCX.CardNo);
    }
	/*监测登记画面查询*/
	function registerSearch(pageIndex) {
		var currentPage = $('#tagContent1').find("#pageIndex").val();
		if($.isEmpty(currentPage)){
			currentPage = 1;
    }
        pageIndex = ($.isEmpty(pageIndex)?currentPage:pageIndex);
        var searchObj = {
            url : "/idm/schistosome/register/list",
            insertDiv : 'registerResultDiv',
            param : {
				indexPage : pageIndex
			},
//			wait:true,
            callback : function(data) {
            	$('#tagContent1').find("#pageIndex").val(pageIndex);
            }
		};
		$("#registerSearchForm").submitFormLoadHtml(searchObj);
	};
    function search(){
        disableChangeConfirm();
        $("#registerdetailDiv").empty();
        registerSearch();
        $("#register_top_all").show();
    }
    /*
     * 新增画面：吸虫病监测登记
     * type,'add':新增，'view':查看
     * flag,'Local':本地居民，'Other':暂住人口
     * */
    function addRegister(type,flag){
		if(flag == 'Local'){
			$('#floatPopultationId').val(1);
		}else{
			$('#floatPopultationId').val(2);
		}
		$("#register_top_all").hide();
		$.loadHtmlByUrl({
			url : "/idm/schistosome/register/add",
			insertDiv :"registerdetailDiv",
			param : {
				type:type,
				flag:flag}
		});
		$("#registerdetailDiv").show();	   	
    }
	function editRegister(id,type) { 
		$("#register_top_all").hide();
		$.loadHtmlByUrl({
			url : '/idm/schistosome/register/edit',
			insertDiv :"registerdetailDiv",
            param : {
				type:type,
				singleId:id}
		});
		$("#registerdetailDiv").show();
	};	 
	function getTestOption(optionId){
		$.getJsonByUrl({
			 url : '/idm/schistosome/bloodOption/json',
			 checkRepeat:false,
			 wait:true,
			 callback:function(data){
				 //删除option
				 $("#bloodOptionId").find("option").remove();
				 if(data != "empty") {
					 $("#bloodOptionId").append(data);
				 } else {
					 $("#bloodOptionId").append("<option value=\"\">请选择</option>");
				 }
			 },
			 param:{optionId:optionId}
		});		
	}
    function registerDown(){
    	location.href = contextPath + "/idm/schistosome/downSchRegisterExcel?" + $('#registerSearchForm').formSerialize();
    }
	/*
	 * 一键通过
	 * */
	function batchApproval(){
		var ids ="";    
		var names = "";
		$('input[name="check"]:checked').each(function(){    
			ids += $(this).val() + ',';  
			names += $(this).nextAll('input').eq(0).val() + ',';
		});  
		ids = ids.substring(0, ids.lastIndexOf(','));
		names = names.substring(0, names.lastIndexOf(','));
		if(ids.length==0){
			layer.alert('请选择需要审核的患者！', {icon:0,title:'提示'});
			return false;
		}
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.confirm("以下人员将审核通过：" + names, {icon:1, title:'确认提示'}, function(index){
				$.getJsonByUrl({
					 url : '/idm/schistosome/register/batchApproval',
					 checkRepeat:false,
	//				 wait:true,
					 callback:function(data){
			                if (data.indexOf("fail") > -1) {
			                	layer.alert("一键通过失败！", {icon:0,title:'提示'});
			                }else {
			                	layer.alert("一键通过成功！", {icon:0,title:'提示'});
			                    search();
			                    return false;
			                }
					 },
					 param:{ids:ids}
				});	 
				layer.close(index);
			});
		});			
	}
	return {
		search:search,
		registerSearch:registerSearch,
		addRegister:addRegister,
		editRegister:editRegister,
		getTestOption:getTestOption,
		registerDown:registerDown,
		batchApproval:batchApproval
	};
})();
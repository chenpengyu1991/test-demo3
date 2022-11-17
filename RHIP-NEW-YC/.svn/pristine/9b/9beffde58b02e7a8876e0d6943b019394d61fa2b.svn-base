var advancedSearch = (function() {
	$(function() {
		// 高级查询条件显示控制
		$("#perAdvanceSearchConditionBtn2").click(function(e) {
			e.preventDefault();
			controlAdvanceSearchSection($(this));
		});

        $("#check-submit-btn2").on("click", function (e) {
            e.preventDefault();
        	StartRead();
        });
		advancedSearch();
        $("#advancedBtnSearch").click(function(e) {
        	e.preventDefault();
        	advancedSearch(1);
        }); 
        $("#advancedBtnExport").click(function(e) {
        	e.preventDefault();
        	advancedDown();
        });	 
        $("#historicalImport").click(function(e) {
       		e.preventDefault();
        	historicalImport();//历史数据导入
        });	         
        $("#advancedSearchForm").onEnter(advancedSearch, 1);
        init('currentUnit','R200,J100,A100,B100',[0]);//其他,市级医院,卫生院 【不能选择镇】

    });
    function StartRead()//开始读卡
    {
        if (GT2ICROCX.GetState() == 0){
            GT2ICROCX.ReadCard()
        }

        //GT2ICROCX.ReadCard() //循环读卡
        $("#idCard1").val(GT2ICROCX.CardNo);
    }
	/*晚血病人列表查询*/
	function advancedSearch(pageIndex) {
		var currentPage = $('#tagContent3').find("#pageIndex").val();
		if($.isEmpty(currentPage)){
			currentPage = 1;
		}
        pageIndex = ($.isEmpty(pageIndex)?currentPage:pageIndex);	
		var searchObj = {
			url : "/idm/schistosome/advanced/list",
			insertDiv : 'advancedResultDiv',
//			wait:true,
			param : {
				indexPage : pageIndex
			},
            callback : function(data) {
            	$('#tagContent3').find("#pageIndex").val(pageIndex);
            }
		};
		$("#advancedSearchForm").submitFormLoadHtml(searchObj);
	};
    function search(){
        disableChangeConfirm();
        $("#advanceddetailDiv").empty();
        advancedSearch();
        $("#advanced_top_all").show();
    }
    
    function returnSearch(){
		if (contentChanged)
		{
			 layui.use('layer', function() {
	    			var layer = layui.layer;
	    			var index = layer.confirm('确认离开?', {icon:1, title:'确认提示'}, function(){
	    				layer.close(index);
	    				search();
					});
	    			
	    		});
		}else{
			search();
		}
		
	
        /*if(contentChanged){
        	msgUtil.backConfirm(function(){
				search();
			});        	
        }else{
        	search();
        }    */	
    } 
    /**
     * logoff：注销状态
     */
	function initSurvey(idmId,logoff){
		$("#advanced_top_all").hide();
		$.loadHtmlByUrl({
			url : '/idm/schistosome/advanced/initSurvey',
			insertDiv :"advanceddetailDiv",
            param : {idmId:idmId,logoff:logoff}
		});
		$("#advanceddetailDiv").show();		
	}
	/**
	 * 添加/编辑管理卡
     * logoff：注销状态
	 */
	function editCard(idmId,logoff){
		$("#advanced_top_all").hide();
		$.loadHtmlByUrl({
			url : '/idm/schistosome/advanced/card/edit',
			insertDiv :"advanceddetailDiv",
            param : {idmId:idmId,logoff:logoff}
		});
		$("#advanceddetailDiv").show();		
	}
	/**
     * logoff：注销状态
	 */
	function initReexamine(idmId,logoff){
		$("#advanced_top_all").hide();

		$.loadHtmlByUrl({
			url : '/idm/schistosome/advanced/initReexamine',
			insertDiv :"advanceddetailDiv",
            param : {idmId:idmId,logoff:logoff}
		});
		$("#advanceddetailDiv").show();		
	}	
	
	/**
     * logoff：注销状态
	 */
	function initMedical(idmId,logoff){
		$("#advanced_top_all").hide();

		$.loadHtmlByUrl({
			url : '/idm/schistosome/advanced/initMedical',
			insertDiv :"advanceddetailDiv",
            param : {idmId:idmId,logoff:logoff}
		});
		$("#advanceddetailDiv").show();		
	}	
    function advancedDown(){
    	location.href = contextPath + "/idm/schistosome/advanced/downExcel?" + $('#advancedSearchForm').formSerialize();
    }	
    function historicalImport(){
		var dialogParams = {
				id : "d1",
				url : "/idm/schistosome/advanced/showHistoricalImport",
				param : {},
				height : 200,
				width : 750,
				title : "数据导入"
		};
		$.dialog(dialogParams);		    	
    }

    /**
     * 初始化机构控件
     * orgId:控件ID
     * orgType:机构类型
     * unSelectType:不能选择的机构类型
     */
    function init(orgId,orgType,unSelectType){
        //机构下拉树设置
        var option={
            url:"/mdmOrganization/organationTree",
            unSelecteType:unSelectType,  //下来树不能类型：0：镇，B1:中心，B2:站
            param:{organType:orgType}  //查询机构类型,逗号分割
        };
        //机构自动检索设置
        var opb = {
            url:"/mdmOrganization/organationSelect",
            feild: {
                value: "organCode",
                lable: "organName"
            },
            param:{organType:orgType}  //查询机构类型,逗号分割
        };

        var hospitalCode=$("#" + orgId);
        if(hospitalCode.length>0){
            //初始化自动检索
            hospitalCode.selectBox(opb);
            //初始化下拉树
            hospitalCode.initTreeSelect(option);
        }
    }

	return {
		advancedSearch:advancedSearch,
		search:search,
		returnSearch:returnSearch,
		initSurvey:initSurvey,
		editCard:editCard,
		initReexamine:initReexamine,
		initMedical:initMedical
	};
})();
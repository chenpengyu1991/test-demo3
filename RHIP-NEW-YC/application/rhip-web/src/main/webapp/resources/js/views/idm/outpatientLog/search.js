var logSearch = (function() {
	$(function() { 
            /*报卡查询*/
            $("#logBtnSearch").click(function() {
                search(1);
            });
            search(1);
            $("#logSearch").onEnter(search, 1);
            $("#btnResourceExport").on("click", function(event) {
    	    	$("#exportTable").exportExcel("门诊日志报表");
    	    });		
            $('#townOrgCode').on("change",function(){
            	getDeptOption($('#townOrgCode').val());
            });
            $('#centerOrgCode').on("change",function(){
            	getDeptOption($('#centerOrgCode').val());
            });
            $('#orgCode').on("change",function(){
            	getDeptOption($('#orgCode').val());
            });
            $('#clinicOrganCode').on("change",function(){
            	getDeptOption($('#clinicOrganCode').val());
            }); 
	});

	function search(indexPage) { 
		var searchObj = {
			url : "/idm/log/outpatient/list",
			insertDiv : "logResultDiv",
//			wait:true,
			param : {
				indexPage : indexPage
			}
		};
		$("#logSearchForm").submitFormLoadHtml(searchObj);
	};

  /*  function detail(id) {
        $("#top_all").hide();
        $.loadHtmlByUrl({
            url : '/idm/report/detail/'+ id  ,
            insertDiv :"detailDiv"
        });
        $("#detailDiv").show();
    };*/

	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	};
	
	function getDeptOption(organCode){
		var option = {
			url : "/idm/inspection/getDeptList",
			param : {
				organCode : organCode
			},
			callback : (function(list){
				var select = $("#medicalRoomCode");
				select.empty();
				var html = '<option value ="">请选择</option>';
				for(var i in list){
					html += '<option value="' + list[i].deptCode + '">' + list[i].deptName + '</option>';
				}
				select.append(html);	
			})
		};
		$.getJsonByUrl(option);
	}	
	
	/**
     * 初始化机构控件
     * orgId:控件ID
     * orgType:机构类型
     * unSelectType:不能选择的机构类型
     *//*
    function init(orgId,orgType,unSelectType){
        //机构下拉树设置
        var option={
            url:"/mdmOrganization/organationTree",
            unSelecteType:unSelectType,  //下来树不能类型：0：镇，B1:中心，B2:站
            param:{organType:orgType},  //查询机构类型,逗号分割
            selectFun:selectTreeFun
        };
        //机构自动检索设置
        var opb = {
            url:"/mdmOrganization/organationSelect",
            feild: {
                value: "organCode",
                lable: "organName"
            },
            param:{organType:orgType},  //查询机构类型,逗号分割
            selectFun:selectBoxFun
        };

        var hospitalCode=$("#" + orgId);
        if(hospitalCode.length>0){
            //初始化自动检索
            hospitalCode.selectBox(opb);
            //初始化下拉树
            hospitalCode.initTreeSelect(option);
        }
    }
    
    *//**
     * 机构下拉树回调
     * 设置当前选择机构的类型
     *//*
    function selectTreeFun(data){
        $('#selectCodeType').val(data.type);
    }
    *//**
     * 机构自动检索回调
     * 设置当前选择机构的类型
     *//*
    function selectBoxFun(data){
        $('#selectCodeType').val(data.attr('genreCode'));
    }*/

	return {
        search : search,
       /* detail:detail,*/
        toggle:toggle
	};
})();

$(document).ready(function () { 
	//按钮样式切换 
	$("#logBtnSearch").hover( 
		function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
		}, 
		function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
		} 
	); 
});

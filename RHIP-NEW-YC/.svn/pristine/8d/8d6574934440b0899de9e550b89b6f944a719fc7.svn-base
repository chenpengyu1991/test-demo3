var villagetransferLogSearch = (function() {
	$(function() {
		$("#transferOperationLogQuery").click(function() {
			recordsPerform(1);
		});
		$("#form_search").onEnter(function() {
			recordsPerform(1);
		});
		
		 //多选初始化
        $("select[multiple]").each(function () {
            $(this).multiselect({
                header: false,
                noneSelectedText: '请选择患病类型',
                selectedList: 13
            });
        });
        
        init();
	});
	
	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	};

	function recordsPerform(indexPage) {
		var beginTime = new Date($("#beginTime").val());
		var endTime = new Date($("#endTime").val());
		var moduleName = $("#moduleName").val();

		if (moduleName == "" ) {
			layer.alert("请选择模块！", {icon:0,title:'提示'});
            return;
		}
		
		if (beginTime > endTime) {
			layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
		} else {
			var searchObj = {
				url : "/transfer/log/villagelist",
				insertDiv : "transferOperationLogList",
				param : {
					indexPage : indexPage
				}
			};
			$("#form_search").submitFormLoadHtml(searchObj);
		}
	}
	
	//根据模块改变排版   
    function changeModule(){
    	var value = $("#moduleName").val();
    	if(value == "家庭档案"||value == "个人档案"||value == "老年人健康管理"){
    		$("div[id ^= activity]").hide();
    		$("div[id ^= person]").show();
    		$("div[id ^= illness]").hide();
    	}
    	if(value == "慢病报卡"||value == "慢病管理卡"){
    		$("div[id ^= activity]").hide();
    		$("div[id ^= person]").show();
    		$("div[id ^= illness]").show();
    	}
    	if(value == "健康教育活动"){
    		$("div[id ^= person]").hide();
    		$("div[id ^= activity]").show();
    		$("div[id ^= illness]").hide();
    	}
    }

    
    
    function init(){
     
        //机构下拉树设置
        var option={
            url:"/mdmOrganization/organationTree",
            unSelecteType:['0','B1']  //不能选择：0是镇，B1是中心
        };
        //机构自动检索设置
        var opb = {
            url:"/mdmOrganization/organationSelect",
            feild: {
                value: "organCode",
                lable: "organName"
            },
            param:{organType:"B2"}  //只查询B1（即所有站）
        };
        
        //村委会自动检索设置
        var opa= {
            url:"/transfer/villageSelect",
            feild: {
                value: "itemCode",
                lable: "itemName"
            }
        };

        var moveOutVillage=$("#moveOutVillage");
        if(moveOutVillage.length>0){
            //初始化自动检索
        	moveOutVillage.selectBox(opa);
            //初始化下拉树
            //moveOutOrgan.initTreeSelect(option);
        }
        var moveInOrgan=$("#moveInOrgan");
        if(moveInOrgan.length>0){
            //初始化自动检索
            moveInOrgan.selectBox(opb);
            //初始化下拉树
            moveInOrgan.initTreeSelect(option);
        }
    }
	
	
	return {
		search : recordsPerform,
		changeModule : changeModule 
	};
})();
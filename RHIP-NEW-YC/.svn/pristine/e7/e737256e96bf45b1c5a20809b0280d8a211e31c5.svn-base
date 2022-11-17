var patientMoveSearch = (function() {

	$(function() { 	
        $("#patientMoveBtnSearch").click(function(e) {
        	e.preventDefault();
        	searchPatientMove(1);
        });	
        $("#patientMoveSearchForm").onEnter(searchPatientMove, 1);
        searchPatientMove(1);

        init();

    });

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

        var moveOutOrgan=$("#moveOutOrgan");
        if(moveOutOrgan.length>0){
            //初始化自动检索
            moveOutOrgan.selectBox(opb);
            //初始化下拉树
            moveOutOrgan.initTreeSelect(option);
        }
        var moveInOrgan=$("#moveInOrgan");
        if(moveInOrgan.length>0){
            //初始化自动检索
            moveInOrgan.selectBox(opb);
            //初始化下拉树
            moveInOrgan.initTreeSelect(option);
        }
    }

    /**
     * 查询列表
     * @param pageIndex
     */
	function searchPatientMove(pageIndex) {
        pageIndex = ($.isEmpty(pageIndex)?$("#pageIndex").val():pageIndex);
		var searchObj = {
			url : "/mhm/patient/move/list",
			insertDiv : 'patientMoveResultDiv',
			param : {
                pageIndex : pageIndex
			},
//			wait:true,
            callback : function(data) {
            	$("#pageIndex").val(pageIndex);
            }
		};
		$("#patientMoveSearchForm").submitFormLoadHtml(searchObj);
	};

    /**
     * 弹出迁入迁出画面
     * @param type
     */
    function popSransfer(type, temp){
        var id;
        var eventId;
        var flag;
        //从查询结果列表的行来
        if(!$.isEmpty(temp)){
            id = temp.substring(0,temp.indexOf("-"));
            eventId = temp.substring(temp.indexOf("-")+1,temp.indexOf(":"));
            flag = temp.substring(temp.indexOf(":")+1,temp.length);
        }
        //从查询条件上方按钮来
        else{
            $("#moveListId tr.listtrselect").each(function(){
                var tr = $(this);
                var tds = tr.find("td.hide");
                tds.each(function(){
                    var str = $(this).text();
                    id = str.substring(0,str.indexOf("-"));
                    eventId = str.substring(str.indexOf("-")+1,str.indexOf(":"));
                    flag = str.substring(str.indexOf(":")+1,str.length);
                });
            });
        }

        if($.isEmpty(eventId)){
        	layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.alert("请选择一条记录！ ", {icon:0,title:'提示'});
    		});
                return;
            }
            if(!$.isEmpty(flag) && (flag==1 || flag==5) && type==1){
            	layui.use('layer', function(){
        			var layer = layui.layer;
        			layer.alert("上次迁移流程未结束！不能迁出！", {icon:0,title:'提示'});
        		});
                return;
            }
            /*var transferDialog = {
                url : "/mhm/patient/move/popupTransfer",
                height : 595,
                width : 800,
                title : (2 == type?"迁入迁出":"迁出"),
                id :"transferDialog",
                param:{type:type,id:id,eventId:eventId}
            };
            $.dialog(transferDialog);*/
            
            $.post(contextPath+'/mhm/patient/move/popupTransfer',
            		{ type:type,id:id,eventId:eventId
    			     }, 
    			function(ret){
            	layui.use(['layer'], function() {
            		  var layer = layui.layer
            		  layer.open({
            			  type: 1,
            			  id:'transferDialog',
            			  area: ['800px', '595px'],
            			  title:(2 == type?"迁入迁出":"迁出"),
            			  content: ret
            		  });
            		});
            	});
    }

    function rowClick(logoff){
        if("1" == logoff){
            $("#outButtonDiv").hide();
        }else{
            $("#outButtonDiv").show();
        }
    }

	return {
		searchPatientMove:searchPatientMove,
        popSransfer:popSransfer,
        rowClick:rowClick
	};
})();
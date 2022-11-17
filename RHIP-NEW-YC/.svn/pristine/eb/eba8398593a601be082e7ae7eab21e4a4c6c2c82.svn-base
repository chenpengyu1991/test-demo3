define(function() {
	function load() {
		$(function(){

	        $("#form_search #groupClassification").multiselect({
	            header : false,
	            noneSelectedText : '请选择',
	            selectedList : 4,
	            minWidth : "auto"
	        });

	        personSearch(1);
	        
	     // 高级查询条件显示控制
			 $("#perAdvanceSearchConditionBtn").click(function(e) {
		            e.preventDefault();
		            controlAdvanceSearchSection($(this));
		        });
			

	        tables.init();
	        $("#personAdd").click(function() {
	            var personAdd = {
	                url : contextPath + "/personRecord/addPersonRecordIni",
	                height : 650,
	                width : 900,
	                param : {
	                    indexPage : 1
	                },
	                title : "创建健康档案",
	                close : refresh
	            };
	            $.dialog(personAdd);
	        });
	        $("#per_search_btn").click(function(e){
	        	e.preventDefault();
	            personSearch(1);
	        } );

	        $("#personApprove").click(
	            function() {
	                var selectedTr = tables.getSelectedTr();
	                if (selectedTr.length > 0) {
	                    var personId = selectedTr.find("td .selected_value:first").val();
	                    var filingFlag = selectedTr.find("td .selected_value_off:first").val();
	                    if(filingFlag == 9)
	                    {
	                    	layer.alert("该人员档案已注销,不能审核！", {icon:0,title:'提示'});
	                        return;
	                    }
	                    if (personId) {
	                        $("#personId").val(personId);
	                        var statusVal=$("#status"+personId).val();
	                        if (statusVal!=2) {
	                        	layer.alert("此档案未注销审核，请重新选择！", {icon:0,title:'提示'});
	                            return false;
	                        }
	                        var offDialog = {
	                            id:"offDialog",
	                            url : contextPath + "/personRecord/offPersonRecord",
	                            height : 410,
	                            width : 550,
	                            param : {
	                                personId : personId,
	                                status:statusVal
	                            },
	                            title : "审核个人档案"
	                        };
	                        $.dialog(offDialog);
	                    }
	                } else {
	                	layer.alert("请选中一行！", {icon:0,title:'提示'});
	                }
	            });

	        // 健康档案浏览器
	        $("#list_datagrid").on("click", ".person-link-btn", function(event) {
	            // alert(this);
	            event.preventDefault();
	            var $this = $(this);
	           /* var dialogObj = {
	                url : $this.attr("href"),
	                height : 654,
	                width : 1000,
					id:'regionRecord'
	            };
	            $.dialog(dialogObj);*/
//	            return false;
	            /*$.post($this.attr("href"), function(ret){
	            	layui.use(['layer'], function() {
	            		  var layer = layui.layer
	            		  layer.open({
	            			  type: 1,
	            			  id:'indexEhr',
	            			  area: ['1100px', '696px'],
	            			  title:'健康档案',
	            			  content: ret
	            		  });
	            		});
	            	});*/
	            
	            $("#top_all").hide();
				$("#list_datagrid").hide();
				$.loadHtmlByUrl({
					url : $this.attr("href"),
					insertDiv :"detailDiv",
					param : {region:1},
		            wait : true
		        });
				$("#detailDiv").show();
	        });

	        $("#list_datagrid").on("click", ".readRecord", function(){
	            var selectedTr = tables.getSelectedTr();
	            var personId = selectedTr.find("td .selected_value:first").val();
	            /*var readRecord = {
	                url : contextPath + "/personRecord/readRecord",
	                height : 400,
	                width : 900,
	                param : {
	                    recordPersonId : personId,
	                },
	                title : "调阅记录"
	            };*/
//	            $.dialog(readRecord);
	            
	            $.post(contextPath+'/personRecord/readRecord', {recordPersonId:personId}, function(ret){
	            	layui.use(['layer'], function() {
	            		  var layer = layui.layer
	            		  layer.open({
	            			  type: 1,
	            			  id:'readRecord',
	            			  area: ['900px', '400px'],
	            			  title:'调阅记录',
	            			  content: ret
	            		  });
	            		});
	            	});
	            
	        });

	        //
	        $("#list_datagrid").on("click", ".basicIndex", function(event) {
	            event.preventDefault();
	            var $this = $(this);
	            var personId=$this.data("personId");
	            if(personId){
	                /*var dialogObj = {
	                    url : "/ehrbrowser/basic/basicIndex",
	                    height : 610,
	                    width : 800,
	                    param:{
	                        personId:personId
	                    },
	                    title : "档案查看"
	                };
	                $.dialog(dialogObj);*/
	            	
	            	/*$.post(contextPath+'/ehrbrowser/basic/basicIndex', {personId:personId}, function(ret){
		            	layui.use(['layer'], function() {
		            		  var layer = layui.layer
		            		  layer.open({
		            			  type: 1,
		            			  id:'basicEhr',
		            			  area: ['850px', '620px'],
		            			  title:'档案查看',
		            			  content: ret
		            		  });
		            		});
		            	});*/
	            	
	            	$("#top_all").hide();
	 				$("#list_datagrid").hide();
	 				$.loadHtmlByUrl({
	 					url : '/ehrbrowser/basic/basicIndex',
	 					insertDiv :"detailDiv",
	 					param : {personId:personId,
	 						     region:1
	 						     },
	 		            wait : true
	 		        });
	 				$("#detailDiv").show();
	            }
	        });
	        $("#list_datagrid").on("click", ".viewModifyTrace", function() {
	            var selectedTr = tables.getSelectedTr();
	            var personId = selectedTr.find("td .selected_value:first").val();
	            if (personId != null)
	            {
	                var personId = selectedTr.find("td .selected_value:first").val();
	                var personName = selectedTr.find("td .person-link-btn:first").html();

	                /*if (personId)
	                {
	                    var viewModifyTrace = {
	                        url : contextPath + "/personRecord/showModifyTrace",
	                        height : 400,
	                        width : 900,
	                        param : {
	                            modifyPersonId : personId
	                        },
	                        title : personName + "的档案修改痕迹浏览"
	                    };
	                    $.dialog(viewModifyTrace);
	                }
	            } else
	            {
	                layer.alert("请选中一行！");
	            }*/
	            	$.post(contextPath+'/personRecord/showModifyTrace', {modifyPersonId : personId}, function(ret){
	            		layui.use(['layer'], function() {
	            			var layer = layui.layer
	            			layer.open({
	            				type: 1,
	            				id:'modifyTrace',
	            				area: ['1020px', '580px'],
	            				title:personName + "的档案修改痕迹浏览",
	            				content: ret
	            			});
	            		});
	            	});
	            } else {
	            	layui.use('layer', function(){
	        			var layer = layui.layer;
	        			layer.alert("请选中一行！", {icon:0,title:'提示'});
	        		});
				}
	        });
	        $("#list_datagrid").on("click", ".personOffActive", function() {
	            var selectedTr = tables.getSelectedTr();
	            var personId = selectedTr.find("td .selected_value:first").val();
	            if (personId != null)
	            {
	                var filingFlag = selectedTr.find("td .selected_value_off:first").val();
	                if (filingFlag == 9)
	                {
	                   /* layer.confirm("确认激活该档案？", function(index) {
	                        $.getJsonByUrl({
	                            url : contextPath + "/personRecord/personOffActive",
	                            param : {
	                                personId : personId,
	                                filingFlag : filingFlag
	                            },
	                            callback : function(data) {
	                                if (data == 1)
	                                {
	                                    layer.alert("激活成功！");
	                                    personRecordPagination.pagination(1);

	                                } else
	                                {
	                                    layer.alert("激活失败！");
	                                }
	                            }
	                        });
	                        layer.close(index);
	                    });*/
	                	
	                	layui.use('layer', function() {
	            			var layer = layui.layer;
	            			layer.confirm('确认激活该档案？', {icon:1, title:'确认提示'}, function(index) {
	            				$.getJsonByUrl({
		                            url : contextPath + "/personRecord/personOffActive",
		                            param : {
		                                personId : personId,
		                                filingFlag : filingFlag
		                            },
		                            callback : function(data) {
		                                if (data == 1)
		                                {
		                                	layer.alert("激活成功！", {icon:0,title:'提示'});
		                                    personRecordPagination.pagination(1);

		                                } else
		                                {
		                                	layer.alert("激活失败！", {icon:0,title:'提示'});
		                                }
		                            }
		                        });;
	            			});
	            		});
	                }
	            }
	        });

	        $("#list_datagrid").on("click", ".personModify", function() {
	            var selectedTr = tables.getSelectedTr();
	            var personId = selectedTr.find("td .selected_value:first").val();
	            if (personId != null)
	            {
	                var filingFlag = $(".selected_value_off").val();
	                if (filingFlag == 9)
	                {
	                	layer.alert("该人员已结案,不能修改！", {icon:0,title:'提示'});
	                    return;
	                }
	                if (filingFlag == 2)
	                {
	                	layer.alert("该人员正在审核中,不能修改！", {icon:0,title:'提示'});
	                    return;
	                }
	                if (personId)
	                {
	                    var personModify = {
	                        url : contextPath + "/personRecord/addPersonRecordIni",
	                        height : 660,
	                        width : 900,
	                        param : {
	                            indexPage : 1,
	                            personId : personId
	                        },
	                        title : "修改个人健康档案",
	                        close : refresh
	                    };
	                    $.dialog(personModify);
	                }
	            } else
	            {
	            	layer.alert("请选中一行！", {icon:0,title:'提示'});
	            }
	        });

	        $("#idCard").keyup(function(){
	            var idCardValue = $("#idCard").val();
	            $("#idCard").attr("value",idCardValue.toUpperCase());
	        });

	        // Enter查询
	        $("#form_search").onEnter(function(){
	            personSearch(1);
	        });
	        $("#ehr-person-region-export-btn").click(function() {
	            exportList();
	        });
	    });
	}
	

    var isSaved = false;
    var currentPage = 1;
    var SelectedAbleTable = function(contextId, tableId) {
        this.tableSe = "#" + tableId;
        this.contextSe = "#" + contextId;
    };

    SelectedAbleTable.prototype = {
        trSeletedClass : "listtrselect",
        trSeletedSe : " .listtrselect ",
        trSe : " tbody tr ",
        init : function() {
            $(this.contextSe).on(
                "click",
                this.tableSe + this.trSe,
                this,
                function(e) {
                    var outer = e.data;
                    $(outer.tableSe + outer.trSe).removeClass(
                        outer.trSeletedClass);
                    $(this).addClass(outer.trSeletedClass);
                });
        },
        getSelectedTr : function() {
            return $("table tr").filter(this.trSeletedSe);
        }
    };
    var tables = new SelectedAbleTable("list_datagrid", "person_record_table");


    function refresh() {
        if (isSaved)
        {
            personSearch(currentPage);
            isSaved = false;
        }
        var removeSessionOption = {
            url : "/personRecord/removeSession"
        };
        $.getJsonByUrl(removeSessionOption);
    }
    function personSearch(indexPage) {
        var ageBegin = parseInt($("#beginAge").val());
        var ageEnd = parseInt($("#endAge").val());

        var createBegin = new Date($("#createBeginDate").val());
        var createEnd = new Date($("#createEndDate").val());

        var updateBegin = new Date($("#updateBeginDate").val());
        var updateEnd = new Date($("#updateEndDate").val());



        var url = '/regionRecord/result';

        if(updateBegin > updateEnd){
            layer.alert("更新开始时间不能大于建档结束时间！", {icon:0,title:'提示'});
            return;
        }

        if (ageBegin > ageEnd && createBegin > createEnd) {
            layer.alert("开始年龄不能大于结束年龄\n建档开始时间不能大于建档结束时间！", {icon:0,title:'提示'});
            $("#beginAge").val("");
            $("#endAge").val("");
            $("#createBeginDate").val("");
            $("#createEndDate").val("");
        } else if (createBegin > createEnd) {
            layer.alert("建档开始时间不能大于建档结束时间！", {icon:0,title:'提示'});
            $("#createBeginDate").val("");
            $("#createEndDate").val("");
        } else if (ageBegin > ageEnd) {
            layer.alert("开始年龄不能大于结束年龄！", {icon:0,title:'提示'});
            $("#beginAge").val("");
            $("#endAge").val("");
        } else {
            $("#form_search").submitFormLoadHtml({
                url : url,
                insertDiv:"list_datagrid",
                param:{
                    organCode : $("#nowAddressCode").val(),
                    indexPage: indexPage
                }
            });
        }
    }

    $("#sys_mdm_btn").click(function(){
        $.getJsonByUrl({
            url : "/region/tongbuToMDM",
            callback:function(data){
                layer.alert(data, {icon:0,title:'提示'});
            }
        });
    } );

    function toggle(obj,tableId) {
        $(obj).toggleClass("ico-top");
        $(obj).toggleClass("ico-bottom");
        $("#" + tableId).toggle();
    };

    function exportList() {
        var option={
            url:"/regionRecord/export"
        };
        searchCheck(function() {
        	$("#form_search").exportListExcel(option);
        });
    }
    function searchCheck(callback) {

        var ageBegin = parseInt($("#beginAge").val());
        var ageEnd = parseInt($("#endAge").val());

        var createBegin = new Date($("#createBeginDate").val());
        var createEnd = new Date($("#createEndDate").val());

        var updateBegin = new Date($("#updateBeginDate").val());
        var updateEnd = new Date($("#updateEndDate").val());

        if (updateBegin > updateEnd)
        {
            layer.alert("更新开始时间不能大于建档结束时间！", {icon:0,title:'提示'});
            return;
        }

        if (ageBegin > ageEnd && createBegin > createEnd)
        {
            layer.alert("开始年龄不能大于结束年龄\n建档开始时间不能大于建档结束时间！", {icon:0,title:'提示'});
            $("#beginAge").val("");
            $("#endAge").val("");
            $("#createBeginDate").val("");
            $("#createEndDate").val("");
        } else if (createBegin > createEnd)
        {
            layer.alert("建档开始时间不能大于建档结束时间！", {icon:0,title:'提示'});
            $("#createBeginDate").val("");
            $("#createEndDate").val("");
        } else if (ageBegin > ageEnd)
        {
            layer.alert("开始年龄不能大于结束年龄！", {icon:0,title:'提示'});
            $("#beginAge").val("");
            $("#endAge").val("");
        } else
        {
            callback();
        }
    }

    return {
		load: load
	}
});
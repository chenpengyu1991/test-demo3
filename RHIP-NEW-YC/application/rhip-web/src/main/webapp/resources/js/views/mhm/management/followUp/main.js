var followUpMain = (function() {
	var validateMain=null;
	$(function() { 
        $("#return").click(function(e) {
			e.preventDefault();
			mhmCommon.returnSearch(managementSearch.search);
		});
		$("#sf_return").click(function(e) {
			e.preventDefault();
			layui.use('layer', function(){
				var layer = layui.layer;
				layer.confirm('确认离开？', {icon:1, title:'确认提示'}, function(){
					layer.closeAll();
					followupSearch.search(1);
				});
			});
		});
        $("#add").click(function(e) {
        	e.preventDefault();
        	add();
        });
        $("#update").click(function(e) {
        	e.preventDefault();
        	save();
        });
        $("#save").click(function(e) {
        	e.preventDefault();
        	save();
        }); 
        $("#delete").click(function(e) {
        	e.preventDefault();
        	deleteFollowUp();
        });  
        $("#pass").click(function(e) {
        	e.preventDefault();
        	approval('1');
        }); 
        $("#reject").click(function(e) {
        	e.preventDefault();
        	approval('2');
        });

		$("#button_print").click(function (e) {
            e.preventDefault();
            var reportClass = $("#followUpDiv").attr("class");
            $("#followUpDiv").removeClass();
            $("#followUpDiv").jqprint(
                {
                    debug: false, //如果是true则可以显示iframe查看效果（iframe默认高和宽都很小，可以再源码中调大），默认是false
                    importCSS: true, //true表示引进原来的页面的css，默认是true。（如果是true，先会找$("link[media=print]")，若没有会去找$("link")中的css文件）
                    printContainer: true, //表示如果原来选择的对象必须被纳入打印（注意：设置为false可能会打破你的CSS规则）。
                    operaSupport: true//表示如果插件也必须支持歌opera浏览器，在这种情况下，它提供了建立一个临时的打印选项卡。默认是true
                });
            $("#printDiv").addClass(reportClass);
        });

		var nextFollowUpFlag = $("#nextFollowUpFlag").val();
		if(!$.isEmpty(nextFollowUpFlag)){
			if(nextFollowUpFlag == '1'){
				layer.alert("有计划随访未填写，需尽快填写！", {icon:0,title:'提示'});
			}else if(nextFollowUpFlag == '2'){
				layer.alert("存在逾期随访未填写，需尽快填写！", {icon:0,title:'提示'});
			}

		}
		followUpList(1);
//		$('#followupDt').on("onDatePickerChanged",function(){
//			debugger;
//			var statusId = $("#followUpForm").find('#statusId').val();
//            validateFollowupDt(this.value,statusId);
//        });			
	});
	function approval(status){
		var followupId = $('#followupId').val();
        $("#followUpForm").submitFormGetJson({
            url : "/mhm/followUp/approval",
			param : {
				id : followupId,
				status:status
			},            
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                	layui.use('layer', function(){
            			var layer = layui.layer;
            			layer.alert("保存失败！", {icon:0,title:'提示'});
            		});
                    /*msgUtil.alert("审核失败！");*/
                }else {
                	layui.use('layer', function(){
            			var layer = layui.layer;
            			layer.alert("审核成功！", {icon:0,title:'提示'}, function(index) {
							layer.close(index);	
            				followUpList();
            			});
            		});
                    /*msgUtil.alert("审核成功！");*/
                    return false;
                }
            },
            wait:true
        });  		
	}
	/*
	 * 随访记录列表查询
	 */
	function followUpList(pageIndex) {
        pageIndex = ($.isEmpty(pageIndex)?$('#followUpPageIndex').val():pageIndex);
        var statusId = $('#statusId').val();
		var searchObj = {
			url : "/mhm/followUp/list",
			insertDiv : 'followUpListDiv',
			param : {
				pageIndex : pageIndex,
				statusId:statusId
			},
//			wait:true,
            callback : function(data) {
            	$("#followUpPageIndex").val(pageIndex);
				var length = $('#followUpDiv').has('form').length;
				var eventId = $('#followUpList tr').eq(1).find('#eventTrId').val();
	            add(eventId);
	            $('#followUpList tr').eq(1).addClass('listtrselect');
            }
		};
		$("#followUpListForm").submitFormLoadHtml(searchObj);
	};

	/*
	 * 添加或修改
	 * */
	function add(eventId){
        // if(contentChanged){
        // 	msgUtil.backConfirm(function(){
        // 		addFollowUp(eventId);
		// 	});
        // }else{
        	addFollowUp(eventId);
        // }
	}
    /*
     * 加载随访记录编辑画面
     * */
    function addFollowUp(eventId){
    	disableChangeConfirm();
    	var statusId = $('#statusId').val();
		var pageIndex = $("#followUpPageIndex").val();
		$.loadHtmlByUrl({
			url : "/mhm/followUp/edit",
			insertDiv :"followUpDiv",
			param : {
				statusId:statusId,eventId:eventId
			},
//			wait:true,
			callback : function(data) {
	                mhmCommon.changeBtnStatus($.isEmpty(eventId)?'add':'edit');
	            }
		});
		$("#followUpDiv").show();
    };

    /*
     * 保存随访记录
     * */
    function save(){
    	validateMain = $("#followUpForm").easyValidate();
    	beforSubmit();
        var result=validateMain.validateForm();
        if(!result){
            return;
        }
        var eventId = $('#eventId').val();
        var frTableData = util.Obj2str(mhmCommon.getTablesData('frMedicationTable', [], [], eventId));
    	$("#followupMedication").val(frTableData);
        $("#followUpForm").submitFormGetJson({
            url : "/mhm/followUp/save",
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                	layui.use('layer', function(){
            			var layer = layui.layer;
            			layer.alert("保存失败！", {icon:0,title:'提示'});
            		});
                    /*msgUtil.alert("保存失败！");*/
                }else {
                	layui.use('layer', function(){
            			var layer = layui.layer;
            			layer.alert("保存成功！", {icon:0,title:'提示'}, function() {
            				layer.closeAll();
            				disableChangeConfirm();
                            followUpList();
            			});
            		});
                    /*msgUtil.alert("保存成功！");
                    disableChangeConfirm();
                    followUpList();*/
                    return false;
                }
            },
            wait:true
        });    	
    }
    
    /*
     * 删除随访记录
     * */
    function deleteFollowUp(){
    	var eventId = $('#followUpForm').find("#eventId").val();
    	layui.use('layer', function(){
    		var layer = layui.layer;
    		layer.confirm("删除随访记录", {icon:2, title:'确认提示'}, function(index){
		        $("#followUpForm").submitFormGetJson({
		            url : "/mhm/followUp/delete",
		            param : {eventId:eventId},
		            wait:true,
		            callback : function(data) {
		                if (data.indexOf("fail") > -1) {
		            		layer.alert("删除失败！", {icon:0,title:'提示'});
		                    /*msgUtil.alert("删除失败！");*/
		                }else {
	            			layer.alert("删除成功！", {icon:0,title:'提示'}, function(index2) {
	            				followUpList();
	            				layer.close(index2);
	            			});
		                    /*msgUtil.alert("删除成功！");
		                    followUpList();*/
		                    return false;
		                }
		            }
		        });  
		        layer.close(index);
	    	});
	    });		
    }
    
    /*
     * 随访信息和失访信息中有相同的字段，提交时根据随访方式取其中一个
     * */
    function beforSubmit(){
    	var followupType = $('input[name="mhmFollowup.type"]:visible:checked').val();
    	if(followupType == '2'){
    		$('#hLockState').val($('#lockStateLost').val());
    		$('#hHospitalCourse').val($('#hospitalCourseLost').val());
    		$('#hLastleaveHospitalDate').val($('#lastleaveHospitalDateLost').val());
    		$('#hEconomicGrantDept').val($('#economicGrantDeptLost').val());
    	}else{
    		$('#hLockState').val($('#lockState').val());
    		$('#hHospitalCourse').val($('#hospitalCourse').val());
    		$('#hLastleaveHospitalDate').val($('#lastleaveHospitalDate').val());
    		$('#hEconomicGrantDept').val($('#economicGrantDept').val());    		
    	}
    	var followupDt = $('#followUpForm').find('#followupDt').val();
    	var statusId = $('#followUpForm').find('#statusId').val();
    	validateFollowupDt(followupDt,statusId);
    	
    }
	/**
	 * 验证随访日期
	 * 必须在建档日期之后
	 */
	function validateFollowupDt(followupDt,statusId){
		if (!$.isEmpty(followupDt)){
            $.getJsonByUrl({
                url : "/mhm/followUp/validateFollowupDt",
                wait : true,
                async : false,
                callback : function(data) {
					if(data.indexOf("success") > -1) {
                		validateMain.removeError('mhmFollowup.followupDt');
            			validateMain.removeCheckElement('mhmFollowup.followupDt');
                	}else if (data.indexOf("fail") > -1) {
                   		validateMain.addError('mhmFollowup.followupDt',"无法获取建档日期");
			        	validateMain.addCheckElement('mhmFollowup.followupDt',{"compare":["followupDtFlag","le","无法获取建档日期 "]});
                	}else if (!$.isEmpty(data)) {
                   		validateMain.addError('mhmFollowup.followupDt',"随访日期必须在建档日期之后,建档日期：" + data);
			        	validateMain.addCheckElement('mhmFollowup.followupDt',{"compare":["followupDtFlag","le","随访日期必须在建档日期之后,建档日期：" + data]});
                	}
                },
                param:{statusId:statusId,followupDt:followupDt}
            });
		}
	}    
 	return {
 		followUpList:followUpList,
 		add:add,
		save:save,
		deleteFollowUp:deleteFollowUp
	};
})();
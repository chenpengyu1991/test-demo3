var caseSearch = (function() {
	$(function () {
		// 高级查询条件显示控制
		$("#perAdvanceSearchConditionBtn").click(function(e) {
			e.preventDefault();
			controlAdvanceSearchSection($(this));
		});

        $("#check-submit-btn").on("click", function (e) {
            e.preventDefault();
        	StartRead();
        });

        $("#caseSearchId").click(function(e) {
			e.preventDefault();
        	search(1);
		});
        search(1);
		$("#reportSearchForm").onEnter(search, 1);
		$('#reportStatus').change(function () {
			reportStatusChange();
		});
		queryInfection();
		$("#reportBtnSearch").hover( 
			function () { 
			$(this).removeClass("search_btn").addClass("search_btn_h"); 
			}, 
			function () { 
			$(this).removeClass("search_btn_h").addClass("search_btn"); 
			} 
		); 
		$("#btnExport").click(function() {
			var params = $('#reportSearchForm').serializeObject();
/*			var dialogParams = {
				id : "d1",
				url : "/idm/case/exportIndex",
				height : 300,
				width : 500,
				title : "导出",
				param : params
			};
			$.dialog(dialogParams);*/
			$.post(contextPath+'/idm/case/exportIndex',
				params,
				function(ret){
					layui.use(['layer'], function() {
						var layer = layui.layer
						layer.open({
							type: 1,
							id:'d1',
							area: ['500px', '300px'],
							title:'导出',
							content: ret
						});
					});
				});
		});
	});

    function StartRead()//开始读卡
    {
        if (GT2ICROCX.GetState() == 0){
            GT2ICROCX.ReadCard()
        }

        //GT2ICROCX.ReadCard() //循环读卡
        $("#idCard").val(GT2ICROCX.CardNo);
    }
    // 组合39种疾病的下拉内容
    function queryInfection() {
        $("#infectiousCode").append('<option value="">' + "请选择" + '</option>');

        $.getJsonByUrl({
            url : "/idm/set/queryCaseInfection",
//            wait:true,
            callback : function(data) {
                $.each(data,function(key,values){
                    $("#infectiousCode").append('<option value="'+ key +'">' + values + '</option>');
                });
            }
        });
    };

	function search(indexPage) {
		var validate = $("#reportSearchForm").easyValidate();
        var result=validate.validateForm();
    	if(!result){
    		return;
    	}
        if($.isEmpty(indexPage)){
            indexPage = $("#pageIndexI").val();
        }
        
        var tab = $("#tab").val();
		var searchObj = {
			url : "/idm/case/caseList/"+tab,
			insertDiv : "caseResultDiv",
//			wait:true,
			param : {
				indexPage : indexPage
//              tab : tab
			}/*,
			callback: function() {
				为listDiv中a的添加click事件
				initLinkClick('caseAddId',caseIndex, {id:"data-id",idmId:"data-idmid",infectiousCode:"data-infectiouscode",name:"data-name",type:"data-type",logoff:"data-logoff"});
				initLinkClick('caseModifyId',caseIndex, {id:"data-id",idmId:"data-idmid",infectiousCode:"data-infectiouscode",name:"data-name",type:"data-type",logoff:"data-logoff"});
			}*/
		};
        $("#detailDiv").hide();
        $("#top_all").show();
		$("#reportSearchForm").submitFormLoadHtml(searchObj);
	};

	function add() { 
		var pageIndex = $("#currentPage").val();
		$("#top_all").hide();
		$.loadHtmlByUrl({
			url : "/idm/report/add",
			insertDiv :"detailDiv",
			param : {pageIndex:pageIndex},
            wait : true
		});
		$("#detailDiv").show();
		
	};
	function edit(id) { 
		$("#top_all").hide();
        var pageIndex = $("#currentPage").val();
		$.loadHtmlByUrl({
			url : '/idm/report/edit/'+ id  ,
			insertDiv :"detailDiv",
            param : {pageIndex:pageIndex},
            wait : true
        });
		$("#detailDiv").show();
	};

    function caseIndex(id,idmId,infectiousCode,name,type,logoff){
        $("#top_all").hide();
        var pageIndex = $("#currentPage").val();
        $.loadHtmlByUrl({
            url : "/idm/case/caseIndex",
            insertDiv :"detailDiv",
            param : {
            	id:id,
				idmId:idmId,
				infectiousCode:infectiousCode,
				pageIndex:pageIndex,
				name:name,
				type:type,
				logoff:logoff}
        });
        $("#detailDiv").show();

    };

	/*个案填写*/
	function caseAdd(id,idmId,infectiousCode, logoff) {
		$("#top_all").hide();
        var pageIndex = $("#currentPage").val();
		$.loadHtmlByUrl({
			url : "/idm/case/initAdd",
			insertDiv :"caseDetailDiv",
			param : {id:id, idmId:idmId, infectiousCode:infectiousCode, pageIndex:pageIndex, logoff: logoff}
        });
		$("#caseDetailDiv").show();
		
	};
	/*个案编辑*/
	function caseEdit(idmId,infectiousCode, logoff) {
		$("#top_all").hide();
        var pageIndex = $("#currentPage").val();
		$.loadHtmlByUrl({
			url : "/idm/case/initEdit",
			insertDiv :"caseDetailDiv",
			param : {idmId : idmId, infectiousCode:infectiousCode, pageIndex:pageIndex, logoff:logoff},
            wait : true
        });
		$("#caseDetailDiv").show();
	};
	/*个案查看*/
	function caseView(idmId,infectiousCode, logoff) {
		$("#top_all").hide();
        var pageIndex = $("#currentPage").val();
		$.loadHtmlByUrl({
			url : "/idm/case/initView",
			insertDiv :"caseDetailDiv",
			param : {idmId : idmId, infectiousCode:infectiousCode, pageIndex:pageIndex, logoff:logoff},
            wait : true
        });
		$("#caseDetailDiv").show();
	};
	
	function print(id) { 
		$("#top_all").hide();
		$.loadHtmlByUrl({
			url : '/idm/report/print/'+ id  ,
			insertDiv :"detailDiv"
		});
		$("#detailDiv").show();
	};
	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	};
	/*
	 * 如果报卡状态为未审核
	 * 禁止选择个案状态
	 * */
	function reportStatusChange(){
		var reportStatus = $('#reportStatus').val();
		if(reportStatus == '1'){
			$('#caseStatus').val('');
			$('#caseStatus').attr("disabled","disabled");
		}else{
			$('#caseStatus').removeAttr('disabled');
		}
	}
	
	/*个案手动分配*/
	function assign(id) {
		 var pageIndex = $("#currentPage").val();
		$.post(contextPath+'/idm/case/assign',
			{
				pageIndex :pageIndex,
				id : id
			},
			function(ret){
				layui.use(['layer'], function() {
					var layer = layui.layer
					layer.open({
						type: 1,
						id:'assignDiv',
						area: ['600px', '300px'],
						title:"个案分配",
						content: ret
					});
				});
			});
	}
	
	$("#save").click(function() {
		var id = $("#id").val();
		var validate = $("#assignForm").easyValidate();

		if (validate.validateForm()) {

			$("#assignForm").submitFormGetJson({
				url : "/idm/case/saveAssign",
				param : {
					id : id,
					type : '0'
				},
				callback : submitCallback
			});
		}
	});
	
	function submitCallback(data) {
		var pageIndex = $("#currentPage").val();
		if (data.result) {
			debugger;
			layer.alert(data.message, {icon:0,title:'提示'}, function(index) {
				$.removeDialog("assignDiv");
				caseSearch.search(pageIndex);
				layer.close(index);
			});
		} else {
			layer.alert(data.message, {icon:0,title:'提示'});
		}
	}
	
	function confirm(id) {
		var index = layer.confirm("确定要纳入管理吗？", {icon:1, title:'确认提示'}, function(){
			 $.getJsonByUrl({
		            url : "/idm/case/saveAssign",
		            param : {
						id : id,
						type : '1'
					},
		            callback : confirmCallback,
		            wait:true
		        });
			 layer.close(index);
		});
	}
	 
	function confirmCallback(data) {
		var pageIndex = $("#currentPage").val();
		layer.alert(data.message, {icon:0,title:'提示'});
		if (data.result) {
			search(pageIndex);
		}
	}
	
	

	
	return {
        search : search,
        add:add,
        caseAdd:caseAdd,
        caseEdit:caseEdit,
        caseView:caseView,
        print:print,
        edit:edit,
        toggle:toggle,
        caseIndex:caseIndex,
        assign:assign,
        confirm:confirm
	};
})();

/*$(document).ready(function () { 
	//按钮样式切换 
	$("#reportBtnSearch").hover( 
		function () { 
		$(this).removeClass("search_btn").addClass("search_btn_h"); 
		}, 
		function () { 
		$(this).removeClass("search_btn_h").addClass("search_btn"); 
		} 
	); 

});*/

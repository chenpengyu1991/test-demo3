var repeatSearch = (function() {
	$(function () {
		$("#caseSearchId").click(function() {
			search(1);
		});
        $("#check-submit-btn").on("click", function () {
            StartRead();
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
        if($.isEmpty(indexPage)){
            indexPage = $("#pageIndexI").val();
        }
        var tab = $("#tab").val();
		var searchObj = {
			url : "/idm/case/repeatList",
			insertDiv : "caseResultDiv",
//			wait:true,
			param : {
				indexPage : indexPage
//                tab : tab
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

	
    function caseIndex(id,idmId,infectiousCode,name,type,logoff,repeat){
        $("#top_all").hide();
        var pageIndex = $("#currentPage").val();
        $.loadHtmlByUrl({
            url : "/idm/case/caseIndex",
            insertDiv :"detailDiv",
            param : {id:id, idmId:idmId, infectiousCode:infectiousCode, pageIndex:pageIndex,name:name,type:type,logoff:logoff,repeat:repeat}
        });
        $("#detailDiv").show();

    };

    /*个案查看*/
	function caseView(idmId,infectiousCode, logoff) {
		$("#top_all").hide();
        var pageIndex = $("#currentPage").val();
		$.loadHtmlByUrl({
			url : "/idm/case/initView",
			insertDiv :"caseDetailDiv",
			param : {idmId : idmId, infectiousCode:infectiousCode, pageIndex:pageIndex, logoff:logoff,repeat:1},
            wait : true
        });
		$("#caseDetailDiv").show();
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
	
	function invalid(idmId){
		var index = layer.confirm("确定要作废吗？", {icon:2, title:'确认提示'}, function(){
			$.getJsonByUrl({
				url : "/idm/case/invalid",
				param :{idmId : idmId},
				callback : function(data){
					layer.alert(data.message, {icon:0,title:'提示'});
					if (data.result) {
						search(1);
					}
				},
				wait : true
			})
			layer.close(index);
		});
	}
	
	

	return {
        search : search,
        caseView:caseView,
        toggle:toggle,
        caseIndex : caseIndex,
	    invalid : invalid
	};
})();

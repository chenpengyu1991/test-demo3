var cdmManagePlanlist =(function()
{
	$(function() { 
		 search(1);
	 //添加回车监听事件
	 $('form').keypress(function (e) {
	     var key = e.which;
	     if (key == 13) {
	    	 search(1);
	     }
	 });
	 /*代建保健计划查询*/
	    $("#per_search_btn").click(function() {
	        search(1);
	    });
	    //身份证查询X大小写转换
	    $("#idCard").keyup(function(){
        	var idCardValue = $("#idCard").val();
        	$("#idCard").attr("value",idCardValue.toUpperCase());
      });
	  //点击超链接查看保健计划详细信息
		 $("#planInfo").on("click", ".plan-link",function(event){
				event.preventDefault();
				var loadHtmlByUrlOption = {
						url : "/cdm/standardization/healthPlan/"+$(this).data("personid"),
						insertDiv : "cdm-manage-input-box"
				};
				$. loadHtmlByUrl(loadHtmlByUrlOption);
				$("#cdm-manage-list-box").hide();
				$("#cdm-manage-input-box").show();
			});
		 
		 //点击超链接查看管理卡详细信息
		 $("#planInfo").on("click", ".report-link",function(event){
				event.preventDefault();
				$("#cdm-manage-list-box").hide();
				$("#cdm-manage-input-box").show();
				var loadHtmlByUrlOption = {
					url : "/cdm/standardization/view/"+$(this).data("personid"),
					insertDiv : "cdm-manage-input-box"
				};
				$.loadHtmlByUrl(loadHtmlByUrlOption);
			});
		 $("#check-submit-btn").on("click", function () {
				StartRead();
			});
		});

		function StartRead()//开始读卡
		{
			if (GT2ICROCX.GetState() == 0){
				GT2ICROCX.ReadCard()
			}

			//GT2ICROCX.ReadCard() //循环读卡

			$("#idcard").val(GT2ICROCX.CardNo);
		}
	
	function isNumber(val){
		if(val){
			return val.match(/(\d+)|(^(\d+.\d+)$)/);
		}
		return true;
	}
	
	function checkAge(){
		var startAge=$("#beginAge").val();
		if(!isNumber(startAge)){
			$("#beginAge").val("");
			layer.alert("请输入正确的年龄段！", {icon:0,title:'提示'});
			return false;
		}
		var endAge=$("#endAge").val();
		if(!isNumber(endAge)){
			$("#endAge").val("");
			layer.alert("请输入正确的年龄段！", {icon:0,title:'提示'});
			return false;
		}
		if(startAge&&endAge&&Number(startAge) > Number(endAge)){
			layer.alert("开始年龄不能大于结束年龄！", {icon:0,title:'提示'});
			return false;
		}
		return true;
	}
	 //查询列表
	function search(indexPage) { 
		if(!checkAge()){
			return;
		}
		var searchObj = {
			url : "/cdm/standardization/planList",
			insertDiv : "planInfo",
			param : {
				pageIndex : indexPage
			}
		};
		$("#form_search").submitFormLoadHtml(searchObj);
	}
	
	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	}
	
	return {
		search : search,
		toggle : toggle
	};
})();
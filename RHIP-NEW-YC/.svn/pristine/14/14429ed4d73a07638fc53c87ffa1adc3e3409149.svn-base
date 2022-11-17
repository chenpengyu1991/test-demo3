var repeatReportCard = (function() {
	$(function() {
		 search(1);
		
		$("#disTypeSelect").multiselect({
			header : false,
			noneSelectedText : '请选择',
			selectedList : 4,
			minWidth : "auto"
		});
		
		$("#slideTable").on("click", function(event){
			toggle(this, 'searchTable');
		});
		
		//添加回车监听事件
		 $('input').keypress(function (e) {
		     var key = e.which;
		     if (key == 13) {
		    	 search(1);
		     }
		 });
		 
		$("#repeat_reportCard_search_btn").on("click", function(event){
			event.preventDefault();
			search(1);
		});
		
		 //点击超链接查看详细信息
		 $("#list_datagrid").on("click", ".report-link",function(event){
				event.preventDefault();
				var loadHtmlByUrlOption = {
						url : "/cdm/reportcard/view/"+$(this).data("personid"),
						insertDiv : "input_view"
				};
				$. loadHtmlByUrl(loadHtmlByUrlOption);
				$("#list_view").hide();
				$("#input_view").show();
			});
		 
		 //点击超链接操作删除
		 $("#list_datagrid").on("click", ".del-link",function(event){
			 var $this= $(this);
			 layui.use('layer', function(){
     			var layer = layui.layer;
     			if($this.data("flag")==9){
     				layer.alert("已管理人员不得删除！", {icon:0,title:'提示'});
     			}else{
     				var index = layer.confirm("删除重复报卡？", {icon:2, title:'确认提示'}, function(){
     					event.preventDefault();
     					var loadHtmlByUrlOption = {
     							url : "/cdm/reportcard/del/"+$this.data("cdmid"),
     							callback : function(data){
     								if(data=="success"){
     									var index2 = layer.alert("删除成功", {icon:0,title:'提示'}, function() {
     										layer.close(index);
     										layer.close(index2);
     										search(1);
     									});
     								}
     							}
     					};
     					$.getJsonByUrl(loadHtmlByUrlOption);
     				});
     			}
     		});
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
	 //查询列表
	function search(indexPage) { 
		if(!checkDate()){
			return;
		}
		var searchObj = {
			url : "/cdm/reportcard/repeatReportCardList",
			insertDiv : "list_datagrid",
			param : {
				pageIndex : indexPage
			}
		};
		$("#form_search").submitFormLoadHtml(searchObj);
	}
	function toggle(obj, tableId)
	{
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	}
	
	function checkDate(){
		var reportCreateStartDate=$("#reportCreateStartDate").val();
		var reportCreateEndDate=$("#reportCreateEndDate").val();
		if(reportCreateStartDate&&reportCreateEndDate&&new Date(reportCreateStartDate)>new Date(reportCreateEndDate)){
			layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
			return false;
		}
		return true;
	}
	return {
		search : search,
		toggle : toggle
	};
})();
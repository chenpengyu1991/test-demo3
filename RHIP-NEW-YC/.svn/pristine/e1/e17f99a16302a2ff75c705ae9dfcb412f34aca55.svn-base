var personMoveCancelJS = (function() {
	
     $(function(){
    	 Cancelsearch(1);
    	 moveSearch(1);
    	// tab切换
 		$("#tag1").on("click", function(event){
 			selectTag("tagContent0", this);
 		});
 		$("#tag2").on("click", function(event){
 			selectTag("tagContent1", this);
 		});
    	 
    	$("#per_search_btn").on("click", function(e){
    		e.preventDefault();
    		Cancelsearch(1);
    	});
    	 
    	// Enter查询
		$("#form_search").onEnter(function(){
			Cancelsearch(1);
		});
		
		$("#move_search_btn").on("click", function(e){
			e.preventDefault();
			moveSearch(1);
    	});
    	 
    	// Enter查询
		$("#form_moveSearch").onEnter(function(){
			moveSearch(1);
		});
		$("#cancelButtonId").click(function() {
			$.removeDialog("personCancelDialog");
		});
		
		$("#per_export_btn").click(function() {//结案
			perExportList();
		});
		
		$("#move_export_btn").click(function() {//迁移
			moveExportList();
		});
     });
     
     function perExportList(){
    	var option={
 				url:"/personCancel/export"
 		};
 		$("#form_search").exportListExcel(option);
     }
     
     function moveExportList(){
    	var option={
				url:"/personMove/export"
		};
		$("#form_moveSearch").exportListExcel(option);
     }
     
     function Cancelsearch(indexPage){
    	 var createBegin = new Date($("#cancelBeginDate").val());
		 var createEnd = new Date($("#cancelEndDate").val());
		 
		 if(createBegin > createEnd){
			 layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
		 }else{
			 $("#form_search").submitFormLoadHtml({
	            url : contextPath + "/personCancel/result",
	            insertDiv : "personCancelListDiv",
	            param:{
	                indexPage: indexPage
	            }
	        });
		 }
     }
     
     function moveSearch(indexPage){
    	 var createBegin = new Date($("#moveBeginDate").val());
		 var createEnd = new Date($("#moveEndDate").val());
		 
		 if(createBegin > createEnd){
			 layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
		 }else{
			 $("#form_moveSearch").submitFormLoadHtml({
	            url : contextPath + "/personMove/result",
	            insertDiv : "personMoveListDiv",
	            param:{
	                indexPage: indexPage
	            }
	        });
		 }
     }
     function dialog(idCard) {
 		var userDialog = {
 			id :"personCancelDialog",
             url : "/personCancel/detail",
             height : 400,
             width : 700,
             title : "档案注销（死亡）",
             param : {
            	 idCard:idCard
 			}
         };
 		
         $.dialog(userDialog);
 	}
     return {
 		Cancelsearch : Cancelsearch,
 		dialog : dialog,
 		moveSearch:moveSearch
 	};
    
})();

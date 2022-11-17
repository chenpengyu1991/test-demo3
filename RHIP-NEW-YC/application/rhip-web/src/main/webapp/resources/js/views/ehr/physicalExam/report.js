var healthExamReport = (function(){
	$(function(){
		
//		$("#reportDialog ul li").css("display","none");
//		$("#reportDialog ul li:eq(0)").css("display","inline");
		
		var liIndex = 0;
		var last = $("#reportDialog ul li").length - 1;
		$("#preBtn").attr("disabled","disabled");	
		
		$("#preBtn").on("click", function(){
			$("#reportDialog ul li:eq(" + liIndex + ")").css("display","none");
			$("#reportDialog ul li:eq(" + liIndex - 1 + ")").css("display","inline");
			
			alert(liIndex + ","+ last);
			if(liIndex == 0){
				$("#preBtn").attr("disabled","true");
			}else {
				$("#preBtn").attr("disabled","false");
			}
			if(liIndex == last){
				$("#nextBtn").attr("disabled","true");	
			}else {
				$("#nextBtn").attr("disabled","false");	
			}
			
			
			liIndex = liIndex - 1;
		});
		
		$("#nextBtn").on("click", function(){
			$("#reportDialog ul li:eq(" + liIndex + ")").css("display","none");
			$("#reportDialog ul li:eq(" + liIndex + 1 + ")").css("display","inline");
			
			alert(liIndex + ","+ last);
			if(liIndex == 0){
				$("#preBtn").attr("disabled","disabled");	
			}else {
				$("#preBtn").remove("disabled");
			}
			if(liIndex == last){
				$("#nextBtn").attr("disabled","disabled");	
			}else {
				$("#nextBtn").remove("disabled");
			}
			
			liIndex = liIndex + 1;
		});
		
		$(".examEventLink").on("click", function(event){
			event.preventDefault();
			var examid = $(this).attr("id");
			var examState = $("#examEventDetail" + examid).attr("style");
			if(examState == "display: none;"){
				$.loadHtmlByUrl({
					url : $(this).attr("href"),
					param : {
						ehrId : $("#ehr_id").val(),
						personId : $("#person_id").val(),
						inspectionType : $(this).text().trim()
					},
					insertDiv : "examEventDetail" + examid
				});
				$("#examEventDetail" + examid).show();
			}else {
				$("#examEventDetail" + examid).hide();
			}
		});
		
		$(".studyEventLink").on("click", function(event){
			event.preventDefault();
			var studyid = $(this).attr("id");
			var studyState = $("#studyEventDiv" + studyid).attr("style");
			if(studyState == "display: none;"){
				$("#studyEventDiv" + studyid).show();
			}else {
				$("#studyEventDiv" + studyid).hide();
			}
		});
		
		$("#obOpenLink").on("click", function(event){
			event.preventDefault();
			var studyState = $("#obTable").attr("style");
			if(studyState == "display: none;"){
				$("#obTable").show();
			}else {
				$("#obTable").hide();
			}
		});
		
		$("#resultOpenLink").on("click", function(event){
			event.preventDefault();
			var studyState = $("#resultDiv").attr("style");
			if(studyState == "display: none;"){
				$("#resultDiv").show();
			}else {
				$("#resultDiv").hide();
			}
		});
	});
})();
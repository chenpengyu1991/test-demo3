var ehrbrowserIndex = (function() {
	var menuClass="ehrbrowser-menu";
	var mainId="ehrbrowser-content";
	var personid = $("#ehrbrowser_person_id_input").val();
	$(function() {
		if(personid != "" && personid.length > 0){
			$("."+menuClass).on("click",function(event){
				event.preventDefault(); 
				var $this = $(this);
					$.loadHtmlByUrl({
						url : $this.attr("href"),
						param:{
			                personId: personid
			            },
						insertDiv : mainId
					});
			});
		}else {
			msgUtil.alert("所查询人员档案不存在!");
		}
		
		$("."+menuClass+":first").click();
	});
})();
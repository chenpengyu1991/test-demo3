var brwPlanInfoTab =(function() {
	$(function() {
		initTab();
	});
	
	function initTab(){
		var $bar=$("#tags");
		$bar.find("a").on("click",function(event){
			var $this=$(this);
			var target=$this.data("target");
			type=$this.data("type");
			$bar.find("li.selectTag").removeClass("selectTag");
			$this.parent().addClass("selectTag");
			$("#tagContent").children().hide();
			$("#"+target).show();
		});
		$bar.find("a:first").click();
	}
})();
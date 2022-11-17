var manageIndex = (function(){
	$(function(){
		initTab();
	});
	
	function initTab(){
		var $bar=$("#tags");
		$bar.find("a").on("click",function(event){
			var $this=$(this);
			var target=$this.data("target");
			$bar.find("li.selectTag").removeClass("selectTag");
			$this.parent().addClass("selectTag");
			$("#tagContent").children().hide();
			$("#"+target).show();
			//baseLayoutLoad.outResize();
		});
		$bar.find("a:first").click();
	}
})();
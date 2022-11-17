var clinicalChartPop = (function() {
	$(function() {
		$(".clichart-week-btn").on("click", function(event) {
			var $this = $(this);
			getChartData($this.attr("href"));
			event.preventDefault();
			$(".clichart-week-btn").removeClass("selected");
			$this.addClass("selected");
			return false;
		});
		$(".clichart-week-btn:first").click();
		
	});
	
	function getChartData(url){
		$.loadHtmlByUrl({
			url : url,
			insertDiv : "chichat-data-content"
		});
	}
	return {};
})();

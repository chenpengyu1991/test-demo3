define(function() {
	function load(){
		$(function() {
			initForm();

		});
	};

	function initForm(){
		$("#tag1").on("click", function(event)
		{
			var url =  $(this).data('url');
			selectTagl('tagContent1', this);
			loadChart(url,'tagContent1');
		});
		$("#tag2").on("click", function(event)
		{
			var url =  $(this).data('url');
			selectTagl('tagContent1', this);
			loadChart(url,'tagContent1');
		});
		loadChart('/ihm/deathAnalys/icd10ComposeChart','tagContent1');
	}

	/*加载当前年*/
	function loadChart(chartUrl,tagContentId) {
		//参数
		var loadHtmlByUrlOption = {
			url : "/ihm/deathAnalys/tabIndex",
			param : {chartUrl:chartUrl},
			checkRepeat : true,
			insertDiv : tagContentId
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	};
	return {
		load:load
	};
});

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
			loadTab(url,'tagContent1');

		});
		$("#tag2").on("click", function(event)
		{
			var url =  $(this).data('url');
			selectTagl('tagContent1', this);
			loadTab(url,'tagContent1');
		});
		loadTab( $('#tag1').data('url'),'tagContent1');
	}

	/*加载当前年*/
	function loadTab(tabUrl,tagContentId) {
		//参数
		var loadHtmlByUrlOption = {
			url : tabUrl,
			param : {},
			checkRepeat : true,
			insertDiv : tagContentId
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	};


	return {
		load:load
	};
});

define(function(){
	function load() {
		$(function () {
			$("#integration_log_search_btn").click(function () {
				search(1);
			});

			$("#integrationLogSearch").onEnter(search, 1);
			search(1);

			$("#integrationLogTop").click(function () {
				toggle(this,"integrationLogSearch");
			});

		});
	}

	function search(indexPage) {
		var searchObj = {
				url : "/im/log/list",
				insertDiv : "listDivIntegrationLog",
				param : {
					indexPage : indexPage
				}
			};
			$("#integration_log_from").submitFormLoadHtml(searchObj);
	};

	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	};

	return {
		load: load,
		toggle: toggle,
		search: search
	};
});
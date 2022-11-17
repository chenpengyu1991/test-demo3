var fileInit = (function(){

	$(function() {
		/*资料下载*/
		$("#zlxz").click(function() {
			window.location.href = contextPath+ "/fileManager/index?indexPage=1";
		});
		$("#bgxz, #bgxz1, #bgxz2").click(function() {
			window.location.href = contextPath+ "/fileManager/index?type=01&indexPage=1";
		});
		$("#zcwj, #zcwj1, #zcwj2").click(function() {
			window.location.href = contextPath+ "/fileManager/index?type=02&indexPage=1";
		});
		$("#rjxz, #rjxz1, #rjxz2").click(function() {
			window.location.href = contextPath+ "/fileManager/index?type=03&indexPage=1";
		});
		/*资料下载 end*/
		initLinkClick('fileManagerDetail',fileManagerDetail, {id:"data-id", type:"data-type"});
		initLinkClick('fileDownload',fileDownload, {id:"data-id"});
	});


	function fileManagerDetail(id, type) {
		window.location.href = contextPath+ "/fileManager/fileDetail?id="+id+"&type="+type;
	}
	function fileDownload(id) {
		window.location.href = contextPath+ "/fileManager/download/"+id;
	}

})();
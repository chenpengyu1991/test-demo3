var newBornBabyRegister = (function(){
	$(function(){
        getBornBabyRegisterList($(".WhYcfbjXsedj:first").val());
	});
	
	function getBornBabyRegisterList(id){
		var loadByUrl = {
			url : "/ehrbrowser/health/newBornBabyRegisterDetail",
			insertDiv : "WhYcfbjXsedjDiv",
			param : {
				id : id
			}
		};
		$.loadHtmlByUrl(loadByUrl);
	}
	
	return {
        getBornBabyRegisterList : getBornBabyRegisterList
	};
})();
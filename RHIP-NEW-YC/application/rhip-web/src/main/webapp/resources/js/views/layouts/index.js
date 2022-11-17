var homepageInit = (function() {
	
	function back(){
		baseLayoutLoad.loadMenuContent("/home/load");
	}
	
	return {
		back : back
	};
})();
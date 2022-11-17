define(function(){
	function load() {
	 $(function(){
          $.ajaxSetup ({
            cache: false
          });
         try {
        	 $.loadHtmlByUrl({
     			url : "/ehrbrowser/healthExplore",
     			insertDiv : "healthBrwDiv"
     		});
         } catch (e) {
         }
        
        try {
            if(null!=healthBrwLayout && $.isFunction(healthBrwLayout.getHtml)){
                healthBrwLayout.getHtml();
            }
        } catch (e) {
        }
       
     })
	}
	return {
		load: load
	};
});
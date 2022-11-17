define(function(){
	function load() {
	 $(function(){
          $.ajaxSetup ({
            cache: false
          });
         try {
        	 $.loadHtmlByUrl({
     			url : "/referral/edit",
     			insertDiv : "referralBrwDiv"
     		});
         } catch (e) {
         }
        
        try {
            if(null!=referralBrwLayout && $.isFunction(referralBrwLayout.getHtml)){
            	referralBrwLayout.getHtml();
            }
        } catch (e) {
        }
       
     })
	}
	return {
		load: load
	};
});
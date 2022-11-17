require.config({
	baseUrl:"../js/jquery",
	paths:{
		"jquery" : "../../jquery/jquery1.7.2",
		"jquery-ui" : "../../jquery/jquery-ui-1.11.0.custom"
	},
	shim:{
		'jquery-ui':{deps: ['jquery']}
	}
	
});
require(["jquery"], function($) {
	$(function(){
		$("input[name='login']").click(login);
		$("#nameTextId")[0].focus();
		document.onkeydown = function(e){ 
		    var ev = document.all ? window.event : e;
		    if(ev.keyCode==13) {
		    	login();
		    }
		}
   });
	
	function login(){ 
		var form = document.getElementById('loginFormId');	
		var type=$(":radio:checked").val();			
		var act=type=="0"?"login":"plogin"; 
		form.action = contextPath + "/access/"+"login"; 
		form.submit(); 
    }
});
var jsUrls = [];

jsUrls.push('jquery');
jsUrls.push('jquery-ui');
jsUrls.push('jquery.founder');
jsUrls.push('jquery.founder.form');
jsUrls.push('jquery.founder.ajax');
jsUrls.push('idCardUtil');
jsUrls.push('idCard');
jsUrls.push('jquery.founder.select');
jsUrls.push('jquery.easy_validator');
jsUrls.push('jquery.autocomplete');
jsUrls.push('jquery.alerts');
jsUrls.push('WdatePicker');
jsUrls.push('base');
jsUrls.push('util');

require.config({
	baseUrl:contextPath + "/js/jquery",
	paths:{
		"jquery" : "../jquery/jquery-1.1",
		"jquery-ui" : "../jquery/jquery-ui-1.11.0.custom",
		"jquery.founder" :  "../util/jquery.founder",
		"jquery.founder.form" :  "../util/jquery.founder.form",
		"jquery.founder.ajax" :  "../util/jquery.founder.ajax",
		"idCardUtil" :  "../util/idCardUtil",
		"idCard" :  "../util/idCard",
		"jquery.founder.select" :  "../util/jquery.founder.select",
		"jquery.easy_validator" :  "../util/jquery.easy_validator",
		"jquery.autocomplete" :  "../autocomplete/jquery.autocomplete",
		"jquery.alerts" :  "../jquery.alerts/jquery.alerts",
		"WdatePicker" : "../datepicker/WdatePicker",
		"base": "../util/base",
		"util": "../util/util",
		"views" : "../views"
	},
	shim:{
		'jquery-ui':{deps: ['jquery']},
		'jquery.placeholder':{deps: ['jquery']},
		'jquery.treeview':{deps: ['jquery']},
		'ajaxfileupload':{deps: ['jquery']},
		'jquery.founder':{deps: ['jquery']},
		'jquery.founder.form':{deps: ['jquery']},
		'jquery.founder.page' : {deps: ['jquery']},
		'jquery.founder.ajax':{deps: ['jquery']},
		'jquery.bgiframe':{deps: ['jquery']},
		'section':{deps: ['jquery']},
		'idCardUtil':{deps: ['jquery']},
		'jquery.founder.select':{deps: ['jquery','jquery.autocomplete']},
		'jquery.easy_validator':{deps: ['jquery']},
		'jquery.autocomplete':{deps: ['jquery','jquery-ui']},
		'jquery.alerts':{deps: ['jquery']},
		'WdatePicker':{deps: ['jquery']},
		'base':{deps: ['jquery','util']},
		'util':{deps: ['jquery']},
		'views/layouts/baseLayoutLoad':{deps: jsUrls}
		
	}
	
});

require(["views/layouts/baseLayoutLoad"], function(baseLayout) {
	baseLayout.initHome();
}); 


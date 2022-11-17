var jsUrls = [];
jsUrls.push('jquery');
jsUrls.push('jquery.placeholder');
jsUrls.push('jquery.treeview');
jsUrls.push('jquery.form');
jsUrls.push('jquery.multiselect');
jsUrls.push('ajaxfileupload');
jsUrls.push('jquery.blockUI');
jsUrls.push('jquery.founder');
jsUrls.push('jquery.founder.form');
jsUrls.push('jquery.founder.page');
jsUrls.push('jquery.founder.ajax');
jsUrls.push('jquery.bgiframe');
jsUrls.push('section');
jsUrls.push('idCardUtil');
jsUrls.push('jquery.founder.select');
jsUrls.push('jquery.easy_validator');
jsUrls.push('jquery.autocomplete');
jsUrls.push('jquery.alerts');
jsUrls.push('highcharts');
jsUrls.push('highcharts.exporting');
jsUrls.push('WdatePicker');
jsUrls.push('base');
jsUrls.push('pageUtil');
jsUrls.push('util');
jsUrls.push('IC');
jsUrls.push('jquery.PrintArea');
jsUrls.push('jquery.ztree.core-3.5');
jsUrls.push('jquery.ztree.excheck-3.5.min');

require.config({
	baseUrl:contextPath + "/js/jquery",
	paths:{
		"jquery" : "../jquery/jquery1.7.2",
		"jquery-ui" : "../jquery/jquery-ui-1.11.0.custom",
		"jquery.placeholder" : "../jquery/jquery.placeholder.1.3",
		"jquery.treeview" : "../jquery/jquery.treeview",
		"jquery.form" : "../jquery/jquery.form",
		"jquery.multiselect" : "../jquery/jquery.multiselect",
		"ajaxfileupload" : "../jquery/ajaxfileupload",
		"jquery.blockUI" : "../jquery/jquery.blockUI",
		"jquery.founder" :  "../util/jquery.founder",
		"jquery.founder.form" :  "../util/jquery.founder.form",
		"jquery.founder.page" :  "../util/jquery.founder.page",
		"jquery.founder.ajax" :  "../util/jquery.founder.ajax",
		"jquery.bgiframe" :  "../util/jquery.bgiframe",
		"section" :  "../util/section",
		"idCardUtil" :  "../util/idCardUtil",
		"jquery.founder.select" :  "../util/jquery.founder.select",
		"jquery.easy_validator" :  "../util/jquery.easy_validator",
		"jquery.autocomplete" :  "../autocomplete/jquery.autocomplete",
		"jquery.alerts" :  "../jquery.alerts/jquery.alerts",
		"highcharts" :  "../Highcharts-2.3.3/js/highcharts",
		"highcharts.exporting" :  "../Highcharts-2.3.3/js/modules/exporting",
		"jquery.ztree.core-3.5" :  "../zTree/js/jquery.ztree.core-3.5",
		"jquery.ztree.excheck-3.5.min" :  "../zTree/js/jquery.ztree.excheck-3.5.min",
		"WdatePicker" : "../datepicker/WdatePicker",
		'base': '../util/base',
		'pageUtil': '../util/pageUtil',
		'util': '../util/util',
		'IC':  '../util/IC',
		'orgUtil':  '../util/orgUtil',
		'jquery.PrintArea':  '../jquery/jquery.PrintArea',
		//'bootstrap' : '../../../css/bootstrap/js/bootstrap',
		"views" : "../views"
	},
	shim:{
		'jquery-ui':{deps: ['jquery']},
		'jquery.placeholder':{deps: ['jquery']},
		'jquery.treeview':{deps: ['jquery']},
		'jquery.form':{deps: ['jquery']},
		'jquery.multiselect':{deps: ['jquery','jquery-ui']},
		'ajaxfileupload':{deps: ['jquery']},
		'jquery.blockUI':{deps: ['jquery']},
		'jquery.founder':{deps: ['jquery']},
		'jquery.founder.form':{deps: ['jquery']},
		'jquery.founder.page' : {deps: ['jquery']},
		'jquery.founder.ajax':{deps: ['jquery']},
		'jquery.bgiframe':{deps: ['jquery']},
		'section':{deps: ['jquery']},
		'idCardUtil':{deps: ['jquery']},
		'jquery.ztree.core-3.5':{deps: ['jquery']},
		'jquery.ztree.excheck-3.5.min':{deps: ['jquery','jquery.ztree.core-3.5']},
		'jquery.founder.select':{deps: ['jquery','jquery.autocomplete']},
		'jquery.easy_validator':{deps: ['jquery']},
		'jquery.autocomplete':{deps: ['jquery','jquery-ui']},
		'jquery.alerts':{deps: ['jquery']},
		'highcharts':{deps: ['jquery']},
		'highcharts.exporting':{deps: ['jquery','highcharts']},
		'jquery.ztree.core-3.5':{deps: ['jquery']},
		'WdatePicker':{deps: ['jquery']},
		'base':{deps: ['jquery','util']},
		'pageUtil':{deps: ['jquery']},
		'util':{deps: ['jquery']},
		'IC':{deps: ['jquery']},
		'jquery.PrintArea':{deps: ['jquery']},
		'orgUtil':{deps: jsUrls},
		'views/integration/integration':{deps: jsUrls}
		
	}
	
});

 require(['views/integration/integration'],function(integration){
		 integration.load();
	 });
	 
	 

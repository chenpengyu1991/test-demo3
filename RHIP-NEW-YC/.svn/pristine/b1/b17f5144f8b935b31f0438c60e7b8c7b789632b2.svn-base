var jsUrls = [];

jsUrls.push('jquery');
jsUrls.push('jquery.placeholder');
jsUrls.push('jquery.treeview');
jsUrls.push('jquery.form');
/*jsUrls.push('jquery-migrate');*/
jsUrls.push('jquery.multiselect');
jsUrls.push('ajaxfileupload');
jsUrls.push('load');
jsUrls.push('jquery.blockUI');
jsUrls.push('jquery.founder');
jsUrls.push('jquery.founder.form');
jsUrls.push('jquery.founder.page');
jsUrls.push('jquery.founder.ajax');
jsUrls.push('jquery.founder.export');
jsUrls.push('jquery.bgiframe');
jsUrls.push('section');
jsUrls.push('idCardUtil');
jsUrls.push('jquery.founder.select');
jsUrls.push('jquery.easy_validator');
jsUrls.push('jquery.autocomplete');
jsUrls.push('jquery.alerts');
jsUrls.push('highcharts');
jsUrls.push('highcharts.exporting');
jsUrls.push('jquery.ztree.core-3.5');
jsUrls.push('jquery.ztree.excheck-3.5.min');
jsUrls.push('WdatePicker');
jsUrls.push('base');
jsUrls.push('pageUtil');
jsUrls.push('util');
jsUrls.push('IC');
jsUrls.push('orgUtil');
jsUrls.push('echarts.min');
//jsUrls.push('bootstrap');
/*jsUrls.push('echarts');
jsUrls.push('echarts.pie');
jsUrls.push('echarts.funnel');
jsUrls.push('echarts.bar');
jsUrls.push('echarts.line');*/

require.config({
	baseUrl:contextPath + "/js/jquery",
	waitSeconds: 0,
	paths:{
		"jquery" : "../jquery/jquery1.7.2",
		/*'jquery-migrate':  '../jquery/jquery-migrate-1.1.0',*/
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
		"jquery.founder.export" :  "../util/jquery.founder.export",
		"jquery.bgiframe" :  "../util/jquery.bgiframe",
        "load" :  "../util/load",
        "section" :  "../util/section",
		"idCardUtil" :  "../util/idCardUtil",
		"jquery.founder.select" :  "../util/jquery.founder.select",
		"jquery.easy_validator" :  "../util/jquery.easy_validator",
		"jquery.autocomplete" :  "../autocomplete/jquery.autocomplete",
		"jquery.alerts" :  "../jquery.alerts/jquery.alerts",
		"highcharts" :  "../Highcharts-2.3.3/js/highcharts",
		"highcharts.exporting" :  "../Highcharts-2.3.3/js/modules/exporting",
		// "echarts" : "../echarts/echarts",
		"echarts.min" : "../echarts/echarts.min",
		// "echarts.shine" : "../echarts/theme/shine",
		// "echarts.pie" : "../echarts/chart/pie",
		// "echarts.funnel" : "../echarts/chart/funnel",
		// "echarts.bar" : "../echarts/chart/bar",
		// "echarts.line" : "../echarts/chart/line",
		"jquery.ztree.core-3.5" :  "../zTree/js/jquery.ztree.core-3.5",
		"jquery.ztree.excheck-3.5.min" :  "../zTree/js/jquery.ztree.excheck-3.5.min",
		"WdatePicker" : "../datepicker/WdatePicker",
		'base': '../util/base',
		'pageUtil': '../util/pageUtil',
		'util': '../util/util',
		'IC':  '../util/IC',
		'orgUtil':  '../util/orgUtil',
		//'bootstrap' : '../../../css/bootstrap/js/bootstrap',
		"views" : "../views"
	},
	shim:{
		'jquery-ui':{deps: ['jquery']},
		/*'jquery-migrate':{deps: ['jquery']},*/
		'jquery.placeholder':{deps: ['jquery']},
		'jquery.treeview':{deps: ['jquery']},
		'jquery.form':{deps: ['jquery']},
		'jquery.multiselect':{deps: ['jquery','jquery-ui'/*,'jquery-migrate'*/]},
		'ajaxfileupload':{deps: ['jquery']},
        'load':{deps: ['jquery']},
        'jquery.blockUI':{deps: ['jquery']},
		'jquery.founder':{deps: ['jquery']},
		'jquery.founder.form':{deps: ['jquery']},
		'jquery.founder.page' : {deps: ['jquery']},
		'jquery.founder.ajax':{deps: ['jquery']},
		'jquery.founder.export':{deps: ['jquery']},
		'jquery.bgiframe':{deps: ['jquery']},
		'section':{deps: ['jquery']},
		'idCardUtil':{deps: ['jquery']},
		'jquery.founder.select':{deps: ['jquery','jquery.autocomplete']},
		'jquery.easy_validator':{deps: ['jquery']},
		'jquery.autocomplete':{deps: ['jquery','jquery-ui']},
		'jquery.alerts':{deps: ['jquery']},
		'highcharts':{deps: ['jquery']},
		'highcharts.exporting':{deps: ['jquery','highcharts']},
		// 'echarts':{deps: ['jquery']},
		'echarts.min':{deps: ['jquery']},
		/*'echarts.pie':{deps: ['jquery']},
		'echarts.funnel':{deps: ['jquery']},
		'echarts.bar':{deps: ['jquery']},
		'echarts.line':{deps: ['jquery']},*/
		'jquery.ztree.core-3.5':{deps: ['jquery']},
		'jquery.ztree.excheck-3.5.min':{deps: ['jquery','jquery.ztree.core-3.5']},
		'WdatePicker':{deps: ['jquery']},
		'base':{deps: ['jquery','util']},
		'pageUtil':{deps: ['jquery']},
		'util':{deps: ['jquery']},
		'IC':{deps: ['jquery']},
		'orgUtil':{deps: ['jquery']},
		//'bootstrap' : {deps: ['jquery']},
		'x-admin/load_resources':{deps: jsUrls}
		
	}
	
});

require(["x-admin/load_resources"], function(load_resources) {
	load_resources.load();
}); 


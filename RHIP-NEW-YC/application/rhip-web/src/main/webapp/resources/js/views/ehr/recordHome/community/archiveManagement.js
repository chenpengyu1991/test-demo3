var communityArchiveManagement = (function(){
	
	 $(function() {
	        //档案管理
        loadingArchiveManagement();
        /*$("input[name=RadioGroup5]").on("click",function(){
        	loadingArchiveManagement();
		 });*/
    });
	 
	 function loadingArchiveManagement() {
		 var statisticsDate =$("input[name=RadioGroup5]:checked").val();
		 $.getJsonByUrl({
			 	url : "/haStatistics/getCommunityArchiveManagementList",
				param : {'statisticsDate' : statisticsDate},
				checkRepeat : true,
				callback : function(data){
					var hrArchiveNew = data["hrArchiveNew"];
					var hrArchiveTotal = data["hrArchiveTotal"];
					var hrOneStar = data["hrOneStar"];
					var hrTwoStar = data["hrTwoStar"];
					var hrThreeStar = data["hrThreeStar"];
					var hrArchiveCancel = data["hrArchiveCancel"];
					var hrArchiveEmigration = data["hrArchiveEmigration"];
					var unhrArchiveNew = data["unhrArchiveNew"];
					var unhrArchiveTotal = data["unhrArchiveTotal"];
					var unhrOneStar = data["unhrOneStar"];
					var unhrTwoStar = data["unhrTwoStar"];
					var unhrThreeStar = data["unhrThreeStar"];
					var unhrArchiveCancel = data["unhrArchiveCancel"];
					var unhrArchiveEmigration = data["unhrArchiveEmigration"];
					Highcharts.setOptions({
						lang : {
							numericSymbols : null
//							downloadJPEG : '下载为JPEG图片',
//							downloadPDF : '下载为PDF文档',
//							downloadPNG : '下载为PNG图片',
//							downloadSVG : '下载为SVG图片',
//							exportButtonTitle : '导出',
//							printButtonTitle : '打印'

						}
					});
					var chart = new Highcharts.Chart({
						chart : {
							renderTo : 'archiveManagementChart'
						},
						credits : {
							enabled : false
						},
						title : {
							text : '档案管理'
						},
						xAxis : {
							categories : [ '新增个人档案', '档案更新份数', '一星档案', '二星档案', '三星档案', '档案结案', '档案迁移']
						},
						yAxis : {
							title : {
								text : '份'
							}
						},
						exporting : {
							enabled : false
						},
						lang : {
							numericSymbols : 'null'
						},
						tooltip : {
							formatter : function() {
								var s;
								s = '' + this.series.name + ': '
										+ Highcharts.numberFormat(this.y, 0);
								return s;
							}
						},
						plotOptions:{
	                        series: {
	                            minPointLength:5
	                        }
                    	},					
						series : [ {
							type : 'column',
							name : '户籍',
							data : [ hrArchiveNew, hrArchiveTotal, hrOneStar, hrTwoStar, hrThreeStar, hrArchiveCancel, hrArchiveEmigration]
						}, {
							type : 'column',
							name : '非户籍',
							data : [ unhrArchiveNew, unhrArchiveTotal, unhrOneStar, unhrTwoStar, unhrThreeStar, unhrArchiveCancel, unhrArchiveEmigration]
						} ]
					});
				}
		 });
	 }
	 return {
		 loadingArchiveManagement:loadingArchiveManagement
	 }
})();
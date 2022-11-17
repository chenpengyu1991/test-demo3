
    $(function() {
        //档案管理
        loadingCardReport();
        $("input[name=RadioGroup5]").on("click",function(){
            loadingCardReport();
        });
        
        $("#viewReportCardMonitor").on("click",function(e){
        	e.preventDefault();
        	viewReportCardDetail();
        });
        
    });

    function loadingCardReport() {
        var statisticsDate =$("input[name=RadioGroup5]:checked").val();
         
        $.getJsonByUrl({
            url : "/ihm/card/monitor/json",
            param : {'statisticsDate' : statisticsDate},
            checkRepeat : true,
            callback : function(data){
        /*     alert(data);*/
               var organName1=data["ORGANNAME1"];
                var organName2=data["ORGANNAME2"];
                var organName3=data["ORGANNAME3"];
                var organName4=data["ORGANNAME4"];
                var organName5=data["ORGANNAME5"];
                var organName6=data["ORGANNAME6"];
                var organName7=data["ORGANNAME7"];
                var organName8=data["ORGANNAME8"];
                var organName9=data["ORGANNAME9"];
                var organName10=data["ORGANNAME10"];
                var organName11=data["ORGANNAME11"];
                var organName12=data["ORGANNAME12"];
                var organName13=data["ORGANNAME13"];
                var organName14=data["ORGANNAME14"];
                var organName15=data["ORGANNAME15"];

                var counta1=data["COUNTNUMA1"];
                var counta2=data["COUNTNUMA2"];
                var counta3=data["COUNTNUMA3"];
                var counta4=data["COUNTNUMA4"];
                var counta5=data["COUNTNUMA5"];
                var counta6=data["COUNTNUMA6"];
                var counta7=data["COUNTNUMA7"];
                var counta8=data["COUNTNUMA8"];
                var counta9=data["COUNTNUMA9"];
                var counta10=data["COUNTNUMA10"];
                var counta11=data["COUNTNUMA11"];
                var counta12=data["COUNTNUMA12"];
                var counta13=data["COUNTNUMA13"];
                var counta14=data["COUNTNUMA14"];
                var counta15=data["COUNTNUMA15"];

                var countb1=data["COUNTNUMB1"];
                var countb2=data["COUNTNUMB2"];
                var countb3=data["COUNTNUMB3"];
                var countb4=data["COUNTNUMB4"];
                var countb5=data["COUNTNUMB5"];
                var countb6=data["COUNTNUMB6"];
                var countb7=data["COUNTNUMB7"];
                var countb8=data["COUNTNUMB8"];
                var countb9=data["COUNTNUMB9"];
                var countb10=data["COUNTNUMB10"];
                var countb11=data["COUNTNUMB11"];
                var countb12=data["COUNTNUMB12"];
                var countb13=data["COUNTNUMB13"];
                var countb14=data["COUNTNUMB14"];
                var countb15=data["COUNTNUMB15"];

                var countc1=data["COUNTNUMC1"];
                var countc2=data["COUNTNUMC2"];
                var countc3=data["COUNTNUMC3"];
                var countc4=data["COUNTNUMC4"];
                var countc5=data["COUNTNUMC5"];
                var countc6=data["COUNTNUMC6"];
                var countc7=data["COUNTNUMC7"];
                var countc8=data["COUNTNUMC8"];
                var countc9=data["COUNTNUMC9"];
                var countc10=data["COUNTNUMC10"];
                var countc11=data["COUNTNUMC11"];
                var countc12=data["COUNTNUMC12"];
                var countc13=data["COUNTNUMC13"];
                var countc14=data["COUNTNUMC14"];
                var countc15=data["COUNTNUMC15"];
/*alert(countc1);*/
                Highcharts.setOptions({
                    lang : {
                        numericSymbols : null
                    }
                });
                var chart = new Highcharts.Chart({
                    chart : {
                        renderTo : 'cardMonitorChart'
                    },
                    credits : {
                        enabled : false
                    },
                    title : {
                        text : '报卡监控统计'
                    },
                   xAxis : {
                   categories : [organName1,organName2, organName3, organName4, organName5, organName6,organName7,organName8,organName9,organName10,organName11,organName12,organName13,organName14,organName15],
                   labels:{rotation: -45,y:60}
                   },
                    yAxis : {
                        title : {
                            text : '个'
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
                            minPointLength:0
                        }
                    },
                    series : [ {
                        type : 'column',
                        name : '慢病',
                        data : [parseInt(counta1),parseInt(counta2),parseInt(counta3),parseInt(counta4),parseInt(counta5),
                            parseInt(counta6), parseInt(counta7),parseInt(counta8),parseInt(counta9),parseInt(counta10),
                            parseInt(counta11), parseInt(counta12),parseInt(counta13),parseInt(counta14),parseInt(counta15)]
                    }, {
                        type : 'column',
                        name : '传染病',
                        data : [parseInt(countb1),parseInt(countb2),parseInt(countb3),parseInt(countb4),parseInt(countb5),
                            parseInt(countb6), parseInt(countb7),parseInt(countb8),parseInt(countb9),parseInt(countb10),
                            parseInt(countb11), parseInt(countb12),parseInt(countb13),parseInt(countb14),parseInt(countb15)]
                    }, {
                        type : 'column',
                        name : '食源性疾病',
                        data : [parseInt(countc1),parseInt(countc2),parseInt(countc3),parseInt(countc4),parseInt(countc5),
                            parseInt(countc6), parseInt(countc7),parseInt(countc8),parseInt(countc9),parseInt(countc10),
                            parseInt(countc11), parseInt(countc12),parseInt(countc13),parseInt(countc14),parseInt(countc15)]
                    }]
                });
               /* chart.series=[ '镇1', '镇2', '镇3', '镇4', '镇5', '镇6', '镇7']
                   *//* option.series = dataSource.series;
                option.xAxis.categories = dataSource.categories;*/
            }
        });
    }
    
    function viewReportCardDetail() {
    	$("#reportCardMonitorList").show();
    	$("#mainContent").hide();
    	var options = {
                url: contextPath + "/ihm/card/monitor/show",
                insertDiv: "reportCardMonitorList"
            };
            $.loadHtmlByUrl(options);
    }


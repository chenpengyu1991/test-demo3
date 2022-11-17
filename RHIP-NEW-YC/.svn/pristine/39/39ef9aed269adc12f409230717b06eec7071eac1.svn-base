define(
    function load(){
        $(function(){
            var loadingImg = "<span><img src='" + contextPath + "/images/AjaxLoader16.gif' style='vertical-align:top;'/></span>";
            $("#child").append(loadingImg);
            $("#childHealthcare").append(loadingImg);
            $("#pregWomenHealthcare").append(loadingImg);
            $("#permaritalExa").append(loadingImg);
            childChart();
            childHealthcare();
            pregWomenHealthcare();
            permaritalExa();
        })

        function childChart(){
            var  childA1= getNumVal("childA1");
            var  childA2= getNumVal("childA2");
            var  childA3= getNumVal("childA3");
            var  childA4= getNumVal("childA4");
            var  childA5= getNumVal("childA5");
            var  childA6= getNumVal("childA6");
            var  childA7= getNumVal("childA7");
            var  childB1= getNumVal("childB1");
            var  childB2= getNumVal("childB2");
            var  childB3= getNumVal("childB3");
            var  childB4= getNumVal("childB4");
            var  childB5= getNumVal("childB5");
            var  childB6= getNumVal("childB6");
            var  childB7= getNumVal("childB7");
            var  childC1= getNumVal("childC1");
            var  childC2= getNumVal("childC2");
            var  childC3= getNumVal("childC3");
            var  childC4= getNumVal("childC4");
            var  childC5= getNumVal("childC5");
            var  childC6= getNumVal("childC6");
            var  childC7= getNumVal("childC7");


            chiEChartOption = {
                title : {
                    text: '儿童人数统计报表',
                    textStyle:{fontSize: 13},
                    x: 'center'
                },
                tooltip : {
                    trigger: 'axis'
                },
                legend: {
                    data:['A镇人数','B镇人数','C镇人数'],
                    y:'bottom'
                },
                toolbox: {
                    show : true,
                    feature : {
                        mark : {show: false},
                        dataView : {show: true, readOnly: false},
                        magicType : {show: true, type: ['line', 'bar']},
                        restore : {show: true},
                        saveAsImage : {show: true}
                    }
                },
                calculable : true,
                xAxis : [
                    {
                        type : 'category',
                        data : ['0-1', '1-2', '2-3', '3-4',
                            '4-5', '5-6', '6-7']
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'A镇人数',
                        type:'bar',
                        data:[childA1,childA2,childA3,childA4,childA5,childA6,childA7],
                        markPoint : {
                            data : [
                                {type : 'max', name: '最大值'},
                                {type : 'min', name: '最小值'}
                            ]
                        }
                    },
                    {
                        name:'B镇人数',
                        type:'bar',
                        data:[childB1,childB2,childB3,childB4,childB5,childB6,childB7],
                        markPoint:{
                            data:[
                                {type:'max',name:'最大值'},
                                {type:'min',name:'最小值'}
                            ]
                        }
                    },
                    {
                        name:'C镇人数',
                        type:'bar',
                        data:[childC1,childC2,childC3,childC4,childC5,childC6,childC7],
                        markPoint:{
                            data:[
                                {type:'max',name:'最大值'},
                                {type:'min',name:'最小值'}
                            ]
                        }
                    }
                ]
            };
            var childChart = document.getElementById('child');
            require(
                [
                    'echarts',
                    'echarts/chart/bar',
                    'echarts/chart/line'
                ],
                function (ec) {
                    var myChartChil = ec.init(childChart);
                    myChartChil.setOption(chiEChartOption);
                    window.onresize = myChartChil.resize;
                });

        }

        function childHealthcare(){
            var chiHelCareA1 = getNumVal("chiHelCareA1");
            var chiHelCareA2 = getNumVal("chiHelCareA2");
            var chiHelCareA3 = getNumVal("chiHelCareA3");
            var chiHelCareA4 = getNumVal("chiHelCareA4");
            var chiHelCareB1 = getNumVal("chiHelCareB1");
            var chiHelCareB2 = getNumVal("chiHelCareB2");
            var chiHelCareB3 = getNumVal("chiHelCareB3");
            var chiHelCareB4 = getNumVal("chiHelCareB4");
            var chiHelCareC1 = getNumVal("chiHelCareC1");
            var chiHelCareC2 = getNumVal("chiHelCareC2");
            var chiHelCareC3 = getNumVal("chiHelCareC3");
            var chiHelCareC4 = getNumVal("chiHelCareC4");
            chiHelEChartOption = {
                title : {
                    text: '儿童保健服务统计报表',
                    textStyle:{fontSize: 13},
                    x: 'center'
                },
                tooltip : {
                    trigger: 'axis'
                },
                legend: {
                    data:['A镇人数','B镇人数','C镇人数'],
                    y:'bottom'
                },
                toolbox: {
                    show : true,
                    feature : {
                        mark : {show: false},
                        dataView : {show: true, readOnly: false},
                        magicType : {show: true, type: ['line', 'bar']},
                        restore : {show: true},
                        saveAsImage : {show: true}
                    }
                },
                calculable : true,
                xAxis : [
                    {
                        type : 'category',
                        data : ['新生儿访视数', '苯丙酮尿症', '甲状腺减低症', '听力']
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'A镇人数',
                        type:'bar',
                        data:[chiHelCareA1,chiHelCareA2,chiHelCareA3,chiHelCareA4],
                        markPoint : {
                            data : [
                                {type : 'max', name: '最大值'},
                                {type : 'min', name: '最小值'}
                            ]
                        }
                    },
                    {
                        name:'B镇人数',
                        type:'bar',
                        data:[chiHelCareB1,chiHelCareB2,chiHelCareB3,chiHelCareB4],
                        markPoint:{
                            data:[
                                {type:'max',name:'最大值'},
                                {type:'min',name:'最小值'}
                            ]
                        }
                    },
                    {
                        name:'C镇人数',
                        type:'bar',
                        data:[chiHelCareC1,chiHelCareC2,chiHelCareC3,chiHelCareC4],
                        markPoint:{
                            data:[
                                {type:'max',name:'最大值'},
                                {type:'min',name:'最小值'}
                            ]
                        }
                    }
                ]
            };
            var childHealthcare = document.getElementById('childHealthcare');
            require(
                [
                    'echarts',
                    'echarts/chart/bar',
                    'echarts/chart/line'
                ],
                function (ec) {
                    var myChartChilcar = ec.init(childHealthcare);
                    myChartChilcar.setOption(chiHelEChartOption);
                    window.onresize = myChartChilcar.resize;
                });


        }

        function pregWomenHealthcare(){
            var pregantWomenA1  =getNumVal("pregantWomenA1");
            var pregantWomenA2  =getNumVal("pregantWomenA2");
            var pregantWomenA3  =getNumVal("pregantWomenA3");
            var pregantWomenA4  =getNumVal("pregantWomenA4");
            var pregantWomenA5  =getNumVal("pregantWomenA5");
            var pregantWomenA6  =getNumVal("pregantWomenA6");
            var pregantWomenA7  =getNumVal("pregantWomenA7");
            var pregantWomenA8  =getNumVal("pregantWomenA8");
            var pregantWomenA9  =getNumVal("pregantWomenA9");
            var pregantWomenA10 =getNumVal("pregantWomenA10");
            var pregantWomenA11 =getNumVal("pregantWomenA11");
            var pregantWomenA12 =getNumVal("pregantWomenA12");
            var pregantWomenB1  =getNumVal("pregantWomenB1");
            var pregantWomenB2  =getNumVal("pregantWomenB2");
            var pregantWomenB3  =getNumVal("pregantWomenB3");
            var pregantWomenB4  =getNumVal("pregantWomenB4");
            var pregantWomenB5  =getNumVal("pregantWomenB5");
            var pregantWomenB6  =getNumVal("pregantWomenB6");
            var pregantWomenB7  =getNumVal("pregantWomenB7");
            var pregantWomenB8  =getNumVal("pregantWomenB8");
            var pregantWomenB9  =getNumVal("pregantWomenB9");
            var pregantWomenB10 =getNumVal("pregantWomenB10");
            var pregantWomenB11 =getNumVal("pregantWomenB11");
            var pregantWomenB12 =getNumVal("pregantWomenB12");
            var pregantWomenC1  =getNumVal("pregantWomenC1");
            var pregantWomenC2  =getNumVal("pregantWomenC2");
            var pregantWomenC3  =getNumVal("pregantWomenC3");
            var pregantWomenC4  =getNumVal("pregantWomenC4");
            var pregantWomenC5  =getNumVal("pregantWomenC5");
            var pregantWomenC6  =getNumVal("pregantWomenC6");
            var pregantWomenC7  =getNumVal("pregantWomenC7");
            var pregantWomenC8  =getNumVal("pregantWomenC8");
            var pregantWomenC9  =getNumVal("pregantWomenC9");
            var pregantWomenC10 =getNumVal("pregantWomenC10");
            var pregantWomenC11 =getNumVal("pregantWomenC11");
            var pregantWomenC12 =getNumVal("pregantWomenC12");
            preWoEChartOption = {

                title : {
                    text: '孕产妇保健统计报表',
                    textStyle:{fontSize: 13},
                    x: 'center'
                },
                tooltip : {
                    trigger: 'axis'
                },
                legend: {
                    data:['A镇人数','B镇人数','C镇人数'],
                    y:'bottom'
                },
                toolbox: {
                    show : true,
                    feature : {
                        mark : {show: false},
                        dataView : {show: true, readOnly: false},
                        magicType : {show: true, type: ['line', 'bar']},
                        restore : {show: true},
                        saveAsImage : {show: true}
                    }
                },
                calculable : true,
                xAxis : [
                    {
                        type : 'category',
                        data : ['自然分娩','会阴切开','会阴未切','阴道手术助产','产钳助产','臀位助产','胎头吸引','剖宫产','子宫下端横切口剖宫产','子宫体剖宫产','腹膜外剖宫产','其他']
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'A镇人数',
                        type:'bar',
                        data:[pregantWomenA1,pregantWomenA2,pregantWomenA3,pregantWomenA4,pregantWomenA5,pregantWomenA6,pregantWomenA7,pregantWomenA8,pregantWomenA9,pregantWomenA11,pregantWomenA12],
                        markPoint : {
                            data : [
                                {type : 'max', name: '最大值'},
                                {type : 'min', name: '最小值'}
                            ]
                        }
                    },
                    {
                        name:'B镇人数',
                        type:'bar',
                        data:[pregantWomenB1,pregantWomenB2,pregantWomenB3,pregantWomenB4,pregantWomenB5,pregantWomenB6,pregantWomenB7,pregantWomenB8,pregantWomenB9,pregantWomenB10,pregantWomenB11,pregantWomenB12],
                        markPoint:{
                            data:[
                                {type:'max',name:'最大值'},
                                {type:'min',name:'最小值'}
                            ]
                        }
                    },
                    {
                        name:'C镇人数',
                        type:'bar',
                        data:[pregantWomenC1,pregantWomenC2,pregantWomenC3,pregantWomenC4,pregantWomenC5,pregantWomenC6,pregantWomenC7,pregantWomenC8,pregantWomenC9,pregantWomenC10,pregantWomenC11,pregantWomenC12],
                        markPoint:{
                            data:[
                                {type:'max',name:'最大值'},
                                {type:'min',name:'最小值'}
                            ]
                        }
                    }
                ]
            };
            var pregWomenHealthcare = document.getElementById('pregWomenHealthcare');
            require(
                [
                    'echarts',
                    'echarts/chart/bar',
                    'echarts/chart/line'
                ],
                function (ec) {
                    var myChartPreWo = ec.init(pregWomenHealthcare);
                    myChartPreWo.setOption(preWoEChartOption);
                    window.onresize = myChartPreWo.resize;
                });

        }



        function permaritalExa(){
            var preExaChartA1 =getNumVal("preExaChartA1");
            var preExaChartA2 =getNumVal("preExaChartA2");
            var preExaChartA3 =getNumVal("preExaChartA3");
            var preExaChartA4 =getNumVal("preExaChartA4");
            var preExaChartB1 =getNumVal("preExaChartB1");
            var preExaChartB2 =getNumVal("preExaChartB2");
            var preExaChartB3 =getNumVal("preExaChartB3");
            var preExaChartB4 =getNumVal("preExaChartB4");
            var preExaChartC1 =getNumVal("preExaChartC1");
            var preExaChartC2 =getNumVal("preExaChartC2");
            var preExaChartC3 =getNumVal("preExaChartC3");
            var preExaChartC4 =getNumVal("preExaChartC4");
            preExaEChartOption = {

                title : {
                    text: '男女婚检统计报表',
                    textStyle:{fontSize: 13},
                    x: 'center'
                },
                tooltip : {
                    trigger: 'axis'
                },
                legend: {
                    data:['A镇人数','B镇人数','C镇人数'],
                    y:'bottom'
                },
                toolbox: {
                    show : true,
                    feature : {
                        mark : {show: false},
                        dataView : {show: true, readOnly: false},
                        magicType : {show: true, type: ['line', 'bar']},
                        restore : {show: true},
                        saveAsImage : {show: true}
                    }
                },
                calculable : true,
                xAxis : [
                    {
                        type : 'category',
                        data : ['育龄妇女', '妇女疾病' ,'女性婚检', '男性婚检']
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'A镇人数',
                        type:'bar',
                        data:[preExaChartA1,preExaChartA2,preExaChartA3,preExaChartA4],
                        markPoint : {
                            data : [
                                {type : 'max', name: '最大值'},
                                {type : 'min', name: '最小值'}
                            ]
                        }
                    },
                    {
                        name:'B镇人数',
                        type:'bar',
                        data:[preExaChartB1,preExaChartB2,preExaChartB3,preExaChartB4],
                        markPoint:{
                            data:[
                                {type:'max',name:'最大值'},
                                {type:'min',name:'最小值'}
                            ]
                        }
                    },
                    {
                        name:'C镇人数',
                        type:'bar',
                        data:[preExaChartC1,preExaChartC2,preExaChartC3,preExaChartC4],
                        markPoint:{
                            data:[
                                {type:'max',name:'最大值'},
                                {type:'min',name:'最小值'}
                            ]
                        }
                    }
                ]
            };
            var permaritalExa = document.getElementById('permaritalExa');
            require(
                [
                    'echarts',
                    'echarts/chart/bar',
                    'echarts/chart/line'
                ],
                function (ec) {
                    var myChartPer = ec.init(permaritalExa);
                    myChartPer.setOption(preExaEChartOption);
                    window.onresize = myChartPer.resize;
                });
        }



        function getNumVal(inputVal) {
            var val = $("#" + inputVal).val();
            if (isNaN(val)) {
                return 0;
            }
            return parseInt(val);
        }

        return {
            load: load
        }
    });
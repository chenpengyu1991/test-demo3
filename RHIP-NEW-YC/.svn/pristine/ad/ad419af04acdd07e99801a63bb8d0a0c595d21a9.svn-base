var trendSearch = (function() {

        var validate=null;

    $(function() {
        /*$("#targetSearchForm").onEnter(refreshChart);*/
                $("#idmBtnSearch").click(function(e) {
                	e.preventDefault();
                    refreshChart();
                });
                initForm();
            });

        /**
         * 传染病,按分类,按名称查询
         */
        function changeInfectious(type){debugger;
            $('#searchType').val('');
            $("#searchInfectiousCode option").remove();
            if(type == '1'){
                $('#searchType').show();
            }else{
                $('#searchType').hide();
            }
            querySearchInfection();
        }

        /**
         * 查询传染病
         * type:1 按分类查询
         * type:2 按名称查询
         */
        function querySearchInfection() {
            var infectiousType = $('input[name="infectiousType"]:checked').val();debugger;
            var infectionType;
            if(infectiousType !='2'){//按名称
                infectionType = $('#searchType').val();
                if(infectionType == 'L'){
                    $("#searchInfectiousCode").hide();
                    return;
                }

            }/*else{//按分类
                $("#searchInfectiousCode").hide();
            }*/
            //默认为J甲乙丙
            infectionType = $.isEmpty(infectionType)?"J":infectionType;
            $("#searchInfectiousCode option").remove();
            $.getJsonByUrl({
                url : "/idm/report/queryInfections",
                param : {type:'IDM00400'+infectionType},
                wait:true,
                callback : function(data) {

					/*将KEY放入数组，数组排序后，通过遍历数组，排序输出*/
                    var keyArr = [];
                    $.each(data, function(key, val){
                        keyArr[keyArr.length] = key;
                    });
                    keyArr.sort();
                    $.each(keyArr, function(i, key){
                        $("#searchInfectiousCode").append('<option value="'+ key +'">' + data[key] + '</option>');
                    });
                    $("#searchInfectiousCode").show();
                }
            });
        };

        function refreshChart(){
            document.getElementById("idm_trend_chart").style.height='500px';
            document.getElementById("idm_trend_chart").style.width='1050px';
            validate = $("#targetSearchForm").easyValidate();
            var result=validate.validateForm();
            if(!result){
                return;
            }
            changeOrgType();
            var genreCode = $('#genreCode').val();
            var gbCode = $('#gbCode').val();
            var superOrganCode = $('#superOrganCode').val();
            var organCode = $('#organCode').val();

            var gbName = $('#gbName').val();
            var superOrganName = $('#superOrganName').val();
            var organName = $('#organName').val();

            var yearDate = $('#yearDate').val();
            var infectiousCode = $('#searchInfectiousCode').val();
            if($.isEmpty(infectiousCode)){
                infectiousCode = '102';
            }
            $.getJsonByUrl({
                url : "/ihm/idm/trend/data",
                wait:true,
                param:{
                    genreCode:genreCode,
                    organCode:organCode,
                    superOrganCode:superOrganCode,
                    gbCode:gbCode,
                    yearDate:yearDate,
                    infectiousCode:infectiousCode
                },
                callback : callback
            });
        }

        function callback(data){
            /**
             * 图表中显示机构名称
             */
            var genreName = $('#genreCode').find("option:selected").text();
            var  orgName = $('#gbName').val() +  $('#superOrganName').val() + $('#organName').val();
            if($.isEmpty(orgName)){
                orgName = genreName + "统计  ";
            }
            var infectiousName = $("#searchInfectiousCode").find("option:selected").text();
            if($.isEmpty(infectiousName)){
                infectiousName = '霍乱';
            }
            var trendDataArray = new Array();
            var monthArray = new Array();

            for(var i=0; i<data.length; i++){
                var trend = data[i][1];

                if(trend == undefined){
                    break;
                }
                trendDataArray.push(trend);

                monthArray.push(formatDate(new Date(data[i][0])) + "月");

            }

            outAndHosEChartOption = {
                title : {
                    text: '传染病疫情趋势分析',
                    subtext: orgName  + "  " + infectiousName + '上报数',
                    textStyle:{fontSize: 15},
                    x :	'center'
                },
                tooltip : {
                    trigger: 'axis'
                },
                legend: {
                    data:['报卡数'],
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
                        data : monthArray
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'报卡数',
                        type:'bar',
                        data:trendDataArray,
                        markPoint : {
                            data : [
                                {type : 'max', name: '最大值'},
                                {type : 'min', name: '最小值'}
                            ]
                        },
                        markLine : {
                            data : [
                                {type : 'average', name: '平均值'}
                            ]
                        }
                    }
                ]
            };
            if ($.isEmpty(trendDataArray) || trendDataArray.length == 0) {
                $("#idm_trend_chart").text("无相关数据！");
                return;
            }
            var idm_trend_chart = document.getElementById('idm_trend_chart');

            var myChart = echarts.init(idm_trend_chart);
            myChart.setOption(outAndHosEChartOption);
            window.onresize = myChart.resize;
        }

        function formatDate(date) {
            if (date) {
                return date.pattern("yyyy/MM");
            }
            return "";
        }
        function initForm(){
            $('#centre1').on("change",function(){
                $('#superOrganCode').val(this.value);
            });
            $('#town1').on("change",function(){
                $('#gbCode').val(this.value);
            });
            $('#centre2').on("change",function(){
                $('#superOrganCode').val(this.value);
            });
            $('#town2').on("change",function(){
                $('#gbCode').val(this.value);
            });
            $('#station2').on("change",function(){
                $('#organCode').val(this.value);
            });
            $('#genreCode').on("change",function(){
                changeOrgType();
            });
            changeOrgType();
            querySearchInfection();

        }
        function changeOrgType(){
            var genreCode = $('#genreCode').val();
            if(genreCode == 'A1'){
                $('#byHospital').show();
                $('#byCentre').hide();
                $('#byTown').hide();
                getCurrentOrgCode(0);
            }else if(genreCode == 'B1'){
                $('#byHospital').hide();
                $('#byCentre').show();
                $('#byTown').hide();
                getCurrentOrgCode(1);
            }else if(genreCode == '0'){
                $('#byHospital').hide();
                $('#byCentre').hide();
                $('#byTown').show();
                getCurrentOrgCode(3);
            }
        }
        function getCurrentOrgCode(index){
            $('#gbCode').val($('#town' + index).val());
            if(!$.isEmpty($('#town' + index).val())){
                $('#gbName').val($('#town' + index).find("option:selected").text() + "  ");
            }else{
                $('#gbName').val("");
            }
            if(index==0){
                $('#superOrganCode').val($('#organCode' + index).val());
                if(!$.isEmpty($('#organCode' + index).val())){
                    $('#superOrganName').val($('#organCode' + index).find("option:selected").text()+ "  ");
                }else{
                    $('#superOrganName').val("");
                }
            }else if(index != 3){
                $('#superOrganCode').val($('#centre' + index).val());
                $('#organCode').val($('#station' + index).val());
                if(!$.isEmpty($('#centre' + index).val())){
                    $('#superOrganName').val($('#centre' + index).find("option:selected").text()+ "  ");
                }else{
                    $('#superOrganName').val("");
                }
                if(!$.isEmpty($('#station' + index).val())){
                    $('#organName').val($('#station' + index).find("option:selected").text()+ "  ");
                }else{
                    $('#organName').val("");
                }
            }else{
                $('#superOrganCode').val("");
                $('#organCode').val("");
                $('#superOrganName').val("");
                $('#organName').val("");
            }
        }
        return {
            load: load,
            changeInfectious:changeInfectious,
            querySearchInfection:querySearchInfection
        };
})();


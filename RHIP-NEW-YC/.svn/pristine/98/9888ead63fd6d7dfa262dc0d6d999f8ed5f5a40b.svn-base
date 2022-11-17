/**
 * Created by wang_zhou on 2015/6/17.
 */
var doubleVis = (function(){
    var loadingImg = "<span><img src='" + contextPath + "/images/AjaxLoader16.gif' style='vertical-align:top;'/></span>";
    $(function() {
        $("#doubleVisOutChart").append(loadingImg);
        getDoubleVisData();
        $("input[name=RadioGroup5]").on("click",function(){
            $("#doubleVisOutChart").empty();
            $("#doubleVisInChart").empty();
            $("#doubleVisOutChart").append(loadingImg);
            getDoubleVisData();
        });
    });

    function getDoubleVisData(){
        var statisticsDate =$("input[name=RadioGroup5]:checked").val();
        $.getJsonByUrl({
            url : "/ihm/doublevis/getDoubleVisChart",
            param : {'statisticsDate' : statisticsDate},
            checkRepeat : true,
            callback : function(data) {
                $(loadingImg).remove();
                doubleVisOut(data);
                doubleVisIn(data);
            }
        });
    }
    function doubleVisOut(data) {
        var str = [];
        var total = 0;
        for(var i =0; i < data.length; i++) {
            var obj = {};
            obj["name"] = data[i]['orgName'];
            obj["y"] = data[i]['outTransfer'];
            //total += data[i]['hrArchiveNew'];
            str.push(obj);
        }
        //$("#totalRecord").html(total);
        var chartOut = new Highcharts.Chart({
            chart: {
                renderTo: 'doubleVisOutChart',
                defaultSeriesType: 'pie',
                marginLeft:180,
                height:400
            },
            title : {
                text : '双向转诊转出统计'
            },
            xAxis: {
                categories: []
            },
            yAxis: {
            },
            exporting : {
                enabled : false
            },
            credits : {
                enabled : false
            },
            legend: {
                layout: 'vertical',
                floating: true,
                backgroundColor: '#FFFFFF',
                align: 'left',
                verticalAlign: 'top',
                y: 60,
                x: -600
            },
            tooltip: {
                formatter: function() {
                    return '<b>'+ this.series.name +'</b><br/>'+
                        this.point.name + '：' + this.y;
                }
            },
            plotOptions:{
                pie:{
                    allowPointSelect:true,
                    cursor:'pointer',
                    dataLabels:{
                        enabled:true,
                        color:'#000000',
                        connectorColor:'#000000',
                        formatter:function(){
                            return'<b>'+this.point.name+'</b>: '+this.y + '次(' + Math.round(this.percentage)+' %)';
                        }
                    }
                }
            },
            series: [{
                data: str,
                name : '转出数'
            }]
        });
    }

    function doubleVisIn(data) {
        var str = [];
        var total = 0;
        for(var i =0; i < data.length; i++) {
            var obj = {};
            obj["name"] = data[i]['orgName'];
            obj["y"] = data[i]['inTransfer'];
            //total += data[i]['hrArchiveNew'];
            str.push(obj);
        }
        //$("#totalRecord").html(total);
        var chartIn = new Highcharts.Chart({
            chart: {
                renderTo: 'doubleVisInChart',
                defaultSeriesType: 'pie',
                marginLeft:180,
                height:400
            },
            title : {
                text : '双向转诊转入统计'
            },
            xAxis: {
                categories: []
            },
            yAxis: {
            },
            exporting : {
                enabled : false
            },
            credits : {
                enabled : false
            },
            legend: {
                layout: 'vertical',
                floating: true,
                backgroundColor: '#FFFFFF',
                align: 'right',
                verticalAlign: 'top',
                y: 60,
                x: -600
            },
            tooltip: {
                formatter: function() {
                    return '<b>'+ this.series.name +'</b><br/>'+
                        this.point.name + '：' + this.y;
                }
            },
            plotOptions:{
                pie:{
                    allowPointSelect:true,
                    cursor:'pointer',
                    dataLabels:{
                        enabled:true,
                        color:'#000000',
                        connectorColor:'#000000',
                        formatter:function(){
                            return'<b>'+this.point.name+'</b>: '+this.y + '次(' + Math.round(this.percentage)+' %)';
                        }
                    }
                }
            },
            series: [{
                data: str,
                name : '回转数'
            }]
        });
    }

    // inArray的jQuery源码
    inArray = function( elem, array ) {
        var rtn = null;
        $.each(array,function(key,value){
            if(key == elem) {
                rtn = value;
                return true;
            }
        });
        return rtn;
    };

    buildArchiveTable = function(value) {
        if(value) {
            return "<td>" + value + "</td>";
        }
        else {
            return "<td>0</td>";
        }
    };
    
    function viewDualReferralDetail() {
    	$("#mainContent").hide();
    	$("#dualReferralList").show();
    	var options = {
                url: contextPath + "/ihm/doublevis/searchData",
                insertDiv: "dualReferralList"
            };
            $.loadHtmlByUrl(options);
    }
    
    return {
    	viewDualReferralDetail:viewDualReferralDetail
    }

})();
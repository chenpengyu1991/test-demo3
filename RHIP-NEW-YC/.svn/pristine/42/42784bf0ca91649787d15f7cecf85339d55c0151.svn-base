var sputum = (function() {
	$(function() {
	});

	function initSputum(singleId, thisDt, thisType, logoff) {
//		$("#top_all").hide();
//		var pageIndex = $("#currentPage" + tbType).val();
//		$.loadHtmlByUrl({
//			url : "/idm/tb/management/sputum",
//			insertDiv :"temp",
//			param : {
//				singleId: 857,
//				pageIndex: 1
//			}
//		});
//		$("#detailDiv").show();
        $("#top_allStandardization").hide();
        var pageIndex = $("#currentPageStandardization").val();
        $.loadHtmlByUrl({
            url : "/idm/tb/management/sputum",
            insertDiv :"detailDivStandardization",
//            wait : true,
            param : {
                singleId: singleId,
                thisDtStr:thisDt,
                thisType:thisType,
                logoff: logoff,
                pageIndex: pageIndex
            }
        });
        $("#detailDivStandardization").show();
	};

    //得到n天后的日期，并格式化为yyyy/MM/dd
    function getDate(n, thisDate)
    {
        var uom = new Date(thisDate.substring(0,4),thisDate.substring(5,7),thisDate.substring(8,10));
        uom.setDate(uom.getDate()+n);
        var month = (uom.getMonth()+1);
        if(month < 10){
            month = '0'+month;
        }
        var day = uom.getDate()
        if(day < 10){
            day = '0'+day;
        }
        uom = uom.getFullYear() + "/" + month + "/" + day;
        return uom;
    }

    //thisType  初治:1, 复发:2
    //checkResult 阴性:2, 阳性:3
    function selectRows(thisType,radioBtn,rm){
        if('rm' == rm){
            $("#sputumTable tr").each(function(trindex,tritem){
                if(trindex > 0 && $(this).attr("rm")=='rm'){
                   $(this).remove();
                }
            });
        }
        var checkResult = $(radioBtn).val();
        //初治+2月末结果阴性 256
        if(checkResult == 2 && thisType == 1){
            $("#5").show();
            $("#6").show();
            $("#3").hide();
            $("#8").hide();

            $("#5").attr("flag",1);
            $("#6").attr("flag",1);
            $("#3").attr("flag",0);
            $("#8").attr("flag",0);
        }
        //初治+2月末结果阳性 2356
        if(checkResult == 3 && thisType == 1){
            $("#3").show();
            $("#5").show();
            $("#6").show();
            $("#8").hide();

            $("#3").attr("flag",1);
            $("#5").attr("flag",1);
            $("#6").attr("flag",1);
            $("#8").attr("flag",0);
        }
        //复治+2月末结果阴性 258
        if(checkResult == 2 && thisType == 99){
            $("#5").show();
            $("#8").show();
            $("#3").hide();
            $("#6").hide();

            $("#5").attr("flag",1);
            $("#8").attr("flag",1);
            $("#3").attr("flag",0);
            $("#6").attr("flag",0);
        }
        //复治+2月末结果阳性 2358
        if(checkResult == 3 && thisType == 99){
            $("#3").show();
            $("#5").show();
            $("#8").show();
            $("#6").hide();

            $("#3").attr("flag",1);
            $("#5").attr("flag",1);
            $("#8").attr("flag",1);
            $("#6").attr("flag",0);
        }
    }

    function saveSputum(singleId){
        var tbData = getTableData();

        var sputumJson = util.Obj2str(tbData);
        $("#sputumForm").submitFormGetJson({
            url : "/idm/tb/management/saveSputum",
            wait : true,
            param:{
                singleId:singleId ,
                sputumJson:sputumJson
            },
            callback : function(data) {
                if (data.indexOf("fail") > -1) {
                    layer.alert("预约查痰保存失败！", {icon:0,title:'提示'});
                }else {
                    layer.alert("预约查痰保存成功！", {icon:0,title:'提示'});
//                    standardization.search(1);
                    standardization.searchTemp();
                    $("#detailDivStandardization").hide();
                    $("#listDivStandardization").show();
                    return false;
                }
            }
        });
    }

    function getTableData(){
        var tableData = [];

        $("#sputumTable tr").each(function(trindex,tritem){
            var fValue;
            var trId = $(this).attr("id");
            if(trindex > 0){
                var trData = {};
                trData["monthSeq"] = trId;
                $(tritem).find("td").each(function(tdindex,tditem){
                    if(tdindex == 0){
                        trData["sputumDt"] = $(tditem).text();
                    }if(tdindex == 1){
                        fValue =  $($(this).find("input")[0]).prop("value");
                        if(!$.isEmpty(fValue)){
                            trData["inspectDt"] = fValue;
                        }
                        fValue =  $($(this).find("input")[1]).prop("value");
                        if(!$.isEmpty(fValue)){
                            trData["id"] = fValue;
                        }
                        fValue =  $($(this).find("input")[2]).prop("value");
                        if(!$.isEmpty(fValue)){
                            trData["createUnit"] = fValue;
                        }
                        fValue =  $($(this).find("input")[3]).prop("value");
                        if(!$.isEmpty(fValue)){
                            trData["createDt"] = fValue;
                        }
                        fValue =  $($(this).find("input")[4]).prop("value");
                        if(!$.isEmpty(fValue)){
                            trData["createUser"] = fValue;
                        }
                    }if(tdindex == 2){
                        fValue =  $($(this).find("input")[0]).prop("value");
                        if(!$.isEmpty(fValue)){
                            trData["delayDays"] = fValue;
                        }
                    }if(tdindex == 3){
                        fValue = $("input[name='"+"sputumResult"+trId+"']:checked").val();
                        if(!$.isEmpty(fValue)){
                            trData["sputumResult"] = fValue;
                        }
                    }
                });
                tableData.push(trData);
            }
        });
        return tableData;
    }

    function getDelayDays(dateSelect, row){
        var selectedTr = $(dateSelect).closest("tr");
        var date2Temp = ($(selectedTr).find('[field="sputumDt"]')[0]);
        var delayDaysTemp = ($(selectedTr).find('[name="delayDays"]')[0]);
        var date2 = $(date2Temp).text();

        var date1 = $(dateSelect).val();
        if(!$.isEmpty(date2)){
            var delayDays = dateDiff(date1, date2);
//            $("#delayDays" + row).val(delayDays);
            if(delayDays-7>0){
            	$(delayDaysTemp).val(delayDays-7);
            }else{
            	$(delayDaysTemp).val(0);
            }
            
        }
        if($.isEmpty(date1)){
           $(delayDaysTemp).val(0);
        }
    }

    function  dateDiff(sDate1,  sDate2){    //sDate1和sDate2是yyyy/mm/dd格式
        var  aDate,  oDate1,  oDate2,  iDays
//        oDate1  =  new  Date(sDate1.substring(5,7) + '-' + sDate1.substring(8,10) + '-' + sDate1.substring(0,4))  //dd/mm/yyyy
//        oDate2  =  new  Date(sDate2.substring(5,7) + '-' + sDate2.substring(8,10) + '-' + sDate2.substring(0,4))
        oDate1  =  new  Date(sDate1);
        oDate2  =  new  Date(sDate2);
        iDays  =  parseInt((oDate1  -  oDate2)  /  1000  /  60  /  60  /24)    //把相差的毫秒数转换为天数
        return  iDays;
    }

	return {
        initSputum: initSputum,
        selectRows:selectRows,
        getTableData:getTableData,
        saveSputum:saveSputum,
        getDelayDays:getDelayDays
	};
})();

/**
 * 一体机记录查询
 */
var yishareSearch = (function() {

	$(function () {
        searchytj(1);
	});


    function searchytj(pageIndex){
    	var idcard =$("#idcard").val();
    	var module =$("#module").val();//模块来源tj:健康档案体检 cdm:慢病随访
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var searchObj = {
            url : "/cdm/standardization/followup/yshare/list",
            insertDiv : 'ysharelist',
            param : {pageIndex:pageIndex,idcard:idcard,module:module},
            callback : function(data) {
                $("#pageIndex").val(pageIndex);
            }
        };
        $("#yshareForm").submitFormLoadHtml(searchObj);
	}

	function select(height,weight,sbp,dbp,fetalheart,glu,anal,memo1,temp,pulse,
                    cho,breath,tg,hdl,ldl,ncgBlo,ncgPro,ncgKet,ncgGlu,ncgBil,ncgLeu){
	    var module = $("#module").val();
	    var memo1_0 ="0";//空腹血糖标记
        if('tj'==module){//建档档案体检页
            //清空血糖,血压异常提示
            $("#healthAbnormal").val("");
            //清空体重异常异常提示
            $("#healthAbnormal1").val("");
            $("#personHeightId").val(height);
            $("#personWeightId").val(weight);
            $("#leftBloodUp").val(sbp);
            $("#leftBloodDown").val(dbp);
            $("#rightBloodUp").val(sbp);
            $("#rightBloodDown").val(dbp);
            $("#leftBloodUp").blur();
            $("#leftBloodDown").blur();
            if(sbp!='')
                $("#bloodPressureSource input[data-label='体检车']").attr("checked","checked");
            //心率
            $("#heartRate").val(fetalheart);
            $("#personWeightId").blur();
            //空腹血糖
            $("#bloodGlucoseLeft").val(glu);
            if(memo1_0 == memo1||"" == memo1||undefined == memo1) {//标记0或空为空腹血糖
                $("#bloodGlucoseLeft").val(glu);
                if(glu!='')
                    $("#bloodSugarSource input[data-label='体检车']").attr("checked","checked");
            }
            $("#bloodGlucoseLeft").blur();
            //心电图
            $("#ecgAnomalyDesc").val(anal);
            //体温
            $("#temp").val(temp);
            $("#temperature").val(temp);
            //脉率
            $("#pulseRate").val(pulse);
            //总胆固醇
            $("#cho").val(cho);
            $("#tc").val(cho);
            //呼吸频率
            $("#breath").val(breath);
            $("#respiratoryRate").val(breath);
            //甘油三酯
            $("#tg").val(tg);
            $("#triglycerideValue").val(tg);
            //高密度脂蛋白
            $("#hdl").val(hdl);
            $("#hdlcDetectValue").val(hdl);
            //低密度脂蛋白
            $("#ldl").val(ldl);
            $("#ldlcDetectValue").val(ldl);
            //隐血（潜血）
            if(ncgBlo!="-"){
            $("#ncgBlo").val(ncgBlo);
            }
            //尿蛋白
            $("#ncgPro").val(ncgPro);
            $("#urineProQuantitativeValue").val(ncgPro);
            
            //酮体
            $("#ncgKet").val(ncgKet);
            $("#ketQuantitativeValue").val(ncgKet);
            //尿糖
            if(ncgGlu!="-"){
            	$("#ncgGlu").val(ncgGlu);
                $("#urineSugQuantitativeValue").val(ncgGlu);
            }
            //胆红素
            if(ncgBil!="-"){
            	$("#ncgBil").val(ncgBil);
                $("#conjugatedBilirubin").val(ncgBil);
            }
            //白细胞
            if(ncgLeu!="-"){
            	$("#ncgLeu").val(ncgLeu);
                $("#leukocyteCount").val(ncgLeu);
            }
            
        }
        else{//慢病随访
            $("#height").val(height);
            $("#bodyWeight").val(weight);
            $("#hbpSbp").val(sbp);
            $("#hbpDbp").val(dbp);
            $("#heartRate").val(fetalheart);
            $("#bodyWeight").blur();
            //脑卒中
            $("input[name='bpExamFlag'][value='1']").attr("checked",true);
            $("input[name='bpExamFlag'][value='1']").click();
            $("#sbp").val(sbp);
            $("#dbp").val(dbp);
            $("input[name='bloodGlucoseFalg'][value='1']").attr("checked",true);
            $("input[name='bloodGlucoseFalg'][value='1']").click();
            //血糖
            $("#fpg").val("");
            $("#gluValue").val("");
            if(memo1 ==""||memo1 == memo1_0) //标记0或空为空腹血糖
                $("#fpg").val(glu);
            else
                $("#gluValue").val(glu);
            //心电图
            $("#ecg").val(anal);
        }
        var layer = layui.layer;
        layer.closeAll();
    }

    return {
        select:select,
        searchytj : searchytj
    }
})();
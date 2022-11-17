var prescriptionCost = (function() {
	$(function() {
		$("#btnSearch").click(function(e) {
			e.preventDefault();
			initEchart();
		});
		initEchart();
        initForm();
        init();
	});
	function init(){
        //机构下拉树设置
        var option={
            url:"/mdmOrganization/organationTree",
            unSelecteType:['0']  //不能选择：0是镇，B1是中心
        };
        //机构自动检索设置
        var opb = {
            url:"/mdmOrganization/organationSelect",
            feild: {
                value: "organCode",
                lable: "organName"
            },
            param:{organType:"A1,B1,B2"}  //只查询B1（即所有站）
        };
        var hospitalCode=$("#hospitalCode");
        if(hospitalCode.length>0){
            //初始化自动检索
            hospitalCode.selectBox(opb);
            //初始化下拉树
            hospitalCode.initTreeSelect(option);
        }
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
        $('#rangeType').on("change",function(){
            changeRangeType();
        });
        changeOrgType();
        changeRangeType();
    }

	function initEchart() {
		$('#nodata').hide();
		$('#resultDiv').show();
		changeOrgType();
		changeRangeType();
		var genreCode = $('#genreCode').val();
		var town = $('#town2').val();
		if("B2" == genreCode && $.isEmpty(town)){
			layer.alert("请选择镇！", {icon:0,title:'提示'});
			return;
		}
			// 基于准备好的dom，初始化echarts图表
			var chartEle = document.getElementById('resultDiv');
			var echartsObj = echarts.init(chartEle, 'shine');
			echartsObj.showLoading({
				text: '数据获取中',
				effect: 'whirling'
			});
			var postData = $('#targetSearchForm').serializeObject();
			var params = {
				"url" : '/ihm/prescription/prescriptionCost/chart',
				"callback" : function(result){
					//取消载入提示
					echartsObj.hideLoading();
					if($.isEmpty(result.xAxisJSON)){
						$('#nodata').show();
						$('#resultDiv').hide();
						return;
					}else{
						$('#nodata').hide();
						$('#resultDiv').show();
					}
					$('#orgCodes').val(result.orgCodes);
					var option = chartFun2.getYcategoryOption(result);
					echartsObj.setOption(option, true);
					$(echartsObj).resize();
					initChartEvent(echartsObj,result.genreCode,result.beginDt,result.endDt);
				},
				"param" :postData
			};
			$.getJsonByUrl(params);
	}

	function initChartEvent(chartObj,genreCode,beginDt,endDt){
		chartObj.on('click', function (params) {
			if (params.componentType == 'series' && params.value != 0) {
				showDetail(params.dataIndex,genreCode,beginDt,endDt);
			}
		});
	}

	function showDetail(dataIndex,genreCode,beginDt,endDt){
		var orgCodeArray = $('#orgCodes').val().split(',');
		var orgCode = orgCodeArray[dataIndex];

		$("#top_all").hide();
		$.loadHtmlByUrl({
			url : "/ihm/prescription/detail/search",
			insertDiv :"prescriptionDetailDiv",
			param : {
				orgCode:orgCode,
				genreCode:genreCode,
				beginDt:beginDt,
				endDt:endDt},
			wait:true
		});
		$("#prescriptionDetailDiv").show();
	}

    function changeRangeType(){
        var yearType = $('input[name="yearType"]:checked').val();
        if($.isEmpty(yearType)){
            $('input[name="yearType"]:eq(0)').attr("checked",'checked');
        }
        var rangeType = $('#rangeType').val();
        if(rangeType == '1'){
            $('#byMonth').show();
            $('#byQuarter').hide();
            $('#byYear').hide();
            $('#byRange').hide();
        }else if(rangeType == '2'){
            $('#byMonth').hide();
            $('#byQuarter').show();
            $('#byYear').hide();
            $('#byRange').hide();
        }else if(rangeType == '3'){
            $('#byMonth').hide();
            $('#byQuarter').hide();
            $('#byYear').show();
            $('#byRange').hide();
        }else if(rangeType == '4'){
            $('#byMonth').hide();
            $('#byQuarter').hide();
            $('#byYear').hide();
            $('#byRange').show();
            $('#beginDate').val($('#beginDate4').val());
            $('#endDate').val($('#endDate4').val());
        }
    }
    function changeOrgType(){
        var genreCode = $('#genreCode').val();
        if(genreCode == 'A1'){
            $('#byHospital').show();
            $('#byCentre').hide();
            $('#byStation').hide();
            $('#byTown').hide();
            getCurrentOrgCode(0);
        }else if(genreCode == 'B1'){
            $('#byHospital').hide();
            $('#byCentre').show();
            $('#byStation').hide();
            $('#byTown').hide();
            getCurrentOrgCode(1);
        }else if(genreCode == 'B2'){
            $('#byHospital').hide();
            $('#byCentre').hide();
            $('#byStation').show();
            $('#byTown').hide();
            getCurrentOrgCode(2);
        }else if(genreCode == '0'){
            $('#byHospital').hide();
            $('#byCentre').hide();
            $('#byStation').hide();
            $('#byTown').show();
            getCurrentOrgCode(3);
        }else if(genreCode == '46714114-9'){
            $('#byHospital').hide();
            $('#byCentre').hide();
            $('#byStation').hide();
            $('#byTown').hide();
            getCurrentOrgCode(3);
        }
    }

    function getCurrentOrgCode(index){
        $('#gbCode').val($('#town' + index).val());
        if(index==0){
            $('#superOrganCode').val($('#organCode' + index).val());
        }else if(index == '46714114-9'){
            $('#superOrganCode').val($('#genreCode').val());
            $('#genreCode').val('R2');
        }else if(index != 3){
            $('#superOrganCode').val($('#centre' + index).val());
            $('#organCode').val($('#station' + index).val());
        }else{
            $('#superOrganCode').val("");
            $('#organCode').val("");
        }
    }	
	return {
		
	};
})();
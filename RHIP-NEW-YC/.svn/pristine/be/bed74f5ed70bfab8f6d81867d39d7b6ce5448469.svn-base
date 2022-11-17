//预防接种首页查询
var mainPageH = (function() {
    $(function(){
        $("#form_search").onEnter(recordsPerform, 1);
        $("#vaccineRecordsSearch").click(function(e){
            e.preventDefault();
            recordsPerform(1);
        });
        recordsPerform(1);
        // 点击新增按钮
        $("#vaccineRecordsAdd").click(function() {
            addVaccineDetailsHtml();
        });

        $("#btnExport").click(function() {
            var option={
                url : "/vaccinehome/excel"
            };
            $("#form_search").exportListExcel(option);
        });
		$("#perAdvanceSearchConditionBtn").click(function(e) {
	            e.preventDefault();
	            controlAdvanceSearchSection($(this));
	        });
        initDate();
    });

	function initDate() {
        layui.use('laydate', function(){
            var laydate = layui.laydate;

            //执行一个laydate实例
            laydate.render({
                elem: '#createBeginDate'
                ,format: 'yyyy/MM/dd'
                ,max:0
            });

            //执行一个laydate实例
            laydate.render({
                elem: '#createEndDate'
                ,format: 'yyyy/MM/dd'
                ,max:0
            });
        });
    }
	// 显示查询结果
	function recordsPerform(indexPage) {
		var createBegin = new Date($("#createBeginDate").val());
		var createEnd = new Date($("#createEndDate").val());

		if (createBegin > createEnd) {
			layui.use('layer', function() {
    			var layer = layui.layer;
    			layer.alert("接种开始时间不能大于接种结束时间！", {icon:0,title:'提示'});
       		});
		} else {
			var searchObj = {
				url : "/vaccinehome/list",
				insertDiv : "recordsGrid",
				param : {
					indexPage : indexPage
				}
			};
			$("#form_search").submitFormLoadHtml(searchObj);
		}
	}

    //新增预防接种
	function addVaccineDetailsHtml() {
        $.post(contextPath+'/ph/hospital/records/add',
            function(ret){
                layui.use(['layer'], function() {
                    var layer = layui.layer
                    layer.open({
                        type: 1,
                        id:'addDialogChoose',
                        area: ['350px', '300px'],
                        title:'新增个人预防接种信息',
                        content: ret
                    });
                });
            }
		);
	}
	function factoryAutoComplete(query,isM) {
		var url = "/ph/hospital/records/factory";
		if(isM!=undefined)
			url+="/true";
		else
			url+="/false";
		$.getJsonByUrl({
			url : url,
			param : {
			
			},
			callback : function(data) {
				var $drugInput = $(query);
				$drugInput.autocomplete(data, {
					minChars : 0,
					width : 250,
					max : 100,
					autoFill : false,
					matchContains : true,
					formatItem : function(row, i, max) {
						return row.itemName;
					},
					formatMatch : function(row, i, max) {
						return row.itemName;
					},
					formatResult : function(row) {
						return row.itemName;
					}
				});
			}
		});
	}
	
	/**
	 * 隐藏、显示地址
	 * houseHoldType:是否流动人口
	 */
    function toggerAddress(){
    	var houseHoldType=$('input[name="VaccinationDetailsDTO.vaccinationMgmt.householdType"]:checked').val();
        if(houseHoldType=="1"){
	 		$("#village_address").attr("disabled", "disabled");
            $("#town_address").attr("disabled", "disabled");
            $('#text_pahouseNumber').attr({'style':'width:90%'});        	
        }else{
            $("#village_address").removeAttr("disabled");
            $('#town_address').removeAttr("disabled");
            $('#text_pahouseNumber').attr({"style":"width:180px"});
            $('input[name="VaccinationDetailsDTO.vaccinationMgmt.householdType"]:eq(1)').attr("checked",'checked');
        }
        toggleOther('VaccinationDetailsDTO.vaccinationMgmt.householdType','village_address','2');
        toggleOther('VaccinationDetailsDTO.vaccinationMgmt.householdType','town_address','2');
    }
    
    function showVaccineFlag(immType) {
    	if (immType == '4') {
    		$("#vaccineFlagLabel").attr("class","coltext");
    		$("#vaccineFlagLabel").text("是否接种");
    		$("#vaccineFlagValue").attr("class","colinput");
    		$("#vaccineFlagValue").html('<select name="pneumoniaVaccFlag"><option value="">请选择</option><option value="1">是</option><option value="0">否</option></select>');
    	} else {
    		$("#vaccineFlagLabel").attr("class","");
    		$("#vaccineFlagLabel").text("");
    		$("#vaccineFlagValue").attr("class","");
    		$("#vaccineFlagValue").html('');
    	}
    }
    
	return {
		search : recordsPerform,
        factoryAutoComplete:factoryAutoComplete,
        toggerAddress:toggerAddress,
        showVaccineFlag:showVaccineFlag
	};
})();


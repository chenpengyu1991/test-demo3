var statisticsSearch = (function() {
	var url = "/hm/yz/outpatientList";
	var validate = null;
	$(function() {
		// $("#beginDate").val(util.getNowDateFormate(new Date(),true));
        // $("#endDate").val(util.getNowDateFormate(new Date()));
        validate = $("#statisticsSearchForm").easyValidate();
        /* 统计查询 */
        $("#statisticsBtnSearch").click(function (e) {
        	e.preventDefault();
            search(1);
        });
        search(1);
        $("#statisticsBtnSearch").onEnter(search, 1);
        document.onkeydown = function (e) {
            var theEvent = window.event || e;
            var code = theEvent.keyCode || theEvent.which;
            if (code == 13) {
                search(1);
            } else if ((code == 73) && (event.shiftKey)) {
                if (!$("#import").is(":hidden")) {
                    $("#import").hide();
                    // isImportShow = false;
                } else {
                    $("#import").show();
                }

            }
        };

        // $("#context").change(selContextChanged);
        // util.checkBoxAll("reportChk","reportChkRef");
        $("#import").click(function () {
            importHistoryData();
        });
        initForm();
	})
	/*function load() {
        // $("#beginDate").val(util.getNowDateFormate(new Date(),true));
        // $("#endDate").val(util.getNowDateFormate(new Date()));
        validate = $("#statisticsSearchForm").easyValidate();
         统计查询 
        $("#statisticsBtnSearch").click(function () {
            search(1);
        });
        search(1);
        $("#statisticsBtnSearch").onEnter(search, 1);
        document.onkeydown = function (e) {
            var theEvent = window.event || e;
            var code = theEvent.keyCode || theEvent.which;
            if (code == 13) {
                search(1);
            } else if ((code == 73) && (event.shiftKey)) {
                if (!$("#import").is(":hidden")) {
                    $("#import").hide();
                    // isImportShow = false;
                } else {
                    $("#import").show();
                }

            }
        };

        // $("#context").change(selContextChanged);
        // util.checkBoxAll("reportChk","reportChkRef");
        $("#import").click(function () {
            importHistoryData();
        });
        initForm();
    }*/

	function importHistoryData() {
		var rs = validate.validateForm();
		if (rs) {
			layui.use('layer', function(){
				var layer = layui.layer;
				layer.confirm("确认导入?", {icon:1, title:'确认提示'}, function(index) {
					$.getJsonByUrl({
						url : "/hm/yz/importHistoryData",
						callback : function(data) {
							layer.alert(data.message, {icon:0,title:'提示'});
						},
						param : {
							begin : $("#beginDate").val(),
							end : $("#endDate").val()
						}
					});
					layer.close(index);
				});
			});		
		}
	}

	function search(indexPage) {
		var rs = validate.validateForm();
        changeOrgType();
        changeRangeType();
        if ($("#context").val() == 'T001') {
            url = "/hm/yz/outpatientList";
        } else if ($("#context").val() == 'T002') {
            url = "/hm/yz/hospitalizeList";
        }else {
            url = "/hm/yz/outpatientList";
        }
		if (rs) {
			var searchObj = {
				url : url,
				insertDiv : "resultDiv",
				param : {
					indexPage : indexPage
				}
			};
			$("#statisticsSearchForm").submitFormLoadHtml(searchObj);
		}
	};

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
        if(genreCode == 'A100'){
            $('#byHospital').show();
            $('#byCentre').hide();
            $('#byStation').hide();
            $('#byTown').hide();
            getCurrentOrgCode(0);
        }else if(genreCode == 'B100'){
            $('#byHospital').hide();
            $('#byCentre').show();
            $('#byStation').hide();
            $('#byTown').hide();
            getCurrentOrgCode(1);
        }else if(genreCode == 'B200'){
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

/*
	function selContextChanged() {
		if ($("#context").val() == 'T001') {
			url = "/hm/yz/outpatientList";
		} else if ($("#context").val() == 'T002') {
			url = "/hm/yz/hospitalizeList";
		} else if ($("#context").val() == 'T003') {
			url = "/hm/yz/list";
		}

	}
*/

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

	function toggle(obj, tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	}

	return {
		search : search,
		// add:add,
		// caseAdd:caseAdd,
		// caseEdit:caseEdit,
		// print:print,
		// edit:edit,
		toggle : toggle,
        load :load
	};
})();

/*$(document).ready(function() {
	// 按钮样式切换
	$("#statisticsBtnSearch").hover(function() {
		$(this).removeClass("search_btn").addClass("search_btn_h");
	}, function() {
		$(this).removeClass("search_btn_h").addClass("search_btn");
	});

});*/

function initIndexPage() {
	garyPageH.search(1);
}

var garyPageH = (function() {
	$(function() {
		$("#form_search").onEnter(function() {
			recordsPerform(1);
		});
		
		$("#vaccineRecordsSearch").click(function() {
			recordsPerform(1);
		});

		$("#grayAdd").click(function() {
			var ehrType = $("input[name=record_radio]").getValue();
        	if($.isEmpty(ehrType)){
        		 layer.alert("请选中一行！", {icon:0,title:'提示'});
        		 return;
        	}
        	var ehrId = ehrType.split("===")[0];
        	var type = ehrType.split("===")[1];
            if (!ehrId) {
                return;
            }
            if (1 != type) {
                layer.alert("请选择狂犬疫苗接种！", {icon:0,title:'提示'});
                return;
            }
            checkGray(ehrId);
		});
		recordsPerform(1);
	});

	// 判断是否需要接种狂犬疫苗
	function checkGray(ehrId) {
		var op = {
			url : "/ph/rabies/checkGray",
			param : {
				ehrId : ehrId
			},
			callback : function(data) {
				if (data == "0") {
					layer.alert("该患者不需要注射免疫球蛋白！", {icon:0,title:'提示'});
					return;
				}
				showDialog(ehrId);
			}
		};
		$.getJsonByUrl(op);
	}

	// 弹出狂犬疫苗接种
	function showDialog(ehrId) {
		var grayAdd = {
			url : "/ph/rabies/gray",
			id : "grayDialog",
			height : 600,
			width : 900,
			param : {
				ehrId : ehrId
			},
			title : "狂犬免疫球蛋白接种",
			close : null
		};
		$.dialog(grayAdd);
	}

	// 显示查询结果
	function recordsPerform(indexPage) {
		var createBegin = new Date($("#createBeginDate").val());
		var createEnd = new Date($("#createEndDate").val());

		if (createBegin > createEnd) {
			layer.alert("接种开始时间不能大于接种结束时间！", {icon:0,title:'提示'});
		} else {
			var searchObj = {
				url : "/ph/hospital/records/grid",
				insertDiv : "recordsGrid",
				param : {
					indexPage : indexPage,
					gray : true
				}
			};
			$("#form_search").submitFormLoadHtml(searchObj);
		}
	}

	function toggle(obj, tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	}
	;

	return {
		search : recordsPerform,
		toggle : toggle

	};

})();

var grayDetialH = (function() {
	function closeDialog() {
		$.removeDialog("grayDialog");
	}

	return {
        closeDialog : closeDialog
	};
})();

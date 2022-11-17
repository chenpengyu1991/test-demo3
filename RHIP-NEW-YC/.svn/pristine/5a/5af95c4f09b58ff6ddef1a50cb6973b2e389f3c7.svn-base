var organizationInfoEdit = (function() {
	var validate = null;
	$(function() {
		validate = $("#organizationForm").easyValidate();
		$("#backButton").click(function(e) {
			e.preventDefault();
			layer.confirm("确认离开？",function(index){
				layer.close(index);
				$("#medicalOraganDiv").empty();
				$("#oraganSearchDiv").show();
			});
		});

//        if($("#organizationEditFlag").val()=="add"){
            $("#areaCodeId").multiselect({
                 header:false,
                 noneSelectedText: '所含行政村',
                 selectedList: 4//最多可选中几个
                });
//        }
		$("#saveButton").click(function(e) {
			e.preventDefault();
			validate.addExtension("symptomVali",symptomVali);
			if (validate.validateForm()) {
				setParentCode();
				$("#organizationForm").submitFormGetJson({
					url : "/mdmOrganization/save",
					wait: true,
					callback : submitCallback,
					param : {
						type : $("#type").val()
					}
				});
			}
		});
		
		$("#selectParentOrganization").click(function(e) {
			e.preventDefault();
			/*var dialogParams = {
					id : "d2",
					url : "/mdmOrganization/viewTree",
					height : 500,
					width : 600,
					title : "选择机构"
			};
			$.dialog(dialogParams);*/
			
			$.post(contextPath+'/mdmOrganization/viewTree',
	        		 
					function(ret){
		        	layui.use(['layer'], function() {
		        		  var layer = layui.layer
		        		  layer.open({
		        			  type: 1,
		        			  id:'orgViewDialog',
		        			  area: ['600px', '500px'],
		        			  title:'选择机构',
		        			  content: ret
		        		  });
		        		});
		        	});
		});
		
		$("#selectArea").click(initSelectAreaDialog);
		
		$("#sureButton").click(function() {
			layui.use('layer', function(){
    			var layer = layui.layer;
    			layer.closeAll();
    		});
			/*$.removeDialog("villageDia");*/
		});
		
		$("#removeParentOrganization").click(function() {
			$("#eparentCodeIdAdd").val("");
			$("#label_parentName").html("无");
		});
		
		$("#removeArea").click(function() {
			$("#hidden_areaCode").val("");
			$("#label_areaName").html("无");
		});
		initShowHiddenFields();
		var option={
				url:"/mdmOrganization/organationTree",
				unSelecteType:['0'],
				selectFun:getVillageOpting,
				param:{organType:"B100"}//设置显示哪些机构 ,逗号分割
		};
		var opb = {
				url:"/mdmOrganization/organationSelect",
				feild : {
					value : "organCode",
					lable : "organName"
				},
				selectFun:getVillageOpting,
				param:{organType:"B100"}//设置显示哪些机构 ,逗号分割
			};
		$("#eparentCodeIdAdd").selectBox(opb);
		$("#eparentCodeIdAdd").initTreeSelect(option);
	});

	function setParentCode() {
		var selectGenreCode = $("#selectGenreCode").val();
		if ("B100" == selectGenreCode || "A100" == selectGenreCode ) {
			if($("input[id='parentCodeCentreId']").is(":checked")) {
				$("#organizationForm").find("input[name='parentCode']").each(function() {
					$(this).val($("input[id='parentCodeCentreId']").val());
				});
			} else {
				$("#organizationForm").find("input[name='parentCode']").each(function() {
					$(this).val('');
				});
			}

		} else if("B200" == selectGenreCode) {
			$("#organizationForm").find("input[name='parentCode']").each(function() {
				$(this).val($("input[ref='eparentCodeIdAdd']").val());
			});
		}
	}
	function initSelectAreaDialog() {
		var selectGenreCode = $("#selectGenreCode").val();
		
		
		if (("B100" == selectGenreCode || "A100" == selectGenreCode) && $.isEmpty($("#gbCodeId").val())) {
			layui.use('layer', function(){
				var layer = layui.layer;
				layer.alert("请选择所属街道！", {icon:0,title:'提示'});
			});

			/*msgUtil.alert("请选择所属街道");*/
			return;
		} else if ("B200" == selectGenreCode && $.isEmpty($("input[ref='eparentCodeIdAdd']").val())) {
			layui.use('layer', function(){
				var layer = layui.layer;
				layer.alert("请选择上级机构！", {icon:0,title:'提示'});
			});
			/*msgUtil.alert("请选择上级机构");*/
			return;
		} else if (("B100" == selectGenreCode || "A100" == selectGenreCode)
			&& (!$("input[id='parentCodeCentreId']").is(":checked") && !$("input[id='parentCodeHealthId']").is(":checked"))) {
			layui.use('layer', function(){
				var layer = layui.layer;
				layer.alert("请选择上级机构！", {icon:0,title:'提示'});
			});
			/*msgUtil.alert("请选择上级机构");*/
			return;
		}  else if ($.isEmpty(selectGenreCode)) {
			layui.use('layer', function(){
				var layer = layui.layer;
				layer.alert("请选择机构类别！", {icon:0,title:'提示'});
			});
			/*msgUtil.alert("请选择机构类别");*/
			return;
		}
		
		/*var dialogParams = {
				id : "villageDia",
				url : "/mdmOrganization/getVillages",
				height : 500,
				width : 600,
				title : "选择行政村",
				param:{
					gbCode: $("#gbCodeId").val(),
					organCode: $("#eorganCodeId").val(),
					parentCode: $("input[ref='eparentCodeIdAdd']").val()
				}
		};
		$.dialog(dialogParams);*/
		
		$.post(contextPath+'/mdmOrganization/viewTree',
				{
				gbCode: $("#gbCodeId").val(),
				organCode: $("#eorganCodeId").val(),
				parentCode: $("input[ref='eparentCodeIdAdd']").val()
				},
				function(ret){
	        	layui.use(['layer'], function() {
	        		  var layer = layui.layer
	        		  layer.open({
	        			  type: 1,
	        			  id:'villageDialog',
	        			  area: ['600px', '500px'],
	        			  title:'选择行政村',
	        			  content: ret
	        		  });
	        		});
	        	});
	}
	
	function initShowHiddenFields() {
		var val = $("#selectGenreCode").val();
		if ("B100" == val || "A100" == val || "C" == val) {
			$("#level_1_tr").show();
			$("#level_2_tr").hide();
			$("#level_3_tr").hide();
			$("#level_4_tr").show();
			$("input[ref='eparentCodeIdAdd']").val('');
		} else if ("B200" == val) {
			$("#level_2_tr").show();
			$("#level_1_tr").hide();
			$("#level_4_tr").hide();
			$("#level_3_tr").show();
			$("#level_4_tr").find("input[type='checkbox']").each(function() {
				$(this).removeAttr("checked");
			});
		} else if("R11" == val || "J100" == val || "L" == val) {
			$("#level_2_tr").hide();
			$("#level_1_tr").hide();
			$("#level_3_tr").hide();
			$("#level_4_tr").hide();
			$("input[ref='eparentCodeIdAdd']").val('');
			$("#level_4_tr").find("input[type='checkbox']").each(function() {
				$(this).removeAttr("checked");
			});
		} else {
			$("#level_2_tr").hide();
			$("#level_1_tr").show();
			$("#level_3_tr").hide();
            $("#level_4_tr").show();
		}
	}
	
	function checkStartDate(dateValue) {
		if (dateValue != "") {
			validate.removeError("startDate");
		}
	}
	
	function submitCallback(data) {
		layui.use('layer', function(){
			var layer = layui.layer;
			layer.alert(data.message, {icon:0,title:'提示'}, function() {
				layer.closeAll();
				if (data.result) {
					$("#medicalOraganDiv").empty();
					organizationSearch.search($("#indexPage").val());
					$("#oraganSearchDiv").show();
				}
			});
			
		});
	}
	
	function getVillageCode() {
		var raValue = '';
		var raText = '';
	    $('input[name="villageCodes"]:checked').each(function(){
	    	var temp = $(this).val();
	        raValue += temp+",";
	        raText +=  $("#"+temp).html()  +",";
	    });
	    $("#label_areaName").html(raText);
	    if($.isEmpty(raText)) {
	    	$("#label_areaName").html("无");
	    } else {
	    	$("#label_areaName").html(raText.substring(0,raText.length-1));
	    }
	    $("#hidden_areaCode").val(raValue.substring(0,raValue.length-1));
	}
	
	function getVillageOpting() {
		
		$.getJsonByUrl({
			 url : "/mdmOrganization/getVillageOpting",
			 checkRepeat:false,
			 callback:function(data){
				 //删除option
				 var i = 0;
				 while($("select[id='areaCodeId'] option").length>0 && i <= $("select[id='areaCodeId'] option").length) {
					 $("select[id='areaCodeId'] option:last").remove();
					 i=0;
				 }
				 if(data != "empty") {
					 $("select[id='areaCodeId']").append(data);
				 }
				 $("select").multiselect('refresh');
			 },
			 param:{
					gbCode: $("#gbCodeId").val(),
					organCode: $("#eorganCodeId").val(),
					parentCode: $("input[ref='eparentCodeIdAdd']").val()
				}
		});
	}

	function symptomVali(){
		var inputs=$("#level_4_tr").find("input[type='checkbox']");
		var selecteds=inputs.filter(":checked");
		if(selecteds.length>0){
			inputs.each(function(){
				$(this).parent().removeClass("lose");
			});
			return true;
		}else{
			inputs.each(function(){
				$(this).parent().addClass("lose");
			});
			return false;
		}
	}

	return {
		checkStartDate : checkStartDate,
		initShowHiddenFields: initShowHiddenFields,
		getVillageCode: getVillageCode,
		getVillageOpting: getVillageOpting,
        setParentCode: setParentCode
	};
})();
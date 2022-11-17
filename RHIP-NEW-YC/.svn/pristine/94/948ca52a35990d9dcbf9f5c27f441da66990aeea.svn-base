var hsaInspRecordAdd = (function ()
{
  var validate =null;
	$(function ()
	{
		 validate = $("#hsa-input-form").easyValidate();
		/* 返回 */
		$("#hsa-input-back-btn").click(function ()
		{
			back();
		});

		// 新增
		$("#hsa-inspRecord-add-btn").click(function ()
		{
			addCard();
		});

		//保存记录界面
		$("#hsa-input-save-btn").click(function ()
		{
			var inputLocationId=$("input[name='locationId']").val();
			if(!inputLocationId){
				$("#hsa-location-search-input").val("");
			}
			 result=validate.validateForm();
			   if(result==true){
				   save();
			   }
		});
		//确认记录界面
		$("#hsa-input-confirm-btn").click(function ()
		{
			var id=$("#has-insprecord-id").val();
			var index = layer.confirm("是否确认？", {icon:1, title:'确认提示'}, function(){
				$("#hsa-record-input-add").hide();
				$("#hsa-record-list-box").show();
				var loadHtmlByUrlOption = {
						url : "/hsa/inspRecord/updateInspRecord",
						param:{
								id:id
						},
						callback : function(data){
							var layer = layui.layer;
							 if(data=="success"){
								var index = layer.alert("确认成功！", {icon:0,title:'提示'}, function() {
									hsaInspRecordList.search(1)
									layer.close(index);
								});
							 }else{
								 layer.alert("确认失败！", {icon:0,title:'提示'});
							 }
				    	}  
					};
					$.loadHtmlByUrl(loadHtmlByUrlOption);
					layer.close(index);
			});
		});
		//新增巡查地点信息
		$("#hsa-add-location-info").click(function ()
		{
			addLocInfo();
		});
		initLocationSearch();

		$("#hsa-guide-type").change(openGuideTable);
		$("#hsa-guide-type").change();
		$("input[name='isGuide']").click(openGuideContent);
		$("input[name='isReport']").click(openReportContent);
		$("#infoTypeCode").change(openSusOccDisease);
		  //点击巡查指导checkbox事件
		 $("input[type='checkbox']","#hsa-guide-content").on("click",function(event){
			 var $this=$(this);
			 var target=$this.data("target");
			 var target1=$this.data("target1");
			 var target2=$this.data("target2");
			 var target3=$this.data("target3");
			 var target4=$this.data("target4");
			 if($this.prop("checked")){
				 $("#"+target).show();
				 $("#"+target1).show();
			 }else{
				$("#" + target).hide().find("input[type='radio']").val([ '5' ]);
				$("#" + target1).hide().find("input[type='radio']").val([ '5' ]);
			 }
			 if(target2 && target3){
				 if($this.prop("checked")){
					 $("#"+target2).prop("readonly",false);
					 $("#"+target3).prop("readonly",false);
				 }else{
					 $("#"+target2).val("");
					 $("#"+target3).val("");
					 $("#"+target2).prop("readonly",true);
					 $("#"+target3).prop("readonly",true);
				 } 
			 }
			 if(target4){
				 if($this.prop("checked")){
					 $("#"+target4).prop("readonly",false);
				 }else{
					 $("#"+target4).prop("readonly",true);
					 $("#"+target4).val("");
				 }  
			 }
			});
		    if($("#has-insprecord-flag").val()=="add"){
				 $("input[name='isGuide']").val(['2']);
				 $("input[name='isReport']").val(['2']);
			}else{
				 $("input[name='isGuide']").val([$("#hsaInspRecordIsGuide").val()]);
				 $("input[name='isReport']").val([$("#hsaInspRecordIsReport").val()]);
				
			}
		    showSusOccDi();
		 $("#townCodeId","#hsa-record-input-add").attr("disabled",true); 
		 openGuideTable();
		 if($("#has-insprecord-flag").val()=="view"){
			 $("#hsa-record-input-add").find("input[type='checkbox']").attr("disabled",true);
			 $("#hsa-record-input-add").find("input[type='radio']").attr("disabled",true);
			 $("#hsa-record-input-add").find("input[type='text']").attr("disabled",true);
			 $(".disabledInfoContent").attr("disabled","disabled");
			 $("#hsa-guide-type","#hsa-record-input-add").attr("disabled",true); 
		}
		 validate.addExtension("cuValidate",customValidate);//方法名,方法
	});

	function showSusOccDi(){
		var infoTypeCode = $("#infoTypeCode").val();
	 	if (infoTypeCode == "4"){
			$("#hideSusOccDisease").show();
		} else {
			$("#hideSusOccDisease").hide();
		}
	}
	//新增地点弹窗
	function addLocInfo()
	{
		var dialogObj = {
			url: contextPath + "/hsa/inspRecord/addLocInfo",
			title: "新增地点信息",
			id: "hsa-add-location-from-dialog"
		};
		$.dialog(dialogObj);
	}


	//初始化地点查询
	function initLocationSearch()
	{
		var opb = {
			url: "/hsa/inspRecord/locationSelect",
			feild: {
				value: "id",
				lable: "unitName"
			},
			selectFun: afterSelectLocation
		};
		$("#hsa-location-search-input").selectBox(opb);
	}

	//选择地点后显示详细信息
	function afterSelectLocation($item, $input)
	{
		var id = $("input[name='locationId']").val();
		var $infoTable = $("#has-view-loaction-info-table");
		if (!id){
			$("input", $infoTable).each(function ()
			{
				$(this).val("");
			});
		}
		$.getJsonByUrl({
			url: "/hsa/inspRecord/getLocInfo",
			param: {locationId: id},
			wait: true,
			callback: function (data)
			{
				for (var key in data) {
					$("#" + key, $infoTable).val(data[key]);
				}
			}
		});
	}

	function back()
	{
		$("#hsa-record-input-add").hide();
		$("#hsa-record-list-box").show();
		hsaInspRecordList.search(1);
	}


	function addCard()
	{
		$("#hsa-record-list-box").hide();
		$("#hsa-record-input-add").show();
		var loadHtmlByUrlOption = {
			url: "/hsa/inspRecord/add",
			insertDiv: "hsa-record-input-add"
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
	}

	function openGuideTable()
	{
		var val = $("#hsa-guide-type").val();
		switch (val) {
			case "1":
				$("#hsa-guide-food").show().find("input").prop("disabled",false);
				$("#hsa-guide-water").hide().find("input").prop("disabled",true);
				$("#hsa-guide-idp").hide().find("input").prop("disabled",true);
				$("#hsa-guide-plocation").hide().find("input").prop("disabled",true);
				break;
			case "2":
				$("#hsa-guide-food").hide().find("input").prop("disabled",true);
				$("#hsa-guide-water").show().find("input").prop("disabled",false);
				$("#hsa-guide-idp").hide().find("input").prop("disabled",true);
				$("#hsa-guide-plocation").hide().find("input").prop("disabled",true);
				break;
			case "3":
				$("#hsa-guide-food").hide().find("input").prop("disabled",true);
				$("#hsa-guide-water").hide().find("input").prop("disabled",true);
				$("#hsa-guide-idp").show().find("input").prop("disabled",false);
				$("#hsa-guide-plocation").hide().find("input").prop("disabled",true);
				break;
			case "4":
				$("#hsa-guide-food").hide().find("input").prop("disabled",true);
				$("#hsa-guide-water").hide().find("input").prop("disabled",true);
				$("#hsa-guide-idp").hide().find("input").prop("disabled",true);
				$("#hsa-guide-plocation").show().find("input").prop("disabled",false);
				break;
			default:
				$("#hsa-guide-food").hide();
				$("#hsa-guide-water").hide();
				$("#hsa-guide-idp").hide();
				$("#hsa-guide-plocation").hide();
				break;
		}
	}

	function openSusOccDisease()
	{
		var val = $(this).val();
		if (val == "4"){
			$("#hideSusOccDisease").show();
		} else {
			$("#hideSusOccDisease").hide();
		}
	}

	function openGuideContent()
	{
		var val = $(this).val();
		if (val == 1){
			$("#hsa-guide-content").show();	
		} else {
			$("#hsa-guide-content").hide();
		}
	}

	function openReportContent()
	{
		var val = $(this).val();
		if (val == 1){
			$("#hsa-report-record-content").show();
		} else {
			$("#hsa-report-record-content").hide();
			$("#discoveryDate").attr("value","");
			$("#infoTypeCode").attr("value","");
			$("#infoContent").attr("value","");
			$("#hideSusOccDisease").hide();
		}
	}
	
	function save()
	{
		var arr = susOccDatagrid();
		$("#hsa-input-form").submitFormGetJson({
			url : "/hsa/inspRecord/save",
			param : arr,
			callback : function(data) {
				if ("success" == data) {
					layer.alert("保存成功！", {icon:0,title:'提示'}, function(index) {
						back();
						layer.close(index);
					});
				}
			}
		});
	}
	function susOccDatagrid(){
		var data = {};
		var j=0;
		var infoTypeCode = $("#infoTypeCode").val();
	 	if (infoTypeCode == "4"){
	 		$("#susOccDiseaseDatagrid tr").each(function(){
				if ($(this).length > 0){
					var tds = $(this).children("td");
					var tdSize = tds.length;
					var i = 0, name, $td;
					for (; i < tdSize; i++) {
						$td = $(tds[i]);
						name = $td.attr("dataName");
						name='susOccDisInfoList['+j+'].'+name;
						data[name] = $td.attr("dataValue");
					}
					j++;
				}
			});
	 	}
		return data;
	}
	
	function customValidate(name,$input){
		var value=$input.filter(":checked").val();
		 if(value!=5){
			 return true;
		 }else{
			return false; 
		 }
	}


	
	
	return {};
})();
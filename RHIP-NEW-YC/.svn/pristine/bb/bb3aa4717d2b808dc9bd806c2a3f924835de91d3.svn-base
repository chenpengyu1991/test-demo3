define(function(){
	function load() {
			$(function () {
			
			$.ajaxSetup ({
				cache: false
			});
			
			// tab切换
			$("#front_machine_btn").on("click", function(event)
			{
				searchResult(this, "front_machine_btn", "tagContent0", "front_machine_from", "/im/list/1", "front_machine_content");
				
			});
			
			$("#drug_category_btn").on("click", function(event)
			{
				searchResult(this, "drug_category_btn", "tagContent1", "drug_category_from", "/im/list/2", "drug_category_content");
			});
			
			$("#hospital_medical_btn").on("click", function(event)
			{
				searchResult(this, "hospital_medical_btn", "tagContent2", "hospital_medical_from", "/im/list/3", "hospital_medical_content");
			});
			
			$("#medical_statistics_btn").on("click", function(event)
			{
				searchResult(this, "medical_statistics_btn", "tagContent6", "medical_data_from", "/im/medicalData/search", "medical_statistics_content");
			});
	
			$("#plan_immu_btn").on("click", function(event)
			{
				searchResult(this, "plan_immu_btn", "tagContent3", "plan_immu_from", "/im/list/4", "plan_immu_content");
			});
			
			$("#women_children_btn").on("click", function(event)
			{
				searchResult(this, "women_children_btn", "tagContent4", "women_children_from", "/im/list/5", "women_children_content");
			});
	
			$("#physical_exam_btn").on("click", function(event)
			{
				searchResult(this, "physical_exam_btn", "tagContent5", "physical_exam_search_form", "/im/list/6", "physical_examination_content");
			});
			
			$("#transport_btn").on("click", function(event)
			{
				searchResult(this, "transport_btn", "tagContent7", "physical_exam_search_form", null, "transport_statistics_content");
			});
	        $("#medicalGoods_btn").on("click", function(event)
	        {
	            searchResult(this, "medicalGoods_btn", "tagContent8", "medicalGoods_search_form", "/im/list/8", "medicalGoods_content");
	        });
	        $("#bloodStation_btn").on("click", function(event)
	        {
	            searchResult(this, "bloodStation_btn", "tagContent9", "bloodStation_search_form", "/im/list/9", "bloodStationcontent");
	        });
	        $("#data120_btn").on("click", function(event)
	        {
	            searchResult(this, "data120_btn", "tagContent10", "data120_search_form", "/im/list/10", "data120_content");
	        });
			$("#monitor_config").on("click", function(event)
			{
				popuEmailConfig();
			});  
			
		 	$("#front_machine_search_btn").on("click", function(e){
				search('front_machine_from','1','front_machine_content');
			});
			
			$("#hospital_medical_search_btn").on("click", function(e){
				search('hospital_medical_from','3','hospital_medical_content', 'createBeginTimeHM', 'createEndTimeHM');
			});
			
			$("#drug_category_search_btn").on("click", function(e){
				search('drug_category_from','2','drug_category_content', 'createBeginTimeDC', 'createEndTimeDC');
			});
			
			$("#plan_immu_search_btn").on("click", function(e){
				search('plan_immu_from','4','plan_immu_content', 'createBeginTimePI', 'createEndTimePI');
			});
			
			$("#women_children_search_btn").on("click", function(e){
				search('women_children_from','5','women_children_content', 'createBeginTimeWHCH', 'createEndTimeWHCH');
			});
			
			$("#physical_exam_search_btn").on("click", function(e){
				search('physical_exam_search_form','6','physical_examination_content', 'createBeginTimePE', 'createEndTimePE');
			});
			$("#medical_goods_search_btn").on("click", function(e){
				search('medicalGoods_search_form','8','medicalGoods_content', 'createBeginTimeMG', 'createEndTimeMG');
			});
			$("#blood_station_search_btn").on("click", function(e){
				search('bloodStation_search_form','9','bloodStation_content', 'createBeginTimeBS', 'createEndTimeBS');
			});
			$("#data120_search_btn").on("click", function(e){
				search('data120_search_form','10','data120_content', 'createBeginTimeJJ', 'createEndTimeJJ');
			});
			
			$("#front_machine_search_bottom").on("click", function(e){
				toggle(this,'frontMachineSearch','frontMachineDiv','contentfixed126');
			});
			
			$("#hospital_medical_search_bottom").on("click", function(e){
				toggle(this,'hospitalmedicalSearch','hospitalMedicalDiv','contentfixed149');
			});
			
			$("#drug_category_search_bottom").on("click", function(e){
				toggle(this,'drugcategorySearch','drugCategoryDiv','contentfixed149');
			});
			
			$("#plan_immu_search_bottom").on("click", function(e){
				toggle(this,'planimmuSearch');
			});
			
			$("#women_children_search_bottom").on("click", function(e){
				toggle(this,'womenchildrenSearch','womenChildrenHealthcareDiv','contentfixed149');
			});
			
			$("#physical_exam_search_bottom").on("click", function(e){
				toggle(this,'physicalexamSearch','physicalExaminationDiv','contentfixed149');
			});
			
			$("#medical_goods_bottom").on("click", function(e){
				toggle(this,'hospitalmedicalSearch','medicalGoodsDiv','contentfixed149');
			});
			
			$("#blood_station_search_bottom").on("click", function(e){
				toggle(this,'bloodStationSearch','bloodStationDiv','contentfixed149');
			});
			
			$("#data120_search_bottom").on("click", function(e){
				toggle(this,'data120Search','data120Div','contentfixed149');
			});
		});
		
		$("select[id^='projectNames']").multiselect({
			 header:false,
			 noneSelectedText: '请选择项目类型',
			 selectedList: 2//最多可选中几个
		});
		
		$("select[id='organization']").append('<option title="常熟市社区卫生服务站" value="320000000">常熟市社区卫生服务站</option>');
	}

   /**
	 * 弹出提醒设置画面
	 */
    function popuEmailConfig() {
	    var emailConfigDialog = {
	            url : "/im/emailconfig",
	            height : 550,
	            width : 800,
	            title : "提醒设置" ,
	            id :"emailConfigDialog",
            	param:{}	            
	        };
		$.dialog(emailConfigDialog);		
    };
    
	function toggle(obj,tableId,listTableId,css) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
        topHide(tableId,listTableId,css);
    };

    /**
     * 是否出现滚动条对列表宽度影响
     */
    function scrollYFun(type) {
        switch (type)
        {
            case "tagContent0": scrollYFunDetail("frontMachine"); break;
            case "tagContent1": scrollYFunDetail("drugCategory"); break;
            case "tagContent2": scrollYFunDetail("hospitalMedical"); break;
            case "tagContent3": ; break;
            case "tagContent4": scrollYFunDetail("womenChildrenHealthcare"); break;
            case "tagContent5": scrollYFunDetail("physicalExamination"); break;
            case "tagContent6": scrollYFunDetail("medicalData"); break;
            case "tagContent8": scrollYFunDetail("medicalGoods"); break;
            case "tagContent9": scrollYFunDetail("bloodStation"); break;
            case "tagContent10": scrollYFunDetail("data120"); break;
        }
        switch (type)
        {
            case "1": scrollYFunDetail("frontMachine"); break;
            case "2": scrollYFunDetail("drugCategory"); break;
            case "3": scrollYFunDetail("hospitalMedical"); break;
            case "4": ; break;
            case "5": scrollYFunDetail("womenChildrenHealthcare"); break;
            case "6": scrollYFunDetail("physicalExamination"); break;
            case "8": scrollYFunDetail("medicalGoods"); break;
            case "9": scrollYFunDetail("bloodStation"); break;
            case "10": scrollYFunDetail("data120"); break;
        }

    }

    function scrollYFunDetail(id) {
        var tableId = id+"Div";
        var mainId = id+"TopDiv";
        var obj=document.getElementById(tableId);
        if(obj == null){
            return;
        }
        if(obj.scrollHeight>obj.clientHeight||obj.offsetHeight>obj.clientHeight){
            document.getElementById(mainId).setAttribute("class","paddingright17");
        }else{
            document.getElementById(mainId).removeAttribute("class");
        }
    }

    /**
     * 是否收起查询条件对固定滚动的影响
     */
    function topHide(tableId,listTableId,css){
        document.getElementById(listTableId).removeAttribute("class");
        if($("#" + tableId).css("display")=="none"){
            if(tableId == "frontMachineSearch"){
                document.getElementById(listTableId).setAttribute("class","contentfixed90");
            }else{
                document.getElementById(listTableId).setAttribute("class","contentfixed113");
            }
        }else{
            document.getElementById(listTableId).setAttribute("class",css);
        }
    }

	function searchResult(obj, btn, tagcon, formId, url, insertDiv) {
		selectTag(tagcon, obj);
		if ($.isEmpty(url)) {
			return;
		}
		if (!$("#"+btn).hasClass("loaded"))
		{
			if(formId != 'hospital_medical_from' && formId != 'medicalGoods_search_form' && formId != 'bloodStation_search_form'&& formId != 'data120_search_form') {
				$("#"+formId).submitFormLoadHtml({
					url : url,
					insertDiv : insertDiv,
	                callback : function(data) {
	                    scrollYFun(tagcon);
	                }
				});
			}
			
			// 执行一次后,标记切换tab时不再查询
			$($("#"+btn)).addClass("loaded");
		}
	}
	
	
	function search(formId, type, insertDiv, beginTimeId, endTimeId) {
		var b = $("#"+beginTimeId).val();
		var e = $("#"+endTimeId).val();
		if (!$.isEmpty(b) || !$.isEmpty(e)) {
			if ($.isEmpty(b) || $.isEmpty(e)) {
				layer.alert("请选择开始与结束时间！", {icon:0,title:'提示'});
				return;
			}
		}
		if (!$.isEmpty(b) && !$.isEmpty(e)) {
			var createBeginTime = new Date(b);
			var createEndTime = new Date(e);
			if (createBeginTime > createEndTime) {
				layer.alert("开始时间不能大于结束时间！", {icon:0,title:'提示'});
				return;
			}
			if ((createEndTime - createBeginTime)/(60*60*1000*24) > 6) {
				layer.alert("所选时间不能超过7天！", {icon:0,title:'提示'});
				return;
			}
		}

		$("#"+formId).submitFormLoadHtml({
			url : "/im/list/"+type,
			insertDiv : insertDiv,
            callback : function(data) {
                scrollYFun(type);
            }
		});
    }
			
	return {
		load: load
	};
})
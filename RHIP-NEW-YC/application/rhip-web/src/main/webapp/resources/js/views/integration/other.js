define(function()
{
    function load(){
        $(function()
        {
            // tab切换>显示档案统计
            $("#drug_category_btn").on("click", function(event)
            {
                searchResult(this, "drug_category_btn", "tagContent1", "drug_category_from", "/im/list/2", "drug_category_content");
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

            //药品目录
            $("#drug_category_search_btn").click(function() {
                search('drug_category_from','2','drug_category_content', 'createBeginTimeDC', 'createEndTimeDC');
            });
            $("#drugcategorySearchToggle").click(function() {
                toggle(this,'drugcategorySearch','drugCategoryDiv','contentfixed149');
            });

            //医药卫生用品
            $("#hospital_medical_search_btn1").click(function() {
                search('medicalGoods_search_form','8','medicalGoods_content', 'createBeginTimeMG', 'createEndTimeMG');
            });
            $("#hospitalmedicalSearchToggle").click(function() {
                toggle(this,'medicalGoodsSearch','medicalGoodsDiv','contentfixed149');
            });
            //血站
            $("#hospital_medical_search_btn2").click(function() {
                search('bloodStation_search_form','9','bloodStation_content', 'createBeginTimeBS', 'createEndTimeBS');
            });
            $("#bloodStationSearchToggle").click(function() {
                toggle(this,'bloodStationSearch','bloodStationDiv','contentfixed149');
            });
            //120数据
            $("#hospital_medical_search_btn3").click(function() {
                search('data120_search_form','10','data120_content', 'createBeginTimeJJ', 'createEndTimeJJ');
            });
            $("#data120SearchToggle").click(function() {
                toggle(this,'data120Search','data120Div','contentfixed149');
            });

        });
    }


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
        load:load,
		search:search,
		toggle : toggle
	};


})
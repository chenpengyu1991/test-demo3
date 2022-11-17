var ehrBrowserBasic = (function() {

    $(function() {/*
        $("#basic_cover_li").click(function(){
        	var isInfoClick_cover = true;
        	var isInfoSaved = true;
        	var isExamClick_cover = true;
        	var isUnCreatePerson_cover = true;
        	
        	if($("#two2").hasClass("hover")){
        		addPersonInfo.isInfoClicked();
        		isInfoClick_cover = addPersonInfo.savePersonInfo(loadCover);
        		isInfoSaved = false;
        	}
        	if($("#two3").hasClass("hover")){
        		addPhyExam.isExamClicked();
        		isExamClick_cover = addPhyExam.save();
        	}
        	if($("#basic_info_li").hasClass("layui-this")){
    		addPersonInfo.isInfoClicked();
    		isInfoClick_cover = addPersonInfo.savePersonInfo(loadCover);
    		isInfoSaved = false;
	    	}
	    	if($("#basic_physical_examination_li").hasClass("layui-this")){
	    		addPhyExam.isExamClicked();
	    		isExamClick_cover = addPhyExam.save();
	    	}
        	
        	if(isInfoSaved && isInfoClick_cover && isExamClick_cover){
        		loadCover();
        	}
        });
        
        $("#basic_info_li").click(function(){
        	var isCoverClick_info = true;
        	var isCoverSaved = true;
        	var isExamClick_info = true;
        	var isUnCreate_info = false;
        	var hhtValue = "";
        	var gpValue = "";
    		if($("#basic_cover_li").hasClass("layui-this")){
    			isUnCreate_info = addPersonCover.isUnCreatePerson();
    			if(isUnCreate_info){
            		addPersonCover.isCoverClicked();
            		isCoverClick_info = addPersonCover.saveCover(loadInfo);
            		isCoverSaved = false;
    			}else {
            		layer.alert("人员尚未建档，请先保存封面信息！");
            		return;
            	}
        	}
        	if($("#basic_physical_examination_li").hasClass("layui-this")){
        		addPhyExam.isExamClicked();
        		isExamClick_info = addPhyExam.save();
        	}
        	if(isCoverSaved && isCoverClick_info && isExamClick_info){
        		loadInfo();
        	}
        });

        $("#basic_physical_examination_li").click(function(){
        	var isCoverClick_examination = true;
        	var isInfoClick_examination = true;
        	var isUnCreate_examination = false;
        	
        	if($("#basic_cover_li").hasClass("layui-this")){
        		isUnCreate_examination = addPersonCover.isUnCreatePerson();
        		if(isUnCreate_examination){
					//layer.alert("待检验检查完成，请填入相关体检项目");
            		addPersonCover.isCoverClicked();
            		isCoverClick_examination = addPersonCover.saveCover();
    			}else {
    				layui.use('layer', function(){
            			var layer = layui.layer;
            			layer.alert("人员尚未建档，请先保存封面信息！");
            		return;
            	});
    			}
        	}
        	if($("#basic_info_li").hasClass("layui-this")){
				//layer.alert("待检验检查完成，请填入相关体检项目");
        		addPersonInfo.isInfoClicked();
                //检查慢病管理卡是否创建 团风不需要检测是否报卡，2019528团风又需要了BUG0158233
				if(!addPersonInfo.mbbkReportCheck()) {
					addPersonInfo.showMbGl();
					return;
				}
				else
        			isInfoClick_examination = addPersonInfo.savePersonInfo();
        	}
        	if(isCoverClick_examination && isInfoClick_examination){
    			loadBasicHtml("addPersonPhyExam");
        		setClassforTwo3();
        	}
        });

        $("#basic_reception_status_li").click(function(){
            var isCoverClick_examination = true;
            var isExamClick_info = true;
            var isInfoClick_examination = true;

            if($("#basic_cover_li").hasClass("layui-this")){
                isUnCreate_examination = addPersonCover.isUnCreatePerson();
                if(isUnCreate_examination){
                    //layer.alert("待检验检查完成，请填入相关体检项目");
                    addPersonCover.isCoverClicked();
                    isCoverClick_examination = addPersonCover.saveCover();
                }else {
                	layui.use('layer', function(){
            			var layer = layui.layer;
            			layer.alert("人员尚未建档，请先保存封面信息！");
            		return;
            	});
                }
            }
            if($("#basic_info_li").hasClass("layui-this")){
                //layer.alert("待检验检查完成，请填入相关体检项目");
                addPersonInfo.isInfoClicked();
                //检查慢病管理卡是否创建
                if(!addPersonInfo.mbbkReportCheck()) {
                    addPersonInfo.showMbGl();
                    return;
                }
                else{
                    isInfoClick_examination = addPersonInfo.savePersonInfo();
                //}
            }
            if($("#basic_physical_examination_li").hasClass("layui-this")){
                addPhyExam.isExamClicked();
                isExamClick_info = addPhyExam.save();
            }
            if( isInfoClick_examination && isCoverClick_examination && isExamClick_info){
                loadReception();
            }
        });

        $("#basic_consultation_view_li").click(function(){
            var isCoverClick_examination = true;
            var isExamClick_info = true;
            var isInfoClick_examination = true;

            if($("#basic_cover_li").hasClass("layui-this")){
                isUnCreate_examination = addPersonCover.isUnCreatePerson();
                if(isUnCreate_examination){
                    //layer.alert("待检验检查完成，请填入相关体检项目");
                    addPersonCover.isCoverClicked();
                    isCoverClick_examination = addPersonCover.saveCover();
                }else {
                	layui.use('layer', function(){
            			var layer = layui.layer;
            			layer.alert("人员尚未建档，请先保存封面信息！");
            		return;
            	});
                }
            }
            if($("#basic_info_li").hasClass("layui-this")){
                //layer.alert("待检验检查完成，请填入相关体检项目");
                addPersonInfo.isInfoClicked();
                //检查慢病管理卡是否创建
                if(!addPersonInfo.mbbkReportCheck()) {
                    addPersonInfo.showMbGl();
                    return;
                }
                else{
                    isInfoClick_examination = addPersonInfo.savePersonInfo();
                //}
            }
            if($("#basic_physical_examination_li").hasClass("layui-this")){
                addPhyExam.isExamClicked();
                isExamClick_info = addPhyExam.save();
            }
            if( isInfoClick_examination && isCoverClick_examination && isExamClick_info){
                loadConsultation();
            }
        });

        $("#referral_info_li").click(function(){
            var isCoverClick_examination = true;
            var isExamClick_info = true;
            var isInfoClick_examination = true;
            var isConsultation_examination = true;

            if($("#basic_cover_li").hasClass("layui-this")){
                isUnCreate_examination = addPersonCover.isUnCreatePerson();
                if(isUnCreate_examination){
                    //layer.alert("待检验检查完成，请填入相关体检项目");
                    addPersonCover.isCoverClicked();
                    isCoverClick_examination = addPersonCover.saveCover();
                }else {
                	layui.use('layer', function(){
            			var layer = layui.layer;
            			layer.alert("人员尚未建档，请先保存封面信息！");
            		return;
            	});
                }
            }
            if($("#basic_info_li").hasClass("layui-this")){
                //layer.alert("待检验检查完成，请填入相关体检项目");
                addPersonInfo.isInfoClicked();
                //检查慢病管理卡是否创建
                if(!addPersonInfo.mbbkReportCheck()) {
                    addPersonInfo.showMbGl();
                    return;
                }
                else{
                    isInfoClick_examination = addPersonInfo.savePersonInfo();
                //}
            }
            if($("#basic_physical_examination_li").hasClass("layui-this")){
                addPhyExam.isExamClicked();
                isExamClick_info = addPhyExam.save();
            }
            if( isInfoClick_examination && isCoverClick_examination && isExamClick_info){
                loadReferral();
            }
        });
    */});

    $(document).ready(function() {
        var ehr_urlFromPhysicalExam = $("#ehr_urlFromPhysicalExam").val();
        if($.isEmpty(ehr_urlFromPhysicalExam)){
            $("#basic_info").html("");
            $("#basic_physical_examination").html("");
            $("#basic_reception_status").html("");
            $("#basic_consultation_view").html("");
            $("#referral_info").html("");
            loadCover();
        }else {
            $("#basic_cover").html("");
            $("#basic_info").html("");
            $("#basic_physical_examination").html("");
            $("#basic_reception_status").html("");
            $("#basic_consultation_view").html("");
            $("#referral_info").html("");
            loadBasicHtml("addPersonPhyExam","basic_physical_examination");
        }
    });

    function loadCover(){
        loadBasicHtml("addCover","basic_cover");
        /*setClassforTwo1();*/
    }

    function loadInfo(){
    	loadBasicHtml("addPersonInfo","basic_info");
        /*setClassforTwo2();*/
    }
    
    function loadReception(){
    	loadBasicHtml("getReceptionDate","basic_reception_status");
        /*setClassforTwo4();*/
    }

    function loadConsultation(){
        loadBasicHtml("addConsultation","basic_consultation_view");
        /*setClassforTwo5();*/
    }

    function loadReferral(){
        loadBasicHtml("referralList","referral_info");
        setClassforTwo6();
    }
   
    function setClassforTwo1(){  	   	
		$("#two1").attr("class","hover");
		$("#two2").attr("class","");
		$("#two3").attr("class","");
        $("#two4").attr("class","");
        $("#two5").attr("class","");
        $("#two6").attr("class","");
	}
    
    function setClassforTwo2(){  	   	
    	$("#two1").attr("class","");
		$("#two2").attr("class","hover");
		$("#two3").attr("class","");
        $("#two4").attr("class","");
        $("#two5").attr("class","");
        $("#two6").attr("class","");
    }
    
    function setClassforTwo3(){  	   	
    	$("#two1").attr("class","");
		$("#two2").attr("class","");
		$("#two3").attr("class","hover");
        $("#two4").attr("class","");
        $("#two5").attr("class","");
        $("#two6").attr("class","");
    }

    function setClassforTwo4(){
        $("#two1").attr("class","");
        $("#two2").attr("class","");
        $("#two3").attr("class","");
        $("#two4").attr("class","hover");
        $("#two5").attr("class","");
        $("#two6").attr("class","");
    }

    function setClassforTwo5(){
        $("#two1").attr("class","");
        $("#two2").attr("class","");
        $("#two3").attr("class","");
        $("#two4").attr("class","");
        $("#two5").attr("class","hover");
        $("#two6").attr("class","");
    }

    function setClassforTwo6(){
        $("#two1").attr("class","");
        $("#two2").attr("class","");
        $("#two3").attr("class","");
        $("#two4").attr("class","");
        $("#two5").attr("class","");
        $("#two6").attr("class","hover");
    }

    function loadBasicHtml(moduleName, divId){
        $.loadHtmlByUrl({
            url : contextPath + "/personRecord/"+moduleName,
            insertDiv :divId,
            param:null
        });
    };

    return {loadCover:loadCover,
    	loadInfo:loadInfo,
    	loadReception:loadReception,
    	loadConsultation:loadConsultation,
    	loadReferral:loadReferral,
    	loadBasicHtml:loadBasicHtml
    	}
})();
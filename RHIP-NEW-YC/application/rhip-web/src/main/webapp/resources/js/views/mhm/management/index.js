var managementIndex = (function() {
	$(function() {

		/*基本档案
		$("#tag1").on("click", function(event)
		{	var selfObj = this;
	        if(contentChanged){
	        	msgUtil.backConfirm(function(){
	        		disableChangeConfirm();
	    			selectTagl("tagContent1", selfObj);
	    			baseinfo();
				});        	
	        }else{
				selectTagl("tagContent1", selfObj);
				baseinfo();
	        }
		});
		出院信息
		$("#tag2").on("click", function(event)
		{
			var selfObj = this;
	        if(contentChanged){
	        	msgUtil.backConfirm(function(){
	        		disableChangeConfirm();
	    			selectTagl("tagContent2", selfObj);
                    outInfo();
				});        	
	        }else{
				selectTagl("tagContent2", selfObj);
                outInfo();
	        }
	        
		});
		随访记录
		$("#tag3").on("click", function(event)
		{
			var selfObj = this;
	        if(contentChanged){
	        	msgUtil.backConfirm(function(){
	        		disableChangeConfirm();
	    			selectTagl("tagContent3", selfObj);
                    followUp();
				});        	
	        }else{
				selectTagl("tagContent3", selfObj);
                followUp();
	        }
		});	
		失访信息表
		$("#tag4").on("click", function(event)
		{
			var selfObj = this;
	        if(contentChanged){
	        	msgUtil.backConfirm(function(){
	        		disableChangeConfirm();
	    			selectTagl("tagContent4", selfObj);
	    			lostFollowUpIndex();
				});        	
	        }else{
				selectTagl("tagContent4", selfObj);
				lostFollowUpIndex();
	        }
		});	
		个案管理计划
		$("#tag5").on("click", function(event)
		{
			var selfObj = this;
	        if(contentChanged){
	        	msgUtil.backConfirm(function(){
	        		disableChangeConfirm();
	    			selectTagl("tagContent5", selfObj);
	    			casePlan();
				});        	
	        }else{
				selectTagl("tagContent5", selfObj);
				casePlan();
	        }
		});	
		效果评估
		$("#tag6").on("click", function(event)
		{
			var selfObj = this;
	        if(contentChanged){
	        	msgUtil.backConfirm(function(){
	        		disableChangeConfirm();
	    			selectTagl("tagContent6", selfObj);
	    			evaluation();
				});        	
	        }else{
				selectTagl("tagContent6", selfObj);
				evaluation();
	        }
		});	
		应急处置
		$("#tag7").on("click", function(event)
		{
			var selfObj = this;
	        if(contentChanged){
	        	msgUtil.backConfirm(function(){
	        		disableChangeConfirm();
	    			selectTagl("tagContent7", selfObj);
	    			emergency();
				});        	
	        }else{
				selectTagl("tagContent7", selfObj);
				emergency();
	        }
		});	
		门诊信息
		$("#tag8").on("click", function(event)
		{
			var selfObj = this;
	        if(contentChanged){
	        	msgUtil.backConfirm(function(){
	        		disableChangeConfirm();
	    			selectTagl("tagContent8", selfObj);
	    			advancedIndex();
				});        	
	        }else{
				selectTagl("tagContent8", selfObj);
				advancedIndex();
	        }
		});	
		转诊信息
		$("#tag9").on("click", function(event)
		{
			var selfObj = this;
	        if(contentChanged){
	        	msgUtil.backConfirm(function(){
	        		disableChangeConfirm();
	    			selectTagl("tagContent9", selfObj);
	    			referral();
				});        	
	        }else{
				selectTagl("tagContent9", selfObj);
				referral();
	        }
		});
        健康体检
        $("#tag10").on("click", function(event)
        {
            var selfObj = this;
            if(contentChanged){
                msgUtil.backConfirm(function(){
                    disableChangeConfirm();
                    selectTagl("tagContent10", selfObj);
                    healthCheck();
                });
            }else{
                selectTagl("tagContent10", selfObj);
                healthCheck();
            }
        });*/
        baseinfo();
	});

	/*加载基本档案页面*/
	function baseinfo() {
		var length = $('#tagContent1').has('form').length;
		if (length == 0){
            var statusId = $("#statusId").val();
            var logoff = $("#logoffId").val();
			//参数
			var loadHtmlByUrlOption = {
				url : "/mhm/baseArchives/init",
				param : {statusId : statusId, logoff:logoff},
				checkRepeat : true,
				insertDiv : "tagContent1",
				errorDiv: "",
				okDiv:""
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		}
	};

    /*加载出院信息页面*/
    function outInfo() {
        var length = $('#tagContent2').has('form').length;
        var statusId = $("#statusId").val();
        if (length == 0){
            //参数
            var loadHtmlByUrlOption = {
                url : "/mhm/outInfo/init",
                param : {statusId : statusId},
                checkRepeat : true,
                insertDiv : "tagContent2",
                errorDiv: "",
                okDiv:""
            };
            $.loadHtmlByUrl(loadHtmlByUrlOption);
        }
    };

    /*加载随访信息页面*/
    function followUp() {
    	var statusId = $('#statusId').val();
        //参数
        var loadHtmlByUrlOption = {
            url : "/mhm/followUp/main",
            param : {statusId:statusId},
            checkRepeat : true,
            insertDiv : "tagContent3",
            errorDiv: "",
            okDiv:""
        };
        $.loadHtmlByUrl(loadHtmlByUrlOption);
    };

	/*加载个案管理计划页面*/
	function casePlan() {
        var bringIntoMode = $("select[name='mhmOtherInfo.bringIntoMode']").find("option[value!='']:selected").val();
		var length = $('#tagContent5').has('form').length;
		if (length == 0){
			//参数
			var loadHtmlByUrlOption = {
				url : "/mhm/management/caseplan/main",
				param : {bringIntoMode:bringIntoMode},
				checkRepeat : true,
				insertDiv : "tagContent5",
				errorDiv: "",
				okDiv:""
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		}
	};	
	/*加载效果评估页面*/
	function evaluation() {
        var bringIntoMode = $("select[name='mhmOtherInfo.bringIntoMode']").find("option[value!='']:selected").val();
        var length = $('#tagContent6').has('form').length;
		if (length == 0){
			//参数
			var loadHtmlByUrlOption = {
				url : "/mhm/management/evaluation/main",
				param : {bringIntoMode:bringIntoMode},
				checkRepeat : true,
				insertDiv : "tagContent6",
				errorDiv: "",
				okDiv:""
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		}
	};	
	/*加载应急处置页面*/
	function emergency() {
        var statusId = $('#statusId').val();
        var length = $('#tagContent7').has('form').length;
		if (length == 0){
			//参数
			var loadHtmlByUrlOption = {
				url : "/mhm/management/emergency/main",
				param : {statusId:statusId},
				checkRepeat : true,
				insertDiv : "tagContent7",
				errorDiv: "",
				okDiv:""
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		}
	};	

    /*加载门诊信息（集成）*/
    function advancedIndex(){
        var length = $('#tagContent8').has('form').length;
        var statusId = $("#statusId").val();
        if (length == 0){
            //参数
            var loadHtmlByUrlOption = {
                url : "/mhm/management/outPatient",
                param : {statusId : statusId},
                checkRepeat : true,
                insertDiv : "tagContent8",
                errorDiv: "",
                okDiv:""
            };
            $.loadHtmlByUrl(loadHtmlByUrlOption);
        }
    }

	/*加载转诊信息*/
	function referral() {
		var length = $('#tagContent9').has('form').length;
		if (length == 0){
			//参数
			var loadHtmlByUrlOption = {
				url : "/mhm/management/referral",
				 param : {pixId : $('#pixId').val()},
				checkRepeat : true,
				insertDiv : "tagContent9",
				errorDiv: "",
				okDiv:""
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		}
	}
	/*加载失访信息页面*/
	function lostFollowUpIndex() {
    	var statusId = $('#statusId').val();		
		var length = $('#tagContent4').has('form').length;
		if (length == 0){
			//参数
			var loadHtmlByUrlOption = {
				url : "/mhm/lostfollowup/edit",
                param : {statusId:statusId},
				checkRepeat : true,
				insertDiv : "tagContent4",
				errorDiv: "",
				okDiv:""
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		}
	};
    /*加载健康体检页面*/
    function healthCheck(){
        var length = $('#tagContent10').has('form').length;
        var statusId = $("#statusId").val();
        if (length == 0){
            //参数
            var loadHtmlByUrlOption = {
                url : "/mhm/healthCheck/main",
                param : {statusId : statusId},
                checkRepeat : true,
                insertDiv : "tagContent10",
                errorDiv: "",
                okDiv:""
            };
            $.loadHtmlByUrl(loadHtmlByUrlOption);
        }
    }
	return {
		baseinfo:baseinfo,
		outInfo:outInfo,
		followUp:followUp,
		lostFollowUpIndex:lostFollowUpIndex,
		casePlan:casePlan,
		evaluation:evaluation,
		emergency:emergency,
		advancedIndex:advancedIndex,
		referral:referral,
		healthCheck:healthCheck
	};
})();
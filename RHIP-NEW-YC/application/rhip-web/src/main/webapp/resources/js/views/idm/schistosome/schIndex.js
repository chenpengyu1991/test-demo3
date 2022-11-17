var schIndex = (function() {
	$(function() { 
		/*监测登记
		$("#tag1").on("click", function(event)
		{	var selfObj = this;
	        if(contentChanged){
	        	msgUtil.backConfirm(function(){
	        		disableChangeConfirm();
	    			selectTag("tagContent1", selfObj);
	    			registerIndex();
				});        	
	        }else{
				selectTag("tagContent1", selfObj);
				registerIndex();
	        }
		});
		个案调查
		$("#tag2").on("click", function(event)
		{
			var selfObj = this;
	        if(contentChanged){
	        	msgUtil.backConfirm(function(){
	        		disableChangeConfirm();
	    			selectTag("tagContent2", selfObj);
	    			caseIndex();
				});        	
	        }else{
				selectTag("tagContent2", selfObj);
				caseIndex();
	        }
	        
		});
		管理
		$("#tag3").on("click", function(event)
		{
			var selfObj = this;
	        if(contentChanged){
	        	msgUtil.backConfirm(function(){
	        		disableChangeConfirm();
	    			selectTag("tagContent3", selfObj);
	    			advancedIndex();
				});        	
	        }else{
				selectTag("tagContent3", selfObj);
				advancedIndex();
	        }
		});
		报表
        $("#tag4").on("click", function(event)
        {
            var selfObj = this;
            if(contentChanged){
                msgUtil.backConfirm(function(){
                    disableChangeConfirm();
                    selectTag("tagContent4", selfObj);
                    reportIndex();
                });
            }else{
                selectTag("tagContent4", selfObj);
                reportIndex();
            }

        });*/
        registerIndex();
	});

	/*加载监测登记页面*/
	function registerIndex() {
		var length = $('#tagContent1').has('form').length;
		if (length == 0){
			//参数
			var loadHtmlByUrlOption = {
				url : "/idm/schistosome/register/search",
				param : null,
//				wait:true,
				checkRepeat : true,
				insertDiv : "tagContent1",
				errorDiv: "",
				okDiv:""
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		}
	};
	/*加载个案页面*/
	function caseIndex() {
		var length = $('#tagContent2').has('form').length;
		if (length == 0){
			//参数
			var loadHtmlByUrlOption = {
				url : "/idm/schistosome/case/search",
				param : null,
				checkRepeat : true,
				insertDiv : "tagContent2",
				errorDiv: "",
				okDiv:""
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		}
	};
	/*加载管理页面*/
	function advancedIndex() {
		var length = $('#tagContent3').has('form').length;
		if (length == 0){
			//参数
			var loadHtmlByUrlOption = {
				url : "/idm/schistosome/advanced/search",
				param : null,
				checkRepeat : true,
				insertDiv : "tagContent3",
				errorDiv: "",
				okDiv:""
			};
			$.loadHtmlByUrl(loadHtmlByUrlOption);
		}
	};
//血吸虫统计报表加载页面
    function reportIndex() {
        var length = $('#tagContent4').has('form').length;
        if (length == 0){
            //参数
            var loadHtmlByUrlOption = {
                url : "/idm/schistosome/report/search",
                param : null,
                checkRepeat : true,
                insertDiv : "tagContent4",
                errorDiv: "",
                okDiv:""
            };
            $.loadHtmlByUrl(loadHtmlByUrlOption);
        }
    };

	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	};	
	return {
		toggle:toggle,
		registerIndex:registerIndex,
		caseIndex:caseIndex,
		advancedIndex:advancedIndex,
		reportIndex:reportIndex
	};
})();
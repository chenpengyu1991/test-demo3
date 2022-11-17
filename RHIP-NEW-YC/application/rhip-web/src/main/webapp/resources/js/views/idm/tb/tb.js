var tb = (function() {
	$(function() {
        $(".thirdMenu a").click(function(){
            //以下代码为：主内容区二级菜单切换显示定位的问题
            var idString = $(this).parent().parent().attr("id");
            $("#"+idString).find(".active").removeClass("active");
            $(this).parent().addClass("active");
        });


        $("#diagnosisId").click(function() {
        	loadSearchPage('/idm/tb/treatment/diagnosis/search', 'diagnosis');
        	showDiv('diagnosis');
        	hideDiv('dcmr');
        	hideDiv('treatment');
        });
        
        $("#dcmrId").click(function() {
        	loadSearchPage('/idm/tb/treatment/dcmr/search', 'dcmr');
        	showDiv('dcmr');
        	hideDiv('diagnosis');
        	hideDiv('treatment');
        });

        $("#treatmentId").click(function() {
        	loadSearchPage('/idm/tb/treatment/search', 'treatment');
        	showDiv('treatment');
        	hideDiv('diagnosis');
        	hideDiv('dcmr');
        });
        
        $("#recommendationId").click(function() {
        	loadSearchPage('/idm/tb/confirmed/recommendation/search', 'recommendation');
        	showDiv('recommendation');
        	hideDiv('register');
        	hideDiv('transfertreat');
        });

        $("#registerId").click(function() {
        	loadSearchPage('/idm/tb/confirmed/register/search', 'register');
        	showDiv('register');
        	hideDiv('recommendation');
        	hideDiv('transfertreat');
        });
        $("#transfertreatId").click(function() {
        	loadSearchPage('/idm/tb/confirmed/transfertreat/search', 'transfertreat');
        	showDiv('transfertreat');
        	hideDiv('recommendation');
        	hideDiv('register');
        });

		$("#ndyQz").click(function() {
			loadSearchPage('/idm/tb/ndy/confirm/search', 'ndyQz');
			showDiv('ndyQz');
			hideDiv('ndyFy');
		});

		$("#ndyFy").click(function() {
			loadSearchPage('/idm/tb/ndy/fuyao/search', 'ndyFy');
			showDiv('ndyFy');
			hideDiv('ndyQz');
		});

       $("#medicineId").click(function() {
        	loadSearchStandardizationPage(1);
        });

        $("#sputumId").click(function() {
        	loadSearchStandardizationPage(2);
        });
        
        $("#interviewId").click(function() {
        	loadSearchStandardizationPage(3);
        });
        
        $("#delayId").click(function() {
        	loadSearchStandardizationPage(4);
        });
        
        $("#contactId").click(function() {
        	loadSearchStandardizationPage(5);
        });
		// //耐多药
		// $("#ndy_medicineId").click(function() {
		// 	loadSearchStandardizationPage(6);
		// });
		//随访记录
		$("#sf_recordId").click(function() {
			loadSearchStandardizationPage(7);
		});


	});

    function showDiv(id) {
    	document.getElementById(id + 'Page').style.display = "";
    }
    
    function hideDiv(id) {
    	document.getElementById(id + 'Page').innerHTML = "";
    }

    function hideAllDiv() {

    }
    
    function loadSearchPage(url, id, type) {
    	$.loadHtmlByUrl({
			url : url,
//            wait : true,
			insertDiv :id + 'Page',
			param : {
				type : type
			}
		});
    }
    
    function loadSearchStandardizationPage(type) {
    	$.loadHtmlByUrl({
			url : '/idm/tb/management/search',
			insertDiv :'standardizationPage',
//            wait : true,
			param : {
				type : type
			}
		});
    }
})();

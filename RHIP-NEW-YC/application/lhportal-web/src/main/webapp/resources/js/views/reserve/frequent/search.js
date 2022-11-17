var frequentSearch = (function() {
	//解决ie8 下placeholder兼容性
	if( !('placeholder' in document.createElement('input')) ){  
		   
	    $('input[placeholder],textarea[placeholder]').each(function(){   
	      var that = $(this),   
	      text= that.attr('placeholder');   
	      if(that.val()===""){   
	        that.val(text).addClass('placeholder');   
	      }   
	      that.focus(function(){   
	        if(that.val()===text){   
	          that.val("").removeClass('placeholder');   
	        }   
	      })   
	      .blur(function(){   
	        if(that.val()===""){   
	          that.val(text).addClass('placeholder');   
	        }   
	      })   
	      .closest('form').submit(function(){   
	        if(that.val() === text){   
	          that.val('');   
	        }   
	      });   
	    });   
	  }  
	
	$(function() {
		search(1);
		/*$("#frequentName").focus(function(){
			$(this).val("").css("color","#4F4F4F");
		});*/
		$("#frequentSearchBtn").click(function(){
			search(1);
		});
		$("#frequentSearchBtn").onEnter(function(){
			search(1);
		});
		$("#toAdd").click(function() {
			
			clear('frequentContactsForm');
            $("#frequentNameSpan").empty();
            $("#genderSpan").empty();
            $("#telephoneSpan").empty();
            $("#cardNoSpan").empty();
            $("#birthdaySpan").empty();
            if($("#addFrequentForm").css("display")=="block"){
				$('#addFrequentForm').slideToggle();
			}
			
			$('#addFrequentForm').slideToggle();
		});
	});

	function search(indexPage) {
		var option = {
			url:"/userSpace/reserve/frequent/list",
			insertDiv:"listDiv",
			param:{
				indexPage:indexPage
			}
		};
		$("#frequentSearch").submitFormLoadHtml(option);
		/*$('#addFrequentForm').fadeOut();*/
	}
	
	return {
		search : search
	};
})();
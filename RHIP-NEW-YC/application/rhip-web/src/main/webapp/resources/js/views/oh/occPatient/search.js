var occPatientSearch = (function() {
	$(function() { 
            /*职业病人档案查询*/
            $("#occPatientBtnSearch").click(function(e) {
				e.preventDefault();//防止整个页面刷新
                search(1);
            });
            $("#initAdd").click(function() {
            	initAdd();
            });
            $("#pass").click(function() {
            	isPass("确认审核通过?","1");
            });
            $("#unpass").click(function() {
            	isPass("确认退回?","2");
            });
            
            search(1);
            $("#occPatientBtnSearch").onEnter(search, 1);
            document.onkeydown = function (e) { 
            	var theEvent = window.event || e; 
            	var code = theEvent.keyCode || theEvent.which; 
            	if (code == 13) { 
            		search(1); 
            	}
            };   
            
            //$("#context").change(selContextChanged);
            //util.checkBoxAll("reportChk","reportChkRef");
	});

	function search(indexPage) { 
		var searchObj = {
			url : "/oh/occPatient/employeeInfolist",
			insertDiv : "resultDiv",
			param : {
				indexPage : indexPage
			}
		};
		$("#occPatientSearchForm").submitFormLoadHtml(searchObj);
	};
	
	function initAdd(){
		$("#mainSearchDiv").hide();
		var option = {
				url : "/oh/occPatient/initAddView",
				insertDiv : "operationDiv"//,
//				param :{
//					operatorType:'3'
//				}
		};
		$.loadHtmlByUrl(option);
	}

	function toggle(obj,tableId) {
		$(obj).toggleClass("ico-top");
		$(obj).toggleClass("ico-bottom");
		$("#" + tableId).toggle();
	};

	function isPass(msg,opType){
	var chk_employeeInfoId="";
	 $('input[name="employeeInfoIds"]:checked').each(function(){    
		 chk_employeeInfoId+=$(this).val();
		 chk_employeeInfoId+=",";
      });    
	 if(chk_employeeInfoId.length==0 ){
		 layer.alert('你还没有选择任何内容！', {icon:0,title:'提示'});   
		 return;
	 }
	 	layer.confirm(msg, {icon:1, title:'确认提示'}, function(index){
			$.getJsonByUrl({
		    	url : "/oh/occPatient/verifyEmployeeInfo",
	            callback:function(data){
	            	layer.alert(data.message, {icon:0,title:'提示'});
	            	if (data.result) {
	            		search($("#currentPage").val());
	        		}
	    		},
		    	param:{
		    		employeeInfoId:chk_employeeInfoId,
		    		opType:opType
		    	}
			 });
			layer.close(index);
		});
	}
	
	return {
        search : search,
      //  add:add,
       // caseAdd:caseAdd,
       // caseEdit:caseEdit,
      //  print:print,
       // edit:edit,
        isPass:isPass,
        toggle:toggle
	};
})();


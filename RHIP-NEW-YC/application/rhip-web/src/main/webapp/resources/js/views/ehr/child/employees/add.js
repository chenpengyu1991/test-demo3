var addEmployees = (function() {
	var pageIndex = $('#pageIndex').val();
    var searchType=$('#searchType').val();
    var validate = $("#employeesForm").easyValidate();
    validate.addExtension("diseaseHistoryVali",diseaseHistoryVali);
	$(function() {
        if($("#flag").val()=="2"){
        	$("#button_save").hide();
        	$("#employeesForm").find("input").attr("disabled",true);
        }
        
        $("#button_print").click(function(){
			var reportClass=$("#employeesForm").attr("class");
			$("#employeesForm").removeClass();
			/*if($("#companys0").val().length>11){
				$("#healthCardDiv1").css("height", "90px");
			}*/
        	$("#printDiv").jqprint(
        			{
        			     debug: false, //如果是true则可以显示iframe查看效果（iframe默认高和宽都很小，可以再源码中调大），默认是false
        			     importCSS: true, //true表示引进原来的页面的css，默认是true。（如果是true，先会找$("link[media=print]")，若没有会去找$("link")中的css文件）
        			     printContainer: true, //表示如果原来选择的对象必须被纳入打印（注意：设置为false可能会打破你的CSS规则）。
        			     operaSupport: true//表示如果插件也必须支持歌opera浏览器，在这种情况下，它提供了建立一个临时的打印选项卡。默认是true
        			});
        	$("#employeesForm").addClass(reportClass);
        	//$("#healthCardDiv1").css("height", "100px");
        });
       $("input[name='idcard']").on("blur", function () {
    	   
    	   checkedIdcard();
       });
        
       $('#cancelBtn').click(function () {
           $('#child-exam-input-box').empty();
           $('#child-exam-input-box').hide();
           $('#child-exam-list-box').show();
           employeesSearch.search(1);
       });
         
         
         $("#button_save").click(function() {
        	 debugger;
        	 var idCardValue = $.trim($("input[name='idcard']").val());
         	var personId=$("#text_personId").val();
         	// var babyCardNo=null;
         	//if($("#id").val()==""){
         		$.getJsonByUrl({
                    url: "/employees/getChildInfo",
                    param: {
                        idCard: idCardValue,
                        personId:personId,
                        id:$("#id").val(),
                        physicalExaminationDate:$("input[name='physicalExaminationDate']").val()
                    },
                    callback: function (data) {
                        if (data) {
                       	 if(data.timeFlag=="1"){
                       		layer.alert("该人员进一年内已体检！", {icon:0,title:'提示'});
                       		 return false;
                       	 }else{
                        		savePersonInfo();
                      	 }
                        }else{
                        	layer.alert("该人员未建档,请先建档！", {icon:0,title:'提示'});
                       	 return false;
                        }
                    }
                   
                });
         		//} else{
           		//savePersonInfo();
          	 //}
              
        	 
        	 
         });
         $("input[name='diseaseHistoryFlag']").click(function(){
        	if( $("input[name='diseaseHistoryFlag']:checked").val()=='2'){
        		$(".diseaseHistoryFlag").show();
        	}else{
        		
        		$(".diseaseHistoryFlag").find("input").val("");
        		$(".diseaseHistoryFlag").find("input").attr("checked",false);
        		$(".diseaseHistoryFlag").hide();
        	}
         });
     });
	
	function checkedIdcard(){
    	var idCardValue = $.trim($("input[name='idcard']").val());
    	var personId=$("#text_personId").val();
    	// var babyCardNo=null;
         $.getJsonByUrl({
             url: "/employees/getChildInfo",
             param: {
                 idCard: idCardValue,
                 personId:personId,
                 id:null,
                 physicalExaminationDate:null
             },
             callback: function (data) {
                 if (data) {
                	 /*if(data.timeFlag=="1"){
                		 layer.alert("该人员进一年内已体检!");
                		 return false;
                	 }else{*/
                		 //$("#physicalExaminationNo").val(data.physicalExaminationNo);
                    	 $("input[name='idcard']").val(data.idCard);
                         $("input[name='name']").val(data.name);
                         $("#text_personId").val(data.personId);
                         if(data.idCard!=null){
                        	 if (validate.validate("idcard"))
                 			{
                 			var Age = new Date().getFullYear() - new Date(IC.getBirthday(data.idCard)).Format("yyyy/MM/dd").substring(0,4);
                 			$("input[name='age']").val(Age);
                 			}
                         }
                         if(data.birthday!=null&&data.idCard==null){
                        	 $("input[name='age']").val(new Date().getFullYear() -new Date(data.birthday).Format("yyyy/MM/dd").substring(0,4));
                         }
                         $("input[name='genders']").each(function(){
                          	if($(this).val()==data.gender){
                          		$(this).attr("checked","true");
                          	}
                          	
                          });
                	 }
                 /*}else{
                	 
                	 layer.alert("该人员未建档,请先建档!");
                	 return false;
                 }*/
             }
            
         });
 
	}
	function savePersonInfo(fn){
		var result = validate.validateForm();
    	if(!result){
    		return false;
    	}
		var option = "保存成功";
		$("#person_info_errbox").empty();
		$("#employeesForm").submitFormGetJson({
			url: "/employees/saveEmployees",
			wait:true,
			callback: function (data) {
				if(data=="1"){
					layer.alert(option, {icon:0,title:'提示'}, function(index){
						$('#child-exam-input-box').empty();
			             $('#child-exam-input-box').hide();
			             $('#child-exam-list-box').show();
			             $("input[name='name']").val("");
			             employeesSearch.search(1);
			             layer.close(index);
	                });
				}else{
					layer.alert("保存失败！", {icon:0,title:'提示'});
				}
				
				
			}
		});
		return true;
	}
	function diseaseHistoryVali(){
		var inputs=$("#diseaseHistorySpan").find("input");
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
    Date.prototype.Format = function (fmt) { //author: meizz
        var o = {
            "M+": this.getMonth() + 1, //月份
            "d+": this.getDate(), //日
            "h+": this.getHours(), //小时
            "m+": this.getMinutes(), //分
            "s+": this.getSeconds(), //秒
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度
            "S": this.getMilliseconds() //毫秒
        };
        if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }
    
    function showst(checkId,someId) {
        if ($("#" +checkId).attr("checked") == "checked"){
            $("#"+someId).show();
        }
    }

    return {
    	savePersonInfo:savePersonInfo
    };
})();

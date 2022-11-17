var cdmEvaAdd = (function () {

  var validate = null;
  //初始化
  $(function () {
    validate = $("#evaluation-form").easyValidate();
    validate.addExtension("riskFactorVali",riskFactorVali);
    validate.addExtension("healthGuidanceVali",healthGuidanceVali);
    $("#save-btn-external").click(save)
    $("#addOldDepressed").on("click" ,function(){
      	 checkOldDepressedStatus();
       });
  });

  function save() {
    var result=validate.validateForm();
    if(!result){
      return;
    }
    $("#evaluation-form").submitFormGetJson({
      url : "/physicalExamExternal/saveEvaluation",
      wait : true,
      callback : function(data)
      {
        if (data == true)
        {
        	layer.alert("保存成功！", {icon:0,title:'提示'});
        } else{
        	layer.alert("保存失败！", {icon:0,title:'提示'});
        }
      }
    });
  }
  function checkOldDepressedStatus(){
     	var personId =$("#personId").val();
		$.getJsonByUrl({
            url : "/personRecord/checkEchStatus",
            wait : true,
            param:{personId:personId},
            callback : function(data) {
               if($.isEmpty(data.examRecordId)){
				    addOldDepressed(personId, "");
                }else{
                	addOldDepressed(personId,data.examRecordId);
                }
            }
         });
     }
  function addOldDepressed(personId,examRecordId){
 	 var depressedDialog = {
 	            url : contextPath + "/hm/manage/addDepressed",
 	            height : 600,
 	            width : 600,
 	            title : "老年人抑郁量表" ,
 	            id :"depressedDialog",
 	            param : {
 	            	examRecordId:examRecordId,
 					personId: personId,
 	            	editflag:'edit',
 	            	sourceFlag:'2',
 	            	ehrId:$("input[name='ehrId']").val()
 	            }
 	        };
 	        $.dialog(depressedDialog);
  }
  function calculateAssessment() {
    var score = toNumber($(":checked[name='eatingAssessment']").val())
        + toNumber($(":checked[name='cleaningAssessment']").val())
        + toNumber($(":checked[name='clothingAssessment']").val()) + toNumber(
            $(":checked[name='defecationAssessment']").val())
        + toNumber($(":checked[name='exerciseAssessment']").val());
    if (score >= 0 && score <= 3) {
      $(":radio[name='lifeAbilitySelfAssessment'][value='1']").click();
    } else if (score >= 4 && score <= 8) {
      $(":radio[name='lifeAbilitySelfAssessment'][value='2']").click();
    } else if (score >= 9 && score <= 18) {
      $(":radio[name='lifeAbilitySelfAssessment'][value='3']").click();
    } else {
      $('input:radio[name="lifeAbilitySelfAssessment"]').eq(3).click();
      $(":radio[name='lifeAbilitySelfAssessment'][value='4']").click();
    }
  }
  function riskFactorVali() {
    var inputs=$("#ttbRisk").find("input[type='checkbox']");
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
  function healthGuidanceVali() {
    var inputs=$("#ttbhealth").find("input[type='checkbox']");
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
  function toNumber(num) {
    var n = parseInt(num);
    if (isNaN(n)) {
      return 0;
    } else {
      return n;
    }
  }
  return {
    calculateAssessment: calculateAssessment
  };
})();
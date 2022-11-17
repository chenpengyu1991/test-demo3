/**
 * Created by jingqiu on 17-3-25.
 */
var editChildExam = (function() {
    var validation;
    $(function() {
        validation = $('#childExaminationForm').easyValidate();
        $('#saveChildExamBtn').click(function () {
            saveExam();
        });
        $('#cancelChildExamBtn').click(function () {
            layer.confirm("确认离开？",function(index){
                layer.close(index);
                var idCard=$("#idCard").val();
                childList.viewChildExams(idCard);
            });
        });
        if ($(':checked[name="followupSick"]').val() == '2') {
            $('#followupSickDetail').show();
        } else {
            $('#followupSickDetail').hide();
        }
        
        $(':checked[name="tcmHealthManageService"]').each(function(){
   		 if($(this).val()=='99'){
   			 $('#tcmHealthManageDetail').show();
   		 }else{
   			 $('#tcmHealthManageDetail').hide();
   		 }
   		 
   	 });
           
           $(':checked[name="guidanceCategory"]').each(function(){
        		 if($(this).val()=='9'){
        			 $('#guidanceCategoryDetail').show();
        		 }else{
        			 $('#guidanceCategoryDetail').hide();
        		 }
        		 
        	 });
        $('#cPhysicalExamAge').change(function() {
            var cPhysicalExamAge = $(this).val();
            var examineAgeGroup = $("#examineAgeGroup").val();
            $.loadHtmlByUrl({
                url: '/childHealthExamine/loadExamDetail',
                insertDiv: 'examDetail',
                param: {
                    examineAgeGroup: examineAgeGroup,
                    cPhysicalExamAge: cPhysicalExamAge
                },
                callback: function() {
                    validation = $('#childExaminationForm').easyValidate();
                    eventProcess();
                }
            })
        });

        //异常选项动作
        eventProcess();
    });

    /**　保存体检表 */
    function saveExam() {
        var result = validation.validateForm();
        if (!result) {
            return;
        }
        /*var babyCardNo = $('#childExaminationForm').find('#babyCardNo').val();*/
        var idCard = $('#childExaminationForm').find('#idCard').val();
        $('#childExaminationForm').submitFormGetJson({
            url: "/childHealthExamine/saveChildExamine",
            wait: true,
            callback: function(result) {
                if (result.success) {
                	layer.alert("保存成功！", {icon:0,title:'提示'});
                    childList.viewChildExams(idCard);
                } else {
                	layer.alert(result.message, {icon:0,title:'提示'});
                }
            }
        });
    }

    function eventProcess() {
        organSelect.initOrg('checkOrganCode');
        $(':radio[name="heartLungAnomalySign"]').change(function () {
            showAnomalyDesc('heartLungAnomalySign', 'heartLungAnomalyDesc');
        });
        $(':radio[name="abdominalPalp"]').change(function () {
            showAnomalyDesc('abdominalPalp', 'abdominalPalpAnomalyDesc');
        });
        $(':radio[name="followupSick"]').change(function () {
            if ($(':checked[name="followupSick"]').val() == '2') {
                $('#followupSickDetail').show();
            } else {
                $('#followupSickDetail').hide();
            }
        });
        $(':radio[name="referralFlag"]').change(function () {
            if ($(':checked[name="referralFlag"]').val() == '2') {
                $('#referralDetail').show();
            } else {
                $('#referralDetail').hide();
                $('#referralReason').val(null);
                $('#referralHospitalName').val(null);
                $('#referralDeptName').val(null);
            }
        });
        $(':input[name="guidanceCategory"]').on("click",function () {
         	 if($(':checked[name="guidanceCategory"]').length==0){
         		 $('#guidanceCategoryDetail').hide();
         	 }
         	 $(':checked[name="guidanceCategory"]').each(function(){
         		 if($(this).val()=='9'){
         			 $('#guidanceCategoryDetail').show();
         		 }else{
         			$('input[name="mgOpinion"]').val("");
         			 $('#guidanceCategoryDetail').hide();
         		 }
         		 
         	 });
          });
        $("input[name='stature']").on("blur",function(){
        	if($("input[name='stature']").val().length>0&&$("input[name='bodyWeight']").val().length>0){
        		var num=($("input[name='bodyWeight']").val()/$("input[name='stature']").val())*100;
        		$($("input[name='bodyWeightStature']")).val(num.toFixed(2));
        	}
        	
        });
        $("input[name='bodyWeight']").on("blur",function(){
        	
        	if($("input[name='stature']").val().length>0&&$("input[name='bodyWeight']").val().length>0){
        		var num=($("input[name='bodyWeight']").val()/$("input[name='stature']").val())*100;
        		$($("input[name='bodyWeightStature']")).val(num.toFixed(2));
        	}
        	
        });
        $(':input[name="tcmHealthManageService"]').on("click",function () {
        	 if($(':checked[name="tcmHealthManageService"]').length==0){
        		 $('#tcmHealthManageDetail').hide();
        	 }
        	 $(':checked[name="tcmHealthManageService"]').each(function(){
        		 if($(this).val()=='99'){
        			 $('#tcmHealthManageDetail').show();
        		 }else{
        			 $('#tcmHealthManageDetail').hide();
        		 }
        		 
        	 });
         });
    }

    function showAnomalyDesc(radioName, descId) {
        if ($(':checked[name="' + radioName + '"]').val() == '2') {
            $('#'+descId).show();
        } else {
            $('#'+descId).val(null);
            $('#'+descId).hide();
        }
    }
})();
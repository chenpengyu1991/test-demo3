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
                var babyCardNo=$("#babyCardNo").val();
                childList.viewChildExams(babyCardNo);
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
        var babyCardNo = $('#childExaminationForm').find('#babyCardNo').val();
        $('#childExaminationForm').submitFormGetJson({
            url: "/childHealthExamine/saveChildExamine",
            wait: true,
            callback: function(result) {
                if (result.success) {
                	layer.alert("保存成功！", {icon:0,title:'提示'});
                    childList.viewChildExams(babyCardNo);
                } else {
                	layer.alert(result.message, {icon:0,title:'提示'});
                }
            }
        });
    }

    function eventProcess() {
        organSelect.initOrg('checkOrganCode');
        $(':radio[name="skinInspectionAnomalySign"]').change(function () {
            showAnomalyDesc('skinInspectionAnomalySign', 'skinInspectionAnomalyDesc');
        });
        $(':radio[name="childrenComplexionCode"]').change(function () {
            showAnomalyDesc('childrenComplexionCode', 'complexionOther', '9');
        });
        $(':radio[name="eyeappearanceSign"]').change(function () {
            showAnomalyDesc('eyeappearanceSign', 'eyeAppearanceInspectionDesc');
        });
        $(':radio[name="earappearanceSign"]').change(function () {
            showAnomalyDesc('earappearanceSign', 'earappearanceDesc');
        });
        $(':radio[name="oralExamination"]').change(function () {
            showAnomalyDesc('oralExamination', 'oralExaminationDesc');
        });
        $(':radio[name="heartLungAnomalySign"]').change(function () {
            showAnomalyDesc('heartLungAnomalySign', 'heartLungAnomalyDesc');
        });
        $(':radio[name="abdominalPalp"]').change(function () {
            showAnomalyDesc('abdominalPalp', 'abdominalPalpAnomalyDesc');
        });
        $(':radio[name="limbActivityAnomalySign"]').change(function () {
            showAnomalyDesc('limbActivityAnomalySign', 'limbActivityDesc');
        });
        $(':radio[name="umbilicalCordCheck"]').change(function () {
            showAnomalyDesc('umbilicalCordCheck', 'umbilicalCordCheckDesc');
        });
        $(':radio[name="analGenitaliaCheck"]').change(function () {
            showAnomalyDesc('analGenitaliaCheck', 'analGenitaliaAnomalyDesc');
        });
        /*$(':radio[name="followupSick"]').change(function () {
            showAnomalyDesc('followupSick', 'otherDiseaseState', '15');
        });*/
        
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
        $(':radio[name="afClosureFlag"]').change(function () {
            if ($(':checked[name="afClosureFlag"]').val() == '11') {
                $('#teethDiameter').show();
            } else {
                $('#afTransverseDiameter').val(null);
                $('#bregmaDiameter').val(null);
                $('#teethDiameter').hide();
            }
        });
        
        $(':input[name="guidanceCategory"]').click(function () {
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

    function showAnomalyDesc(radioName, descId, conditionValue) {
        var value = conditionValue || '2';
        if ($(':checked[name="' + radioName + '"]').val() == value) {
            $('#'+descId).show();
        } else {
            $('#'+descId).val(null);
            $('#'+descId).hide();
        }
    }
})();
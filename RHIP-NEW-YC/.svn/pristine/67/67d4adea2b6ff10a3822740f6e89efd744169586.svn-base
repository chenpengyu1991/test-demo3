/**
 * Created with IntelliJ IDEA.
 * User: rose
 * Date: 15-7-24
 */

var ehrBrowserBasicForPhysical = (function() {

    $(function() {

        $("#searchForPhysical").click(function(e){
        	e.preventDefault();
            searchForPhysical();
        });

        $("#healthServiceFeedbackForm").click(function(e){
        	e.preventDefault();
            searchForFeedback();
        });

      $("#addEch").on("click" ,function(e){
    	 e.preventDefault();
         checkEchStatus();
      });

    });

    function searchForPhysical(){
        var personId = $("#personIdForPhysical").val();
        /*$.removeDialog("resultForPhysicalDialog");
        var resultForPhysicalDialog = {
            id :"resultForPhysicalDialog",
            url : "/healthevent/resultForPhysical",
            height : 650,
            width : 1200,
            title : "体检列表",
            param : {
                personId:personId,
                timeType:"3",
                ehrType:"3"
            }
        };
        $.dialog(resultForPhysicalDialog);*/
        $.post(contextPath+'/healthevent/resultForPhysical', {
        	 personId:personId,
             timeType:"3",
             ehrType:"3"
        },
        function(ret) {
        	layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'peList',
        			  area: ['1250px', '600px'],
        			  title:'体检列表',
        			  content: ret
        		  });
        		});
        	});
    }

    /**
     * 健康服务反馈表
     */
    function searchForFeedback(){
        var personId = $("#personIdForPhysical").val();
        /*$.removeDialog("healthServiceFeedbackDialog");
        var healthServiceFeedbackDialog = {
            id :"healthServiceFeedbackDialog",
            url : "/ehrbrowser/basic/physicalExamination",
            height : 1100,
            width : 1000,
            title : "健康服务反馈表",
            param : {
                personId:personId,
                feedback:true
            }
        };
        $.dialog(healthServiceFeedbackDialog);*/
        $.post(contextPath+'/ehrbrowser/basic/physicalExamination', {
            personId:personId,
            feedback:true
        },
        function(ret) {
        	layui.use(['layer'], function() {
        		  var layer = layui.layer
        		  layer.open({
        			  type: 1,
        			  id:'peFeedback',
        			  area: ['1000px', '600px'],
        			  title:'健康服务反馈表',
        			  content: ret
        		  });
        		});
        	});
    }

  /**
   * 是否能够体质辨识检查
   */
  function checkEchStatus(){
    var personId =$("#personIdForPhysical").val();
    $.getJsonByUrl({
      url : "/personRecord/checkEchStatus",
      wait : true,
      param:{personId:personId},
      callback : function(data) {
        if($.isEmpty(data.examRecordId)){
          addEch(personId, "");
        }else{
          addEch(personId, data.examRecordId);
        }
      }
    });
  }

  /**
   * 弹出体质辨识画面
   */
  function addEch(personId, examRecordId){
    /*var echDialog = {
      url : "/ech/manage/report/init",
      height : 650,
      width : 1000,
      title : "老年人中医药健康管理服务记录表" ,
      id :"echDialog",
      param : {
        personId: personId,
        examRecordId:examRecordId,
        editflag:'view',
        sourceFlag:'2'
      }
    };
    $.dialog(echDialog);*/
    
    $.post(contextPath+'/ech/manage/report/init',
    		{
    		personId: personId,
	        examRecordId:examRecordId,
	        editflag:'view',
	        sourceFlag:'2'
		     }, 
		function(ret){
			  layer.open({
				  type: 1,
				  id:'echDialog',
				  area: ['1000px', '650px'],
				  title:'老年人中医药健康管理服务记录表',
				  content: ret,
    			  success: function(layero, index){
  				    console.log(layero, index);
  				    $('#iden_index').val(index);
  				  }
			  });
    	});
  }

    function cdmPhysical(personId, ehrId){
        var loadByUrlOption = {
            url : "/cdm/standardization/phyExamination/externalView",
            param : {
                personId : personId,
                ehrId : ehrId
            },
            insertDiv : "physicalDetailId"
        };
        $.loadHtmlByUrl(loadByUrlOption);
    }

    function studentPhysical(personId, ehrId){
        var loadByUrlOption = {
            url : "/hm/studentExam/viewStudentExam/"+personId+"/"+ehrId,
            insertDiv : "physicalDetailId"
        };
        $.loadHtmlByUrl(loadByUrlOption);
    }

    function oldPhysical(personId,ehrId){
    	if (!personId){
			return;
		}

		var loadHtmlByUrlOption = {
			url: "/hm/manage/view",
			insertDiv: "physicalDetailId",
			param: {
				personId : personId,
                ehrId : ehrId,
                liciTiJianView:'liciTiJianView'
			}
		};
		$.loadHtmlByUrl(loadHtmlByUrlOption);
    }

    function physical(personId, ehrId){
        var loadByUrlOption = {
            url : "/physicalExam/index/"+personId+"/"+ehrId,
            param : {
                /*personId : personId,
                ehrId : ehrId*/
            },
            insertDiv : "physicalDetailId"
        };
        $.loadHtmlByUrl(loadByUrlOption);
    }

    /***
     * 健康档案个人体检表
     * @param personId
     * @param ehrId
     */
    function ehrphysical(personId, ehrId){
        var loadByUrlOption = {
            url : "/ehrbrowser/basic/viewPhysicalExam",
            param : {
                personId : personId,
                ehrId : ehrId
            },
            insertDiv : "physicalDetailId"
        };
        $.loadHtmlByUrl(loadByUrlOption);
    }
    return {
        cdmPhysical : cdmPhysical,
        studentPhysical : studentPhysical,
        oldPhysical : oldPhysical,
        physical : physical,
        ehrphysical:ehrphysical
    };
})();

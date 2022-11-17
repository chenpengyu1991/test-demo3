/**
 * Created by bagen on 18-5-21.
 */
var editChildExam = (function() {
  $(function() {
    var validation;
    validation = $('#evaluation-form').easyValidate();
    //构筑动态机构下拉框
    organSelect.initOrgForChild('checkOrganCode');
    //保存按钮事件
   $('#saveChildExamBtn').click(function () {
      saveExam();
    });
    //返回按钮时间
    $('#cancelChildExamBtn').click(function (e) {
    	e.preventDefault();
      // layer.confirm("确认离开？",function(index){
      //   layer.close(index);
      //
      // });
      echChildrenSearch.returnSearch();
    });
    //身份证判断事件
    $("#idCard").on("blur", function () {
      var idCardValue = $.trim($("#idCard").val());
      if (idCardValue.length == 15 || idCardValue.length == 18) {
        $.getJsonByUrl({
          url: "/personRecord/getPersonByIdcard",
          param: {
            idCard: idCardValue
          },
          callback: function (data) {
            if (data) {
              if (!data.healthFileNo) {
                layer.alert("此人员尚未建档，请先给此人员创建健康档案！", {icon:0,title:'提示'});
              } else {
                $("#personId").val(data.id);
                $("#name").val(data.name);
              }
            }else{
              $("#personId").val("");
              $("#name").val("");
              layer.alert("此人员尚未建档，请先给此人员创建健康档案！", {icon:0,title:'提示'});
            }
          }
        });
      }
    });

    $('#cPhysicalExamAge').change(function() {
      var cPhysicalExamAge = $(this).val();
      $.loadHtmlByUrl({
        url: '/ech/children/changeAge',
        insertDiv :"maindetailDiv",
        param: {
          cPhysicalExamAge: cPhysicalExamAge
        }
      })
    });
  });

  /**　保存体检表 */
  function saveExam() {
    var validation = $('#evaluation-form').easyValidate();
    var result = validation.validateForm();
    if (!result) {
      return;
    }
    if($.isEmpty($("#personId").val())) {
    	layer.alert("此人员尚未建档，请先给此人员创建健康档案！", {icon:0,title:'提示'});
      return;
    }
    $('#evaluation-form').submitFormGetJson({
      url: "/ech/children/save",
      wait: true,
      callback: function(result) {
		layui.use('layer', function(){
        			var layer = layui.layer;
        			if (result.success) {
        				layer.alert('保存成功！', {icon:0,title:'提示'}, function(){
							 echChildrenSearch.search();
        					layer.closeAll();
        				});
        			} else {
        				layer.alert(result.message, {icon:0,title:'提示'});
					}
        		});
      }
    });
  }

  /*打印*/
    function print(){
      var type="";
        $.each($("input[name='tcmHealthManageService']:checkbox:checked"),function(){
           // window.alert("你选了："+$('input[type=checkbox]:checked').length+"个，其中有："+$(this).val());
            type+=$(this).val();
            type+=",";
        });
        var url = contextPath + "/ech/children/printChildHealthCare?type=" + type;
        util.printPage(url);
        // $("#printPage").jqprint();
    }

    return {
        print: print
    };
})();
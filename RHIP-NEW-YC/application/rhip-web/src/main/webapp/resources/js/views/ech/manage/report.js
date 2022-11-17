var echReport = (function() {
  var validate = null;
  $(function() {
    validate = $("#reportFormId").easyValidate();
    initForm();
    enableChangeConfirm();


    $(':checked[name="qiQualityGuidance"]').each(function(){
      if($(this).val()=='6'){
        $('.qiQualityGuidanceDetail').show();
      }else{
        $('.qiQualityGuidanceDetail').hide();
      }

    });
    $(':checked[name="yangQualityGuidance"]').each(function(){
      if($(this).val()=='6'){
        $('.yangQualityGuidanceDetail').show();
      }else{
        $('.yangQualityGuidanceDetail').hide();
      }

    });

    $(':checked[name="yinDeficiencyGuidance"]').each(function(){
      if($(this).val()=='6'){
        $('.yinDeficiencyGuidanceDetail').show();
      }else{
        $('.yinDeficiencyGuidanceDetail').hide();
      }

    });

    $(':checked[name="phlegmWetnessGuidance"]').each(function(){
      if($(this).val()=='6'){
        $('.phlegmWetnessGuidanceDetail').show();
      }else{
        $('.phlegmWetnessGuidanceDetail').hide();
      }

    });
    $(':checked[name="heatMediumGuidance"]').each(function(){
      if($(this).val()=='6'){
        $('.heatMediumGuidanceDetail').show();
      }else{
        $('.heatMediumGuidanceDetail').hide();
      }

    });


    $(':checked[name="bloodQualityGuidance"]').each(function(){
      if($(this).val()=='6'){
        $('.bloodQualityGuidanceDetail').show();
      }else{
        $('.bloodQualityGuidanceDetail').hide();
      }

    });

    $(':checked[name="qiStagnationGuidance"]').each(function(){
      if($(this).val()=='6'){
        $('.qiStagnationGuidanceDetail').show();
      }else{
        $('.qiStagnationGuidanceDetail').hide();
      }

    });

    $(':checked[name="specialQualityGuidance"]').each(function(){
      if($(this).val()=='6'){
        $('.specialQualityGuidanceDetail').show();
      }else{
        $('.specialQualityGuidanceDetail').hide();
      }

    });

    $(':checked[name="peacefulQualityGuidance"]').each(function(){
      if($(this).val()=='6'){
        $('.peacefulQualityGuidanceDetail').show();
      }else{
        $('.peacefulQualityGuidanceDetail').hide();
      }

    });


    $("#button_printId").click(function(e){
      e.preventDefault();
      var reportClass=$("#reportFormId").attr("class");
      $("#reportFormId").removeClass();
      $("#printDivId").jqprint(
          {
            debug: false, //如果是true则可以显示iframe查看效果（iframe默认高和宽都很小，可以再源码中调大），默认是false
            importCSS: true, //true表示引进原来的页面的css，默认是true。（如果是true，先会找$("link[media=print]")，若没有会去找$("link")中的css文件）
            printContainer: true, //表示如果原来选择的对象必须被纳入打印（注意：设置为false可能会打破你的CSS规则）。
            operaSupport: true//表示如果插件也必须支持歌opera浏览器，在这种情况下，它提供了建立一个临时的打印选项卡。默认是true
          });
      $("#reportFormId").addClass(reportClass);
    });

    $("#qiQualityGuidance").click(function(){
      if(!checkAllScore()){
    	  layui.use('layer', function(){
  			var layer = layui.layer;
  			layer.alert("服务记录表未填写完整！", {icon:0,title:'提示'});
  		});
        /*layer.alert("服务记录表未填写完整！");*/
        return;
      }
      var optionDatas = getOptionData();
      var result=validate.validateForm();
      if(!result){
        return;
      }
      var sourceFlag = $('#sourceFlag').val();
      if("3" != $('#sourceFlag').val()){
        $("#reportFormId").submitFormGetJson({
          url : contextPath + "/ech/manage/report/guidance",
          param : {
            optionDatas : util.Obj2str(optionDatas),
            sourceFlag:$('#sourceFlag').val()
          },
          callback : function(data) {
            var report="";
            if($('#sourceFlag').val()=="1"){
              report=data.report;
            }
            if($('#sourceFlag').val()=="2"){
              report=data;
            }
            $(".guidanceClass").show();
            $(".guidanceClass #tcmQiQuality").html("<b>"+data.report.tcmQiQuality+"</b>");
            $("#tcmYangQuality").html("<b>"+data.report.tcmYangQuality+"</b>");
            $("#tcmYinDeficiency").html("<b>"+data.report.tcmYinDeficiency+"</b>");
            $("#tcmPhlegmWetness").html("<b>"+data.report.tcmPhlegmWetness+"</b>");
            $("#tcmHeatMedium").html("<b>"+data.report.tcmHeatMedium+"</b>");
            $("#tcmBloodQuality").html("<b>"+data.report.tcmBloodQuality+"</b>");
            $("#tcmQiStagnation").html("<b>"+data.report.tcmQiStagnation+"</b>");
            $("#tcmSpecialQuality").html("<b>"+data.report.tcmSpecialQuality+"</b>");
            $("#tcmPeacefulQuality").html("<b>"+data.report.tcmPeacefulQuality+"</b>");
            //-----------------------------------------------------气虚质
            $(".guidanceClass").show();
            if(report.qiFlag =='1'){
              $("input[name='qiQualityGuidance']").each(function(){
                $(this).removeAttr("disabled");
                $(this).attr("checked",false);
              });
              $("#qiFlag1").show();
              $("#qiFlag3").hide();
            }if(report.qiFlag =='3'){
              $("input[name='qiQualityGuidance']").each(function(){
                $(this).removeAttr("disabled");
                $(this).attr("checked",false);

              });
              $("#qiFlag1").hide();
              $("#qiFlag3").show();
            }if(report.qiFlag=='0'){
              $("input[name='qiQualityGuidance']").each(function(){
                $(this).attr("disabled",true);
                $(this).attr("checked",false);
              });
              $("#qiFlag1").hide();
              $("#qiFlag3").hide();
            }

            //--------------------------------------------------------阳虚质
            if(report.yangFlag =='1'){
              $("input[name='yangQualityGuidance']").each(function(){
                $(this).removeAttr("disabled");
                $(this).attr("checked",false);
              });
              $("#yangFlag1").show();
              $("#yangFlag3").hide();
            }if(report.yangFlag =='3'){
              $("input[name='yangQualityGuidance']").each(function(){
                $(this).removeAttr("disabled");
                $(this).attr("checked",false);
              });
              $("#yangFlag3").show();
              $("#yangFlag1").hide();
            }if(report.yangFlag=='0'){
              $("input[name='yangQualityGuidance']").each(function(){
                $(this).attr("disabled",true);
                $(this).attr("checked",false);

              });
              $("#yangFlag1").hide();
              $("#yangFlag3").hide();
            }
            //--------------------------------------------------------阴虚质
            if(report.yinDeficiencyFlag =='1'){
              $("input[name='yinDeficiencyGuidance']").each(function(){
                $(this).removeAttr("disabled");
                $(this).attr("checked",false);
              });
              $("#yinDeficiencyFlag1").show();
              $("#yinDeficiencyFlag3").hide();
            }if(report.yinDeficiencyFlag =='3'){
              $("input[name='yinDeficiencyGuidance']").each(function(){
                $(this).removeAttr("disabled");
                $(this).attr("checked",false);
                $("#yinDeficiencyFlag3").show();
                $("#yinDeficiencyFlag1").hide();
              });
              $("#yinDeficiencyFlag3").show();
            }if(report.yinDeficiencyFlag=='0'){
              $("input[name='yinDeficiencyGuidance']").each(function(){
                $(this).attr("disabled",true);
                $(this).attr("checked",false);
              });
              $("#yinDeficiencyFlag1").hide();
              $("#yinDeficiencyFlag3").hide();
            }
            //--------------------------------------------------------痰湿质
            if(report.phlegmWetnessFlag =='1'){
              $("input[name='phlegmWetnessGuidance']").each(function(){
                $(this).removeAttr("disabled");
                $(this).attr("checked",false);
              });
              $("#phlegmWetnessFlag1").show();
              $("#phlegmWetnessFlag3").hide();
            }if(report.phlegmWetnessFlag =='3'){
              $("input[name='phlegmWetnessGuidance']").each(function(){
                $(this).removeAttr("disabled");
                $(this).attr("checked",false);
              });
              $("#phlegmWetnessFlag1").hide();
              $("#phlegmWetnessFlag3").show();
            }if(report.phlegmWetnessFlag=='0'){
              $("input[name='phlegmWetnessGuidance']").each(function(){
                $(this).attr("disabled",true);
                $(this).attr("checked",false);
              });
              $("#phlegmWetnessFlag1").hide();
              $("#phlegmWetnessFlag3").hide();
            }
            //--------------------------------------------------------湿热质
            if(report.heatMediumFlag =='1'){
              $("input[name='heatMediumGuidance']").each(function(){
                $(this).removeAttr("disabled");
                $(this).attr("checked",false);
              });
              $("#heatMediumFlag1").show();
              $("#heatMediumFlag3").hide();
            }if(report.heatMediumFlag =='3'){
              $("input[name='heatMediumGuidance']").each(function(){
                $(this).removeAttr("disabled");
                $(this).attr("checked",false);

              });
              $("#heatMediumFlag1").hide();
              $("#heatMediumFlag3").show();
            }if(report.heatMediumFlag=='0'){
              $("input[name='heatMediumGuidance']").each(function(){
                $(this).attr("disabled",true);
                $(this).attr("checked",false);

              });
              $("#heatMediumFlag1").hide();
              $("#heatMediumFlag3").hide();
            }
            //--------------------------------------------------------血瘀质
            if(report.bloodFlag =='1'){
              $("input[name='bloodQualityGuidance']").each(function(){
                $(this).removeAttr("disabled");
                $(this).attr("checked",false);
              });
              $("#bloodFlag1").show();
              $("#bloodFlag3").hide();
            }if(report.bloodFlag =='3'){
              $("input[name='bloodQualityGuidance']").each(function(){
                $(this).removeAttr("disabled");
                $(this).attr("checked",false);
              });
              $("#bloodFlag3").show();
              $("#bloodFlag1").hide();
            }if(report.bloodFlag=='0'){
              $("input[name='bloodQualityGuidance']").each(function(){
                $(this).attr("disabled",true);
                $(this).attr("checked",false);

              });
              $("#bloodFlag1").hide();
              $("#bloodFlag3").hide();
            }
            //--------------------------------------------------------气郁质
            if(report.qiStagnationFlag =='1'){
              $("input[name='qiStagnationGuidance']").each(function(){
                $(this).removeAttr("disabled");
                $(this).attr("checked",false);
              });
              $("#qiStagnationFlag1").show();
              $("#qiStagnationFlag3").hide();
            }if(report.qiStagnationFlag =='3'){
              $("input[name='qiStagnationGuidance']").each(function(){
                $(this).removeAttr("disabled");
                $(this).attr("checked",false);
              });
              $("#qiStagnationFlag3").show();
              $("#qiStagnationFlag1").hide();
            }if(report.qiStagnationFlag=='0'){
              $("input[name='qiStagnationGuidance']").each(function(){
                $(this).attr("disabled",true);
                $(this).attr("checked",false);
              });
              $("#qiStagnationFlag1").hide();
              $("#qiStagnationFlag3").hide();
            }
            //--------------------------------------------------------特禀质
            if(report.specialFlag =='1'){
              $("input[name='specialQualityGuidance']").each(function(){
                $(this).removeAttr("disabled");
                $(this).attr("checked",false);
              });
              $("#specialFlag1").show();
              $("#specialFlag3").hide();
            }if(report.specialFlag =='3'){
              $("input[name='specialQualityGuidance']").each(function(){
                $(this).removeAttr("disabled");
                $(this).attr("checked",false);
              });
              $("#specialFlag3").show();
              $("#specialFlag1").hide();
            }if(report.specialFlag=='0'){
              $("input[name='specialQualityGuidance']").each(function(){
                $(this).attr("disabled",true);
                $(this).attr("checked",false);
              });
              $("#specialFlag1").hide();
              $("#specialFlag3").hide();
            }
            //--------------------------------------------------------平和质
            if(report.peacefulFlag =='1'){
              $("input[name='peacefulQualityGuidance']").each(function(){
                $(this).removeAttr("disabled");
                $(this).attr("checked",false);
              });
              $("#peacefulFlag1").show();
              $("#peacefulFlag3").hide();
            }if(report.peacefulFlag =='3'){
              $("input[name='peacefulQualityGuidance']").each(function(){
                $(this).removeAttr("disabled");
                $(this).attr("checked",false);
              });
              $("#peacefulFlag1").hide();
              $("#peacefulFlag3").show();
            }if(report.peacefulFlag=='0'){
              $("input[name='peacefulQualityGuidance']").each(function(){
                $(this).attr("disabled",true);
                $(this).attr("checked",false);
              });
              $("#peacefulFlag1").hide();
              $("#peacefulFlag3").hide();
            }


          }
        });
      }



    });
    $(':input[name="qiQualityGuidance"]').on("click",function () {
      if($(':checked[name="qiQualityGuidance"]').length==0){
        $('.qiQualityGuidanceDetail').hide();
      }
      $(':checked[name="qiQualityGuidance"]').each(function(){
        if($(this).val()=='6'){
          $('.qiQualityGuidanceDetail').show();
        }else{
          $('.qiQualityGuidanceDetail').hide();
        }

      });
    });
    $(':input[name="yangQualityGuidance"]').on("click",function () {
      if($(':checked[name="yangQualityGuidance"]').length==0){
        $('.yangQualityGuidanceDetail').hide();
      }
      $(':checked[name="yangQualityGuidance"]').each(function(){
        if($(this).val()=='6'){
          $('.yangQualityGuidanceDetail').show();
        }else{
          $('.yangQualityGuidanceDetail').hide();
        }

      });
    });

    $(':input[name="yinDeficiencyGuidance"]').on("click",function () {
      if($(':checked[name="yinDeficiencyGuidance"]').length==0){
        $('.yinDeficiencyGuidanceDetail').hide();
      }
      $(':checked[name="yinDeficiencyGuidance"]').each(function(){
        if($(this).val()=='6'){
          $('.yinDeficiencyGuidanceDetail').show();
        }else{
          $('.yinDeficiencyGuidanceDetail').hide();
        }

      });
    });

    $(':input[name="phlegmWetnessGuidance"]').on("click",function () {
      if($(':checked[name="phlegmWetnessGuidance"]').length==0){
        $('.phlegmWetnessGuidanceDetail').hide();
      }
      $(':checked[name="phlegmWetnessGuidance"]').each(function(){
        if($(this).val()=='6'){
          $('.phlegmWetnessGuidanceDetail').show();
        }else{
          $('.phlegmWetnessGuidanceDetail').hide();
        }

      });
    });
    $(':input[name="heatMediumGuidance"]').on("click",function () {
      if($(':checked[name="heatMediumGuidance"]').length==0){
        $('.heatMediumGuidanceDetail').hide();
      }
      $(':checked[name="heatMediumGuidance"]').each(function(){
        if($(this).val()=='6'){
          $('.heatMediumGuidanceDetail').show();
        }else{
          $('.heatMediumGuidanceDetail').hide();
        }

      });
    });


    $(':input[name="bloodQualityGuidance"]').on("click",function () {
      if($(':checked[name="bloodQualityGuidance"]').length==0){
        $('.bloodQualityGuidanceDetail').hide();
      }
      $(':checked[name="bloodQualityGuidance"]').each(function(){
        if($(this).val()=='6'){
          $('.bloodQualityGuidanceDetail').show();
        }else{
          $('.bloodQualityGuidanceDetail').hide();
        }

      });
    });

    $(':input[name="qiStagnationGuidance"]').on("click",function () {
      if($(':checked[name="qiStagnationGuidance"]').length==0){
        $('.qiStagnationGuidanceDetail').hide();
      }
      $(':checked[name="qiStagnationGuidance"]').each(function(){
        if($(this).val()=='6'){
          $('.qiStagnationGuidanceDetail').show();
        }else{
          $('.qiStagnationGuidanceDetail').hide();
        }

      });
    });

    $(':input[name="specialQualityGuidance"]').on("click",function () {
      if($(':checked[name="specialQualityGuidance"]').length==0){
        $('.specialQualityGuidanceDetail').hide();
      }
      $(':checked[name="specialQualityGuidance"]').each(function(){
        if($(this).val()=='6'){
          $('.specialQualityGuidanceDetail').show();
        }else{
          $('.specialQualityGuidanceDetail').hide();
        }

      });
    });

    $(':input[name="peacefulQualityGuidance"]').on("click",function () {
      if($(':checked[name="peacefulQualityGuidance"]').length==0){
        $('.peacefulQualityGuidanceDetail').hide();
      }
      $(':checked[name="peacefulQualityGuidance"]').each(function(){
        if($(this).val()=='6'){
          $('.peacefulQualityGuidanceDetail').show();
        }else{
          $('.peacefulQualityGuidanceDetail').hide();
        }

      });
    });
    $(".optionNormal").click(function(){

      qiQualityGuidance();
    });
  });

  function qiQualityGuidance(){
    if(!checkAllScore()){
      //layer.alert("服务记录表未填写完整！");
      return;
    }
    var optionDatas = getOptionData();
    var result=validate.validateForm();
    if(!result){
      return;
    }
    var sourceFlag = $('#sourceFlag').val();
    if("3" != $('#sourceFlag').val()){
      $("#reportFormId").submitFormGetJson({
        url : contextPath + "/ech/manage/report/guidance",
        param : {
          optionDatas : util.Obj2str(optionDatas),
          sourceFlag:$('#sourceFlag').val()
        },
        callback : function(data) {
          var report="";
          if($('#sourceFlag').val()=="1"){
            report=data.report;
          }
          if($('#sourceFlag').val()=="2"){
            report=data;
          }
          //-----------------------------------------------------气虚质
          $(".guidanceClass").show();
          $(".guidanceClass #tcmQiQuality").html("<b>"+data.report.tcmQiQuality+"</b>");
          $("#tcmYangQuality").html("<b>"+data.report.tcmYangQuality+"</b>");
          $("#tcmYinDeficiency").html("<b>"+data.report.tcmYinDeficiency+"</b>");
          $("#tcmPhlegmWetness").html("<b>"+data.report.tcmPhlegmWetness+"</b>");
          $("#tcmHeatMedium").html("<b>"+data.report.tcmHeatMedium+"</b>");
          $("#tcmBloodQuality").html("<b>"+data.report.tcmBloodQuality+"</b>");
          $("#tcmQiStagnation").html("<b>"+data.report.tcmQiStagnation+"</b>");
          $("#tcmSpecialQuality").html("<b>"+data.report.tcmSpecialQuality+"</b>");
          $("#tcmPeacefulQuality").html("<b>"+data.report.tcmPeacefulQuality+"</b>");

          if(report.qiFlag =='1'){
            $("input[name='qiQualityGuidance']").each(function(){
              $(this).removeAttr("disabled");
              $(this).attr("checked",false);
              $(".qiQualityGuidanceDetail").hide();
              $("input[name='qiQualityGuidancestr']").val("");
              $(this).next().html("<b>"+$(this).next().html().replace(/<.*?>/g, "")+"</b>");
            });
            $("#qiFlag1").show();
            $("#qiFlag3").hide();
          }if(report.qiFlag =='3'){
            $("input[name='qiQualityGuidance']").each(function(){
              $(this).removeAttr("disabled");
              $(this).attr("checked",false);
              $(".qiQualityGuidanceDetail").hide();
              $("input[name='qiQualityGuidancestr']").val("");
              $(this).next().html("<b>"+$(this).next().html().replace(/<.*?>/g, "")+"</b>");
            });
            $("#qiFlag1").hide();
            $("#qiFlag3").show();
          }if(report.qiFlag=='0'){
            $("input[name='qiQualityGuidance']").each(function(){
              $(this).attr("disabled",true);
              $(this).attr("checked",false);
              $(this).next().html($(this).next().html().replace(/<.*?>/g, ""));
            });
            $("#qiFlag1").hide();
            $("#qiFlag3").hide();
          }

          //--------------------------------------------------------阳虚质
          if(report.yangFlag =='1'){
            $("input[name='yangQualityGuidance']").each(function(){
              $(this).removeAttr("disabled");
              $(this).attr("checked",false);
              $(".yangQualityGuidanceDetail").hide();
              $("input[name='yangQualityGuidancestr']").val("");
              $(this).next().html("<b>"+$(this).next().html().replace(/<.*?>/g, "")+"</b>");
            });
            $("#yangFlag1").show();
            $("#yangFlag3").hide();
          }if(report.yangFlag =='3'){
            $("input[name='yangQualityGuidance']").each(function(){
              $(this).removeAttr("disabled");
              $(this).attr("checked",false);
              $(".yangQualityGuidanceDetail").hide();
              $("input[name='yangQualityGuidancestr']").val("");
              $(this).next().html("<b>"+$(this).next().html().replace(/<.*?>/g, "")+"</b>");
            });
            $("#yangFlag3").show();
            $("#yangFlag1").hide();
          }if(report.yangFlag=='0'){
            $("input[name='yangQualityGuidance']").each(function(){
              $(this).attr("disabled",true);
              $(this).attr("checked",false);
              $(this).next().html($(this).next().html().replace(/<.*?>/g, ""));

            });
            $("#yangFlag1").hide();
            $("#yangFlag3").hide();
          }
          //--------------------------------------------------------阴虚质
          if(report.yinDeficiencyFlag =='1'){
            $("input[name='yinDeficiencyGuidance']").each(function(){
              $(this).removeAttr("disabled");
              $(this).attr("checked",false);
              $(".yinDeficiencyGuidanceDetail").hide();
              $("input[name='yinDeficiencyGuidancestr']").val("");
              $(this).next().html("<b>"+$(this).next().html().replace(/<.*?>/g, "")+"</b>");
            });
            $("#yinDeficiencyFlag1").show();
            $("#yinDeficiencyFlag3").hide();
          }if(report.yinDeficiencyFlag =='3'){
            $("input[name='yinDeficiencyGuidance']").each(function(){
              $(this).removeAttr("disabled");
              $(this).attr("checked",false);
              $(".yinDeficiencyGuidanceDetail").hide();
              $("input[name='yinDeficiencyGuidancestr']").val("");
              $(this).next().html("<b>"+$(this).next().html().replace(/<.*?>/g, "")+"</b>");
            });
            $("#yinDeficiencyFlag1").hide();
            $("#yinDeficiencyFlag3").show();
          }if(report.yinDeficiencyFlag=='0'){
            $("input[name='yinDeficiencyGuidance']").each(function(){
              $(this).attr("disabled",true);
              $(this).attr("checked",false);
              $(this).next().html($(this).next().html().replace(/<.*?>/g, ""));
            });
            $("#yinDeficiencyFlag1").hide();
            $("#yinDeficiencyFlag3").hide();
          }
          //--------------------------------------------------------痰湿质
          if(report.phlegmWetnessFlag =='1'){
            $("input[name='phlegmWetnessGuidance']").each(function(){
              $(this).removeAttr("disabled");
              $(this).attr("checked",false);
              $(".phlegmWetnessGuidanceDetail").hide();
              $("input[name='phlegmWetnessGuidancestr']").val("");
              $(this).next().html("<b>"+$(this).next().html().replace(/<.*?>/g, "")+"</b>");
            });
            $("#phlegmWetnessFlag1").show();
            $("#phlegmWetnessFlag3").hide();
          }if(report.phlegmWetnessFlag =='3'){
            $("input[name='phlegmWetnessGuidance']").each(function(){
              $(this).removeAttr("disabled");
              $(this).attr("checked",false);
              $(".phlegmWetnessGuidanceDetail").hide();
              $("input[name='phlegmWetnessGuidancestr']").val("");
              $(this).next().html("<b>"+$(this).next().html().replace(/<.*?>/g, "")+"</b>");
            });
            $("#phlegmWetnessFlag1").hide();
            $("#phlegmWetnessFlag3").show();
          }if(report.phlegmWetnessFlag=='0'){
            $("input[name='phlegmWetnessGuidance']").each(function(){
              $(this).attr("disabled",true);
              $(this).attr("checked",false);
              $(this).next().html($(this).next().html().replace(/<.*?>/g, ""));
            });
            $("#phlegmWetnessFlag1").hide();
            $("#phlegmWetnessFlag3").hide();
          }
          //--------------------------------------------------------湿热质
          if(report.heatMediumFlag =='1'){
            $("input[name='heatMediumGuidance']").each(function(){
              $(this).removeAttr("disabled");
              $(this).attr("checked",false);
              $(".heatMediumGuidanceDetail").hide();
              $("input[name='heatMediumGuidancestr']").val("");
              $(this).next().html("<b>"+$(this).next().html().replace(/<.*?>/g, "")+"</b>");
            });
            $("#heatMediumFlag1").show();
            $("#heatMediumFlag3").hide();
          }if(report.heatMediumFlag =='3'){
            $("input[name='heatMediumGuidance']").each(function(){
              $(this).removeAttr("disabled");
              $(this).attr("checked",false);
              $(".heatMediumGuidanceDetail").hide();
              $("input[name='heatMediumGuidancestr']").val("");
              $(this).next().html("<b>"+$(this).next().html().replace(/<.*?>/g, "")+"</b>");
            });
            $("#heatMediumFlag1").hide();
            $("#heatMediumFlag3").show();
          }if(report.heatMediumFlag=='0'){
            $("input[name='heatMediumGuidance']").each(function(){
              $(this).attr("disabled",true);
              $(this).attr("checked",false);
              $(this).next().html($(this).next().html().replace(/<.*?>/g, ""));
            });
            $("#heatMediumFlag1").hide();
            $("#heatMediumFlag3").hide();
          }
          //--------------------------------------------------------血瘀质
          if(report.bloodFlag =='1'){
            $("input[name='bloodQualityGuidance']").each(function(){
              $(this).removeAttr("disabled");
              $(this).attr("checked",false);
              $(".bloodQualityGuidanceDetail").hide();
              $("input[name='bloodQualityGuidancestr']").val("");
              $(this).next().html("<b>"+$(this).next().html().replace(/<.*?>/g, "")+"</b>");
            });
            $("#bloodFlag1").show();
            $("#bloodFlag3").hide();
          }if(report.bloodFlag =='3'){
            $("input[name='bloodQualityGuidance']").each(function(){
              $(this).removeAttr("disabled");
              $(this).attr("checked",false);
              $(".bloodQualityGuidanceDetail").hide();
              $("input[name='bloodQualityGuidancestr']").val("");
              $(this).next().html("<b>"+$(this).next().html().replace(/<.*?>/g, "")+"</b>");
            });
            $("#bloodFlag3").show();
            $("#bloodFlag1").hide();
          }if(report.bloodFlag=='0'){
            $("input[name='bloodQualityGuidance']").each(function(){
              $(this).attr("disabled",true);
              $(this).attr("checked",false);
              $(this).next().html($(this).next().html().replace(/<.*?>/g, ""));
            });
            $("#bloodFlag1").hide();
            $("#bloodFlag3").hide();
          }
          //--------------------------------------------------------气郁质
          if(report.qiStagnationFlag =='1'){
            $("input[name='qiStagnationGuidance']").each(function(){
              $(this).removeAttr("disabled");
              $(this).attr("checked",false);
              $(".qiStagnationGuidanceDetail").hide();
              $("input[name='qiStagnationGuidancestr']").val("");
              $(this).next().html("<b>"+$(this).next().html().replace(/<.*?>/g, "")+"</b>");
            });
            $("#qiStagnationFlag1").show();
            $("#qiStagnationFlag3").hide();
          }if(report.qiStagnationFlag =='3'){
            $("input[name='qiStagnationGuidance']").each(function(){
              $(this).removeAttr("disabled");
              $(this).attr("checked",false);
              $(".qiStagnationGuidanceDetail").hide();
              $("input[name='qiStagnationGuidancestr']").val("");
              $(this).next().html("<b>"+$(this).next().html().replace(/<.*?>/g, "")+"</b>");
            });
            $("#qiStagnationFlag3").show();
            $("#qiStagnationFlag1").hide();
          }if(report.qiStagnationFlag=='0'){
            $("input[name='qiStagnationGuidance']").each(function(){
              $(this).attr("disabled",true);
              $(this).attr("checked",false);
              $(this).next().html($(this).next().html().replace(/<.*?>/g, ""));
            });
            $("#qiStagnationFlag1").hide();
            $("#qiStagnationFlag3").hide();
          }
          //--------------------------------------------------------特禀质
          if(report.specialFlag =='1'){
            $("input[name='specialQualityGuidance']").each(function(){
              $(this).removeAttr("disabled");
              $(this).attr("checked",false);
              $(".specialQualityGuidanceDetail").hide();
              $("input[name='specialQualityGuidancestr']").val("");
              $(this).next().html("<b>"+$(this).next().html().replace(/<.*?>/g, "")+"</b>");
            });
            $("#specialFlag1").show();
            $("#specialFlag3").hide();
          }if(report.specialFlag =='3'){
            $("input[name='specialQualityGuidance']").each(function(){
              $(this).removeAttr("disabled");
              $(this).attr("checked",false);
              $(".specialQualityGuidanceDetail").hide();
              $("input[name='specialQualityGuidancestr']").val("");
              $(this).next().html("<b>"+$(this).next().html().replace(/<.*?>/g, "")+"</b>");
            });
            $("#specialFlag3").show();
            $("#specialFlag1").hide();
          }if(report.specialFlag=='0'){
            $("input[name='specialQualityGuidance']").each(function(){
              $(this).attr("disabled",true);
              $(this).attr("checked",false);
              $(this).next().html($(this).next().html().replace(/<.*?>/g, ""));
            });
            $("#specialFlag1").hide();
            $("#specialFlag3").hide();
          }
          //--------------------------------------------------------平和质
          if(report.peacefulFlag =='1'){
            $("input[name='peacefulQualityGuidance']").each(function(){
              $(this).removeAttr("disabled");
              $(this).attr("checked",false);
              $(".peacefulQualityGuidanceDetail").hide();
              $("input[name='peacefulQualityGuidancestr']").val("");
              $(this).next().html("<b>"+$(this).next().html().replace(/<.*?>/g, "")+"</b>");
            });
            $("#peacefulFlag1").show();
            $("#peacefulFlag2").hide();
          }if(report.peacefulFlag =='2'){
            $("input[name='peacefulQualityGuidance']").each(function(){
              $(this).removeAttr("disabled");
              $(this).attr("checked",false);
              $(".peacefulQualityGuidanceDetail").hide();
              $("input[name='peacefulQualityGuidancestr']").val("");
              $(this).next().html("<b>"+$(this).next().html().replace(/<.*?>/g, "")+"</b>");
            });
            $("#peacefulFlag2").show();
            $("#peacefulFlag1").hide();
          }if(report.peacefulFlag=='0'){
            $("input[name='peacefulQualityGuidance']").each(function(){
              $(this).attr("disabled",true);
              $(this).attr("checked",false);
              $(this).next().html($(this).next().html().replace(/<.*?>/g, ""));
            });
            $("#peacefulFlag1").hide();
            $("#peacefulFlag2").hide();
          }
        }
      });
    }




  }

  function initForm(){
    var editflag = $('#editflag').val();
    if(editflag == 'edit'){
      $("th div").mouseout(function() {
        if (this.id != "") {
          if (this.className != "optionSelect") {
            this.className = "optionNormal";
          }
        }
      });
      $("th div").mouseover(function() {
        if (this.id != "") {
          if (this.className != "optionSelect") {
            this.className = "optionOver";
          }
        }
      });
      $("th div").click(function() {
        if (this.id != "") {
          var ids = this.id.split('_');
          $("#" + ids[0] + "_1" ).attr("class", "optionNormal");
          $("#" + ids[0] + "_2" ).attr("class", "optionNormal");
          $("#" + ids[0] + "_3" ).attr("class", "optionNormal");
          $("#" + ids[0] + "_4" ).attr("class", "optionNormal");
          $("#" + ids[0] + "_5" ).attr("class", "optionNormal");
          this.className = "optionSelect";
          contentChanged = true;
          checkSorce($(this).data('optionNo'));
        }
      });
      $("#save").click(function(e) {
    	e.preventDefault();
        saveReport();
      });
      $("#calcTZJG").click(function(e) {
    	e.preventDefault();
        calcTizhijieguo();
      });
     /* $("#cancelButton").click(function(e) {
	    e.preventDefault();
        closeEchCalc();
      });*/
    }else{
      $('.required').removeClass("required");
    }
    initScore();
  }

  /**
   * 初始化分数
   */
  function initScore(){
    var options = $('#options').val();
    if(!$.isEmpty(options)){
      var optionDatas = options.split(';');
      for(var option in optionDatas){
        $("#" + optionDatas[option] ).attr("class", "optionSelect");
      }
    }
  }

  /**
   * 检查33道题是否全部选择
   */
  function checkAllScore(){
    var i = 0;
    var selectFlag = true;
    for (i = 1; i < 34; i++) {
      if(!checkSorce(i)){
        selectFlag = false;
      }
    }
    return selectFlag
  }
  /**
   * 检查题目是否被选择
   */
  function checkSorce(optionId){
    var selectFlag = $("th div[data-option-no='"+ optionId + "']").hasClass('optionSelect');
    if(!selectFlag){
      $("th div[id='option"+ optionId + "_1']").parent().prev().addClass('optionLose');
    }else{
      $("th div[id='option"+ optionId + "_1']").parent().prev().removeClass('optionLose');
    }
    return selectFlag
  }

  /**
   * 保存辨识表
   */
  function saveReport(){
    if(!checkAllScore()){
    	layer.alert("服务记录表未填写完整！", {icon:0,title:'提示'});
      return;
    }
    var optionDatas = getOptionData();
    var result=validate.validateForm();
    if(!result){
      return;
    }
    var sourceFlag = $('#sourceFlag').val();
    var isInfo=$("#isInfo").val();
    if("1" == $('#sourceFlag').val()){//来源：中医药
      $("#reportFormId").submitFormLoadHtml({
        url : "/ech/manage/report/save",
        wait : true,
        insertDiv : "result",
        param : {
          optionDatas : util.Obj2str(optionDatas),
          sourceFlag:$('#sourceFlag').val()
        },
        callback : function(data) {
        	
          if (data.indexOf("fail") > -1) {
      			layer.alert("保存失败！");
          }else{
    			var index = layer.alert("保存成功！", {icon:0,title:'提示'}, function() {
    				layer.close(index);
    				layer.close($('#iden_index').val());
    				$("#report").hide();
    				$("#result").show();
    				echManageSearch.manageSearch(1);
    	            $("#ech-phyexam-res-back-btn").on("click", function(){
    	        		$("#result").hide();
    	        		if(isInfo){
    	                	$("#ech-manage-list-box").show();
    	                }else{
    	                	echIdenList.search(1);
    	                	$("#ech-person-phyexam-list-box").show();
    	                }
    	        	});
    			});
            contentChanged = false;
            return false;
          }
        }
      });
    }else{//来源：健康档案
      $("#reportFormId").submitFormGetJson({
        url : "/ech/manage/report/save1",
        wait : true,
        param : {
          optionDatas : util.Obj2str(optionDatas),
          sourceFlag:$('#sourceFlag').val()
        },
        callback : function(data) {
          if ($.isEmpty(data)) {
      			layer.alert("保存失败！", {icon:0,title:'提示'});
          }else{
	  			var index = layer.alert("保存成功！", {icon:0,title:'提示'}, function() {
	  				layer.close(index);
	  				layer.close($('#iden_index').val());
	  				updateEch(data);
	  				$("#CMedicine").show();
	  			});
            contentChanged = false;
            return false;
          }
        }
      });
    }

  }

  /**
   * 计算中医体质结果
   */
  function calcTizhijieguo(){
    if(!checkAllScore()){
		layer.alert("服务记录表未填写完整！", {icon:0,title:'提示'});
      return;
    }
    var optionDatas = getOptionData();
    /*var result=validate.validateForm();
     if(!result){
     return;
     }*/
    var sourceFlag = $('#sourceFlag').val();
    /*var echCalc = {
      id :"d1",
      url : "/ech/manage/report/calc",
      height : 320,
      width : 450,
      param : {
        optionDatas : util.Obj2str(optionDatas),
        sourceFlag:$('#sourceFlag').val()
      },
      title : "计算结果",
      showClose : false
    };
    $.dialog(echCalc);*/
    
    $.post(contextPath+'/ech/manage/report/calc',
    		{ optionDatas : util.Obj2str(optionDatas),
             sourceFlag:$('#sourceFlag').val()
		     }, 
		function(ret){
    		  layer.open({
    			  type: 1,
    			  id:'echCalcDialog',
    			  area: ['450px', '320px'],
    			  title:'计算结果',
    			  content: ret,
    			  success: function(layero, index){
				    $("#cancelButton").click(function(e) {
					    e.preventDefault();
				        layer.close(index);
				      });
				  }
    		  });
    	});
  }

/*  function closeEchCalc(){
    $.removeDialog("d1");
		layer.closeAll();
  }*/
  
  /**
   * 更新健康档案中体检记录页面中的健康体质
   *
   */
  function updateEch(data){
    $('input[name="PersonalPhyExamDTO.physiqueExamination.tcmPeacefulQuality"][value="' + data.peacefulFlag + '"]').attr("checked", 'checked');
    $('input[name="PersonalPhyExamDTO.physiqueExamination.tcmQiQuality"][value="' + data.qiFlag + '"]').attr("checked", 'checked');
    $('input[name="PersonalPhyExamDTO.physiqueExamination.tcmYangQuality"][value="' + data.yangFlag + '"]').attr("checked", 'checked');
    $('input[name="PersonalPhyExamDTO.physiqueExamination.tcmYinDeficiency"][value="' + data.yinDeficiencyFlag + '"]').attr("checked", 'checked');
    $('input[name="PersonalPhyExamDTO.physiqueExamination.tcmPhlegmWetness"][value="' + data.phlegmWetnessFlag + '"]').attr("checked", 'checked');
    $('input[name="PersonalPhyExamDTO.physiqueExamination.tcmHeatMedium"][value="' + data.heatMediumFlag + '"]').attr("checked", 'checked');
    $('input[name="PersonalPhyExamDTO.physiqueExamination.tcmBloodQuality"][value="' + data.bloodFlag + '"]').attr("checked", 'checked');
    $('input[name="PersonalPhyExamDTO.physiqueExamination.tcmQiStagnation"][value="' + data.qiStagnationFlag + '"]').attr("checked", 'checked');
    $('input[name="PersonalPhyExamDTO.physiqueExamination.tcmSpecialQuality"][value="' + data.specialFlag + '"]').attr("checked", 'checked');
    //更新慢病体检表中的体制辨识 add by Hao Jingqiu 2017-03-29
    $('input[name="tcmPeacefulQuality"][value="' + data.peacefulFlag + '"]').attr("checked", 'checked');
    $('input[name="tcmQiQuality"][value="' + data.qiFlag + '"]').attr("checked", 'checked');
    $('input[name="tcmYangQuality"][value="' + data.yangFlag + '"]').attr("checked", 'checked');
    $('input[name="tcmYinDeficiency"][value="' + data.yinDeficiencyFlag + '"]').attr("checked", 'checked');
    $('input[name="tcmPhlegmWetness"][value="' + data.phlegmWetnessFlag + '"]').attr("checked", 'checked');
    $('input[name="tcmHeatMedium"][value="' + data.heatMediumFlag + '"]').attr("checked", 'checked');
    $('input[name="tcmBloodQuality"][value="' + data.bloodFlag + '"]').attr("checked", 'checked');
    $('input[name="tcmQiStagnation"][value="' + data.qiStagnationFlag + '"]').attr("checked", 'checked');
    $('input[name="tcmSpecialQuality"][value="' + data.specialFlag + '"]').attr("checked", 'checked');
    $('#identificationId').val(data.id);
    $.removeDialog ("echDialog");
  }
  function getOptionData(){
    var optionDatas = [];
    $("th div[id^='option']").each(function(){
      var optionData = {};
      if($(this).hasClass("optionSelect")){
        optionData['optionNo'] = $(this).data('optionNo');
        var ids = this.id.split('_');
        optionData['score'] = ids[1];
        optionDatas.push(optionData);
      }
    });
    return optionDatas;
  }

  /**
   * 打印健康教育处方指导意见
   */
  function printHealthEducation(type){
    var url = contextPath + "/ech/manage/report/printHealthEducation?type=" + type;
    util.printPage(url);
  }
  return {
    printHealthEducation:printHealthEducation,
    updateEch:updateEch

  }
})();
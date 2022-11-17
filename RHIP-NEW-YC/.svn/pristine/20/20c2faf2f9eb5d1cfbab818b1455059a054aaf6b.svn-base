var cwhCommon = (function() {
	var pageIndex;
	var searchType;
    $(function() {
    	pageIndex = $('#pageIndex').val();
    	searchType=$('#searchType').val();
        initOrg();
        validate = $("#childrenForm").easyValidate();
        $("#homeVillage_address").change(displayHrAddress);
        /*$("#followup-add-btn").click(function() {
        	
        	var dialog = {
                    url : "/ihm/addNeonatalVisitDetail",
                    param : {},
                    height : 650,
                    width : 880,
                    title : "新生儿家庭访视" ,
                    id :"dialog"
                };
                $.dialog(dialog);
        	
		});*/
        
        $('#followup-add-btn').click(function() {
            $('#child-exam-list-box').hide();
            $('#child-exam-input-box').show();
            $.loadHtmlByUrl({
                url: '/ihm/addNeonatalVisitDetail',
                insertDiv: 'child-exam-input-box',
                param: {
                	pageIndex:pageIndex,
                	searchType:searchType
                }
            })
        });
        $('#cancelChildExamBtn').click(function () {
            $('#child-exam-input-box').empty();
            $('#child-exam-input-box').hide();
            $('#child-exam-list-box').show();
            childSearch.search(1);
        });
        
        $("#button_saves").click(function() {
        	//$("#firstFlg").remove();
        	debugger;
            var result = validate.validateForm();
            if (!result) {
                return false;
            }
        	  $("#childrenForm").submitFormGetJson({
                  url: "/ihm/saveNeonatalVisitDetail",
                  wait : true,
                  param: {
                      /*indexPage: 1,
                      personId: personId,
                      nowAddressCode: nowAddressCode,
                      householderAddressCode: householderAddressCode*/
                  },
                  callback: function (data) {
                	  layer.alert(data, {icon:0,title:'提示'}, function(index){
                			  $('#cancelChildExamBtn').click();
                			  layer.close(index);
                	  });
                		  
                  	}
        	  });
        	  return true;
        });
        initShowInput();
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
        
        $(':radio[name="complicationHistory"]').change(function () {
            if ($(':checked[name="complicationHistory"]').val() == '3') {
                $('#complicationHistoryDetail').show();
            } else {
                $('#complicationHistoryDetail').hide();
                $('#otherComplicationHistory').val(null);
            }
        });
        
        $(':radio[name="lastdeliverycode"]').change(function () {
            if ($(':checked[name="lastdeliverycode"]').val() == '40') {
                $('#lastdeliverycodeDetail').show();
            } else {
                $('#lastdeliverycodeDetail').hide();
                $('#lastdeliverycodedesc').val(null);
            }
        });
        $(':radio[name="asphyxiaSign"]').change(function () {
            if ($(':checked[name="asphyxiaSign"]').val() == '2') {
                $('#asphyxiaSignDetail').show();
            } else {
                $('#asphyxiaSignDetail').hide();
                $('#apgarValue').val(null);
            }
        });
        
        $(':radio[name="skinVisionInspection"]').change(function () {
        	debugger;
            if ($(':checked[name="skinVisionInspection"]').val() == '99') {
                $('#skinVisionInspectionDetail').show();
            } else {
                $('#skinVisionInspectionDetail').hide();
                $('#skinVisionInspectionDesc').val(null);
            }
        });
        $(':radio[name="diseaseScreeningProject"]').change(function () {
            if ($(':checked[name="diseaseScreeningProject"]').val() == '3') {
                $('#diseaseScreeningProjectDetail').show();
            } else {
                $('#diseaseScreeningProjectDetail').hide();
                $('#diseaseScreeningDesc').val(null);
            }
        });
        
        $(':radio[name="bregmaTension"]').change(function () {
            if ($(':checked[name="bregmaTension"]').val() == '9') {
                $('#bregmaTensiontDetail').show();
            } else {
                $('#bregmaTensiontDetail').hide();
                $('#bregmaTensionsDesc').val(null);
            }
        });
        $(':radio[name="complexionCode"]').change(function () {
            if ($(':checked[name="complexionCode"]').val() == '9') {
                $('#complexionCodeDetail').show();
            } else {
                $('#complexionCodeDetail').hide();
                $('#complexionCodesDesc').val(null);
            }
        });
        
    });
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
    
    
    function initShowInput() {
        showst("eyeappearanceSign","eyeAppearanceInspectionDesc");
        showst("limbActivityAnomalySign","limbActivityDesc");
        showst("earAppearanceInspection","earAppearanceInspectionDesc");
        showst("neckLumpSign","neckLumpDesc");
        showst("nasalCheckAnomaly","nasalCheckAnomalyDesc");
        showst("oralExaminationAnomaly","oralExaminationAnomalyDesc");
        showst("analExaminationAnomaly","analExaminationAnomalyDesc");
        showst("cardiacAuscuAnomaly","cardiacAuscuAnomalyDesc");
        showst("extGenitalCheckAnomaly","extGenitalCheckAnomalyDesc");
        showst("abdominalPalpAnomaly","abdominalPalpAnomalyDesc");
        showst("spinalCheckAnomaly","spinalCheckAnomalyDesc");
        showst("umbilicalCordCheck","umbilicalCordCheckDesc");
        showst("deformitySign","deformityDesc");

        if ($(':checked[name="referralFlag"]').val() == '2') {
            $('#referralDetail').show();
        } else {
            $('#referralDetail').hide();
            $('#referralReason').val(null);
            $('#referralHospitalName').val(null);
            $('#referralDeptName').val(null);
        }
        if ($(':checked[name="complicationHistory"]').val() == '3') {
            $('#complicationHistoryDetail').show();
        } else {
            $('#complicationHistoryDetail').hide();
            $('#otherComplicationHistory').val(null);
        }
        if ($(':checked[name="lastdeliverycode"]').val() == '40') {
            $('#lastdeliverycodeDetail').show();
        } else {
            $('#lastdeliverycodeDetail').hide();
            $('#lastdeliverycodedesc').val(null);
        }
        $(':radio[name="asphyxiaSign"]').change(function () {
            if ($(':checked[name="asphyxiaSign"]').val() == '2') {
                $('#asphyxiaSignDetail').show();
            } else {
                $('#asphyxiaSignDetail').hide();
                $('#apgarValue').val(null);
            }
        });

        if ($(':checked[name="skinVisionInspection"]').val() == '99') {
            $('#skinVisionInspectionDetail').show();
        } else {
            $('#skinVisionInspectionDetail').hide();
            $('#skinVisionInspectionDesc').val(null);
        }
        if ($(':checked[name="diseaseScreeningProject"]').val() == '3') {
            $('#diseaseScreeningProjectDetail').show();
        } else {
            $('#diseaseScreeningProjectDetail').hide();
            $('#diseaseScreeningDesc').val(null);
        }

        if ($(':checked[name="bregmaTension"]').val() == '9') {
            $('#bregmaTensiontDetail').show();
        } else {
            $('#bregmaTensiontDetail').hide();
            $('#bregmaTensionsDesc').val(null);
        }
        if ($(':checked[name="complexionCode"]').val() == '9') {
            $('#complexionCodeDetail').show();
        } else {
            $('#complexionCodeDetail').hide();
            $('#complexionCodesDesc').val(null);
        }
    }

    function showst(checkId,someId) {
        if ($("#" +checkId).attr("checked") == "checked"){
            $("#"+someId).show();
        }
    }

    function viewChildExams() {
    	debugger;
        $('#child-exam-list-box').show();
        $('#child-exam-input-box').hide();
        $.loadHtmlByUrl({
            url: '/ihm/child/neonatalVisit/list',
            insertDiv: 'child-exam-list-box',
            param: {
            	pageIndex:pageIndex
                /*examineAgeGroup: childSearch.examineAgeGroup,
                babyCardNo: babyCardNo*/
            }
        })
    }
    
    function initOrg(){
    	init('hospitalCode','A100',['0']);//市级医院
    	init('superOrganCode','B100',[]);//卫生院
    	
    	var organType = $('#organType').val();
    	var unSelectType = $('#unSelectType').val();
    	init('organCode',$.isEmpty(organType)?'A100,B100,B200,G2':organType
    	,$.isEmpty(unSelectType)?[]:[unSelectType.split(',')]);//社区卫生服务站、妇幼保健所
    }
    
    /**
     * 初始化机构控件
     * orgId:控件ID
     * orgType:机构类型
     * unSelectType:不能选择的机构类型
     */
	function init(orgId,orgType,unSelectType){
        //机构下拉树设置
        var option={
            url:"/mdmOrganization/organationTree",
            unSelecteType:unSelectType,  //下来树不能类型：0：镇，B1:中心，B2:站
            param:{organType:orgType},  //查询机构类型,逗号分割
            selectFun:selectTreeFun
        };
        //机构自动检索设置
        var opb = {
            url:"/mdmOrganization/organationSelect",
            feild: {
                value: "organCode",
                lable: "organName"
            },
            param:{organType:orgType},  //查询机构类型,逗号分割
            selectFun:selectBoxFun
        };

        var hospitalCode=$("#" + orgId);
        if(hospitalCode.length>0){
            //初始化自动检索
            hospitalCode.selectBox(opb);
            //初始化下拉树
            hospitalCode.initTreeSelect(option);
        }
    }   
    
	function displayHrAddress() {
        var town = $("#homeTown_address option:selected").text();
        var street = $("#homeStreet_address option:selected").text();
        var village = $("#homeVillage_address option:selected").text();
        var result = '';
        if (town != '请选择')
            result = town;
        if (street != '请选择') {
            result = result + street;
        }
        if (village != '请选择')
            result = result + village;
        $("#tempHrValue").text(result);
        $("#orgHrName").val(result);
    }	
    /**
     * 机构下拉树回调
     */
    function selectTreeFun(data){
    	var orgType = $("input[name='orgType'][type='radio']:checked").val();
    	$('#genreCode' + orgType).val(data.type);
    	$('#genreCode').val(data.type);
    }
    /**
     * 机构自动检索回调
     */
    function selectBoxFun(data){
    	var orgType = $("input[name='orgType'][type='radio']:checked").val();
    	$('#genreCode' + orgType).val(data.attr('genreCode'));
    	$('#genreCode').val(data.attr('genreCode'));
    }
	function changeOrgType(){
		var orgType = $('input:radio[name="orgType"]:checked').val();
		if(orgType == '1'){
			$('#orgCode1').show();
			$('#orgCode2').hide();
			$('#orgCode3').hide();
			$('#orgCode4').hide();
		}else if(orgType == '2'){
			$('#orgCode1').hide();
			$('#orgCode2').show();
			$('#orgCode3').hide();
			$('#orgCode4').hide();
		}else if(orgType == '3'){
			$('#orgCode1').hide();
			$('#orgCode2').hide();
			$('#orgCode3').show();
			$('#orgCode4').hide();
		}else if(orgType == '4'){
			$('#orgCode1').hide();
			$('#orgCode2').hide();
			$('#orgCode3').hide();
			$('#orgCode4').show();
		}
	}    
	return {
		displayHrAddress: displayHrAddress,
		changeOrgType:changeOrgType
	};
})();




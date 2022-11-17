var familyVisit = (function () {

    $(function () {
        var pageIndex = $('#pageIndex').val();
        var searchType = $('#searchType').val();
        var validate = $("#childrenForm").easyValidate();
        $("#homeVillage_address").change(displayHrAddress);
        init('nextSupervisionPlace', 'B1,B2', []);//社区卫生服务站

        $("#homeVillage_address").removeAttr("reg");

        $("#textIdCard").on("blur", function () {
            if (!isNull($("#text_personId").val())){
                return;
            }
            var idCardValue = $.trim($("#textIdCard").val());
            $.getJsonByUrl({
                url: "/childHealthExamine/getChildInfo",
                param: {
                    idCard: idCardValue/*,
                     babyCardNo: babyCardNo*/
                },
                callback: function (data) {
                    if (data) {
                        setCommon(data);
                    }else {
                    	layer.alert("此人员尚未建档，请先给此人员创建健康档案！", {icon:0,title:'提示'});
                     }
                }
            });
        });

        $("#babyCardNo").on("blur", function () {
            if (!isNull($("#text_personId").val())){
                return;
            }
            var babyCardNo = $.trim($("#babyCardNo").val());
            $.getJsonByUrl({
                url: "/childHealthExamine/getChildInfo",
                param: {
                    //idCard: idCardValue,
                    babyCardNo: babyCardNo
                },
                callback: function (data) {
                    if (data) {
                        setCommon(data);
                    } else {
                    	layer.alert("此人员尚未建档，请先给此人员创建健康档案！", {icon:0,title:'提示'});
                    }
                }
            });
        });

        $('#cancelChildExamBtn').click(function (e) {
            e.preventDefault();
            layer.confirm("确认离开？",function(index){
                layer.close(index);
                doBack();
            });
        });

        $(':input:not(:disabled)', "#childrenForm").not(':button, :submit, :reset, :hidden').click(function () {
            if ($("input[name='managementFlag']:checked").val() == 2) {
                if ($(this).attr("name") != "neonatusName" && $(this).attr("name") != "babyCardNo"
                    && $(this).attr("name") != "neonatalGender" && $(this).attr("name") != "neonatusBirthday"
                    && $(this).attr("name") != "pacounty" && $(this).attr("name") != "patownShip"
                    && $(this).attr("name") != "pastreet" && $(this).attr("name") != "managementFlag"

                    && $(this).attr("name") != "pahouseNumber" && $(this).attr("name") != "fatherName"
                    && $(this).attr("name") != "fatherPhone" && $(this).attr("name") != "fatherBirthday"
                    && $(this).attr("name") != "motherName" && $(this).attr("name") != "matherPhone"
                    && $(this).attr("name") != "motherBirthday" && $(this).attr("name") != "obstetricInstitutionsName"

                    && $(this).attr("name") != "nextSupervisionPlace" && $(this).attr("name") != "supervisionDoctorCode"
                    && $(this).attr("name") != "nextSupervisionPlace" && $(this).attr("name") != "nextSupervisionDate"

                    && $(this).attr("name") != "lastdeliveryCode" && $(this).attr("name") != "gestationalWeek"
                    && $(this).attr("name") != "complicationHistory"


                    && $(this).attr("name") != "deformityDesc" && $(this).attr("name") != "diseaseScreeningDesc"
                    && $(this).attr("name") != "nextSupervisionPlace" && $(this).attr("name") != "limbActivityDesc"

                    && $(this).attr("name") != "earAppearanceInspectionDesc" && $(this).attr("name") != "neckLumpDesc"
                    && $(this).attr("name") != "nasalCheckAnomalyDesc"


                    && $(this).attr("name") != "oralExaminationAnomalyDesc" && $(this).attr("name") != "analExaminationAnomalyDesc"
                    && $(this).attr("name") != "cardiacAuscuAnomalyDesc" && $(this).attr("name") != "extGenitalCheckAnomalyDesc"

                    && $(this).attr("name") != "abdominalPalpAnomalyDesc" && $(this).attr("name") != "spinalCheckAnomalyDesc"
                    && $(this).attr("name") != "umbilicalCordCheckDesc"


                    && $(this).attr("name") != "referralHospitalName" && $(this).attr("name") != "referralDeptName"


                    && $(this).attr("name") != "bregmaTensionsDesc" && $(this).attr("name") != "skinVisionInspectionDesc"

                    && $(this).attr("name") != "referralReason" && $(this).attr("name") != "complexionCodesDesc"
                    && $(this).attr("name") != "otherComplicationHistory" && $(this).attr("name") != "abnormalChestAnomalyDesc"
                    && $(this).attr("name") != "neonatusIdcard"
                    && $(this).attr("name") != "eyeAppearanceInspectionDesc" && $(this).attr("name") != "lastdeliverycodedesc"


                ) {
                    if ($(this).attr("type") == "text" || $(this).attr("type") == undefined) {
                        if ($(this).val() != null && $(this).val() != undefined && $(this).val() != "") {
                            $(this).removeClass();
                        }
                    }
                    if ($(this).attr("type") == "radio" || $(this).attr("type") == "checkbox") {
                        if ($(this).attr("checked") != undefined) {
                            var inputname = $(this).attr("name");
                            if ($("input[name='" + inputname + "']:checked").length > 0) {
                                $("input[name='" + inputname + "']").parent().removeClass();
                            }

                        }
                    }


                }
            }
        })
        $(':input:not(:disabled)', "#childrenForm").not(':button, :submit, :reset, :hidden').on("blur", function () {
            if ($("input[name='managementFlag']:checked").val() == 2) {
                if ($(this).attr("name") != "neonatusName" && $(this).attr("name") != "babyCardNo"
                    && $(this).attr("name") != "neonatalGender" && $(this).attr("name") != "neonatusBirthday"
                    && $(this).attr("name") != "pacounty" && $(this).attr("name") != "patownShip"
                    && $(this).attr("name") != "pastreet" && $(this).attr("name") != "managementFlag"

                    && $(this).attr("name") != "pahouseNumber" && $(this).attr("name") != "fatherName"
                    && $(this).attr("name") != "fatherPhone" && $(this).attr("name") != "fatherBirthday"
                    && $(this).attr("name") != "motherName" && $(this).attr("name") != "matherPhone"
                    && $(this).attr("name") != "motherBirthday" && $(this).attr("name") != "obstetricInstitutionsName"

                    && $(this).attr("name") != "nextSupervisionPlace" && $(this).attr("name") != "supervisionDoctorCode"
                    && $(this).attr("name") != "nextSupervisionPlace" && $(this).attr("name") != "nextSupervisionDate"

                    && $(this).attr("name") != "lastdeliveryCode" && $(this).attr("name") != "gestationalWeek"
                    && $(this).attr("name") != "complicationHistory"


                    && $(this).attr("name") != "deformityDesc" && $(this).attr("name") != "diseaseScreeningDesc"
                    && $(this).attr("name") != "nextSupervisionPlace" && $(this).attr("name") != "limbActivityDesc"

                    && $(this).attr("name") != "earAppearanceInspectionDesc" && $(this).attr("name") != "neckLumpDesc"
                    && $(this).attr("name") != "nasalCheckAnomalyDesc"


                    && $(this).attr("name") != "oralExaminationAnomalyDesc" && $(this).attr("name") != "analExaminationAnomalyDesc"
                    && $(this).attr("name") != "cardiacAuscuAnomalyDesc" && $(this).attr("name") != "extGenitalCheckAnomalyDesc"

                    && $(this).attr("name") != "abdominalPalpAnomalyDesc" && $(this).attr("name") != "spinalCheckAnomalyDesc"
                    && $(this).attr("name") != "umbilicalCordCheckDesc"


                    && $(this).attr("name") != "referralHospitalName" && $(this).attr("name") != "referralDeptName"


                    && $(this).attr("name") != "bregmaTensionsDesc" && $(this).attr("name") != "skinVisionInspectionDesc"

                    && $(this).attr("name") != "referralReason" && $(this).attr("name") != "complexionCodesDesc"
                    && $(this).attr("name") != "otherComplicationHistory" && $(this).attr("name") != "abnormalChestAnomalyDesc"
                    && $(this).attr("name") != "neonatusIdcard"
                    && $(this).attr("name") != "eyeAppearanceInspectionDesc" && $(this).attr("name") != "lastdeliverycodedesc"
                    && $(this).attr("name") != "neonatusIdcard"


                ) {
                    if ($(this).attr("type") == "text" || $(this).attr("type") == undefined) {
                        if ($(this).val() != null && $(this).val() != undefined && $(this).val() != "") {
                            $(this).removeClass();
                        } else {
                            $(this).addClass("lose");
                        }
                    }
                    if ($(this).attr("type") == "radio" || $(this).attr("type") == "checkbox") {
                        if ($(this).attr("checked") != undefined) {
                            var inputname = $(this).attr("name");
                            if ($("input[name='" + inputname + "']:checked").length > 0) {
                                $("input[name='" + inputname + "']").parent().removeClass();
                            } else {
                                $("input[name='" + inputname + "']").parent().addClass("lose");
                            }

                        }
                    }


                }
            }
        })
        $('[name="feedingType"]').click(function () {
            if ($("input[name='feedingType']:checked").val() == "3") {
                $("input[name='eatMilkNumber']").removeAttr("disabled");
                $("input[name='eatMilkSupply']").removeAttr("disabled");
            } else {
                $("input[name='eatMilkNumber']").val("");
                $("input[name='eatMilkSupply']").val("");
                $("input[name='eatMilkNumber']").removeClass();
                $("input[name='eatMilkSupply']").removeClass();
                $("input[name='eatMilkNumber']").attr("disabled", true);
                $("input[name='eatMilkSupply']").attr("disabled", true);

            }

        });

        $("#button_saves").click(function (e) {
			e.preventDefault();
            var result = validate.validateForm();
            var flag;
            if ($("input[name='managementFlag']:checked").val() == 2) {
                $(':input:not(:disabled)', "#childrenForm").not(':button, :submit, :reset, :hidden').each(function () {
                    //不验证第三级地址
                    if ($(this).attr("name") != "paGroup") {
                        if ($(this).attr("type") == "text" || $(this).attr("type") == undefined) {
                            if ($(this).attr("name") != "neonatusIdcard") {
                                if ($(this).val() == null || $(this).val() == undefined || $(this).val() == "") {
                                    $(this).addClass("lose");
                                    flag = 1;
                                }
                            }

                        }
                        if ($(this).attr("type") == "radio" || $(this).attr("type") == "checkbox") {
                            if ($(this).attr("checked") == undefined) {
                                var inputname = $(this).attr("name");
                                if ($("input[name='" + inputname + "']:checked").length == 0) {
                                    $(this).parent().addClass("lose");
                                    flag = 1;
                                }

                            }
                        }
                    }
                });
            } else {
                $(':input:not(:disabled)', "#childrenForm")
                    .not(':button, :submit, :reset, :hidden').each(function () {

                    if ($(this).attr("name") != "neonatusName" && $(this).attr("name") != "babyCardNo"
                        && $(this).attr("name") != "neonatalGender" && $(this).attr("name") != "neonatusBirthday"
                        && $(this).attr("name") != "pacounty" && $(this).attr("name") != "patownShip"
                        && $(this).attr("name") != "pastreet" && $(this).attr("name") != "managementFlag"

                        && $(this).attr("name") != "pahouseNumber" && $(this).attr("name") != "fatherName"
                        && $(this).attr("name") != "fatherPhone" && $(this).attr("name") != "fatherBirthday"
                        && $(this).attr("name") != "motherName" && $(this).attr("name") != "matherPhone"
                        && $(this).attr("name") != "motherBirthday" && $(this).attr("name") != "obstetricInstitutionsName"

                        && $(this).attr("name") != "nextSupervisionPlace" && $(this).attr("name") != "supervisionDoctorCode"
                        && $(this).attr("name") != "nextSupervisionPlace" && $(this).attr("name") != "nextSupervisionDate"

                        && $(this).attr("name") != "lastdeliveryCode" && $(this).attr("name") != "gestationalWeek"
                        && $(this).attr("name") != "complicationHistory"


                        && $(this).attr("name") != "deformityDesc" && $(this).attr("name") != "diseaseScreeningDesc"
                        && $(this).attr("name") != "nextSupervisionPlace" && $(this).attr("name") != "limbActivityDesc"

                        && $(this).attr("name") != "earAppearanceInspectionDesc" && $(this).attr("name") != "neckLumpDesc"
                        && $(this).attr("name") != "nasalCheckAnomalyDesc"


                        && $(this).attr("name") != "oralExaminationAnomalyDesc" && $(this).attr("name") != "analExaminationAnomalyDesc"
                        && $(this).attr("name") != "cardiacAuscuAnomalyDesc" && $(this).attr("name") != "extGenitalCheckAnomalyDesc"

                        && $(this).attr("name") != "abdominalPalpAnomalyDesc" && $(this).attr("name") != "spinalCheckAnomalyDesc"
                        && $(this).attr("name") != "umbilicalCordCheckDesc"


                        && $(this).attr("name") != "referralHospitalName" && $(this).attr("name") != "referralDeptName"


                        && $(this).attr("name") != "bregmaTensionsDesc" && $(this).attr("name") != "skinVisionInspectionDesc"

                        && $(this).attr("name") != "referralReason" && $(this).attr("name") != "complexionCodesDesc"
                        && $(this).attr("name") != "otherComplicationHistory" && $(this).attr("name") != "abnormalChestAnomalyDesc"
                        && $(this).attr("name") != "eyeAppearanceInspectionDesc" && $(this).attr("name") != "lastdeliverycodedesc"


                    ) {
                        $(this).removeClass();
                        $(this).parent().removeClass();

                    }
                });
            }

            if (!result || flag == 1) {
                return false;
            }

            if($.isEmpty($("#text_personId").val())) {
                layui.use('layer',function(){
                    var layer=layui.layer;
                    layer.alert("此人员尚未建档，请先给此人员创建健康档案！", {icon:0,title:'提示'});
                })
                return;
            }
			$("#childrenForm").submitFormGetJson({
                url: "/childFamilyVisit/save",
                wait: true,
                callback: function (data) {
                    layui.use('layer',function(){
                        var layer=layui.layer;
                        layer.alert(data, {icon:0,title:'提示'});
						doBack();
                    })
                }
            });
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

        $(':radio[name="deformitySign"]').change(function () {
            if ($(':checked[name="deformitySign"]').val() == '2') {
                $('#deformitySignDetail').show();
            } else {
                $('#deformitySignDetail').hide();
                $('#deformityDesc').val(null);
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

        $(':radio[name="lastdeliveryCode"]').change(function () {
            if ($(':checked[name="lastdeliveryCode"]').val() == '40') {
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

        $(':radio[name="apgarValue"]').change(function () {
            if ($(':checked[name="apgarValue"]').val() == '01') {
                $('[name="apgarValueOneMin"]').show();
            } else {
                $('[name="apgarValueOneMin"]').hide();
                $('[name="apgarValueOneMin"]').val(null);
            }
        });

        $(':radio[name="apgarValue"]').change(function () {
            if ($(':checked[name="apgarValue"]').val() == '02') {
                $('[name="apgarValueFiveMin"]').show();
            } else {
                $('[name="apgarValueFiveMin"]').hide();
                $('[name="apgarValueFiveMin"]').val(null);
            }
        });

        $(':radio[name="skinVisionInspection"]').change(function () {
            if ($(':checked[name="skinVisionInspection"]').val() == '99') {
                $('#skinVisionInspectionDetail').show();
            } else {
                $('#skinVisionInspectionDetail').hide();
                $('#skinVisionInspectionDesc').val(null);
            }
        });

        $(':input[name="diseaseScreeningProject"]').on("click", function () {
            if ($(':checked[name="diseaseScreeningProject"]').length == 0) {
                $('#diseaseScreeningDetail').hide();
            }
            $(':checked[name="diseaseScreeningProject"]').each(function () {
                if ($(this).val() == '14') {
                    $('#diseaseScreeningDetail').show();
                } else {
                    $('#diseaseScreeningDetail').hide();
                }

            });
        });

        $(':input[name="healthGuidanceCategory"]').on("click", function () {
            if ($(':checked[name="healthGuidanceCategory"]').length == 0) {
                $('#healthGuidanceDetail').hide();
            }
            $(':checked[name="healthGuidanceCategory"]').each(function () {
                if ($(this).val() == '9') {
                    $('#healthGuidanceDetail').show();
                } else {
                    $('#healthGuidanceDetail').hide();
                }

            });
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

        $(':radio[name="skinVisionInspection"]').each(function () {
            if ($(this).val() == '02' || $(this).val() == '03' || $(this).val() == '04' || $(this).val() == '05' || $(this).val() == '06') {
                $(this).parent().hide();
            }
        })

        $(':radio[name="jaundicePartsCode"]').each(function () {
            if ($(this).val() == '5' || $(this).val() == '9') {
                $(this).parent().hide();
            }
        })

        $(':radio[name="complexionCode"]').each(function () {
            if ($(this).val() == '3' || $(this).val() == '4' || $(this).val() == '5') {
                $(this).parent().hide();
            }
        })
    });

    /**
     * 初始化机构控件
     * orgId:控件ID
     * orgType:机构类型
     * unSelectType:不能选择的机构类型
     */
    function init(orgId, orgType, unSelectType) {
        //机构下拉树设置
        var option = {
            url: "/mdmOrganization/organationTree",
            unSelecteType: unSelectType,  //下来树不能类型：0：镇，B1:中心，B2:站
            param: {organType: orgType},  //查询机构类型,逗号分割
            selectFun: selectTreeFun
        };
        //机构自动检索设置
        var opb = {
            url: "/mdmOrganization/organationSelect",
            feild: {
                value: "organCode",
                lable: "organName"
            },
            param: {organType: orgType},  //查询机构类型,逗号分割
            selectFun: selectBoxFun
        };

        var hospitalCode = $("#" + orgId);
        if (hospitalCode.length > 0) {
            //初始化自动检索
            hospitalCode.selectBox(opb);
            //初始化下拉树
            hospitalCode.initTreeSelect(option);
        }
    }

    /**
     * 机构下拉树回调
     * 设置当前选择机构的类型
     */
    function selectTreeFun(data) {
        $('#selectCodeType').val(data.type);
    }

    /**
     * 机构自动检索回调
     * 设置当前选择机构的类型
     */
    function selectBoxFun(data) {
        $('#selectCodeType').val(data.attr('genreCode'));
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

    function initShowInput() {
        showst("eyeappearanceSign", "eyeAppearanceInspectionDesc");
        showst("limbActivityAnomalySign", "limbActivityDesc");
        showst("earAppearanceInspection", "earAppearanceInspectionDesc");
        showst("neckLumpSign", "neckLumpDesc");
        showst("nasalCheckAnomaly", "nasalCheckAnomalyDesc");
        showst("oralExaminationAnomaly", "oralExaminationAnomalyDesc");
        showst("analExaminationAnomaly", "analExaminationAnomalyDesc");
        showst("cardiacAuscuAnomaly", "cardiacAuscuAnomalyDesc");
        showst("abnormalChestAnomaly", "abnormalChestAnomalyDesc");
        showst("extGenitalCheckAnomaly", "extGenitalCheckAnomalyDesc");
        showst("abdominalPalpAnomaly", "abdominalPalpAnomalyDesc");
        showst("spinalCheckAnomaly", "spinalCheckAnomalyDesc");
        showst("umbilicalCordCheck", "umbilicalCordCheckDesc");

        if ($(':checked[name="referralFlag"]').val() == '2') {
            $('#referralDetail').show();
        } else {
            $('#referralDetail').hide();
            $('#referralReason').val(null);
            $('#referralHospitalName').val(null);
            $('#referralDeptName').val(null);
        }
        if ($.trim($('[id="deformitySign"]').val()) == '2') {
            $('input[name="deformitySign"]').each(function () {
                if ($(this).val() == '2') {
                    $(this).attr("checked", true);
                }

            });
            $('#deformitySignDetail').show();
        } else {
            $('input[name="deformitySign"]').each(function () {
                if ($(this).val() == '1') {
                    $(this).attr("checked", true);
                }

            });
            $('#deformitySignDetail').hide();
            $('#deformityDesc').val(null);
        }

        if ($(':checked[name="complicationHistory"]').val() == '3') {
            $('#complicationHistoryDetail').show();
        } else {
            $('#complicationHistoryDetail').hide();
            $('#otherComplicationHistory').val(null);
        }
        if ($(':checked[name="lastdeliveryCode"]').val() == '40') {
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

        $(':radio[name="apgarValue"]').change(function () {
            if ($(':checked[name="apgarValue"]').val() == '01') {
                $('[name="apgarValueOneMin"]').show();
            } else {
                $('[name="apgarValueOneMin"]').hide();
                $('[name="apgarValueOneMin"]').val(null);
            }
        });

        $(':radio[name="apgarValue"]').change(function () {
            if ($(':checked[name="apgarValue"]').val() == '02') {
                $('[name="apgarValueFiveMin"]').show();
            } else {
                $('[name="apgarValueFiveMin"]').hide();
                $('[name="apgarValueFiveMin"]').val(null);
            }
        });

        if ($(':checked[name="skinVisionInspection"]').val() == '99') {
            $('#skinVisionInspectionDetail').show();
        } else {
            $('#skinVisionInspectionDetail').hide();
            $('#skinVisionInspectionDesc').val(null);
        }

        $(':checked[name="healthGuidanceCategory"]').each(function () {
            if ($(':checked[name="healthGuidanceCategory"]').length == 0) {
                $('#healthGuidanceDetail').hide();
            }
            if ($(this).val() == '9') {
                $('#healthGuidanceDetail').show();
            } else {
                $('#healthGuidanceDetail').hide();
            }

        });

        $(':checked[name="diseaseScreeningProject"]').each(function () {
            if ($(':checked[name="diseaseScreeningProject"]').length == 0) {
                $('#diseaseScreeningDetail').hide();
            }
            if ($(this).val() == '14') {
                $('#diseaseScreeningDetail').show();
            } else {
                $('#diseaseScreeningDetail').hide();
            }

        });

        $(':checked[name="feedingType"]').each(function () {
            if ($("input[name='feedingType']:checked").val() == "3") {
                $("input[name='eatMilkNumber']").removeAttr("disabled");
                $("input[name='eatMilkSupply']").removeAttr("disabled");
            } else {
                $("input[name='eatMilkNumber']").val("");
                $("input[name='eatMilkSupply']").val("");
                $("input[name='eatMilkNumber']").attr("disabled", true);
                $("input[name='eatMilkSupply']").attr("disabled", true);
                $("input[name='eatMilkNumber']").removeClass();
                $("input[name='eatMilkSupply']").removeClass();
            }
        });
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

    function showst(checkId, someId) {
        if ($("#" + checkId).attr("checked") == "checked") {
            $("#" + someId).show();
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

    function setCommon(data) {
        if($.isEmpty(data.healthFileNo)) {
        	layer.alert("此人员尚未建档，请先给此人员创建健康档案！", {icon:0,title:'提示'});
        }
        $("#textIdCard").val(data.idCard);
        $("#textIdCard").attr("readonly","readonly");
        if (isNull($("input[name='neonatusName']").val())) $("input[name='neonatusName']").val(data.name);
        $("#text_personId").val(data.id);
        if (data.babyCardNo != null && isNull($("input[name='babyCardNo']").val())) {
            $("input[name='babyCardNo']").val(data.babyCardNo);
        }
        if (data.idCard != null && isNull($("input[name='neonatusBirthday']").val())) {
            $("input[name='neonatusBirthday']").val(IC.getBirthday(data.idCard));
        }
        if (data.birthday != null && data.idCard == null && isNull($("input[name='neonatusBirthday']").val())) {
            $("input[name='neonatusBirthday']").val(new Date(data.birthday).Format("yyyy/MM/dd"));

        }


        //if(data.flag=="2"){
        if (isNull($("input[name='fatherName']").val())) $("input[name='fatherName']").val(data.fatherName);
        if (isNull($("input[name='fatherPhone']").val())) $("input[name='fatherPhone']").val(data.fatherPhone);
        if (isNull($("input[name='motherName']").val())) $("input[name='motherName']").val(data.motherName);
        if (isNull($("input[name='matherPhone']").val())) $("input[name='matherPhone']").val(data.matherPhone);
        if (isNull($("input[name='fatherOccupationalGroupCode']").val())) $("input[name='fatherOccupationalGroupCode']").val(data.fatherOccupationalGroupCode);
        if (isNull($("input[name='fatherBirthday']").val())) $("input[name='fatherBirthday']").val(data.fatherBirthday);
        if (isNull($("input[name='motherOccupationalGroupCode']").val())) $("input[name='motherOccupationalGroupCode']").val(data.motherOccupationalGroupCode);
        if (isNull($("input[name='motherBirthday']").val())) $("input[name='motherBirthday']").val(data.motherBirthday);
        //}
        if (isNull($("input[name='neonatalGender']").val()) || $("input[name='neonatalGender']").val() == "0") {
            $("input[name='neonatalGender']").each(function () {
                if ($(this).val() == data.gender) {
                    $(this).attr("checked", "true");
                }

            });
        }
        //地址
        if (data.patownShip != null && $("#homeTown_address").attr("idd") != null) {
            if (isNull($('#homeTown_address').val())) {
                $('#homeTown_address').val(data.patownShip);
                var iddStreet = $("#homeTown_address").attr("idd").replace('townId', '');
                orgUtil.getStreetOpting(iddStreet, data.pastreet, '', null);
            }
            if (isNull($('#text_pahouseNumber').val())) $('#text_pahouseNumber').val(data.pahouseNumber);
            setTimeout(function () {
                var tempHrValue = '';
                tempHrValue += $('#homeTown_address :selected').text();
                tempHrValue += $('#homeStreet_address :selected').text();
                //tempHrValue += $('#homeVillage_address :selected').text();
                $('#tempHrValue').text(tempHrValue);
            }, 500);
        }
    }

    function doBack(){
            familyVisitSearch.search(1);
            $('#child-exam-input-box').hide();
            $('#child-exam-list-box').show();
    }

    return {
        displayHrAddress: displayHrAddress
    };
})();

function isNull(obj) {
    if (obj == null || obj == "") {
        return true;
    }
}
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cleave/cleave.min.js"></script>
<link href="${pageContext.request.contextPath}/js/fineuploader/fineuploader-3.4.1.css" rel="stylesheet"/>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/js/fineuploader/jquery.fineuploader-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}/js/views/he/upload/upload.js" type="text/javascript"></script>
<%--<script type="text/javascript">
    $(document).ready(function () {
        healthEducationUpload.uploadFile("heMaterialFile", "/mongoFile/uploadFile/A00000006", "/mongoFile/deleteFile/A00000006");
    });
</script>--%>

<div class="dm-followup-from-content">
    <form id="dm-followup-hbp-from" class="dm-followup-from">
        <input type="hidden" id="age" value="${age}"/>
        <input type="hidden" name="id" value="${hbp.id}"/>
        <input type="hidden" name="reasonFollowId" id="reasonFollowId" value="${reasonFollowId}"/>
        <input type="hidden" name="planId" value="${hbp.planId}">
        <input type="hidden" name="planType" id="planType" value="${planType}"/>
        <div class="postcontent">
            <div class="postdiv">
                <fieldset class="layui-elem-field" style="margin-top: -10px;">
                    <legend>随访填写</legend>
                    <table class="posttable">
                        <colgroup>
                            <col style="min-width: 100px; width: 30%"/>
                            <col style="min-width: 150px; width: 70%"/>
                        </colgroup>
                        <tr>
                            <th><label class="required">随访日期</label></th>
                            <td>
                                <%-- <tag:dateInput onlypast="true" name="visitDate" style="width:178px;" date="${hbp.visitDate}" reg="{'required':true}" /> --%>
                                <input type="text" class="layui-input x-admin-content-sm-date" reg="{'required':true}"
                                       name="visitDate" id="hbpVisitDateId"
                                       value="<fmt:formatDate value='${hbp.visitDate}' pattern='yyyy/MM/dd'/>"
                                       style="padding-left: 0px;width:178px;"/>
                            </td>
                        </tr>
                        <tr>
                            <th><label class="required">随访方式</label></th>
                            <td><ehr:dic-radio dicmeta="DMD00026" value="${hbp.visitWayCode}" reg="{'required':true}"
                                               name="visitWayCode"></ehr:dic-radio></td>
                        </tr>
                        <tr>
                            <th><label class="required">症状</label></th>
                            <td>
                                <ehr:dic-radio dicmeta="FS10238" reg="{'required':true}" name="curSymptomFlag"
                                               value="${hbp.curSymptomFlag}"></ehr:dic-radio>
                                <div id="hbp-followup-curSymptomFlag" class="${hbp.curSymptomFlag!='2'?'hide':'' }">
                                    <ehr:dic-checkbox dicmeta="DMD00038" name="curSymptom" value="${hbp.curSymptom }"
                                                      reg="{'required':true,'dependValue':'2','dependOn':'curSymptomFlag'}"/>
                                    <input style="width: 100px;"
                                           reg="{'maxlength':100,'required':true,'dependValue':'10','dependOn':'curSymptom'}"
                                           type="text" name="otherSymptom" value="${hbp.otherSymptom}"></input>
                                </div>
                            </td>
                        </tr>
                    </table>
                    <fieldset class="layui-elem-field">
                        <legend>体征</legend>
                        <table class="posttable">
                            <colgroup>
                                <col style="min-width: 100px; width: 30%"/>
                                <col style="min-width: 150px; width: 70%"/>
                            </colgroup>
                            <tr>
                                <th><label class="required">血压</label></th>
                                <td><tag:numberInput style="width:50px;" id="hbpSbp" name="sbp" value="${hbp.sbp}"
                                                     reg="{'required':true,'min':0,'max':9999}"/>/
                                    <tag:numberInput id="hbpDbp" name="dbp" value="${hbp.dbp}" style="width:50px;"
                                                     reg="{'required':true,'min':0,'max':9999}"/>mmHg
                                </td>
                            </tr>
                            <tr>
                                <th><label class="required" for="height">身高</label></th>
                                <td><tag:numberInput style="width:109px;" point="point" id="height" name="height"
                                                     value="${hbp.height}"
                                                     reg="{'required':true,'min':0,'max':9999.9}"/>cm
                                </td>
                            </tr>
                            <tr>
                                <th><label class="required" for="bodyWeight">体重</label></th>
                                <td><tag:numberInput style="width:50px;" point="point" id="bodyWeight" name="bodyWeight"
                                                     value="${hbp.bodyWeight}"
                                                     reg="{'required':true,'min':0,'max':9999.9}" placeholder="目前值"/>/
                                    <tag:numberInput style="width:50px;" point="point" id="nextFollowupBodyWeight"
                                                     name="nextFollowupBodyWeight" value="${hbp.nextFollowupBodyWeight}"
                                                     reg="{'required':true,'min':0,'max':9999.9}" placeholder="期望值"/>kg
                                </td>
                            </tr>
                            <tr>
                                <th><label class="" for="indexOfBodyCharacteristics">体质指数(BMI)</label></th>
                                <td><input style="width:50px;" readonly="readonly" type="text"
                                           id="indexOfBodyCharacteristics" name="indexOfBodyCharacteristics"
                                           value="${hbp.indexOfBodyCharacteristics}" reg="{'min':0,'max':999.99}"/>/
                                    <input style="width:50px;" readonly="readonly" type="text" id="nextFollowupBmi"
                                           name="nextFollowupBmi" value="${hbp.nextFollowupBmi}"
                                           reg="{'min':0,'max':999.99}"/>kg/㎡
                                </td>
                            </tr>
                            <tr>
                                <th><label class="" for="heartRate">心率</label></th>
                                <td><tag:numberInput style="width:109px;" id="heartRate" name="heartRate"
                                                     value="${hbp.heartRate}" reg="{'min':0,'max':999}"/></td>
                            </tr>
                            <tr>
                                <th><label>其他</label></th>
                                <td><input type="text" name="signOther" value="${hbp.signOther}"
                                           reg="{'maxlength':100}"/></td>
                            </tr>
                        </table>
                    </fieldset>
                    <fieldset class="layui-elem-field">
                        <legend>生活方式指导</legend>
                        <table class="posttable">
                            <colgroup>
                                <col style="min-width: 100px; width: 30%"/>
                                <col style="min-width: 150px; width: 70%"/>
                            </colgroup>
                            <tr>
                                <th><label class="required" for="dailyDailySmokeber">日吸烟量（支）</label></th>
                                <td><tag:numberInput style="width:50px;" id="dailyDailySmokeber"
                                                     name="dailyDailySmokeber" value="${hbp.dailyDailySmokeber}"
                                                     reg="{'required':true,'min':0,'max':9999}" placeholder="目前值"/>/
                                    <tag:numberInput style="width:50px;" id="smokeberTarget" name="smokeberTarget"
                                                     value="${hbp.smokeberTarget}"
                                                     reg="{'required':true,'min':0,'max':9999}" placeholder="期望值"/></td>
                            </tr>
                            <tr>
                                <th><label class="required" for=dailyDrink>日饮酒量（两）</label></th>
                                <td><tag:numberInput style="width:50px;" id="dailyDrink" name="dailyDrink"
                                                     value="${hbp.dailyDrink}"
                                                     reg="{'required':true,'min':0,'max':9999}" placeholder="目前值"/>/
                                    <tag:numberInput style="width:50px;" id="nextFollowupDailyDrink"
                                                     name="nextFollowupDailyDrink" value="${hbp.nextFollowupDailyDrink}"
                                                     reg="{'required':true,'min':0,'max':9999}" placeholder="期望值"/></td>
                            </tr>
                            <tr>
                                <th><label class="required" for="trainFrequency">运动</label></th>
                                <td><tag:numberInput style="width:50px" id="trainFrequency" name="trainFrequency"
                                                     value="${hbp.trainFrequency}"
                                                     reg="{'required':true,'min':0,'max':99}" placeholder="目前值"/>次/周
                                    <tag:numberInput style="width:50px" id="trainingMin" name="trainingMin"
                                                     value="${hbp.trainingMin}"
                                                     reg="{'required':true,'min':0,'max':9999}" placeholder="目前值"/>分钟/次
                                </td>
                            </tr>
                            <tr>
                                <th></th>
                                <td><tag:numberInput style="width:50px" id="nextExerciseFrequency"
                                                     name="nextExerciseFrequency" value="${hbp.nextExerciseFrequency}"
                                                     reg="{'required':true,'min':0,'max':99}" placeholder="期望值"/>次/周
                                    <tag:numberInput style="width:50px" id="nextExerciseTime" name="nextExerciseTime"
                                                     value="${hbp.nextExerciseTime}"
                                                     reg="{'required':true,'min':0,'max':9999}" placeholder="期望值"/>分钟/次
                                </td>
                            </tr>
                            <tr>
                                <th><label class="required" for="salinity">摄盐情况（咸 淡）</label></th>
                                <td>目前值<ehr:dic-radio dicmeta="DMD00063" id="salinity" name="salinity"
                                                      value="${hbp.salinity }" reg="{'required':true}"></ehr:dic-radio>/
                                    期望值<ehr:dic-radio dicmeta="DMD00063" id="nextSalinityTarget"
                                                      name="nextSalinityTarget" value="${hbp.nextSalinityTarget }"
                                                      reg="{'required':true}"></ehr:dic-radio></td>
                            </tr>
                            <tr>
                                <th><label class="required" for="mentality">心理调整</label></th>
                                <td><ehr:dic-radio dicmeta="DMD00039" name="mentality" value="${hbp.mentality }"
                                                   reg="{'required':true}"></ehr:dic-radio></td>
                            </tr>
                            <tr>
                                <th><label class="required" for="compiance">遵医行为</label></th>
                                <td><ehr:dic-radio dicmeta="DMD00040" name="compiance" value="${hbp.compiance }"
                                                   reg="{'required':true}"></ehr:dic-radio>
                            </tr>
                        </table>
                    </fieldset>
                    <%--<fieldset>
                        <legend>血脂</legend>
                        <table class="posttable">
                            <colgroup>
                                <col style="min-width: 100px; width: 30%" />
                                <col style="min-width: 150px; width: 70%" />
                            </colgroup>
                            <tr>
                                <th>总胆固醇</th>
                                <td><tag:numberInput point="point" reg="{'min':0,'max':999.99}" name="tc" value="${hbp.tc}" style="width: 80px;" />mmol/L</td>
                            </tr>
                            <tr>
                                <th>甘油三酯</th>
                                <td><tag:numberInput point="point" reg="{'min':0,'max':99.9}" name="triglycerideValue" value="${hbp.triglycerideValue}"
                                        style="width: 80px;"
                                    />mmol/L</td>
                            </tr>
                            <tr>
                                <th>血清低密度脂蛋白胆固醇</th>
                                <td><tag:numberInput reg="{'min':0,'max':999.99}" point="point" name="ldlcDetectValue" value="${hbp.ldlcDetectValue}"
                                        style="width: 80px;"
                                    />mmol/L</td>
                            </tr>
                            <tr>
                                <th>血清高密度脂蛋白胆固醇</th>
                                <td><tag:numberInput reg="{'min':0,'max':9999.9}" point="point" name="hdlcDetectValue" value="${hbp.hdlcDetectValue}"
                                        style="width: 80px;"
                                    />mmol/L</td>
                            </tr>
                        </table>
                    </fieldset>--%>

                    <table class="posttable">
                        <colgroup>
                            <col style="min-width: 100px; width: 30%"/>
                            <col style="min-width: 150px; width: 70%"/>
                        </colgroup>
                        <tr>
                            <th><label for="aeResultDesc">辅助检查</label></th>
                            <td><input type="text" name="aeResultDesc" value="${hbp.aeResultDesc }"
                                       reg="{'maxlength':100}"/></td>
                        </tr>
                        <tr>
                            <th><label class="required" for="medicationCompliance">服药依从性</label></th>
                            <td><ehr:dic-radio dicmeta="DMD00041" name="medicationCompliance"
                                               value="${hbp.medicationCompliance }"
                                               reg="{'required':true}"></ehr:dic-radio></td>
                        </tr>
                        <tr>
                            <th><label for="sideEffects">药物不良反应</label></th>
                            <td><ehr:dic-radio onchange="toggleOther('sideEffects','hbp-followup-effectsState','2')"
                                               dicmeta="FS10238" name="sideEffects"
                                               value="${hbp.sideEffects }"></ehr:dic-radio>
                                <input style="width:352px;" type="text" id="hbp-followup-effectsState"
                                       class="${hbp.sideEffects!='2'?'hide':'' }" value="${hbp.effectsState}"
                                       name="effectsState"
                                       reg="{'required':true,'maxlength':100,'dependOn':'sideEffects','dependValue':'2'}">
                            </td>
                        </tr>
                        <tr>
                            <th><label class="required" for="visitType">此次随访分类</label></th>
                            <td><ehr:dic-radio dicmeta="DMD00042" name="visitType" value="${hbp.visitType }"
                                               reg="{'required':true}"></ehr:dic-radio></td>
                        </tr>
                    </table>
                    <fieldset class="layui-elem-field">
                        <legend>用药情况</legend>
                        <table class="posttable">
                            <colgroup>
                                <col style="min-width: 100px; width: 30%"/>
                                <col style="min-width: 150px; width: 70%"/>
                            </colgroup>
                            <tr>
                                <th><label class="required">用药</label></th>
                                <td><ehr:dic-radio reg='{"required":"true"}' dicmeta="FS10246" name="medicateHbpFlag"
                                                   id="medicateHbpFlag" value="${hbp.medicateHbpFlag}"/></td>
                            </tr>
                        </table>
                        <span style="display:${hbp.medicateHbpFlag !='1'?'none':'inline' }" id="medicateHbpSpan">
						<c:set var="drug" value="${hbp}" scope="request"></c:set>
						<jsp:include page="../hbpdicommon/druguse.jsp"></jsp:include>
					</span>
                    </fieldset>
                    <fieldset class="layui-elem-field">
                        <legend>转诊</legend>
                        <table class="posttable">
                            <colgroup>
                                <col style="min-width: 100px; width: 30%"/>
                                <col style="min-width: 150px; width: 70%"/>
                            </colgroup>
                            <tr>
                                <th><label class="required" for="referralHbpFlag">转诊</label></th>
                                <td><ehr:dic-radio reg='{"required":"true"}' dicmeta="FS10246" name="referralHbpFlag"
                                                   id="referralHbpFlag" value="${hbp.referralHbpFlag}"/></td>
                            </tr>
                        </table>
                        <table class="posttable" style="${hbp.referralHbpFlag !='1'?'display:none':'' }"
                               id="referralHbpSpan">
                            <colgroup>
                                <col style="min-width: 100px; width: 30%"/>
                                <col style="min-width: 150px; width: 70%"/>
                            </colgroup>
                            <tr>
                                <th><label for="referralOrganCode">机构</label></th>
                                <td class="colinput">
                                    <ehr:org-type-list id="referralOrganCode" width="275px" name="referralOrganCode"
                                                       type="hospital,centre" value="${hbp.referralOrganCode}"/>
                                </td>
                            </tr>
                            <tr>
                                <th><label for="referralDepartment">科别</label></th>
                                <td><input type="text" name="referralDepartment" id="referralDepartment"
                                           reg="{'maxlength':100}" value="${hbp.referralDepartment}"/></td>
                            </tr>
                            <tr>
                                <th>接诊医生</th>
                                <td><input type="text" name="referralDoctor" id="referralDoctor" reg="{'maxlength':100}"
                                           value="${hbp.referralDoctor}"/></td>
                            </tr>
                            <tr>
                                <th>转诊日期</th>
                                <td>
                                    <%-- <tag:dateInput onlypast="true" id="referralDate" name="referralDate" style="width:178px;" date="${hbp.referralDate}"/> --%>
                                    <input type="text" class="layui-input x-admin-content-sm-date" name="referralDate"
                                           id="hbpReferralDateId"
                                           value="<fmt:formatDate value='${hbp.referralDate}' pattern='yyyy/MM/dd'/>"
                                           style="padding-left: 0px;width:178px;"/>
                                </td>
                            </tr>
                            <tr>
                                <th><label for="referralReasons">原因</label></th>
                                <td><input type="text" name="referralReasons" id="referralReasons"
                                           reg="{'maxlength':150}" value="${hbp.referralReasons}"/></td>
                            </tr>
                        </table>
                    </fieldset>
                    <c:if test="${not empty attches}">
                    <fieldset class="layui-elem-field">
					<legend>附件</legend>
                        <table class="posttable">
                            <colgroup>
								<col style="width: 15%;"/>
								<col style="width: 35%;"/>
								<col style="width: 15%;"/>
								<col style="width: 35%;"/>
                            </colgroup>
                            <tr>
                                <th></th>
                                <td colspan="3">
                                    <div style="width: 960px;">
                                        <c:forEach items="${attches}" var="attche">
                                            <div style="width: 320px;height:200px;overflow:hidden;float: left;margin-top: 5px;margin-left:5px;margin-right:10px;text-align: center;"
                                                 id="${attche.mongoId}-div">
                                                    <a target="blank"
                                                       href="${pageContext.request.contextPath}/mongoFile/showAsImage/${attche.mongoId}"><img
                                                            alt="点击查看大图" title="点击查看大图"
                                                            src="${pageContext.request.contextPath}/mongoFile/showSmallImage/${attche.mongoId}"
                                                    /></a>
                                                <br/>
                                                <a target="blank"
                                                   href="${pageContext.request.contextPath}/mongoFile/download/${attche.mongoId}"
                                                   onclick="javascript:void(0)">${attche.fileName}</a>

                                                <%--<a href="javascript:void(0);"
                                                   onclick="healthEducationUpload.deleteFile('${attche.mongoId}')">删除</a>--%>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </td>
                            </tr>
                            <%--<tr>
                                <th><label class="required">附件</label></th>
                                <td style="width: 120px;">
                                    <div id="heMaterialFile"></div>
                                </td>
                                <td colspan="2">
                                    <span style="color: blue;">注：提供宣传材料样张照片，单个附件请控制在2M之内(建议图片分辨率为800像素*600像素如果原图片超过2M，建议使用<a
                                            href="http://xiuxiu.meitu.com" target="blank"><strong>美图</strong></a>软件修改)，附件数量不能超过5个</span>
                                    <span id="activeTips" style="color: blue;"></span>
                                </td>
                            </tr>--%>
                        </table>
                    </fieldset></c:if>
                </fieldset>
                <c:set var="input" value="${hbp}" scope="request"></c:set>
                <jsp:include page="../common/inputInfo.jsp"></jsp:include>
            </div>
        </div>
    </form>
    <jsp:include page="hbpFollowupInputPrint.jsp"/>
</div>

<script type="text/javascript">

    layui.use('laydate', function () {
        var laydate = layui.laydate;

        laydate.render({
            elem: '#hbpVisitDateId'
            , format: 'yyyy/MM/dd'
            , max: 0
            , done: function (value) {
                if (!$.isEmpty(value)) {
                    $("#hbpVisitDateId").removeClass("lose");
                } else {
                    $("#hbpVisitDateId").addClass("lose");
                }
            }
        });

        laydate.render({
            elem: '#hbpReferralDateId'
            , format: 'yyyy/MM/dd'
            , max: 0
            , trigger: 'click'
            , done: function (value) {
                if (!$.isEmpty(value)) {
                    $("#hbpReferralDateId").removeClass("lose");
                } else {
                    $("#hbpReferralDateId").addClass("lose");
                }
            }
        });
    });
    $(function () {
        $('.x-admin-content-sm-date').each(function(){
            var id = $(this).attr("id");
            if(!$.isEmpty(id)){
                autoFormatDate(id);
            }
        });
    });
</script>


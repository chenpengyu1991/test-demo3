<%@ page language="java" pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<link href="${pageContext.request.contextPath}/css/views/ehrbrowser/personalRecord/phyExam.css" type="text/css" rel="stylesheet"/>
<script src="${pageContext.request.contextPath}/js/views/ihm/cwhTarget/cwhCommon.js" type="text/javascript"></script>

<link href="${pageContext.request.contextPath}/css/views/ech/report.css"
      type="text/css" rel="stylesheet"/>
<style>
    .posttable th, .posttable td {
        height: 26px;
        line-height: 26px;
        padding: 0 5px;
        table-layout: fixed;
    }
</style>
<script type="text/javascript">
    $(function () {
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
</script>

<div class="toolbar">
    <a href="javascript:void(0)" id="button_saves"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
    <a href="javascript:void(0)" id="cancelChildExamBtn"><button class="btn-gray layui-btn layui-btn-sm"><i class="layui-icon">&#xe65c;</i>返回</button></a>
</div>
<div class="contentfixed32" id="con_two_3">
    <div class="msgError" style="display: none" id="person_px_info_errbox"></div>
    <div id="msgError" class="msgError" style="display: none;"></div>
    <form action="" id="childrenForm">
        <input type="hidden" name="id" value="${neonatalFamilyVisit.id}"/>
        <input type="hidden" name="personId" value="${neonatalFamilyVisit.personId}" id="text_personId"/>
        <div class="postcontent searchSection x-admin-sm" style="background-color: white; ">
            <ul>
                <li style="text-align: center; font-size: 25px;">新生儿家庭访视</li>
            </ul>
            <br/>
            <div style=" overflow: auto;" class="postcontent">
                <table style="line-height: 10px;" class="posttable">
                    <colgroup>
                        <col style="width: 20%;"/>
                        <col style="width: 30%;"/>
                        <col style="width: 20%;"/>
                        <col style="width: 30%;"/>
                    </colgroup>
                    <tr>
                        <th><label class="required">姓名</label></th>
                        <td><input reg='{"required":"true","maxlength":16}' type="text" id="text_name" name="neonatusName" value="${neonatalFamilyVisit.neonatusName}"/></td>
                        <th><label class="required">出生编号</label></th>
                        <td><input type="text" reg='{"required":"true","maxlength":13}' name="babyCardNo" value="${neonatalFamilyVisit.babyCardNo}"/></td>

                    </tr>
                    <tr>
                        <th><label class="required">性别</label></th>
                        <td><ehr:dic-radio dicmeta="GBT226112003" name="neonatalGender" reg='{"required":"true"}' value='${neonatalFamilyVisit.neonatalGender}'/></td>
                        <th>出生日期</th>
                        <td>
                            <input type="text" class="layui-input x-admin-content-sm-date" name="neonatusBirthday" id="text_inputDate"
                                   reg='{"required":true}' value="<fmt:formatDate value='${neonatalFamilyVisit.neonatusBirthday}' pattern='yyyy/MM/dd'/>"/>
                        </td>
                    </tr>
                    <tr>
                        <th>身份证件号</th>
                        <td><input reg='{"maxlength":18}' type="text" id="textIdCard" name="neonatusIdcard" value="${neonatalFamilyVisit.neonatusIdcard}"/></td>
                    </tr>
                    <tr>
                        <th><label class="required">家庭地址 </label></th>
                        <td colspan="2">
                            <ehr:dic-town-street-village
                                    villageId="homeVillage_address" townId="homeTown_address"
                                    streetId="homeStreet_address"
                                    streetValue="${neonatalFamilyVisit.patownShip}"
                                    villageName="pastreet" streetName="patownShip"
                                    townName="pacounty"
                                    villageValue="${neonatalFamilyVisit.pastreet}"
                                    townValue="${neonatalFamilyVisit.pacounty}" width="118px;"
                                    reg="{'dependValue':'1','required':true}"
                                    callback="familyVisit.displayHrAddress"/>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">住址详细地址</label></th>
                        <td>
                            <span id="homeSpan"> <label id="tempHrValue"><ehr:dic
                                code="${neonatalFamilyVisit.pacounty}" dicmeta="FS990001"/>
									<ehr:dic code="${neonatalFamilyVisit.patownShip}"
                                             dicmeta="FS990001"/> <ehr:dic
                                    code="${neonatalFamilyVisit.pastreet}" dicmeta="FS990001"/>
                                </label><br/> <%-- <input type="hidden" name="PersonInfoDTO.personInfo.hrAddressDetail" id="orgHrName" value="${personInfo.hrAddressDetail}"/> --%>
                            </span>
                            <input type="text" id="text_pahouseNumber" reg='{"required":"true","maxlength":50}' name="pahouseNumber" value="${neonatalFamilyVisit.pahouseNumber}"/>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">父亲姓名</label></th>
                        <td><input reg='{"required":"true","maxlength":16}' type="text" name="fatherName" value="${neonatalFamilyVisit.fatherName}"/></td>
                        <th>父亲职业</th>
                        <td>
                            <ehr:dic-list name="fatherOccupation" dicmeta="GBT6565" value="${neonatalFamilyVisit.fatherOccupation}"/>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">父亲联系电话</label></th>
                        <td><input type="text" name="fatherPhone" reg='{"required":"true","regex":"phone"}' value="${neonatalFamilyVisit.fatherPhone}"/></td>
                        <th>父亲出生日期</th>
                        <td>
                            <input type="text" class="layui-input x-admin-content-sm-date" name="fatherBirthday" id="fatherBirthday"
                                   reg='{"required":true}' value="<fmt:formatDate value='${neonatalFamilyVisit.fatherBirthday}' pattern='yyyy/MM/dd'/>"/>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">母亲姓名</label></th>
                        <td><input reg='{"required":"true","maxlength":16}' type="text" name="motherName" value="${neonatalFamilyVisit.motherName}"/></td>
                        <th>母亲职业</th>
                        <td>
                            <ehr:dic-list name="motherOccupation" dicmeta="GBT6565" value="${neonatalFamilyVisit.motherOccupation}"/>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">母亲联系电话</label></th>
                        <td><input type="text" id="text_phoneNumber" name="matherPhone" reg='{"required":"true","regex":"phone"}' value="${neonatalFamilyVisit.matherPhone}"/></td>
                        <th><label class="required">母亲出生日期</label></th>
                        <td>
                            <input type="text" class="layui-input x-admin-content-sm-date" name="motherBirthday" id="motherBirthday"
                                   reg='{"required":true}' value="<fmt:formatDate value='${neonatalFamilyVisit.motherBirthday}' pattern='yyyy/MM/dd'/>"/>
                        </td>
                    </tr>
                    <tr>
                        <th>出生孕周</th>
                        <td><tag:numberInput name="gestationalWeek" value="${neonatalFamilyVisit.gestationalWeek}" reg="{'min':0,'max':9999}"/>周
                        </td>
                        <th><label class="required">助产机构名称</label></th>
                        <td><ehr:org-type-list id="obstetricInstitutionsName"
                                               name="obstetricInstitutionsName"
                                               type="hospital,centre" reg="{'required':true}"
                                               value="${neonatalFamilyVisit.obstetricInstitutionsName}"/></td>
                    </tr>
                    <tr>
                        <th>母亲妊娠期患病情况</th>
                        <td colspan="2">
                            <input type="hidden" value="${neonatalFamilyVisit.complicationHistory}" id="text_trainingWay"/>
                            <span id="other_train_way_span" class="hidediv"> </span>
                            <ehr:dic-radio name="complicationHistory" dicmeta="T19911105" code="1,2,3,4" value="${neonatalFamilyVisit.complicationHistory}"/>
                            <div id="complicationHistoryDetail" ${"3" eq neonatalFamilyVisit.complicationHistory ? '' : 'hidden'}>
                                <input type="text" id="otherComplicationHistory"
                                       name="otherComplicationHistory"
                                       reg='{"extension":["otherComplicationHistory","不能为空"],"maxlength":"100"}'
                                       value="${neonatalFamilyVisit.otherComplicationHistory}"><br>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th>出生情况</th>
                        <td colspan="3">
                            <ehr:dic-radio
                                    name="lastdeliveryCode" dicmeta="CV0210003"
                                    value="${neonatalFamilyVisit.lastdeliveryCode}"/>
                            <div id="lastdeliverycodeDetail"
                            ${"40" eq neonatalFamilyVisit.lastdeliveryCode ? '' : 'hidden'}>
                                <input type="text" id="lastdeliverycodedesc"
                                       name="lastdeliverycodedesc"
                                       reg='{"extension":["otherComplicationHistory","不能为空"],"maxlength":"100"}'
                                       value="${neonatalFamilyVisit.lastdeliverycodedesc}"><br>
                            </div>

                        </td>
                    </tr>
                    <tr>
                        <th>新生儿窒息</th>
                        <td><ehr:dic-radio dicmeta="FS10111" name="asphyxiaSign" value='${neonatalFamilyVisit.asphyxiaSign}'/>

                            <div id="asphyxiaSignDetail"
                            ${"2" eq neonatalFamilyVisit.asphyxiaSign ? '' : 'hidden'}>
                                Apgar评分
                                <label><input
                                        type="radio" name="apgarValue"
                                ${neonatalFamilyVisit.apgarValue eq "01" ? "checked" : ""}
                                        value="01"> 1分钟 <input type="radio" name="apgarValue"
                                ${neonatalFamilyVisit.apgarValue eq "02" ? "checked" : ""}
                                                               value="02">65分钟
                                    <input type="radio" name="apgarValue"
                                    ${neonatalFamilyVisit.apgarValue eq "03" ? "checked" : ""}
                                           value="03">不详</label>
                            </div>
                        </td>
                        <th>新生儿畸形标志</th>
                        <td colspan="2" style="vertical-align: top">
                            <label><input type="radio" onclick="util.clickHideText(this,'deformityDesc')" name="deformitySign"
                                        ${neonatalFamilyVisit.deformitySign eq "0" ? "checked" : ""} value="0"> 无</label>
                            <label><input type="radio" id="deformitySign" onclick="util.clickShowText(this,'deformityDesc')" name="deformitySign"
                                        ${neonatalFamilyVisit.deformitySign eq "1" ? "checked" : ""} value="1"> 有</label>
                            <input type="text" id="deformityDesc" name="deformityDesc" value="${neonatalFamilyVisit.deformityDesc}"
                                        CLASS="hidediv" style="width: 200px;" reg='{"dependOn":"deformitySign","required":"true","maxlength":"33"}'/>
                        </td>
                    </tr>
                    <tr>
                        <th>新生儿听力筛查</th>
                        <td style="vertical-align: top;"><ehr:dic-radio
                                dicmeta="FS10025" name="hearingScreeningState"
                                value='${neonatalFamilyVisit.hearingScreeningState}'/></td>
                    </tr>
                    <tr>
                        <th>新生儿疾病筛查</th>
                        <td colspan="3"><ehr:dic-radio dicmeta="CV0450008"
                                                       name="diseaseScreeningProject"
                                                       value='${neonatalFamilyVisit.diseaseScreeningProject}'/>
                            <span id="diseaseScreeningProjectDetail"
                            ${"3" eq neonatalFamilyVisit.diseaseScreeningProject ? '' : 'hidden'}>
								<input type="text" id="diseaseScreeningDesc" name="diseaseScreeningDesc"
                                       style="width: 30%;"
                                       reg='{"extension":["diseaseScreeningDesc","不能为空"],"maxlength":"100"}'
                                       value="${neonatalFamilyVisit.diseaseScreeningDesc}">
							</span>
                        </td>
                    </tr>
                    <tr>
                        <th>出生体重(kg)</th>
                        <td><tag:numberInput reg="{'min':0,'max':999.9}"
                                             point="point" name="birthWeight"
                                             value="${neonatalFamilyVisit.birthWeight}" /></td>
                        <th>出生身长(cm)</th>
                        <td><tag:numberInput reg="{'min':0,'max':999.9}"
                                             point="point" name="birthStature"
                                             value="${neonatalFamilyVisit.birthStature}" /></td>
                    </tr>


                    <tr>
                        <th>目前体重(kg)</th>
                        <td><tag:numberInput reg="{'min':0,'max':999.9}"
                                             point="point" name="bodyWeight"
                                             value="${neonatalFamilyVisit.bodyWeight}"/></td>
                        <th>喂养方式</th>
                        <td><ehr:dic-radio dicmeta="FS10026" name="feedingType"
                                           value='${neonatalFamilyVisit.feedingType}'/></td>
                    </tr>
                    <tr>
                        <th>每天吃奶次数*</th>
                        <td><tag:numberInput reg="{'min':0,'max':999}"
                                             name="eatMilkNumber"
                                             value="${neonatalFamilyVisit.eatMilkNumber}" />
                        </td>
                        <th>每次吃奶量(ml)</th>
                        <td><tag:numberInput reg="{'min':0,'max':999}"
                                             name="eatMilkSupply"
                                             value="${neonatalFamilyVisit.eatMilkSupply}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>呕吐标志*</th>
                        <td><ehr:dic-radio
                                dicmeta="FS10111" name="vomitingMark"
                                value="${neonatalFamilyVisit.vomitingMark}"/></td>

                        <th>新生儿大便性状*</th>
                        <td>
                            <ehr:dic-radio name="stoolProperty" dicmeta="CV0401012" code="2,3"
                                           value="${neonatalFamilyVisit.stoolProperty}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>新生儿大便次数*</th>
                        <td><tag:numberInput reg="{'min':0,'max':999}"
                                             name="stoolNumber" value="${neonatalFamilyVisit.stoolNumber}" /> 次/日
                        </td>
                    </tr>
                    <tr>
                        <th>体温(℃)</th>
                        <td><tag:numberInput reg="{'min':0,'max':999.9}"
                                             point="point" name="temperature"
                                             value="${neonatalFamilyVisit.temperature}" /></td>
                        <th>脉率(次/分钟)</th>
                        <td><tag:numberInput reg="{'min':0,'max':999}"
                                             name="pulseRate" value="${neonatalFamilyVisit.pulseRate}" /></td>
                    </tr>
                    <tr>
                        <th>呼吸频率(次/分钟)</th>
                        <td><tag:numberInput reg="{'min':0,'max':999}"
                                             name="respiratoryRate"
                                             value="${neonatalFamilyVisit.respiratoryRate}" /></td>
                        <th>新生儿面色</th>
                        <td><ehr:dic-radio dicmeta="CV0410008" name="complexionCode"
                                           value='${neonatalFamilyVisit.complexionCode}'/>
                            <div id="complexionCodeDetail"
                            ${"9" eq neonatalFamilyVisit.complexionCode ? '' : 'hidden'}>
                                <input type="text" id="complexionCodeDesc" name="complexionCodesDesc"
                                       width="90px"
                                       reg='{"extension":["complexionCodesDesc","不能为空"],"maxlength":"100"}'
                                       value="${neonatalFamilyVisit.complexionCodesDesc}"><br>
                            </div>

                        </td>
                    </tr>
                    <tr>
                        <th>黄疸部位</th>
                        <td colspan="3"><ehr:dic-radio dicmeta="CV0410009"
                                                       name="jaundicePartsCode"
                                                       value='${neonatalFamilyVisit.jaundicePartsCode}'/></td>
                    </tr>
                    <tr>
                        <th>前囟横径(cm)</th>
                        <td><tag:numberInput reg="{'min':0,'max':999.9}"
                                             name="afTransverseDiameter" point="point"
                                             value="${neonatalFamilyVisit.afTransverseDiameter}" /></td>
                        <th>前囟纵径(cm)</th>
                        <td><tag:numberInput reg="{'min':0,'max':999.9}"
                                             point="point" name="bregmaDiameter"
                                             value="${neonatalFamilyVisit.bregmaDiameter}" /></td>
                    </tr>
                    <tr>
                        <th>前囟张力</th>
                        <td><ehr:dic-radio dicmeta="CV0410018"
                                           name="bregmaTension"
                                           value='${neonatalFamilyVisit.bregmaTension}'/>
                            <div id="bregmaTensiontDetail"
                            ${"9" eq neonatalFamilyVisit.bregmaTension ? '' : 'hidden'}>
                                <input type="text" id="bregmaTensionsDesc" name="bregmaTensionsDesc"
                                       width="30%"
                                       reg='{"extension":["bregmaTensionsDesc","不能为空"],"maxlength":"100"}'
                                       value="${neonatalFamilyVisit.bregmaTensionsDesc}"><br>
                            </div>


                        </td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>眼外观检查异常</th>
                        <td colspan="2"><label><input type="radio"
                                                      onclick="util.clickHideText(this,'eyeAppearanceInspectionDesc')"
                                                      name="eyeappearanceSign"
                        ${neonatalFamilyVisit.eyeappearanceSign eq "0" ? "checked" : ""}
                                                      value="0"> 未见异常</label> <label><input type="radio"
                                                                                            id="eyeappearanceSign"
                                                                                            onclick="util.clickShowText(this,'eyeAppearanceInspectionDesc')"
                                                                                            name="eyeappearanceSign"
                        ${neonatalFamilyVisit.eyeappearanceSign eq "1" ? "checked" : ""}
                                                                                            value="1"> 有异常</label>
                            <input type="text"
                                   id="eyeAppearanceInspectionDesc"
                                   name="eyeAppearanceInspectionDesc"
                                   value="${neonatalFamilyVisit.eyeAppearanceInspectionDesc}"
                                   CLASS="hidediv" style="width: 200px;"
                                   reg='{"dependOn":"eyeappearanceSign","required":"true","maxlength":"33"}'>
                        </td>
                    </tr>
                    <tr>
                        <th>四肢活动度异常</th>
                        <td colspan="2"><label><input type="radio"
                                                      onclick="util.clickHideText(this,'limbActivityDesc')"
                                                      name="limbActivityAnomalySign"
                        ${neonatalFamilyVisit.limbActivityAnomalySign eq "0" ? "checked" : ""}
                                                      value="0"> 未见异常</label> <label><input type="radio"
                                                                                            id="limbActivityAnomalySign"
                                                                                            onclick="util.clickShowText(this,'limbActivityDesc')"
                                                                                            name="limbActivityAnomalySign"
                        ${neonatalFamilyVisit.limbActivityAnomalySign eq "1" ? "checked" : ""}
                                                                                            value="1"> 有异常</label>
                            <input type="text" id="limbActivityDesc"
                                   name="limbActivityDesc"
                                   value="${neonatalFamilyVisit.limbActivityDesc}" CLASS="hidediv"
                                   style="width: 200px;"
                                   reg='{"dependOn":"limbActivityAnomalySign","required":"true","maxlength":"33"}'>
                        </td>
                    </tr>
                    <tr>
                        <th>耳外观检查异常</th>
                        <td colspan="2"><label><input type="radio"
                                                      onclick="util.clickHideText(this,'earAppearanceInspectionDesc')"
                                                      name="earAppearanceInspection"
                        ${neonatalFamilyVisit.earAppearanceInspection eq "0" ? "checked" : ""}
                                                      value="0"> 未见异常</label> <label><input type="radio"
                                                                                            id="earAppearanceInspection"
                                                                                            onclick="util.clickShowText(this,'earAppearanceInspectionDesc')"
                                                                                            name="earAppearanceInspection"
                        ${neonatalFamilyVisit.earAppearanceInspection eq "1" ? "checked" : ""}
                                                                                            value="1"> 有异常</label>
                            <input type="text"
                                   id="earAppearanceInspectionDesc"
                                   name="earAppearanceInspectionDesc"
                                   value="${neonatalFamilyVisit.earAppearanceInspectionDesc}"
                                   CLASS="hidediv" style="width: 200px;"
                                   reg='{"dependOn":"earAppearanceInspection","required":"true","maxlength":"33"}'>
                        </td>
                    </tr>
                    <tr>
                        <th>颈部包块标志</th>
                        <td colspan="2"><label><input type="radio"
                                                      onclick="util.clickHideText(this,'neckLumpDesc')"
                                                      name="neckLumpSign"
                        ${neonatalFamilyVisit.neckLumpSign eq "0" ? "checked" : ""}
                                                      value="0"> 无</label> <label><input type="radio"
                                                                                         id="neckLumpSign"
                                                                                         onclick="util.clickShowText(this,'neckLumpDesc')"
                                                                                         name="neckLumpSign"
                        ${neonatalFamilyVisit.neckLumpSign eq "1" ? "checked" : ""}
                                                                                         value="1"> 有</label> <input
                                type="text" id="neckLumpDesc"
                                name="neckLumpDesc" value="${neonatalFamilyVisit.neckLumpDesc}"
                                CLASS="hidediv" style="width: 200px;"
                                reg='{"dependOn":"neckLumpSign","required":"true","maxlength":"33"}'></td>
                    </tr>
                    <tr>
                        <th>鼻检查异常</th>
                        <td colspan="2"><label><input type="radio"
                                                      onclick="util.clickHideText(this,'nasalCheckAnomalyDesc')"
                                                      name="nasalCheckAnomaly"
                        ${neonatalFamilyVisit.nasalCheckAnomaly eq "0" ? "checked" : ""}
                                                      value="0"> 未见异常</label> <label><input type="radio"
                                                                                            id="nasalCheckAnomaly"
                                                                                            onclick="util.clickShowText(this,'nasalCheckAnomalyDesc')"
                                                                                            name="nasalCheckAnomaly"
                        ${neonatalFamilyVisit.nasalCheckAnomaly eq "1" ? "checked" : ""}
                                                                                            value="1"> 有异常</label>
                            <input type="text"
                                   id="nasalCheckAnomalyDesc" name="nasalCheckAnomalyDesc"
                                   value="${neonatalFamilyVisit.nasalCheckAnomalyDesc}"
                                   CLASS="hidediv" style="width: 200px;"
                                   reg='{"dependOn":"nasalCheckAnomaly","required":"true","maxlength":"33"}'>
                        </td>
                    </tr>
                    <tr>
                        <th>皮肤检查异常</th>
                        <td colspan="2">
                            <ehr:dic-radio
                                    name="skinVisionInspection" dicmeta="CV0410004"
                                    code="01,02,03,04,05,06,07,08,99"
                                    value="${neonatalFamilyVisit.skinVisionInspection}"/>
                            <div id="skinVisionInspectionDetail"
                            ${"99" eq neonatalFamilyVisit.skinVisionInspection ? '' : 'hidden'}>
                                <input type="text" id="skinVisionInspectionDesc"
                                       name="skinVisionInspectionDesc"
                                       reg='{"extension":["skinVisionInspectionDesc","不能为空"],"maxlength":"100"}'
                                       value="${neonatalFamilyVisit.skinVisionInspectionDesc}"><br>
                            </div>

                        </td>
                    </tr>
                    <tr>
                        <th>口腔检查异常</th>
                        <td colspan="2"><label><input type="radio"
                                                      onclick="util.clickHideText(this,'oralExaminationAnomalyDesc')"
                                                      name="oralExaminationAnomaly"
                        ${neonatalFamilyVisit.oralExaminationAnomaly eq "0" ? "checked" : ""}
                                                      value="0"> 未见异常</label> <label><input type="radio"
                                                                                            id="oralExaminationAnomaly"
                                                                                            onclick="util.clickShowText(this,'oralExaminationAnomalyDesc')"
                                                                                            name="oralExaminationAnomaly"
                        ${neonatalFamilyVisit.oralExaminationAnomaly eq "1" ? "checked" : ""}
                                                                                            value="1"> 有异常</label>
                            <input type="text"
                                   id="oralExaminationAnomalyDesc" name="oralExaminationAnomalyDesc"
                                   value="${neonatalFamilyVisit.oralExaminationAnomalyDesc}"
                                   CLASS="hidediv" style="width: 200px;"
                                   reg='{"dependOn":"oralExaminationAnomaly","required":"true","maxlength":"33"}'>
                        </td>
                    </tr>
                    <tr>
                        <th>肛门检查异常</th>
                        <td colspan="2"><label><input type="radio"
                                                      onclick="util.clickHideText(this,'analExaminationAnomalyDesc')"
                                                      name="analExaminationAnomaly"
                        ${neonatalFamilyVisit.analExaminationAnomaly eq "0" ? "checked" : ""}
                                                      value="0"> 未见异常</label> <label><input type="radio"
                                                                                            id="analExaminationAnomaly"
                                                                                            onclick="util.clickShowText(this,'analExaminationAnomalyDesc')"
                                                                                            name="analExaminationAnomaly"
                        ${neonatalFamilyVisit.analExaminationAnomaly eq "1" ? "checked" : ""}
                                                                                            value="1"> 有异常</label>
                            <input type="text"
                                   id="analExaminationAnomalyDesc" name="analExaminationAnomalyDesc"
                                   value="${neonatalFamilyVisit.analExaminationAnomalyDesc}"
                                   CLASS="hidediv" style="width: 200px;"
                                   reg='{"dependOn":"analExaminationAnomaly","required":"true","maxlength":"33"}'>
                            <%--<c:out value='${neonatalFamilyVisit.analExaminationAnomaly eq "0" ? "未见异常" : neonatalFamilyVisit.analExaminationAnomalyDesc}'></c:out>--%>
                        </td>
                    </tr>
                    <tr>
                        <th>心肺听诊异常</th>
                        <td colspan="2"><label><input type="radio"
                                                      onclick="util.clickHideText(this,'cardiacAuscuAnomalyDesc')"
                                                      name="cardiacAuscuAnomaly"
                        ${neonatalFamilyVisit.cardiacAuscuAnomaly eq "0" ? "checked" : ""}
                                                      value="0"> 未见异常</label> <label><input type="radio"
                                                                                            id="cardiacAuscuAnomaly"
                                                                                            onclick="util.clickShowText(this,'cardiacAuscuAnomalyDesc')"
                                                                                            name="cardiacAuscuAnomaly"
                        ${neonatalFamilyVisit.cardiacAuscuAnomaly eq "1" ? "checked" : ""}
                                                                                            value="1"> 有异常</label>
                            <input type="text"
                                   id="cardiacAuscuAnomalyDesc" name="cardiacAuscuAnomalyDesc"
                                   value="${neonatalFamilyVisit.cardiacAuscuAnomalyDesc}"
                                   CLASS="hidediv" style="width: 200px;"
                                   reg='{"dependOn":"cardiacAuscuAnomaly","required":"true","maxlength":"33"}'>
                        </td>
                    </tr>
                    <tr>
                        <th>外生殖器检查异常</th>
                        <td colspan="2"><label><input type="radio"
                                                      onclick="util.clickHideText(this,'extGenitalCheckAnomalyDesc')"
                                                      name="extGenitalCheckAnomaly"
                        ${neonatalFamilyVisit.extGenitalCheckAnomaly eq "0" ? "checked" : ""}
                                                      value="0"> 未见异常</label> <label><input type="radio"
                                                                                            id="extGenitalCheckAnomaly"
                                                                                            onclick="util.clickShowText(this,'extGenitalCheckAnomalyDesc')"
                                                                                            name="extGenitalCheckAnomaly"
                        ${neonatalFamilyVisit.extGenitalCheckAnomaly eq "1" ? "checked" : ""}
                                                                                            value="1"> 有异常</label>
                            <input type="text"
                                   id="extGenitalCheckAnomalyDesc" name="extGenitalCheckAnomalyDesc"
                                   value="${neonatalFamilyVisit.extGenitalCheckAnomalyDesc}"
                                   CLASS="hidediv" style="width: 200px;"
                                   reg='{"dependOn":"extGenitalCheckAnomaly","required":"true","maxlength":"33"}'>
                        </td>
                    </tr>
                    <tr>
                        <th>腹部触诊异常</th>
                        <td colspan="2"><label><input type="radio"
                                                      onclick="util.clickHideText(this,'abdominalPalpAnomalyDesc')"
                                                      name="abdominalPalpAnomaly"
                        ${neonatalFamilyVisit.abdominalPalpAnomaly eq "0" ? "checked" : ""}
                                                      value="0"> 未见异常</label> <label><input type="radio"
                                                                                            id="abdominalPalpAnomaly"
                                                                                            onclick="util.clickShowText(this,'abdominalPalpAnomalyDesc')"
                                                                                            name="abdominalPalpAnomaly"
                        ${neonatalFamilyVisit.abdominalPalpAnomaly eq "1" ? "checked" : ""}
                                                                                            value="1"> 有异常</label>
                            <input type="text"
                                   id="abdominalPalpAnomalyDesc" name="abdominalPalpAnomalyDesc"
                                   value="${neonatalFamilyVisit.abdominalPalpAnomalyDesc}"
                                   CLASS="hidediv" style="width: 200px;"
                                   reg='{"dependOn":"abdominalPalpAnomaly","required":"true","maxlength":"33"}'>
                        </td>
                    </tr>
                    <tr>
                        <th>脊柱检查异常</th>
                        <td colspan="2"><label><input type="radio"
                                                      onclick="util.clickHideText(this,'spinalCheckAnomalyDesc')"
                                                      name="spinalCheckAnomaly"
                        ${neonatalFamilyVisit.spinalCheckAnomaly eq "0" ? "checked" : ""}
                                                      value="0"> 未见异常</label> <label><input type="radio"
                                                                                            id="spinalCheckAnomaly"
                                                                                            onclick="util.clickShowText(this,'spinalCheckAnomalyDesc')"
                                                                                            name="spinalCheckAnomaly"
                        ${neonatalFamilyVisit.spinalCheckAnomaly eq "1" ? "checked" : ""}
                                                                                            value="1"> 有异常</label>
                            <input type="text"
                                   id="spinalCheckAnomalyDesc" name="spinalCheckAnomalyDesc"
                                   value="${neonatalFamilyVisit.spinalCheckAnomalyDesc}"
                                   CLASS="hidediv" style="width: 200px;"
                                   reg='{"dependOn":"spinalCheckAnomaly","required":"true","maxlength":"33"}'>
                        </td>
                    </tr>
                    <tr>
                        <th>脐带检查结果</th>
                        <td colspan="2"><span id="wineTypeSpan"> <label><input
                                type="radio"
                                onclick="util.clickHideText(this,'umbilicalCordCheckDesc')"
                                name="umbilicalCordCheck"
                        ${neonatalFamilyVisit.umbilicalCordCheck eq "1" ? "checked" : ""}
                                value="1"> 未脱</label> <label><input type="radio"
                                                                    onclick="util.clickHideText(this,'umbilicalCordCheckDesc')"
                                                                    name="umbilicalCordCheck"
                        ${neonatalFamilyVisit.umbilicalCordCheck eq "2" ? "checked" : ""}
                                                                    value="2"> 脱落</label> <label><input type="radio"
                                                                                                        onclick="util.clickHideText(this,'umbilicalCordCheckDesc')"
                                                                                                        name="umbilicalCordCheck"
                        ${neonatalFamilyVisit.umbilicalCordCheck eq "3" ? "checked" : ""}
                                                                                                        value="3"> 脐部有渗出</label> <label><input
                                type="radio"
                                id="umbilicalCordCheck"
                                onclick="util.clickShowText(this,'umbilicalCordCheckDesc')"
                                name="umbilicalCordCheck"
                        ${neonatalFamilyVisit.umbilicalCordCheck eq "4" ? "checked" : ""}
                                value="4"> 其他</label> <input type="text"
                                                             id="umbilicalCordCheckDesc" name="umbilicalCordCheckDesc"
                                                             value="${neonatalFamilyVisit.umbilicalCordCheckDesc}"
                                                             CLASS="hidediv" style="width: 200px;"
                                                             reg='{"dependOn":"umbilicalCordCheck","required":"true","maxlength":"33"}'>
						</span>
                        </td>
                    </tr>
                    <tr>
                        <th>转诊建议</th>
                        <td><ehr:dic-radio name="referralFlag" dicmeta="FS10187"
                                           code="1,2" value="${neonatalFamilyVisit.referralFlag}"/>
                            <div id="referralDetail"
                            ${"1" eq neonatalFamilyVisit.referralFlag ? '' : 'hidden'}>
                                原&emsp;&emsp;因&nbsp;<input type="text" id="referralReason" name="referralReason"
                                         value="${neonatalFamilyVisit.referralReason}">
                                <br>
                                转诊机构&nbsp;<input type="text" reg="{'required':true}" id="referralHospitalName"
                                           name="referralHospitalName"
                                           value="${neonatalFamilyVisit.referralHospitalName}">
                                <br>
                                转诊科室&nbsp;<input type="text" reg="{'required':true}" id="referralDeptName"
                                           name="referralDeptName" value="${neonatalFamilyVisit.referralDeptName}">
                            </div>
                        </td>

                    </tr>
                    <tr>
                        <th>新生儿访视健康指导</th>
                        <td colspan="3"><ehr:dic-checkbox
                                name="healthGuidanceCategory"
                                value="${neonatalFamilyVisit.healthGuidanceCategory}"
                                dicmeta="CV0600217"></ehr:dic-checkbox></td>
                    </tr>
                    <tr>
                        <th><label class="required">本次访视日期</label></th>
                        <td>
                            <jsp:useBean id="today" class="java.util.Date"/>
                            <input type="text" class="layui-input x-admin-content-sm-date" name="visitDate" id="visitDate"
                                   reg='{"required":true}' value="<fmt:formatDate value='${empty neonatalFamilyVisit.visitDate?today:neonatalFamilyVisit.visitDate}' pattern='yyyy/MM/dd'/>"/>

                        </td>
                        <th><label class="required">访视医师姓名</label></th>
                        <td>
                            <ehr:staff-list reg='{"required":true}' name="supervisionDoctor" id="supervisionDoctor"
                                            value="${neonatalFamilyVisit.supervisionDoctor}" defaultval="Y"/>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">下次访视地点</label></th>
                        <td><ehr:org-type-list id="nextSupervisionPlace" name="nextSupervisionPlace" type="hospital,centre"
                                               reg="{'required':true}"
                                               value="${neonatalFamilyVisit.nextSupervisionPlace}"/></td>
                        <th><label class="required">下次访视日期</label></th>
                        <td>
                            <input type="text" class="layui-input x-admin-content-sm-date" name="nextSupervisionDate" id="nextSupervisionDate"
                                   reg='{"required":true}' value="<fmt:formatDate value='${neonatalFamilyVisit.nextSupervisionDate}' pattern='yyyy/MM/dd'/>"/>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </form>
</div>

<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        laydate.render({
            elem: '#text_inputDate'
            ,format: 'yyyy/MM/dd'
            ,max:0
            ,trigger: 'click'
        });
        laydate.render({
            elem: '#fatherBirthday'
            ,format: 'yyyy/MM/dd'
            ,max:0
            ,trigger: 'click'
        });
        laydate.render({
            elem: '#motherBirthday'
            ,format: 'yyyy/MM/dd'
            ,max:0
            ,trigger: 'click'
        });
        laydate.render({
            elem: '#visitDate'
            ,format: 'yyyy/MM/dd'
            ,max:0
            ,trigger: 'click'
        });
        laydate.render({
            elem: '#nextSupervisionDate'
            ,format: 'yyyy/MM/dd'
            ,max:0
            ,trigger: 'click'
        });
    });
</script>
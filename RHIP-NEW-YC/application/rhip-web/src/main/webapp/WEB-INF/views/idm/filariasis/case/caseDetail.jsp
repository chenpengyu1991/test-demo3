<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="${pageContext.request.contextPath}/js/views/idm/filariasis/filariasisCase.js"
        type="text/javascript"></script>

<script type="text/javascript">
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        laydate.render({
            elem: '#birthday'
            , format: 'yyyy/MM/dd'
            , max: 0
            , done: function (value) {
                if (!$.isEmpty(value)) {
                    $("#birthday").removeClass("lose");
                } else {
                    $("#birthday").addClass("lose");
                }
            }
        });
        


        laydate.render({
            elem: '#modifySurveyDate'
            , format: 'yyyy/MM/dd'
            , max: 0
            , done: function (value) {
                if (!$.isEmpty(value)) {
                    $("#modifySurveyDate").removeClass("lose");
                } else {
                    $("#modifySurveyDate").addClass("lose");
                }
            }
        });
        
        
        laydate.render({
            elem: '#microfilariaDt'
            , format: 'yyyy/MM/dd'
            , max: 0
            , done: function (value) {
                if (!$.isEmpty(value)) {
                    $("#microfilariaDt").removeClass("lose");
                } else {
                    $("#microfilariaDt").addClass("lose");
                }
            }
        });

        laydate.render({
        	 elem: '#breakOutDt'
                 , type: 'year'
            , max: 0
            , done: function (value) {
                if (!$.isEmpty(value)) {
                    $("#breakOutDt").removeClass("lose");
                } else {
                    $("#breakOutDt").addClass("lose");
                }
            }
        });
        

        laydate.render({
            elem: '#lastBreakOutDt'
            	, type: 'month'
            , format: 'yyyy/MM'
            , max: 0
            , done: function (value) {
                if (!$.isEmpty(value)) {
                    $("#lastBreakOutDt").removeClass("lose");
                } else {
                    $("#lastBreakOutDt").addClass("lose");
                }
            }
        });
        
        
        laydate.render({
            elem: '#chyluriaDt'
            , type: 'year'
            , max: 0
            , done: function (value) {
                if (!$.isEmpty(value)) {
                    $("#chyluriaDt").removeClass("lose");
                } else {
                    $("#chyluriaDt").addClass("lose");
                }
            }
        });
        
        
        laydate.render({
            elem: '#chyluriaLastDt'
            	, type: 'month'
            , format: 'yyyy/MM'
            , max: 0
            , done: function (value) {
                if (!$.isEmpty(value)) {
                    $("#chyluriaLastDt").removeClass("lose");
                } else {
                    $("#chyluriaLastDt").addClass("lose");
                }
            }
        });
        
        laydate.render({
        	elem: '#tunicaVaginaliDt'
            , type: 'month'
            ,format: 'yyyy/MM'
            , max: 0
            , done: function (value) {
                if (!$.isEmpty(value)) {
                    $("#chyluriaLastDt").removeClass("lose");
                } else {
                    $("#chyluriaLastDt").addClass("lose");
                }
            }
        });
    });

</script>

<div class="toolbar">
    <div class="toolbar" style="background: none">
        <a href="javascript:filariasisCase.returnSearch()" id="cancelContact"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
        <c:if test="${logoff != '1'}">
            <c:if test="${type =='add'}">
                <a href="javascript:filariasisCase.caseSubmit('add')"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
            </c:if>
            <c:if test="${type =='edit'}">
                <%--<a href="javascript:filariasisCase.caseSubmit('edit')"><b class="xiug">修改</b></a>--%>
                <a href="javascript:filariasisCase.caseSubmit('edit')"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
            </c:if>
        </c:if>
    </div>

</div>
<form id="caseForm">
<div class="postcontent divFixed125">
<i class="popno" style="height: auto;padding-top: 10px;"> 慢性丝虫病个案调查表
</i>
<input type="hidden" id="singleIdCase" name="singleId" value="${singleId}"/>
<input type="hidden" id="idmIdCase" name="idmId" value="${idmId}"/>
<input type="hidden" name="caseInformation.id" value="${filDto.caseInformation.id}"/>
<input type="hidden" name="generalCondition.id" value="${filDto.generalCondition.id}"/>
<input type="hidden" name="generalCondition.age" value="${filDto.generalCondition.age}"/>
<input type="hidden" name="pastHistory.id" value="${filDto.pastHistory.id}"/>
<input type="hidden" name="attackCondition.id" value="${filDto.attackCondition.id}"/>
<input type="hidden" name="clinicalManifestations.id" value="${filDto.clinicalManifestations.id}"/>
<input type="hidden" name="labExamine.id" value="${filDto.labExamine.id}"/>


<div class="postdiv">
    <table class="posttable">
        <colgroup>
            <col style="width: 50%;"/>
            <col style="width: 50%;"/>
        </colgroup>
        <tr style="text-align: right">
            <td>编号：<input type="text" name="caseInformation.mediRecordNum" style="width: 120px;"
                          value="${filDto.caseInformation.mediRecordNum}" reg='{"maxlength":"6"}'/></td>
        </tr>
    </table>
    <fieldset>
        <legend>一般情况</legend>
        <table class="posttable">
            <colgroup>
                <col style="width: 21%"/>
                <col style="width: 29%"/>
                <col style="width: 23%"/>
                <col style="width: 27%"/>
            </colgroup>
            <tr>
                <th>姓名：</th>
                <td>
                    <input type="text" name="generalCondition.name" value="${filDto.generalCondition.name}"
                           reg='{"maxlength":"50"}'/>
                </td>
                <th>性别：</th>
                <td>
                    <ehr:dic-radio dicmeta="GBT226112003" name="generalCondition.gender" code="1,2"
                                   value="${filDto.generalCondition.gender}"/>
                </td>
            </tr>
            <tr>
                <th>出生日期：</th>
                <td>
                    <input type="text" reg='{"required":"true"}' class="layui-input x-admin-content-sm-date"
                           name="generalCondition.birthday" id="birthday"
                           value="<fmt:formatDate value='${filDto.generalCondition.birthday}' pattern='yyyy/MM/dd'/>"
                           style="padding-left: 0px;"/>
                </td>
            </tr>
            <tr>
                <th>现住址：</th>
                <td colspan="3">
                    <ehr:dic-town-street-village villageId="pavillage_address" streetId="pastreet_address" callback="idmCommon.displayPaAddress"
                                                 townId="patown_address" villageName="generalCondition.paGroup" streetName="generalCondition.pastreet"
                                                 townName="generalCondition.patownShip" villageValue="${filDto.generalCondition.paGroup}" streetValue="${filDto.generalCondition.pastreet}"
                                                 townValue="${filDto.generalCondition.patownShip}" width="180px;"/>
                    <div>
                        <label id="tempPaValue">
                            <ehr:dic code="${filDto.generalCondition.patownShip}" dicmeta="FS990001"/>
                            <ehr:dic code="${filDto.generalCondition.pastreet}" dicmeta="FS990001"/>
                            <ehr:dic code="${filDto.generalCondition.paGroup}" dicmeta="FS990001"/>
                        </label>
                        <input type="text" id="text_pahouseNumber" name="generalCondition.pahouseNumber" value="${filDto.generalCondition.pahouseNumber}"
                               reg='{"maxlength":"50","required":"true"}'  style="width: 180px;">
                        <span id="spanPaNumber">(门牌号)</span>
                    </div>
                </td>
            </tr>
            <tr>
                <th>职业：</th>
                <td colspan="3">
                    <ehr:dic-list dicmeta="GBT6565" name="generalCondition.occupation" width="180px;"
                                  value="${filDto.generalCondition.occupation}"
                                  code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120208,CV020120209,CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120299"
                                  onchange="toggleOtherSC('generalCondition.occupation','occupationPart','CV020120299');"/>
                            <span id="occupationPart" style="display: none">
                                <input type="text" name="generalCondition.occupationOther"
                                       value="${filDto.generalCondition.occupationOther}"
                                       reg='{"maxlength":"30"}' style="width: 200px;"/>
                            </span>
                </td>
            </tr>
            <tr>
                <th>电话：</th>
                <td><input type="text" name="generalCondition.phoneNumber"
                           value="${filDto.generalCondition.phoneNumber}" reg='{"regex":"phone"}'/></td>
                <th>邮编：</th>
                <td><input type="text" name="generalCondition.postcode"
                           value="${filDto.generalCondition.postcode}" reg='{"regex":"postCode"}'/></td>
            </tr>
            <tr></tr>
        </table>
    </fieldset>
</div>
<div class="postdiv">
<fieldset>
<legend>疾病信息</legend>
<table class="posttable">
<colgroup>
    <col style="width: 21%"/>
    <col style="width: 29%"/>
    <col style="width: 23%"/>
    <col style="width: 27%"/>
</colgroup>
<tr>
    <th><b>既往微丝蚴检查情况：</b></th>
    <td>
        <ehr:dic-radio name="pastHistory.microfilariaCheck" dicmeta="PH00025"
                       value="${filDto.pastHistory.microfilariaCheck}"
                       onchange="toggleOther('pastHistory.microfilariaCheck','microfilariaCheckPart',2);"/>
    </td>
    <td></td>
    <td></td>
</tr>
<tbody id="microfilariaCheckPart" style="display: none">
    <tr>
        <th>血检日期</th>
        <td>
            <input type="text" reg='{"required":"true"}' class="layui-input x-admin-content-sm-date"
                   name="pastHistory.microfilariaDt" id="microfilariaDt"
                   value="<fmt:formatDate value='${filDto.pastHistory.microfilariaDt}' pattern='yyyy/MM/dd'/>"
                   style="padding-left: 0px;"/>
        </td>
        <th>检查结果</th>
        <td>
            <ehr:dic-radio name="pastHistory.microfilariaResult" dicmeta="PH00004" code="2,1,4"
                           value="${filDto.pastHistory.microfilariaResult}"/>
        </td>
    </tr>
    <tr>
        <th>乙胺嗪治疗</th>
        <td><ehr:dic-radio name="pastHistory.diethylcarbamazine" dicmeta="PH00002" code="1,2,4"
                           value="${filDto.pastHistory.diethylcarbamazine}"/></td>
    </tr>
</tbody>
<tr>
    <th><label class="required"><b>淋巴管/结炎发作情况：</b></label></th>
    <td><ehr:dic-radio name="attackCondition.lymphatic" dicmeta="PH00002" code="1,2" reg='{"required":"true"}'
                       value="${filDto.attackCondition.lymphatic}" onchange="toggleOther('attackCondition.lymphatic','lymphaticPart',1);"/></td>
</tr>
<tbody id="lymphaticPart" style="display: none">
    <tr>
        <th>1.首次发作时间：</th>
        <td>
            <input type="text" reg='{"required":"true"}' class="layui-input x-admin-content-sm-date"
                   name="attackCondition.breakOutDt" id="breakOutDt"
                   value="<fmt:formatDate value='${filDto.attackCondition.breakOutDt}' pattern='yyyy'/>"
                   style="padding-left: 0px;"/>
        </td>
        <th>2.最近发作时间：</th>
        <td>
            <input type="text" reg='{"required":"true"}' class="layui-input x-admin-content-sm-date"
                   name="attackCondition.lastBreakOutDt" id="lastBreakOutDt"
                   value="<fmt:formatDate value='${filDto.attackCondition.lastBreakOutDt}' pattern='yyyy/MM'/>"
                   style="padding-left: 0px;"/>
        </td>
    </tr>
    <tr>
        <th>3.年平均发作次数：</th>
        <td><input type="text" name="attackCondition.breakOutNum" value="${filDto.attackCondition.breakOutNum}" reg='{"maxlength":"20"}'></td>
        <th>4.平均病程天数：</th>
        <td><input type="text" name="attackCondition.perDays" value="${filDto.attackCondition.perDays}" reg='{"maxlength":"20"}'></td>
    </tr>
    <tr>
        <th>5.发作季节：</th>
        <td>
            <ehr:dic-radio name="attackCondition.breakOutSeason" dicmeta="IDM00277"
                           value="${filDto.attackCondition.breakOutSeason}"/>
        </td>
        <th>6.发作部位</th>
        <td>
            <ehr:dic-radio name="attackCondition.breakOutPart" dicmeta="IDM00278"
                           value="${filDto.attackCondition.breakOutPart}"/>
        </td>
    </tr>
    <tr>
        <th>7.发作特点：</th>
        <td>
            <ehr:dic-radio name="attackCondition.breakOutPoint" dicmeta="IDM00279"
                           value="${filDto.attackCondition.breakOutPoint}"/>
        </td>
        <th>8.丹毒样皮炎</th>
        <td>
            <ehr:dic-radio name="attackCondition.erysipelas" dicmeta="PH00002" code="1,2"
                           value="${filDto.attackCondition.erysipelas}"/>
        </td>
    </tr>
    <tr>
        <th>9.高热寒战史项：</th>
        <td>
            <ehr:dic-radio name="pastHistory.hyerpyrexiaShiver" dicmeta="PH00002" code="1,2"
                           value="${filDto.pastHistory.hyerpyrexiaShiver}"/>
        </td>
    </tr>
</tbody>

<tr>
    <th><label class="required"><b>淋巴水肿/象皮肿：</b></label></th>
    <td><ehr:dic-radio name="attackCondition.lymphedema" dicmeta="PH00002" code="1,2" reg='{"required":"true"}'
                       value="${filDto.attackCondition.lymphedema}" onchange="toggleOther('attackCondition.lymphedema','lymphedemaPart',1);"/></td>
</tr>
<tbody id="lymphedemaPart" style="display: none">
    <tr>
        <th>1.部位：</th>
        <td colspan="3">
            上肢：<ehr:dic-list width="200px" name="clinicalManifestations.upperLimb" dicmeta="IDM00280"
                             value="${filDto.clinicalManifestations.upperLimb}"/>
            下肢：<ehr:dic-list width="200px" name="clinicalManifestations.lowerLimb" dicmeta="IDM00280"
                             value="${filDto.clinicalManifestations.lowerLimb}"/>
            其他：<ehr:dic-list width="200px" name="clinicalManifestations.otherSelect" dicmeta="IDM00281"
                             value="${filDto.clinicalManifestations.otherSelect}"/>
        </td>
    </tr>
    <tr>
        <th>2.分期（七期法）：</th>
        <td>
            左<input type="text" name="clinicalManifestations.leftStage"
                    value="${filDto.clinicalManifestations.leftStage}" style="width: 80px; text-align: center" reg='{"maxlength":"20"}'>期
            右<input type="text" name="clinicalManifestations.rightStage"
                    value="${filDto.clinicalManifestations.rightStage}" style="width: 80px; text-align: center" reg='{"maxlength":"20"}'>期
        </td>
    </tr>
    <tr>
        <th>3.下肢腿围测量：</th>
        <td>
            左<input type="text" name="clinicalManifestations.lowerLimbLeft" value="${filDto.clinicalManifestations.lowerLimbLeft}"
                    reg='{"maxlength":"20"}' style="width: 80px; text-align: center">cm
            右<input type="text" name="clinicalManifestations.lowerLimbRight" value="${filDto.clinicalManifestations.lowerLimbRight}"
                    reg='{"maxlength":"20"}' style="width: 80px; text-align: center">cm
        </td>
    </tr>
    <tr>
        <th>4.凹陷性水肿：</th>
        <td>
            <ehr:dic-radio name="clinicalManifestations.pittingEdema" dicmeta="PH00002" code="1,2"
                           value="${filDto.clinicalManifestations.pittingEdema}"/>
        </td>
        <th>5.溃疡</th>
        <td>
            <ehr:dic-radio name="clinicalManifestations.isUlcer" dicmeta="PH00002" code="1,2"
                           value="${filDto.clinicalManifestations.isUlcer}"/>
        </td>
    </tr>
    <tr>
        <th>6.皮肤：</th>
        <td>
            <ehr:dic-radio name="clinicalManifestations.skin" dicmeta="IDM00282"
                           value="${filDto.clinicalManifestations.skin}"/>
        </td>
        <th>7.皮肤增厚</th>
        <td>
            <ehr:dic-radio name="clinicalManifestations.skinThichen" dicmeta="PH00002" code="1,2"
                           value="${filDto.clinicalManifestations.skinThichen}"/>
        </td>
    </tr>
    <tr>
        <th>8.皮肤皱褶：</th>
        <td>
            <ehr:dic-radio name="clinicalManifestations.skinFold" dicmeta="PH00002" code="1,2"
                           value="${filDto.clinicalManifestations.skinFold}"/>
        </td>
        <th>9.患肢畸形：</th>
        <td>
            <ehr:dic-radio name="clinicalManifestations.deformity" dicmeta="PH00002" code="1,2"
                           value="${filDto.clinicalManifestations.deformity}"/>
        </td>
    </tr>
    <tr>
        <th>10.功能障碍：</th>
        <td>
            <ehr:dic-radio name="clinicalManifestations.dysfunction" dicmeta="PH00002" code="1,2"
                           value="${filDto.clinicalManifestations.dysfunction}"/>
        </td>
    </tr>
</tbody>

<tr>
    <th><label class="required"><b>乳 糜 尿：</b></label></th>
    <td><ehr:dic-radio name="attackCondition.chyluria" dicmeta="PH00002" code="1,2" reg='{"required":"true"}'
                       value="${filDto.attackCondition.chyluria}" onchange="toggleOther('attackCondition.chyluria','chyluriaPart',1);"/></td>
</tr>
<tbody id="chyluriaPart" style="display: none">
    <tr>
        <th>1.首次发作时间：</th>
        <td>
            <input type="text" reg='{"required":"true"}' class="layui-input x-admin-content-sm-date"
                   name="attackCondition.chyluriaDt" id="chyluriaDt"
                   value="<fmt:formatDate value='${filDto.attackCondition.chyluriaDt}' pattern='yyyy'/>"
                   style="padding-left: 0px;"/>
        </td>
        <th>2.最近发作时间：</th>
        <td>
            <input type="text" reg='{"required":"true"}' class="layui-input x-admin-content-sm-date"
                   name="attackCondition.chyluriaLastDt" id="chyluriaLastDt"
                   value="<fmt:formatDate value='${filDto.attackCondition.chyluriaLastDt}' pattern='yyyy/MM'/>"
                   style="padding-left: 0px;"/>
        </td>
    </tr>
    <tr>
        <th>3.年发作频率：</th>
        <td><input type="text" name="attackCondition.chyluriaRate" value="${filDto.attackCondition.chyluriaRate}" reg='{"maxlength":"20"}'>
        </td>
        <th>4.发作最长持续时间（天）：</th>
        <td><input type="text" name="attackCondition.chyluriaDuration"
                   value="${filDto.attackCondition.chyluriaDuration}" reg='{"maxlength":"20"}'></td>
    </tr>
    <tr>
        <th>5.发作诱因：</th>
        <td>
            <ehr:dic-radio name="attackCondition.chyluriaResult" dicmeta="IDM00283"
                           value="${filDto.attackCondition.chyluriaResult}"/>
        </td>
        <th>6.发作特点：</th>
        <td>
            <ehr:dic-radio name="attackCondition.chyluriaPoint" dicmeta="IDM00284"
                           value="${filDto.attackCondition.chyluriaPoint}"/>
        </td>
    </tr>
    <tr>
        <th>7.尿液外观：</th>
        <td>
            <ehr:dic-radio name="labExamine.urineGuise" dicmeta="IDM00285" value="${filDto.labExamine.urineGuise}"/>
        </td>
        <th>8.排尿困难：</th>
        <td>
            <ehr:dic-radio name="labExamine.urineHard" dicmeta="PH00002" code="1,2"
                           value="${filDto.labExamine.urineHard}"/>
        </td>
    </tr>
    <tr>
        <th>9.乳糜试验：</th>
        <td>
            <ehr:dic-radio name="labExamine.chy" dicmeta="FS10043" code="2,1" value="${filDto.labExamine.chy}"/>
        </td>
        <th>10.治疗情况：</th>
        <td>
            <ehr:dic-list name="labExamine.treatCondition" dicmeta="IDM00286"
                          value="${filDto.labExamine.treatCondition}"/>
        </td>
    </tr>
</tbody>

<tr>
    <th><label class="required"><b>鞘膜积液：</b></label></th>
    <td><ehr:dic-radio name="attackCondition.tunicaVaginali" dicmeta="PH00002" code="1,2" reg='{"required":"true"}'
                       value="${filDto.attackCondition.tunicaVaginali}" onchange="toggleOther('attackCondition.tunicaVaginali','tunicaVaginaliPart',1);"/></td>
</tr>
<tbody id="tunicaVaginaliPart" style="display: none">
    <tr>
        <th>1.首次发作时间：</th>
        <td>
        	<input type="text" class="layui-input x-admin-content-sm-date"
                   name="attackCondition.tunicaVaginaliDt" id="tunicaVaginaliDt"
                   value="<fmt:formatDate value='${filDto.attackCondition.tunicaVaginaliDt}' pattern='yyyy/MM'/>"
                   style="padding-left: 0px;"/>
                   
            <%-- <tag:dateInput id="tunicaVaginaliDt" name="attackCondition.tunicaVaginaliDt" onlypast="true" pattern="yyyy/MM"
                           date="${filDto.attackCondition.tunicaVaginaliDt}"/> --%>
        </td>
        <th>2.部位：</th>
        <td>
            <ehr:dic-radio name="attackCondition.tunicaVaginaliPoint" dicmeta="IDM00280"
                           value="${filDto.attackCondition.tunicaVaginaliPoint}"/>
        </td>
    </tr>
    <tr>
        <th>3.鞘膜积液大小：</th>
        <td>
            长度：<input type="text" name="labExamine.tunicaVaginalWidth"
                      value="${filDto.labExamine.tunicaVaginalWidth}" style="width: 60px; text-align: center" reg='{"maxlength":"20"}'>cm
            周径：<input type="text" name="labExamine.tunicaVaginalGirth"
                      value="${filDto.labExamine.tunicaVaginalGirth}" style="width: 60px; text-align: center" reg='{"maxlength":"20"}'>cm
        </td>
        <th>4.压痛：</th>
        <td>
            <ehr:dic-radio name="labExamine.tenderness" dicmeta="PH00002" code="1,2"
                           value="${filDto.labExamine.tenderness}"/>
        </td>
    </tr>
    <tr>
        <th>5.透光试验：</th>
        <td>
            <ehr:dic-radio name="labExamine.transillumination" dicmeta="FS10043" code="2,1"
                           value="${filDto.labExamine.transillumination}"/>
        </td>
    </tr>
</tbody>
</table>
</fieldset>
</div>

<div class="postdiv">
    <fieldset>
        <table class="posttable">
            <colgroup>
                <col style="width: 21%"/>
                <col style="width: 29%"/>
                <col style="width: 23%"/>
                <col style="width: 27%"/>
            </colgroup>
            <tr>
                <th>调查人：</th>
                <td>
                    <ehr:staff-name staffCode="${filDto.caseInformation.modifyRespondents}"/>
                    <input type="hidden" name="caseInformation.modifyRespondents" value="${filDto.caseInformation.modifyRespondents}"/>
                    <input type="hidden" name="caseInformation.surveyOrg" value="${filDto.caseInformation.surveyOrg}"/>
                    <%--<ehr:staff-list name="caseInformation.modifyRespondents" orgCode="" value="${filDto.caseInformation.modifyRespondents}" />--%>
                </td>
                <th>调查日期：</th>
                <td>
                    <input type="text" reg='{"required":"true"}' class="layui-input x-admin-content-sm-date"
                           name="caseInformation.modifySurveyDate" id="modifySurveyDate"
                           value="<fmt:formatDate value='${filDto.caseInformation.modifySurveyDate}' pattern='yyyy/MM/dd'/>"
                           style="padding-left: 0px;"/>
            </tr>
        </table>
    </fieldset>
</div>
</div>
</form>

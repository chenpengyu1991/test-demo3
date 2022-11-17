<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<form id="report-input-form">
    <input type="hidden" id='report-result' value="-1"/>
    <input type="hidden" name='status' value="1"/>
	<input type="hidden" name='personId' value="${food.personId}"/>
	<input type="hidden" name='id' value="${food.id}"/>
    <input type="hidden" id="reportRecordId" name ="reportRecordId" value="${reportRecordId}">
<div class="postcontent contentfixed32">
<i class="popno">食源性疾病病例信息信息表</i>

<div class="postdiv">
<fieldset>
    <legend>基本信息</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 15%; min-width: 100px;"/>
            <col style="width: 35%; min-width: 200px;"/>
            <col style="width: 15%; min-width: 100px;"/>
            <col style="width: 35%; min-width: 200px;"/>
        </colgroup>
        <tr>
            <th>标本编号：</th>
            <td>
                PJS05<input type="text" name="no1" value="${food.no1}" reg='{"maxlength":"20"}' style="width: 10%;"/>
                2014<input type="text" name="no2" value="${food.no2}" reg='{"maxlength":"20"}' style="width: 10%;"/>
            </td>
        </tr>
        <tr>
            <th><label class="required">姓名</label></th>
            <td><input type="text" name="name" value="${food.name}" reg="{'required':true,'maxlength':50}"/></td>
            <th><label class="required">性别</label></th>
            <td><ehr:dic-radio id="gender" uninclude="0,9" dicmeta="GBT226112003" name="gender" value="${food.gender}"
                               reg="{'required':true}"/></td>
        </tr>
        <tr>
            <th><label class="required">出生年月</label></th>
            <td><tag:dateInput name="birthday" id="birthday" onlypast="true" reg="{'required':true}"
                               date="${food.birthday}"/></td>
            <th>身份证</th>
            <td>
                <input type="text" id="idCardTemp" name="idcard" value="${food.idcard}" reg='{"idCard":true}'
                       placeholder="输入身份证获取人员信息"/>
            </td>
        </tr>
        <tr>
            <th>监护人姓名</th>
            <td><input type="text" name="parentsName" value="${food.parentsName}" reg="{'maxlength':50}"/></td>
        </tr>
        <tr>
            <th><label class="required">病人属于</label></th>
            <td colspan="3">
                <ehr:dic-radio name="floatPopulation" dicmeta="CV0201104" id="floatPopulationId"
                               value="${food.floatPopulation}"
                               reg='{"required":"true"}'/>
            </td>
        </tr>
        <tr>
            <th><label class="required">现住址(详填)</label></th>
            <td colspan="3">
                <div class="${'1' eq food.floatPopulation?'':'hide' }" id="pa-address-select">
                    <ehr:dic-town-village villageId="pavillage_address" townId="patown_address"
                                          villageName="pastreet" townName="patownShip"
                                          villageValue="${food.pastreet}"
                                          townValue="${food.patownShip}" width="180px;"/>
                </div>
                <label id="tempPaValue">
                    <ehr:dic code="${food.patownShip}" dicmeta="FS990001"/><ehr:dic code="${food.pastreet}"
                                                                                    dicmeta="FS990001"/>
                </label>
                <input type="text" id="pahouseNumber" name="pahouseNumber" value="${food.pahouseNumber}"
                       reg='{"required":"true","maxlength":"70"}' style="width: 180px;"/>
                <span id="spanPaNumber">(门牌号)</span>
            </td>
        </tr>
        <tr>
            <th><label class="required">联系电话</label></th>
            <td><input type="text" name="phoneNumber" value="${food.phoneNumber}"
                       reg="{'required':true,'regex':'phone'}"/></td>
            <th><label class="required">门诊号</label></th>
            <td><input type="text" name="outpatientNo" value="${food.outpatientNo}" reg="{'required':true,'maxlength':20}"/></td>
        </tr>
        <tr>
            <th><label class="required">发病时间</label></th>
            <td>
                <tag:dateInput nullToToday="true" name="pathogenesisDate" pattern="yyyy/MM/dd HH:mm:ss"
                               id="pathogenesisDate"
                               date="${food.pathogenesisDate}" onlypast="true"
                               reg='{"required":"true","compare":["diagnosisDate","le","发病时间不能小于就诊时间"]}'
                               style="width: 140px"></tag:dateInput>
            </td>
            <th><label class="required">就诊时间</label></th>
            <td>
                <tag:dateInput nullToToday="true" name="diagnosisDate" pattern="yyyy/MM/dd HH:mm:ss" id="diagnosisDate"
                               date="${food.diagnosisDate}" onlypast="true"
                               reg='{"required":"true","compare":["pathogenesisDate","ge","就诊时间不能小于发病时间"]}'
                               style="width: 140px"></tag:dateInput>
            </td>
        </tr>
        <tr>
            <th><label class="required">职业</label></th>
            <td colspan="3">
                <ehr:dic-list name="infectedpersonOccupation" dicmeta="GBT6565" value="${food.infectedpersonOccupation}"
                              reg='{"required":"true"}' width="200px"
                              onchange="toggleOtherSC('infectedpersonOccupation','occupationOther','CV020120299')"
                              code="CV020120201,CV020120203,CV020120211,CV020120210,CV020120206,CV020120208,CV020120204,CV020120214,CV020120215,CV020120216,CV020120299"/>
                            <span id="occupationOther"
                                  style="${food.infectedpersonOccupation == 'CV020120299' ? '' : 'display:none;'}">
                            	<input type="text" style="width: 150px;" name="occupationOther"
                                       value="${occupationOther}" reg='{"maxlength":"20"}'/>
                            </span>
            </td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <legend>主要症状与体征</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 15%; min-width: 100px;"/>
            <col style="width: 35%; min-width: 200px;"/>
            <col style="width: 15%; min-width: 100px;"/>
            <col style="width: 35%; min-width: 200px;"/>
        </colgroup>
        <tr>
            <th>全身</th>
            <td colspan="3">
                <ehr:dic-checkbox name="wholeBody" value="${food.wholeBody}" dicmeta="DMD00083"/>
            </td>
        </tr>
        <tr>
            <td></td>
        </tr>
        <tr>
            <th>中毒</th>
            <td colspan="3"><ehr:dic-checkbox name="toxication" value="${food.toxication}" dicmeta="DMD00084"/></td>
        </tr>
        <tr>
            <td></td>
        </tr>

        <tr>
            <th>肠道感染</th>
            <td colspan="3">
                <ehr:dic-checkbox name="intestinalInfection" value="${food.intestinalInfection}" dicmeta="DMD00070"
                                  code="201,202" />

                (<label style="color:red">*</label>性状
                <ehr:dic-checkbox name="laxSymptom" dicmeta="DMD00071" value="${food.laxSymptom}" reg='{"required":"true"}'/>
						                     	<input type="text" name="laxCount" value="${food.laxCount}"
                                                       reg='{"maxlength":"20","required":"true"}' style="width: 60px;"/>次/天)

                <ehr:dic-checkbox name="intestinalInfection" value="${food.intestinalInfection}" dicmeta="DMD00070"
                                  code="207,208,209"/>
                (<input type="text" name="feverTemp" value="${food.feverTemp}" reg='{"maxlength":"20"}'
                       style="width: 60px;"/>℃ )&nbsp;&nbsp;

                <ehr:dic-checkbox name="intestinalInfection" value="${food.intestinalInfection}" dicmeta="DMD00070"
                                  code="210"/>
            </td>
        </tr>
        <tr>
            <td></td>
        </tr>

        <tr>
            <th>一般感染</th>
            <td colspan="3"><ehr:dic-checkbox name="infect" dicmeta="DMD00072" value="${food.infect}"/></td>
        </tr>
        <tr>
            <td></td>
        </tr>

        <tr>
            <th>局部感染</th>
            <td colspan="3"><ehr:dic-checkbox name="partInfect" dicmeta="DMD00073" value="${food.partInfect}"/></td>
        </tr>
        <tr>
            <td></td>
        </tr>

        <tr>
            <th>神经症状</th>
            <td colspan="3">
                <ehr:dic-checkbox name="nerveSymptom" dicmeta="DMD00074" value="${food.nerveSymptom}"
                                  onchange="toggleOtherCK('nerveSymptom','pupilException','513')"/>
											 <span id="pupilException" style="display: none;">
						                     	（瞳孔异常描述：<input type="text" name="pupilException" value="${food.pupilException}"
                                                       reg='{"maxlength":"20"}' style="width: 20%;"/>）
						                     </span>
            </td>
        </tr>
        <tr>
            <td></td>
        </tr>
        <tr>
            <th>首发症状与体征(前三位)</th>
            <td><input type="text" name="symptom" value="${food.symptom}" reg="{'maxlength':100}"/></td>
            <th>其他症状与体征</th>
            <td><input type="text" name="symptomOther" value="${food.symptomOther}" reg="{'maxlength':100}"/></td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <legend>既往病史</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 15%; min-width: 100px;"/>
            <col style="width: 85%; min-width: 200px;"/>
        </colgroup>
        <tr>
            <th>既往病史</th>
            <td>
                <ehr:dic-checkbox name="previousHistory" dicmeta="DMD00075" value="${food.previousHistory }"
                                  onchange="toggleOtherCK('previousHistory','previousHistoryOther','99')"/>
								 <span id="previousHistoryOther" style="display: none;">
			                     	(<ehr:dic-checkbox name="previousHistoryOther" value="${food.previousHistoryOther}"
                                                       dicmeta="DMD00076"/>)
			                     </span>
            </td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <legend>临床初步诊断</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 15%; min-width: 100px;"/>
            <col style="width: 35%; min-width: 200px;"/>
            <col style="width: 15%; min-width: 100px;"/>
            <col style="width: 35%; min-width: 200px;"/>
        </colgroup>
        <tr>
            <th><label class="required">临床初步诊断</label></th>
            <td><input type="text" name="clinicalDiagnosis" value="${food.clinicalDiagnosis}"
                       reg='{"required":true,"maxlength":"20"}'/></td>
            <th>是否住院</th>
            <td><ehr:dic-radio name="inHospital" dicmeta="PH00001" code="1,2" value="${food.inHospital}"/></td>
        </tr>
        <tr>
            <th>就诊前服用抗生素</th>
            <td><ehr:dic-radio name="antibiotic" dicmeta="PH00001" code="1,2" value="${food.antibiotic}"/></td>
            <th>怀疑食物引起</th>
            <td><ehr:dic-radio name="foodCause" dicmeta="PH00001" code="1,2" value="${food.foodCause}"/></td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <legend>暴露信息（饮食史）</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 15%; min-width: 100px;"/>
            <col style="width: 35%; min-width: 200px;"/>
            <col style="width: 15%; min-width: 100px;"/>
            <col style="width: 35%; min-width: 200px;"/>
        </colgroup>
        <tr>
            <th>暴露信息：</th>
            <td colspan="3">
                <ehr:dic-checkbox name="foodHistory" dicmeta="DMD00077" value="${food.foodHistory}"
                                  onchange="toggleOtherCK('foodHistory','foodHistoryOther','99')"/>
								 <span id="foodHistoryOther" style="display: none;">
			                     	<input type="text" name="foodHistoryOther" value="${food.foodHistoryOther}"
                                           reg='{"maxlength":"100"}'/>
			                     </span>
            </td>
        </tr>
        <tr>
            <th></th>
            <td colspan="3" style="padding: 0px;">
                <div class="repeattable">
                    <table>
                        <colgroup>
                            <col style="width:10%;"/>
                            <col style="width:20%;"/>
                            <col style="width:20%;"/>
                            <col style="width:20%;"/>
                            <col style="width:10%;"/>
                            <col style="width:20%;"/>
                        </colgroup>
                        <thead>
                        <tr>
                            <th style="text-align: center;">可疑食物</th>
                            <th style="text-align: center;">食物名称或类别</th>
                            <th style="text-align: center;">进食食堂</th>
                            <th style="text-align: center;">进食时间</th>
                            <th style="text-align: center;">共同进食人数</th>
                            <th style="text-align: center;">其他人是否发病</th>
                        </tr>
                        <tr>
                            <td style="text-align: center;">1</td>
                            <td style="text-align: center;"><input type="text" name="food1" value="${food.food1}"
                                                                   reg='{"maxlength":"100"}'/></td>
                            <td style="text-align: center;"><ehr:dic-radio name="address1" dicmeta="DMD00078"
                                                                           value="${food.address1}"/></td>
                            <td style="text-align: center;">
                                <tag:dateInput nullToToday="true" name="foodDate1" pattern="yyyy/MM/dd HH:mm:ss"
                                               date="${food.foodDate1}" onlypast="true"
                                               style="width: 140px"></tag:dateInput>
                            </td>
                            <td style="text-align: center;"><input type="text" name="foodNum1" value="${food.foodNum1}"
                                                                   reg='{"maxlength":"20"}'/></td>
                            <td style="text-align: center;"><ehr:dic-radio name="attack1" dicmeta="DMD00079"
                                                                           value="${food.attack1}"/></td>
                        </tr>
                        <tr>
                            <td style="text-align: center;">2</td>
                            <td style="text-align: center;"><input type="text" name="food2" value="${food.food2}"
                                                                   reg='{"maxlength":"100"}'/></td>
                            <td style="text-align: center;"><ehr:dic-radio name="address2" dicmeta="DMD00078"
                                                                           value="${food.address2}"/></td>
                            <td style="text-align: center;">
                                <tag:dateInput nullToToday="true" name="foodDate2" pattern="yyyy/MM/dd HH:mm:ss"
                                               date="${food.foodDate2}" onlypast="true"
                                               style="width: 140px"></tag:dateInput>
                            </td>
                            <td style="text-align: center;"><input type="text" name="foodNum2" value="${food.foodNum2}"
                                                                   reg='{"maxlength":"20"}'/></td>
                            <td style="text-align: center;"><ehr:dic-radio name="attack2" dicmeta="DMD00079"
                                                                           value="${food.attack2 }"/></td>
                        </tr>
                        </thead>
                    </table>
                </div>
            </td>
        </tr>
        <tr>
            <th>发病前一周情况：</th>
            <td><ehr:dic-checkbox name="weekCondition" dicmeta="DMD00080" value="${food.weekCondition}"/></td>
            <td></td>
            <td></td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <legend>六、是否采集粪便和肛拭标本</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 15%; min-width: 100px;"/>
            <col style="width: 35%; min-width: 200px;"/>
            <col style="width: 15%; min-width: 100px;"/>
            <col style="width: 35%; min-width: 200px;"/>
        </colgroup>
        <tr>
            <th><label class="required">是否采集粪便和肛拭标本：</label></th>
            <td><ehr:dic-radio name="specimen" dicmeta="PH00001" code="1,2" value="${food.specimen}"
                               reg="{'required':true}" /></td>
            <th>标本类型：</th>
            <td><ehr:dic-radio name="specimenType" dicmeta="DMD00081" code="1,2" value="${food.specimenType}"/></td>
        </tr>
        <tr>
            <th>标本编号：</th>
            <td>
                SJS05<input type="text" name="specimenno1" value="${food.specimenno1}" reg='{"maxlength":"20"}'
                            style="width: 10%;"/>
                2014<input type="text" name="specimenno2" value="${food.specimenno2}" reg='{"maxlength":"20"}'
                           style="width: 10%;"/>
            </td>
            <th>医疗机构名称：</th>
            <td>
                ${food.fillOrganName}
                    <input type="hidden" name="fillOrganName" value="${food.fillOrganName}"/>
                    <input type="hidden" name="fillOrganCode" value="${food.fillOrganCode}"/>
            </td>
        </tr>
        <tr>
            <th>填表人：</th>
            <td>
                ${food.reportDoctorName}
                <%--<input type="hidden" name="reportDoctorId" value="${food.reportDoctorId}"/>--%>
                <input type="hidden" name="reportDoctorName" value="${food.reportDoctorName}"/>
            </td>
            <th>填写日期：</th>
            <td>
                <tag:dateInput nullToToday="true" name="fillDate" onlypast="true"
                               pattern="yyyy/MM/dd" date="${food.fillDate}"/>
            </td>
        </tr>
    </table>
</fieldset>
</div>
</div>
</form>

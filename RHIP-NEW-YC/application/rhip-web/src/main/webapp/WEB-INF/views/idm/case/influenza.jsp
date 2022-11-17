<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/influenza.js" type="text/javascript"></script>

<c:if test="${isPrint != 1}">
    <jsp:include page="caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
    <div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
    <i class="popno">
        流行性感冒个案调查表<br/>
        <span>（丙类传染病）</span>
    </i>
    <table>
		<colgroup>
			<col style="width: 20%" />
			<col style="width: 30%" />
			<col style="width: 20%" />
			<col style="width: 30%" />
		</colgroup>
		<tr>
			<th>国际标码：</th>
			<td>
				<input type="text" name="generalCondition.gbcode" value="${caseDto.generalCondition.gbcode}" style="width: 50%;"
				 	reg='{"maxlength":"14"}'/>
			</td>
            <th>病例编号：</th>
            <td>
               <input type="text" name="caseInformation.mediRecordNum" value="${caseDto.caseInformation.mediRecordNum}"  
					reg='{"maxlength":"14"}' style="width: 160px;"/>
            </td>
		</tr>
	</table>	
    <input type="hidden" name="idmId" value="${idmId}"/>

    <div class="postdiv">
    <fieldset>
        <legend>一、 一般情况</legend>
        <table class="posttable">
            <colgroup>
                <col style="width: 20%"/>
                <col style="width: 30%"/>
                <col style="width: 20%"/>
                <col style="width: 30%"/>
            </colgroup>
            <tr>
                <th>1．姓名：</th>
                <td colspan="3">
                    <input type="text" name="generalCondition.name" value="${caseDto.generalCondition.name}"
                           reg='{"maxlength":"100"}' style="width: 150px;"/>
                    （患儿家长姓名&nbsp;&nbsp;
                    <input type="text" name="generalCondition.parentsName" value="${caseDto.generalCondition.parentsName}"
                           reg='{"maxlength":"50"}' style="width: 150px;"/>）
                </td>
            </tr>
            <tr>
                <th>2．性别：</th>
                <td><ehr:dic-radio dicmeta="GBT226112003" name="generalCondition.gender" code="1,2" value="${caseDto.generalCondition.gender}"/></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <th>3．年龄：</th>
                <td colspan="3"><input type="text" name="generalCondition.age" value="${caseDto.generalCondition.age}" style="width: 80px;"
                           reg='{"maxlength":"6"}'/>
                    年龄单位：<ehr:dic-radio name="generalCondition.ageUnit" dicmeta="IDM00003" value="${caseDto.generalCondition.ageUnit}"/>
                </td>
            </tr>
            <tr>
                <th>4．职业：</th>
                <td colspan="3">
                    <ehr:dic-list dicmeta="GBT6565" name="generalCondition.occupation" width="180px;" value="${caseDto.generalCondition.occupation}"
                                  code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120208,CV020120209,CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120299"
                                  onchange="toggleOtherSC('generalCondition.occupation','occupationPart','CV020120299','CV020120217');"/>
                            <span  id="occupationPart" style="display: none">
                                <input type="text" name="generalCondition.occupationOther" value="${caseDto.generalCondition.occupationOther}"
                                       reg='{"maxlength":"30"}' placeholder="若选择其他，请描叙" style="width: 200px;"/>
                            </span>
                </td>
            </tr>
            <tr>
                <th>5.文化程度：</th>
                <td colspan="3">
                    <ehr:dic-radio name="generalCondition.education" dicmeta="GBT46582006"
                                   code="IDM06,IDM09,IDM07,IDM02,IDM03,IDM15,IDM08,IDM10" value="${caseDto.generalCondition.education}"/>
                </td>
            </tr>
            <tr>
                <th>6．常住类型：</th>
                <td>
                    <ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005"
                                   value="${caseDto.generalCondition.floatPopulation}" onchange="caseEdit.toggerAddress()"/>
                </td>
            </tr>
            <tr>
                <th>7．现住址：</th>
                <td colspan="3">
                    <ehr:dic-town-street-village streetId="pastreet_address" townId="patown_address" streetName="generalCondition.pastreet" townName="generalCondition.patownShip"
                                                 streetValue="${caseDto.generalCondition.pastreet}" townValue="${caseDto.generalCondition.patownShip}" width="140px;"
                                                 villageId="pavillage_address" villageName="generalCondition.paGroup" villageValue="${caseDto.generalCondition.paGroup}"/>
                    <input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${caseDto.generalCondition.pahouseNumber}"
                           reg='{"maxlength":"50"}'  style="width: 180px;">
                    <span id="spanPaNumber">(门牌号)</span>
                </td>
            </tr>
            <tr>
                <th>8.户籍地址：</th>
                <td colspan="3">
                    <input type="text" id=hrAddress" name="generalCondition.hrAddress" value="${caseDto.generalCondition.hrAddress}"
                           reg='{"maxlength":"100"}'  style="width: 180px;">
                </td>
            </tr>
            <tr>
                <th>9.工作学习单位：</th>
                <td colspan="3">
                    <input type="text" id="unitName" name="generalCondition.unitName" value="${caseDto.generalCondition.unitName}"
                           reg='{"maxlength":"50"}'  style="width: 180px;">

                </td>
            </tr>
            <tr>
                <th>10.联系人：</th>
                <td colspan="3">

                    <input type="text" id="contactName" name="generalCondition.contactName" value="${caseDto.generalCondition.contactName}"
                           reg='{"maxlength":"20"}'  style="width: 180px;">

                    联系电话（办公室）：<input type="text" name="generalCondition.mobile" value="${caseDto.generalCondition.mobile}"
                                     reg='{"regex":"phone"}' style="width: 100px;"/>

                </td>
            </tr>
           <%-- <tr>
                <th><label class="required">5．是否孕妇</label>：</th>
                <td><ehr:dic-radio name="generalCondition.gravidaFlag" dicmeta="PH00001" code="1,2" value="${caseDto.generalCondition.gravidaFlag}"
                                   reg='{"required":"true"}'/></td>
            </tr>--%>

        </table>
    </fieldset>
    <fieldset>
        <legend>二、 发病情况</legend>
        <table class="posttable">
            <colgroup>
                <col style="width: 20%"/>
                <col style="width: 30%"/>
                <col style="width: 20%"/>
                <col style="width: 30%"/>
            </colgroup>
            <tr>
                <th>1．发病日期：</th>
                <td><tag:dateInput id="pathogenesisDateId" name="attackCondition.pathogenesisDate" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.pathogenesisDate}"
                                   onlypast="true" style="width:100px;"/></td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <th>2．发病地点：</th>
                <td>
                	<input reg='{"maxlength":"100"}' type="text" name="attackCondition.pathogenesisPlace" value="${caseDto.attackCondition.pathogenesisPlace}"/>
                
                  <%--   <ehr:dic-town-village villageName="attackCondition.invasionPacounty" townName="attackCondition.invasionPacity"
                                          villageValue="${caseDto.attackCondition.invasionPacounty}" townValue="${caseDto.attackCondition.invasionPacity}" width="180px;"/>
                    <input type="text" name="attackCondition.pathogenesisPlace" reg='{"maxlength":"100"}'
                           value="${caseDto.attackCondition.pathogenesisPlace}" style="width: 180px;">--%>
                </td>
                <th></th>
                <td></td>
            </tr>
            <tr>
                <th>3．初诊日期：</th>
                <td colspan="3">
                    <tag:dateInput id="firstVisitDateId" name="attackCondition.firstVisitDate" pattern="yyyy/MM/dd" onlypast="true"
                                   date="${caseDto.attackCondition.firstVisitDate}" style="width:100px;"
                                   reg='{"compare":["confirmationDateId","le","初诊日期不能晚于确诊日期"]}'/>
                    &nbsp;&nbsp;&nbsp;确诊日期
                    <tag:dateInput id="confirmationDateId" name="attackCondition.confirmationDate" pattern="yyyy/MM/dd" onlypast="true"
                                   date="${caseDto.attackCondition.confirmationDate}" style="width:100px;"
                                   reg='{"compare":["firstVisitDateId","ge","确诊日期不能早于初诊日期"]}'/>
                </td>
            </tr>
            <tr>
                <th>4．诊断医院：</th>
                <td><input type="text" name="attackCondition.confirmationHospital" value="${caseDto.attackCondition.confirmationHospital}" reg='{"maxlength":"100"}'/></td>
            </tr>
            <tr>
                <th>5．住院日期：</th>
                <td colspan="3">
                    <tag:dateInput id="inhosDateId" name="attackCondition.inhosDate" pattern="yyyy/MM/dd" style="width: 100px;"
                                   onlypast="true" date="${caseDto.attackCondition.inhosDate}"
                                   reg='{"compare":["outHospitalDateId","le","住院日期不能晚于出院日期"]}'/>
                    &nbsp;&nbsp;&nbsp;出院日期
                    <tag:dateInput id="outHospitalDateId" name="attackCondition.outHospitalDate" style="width: 100px;"
                                   pattern="yyyy/MM/dd" date="${caseDto.attackCondition.outHospitalDate}"
                                   reg='{"compare":["inhosDateId","ge","出院日期不能早于住院日期"]}'/>
                </td>
            </tr>
            <tr>
                <th>6．转归情况：</th>
                <td>
                    <ehr:dic-radio name="otherCondition.outcomeCode" dicmeta="IDM00005" code="4,1,99" value="${caseDto.otherCondition.outcomeCode}"/>
                </td>
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <legend>三、 临床资料</legend>
        <table class="posttable">
            <colgroup>
                <col style="width: 20%"/>
                <col style="width: 25%"/>
                <col style="width: 20%"/>
                <col style="width: 35%"/>
            </colgroup>
            <tr>
                <th>1．发热持续：</th>
                <td colspan="3">
                    <input type="text" name="clinicalManifestations.heatingDuration" value="${caseDto.clinicalManifestations.heatingDuration}"
                           reg='{"maxlength":"20"}' style="width: 80px;text-align: center"/> 天
                    &nbsp;&nbsp;&nbsp;最高体温
                    <input type="text" name="clinicalManifestations.highestTemperature" value="${caseDto.clinicalManifestations.highestTemperature}"
                           reg='{"maxlength":"20"}' style="width: 80px;text-align: center"/>℃
                </td>
            </tr>
            <tr>
                <th>2．有无如下症状：</th>
                <td></td>
            </tr>
            <tr>
                <th>发热：</th>
                <td>
                    <ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.fever" code="1,2" value="${caseDto.clinicalManifestations.fever}"/>
                <th>畏寒：</th>
                <td>
                    <ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.chills" code="1,2" value="${caseDto.clinicalManifestations.chills}"/>
                </td>
            </tr>
            <tr>
                <th>乏力：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.feeble" code="1,2" value="${caseDto.clinicalManifestations.feeble}"/></td>
                <th>咳嗽：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.cough" code="1,2" value="${caseDto.clinicalManifestations.cough}"/></td>
            </tr>

            <tr>
                <th>头痛：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.headache" code="1,2" value="${caseDto.clinicalManifestations.headache}"/></td>
                <th>腰背酸痛：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.backPain" code="1,2" value="${caseDto.clinicalManifestations.backPain}"/></td>
            </tr>
            <tr>
                <th>四肢酸痛：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.limbAche" code="1,2" value="${caseDto.clinicalManifestations.limbAche}"/></td>
                <th>咽痛：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.soreThroat" code="1,2" value="${caseDto.clinicalManifestations.soreThroat}"/></td>
            </tr>
            </tr>
            <tr>
                <th>鼻塞：</th>
                <td>
                    <ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.nasalObstruction" code="1,2" value="${caseDto.clinicalManifestations.nasalObstruction}"/>
                </td>
                <th>流鼻涕：</th>
                <td>
                    <ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.runningNose" code="1,2" value="${caseDto.clinicalManifestations.runningNose}"/>
                </td>
            </tr>
            <tr>
                <th>打喷嚏：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.sneeze" code="1,2" value="${caseDto.clinicalManifestations.sneeze}"/></td>
                <th>恶心：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.nausea" code="1,2" value="${caseDto.clinicalManifestations.nausea}"/></td>
            </tr>
            <tr>
                <th>呕吐：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.vomit" code="1,2" value="${caseDto.clinicalManifestations.vomit}"/></td>
                <%--<th>腹痛：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.stomachache" code="1,2" value="${caseDto.clinicalManifestations.stomachache}"/></td>--%>
            </tr>
            <tr>
                <th>腹泻：</th>
                <td colspan="3">
                    <ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.diarrhea" code="1,2" value="${caseDto.clinicalManifestations.diarrhea}"
                            onchange="toggleOther('clinicalManifestations.diarrhea','diarrheaDailyTimes',1);"/>
                    <span id="diarrheaDailyTimes" style="display: none">
                          &nbsp;&nbsp;&nbsp;如有腹泻，每日大便
                        <input type="text" name="clinicalManifestations.diarrheaDailyTimes" value="${caseDto.clinicalManifestations.diarrheaDailyTimes}"
                               style="width: 80px;text-align: center" reg='{"maxlength":"20"}'/>次
                    </span>

                </td>
            </tr>
            <tr>
                <th>3．有无以下并发症：</th>
                <td></td>
            <tr>
                <th>肺炎：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.isSymptoms"  code="1,2"
                                   value="${caseDto.clinicalManifestations.isSymptoms}"/></td>
                <th>哮喘：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.asthma"  code="1,2"
                                   value="${caseDto.clinicalManifestations.asthma}"/></td>
            </tr>
            <tr>
                <th>血小板减少性紫癜：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.thromVioletInsane"  code="1,2"
                                   value="${caseDto.clinicalManifestations.thromVioletInsane}"/></td>
                <%--<th>Reye’s综合征：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.reyeSyndrome"  code="1,2"
                                   value="${caseDto.clinicalManifestations.reyeSyndrome}"/></td>--%>
            </tr>
            <tr>
                <th>流产：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.abortion"  code="1,2"
                                   value="${caseDto.clinicalManifestations.abortion}"/></td>
                <th>死胎：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.stillbirth" code="1,2"
                                   value="${caseDto.clinicalManifestations.stillbirth}"/></td>
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <legend>四、流感疫苗接种史</legend>
        <table class="posttable">
            <colgroup>
                <col style="width: 20%"/>
                <col style="width: 30%"/>
                <col style="width: 20%"/>
                <col style="width: 30%"/>
            </colgroup>
            <tr>
                <th> 1．有无接种：</th>
                <td><ehr:dic-radio dicmeta="PH00002" name="epidemiologicalSurvey.influenzaVaccinations" code="1,2"
                        value="${caseDto.epidemiologicalSurvey.influenzaVaccinations}"
                        onchange="toggleOther('epidemiologicalSurvey.influenzaVaccinations','accinationsPart',1);"/>
                </td>
                <td></td>
                <td></td>
            </tr>
            <tbody id="accinationsPart">
                <tr>
                    <th>2．最后一次接种日期：</th>
                    <td><tag:dateInput name="epidemiologicalSurvey.fluLastInoculateDt" pattern="yyyy/MM/dd" onlypast="true"
                                       date="${caseDto.epidemiologicalSurvey.fluLastInoculateDt}" style="width:100px;"/></td>
                </tr>
               <%-- <tr>
                    <th> 3．疫苗商品名：</th>
                    <td colspan="3">
                        <input type="text" name="epidemiologicalSurvey.tivProductName" value="${caseDto.epidemiologicalSurvey.tivProductName}"
                               style="width: 180px;" reg='{"maxlength":"100"}'/>
                        &nbsp;&nbsp;&nbsp;厂家
                        <input type="text" name="epidemiologicalSurvey.tivManufacturers" value="${caseDto.epidemiologicalSurvey.tivManufacturers}"
                               style="width: 300px;" reg='{"maxlength":"100"}'/>
                    </td>
                </tr>
                <tr>
                    <th>4．接种方式及部位：</th>
                    <td colspan="2">
                        <input type="text" name="epidemiologicalSurvey.tivWayPart" value="${caseDto.epidemiologicalSurvey.tivWayPart}" reg='{"maxlength":"100"}'/>
                    </td>
                </tr>
                <tr>
                    <th>5．接种地点：</th>
                    <td colspan="2">
                        <input type="text" name="epidemiologicalSurvey.tivAddr" value="${caseDto.epidemiologicalSurvey.tivAddr}" reg='{"maxlength":"100"}'/>
                    </td>
                </tr>--%>
            </tbody>
        </table>
    </fieldset>
   <%-- <fieldset>
        <legend>五、实验室检测资料</legend>
        <table class="posttable">
            <colgroup>
                <col style="width: 20%"/>
                <col style="width: 30%"/>
                <col style="width: 20%"/>
                <col style="width: 30%"/>
            </colgroup>
            <tr>
                <th>1．病毒分离方法：</th>
                <td colspan="3">
                    <ehr:dic-radio dicmeta="IDM00101" name="labExamine.viralIsolation" value="${caseDto.labExamine.viralIsolation}"/>
                    <br>鉴定
                    <ehr:dic-radio name="labExamine.identificationVirus" dicmeta="IDM00102" value="${caseDto.labExamine.identificationVirus}"/>
                    &nbsp;&nbsp;&nbsp;&nbsp;鉴定时间
                    <tag:dateInput name="labExamine.identificationDate" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.labExamine.identificationDate}"
                                   style="width:100px;"/>
                </td>
            </tr>
            <tr>
                <th>2．双份血清诊断型别为：</th>
                <td colspan="3">
                    <ehr:dic-radio name="labExamine.pairedSeraType" dicmeta="IDM00102" value="${caseDto.labExamine.pairedSeraType}"/>
                    &nbsp;&nbsp;&nbsp;&nbsp;诊断时间
                    <tag:dateInput name="labExamine.pairedSeraDate" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.labExamine.pairedSeraDate}"
                                   style="width:100px;"/>
                    <br>测定抗体所用抗原
                    <input type="text" name="labExamine.antibodyAssayAntigen" value="${caseDto.labExamine.antibodyAssayAntigen}"
                            style="width: 300px;" reg='{"maxlength":"100"}'/>
                </td>
            </tr>
            <tr>
                <th>3．其他诊断方法和结果：</th>
                <td colspan="3">
                    <input type="text" name="labExamine.otherDiagnosed" value="${caseDto.labExamine.otherDiagnosed}" style="width: 300px;" reg='{"maxlength":"100"}'/>
                    &nbsp;&nbsp;&nbsp;&nbsp;诊断时间
                    <tag:dateInput name="labExamine.otherDiagnosedDate" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.labExamine.otherDiagnosedDate}"
                            style="width:100px;"/>
                </td>
            </tr>
        </table>
    </fieldset>--%>
    <fieldset>
        <legend>五、流行病学调查</legend>
        <table class="posttable">
            <colgroup>
                <col style="width: 20%"/>
                <col style="width: 30%"/>
                <col style="width: 20%"/>
                <col style="width: 30%"/>
            </colgroup>
            <tr>
                <th>1．传染源调查：</th>
            </tr>
            <tr>
                <th><label class="required">病前7日内接触流感样病人</label>：</th>
                <td colspan="3">
                    <ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.outHistory" code="1,2" value="${caseDto.infectionSourceRoute.outHistory}"
                        onchange="toggleOther('infectionSourceRoute.outHistory','outContactLevel',1);" reg='{"required":"true"}'/>
                    <span id="outContactLevel" style="display: none">
                        &nbsp;&nbsp;&nbsp;&nbsp;接触方式  
                        <ehr:dic-radio dicmeta="IDM00546" name="infectionSourceRoute.outContactLevel" value="${caseDto.infectionSourceRoute.outContactLevel}"/>
                    </span>

                </td>
            </tr>
            <tr>
                <th><label class="required">病前七日内禽、畜接触史</label>：</th>
                <td colspan="3">
                    <ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.livestockContactHistory" value="${caseDto.infectionSourceRoute.livestockContactHistory}"
                                   code="1,2" onchange="toggleOther('infectionSourceRoute.livestockContactHistory','livestockContactPart',1);" reg='{"required":"true"}'/>
                    <span id="livestockContactPart">
                        <br>接触地点
                        <input type="text" name="infectionSourceRoute.livestockContactAddr" value="${caseDto.infectionSourceRoute.livestockContactAddr}"
                                style="width: 200px;" reg='{"maxlength":"100"}'/>
                        <br>接触动物名称
                        <input type="text" name="infectionSourceRoute.livestockContactAnimal" value="${caseDto.infectionSourceRoute.livestockContactAnimal}"
                               style="width: 200px;" reg='{"maxlength":"100"}'/>
                        <br>接触方式
                        	<ehr:dic-radio dicmeta="IDM00547" name="infectionSourceRoute.livestockContactWay" value="${caseDto.infectionSourceRoute.livestockContactWay}"/>
                        
                        <%--<br>接触频率
                        <ehr:dic-radio dicmeta="IDM00035" name="infectionSourceRoute.livestockContactRate" code="1,2,4"
                                       value="${caseDto.infectionSourceRoute.livestockContactRate}"/>--%>
                        <br>动物健康状况
                        <ehr:dic-radio dicmeta="IDM00103" name="infectionSourceRoute.livestockHealthCondition"
                                       value="${caseDto.infectionSourceRoute.livestockHealthCondition}"/>
                    </span>
                </td>
            </tr>
            <tr>
                <th>2． 疫点环境卫生状况：</th>
            </tr>
            <tr>
                <th><label class="required">住宅情况</label>：</th>
                <td colspan="3">
                    <ehr:dic-radio name="hygienicCondition.resStatus" dicmeta="IDM00104" value="${caseDto.hygienicCondition.resStatus}" reg='{"required":"true"}' code="1,3,4"/>
                    </td>
                </tr>
            <tr>
                <th></th>
                <td colspan="3">家庭人均居住面积
                    <input type="text" name="hygienicCondition.perLivingArea" value="${caseDto.hygienicCondition.perLivingArea}"
                            style="width: 80px;text-align: center" reg='{"maxlength":"20", "scale":"1"}'/>平方米
                    <br>开窗通风
                    <ehr:dic-radio dicmeta="IDM00105" name="hygienicCondition.ventilation" value="${caseDto.hygienicCondition.ventilation}"/>
                    <%-- <br>如使用空调
                    <input type="text" name="hygienicCondition.conditionHours" value="${caseDto.hygienicCondition.conditionHours}"
                           style="width: 80px;text-align: center" reg='{"maxlength":"20", "scale":"1"}'/>小时/天 --%>
                </td>
            </tr>
           <%-- <tr>
                <th><label class="required">住宅周围卫生</label>：</th>
                <td colspan="3"><ehr:dic-radio dicmeta="PH00016" name="hygienicCondition.aroundResHealth" code="1,3,4"
                                   value="${caseDto.hygienicCondition.aroundResHealth}" reg='{"required":"true"}'/>
                    <br>农贸市场
                    <ehr:dic-radio dicmeta="PH00002" name="hygienicCondition.farmerMarket" code="1,2" value="${caseDto.hygienicCondition.farmerMarket}"/>
                    <br>禽、畜养殖场所
                    <ehr:dic-radio dicmeta="PH00002" name="hygienicCondition.livBreFarms"  code="1,2"
                                   value="${caseDto.hygienicCondition.livBreFarms}" onchange="toggleOther('hygienicCondition.livBreFarms','species',1);"/>
                    <span id="species" style="display: none">
                        &nbsp;&nbsp;&nbsp;&nbsp;动物品种
                        <input type="text" name="hygienicCondition.species" value="${caseDto.hygienicCondition.species}" style="width: 150px;" reg='{"maxlength":"100"}'/>
                    </span>
                </td>
            </tr>
            <tr>
                <th>3． 传播途径调查：</th>
                <td colspan="3">
                    <br>与病人同处一室
                    <ehr:dic-radio dicmeta="PH00001" name="infectionSourceRoute.liveTogether" code="1,2"
                                   value="${caseDto.infectionSourceRoute.liveTogether}"/>
                    <br>与病人有较近的接触
                    <ehr:dic-radio dicmeta="PH00001" name="infectionSourceRoute.closerContact" code="1,2"
                                   value="${caseDto.infectionSourceRoute.closerContact}"/>
                    <br>与病人共用食具、茶具、毛巾、玩具等
                    <ehr:dic-radio dicmeta="PH00001" name="infectionSourceRoute.shareUtensils" code="1,2"
                                   value="${caseDto.infectionSourceRoute.shareUtensils}"/>
                    <br>接触动物分泌物、排泄物、羽毛等
                    <ehr:dic-radio dicmeta="PH00001" name="infectionSourceRoute.dischargeExcrement" code="1,2"
                                   value="${caseDto.infectionSourceRoute.dischargeExcrement}"/>
                </td>
            </tr>--%>
        </table>
    </fieldset>
   <%-- <fieldset>
        <legend>七、调查者意见</legend>
        <table class="posttable">
            <colgroup>
                <col style="width: 20%"/>
                <col style="width: 80%"/>
                &lt;%&ndash;<col style="width: 20%"/>&ndash;%&gt;
                &lt;%&ndash;<col style="width: 30%"/>&ndash;%&gt;
            </colgroup>
            <tr>
                <th>可能传染源：</th>
                <td><input type="text" name="infectionSourceRoute.propagatingSource" value="${caseDto.infectionSourceRoute.propagatingSource}" reg='{"maxlength":"100"}'/></td>
            </tr>
            <tr>
                <th>可能传播途径：</th>
                <td><input type="text" name="infectionSourceRoute.transmissionRouteDetail" value="${caseDto.infectionSourceRoute.transmissionRouteDetail}" reg='{"maxlength":"100"}'/></td>
            </tr>
        </table>
    </fieldset>--%>
    <fieldset>
    <legend>六、小结</legend>
    <table class="posttable">
        <tr>
            <td>
                <textarea rows="7" cols="128" name="otherCondition.surveySummary" style="width: 100%" reg='{"maxlength":"1000"}'>
                ${caseDto.otherCondition.surveySummary}</textarea>
            </td>
        </tr>
        </table>
    </fieldset>

    <fieldset>
        <table class="posttable">
            <colgroup>
                <col style="width: 20%"/>
                <col style="width: 30%"/>
                <col style="width: 20%"/>
                <col style="width: 30%"/>
            </colgroup>
            <tr>
                <th> 调查单位：</th>
                <td><ehr:org code="${caseDto.caseInformation.modifySurveyOrg}"/></td>
            </tr>
            <tr>
                <th>调查者：</th>
                <td><ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/></td>
                <th>调查时间：</th>
                <td><tag:dateInput name="caseInformation.modifySurveyDate"
                                   pattern="yyyy/MM/dd" nullToToday="true" onlypast="true" date="${caseDto.caseInformation.modifySurveyDate}"/></td>
            </tr>
            <tr style="display:none;">
	             <td>
	             	<input type="hidden" name="caseInformation.caseFillOrg" value="${caseDto.caseInformation.caseFillOrg}"/>
	             	<input type="hidden" name="caseInformation.modifySurveyOrg" value="${caseDto.caseInformation.modifySurveyOrg}"/>
	             	<input type="hidden" name="caseInformation.modifyRespondents" value="${caseDto.caseInformation.modifyRespondents}"/>
	             	<input type="hidden" name="caseInformation.auditor" value="${caseDto.caseInformation.auditor}"/>
	             </td> 
	         </tr>
        </table>
    </fieldset>
    </div>
    </div>
</form>

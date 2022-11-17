<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/brucellosis.js" type="text/javascript"></script>

<c:if test="${isPrint != 1}">
    <jsp:include page="caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
	<input type="hidden" id="idmId" name="idmId" value="${idmId}"/>
    <div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
        <i class="popno">
            布鲁氏菌病个案调查表<br/>
            <span>（乙类传染病）</span>
        </i>
        <table class="posttable">
            <tr style="text-align: left;">
                <td>
                   	 国际标码：<input type="text" name="generalCondition.gbcode" value="${caseDto.generalCondition.gbcode}" style="width:120px;"
                           reg='{"maxlength":"14"}'/>
                </td>
		        <td>
		        	病例编码：<input type="text" name="caseInformation.mediRecordNum" reg='{"maxlength":"14"}'
		        	value="${caseDto.caseInformation.mediRecordNum}" style="width: 120px;"/>
		        </td>
		    </tr>
		</table>
        <div class="postdiv">
            <fieldset>
                <legend>1.基本情况</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 140px; width: 25%"/>
                        <col style="min-width: 220px; width: 15%"/>
                        <col style="min-width: 150px; width: 25%"/>
                        <col style="min-width: 210px; width: 35%"/>
                    </colgroup>
                    <tr>
                        <th>1.1 患者姓名：</th>
                        <td>
                        	<input type="text" name="generalCondition.name" value="${caseDto.generalCondition.name}" 
                        	 reg='{"maxlength":"100"}'/>
                        </td>
                        <th>1.2 性别：</th>
                        <td>
			            	<ehr:dic-radio dicmeta="GBT226112003" name="generalCondition.gender" code="1,2" value="${caseDto.generalCondition.gender}"/>
			            </td>
                    </tr>
                    <tr>
                    <th>1.3 年龄：</th>
                    <td>
                        <input type="text" name="generalCondition.age" value="${caseDto.generalCondition.age}"
                               reg='{"maxlength":"6"}' cssClass="width30" />
                    </td>
                    <th>1.4 职业：</th>
                    <td>
                        <ehr:dic-list dicmeta="GBT6565" name="generalCondition.occupation" width="180px;" value="${caseDto.generalCondition.occupation}"
                                      code="CV020120211,CV020120210,CV020120212,CV020120213,CV020120203,CV020120208,CV020120202,CV020120214,CV020120216,CV020120225,7-63,7-77,1-75,CV020120299,CV020120217"
                                      onchange="toggleOtherSC('generalCondition.occupation','occupationPart','CV020120299');"/>
                        <span  id="occupationPart" style="display: none">
		                         <input type="text" name="generalCondition.occupationOther" value="${caseDto.generalCondition.occupationOther}"
                                        reg='{"maxlength":"30"}' placeholder="若选择其他，请描叙" style="width: 40%;"/>
		                     </span>
                    </td>
                </tr>
                    <tr>
                        <th>1.5 民族：</th>
                        <td>
                            <ehr:dic-list dicmeta="GBT3304" name="generalCondition.nation" value="${caseDto.generalCondition.nation}"/>

                        </td>
                    </tr>
                    <%--<tr>
                    	<th>常住类型：</th>
                    	<td>
		            		<ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005"
                        		value="${caseDto.generalCondition.floatPopulation}" onchange="caseEdit.toggerAddress()"/>
                    	</td>
                    </tr>
                    <tr>
                        <th>3.家庭住址：</th>
                         <td colspan="3">
                            <ehr:dic-town-village villageId="pavillage_address" townId="patown_address" villageName="generalCondition.pastreet" townName="generalCondition.patownShip"
                                                  villageValue="${caseDto.generalCondition.pastreet}" townValue="${caseDto.generalCondition.patownShip}" width="180px;"/>
                            <input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${caseDto.generalCondition.pahouseNumber}"
                                   reg='{"maxlength":"50"}'  style="width: 180px;">
                        	<span id="spanPaNumber">(门牌号)</span>
                        </td>
                    </tr>--%>
                    <tr>
                        <th>1.6 发病地点：</th>
                        <td colspan="2"><input type="text" name="attackCondition.pathogenesisPlace" value="${caseDto.attackCondition.pathogenesisPlace}"
                                               reg='{"maxlength":"100"}'/></td>
                    </tr>
                    <tr>
                        <th>1.7 发病日期：</th>
                       <td>
					    	<tag:dateInput id="pathogenesisDate" nullToToday="true" name="attackCondition.pathogenesisDate" onlypast="true" pattern="yyyy/MM/dd" 
					    	 reg='{"compare":["firstVisitDate","le","发病日期不能大于首诊日期"]}' date="${caseDto.attackCondition.pathogenesisDate}"/>
					    </td>
                        <%--<th>1.7 就诊（住院）医院名称：</th>
                        <td>
                        	<input type="text" name="attackCondition.admissionHospital" value="${caseDto.attackCondition.admissionHospital}" reg='{"maxlength":"100"}'/>
                        </td>--%>
                    </tr>
                    <tr>
                        <th><label class="required">1.8 住院日期</label>：</th>
                        <td><tag:dateInput id="inhosDateId" name="attackCondition.inhosDate" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.attackCondition.inhosDate}"
                                           reg='{"required":"true","compare":["outHospitalDateId","le","住院日期不能晚于出院日期"]}'/></td>
                    </tr>
                    <tr>
                        <th><label class="required">1.9 报告日期</label>：</th>
                        <td><tag:dateInput name="attackCondition.clinicDate" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.attackCondition.clinicDate}"
                                           reg='{"required":"true"}'/></td>
                        <th>1.10 就诊（住院）医院名称：</th>
                        <td>
                            <input type="text" name="attackCondition.admissionHospital" value="${caseDto.attackCondition.admissionHospital}" reg='{"maxlength":"100"}'/>
                        </td>
                    </tr>
                </table>
            </fieldset>
            <fieldset>
                <legend>2.1临床表现</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 140px; width: 25%"/>
                        <col style="min-width: 220px; width: 15%"/>
                        <col style="min-width: 150px; width: 25%"/>
                        <col style="min-width: 210px; width: 35%"/>
                    </colgroup>
                    <tr>
                        <th>2.1.1发热：</th>
                        <td>
                        	<ehr:dic-radio dicmeta="PH00001" name="clinicalManifestations.fever" code="1,2"
                        	 value="${caseDto.clinicalManifestations.fever}"
                                    onchange="toggleOther('clinicalManifestations.fever','feverFromAdd',1)"/>
                        </td>
                    </tr>
                    <tr style="display: none;" id="feverFromAdd">
                        <td colspan="4" style="padding: 0px;">
                            <table>
                                <colgroup>
                                   <col style="min-width: 140px; width: 25%"/>
                                    <col style="min-width: 220px; width: 15%"/>
                                    <col style="min-width: 150px; width: 25%"/>
                                    <col style="min-width: 210px; width: 35%"/>
                                </colgroup>
                                <tr>
                                    <th>发热持续：</th>
                                    <td>
                                        <input type="text" name="clinicalManifestations.heatingDuration"
                                               name="clinicalManifestations.heatingDuration"
                                               value="${caseDto.clinicalManifestations.heatingDuration}"
                                               cssClass="width30" reg='{"maxlength":"20"}' style="width: 100px;"/>天
                                    </td>
                                    <th>体温最高：</th>
                                    <td>
                                        <input type="text" name="clinicalManifestations.temperature"
                                               value="${caseDto.clinicalManifestations.temperature}"
                                               reg='{"maxlength":"20"}' style="width: 100px;"/>℃
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <th>2.1.2 多汗：</th>
                        <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.hidrosis" code="1,2" value="${caseDto.clinicalManifestations.hidrosis}"/></td>
                    </tr>
                    <tr>
                        <th>2.1.3 肌肉、关节酸痛：</th>
                        <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.limbAche" code="1,2" value="${caseDto.clinicalManifestations.limbAche}"/></td>
                        <th>2.1.4 乏力：</th>
                        <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.feeble" code="1,2" value="${caseDto.clinicalManifestations.feeble}"/></td>
                    </tr>
                    <tr>
                        <th>2.1.5 肝肿大：</th>
                        <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.hepatomegaly" code="1,2" value="${caseDto.clinicalManifestations.hepatomegaly}"/></td>
                        <th>2.1.6 脾肿大：</th>
                        <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.splenomegaly" code="1,2" value="${caseDto.clinicalManifestations.splenomegaly}"/></td>
                    </tr>
                    <tr>
                        <th>2.1.7淋巴结肿大：</th>
                        <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.lymphadenectasis" code="1,2" value="${caseDto.clinicalManifestations.lymphadenectasis}"/></td>
                        <th>2.1.8睾丸肿大：</th>
                        <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.testicularSwelling" code="1,2" value="${caseDto.clinicalManifestations.testicularSwelling}"/></td>
                    </tr>
                </table>
            </fieldset>
            <fieldset>
                <legend>2.2实验室检查</legend>
                <table class="posttable">
                   <colgroup>
                        <col style="min-width: 140px; width: 25%"/>
                        <col style="min-width: 220px; width: 15%"/>
                        <col style="min-width: 150px; width: 25%"/>
                        <col style="min-width: 210px; width: 35%"/>
                    </colgroup>
                    <tr>
                        <th>玻片凝集反应：</th>
                        <td><ehr:dic-radio dicmeta="PH00005" name="labExamine.slideAgglutunation" value="${caseDto.labExamine.slideAgglutunation}"/></td>
                        <th>虎红平板凝集反应：</th>
                        <td><ehr:dic-radio dicmeta="PH00005" name="labExamine.rbpt" value="${caseDto.labExamine.rbpt}"/></td>
                    </tr>
                    <tr>
                        <th>皮肤过敏实验：</th>
                        <td><ehr:dic-radio dicmeta="PH00002" name="labExamine.skinSensibility" code="1,2" value="${caseDto.labExamine.skinSensibility}"/></td>
                        <th>病原分离：</th>
                    <td><ehr:dic-radio dicmeta="IDM00575" name="labExamine.pathogenIsolation" value="${caseDto.labExamine.pathogenIsolation}"/></td>
                    </tr>
                    <tr>
                        <th>SAT滴度为1:100(+ +)：</th>
                        <td>
                            <ehr:dic-radio dicmeta="PH00002" name="labExamine.titerSat" code="1,2" value="${caseDto.labExamine.titerSat}"/></td>
                        <th>补体结合实验1:100(+ +)：</th>
                        <td><ehr:dic-radio dicmeta="PH00002" name="labExamine.fixation" code="1,2" value="${caseDto.labExamine.fixation}"/></td>
                    </tr>
                    <tr>
                        <th>Combs实验滴度为1:400(+ +)：</th>
                        <td>
                            <ehr:dic-radio dicmeta="PH00002" name="labExamine.combs" code="1,2" value="${caseDto.labExamine.combs}"/></td>
                        <th>临床诊断：</th>
                        <td>
                            <input type="text" name="labExamine.bClinical"
                                   value="${caseDto.labExamine.bClinical}" reg='{"maxlength":"100"}'/>
                        </td>
                    </tr>
                </table>
            </fieldset>
            <fieldset>
                <legend>2.3治疗</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 140px; width: 25%"/>
                        <col style="min-width: 220px; width: 15%"/>
                        <col style="min-width: 150px; width: 25%"/>
                        <col style="min-width: 210px; width: 35%"/>
                    </colgroup>
                    <tr>
                        <th>抗生素治疗：</th>
                        <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.antibiobicTreat" code="1,2" value="${caseDto.clinicalManifestations.antibiobicTreat}"/></td>
                        <th>抗原治疗：</th>
                        <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.antigenTreat" code="1,2" value="${caseDto.clinicalManifestations.antigenTreat}"/></td>
                    </tr>
                    <tr>
                        <th>水解素治疗：</th>
                        <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.hydrolysisTreat" code="1,2" value="${caseDto.clinicalManifestations.hydrolysisTreat}"/></td>
                        <th>溶菌素治疗：</th>
                        <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.bacteriolysinTreat" code="1,2" value="${caseDto.clinicalManifestations.bacteriolysinTreat}"/></td>
                    </tr>
                    <tr>
                        <th>转归：</th>
                        <td colspan="3"><ehr:dic-radio name="otherCondition.outcomeCode" dicmeta="IDM00005" code="1,2,3,4" value="${caseDto.otherCondition.outcomeCode}"
                                                       onchange="toggleOther('otherCondition.outcomeCode','deatha',4);"/>
                            <span id="deatha">
                                <tag:dateInput name="otherCondition.deathTime" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.otherCondition.deathTime}"
                                               reg='{"required":"true"}' style="width:180px;"/>死于
                                <input type="text" name="otherCondition.deathPlace"
                                                                                   value="${caseDto.otherCondition.deathPlace}" reg='{"maxlength":"100"}' style="width:180px;"/>
                            </span>
                        </td>
                    </tr>

                </table>
            </fieldset>
            <fieldset>
                <legend>3.1 与动物接触史</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 140px; width: 25%"/>
                        <col style="min-width: 220px; width: 15%"/>
                        <col style="min-width: 150px; width: 25%"/>
                        <col style="min-width: 210px; width: 35%"/>
                    </colgroup>
                    <tr>
                        <th>畜别：</th>
                        <td>
                            <input type="text" name="infectionSourceRoute.animalsKind" value="${caseDto.infectionSourceRoute.animalsKind}" reg="{'maxlength':'100'}"/>
                        </td>
                        <th>饲养放牧：</th>
                        <td><ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.isFeed" code="1,2" value="${caseDto.infectionSourceRoute.isFeed}"/></td>
                    </tr>
                    <tr>
                        <th>屠宰：</th>
                        <td><ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.animalsKill" code="1,2" value="${caseDto.infectionSourceRoute.animalsKill}"/></td>
                        <th>配种员：</th>
                        <td><ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.animalsPz" code="1,2" value="${caseDto.infectionSourceRoute.animalsPz}"/></td>
                    </tr>
                    <tr>
                        <th>兽医：</th>
                        <td><ehr:dic-radio dicmeta="PH00002" name="infectionSourceRoute.animalsDoc" code="1,2" value="${caseDto.infectionSourceRoute.animalsDoc}"/></td>
                        <th>其他：</th>
                        <td>
                            <input type="text" name="infectionSourceRoute.bbOther" value="${caseDto.infectionSourceRoute.bbOther}" reg="{'maxlength':'100'}"/>
                        </td>
                    </tr>

                </table>
            </fieldset>
            <fieldset>
                <legend>3.2 保护情况</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 140px; width: 25%"/>
                        <col style="min-width: 220px; width: 15%"/>
                        <col style="min-width: 150px; width: 25%"/>
                        <col style="min-width: 210px; width: 35%"/>
                    </colgroup>
                    <tr>
                        <th>使用防护衣：</th>
                        <td><ehr:dic-radio dicmeta="PH00002" name="epidemiologicalSurvey.isCoat" code="1,2" value="${caseDto.epidemiologicalSurvey.isCoat}"/></td>
                        <th>使用消毒液：</th>
                        <td><ehr:dic-radio dicmeta="PH00002" name="epidemiologicalSurvey.isWater" code="1,2" value="${caseDto.epidemiologicalSurvey.isWater}"/></td>
                    </tr>
                    <tr>
                        <th>是否人畜共用一口井：</th>
                        <td><ehr:dic-radio dicmeta="PH00002" name="epidemiologicalSurvey.isTog" code="1,2" value="${caseDto.epidemiologicalSurvey.isTog}"/></td>
                        <th>幼羔放卧室内饲养：</th>
                        <td><ehr:dic-radio dicmeta="PH00002" name="epidemiologicalSurvey.isLive" code="1,2" value="${caseDto.epidemiologicalSurvey.isLive}"/></td>
                    </tr>
                    <tr>
                        <th>既往病史：</th>
                        <td><input type="text" name="pastHistory.previousOther" value="${caseDto.pastHistory.previousOther}" reg="{'maxlength':'100'}"/></td>
                    </tr>


                </table>
            </fieldset>
            <fieldset>
                <legend>3.3布氏疫苗接触史</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 140px; width: 25%"/>
                        <col style="min-width: 220px; width: 15%"/>
                        <col style="min-width: 150px; width: 25%"/>
                        <col style="min-width: 210px; width: 35%"/>
                    </colgroup>
                    <tr>
                        <th>疫苗接种时间：</th>
                        <td>
                            <tag:dateInput name="pastHistory.bbTime" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.pastHistory.bbTime}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>菌苗种类：</th>
                        <td><input type="text" name="pastHistory.bbKind" value="${caseDto.pastHistory.bbKind}" reg="{'maxlength':'100'}"/></td>
                    </tr>
                    <tr>
                        <th>接种途径：</th>
                        <td><input type="text" name="pastHistory.bbTreat" value="${caseDto.pastHistory.bbTreat}" reg="{'maxlength':'100'}"/></td>
                    </tr>
                    <tr>
                        <th>确诊时间：</th>
                        <td><tag:dateInput name="pastHistory.bbDate" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.pastHistory.bbDate}"/></td>
                    </tr>
                    <tr>
                        <th>可能的传染源、传播途径及传播因子：</th>
                        <td><input type="text" name="infectionSourceRoute.propagatingSource" value="${caseDto.infectionSourceRoute.propagatingSource}" reg="{'maxlength':'100'}"/></td>
                    </tr>
                    <tr>
                        <th>其他：</th>
                        <td><input type="text" name="pastHistory.bbOther" value="${caseDto.pastHistory.bbOther}" reg="{'maxlength':'100'}"/></td>
                    </tr>
                    <tr>
                        <th>其在本疫点病例发病时间顺序，第：</th>
                        <td><input type="text"  name="pastHistory.bbNum" value="${caseDto.pastHistory.bbNum}" reg="{'maxlength':'100'}"/>例</td>
                    </tr>
                </table>
            </fieldset>

            <fieldset>
                <legend>4.调查小结</legend>
                <table class="posttable">
                    <tr>
                        <td>
                            <textarea name="otherCondition.surveySummary" reg="{'maxlength':'800'}" style="width: 100%; height: 150px;">${caseDto.otherCondition.surveySummary}</textarea>
                         </td>
                    </tr>
                </table>
            </fieldset>
            <fieldset>
                <table class="posttable">
                   <colgroup>
			            <col style="width: 10%"/>
			            <col style="width: 23%"/>
			            <col style="width: 10%"/>
			            <col style="width: 13%"/>
			            <col style="width: 10%"/>
			            <col style="width: 14%"/>
			        </colgroup>
                    <tr>
                        <th>调查者单位：</th>
                        <td>
                        	<ehr:org code="${caseDto.caseInformation.modifySurveyOrg}"/>
                        	<input type="hidden" name="caseInformation.modifySurveyOrg" value="${caseDto.caseInformation.modifySurveyOrg}"/>
                        </td>
                        <th>调查者：</th>
                        <td><ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/>
                            <input type="hidden" name="caseInformation.modifyRespondents" value="${caseDto.caseInformation.modifyRespondents}"/>
                        </td>
                        <th>调查时间：</th>
                        <td>
                        <tag:dateInput nullToToday="true" name="caseInformation.modifySurveyDate" onlypast="true"
	                               pattern="yyyy/MM/dd" date="${caseDto.caseInformation.modifySurveyDate}"/>
	                    </td>
                    </tr>
                </table>
            </fieldset>
        </div>
       
    </div>
</form>

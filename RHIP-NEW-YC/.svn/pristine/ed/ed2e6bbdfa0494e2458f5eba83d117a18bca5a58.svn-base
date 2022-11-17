<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/hcv.js" type="text/javascript"></script>
<c:if test="${isPrint != 1}">
    <jsp:include page="caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
<input type="hidden" id="idmId" name="idmId" value="${idmId}"/>
<div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
    <i class="popno">丙肝个案调查表<br/><span>（乙类传染病）</span></i>
    <table class="posttable">
		<tr>
			<td style="width: 50%; text-align: left;">
				<span>国标码：</span>
				<input type="text" name="generalCondition.gbcode" value="${caseDto.generalCondition.gbcode}" reg='{"maxlength":"14"}' style="width: 160px;"/>
			</td>
			<td style="width: 50%; text-align: right;">
				<span>病例编码：</span>
				<input type="text" name="caseInformation.mediRecordNum" value="${caseDto.caseInformation.mediRecordNum}"  reg='{"maxlength":"14"}' style="width: 160px;"/>
			</td>
		</tr>
	</table>
    <div class="postdiv">
    <fieldset>
    <legend>1.患者情况</legend>
    <table class="posttable">
	    <colgroup>
	        <col style="width: 28%" />
	        <col style="width: 22%" />
	        <col style="width: 15%" />
	        <col style="width: 35%" />
	    </colgroup>
		<tr>
			<th>1.1患者姓名：</th>
			<td>
				<input type="text"  name="generalCondition.name" value="${caseDto.generalCondition.name}" reg='{"maxlength":"100"}' style="width: 150px;"/>
			</td>
            <td></td>
            <td></td>
		</tr>
        <tr>
            <th>1.2户主姓名：</th>
            <td>
                <input type="text" name="generalCondition.parentsName" value="${caseDto.generalCondition.parentsName}" reg='{"maxlength":"50"}' style="width: 150px;"/>
            </td>
        </tr>
        <tr>
            <th>1.3常住类型：</th>
            <td>
                <ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005"
                               value="${caseDto.generalCondition.floatPopulation}" onchange="caseEdit.toggerAddress()"/>
            </td>
        </tr>
		<tr>
			<th>1.4家庭住址：</th>
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
			<th>1.5患者性别：</th>
			<td>
				<ehr:dic-radio name="generalCondition.gender" value="${caseDto.generalCondition.gender}" dicmeta="GBT226112003" code="1,2"/>
			</td>
		</tr>
        <tr>
            <th>1.6患者年龄（岁）：</th>
            <td>
                <input type="text" name="generalCondition.age" value="${caseDto.generalCondition.age}" reg='{"maxlength":"6"}' style="width: 100px;" />
            </td>
        </tr>
		<tr>
			<th>1.7与户主关系：</th>
			<td colspan="3">
				<ehr:dic-list dicmeta="IDM00055" name="generalCondition.relation" 
					value="${caseDto.generalCondition.relation}" code="1,2,3,4,5,6,7,99"/>
			</td>
		</tr>
		<tr>
			<th>1.8患者职业：</th>
			<td colspan="3">
				<ehr:dic-list dicmeta="GBT6565" name="generalCondition.occupation" value="${caseDto.generalCondition.occupation}" 
					onchange="toggleOtherSC('generalCondition.occupation','spanOccupation','CV020120299')" code="CV020120214,CV020120209,CV020120211,CV020120203,CV020120204,CV020120218,CV020120208,CV020120219,CV020120299" />
				<span id="spanOccupation">
					<input type="text" id="occupationOther" name="generalCondition.occupationOther" value="${caseDto.generalCondition.occupationOther}" reg='{"maxlength":"100"}' style="width:140px;"/>
				</span> 
			</td>		
		</tr>
		<tr>
			<th>1.9患者文化程度：</th>
			<td colspan="3">
				<ehr:dic-radio dicmeta="GBT46582006" name="generalCondition.education" value="${caseDto.generalCondition.education}" code="IDM09,IDM07,IDM03,IDM04,IDM08"/>
			</td>
		</tr>
		<tr>
			<th>1.10婚姻状况：</th>
			<td colspan="3">
				<ehr:dic-radio dicmeta="GBT226122003" name="generalCondition.marriage" 
					onchange="toggleOther('generalCondition.marriage','divMarriage','20')" value="${caseDto.generalCondition.marriage}" code="20,10,30"/>
				<div id="divMarriage">结婚时间
					<tag:dateInput nullToToday="true" id="marriageDate" name="generalCondition.marriageDate" style="width: 100px;" pattern="yyyy/MM/dd"
                    	date="${caseDto.generalCondition.marriageDate}" onlypast="true"></tag:dateInput> 
				</div>
			</td>
		</tr>
		<tr>
			<th>1.11乙肝疫苗接种史：</th>
			<td colspan="3">
				<ehr:dic-radio dicmeta="PH00002" name="epidemiologicalSurvey.hepatitisBVaccine"  
					onchange="toggleOther('epidemiologicalSurvey.hepatitisBVaccine','trHepatitis','1')" value="${caseDto.epidemiologicalSurvey.hepatitisBVaccine}" code="1,2,4"/>
			</td>
		</tr>
		<tr id="trHepatitis">
			<th>1.12乙肝疫苗接种时间：</th>
			<td colspan="3">
				<div>第一针 
					<tag:dateInput id="hepatitisBVaccineDtF" name="epidemiologicalSurvey.hepatitisBVaccineDtF" 
                    	date="${caseDto.epidemiologicalSurvey.hepatitisBVaccineDtF}" onlypast="true" style="width: 100px;" pattern="yyyy/MM/dd"></tag:dateInput> 
				</div>
				<div>第二针
					<tag:dateInput id="hepatitisBVaccineDtS" name="epidemiologicalSurvey.hepatitisBVaccineDtS" 
						date="${caseDto.epidemiologicalSurvey.hepatitisBVaccineDtS}" onlypast="true" style="width: 100px;" pattern="yyyy/MM/dd"
						 reg='{"compare":["hepatitisBVaccineDtF","ge","第二针时间必须大于第一针时间"]}'/>
				</div>
				<div>第三针
					<tag:dateInput id="hepatitisBVaccineDtT" name="epidemiologicalSurvey.hepatitisBVaccineDtT" 
						date="${caseDto.epidemiologicalSurvey.hepatitisBVaccineDtT}" onlypast="true" style="width: 100px;" pattern="yyyy/MM/dd"
						reg='{"compare":["hepatitisBVaccineDtS","ge","第三针时间必须大于第二针时间"]}'/>
				</div>
			</td>					
		</tr>
		<tr>
			<th>1.13初次发病时间：</th>
			<td>
				<tag:dateInput id="firstEpisodeDt" name="epidemiologicalSurvey.firstEpisodeDt" 
					date="${caseDto.epidemiologicalSurvey.firstEpisodeDt}" onlypast="true" style="width: 100px;" pattern="yyyy/MM/dd"/>
			</td>
		</tr>
        <tr>
            <th>1.14首次就诊时间：</th>
            <td>
                <tag:dateInput id="firstTreatmentDt" name="epidemiologicalSurvey.firstTreatmentDt"
                               date="${caseDto.epidemiologicalSurvey.firstTreatmentDt}" onlypast="true" style="width: 100px;" pattern="yyyy/MM/dd"
                               reg='{"compare":["firstEpisodeDt","ge","首次就诊时间必须大于初次发病时间"]}'/>
            </td>
        </tr>
		<tr>
			<th>1.15本次就诊单位：</th>
			<td colspan="3">
				<ehr:dic-radio dicmeta="IDM00004" name="epidemiologicalSurvey.theTreatmentUnit"  
					value="${caseDto.epidemiologicalSurvey.theTreatmentUnit}" code="1,2,3,4,5"/>
			</td>
		</tr>
		<tr>
			<th>1.16诊断依据：</th>
			<td colspan="3">
			</td>
		</tr>
		<tr>
			<th>1.16.1症状体征：</th>
			<td colspan="3">
				<ehr:dic-radio dicmeta="PH00002" name="diagnosis.symptomSign"
					value="${caseDto.diagnosis.symptomSign}" code="1,2"/> 
			</td>
		</tr>
		<tr>
			<th>1.16.2肝功能 ：</th>
			<td colspan="3">
				<ehr:dic-radio dicmeta="PH00003" name="diagnosis.liverFunction"
					value="${caseDto.diagnosis.liverFunction}" code="1,2,3"/> 
			</td>
		</tr>
		<tr>
			<th>1.16.3病毒感染标志：</th>
			<td colspan="3">
				<ehr:dic-list dicmeta="IDM00052" name="diagnosis.virusInfection" 
					value="${caseDto.diagnosis.virusInfection}" code="1,2,3,4,5,6,7,8,9"/> 
			</td>
		</tr>
		<tr>
			<th>1.17本次发病前是否是乙肝病毒携带者：</th>
			<td  colspan="3">
				<ehr:dic-radio dicmeta="PH00001" name="diagnosis.hbver"
					value="${caseDto.diagnosis.hbver}" code="1,2,4"/> 
			</td>
		</tr>
		<tr>
			<th>1.18本次发病前是否是丙肝病毒携带者：</th>
			<td colspan="3">
				<ehr:dic-radio dicmeta="PH00001" name="diagnosis.hcver"
					value="${caseDto.diagnosis.hcver}" code="1,2,4"/> 
			</td>
		</tr>
		<tr>			
			<th>1.19本次发病前是否是丁肝病毒携带者：</th>
			<td colspan="3">
				<ehr:dic-radio dicmeta="PH00001" name="diagnosis.hdver"
					value="${caseDto.diagnosis.hdver}" code="1,2,4"/> 
			</td>
		</tr>
	</table>
	</fieldset>
	<div>以下项目仅调查既往无乙肝、丙肝、丁肝病史的初次发病的病人</div>
    <fieldset>
        <legend>2.有关因素调查</legend>
        <table class="posttable">
            <colgroup>
                <col style="width: 23%" />
                <col style="width: 27%" />
                <col style="width: 18%" />
                <col style="width: 22%" />
            </colgroup>
				<tr>
					<th>2.1接受医疔服务情况 （发病前1个月至半年内）：</th>
				</tr>
				<tr>
					<th>2.1.1住院：</th>
					<td>
						<ehr:dic-radio dicmeta="PH00002" name="exposureHistory.inHospital"
							onchange="hcvCase.toggleInHospital()" value="${caseDto.exposureHistory.inHospital}" code="1,2"/>
					</td>
				</tr>
				<tr id="trInHospital1">
					<th>2.1.1.1住院时间：</th>
					<td>
						<tag:dateInput id="inHospitalDt" name="exposureHistory.inHospitalDt" 
							date="${caseDto.exposureHistory.inHospitalDt}" onlypast="true" style="width: 100px;" pattern="yyyy/MM/dd"/>
					</td>
					<th>2.1.1.2出院时间：</th>
					<td>
						<tag:dateInput id="outHospitalDt" name="exposureHistory.outHospitalDt" 
							date="${caseDto.exposureHistory.outHospitalDt}" onlypast="true" style="width: 100px;" pattern="yyyy/MM/dd"
							reg='{"compare":["inHospitalDt","ge","出院时间必须大于住院时间"]}'/>
					</td>
				</tr>
				<tr id="trInHospital2">
					<th>2.1.1.3医疗单位：</th>
					<td>
						<ehr:dic-radio dicmeta="IDM00004" name="exposureHistory.hospitalUnit" 
							value="${caseDto.exposureHistory.hospitalUnit}" code="1,2,3,4"/>
					</td>
					<th>2.1.1.4住院科室：</th>
					<td>
						<ehr:dic-list dicmeta="IDM00053" name="exposureHistory.inHospitalDepartment" 
							value="${caseDto.exposureHistory.inHospitalDepartment}" code="1,2,3,4,5,99"/>
					</td>
				</tr>							
			
				<tr>
					<th>2.1.2手术：</th>
					<td>
						<ehr:dic-radio dicmeta="PH00002" name="exposureHistory.operation"
							onchange="hcvCase.toggleOperation()" value="${caseDto.exposureHistory.operation}" code="1,2"/>
					</td>
				</tr>
				<tr id="trOperation1">
					<th>2.1.2.1何种手术：</th>
					<td>
						<input type="text" name="exposureHistory.operationDetail" value="${caseDto.exposureHistory.operationDetail}" 
							reg='{"maxlength":"100"}' style="width:150px"/> 
					</td>
					<th>2.1.2.2手术时间：</th>
					<td>
						<tag:dateInput id="operationDt" name="exposureHistory.operationDt" 
							date="${caseDto.exposureHistory.operationDt}" onlypast="true" style="width: 100px;" pattern="yyyy/MM"/>
					</td>
				</tr>
				<tr id="trOperation2">
					<th>2.1.2.3手术单位：</th>
					<td colspan="3">
						<ehr:dic-radio dicmeta="IDM00004" name="exposureHistory.operationUnit" 
							value="${caseDto.exposureHistory.operationUnit}" code="1,2,3,4"/>
					</td>
				</tr>							
				<tr>
					<th>2.1.3受血史：</th>
					<td>
						<ehr:dic-radio dicmeta="PH00002" name="exposureHistory.receptionBloodHistory"
							onchange="hcvCase.toggleReBlood()" value="${caseDto.exposureHistory.receptionBloodHistory}" code="1,2"/>
					</td>
				</tr>
				<tr id="trBloodHistory1">
					<th>2.1.3.1受血次数：</th>
					<td>
						<input type="text" name="exposureHistory.receptionBloodNum" value="${caseDto.exposureHistory.receptionBloodNum}" 
							reg='{"maxlength":"20"}' style="width:150px"/>次
					</td>
					<th>2.1.3.2累计受血量：</th>
					<td>
						<input type="text" name="exposureHistory.receptionBloodMeasure" value="${caseDto.exposureHistory.receptionBloodMeasure}" 
							reg='{"maxlength":"20"}' style="width:150px"/>ml
					</td>
				</tr>
				<tr id="trBloodHistory2">
					<th>2.1.3.3受血起止时间：</th>
					<td>
						<tag:dateInput id="receptionBloodBeginDtId" name="exposureHistory.receptionBloodBeginDt" 
							date="${caseDto.exposureHistory.receptionBloodBeginDt}" onlypast="true" style="width: 100px;" pattern="yyyy/MM/dd"/>
						至<tag:dateInput name="exposureHistory.receptionBloodEndDt" 
							date="${caseDto.exposureHistory.receptionBloodEndDt}" onlypast="true" style="width: 100px;" pattern="yyyy/MM/dd"
							reg='{"compare":["receptionBloodBeginDtId","ge","结束时间必须大于开始时间"]}'/>
					</td>
					<th>2.1.3.4医疗单位：</th>
					<td>
						<ehr:dic-radio dicmeta="IDM00004" name="exposureHistory.receptionBloodUnit"
							value="${caseDto.exposureHistory.operationUnit}" code="1,2,3,4"/>
					</td>
				</tr>							
				<tr>
					<th>2.1.4献血史：</th>
					<td>
						<ehr:dic-radio dicmeta="PH00002" name="exposureHistory.donateBloodHistory"
							onchange="hcvCase.toggleDoBlood()" value="${caseDto.exposureHistory.donateBloodHistory}" code="1,2"/>
					</td>
				</tr>
				<tr id="trDonateHistory1">
					<th>2.1.4.1献血次数：</th>
					<td>
						<input type="text" name="exposureHistory.donateBloodNum" value="${caseDto.exposureHistory.donateBloodNum}" 
							reg='{"maxlength":"20"}' style="width:150px"/>
					</td>
					<th>2.1.4.2献血单位：</th>
					<td>
						<input type="text" name="exposureHistory.donateBloodUnit" value="${caseDto.exposureHistory.donateBloodUnit}" 
							reg='{"maxlength":"100"}' style="width:200px"/>
					</td>
				</tr>
				<tr id="trDonateHistory2">
					<th>2.1.4.3献血类型：</th>
					<td>
						<ehr:dic-radio dicmeta="IDM00054" name="exposureHistory.donateBloodCategory"
							value="${caseDto.exposureHistory.donateBloodCategory}" code="1,2,3"/>
					</td>
				</tr>							
				<tr>
					<th>2.1.5静脉输液：</th>
					<td colspan="3">
						<ehr:dic-radio dicmeta="PH00002" name="exposureHistory.ivt" 
							onchange="toggleOther('exposureHistory.ivt','divIvtUnit','1')" value="${caseDto.exposureHistory.ivt}" code="1,2"/>
						<div id="divIvtUnit">医疗单位
							<ehr:dic-radio dicmeta="IDM00004" name="exposureHistory.ivtUnit"
								value="${caseDto.exposureHistory.ivtUnit}" code="1,2,3,4,5"/>
						</div>
					</td>
				</tr>
				<tr>
					<th>2.1.6针灸治疗：</th>
					<td colspan="3">
						<ehr:dic-radio dicmeta="PH00001" name="exposureHistory.acupuncture" 
							onchange="toggleOther('exposureHistory.acupuncture','divAcupuncture','1')"  value="${caseDto.exposureHistory.acupuncture}" code="1,2"/>
						<div id="divAcupuncture">2.1.6.1医疗单位
							<ehr:dic-radio dicmeta="IDM00004" name="exposureHistory.acupunctureUnit" 
								value="${caseDto.exposureHistory.acupunctureUnit}" code="1,2,3,4,5"/>
						</div>
					</td>
				</tr>
				<tr>
					<th>2.1.7肌肉、静脉注射：</th>
					<td>
						<ehr:dic-radio dicmeta="PH00002" name="exposureHistory.intravenousInjection"
							onchange="hcvCase.toggleInjection()" value="${caseDto.exposureHistory.intravenousInjection}" code="1,2"/>
					</td>
				</tr>
				<tr id="trInjection1">
					<th>2.1.7.1一次性注射器：</th>
					<td>
						<ehr:dic-radio dicmeta="PH00001" name="exposureHistory.iiDisposableSyringe"
							value="${caseDto.exposureHistory.iiDisposableSyringe}" code="1,2,4"/>
					</td>
					<th>2.1.7.2一人一针一管：</th>
					<td>
						<ehr:dic-radio dicmeta="PH00001" name="exposureHistory.iiNeedleTubing"
							value="${caseDto.exposureHistory.iiNeedleTubing}" code="1,2,4"/>
					</td>
				</tr>
				<tr id="trInjection2">
					<th>2.1.7.3医疗单位：</th>
					<td colspan="3">
						<ehr:dic-radio dicmeta="IDM00004" name="exposureHistory.intravenousInjectionUnit" 
							value="${caseDto.exposureHistory.intravenousInjectionUnit}" code="1,2,3,4,5"/>
					</td>
				</tr>							
				<tr>
					<th>2.1.8预防接种：</th>
					<td>
						<ehr:dic-radio dicmeta="PH00002" name="exposureHistory.vaccination"
							onchange="hcvCase.toggleVaccination()" value="${caseDto.exposureHistory.intravenousInjection}" code="1,2"/>
					</td>
				</tr>
				<tr id="trVaccination1">
					<th>2.1.8.1一次性注射器：</th>
					<td>
						<ehr:dic-radio dicmeta="PH00001" name="exposureHistory.vaDisposableSyringe"
							value="${caseDto.exposureHistory.vaDisposableSyringe}" code="1,2,4"/>
					</td>
					<th>2.1.8.2一人一针一管：</th>
					<td>
						<ehr:dic-radio dicmeta="PH00001" name="exposureHistory.vaNeedleTubing"
							value="${caseDto.exposureHistory.vaNeedleTubing}" code="1,2,4"/>
					</td>
				</tr>
				<tr id="trVaccination2">
					<th>2.1.8.3医疗单位：</th>
					<td colspan="3">
						<ehr:dic-radio dicmeta="IDM00004" name="exposureHistory.vaccinationUnit" 
							value="${caseDto.exposureHistory.vaccinationUnit}" code="1,2,3,4,5"/>
					</td>
				</tr>							
				<tr>
					<th>2.1.9拔牙：</th>
					<td>
						<ehr:dic-radio dicmeta="PH00002" name="exposureHistory.tooth"
							value="${caseDto.exposureHistory.tooth}" code="1,2" onchange="toggleOther('exposureHistory.tooth','toothPart',1);"/>
					</td>
				</tr>
                <tbody id="toothPart" style="display: none">
                    <tr>
                        <th>2.1.9.1拔牙次数：</th>
                        <td>
                            <input type="text" name="exposureHistory.toothNum" value="${caseDto.exposureHistory.toothNum}"
                                reg='{"maxlength":"20"}' style="width:100px"/>次
                        </td>
                        <th>2.1.9.2拔牙时间：</th>
                        <td>
                            <tag:dateInput name="exposureHistory.toothDt" date="${caseDto.exposureHistory.toothDt}" onlypast="true" style="width: 100px;" pattern="yyyy/MM/dd"/>
                        </td>
                    </tr>
                    <tr>
                        <th>2.1.9.3拔牙单位：</th>
                        <td>
                            <ehr:dic-radio dicmeta="IDM00004" name="exposureHistory.toothUnit"
                                value="${caseDto.exposureHistory.toothUnit}" code="1,2,3,4,5"/>
                        </td>
                    </tr>
                </tbody>
				<tr>
					<th>2.2家庭接触情况：</th>
				</tr>
				<tr>
					<th>2.2.1家庭内乙肝病人或HBV携带者：</th>
					<td>
						<ehr:dic-radio dicmeta="PH00002" name="exposureHistory.hbv"
							onchange="toggleOther('exposureHistory.hbv','divHbv','1')" value="${caseDto.exposureHistory.hbv}" code="1,2,4"/>
						<div id="divHbv">与患者关系
							<ehr:dic-list dicmeta="IDM00055" name="exposureHistory.hbvRelation" 
								value="${caseDto.exposureHistory.hbvRelation}" code="3,5,2,7,99"/> 
						</div>
					</td>
				</tr>
				<tr>
					<th>2.2.2共用牙刷 ：</th>
					<td>
						<ehr:dic-radio dicmeta="PH00002" name="exposureHistory.shareToothbrush"
							value="${caseDto.exposureHistory.shareToothbrush}" code="1,2"/>
					</td>
					<th>2.2.3共用刷牙杯：</th>
					<td>
						<ehr:dic-radio dicmeta="PH00002" name="exposureHistory.shareToothCup"
							value="${caseDto.exposureHistory.shareToothCup}" code="1,2"/>
					</td>
				</tr>
				<tr>
					<th>2.2.4共用剃刀：</th>
					<td>
						<ehr:dic-radio dicmeta="PH00002" name="exposureHistory.shareRazor"
							value="${caseDto.exposureHistory.shareRazor}" code="1,2"/>
					</td>
					<th>2.2.5家庭成员中痔疮患者：</th>
					<td>
						<ehr:dic-radio dicmeta="PH00002" name="exposureHistory.piles"
							value="${caseDto.exposureHistory.piles}" code="1,2"/>
					</td>
				</tr>
				<tr>
					<th>2.2.6月经血污染物品：</th>
					<td>
						<ehr:dic-radio dicmeta="PH00002" name="exposureHistory.mensePollute"
						value="${caseDto.exposureHistory.mensePollute}" code="1,2"/>
					</td>
				</tr>
				<tr>
					<th>2.3其他：</th>
				</tr>
				<tr>
					<th>2.3.1理发时刮面：</th>
					<td>
						<ehr:dic-radio dicmeta="PH00002" name="exposureHistory.shave"
							value="${caseDto.exposureHistory.shave}" code="1,2"/>
					</td>
					<th>2.3.2文眉：</th>
					<td>
						<ehr:dic-radio dicmeta="PH00002" name="exposureHistory.tattooingEyebrow"
							value="${caseDto.exposureHistory.tattooingEyebrow}" code="1,2"/>
					</td>
				</tr>
				<tr>
					<th>2. 3.3文身：</th>
					<td>
						<ehr:dic-radio dicmeta="PH00002" name="exposureHistory.tattoo"
							value="${caseDto.exposureHistory.tattoo}" code="1,2"/>
					</td>
				</tr>
			</table>
		</fieldset>
    <fieldset>
        <legend>2.有关因素调查</legend>
        <table class="posttable">
            <colgroup>
                <col style="width: 15%" />
                <col style="width: 35%" />
                <col style="width: 15%" />
                <col style="width: 35%" />
            </colgroup>
				<tr>
					<th>调查者单位：</th>
					<td><ehr:org code="${caseDto.caseInformation.modifySurveyOrg}"/></td>
					<th>调查者：</th>
					<td><ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/></td>
				</tr>
				<tr>
					<th>审核者：</th>
					<td><ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/></td>
					<th>调查时间：</th>
					<td><tag:dateInput name="caseInformation.surveyDate" pattern="yyyy/MM/dd" date="${caseDto.caseInformation.surveyDate}"/></td>
				</tr>
				 <tr style="display:none;">
	                 <td>
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

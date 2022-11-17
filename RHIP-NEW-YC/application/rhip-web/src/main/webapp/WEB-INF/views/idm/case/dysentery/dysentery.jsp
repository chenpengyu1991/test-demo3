﻿<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/dysentery.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<c:if test="${isPrint != 1}">
    <jsp:include page="../caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
<!-- 	隐藏变量区域 -->

<input type="hidden" id="efcList" name="efcList"/> 
<input type="hidden" id="esList" name="esList" /> 
<input type="hidden" id="leList" name="leList"/>
<input type="hidden" id="disinfectList" name="disinfectList"/> 
<input type="hidden" id="idmId" name="idmId" value="${idmId}"/>
    <div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
		<i class="popno">细菌性痢疾流行病学个案调查表<br/>（乙类传染病）</i>
		<div class="postdiv">
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
						 	reg='{"maxlength":"100"}'/>
					</td>
		            <th>病例编号：</th>
		            <td>
		               <input type="text" name="caseInformation.mediRecordNum" value="${caseDto.caseInformation.mediRecordNum}"  
							reg='{"length":"11"}' style="width: 160px;"/>
		            </td>
				</tr>
			</table>	
        </div>
        <div class="postdiv">
			<fieldset>
			<legend>1.一般情况</legend>
			<table class="posttable">
				<colgroup>
					<col style="min-width: 120px; width: 20%;" />
					<col style="min-width: 250px; width: 30%;" />
					<col style="min-width: 120px; width: 20%;" />
					<col style="min-width: 250px; width: 30%;" />
				</colgroup>
				<tr>
					<th>1.1 姓名：</th>
					<td><input type="text" name="generalCondition.name" value="${caseDto.generalCondition.name}" reg='{"maxlength":"100"}' style="width:180px;"/></td>
				</tr>
				<tr>
					<th>1.2 家长或监护人姓名：：</th>
					<td><input type="text" name="generalCondition.parentsName" value="${caseDto.generalCondition.parentsName}" reg='{"maxlength":"50"}' style="width:180px;" /></td>
				</tr>
				<tr>
					<th>1.3 性别：</th>
					<td colspan="3">
						<ehr:dic-radio id="gender" name="generalCondition.gender" dicmeta="GBT226112003" value="${caseDto.generalCondition.gender}" code="1,2" />
					</td>
				</tr>
				<tr>
					<th>1.4  出生日期：</th>
					<td colspan="3">
						<tag:dateInput  name="generalCondition.birthday" pattern="yyyy/MM/dd" date="${caseDto.generalCondition.birthday}" onlypast="true" style="width: 100px"></tag:dateInput>
						<span>（如出生日期不详，实足年龄:</span>
						<tag:numberInput id="age" name="generalCondition.age" value="${caseDto.generalCondition.age}"
										 maxlength="3" cssClass="width30" style="width: 80px"/>
						<span>年龄单位:</span>
						<ehr:dic-radio id="ageUnit" name="generalCondition.ageUnit"	dicmeta="IDM00003" value="${caseDto.generalCondition.ageUnit}"/>
						<span>）</span>
					</td>
				</tr>
				<tr>
					<th>1.5 职业：</th>
					<td colspan="3">
						<ehr:dic-list id="occupationId" name="generalCondition.occupation" dicmeta="GBT6565" value="${caseDto.generalCondition.occupation}"
									  onchange="toggleOtherSC('generalCondition.occupation','occupationOtherPart','CV020120299')" code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120208,CV020120206,CV020120207,CV020120209,CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,CV020120205,CV020120215,CV020120216,CV020120299,CV020120217" />
						<input type="text" id="occupationOtherPart" name="generalCondition.occupationOther" value="${caseDto.generalCondition.occupationOther}" reg='{"maxlength":"100"}' style="width:140px;display: none"/>
					</td>
				</tr>
				<tr>
					<th>1.6 文化程度：</th>
					<td colspan="3">
						<ehr:dic-radio id="Education" name="generalCondition.education" dicmeta="GBT46582006" value="${caseDto.generalCondition.education}"
									   code="IDM06,IDM07,IDM02,IDM03,IDM08,IDM09,IDM10" />
					</td>
				</tr>
				<tr>
					<th>1.7 现居住地：</th>
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
					<th>1.8 户籍地址:</th>
					<td colspan="3">
						<input type="text" id="hrAddress" name="generalCondition.hrAddress" value="${caseDto.generalCondition.hrAddress}"
                           			reg='{"maxlength":"100"}'  style="width: 180px;">
					</td>
				</tr>
				<tr>
					<th>1.9工作学习单位：</th>
					<td colspan="3">                 
	                           <input type="text" id="unitName" name="generalCondition.unitName" value="${caseDto.generalCondition.unitName}"
	                                  reg='{"maxlength":"50"}'  style="width: 180px;">
				
	                </td>
				</tr>

				<tr>
					<th>1.10 联系人：</th>
					<td colspan="3">
                            
                            <input type="text" id="contactName" name="generalCondition.contactName" value="${caseDto.generalCondition.contactName}"
                                   reg='{"maxlength":"20"}'  style="width: 180px;">
                        	
                        	联系电话（办公室）：<input type="text" name="generalCondition.contactPhone" value="${caseDto.generalCondition.contactPhone}"
                                reg='{"regex":"phone"}' style="width: 100px;"/>
                               （住宅）：<input type="text" name="generalCondition.familyPhone" value="${caseDto.generalCondition.familyPhone}"
                                reg='{"regex":"phone"}' style="width: 100px;"/>
                                （手机）：<input type="text" name="generalCondition.mobile" value="${caseDto.generalCondition.mobile}"
                                reg='{"regex":"phone"}' style="width: 100px;"/>
                            				
                    </td>
				</tr>
				<%--
				<tr>
					<th>1.2 身份证号码：</th>
					<td colspan="3"><input type="text" id="idCard" name="generalCondition.idcard" value="${caseDto.generalCondition.idcard}" placeholder="输入身份证获取个人信息" reg='{"idCard":"true"}' /></td>
				</tr>







				<tr>
					<th>1.12 病人属于：</th>
					<td colspan="3">
						<ehr:dic-radio name="generalCondition.patientAttribute" dicmeta="CV0201104" value="${caseDto.generalCondition.patientAttribute}" reg='{"required":"true"}'  onchange="caseEdit.toggerAddress()"/>
					</td>
				</tr>
				<tr>
					<th>1.13 病例分类：</th>
					<td colspan="3">
						<ehr:dic-radio name="otherCondition.caseType" dicmeta="CV0501002" value="${caseDto.otherCondition.caseType}" code="1,2,3" />
					</td>
				</tr>--%>
				<tr>
					<th>1.11 发病日期：</th>
					<td>
						<tag:dateInput id="pathogenesisDateId"  name="attackCondition.pathogenesisDate" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.pathogenesisDate}" onlypast="true" style="width: 100px" reg='{"compare":["firstVisitDateId","le","发病时间不能晚于初诊时间"]}'></tag:dateInput>
					</td>
					<th>1.12 发病地点：</th>
					<td>
						<input reg='{"maxlength":"100"}' type="text" name="attackCondition.pathogenesisPlace" value="${caseDto.attackCondition.pathogenesisPlace}" style="width:180px;"/>
					</td>
				</tr>
				<tr>
					<th>1.13 报告时间：</th>
					<td>
						<ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${caseDto.caseInformation.reportDate }"/></ehr:tip>
                            <tag:dateInput  name="caseInformation.reportDate" onlypast="true" pattern="yyyy/MM/dd"
                                           date="${caseDto.caseInformation.reportDate}" style="display: none" />
					</td>
					<th>1.14  初诊日期：</th>
					<td>
						<tag:dateInput id="firstVisitDateId"  name="attackCondition.firstVisitDate" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.firstVisitDate}" onlypast="true" style="width: 100px" reg='{"compare":["pathogenesisDateId","ge","初诊时间不能早于发病时间"]}'></tag:dateInput>
					</td>
				</tr>
				
				<tr>
					<th>1.15  初诊单位：</th>
					<td><input type="text" name="attackCondition.firstVisitUnit" value="${caseDto.attackCondition.firstVisitUnit}" reg='{"maxlength":"100"}' style="width: 180px"/></td>
					<%--<th>1.19  初诊病名：</th>
					<td><input type="text" name="attackCondition.firstVisitName" value="${caseDto.attackCondition.firstVisitName}" reg='{"maxlength":"100"}' style="width: 150px"/></td>--%>
				</tr>
				<%--<tr>
					&lt;%&ndash;<th>1.20 确诊日期：</th>
					<td>
						<tag:dateInput  name="attackCondition.confirmationDate" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.confirmationDate}" onlypast="true" style="width: 100px" reg='{"compare":["firstVisitDateId","ge","确诊时间不能早于初诊时间"]}'></tag:dateInput>
					</td>&ndash;%&gt;
					<th>1.21 确诊单位：</th>
					<td>
						<input type="text" name="attackCondition.confirmationHospital" value="${caseDto.attackCondition.confirmationHospital}" reg='{"maxlength":"100"}' style="width: 150px"/>
					</td>
				</tr>--%>
				<tr>
					<th>1.16 住院日期：</th>
					<td>
						<tag:dateInput id="inhosDateId"  name="attackCondition.inhosDate" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.inhosDate}" onlypast="true" style="width: 100px" reg='{"compare":["outHospitalDateId","le","入院日期不能晚于出院日期"]}'></tag:dateInput>
					</td>
					<%--<th>1.23 住院单位：</th>
					<td>
						<input type="text" name="attackCondition.admissionHospital" value="${caseDto.attackCondition.admissionHospital}" reg='{"maxlength":"100"}' style="width: 150px"/>
					</td>--%>
				</tr>
				<tr>
					<th>1.17 出院日期：</th>
					<td colspan="3">
						<tag:dateInput id="outHospitalDateId"  name="attackCondition.outHospitalDate" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.outHospitalDate}" onlypast="true" style="width: 100px" reg='{"compare":["inhosDateId","ge","出院日期不能早于入院日期"]}'></tag:dateInput>
					</td>
				</tr>
				<%--<tr>
					<th>1.25 出院时病原携带情况：</th>
					<td colspan="3">
						<ehr:dic-radio name="attackCondition.carrierFlg" dicmeta="PH00002" value="${caseDto.attackCondition.carrierFlg}" code="4,2,1" onchange="toggleOther('attackCondition.carrierFlg','spanGermicultureResult','1')"/>
						<span id="spanGermicultureResult">（如有，注明细菌培养结果）<input type="text" id="germicultureResult" name="attackCondition.germicultureResult" value="${caseDto.attackCondition.germicultureResult}" reg='{"maxlength":"100"}' style="width: 150px"/></span>
					</td>
				</tr> --%>
			</table>
			</fieldset>
</div>
<div class="postdiv">
	<fieldset>
	<legend>2.主要临床表现</legend>
	<table class="posttable">
		<colgroup>
			<col style="min-width: 120px; width: 20%;" />
			<col style="min-width: 250px; width: 30%;" />
			<col style="min-width: 120px; width: 20%;" />
			<col style="min-width: 250px; width: 30%;" />
		</colgroup>
		<tr>
			<th>2.1 腹泻：</th>
			<td colspan="3">
				<ehr:dic-radio name="clinicalManifestations.diarrhea" dicmeta="PH00002" value="${caseDto.clinicalManifestations.diarrhea}"
							   onchange="toggleOther('clinicalManifestations.diarrhea','spanDiarrhea','1')" code="1,2" />
				<span id="spanDiarrhea">
		 			 持续 <input type="text" name="clinicalManifestations.diarrhoeaDays" value="${caseDto.clinicalManifestations.diarrhoeaDays}" reg='{"maxlength":"20"}'  style="width:80px"/>天
		 			 最多 <input type="text" name="clinicalManifestations.diarrheaDailyTimes" value="${caseDto.clinicalManifestations.diarrheaDailyTimes}" reg='{"maxlength":"20"}' style="width:80px"/>次/天
	 			</span>
			</td>
		</tr>
		<tr>
			<th>2.2 粪便性状：</th>
			<td colspan="3">
				<ehr:dic-radio name="clinicalManifestations.stoolProperty" dicmeta="IDM00025" value="${caseDto.clinicalManifestations.stoolProperty}" code="1,5,6,99"
							   onchange="toggleOther('clinicalManifestations.stoolProperty','stoolProperty',99)" />
				<span id="stoolProperty">
		 			  <input type="text" name="clinicalManifestations.stoolPropertyOther" value="${caseDto.clinicalManifestations.stoolPropertyOther}" reg='{"maxlength":"20"}'  style="width:80px"/>
	 			</span>
			</td>
		</tr>
		<tr>
			<th>2.3 里急后重：</th>
			<td>
				<ehr:dic-radio name="clinicalManifestations.tenesmus" dicmeta="PH00002" value="${caseDto.clinicalManifestations.tenesmus}" code="1,2" />
			</td>
			<th>2.4 恶心：</th>
			<td>
				<ehr:dic-radio name="clinicalManifestations.nausea" dicmeta="PH00002" value="${caseDto.clinicalManifestations.nausea}" code="1,2" />
			</td>
		</tr>
		<tr>
			<th>2.5 呕吐：</th>
			<td colspan="3">
				<ehr:dic-radio name="clinicalManifestations.vomit" dicmeta="PH00002" value="${caseDto.clinicalManifestations.vomit}" code="1,2" />
			</td>
		</tr>
		<tr>
			<th>2.6 发热：</th>
			<td colspan="3">
				<ehr:dic-radio name="clinicalManifestations.fever" dicmeta="PH00002" value="${caseDto.clinicalManifestations.fever}" 
					onchange="toggleOther('clinicalManifestations.fever','spanFever','1')" code="1,2" />
				<span id="spanFever">
					 持续<input type="text" name="clinicalManifestations.heatingDuration" value="${caseDto.clinicalManifestations.heatingDuration}" reg='{"maxlength":"20"}' style="width:80px"/>天
					  最高体温<input type="text" name="clinicalManifestations.highestTemperature"  value="${caseDto.clinicalManifestations.highestTemperature}" reg='{"maxlength":"20"}' style="width:80px"/>℃
				</span>
			</td>
		</tr>
		<%--<tr>
			<th>2.4 腹痛：</th>
			<td>
				<ehr:dic-radio name="clinicalManifestations.stomachache" dicmeta="PH00002" value="${caseDto.clinicalManifestations.stomachache}" code="1,2" />
			</td>
			<th>2.5 腹痛部位：</th>
			<td>
				<ehr:dic-radio name="clinicalManifestations.abdominalPainParts" dicmeta="IDM00029" value="${caseDto.clinicalManifestations.abdominalPainParts}" code="1,2,3" />
			</td>
		</tr>
		<tr>
			<th>2.6 腹痛类型：</th>
			<td colspan="3">
				<ehr:dic-radio name="clinicalManifestations.abdominalPain" dicmeta="IDM00030" value="${caseDto.clinicalManifestations.abdominalPain}" code="1,2,3,4" />
			</td>
		</tr>--%>
		<%--<tr>
			<th>2.10 临床类型：</th>
			<td colspan="3">
				<ehr:dic-radio name="clinicalManifestations.clinicalTypeLevel" dicmeta="IDM00041" value="${caseDto.clinicalManifestations.clinicalTypeLevel}" code="1,2,3,4,5" />
			</td>
		</tr>--%>
		
		<tr>
            <th>2.7 诊断依据：</th>
            <td><ehr:dic-radio dicmeta="IDM00402" name="clinicalManifestations.diagnosisL" value="${caseDto.clinicalManifestations.diagnosisL}"/></td>
        </tr>
        <tr>
			<th>2.8 检验结果：</th>
			<td colspan="3">
  				<jsp:include page="examineList.jsp"></jsp:include>
			</td>
		</tr>
		 <tr>
			<th>2.9 转归：</th>
            <td>
            	<ehr:dic-radio name="otherCondition.outcomeCode" dicmeta="IDM00005" code="1,4,5" 
            	value="${caseDto.otherCondition.outcomeCode}"/>
            </td>
		</tr>
		
	</table>
	</fieldset>
</div>
<%--<div  class="postdiv">
	<fieldset>
	<legend>3.实验室检查</legend>
	<table class="posttable">
		<colgroup>
			<col style="min-width: 120px; width: 20%;" />
			<col style="min-width: 250px; width: 30%;" />
			<col style="min-width: 120px; width: 20%;" />
			<col style="min-width: 250px; width: 30%;" />
		</colgroup>
		<tr>
			<th>3.1 粪便镜检白细胞（脓细胞）：</th>
			<td><input type="text" name="labExamine.dejectaLeukocyte" value="${caseDto.labExamine.dejectaLeukocyte}"  reg='{"maxlength":"20"}' style="width:80px"/>个/HP</td>
			<th>3.2 粪便镜检红细胞：</th>
			<td><input type="text" name="labExamine.dejectaErythrocyte" value="${caseDto.labExamine.dejectaErythrocyte}"  reg='{"maxlength":"20"}' style="width:80px"/>
			</td>
		</tr>
		<tr>
			<th>3.3 粪便镜检阿米巴大滋养体：</th>
			<td>
				<ehr:dic-radio name="labExamine.amoebaTrophozoiteS" dicmeta="PH00005" value="${caseDto.labExamine.amoebaTrophozoiteS}" code="1,2" />
			</td>
			<th>3.4 粪便镜检阿米巴小滋养体：</th>
			<td>
				<ehr:dic-radio name="labExamine.amoebaTrophozoiteB" dicmeta="PH00005" value="${caseDto.labExamine.amoebaTrophozoiteB}" code="1,2" />
			</td>
		</tr>
		<tr>
			<th>3.5 粪便培养：</th>
			<td colspan="3">
				<ehr:dic-radio name="labExamine.stoolCulture" dicmeta="IDM00042" value="${caseDto.labExamine.stoolCulture}" code="1,2,3,4,5" />
			</td>
		</tr>
	</table>
	</fieldset>
</div>--%>
<div  class="postdiv">
	<fieldset>
	<legend>3.流行病学调查</legend>
	<table class="posttable" >
		<colgroup>
			<col style="min-width: 120px; width: 20%;" />
			<col style="min-width: 250px; width: 30%;" />
			<col style="min-width: 120px; width: 20%;" />
			<col style="min-width: 250px; width: 30%;" />
		</colgroup>
		<tr>
			<th>3.1 病前一周内与确诊痢疾病人接触史：</th>
			<td colspan="3">
				<ehr:dic-radio name="epidemiologicalSurvey.dysenteryContactHistory" dicmeta="PH00002" value="${caseDto.epidemiologicalSurvey.dysenteryContactHistory}"
							   onchange="dysenteryCase.toggleHistory('epidemiologicalSurvey.dysenteryContactHistory','1')" code="1,2" />
			</td>
		</tr>
		<tr id="trHistory1">
			<th>3.1.1 接触时间：</th>
			<td>
				<tag:dateInput name="infectionSourceRoute.contactSimilerPatientDt" pattern="yyyy/MM/dd"  style="width: 180px" date="${caseDto.infectionSourceRoute.contactSimilerPatientDt}"/>
			</td>
		</tr>
		<tr id="trHistory2">
			<th>3.1.2 接触地点：</th>
			<td colspan="3">
				<input type="text" name="infectionSourceRoute.contactSimilerPatientAddr" value="${caseDto.infectionSourceRoute.contactSimilerPatientAddr}" reg='{"maxlength":"100"}' style="width:180px"/>
			</td>
		</tr>
		<%-- <tr id="trHistory3">
			<th>4.4.3 与病人关系：</th>
			<td colspan="3">
				<input type="text" name="epidemiologicalSurvey.contactSimilerPatientAddr" value="${caseDto.epidemiologicalSurvey.contactSimilerPatientAddr}" reg='{"maxlength":"100"}' style="width:150px"/>
			</td>
		</tr> --%>
		<tr id="trHistory3">
			<th>3.1.3 接触方式 ：</th>
			<td colspan="3">
				<ehr:dic-checkbox name="epidemiologicalSurvey.contactWayMulti" dicmeta="IDM00033" value="${caseDto.epidemiologicalSurvey.contactWayMulti}" code="1,2,7,99" />
			</td>
		</tr>
		<tr>
			<th>3.2 既往一年内痢疾史：</th>
			<td colspan="3">
				<ehr:dic-radio name="epidemiologicalSurvey.dysentery" dicmeta="PH00002" value="${caseDto.epidemiologicalSurvey.dysentery}" 
					onchange="toggleOther('epidemiologicalSurvey.dysentery','spanDysentery','1')" code="1,2" />
			 	<span id="spanDysentery">
			 	 	发病时间  <tag:dateInput  name="epidemiologicalSurvey.dysenteryDt" pattern="yyyy/MM/dd" date="${caseDto.epidemiologicalSurvey.dysenteryDt}" onlypast="true" style="width: 100px"></tag:dateInput>
			 	 </span>
			</td>
		</tr>
		<tr>
			<th>3.3 病前一周内喝生水史：</th>
			<td  colspan="3">
				<ehr:dic-radio name="epidemiologicalSurvey.rawWater" dicmeta="PH00002" value="${caseDto.epidemiologicalSurvey.rawWater}" code="1,2" />
			</td>

		</tr>
		<tr>
			<th>3.4 病前一周内可疑饮食史：</th>
			<td  colspan="3">
				<ehr:dic-radio name="epidemiologicalSurvey.doubtfulDiet" dicmeta="PH00002" value="${caseDto.epidemiologicalSurvey.doubtfulDiet}" 
					onchange="dysenteryCase.toggleDiet('epidemiologicalSurvey.doubtfulDiet','1')" code="1,2" />
			</td>
		</tr>
		<tr id="trDiet1">
			<th>3.4.1 进食时间：</th>
			<td>
				<tag:dateInput  name="epidemiologicalSurvey.doubtfulDietDt" pattern="yyyy/MM/dd" date="${caseDto.epidemiologicalSurvey.doubtfulDietDt}" onlypast="true" style="width: 100px"></tag:dateInput>
			</td>
			<th>3.4.2 食物名称：</th>
			<td>
				<input type="text" name="epidemiologicalSurvey.doubtfulDietName" value="${caseDto.epidemiologicalSurvey.doubtfulDietName}" reg='{"maxlength":"100"}' style="width:120px"/>
			</td>
		</tr>
		<tr id="trDiet2">
			<th>3.4.3 同餐：</th>
			<td>
				<input type="text" name="epidemiologicalSurvey.sameMealNum" value="${caseDto.epidemiologicalSurvey.sameMealNum}" reg='{"maxlength":"20"}' style="width:80px"/>人
			</td>
			<th>3.4.4 发病：</th>
			<td>
				<input type="text"	name="epidemiologicalSurvey.dysenteryNum" value="${caseDto.epidemiologicalSurvey.dysenteryNum}" reg='{"maxlength":"20"}' style="width:80px"/>人
			</td>
		</tr>
		<tr>
			<th>3.5 饮生水：</th>
			<td colspan="3">
				<ehr:dic-radio dicmeta="PH00002" name="beforeDiseaseDiet.drinkingHistory" code="1,2" value="${caseDto.beforeDiseaseDiet.drinkingHistory}"
							   onchange="toggleOther('beforeDiseaseDiet.drinkingHistory','waterType',1)"/>
				<span style="display: none;" id="waterType">
					水源类型：
		           	<ehr:dic-radio name="beforeDiseaseDiet.waterType" dicmeta="IDM00034" code="3,4,6,8,99" value="${caseDto.beforeDiseaseDiet.waterType}"/>

				</span>
			</td>
		</tr>
		<tr>
		<th>3.6 吃生冷食品：</th>
		<td>
			<ehr:dic-radio dicmeta="PH00002" name="beforeDiseaseDiet.coldFood" code="1,2" value="${caseDto.beforeDiseaseDiet.coldFood}"
						   onchange="toggleOther('beforeDiseaseDiet.coldFood','coldFoodName',1)"/>
		</td>
		</tr>
		<tr id="coldFoodName">
			<th>3.6.1 生冷食品名称：</th>
			<td><input type="text" name="beforeDiseaseDiet.coldFoodName" value="${caseDto.beforeDiseaseDiet.coldFoodName}" reg='{"maxlength":"100"}'/></td>
			<th>3.6.2 购买地点：</th>
			<td><input type="text" name="beforeDiseaseDiet.coldFoodBuyPlace" value="${caseDto.beforeDiseaseDiet.coldFoodBuyPlace}" reg='{"maxlength":"100"}'/></td>
		</tr>
		<tr>
			<th>3.7 熟食冷吃：</th>
			<td>
				<ehr:dic-radio dicmeta="PH00002" name="beforeDiseaseDiet.cookedFoodColdEat" code="1,2" value="${caseDto.beforeDiseaseDiet.cookedFoodColdEat}"
							   onchange="toggleOther('beforeDiseaseDiet.cookedFoodColdEat','cookedFoodName',1)"/>
			</td>
			<td></td>
			<td></td>
		</tr>
		<tr id="cookedFoodName">
			<th>3.7.1 熟食品名称 ：</th>
			<td>
				<input type="text" name="beforeDiseaseDiet.cookedFoodName" value="${caseDto.beforeDiseaseDiet.cookedFoodName}" reg='{"maxlength":"50"}'/>
			</td>
			<th>3.7.2 购买地点：</th>
			<td>
				<input type="text" name="beforeDiseaseDiet.cookedFoodBuyPlace" value="${caseDto.beforeDiseaseDiet.cookedFoodBuyPlace}" reg='{"maxlength":"200"}'/>
			</td>
		</tr>
		<tr>
			<th>3.8 其他可疑食品名称：</th>
			<td>
				<input type="text" name="beforeDiseaseDiet.suspiciousFood" value="${caseDto.beforeDiseaseDiet.suspiciousFood}"  reg='{"maxlength":"100"}'/>
			</td>

			<th>3.8.1  购买地点：</th>
			<td>
				<input type="text" name="beforeDiseaseDiet.susSalesPlaces" value="${caseDto.beforeDiseaseDiet.susSalesPlaces}"  reg='{"maxlength":"100"}'/>
			</td>
		</tr>
		<tr>
			<th>3.9 在外就餐史：</th>
			<td>
				<ehr:dic-radio dicmeta="PH00002" name="beforeDiseaseDiet.outsideDiningHistory" code="1,2" value="${caseDto.beforeDiseaseDiet.outsideDiningHistory}"
							   onchange="toggleOther('beforeDiseaseDiet.outsideDiningHistory','eatPlace',1)"/>
			</td>
		</tr>
		<tr id="eatPlace">
			<th>3.9.1 就餐地点：</th>
			<td><ehr:dic-list name="beforeDiseaseDiet.eatPlace" dicmeta="IDM00037" value="${caseDto.beforeDiseaseDiet.eatPlace}"/></td>
			<th>3.9.2 就餐地点名称：</th>
			<td><input type="text" name="beforeDiseaseDiet.cookedFoodEatPlace" value="${caseDto.beforeDiseaseDiet.cookedFoodEatPlace}" reg='{"maxlength":"50"}'/></td>
		</tr>
		<tr>
			<th>3.10 同餐者：</th>
			<td>
				<ehr:dic-radio dicmeta="PH00002" name="beforeDiseaseDiet.meals" code="1,2" value="${caseDto.beforeDiseaseDiet.meals}"
							   onchange="toggleOther('beforeDiseaseDiet.meals','mealPNum',1)"/>
			</td>
		</tr>
		<tr id="mealPNum">
			<th>3.10.1 同餐人数：</th>
			<td><input type="text" name="beforeDiseaseDiet.mealPNum" value="${caseDto.beforeDiseaseDiet.mealPNum}" reg='{"maxlength":"20"}' /></td>
			<th>3.10.2  同餐日期：</th>
			<td><tag:dateInput id="dinnerDate" name="beforeDiseaseDiet.dinnerDate" date="${caseDto.beforeDiseaseDiet.dinnerDate}"  onlypast="true" pattern="yyyy/MM/dd HH" />时
				<input type="hidden" id="dinnerHour" name="beforeDiseaseDiet.dinnerHour" />
			</td>
		</tr>
		<tr>
			<th>3.11  同餐者发病：</th>
			<td colspan="3">
				<ehr:dic-radio name="beforeDiseaseDiet.dinnerInfectedFlag" dicmeta="PH00002" value="${caseDto.beforeDiseaseDiet.dinnerInfectedFlag}" code="1,2"
							   onchange="toggleOther('beforeDiseaseDiet.dinnerInfectedFlag','dinnerInfectedFlag','1')"/>
				<span id="dinnerInfectedFlag"  style="display:none;"> &nbsp;&nbsp;同餐发病人数:
			<input type="text" name="beforeDiseaseDiet.infectedNum" value="${caseDto.beforeDiseaseDiet.infectedNum}" reg='{"maxlength":"20"}' style="width:80px"/></span>

			</td>

		</tr>
		<tr>
			<th>3.12  饭前洗手：</th>
			<td>
				<ehr:dic-radio name="hygienicCondition.wash" dicmeta="IDM00403" value="${caseDto.hygienicCondition.wash}" code="1,2,3" />
			</td>
			<th>3.13  便后洗手：</th>
			<td>
				<ehr:dic-radio name="epidemiologicalSurvey.washingHandEatingToilet" dicmeta="IDM00403" value="${caseDto.epidemiologicalSurvey.washingHandEatingToilet}" code="1,2" />
			</td>
		</tr>
<%--		<tr>
			<th>4.5 饮用水源：</th>
			<td colspan="3">
				<ehr:dic-radio name="epidemiologicalSurvey.drinkingWater" dicmeta="IDM00034" value="${caseDto.epidemiologicalSurvey.drinkingWater}" code="1,2,4,6,7,8,10,99" />
			</td>
		</tr>
		<tr>
			<th>4.6 洗漱用水：</th>
			<td  colspan="3">
				<ehr:dic-radio name="epidemiologicalSurvey.washWater" dicmeta="IDM00034" value="${caseDto.epidemiologicalSurvey.washWater}" code="1,2,4,6,7,8,10,99" />
			</td>
		</tr>
		<tr>
			<th>4.7 上述用水是否消毒：</th>
			<td>
				<ehr:dic-radio name="epidemiologicalSurvey.waterDisinfect" dicmeta="PH00001" value="${caseDto.epidemiologicalSurvey.waterDisinfect}" code="1,2" />
			</td>
			<th>4.8 居所卫生：</th>
			<td>
				<ehr:dic-radio name="epidemiologicalSurvey.homeHealth" dicmeta="IDM00038" value="${caseDto.epidemiologicalSurvey.homeHealth}" code="1,2,3" />
			</td>
		</tr>
		<tr>
			<th>4.9 室内苍蝇 ：</th>
			<td>
				<ehr:dic-radio name="epidemiologicalSurvey.fly" dicmeta="IDM00039" value="${caseDto.epidemiologicalSurvey.fly}" code="1,2,3" />
			</td>
			<th>4.10 厕所使用：</th>
			<td>
				<ehr:dic-radio name="epidemiologicalSurvey.toilet" dicmeta="IDM00043" value="${caseDto.epidemiologicalSurvey.toilet}" code="1,2" />
			</td>
		</tr>--%>
		<tr>
			<th>3.14 密切接触者登记：</th>
			<td colspan="3">
				<div id="contactedList">
					<jsp:include page="contactsList.jsp"></jsp:include>
				</div>
			</td>
		</tr>
	</table>
	</fieldset>
</div>
<div  class="postdiv">
	<fieldset>
    <legend>4.疫点处理情况</legend>
    <table class="posttable">
		<colgroup>
			<col style="min-width: 120px; width: 20%;" />
		    <col style="min-width: 350px; width: 80%;" />
		</colgroup>
		<tr>
			<th>4.1 病人是否隔离：</th>
			<td>
				<ehr:dic-radio name="epidemicFocusClose.isPatientIsolation" dicmeta="PH00001" value="${caseDto.epidemicFocusClose.isPatientIsolation}" code="1,2" />
			</td>
		</tr>
		<tr>
			<th>4.2 隔离地点：</th>
			<td>
				<ehr:dic-radio name="epidemicFocusClose.isolationPlace" dicmeta="IDM00044" value="${caseDto.epidemicFocusClose.isolationPlace}" code="1,2,99" />
			</td>
		</tr>
		<tr>
			<th>4.3 病人住室消毒：</th>
			<td>
				<ehr:dic-radio name="epidemicFocusClose.patAccomDisin" dicmeta="PH00002" value="${caseDto.epidemicFocusClose.patAccomDisin}" code="1,2" />
			</td>
		</tr>
		<tr>
			<th>4.4 病人排泄物：</th>
			<td>
				<ehr:dic-radio name="epidemicFocusClose.isExcretaDisi" dicmeta="IDM00406" value="${caseDto.epidemicFocusClose.isExcretaDisi}" 
					onchange="toggleOther('epidemicFocusClose.isExcretaDisi','isExcretaDisi','2')" code="1,2" />
				<span id="isExcretaDisi">
					&nbsp;处理方法  <input type="text" name="epidemicFocusClose.processMethod" value="${caseDto.epidemicFocusClose.processMethod}" reg='{"maxlength":"20"}' style="width:80px"/>
					
				</span>
			
			</td>
		</tr>
		<tr>
			<th>4.5 病人的饮食用具：</th>
			<td>
				<ehr:dic-radio name="hygienicCondition.applianceSeparation" dicmeta="IDM00404" value="${caseDto.hygienicCondition.applianceSeparation}" code="1,2" />
			</td>
		</tr>
		<tr>
			<th>4.6 饮食用具消毒方法：</th>
			<td>
				<ehr:dic-radio name="hygienicCondition.applianceDisinfectionMethod" dicmeta="IDM00405" value="${caseDto.hygienicCondition.applianceDisinfectionMethod}" code="1,2" />
			</td>
		</tr>
		<tr>
			<th>4.7 治疗倩况：</th>
			<td>
				<ehr:dic-radio name="otherCondition.cureCondition" dicmeta="IDM00407" value="${caseDto.otherCondition.cureCondition}"  />
			</td>
		</tr>
		<tr>
			<th>4.8 患病期间暂时调离工作岗位：</th>
			<td>
				<ehr:dic-radio name="otherCondition.removeFromWork" dicmeta="PH00001" value="${caseDto.otherCondition.removeFromWork}" code="1,2" />
			</td>
		</tr>
<%--		<tr>
			<th>5.9 清毒情况：</th>
			<td>
  				<jsp:include page="disinfectList.jsp"></jsp:include>
			</td>
		</tr>--%>
	</table>
    </fieldset>
</div>
<div  class="postdiv">
	<fieldset>
    <legend>5.小结</legend>
    	<table class="posttable">
			<tr>
				<td>
            		<textarea name="otherCondition.surveySummary" reg='{"maxlength":"800"}' style="width: 99%" rows=10 >${caseDto.otherCondition.surveySummary}</textarea>
            	</td>
			</tr>
        </table>
     </fieldset>
</div>
<div class="postdiv">
	<fieldset>
    <table class="posttable">
	    <colgroup>
	        <col style="min-width: 120px; width: 20%;" />
	        <col style="min-width: 250px; width: 30%;" />
	        <col style="min-width: 120px; width: 20%;" />
	        <col style="min-width: 250px; width: 30%;" />
	    </colgroup>
		<tr>
			<th>调查者单位：</th>
			<td>
				<ehr:org code="${caseDto.caseInformation.modifySurveyOrg}"/>
			</td>
			<th>调查者：</th>
			<td>
				<ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/>
			</td>
		</tr>
		<tr>
			<th>调查时间：</th>
			<td><tag:dateInput nullToToday="true" name="caseInformation.surveyDate" pattern="yyyy/MM/dd" date="${caseDto.caseInformation.surveyDate}"/></td>
			<th>审核者：</th>
			<td><ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/></td>
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

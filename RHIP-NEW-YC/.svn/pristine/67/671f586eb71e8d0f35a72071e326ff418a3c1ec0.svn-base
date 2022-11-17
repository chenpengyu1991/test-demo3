<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%-- <i class="popno">
     急性弛缓性麻痹病例随访表<br/>
     <span>（乙类传染病脊髓灰质炎监测病例）</span>
 </i>--%>

 <div class="postdiv">
<%-- <fieldset>
	<legend>1. 编号</legend>
		<table class="posttable">
			<colgroup>
				<col style="width: 18%" />
				<col style="width: 32%" />
				<col style="width: 18%" />
				<col style="width: 32%" />
			</colgroup>
			<tr>
				<th>a. 病例编号：</th>
				<td>${caseDto.caseInformation.mediRecordNum}</td>
			</tr>
		</table>
	</fieldset>--%>
<%--	<fieldset>
		<legend>2. 基本情况</legend>
		<table class="posttable">
			<colgroup>
				<col style="width: 18%" />
				<col style="width: 32%" />
				<col style="width: 18%" />
				<col style="width: 32%" />
			</colgroup>
			<tr>
				<th>a. 姓名：</th>
				<td>${caseDto.generalCondition.name }</td>
				<th>b. 性别：</th>
				<td><c:if test="${'1'== caseDto.generalCondition.gender}">
						男
					</c:if>
					<c:if test="${'2'== caseDto.generalCondition.gender}">
						女
					</c:if> 
				</td>
			</tr>
			<tr>
				<th>c. 出生日期：</th>
				<td><fmt:formatDate pattern="yyyy/MM/dd" value="${caseDto.generalCondition.birthday}"/>
			</tr>
			<tr>
				<th>d. 病人详细地址：</th>
                <td colspan="3">
                	<ehr:dic code="${caseDto.generalCondition.pastreet}" dicmeta="FS990001"/><ehr:dic code="${caseDto.generalCondition.patownShip}" dicmeta="FS990001"/>${caseDto.generalCondition.pahouseNumber}
                    &lt;%&ndash; <ehr:dic-town-village villageId="pavillage_address" townId="patown_address" villageName="generalCondition.pastreet" townName="generalCondition.patownShip"
                                          villageValue="${caseDto.generalCondition.pastreet}" townValue="${caseDto.generalCondition.patownShip}" width="180px;" />
                    <input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${caseDto.generalCondition.pahouseNumber}"
                           reg='{"maxlength":"50"}'  style="width: 180px;">
                	<span id="spanPaNumber">(门牌号)</span> &ndash;%&gt;
                </td>
			</tr>
		</table>
	</fieldset>--%>
     <fieldset>
         <legend>9. 麻痹60天后随访</legend>
         <table class="posttable">
             <colgroup>
                 <col style="width: 20%"/>
                 <col style="width: 25%"/>
                 <col style="width: 20%"/>
                 <col style="width: 35%"/>
             </colgroup>
             <tr>
                 <th>a. 是否进行病例随访：</th>
                 <td><ehr:dic-radio dicmeta="PH00001" name="diagnosis.followUp" value="${caseDto.diagnosis.followUp}" code="1,2"/></td>
                 <th>b. 随访单位：</th>
                 <td><ehr:dic-radio dicmeta="CV850003" code="3,2,1" name="diagnosis.followUpUnit" value="${caseDto.diagnosis.followUpUnit}"/></td>
             </tr>
             <tr>
                 <th>c. 随访日期：</th>
                 <td><tag:dateInput id="followUpDt" name="diagnosis.followUpDt" date="${caseDto.diagnosis.followUpDt}" pattern="yyyy/MM/dd" nullToToday="true" onlypast="true"
                 		reg='{"compare":["toCdcDt","le","随访日期不能小于随访表送达省CDC时间"]}' /></td>
                 <th>d. 随访人姓名：</th>
                 <td><input type="text" name="diagnosis.followUpName" value="${caseDto.diagnosis.followUpName}" reg='{"maxlength":"50"}'/></td>
             </tr>
             <tr>
                 <th>e. 病例死亡：</th>
                 <td><ehr:dic-radio dicmeta="PH00001" name="diagnosis.followupCaseDie" value="${caseDto.diagnosis.followupCaseDie}" code="1,2"/></td>
                 <th>f. 病例失访：</th>
                 <td><ehr:dic-radio dicmeta="PH00001" name="diagnosis.followupCaseLostFollowup" value="${caseDto.diagnosis.followupCaseLostFollowup}" code="1,2"/></td>
             </tr>
             <tr>
                 <th> g. 是否残留麻痹：</th>
                 <td>
                 	<ehr:dic-radio dicmeta="PH00001" name="diagnosis.followupResidualParalysis" value="${caseDto.diagnosis.followupResidualParalysis}" code="1,2"
                 	 onchange="toggleOther('diagnosis.followupResidualParalysis','leftUpperLimb',1);"/>
                 </td>
             </tr>
             <tr id="leftUpperLimb" style="${caseDto.diagnosis.followupResidualParalysis == '1' ? '' : ';display:none;'}">
             	<td colspan="4" style="padding: 0px;">
             		<table>
             			<colgroup>
			                 <col style="width: 20%"/>
			                 <col style="width: 25%"/>
			                 <col style="width: 20%"/>
			                 <col style="width: 35%"/>
			             </colgroup>
             			<tr>
			                 <th> 麻痹部位：</th>
			             </tr>
			             <tr>
			                 <th>h. 左上肢：</th>
			                 <td><ehr:dic-list name="diagnosis.leftUpperLimb" dicmeta="IDM00116" value="${caseDto.diagnosis.leftUpperLimb}" width="60%" uninclude="99"/></td>
			                 <th>i. 右上肢：</th>
			                 <td><ehr:dic-list name="diagnosis.rightUpperLimb" dicmeta="IDM00116" value="${caseDto.diagnosis.rightUpperLimb}" width="50%" uninclude="99"/></td>
			             </tr>
			             <tr>
			                 <th> j. 左下肢：</th>
			                 <td>
			                 	<ehr:dic-list name="diagnosis.leftLowerLimb" dicmeta="IDM00116" value="${caseDto.diagnosis.leftLowerLimb}" width="60%" uninclude="99"/>
			                </td>
			                <th> k. 右下肢：</th>
			                <td><ehr:dic-list name="diagnosis.rightLowerLimb" dicmeta="IDM00116" value="${caseDto.diagnosis.rightLowerLimb}" width="50%" uninclude="99"/></td>
			             </tr>
             		</table>
             	</td>
             </tr>
             <tr>
                 <th>l. 肢体感觉障碍：</th>
                 <td colspan="3">
                 	<ehr:dic-radio dicmeta="PH00002" name="diagnosis.limbSensoryDisturbance" value="${caseDto.diagnosis.limbSensoryDisturbance}" uninclude="3,5"
                 		onchange="toggleOther('diagnosis.limbSensoryDisturbance','limbPart',1);"/>
                 		<span id="limbPart" style="${caseDto.diagnosis.limbSensoryDisturbance == '1' ? '' : 'display:none;'}">
	     					 部位(请注明)：<input type="text" name="diagnosis.limbPart" value="${caseDto.diagnosis.limbPart}" reg='{"maxlength":"100"}' style="width: 40%"/>
     					 </span>
                 </td>
             </tr>
             <tr>
                 <th> m. 如有大小便失禁,持续时间：</th>
                 <td><input type="text" name="diagnosis.incontinentDuration" value="${caseDto.diagnosis.incontinentDuration}" reg='{"maxlength":"20"}'/>天</td>
                 <th>n. 巴彬斯基氏反射：</th>
                 <td><ehr:dic-radio dicmeta="PH00002" name="diagnosis.babinskiReflex" value="${caseDto.diagnosis.babinskiReflex}" uninclude="3,5"/></td>
             </tr>
             <tr>
                 <th>o. 踝阵挛：</th>
                 <td><ehr:dic-radio dicmeta="PH00002" name="diagnosis.ankleClonus" value="${caseDto.diagnosis.ankleClonus}" uninclude="3,5"/></td>
                 <th>P. 肌肉萎缩：</th>
                 <td>
                 	<ehr:dic-radio dicmeta="PH00002" name="diagnosis.muscleAtrophy" value="${caseDto.diagnosis.muscleAtrophy}" uninclude="3,5"
                 	onchange="toggleOther('diagnosis.muscleAtrophy','musclePart',1);"/>
                 	<span id="musclePart" style="${caseDto.diagnosis.muscleAtrophy == '1' ? '' : 'display:none;'}">
                 		部位（请注明）：<input type="text" name="diagnosis.musclePart" value="${caseDto.diagnosis.musclePart}" reg='{"maxlength":"100"}' style="width: 40%"/>
                    </span>
                 </td>
             </tr>
             <tr>
                 <th>q. 深部腱反射异常：</th>
                 <td>
                 	<ehr:dic-radio dicmeta="PH00002" name="diagnosis.dtrUnusual" value="${caseDto.diagnosis.dtrUnusual}" uninclude="3,5"
                 		onchange="toggleOther('diagnosis.dtrUnusual','tendoCalcaneus',1);"/>
                 </td>
             </tr>
             <tr id="tendoCalcaneus" style="${caseDto.diagnosis.dtrUnusual == '1' ? '' : 'display:none;'}">
                 <td colspan="4" style="padding: 0px;">
                 	<table>
                 		<colgroup>
			                 <col style="width: 20%"/>
			                 <col style="width: 25%"/>
			                 <col style="width: 20%"/>
			                 <col style="width: 35%"/>
			             </colgroup>
                 		<tr>
			                 <th>跟腱：</th>
			                 <td><ehr:dic-radio dicmeta="IDM00118" name="diagnosis.tendoCalcaneus" value="${caseDto.diagnosis.tendoCalcaneus}" uninclude="5"/></td>
			                 <th>膝：</th>
			                 <td><ehr:dic-radio dicmeta="IDM00118" name="diagnosis.knee" value="${caseDto.diagnosis.knee}" uninclude="5"/></td>
			             </tr>
			             <tr>
			                 <th>肱二头肌：</th>
			                 <td><ehr:dic-radio dicmeta="IDM00118" name="diagnosis.bicepsBrachii" value="${caseDto.diagnosis.bicepsBrachii}" uninclude="5"/></td>
			             </tr>
                 	</table>
                 </td>
             </tr>
             <tr>
                 <th> r. 行走能力：</th>
                 <td><ehr:dic-list name="diagnosis.locomotorActivity" dicmeta="IDM00127" value="${caseDto.diagnosis.locomotorActivity}" width="80%"/></td>
                 <th>s. 检查医师：</th>
                 <td>
                 	<ehr:dic-list name="diagnosis.checkDoctor" dicmeta="IDM00128" value="${caseDto.diagnosis.checkDoctor}"
                 		onchange="toggleOtherSC('diagnosis.checkDoctor','checkDoctorOther','99')" width="50%"/>
                  	<input type="text" id="checkDoctorOther" name="diagnosis.checkDoctorOther" value="${caseDto.diagnosis.checkDoctorOther}" reg='{"maxlength":"100"}'
                  		style="${caseDto.diagnosis.checkDoctor == '99' ? 'width:40%;' : 'width:40%;display:none;'}" />
                  </td>
             </tr>
             <tr>
                 <th>t. 病例出院诊断：</th>
                 <td>
                 	<ehr:dic-list name="diagnosis.outHospitlDiagnosis" dicmeta="IDM00121" value="${caseDto.diagnosis.outHospitlDiagnosis}" uninclude="1,6"
                 		onchange="toggleOtherSC('diagnosis.outHospitlDiagnosis','diagnosisOtherTr','99')" width="60%"/>
                 	<input type="text" id="diagnosisOtherTr" name="diagnosis.diagnosisOther" value="${caseDto.diagnosis.diagnosisOther}" reg='{"maxlength":"100"}'
                 		style="${caseDto.diagnosis.outHospitlDiagnosis == '99' ? 'width:25%;' : 'width:25%;display:none;'}"/>
                 </td>
                 <th>u. 随访表送达省CDC时间：</th>
                 <td>
                 	<tag:dateInput id="toCdcDt" name="diagnosis.toCdcDt" pattern="yyyy/MM/dd" date="${caseDto.diagnosis.toCdcDt}" nullToToday="true" onlypast="true" 
                 		reg='{"compare":["followUpDt","ge","随访表送达省CDC时间不能大于随访日期"]}'/>
                 </td>
             </tr>

         </table>
     </fieldset>
 </div>

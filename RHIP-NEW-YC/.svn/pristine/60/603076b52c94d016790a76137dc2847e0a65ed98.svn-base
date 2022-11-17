<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/varicella.js" type="text/javascript"></script>
<c:if test="${isPrint != 1}">
    <jsp:include page="caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
	<input type="hidden" id="idmId" name="idmId" value="${idmId}"/>
	<input type="hidden" name="esList" id="esList"/>
    <input type="hidden" name="efcList" id="efcList"/>
    <div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
		<i class="popno">
			水痘病例个案调查表 <br />
		</i>
		<table>
			<colgroup>
				<col style="width: 20%" />
				<col style="width: 30%" />
				<col style="width: 20%" />
				<col style="width: 30%" />
			</colgroup>
			<tr>
				<th>传染病报告编码：</th>
				<td>
					 ${caseDto.caseInformation.caseNo}
                    <input type="hidden" name="caseInformation.caseNo" value="${caseDto.caseInformation.caseNo}"/>
				</td>
				<td colspan="2">
					${rootDicItem.itemName}<ehr:dic-town-street-village streetId="revillage_address" townId="retown_address" streetName="generalCondition.restreet" townName="generalCondition.retownShip"
																		streetValue="${caseDto.generalCondition.restreet}" townValue="${caseDto.generalCondition.retownShip}" width="140px;"/>
				</td>
			</tr>
		</table>		
		<div class="postdiv">
			<fieldset>
				<legend>1. 病例基本情况 </legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 80px; width: 25%" />
						<col style="min-width: 280px; width: 35%" />
						<col style="min-width: 160px; width: 15%" />
						<col style="min-width: 200px; width: 25%" />
					</colgroup>
					<tr>
						<th>1.1 病人姓名：</th>
						<td>
			            	<input type="text" name="generalCondition.name" value="${caseDto.generalCondition.name}" reg='{"maxlength":"100"}' style="width: 36%"/>
			            </td>
						<th>1.2 病人性别：</th>
						<td>
			            	<ehr:dic-radio  dicmeta="GBT226112003" name="generalCondition.gender" code="1,2" value="${caseDto.generalCondition.gender}"/>
			            </td>
					</tr>
					<tr>
						<th>1.3 出生日期： </th>
						<td><tag:dateInput id="birthday" name="generalCondition.birthday" date="${caseDto.generalCondition.birthday}" style="width: 36%" /></td>
					</tr>
					<tr>
						<th>1.4 发病日期： </th>
						<td>
							<tag:dateInput id="pathogenesisDate"  name="attackCondition.pathogenesisDate" onlypast="true" pattern="yyyy/MM/dd" style="width: 36%"
										   reg='{"compare":["firstVisitDate","le","发病时间不能大于初诊日期"]}' date="${caseDto.attackCondition.pathogenesisDate}"/>
						</td>
					</tr>
					 <tr>
				       	<th>1.5 常住类型：</th>
				       	<td>
				 		<ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005"
				           		value="${caseDto.generalCondition.floatPopulation}" onchange="caseEdit.toggerAddress()"/>
				       	</td>
			       </tr>
					<tr>
						<th>1.6 病例户口所在地：</th>
						<td colspan="3">
							<input type="text" id="hrAddress" name="generalCondition.hrAddress" value="${caseDto.generalCondition.hrAddress}"
	                           			reg='{"maxlength":"100"}'  style="width: 180px;">
			             </td>
					</tr>
					<tr>
			            <th>1.7 现住址：</th>
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
						<th>1.8 病例就诊医院：</th>
						<td>
							<ehr:dic-radio dicmeta="IDM00545" name="exposureHistory.hospitalUnit"
										   value="${caseDto.exposureHistory.hospitalUnit}" />
						</td>
					</tr>
					<tr>
			            <th>1.9 职业：</th>
			            <td>
			            	<ehr:dic-list dicmeta="IDM00633" name="generalCondition.occupation" width="180px;" value="${caseDto.generalCondition.occupation}" />
			            </td>
			         </tr>
					
					<tr>
						<th>1.10 病例报告单位： </th>
						<td>
							<ehr:org code="${caseDto.caseInformation.reportOrg}"/>
							<input type="hidden" value="${caseDto.caseInformation.reportOrg}" name="caseInformation.reportOrg">
						</td>
					</tr>
					<tr>
						<th>1.11 病例报告日期： </th>
						<td>
							<fmt:formatDate pattern="yyyy/MM/dd" value="${caseDto.caseInformation.reportDate}"/>
							<tag:dateInput  name="caseInformation.reportDate" onlypast="true" pattern="yyyy/MM/dd"
											date="${caseDto.caseInformation.reportDate}" style="display: none" />
						</td>
					</tr>
			
				</table>
			</fieldset>

			<fieldset>
				<legend>2. 临床表现 </legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 25%" />
						<col style="width: 75%" />
					</colgroup>
					<tr id="feverTr">
						<td colspan="2" style="padding: 0px;">
							<table>
								<colgroup>
									<col style="min-width: 80px; width: 25%" />
									<col style="min-width: 280px; width: 35%" />
									<col style="min-width: 160px; width: 15%" />
									<col style="min-width: 200px; width: 25%" />
								</colgroup>
								<tr>
									<th>2.1 发热 </th>
									<td>
										<ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.fever" code="1,2,4" value="${caseDto.clinicalManifestations.fever}"
										 onchange="toggleOther('clinicalManifestations.fever','temperature','1')"/>
								         <span id="temperature" style="display: none">
										 	体温：<input type="text" point="point" name="clinicalManifestations.temperature" value="${caseDto.clinicalManifestations.temperature}" 
											cssClass="width30" reg='{"maxlength":"20"}' style="width: 10%" />℃</span>
							         </td>
								</tr>
								<tr> 
									<th>2.2 疱疹</th>
									<td>
										<ehr:dic-radio name="clinicalManifestations.oralMucousUlcerHerpes" value="${caseDto.clinicalManifestations.oralMucousUlcerHerpes}"
										 dicmeta="PH00002" code="1,2,4" />		 
									</td>
								</tr>
								<tr>
					                <th>2.3 头痛 </th>
					                <td colspan="3"><ehr:dic-radio name="clinicalManifestations.headache" dicmeta="PH00002" code="1,2,4" value="${caseDto.clinicalManifestations.headache}"
					                                  /></td>
					            </tr>
					            <tr>
					                <th>2.4 咽痛 </th>
					                <td colspan="3">
										<ehr:dic-radio name="clinicalManifestations.soreThroat" value="${caseDto.clinicalManifestations.soreThroat}"
										 dicmeta="PH00002" code="1,2,4" />		 
									</td>
					            </tr>
					            <tr>
					                <th>2.5 瘙痒 </th>
					                <td colspan="3"><ehr:dic-radio name="clinicalManifestations.itchyEyes" value="${caseDto.clinicalManifestations.itchyEyes}"
										 dicmeta="PH00002" code="1,2,4" />	
									</td>
					            </tr>
					            <tr>
					                <th>2.6 恶心 </th>
					                <td colspan="3"><ehr:dic-radio name="clinicalManifestations.nausea" dicmeta="PH00002" code="1,2,4" value="${caseDto.clinicalManifestations.nausea}"/></td>
					            </tr>
					            <tr>
					                <th>2.7 呕吐 </th>
					                <td colspan="3"><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.vomit" code="1,2,4" value="${caseDto.clinicalManifestations.vomit}" /></td>
					            </tr>
					            <tr>
					                <th>2.8 腹痛 </th>
					                <td colspan="3"><ehr:dic-radio name="clinicalManifestations.stomachache" dicmeta="PH00002" code="1,2,4" value="${caseDto.clinicalManifestations.stomachache}"/></td>
					            </tr>
					            <tr>
					                <th>2.9 肺炎 </th>
					                 <td colspan="3"><ehr:dic-radio name="clinicalManifestations.pneumonia" dicmeta="PH00002" code="1,2,4" value="${caseDto.clinicalManifestations.pneumonia}"/></td>
					            </tr>
					            <tr>
					                <th>2.10 脑炎 </th>
					                <td colspan="3"><ehr:dic-radio name="clinicalManifestations.meningealIrritation" dicmeta="PH00002" code="1,2,4" value="${caseDto.clinicalManifestations.meningealIrritation}"/></td>
					            </tr>
					            <tr>
					                <th>2.11 其他继发感染</th>
					                <td colspan="3"><input type="text" name="clinicalManifestations.other" value="${caseDto.clinicalManifestations.other}" reg='{"maxlength":"50"}'/></td>
					            </tr>
							</table>
						</td>
					</tr>
				</table>
			</fieldset>

			<fieldset>
				<legend>3. 实验室检测 </legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 80px; width: 25%" />
						<col style="min-width: 640px; width: 75%" />
					</colgroup>
					<tr>
						<th>3.1 病人血标本采集：</th>
						<td><ehr:dic-radio name="labExamine.serumSpecimenF" value="${caseDto.labExamine.serumSpecimenF}" dicmeta="PH00002" code="1,2"
						    onchange="toggleOther('labExamine.serumSpecimenF','serumSpecimenDtF','1');toggleOther('labExamine.serumSpecimenF','serumSpecimenDtS','1')"/></td>
					<tr>
					<tr id="serumSpecimenDtF" style="display: none">
						<th>采集日期： </th>
						<td>
							<tag:dateInput name="labExamine.serumSpecimenDtF"  onlypast="true" pattern="yyyy/MM/dd"
								date="${caseDto.labExamine.serumSpecimenDtF}" style="width: 100px;"/>
						</td>
					<tr>	
					<tr id="serumSpecimenDtS" style="display: none">
						<th>恢复期采集日期： </th>
						<td>
							<tag:dateInput name="labExamine.serumSpecimenDtS"  onlypast="true" pattern="yyyy/MM/dd"
								date="${caseDto.labExamine.serumSpecimenDtS}" style="width: 100px;"/>
						</td>
					</tr>
					<tr>
						<th>3.2 水痘特异性IgM抗体：</th>
						<td><ehr:dic-radio name="labExamine.measlesIgm" value="${caseDto.labExamine.measlesIgm}" dicmeta="PH00004" code="1,2"/></td>					
					</tr>
					<tr>
						<th>水痘特异性IgG抗体4倍增高：</th>
						<td colspan="3">
			                <ehr:dic-radio name="labExamine.mzIgg" dicmeta="IDM00563" uninclude="9" value="${caseDto.labExamine.mzIgg}"/>
			            </td>
					</tr>
					<tr>
						<th>3.3 病人病原学本采集：</th>
						<td><ehr:dic-radio name="labExamine.etiologySpecimens" value="${caseDto.labExamine.etiologySpecimens}" dicmeta="PH00002" code="1,2"
						        onchange="toggleOther('labExamine.etiologySpecimens','stoolCollecttimeOne','1')"/>
							<%-- <span id=stoolCollecttimeOne style="display: none"><tag:dateInput name="labExamine.stoolCollecttimeOne"  onlypast="true" pattern="yyyy/MM/dd"
								date="${caseDto.labExamine.stoolCollecttimeOne}" style="width: 100px;"/></span>		--%>		
						</td>
					<tr>
					<tr>
						<th>3.4 病人病毒分离结果： </th>
						<td>
							<ehr:dic-radio name="labExamine.jeViralIsolationResult" value="${caseDto.labExamine.jeViralIsolationResult}" dicmeta="PH00004" code="1,2"/></td>					
					</tr>					
				</table>
			</fieldset>
			<fieldset>
				<legend>4. 流行病学资料（调查发病前3周内情况） </legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 80px; width: 25%" />
						<col style="min-width: 640px; width: 32%" />
						<col style="min-width: 80px; width: 13%" />
						<col style="min-width: 640px; width: 30%" />
					</colgroup>
					<tr>
						<th>4.1 当地有无同样病例发生 </th>
						<td>
							<ehr:dic-radio name="epidemiologicalSurvey.localtionScarlatina" value="${caseDto.epidemiologicalSurvey.localtionScarlatina}" dicmeta="PH00002" code="1,2"/>
						</td>
					<tr>
					<tr>
						<th>4.2 发病前3周与水痘确诊或疑似病例有无接触 </th>
						<td>
							<ehr:dic-radio name="epidemiologicalSurvey.contactHistory" dicmeta="PH00002" 
								onchange="toggleOther('epidemiologicalSurvey.contactHistory','divContactHistory','1')" value="${caseDto.epidemiologicalSurvey.contactHistory}" code="1,2" />  
							    
						</td>
					<tr>
					<tr id="divContactHistory" style="display:none;">
						<th>4.3 如有接触，接触方式 </th>
						<td>
							<ehr:dic-radio name="epidemiologicalSurvey.contactRelation" dicmeta="IDM00544" 
							 value="${caseDto.epidemiologicalSurvey.contactRelation}"/>	
						</td>
					<tr>				
					<tr>
						<th>4.4 家庭内有无同样的病人 </th>
						<td><ehr:dic-radio name="epidemiologicalSurvey.homeContactPatients" dicmeta="PH00002"  value="${caseDto.epidemiologicalSurvey.homeContactPatients}" code="1,2,4" />  </td>
					</tr>
					<tr>
						<th>4.5 如家庭内有同样的病人，填写下表 </th>
						<td colspan="3">
			            	<div id="varicellaContactList">
			            		<jsp:include page="varicellaContactList.jsp"></jsp:include>
			            	</div>
			            </td>
					</tr>
					<tr>
						<th>4.6 是否接种过水痘疫苗：</th>
						<td>
							<ehr:dic-radio name="epidemiologicalSurvey.inoculateHistory" value="${caseDto.epidemiologicalSurvey.inoculateHistory}" dicmeta="IDM00013" code="1,2,3"
							     onchange="toggleOther('epidemiologicalSurvey.inoculateHistory','diphtheritisVaccineF','2');toggleOther('epidemiologicalSurvey.inoculateHistory','diphtheritisVaccineS','2')"/>
					    </td>
					</tr>
					<tr id="diphtheritisVaccineF" style="display: none">
			            <th>疫苗名称1</th>
			            <td><input type="text" name="epidemiologicalSurvey.diphtheritisVaccineF" value="${caseDto.epidemiologicalSurvey.diphtheritisVaccineF}" reg='{"maxlength":"100"}'/></td>
			            <th>接种时间1</th>
			            <td><tag:dateInput id="rvInoculateDt"  name="epidemiologicalSurvey.rvInoculateDt" onlypast="true" pattern="yyyy/MM/dd"
									 date="${caseDto.epidemiologicalSurvey.rvInoculateDt}"/></td>
			        </tr>
			        <tr id="diphtheritisVaccineS" style="display: none">
			            <th>疫苗名称2</th>
			            <td><input type="text" name="epidemiologicalSurvey.diphtheritisVaccineS" value="${caseDto.epidemiologicalSurvey.diphtheritisVaccineS}" reg='{"maxlength":"100"}'/></td>
			            <th>接种时间2</th>
			            <td><tag:dateInput id="rvLastInoculateDt"  name="epidemiologicalSurvey.rvLastInoculateDt" onlypast="true" pattern="yyyy/MM/dd"
									 date="${caseDto.epidemiologicalSurvey.rvLastInoculateDt}"/></td>
			        </tr>
					<tr>
						<th>4.7 病人隔离：</th>
						<td>
                            <ehr:dic-radio name="epidemicFocusClose.isPatientIsolation" value="${caseDto.epidemicFocusClose.isPatientIsolation}"  dicmeta="PH00002" code="1,2"
								onchange="toggleOther('epidemicFocusClose.isPatientIsolation','isPatientIsolationDiv',1);"/>
                        </td>
					</tr>
					<tr id="isPatientIsolationDiv" style="display: none">
						<th>如果是，隔离地点 </th>
						<td>
				             <ehr:dic-radio name="epidemicFocusClose.isolationPlace" value="${caseDto.epidemicFocusClose.isolationPlace}"  dicmeta="IDM00543" />
				       </td>
				    </tr>
					<tr>
						<th>4.8 隔离开始时间： </th>
						<td>
			                <tag:dateInput name="epidemicFocusClose.quarantineBeginDate" id="quarantineBeginDate" onlypast="true" pattern="yyyy/MM/dd"
		             			 date="${caseDto.epidemicFocusClose.quarantineBeginDate}" style="width: 200px;" reg='{"compare":["quarantineEndDate","le","隔离结束时间不能小于隔离开始时间"]}'/>
		             	</td>
		             	<th>隔离结束时间： </th>
						<td>
			            	 <tag:dateInput name="epidemicFocusClose.quarantineEndDate" id="quarantineEndDate" onlypast="true" pattern="yyyy/MM/dd"
		             			 date="${caseDto.epidemicFocusClose.quarantineEndDate}" style="width: 200px;" reg='{"compare":["quarantineBeginDate","ge","隔离开始时间不能大于隔离结束时间"]}'/>
			            </td>
					</tr>
					<tr>
						<th>4.9 与患者密切接触者的人数： </th>
						<td>
							<input type="text" name="epidemicFocusClose.contactsNum" value="${caseDto.epidemicFocusClose.contactsNum}"
                                       reg='{"maxlength":"20"}'  style="width: 100px;"/>人
						</td>
					</tr>
					<tr>
						<th>根据密切接触者的情况，填写下表 </th>
						<td colspan="3">
                            <div id="pertussisContactedList">
								<jsp:include page="varicellaContactedList.jsp"></jsp:include>
                            </div>							
						</td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>5. 疫情性质</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 80px; width: 15%" />
						<col style="min-width: 280px; width: 35%" />
						<col style="min-width: 80px; width: 15%" />
						<col style="min-width: 280px; width: 35%" />
					</colgroup>
					 <tr>
		                <th>疫情性质：</th>
		                <td ><ehr:dic-radio name="otherCondition.caseEpidemic" dicmeta="IDM00634" code="1,2,3"
		                                    value="${caseDto.otherCondition.caseEpidemic}"/>
		                </td>
		            </tr>
				</table>
			</fieldset>
			<fieldset>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 80px; width: 15%" />
						<col style="min-width: 280px; width: 35%" />
						<col style="min-width: 80px; width: 15%" />
						<col style="min-width: 280px; width: 35%" />
					</colgroup>
					<tr>
						<th>调查者单位：</th>
						<td>
                            <ehr:org  code="${caseDto.caseInformation.modifySurveyOrg}"></ehr:org>
                            <input type="hidden" name="caseInformation.modifySurveyOrg" value="${caseDto.caseInformation.modifySurveyOrg}"/>
                        </td>
						<th>调查者：</th>
						<td><ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/>
						 <input type="hidden" name="caseInformation.modifyRespondents" value="${caseDto.caseInformation.modifyRespondents}"/></td>
					 </tr>
					 <tr>
						<th>调查日期：</th>
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

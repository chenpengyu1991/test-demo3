<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/diphtheria.js" type="text/javascript"></script>

<c:if test="${isPrint != 1}">
    <jsp:include page="../caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
	<input type="hidden" id="idmId" name="idmId" value="${idmId}"/>
	<input type="hidden" name="leList" id="leList">
	<input type="hidden" name="esList" id="esList"/>
    <input type="hidden" name="efcList" id="efcList"/>
    <div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
		<i class="popno">
		    白喉个案调查表<br/>
		    <span>（乙类传染病）</span>
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
	
		<div class="postdiv">
			<fieldset>
			    <legend>一、一般情况</legend>
			    <table class="posttable">
			        <colgroup>
			            <col style="width: 20%"/>
			            <col style="width: 30%"/>
			            <col style="width: 20%"/>
			            <col style="width: 30%"/>
			        </colgroup>
			        <tr>
			           <%--  <th>1、编号：</th>
			            <td><input type="text" name="caseInformation.mediRecordNum" reg='{"length":"7"}' value="${caseDto.caseInformation.mediRecordNum}"/></td> --%>
			            <th>姓名：</th>
			            <td>
			            	<input type="text" name="generalCondition.name" value="${caseDto.generalCondition.name}" style="width:180px;"
			            		reg='{"maxlength":"100"}'/>
			            </td>
			        </tr>
			        <tr>
			            <th>性别：</th>
			           <td>
			           		<ehr:dic-radio dicmeta="GBT226112003" name="generalCondition.gender" code="1,2" value="${caseDto.generalCondition.gender}"/>
			           </td>
			            <th>出生日期：</th>
			            <td>
			            	<tag:dateInput id="birthday" name="generalCondition.birthday" date="${caseDto.generalCondition.birthday}" style="width: 36%"/>
				          </td>
			        </tr>
			        <tr>
			            <th>年龄：</th>
			            <td colspan="3">
			               <tag:numberInput id="age" name="generalCondition.age" value="${caseDto.generalCondition.age}" 
				            	maxlength="3" cssClass="width30" style="width:180px;"/>
				            	<ehr:dic-radio id="ageUnit" name="generalCondition.ageUnit"  dicmeta="IDM00003" value="${caseDto.generalCondition.ageUnit}"/>
			            </td>
			        </tr>
			        <tr>
			        	<th>发病日期：</th>
						<td><tag:dateInput name="AttackCondition.pathogenesisDate" date="${caseDto.attackCondition.pathogenesisDate }"  onlypast="true" style="width:180px;" pattern="yyyy/MM/dd"/></td>
			        </tr>
			        <tr>
				       	<th>常住类型：</th>
				       	<td>
				 		<ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005"
				           		value="${caseDto.generalCondition.floatPopulation}" onchange="caseEdit.toggerAddress()"/>
				       	</td>
			       </tr>
					<tr>
						<th>户籍地址：</th>
						<td colspan="3">
			                  <input type="text" name="generalCondition.hrAddress" id="hrAddress" value="${caseDto.generalCondition.hrAddress}"
			                         style="width: 180px;" reg='{"maxlength":"100"}'>
			             </td>
					</tr>
			        <tr>
			            <th>现住址：</th>
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
		                <th>病例户口类型：</th>
		                <td colspan="3">
		                    <ehr:dic-radio name="generalCondition.patientAttribute" dicmeta="CV0201104" value="${caseDto.generalCondition.patientAttribute}"
		                            code="1,3,4"/>
		                </td>
		            </tr>
			        <tr>
			            <th>工作单位或就读幼儿园、学校：</th>
			            <td> <input reg='{"maxlength":"70"}' type="text" name="generalCondition.unitName" value="${caseDto.generalCondition.unitName}" style="width:180px;"/></td>
			            <th>电话：</th>
			            <td><input type="text" name="generalCondition.mobile" value="${caseDto.generalCondition.mobile}" reg='{"regex":"phone","maxlength":20}' style="width:180px;"/></td>
			        </tr>
			        <tr>
			            <th>家长姓名（儿童和学生病例填写）：</th>
			            <td><input type="text" id="parentsName" name="generalCondition.parentsName" value="${caseDto.generalCondition.parentsName}" style="width:180px;"
			                                   reg='{"maxlength":"50"}'/></td>
			            <th>家庭电话：</th>
			            <td><input type="text" name="generalCondition.familyPhone" value="${caseDto.generalCondition.familyPhone}" reg='{"regex":"phone","maxlength":20}' style="width:180px;"/></td>
			        </tr>
			        <tr>
			            <th>病例就诊医院：</th>
			            <td><ehr:dic-radio name="clinicalManifestations.hospitalType" dicmeta="IDM00545"
				           		value="${caseDto.clinicalManifestations.hospitalType}" /></td>
			                                  
			        </tr>
			        <tr>
			            <th>病例报告单位：</th>
			            <td><ehr:org  code="${caseDto.caseInformation.reportOrg}"></ehr:org>
			           		 <input type="hidden" name="caseInformation.reportOrg" value="${caseDto.caseInformation.reportOrg}"/> 
			            </td>
			                    
			        </tr>
			         <tr>
			            <th>病例报告日期：</th>
			            <td>
							<fmt:formatDate value='${caseDto.caseInformation.reportDate}' pattern="yyyy/MM/dd" />
                            <tag:dateInput  name="caseInformation.reportDate" onlypast="true" pattern="yyyy/MM/dd"
                                               date="${caseDto.caseInformation.reportDate}" style="display: none" />
						</td>
			        </tr>
			    </table>
			</fieldset>
			<fieldset>
			    <legend>二、临床症状和体征</legend>
			    <table class="posttable">
			        <colgroup>
			            <col style="width: 20%"/>
			            <col style="width: 80%"/>
			        </colgroup>
			        <tr>
		                <th><label>发热</label>：</th>
		                <td><ehr:dic-radio name="clinicalManifestations.fever" dicmeta="PH00002" code="1,2,4" value="${caseDto.clinicalManifestations.fever}"
		                                   onchange="toggleOther('clinicalManifestations.fever','feverLimits',1);"/></td>
		            </tr>
		            <tr id="feverLimits" style="display: none">
		                <th><label>体温</label>：</th>
		                <td><input type="text" name="clinicalManifestations.feverLimits" value="${caseDto.clinicalManifestations.feverLimits}" style="width: 100px;" reg='{"maxlength":"10"}'/>℃
		            </tr>
		            <tr>
		                <th><label>咽痛</label>：</th>
		                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.soreThroat" code="1,2,4"  
		                                   value="${caseDto.clinicalManifestations.soreThroat}"/></td>
		            </tr>
		            <tr>
		                <th><label>声嘶</label>：</th>
		                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.hoarseness" code="1,2,4"  
		                                   value="${caseDto.clinicalManifestations.hoarseness}"/></td>
		            </tr>
		              <tr>
		                <th><label>鼻咽部有不易剥落的灰白色假膜</label>：</th>
		                <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.grayPseudome" code="1,2,4"  
		                                   value="${caseDto.clinicalManifestations.grayPseudome}"/></td>
		            </tr>
		            <tr>
		                <th><label>临床类型</label>：</th>
		                <td><ehr:dic-radio dicmeta="IDM00613" name="clinicalManifestations.clinicalTypeLevel" value="${caseDto.clinicalManifestations.clinicalTypeLevel}" 
		                				  onchange="toggleOther('clinicalManifestations.clinicalTypeLevel','clinicalTypeLevel',5);toggleOther('clinicalManifestations.clinicalTypeLevel','other',99);"/>
               				  <span id="other" style="display: none">
               				  	  <input type="text" name="clinicalManifestations.other" value="${caseDto.clinicalManifestations.other}" reg='{"maxlength":"10"}' style="width:100px;"/>
               				  </span>
	                	 </td>
		            </tr>
		             <tr id="clinicalTypeLevel" style="display: none">
		                <th><label class="required">名称</label>：</th>
		                <td><input type="text" name="clinicalManifestations.complications" value="${caseDto.clinicalManifestations.complications}" reg='{"maxlength":"10"}' style="width:100px;"/>
		            </tr>
		            
		             <tr>
		                <th><label>病情转归</label>：</th>
		                <td><%-- <ehr:dic-radio dicmeta="IDM00005" name="clinicalManifestations.outcome" code="2,1,4,3,6,7"  
		                                   value="${caseDto.clinicalManifestations.outcome}" onchange="toggleOther('clinicalManifestations.outcome','deathTime',4);toggleOther('clinicalManifestations.outcome','sequelaeName',7);"/>
		                              --%>
                              <ehr:dic-radio dicmeta="IDM00005" name="clinicalManifestations.outcome" code="2,1,4,3,6,7"  
                                   value="${caseDto.clinicalManifestations.outcome}" onchange="toggleOther('clinicalManifestations.outcome','sequelaeName',7);"/>
                             
                            <span id="sequelaeName" style="display: none">
                                	  名称：<input type="text" name="attackCondition.sequelaeName" value="${caseDto.attackCondition.sequelaeName}"
                                       reg='{"maxlength":"100"}' style="width: 150px;"/>
                            </span>
		                                   </td>
		            </tr>
		             <%-- <tr style="display: none;" id="deathTime">
			            <th><label>死亡时间</label>：</th>
			            <td>
			             <tag:dateInput id="inhosDateId" name="attackCondition.dieDt" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.dieDt}" onlypast="true" style="width: 100px"></tag:dateInput>   
			            </td>
			        </tr> --%>
			        <tr>
			            <th><label>死亡时间</label>：</th>
			            <td>
			             <tag:dateInput id="inhosDateId" name="attackCondition.dieDt" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.dieDt}" onlypast="true" style="width: 100px"></tag:dateInput>   
			            </td>
			        </tr>

			    </table>
			</fieldset>
			<fieldset>
				<legend>三、实验室资料</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 80px; width: 25%" />
						<col style="min-width: 640px; width: 75%" />
					</colgroup>
					<tr>
						<th>1.病人咽拭子采集：</th>
						<td>
							<ehr:dic-radio name="labExamine.nasopharyngealSwab" value="${caseDto.labExamine.nasopharyngealSwab}" dicmeta="PH00002" code="1,2"/>
						</td>
					<tr>
					<tr>
						<th>2.采集日期：</th>
						<td>
							<tag:dateInput name="labExamine.nasopharyngealSwabDate"  onlypast="true" pattern="yyyy/MM/dd"
								date="${caseDto.labExamine.nasopharyngealSwabDate}" style="width: 100px;"/>
						</td>
					<tr>	
					<tr>
						<th>3.病人血标本采集：</th>
						<td><ehr:dic-radio name="labExamine.serumSpecimenF" value="${caseDto.labExamine.serumSpecimenF}" dicmeta="PH00002" code="1,2"/></td>
					</tr>
					<tr>
						<th>4.标本白喉杆菌：</th>
						<td><ehr:dic-radio name="labExamine.pertussis" value="${caseDto.labExamine.pertussis}" dicmeta="PH00004" code="1,2"/></td>					
					</tr>
					<tr>
						<th>5.血清白喉抗体：</th>
						<td><ehr:dic-radio name="labExamine.pairedSeraType" value="${caseDto.labExamine.pairedSeraType}" dicmeta="IDM00541"/></td>	
					</tr>					
				</table>
			</fieldset>
			<fieldset>
				<legend>四、流行病学资料（调查生病前7天内情况）</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 80px; width: 25%" />
						<col style="min-width: 640px; width: 75%" />
					</colgroup>
					<tr>
						<th>1.当地有无同样病例发生：</th>
						<td>
							<ehr:dic-radio name="epidemiologicalSurvey.localtionScarlatina" value="${caseDto.epidemiologicalSurvey.localtionScarlatina}" dicmeta="PH00002" code="1,2"/>
						</td>
					<tr>
					<tr>
						<th>2.与同样病例有无接触：</th>
						<td>
							<ehr:dic-radio name="epidemiologicalSurvey.contactHistory" dicmeta="PH00002" 
								onchange="toggleOther('epidemiologicalSurvey.contactHistory','divContactHistory','1')" value="${caseDto.epidemiologicalSurvey.contactHistory}" code="1,2" />  
							<%-- <div id="divContactHistory">
								<div>
									<span>3.接触方式:</span>	
					           		<ehr:dic-radio name="epidemiologicalSurvey.contactRelation" dicmeta="IDM00057" 
										onchange="toggleOther('epidemiologicalSurvey.contactRelation','contactRelationOtherId','99')" value="${caseDto.epidemiologicalSurvey.contactRelation}" code="1,2,3,4,5,6,7,99" />
									<input type="text" id="contactRelationOtherId" name="epidemiologicalSurvey.contactRelationOther" value="${caseDto.epidemiologicalSurvey.contactRelationOther}" 
										reg='{"maxlength":"20"}' style="width:120px"/>
								</div>					
							</div>   --%>        
						</td>
					<tr>
					<tr id="divContactHistory" style="display:none;">
						<th>3.接触方式：</th>
						<td>
							<ehr:dic-radio name="epidemiologicalSurvey.contactRelation" dicmeta="IDM00544" 
										onchange="toggleOther('epidemiologicalSurvey.contactRelation','contactRelationOtherId','99')" value="${caseDto.epidemiologicalSurvey.contactRelation}" code="1,2,3,4,99" />
									<span id="contactRelationOtherId" style="display:none;"><input type="text"  name="epidemiologicalSurvey.contactRelationOther" value="${caseDto.epidemiologicalSurvey.contactRelationOther}" 
										reg='{"maxlength":"20"}' style="width:120px"/></span>
							
						</td>
					<tr>				
					<tr>
						<th>4.家庭内同样的病人：</th>
						<td><ehr:dic-radio name="epidemiologicalSurvey.homeContactPatients" dicmeta="PH00002"  value="${caseDto.epidemiologicalSurvey.homeContactPatients}" code="1,2" />  </td>
					</tr>
					<tr>
						<th>5.如家庭内有同样的病人，填写下表：</th>
						<td colspan="3">
			            	<div id="contactList">
			            		<jsp:include page="contactList.jsp"></jsp:include>
			            	</div>
			            </td>
					</tr>
					<tr>
						<th>6.百白破联合疫苗接种史：</th>
						<td>
							<ehr:dic-radio name="epidemiologicalSurvey.inoculateHistory" value="${caseDto.epidemiologicalSurvey.inoculateHistory}" dicmeta="IDM00013" code="2,3"
								onchange="toggleOther('epidemiologicalSurvey.inoculateHistory','inoculateHistoryDiv',2);"/>
								<span  id="inoculateHistoryDiv" style="display: none">
									<input type="text" name="epidemiologicalSurvey.inoculateNum" value="${caseDto.epidemiologicalSurvey.inoculateNum}"
								 		reg='{"maxlength":"20"}' cssClass="width30"  style="width:5%"/>次
								 </span>
					    </td>
					</tr>
					<tr>
						<th>7.最后一次接种时间：</th>
						 <td><tag:dateInput id="firstVisitDate" nullToToday="true" name="epidemiologicalSurvey.lastInoculateDt" onlypast="true" pattern="yyyy/MM/dd"
					      date="${caseDto.epidemiologicalSurvey.lastInoculateDt}" style="width: 200px;"/></td>
					</tr>
					<tr>
						<th>8.接种依据：</th>
						<td>
							<ehr:dic-radio name="epidemiologicalSurvey.vaccinationReason" value="${caseDto.epidemiologicalSurvey.vaccinationReason}" dicmeta="IDM00069" code="1,2,6"/>
					    </td>
					</tr>
					<tr>
						<th>9.发病前2天或病后去过何地：</th>
						<td>
							<ehr:dic-radio name="epidemicFocusClose.isGoPlace" value="${caseDto.epidemicFocusClose.isGoPlace}" dicmeta="IDM00542" 
								onchange="toggleOther('epidemicFocusClose.isGoPlace','isGoPlaceDiv',99);"/>
			            	<span  id="isGoPlaceDiv" style="display: none">
                                <input type="text" name="epidemicFocusClose.pubPlaNameAddr" value="${caseDto.epidemicFocusClose.pubPlaNameAddr}"
                                       reg='{"maxlength":"50"}'  style="width: 200px;"/>
                            </span>
			            </td>
					</tr>
					<tr>
						<th>10.病人隔离：</th>
						<td>
                            <ehr:dic-radio name="epidemicFocusClose.isPatientIsolation" value="${caseDto.epidemicFocusClose.isPatientIsolation}"  dicmeta="PH00002" code="1,2"
								onchange="toggleOther('epidemicFocusClose.isPatientIsolation','isPatientIsolationDiv',1);"/>
                        </td>
					</tr>
					<tr id="isPatientIsolationDiv" style="display: none">
						<th>11.如隔离，隔离地点：</th>
						<td colspan="3">
				             <ehr:dic-radio name="epidemicFocusClose.isolationPlace" value="${caseDto.epidemicFocusClose.isolationPlace}"  dicmeta="IDM00543"
											onchange="toggleOther('epidemicFocusClose.isolationPlace','placeDetail',99);"/>
							<span id="placeDetail">
								<input type="text" name="epidemicFocusClose.placeDetail" value="${caseDto.epidemicFocusClose.placeDetail}"
									   reg='{"maxlength":"100"}'  style="width: 100px;"/>
							</span>
				       </td>
				    </tr>
					<tr>
						<th>12.隔离开始时间：</th>
						<td>
			                <tag:dateInput name="epidemicFocusClose.quarantineBeginDate" onlypast="true" pattern="yyyy/MM/dd"
		             			 date="${caseDto.epidemicFocusClose.quarantineBeginDate}" style="width: 200px;"/>
		             	</td>
					</tr>
					<tr>
						<th>13.隔离结束时间：</th>
						<td>
			            	 <tag:dateInput name="epidemicFocusClose.quarantineEndDate" onlypast="true" pattern="yyyy/MM/dd"
		             			 date="${caseDto.epidemicFocusClose.quarantineEndDate}" style="width: 200px;"/>
			            </td>
					</tr>
					<tr>
						<th>14.患者密切接触者的人数：</th>
						<td>
							<input type="text" name="epidemicFocusClose.contactsNum" value="${caseDto.epidemicFocusClose.contactsNum}"
                                       reg='{"maxlength":"20"}'  style="width: 100px;"/>人
						</td>
					</tr>
					<tr>
						<th>15.根据密切接触者的情况，填下表：</th>
						<td colspan="3">
                            <div id="contactedList">
								<jsp:include page="contactedList.jsp"></jsp:include>
                            </div>							
						</td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>五、小结</legend>
				<table class="posttable">
					<tr>
						<td>
							<textarea name="otherCondition.surveySummary" style="width: 100%" rows="5" reg='{"maxlength":"400"}'>${caseDto.otherCondition.surveySummary}</textarea>
						</td>
					</tr>
				</table>
			</fieldset>
			<%-- <fieldset>
			    <legend>六、病例分类</legend>
			    <table class="posttable">
			        <tr>
			            <td><ehr:dic-radio name="otherCondition.caseType" dicmeta="IDM00040" code="1,2,3,5" value="${caseDto.otherCondition.caseType }"/></td>
			        </tr>
			    </table>
			</fieldset> --%>
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
                        </td>
						<th>调查者：</th>
						<td><ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/></td>
					 </tr>
					 <tr>
						<th>审查者：</th>
						<td><ehr:user userCode="${caseDto.caseInformation.auditor}"/></td>
						<th>调查日期：</th>
						<td>
                        	 <tag:dateInput nullToToday="true" name="caseInformation.modifySurveyDate" onlypast="true"
	                               pattern="yyyy/MM/dd" date="${caseDto.caseInformation.modifySurveyDate}"/>
	                    </td>
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

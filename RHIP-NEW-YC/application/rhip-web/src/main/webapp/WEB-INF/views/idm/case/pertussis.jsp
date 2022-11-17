<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/pertussis.js" type="text/javascript"></script>
<!-- <script type="text/javascript">
    require(['views/idm/case/pertussis'],function(pertussis){
    	pertussis.load();
    });
</script> -->
<c:if test="${isPrint != 1}">
    <jsp:include page="caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
	<input type="hidden" id="idmId" name="idmId" value="${idmId}"/>
	<input type="hidden" name="esList" id="esList"/>
    <input type="hidden" name="efcList" id="efcList"/>
    <div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
		<i class="popno">
			百日咳个案调查表<br />
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
				<legend>一. 一般情况</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 80px; width: 25%" />
						<col style="min-width: 280px; width: 35%" />
						<col style="min-width: 160px; width: 15%" />
						<col style="min-width: 200px; width: 25%" />
					</colgroup>
					<tr>
						<th>1.患者姓名：</th>
						<td>
			            	<input type="text" name="generalCondition.name" value="${caseDto.generalCondition.name}" reg='{"maxlength":"100"}' style="width: 36%"/>
			            </td>
						<th>2.性别：</th>
						<td>
			            	<ehr:dic-radio  dicmeta="GBT226112003" name="generalCondition.gender" code="1,2" value="${caseDto.generalCondition.gender}"/>
			            </td>
					</tr>
					<tr>
						<th>3.出生日期：</th>
						<td><tag:dateInput id="birthday" name="generalCondition.birthday" date="${caseDto.generalCondition.birthday}" style="width: 36%" /></td>
						<th>年龄：</th>
						<td>
							<input type="text" id="age" name="generalCondition.age" value="${caseDto.generalCondition.age}" 
				            	reg='{"maxlength":"6"}' cssClass="width30" style="width: 20%"/>
				            	 <ehr:dic-radio id="ageUnit" name="generalCondition.ageUnit"  dicmeta="IDM00003" value="${caseDto.generalCondition.ageUnit}"/>
						</td>
					</tr>
					<tr>
						<th>4.发病日期：</th>
						<td>
							<tag:dateInput id="pathogenesisDate"  name="attackCondition.pathogenesisDate" onlypast="true" pattern="yyyy/MM/dd" style="width: 36%" 
										   reg='{"compare":["firstVisitDate","le","发病时间不能大于初诊日期"]}' date="${caseDto.attackCondition.pathogenesisDate}"/>
						</td>
					</tr>
					<tr>
						<th>5.家长姓名：</th>
						<td><input type="text" id="parentsName" name="generalCondition.parentsName" value="${caseDto.generalCondition.parentsName}"
                                   reg='{"maxlength":"50"}' style="width: 36%"/></td>
						<%--<th>联系电话：</th>
						<td>
			            	 <input type="text" name="generalCondition.phoneNumber" value="${caseDto.generalCondition.phoneNumber}" 
			            	 reg='{"regex":"phone","maxlength":20}' style="width: 36%"/>
			           	</td>--%>
					</tr>
					<tr>
                    	<th>6.常住类型：</th>
                    	<td>
		            		<ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005"
                        		value="${caseDto.generalCondition.floatPopulation}" />
                    	</td>
                    </tr>
					<tr>
						<th>7.家庭住址：</th>
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
						<th>8.病例就诊医院：</th>
						<td>
							<ehr:dic-radio dicmeta="IDM00004" name="exposureHistory.hospitalUnit"
										   value="${caseDto.exposureHistory.hospitalUnit}" />
						</td>
					</tr>
					<tr>
						<th>9.报告单位：</th>
						<td>
							<ehr:org code="${caseDto.caseInformation.reportOrg}"/>
							<input type="hidden" value="${caseDto.caseInformation.reportOrg}" name="caseInformation.reportOrg">
						</td>
					</tr>
					<tr>
						<%--<th>8.确诊日期：</th>
						<td>
							<tag:dateInput id="confirmationDate"  name="attackCondition.confirmationDate" onlypast="true" pattern="yyyy/MM/dd"
										   reg='{"compare":["firstVisitDate","ge","确诊时间不能小于初诊时间"]}' date="${caseDto.attackCondition.confirmationDate}" />
						</td>--%>
						<th>10.报告日期：</th>
						<td>
							<fmt:formatDate pattern="yyyy/MM/dd" value="${caseDto.caseInformation.reportDate}"/>
							<tag:dateInput  name="caseInformation.reportDate" onlypast="true" pattern="yyyy/MM/dd"
											date="${caseDto.caseInformation.reportDate}" style="display: none" />
						</td>
					</tr>
					<%--<tr>
						<th>5.居住状况：</th>
						<td colspan="3">
							<ehr:dic-radio name="generalCondition.livingConditions" dicmeta="IDM00212" value="${caseDto.generalCondition.livingConditions }"
								/>
							<input type="text" id="livingConditionsOther" name="generalCondition.livingConditionsOther" value="${caseDto.generalCondition.livingConditionsOther}"
								style="width:30%;"  reg='{"maxlength":100}'/>
						</td>
					</tr>
					<tr>
                        <th>托幼机构或学校名称和地址：</th>
                        <td colspan="3">
                            <input type="text" name="generalCondition.unitName" value="${caseDto.generalCondition.unitName }" reg='{"maxlength":70}' />
                        </td>
					</tr>
					<tr>
						<th>6.发病日期：</th>
						<td>
					    	<tag:dateInput id="pathogenesisDate"  name="attackCondition.pathogenesisDate" onlypast="true" pattern="yyyy/MM/dd" 
					    	 reg='{"compare":["firstVisitDate","le","发病时间不能大于初诊日期"]}' date="${caseDto.attackCondition.pathogenesisDate}"/>
					    </td>
						<th>7.初诊日期：</th>
						 <td><tag:dateInput id="firstVisitDate"  name="attackCondition.firstVisitDate" onlypast="true" pattern="yyyy/MM/dd"
					     reg='{"compare":["pathogenesisDate","ge","初诊时间不能小于发病日期"]}' date="${caseDto.attackCondition.firstVisitDate}"/></td>
					</tr>


					<tr>
						<th>11.住院日期：</th>
						<td>
				           <tag:dateInput id="inhosTime"  name="otherCondition.inhosTime" onlypast="true" pattern="yyyy/MM/dd"
				            	reg='{"compare":["pathogenesisDate","ge","住院时间不能小于发病日期"]}' date="${caseDto.otherCondition.inhosTime}"/>
				       </td>
						<th>出院日期：</th>
						<td>
			                <tag:dateInput  name="otherCondition.outhosDate" onlypast="true" pattern="yyyy/MM/dd"
		             			reg='{"compare":["inhosTime","ge","出院时间不能小于 住院时间"]}' date="${caseDto.otherCondition.outhosDate}"/>
		             	</td>
					</tr>
					<tr>
						<th>12.住院医院：</th>
						<td>
			            	<input reg='{"maxlength":"100"}' type="text" name="attackCondition.admissionHospital" value="${caseDto.attackCondition.admissionHospital}"/>
			            </td>
					</tr>
					<tr>
						<th>14.既往史：</th>
						<td colspan="3">
							<ehr:dic-radio name="pastHistory.previousHistory" value="${caseDto.pastHistory.previousHistory }" dicmeta="PH00002" code="1,2"
								/>
							<span id="previousType">
								<ehr:dic-radio name="pastHistory.previousType" value="${caseDto.pastHistory.previousType }" dicmeta="IDM00184"
								 	/>
								 <span id="previousOther">
									<input type="text" name="pastHistory.previousOther" value="${caseDto.pastHistory.previousOther }" reg='{"maxlength":"100"}' style="width: 30%"/>
								</span>
							</span>
                        </td>
					</tr>--%>
				</table>
			</fieldset>

			<fieldset>
				<legend>二. 主要临床表现</legend>
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
									<th>1.主要症状:发热：</th>
									<td>
										<ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.fever" code="1,2,4" value="${caseDto.clinicalManifestations.fever}"
								         />
							         </td>
									<th>体温：</th>
									<td>
										<input type="text" point="point" name="clinicalManifestations.temperature" value="${caseDto.clinicalManifestations.temperature}" 
											cssClass="width30" reg='{"maxlength":"20"}' style="width: 10%" />℃
									</td>
								</tr>
								<tr>
									<th>痉挛性咳嗽：</th>
									<td>
										<ehr:dic-radio name="clinicalManifestations.expectoration" value="${caseDto.clinicalManifestations.expectoration}"
										 dicmeta="PH00002" code="1,2,4" onchange="toggleOther('clinicalManifestations.expectoration','rashDays',1)"/>
										 <span id="rashDays">
										 	持续:<input type="text" point="point" name="clinicalManifestations.rashDays" value="${caseDto.clinicalManifestations.rashDays}" 
												cssClass="width30" reg='{"maxlength":"20"}' style="width: 10%" />天</span>
									</td>
									<%--<th>鸡鸣声：</th>
									<td><ehr:dic-radio name="clinicalManifestations.crow" value="${caseDto.clinicalManifestations.crow}" dicmeta="PH00002" code="1,2"/></td>--%>
								</tr>
								<%--<tr>
									<th>面红：</th>
									<td><ehr:dic-radio name="clinicalManifestations.blush" dicmeta="PH00002" value="${caseDto.clinicalManifestations.blush}" code="1,2"/></td>
									<th>出汗：</th>
									<td><ehr:dic-radio name="clinicalManifestations.sweat" dicmeta="PH00002" value="${caseDto.clinicalManifestations.sweat}" code="1,2"/></td>
								</tr>
								<tr>
									<th>唇青紫：</th>
									<td><ehr:dic-radio name="clinicalManifestations.lip" dicmeta="PH00002" value="${caseDto.clinicalManifestations.lip}" code="1,2"/></td>
									<th>颈静脉怒张：</th>
									<td><ehr:dic-radio name="clinicalManifestations.jugularDistention" dicmeta="PH00002" value="${caseDto.clinicalManifestations.jugularDistention}" code="1,2"/></td>
								</tr>
								<tr>
									<th>呕吐：</th>
									<td><ehr:dic-radio name="clinicalManifestations.vomit" dicmeta="PH00002" value="${caseDto.clinicalManifestations.vomit}" code="1,2"/></td>
									<th>咳血：</th>
									<td><ehr:dic-radio name="clinicalManifestations.hemoptysis" dicmeta="PH00002" value="${caseDto.clinicalManifestations.hemoptysis}" code="1,2"/></td>
								</tr>
								<tr>
									<th>鼻衅：</th>
									<td><ehr:dic-radio name="clinicalManifestations.epistaxis" dicmeta="PH00002" value="${caseDto.clinicalManifestations.epistaxis}" code="1,2"/></td>
									<th>结膜出血：</th>
									<td><ehr:dic-radio name="clinicalManifestations.conjunctivalHemorrhage" dicmeta="PH00002" value="${caseDto.clinicalManifestations.conjunctivalHemorrhage}" code="1,2"/></td>
								</tr>
								<tr>
									<th>眼睑浮肿：</th>
									<td><ehr:dic-radio name="clinicalManifestations.eyelidsSwelling" dicmeta="PH00002" value="${caseDto.clinicalManifestations.eyelidsSwelling}" code="1,2"/></td>
									<th>睡眠不安：</th>
									<td><ehr:dic-radio name="clinicalManifestations.sleepUneasy" dicmeta="PH00002" value="${caseDto.clinicalManifestations.sleepUneasy}" code="1,2"/></td>
								</tr>
								<tr>
									<th>憋气：</th>
									<td><ehr:dic-radio name="clinicalManifestations.chokeResentment" dicmeta="PH00002" value="${caseDto.clinicalManifestations.chokeResentment}" code="1,2"/></td>
									<th>窒息：</th>
									<td><ehr:dic-radio name="clinicalManifestations.asphyxia" dicmeta="PH00002" value="${caseDto.clinicalManifestations.asphyxia}" code="1,2"/></td>
								</tr>
								<tr>
									<th>惊厥：</th>
									<td><ehr:dic-radio name="clinicalManifestations.seizure" dicmeta="PH00002" value="${caseDto.clinicalManifestations.seizure}" code="1,2"/></td>
									<th>其它：</th>
									<td><input type="text" name="clinicalManifestations.otherRespiratory" value="${caseDto.clinicalManifestations.otherRespiratory}" reg='{"maxlength":"50"}'/></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<th>2.治疗情况：</th>
						<td>
							开始治疗日期<tag:dateInput name="clinicalManifestations.cureDt"  onlypast="true" pattern="yyyy/MM/dd"
								date="${caseDto.clinicalManifestations.cureDt}" style="width: 100px;"/>
							曾用中药<input type="text" name="clinicalManifestations.chineseMedicine" value="${caseDto.clinicalManifestations.chineseMedicine}" style="width: 100px;" reg='{"maxlength":"100"}' />
							曾用西药<input name="clinicalManifestations.westernMedicine" type="text" value="${caseDto.clinicalManifestations.westernMedicine}" style="width: 100px;" reg='{"maxlength":"100"}' />
						</td>
					</tr>
					<tr>
						<th></th>
						<td>抗菌素开始使用日期及天数：
							<tag:dateInput name="clinicalManifestations.antibioticsDt"  onlypast="true" pattern="yyyy/MM/dd"
								date="${caseDto.clinicalManifestations.antibioticsDt}" style="width:10%"/>
								<input type="text" name="clinicalManifestations.antibioticsDays" value="${caseDto.clinicalManifestations.antibioticsDays}"
								 reg='{"maxlength":"20"}' cssClass="width30"  style="width:5%"/>天
						</td>
					</tr>
					<tr>
						<th>3.辅助检查：</th>
						<td>
							百日咳培养<input type="text" style="width: 100px;" name="labExamine.pertussis" value="${caseDto.labExamine.pertussis}" reg='{"maxlength":"100"}'/>
							日期<tag:dateInput name="labExamine.pertussisDt"  onlypast="true" pattern="yyyy/MM/dd"
								date="${caseDto.labExamine.pertussisDt}" style="width: 100px;"/>
						</td>
					</tr>
					<tr>
						<th></th>
						<td>
							WBC总数<input type="text" name="labExamine.hemogramWbc" value="${caseDto.labExamine.hemogramWbc}" reg='{"maxlength":"20"}' cssClass="width30" style="width:20%"/>
							分类：淋巴<input type="text" style="width: 100px;" name="labExamine.lymphocyte" value="${caseDto.labExamine.lymphocyte}" reg='{"maxlength":"20"}'/>
							中性<input type="text" name="labExamine.neutrophilcell" value="${caseDto.labExamine.neutrophilcell}" style="width: 100px;" reg='{"maxlength":"20"}'/>
							其它<input type="text" name="labExamine.otherTest" value="${caseDto.labExamine.otherTest}" style="width: 100px;" reg='{"maxlength":"100"}'/>
							化验日期<tag:dateInput name="labExamine.resultReportDate_1"  onlypast="true" pattern="yyyy/MM/dd"
								date="${caseDto.labExamine.resultReportDate_1}" style="width: 100px;"/>
						</td>
					</tr>
					<tr>
						<th>4.抗体检测：</th>
						<td>
							第一次采血日期（急性期）<tag:dateInput name="labExamine.diphtheriaCultureDwelltime_1"  onlypast="true" pattern="yyyy/MM/dd"
								date="${caseDto.labExamine.diphtheriaCultureDwelltime_1}" style="width: 100px;"/>
							结果<input name="labExamine.diphtheriaCultureResult_1" value="${caseDto.labExamine.diphtheriaCultureResult_1 }" type="text" style="width: 100px;" reg='{"maxlength":"100"}'/>
						</td>
					</tr>
					<tr>
						<th></th>
						<td>
							第二次采血日期（恢复期）<tag:dateInput name="labExamine.diphtheriaCultureDwelltime_2"   onlypast="true" pattern="yyyy/MM/dd"
								date="${caseDto.labExamine.diphtheriaCultureDwelltime_2}" style="width: 100px;"/>
							结果<input name="labExamine.diphtheriaCultureResult_2" value="${caseDto.labExamine.diphtheriaCultureResult_2 }" type="text" style="width: 100px;" reg='{"maxlength":"100"}'/>
						</td>
					</tr>
					<tr>
						<th>5.合并症</th>
						<td>
							<ehr:dic-radio name="clinicalManifestations.compl" value="${caseDto.clinicalManifestations.compl}" dicmeta="PH00002" code="1,2"
								/>
						</td>
					</tr>
					<tr id="houTr">
						<td colspan="2" style="padding: 0px;">
							<table>
								<colgroup>
									<col style="min-width: 80px; width: 25%" />
									<col style="min-width: 280px; width: 35%" />
									<col style="min-width: 160px; width: 15%" />
									<col style="min-width: 200px; width: 25%" />
								</colgroup>
								<tr>
									<th>喉炎：</th>
									<td><ehr:dic-radio name="clinicalManifestations.soreThroat" value="${caseDto.clinicalManifestations.soreThroat}" dicmeta="PH00002" code="1,2"/></td>
									<th>肺炎：</th>
									<td><ehr:dic-radio name="clinicalManifestations.pneumonia" value="${caseDto.clinicalManifestations.pneumonia}" dicmeta="PH00002" code="1,2"/></td>
								</tr>
								<tr>
									<th>肺气炎：</th>
									<td><ehr:dic-radio name="clinicalManifestations.pulmonaryAtelectasis" value="${caseDto.clinicalManifestations.pulmonaryAtelectasis}" dicmeta="PH00002" code="1,2"/></td>
									<th>支气管扩张：</th>
									<td><ehr:dic-radio name="clinicalManifestations.bronchopneumonia" value="${caseDto.clinicalManifestations.bronchopneumonia}" dicmeta="PH00002" code="1,2"/></td>
								</tr>
								<tr>
									<th>闹病：</th>
									<td><ehr:dic-radio name="clinicalManifestations.onset" dicmeta="PH00002" value="${caseDto.clinicalManifestations.onset}" code="1,2"/></td>
									<th>其它：</th>
									<td><input type="text" name="clinicalManifestations.other" value="${caseDto.clinicalManifestations.other}" reg='{"maxlength":"50"}'/></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<th>6.临床转归：</th>
						<td><ehr:dic-radio name="otherCondition.outcomeCode" value="${caseDto.otherCondition.outcomeCode }" dicmeta="CV550102" code="1,2,4"/></td>
					</tr>--%>
				</table>
			</td>
			</tr>
			</table>
			</fieldset>

			<fieldset>
				<legend>三. 实验室资料</legend>
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
						<th>4.标本百日咳杆菌培养：</th>
						<td><ehr:dic-radio name="labExamine.pertussis" value="${caseDto.labExamine.pertussis}" dicmeta="PH00004" code="1,2"/></td>					
					</tr>
					<tr>
						<th>5.双份血清抗体：</th>
						<td><ehr:dic-radio name="labExamine.pairedSeraType" value="${caseDto.labExamine.pairedSeraType}" dicmeta="IDM00541"/></td>	
					</tr>					
				</table>
			</fieldset>
			<fieldset>
				<legend>四. 流行病学资料（调查生病前7天内情况）</legend>
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
							<ehr:dic-radio name="epidemiologicalSurvey.contactRelation" dicmeta="IDM00057" 
										onchange="toggleOther('epidemiologicalSurvey.contactRelation','contactRelationOtherId','99')" value="${caseDto.epidemiologicalSurvey.contactRelation}" code="1,2,3,4,5,6,7,99" />
									<span id="contactRelationOtherId"><input type="text"  name="epidemiologicalSurvey.contactRelationOther" value="${caseDto.epidemiologicalSurvey.contactRelationOther}" 
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
			            	<div id="pertussisContactList">
			            		<jsp:include page="pertussisContactList.jsp"></jsp:include>
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
						 <td><tag:dateInput id="firstVisitDate"  name="epidemiologicalSurvey.lastInoculateDt" onlypast="true" pattern="yyyy/MM/dd"
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
						<td>
				             <ehr:dic-radio name="epidemicFocusClose.isolationPlace" value="${caseDto.epidemicFocusClose.isolationPlace}"  dicmeta="IDM00543" />
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
                            <div id="pertussisContactedList">
								<jsp:include page="pertussisContactedList.jsp"></jsp:include>
                            </div>							
						</td>
					</tr>
				</table>
			</fieldset>
			<%-- <fieldset>
				<legend>四.流行病学资料（调查生病前7天内情况）</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 80px; width: 25%" />
						<col style="min-width: 640px; width: 75%" />
					</colgroup>
					<tr>
						<th>1.预防接种史：</th>
						<td>
							基础免疫日期①<input type="text"name="epidemiologicalSurvey.diphtheritisVaccineDtF" 
								value="${caseDto.epidemiologicalSurvey.diphtheritisVaccineDtF}" style="width: 20%;"/>
							②<input type="text" name="epidemiologicalSurvey.diphtheritisVaccineDtS"  
								value="${caseDto.epidemiologicalSurvey.diphtheritisVaccineDtS}"  style="width: 20%;"/>
							③<input type="text" name="epidemiologicalSurvey.diphtheritisVaccineDtT"  
								value="${caseDto.epidemiologicalSurvey.diphtheritisVaccineDtT}" style="width: 20%;"/>
						</td>
					<tr>
					<tr>
						<th></th>
						<td>
							加强免疫日期①<input type="text" name="epidemiologicalSurvey.diphtheritisVaccineDtFo" style="width: 20%;" value="${caseDto.epidemiologicalSurvey.diphtheritisVaccineDtFo}"/>
							②<input type="text" name="epidemiologicalSurvey.diphtheritisVaccineDtFi"   
								value="${caseDto.epidemiologicalSurvey.diphtheritisVaccineDtFi}" style="width: 20%;"/>
						</td>
					<tr>	
					<tr>
						<th></th>
						<td>未种原因<input type="text" name="epidemiologicalSurvey.unvaccinatedReasonOther" 
							value="${caseDto.epidemiologicalSurvey.unvaccinatedReasonOther}" reg='{"maxlength":"100"}'/></td>
					</tr>
					<tr>
						<th></th>
						<td>发病至末次接种时间<tag:dateInput name="epidemiologicalSurvey.mvLastInoculateDt"  nullToToday="true" onlypast="true" pattern="yyyy/MM" 
							date="${caseDto.epidemiologicalSurvey.mvLastInoculateDt}" style="width: 15%;" id="mvLastInoculateDt"/></td>
					</tr>
					<tr>
						<th>2.可疑传染源：</th>
						<td>病前有、无接触过同样的病人，接触日期<input type="text" name="epidemiologicalSurvey.contactDt" style="width: 15%;"
							   value="${caseDto.epidemiologicalSurvey.contactDt}" reg='{"maxlength":"100"}'/>
						</td>
					</tr>
					<tr>
						<th></th>
						<td>接触地点<input type="text" name="epidemiologicalSurvey.recentContactPatientsAddr" value="${caseDto.epidemiologicalSurvey.recentContactPatientsAddr}" reg='{"maxlength":"100"}'/></td>
					</tr>
					<tr>
						<th>继发情况：</th>
						<td><ehr:dic-radio name="epidemiologicalSurvey.sarsAnimal" value="${caseDto.epidemiologicalSurvey.sarsAnimal}" dicmeta="PH00002" code="1,2"/></td>
					</tr>
				</table>
			</fieldset> --%>

			<fieldset>
				<legend>五．小结</legend>
				<table class="posttable">
					<tr>
						<td>
							<textarea name="otherCondition.surveySummary" style="width: 100%" rows="5" reg='{"maxlength":"400"}'>${caseDto.otherCondition.surveySummary}</textarea>
						</td>
					</tr>
				</table>
			</fieldset>
			
			<fieldset>
				<legend></legend>
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
						<th>审查者：</th>
						<td><ehr:user userCode="${caseDto.caseInformation.auditor}"/>
						<input type="hidden" name="caseInformation.auditor" value="${caseDto.caseInformation.auditor}"/></td>
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

<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/scarlatina.js" type="text/javascript"></script>
<script	src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js"	type="text/javascript"></script>
<c:if test="${isPrint != 1}">
    <jsp:include page="../caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
<input type="hidden" id="efcList" name="efcList" value="" /> 
<input type="hidden" id="leList" name="leList" value="" /> 
	<input type="hidden" id="idmId" name="idmId" value="${idmId}"/>
    <div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
		<i class="popno">猩红热个案调查表<br /><span>（乙类传染病）</span></i>
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
			<legend>1. 一般情况</legend>
				<table class="posttable">
					<colgroup>
					    <col style="min-width: 150px;width: 25%" />
					    <col style="min-width: 450px;width: 75%" />
					</colgroup>
			        <tr>
			            <th>1.1 姓名：</th>
			            <td>
			                <input type="text" name="generalCondition.name" value="${caseDto.generalCondition.name}" reg='{"maxlength":"100"}' style="width:150px;"/>
			            </td>
			        </tr>
					<tr>
						<th>1.2 性别：</th>
						<td>
							<ehr:dic-radio id="gender" name="generalCondition.gender" dicmeta="GBT226112003" value="${caseDto.generalCondition.gender}" code="1,2" />
						</td>
					</tr>
					<tr>
						<th>1.3 出生日期：</th>
						<td>
							<tag:dateInput nullToToday="true" name="generalCondition.birthday" pattern="yyyy/MM/dd" date="${caseDto.generalCondition.birthday}" onlypast="true" style="width:150px;"></tag:dateInput>
							<span>（如出生日期不详，实足年龄:</span>
							<tag:numberInput id="age" name="generalCondition.age" value="${caseDto.generalCondition.age}"
											 maxlength="3" cssClass="width30" style="width: 80px;"/>
							<span>年龄单位:</span>
							<ehr:dic-radio id="ageUnit" name="generalCondition.ageUnit"	dicmeta="IDM00003" value="${caseDto.generalCondition.ageUnit}" />
							<span>）</span>
						</td>
					</tr>
					<tr>
						<th>1.4 家长或监护人姓名：</th>
						<td>
							<input type="text" name="generalCondition.parentsName" value="${caseDto.generalCondition.parentsName}" reg='{"maxlength":"50"}' style="width:150px;" />
						</td>
					</tr>
					<tr>
						<th>1.5 职业：</th>
						<td>
							<ehr:dic-list id="occupationId" name="generalCondition.occupation" dicmeta="GBT6565" value="${caseDto.generalCondition.occupation}"
										  onchange="toggleOtherSC('generalCondition.occupation','occupationOtherPart','CV020120299')"
										  code="CV020120201,CV020120202,CV020120203,CV020120211,CV020120209,CV020120299,CV020120217" />
							<input type="text" id="occupationOtherPart" name="generalCondition.occupationOther" value="${caseDto.generalCondition.occupationOther}" reg='{"maxlength":"100"}' style="width:140px;display: none"/>
						</td>
					</tr>
					<tr>
						<th>1.6 文化程度：</th>
						<td>
							<ehr:dic-radio id="Education" name="generalCondition.education" dicmeta="GBT46582006" value="${caseDto.generalCondition.education}"
										   code="IDM06,IDM07,IDM02,IDM03,IDM08,IDM09,IDM10" />
						</td>
					</tr>
					<tr>
						<th>1.7 现居住地或工作学习单位：</th>
						<td>
							<ehr:dic-town-street-village streetId="pastreet_address" townId="patown_address" streetName="generalCondition.pastreet" townName="generalCondition.patownShip"
														 streetValue="${caseDto.generalCondition.pastreet}" townValue="${caseDto.generalCondition.patownShip}" width="140px;"
														 villageId="pavillage_address" villageName="generalCondition.paGroup" villageValue="${caseDto.generalCondition.paGroup}"/>
							<input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${caseDto.generalCondition.pahouseNumber}"
			                        reg='{"maxlength":"50"}'  style="width: 180px;">
			             	<span id="spanPaNumber">(门牌号)</span>
							<br/>
							联系电话<input type="text" name="generalCondition.phoneNumber" value="${caseDto.generalCondition.phoneNumber}" reg='{"regex":"phone","maxlength":"20"}' style="width:140px;" />
						</td>
					</tr>
					<tr>
						<th>1.8 发病日期：</th>
						<td>
							<tag:dateInput id="firstEpisodeDt" name="attackCondition.pathogenesisDate" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.pathogenesisDate}" onlypast="true" style="width: 100px" reg='{"compare":["firstTreatmentDt","le","发病日期必须小于初诊日期"]}'></tag:dateInput>
						</td>
					</tr>
					<tr>
						<th>1.9 就诊日期：</th>
						<td>
							<tag:dateInput id="firstTreatmentDt" name="attackCondition.firstVisitDate" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.firstVisitDate}" onlypast="true" style="width: 100px" reg='{"compare":["firstEpisodeDt","ge","初诊日期必须大于发病日期"]}'></tag:dateInput>
						</td>
					</tr>
					<tr>
						<th>1.10 确诊日期：</th>
						<td>
							<tag:dateInput  name="attackCondition.confirmationDate" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.confirmationDate}" onlypast="true" style="width: 100px" reg='{"compare":["firstTreatmentDt","ge","确诊日期必须大于初诊日期"]}'></tag:dateInput>
						</td>
					</tr>
					<tr>
						<th>1.11 住院时间：</th>
						<td>
							<tag:dateInput id="inhosDateId" name="attackCondition.inhosDate" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.inhosDate}" onlypast="true" style="width: 100px" reg='{"compare":["outHospitalDateId","le","入院日期不能晚于出院日期"]}'></tag:dateInput>
						</td>
					</tr>
					<tr>
						<th>1.12 出院日期：</th>
						<td>
							<tag:dateInput id="outHospitalDateId" name="attackCondition.outHospitalDate" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.outHospitalDate}" onlypast="true" style="width: 100px" reg='{"compare":["inhosDateId","ge","出院日期不能早于入院日期"]}'></tag:dateInput>
						</td>
					</tr>
					<tr>
						<th>1.13 死亡时间：</th>
						<td>
							<tag:dateInput id="inhosDateId" name="attackCondition.dieDt" pattern="yyyy/MM/dd" date="${caseDto.attackCondition.dieDt}" onlypast="true" style="width: 100px"></tag:dateInput>
						</td>
					</tr>
					<tr>
						<th>1.14 诊断单位：</th>
						<td>
							<input type="text" name="attackCondition.firstVisitUnit" value="${caseDto.attackCondition.firstVisitUnit}" reg='{"maxlength":"100"}' style="width: 150px"/>
						</td>
					</tr>
					<tr>
						<th>1.15 报告单位：</th>
						<td>
							<ehr:org code="${caseDto.caseInformation.reportOrg}"></ehr:org>
							<input type="hidden" name="caseInformation.reportOrg" value="${caseDto.caseInformation.reportOrg}">
							<%-- <span style="display: none" ><ehr:dic-org-list name="caseInformation.reportOrg" value="${caseDto.caseInformation.reportOrg}"></ehr:dic-org-list></span>--%>
						</td>
					</tr>
					<tr>
						<th>1.16 住院单位：</th>
						<td>
							<input type="text" name="attackCondition.admissionHospital" value="${caseDto.attackCondition.admissionHospital}" reg='{"maxlength":"100"}' style="width: 150px"/>
						</td>
					</tr>
			        <%--<tr>
			            <th>1.2 身份证号码：</th>
			            <td>
							<input type="text" id="idCard" name="generalCondition.idcard" value="${caseDto.generalCondition.idcard}" placeholder="输入身份证获取个人信息" reg='{"idCard":"true"}' />
			            </td>
			        </tr>
                    <tr>
                        <th>1.7 病人属于：</th>
                        <td>
                            <ehr:dic-radio name="generalCondition.patientAttribute" dicmeta="CV0201104"
                                           value="${caseDto.generalCondition.patientAttribute}" reg='{"required":"true"}'
                                           onchange="scarlatinaCase.toggerAddress()"/>
                        </td>
                    </tr>
			        <tr>
			            <th>1.10 病例分类：</th>
			            <td>
							<ehr:dic-radio name="otherCondition.caseType" dicmeta="CV0501002" 
								value="${caseDto.otherCondition.caseType}" code="1,2,3" />
			            </td>
			        </tr>
			
			        <tr>
			            <th>1.14 初诊病名：</th>
			            <td>
			            	<input type="text" name="attackCondition.firstVisitName" value="${caseDto.attackCondition.firstVisitName}" reg='{"maxlength":"100"}' style="width: 150px"/>
			            </td>
			        </tr>
			        <tr>
			            <th>1.16 确诊单位：</th>
			            <td>
			                <input type="text" name="attackCondition.confirmationHospital" value="${caseDto.attackCondition.confirmationHospital}" reg='{"maxlength":"100"}' style="width: 150px"/>
			            </td>
			        </tr>
			        <tr>
			            <th>1.22 出院时病原携带情况：</th>
			            <td>
							<ehr:dic-radio name="attackCondition.carrierFlg" dicmeta="PH00002" 
								value="${caseDto.attackCondition.carrierFlg}" code="4,2,1" onchange="toggleOther('attackCondition.carrierFlg','spanGermicultureResult','1')"/>
							<span id="spanGermicultureResult">（如有，注明病原血清学阳性指标）<input type="text" id="germicultureResult" name="attackCondition.germicultureResult" value="${caseDto.attackCondition.germicultureResult}" reg='{"maxlength":"100"}' style="width: 150px"/></span>
			            </td>
			        </tr>--%>
			    </table>
			    </fieldset>
			<fieldset>
			    <legend>2. 主要临床表现</legend>
			    <table class="posttable">
			        <colgroup>
			            <col style="width: 25%" />
			            <col style="width: 25%" />
			            <col style="width: 18%" />
			            <col style="width: 32%" />
			        </colgroup>
			            <tr>
			                <th>发热：</th>
			                <td colspan="3">
								<ehr:dic-radio name="clinicalManifestations.fever" dicmeta="PH00002" 
									onchange="toggleOther('clinicalManifestations.fever','trFever','1')" value="${caseDto.clinicalManifestations.fever}" code="1,2,4" />
			                </td>
			            </tr>
			            <tr id="trFever">
			            	<%-- <th>2.2 持续天数：</th>
			            	<td>
								<input type="text" name="clinicalManifestations.heatingDuration" value="${caseDto.clinicalManifestations.heatingDuration}" reg='{"maxlength":"20"}' style="width:80px"/>天
							</td>   --%>
			                <th>体温最高：</th>
			                <td>
			                    <input type="text" name="clinicalManifestations.highestTemperature"  value="${caseDto.clinicalManifestations.highestTemperature}" reg='{"maxlength":"20"}' style="width:80px"/>℃
			                </td>				       
			            </tr>
			            <tr>
			                <th>咽充血、咽喉痛：</th>
			                <td>
								<ehr:dic-radio name="clinicalManifestations.soreThroat" dicmeta="PH00002" 
									value="${caseDto.clinicalManifestations.soreThroat}" code="1,2,4" />
			                </td>
			                <%--<th>口周苍白圈：</th>
			                <td>
								<ehr:dic-radio name="clinicalManifestations.circumoralPallor" dicmeta="PH00002" 
									value="${caseDto.clinicalManifestations.circumoralPallor}" code="1,2,4" />
			                </td>     --%>
			            </tr>
			            <tr>
	                        <th>皮疹：</th>
	                        <td colspan="3"><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.rash" code="1,2" value="${caseDto.clinicalManifestations.rash}"
	                                           onchange="toggleOther('clinicalManifestations.rash','rashParts',1)"/>
	                            <span id="rashParts" style="display: none">
	                            	皮疹出现时间：<tag:dateInput  name="clinicalManifestations.symptomsTime" pattern="yyyy/MM/dd" date="${caseDto.clinicalManifestations.symptomsTime}" onlypast="true" style="width: 100px" ></tag:dateInput>
	                                	分布:<input type="text" name="clinicalManifestations.rashParts" value="${caseDto.clinicalManifestations.rashParts}"
	                                       reg='{"maxlength":"20"}' style="width: 120px;">
	                            </span>
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>并发症：</th>
	                        <td><ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.isComplications" code="1,2" value="${caseDto.clinicalManifestations.isComplications}"
	                                           />
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>其他：</th>
	                        <td><input type="text" name="clinicalManifestations.other" value="${caseDto.clinicalManifestations.other}"
	                                       reg='{"maxlength":"20"}' style="width: 150px;">
	                        </td>
	                    </tr>
			            <%--<tr>
			                <th>杨莓舌：</th>
			                <td>
								<ehr:dic-radio name="clinicalManifestations.raspberryTongue" dicmeta="PH00002" 
									value="${caseDto.clinicalManifestations.raspberryTongue}" code="1,2,4" />
			                </td>
			                <th>粘膜疹：</th>
			                <td>
								<ehr:dic-radio name="clinicalManifestations.enanthema" dicmeta="PH00002" 
									value="${caseDto.clinicalManifestations.enanthema}" code="1,2,4" />
			                </td>                
			            </tr>
			            <tr>
			                <th>咽峡部和扁桃体红肿：</th>
			                <td colspan="3">
								<ehr:dic-radio name="clinicalManifestations.swallowSpondylolysisRed" dicmeta="PH00002" 
									value="${caseDto.clinicalManifestations.swallowSpondylolysisRed}" code="1,2,4" />
			                </td>
			            </tr>
			            <tr>
			                <th>出疹日期：</th>
			                <td>
								<tag:dateInput nullToToday="true" name="clinicalManifestations.rashDate" pattern="yyyy/MM/dd" date="${caseDto.clinicalManifestations.rashDate}" onlypast="true" style="width: 100px"></tag:dateInput>                
			                </td>
			                <th>出疹持续天数：</th>
			                <td>
								<input type="text" name="clinicalManifestations.rashDays" value="${caseDto.clinicalManifestations.rashDays}" reg='{"maxlength":"20"}' style="width:80px"/>天                
			                 </td>
			            </tr>
			            <tr>
			                <th>疹形及分布：</th>
			                <td>
								<input type="text" name="clinicalManifestations.rashShapeDistribution" value="${caseDto.clinicalManifestations.rashShapeDistribution}" reg='{"maxlength":"100"}' style="width:150px"/>                
			                </td>
			                <th>脱皮：</th>
			                <td>
								<ehr:dic-radio name="clinicalManifestations.peel" dicmeta="PH00002" 
									value="${caseDto.clinicalManifestations.peel}" code="1,2,4" />
			                </td>
			            </tr>
			            <tr>
			                <th>性状：</th>
			                <td colspan="3">
								<ehr:dic-radio name="clinicalManifestations.character" dicmeta="IDM00056" 
									value="${caseDto.clinicalManifestations.character}" code="1,2,3,4" />
			                </td>
			            </tr>--%>
				        <tr>
							<th>临床诊断为：</th>
							<td><ehr:dic-radio name="epidemiologicalSurvey.liverDiagnosis" dicmeta="IDM00537" value="${caseDto.epidemiologicalSurvey.liverDiagnosis}"/></td>
						</tr>
						<tr>
		                    <th>白细胞计数：</th>
		                    <td><input type="text" name="labExamine.leukocyteCount" value="${caseDto.labExamine.leukocyteCount}"
		                               reg='{"maxlength":"20"}' style="width: 80px;text-align: center"/> X10^9个/L</td>
		               		<th>分类：</th>
			                <td>
								<input type="text" name="labExamine.sampleClass" value="${caseDto.labExamine.sampleClass}" reg='{"maxlength":"100"}' style="width:150px"/>                
			                </td>
		                </tr>
		                <tr>
		                    <th>咽拭子（或其他病灶分泌物）细菌培养：</th>
		                    <td><input type="text" name="labExamine.throatSwabPcr" value="${caseDto.labExamine.throatSwabPcr}"
		                               reg='{"maxlength":"20"}' style="width: 150px;"/></td>
		               		<th>兔疫荧光实验（咽拭涂片）：</th>
			                <td>
								<input type="text" name="labExamine.throatSwabRtPcr" value="${caseDto.labExamine.throatSwabRtPcr}" reg='{"maxlength":"20"}' style="width:150px"/>                
			                </td>
		                </tr>
						<tr>
				            <th>转归：</th>
				            <td colspan="3">
				                <ehr:dic-radio name="otherCondition.outcomeCode" dicmeta="IDM00005" code="1,2,4" value="${caseDto.otherCondition.outcomeCode}"
				                        />
				            </td>
				        </tr>
			        </table>
			    </fieldset>
			
			<fieldset>
				<legend>3. 流行病学调查</legend>
				<table class="posttable">
					<colgroup>
					    <col style="width: 18%" />
					    <col style="width: 32%" />
					    <col style="width: 15%" />
					    <col style="width: 35%" />
					</colgroup>
				   <%--	<tr>
				   		<th>3.1 本地有无猩红热流行：</th>
				   		<td colspan="3">
							<ehr:dic-radio name="epidemiologicalSurvey.localtionScarlatina" dicmeta="PH00002" 
								value="${caseDto.epidemiologicalSurvey.localtionScarlatina}" code="1,2,4" />
			           </td>
			       	</tr>--%>
			       	<%-- <tr>
			       		<th>3.2 有无外出史：</th>
			           	<td colspan="3">
			           		<ehr:dic-radio name="epidemiologicalSurvey.outHistory" dicmeta="PH00002" 
								onchange="toggleOther('epidemiologicalSurvey.outHistory','divOutHistory','1')" value="${caseDto.epidemiologicalSurvey.outHistory}" code="1,2" />
				           	<div id="divOutHistory">
				           		<span> 如有则 3.2.1该地有无猩红热流行： </span>	
				           		<ehr:dic-radio name="epidemiologicalSurvey.theScarlatina" dicmeta="PH00002" 
									value="${caseDto.epidemiologicalSurvey.theScarlatina}" code="1,2" />
				           	</div>					
			           	</td>
			       	</tr> --%>
					<tr>
						<th>3.1 与病人接触史：</th>
						<td colspan="3">
							<ehr:dic-radio name="epidemiologicalSurvey.contactHistory" dicmeta="PH00002"
										   onchange="toggleOther('epidemiologicalSurvey.contactHistory','divContactHistory','1')" value="${caseDto.epidemiologicalSurvey.contactHistory}" code="1,2" />
							<div id="divContactHistory">
								<div>
									<span>如果有，则3.1.1病人姓名:</span>
									<input type="text" name="epidemiologicalSurvey.contactPatientName" value="${caseDto.epidemiologicalSurvey.contactPatientName}"
										   reg='{"maxlength":"50"}' style="width:120px"/>
								</div>
								<div>
									<span>3.1.2 发病日期:</span>
									<tag:dateInput nullToToday="true" name="epidemiologicalSurvey.dysenteryDt" pattern="yyyy/MM/dd"
												   date="${caseDto.epidemiologicalSurvey.dysenteryDt}" onlypast="true" style="width: 120px"></tag:dateInput>
								</div>
								<div>
									<span>3.1.3 接触时间:</span>
									<input type="text" name="epidemiologicalSurvey.contactDt" value="${caseDto.epidemiologicalSurvey.contactDt}"
										   reg='{"maxlength":"200"}' style="width:120px"/>
								</div>
								<div>
									<span>3.1.4 接触方式:</span>
									<ehr:dic-radio name="epidemiologicalSurvey.contactRelation" dicmeta="IDM00057"
												   onchange="toggleOther('epidemiologicalSurvey.contactRelation','contactRelationOtherId','99')" value="${caseDto.epidemiologicalSurvey.contactRelation}" code="1,2,3,4,5,6,7,99" />
									<input type="text" id="contactRelationOtherId" name="epidemiologicalSurvey.contactRelationOther" value="${caseDto.epidemiologicalSurvey.contactRelationOther}"
										   reg='{"maxlength":"20"}' style="width:120px"/>
								</div>
							</div>
						</td>
					</tr>
			       	<tr>
			       		<th>3.2 公共场所：</th>
			           	<td colspan="3">
			           		<ehr:dic-radio name="epidemiologicalSurvey.outHistory" dicmeta="IDM00538" 
								onchange="toggleOther('epidemiologicalSurvey.outHistory','divOutHistory','1')" value="${caseDto.epidemiologicalSurvey.outHistory}" code="1,2" />	
			           	</td>
			       	</tr>
			       	<tr id="divOutHistory">
			       		<th>公共场所类型：</th>
			           	<td colspan="3">
			           		<ehr:dic-radio name="epidemiologicalSurvey.oftenPublicPlace" dicmeta="IDM00539" value="${caseDto.epidemiologicalSurvey.oftenPublicPlace}"  onchange="toggleOther('epidemiologicalSurvey.oftenPublicPlace','oftenPublicPlace','99')"/>					
				         
				           		<span  id="oftenPublicPlace" style="display:none;"> 	
				           			<input type="text" name="epidemiologicalSurvey.otherPublicPlace" value="${caseDto.epidemiologicalSurvey.otherPublicPlace}" 
										reg='{"maxlength":"50"}' style="width:120px"/>
								</span>
				           
			           	</td>
			       	</tr>
					<tr>
						<th>3.3 家庭人口数：</th>
						<td>
							<input type="text" name="epidemiologicalSurvey.homePopulationNum" value="${caseDto.epidemiologicalSurvey.homePopulationNum}"
								   reg='{"maxlength":"20"}' style="width:120px"/>人
						</td>
						<th>3.4 家庭居住面积：</th>
						<td>
							<input type="text" name="epidemiologicalSurvey.livingSpace" value="${caseDto.epidemiologicalSurvey.livingSpace}"
								   reg='{"maxlength":"20"}' style="width:120px"/>M<sup>2</sup>
						</td>
					</tr>
			        <tr>
			            <th>3.5 以往是否患过猩红热：</th>
			            <td colspan="3">
			           		<ehr:dic-radio name="epidemiologicalSurvey.pph" dicmeta="IDM00540" 
								onchange="toggleOther('epidemiologicalSurvey.pph','pphDiv','1')" value="${caseDto.epidemiologicalSurvey.pph}" code="1,2" />  
							<div id="pphDiv">
								
								<div>
									<span>患病时间:</span>
									<tag:dateInput  name="epidemiologicalSurvey.liverFirstEpisodeDt" pattern="yyyy/MM/dd" 
										date="${caseDto.epidemiologicalSurvey.liverFirstEpisodeDt}" onlypast="true" style="width: 120px"></tag:dateInput>
								</div>
								<div>
									<span>诊断单位:</span>
									<input type="text"  name="epidemiologicalSurvey.diagnosisUnit" value="${caseDto.epidemiologicalSurvey.diagnosisUnit}" 
										reg='{"maxlength":"50"}' style="width:120px"/>
								</div>
												
							</div>          
			            </td>
			        </tr>
			       <%-- <tr>
			            <th>3.7 密切接触者调查：</th>
			            <td colspan="3">
			            	<div id="contactedList">
			            		<jsp:include page="contactsList.jsp"></jsp:include>
			            	</div>
			            </td>
			        </tr>--%>
				</table>
			</fieldset>
			<%-- <fieldset>
			    <legend>4. 实验室检查结果（包括白细胞总数、中性及嗜酸性细胞所占比例，样本培养结果）</legend>
				<jsp:include page="labExamineList.jsp"></jsp:include>
			</fieldset>--%>
			<fieldset>
			    <legend>4. 控制措施</legend>
			    <table class="posttable">
			        <colgroup>
			            <col style="width: 20%" />
			            <col style="width: 80%" />
			        </colgroup>
			        <tr>
			            <th>4.1 病人隔离：</th>
			            <td>
			            	<ehr:dic-radio name="epidemicFocusClose.isPatientIsolation" dicmeta="PH00002" 
								value="${caseDto.epidemicFocusClose.isPatientIsolation}" code="1,2" />
			            </td>
			        </tr>
			        <tr id="trIsolationPlace">
			            <th>4.2 隔离地点：</th>
			            <td>
			            	<ehr:dic-radio name="epidemicFocusClose.isolationPlace" dicmeta="IDM00044" 
								value="${caseDto.epidemicFocusClose.isolationPlace}" code="1,2,3" />
			            </td>
			        </tr>
			        <tr>
			            <th>4.3 病人住室消毒：</th>
			            <td>
			            	<ehr:dic-radio name="epidemicFocusClose.patAccomDisin" dicmeta="PH00002" 
								value="${caseDto.epidemicFocusClose.patAccomDisin}" code="1,2" />            
			            </td>
			        </tr>
			        <tr>
			            <th>4.4 病人分泌物消毒：</th>
			            <td>
			            	<ehr:dic-radio name="epidemicFocusClose.patDischargeDisin" dicmeta="PH00002" 
								value="${caseDto.epidemicFocusClose.patDischargeDisin}" code="1,2" />              
			            </td>
			        </tr>
			        <tr>
			            <th>4.5 病人住室通风：</th>
			            <td>
				           	<ehr:dic-radio name="epidemicFocusClose.patAccomVent" dicmeta="PH00009" 
									value="${caseDto.epidemicFocusClose.patAccomVent}" code="1,3" />
			            </td>
			        </tr>
			        <tr>
			            <th>4.6 其他：</th>
			            <td>
			                <input type="text" name="epidemicFocusClose.other"  value="${caseDto.epidemicFocusClose.other}" 
								reg='{"maxlength":"100"}' style="width:120px"/>
			            </td>
			        </tr> 
			    </table>
			</fieldset>
			<fieldset>
				<legend>5. 调查小结</legend>
				<table class="posttable">
					<tr>
						<td>
							<textarea name="otherCondition.surveySummary" reg='{"maxlength":"800"}' style="width: 98%" rows=10 >${caseDto.otherCondition.surveySummary}</textarea>
						</td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<table class="posttable">
					<colgroup>
						<col style="width: 15%" />
						<col style="width: 35%" />
						<col style="width: 15%" />
						<col style="width: 35%" />
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
						<th>审查者：</th>
						<td>
							<ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/>
						</td>
						<th>调查时间：</th>
						<td>
							<tag:dateInput name="caseInformation.surveyDate" pattern="yyyy/MM/dd" date="${caseDto.caseInformation.surveyDate}"/>
						</td>
					</tr>
					<tr style="display:none;">
			            <td>
							<input type="hidden" name="caseInformation.surveyOrg" value="${caseDto.caseInformation.surveyOrg}"/>
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

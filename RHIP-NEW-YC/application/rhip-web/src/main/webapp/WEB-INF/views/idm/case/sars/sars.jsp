<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/sars.js" type="text/javascript"></script>
<script	src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js"	type="text/javascript"></script>
<c:if test="${isPrint != 1}">
    <jsp:include page="../caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
    <div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
		<i class="popno">
		    传染性非典型肺炎SARS病例个案调查表<br/>
		    <span>（乙类传染病）</span>
		</i>
		<input type="hidden" name="idmId" value="${idmId}" id="idmId"/>
		<input type="hidden" name="esList" id="esList">
		<input type="hidden" name="efcList" id="efcList">
		<input type="hidden" name="acList" id="acList">
		<input type="hidden" name="esActivityList" id="esActivityList">
		<input type="hidden" name="esAnimalList" id="esAnimalList">
		<input type="hidden" name="esLeaveList" id="esLeaveList">
		<input type="hidden" name="esContactList" id="esContactList">
		<input type="hidden" name="efcFamilyList" id="efcFamilyList">
		<input type="hidden" name="efcWorkOrgList" id="efcWorkOrgList">
		<input type="hidden" name="caseStatus" id="caseStatusId" value="${caseDto.caseStatus}">
		<div class="postdiv">
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
		<fieldset>
		    <legend>1.一般情况</legend>
		    <table class="posttable">
		        <colgroup>
		            <col style="min-width:100px;width: 20%"/>
		            <col style="min-width:150px;width: 30%"/>
		            <col style="min-width:100px;width: 15%"/>
		            <col style="min-width:150px;width: 35%"/>		            
		        </colgroup>	
		        <tr>
		            <th>1.1 姓名：</th>
		            <td colspan="3">
		                <input type="text" name="generalCondition.name" value="${caseDto.generalCondition.name}" reg='{"maxlength":"100"}'/>
		            </td>
		        </tr>
		        <tr>
		            <th>1.2 身份证号码:：</th>
		            <td colspan="3">
						<input type="text" id="idCard" name="generalCondition.idcard" value="${caseDto.generalCondition.idcard}" placeholder="输入身份证获取个人信息" reg='{"idCard":"true"}' />
		            </td>
		        </tr>
		        <tr>
		            <th>1.3 性别：</th>
		            <td colspan="3">
		            	<ehr:dic-radio id="gender" name="generalCondition.gender" dicmeta="GBT226112003" value="${caseDto.generalCondition.gender}" code="1,2" />
		            </td>
		        </tr>
		        <tr>
		        	<th>1.4 年龄(岁)：</th>
		        	<td colspan="3">
                        <tag:numberInput id="age" name="generalCondition.age" value="${caseDto.generalCondition.age}"
                                         maxlength="3" cssClass="width30" style="width: 80px;"/>
		        	</td>
		        </tr>
		        <tr>
		        	<th>1.5 职业：</th>
		        	<td colspan="3">
		        		<ehr:dic-radio  name="generalCondition.occupationFlag" dicmeta="IDM00253" value="${caseDto.generalCondition.occupationFlag}"
							onchange="sarsCase.toggleOccupation()" code="1,2" />
						<div>
							<ehr:dic-list id="occupationId" name="generalCondition.occupation" dicmeta="GBT6565" value="${caseDto.generalCondition.occupation}"
								onchange="toggleOther('generalCondition.occupation','occupationOtherPart','CV020120299')"
								code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120209,CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120220,CV020120221,CV020120222,9-31,CV020120223,CV020120299" />
							<input type="text" id="occupationOtherPart" name="generalCondition.occupationOther" value="${caseDto.generalCondition.occupationOther}" reg='{"maxlength":"100"}' style="width:140px;display: none"/>
						</div>
		        	</td>
		        </tr>
		        <tr>
			       	<th>常住类型：</th>
			       	<td>
			 		<ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005"
			           		value="${caseDto.generalCondition.floatPopulation}" onchange="caseEdit.toggerAddress()"/>
			       	</td>
		       </tr>
	        	<tr>
		            <th>1.6 现居住地(详填)：</th>
		            <td colspan="3">
			                 <ehr:dic-town-village villageId="pavillage_address" townId="patown_address" villageName="generalCondition.pastreet" townName="generalCondition.patownShip"
			                                       villageValue="${caseDto.generalCondition.pastreet}" townValue="${caseDto.generalCondition.patownShip}" width="180px;"/>
			                 <input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${caseDto.generalCondition.pahouseNumber}"
			                        reg='{"maxlength":"50"}'  style="width: 180px;">
			             	<span id="spanPaNumber">(门牌号)</span>
			             </td>
			     </tr>
	        	<tr>
		            <th>1.6.1 联系电话：</th>
		            <td>
		            	<input type="text" name="generalCondition.phoneNumber" value="${caseDto.generalCondition.phoneNumber}" reg='{"regex":"phone","maxlength":"20"}' style="width:140px;" />
		          	</td>
		            <th>1.6.2 国标码：</th>
		            <td>
		            	<input type="text" name="generalCondition.addressGbcode" value="${caseDto.generalCondition.addressGbcode}" reg='{"maxlength":"30"}' style="width:140px;" />
		          	</td>		          	
			     </tr>	
	        	<tr>
		            <th>1.7 工作单位 ：</th>
		            <td  colspan="3">
		            	<input type="text" name="generalCondition.unitName" value="${caseDto.generalCondition.unitName}" reg='{"maxlength":"70"}'  />
		          	</td>
			    </tr>
	        	<tr>
		            <th>1.8 户口所在地(详填) ：</th>
		            <td colspan="3">
			                <ehr:dic-town-village villageId="hrvillage_address" townId="hrtown_address" villageName="generalCondition.hrstreet" townName="generalCondition.hrtownShip"
			                                       villageValue="${caseDto.generalCondition.hrstreet}" townValue="${caseDto.generalCondition.hrtownShip}" width="180px;"/>
			
			                 <input type="text" name="generalCondition.hrhouseNumber" id="hrhouseNumber" value="${caseDto.generalCondition.hrhouseNumber}"
			                         style="width: 180px;" reg='{"maxlength":"50"}'>
			                 <span id="spanHrNumber">(门牌号)</span>
			             </td>
			    </tr>	
			    <tr>
			    	<th>1.9 既往病史：</th>
			    	<td colspan="3"></td>
			    </tr>	
			    <tr>
			    	<th>1.9.1基础疾病<br>(糖尿病、高血压、心脏病、肾病等)：</th>
			    	<td colspan="3">
						<ehr:dic-radio name="pastHistory.basicDiseaseFlg" dicmeta="PH00002" value="${caseDto.pastHistory.basicDiseaseFlg}" code="1,2,4" />
			    	</td>
			    </tr>	
				<tr>
					<th>1.9.2 既往非典病史：</th>
					<td colspan="3">
						<ehr:dic-radio name="pastHistory.pastHistorySars" dicmeta="PH00002" value="${caseDto.pastHistory.pastHistorySars}" code="1,2,4" />						
					</td>
				</tr>			        			     		     		        		        		        			        		        		        	    	
		    </table>
	    </fieldset>
		<fieldset>
	    <legend>2. 发病与就诊情况</legend>
	    <table class="posttable">
	        <colgroup>
	            <col style="min-width:100px;width: 20%"/>
	            <col style="min-width:400px;width: 80%"/>
	        </colgroup>
	        <tr>
	            <th>2.1发病情况：</th>
	         	<td></td>
	        </tr>
	        <tr>
	            <th>2.1.1 发病时间：</th>
	            <td>
	            	<tag:dateInput nullToToday="true" name="attackCondition.pathogenesisDate" pattern="yyyy/MM/dd" 
	            		date="${caseDto.attackCondition.pathogenesisDate}" onlypast="true" style="width: 100px"></tag:dateInput>
	            </td>
	        </tr>
	        <tr>
	            <th>2.1.2 首发症状(描述)：</th>
	            <td>
	            	<input type="text" name="attackCondition.firstSymptom" value="${caseDto.attackCondition.firstSymptom}" 
	            		reg='{"maxlength":"100"}' />
	            </td>
	        </tr>
	        <tr>
	            <th>2.2发病地点：</th>
	            <td>
	            	<input type="text" name="attackCondition.pathogenesisPlace" value="${caseDto.attackCondition.pathogenesisPlace}" 
	            		reg='{"maxlength":"100"}' />	            
                    <div>
                    	国标码<input type="text" name="attackCondition.gbcode" value="${caseDto.attackCondition.gbcode}" 
	            			reg='{"maxlength":"20"}' style="width:150px;"/>
                    </div>
	            </td>
	        </tr>
	        <tr>
	            <th>2.3就诊情况（从发病到入院的就诊经过）：</th>
	            <td><jsp:include page="medicalConditionList.jsp"></jsp:include></td>
	        </tr>
	        <tr>
	            <th>2.4入院情况：</th>
	            <td></td>
	        </tr>
	        <tr>
	            <th>2.4.1入院日期：</th>
	            <td>
	            	<tag:dateInput nullToToday="true" name="attackCondition.inhosDate" pattern="yyyy/MM/dd" 
	            		date="${caseDto.attackCondition.inhosDate}" onlypast="true" style="width: 100px"></tag:dateInput>
	            </td>
	        </tr>
	        <tr>
	            <th>2.4.2所住医院名称：</th>
	            <td>
	            	<input type="text" name="attackCondition.admissionHospital" value="${caseDto.attackCondition.admissionHospital}" 
	            		reg='{"maxlength":"100"}' />		            	
	            </td>
	        </tr>
	        <tr>
	            <th>2.4.3住院号：</th>
	            <td>
	            	<input type="text" name="attackCondition.admissionNo" value="${caseDto.attackCondition.admissionNo}" 
	            		reg='{"maxlength":"50"}' />	            	
	            </td>
	        </tr>
	        <tr>
	            <th>2.4.4入院诊断：</th>
	            <td>
					<ehr:dic-radio name="attackCondition.inhosDiagnosis" dicmeta="IDM00040" value="${caseDto.attackCondition.inhosDiagnosis}"
						onchange="toggleOther('attackCondition.inhosDiagnosis','inhosDiagnosisOtherId','99')" code="1,2,99" />	            
	           	 	<input type="text" id="inhosDiagnosisOtherId" name="attackCondition.inhosDiagnosisOther" 
	           	 		value="${caseDto.attackCondition.inhosDiagnosisOther}" reg='{"maxlength":"100"}'  style="width: 150px"/>
	            </td>
	        </tr>
	        <tr>
	            <th>2.5 报告时间：</th>
	            <td>
                    <tag:dateInput nullToToday="true" name="caseInformation.reportDate" pattern="yyyy/MM/dd"
	            		date="${caseDto.caseInformation.reportDate}" onlypast="true" style="width: 100px;display:none"></tag:dateInput>
	            	<fmt:formatDate value="${caseDto.caseInformation.reportDate}" pattern="yyyy/MM/dd"/>
	            		
	            </td>
	        </tr>
	    </table>
	</fieldset>
	<fieldset>
    <legend>3. 临床表现</legend>
    <table class="posttable">
        <colgroup>
            <col style="min-width:100px;width: 20%"/>
            <col style="min-width:400px;width: 80%"/>
        </colgroup>
        <tr>
            <th>首发症状(描述)：</th>
            <td>
           	 	<input type="text" id="originalSymptom" name="clinicalManifestations.originalSymptom" 
           	 		value="${caseDto.clinicalManifestations.originalSymptom}" reg='{"maxlength":"200"}'  style="width:98%"/>            	
            </td>
        </tr>
        <tr>
            <th>3.1发热：</th>
            <td>
				<ehr:dic-radio name="clinicalManifestations.fever" dicmeta="PH00002" value="${caseDto.clinicalManifestations.fever}"
					onchange="toggleOther('clinicalManifestations.fever','divFever','1')" code="1,2" />	
				<div id="divFever">
					 3.1.1体温(最高)<input type="text" name="clinicalManifestations.highestTemperature" value="${caseDto.clinicalManifestations.highestTemperature}" reg='{"maxlength":"20"}' style="width:80px"/>℃
					 3.1.2体温(入院时)<input type="text" name="clinicalManifestations.temperature"  value="${caseDto.clinicalManifestations.temperature}" reg='{"maxlength":"20"}' style="width:80px"/>℃
				</div>					            
            </td>
        </tr>
        <tr>
            <th>3.2咳嗽：</th>
            <td>
				<ehr:dic-radio name="clinicalManifestations.cough" dicmeta="PH00002" value="${caseDto.clinicalManifestations.cough}"
					onchange="toggleOther('clinicalManifestations.cough','divCough','1')" code="1,2" />	
            	<div id="divCough">
	 				3.2.1 咳痰<ehr:dic-radio name="clinicalManifestations.expectoration" dicmeta="PH00002" value="${caseDto.clinicalManifestations.expectoration}"	code="1,2" />	
            	</div>
            </td>
        </tr>
        <tr>
            <th>3.3上呼吸道卡他症状：</th>
            <td>
				<ehr:dic-radio name="clinicalManifestations.catarrh" dicmeta="PH00002" value="${caseDto.clinicalManifestations.catarrh}"
					code="1,2" />	
            </td>
        </tr>
        <tr>
            <th>3.4胸闷：</th>
            <td>
				<ehr:dic-radio name="clinicalManifestations.chestStufly" dicmeta="PH00002" value="${caseDto.clinicalManifestations.chestStufly}"
					code="1,2" />	
            </td>
        </tr>
        <tr>
            <th>3.5呼吸困难：</th>
            <td>
 				<ehr:dic-radio name="clinicalManifestations.dyspnea" dicmeta="PH00002" value="${caseDto.clinicalManifestations.dyspnea}"
					code="1,2" />	
            </td>
        </tr>
        <tr>
            <th>3.6腹泻：</th>
            <td>
 				<ehr:dic-radio name="clinicalManifestations.diarrhea" dicmeta="PH00002" value="${caseDto.clinicalManifestations.diarrhea}"
					code="1,2" />            
            </td>
        </tr>
    </table>
	</fieldset>
	<fieldset>
    <legend>4. 临床及实验室检查</legend>
    <table class="posttable">
        <colgroup>
            <col style="min-width:100px;width: 20%"/>
            <col style="min-width:400px;width: 80%"/>
        </colgroup>
        <tr>
            <th>4.1 血常规：</th>
            <td>
            		<span>
            			初诊时:&nbsp白细胞计数
   						<input type="text" name="labExamine.firstLeukocyteCount" value="${caseDto.labExamine.firstLeukocyteCount}" 
   							reg='{"maxlength":"20"}' style="width:60px;"/>×10<sup>9</sup>/L
						&nbsp中性粒细胞
						<input type="text" name="labExamine.firstNeutrophilic" value="${caseDto.labExamine.firstNeutrophilic}" 
							reg='{"maxlength":"20"}' style="width:60px;"/>%
						&nbsp淋巴细胞计数
						<input type="text" name="labExamine.firstLymphocyteCount" value="${caseDto.labExamine.firstLymphocyteCount}" 
							reg='{"maxlength":"20"}' style="width:60px;"/>% 
					</span>
					<br>
            		<span>
            			入院时:&nbsp白细胞计数
				        <input type="text" name="labExamine.admissionLeukocyteCount" value="${caseDto.labExamine.admissionLeukocyteCount}" 
				           	reg='{"maxlength":"20"}' style="width:60px;"/>×10<sup>9</sup>/L
				    	&nbsp中性粒细胞
				    	<input type="text" name="labExamine.admissionNeutrophilic" value="${caseDto.labExamine.admissionNeutrophilic}" 
				            reg='{"maxlength":"20"}' style="width:60px;"/>%
				   		&nbsp淋巴细胞计数
				   		<input type="text" name="labExamine.admissionLymphocyteCount" value="${caseDto.labExamine.admissionLymphocyteCount}" 
				        	reg='{"maxlength":"20"}' style="width:60px;"/>%   
				    </span>         		
            </td>
        </tr>
        <tr>
        	<th>4.2胸部Ｘ线检查：</th>
           	<td>
				<div>
            		初诊时:日期
	            	<tag:dateInput nullToToday="true" name="labExamine.chestXrayFirstTime" pattern="yyyy/MM/dd" 
	            		date="${caseDto.labExamine.chestXrayFirstTime}" onlypast="true" style="width: 100px"></tag:dateInput>
					&nbsp结果
 					<ehr:dic-radio name="labExamine.chestXrayFirstResult" dicmeta="IDM00111" value="${caseDto.labExamine.chestXrayFirstResult}"
						onchange="toggleOther('labExamine.chestXrayFirstResult','chestXrayFirstOtherId','99')" code="1,2,99" />
					<input type="text" id="chestXrayFirstOtherId" name="labExamine.chestXrayFirstOther" value="${caseDto.labExamine.chestXrayFirstOther}" 
				    	reg='{"maxlength":"100"}' style="width:120px;"/>  
				</div>
            	<div>
            		入院时:日期
	            	<tag:dateInput nullToToday="true" name="labExamine.chestXrayAdmissionTime" pattern="yyyy/MM/dd" 
	            		date="${caseDto.labExamine.chestXrayAdmissionTime}" onlypast="true" style="width: 100px"></tag:dateInput>
					&nbsp结果
 					<ehr:dic-radio name="labExamine.chestXrayAdmissionResult" dicmeta="IDM00111" value="${caseDto.labExamine.chestXrayAdmissionResult}"
						onchange="toggleOther('labExamine.chestXrayAdmissionResult','chestXrayAdmissionOtherId','99')" code="1,2,99" />
					<input type="text" id="chestXrayAdmissionOtherId" name="labExamine.chestXrayAdmissionOther" value="${caseDto.labExamine.chestXrayAdmissionOther}" 
	        			reg='{"maxlength":"100"}' style="width:120px;"/>  
	        	</div>
				<div>
					（具体描述）<textarea name="labExamine.chestXrayResult" reg='{"maxlength":"100"}' style="width: 99%" rows=10 >${caseDto.labExamine.chestXrayResult}</textarea>			
				</div>
            </td>            
        </tr>
        <tr>
            <th>4.3血清学检测结果：</th>
            <td></td>
        </tr>
        <tr>
            <th>4.3.1第一份血清：</th>
            <td>
				&nbsp采血时间<tag:dateInput nullToToday="true" name="labExamine.firstDrawbloodTime" pattern="yyyy/MM/dd" 
	            	date="${caseDto.labExamine.firstDrawbloodTime}" onlypast="true" style="width: 100px"></tag:dateInput> 
	            <div>
	            	SARS-IgM&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
 					<ehr:dic-radio name="labExamine.firstSarsIgm" dicmeta="PH00004" value="${caseDto.labExamine.firstSarsIgm}"
						code="1,2" />
	            </div> 
	            <div>
	            	SARS-IgG&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
 					<ehr:dic-radio name="labExamine.firstSarsIgg" dicmeta="PH00004" value="${caseDto.labExamine.firstSarsIgg}"
						code="1,2" />	            
	            </div> 
	            <div>
	            	SARS-总抗体&nbsp&nbsp&nbsp
 					<ehr:dic-radio name="labExamine.firstSarsAnti" dicmeta="PH00004" value="${caseDto.labExamine.firstSarsAnti}"
						code="1,2" />	            
	            </div> 	            	                      
            </td>
        </tr>
        <tr>
            <th>4.3.2第二份血清：</th>
            <td>
				&nbsp采血时间<tag:dateInput nullToToday="true" name="labExamine.secondDrawbloodTime" pattern="yyyy/MM/dd" 
	            	date="${caseDto.labExamine.secondDrawbloodTime}" onlypast="true" style="width: 100px"></tag:dateInput> 
	            <div>
	            	SARS-IgM&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
 					<ehr:dic-radio name="labExamine.secondSarsIgm" dicmeta="PH00004" value="${caseDto.labExamine.secondSarsIgm}"
						code="1,2" />
	            </div> 
	            <div>
	            	SARS-IgG&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
 					<ehr:dic-radio name="labExamine.secondSarsIgg" dicmeta="PH00004" value="${caseDto.labExamine.secondSarsIgg}"
						code="1,2" />	            
	            </div> 
	            <div>
	            	SARS-总抗体&nbsp&nbsp&nbsp
 					<ehr:dic-radio name="labExamine.secondSarsAnti" dicmeta="PH00004" value="${caseDto.labExamine.secondSarsAnti}"
						code="1,2" />	            
	            </div>             
            </td>
        </tr>
        <tr>
            <th>4.4病原学检测结果：</th>
            <td><jsp:include page="pathogenCheckList.jsp"></jsp:include></td>
        </tr>
    </table>
	</fieldset>
	<fieldset>
    <legend>5. 流行病学史调查</legend>
    <table class="posttable">
        <colgroup>
            <col style="min-width:100px;width: 20%"/>
            <col style="min-width:400px;width: 80%"/>
        </colgroup>
        <tr>
            <th>调查日期：</th>
            <td>
				<tag:dateInput nullToToday="true" name="epidemiologicalSurvey.surveyDate" pattern="yyyy/MM/dd" 
	            	date="${caseDto.epidemiologicalSurvey.surveyDate}" onlypast="true" style="width: 100px"></tag:dateInput>             	
            </td>
        </tr>
        <tr>
            <th style="vertical-align:middle;text-align:right;">5.1发病前一周内逐日活动情况：</th>
            <td><jsp:include page="activityList.jsp"></jsp:include></td>
        </tr>
        <tr>
            <td colspan="2">5.2 请详细描述发病前二周内特殊活动情况(如到医院、去外地、聚餐、聚会、外人来访等)。</td>
        </tr>
        <tr>
        	<th>：</th>
            <td>
				<textarea name="epidemiologicalSurvey.contectDetail" reg='{"maxlength":"2000"}' style="width: 99%" rows=10 >${caseDto.epidemiologicalSurvey.contectDetail}</textarea>                
            </td>
        </tr>
        <tr>
            <td colspan="2">
                5.3 发病前2周内是否接触过非典病人或/和疑似非典患者
                <ehr:dic-radio dicmeta="PH00001" name="epidemiologicalSurvey.sarsPatient" value="${caseDto.epidemiologicalSurvey.sarsPatient}"
						onchange="toggleOther('epidemiologicalSurvey.sarsPatient','trSarsPatientId','1')" code="1,2" />
        </tr>
        <tr id="trSarsPatientId">
            <td colspan="2"><jsp:include page="contactList.jsp"></jsp:include></td>        
        </tr>
        <tr>
            <td colspan="2">
                5.4 发病前两周内接触动物（罕见动物、禽类）情况
                <ehr:dic-radio dicmeta="PH00001" name="epidemiologicalSurvey.sarsAnimal" value="${caseDto.epidemiologicalSurvey.sarsAnimal}"
						onchange="toggleOther('epidemiologicalSurvey.sarsAnimal','trSarsAnimal','1')" code="1,2" />
            </td>
        </tr>
        <tr id="trSarsAnimal">
            <td colspan="2"><jsp:include page="contactAnimalList.jsp"></jsp:include></td>
        </tr>
        <tr>
            <td colspan="2">5.5 发病后至隔离治疗前逐日活动情况</td>
        </tr>
        <tr>
        	<td colspan="2"><jsp:include page="leaveActivityList.jsp"></jsp:include></td>   
        </tr>
        <tr>
            <td colspan="2">5.6 发病后至住院前密切接触者</td>
        </tr>
        <tr>
            <td colspan="2">5.6.1家庭、亲友</td>
        </tr>
        <tr>
            <td colspan="2">
            	<div id="contactedFamilyList">
            		<jsp:include page="familyList.jsp"></jsp:include>
            	</div>
            </td>
        </tr>        
        <tr>
            <td colspan="2">5.6.2 工作单位或主要活动场所联系人</td>
        </tr>
        <tr>
        	<td colspan="2">
        		<div id="contactedWorkOrgList">
        			<jsp:include page="workOrgList.jsp"></jsp:include>
        		</div>
        	</td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <legend>6. 转归与最终诊断情况（随访或根据医疗报告完成）</legend>
    <table class="posttable">
        <colgroup>
            <col style="min-width:100px;width: 20%"/>
            <col style="min-width:400px;width: 80%"/>
        </colgroup>
        <tr>
            <th>6.1最后诊断：</th>
            <td>
               	<ehr:dic-radio dicmeta="IDM00040" name="diagnosis.lastDiagnosis" value="${caseDto.diagnosis.lastDiagnosis}"
						onchange="sarsCase.toggleLastDia()" code="1,2,3,5" />  
				<span id="spanLastDiagnosis">
				                其它疾病名
				     <input type="text" name="diagnosis.diagnosisDisease" value="${caseDto.diagnosis.diagnosisDisease}" 
				            reg='{"maxlength":"100"}' style="width:120px;"/>
				</span>          
        </tr>
        <tr id="trLastDiagnosis">
            <th>排除依据：</th>
            <td>
				<input type="text" name="diagnosis.diagnosisReason" value="${caseDto.diagnosis.diagnosisReason}" 
					reg='{"maxlength":"100"}' style="width:98%;"/>            	
            </td>
        </tr>
        <tr>
            <th>6.2转归：</th>
            <td>
               	<ehr:dic-radio dicmeta="IDM00005" name="otherCondition.outcomeCode" value="${caseDto.otherCondition.outcomeCode}"
					onchange="sarsCase.toggleOutCome()" code="1,4" />  
				<div id="divOutCome">
					若病例死亡,则填写6.2.1
				</div>           
            </td>
        </tr>
        <tr id="trOutCome">
            <th>6.2.1病例死亡时间：</th>
            <td>
				<tag:dateInput nullToToday="true" name="otherCondition.deathTime" pattern="yyyy/MM/dd" 
	            	date="${caseDto.otherCondition.deathTime}" onlypast="true" style="width: 100px"></tag:dateInput>             	
            </td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <legend>7. 调查小结</legend>
    <table class="posttable">
        <colgroup>
            <col style="min-width:100px;width: 20%"/>
            <col style="min-width:400px;width: 80%"/>
        </colgroup>    
        <tr>
            <td colspan="2">
            	<textarea name="otherCondition.surveySummary" reg='{"maxlength":"2000"}' style="width: 99%" rows=10 >${caseDto.otherCondition.surveySummary}</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2">补充调查（时间、内容等）</td>
        </tr>
        <tr>
            <td colspan="2">
				<textarea name="otherCondition.supplyInvestigation" reg='{"maxlength":"100"}' style="width: 99%" rows=10 >${caseDto.otherCondition.supplyInvestigation}</textarea>            	
            </td>
        </tr>
    </table>
</fieldset>
<fieldset>
    <table class="posttable">
        <colgroup>
            <col style="min-width:100px;width: 20%"/>
            <col style="min-width:400px;width: 80%"/>
        </colgroup>
        <tr>
            <th>调查单位：</th>
            <td><ehr:org code="${caseDto.caseInformation.modifySurveyOrg}"/></td>
        </tr>
        <tr>
            <th>调查时间：</th>
            <td><tag:dateInput name="caseInformation.surveyDate" pattern="yyyy/MM/dd" date="${caseDto.caseInformation.surveyDate}" style="width: 100px"></tag:dateInput></td>
        </tr>
        <tr>
            <th>调查者签名：</th>
            <td><ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/></td>
        </tr>
    </table>
</fieldset>
</div>
</div>
</form>

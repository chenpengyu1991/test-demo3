<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/rubella.js" type="text/javascript"></script>

<c:if test="${isPrint != 1}">
    <jsp:include page="caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
<input type="hidden" id="idmId" name="idmId" value="${idmId}"/>
    <div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
		<i class="popno">风疹个案调查表<br /><span>（丙类传染病）</span></i>
		<table class="posttable">
			        <colgroup>
			            <col style="width: 50%"/>
			             <col style="width: 50%"/>
			        </colgroup>
			        <tr>
			            <td style="text-align: left;">
                            国标编码：<input type="text" name="generalCondition.gbcode" value="${caseDto.generalCondition.gbcode}" reg='{"maxlength":"14"}' style="width:180px;"/>
			            </td>
			             <%-- <td style="text-align: center;">

                           年    度：
							  <tag:dateInput  name="caseInformation.years"  date="${caseDto.caseInformation.years}"  pattern="yyyy"/>
							  &lt;%&ndash;<input type="text" name="caseInformation.years" value="${caseDto.caseInformation.years}" reg='{"length":"4"}'/>&ndash;%&gt;
			            </td>--%>
			            <td style="text-align: right;">
                            病例编码：<input type="text" name="caseInformation.mediRecordNum" reg='{"maxlength":"14"}' value="${caseDto.caseInformation.mediRecordNum}" style="width:180px;"/>
			            </td>
			        </tr>
			    </table>
        <div class="postdiv">
	        <fieldset>
				<legend>1．编号</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 15%" />
						<col style="width: 35%" />
						<col style="width: 15%" />
						<col style="width: 35%" />
					</colgroup>
					<tr>
						<th><label class="required">报告日期</label>：</th>
						<td>
							<tag:dateInput id="reportDateId" name="caseInformation.reportDate" pattern="yyyy/MM/dd" date="${caseDto.caseInformation.reportDate}"
								style="width: 100px;display:none" reg='{"required":"true"}' />
							<fmt:formatDate value="${caseDto.caseInformation.reportDate}" pattern="yyyy/MM/dd"/>
						</td>
						<th><label class="required">调查日期</label>：</th>
						<td>
							<tag:dateInput name="caseInformation.modifySurveyDate" pattern="yyyy/MM/dd" date="${caseDto.caseInformation.modifySurveyDate}" reg='{"required":"true","compare":["reportDateId","ge","调查日期不能早于报告日期"]}'/>
						</td>
					</tr>
					<tr>
						<th>报告来源：</th>
						<td colspan="3">
							<ehr:dic-radio name="otherCondition.caseSource" dicmeta="IDM00603" value="${caseDto.otherCondition.caseSource}"/>
						</td>
					</tr>

				</table>
			</fieldset>
            <fieldset>
                <legend>2．基本情况</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 15%" />
                        <col style="width: 35%" />
                        <col style="width: 15%" />
                        <col style="width: 35%" />
                    </colgroup>
					<tr>
						<th>病人姓名：</th>
						<td>
							<input type="text"  name="generalCondition.name" value="${caseDto.generalCondition.name}" reg='{"maxlength":"100"}' style="width:180px;">
						</td>
						<th>联系人姓名：</th>
						<td colspan="3">
							<input type="text" name="generalCondition.contactName" value="${caseDto.generalCondition.contactName}" reg='{"maxlength":50}' style="width:180px;"/>
						</td>
					</tr>
					<tr>
						<th>联系电话：</th>
						<td><input type="text" name="generalCondition.phoneNumber" value="${caseDto.generalCondition.phoneNumber}" reg='{"regex":"phone","maxlength":"20"}' style="width:180px;"></td>

						<th>性别：</th>
						<td>
							<ehr:dic-radio name="generalCondition.gender" dicmeta="GBT226112003" value="${caseDto.generalCondition.gender}" code="1,2" />
						</td>
					</tr>
					<tr>
						<th>于妊娠期小于3月：</th>
						<td>
							<ehr:dic-radio name="generalCondition.lessInPregnancy" dicmeta="PH00001"  code="1,2" value="${caseDto.generalCondition.lessInPregnancy}"/>
						</td>
					</tr>
					<tr>
						<th>出生日期：</th>
						<td>
							<tag:dateInput nullToToday="true" name="generalCondition.birthday" pattern="yyyy/MM/dd" date="${caseDto.generalCondition.birthday}" onlypast="true" style="width: 180px"></tag:dateInput>
						</td>
						<%--<th>d．文化程度：</th>
						<td>
							<ehr:dic-radio  name="generalCondition.education" dicmeta="GBT46582006" value="${caseDto.generalCondition.education}"
							code="IDM09,IDM07,IDM02,IDM03,IDM04,IDM05" />
						</td>				--%>
					</tr>
					<tr>
						<th>年龄：</th>
			            <td>
                            <input type="text" id="age" name="generalCondition.age" value="${caseDto.generalCondition.age}"
                                            reg='{"maxlength":"6","regex":"number"}' cssClass="width30" style="width:50px;"/>
			            	 <ehr:dic-radio id="ageUnit" name="generalCondition.ageUnit"  dicmeta="IDM00003" value="${caseDto.generalCondition.ageUnit}"/>
			            </td>
			        </tr>
					<tr>
						<th>现住址：</th>
						<td colspan="3">
							<ehr:dic-town-street-village streetId="pastreet_address" townId="patown_address" streetName="generalCondition.pastreet" townName="generalCondition.patownShip"
														 streetValue="${caseDto.generalCondition.pastreet}" townValue="${caseDto.generalCondition.patownShip}" width="140px;"
														 villageId="pavillage_address" villageName="generalCondition.paGroup" villageValue="${caseDto.generalCondition.paGroup}"/>
							<input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${caseDto.generalCondition.pahouseNumber}"
								   reg='{"maxlength":"50"}' style="width: 180px;">
							<span id="spanPaNumber">(门牌号)</span>
						</td>
					</tr>
			        <tr>
						<th>职业：</th>
						<td colspan="3">
							<ehr:dic-radio name="generalCondition.occupation" dicmeta="GBT6565" value="${caseDto.generalCondition.occupation}"
								code="GBT46582006,CV020120208,CV020120229,CV020120204,CV020120209,CV020120211,CV020120212,CV020120234,CV020120214,CV020120216,CV020120215,CV020120299" />
						</td>
					</tr>
					<tr>
						<th>是否流动人口：</th>
						<td colspan="3">
				        	<ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005" code="1,2"
                        		value="${caseDto.generalCondition.floatPopulation}" onchange="caseEdit.toggerAddress();toggleOther('generalCondition.floatPopulation','spanHrhouseNumber',2)"/>
							<span id="spanHrhouseNumber"> 如果是，来自省<input type="text" name="generalCondition.fromProvince" value="${caseDto.generalCondition.fromProvince}" style="width: 100px;" 
								reg='{"maxlength":"50"}'/>
								来永城日期：<tag:dateInput id="toSuzhouDate" name="generalCondition.toSuzhouDate" pattern="yyyy/MM/dd" date="${caseDto.generalCondition.toSuzhouDate}"
									style="width: 100px;" />
								<%--<fmt:formatDate value="${caseDto.generalCondition.toSuzhouDate}" pattern="yyyy/MM/dd"/>>--%>
								来永城时间:<ehr:dic-radio name="generalCondition.toSuzhouTime" dicmeta="IDM00604" value="${caseDto.generalCondition.toSuzhouTime}"/>
								</span>
						</td>						
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>3．免疫接种史</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 40%" />
						<col style="width: 60%" />
					</colgroup>
					<tr>
						<th>c．风疹疫苗免疫史：</th>
						<td>
							<ehr:dic-radio name="epidemiologicalSurvey.rubellaVaccine" dicmeta="PH00002" value="${caseDto.epidemiologicalSurvey.rubellaVaccine}"
										   onchange="toggleOther('epidemiologicalSurvey.rubellaVaccine','divVaccine','1')"  code="2,1,4" />
							<div id="divVaccine">
								<span>若有，最后一次接种日期：</span>
								<tag:dateInput nullToToday="true" name="epidemiologicalSurvey.lastRubellaVaccineDt" pattern="yyyy/MM/dd" date="${caseDto.epidemiologicalSurvey.lastRubellaVaccineDt}" onlypast="true" style="width: 100px"></tag:dateInput>
								免疫史来源：<ehr:dic-list dicmeta="IDM00069"
													name="epidemiologicalSurvey.immunizationHistorySource"
													code="1,2,4"
													value="${caseDto.epidemiologicalSurvey.immunizationHistorySource }" />
								共接种剂次数：<input type="text" name="epidemiologicalSurvey.inoculateNum" value="${caseDto.epidemiologicalSurvey.inoculateNum}" reg='{"maxlength":"10","regex":"number"}' style="width:50px"/>
							</div>

					</tr>
		</table>
		</fieldset>
        <fieldset>
        <legend>4．临床表现</legend>
        <table class="posttable">
            <colgroup>
                <col style="width: 15%" />
                <col style="width: 35%" />
                <col style="width: 15%" />
                <col style="width: 35%" />                
            </colgroup>
			<%--<tr>
				<th>a．发病日期：</th>
				<td colspan="3">
					<tag:dateInput nullToToday="true" name="clinicalManifestations.dateAccident" pattern="yyyy/MM/dd" date="${caseDto.clinicalManifestations.dateAccident}" onlypast="true" style="width: 100px"></tag:dateInput>				
				</td>
			</tr>--%>
			<tr>
				<th>发热：</th>
				<td colspan="3">
					<ehr:dic-radio name="clinicalManifestations.fever" dicmeta="PH00002" value="${caseDto.clinicalManifestations.fever}" 
						onchange="toggleOther('clinicalManifestations.fever','divFever','1')" code="2,1,4" />
					<div id="divFever">			
						<span>若有，开始发热日期</span>
						<tag:dateInput nullToToday="true" name="clinicalManifestations.hotDate" pattern="yyyy/MM/dd" date="${caseDto.clinicalManifestations.hotDate}" onlypast="true" style="width: 80px"></tag:dateInput>
						<span>最高体温 </span><input type="text" name="clinicalManifestations.highestTemperature" value="${caseDto.clinicalManifestations.highestTemperature}" reg='{"maxlength":"20","regex":"number"}' style="width:50px">
						<span>℃</span>	
						<span>退热日期 </span><tag:dateInput  name="clinicalManifestations.hotBackDate" pattern="yyyy/MM/dd" date="${caseDto.clinicalManifestations.hotBackDate}" onlypast="true" style="width: 80px"></tag:dateInput>
						
					</div>	
				</td>
			</tr>
			<tr>
				<th>出疹日期：</th>
				<td>
					<tag:dateInput id="rashDateId"  name="clinicalManifestations.rashDate" pattern="yyyy/MM/dd" date="${caseDto.clinicalManifestations.rashDate}" onlypast="true" style="width: 100px"></tag:dateInput>
				</td>
				<th>退疹日期：</th>
				<td>
					<tag:dateInput id="backRashDateId"  name="clinicalManifestations.backRashDate" pattern="yyyy/MM/dd" date="${caseDto.clinicalManifestations.backRashDate}" onlypast="true" style="width: 100px"></tag:dateInput>
				</td>
			</tr>
			<tr>
				<th>咳嗽：</th>
				<td>
					<ehr:dic-radio name="clinicalManifestations.cough" dicmeta="PH00002" value="${caseDto.clinicalManifestations.cough}" code="2,1,4" />				
				</td>
				<th>卡它症状：</th>
				<td>
					<ehr:dic-radio name="clinicalManifestations.coryza" dicmeta="PH00002" value="${caseDto.clinicalManifestations.coryza}" code="2,1,4" />				
				</td>				
			</tr>
			<tr>
			<th>结膜炎：</th>
			<td>
				<ehr:dic-radio name="clinicalManifestations.conjunctivitis" dicmeta="PH00002" value="${caseDto.clinicalManifestations.conjunctivitis}" code="2,1,4" />
			</td>
				<th>关节疼痛：</th>
				<td>
					<ehr:dic-radio name="clinicalManifestations.arthralgia" dicmeta="PH00002" value="${caseDto.clinicalManifestations.arthralgia}" code="2,1,4" />
				</td>
			</tr>
			<tr>
				<%--<th>g．出疹顺序：</th>
				<td>
					<ehr:dic-radio name="clinicalManifestations.rashOrder" dicmeta="IDM00046" value="${caseDto.clinicalManifestations.rashOrder}" code="1,2,3" />
				</td>--%>
				<th>皮疹形态：</th>
				<td>
					<ehr:dic-radio name="clinicalManifestations.measlesShape" dicmeta="IDM00605" value="${caseDto.clinicalManifestations.measlesShape}" code="1,2,3,4" />
				</td>
			</tr>
			<tr>
				<th>耳后淋巴结肿大：</th>
				<td>
					<ehr:dic-radio name="clinicalManifestations.enanthema" dicmeta="PH00002" value="${caseDto.clinicalManifestations.enanthema}" code="2,1,4" />				
				</td>
			</tr>
			<tr>
				<th>枕后淋巴结肿大：</th>
				<td>
					<ehr:dic-radio name="clinicalManifestations.isRashPigmentation" dicmeta="PH00002" value="${caseDto.clinicalManifestations.isRashPigmentation}" code="2,1,5" />
				</td>
				<%--<th>l．糠麸样脱屑：</th>
				<td>
					<ehr:dic-radio name="clinicalManifestations.chaffBranSampleDebond" dicmeta="PH00002" value="${caseDto.clinicalManifestations.chaffBranSampleDebond}" code="2,1,5" />				
				</td>	--%>
			</tr>
			<tr>
				<th>颈部淋巴结肿大：</th>
				<td>
					<ehr:dic-radio name="clinicalManifestations.chestPain" dicmeta="IDM00606" value="${caseDto.clinicalManifestations.chestPain}" code="1,2,3,4" />				
				</td>

			</tr>
			<tr>
				<th>死亡：</th>
				<td><ehr:dic-radio name="attackCondition.isDeath" dicmeta="PH00001" value="${caseDto.attackCondition.isDeath}" code="2,1,4" onchange="toggleOther('attackCondition.isDeath','isDeath','1');"/>						
					<span style="display:none;" id="isDeath"> 死亡日期:
						<tag:dateInput name="attackCondition.dieDt" date="${caseDto.attackCondition.dieDt}" pattern="yyyy/MM/dd" style="width:180px;"/></span>
				</td>

				
			</tr>
		</table>
		</fieldset>
			<fieldset>
				<legend>5．接触史</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 40%" />
						<col style="width: 60%" />
					</colgroup>
					<tr>
						<th>a．出疹前21天内与其他确诊病例接触：</th>
						<td>
							<ehr:dic-radio name="epidemiologicalSurvey.eruptionContact" dicmeta="PH00002" value="${caseDto.epidemiologicalSurvey.eruptionContact}"
										   onchange="toggleOther('epidemiologicalSurvey.eruptionContact','divContact','1')" code="2,1" />
							<div id="divContact">
								<span>若有，地点</span>
								<ehr:dic-radio name="epidemiologicalSurvey.eruptionContactAddr" dicmeta="IDM00300"
											   value="${caseDto.epidemiologicalSurvey.eruptionContactAddr}" />
								<%--<input type="text" id ='eruptionContactAddr' name="epidemiologicalSurvey.eruptionContactAddr"
									   value="${caseDto.epidemiologicalSurvey.eruptionContactAddr}" reg='{"maxlength":"100"}' style="width:150px"/>--%>
							</div>
						</td>
					</tr>
					<%--<tr>
						<th>b．发病前7-21天经常出入人群密集的公共场所（如歌舞厅、医院等）：</th>
						<td>
							<ehr:dic-radio name="epidemiologicalSurvey.eruptionContactPublicPlace" dicmeta="PH00002" value="${caseDto.epidemiologicalSurvey.eruptionContactPublicPlace}" code="2,1" />
						</td>
					</tr>
					<tr>
						<th>c．风疹疫苗免疫史：</th>
						<td>
							<ehr:dic-radio name="epidemiologicalSurvey.rubellaVaccine" dicmeta="PH00002" value="${caseDto.epidemiologicalSurvey.rubellaVaccine}"
										   onchange="toggleOther('epidemiologicalSurvey.rubellaVaccine','divVaccine','1')"  code="2,1,4" />
							<div id="divVaccine">
								<span>若有，最近一次接种日期：</span>
								<tag:dateInput nullToToday="true" name="epidemiologicalSurvey.lastRubellaVaccineDt" pattern="yyyy/MM/dd" date="${caseDto.epidemiologicalSurvey.lastRubellaVaccineDt}" onlypast="true" style="width: 100px"></tag:dateInput>
								免疫史来源：<ehr:dic-list dicmeta="IDM00069"
													name="epidemiologicalSurvey.immunizationHistorySource"
													code="1,2,4"
													value="${caseDto.epidemiologicalSurvey.immunizationHistorySource }" />
								共接种剂次数：<input type="text" name="epidemiologicalSurvey.inoculateNum" value="${caseDto.epidemiologicalSurvey.inoculateNum}" reg='{"maxlength":"10"}' style="width:50px"/>
							</div>

					</tr>
					<tr>
						<th>c. 麻痹前最近一次服苗 1) 日期：</th>
						<td><tag:dateInput name="epidemiologicalSurvey.palsyLastDt"
										   pattern="yyyy/MM/dd"
										   date="${caseDto.epidemiologicalSurvey.palsyLastDt }" /></td>

						</td>
					</tr>
					<tr>
						<th>d．除麻疹疫苗外，还接种以下何苗：</th>
						<td>
							<ehr:dic-radio name="epidemiologicalSurvey.exceptRubella" dicmeta="IDM00049" value="${caseDto.epidemiologicalSurvey.exceptRubella}" code="1,2,3,4" />
						</td>
					</tr>--%>

				</table>
			</fieldset>
        <fieldset>
            <legend>6．实验室检查</legend>
            <table class="posttable">
                <colgroup>
                    <col style="width: 25%" />
                    <col style="width: 25%" />
                    <col style="width: 15%" />
                    <col style="width: 35%" />
                </colgroup>
					<tr>
						<th>a．第一份急性期血标本采集日期：</th>
						<td >
							<tag:dateInput nullToToday="true" name="labExamine.serumSpecimenDate" pattern="yyyy/MM/dd" date="${caseDto.labExamine.serumSpecimenDate}" onlypast="true" style="width: 100px"></tag:dateInput>
						</td>
						<th>IgM抗体：</th>
						<td>
							<ehr:dic-radio name="labExamine.measlesIgm" dicmeta="PH00004" value="${caseDto.labExamine.measlesIgm}" code="2,1" />
						</td>
					</tr>
					<tr>
						<th>第二份急性期血标本采集日期：</th>
						<td >
							<tag:dateInput nullToToday="true" name="labExamine.dengueIgmCollectTime" pattern="yyyy/MM/dd" date="${caseDto.labExamine.dengueIgmCollectTime}" onlypast="true" style="width: 100px"></tag:dateInput>
						</td>
						<th>IgM抗体：</th>
						<td>
							<ehr:dic-radio name="labExamine.ruIgm" dicmeta="PH00004" value="${caseDto.labExamine.ruIgm}" code="2,1" />
						</td>						
					</tr>
					<%--<tr>
						<th>b．是否采集病原学检测标本：</th>
						<td colspan="3">
							<ehr:dic-radio name="labExamine.etiologySpecimens" dicmeta="PH00001" value="${caseDto.labExamine.etiologySpecimens}" code="2,1" />						
						</td>
					</tr>--%>
					<tr>
						<th>咽拭子病毒分离：</th>
						<td>
							<ehr:dic-radio name="labExamine.nasopharyngealSwab" dicmeta="PH00004" value="${caseDto.labExamine.nasopharyngealSwab}" code="2,1" />						
						</td>
						<th>采集日期：</th>
						<td>
							<tag:dateInput nullToToday="true" name="labExamine.nasopharyngealSwabDate" pattern="yyyy/MM/dd" date="${caseDto.labExamine.nasopharyngealSwabDate}" onlypast="true" style="width: 100px"></tag:dateInput>
						</td>
					</tr>
					<tr>
						<th>尿标本病毒分离：</th>
						<td>
							<ehr:dic-radio name="labExamine.urineAliquot" dicmeta="PH00004" value="${caseDto.labExamine.urineAliquot}" code="2,1" />						
						</td>
						<th>采集日期：</th>
						<td>
							<tag:dateInput nullToToday="true" name="labExamine.urineAliquotDate" pattern="yyyy/MM/dd" date="${caseDto.labExamine.urineAliquotDate}" onlypast="true" style="width: 100px"></tag:dateInput>						
						</td>
					</tr>
					<%--<tr>
						<th>其他标本：</th>
						<td>
							<input type="text" name="labExamine.otherSpecimen" value="${caseDto.labExamine.otherSpecimen}" reg='{"maxlength":"100"}' style="width:150px"/>
						</td>
						<th>采集日期：</th>
						<td>
							<tag:dateInput nullToToday="true" name="labExamine.otherSpecimenDate" pattern="yyyy/MM/dd" date="${caseDto.labExamine.otherSpecimenDate}" onlypast="true" style="width: 100px"></tag:dateInput>
						</td>
					</tr>
					<tr>
						<th>麻疹病毒鉴定结果：</th>
						<td>
							<ehr:dic-radio name="labExamine.morbillivirusResult" dicmeta="PH00004" value="${caseDto.labExamine.morbillivirusResult}" code="2,1" />						
						</td>
						<th>基因型：</th>
						<td>
							<input type="text" name="labExamine.morbillivirusGenotype" value="${caseDto.labExamine.morbillivirusGenotype}" reg='{"maxlength":"100"}' style="width:150px"/>
						</td>						
					</tr>
					<tr>
						<th>风疹病毒鉴定结果：</th>
						<td>
							<ehr:dic-radio name="labExamine.rubellavirusResult" dicmeta="PH00004" value="${caseDto.labExamine.rubellavirusResult}" code="2,1" />
						</td>
						<th>基因型：</th>
						<td>
							<input type="text" name="labExamine.rubellavirusGenotype" value="${caseDto.labExamine.rubellavirusGenotype}" reg='{"maxlength":"100"}' style="width:150px"/>
						</td>						
					</tr>--%>
				</table>
			</fieldset>
<%--       <fieldset>
            <legend>6．防疫措施</legend>
            <table class="posttable">
                <colgroup>
                    <col style="width: 15%" />
                    <col style="width: 85%" />
                </colgroup>
					<tr>
						<th>a．病人隔离情况：</th>
						<td>
							<textarea name="epidemicFocusClose.patientIsolationCond" style="width: 90%" rows=10 reg='{"maxlength":"500"}'>${caseDto.epidemicFocusClose.patientIsolationCond}</textarea>						
						</td>
					</tr>
					<tr>
						<th>b．疫点处理情况：</th>
						<td>
							<textarea name="epidemicFocusClose.farmSet" style="width: 90%" rows=10 reg='{"maxlength":"500"}'>${caseDto.epidemicFocusClose.farmSet}</textarea>
						</td>
					</tr>
				</table>
			</fieldset>	--%>
			<fieldset>
			    <legend>7.病例分类</legend>
			    <table class="posttable">
				    <colgroup>
	                    <col style="width: 20%" />
	                    <col style="width: 30%" />
	                     <col style="width: 20%" />
	                    <col style="width: 30%" />
	                </colgroup>
			        <tr>
			        	<th>病例最后分类：</th>
			            <td><ehr:dic-radio name="otherCondition.caseType" dicmeta="IDM00040" code="2,3,5" value="${caseDto.otherCondition.caseType }" 
			            	onchange="toggleOther('otherCondition.caseType','caseType','3');"/></td>
			        </tr>
			        <tr id="caseType"  style="display:none;">
			        	<th>确诊病例依据：</th>
			            <td colspan="3"><ehr:dic-checkbox name="otherCondition.diagnoseAccording" dicmeta="IDM00607" value="${caseDto.otherCondition.diagnoseAccording }"/></td>
			        </tr>
			         <tr>
			        	<th>疫情性质：</th>
			            <td colspan="3">
							<ehr:dic-radio name="epidemiologicalSurvey.measlesOutbreakCase" dicmeta="IDM00608"  value="${caseDto.epidemiologicalSurvey.measlesOutbreakCase}"
			            	onchange="toggleOther('epidemiologicalSurvey.measlesOutbreakCase','measlesOutbreakCase','2');"/>
			            	<span id="measlesOutbreakCase"  style="display:none;">
			            	首发病例发病日期：<tag:dateInput style="width: 100px" name="epidemiologicalSurvey.firstCaseDt" pattern="yyyy/MM/dd" date="${caseDto.epidemiologicalSurvey.firstCaseDt}" /> 
			            	首发病例编号：<input type="text" name="epidemiologicalSurvey.outbreakNo" value="${caseDto.epidemiologicalSurvey.outbreakNo}"
			                                 reg='{"maxlength":"13"}' style="width: 80px;"/>
			                                               首发病例姓名：<input type="text" name="epidemiologicalSurvey.firstCaseName" value="${caseDto.epidemiologicalSurvey.firstCaseName}"
			                                 reg='{"maxlength":"13"}' style="width: 80px;"/>
			            	</span>
			            </td>
			        </tr>
			    </table>
			</fieldset>
		<fieldset>
			<table class="posttable">
				<colgroup>
					<col style="width: 28%"/>
					<col style="width: 22%"/>
					<col style="width: 28%"/>
					<col style="width: 22%"/>
				</colgroup>
				<tr>
					<th>调查人员签字：</th>
					<td>
						<ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/>
						<input type="hidden" name="caseInformation.modifyRespondents" value="${caseDto.caseInformation.modifyRespondents}"/>
					</td>
					<th>调查单位：</th>
					<td>
						<ehr:org code="${caseDto.caseInformation.modifySurveyOrg}"/>
						<input type="hidden" name="caseInformation.modifySurveyOrg" value="${caseDto.caseInformation.modifySurveyOrg}"/>
					</td>
				</tr>
			</table>
		</fieldset>
		</div>
	</div>
</form>

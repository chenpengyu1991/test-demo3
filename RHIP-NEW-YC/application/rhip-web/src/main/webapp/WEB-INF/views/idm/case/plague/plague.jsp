<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<script	src="${pageContext.request.contextPath}/js/views/idm/case/edit.js"	type="text/javascript"></script>
<script	src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js"	type="text/javascript"></script>
<script	src="${pageContext.request.contextPath}/js/views/idm/case/plague.js"	type="text/javascript"></script>
<script type="text/javascript">
	
</script>
<c:if test="${isPrint != 1}">
    <jsp:include page="../caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
    <div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
		<i class="popno"> 鼠疫个案调查表<br /> <span>（甲类传染病）</span>
		</i> <input type="hidden" name="idmId" value="${idmId}" id="idmId" /> <input
			type="hidden" name="leList" id="leList">
		<input type="hidden" name="efcList" id="efcList">
		<input type="hidden" name="caseStatus" id="caseStatusId" value="${caseDto.caseStatus}">
		<div class="postdiv">
				<table class="posttable" style="text-align: right;">
					<colgroup>
						<col style="width: 50%" />
						<col style="width: 50%" />
					</colgroup>
					<tr>
						<td style="text-align: left;">国标码：<input type="text" name="attackCondition.gbcode"
                                       value="${caseDto.attackCondition.gbcode}" style="width: 160px;" reg='{"maxlength":"14"}'/></td>
						<td style="text-align: right;">病例编码：<input type="text" name="caseInformation.mediRecordNum"
                                        value="${caseDto.caseInformation.mediRecordNum}"
                                        style="width: 160px;" reg='{"maxlength":"14"}' /></td>
					</tr>
				</table>
			<fieldset>
				<legend>1. 一般情况</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 18%" />
						<col style="width: 32%" />
						<col style="width: 18%" />
						<col style="width: 32%" />
					</colgroup>
					<tr>
						<th>1.1病人姓名：</th>
						<td><input type="text" name="generalCondition.name"
							value="${caseDto.generalCondition.name}" reg='{"maxlength":"100"}' /></td>
						<th>1.2性别：</th>
						<td><ehr:dic-list name="generalCondition.gender"
								dicmeta="GBT226112003"
								value="${caseDto.generalCondition.gender}" code="1,2" /></td>
					</tr>
					<tr>
						<th>1.3年龄（岁）：</th>
						<td><input type="text"
							name="generalCondition.age"
							value="${caseDto.generalCondition.age}" reg='{"maxlength":"6"}'/></td>
					</tr>
					<tr>
				       	<th>常住类型：</th>
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
					<%-- <tr>
						<th>1.5职业：</th>
                        <td colspan="3">
                            <ehr:dic-list dicmeta="GBT6565"
                                          name="generalCondition.occupation" width="180px;"
                                          value="${caseDto.generalCondition.occupation}"
                                          code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120208,CV020120209,CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120299"
                                          onchange="toggleOtherSC('generalCondition.occupation','occupationForAdd','CV020120299');"/>
                            <span id="occupationForAdd" style="display: none">
							<input type="text" name="generalCondition.occupationOther"
                                   value="${caseDto.generalCondition.occupationOther}"
                                   placeholder="若选择其他，请描叙" style="width: 200px;" reg='{"maxlength":"20"}'/>
                            </span>
                        </td>
					</tr> --%>
					<tr>
			            <th>1.5职业：</th>
			            <td colspan="3">
			            	<ehr:dic-list id="occupationId" dicmeta="GBT6565" name="generalCondition.occupation" width="150px;" value="${caseDto.generalCondition.occupation}"
                                  code="CV020120210,CV020120211,CV020120213,CV020120209,CV020120229,CV020120208,CV020120216,CV020120214,CV020120217"
                                 />
                                 <%--  onchange="toggleOtherSC('generalCondition.occupation','occupationOtherPart','CV020120299');"/> --%>
			            	 <%-- <span  id="occupationOtherPart" style="display: none">
		                         <input type="text" name="generalCondition.occupationOther" value="${caseDto.generalCondition.occupationOther}"
		                                reg='{"maxlength":"30"}' placeholder="若选择其他，请描叙" style="width: 40%;"/>
		                     </span> --%>
			            </td>
			        </tr>
					<tr>
						<th>1.6父亲姓名：</th>
						<td><input type="text" name="generalCondition.fatherName"
							value="${caseDto.generalCondition.fatherName}" reg='{"maxlength":"50"}' /></td>
						<th>父亲单位：</th>
						<td><input type="text" name="generalCondition.fatherUnit"
							value="${caseDto.generalCondition.fatherUnit}" reg='{"maxlength":"20"}'/></td>
					</tr>
					<tr>
						<th>父亲住址：</th>
						<td><input type="text"
							name="generalCondition.fatherAddr"
							value="${caseDto.generalCondition.fatherAddr}" reg='{"maxlength":"100"}'/></td>
					</tr>
					<tr>
						<th>母亲姓名：</th>
						<td><input type="text" name="generalCondition.motherName"
							value="${caseDto.generalCondition.motherName}" reg='{"maxlength":"50"}' /></td>
						<th>母亲单位：</th>
						<td><input type="text" name="generalCondition.motherUnit"
							value="${caseDto.generalCondition.motherUnit} " reg='{"maxlength":"20"}'/></td>
					</tr>
					<tr>
						<th>母亲住址：</th>
						<td><input type="text"
							name="generalCondition.motherAddr"
							value="${caseDto.generalCondition.motherAddr}" reg='{"maxlength":"100"}'/></td>
					</tr>
					<tr>
						<th>1.7发病时间：</th>
						<td><tag:dateInput id="pathogenesisDate" name="attackCondition.pathogenesisDate"
								pattern="yyyy/MM/dd"
								date="${caseDto.attackCondition.pathogenesisDate}" reg='{"compare":["firstVisitDate","le","发病时间不能晚于初诊日期"]}'/></td>
						<th>1.8发病地点：</th>
						<td><input type="text"
							name="attackCondition.pathogenesisPlace"
							value="${caseDto.attackCondition.pathogenesisPlace}" reg='{"maxlength":"100"}'></td>
					</tr>
					<tr>
						<th>1.9初诊日期：</th>
						<td><tag:dateInput id="firstVisitDate" name="attackCondition.firstVisitDate"
								pattern="yyyy/MM/dd"
								date="${caseDto.attackCondition.firstVisitDate}" reg='{"compare":["pathogenesisDate","ge","初诊日期不能早于发病时间"]}'/></td>
						<th>1.10初诊单位：</th>
						<td><input type="text" name="attackCondition.firstVisitUnit"
							value="${caseDto.attackCondition.firstVisitUnit}"
							reg='{"maxlength":"100"}' /></td>
					</tr>
					<tr>
						<th>1.11住院日期：</th>
						<td><tag:dateInput id="inhosDateId" name="attackCondition.inhosDate"
								pattern="yyyy/MM/dd" date="${caseDto.attackCondition.inhosDate}" reg='{"compare":["outHospitalDateId","le","住院日期不能晚于出院日期"]}'/></td>
						<th>1.12出院日期：</th>
						<td><tag:dateInput id="outHospitalDateId" name="attackCondition.outHospitalDate"
								pattern="yyyy/MM/dd"
								date="${caseDto.attackCondition.outHospitalDate}" reg='{"compare":["inhosDateId","ge","出院日期不能早于住院日期"]}'/></td>
					</tr>
					<tr>
						<th>1.13住院单位：</th>
						<td><input type="text"
							name="attackCondition.admissionHospital"
							value="${caseDto.attackCondition.admissionHospital}"
							reg='{"maxlength":"100"}' /></td>
						<th>1.14报告单位：</th>
						<td>
                            <ehr:org code="${caseDto.caseInformation.reportOrg}" />
                            <input type="hidden" name="caseInformation.reportOrg"
							value="${caseDto.caseInformation.reportOrg}"
							reg='{"maxlength":"100"}' />
                        </td>
					</tr>
					<tr>
						<th>1.15报告时间：</th>
						<td>
                            <fmt:formatDate pattern="yyyy/MM/dd" value="${caseDto.caseInformation.reportDate}"/>
                            <tag:dateInput name="caseInformation.reportDate"
								pattern="yyyy/MM/dd"
								date="${caseDto.caseInformation.reportDate}" style="display: none" />
                        </td>
						<th>1.16诊断：</th>
						<td><ehr:dic-radio dicmeta="PH00002"
								name="attackCondition.diagnosisFlag"
								value="${caseDto.attackCondition.diagnosisFlag}" code="1,2" /></td>
					</tr>
					<tr>
						<th>1.17死亡日期：</th>
						<td><tag:dateInput name="attackCondition.dieDt"
								date="${caseDto.attackCondition.dieDt}" pattern="yyyy/MM/dd" /></td>
						<th>1.18病程：</th>
						<td><input type="text"
							name="attackCondition.diagnosisCourseDay"
							value="${caseDto.attackCondition.diagnosisCourseDay}" reg='{"maxlength":"20"}'/>天</td>
					</tr>
				</table>
			</fieldset>

			<fieldset>
				<legend>2. 临床表现</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 22%" />
						<col style="width: 28%" />
						<col style="width: 18%" />
						<col style="width: 32%" />
					</colgroup>
					<tr>
						<th>2.1淋巴结肿大：</th>
						<td colspan="3"><ehr:dic-radio dicmeta="PH00002"
								name="clinicalManifestations.lymphadenectasis"
								value="${ caseDto.clinicalManifestations.lymphadenectasis}"
								code="1,2"
                                onchange="toggleOther('clinicalManifestations.lymphadenectasis','lymphadenectasisForAdd',1);"/>
                            <span id="lymphadenectasisForAdd" style="display: none; margin-left:20px;">
                                部位：
                                <input type="text"
                                       name="clinicalManifestations.lymphadenectasisPart"
                                       value="${ caseDto.clinicalManifestations.lymphadenectasisPart}"
                                       reg='{"maxlength":"500"}' style="width: 100px;" />
                            </span>
                        </td>
					</tr>
					<tr>
						<th>2.2咳嗽：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.cough"
								value="${ caseDto.clinicalManifestations.cough}" code="1,2"></ehr:dic-radio>
						</td>
					</tr>
					<tr>
						<th>胸痛：</th>
						<td colspan="3"><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.chestPain"
								value="${ caseDto.clinicalManifestations.chestPain}" code="1,2"></ehr:dic-radio></td>
					</tr>
					<tr>
						<th>泡沫痰：</th>
						<td colspan="3"><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.frothySputum"
								value="${ caseDto.clinicalManifestations.frothySputum}"
								code="1,2"></ehr:dic-radio></td>
					</tr>
					<tr>
						<th>2.3呼吸困难：</th>
						<td><ehr:dic-radio dicmeta="PH00002"
								name="clinicalManifestations.dyspnea"
								value="${ caseDto.clinicalManifestations.dyspnea}" code="1,2" /></td>
					</tr>
					<tr>
						<th>2.4皮肤黏膜发绀：</th>
						<td><ehr:dic-radio dicmeta="PH00002"
								name="clinicalManifestations.skinMucCy"
								value="${ caseDto.clinicalManifestations.skinMucCy}" code="1,2" /></td>
					</tr>
					<tr>
						<th>2.5恶寒、高热：</th>
						<td><ehr:dic-radio dicmeta="PH00001"
								name="clinicalManifestations.coldHeat"
								value="${ caseDto.clinicalManifestations.coldHeat}" code="1,2" /></td>
					</tr>
					<tr>
						<th>2.6最高体温：</th>
						<td><input type="text"
							name="clinicalManifestations.highestTemperature"
							value="${ caseDto.clinicalManifestations.highestTemperature}" style="width: 100px;" reg='{"maxlength":"20"}'/>℃</td>
					</tr>
					<tr>
						<th>2.7剧烈头痛：</th>
						<td><ehr:dic-radio dicmeta="PH00002"
								name="clinicalManifestations.headache"
								value="${ caseDto.clinicalManifestations.headache}" code="1,2" /></td>
					</tr>
					<tr>
						<th>2.8狂躁：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.mania"
								value="${ caseDto.clinicalManifestations.mania}" code="1,2" />
						</td>
					</tr>
					<tr>
						<th>谵妄：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.coma"
								value="${ caseDto.clinicalManifestations.coma}" code="1,2" /></td>
					</tr>
					<tr>
						<th>神志不清：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.obnubilation"
								value="${ caseDto.clinicalManifestations.obnubilation}"
								code="1,2" /></td>
					</tr>
					<tr>
						<th>2.9皮下及黏膜出血：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.subcutaneousMucosaBleed"
								value="${caseDto.clinicalManifestations.subcutaneousMucosaBleed }"
								code="1,2" /></td>
					</tr>
					<tr>
						<th>血尿：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.hematuresis"
								value="${caseDto.clinicalManifestations.hematuresis }"
								code="1,2" /></td>
					</tr>
					<tr>
						<th>血便：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.bloodyStool"
								value="${caseDto.clinicalManifestations.bloodyStool }"
								code="1,2" /></td>
					</tr>
					<tr>
						<th>血性呕吐物：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.bloodyVomit"
								value="${ caseDto.clinicalManifestations.bloodyVomit}"
								code="1,2" /></td>
					</tr>
					<tr>
						<th>2.10收缩压/舒张压：</th>
						<td><input type="text"
							name="clinicalManifestations.bloodPressure"
							value="${caseDto.clinicalManifestations.bloodPressure }" style="width: 100px;" reg='{"maxlength":"20"}'/>mmHg</td>
					</tr>
					<tr>
						<th>2.11胸透：</th>
						<td colspan="3"><textarea style="width: 100%" rows="5"
								name="labExamine.chestXrays" reg='{"maxlength":"100"}'>${caseDto.labExamine.chestXrays}</textarea></td>
					</tr>
					<tr>
						<th>2.12实验室检查：</th>
						<td colspan="3">
							<div class="repeattable">
                                <div class="toolbarsublist">
                                    <a href="javascript:void(0)" id="addLeList" ><b class="xinz">添加</b></a>
                                </div>
								<table id="leTable">
									<colgroup>
										<col style="width: 15%" />
										<col style="width: 15%" />
										<col style="width: 15%" />
										<col style="width: 25%" />
										<col style="width: 15%" />
										<col style="width: 15%" />
									</colgroup>
									<thead>
										<tr>
											<th class="centerth">日期</th>
											<th class="centerth">标本</th>
											<th class="centerth">项目</th>
											<th class="centerth">方法</th>
											<th class="centerth">结果</th>
											<th class="centerth">操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="labExamine" items="${caseDto.idmListLeList}"
											varStatus="status">
											<tr id='${status.count}'>
												<td field="leDt"><ehr:tip><fmt:formatDate value='${labExamine.leDt}' pattern='yyyy/MM/dd' /></ehr:tip></td>
												<td field="sampleStr"><ehr:tip>${labExamine.sampleStr}</ehr:tip></td>
												<td field="sampleId" style="display:none;"><ehr:tip>${labExamine.sampleId}</ehr:tip></td>
												<td field="other"><ehr:tip>${labExamine.other}</ehr:tip></td>
												<td field="method"><ehr:tip>${labExamine.method}</ehr:tip></td>
												<td field="checkResult"><ehr:tip>${labExamine.checkResult}</ehr:tip></td>
												<td class="btnsublist" field="btn">
                                                    <a href="javascript:void(0)" onclick="plagueCase.editTr(this, 'leList')">修改</a>&nbsp;
                                                    <a href="javascript:void(0)" onclick="caseEdit.removeTr(this)">删除</a>
                                                </td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>3. 流行病学调查</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 22%" />
						<col style="width: 28%" />
						<col style="width: 20%" />
						<col style="width: 30%" />
					</colgroup>
					<tr>
						<th>3.1患者发病前10小时去过外地：</th>
						<td colspan="3"><ehr:dic-radio dicmeta="PH00001"
								name="epidemiologicalSurvey.outHistory"
								value="${caseDto.epidemiologicalSurvey.outHistory}" code="1,2"
                                onchange="toggleOther('epidemiologicalSurvey.outHistory','outHistoryFromAdd',1)"/></td>
					</tr>
                    <tr style="display: none;" id="outHistoryFromAdd">
                        <td colspan="4" style="padding: 0px;">
                            <table>
                                <colgroup>
                                    <col style="width: 22%"/>
                                    <col style="width: 28%"/>
                                    <col style="width: 20%"/>
                                    <col style="width: 30%"/>
                                </colgroup>
                                <tr>
                                    <th>3.2该地是否有鼠疫流行：</th>
                                    <td><ehr:dic-radio dicmeta="PH00002"
                                                       name="epidemiologicalSurvey.plague"
                                                       value="${caseDto.epidemiologicalSurvey.plague}" code="1,2"/></td>
                                    <th>该地详细地址：</th>
                                    <td><input type="text"
                                               name="epidemiologicalSurvey.plagueAddr"
                                               value="${caseDto.epidemiologicalSurvey.plagueAddr}"
                                               reg='{"maxlength":"100"}'/></td>
                                </tr>
                            </table>
                        </td>
                    </tr>
					<tr>
						<th>3.3是否接触过疑似病人：</th>
						<td><ehr:dic-radio dicmeta="PH00001"
								name="epidemiologicalSurvey.contactPatients"
								value="${caseDto.epidemiologicalSurvey.contactPatients }"
								code="1,2" /></td>
					</tr>
					<tr>
						<th>3.4预防接种史：注射时间：</th>
						<td><tag:dateInput name="epidemiologicalSurvey.vaccinationDt"
								date="${caseDto.epidemiologicalSurvey.vaccinationDt }"
								pattern="yyyy/MM/dd" /></td>
						<th>菌苗种类：</th>
						<td><input type="text"
							name="epidemiologicalSurvey.vaccinumCategory"
							value="${caseDto.epidemiologicalSurvey.vaccinumCategory }"
							reg='{"maxlength":"100"}' /></td>
					</tr>
					<tr>
						<th>3.5过去健康状况：</th>
						<td><ehr:dic-radio dicmeta="FS10248"
								name="epidemiologicalSurvey.healthCondition" code="1,2,5"
								value="${caseDto.epidemiologicalSurvey.healthCondition }" /></td>
					</tr>
					<tr>
						<th>3.6病家及院内人口数：</th>
						<td><input type="text"
							name="epidemiologicalSurvey.homePopulationNum"
							value="${caseDto.epidemiologicalSurvey.homePopulationNum }" reg='{"maxlength":"20"}'/></td>
					</tr>
					<tr>
						<th>3.7家庭中或院内有无其他人患鼠疫：</th>
						<td><ehr:dic-radio dicmeta="PH00002"
								name="epidemiologicalSurvey.homePlague"
								value="${ caseDto.epidemiologicalSurvey.homePlague}" code="1,2" /></td>
					</tr>
					<tr>
						<th>3.8疫村情况：</th>
					</tr>
					<tr>
						<th>3.8.1户数：</th>
						<td><input type="text"
							name="epidemiologicalSurvey.diseaseVillageHouseholds"
							value="${caseDto.epidemiologicalSurvey.diseaseVillageHouseholds }"
							reg='{"maxlength":"20"}'/></td>
						<th>人口数：</th>
						<td><input type="text"
							name="epidemiologicalSurvey.diseaseVillagePopulationNum"
							value="${caseDto.epidemiologicalSurvey.diseaseVillagePopulationNum }"
							reg='{"maxlength":"20"}' /></td>
					</tr>
					<tr>
						<th>男：</th>
						<td><input type="text"
							name="epidemiologicalSurvey.diseaseVillageMNum"
							value="${caseDto.epidemiologicalSurvey.diseaseVillageMNum }"
							reg='{"maxlength":"20"}' /></td>
						<th>女：</th>
						<td><input type="text"
							name="epidemiologicalSurvey.diseaseVillageFNum"
							value="${caseDto.epidemiologicalSurvey.diseaseVillageFNum }"
							reg='{"maxlength":"20"}' /></td>
					</tr>
					<tr>
						<th>3.8.2地理交通情况（附地图）：</th>
						<td><input type="text"
							name="epidemiologicalSurvey.diseaseVillageTraffic"
							value="${caseDto.epidemiologicalSurvey.diseaseVillageTraffic}" reg='{"maxlength":"100"}'/></td>
					</tr>
					<tr>
						<th>3.8.3病死鼠发现倩况：</th>
					</tr>
					<tr>
						<th>种类：</th>
						<td><input type="text"
							name="epidemiologicalSurvey.dieMouseCategory"
							value="${caseDto.epidemiologicalSurvey.dieMouseCategory}" reg='{"maxlength":"20"}'/></td>
						<th>只数：</th>
						<td><input type="text"
							name="epidemiologicalSurvey.dieMouseNum"
							value="${caseDto.epidemiologicalSurvey.dieMouseNum }" reg='{"maxlength":"20"}'/></td>
					</tr>
					<tr>
						<th>发现日期：</th>
						<td><tag:dateInput name="epidemiologicalSurvey.dieMouseDt"
								date="${caseDto.epidemiologicalSurvey.dieMouseDt }"
								pattern="yyyy/MM/dd" /></td>
						<th>发现地点：</th>
						<td><input type="text"
							name="epidemiologicalSurvey.dieMouseAddr"
							value="${caseDto.epidemiologicalSurvey.dieMouseAddr}"
							reg='{"maxlength":"100"}' /></td>
					</tr>
					<tr>
						<th>3.8.4病死鼠鼠疫检出情况：</th>
					</tr>
					<tr>
						<th>种类：</th>
						<td><input type="text"
							name="epidemiologicalSurvey.dieMousePlagueCategory"
							value="${caseDto.epidemiologicalSurvey.dieMousePlagueCategory}" reg='{"maxlength":"20"}'/></td>
						<th>只数：</th>
						<td><input type="text"
							name="epidemiologicalSurvey.dieMousePlagueNum"
							value="${caseDto.epidemiologicalSurvey.dieMousePlagueNum}"
							reg='{"maxlength":"20"}' /></td>
					</tr>
					<tr>
						<th>检出日期：</th>
						<td><tag:dateInput
								name="epidemiologicalSurvey.dieMousePlagueDt"
								date="${caseDto.epidemiologicalSurvey.dieMousePlagueDt }"
								pattern="yyyy/MM/dd" /></td>
					</tr>
					<tr>
						<th>3.8.5蚤类检出情况：</th>
					</tr>
					<tr>
						<th>种类：</th>
						<td><input type="text"
							name="epidemiologicalSurvey.fleaCategory"
							value="${caseDto.epidemiologicalSurvey.fleaCategory }" reg='{"maxlength":"20"}'/></td>
						<th>组成：</th>
						<td><input type="text" name="epidemiologicalSurvey.fleaForm"
							value="${caseDto.epidemiologicalSurvey.fleaForm}" reg='{"maxlength":"20"}'/></td>
					</tr>
					<tr>
						<th>检出日期：</th>
						<td><tag:dateInput name="epidemiologicalSurvey.fleaDt"
								date="${caseDto.epidemiologicalSurvey.fleaDt}"
								pattern="yyyy/MM/dd" /></td>
						<th>只数：</th>
						<td><input type="text" name="epidemiologicalSurvey.fleaNum"
							value="${caseDto.epidemiologicalSurvey.fleaNum}"
							reg='{"maxlength":"20"}' /></td>
					</tr>
					<tr>
						<th>3.8.6室内鼠密度：</th>
						<td><input type="text"
							name="epidemiologicalSurvey.inMouseDensity"
							value="${ caseDto.epidemiologicalSurvey.inMouseDensity}" reg='{"maxlength":"20"}'/></td>
						<th>蚤指数：</th>
						<td><input type="text"
							name="epidemiologicalSurvey.inMouseFleaExponent"
							value="${caseDto.epidemiologicalSurvey.inMouseFleaExponent}"
							reg='{"maxlength":"20"}' /></td>
					</tr>
					<tr>
						<th>3.8.7室外鼠密度：</th>
						<td><input type="text"
							name="epidemiologicalSurvey.outMouseDensity"
							value="${ caseDto.epidemiologicalSurvey.outMouseDensity}" reg='{"maxlength":"20"}'/></td>
						<th>蚤指数：</th>
						<td><input type="text"
							name="epidemiologicalSurvey.outMouseFleaExponent"
							value="${caseDto.epidemiologicalSurvey.outMouseFleaExponent}" /></td>
					</tr>
					<tr>
						<th>3.8.8周围有无历史疫区（包括人类鼠疫疫区、地方性动物鼠疫疫区）：</th>
						<td><ehr:dic-radio dicmeta="PH00002"
								name="epidemiologicalSurvey.historicalEpidemicArea"
								value="${caseDto.epidemiologicalSurvey.historicalEpidemicArea}"
								code="1,2" /></td>
					</tr>
					<tr>
						<th>3.9疫源地处理：</th>
						<td colspan="3">
                            <%--不能折行，显示会有问题--%>
							<textarea name="epidemicFocusClose.infectiousFocusDispose" reg='{"maxlength":"200"}' style="width: 100%">${caseDto.epidemicFocusClose.infectiousFocusDispose}</textarea>
						</td>
					</tr>
					<tr>
						<th>3.10密切接触者登记：</th>
						<td colspan="3">
							<div id="contactedList">
								<jsp:include page="contactedList.jsp"></jsp:include>
							</div>
						</td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>4. 转归</legend>
				<table class="posttable">
					<tr>
						<td><ehr:dic-radio dicmeta="CV550102"
								name="otherCondition.outcomeCode"
								value="${caseDto.otherCondition.outcomeCode}" code="1,4" /></td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>5. 并发症</legend>
				<table class="posttable">
					<tr>
						<td><input type="text" name="otherCondition.complications"
							value="${caseDto.otherCondition.complications }"
							reg='{"maxlength":"100"}' /></td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>6. 小结</legend>
				<table class="posttable">
					<tr>
						<td><textarea name="otherCondition.surveySummary" reg='{"maxlength":"800"}' style="width: 100%">${caseDto.otherCondition.surveySummary}</textarea></td>
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
						<td><ehr:org
								code="${caseDto.caseInformation.modifySurveyOrg}"/></td>
						<th>调查者：</th>
						<td><ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/></td>
					</tr>
					<tr>
						<th>审查者：</th>
                        <td><ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/></td>
                        <%--<td><input type="text" name="caseInformation.auditor" value="${caseDto.caseInformation.auditor}"/></td>--%>
						<th>调查时间：</th>
						<td><tag:dateInput name="caseInformation.modifySurveyDate"
								pattern="yyyy/MM/dd"
								date="${caseDto.caseInformation.modifySurveyDate}" /></td>
					</tr>
					<tr style="display:none;">
			             <td>
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


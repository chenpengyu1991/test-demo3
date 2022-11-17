<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>

<script
	src="${pageContext.request.contextPath}/js/views/idm/case/edit.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/js/views/idm/case/leptospirosis.js"
	type="text/javascript"></script>
	
<script type="text/javascript">
</script>
<c:if test="${isPrint != 1}">
    <jsp:include page="../caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
    <div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
		<i class="popno"> 钩体病个案调查表<br /> <span>（乙类传染病）</span>
		</i>
		<input type="hidden" name="idmId" value="${idmId}" id="idmId" />
		 <input type="hidden" name="leList" id="leList">
		   <table class="posttable">
		        <colgroup>
		            <col style="width: 25%"/>
		            <col style="width: 55%"/>
		            <col style="width: 20%"/>
		        </colgroup>
		        <tr>
		            <td style="text-align: left;">
                          	国标编码：<input type="text" name="generalCondition.gbcode" value="${caseDto.generalCondition.gbcode}" reg='{"maxlength":"14"}'/>
		            </td>
					<td>
						${rootDicItem.itemName}
						<ehr:dic-town-street-village streetId="revillage_address" townId="retown_address" streetName="generalCondition.restreet" townName="generalCondition.retownShip"
													 streetValue="${caseDto.generalCondition.restreet}" townValue="${caseDto.generalCondition.retownShip}" width="140px;"/>
					</td>
					<td style="text-align: right;">
                          	 病例编码：<input type="text" name="caseInformation.mediRecordNum" reg='{"maxlength":"14"}' value="${caseDto.caseInformation.mediRecordNum}" style="width:150px"/>
		            </td>
		        </tr>
		    </table>
		<div class="postdiv">
			<fieldset>
				<legend>一、基本情况</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 100px; width: 15%" />
						<col style="min-width: 260px; width: 35%" />
						<col style="min-width: 180px; width: 30%" />
						<col style="min-width: 180px; width: 20%" />
					</colgroup>
					<tr>
						<th>1.患者姓名：</th>
						<td><input type="text" name="generalCondition.name"
							value="${caseDto.generalCondition.name }" reg='{"maxlength":"100"}'/></td>
						<th>(如患者年龄<14岁，则家长姓名：</th>
						<td><input type="text" name="generalCondition.parentsName"
							value="${caseDto.generalCondition.parentsName }" reg='{"maxlength":"50"}'/>)</td>
					</tr>
					<tr>
						<th>2.性别：</th>
						<td><ehr:dic-radio dicmeta="FS10006"
								name="generalCondition.gender"
								value="${caseDto.generalCondition.gender }" /></td>
					</tr>
					<tr>
						<th>3.年龄：</th>
						<td><input type="text" name="generalCondition.age"
							value="${caseDto.generalCondition.age }" reg='{"maxlength":"6"}'/>岁</td>
					</tr>
					<tr>
						<th>4.民族：</th>
						<td><ehr:dic-list name="generalCondition.nation"
								dicmeta="GBT3304" value="${caseDto.generalCondition.nation }"></ehr:dic-list>
						</td>
					</tr>
					<tr>
						<th>5.职业：</th>
						<td><ehr:dic-list name="generalCondition.occupation"
								dicmeta="GBT6565"
								value="${caseDto.generalCondition.occupation }"
								 code="CV020120210,CV020120211,CV020120212,CV020120213,CV020120202,CV020120209,CV020120229,CV020120208,CV020120216,CV020120214,CV020120217,CV020120299" /><input
							type="text" name="generalCondition.occupationOther"
							value="${caseDto.generalCondition.occupationOther}"
							reg='{"maxlength":"30"}' style="width: 100px"
							id="occupationOther" /></td>
					</tr>
					<tr>
						<th>6.所在单位：</th>
						<td><input type="text" name="generalCondition.unitName"
							value="${caseDto.generalCondition.unitName }" reg='{"maxlength":"70"}'/></td>
						<th>7.联系电话：</th>
						<td><input type="text" name="generalCondition.contactPhone"
							value="${caseDto.generalCondition.contactPhone }" reg='{"regex":"phone","maxlength":20}'/></td>
					</tr>
					<tr>
                    	<th>8.常住类型：</th>
                    	<td>
		            		<ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005"
                        		value="${caseDto.generalCondition.floatPopulation}" onchange="caseEdit.toggerAddress()"/>
                    	</td>
                    </tr>
					<tr>
						<th>9.家庭住址：</th>
						<td colspan="3">
							<ehr:dic-town-street-village streetId="pastreet_address" townId="patown_address" streetName="generalCondition.pastreet" townName="generalCondition.patownShip"
														 streetValue="${caseDto.generalCondition.pastreet}" townValue="${caseDto.generalCondition.patownShip}" width="140px;"
														 villageId="pavillage_address" villageName="generalCondition.paGroup" villageValue="${caseDto.generalCondition.paGroup}"/>
							<input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${caseDto.generalCondition.pahouseNumber}"
                                   reg='{"maxlength":"50"}'  style="width: 180px;">
                        	<span id="spanPaNumber">(门牌号)</span>
                        </td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>二、发病情况</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 100px; width: 15%" />
						<col style="min-width: 260px; width: 35%" />
						<col style="min-width: 180px; width: 30%" />
						<col style="min-width: 180px; width: 20%" />
					</colgroup>
					<tr>
						<th>1.发病日期：</th>
						<td><tag:dateInput id="pathogenesisDate" nullToToday="true"
								name="attackCondition.pathogenesisDate" onlypast="true"
								date="${caseDto.attackCondition.pathogenesisDate }"
								pattern="yyyy/MM/dd" reg='{"compare":["clinicDate","le","发病日期不能晚于就诊日期"]}'></tag:dateInput></td>
						<th>2.就诊日期：</th>
						<td><tag:dateInput id="clinicDate" 
								name="attackCondition.clinicDate" onlypast="true"
								date="${caseDto.attackCondition.clinicDate }"
								pattern="yyyy/MM/dd" reg='{"compare":["pathogenesisDate","ge","就诊日期不能早于发病日期"]}'></tag:dateInput></td>
					</tr>
					<tr>
						<th>3.发病地点：</th>
						<td>
								<input reg='{"maxlength":"100"}' type="text" name="attackCondition.pathogenesisPlace" value="${caseDto.attackCondition.pathogenesisPlace}"/>
						<th></th>
						<td></td>
					</tr>
					<tr>
						<th>4.住院医院：</th>
						<td><input type="text"
							name="attackCondition.admissionHospital"
							value="${caseDto.attackCondition.admissionHospital }" reg='{"maxlength":"50"}'/></td>
						<th>5.住院号：</th>
						<td><input type="text" name="attackCondition.admissionNo"
							value="${caseDto.attackCondition.admissionNo }" reg='{"maxlength":"20"}'/></td>
					</tr>
					<tr>
						<th>6.住院日期：</th>
						<td><tag:dateInput id="inhosDate" 
								name="attackCondition.inhosDate" onlypast="true"
								date="${caseDto.attackCondition.inhosDate }"
								pattern="yyyy/MM/dd" reg='{"compare":["outHospitalDate","le","住院日期不能晚于出院日期"]}'></tag:dateInput></td>
						<th>7.出院日期：</th>
						<td><tag:dateInput id="outHospitalDate" 
								name="attackCondition.outHospitalDate" onlypast="true"
								date="${caseDto.attackCondition.outHospitalDate }"
								pattern="yyyy/MM/dd" reg='{"compare":["inhosDate","ge","出院日期不能早于住院日期"]}'></tag:dateInput></td>
					</tr>
					<tr>
						<th>8.入院诊断：</th>
						<td colspan="3"><ehr:dic-radio dicmeta="IDM00191"
								name="attackCondition.inhosDiagnosis"
								value="${caseDto.attackCondition.inhosDiagnosis }"></ehr:dic-radio>
							<input type="text" name="attackCondition.inhosDiagnosisOther" value="${caseDto.attackCondition.inhosDiagnosisOther}"
							style="width: 80px;" id="inhosDiagnosisOther" reg='{"maxlength":"200"}'/></td>
					</tr>

					<tr>
						<th>9.入院诊断日期：</th>
						<td><tag:dateInput 
								name="attackCondition.inhosDiagnosisDate" onlypast="true"
								date="${caseDto.attackCondition.inhosDiagnosisDate }"
								pattern="yyyy/MM/dd"></tag:dateInput></td>
					</tr>
					<tr>
						<th>10.临床分型：</th>
						<td colspan="3"><ehr:dic-list
								name="attackCondition.clinicalClassification" dicmeta="IDM00192"
								value="${caseDto.attackCondition.clinicalClassification }"></ehr:dic-list>
						</td>
					</tr>
					<tr>
						<th>11.出院诊断：</th>
						<td colspan="3"><ehr:dic-list
								name="attackCondition.outDiagnosis" dicmeta="IDM00040"
								value="${caseDto.attackCondition.outDiagnosis }" code="1,2,3,99"></ehr:dic-list>
							<input type="text" name="attackCondition.outDiagnosisOther"
							value="${caseDto.attackCondition.outDiagnosisOther }" id="outDiagnosisOther" style="width:200px" reg='{"maxlength":"200"}'></td>
					</tr>
					<tr>
						<th>12.治疗情况：</th>
						<td colspan="3">抗菌药物名称: <input type="text"
							name="attackCondition.antibacterialDrugName" style="width: 80px;"
							value="${caseDto.attackCondition.antibacterialDrugName }" reg='{"maxlength":"50"}'/>&nbsp;&nbsp;首次使用时间:
							<tag:dateInput nullToToday="true"
								name="attackCondition.firstUseTime" onlypast="true"
								pattern="yyyy/MM/dd" style="width: 80px;"
								date="${caseDto.attackCondition.firstUseTime }"></tag:dateInput>&nbsp;&nbsp;
							剂量： <input type="text" name="attackCondition.firstUseUnit"
							style="width: 80px;"
							value="${caseDto.attackCondition.firstUseUnit }" reg='{"maxlength":"50"}'/>疗程 &nbsp;&nbsp; 赫氏反应： <ehr:dic-radio
								dicmeta="FS10018" name="attackCondition.herxheimerReaction"
								value="${caseDto.attackCondition.herxheimerReaction }"
								code="1,2"></ehr:dic-radio> &nbsp;&nbsp;是否用激素治疗: <ehr:dic-radio
								dicmeta="FS10009" name="attackCondition.hormonotherapy"
								value="${caseDto.attackCondition.hormonotherapy }" code="2,1"></ehr:dic-radio>
						</td>
					</tr>
					<tr>
						<th>13.转归：</th>
						<td colspan="3"><ehr:dic-radio dicmeta="CV550102"
								name="otherCondition.outcomeCode" code="1,2,3,4"
								value="${caseDto.otherCondition.outcomeCode }"></ehr:dic-radio>
								<span id="otherConditionDeathTime">(日期：
								<tag:dateInput nullToToday="true"
									name="otherCondition.deathTime" onlypast="true"
									date="${caseDto.otherCondition.deathTime }" pattern="yyyy/MM/dd"
									style="width: 80px;" reg='{"compare":["inhosDate","ge","死亡日期不能早于住院日期"]}'></tag:dateInput>
									死于<input type="text" name="otherCondition.deathCause" value="${caseDto.otherCondition.deathCause}" reg='{"maxlength":"100"}'
	                    					style="width: 100px;"/>)
								</span></td>
					</tr>
					<tr>
						<th>14.报告日期：</th>
						<td> <tag:dateInput id="reportDate" name="caseInformation.reportDate" pattern="yyyy/MM/dd" onlypast="true" date="${caseDto.caseInformation.reportDate}"
		                                   reg='{"required":"true"}' style="display:none"/>
		                    <fmt:formatDate pattern="yyyy/MM/dd" value="${caseDto.caseInformation.reportDate}"/></td>
					</tr>
				</table>
			</fieldset>

			<fieldset>
				<legend>三、症状和体征</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 120px; width: 20%" />
						<col style="min-width: 120px; width: 17%" />
						<col style="min-width: 120px; width: 100px;" />
						<col style="min-width: 120px; width: 17%" />
						<col style="min-width: 120px; width: 13%" />
						<col style="min-width: 120px; width: 18%" />
					</colgroup>
					<tr>
						<th>发热：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.fever"
								value="${caseDto.clinicalManifestations.fever }" code="1,2"
                                onchange="toggleOther('clinicalManifestations.fever','feverPart',1);"></ehr:dic-radio>
						</td>
                        <td colspan="4" style="display: none;" id="feverPart">
                            <table>
                                <colgroup>
                                    <col style="min-width: 120px; width: 100px;" />
									<col style="min-width: 120px; width: 35%" />
                                </colgroup>
                                <tr>
                                    <th>最高体温：</th>
                                    <td colspan="3"><input type="text"
                                               name="clinicalManifestations.highestTemperature"
                                               value="${caseDto.clinicalManifestations.highestTemperature }"
                                               reg='{"maxlength":"20"}' style="width: 100px;"/>&nbsp;&nbsp;&nbsp;&nbsp;
                                        	发热持续时间：<input type="text"
                                                      name="clinicalManifestations.heatingDuration"
                                                      value="${caseDto.clinicalManifestations.heatingDuration }"
                                                      reg='{"maxlength":"20"}' style="width: 100px;"/>
                                    </td>
                                </tr>
                            </table>
                    </tr>
					<tr>
						<th>畏寒：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.chills"
								value="${caseDto.clinicalManifestations.chills }" code="1,2"></ehr:dic-radio>
						</td>
						<th>腿痛：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.legPain"
								value="${caseDto.clinicalManifestations.legPain }" code="1,2"></ehr:dic-radio></td>
						<th>全身肌痛：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.wholeBodyPain"
								value="${caseDto.clinicalManifestations.wholeBodyPain }"
								code="1,2"></ehr:dic-radio></td>
					</tr>
					<tr>
						<th>腓肠肌痛：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.gastrocnemiusPain"
								value="${caseDto.clinicalManifestations.gastrocnemiusPain }"
								code="1,2"></ehr:dic-radio></td>
						<th>乏力：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.lassitude"
								value="${caseDto.clinicalManifestations.lassitude }" code="1,2"></ehr:dic-radio>
						</td>
						<th>眼结膜充血：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.conjunctivalCongestion"
								value="${caseDto.clinicalManifestations.conjunctivalCongestion }"
								code="1,2"></ehr:dic-radio></td>
					</tr>
					<tr>
						<th>腓肠肌压痛：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.gastrocnemiusTenderness"
								value="${caseDto.clinicalManifestations.gastrocnemiusTenderness }"
								code="1,2"></ehr:dic-radio></td>
						<th>淋巴结肿大：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.superficialLymphNodes"
								value="${caseDto.clinicalManifestations.superficialLymphNodes }" code="1,2"></ehr:dic-radio>
						</td>
						<th>呕吐：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.vomit"
								value="${caseDto.clinicalManifestations.vomit }" code="1,2"></ehr:dic-radio>
						</td>
					</tr>
					<tr>
						<th>腹痛：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.stomachache"
								value="${caseDto.clinicalManifestations.stomachache }"
								code="1,2"></ehr:dic-radio></td>
						<th>腰酸：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.backache"
								value="${caseDto.clinicalManifestations.backache }"
								code="1,2"></ehr:dic-radio></td>
						<th>腹泻：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.diarrhea"
								value="${caseDto.clinicalManifestations.diarrhea }" code="1,2"></ehr:dic-radio>
						</td>
					</tr>
					<tr>
						<th>咳嗽：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.cough"
								value="${caseDto.clinicalManifestations.cough }" code="1,2"></ehr:dic-radio>
						</td>
						<th>黄疸：</th>
						<td><ehr:dic-radio dicmeta="IDM00551"
								name="clinicalManifestations.jaundice"
								value="${caseDto.clinicalManifestations.jaundice }" ></ehr:dic-radio></td>
						<%-- <th>咯血：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.hemoptysis"
								value="${caseDto.clinicalManifestations.hemoptysis }" code="1,2"></ehr:dic-radio>
						</td> --%>
						<th>鼻衄：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.epistaxis"
								value="${caseDto.clinicalManifestations.epistaxis }" code="1,2"></ehr:dic-radio>
						</td>
					</tr>
					<tr>
						<th>皮肤巩膜黄染：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.skinScleraYellow"
								value="${caseDto.clinicalManifestations.skinScleraYellow }"
								code="1,2"></ehr:dic-radio></td>
						<th>肝肿大：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.hepatomegaly"
								value="${caseDto.clinicalManifestations.hepatomegaly }"
								code="1,2"></ehr:dic-radio></td>
						<th>皮肤出血点：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.bleedingSpotsSkin"
								value="${caseDto.clinicalManifestations.bleedingSpotsSkin }"
								code="1,2"></ehr:dic-radio></td>
					</tr>
					<%-- <tr>

						<th>少 尿：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.oliguria"
								value="${caseDto.clinicalManifestations.oliguria }" code="1,2"></ehr:dic-radio>
						</td>
					</tr> --%>
					<tr>
						<%-- <th>血尿：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.hematuresis"
								value="${caseDto.clinicalManifestations.hematuresis }"
								code="1,2"></ehr:dic-radio></td> --%>
						<th>脑膜脑炎症状：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.meningealIrritation"
								value="${caseDto.clinicalManifestations.meningealIrritation }"
								code="1,2"></ehr:dic-radio></td>
						<th>肾区疼痛：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.renalPain"
								value="${caseDto.clinicalManifestations.renalPain }" code="1,2"></ehr:dic-radio>
						</td>
						<th>头痛：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.headache"
								value="${caseDto.clinicalManifestations.headache }" code="1,2"></ehr:dic-radio>
						</td>
					</tr>
					<tr>
						<th>颈项强直：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.neckRigidity"
								value="${caseDto.clinicalManifestations.neckRigidity }"
								code="1,2"></ehr:dic-radio></td>
						<th>抽搐：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.convulsion"
								value="${caseDto.clinicalManifestations.convulsion }" code="1,2"></ehr:dic-radio>
						</td>
						<th>瘫痪：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.paralysis"
								value="${caseDto.clinicalManifestations.paralysis }" code="1,2"></ehr:dic-radio>
						</td>
					</tr>
					<tr>
						<th>克布氏征阳性：</th>
						<td>
						<ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.gBrinellPositive"
								value="${caseDto.clinicalManifestations.gBrinellPositive}" code="1,2"></ehr:dic-radio>
						</td>
						<th>脾肿大：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="clinicalManifestations.splenomegaly"
								value="${caseDto.clinicalManifestations.splenomegaly }"
								code="1,2"></ehr:dic-radio></td>
					</tr>
					<tr>
						<th>意识障碍：</th>
						<td></td>
					</tr>
					<tr>
						<th>嗜睡：</th>
						<td><ehr:dic-radio dicmeta="FS10018" name="clinicalManifestations.sleepiness" value="${caseDto.clinicalManifestations.sleepiness }" code="1,2"></ehr:dic-radio></td>
						<td></td>
						<td></td>
						<th>谵妄：</th>
						<td><ehr:dic-radio dicmeta="FS10018" name="clinicalManifestations.delirium" value="${caseDto.clinicalManifestations.delirium }" code="1,2"></ehr:dic-radio></td>
					</tr>
					<tr>
						<th>昏睡：</th>
						<td><ehr:dic-radio dicmeta="FS10018" name="clinicalManifestations.headacheDizziness" value="${caseDto.clinicalManifestations.headacheDizziness }" code="1,2"></ehr:dic-radio></td>
						<td></td>
						<td></td>
						<th>昏迷：</th>
						<td><ehr:dic-radio dicmeta="FS10018" name="clinicalManifestations.coma" value="${caseDto.clinicalManifestations.coma }" code="1,2"></ehr:dic-radio></td>
					</tr>
					<tr>
						<th>出血：</th>
						<td colspan="5"><ehr:dic-checkbox  dicmeta="IDM00552" name="clinicalManifestations.hemorrhage" value="${caseDto.clinicalManifestations.hemorrhage }"></ehr:dic-checkbox></td>
					</tr>
					<tr>
						<th>小便：</th>
						<td colspan="5"><ehr:dic-checkbox  dicmeta="IDM00553" name="clinicalManifestations.urine" value="${caseDto.clinicalManifestations.urine }" 
										onchange="toggleOtherCK('clinicalManifestations.urine', 'urine', 5);"></ehr:dic-checkbox>
						 	 <span id="urine" style="display: none">
	                               <ehr:dic-radio  code="03,04,05,06" dicmeta="CV0450015" name="clinicalManifestations.proteinuria" value="${caseDto.clinicalManifestations.proteinuria}"></ehr:dic-radio>
                    		</span>
                    		 
                    	</td>
					</tr>
					<tr>
						<th>其他：</th>
                    	<td><input type="text" name="clinicalManifestations.other"
							value="${caseDto.clinicalManifestations.other}" /></td>
					</tr>
					<tr>
					    <th>临床类型：</th>
			            <td colspan="3">
			            	<ehr:dic-radio dicmeta="IDM00554" name="clinicalManifestations.clinicalTypeLevel" value="${caseDto.clinicalManifestations.clinicalTypeLevel}" />
			            </td>
			       </tr>
			       <tr>
					    <th>治疗简况（抗生素、激素，种类、剂量、疗程）：</th>
					    
			            <td colspan="4"><textarea rows="4" cols="100" name="otherCondition.cureCondition" style="width: 80%" reg='{"maxlength":"500"}'>
                					${caseDto.otherCondition.cureCondition}</textarea>
			            	
			            </td>
			       </tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>四、实验室检查</legend>
				<div class="repeattable">
					<div class="toolbarsublist">
						<a href="javascript:void(0)" id="addLeList"><b class="xinz">添加</b></a>
					</div>
					<table id="leTable">
						<thead>
							<tr>
								<th class="centerth">检查项目</th>
								<th class="centerth">首次采样时间</th>
								<th class="centerth">首次检查结果</th>
								<th class="centerth">第二次采样时间</th>
								<th class="centerth">第二次检查结果</th>
								<th class="centerth">操 作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="labExamine" items="${caseDto.idmListLeList}"
											varStatus="status">
											<tr id='${status.count}'>
												<td field="checkItemStr"><ehr:tip>${labExamine.checkItemStr }</ehr:tip></td>
												<td field="checkItem" style="display:none;"><ehr:tip>${labExamine.checkItem}</ehr:tip></td>
												<td field="sampleDyFirst"><ehr:tip><fmt:formatDate value='${labExamine.sampleDyFirst}' pattern="yyyy/MM/dd" /></ehr:tip></td>
												<td field="sampleResultFirst"><ehr:tip>${labExamine.sampleResultFirst}</ehr:tip></td>
												<td field=sampleDySecond><ehr:tip><fmt:formatDate value='${labExamine.sampleDySecond}' pattern="yyyy/MM/dd" /></ehr:tip></td>
												<td field="sampleResultSecond"><ehr:tip>${labExamine.sampleResultSecond}</ehr:tip></td>
												<td class="btnsublist" field="btn">
                                                    <a href="javascript:void(0)" onclick="letopspirosisCase.editTr(this, 'leList')">修改</a>&nbsp;
                                                    <a href="javascript:void(0)" onclick="letopspirosisCase.removeRe(this)">删除</a>
                                                </td>
											</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</fieldset>

			<fieldset>
				<legend>五、接触史及有关因素调查</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 250px; width: 35%" />
						<col style="min-width: 160px; width: 25%" />
						<col style="min-width: 100px; width: 15%" />
						<col style="min-width: 210px; width: 25%" />
					</colgroup>
					<tr>
						<th>发病前1月内接触可疑疫水：</th>
						<td><ehr:dic-radio dicmeta="FS10018"
								name="epidemiologicalSurvey.oneMonthDoubtfulWater" code="1,2"
								value="${caseDto.epidemiologicalSurvey.oneMonthDoubtfulWater }"
                                onchange="toggleOther('epidemiologicalSurvey.oneMonthDoubtfulWater','oneMonthDoubtfulWaterFromAddrd',1)"></ehr:dic-radio>
						</td>
						<td></td>
						<td></td>
					</tr>
                    <tr style="display: none;" id="oneMonthDoubtfulWaterFromAddrd">
                        <td colspan="4" style="padding: 0px;">
                            <table>
                                <colgroup>
                                    <col style="width: 35%"/>
                                    <col style="width: 25%"/>
                                    <col style="width: 15%"/>
                                    <col style="width: 25%"/>
                                </colgroup>
                                <tr>
                                    <th class="oneMonthDoubtfulWater">时间：</th>
                                    <td class="oneMonthDoubtfulWater">
                                    	<tag:dateInput nullToToday="true"
                                             name="epidemiologicalSurvey.oneMonthDoubtfulWaterDt"
                                             onlypast="true"
                                             date="${caseDto.epidemiologicalSurvey.oneMonthDoubtfulWaterDt }"
                                             pattern="yyyy/MM/dd"/>
                                     </td>
                                    <th>接触方式：</th>
                                    <td><ehr:dic-list
                                            name="epidemiologicalSurvey.doubtfulContactWay"
                                            dicmeta="IDM00193"
                                            value="${caseDto.epidemiologicalSurvey.doubtfulContactWay }"></ehr:dic-list>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
					<tr>
						<th>发病前1月内是否接触鼠类：</th>
						<td><ehr:dic-radio dicmeta="PH00001" code="1,2,4"
								name="epidemiologicalSurvey.oneMonthMouse"
								value="${caseDto.epidemiologicalSurvey.oneMonthMouse }"></ehr:dic-radio>
						</td>
					</tr>
					<tr class="oneMonthMouse">
						<th>如是 ，接触方式：</th>
						<td colspan="3"><ehr:dic-radio dicmeta="IDM00155"
								name="epidemiologicalSurvey.oneMonthMouseContact"
								value="${caseDto.epidemiologicalSurvey.oneMonthMouseContact }"></ehr:dic-radio>
							<input type="text" name="epidemiologicalSurvey.otherPublicPlace"
							value="${caseDto.epidemiologicalSurvey.otherPublicPlace }" id="otherPublicPlace" reg='{"maxlength":"20"}'/></td>
					</tr>
					<tr>
						<th>发病前1月内是否接触其它动物及其排泄物：</th>
						<td><ehr:dic-radio dicmeta="FS10101"
								name="epidemiologicalSurvey.oneMonthMouseAnimal"
								value="${caseDto.epidemiologicalSurvey.oneMonthMouseAnimal }"></ehr:dic-radio>
						</td>
					</tr>
					<tr class="oneMonthMouseAnimal">
						<th>动物种类：</th>
						<td><ehr:dic-radio dicmeta="IDM00194"
								name="epidemiologicalSurvey.animalCategory"
								value="${caseDto.epidemiologicalSurvey.animalCategory }"></ehr:dic-radio>
						</td>
					</tr>
					<tr>
						<th>钩体病疫苗预防接种史：</th>
						<td><ehr:dic-radio dicmeta="PH00002" code="1,2,4"
								name="epidemiologicalSurvey.leptospirosisVaccination"
								value="${caseDto.epidemiologicalSurvey.leptospirosisVaccination }"></ehr:dic-radio>
						</td>
					</tr>
					<tr class="leptospirosisVaccination">
						<th>如有 ，最近一次接种时间：</th>
						<td><tag:dateInput nullToToday="true"
								name="epidemiologicalSurvey.lastInoculateDt" onlypast="true"
								date="${caseDto.epidemiologicalSurvey.lastInoculateDt }"
								pattern="yyyy/MM/dd"></tag:dateInput>
						</td>
						<th>接种剂量：</th>
						<td><input type="text"
							name="epidemiologicalSurvey.inoculateMetrology"
							value="${caseDto.epidemiologicalSurvey.inoculateMetrology }" reg='{"maxlength":"20"}'/>毫升
						</td>
					</tr>
					<tr class="leptospirosisVaccination">
						<th>接种次数：</th>
						<td><input type="text"
							name="epidemiologicalSurvey.inoculateNum"
							value="${caseDto.epidemiologicalSurvey.inoculateNum }" reg='{"maxlength":"20"}'/>次</td>
						<th>接种部位：</th>
						<td><input type="text"
							name="epidemiologicalSurvey.inoculatePart"
							value="${caseDto.epidemiologicalSurvey.inoculatePart }" reg='{"maxlength":"20"}'/></td>
					</tr>
					<tr>
						<th>既往是否患过此病：</th>
						<td><ehr:dic-radio dicmeta="FS10101"
								name="epidemiologicalSurvey.pph"
								value="${caseDto.epidemiologicalSurvey.pph }"></ehr:dic-radio></td>
					</tr>
					<tr class="epidemiologicalSurveyPph">
						<th>如是，诊断单位：</th>
						<td><input type="text" name="epidemiologicalSurvey.diagnosisUnit"
							value="${caseDto.epidemiologicalSurvey.diagnosisUnit }" reg='{"maxlength":"100"}'/></td>
						<th>时间：</th>
						<td><tag:dateInput nullToToday="true"
								name="epidemiologicalSurvey.diagnosisDt"
								date="${caseDto.epidemiologicalSurvey.diagnosisDt }"
								onlypast="true" pattern="yyyy/MM/dd"></tag:dateInput></td>
					</tr>
				</table>
			</fieldset>
				<fieldset>
				<legend>六、流行病调查</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 120px; width: 25%" />
						<col style="min-width: 240px; width: 25%" />
						<col style="min-width: 120px; width: 15%" />
						<col style="min-width: 240px; width: 35%" />
					</colgroup>
					<tr>
						<th>受感染方式：</th>
						<td colspan="3"><ehr:dic-checkbox dicmeta="IDM00600" name="otherCondition.modeInfection" value="${caseDto.otherCondition.modeInfection}"
												onchange="toggleOtherCK('otherCondition.modeInfection','modeInfection',99);"/>
								
						<span id="modeInfection">
								<input type="text" name="otherCondition.modeInfectionOther" value="${caseDto.otherCondition.modeInfectionOther}" reg='{"maxlength":"50"}'
                   					   style="width: 100px;"/>
								</span>
						</td>

					</tr>
					<tr>
						<th>病家使用水源种类：</th>
						<td colspan="3"><ehr:dic-radio name="epidemiologicalSurvey.drinkingWater" dicmeta="IDM00034" code="5,3"
                       								 value="${caseDto.epidemiologicalSurvey.drinkingWater}"/> 
						</td>

					</tr>
					<tr>
						<th>是否有饮生水习惯：</th>
						<td colspan="3"><ehr:dic-radio dicmeta="PH00002" name="beforeDiseaseDiet.drinkingHistory"
				            			 code="1,2" value="${caseDto.beforeDiseaseDiet.drinkingHistory}"/> 
						</td>

					</tr>
					<tr>
						<th>家畜排泄物处理：</th>
						<td colspan="3"><ehr:dic-radio name="epidemicFocusClose.isExcretaDisi" dicmeta="IDM00601" value="${caseDto.epidemicFocusClose.isExcretaDisi}" 
										 />
						</td>
					</tr>
					<tr>
						<th>病家居所周围环境 </th>
					</tr>
					<tr>
						<th>鼠洞：</th>
						<td ><ehr:dic-radio name="epidemiologicalSurvey.inMouseDensity" dicmeta="IDM00602" value="${caseDto.epidemiologicalSurvey.inMouseDensity}" 
										 />
						</td>
						<th>鼠密度：</th>
						<td ><input type="text"
								name="epidemiologicalSurvey.outMouseDensity"
								value="${caseDto.epidemiologicalSurvey.outMouseDensity }" reg='{"maxlength":"20"}'/>	
						</td>
					</tr>	
					<tr>
						<th>发病前一周下雨否：</th>
						<td><ehr:dic-radio name="epidemiologicalSurvey.rainFall" dicmeta="PH00002" code="1,2" value="${caseDto.epidemiologicalSurvey.rainFall}" 
										 /></td>
						<th>降雨量：</th>
						<td><input type="text"
							name="epidemiologicalSurvey.rainFallNum"
							value="${caseDto.epidemiologicalSurvey.rainFallNum }" reg='{"maxlength":"10"}'/>	
						</td>
					</tr>
					<tr>
						<th>其他：</th>
						<td colspan="3">
							<input type="text" name="epidemiologicalSurvey.other" value="${caseDto.epidemiologicalSurvey.other}" reg='{"maxlength":"200"}'/>
						</td>
					</tr>
					<tr>
					    <th>在本疫点病例发病时间顺序：</th>
			            <td>
			            	第<input type="text" name="epidemiologicalSurvey.dysenteryDtOrder" value="${caseDto.epidemiologicalSurvey.dysenteryDtOrder}" 
							    reg='{"maxlength":"20"}' cssClass="width30" style="width: 30%"/>例
			            </td>
					</tr>					
				</table>
			</fieldset>
			<fieldset>
				<legend>七、治疗情况</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 120px; width: 15%" />
						<col style="min-width: 240px; width: 35%" />
						<col style="min-width: 120px; width: 15%" />
						<col style="min-width: 240px; width: 35%" />
					</colgroup>
					<tr>
						<th>是否用激素治疗：</th>
						<td><ehr:dic-radio dicmeta="FS10009"
								name="otherCondition.hormonotherapyFlg" code="2,1" value="${caseDto.otherCondition.hormonotherapyFlg }"></ehr:dic-radio></td>
						<th class="antibacterials">所用抗菌药物：</th>
						<td class="antibacterials"><input type="text" name="otherCondition.antibacterials"
							value="${caseDto.otherCondition.antibacterials}" reg='{"maxlength":"50"}'/></td>
					</tr>
					<tr class="antibacterials">
						<th>治疗剂量：</th>
						<td><input type="text"
							name="otherCondition.antibacterialsPertime"
							value="${caseDto.otherCondition.antibacterialsPertime }" reg='{"maxlength":"50"}'/></td>
					</tr>
					<tr class="antibacterials">
						<th>治疗天数：</th>
						<td><input type="text"
							name="otherCondition.antibacterialsDay"
							value="${caseDto.otherCondition.antibacterialsDay }" reg='{"maxlength":"20"}'/></td>
						<th>治疗开始时间：</th>
						<td><tag:dateInput nullToToday="true"
								name="otherCondition.therapyTime" onlypast="true"
								date="${caseDto.otherCondition.therapyTime }"
								pattern="yyyy/MM/dd"></tag:dateInput></td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
			    <legend>八、调查小结</legend>
			    <table class="posttable">
			        <tr>
			            <td>
			                <textarea name="epidemicFocusClose.farmSummary" style="width: 100%; height: 150px;" reg='{"maxlength":"200"}'>${caseDto.epidemicFocusClose.farmSummary}</textarea>
			            </td>
			        </tr>
			    </table>
			</fieldset>
			<fieldset>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 120px; width: 15%" />
						<col style="min-width: 240px; width: 35%" />
						<col style="min-width: 120px; width: 15%" />
						<col style="min-width: 240px; width: 35%" />
					</colgroup>
					<tr>
						<th>调查者单位：</th>
						<td><ehr:org code="${caseDto.caseInformation.modifySurveyOrg}"></ehr:org></td>
						<th>调查者：</th>
						<td><ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"></ehr:user></td>
					</tr>
					<tr>
						<th>审查者：</th>
                        <td><ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/></td>
						<th>调查时间：</th>
						<td><tag:dateInput name="caseInformation.surveyDate"
								pattern="yyyy/MM/dd"
								date="${caseDto.caseInformation.surveyDate}" /></td>
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

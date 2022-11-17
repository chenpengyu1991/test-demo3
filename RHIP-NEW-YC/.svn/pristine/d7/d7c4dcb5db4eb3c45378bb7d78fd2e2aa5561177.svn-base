<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/mumps.js" type="text/javascript"></script>

<c:if test="${isPrint != 1}">
    <jsp:include page="caseButton.jsp"></jsp:include>
</c:if>
<form id="caseForm">
<input type="hidden" id="idmId" name="idmId" value="${idmId}"/>
	<input type="hidden" name="esList" id="esList"/>
	<input type="hidden" name="efcList" id="efcList"/>
<div class="postcontent <c:if test="${isPrint != 1}">contentfixed</c:if>">
	<i class="popno">流行性腮腺炎个案调查表<br/><span>（丙类传染病）</span></i>
	<table class="posttable">
		<tr style="text-align: right;">
			<td>
				国标码：
				<input type="text" name="generalCondition.gbcode" style="width: 120px;"
					   value="${caseDto.generalCondition.gbcode}"  reg='{"maxlength":"14"}'/>
			</td>
			<td>
				病例编码：
				<input type="text" name="caseInformation.mediRecordNum" style="width: 120px;"
					   value="${caseDto.caseInformation.mediRecordNum}"  reg='{"maxlength":"14"}'/>
			</td>
		</tr>
	</table>
	<div class="postdiv">
		<fieldset>
		<table  class="posttable" >
				<legend>一、病例基本情况</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%" />
						<col style="width: 30%" />
						<col style="width: 20%" />
						<col style="width: 30%" />
					</colgroup>
					<tr>
						<th>1、患者姓名：</th>
						<td colspan="3"><input type="text" name="generalCondition.name" value="${caseDto.generalCondition.name}"
											   reg='{"maxlength":"100"}' style="width: 150px;"/>

					</tr>
					<tr>

						<th>2、性别：</th>
						<td><ehr:dic-radio dicmeta="GBT226112003" name="generalCondition.gender" code="1,2" value="${caseDto.generalCondition.gender}"/></td>
					</tr>
					<tr>
						<th>3、出生日期：</th>
						<td colspan="3"><tag:dateInput name="generalCondition.birthday" date="${caseDto.generalCondition.birthday}" pattern="yyyy/MM/dd" style="width:100px;"/>
							（如出生日期不详，实足年龄
							<input type="text" id="age" name="generalCondition.age" style="width: 60px;" value="${caseDto.generalCondition.age}" reg='{"maxlength":"6"}'/>
							年龄单位：<ehr:dic-radio name="generalCondition.ageUnit" dicmeta="IDM00003" value="${caseDto.generalCondition.ageUnit}"/> )
						</td>
					</tr>
					<tr>
						<th>4、发病日期：</th>
						<td>
							<tag:dateInput id="pathogenesisDateId" name="attackCondition.pathogenesisDate" pattern="yyyy/MM/dd"
										   date="${caseDto.attackCondition.pathogenesisDate}" style="width:100px;"/>
						</td>
					</tr>
					<tr>
						<th>5、家长姓名：</th>
						<td><input type="text" name="generalCondition.parentsName" value="${caseDto.generalCondition.parentsName}" reg='{"maxlength":"70"}'/></td>
					</tr>


					<tr>
						<th>6、病例户口类型：</th>
						<td><ehr:dic-radio dicmeta="CV0201104" name="generalCondition.patientAttribute" code='1,2,3,4' value="${caseDto.generalCondition.patientAttribute}"/></td>

					</tr>
					<tr>
						<th>7、病例户口所在地：</th>
						<td >
							<input type="text" id="hrAddress" name="generalCondition.hrAddress" value="${caseDto.generalCondition.hrAddress}"
	                           			reg='{"maxlength":"100"}' >
						</td>
					</tr>
					<tr>
						<th>8、现家庭住址：</th>
						<td colspan="3">
							<ehr:dic-town-street-village streetId="pastreet_address" townId="patown_address" streetName="generalCondition.pastreet" townName="generalCondition.patownShip"
														 streetValue="${caseDto.generalCondition.pastreet}" townValue="${caseDto.generalCondition.patownShip}" width="140px;"
														 villageId="pavillage_address" villageName="generalCondition.paGroup" villageValue="${caseDto.generalCondition.paGroup}"/>
							<input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${caseDto.generalCondition.pahouseNumber}"
			                        reg='{"maxlength":"50"}'  style="width: 180px;">
			             	<span id="spanPaNumber">(门牌号)</span>>
						</td>
					</tr>
					<tr>
						<th>9、病例就诊医院：</th>
						<td><ehr:dic-radio name="clinicalManifestations.hospitalType" dicmeta="IDM00545"
											   value="${caseDto.clinicalManifestations.hospitalType}" /></td>

					</tr>
					<tr>
						<th>10、病例报告单位：</th>
						<td colspan="3"><ehr:dic-org-list name="caseInformation.reportOrg" value="${caseDto.caseInformation.reportOrg}"/>

						</td>
					</tr>
					<tr>
						<th>11、病例报告日期：</th>
						<td colspan="3"><tag:dateInput name="caseInformation.reportDate" pattern="yyyy/MM/dd"
													   date="${caseDto.caseInformation.reportDate}" style="width:100px;"/>
						</td>

					</tr>

				</table>
		</table>
		</fieldset>
	</div>
	<div class="postdiv">
		<fieldset>
		<table  class="posttable" >
				<legend>二、临床症状和体征</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%" />
						<col style="width: 30%" />
						<col style="width: 20%" />
						<col style="width: 30%" />
					</colgroup>
					<tr>
						<th>1、发热：</th>
						<td colspan="3">
							<ehr:dic-radio name="clinicalManifestations.fever" dicmeta="PH00002" code="1,2" value="${caseDto.clinicalManifestations.fever}"
										   onchange="toggleOther('clinicalManifestations.fever','feverPart1',1);"/>
							<br>
							<div id="feverPart1" style="display: none">
								发热天数：<input type="text" name="clinicalManifestations.heatingDuration" style="width: 80px;"
											value="${caseDto.clinicalManifestations.heatingDuration}" reg='{"maxlength":"20"}'/>天
								最高体温<input type="text" name="clinicalManifestations.highestTemperature" style="width: 80px;"
										   value="${caseDto.clinicalManifestations.highestTemperature}" reg='{"maxlength":"20"}'/>℃
							</div>
						</td>

					</tr>
					<tr>
						<th>2、腮腺非化脓性肿胀：</th>
						<td><ehr:dic-radio dicmeta="IDM00576" name="clinicalManifestations.sxSwel"  value="${caseDto.clinicalManifestations.sxSwel}"/></td>
					</tr>
					<tr>
						<th>3、其他唾液腺非化脓性肿胀：</th>
						<td><ehr:dic-radio dicmeta="IDM00576" name="clinicalManifestations.sxSwelOther"  value="${caseDto.clinicalManifestations.sxSwelOther}"/></td>
					</tr>
					<tr>
						<th>4、含酸性食物胀痛加剧：</th>
						<td>
						<ehr:dic-radio dicmeta="IDM00576" name="clinicalManifestations.sxAcid"  value="${caseDto.clinicalManifestations.sxAcid}"/>
						</td>
					</tr>
					<tr>
						<th>5、脑膜刺激征：</th>
						<td>
							<ehr:dic-radio dicmeta="IDM00576" name="clinicalManifestations.sxMater"  value="${caseDto.clinicalManifestations.sxMater}"/>
						</td>
					</tr>
					<tr>
						<th>6、睾丸胀痛：</th>
						<td><ehr:dic-radio dicmeta="IDM00627" name="clinicalManifestations.sxPain"  value="${caseDto.clinicalManifestations.sxPain}"/></td>
					</tr>

				</table>
		</table>
		</fieldset>
	</div>
	<div class="postdiv">
		<fieldset>
		<table  class="posttable" >
				<legend>三、实验室资料</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%" />
						<col style="width: 30%" />
						<col style="width: 20%" />
						<col style="width: 30%" />
					</colgroup>
					<tr>
						<th>1、病人血标本采集：</th>
						<td colspan="3">
							<ehr:dic-radio dicmeta="PH00002" code="1,2" name="labExamine.sxBloodCollect"  value="${caseDto.labExamine.sxBloodCollect}"/>
						</td>

					</tr>
					<tr>
						<th>2、采集日期：</th>
						<td><tag:dateInput name="labExamine.sxCollectDate" pattern="yyyy/MM/dd"
										   date="${caseDto.labExamine.sxCollectDate}" style="width:100px;"/></td>
					</tr>
					<tr>
						<th>3、腮腺炎特异性IgM抗性：</th>
						<td><ehr:dic-radio dicmeta="PH00004" code="1,2" name="labExamine.sxIgm"  value="${caseDto.labExamine.sxIgm}"/></td>
					</tr>
				</table>
		</table>
		</fieldset>
	</div>
	<div class="postdiv">
		<fieldset>
		<table  class="posttable" >

				<legend>四、流行病学资料</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%" />
						<col style="width: 30%" />
						<col style="width: 20%" />
						<col style="width: 30%" />
					</colgroup>
					<tr>
						<th>1、当地有无同样的病例发生：</th>
						<td colspan="3">
							<ehr:dic-radio dicmeta="PH00002" code="1,2" name="epidemiologicalSurvey.sxSameCase"  value="${caseDto.epidemiologicalSurvey.sxSameCase}"/>
						</td>

					</tr>
					<tr>
						<th>2、发病前2-3周与同样病例有无接触 ：</th>
						<td colspan="3">
							<ehr:dic-radio dicmeta="PH00002" code="1,2" name="epidemiologicalSurvey.sxBeforeTouch"
										   value="${caseDto.epidemiologicalSurvey.sxBeforeTouch}"
							onchange="toggleOther('epidemiologicalSurvey.sxBeforeTouch','sxTouchTripe',1);"/>
							<span id="sxTouchTripe">
								接触方式：<ehr:dic-radio dicmeta="IDM00544"  name="epidemiologicalSurvey.sxTouchTripe"
													value="${caseDto.epidemiologicalSurvey.sxTouchTripe}"/>
							</span>
						</td>
					</tr>
					<tr>
						<th>3、家庭内有无同样的病人 ：</th>
						<td colspan="3">
							<ehr:dic-radio dicmeta="PH00002" code="1,2,4" name="epidemiologicalSurvey.sxFamilySameCase"
										   value="${caseDto.epidemiologicalSurvey.sxFamilySameCase}"
										   onchange="toggleOther('epidemiologicalSurvey.sxFamilySameCase','pertussisContactList1',1);"/>
							<span id="pertussisContactList1">
								<br><jsp:include page="mumps/contactList.jsp"></jsp:include>

							</span>
						</td>
					</tr>
					<tr>
						<th>4、是否接种过腮腺炎疫苗 ：</th>
						<td>
							<ehr:dic-radio dicmeta="IDM00578" name="epidemiologicalSurvey.sxAcceptVaccine"
										   value="${caseDto.epidemiologicalSurvey.sxAcceptVaccine}"
										   onchange="toggleOther('epidemiologicalSurvey.sxAcceptVaccine','sxAcceptLastDate',1);"/>
							<span id="sxAcceptLastDate">
								<br>最后一次接种时间：<tag:dateInput name="epidemiologicalSurvey.sxAcceptLastDate" pattern="yyyy/MM/dd"
															date="${caseDto.epidemiologicalSurvey.sxAcceptLastDate}" style="width:100px;"/>
								<br>接种依据 ：<ehr:dic-radio dicmeta="IDM00577"  name="epidemiologicalSurvey.sxBasis"
														 value="${caseDto.epidemiologicalSurvey.sxBasis}"/>
							</span>
						</td>
					</tr>

					<tr>
						<th>5、发病前3周或病后去过何地 ：</th>
						<td colspan="3">
							<ehr:dic-radio dicmeta="IDM00542" name="epidemiologicalSurvey.sxVisitPlace"
										   value="${caseDto.epidemiologicalSurvey.sxVisitPlace}"
										   onchange="toggleOther('epidemiologicalSurvey.sxVisitPlace','sxPlaceOther',99);"/>
							<span id="sxPlaceOther">
								<input type="text" name="epidemiologicalSurvey.sxPlaceOther" style="width: 80px;"
										   value="${caseDto.epidemiologicalSurvey.sxPlaceOther}" reg='{"maxlength":"20"}'/>
							</span>
						</td>

					</tr>
					<tr>
						<th>6、病人隔离 ：</th>
						<td colspan="3">
							<ehr:dic-radio dicmeta="IDM00578" code="1,2" name="epidemiologicalSurvey.sxQuerantine"
										   value="${caseDto.epidemiologicalSurvey.sxQuerantine}"
										   onchange="toggleOther('epidemiologicalSurvey.sxQuerantine','sxQuerantine',1);"/>

						<span id="sxQuerantine">
								<br>隔离地点：<ehr:dic-radio dicmeta="IDM00543"  name="epidemiologicalSurvey.sxQuerantinePlace"
													value="${caseDto.epidemiologicalSurvey.sxQuerantinePlace}"
													onchange="toggleOther('epidemiologicalSurvey.sxQuerantinePlace','sxQuerantinePlaceOther',99);"/>
							<span id="sxQuerantinePlaceOther">
								<input type="text" name="epidemiologicalSurvey.sxQuerantinePlaceOther" style="width: 80px;"
									   value="${caseDto.epidemiologicalSurvey.sxQuerantinePlaceOther}" reg='{"maxlength":"20"}'/>
							</span>
							<br>隔离开始日期：<tag:dateInput name="epidemiologicalSurvey.sxQuerantineStar" pattern="yyyy/MM/dd"
													date="${caseDto.epidemiologicalSurvey.sxQuerantineStar}" style="width:100px;"/>
							<br>隔离结束日期：<tag:dateInput name="epidemiologicalSurvey.sxQuerantineEnd" pattern="yyyy/MM/dd"
										   date="${caseDto.epidemiologicalSurvey.sxQuerantineEnd}" style="width:100px;"/>

							</span>
						</td>
					</tr>
					<tr>
						<th>7、与患者密切接触者的人数：</th>
						<td colspan="3">
							<input type="text" name="epidemiologicalSurvey.sxTouchNum" style="width: 80px;"
								   value="${caseDto.epidemiologicalSurvey.sxTouchNum}"

								   reg='{"maxlength":"100"}'/>人
							<span id="pertussisContactList2">
								<br><jsp:include page="mumps/contactedList.jsp"></jsp:include>

							</span>
						</td>
					</tr>
				</table>

		</table>
		</fieldset>
	</div>

		<div class="postdiv">
			<fieldset>
				<legend>五、小结</legend>
				<table class="posttable">
					<tr>
						<td>
							<textarea  name="otherCondition.surveySummary" style="width: 100%" rows="5" reg='{"maxlength":"1000"}'>${caseDto.otherCondition.surveySummary}</textarea>
						</td>
					</tr>
				</table>
			</fieldset>
		</div>
		<div class="postdiv">
			<fieldset>
				<table class="posttable">
					<tr>
						<th>调查者单位：</th>
						<td>
							<ehr:org code="${caseDto.caseInformation.modifySurveyOrg}"/>
							<input type="hidden" name="caseInformation.modifySurveyOrg" value="${caseDto.caseInformation.modifySurveyOrg}"/>
						</td>
						<th>调查者：</th>
						<td>
							<ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/>
							<input type="hidden" name="caseInformation.modifyRespondents" value="${caseDto.caseInformation.modifyRespondents}"/>
						</td>
					</tr>
					<tr>
						<th>审查者：</th>
						<td>
							<ehr:user userCode="${caseDto.caseInformation.modifyRespondents}"/>
							<input type="hidden" name="caseInformation.auditor" value="${caseDto.caseInformation.auditor}"/>
						</td>
						<th>调查时间：</th>
						<td>
							<tag:dateInput name="caseInformation.modifySurveyDate" pattern="yyyy/MM/dd" date="${caseDto.caseInformation.modifySurveyDate}"/>
						</td>
					</tr>
				</table>
			</fieldset>
		</div>
	</div>
</div>
</form>

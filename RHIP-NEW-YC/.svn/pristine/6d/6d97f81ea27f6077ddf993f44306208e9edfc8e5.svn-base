<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKXAK" value="<%=RoleType.JKXAK.getValue()%>"/>
<c:set var="SJYYFBK" value="<%=RoleType.SJYYFBK.getValue()%>"/>
<c:set var="SQZX" value="<%=RoleType.SQZX.getValue()%>"/>

<%@ page import="com.founder.rhip.idm.common.LeprosyStatus" %>
<c:set var="CASE" value="<%=LeprosyStatus.CASE.getValue()%>"/>

<%@ page import="com.founder.rhip.idm.common.SpecialEvents" %>
<c:set var="L_CASE" value="<%=SpecialEvents.L_CASE.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/leprosy/leprosy_common.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/leprosy/caseLeprosy.js" type="text/javascript"></script>

<div class="toolbar">
	<a href="javascript:leprosyCommon.returnSearch('caseLeprosy.searchTemp')" id="cancelContact"><b class="fanhui">返回</b></a>
    <c:if test="${type=='1'}">
        <a href="javascript:leprosyCommon.leprosySubmit('1','${CASE}','caseLeprosy.searchTemp', 'leprosyFormCase')" id="saveContact"><b class="baocun">保存</b></a>
   	</c:if>
    <c:if test="${type=='2'}">
         <%--<a href="javascript:leprosyCommon.leprosySubmit('2','${CASE}','caseLeprosy.searchTemp', 'leprosyFormCase')" id="editContact"><b class="xiug">修改</b></a>--%>
        <a href="javascript:leprosyCommon.leprosySubmit('2','${CASE}','caseLeprosy.searchTemp', 'leprosyFormCase')" id="editContact"><b class="baocun">保存</b></a>
    </c:if>
</div>
<form id="leprosyFormCase">
	<input type="hidden" name="singleId" value="${leprosySaveDto.singleId}" id="singleId"/>
	<input type="hidden" name="idmId" value="${leprosySaveDto.idmId}" id="idmId"/>
	<input type="hidden" name="eventId" value="${L_CASE}" id="eventId"/>
	<input type="hidden" name="specialStatus" value="${CASE}"/>
	<input type="hidden" name="caseInformation.reviewResult" value="${leprosySaveDto.caseInformation.reviewResult}"/>
	<input type="hidden" name="caseInformation.modifySurveyOrg" value="${leprosySaveDto.caseInformation.modifySurveyOrg}">
	<input type="hidden" name="caseInformation.modifyRespondents" value="${leprosySaveDto.caseInformation.modifyRespondents}">
	<input type="hidden" id="pageIndex" value="${pageIndex}">
	<div class="postcontent">
		<i class="popno">江苏省麻风病新（复）发病人个案表</i>
		<div class="postdiv">
			<fieldset>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%" />
						<col style="width: 30%" />
						<col style="width: 20%" />
						<col style="width: 30%" />
					</colgroup>
					<tr>
						<th>国际标码：</th>
						<td>
							<input type="text" name="generalCondition.gbcode" value="${leprosySaveDto.generalCondition.gbcode}" style="width: 50%;"
							 	reg='{"maxlength":"100"}'/>
						</td>
						<th>地区编码：</th>
						<td>
							<input type="text" name="caseInformation.adminiDivCode" value="${leprosySaveDto.caseInformation.adminiDivCode}" style="width: 50%;"
							 	reg='{"maxlength":"50"}'/>
						</td>
					</tr>
					<tr>
						<th>编号：</th>
						<td>
							<input type="text" name="caseInformation.wayResearchCode" value="${leprosySaveDto.caseInformation.wayResearchCode}" style="width: 50%;"
							 	reg='{"maxlength":"50"}'/>
						</td>
						<th>填表时间：</th>
						<td>
							<tag:dateInput name="caseInformation.modifySurveyDate" date="${leprosySaveDto.caseInformation.modifySurveyDate}"
								 nullToToday="true" onlypast="true" pattern="yyyy/MM/dd" style="width: 50%;" />
						</td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>一般情况</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%" />
						<col style="width: 30%" />
						<col style="width: 20%" />
						<col style="width: 30%" />
					</colgroup>
					<tr>
						<th><label class="required">姓名：</label></th>
						<td><input type="text" name="generalCondition.name" value="${leprosySaveDto.generalCondition.name}" style="width: 50%;" reg='{"required":"true","maxlength":"100"}'/></td>
						<th><label class="required">性别：</label></th>
						<td>
			            	<ehr:dic-radio dicmeta="GBT226112003" name="generalCondition.gender" code="1,2" value="${leprosySaveDto.generalCondition.gender}" reg='{"required":"true"}'/>
			            </td>
					</tr>
					<tr>
						<th>出生日期：</th>
						<td>
							<tag:dateInput id="birthday" name="generalCondition.birthday" date="${leprosySaveDto.generalCondition.birthday}"
								 nullToToday="true" onlypast="true" pattern="yyyy/MM/dd" style="width: 50%;" />
						</td>
						<th>婚姻：</th>
						<td><ehr:dic-radio dicmeta="IDM00305" name="generalCondition.marriage" value="${leprosySaveDto.generalCondition.marriage}" /> </td>
					</tr>
					<tr>
						<th>联系电话：</th>
						<td><input type="text" name="generalCondition.phoneNumber" value="${leprosySaveDto.generalCondition.phoneNumber}" reg='{"regex":"phone","maxlength":20}' style="width: 50%;"/></td>
						<th>职业：</th>
						<td>
			            	<ehr:dic-list dicmeta="GBT6565" name="generalCondition.occupation" width="100px;" value="${leprosySaveDto.generalCondition.occupation}"
		                                  code="CV020120202,CV020120201,CV020120203,CV020120209,CV020120210,CV020120207,CV020120214,CV020120299"
		                                  onchange="toggleOtherSC('generalCondition.occupation','spanOccupationOther','CV020120299');"/>
			            	 <span id="spanOccupationOther" style="${leprosySaveDto.generalCondition.occupation == 'CV020120299' ? '' : 'display: none;'}">
		                         <input type="text" name="generalCondition.occupationOther" value="${leprosySaveDto.generalCondition.occupationOther}"
		                                reg='{"maxlength":"30"}' placeholder="若选择其他，请描叙" style="width: 60%;"/>
		                     </span>
			            </td>
					</tr>
					<tr>
						<th>民族：</th>
			            <td>
			            	<span id="nation">
			            		<ehr:dic-list name="generalCondition.nation" reg='{"required":"true"}' dicmeta="GBT3304" value="${leprosySaveDto.generalCondition.nationality eq null ? '01' : leprosySaveDto.generalCondition.nation}"
			            	     width="25%"/>
			            	</span>
			            	<span id="nationOther" style="<c:if test="${leprosySaveDto.generalCondition.nationality != '44'}">display: none;</c:if>">
			            		<input type="text" name="generalCondition.nationOther" value="${leprosySaveDto.generalCondition.nationOther}" 
			            	 	style="width: 36%;" reg='{"required":"true","maxlength":"20"}'/>
			            	</span>
			             </td>
			             <th>籍贯：</th>
						<td><ehr:dic-list name="generalCondition.nativePlace" value="${leprosySaveDto.generalCondition.nativePlace}" dicmeta="GBT2260A1"/> </td>
					</tr>
					<tr>
						<th>常住类型：</th>
						<td>
							<ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005"
		                         value="${leprosySaveDto.generalCondition.floatPopulation}" onchange="idmCommon.toggerAddress()"/>
						</td>
					</tr>
					<tr>
						<th>现住址：</th>
						<td colspan="3">
		                     <ehr:dic-town-village villageId="pavillage_address" townId="patown_address" 
									villageName="generalCondition.pastreet" townName="generalCondition.patownShip"
	                                villageValue="${leprosySaveDto.generalCondition.pastreet}"
	                                townValue="${leprosySaveDto.generalCondition.patownShip}" width="180px;"/>
	                            <label id="tempPaValue">
	                                <ehr:dic code="${leprosySaveDto.generalCondition.patownShip}" dicmeta="FS990001"/><ehr:dic code="${leprosySaveDto.generalCondition.pastreet}" dicmeta="FS990001"/>
	                            </label>
	                            <input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${leprosySaveDto.generalCondition.pahouseNumber}"
	                                   reg='{"maxlength":"70"}' style="width: 180px;"/>
	                            <span id="spanPaNumber"></span>
			            </td>
					</tr>
					
				</table>
			</fieldset>
			<fieldset>
				<legend>传染源</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%" />
						<col style="width: 30%" />
						<col style="width: 20%" />
						<col style="width: 30%" />
					</colgroup>
					<tr>
						<th>传染源:</th>
						<td colspan="3">
							<ehr:dic-radio dicmeta="IDM00306" id="infectionSource" name="epidemicFocusClose.infectionSource" value="${leprosySaveDto.epidemicFocusClose.infectionSource}"
								onchange="caseLeprosy.isShow();"/></td>
					</tr>
					<tr id="jianei" style="${leprosySaveDto.epidemicFocusClose.infectionSource == '1' ? '' : 'display:none;'}">
						<th></th>
						<td colspan="3">
							<ehr:dic-radio dicmeta="IDM00018" name="epidemicFocusClose.inContact" value="${leprosySaveDto.epidemicFocusClose.inContact}"
								onchange="toggleOther('epidemicFocusClose.inContact','inContactOther','99')"/>
								<span id="inContactOther" style="${leprosySaveDto.epidemicFocusClose.inContact == '99' ? '' : 'display:none;'}">
									<input type="text" name="epidemicFocusClose.inContactOther" value="${leprosySaveDto.epidemicFocusClose.inContactOther }" reg='{"maxlength":"100"}' style="width: 40%;">
								</span>
						</td>
					</tr>
					<tr id="jiawai" style="${leprosySaveDto.epidemicFocusClose.infectionSource == '2' ? '' : 'display:none;'}">
						<th></th>
						<td colspan="3">
							<ehr:dic-radio dicmeta="IDM00300" name="epidemicFocusClose.outContact" value="${leprosySaveDto.epidemicFocusClose.outContact }"
								onchange="toggleOther('epidemicFocusClose.outContact','outContactOther','99')"/>
							<span id="outContactOther" style="${leprosySaveDto.epidemicFocusClose.outContact == '99' ? '' : 'display:none;'}">
								<input type="text" name="pastHistory.outContactOther" value="${leprosySaveDto.epidemicFocusClose.outContactOther }" reg='{"maxlength":"100"}' style="width: 40%;">
							</span>
						
						</td>
					</tr>
					<tr>
						<th>密切接触者：</th>
						<td><ehr:dic-radio dicmeta="PH00002" code="1,2"  name="epidemicFocusClose.isContacts" value="${leprosySaveDto.epidemicFocusClose.isContacts}"/></td>
						<th>麻风病疫点：</th>
						<td><ehr:dic-radio dicmeta="PH00002" code="1,2"  name="epidemicFocusClose.isFarm" value="${leprosySaveDto.epidemicFocusClose.isFarm}"/></td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>发现方式</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%" />
						<col style="width: 15%" />
						<col style="width: 20%" />
						<col style="width: 15%" />
						<col style="width: 15%" />
						<col style="width: 15%" />
					</colgroup>
					<tbody>
						<tr>
							<th>首诊单位：</th>
							<td><ehr:org-type-list type="" name="attackCondition.firstVisitUnit" value="${leprosySaveDto.attackCondition.firstVisitUnit}" width="80%;"/> </td>
							<th>发现方式：</th>
							<td><ehr:dic-list name="attackCondition.pathogenesisType" dicmeta="IDM00307" value="${leprosySaveDto.attackCondition.pathogenesisType}"/> </td>
							<th>漏误诊次数：</th>
							<td><input type="text" name="attackCondition.misdiagnoseNum" value="${leprosySaveDto.attackCondition.misdiagnoseNum}" reg='{"maxlength":"20"}'/> </td>
						</tr>
					</tbody>
				</table>
			</fieldset>
			<fieldset>
				<legend>发病情况</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%" />
						<col style="width: 30%" />
						<col style="width: 20%" />
						<col style="width: 30%" />
					</colgroup>
					<tr>
					    <th>发病日期：</th>
					    <td>
					    	<tag:dateInput id="pathogenesisDate" nullToToday="true" name="attackCondition.pathogenesisDate" onlypast="true" pattern="yyyy/MM/dd" 
					    	 	reg='{"compare":["confirmationDate","le","发病日期不能大于确诊日期"]}' date="${leprosySaveDto.attackCondition.pathogenesisDate}"/>
					    </td>
					    <th>确诊日期：</th>
					    <td>
					    	<tag:dateInput id="confirmationDate" nullToToday="true" name="attackCondition.confirmationDate" onlypast="true" pattern="yyyy/MM/dd"
					    	 	reg='{"compare":["pathogenesisDate","ge","确诊日期不能小于发病日期"]}' date="${leprosySaveDto.attackCondition.confirmationDate}"/>
					    </td>
					</tr>
					<tr>
					    <th>初发部位：</th>
					    <td>
							<ehr:dic-list dicmeta="IDM00308" name="attackCondition.earlyPart" value="${leprosySaveDto.attackCondition.earlyPart}"
								onchange="toggleOtherSC('attackCondition.earlyPart','earlyPartOther','99')"/>
							<span id="earlyPartOther" style="${ leprosySaveDto.attackCondition.earlyPart== '99' ? '' : 'display:none;'}">
								<input type="text" name="attackCondition.earlyPartOther" value="${leprosySaveDto.attackCondition.earlyPartOther}" reg='{"maxlength":"100"}' style="width: 40%;">
							</span>
						
						</td>
					    <th>初发症状：</th>
					    <td>
							<ehr:dic-list dicmeta="IDM00309" name="attackCondition.earlySymptom" value="${leprosySaveDto.attackCondition.earlySymptom}"
								onchange="toggleOtherSC('attackCondition.earlySymptom','earlySymptomOther','99')"/>
							<span id="earlySymptomOther" style="${leprosySaveDto.attackCondition.earlySymptom == '99' ? '' : 'display:none;'}">
								<input type="text" name="attackCondition.earlySymptomOther" value="${leprosySaveDto.attackCondition.earlySymptomOther}" reg='{"maxlength":"100"}' style="width: 40%;">
							</span>
						
						</td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>皮肤损害检查</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%" />
						<col style="width: 30%" />
						<col style="width: 20%" />
						<col style="width: 30%" />
					</colgroup>
					<tbody>
						<tr>
							<th>形态：</th>
							<td colspan="3">
								<ehr:dic-radio dicmeta="IDM00310"  name="clinicalManifestations.formType" value="${leprosySaveDto.clinicalManifestations.formType}"
									onchange="toggleOther('clinicalManifestations.formType','formTypeOther','99')"/>
								<span id="formTypeOther" style="${leprosySaveDto.clinicalManifestations.formType == '99' ? '' : 'display:none;'}">
									<input type="text" name="clinicalManifestations.formTypeOther" value="${leprosySaveDto.clinicalManifestations.formTypeOther }" reg='{"maxlength":"100"}' style="width: 40%;">
								</span>
							</td>
						</tr>
						<tr>
							<th>边缘：</th>
							<td><ehr:dic-radio dicmeta="IDM00311"  name="clinicalManifestations.borderType" value="${leprosySaveDto.clinicalManifestations.borderType}"/> </td>
							<th>表面：</th>
							<td><ehr:dic-radio dicmeta="IDM00312"  name="clinicalManifestations.faceType" value="${leprosySaveDto.clinicalManifestations.faceType}"/> </td>
						</tr>
						<tr>
							<th>颜色：</th>
							<td><ehr:dic-radio dicmeta="IDM00313"  name="clinicalManifestations.colorType" value="${leprosySaveDto.clinicalManifestations.colorType}"/> </td>
							<th>数量：</th>
							<td><ehr:dic-radio dicmeta="IDM00314"  name="clinicalManifestations.numType" value="${leprosySaveDto.clinicalManifestations.numType}"/> </td>
						</tr>
						<tr>
							<th>分布：</th>
							<td><ehr:dic-radio dicmeta="IDM00315"  name="clinicalManifestations.distributionType" value="${leprosySaveDto.clinicalManifestations.distributionType}"/> </td>
							<th>眉毛：</th>
							<td>
								<ehr:dic-radio dicmeta="IDM00316"  name="clinicalManifestations.eyebrowType" value="${leprosySaveDto.clinicalManifestations.eyebrowType}"
									onchange="toggleOther('clinicalManifestations.eyebrowType','eyebrowTypeOther','99')"/>
									<span id="eyebrowTypeOther" style="${leprosySaveDto.clinicalManifestations.eyebrowType == '99' ? '' : 'display:none;'}">
										<input type="text" name="clinicalManifestations.eyebrowTypeOther" value="${leprosySaveDto.clinicalManifestations.eyebrowTypeOther }" reg='{"maxlength":"100"}' style="width: 40%;">
									</span>
							</td>
						</tr>
					</tbody>
				</table>
			</fieldset>
			<fieldset>
				<legend>周围神经损害</legend>
				<table>
					<colgroup>
						<col style="width: 20%" />
						<col style="width: 30%" />
						<col style="width: 20%" />
						<col style="width: 30%" />
					</colgroup>
					<tbody>
						<tr>
							<td colspan="4" style="padding: 0px;">
								<div class="repeattable">
								<table id="statistics_record_table">
									<colgroup>
										<col style="width:10%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
									</colgroup>
									<thead>
										<tr>
											<td rowspan="1" colspan="1" >浅神经</td>
											<th rowspan="1" colspan="2" style="text-align: center;">眶上N</th>
											<th rowspan="1" colspan="2" style="text-align: center;">耳大N</th>
											<th rowspan="1" colspan="2" style="text-align: center;">尺N</th>
											<th rowspan="1" colspan="2" style="text-align: center;">桡N</th>
											<th rowspan="1" colspan="2" style="text-align: center;">正中N</th>
											<th rowspan="1" colspan="2" style="text-align: center;">腓总N</th>
											<th rowspan="1" colspan="2" style="text-align: center;">胫N</th>
											<th rowspan="1" colspan="2" style="text-align: center;">其它N</th>
										</tr>
										<tr>
											<th></th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">右</th>
										</tr>
										<tr>
											<td>粗度（mm）</td>
											<td>
												<input type="text" name="eyeLeftRough" value="${listCmForm.eyeLeftRough}" reg='{"maxlength":"20"}'/>
												<input type="hidden" name="idRough" value="${listCmForm.idRough}" reg='{"maxlength":"20"}'/>
											</td>
											<td><input type="text" name="eyeRightRough" value="${listCmForm.eyeRightRough}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="earLeftRough" value="${listCmForm.earLeftRough}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="earRightRough" value="${listCmForm.earRightRough}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="ruleLeftRough" value="${listCmForm.ruleLeftRough}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="ruleRightRough" value="${listCmForm.ruleRightRough}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="oarLeftRough" value="${listCmForm.oarLeftRough}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="oarRightRough" value="${listCmForm.oarRightRough}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="centerLeftRough" value="${listCmForm.centerLeftRough}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="centerRightRough" value="${listCmForm.centerRightRough}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="peronealLeftRough" value="${listCmForm.peronealLeftRough}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="peronealRightRough" value="${listCmForm.peronealRightRough}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="legLeftRough" value="${listCmForm.legLeftRough}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="legRightRough" value="${listCmForm.legRightRough}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="otherLeftRough" value="${listCmForm.otherLeftRough}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="otherRightRough" value="${listCmForm.otherRightRough}" reg='{"maxlength":"20"}'/> </td>
										</tr>
										<tr>
											<td>硬度</td>
											<td>
												<input type="text" name="eyeLeftHard" value="${listCmForm.eyeLeftHard}" reg='{"maxlength":"20"}'/>
												<input type="hidden" name="idHard" value="${listCmForm.idHard}" reg='{"maxlength":"20"}'/>
											</td>
											<td><input type="text" name="eyeRightHard" value="${listCmForm.eyeRightHard}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="earLeftHard" value="${listCmForm.earLeftHard}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="earRightHard" value="${listCmForm.earRightHard}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="ruleLeftHard" value="${listCmForm.ruleLeftHard}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="ruleRightHard" value="${listCmForm.ruleRightHard}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="oarLeftHard" value="${listCmForm.oarLeftHard}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="oarRightHard" value="${listCmForm.oarRightHard}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="centerLeftHard" value="${listCmForm.centerLeftHard}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="centerRightHard" value="${listCmForm.centerRightHard}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="peronealLeftHard" value="${listCmForm.peronealLeftHard}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="peronealRightHard" value="${listCmForm.peronealRightHard}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="legLeftHard" value="${listCmForm.legLeftHard}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="legRightHard" value="${listCmForm.legRightHard}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="otherLeftHard" value="${listCmForm.otherLeftHard}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="otherRightHard" value="${listCmForm.otherRightHard}" reg='{"maxlength":"20"}'/> </td>
										</tr>
										<tr>
											<td>触压痛</td>
											<td>
												<input type="text" name="eyeLeftTouch" value="${listCmForm.eyeLeftTouch}" reg='{"maxlength":"20"}'/>
												<input type="hidden" name="idTouch" value="${listCmForm.idTouch}" reg='{"maxlength":"20"}'/>
											</td>
											<td><input type="text" name="eyeRightTouch" value="${listCmForm.eyeRightTouch}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="earLeftTouch" value="${listCmForm.earLeftTouch}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="earRightTouch" value="${listCmForm.earRightTouch}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="ruleLeftTouch" value="${listCmForm.ruleLeftTouch}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="ruleRightTouch" value="${listCmForm.ruleRightTouch}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="oarLeftTouch" value="${listCmForm.oarLeftTouch}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="oarRightTouch" value="${listCmForm.oarRightTouch}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="centerLeftTouch" value="${listCmForm.centerLeftTouch}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="centerRightTouch" value="${listCmForm.centerRightTouch}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="peronealLeftTouch" value="${listCmForm.peronealLeftTouch}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="peronealRightTouch" value="${listCmForm.peronealRightTouch}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="legLeftTouch" value="${listCmForm.legLeftTouch}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="legRightTouch" value="${listCmForm.legRightTouch}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="otherLeftTouch" value="${listCmForm.otherLeftTouch}" reg='{"maxlength":"20"}'/> </td>
											<td><input type="text" name="otherRightTouch" value="${listCmForm.otherRightTouch}" reg='{"maxlength":"20"}'/> </td>
										</tr>
									</thead>
								</table>
								</div>
							</td>
						</tr>
						<tr>
							<th>皮N检查（部位、粗度）：</th>
							<td>
								<input type="text" name="clinicalManifestations.nCheck" value="${leprosySaveDto.clinicalManifestations.nCheck }"
									 reg='{"maxlength":"100"}'>
							</td>
							<th>浅感觉检查（皮损、麻木区）：</th>
							<td>
								<input type="text" name="clinicalManifestations.sensibilityCheck" value="${leprosySaveDto.clinicalManifestations.sensibilityCheck }"
									 reg='{"maxlength":"100"}'>
							</td>
						</tr>
						<tr>
							<td colspan="4" style="padding: 0;">
								<table class="posttable">
									<colgroup>
										<col style="width: 20%" />
										<col style="width: 15%" />
										<col style="width: 20%" />
										<col style="width: 15%" />
										<col style="width: 15%" />
										<col style="width: 15%" />
									</colgroup>
									<tr>
										<th>温觉：</th>
										<td><ehr:dic-radio dicmeta="PH00002" code="1,2" name="clinicalManifestations.feeling" value="${leprosySaveDto.clinicalManifestations.feeling}"/> </td>
										<th>触觉：</th>
										<td><ehr:dic-radio dicmeta="PH00002" code="1,2" name="clinicalManifestations.touch" value="${leprosySaveDto.clinicalManifestations.touch}"/> </td>
										<th>痛觉：</th>
										<td><ehr:dic-radio dicmeta="PH00002" code="1,2" name="clinicalManifestations.algesia" value="${leprosySaveDto.clinicalManifestations.algesia}"/> </td>
									</tr>
								</table>
							</td>
						</tr>
					</tbody>
				</table>
			</fieldset>
			<fieldset>
				<legend>畸残</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%" />
						<col style="width: 80%" />
					</colgroup>
					<tbody>
						<tr>
							<th>畸残:</th>
							<td>
								<ehr:dic-radio dicmeta="PH00002" code="1,2"  name="clinicalManifestations.disability" value="${leprosySaveDto.clinicalManifestations.disability}"
									onchange="toggleOther('clinicalManifestations.disability','facialParalysis','1')"/>
							</td>
						</tr>
						<tr id="facialParalysis" style="<c:if test="${leprosySaveDto.clinicalManifestations.disability != '1' }">display:none;</c:if>">
							<td colspan="2" style="padding: 0;">
								<table class="posttable">
									<colgroup>
										<col style="width: 20%" />
										<col style="width: 15%" />
										<col style="width: 20%" />
										<col style="width: 15%" />
										<col style="width: 15%" />
										<col style="width: 15%" />
									</colgroup>
									<tr>
										<th>面瘫：</th>
										<td><ehr:dic-radio dicmeta="IDM00280" code="1,2" name="clinicalManifestations.facialParalysis" value="${leprosySaveDto.clinicalManifestations.facialParalysis}"/> </td>
										<th>兔眼：</th>
										<td><ehr:dic-radio dicmeta="IDM00280" code="1,2" name="clinicalManifestations.rabbitEye" value="${leprosySaveDto.clinicalManifestations.rabbitEye}"/> </td>
										<th>眼部：</th>
										<td><ehr:dic-radio dicmeta="IDM00280" code="1,2" name="clinicalManifestations.theEye" value="${leprosySaveDto.clinicalManifestations.theEye}"/> </td>
									</tr>
									<tr>
										<th>失明：</th>
										<td><ehr:dic-radio dicmeta="IDM00280" code="1,2" name="clinicalManifestations.goBlind" value="${leprosySaveDto.clinicalManifestations.goBlind}"/> </td>
										<th>爪形手：</th>
										<td><ehr:dic-radio dicmeta="IDM00280" code="1,2" name="clinicalManifestations.clawHand" value="${leprosySaveDto.clinicalManifestations.clawHand}"/> </td>
										<th>猿手：</th>
										<td><ehr:dic-radio dicmeta="IDM00280" code="1,2" name="clinicalManifestations.apeHand" value="${leprosySaveDto.clinicalManifestations.apeHand}"/> </td>
									</tr>
									<tr>
										<th>谷间肌萎缩：</th>
										<td><ehr:dic-radio dicmeta="IDM00280" code="1,2" name="clinicalManifestations.muscleAtrophy" value="${leprosySaveDto.clinicalManifestations.muscleAtrophy}"/> </td>
										<th>指短缩：</th>
										<td><ehr:dic-radio dicmeta="IDM00280" code="1,2" name="clinicalManifestations.aShort" value="${leprosySaveDto.clinicalManifestations.aShort}"/> </td>
										<th>趾跖短缩：</th>
										<td><ehr:dic-radio dicmeta="IDM00280" code="1,2" name="clinicalManifestations.metatarsalShort" value="${leprosySaveDto.clinicalManifestations.metatarsalShort}"/> </td>
									</tr>
									<tr>
										<th>足内翻：</th>
										<td><ehr:dic-radio dicmeta="IDM00280" code="1,2" name="clinicalManifestations.talipesVarus" value="${leprosySaveDto.clinicalManifestations.talipesVarus}"/> </td>
										<th>爪形趾：</th>
										<td><ehr:dic-radio dicmeta="IDM00280" code="1,2" name="clinicalManifestations.clawToe" value="${leprosySaveDto.clinicalManifestations.clawToe}"/> </td>
										<th>垂腕：</th>
										<td><ehr:dic-radio dicmeta="IDM00280" code="1,2" name="clinicalManifestations.wristDrop" value="${leprosySaveDto.clinicalManifestations.wristDrop}"/> </td>
									</tr>
									<tr>
										<th>垂足：</th>
										<td><ehr:dic-radio dicmeta="IDM00280" code="1,2" name="clinicalManifestations.footDrop" value="${leprosySaveDto.clinicalManifestations.footDrop}"/> </td>
										<th>其他：</th>
										<td><input type="text" name="clinicalManifestations.other" value="${leprosySaveDto.clinicalManifestations.other}" reg='{"maxlength":"100"}'/> </td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<th>保护性感觉丧失：</th>
							<td>
								<ehr:dic-radio dicmeta="PH00002" code="1,2" name="clinicalManifestations.feelingLose" value="${leprosySaveDto.clinicalManifestations.feelingLose}"
									onchange="toggleOther('clinicalManifestations.feelingLose','hand','1')"/>
							</td>
						</tr>
						<tr id="hand" style="${leprosySaveDto.clinicalManifestations.feelingLose == '1' ? '' : 'display:none;'}">
							<td colspan="2" style="padding: 0;">
								<table class="posttable">
									<colgroup>
										<col style="width: 20%" />
										<col style="width: 15%" />
										<col style="width: 20%" />
										<col style="width: 15%" />
										<col style="width: 15%" />
										<col style="width: 15%" />
									</colgroup>
									<tr>
										<th>手：</th>
										<td><ehr:dic-radio dicmeta="IDM00280" name="clinicalManifestations.hand" value="${leprosySaveDto.clinicalManifestations.hand}"/> </td>
										<th>足：</th>
										<td><ehr:dic-radio dicmeta="IDM00280" name="clinicalManifestations.foot" value="${leprosySaveDto.clinicalManifestations.foot}"/> </td>
										<th>眼：</th>
										<td><ehr:dic-radio dicmeta="IDM00280" name="clinicalManifestations.eye" value="${leprosySaveDto.clinicalManifestations.eye}"/> </td>
									</tr>
								</table>
							</td>
						</tr>
					</tbody>
				</table>
			</fieldset>
			<fieldset>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%" />
						<col style="width: 30%" />
						<col style="width: 20%" />
						<col style="width: 30%" />
					</colgroup>
					<tbody>
						<tr>
							<th>麻风反应：</th>
							<td colspan="3">
								<ehr:dic-radio dicmeta="PH00002" code="1,2" name="diagnosis.isLeprosy" value="${leprosySaveDto.diagnosis.isLeprosy}"
									onchange="toggleOther('diagnosis.isLeprosy','leprosyType','1')"/>
								<span id="leprosyType" style="display:none;">
									&nbsp;&nbsp;&nbsp;<ehr:dic-radio dicmeta="IDM00317" name="diagnosis.leprosyType" value="${leprosySaveDto.diagnosis.leprosyType}"/>
								</span>
							</td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<th>溃疡：</th>
							<td>
								<ehr:dic-radio dicmeta="PH00002" code="1,2" name="clinicalManifestations.isUlcer" value="${leprosySaveDto.clinicalManifestations.isUlcer}"
									onchange="toggleOther('clinicalManifestations.isUlcer','ulcerHand','1')"/>
							</td>
						</tr>
						<tr id="ulcerHand" style="${leprosySaveDto.clinicalManifestations.isUlcer == '1' ? '' : 'display:none;'}">
							<td colspan="4" style="padding: 0;">
								<table>
									<colgroup>
										<col style="width: 20%" />
										<col style="width: 15%" />
										<col style="width: 20%" />
										<col style="width: 15%" />
										<col style="width: 15%" />
										<col style="width: 15%" />
									</colgroup>
									<tr>
										<th>手：</th>
										<td><ehr:dic-radio dicmeta="IDM00280" code="1,2" name="clinicalManifestations.ulcerHand" value="${leprosySaveDto.clinicalManifestations.ulcerHand}"/> </td>
										<th>小腿：</th>
										<td><ehr:dic-radio dicmeta="IDM00280" code="1,2" name="clinicalManifestations.ulcerLeg" value="${leprosySaveDto.clinicalManifestations.ulcerLeg}"/> </td>
										<th>踝：</th>
										<td><ehr:dic-radio dicmeta="IDM00280" code="1,2" name="clinicalManifestations.ulcerAnkle" value="${leprosySaveDto.clinicalManifestations.ulcerAnkle}"/> </td>
									</tr>
									<tr>
										<th>足底：</th>
										<td><ehr:dic-radio dicmeta="IDM00280" code="1,2" name="clinicalManifestations.ulcerFoot" value="${leprosySaveDto.clinicalManifestations.ulcerFoot}"/> </td>
										<th>趾：</th>
										<td><ehr:dic-radio dicmeta="IDM00280" code="1,2" name="clinicalManifestations.ulcerToe" value="${leprosySaveDto.clinicalManifestations.ulcerToe}"/> </td>
										<th>其他：</th>
										<td><input type="text" name="clinicalManifestations.ulcerOther" value="${leprosySaveDto.clinicalManifestations.ulcerOther}" reg='{"maxlength":"100"}'/> </td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<th>劳动力丧失：</th>
							<td><ehr:dic-radio dicmeta="IDM00318" name="laborCapacity.lubourIncapacity" value="${leprosySaveDto.laborCapacity.lubourIncapacity}"/> </td>
						</tr>
						<tr>
							<th>生活自理能力丧失：</th>
							<td><ehr:dic-radio dicmeta="IDM00318" name="laborCapacity.lossAdl" value="${leprosySaveDto.laborCapacity.lossAdl}"/> </td>
						</tr>
					</tbody>
				</table>
			</fieldset>
			<fieldset>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%" />
						<col style="width: 15%" />
						<col style="width: 20%" />
						<col style="width: 15%" />
						<col style="width: 15%" />
						<col style="width: 15%" />
					</colgroup>
					<tbody>
						<tr>
							<th>查菌情况</th>
							<td colspan="5">
								<ehr:dic-radio dicmeta="FS10055" name="labExamine.fungusCondition" value="${leprosySaveDto.labExamine.fungusCondition}"
									onchange="caseLeprosy.isShowFungus();"/> 
								<span id="bi" style="${leprosySaveDto.labExamine.fungusCondition=='1' ? '' : 'display:none;'}">
									BI：<input type="text" name="labExamine.bi" value="${leprosySaveDto.labExamine.bi}" reg='{"maxlength":"20"}' style="width: 30%;"/>
								</span>
								<span id="unCheckResult" style="${leprosySaveDto.labExamine.fungusCondition=='3' ? '' : 'display:none;'}">
									原因：<input type="text" name="labExamine.unCheckResult" value="${leprosySaveDto.labExamine.unCheckResult}" reg='{"maxlength":"100"}' style="width: 30%;"/>
								</span>
							</td>
						</tr>
						<tr>
							<th>检查者：</th>
							<td><input type="text" name="labExamine.stoolCollectname_1" value="${leprosySaveDto.labExamine.stoolCollectname_1}" reg='{"maxlength":"50"}'/></td>
							<th>检查单位</th>
							<td><input type="text" name="labExamine.fcCheckUnit" value="${leprosySaveDto.labExamine.fcCheckUnit}" reg='{"maxlength":"100"}'/></td>
							<th>检查时间</th>
							<td>
								<tag:dateInput name="labExamine.fcCheckDt" date="${leprosySaveDto.labExamine.fcCheckDt}"
								 nullToToday="true" onlypast="true" pattern="yyyy/MM/dd" style="width: 50%;" />
							</td>
						</tr>
					</tbody>
				</table>
			</fieldset>
			<fieldset>
				<legend>检查确诊</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%" />
						<col style="width: 15%" />
						<col style="width: 20%" />
						<col style="width: 15%" />
						<col style="width: 15%" />
						<col style="width: 15%" />
					</colgroup>
					<tbody>
						<tr>
							<th>病理检查结果：</th>
							<td><ehr:dic-radio dicmeta="IDM00329" name="labExamine.afb" value="${leprosySaveDto.labExamine.afb}"/> </td>
							<th>病理号：</th>
							<td><input type="text" name="labExamine.pathologyNo" value="${leprosySaveDto.labExamine.pathologyNo}" reg='{"maxlength":"100"}'/></td>
						</tr>
						<tr>
							<th>结果描述：</th>
							<td colspan="3"><input type="text" name="labExamine.otherDiagnosed" value="${leprosySaveDto.labExamine.otherDiagnosed}" reg='{"maxlength":"100"}'/></td>
						</tr>
						<tr>
							<th>检查者：</th>
							<td><input type="text" name="labExamine.testUser" value="${leprosySaveDto.labExamine.testUser}" reg='{"maxlength":"50"}'/></td>
							<th>检查单位：</th>
							<td><input type="text" name="labExamine.checkUnit" value="${leprosySaveDto.labExamine.checkUnit}" reg='{"maxlength":"100"}'/></td>
							<th>检查时间：</th>
							<td>
								<tag:dateInput name="labExamine.checkDt" date="${leprosySaveDto.labExamine.checkDt}"
								 	nullToToday="true" onlypast="true" pattern="yyyy/MM/dd" style="width: 50%;" />
							</td>
						</tr>
					</tbody>
				</table>
			</fieldset>
			<fieldset>
				<legend>麻风病诊断</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%" />
						<col style="width: 30%" />
						<col style="width: 20%" />
						<col style="width: 30%" />
					</colgroup>
					<tbody>
						<tr>
							<th>麻风病诊断依据（型别）：</th>
							<td><input type="text" name="diagnosis.diagnosisReason" value="${leprosySaveDto.diagnosis.diagnosisReason}" reg='{"maxlength":"100"}'/></td>
						</tr>
						<tr>
							<th>神经炎：</th>
							<td>
								<ehr:dic-radio dicmeta="PH00002" code="1,2" name="diagnosis.neuritis" value="${leprosySaveDto.diagnosis.neuritis}"
									onchange="toggleOther('diagnosis.neuritis','neuritisReason','1')"/>
								<span id="neuritisReason" style="${leprosySaveDto.diagnosis.neuritis == '1' ? '' : 'display:none;'}">
									类型及诊断依据：<input type="text" name="diagnosis.neuritisReason" value="${leprosySaveDto.diagnosis.neuritisReason}" reg='{"maxlength":"100"}' style="width: 40%;">
								</span>
							 </td>
						</tr>
						<tr>
							<th>麻风反应：</th>
							<td>
								<ehr:dic-radio dicmeta="PH00002" code="1,2" name="diagnosis.leprosyReaction" value="${leprosySaveDto.diagnosis.leprosyReaction}"
									onchange="toggleOther('diagnosis.leprosyReaction','leprosyReactionReason','1')"/>
								<span id="leprosyReactionReason" style="${leprosySaveDto.diagnosis.leprosyReaction== '1' ? '' : 'display:none;'}">
									类型及诊断依据：<input type="text" name="diagnosis.leprosyReactionReason" value="${leprosySaveDto.diagnosis.leprosyReactionReason}" reg='{"maxlength":"100"}' style="width: 40%;">
								</span>
							 </td>
						</tr>
						<tr>
							<th>负责医生签名：</th>
							<td><input type="text" name="diagnosis.diagnosisDoctor" value="${leprosySaveDto.diagnosis.diagnosisDoctor}" reg='{"maxlength":"50"}'/></td>
							<th>联系电话：</th>
							<td><input type="text" name="diagnosis.doctorTell" value="${leprosySaveDto.diagnosis.doctorTell}" reg='{"regex":"phone","maxlength":20}' style="width: 50%;"/></td>
						</tr>
						<tr>
							<th>确诊单位：</th>
							<td><input type="text" name="diagnosis.diagnosisUnit" value="${leprosySaveDto.diagnosis.diagnosisUnit}" reg='{"maxlength":"100"}'/></td>
							<th>确诊时间：</th>
							<td>
								<tag:dateInput name="diagnosis.diagnosisDt" date="${leprosySaveDto.diagnosis.diagnosisDt}"
								 	nullToToday="true" onlypast="true" pattern="yyyy/MM/dd" style="width: 50%;" />
							</td>
						</tr>
					</tbody>
				</table>
			</fieldset>
			<fieldset>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%" />
						<col style="width: 30%" />
						<col style="width: 20%" />
						<col style="width: 30%" />
					</colgroup>
					<tr>
						<th>MDT方案：</th>
						<td>
							<input type="text" name="diagnosis.mdt" value="${leprosySaveDto.diagnosis.mdt}" reg='{"maxlength":"200"}'>
						</td>
					</tr>
					<tr>
						<th>神经炎治疗方案：</th>
						<td><input type="text" name="diagnosis.neuritisScheme" value="${leprosySaveDto.diagnosis.neuritisScheme}" reg='{"maxlength":"200"}'></td>
					</tr>
					<tr>
						<th>麻风反应治疗方案：</th>
						<td><input type="text" name="diagnosis.scheme" value="${leprosySaveDto.diagnosis.scheme}" reg='{"maxlength":"200"}'></td>
					</tr>
					<tr>
						<th>经治医生：</th>
						<td><input type="text" name="diagnosis.treatmentDoctor" value="${leprosySaveDto.diagnosis.treatmentDoctor}" reg='{"maxlength":"50"}'/></td>
						<th>时间：</th>
						<td>
							<tag:dateInput name="diagnosis.treatmentDt" date="${leprosySaveDto.diagnosis.treatmentDt}"
							 nullToToday="true" onlypast="true" pattern="yyyy/MM/dd" style="width: 50%;" />
						</td>
					</tr>
				</table>
			</fieldset>
		</div>
	</div>
</form>
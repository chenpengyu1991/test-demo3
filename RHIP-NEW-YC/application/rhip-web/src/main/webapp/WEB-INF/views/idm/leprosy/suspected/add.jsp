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
<c:set var="SUSPECTED" value="<%=LeprosyStatus.SUSPECTED.getValue()%>" />

<%@ page import="com.founder.rhip.idm.common.SpecialEvents" %>
<c:set var="L_SUSPECTED" value="<%=SpecialEvents.L_SUSPECTED.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/leprosy/leprosy_common.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/leprosy/suspected.js" type="text/javascript"></script>

<div class="toolbar">
	<ehr:authorize ifAnyGranted="${JKXAK}">
		<a href="javascript:leprosyCommon.returnSearch('suspected.searchTemp')"><b class="fanhui">返回</b></a>
		<c:if test="${type == '1' || type == null}">
	    	<a href="javascript:leprosyCommon.leprosySubmit('1','${SUSPECTED}','suspected.searchTemp', 'leprosyFormSuspected')"><b class="baocun">审核</b></a>
		</c:if>
		<c:if test="${type=='2'}">
	    	<a href="javascript:leprosyCommon.leprosySubmit('2','${SUSPECTED}','suspected.searchTemp', 'leprosyFormSuspected')"><b class="baocun">审核</b></a>
		</c:if>
	</ehr:authorize>
	<ehr:authorize ifAnyGranted="${SJYYFBK},${SQZX}">
		<a href="javascript:leprosyCommon.returnSearch('suspected.searchTemp')"><b class="fanhui">返回</b></a>
	    <c:if test="${type=='1' || type == null}">
	        <a href="javascript:leprosyCommon.leprosySubmit('1','${SUSPECTED}','suspected.searchTemp', 'leprosyFormSuspected')"><b class="shangb">上报</b></a>
	   	</c:if>
	   	<c:if test="${type=='2'}">
	        <a href="leprosyCommon.deleteLeprosy('${leprosySaveDto.singleId}','${leprosySaveDto.idmId}','suspected.searchTemp')"><b class="baocun">作废</b></a>
	   	</c:if>
	</ehr:authorize>
</div>
<form id="leprosyFormSuspected">
	<input type="hidden" name="singleId" value="${leprosySaveDto.singleId}" id="singleId"/>
	<input type="hidden" name="idmId" value="${leprosySaveDto.idmId}" id="idmId"/>
	<input type="hidden" name="eventId" value="${L_SUSPECTED}" id="eventId"/>
	<input type="hidden" name="statusId" value="${statusId}" id="statusId"/>
	<input type="hidden" name="specialStatus" value="${SUSPECTED}"/>
	<input type="hidden" id="pageIndex" value="${pageIndex}">
	<div class="postcontent">
		<i class="popno">江苏省麻风病疑似病例报告卡</i>
		<div class="postdiv">
			<fieldset>
				<legend>基本信息</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%" />
						<col style="width: 30%" />
						<col style="width: 20%" />
						<col style="width: 30%" />
					</colgroup>
					<tr>
						<th>常住类型：</th>
						<td>
							<ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005"
		                                   value="${leprosySaveDto.generalCondition.floatPopulation}" onchange="idmCommon.toggerAddress()"/>
						</td>
					</tr>
					
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
						<th>邮编：</th>
						<td><input type="text" name="generalCondition.postcode" value="${leprosySaveDto.generalCondition.postcode}" reg='{"regex":"postCode","maxlength":7}' style="width: 50%;"/></td>
						<th><label class="required">电话：</label></th>
						<td><input type="text" name="generalCondition.phoneNumber" value="${leprosySaveDto.generalCondition.phoneNumber}" reg='{"required":"true","regex":"phone","maxlength":20}' style="width: 50%;"/></td>
					</tr>
					<tr>
						<th>职业：</th>
						<td>
			            	<ehr:dic-list dicmeta="GBT6565" name="generalCondition.occupation" width="180px;" value="${leprosySaveDto.generalCondition.occupation}"
		                                  code="CV020120202,CV020120201,CV020120203,CV020120209,CV020120210,CV020120207,CV020120214,CV020120299"
		                                  onchange="toggleOtherSC('generalCondition.occupation','spanOccupationOther','CV020120299');"/>
			            	 <span id="spanOccupationOther" style="display: none;">
		                         <input type="text" name="generalCondition.occupationOther" value="${leprosySaveDto.generalCondition.occupationOther}"
		                                reg='{"maxlength":"30"}' placeholder="若选择其他，请描叙" style="width: 120px;"/>
		                     </span>
			            </td>
						<th>文化程度：</th>
						<td style="vertical-align: text-top">
							<ehr:dic-list dicmeta="GBT46582006" code="IDM01,IDM02,IDM03,IDM04,IDM05,IDM06,IDM07,IDM08,IDM09" name="generalCondition.education" value="${ leprosySaveDto.generalCondition.education}"/> 
						</td>
					</tr>
					<tr>
						<th><label class="required">现住址：</label></th>
						<td colspan="3">
		                    <ehr:dic-town-village villageId="pavillage_address" townId="patown_address" 
									villageName="generalCondition.pastreet" townName="generalCondition.patownShip"
	                                villageValue="${leprosySaveDto.generalCondition.pastreet}"
	                                townValue="${leprosySaveDto.generalCondition.patownShip}" width="180px;" reg='{"required":"true"}'/>
	                            <label id="tempPaValue">
	                                <ehr:dic code="${leprosySaveDto.generalCondition.patownShip}" dicmeta="FS990001"/><ehr:dic code="${leprosySaveDto.generalCondition.pastreet}" dicmeta="FS990001"/>
	                            </label>
	                            <input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${leprosySaveDto.generalCondition.pahouseNumber}"
	                                   reg='{"required":"true","maxlength":"70"}' style="width: 180px;"/>
	                            <span id="spanPaNumber"></span>
			            </td>
					</tr>
					<tr>
						<th>户籍地址：</th>
						<td colspan="3">
			                <ehr:dic-town-village villageId="hrvillage_address" townId="hrtown_address" villageName="generalCondition.hrstreet" townName="generalCondition.hrtownShip"
			                                       villageValue="${leprosySaveDto.generalCondition.hrstreet}" townValue="${leprosySaveDto.generalCondition.hrtownShip}" width="180px;"/>
			
			                 <label id="tempHrValue">
	                                <ehr:dic code="${leprosySaveDto.generalCondition.hrtownShip}" dicmeta="FS990001"/><ehr:dic code="${leprosySaveDto.generalCondition.hrstreet}" dicmeta="FS990001"/>
	                            </label>
			                 <input type="text" name="generalCondition.hrhouseNumber" id="hrhouseNumber" value="${leprosySaveDto.generalCondition.hrhouseNumber}"
			                         style="width: 180px;" reg='{"maxlength":"50"}'>
			                 <span id="spanHrNumber"></span>
			             </td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>一般信息</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 35%" />
						<col style="width: 65%" />
					</colgroup>
					<tr>
						<th>既往麻风史：</th>
						<td>
							<ehr:dic-radio dicmeta="PH00002" code="1,2" name="pastHistory.previousHistory" value="${leprosySaveDto.pastHistory.previousHistory }"
								onchange="toggleOther('pastHistory.previousHistory','previousOther','1')"/>
							<span id="previousOther" style="${leprosySaveDto.pastHistory.previousHistory == '1' ? '' : 'display:none;'}">
								<input type="text" name="pastHistory.previousOther" value="${leprosySaveDto.pastHistory.previousOther }" reg='{"maxlength":"100"}' style="width: 40%;">
							</span>
						 </td>
					</tr>
					<tr>
						<th>传染来源 &nbsp;&nbsp;家内：</th>
						<td>
							<ehr:dic-radio dicmeta="IDM00018" name="epidemicFocusClose.inContact" value="${leprosySaveDto.epidemicFocusClose.inContact}"
								onchange="toggleOther('epidemicFocusClose.inContact','inContactOther','99')"/>
								<span id="inContactOther" style="${leprosySaveDto.epidemicFocusClose.inContact == '99' ? '' : 'display:none;'}">
									<input type="text" name="epidemicFocusClose.inContactOther" value="${leprosySaveDto.epidemicFocusClose.inContactOther }" reg='{"maxlength":"100"}' style="width: 40%;">
								</span>
						</td>
					</tr>
					<tr>
						<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;家外：</th>
						<td>
							<ehr:dic-radio dicmeta="IDM00300" name="epidemicFocusClose.outContact" value="${leprosySaveDto.epidemicFocusClose.outContact }"
								onchange="toggleOther('epidemicFocusClose.outContact','outContactOther','99')"/>
							<span id="outContactOther" style="${leprosySaveDto.epidemicFocusClose.outContact == '99' ? '' : 'display:none;'}">
								<input type="text" name="epidemicFocusClose.outContactOther" value="${leprosySaveDto.epidemicFocusClose.outContactOther }" reg='{"maxlength":"100"}' style="width: 40%;">
							</span>
						
						</td>
					</tr>
					<tr>
						<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;接触程度：</th>
						<td><ehr:dic-radio dicmeta="IDM00298" name="epidemicFocusClose.contactDegree" value="${leprosySaveDto.epidemicFocusClose.contactDegree }"/></td>
					</tr>
					<tr>
						<th>出发症状出现日期：</th>
						<td><tag:dateInput name="clinicalManifestations.symptomsTime" date="${leprosySaveDto.clinicalManifestations.symptomsTime}"
								 nullToToday="true" onlypast="true" pattern="yyyy/MM/dd" style="width: 16%" /></td>
					</tr>
					<tr>
						<th>出发症状出现部位：</th>
						<td><ehr:dic-checkbox dicmeta="IDM00301" name="clinicalManifestations.appearances" value="${leprosySaveDto.clinicalManifestations.appearances }"/> </td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>疑似病例依据</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 35%" />
						<col style="width: 65%" />
					</colgroup>
					<tr>
						<td>（请在相应序号上打“√”）</td>
					</tr>
					<tr>
						<th>1、具有下列1种或几种不能使用其他疾病解释的皮损：</th>
						<td><ehr:dic-checkbox dicmeta="IDM00302" name="diagnosis.accordingSkinLesion" value="${leprosySaveDto.diagnosis.accordingSkinLesion }"/></td>
					</tr>
					<tr>
						<th>2、具有下列1种或几种不能使用其他疾病解释的神经损伤症状：</th>
						<td><ehr:dic-checkbox dicmeta="IDM00303" name="diagnosis.accordingSymptom" value="${leprosySaveDto.diagnosis.accordingSymptom }"/></td>
					</tr>
					<tr>
						<th>3、具有下列1种或几种不能使用其他疾病解释的体症：</th>
						<td><ehr:dic-checkbox dicmeta="IDM00304" name="diagnosis.accordingSigns" value="${leprosySaveDto.diagnosis.accordingSigns }"/></td>
					</tr>
				</table>
			</fieldset>
			<fieldset>
				<legend>报告信息</legend>
				<table class="posttable">
					<colgroup>
			            <col style="width: 10%"/>
			            <col style="width: 23%"/>
			             <col style="width: 10%"/>
			             <col style="width: 23%"/>
			             <col style="width: 10%"/>
			            <col style="width: 24%"/>
			        </colgroup>
					<tr>
						<th>报告单位：</th>
						<td><ehr:org code="${leprosySaveDto.caseInformation.modifySurveyOrg}"/>
							<input type="hidden" name="caseInformation.modifySurveyOrg" value="${leprosySaveDto.caseInformation.modifySurveyOrg}">
							<input type="hidden" name="caseInformation.acceptTown" value="${leprosySaveDto.caseInformation.acceptTown}">
						</td>
						<th>报告人：</th>
						<td><ehr:user userCode="${leprosySaveDto.caseInformation.modifyRespondents}"/>
							<input type="hidden" name="caseInformation.modifyRespondents" value="${leprosySaveDto.caseInformation.modifyRespondents}">
						</td>
						<th>报告日期：</th>
						<td>
							<fmt:formatDate pattern="yyyy/MM/dd" value="${leprosySaveDto.caseInformation.modifySurveyDate}"/>
							<tag:dateInput name="caseInformation.modifySurveyDate" date="${leprosySaveDto.caseInformation.modifySurveyDate}" style="display:none;"/>
						</td>
					</tr>
					<ehr:authorize ifAnyGranted="${JKXAK}">
						<tr>
							<th><label class="required">复查结果：</label></th>
							<td><ehr:dic-radio dicmeta="IDM00231" code="5,6,7" name="caseInformation.reviewResult" value="${leprosySaveDto.caseInformation.reviewResult}" reg='{"required":"true"}'/>
							</td>
							<th>复查人：</th>
							<td><ehr:user userCode="${leprosySaveDto.caseInformation.reviewUser== null ? leprosySaveDto.caseInformation.modifyRespondents : leprosySaveDto.caseInformation.reviewUser}"/>
								<input type="hidden" name="caseInformation.reviewUser" value="${leprosySaveDto.caseInformation.reviewUser== null ? leprosySaveDto.caseInformation.modifyRespondents : leprosySaveDto.caseInformation.reviewUser}">
							</td>
							<th>复查日期：</th>
							<td><fmt:formatDate pattern='yyyy/MM/dd' value="${leprosySaveDto.caseInformation.reviewDt=='' ? leprosySaveDto.caseInformation.reviewDt : leprosySaveDto.caseInformation.modifySurveyDate}"/>
								<tag:dateInput name="caseInformation.reviewDt" date="${leprosySaveDto.caseInformation.reviewDt=='' ? leprosySaveDto.caseInformation.modifySurveyDate : leprosySaveDto.caseInformation.reviewDt}" style="display:none;"/>
							</td>
						</tr>
					</ehr:authorize>
				</table>
			</fieldset>
		</div>
	</div>
</form>
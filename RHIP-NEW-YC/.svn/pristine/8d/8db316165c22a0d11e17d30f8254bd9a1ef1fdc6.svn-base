<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.idm.common.SpecialEvents" %>
<%@ page import="com.founder.rhip.idm.common.TbStatus" %>

<c:set var="T_TRANSFERTREAT" value="<%=SpecialEvents.T_TRANSFERTREAT.getValue()%>"/>
<c:set var="TRANSFERTREAT" value="<%=TbStatus.TRANSFERTREAT.getValue()%>" />
<script src="${pageContext.request.contextPath}/js/views/idm/tb/tb_common.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/tb/transfertreat.js" type="text/javascript"></script>

<div class="toolbar">
    <a href="javascript:tbCommon.returnSearch('transfertreat.searchTemp')" ><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
    <c:if test="${type=='1'}">
        <a href="javascript:tbCommon.tbSubmit('1',${TRANSFERTREAT},'transfertreat.searchTemp','tbFormTransfertreat')" id="saveContact"><button class="layui-btn layui-btn-sm button"><i class="layui-icon"></i>保存</button></a>
   	</c:if>
    <c:if test="${type=='2'}">
         <%--<a href="javascript:tbCommon.tbSubmit('2',${TRANSFERTREAT},'transfertreat.searchTemp','tbFormTransfertreat')" id="editContact"><b class="xiug">修改</b></a>--%>
        <a href="javascript:tbCommon.tbSubmit('2',${TRANSFERTREAT},'transfertreat.searchTemp','tbFormTransfertreat')" id="editContact"><button class="layui-btn layui-btn-sm button"><i class="layui-icon"></i>保存</button></a>
        <!--<a href="javascript:void(0)" onclick="javascript:transfertreat.printDrugreg()"><b class="dayin">打印</b></a>-->
    </c:if>
</div>
<form id="tbFormTransfertreat">
	<input type="hidden" name="singleId" value="${tbSaveDto.singleId}" id="singleId"/>
	<input type="hidden" name="eventId" value="${T_TRANSFERTREAT}" id="eventId"/>
	<input type="hidden" name="idmId" value="${tbSaveDto.idmId}" id="idmId"/>
	<input type="hidden" name="specialStatus" value="${TRANSFERTREAT}"/>
	<input type="hidden" name="logoff" value="${tbSaveDto.logoff}"/>
	<input type="hidden" id="pageIndex" value="${pageIndex}">
    <input type="hidden" name="diagnosis.tentativeDiagnosis" value="${tbSaveDto.diagnosis.tentativeDiagnosis}">
    <input type="hidden" name="diagnosis.other" value="${tbSaveDto.diagnosis.other}">
    <div class="postcontent divFixed125" style="top: 200px;">
		<i class="popno">第一联：转 诊 单 （病人持本单去结核病定点医院 永城市人民医院结防科）</i>
		<div class="postdiv">
			<table class="posttable">
				<colgroup>
					<col style="width: 20%" />
					<col style="width: 30%" />
					<col style="width: 20%" />
					<col style="width: 30%" />
				</colgroup>
				<tbody>
					<tr>
						<th><label class="required">姓名</label></th>
						<td><input type="text" name="generalCondition.name" value="${tbSaveDto.generalCondition.name}" style="width: 100px;" reg='{"required":"true","maxlength":"100"}'/></td>
						<th><label class="required">性别</label></th>
						<td>
			            	<ehr:dic-radio dicmeta="GBT226112003" name="generalCondition.gender" code="1,2" value="${tbSaveDto.generalCondition.gender}" reg='{"required":"true"}'/>
			            </td>
					</tr>
					<tr>
						<th><label class="required">年龄</label></th>
						<td>
							<tag:numberInput id="age" name="generalCondition.age" value="${tbSaveDto.generalCondition.age}" 
	            				maxlength="3" cssClass="width30" style="width: 20%" reg='{"required":"true"}'/>
	            			<ehr:dic-radio name="generalCondition.ageUnit"  dicmeta="IDM00003" value="${tbSaveDto.generalCondition.ageUnit}" reg='{"required":"true"}'/>
						</td>
						<th><label class="required">联系电话</label></th>
						<td>
                        	<input type="text" id="phoneNumberId" name="generalCondition.phoneNumber" value="${tbSaveDto.generalCondition.phoneNumber}" 
                        		reg='{"required":"true","regex":"phone","maxlength":20}'/>
                        </td>
					</tr>
					<tr>
						<th><label class="required">身份证号:</label></th>
						<td>
							<input type="text" id="idCard" name="generalCondition.idcard" value="${tbSaveDto.generalCondition.idcard}"
                                   placeholder="输入身份证获取个人信息" reg='{"idCard":"true","required":"true"}'/>
                            <input type="button" id="check-submit-btn1" value="读卡" style="width: 40px;">
                        </td>
					<tr>
		                <th><label class="required">常住类型：</label></th>
		                <td>
		                    <ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005" reg='{"required":"true"}'
		                                   value='${tbSaveDto.generalCondition.floatPopulation}' onchange="idmCommon.toggerAddress()"/>
		                </td>
		            </tr>
					<tr>
						<th><label class="required">现住址:</label></th>
						<td colspan="3">
							<ehr:dic-town-street-village villageId="pavillage_address" streetId="pastreet_address" callback="idmCommon.displayPaAddress"
														 townId="patown_address" villageName="generalCondition.paGroup" streetName="generalCondition.pastreet"
														 townName="generalCondition.patownShip" villageValue="${tbSaveDto.generalCondition.paGroup}" streetValue="${tbSaveDto.generalCondition.pastreet}"
														 townValue="${tbSaveDto.generalCondition.patownShip}" width="118px;" reg="{'required':true}"/>
							<br/><label id="tempPaValue">
								<ehr:dic code="${tbSaveDto.generalCondition.patownShip}" dicmeta="FS990001"/>
								<ehr:dic code="${tbSaveDto.generalCondition.pastreet}" dicmeta="FS990001"/>
								<ehr:dic code="${tbSaveDto.generalCondition.paGroup}" dicmeta="FS990001"/>
							</label>
							<input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${tbSaveDto.generalCondition.pahouseNumber}"
								    reg='{"required":"true","maxlength":"50"}' style="width:300px;"/>(详细地址)
			            </td>
					</tr>
					<tr>
						<th><label class="required">户籍住址:</label></th>
						<td colspan="3"><div class="${'2' eq tbSaveDto.generalCondition.floatPopulation || '4' eq tbSaveDto.generalCondition.floatPopulation?'hide':'' }" id="hr-address-select">
							<ehr:dic-town-street-village
									villageId="hrvillage_address" townId="hrtown_address" streetId="hrStreet_address"
									villageName="generalCondition.hrGroup" streetName="generalCondition.hrstreet"
									townName="generalCondition.hrtownShip" streetValue="${tbSaveDto.generalCondition.hrstreet}"
									villageValue="${tbSaveDto.generalCondition.hrGroup}" callback="idmCommon.displayHrAddress"
									townValue="${tbSaveDto.generalCondition.hrtownShip}" width="118px;" reg="{'required':true}"/>
							</div><label id="tempHrValue">
								<ehr:dic code="${tbSaveDto.generalCondition.hrtownShip}" dicmeta="FS990001"/>
								<ehr:dic code="${tbSaveDto.generalCondition.hrstreet}" dicmeta="FS990001"/>
								<ehr:dic code="${tbSaveDto.generalCondition.hrGroup}" dicmeta="FS990001"/>
							</label>
			                 <input type="text" name="generalCondition.hrhouseNumber" id="hrhouseNumber" value="${tbSaveDto.generalCondition.hrhouseNumber}"
			                          reg='{"required":"true","maxlength":"50"}' style="width:300px;"/>(详细地址)
			             </td>
					</tr>
					<tr>
						<th><label class="required">转诊原因</label></th>
						<td colspan="3">
							<ehr:dic-checkbox dicmeta="IDM00218" name="diagnosis.diagnosisReason" value="${tbSaveDto.diagnosis.diagnosisReason}"
								onchange="toggleOtherCK('diagnosis.diagnosisReason','transferTreatmentAccording','3')" reg='{"required":"true"}'/>
								
							<span id="transferTreatmentAccording">
								<ehr:dic-radio dicmeta="PH00004" code="1,2" name="diagnosis.transferTreatmentAccording" value="${tbSaveDto.diagnosis.transferTreatmentAccording}" reg='{"required":"true"}'/>
							</span>
						</td>
					</tr>
					<tr>
						<th><label class="required">转诊单位</label></th>
						<td><ehr:org code="${tbSaveDto.caseInformation.transferTreatmentUnit}"/>
							<input type="hidden" name="caseInformation.transferTreatmentUnit" value="${tbSaveDto.caseInformation.transferTreatmentUnit}"/>
							<input type="hidden" name="caseInformation.modifySurveyOrg" value="${tbSaveDto.caseInformation.modifySurveyOrg}"/>
						</td>
						<th><label class="required">转诊医师</label></th>
						<td><ehr:user userCode="${tbSaveDto.caseInformation.transferTreatmentDoctor}"/>
						<input type="hidden" name="caseInformation.transferTreatmentDoctor" value="${tbSaveDto.caseInformation.transferTreatmentDoctor}"/>
						<input type="hidden" name="caseInformation.modifyRespondents" value="${tbSaveDto.caseInformation.modifyRespondents}"/>
						</td>
					</tr>
					<tr>
						<th><label class="required">转诊时间</label></th>
						<td>
							<fmt:formatDate value="${tbSaveDto.caseInformation.transferTreatmentDt}" pattern="yyyy/MM/dd"/>
							<tag:dateInput id="birthday" name="caseInformation.transferTreatmentDt" date="${tbSaveDto.caseInformation.transferTreatmentDt}" style="display:none;"/>
							<tag:dateInput id="birthday" name="caseInformation.modifySurveyDate" date="${tbSaveDto.caseInformation.modifySurveyDate}" style="display:none;"/>
						</td>
					</tr>
				</tbody>
			</table>
		</div>

        <br/>
        <table class="posttable">
            <colgroup>
                <col style="width: 80px;">
                <col style="width: 95%;">

            </colgroup>
            <tr>
                <td>
                    <i>病人须知</i>
                </td>
                <td></td>
            </tr>
            <tr>
                <td></td>
				<td>
					1.病人持转诊单两天内到结核病定点医院（永城市结核病防治所）<br/>
					2.就诊前将24小时痰（须从肺部咳出的痰）留置于玻璃瓶内<br/>
					3.就诊时请将痰及X线胸片一并带至结核病定点医院（永城市结核病防治所）<br/>
					4.结核病定点医院（永城市结核病防治所）确诊为传染性肺结核的患者可享受国家规定的免费治疗和免费检查项目<br/>
					<b>结核病定点医院（永城市结核病防治所）地址： 庆丰街与Z003交叉口西50米  电话：0370-3697733(总机)</b>
				</td>
            </tr>
        </table>
	</div>
</form>
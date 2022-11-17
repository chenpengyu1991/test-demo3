<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page import="com.founder.rhip.idm.common.SpecialEvents" %>
<%@ page import="com.founder.rhip.idm.common.TbStatus" %>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="T_REGISTER" value="<%=SpecialEvents.T_REGISTER.getValue()%>"/>
<c:set var="REGISTER" value="<%=TbStatus.REGISTER.getValue()%>" />
<c:set var="JKJHB" value="<%=RoleType.JKJHB.getValue()%>"/>
<script src="${pageContext.request.contextPath}/js/views/idm/tb/tb_common.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/tb/register.js" type="text/javascript"></script>
<div class="toolbar">
    <%-- <a href="javascript:tbCommon.returnSearch('register.searchTemp')" id="cancelContact"><b class="fanhui">返回</b></a> --%>
    <a href="javascript:tbCommon.returnSearch('register.searchTemp')" ><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
	<ehr:authorize ifNotGranted="${JKJHB}">
		<c:if test="${type=='1'}">
			<%-- <a href="javascript:tbCommon.tbSubmit('1','${REGISTER}','register.searchTemp','tbFormRegister')" id="saveContact"><b class="baocun">保存</b></a> --%>
			<a href="javascript:tbCommon.tbSubmit('1','${REGISTER}','register.searchTemp','tbFormRegister')"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
		</c:if>
		<c:if test="${type=='2'}">
			<%--<a href="javascript:tbCommon.tbSubmit('2','${REGISTER}','register.searchTemp','tbFormRegister')" id="editContact"><b class="xiug">修改</b></a>--%>
			<%-- <a href="javascript:tbCommon.tbSubmit('2','${REGISTER}','register.searchTemp','tbFormRegister')" id="editContact"><b class="baocun">保存</b></a> --%>
			<a href="javascript:tbCommon.tbSubmit('2','${REGISTER}','register.searchTemp','tbFormRegister')" ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
		</c:if>
	</ehr:authorize>
</div>
<form id="tbFormRegister">
	<input type="hidden" name="singleId" value="${tbSaveDto.singleId}" id="singleId"/>
	<input type="hidden" name="eventId" value="${T_REGISTER}" id="eventId"/>
	<input type="hidden" name="idmId" value="${tbSaveDto.idmId}" id="idmId"/>
	<input type="hidden" name="specialStatus" value="${REGISTER}"/>
	<input type="hidden" id="pageIndex" value="${pageIndex}">
	<input type="hidden" name="logoff" value="${tbSaveDto.logoff}"/>
	<input type="hidden" name="caseInformation.reviewUnit" value="${tbSaveDto.caseInformation.reviewUnit != null ? (tbSaveDto.caseInformation.reviewUnit!= '' ? tbSaveDto.caseInformation.reviewUnit : currentLoginInfo.organization.organCode) : currentLoginInfo.organization.organCode}"/>
	
    <div class="postcontent divFixed125" style="top: 200px;">
		<i class="popno">筛查登记</i>
		<div class="postdiv">
            <fieldset class="layui-elem-field">
                <legend>基本信息</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%" />
						<col style="width: 30%" />
						<col style="width: 20%" />
						<col style="width: 30%" />
					</colgroup>
					<tbody>
						<tr>
							<th><label class="required">姓名:</label></th>
							<td><input type="text" id="name" name="generalCondition.name" value="${tbSaveDto.generalCondition.name}" reg='{"required":"true","maxlength":"100"}'></td>
							<th>身份证号:</th>
							<td>
                        		<input type="text" id="idCard" name="generalCondition.idcard" value="${tbSaveDto.generalCondition.idcard}"
                                   placeholder="输入身份证获取个人信息" reg='{"idCard":"true"}'/>
                                   <input type="button" id="check-submit-btn1" value="读卡" style="width: 40px;">
                                   
                        	</td>
						</tr>
						<tr>
							<th><label class="required">性别:</label></th>
							<td>
                            	<ehr:dic-radio name="generalCondition.gender" id="gender" dicmeta="FS10006" value="${tbSaveDto.generalCondition.gender}" reg='{"required":"true"}'/>
                       		 </td>
							<th><label class="required">年龄:</label></th>
							<td>
								<tag:numberInput name="generalCondition.age" id="age" value="${tbSaveDto.generalCondition.age}"
		            				maxlength="3" cssClass="width30" style="width: 20%" reg='{"required":"true"}'/>
		            			<ehr:dic-radio name="generalCondition.ageUnit" dicmeta="IDM00003" value="${tbSaveDto.generalCondition.ageUnit==null?'1':tbSaveDto.generalCondition.ageUnit}" reg='{"required":"true"}' />
							</td>
						</tr>
						<tr>
							<th><label class="required">联系电话:</label></th>
							<td>
	                        	<input type="text" id="phoneNumberId" name="generalCondition.phoneNumber" value="${tbSaveDto.generalCondition.phoneNumber}" 
	                        		reg='{"required":"true","regex":"phone","maxlength":20}'/>
	                        </td>
						</tr>
						<tr>
			                <th><label class="required">常住类型:</label></th>
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
							<td colspan="3"><div class="${'2' eq tbSaveDto.generalCondition.floatPopulation || '4' eq tbSaveDto.generalCondition.floatPopulation ?'hide':'' }" id="hr-address-select">
								<ehr:dic-town-street-village
										villageId="hrvillage_address" townId="hrtown_address" streetId="hrStreet_address"
										villageName="generalCondition.hrGroup" streetName="generalCondition.hrstreet"
										townName="generalCondition.hrtownShip" streetValue="${tbSaveDto.generalCondition.hrstreet}"
										villageValue="${tbSaveDto.generalCondition.hrGroup}" callback="idmCommon.displayHrAddress"
										townValue="${tbSaveDto.generalCondition.hrtownShip}" width="118px;"  reg="{'required':true}"/>
								</div>
								<label id="tempHrValue">
									<ehr:dic code="${tbSaveDto.generalCondition.hrtownShip}" dicmeta="FS990001"/>
									<ehr:dic code="${tbSaveDto.generalCondition.hrstreet}" dicmeta="FS990001"/>
									<ehr:dic code="${tbSaveDto.generalCondition.hrGroup}" dicmeta="FS990001"/>
								</label>
								<input type="text" name="generalCondition.hrhouseNumber" id="hrhouseNumber" value="${tbSaveDto.generalCondition.hrhouseNumber}"
									   reg='{"required":"true","maxlength":"50"}' style="width:300px;" />(详细地址)
							</td>
						</tr>
					</tbody>
				</table>
			</fieldset>
			<fieldset class="layui-elem-field">
                <legend>症状信息</legend>
				<table class="posttable">
                    <colgroup>
                        <col style="width: 20%" />
                        <col style="width: 80%" />
                    </colgroup>
                    <tbody>
                    <tr>
                        <th><label class="required">可疑症状:</label></th>
                        <td>
                            <ehr:dic-checkbox name="clinicalManifestations.originalSymptom" dicmeta="IDM00213" value="${tbSaveDto.clinicalManifestations.originalSymptom}"
                                              onchange="toggleOtherCK('clinicalManifestations.originalSymptom','other','99')" reg='{"required":"true"}'/>
									<span id="other" style="display: none;">
										<input type="text" name="clinicalManifestations.other" value="${tbSaveDto.clinicalManifestations.other }"  reg='{"required":"true","maxlength":"100"}'
                                               style="width: 20%"/>
									</span>
                        </td>
                    </tr>
                    </tbody>
				</table>
			</fieldset>
			<fieldset class="layui-elem-field">
                <legend>患者来源</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%" />
						<col style="width: 80%" />
					</colgroup>
					<tbody>
						<tr>
							<th><label class="required">病人来源:</label></th>
							<td>
								<ehr:dic-radio dicmeta="IDM00214" name="otherCondition.caseSource" value="${tbSaveDto.otherCondition.caseSource}" code="1,2,7,8,99"
									onchange="toggleOther('otherCondition.caseSource','caseSourceOther','99')" reg='{"required":"true"}'/>
			                     <span id="caseSourceOther" style="${tbSaveDto.otherCondition.caseSource=='99' ? '' : 'display: none;' }">
			                     	<input type="text" name="otherCondition.caseSourceOther" value="${tbSaveDto.otherCondition.caseSourceOther}" reg='{"required":"true","maxlength":"50"}' style="width: 20%;"/>
			                     </span>
							</td>
						</tr>
					</tbody>
				</table>
			</fieldset>
			<fieldset class="layui-elem-field">
                <legend>胸透/胸片结果</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%" />
						<col style="width: 80%" />
					</colgroup>
					<tr>
						<th><label class="required">胸透/胸片结果:</label></th>
						<td colspan="3"><ehr:dic-radio dicmeta="IDM00216" code="1,2,3,4" name="labExamine.chestXrays" value="${tbSaveDto.labExamine.chestXrays}" reg='{"required":"true"}'/> </td>
					</tr>
				</table>
			</fieldset>
			<fieldset class="layui-elem-field">
                <legend>查痰结果</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%" />
						<col style="width: 80%" />
					</colgroup>
					<tr>
						<th><label class="required">查痰结果:</label></th>
						<td colspan="3"><ehr:dic-radio dicmeta="PH00004" code="1,2" name="labExamine.phlegmPcr" value="${tbSaveDto.labExamine.phlegmPcr}" reg='{"required":"true"}'/> </td>
					</tr>
				</table>
			</fieldset>
			<fieldset class="layui-elem-field">
                <legend>诊断结果</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 20%" />
						<col style="width: 80%" />
					</colgroup>
					<tr>
						<th><label class="required">初步诊断:</label></th>
						<td colspan="3">
							<ehr:dic-radio dicmeta="IDM00216" name="diagnosis.tentativeDiagnosis" value="${tbSaveDto.diagnosis.tentativeDiagnosis}"
								onchange="toggleOther('diagnosis.tentativeDiagnosis','otherDia','99')" reg='{"required":"true"}'/>
			                     <span id="otherDia" style="${tbSaveDto.diagnosis.tentativeDiagnosis=='99' ? '' : 'display: none;' }">
			                     	<input type="text" name="diagnosis.other" value="${tbSaveDto.diagnosis.other}" reg='{"required":"true","maxlength":"50"}' style="width: 20%;"/>
			                     </span>
						 </td>
					</tr>
					<tr>
						<th><label class="required">处理情况:</label></th>
						<td colspan="3">
							<ehr:dic-radio dicmeta="IDM00217" code="1,2,3,99" name="exposureHistory.handlingWay" value="${tbSaveDto.exposureHistory.handlingWay}"
								onchange="toggleOther('exposureHistory.handlingWay','hepatitisBPatientOther','99')" reg='{"required":"true"}'/>
			                     <span id="hepatitisBPatientOther" style="${tbSaveDto.exposureHistory.handlingWay=='99' ? '' : 'display: none;' }">
			                     	<input type="text" name="exposureHistory.hepatitisBPatientOther" value="${tbSaveDto.exposureHistory.hepatitisBPatientOther}" reg='{"required":"true","maxlength":"50"}' style="width: 20%;"/>
			                     </span>
						</td>
					</tr>
				</table>
			</fieldset>
			<fieldset class="layui-elem-field">
                <legend>单位信息</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 10%" />
						<col style="width: 23%" />
						<col style="width: 10%" />
						<col style="width: 23%" />
						<col style="width: 10%" />
						<col style="width: 24%" />
					</colgroup>
					<tr>
						<th>上报单位:</th>
						<td>
							<ehr:org code="${tbSaveDto.caseInformation.modifySurveyOrg}"/>
							<input type="hidden" name="caseInformation.modifySurveyOrg" value="${tbSaveDto.caseInformation.modifySurveyOrg}"/>
						</td>
						<th>报告人:</th>
						<td><ehr:user userCode="${tbSaveDto.caseInformation.modifyRespondents}"/>
							<input type="hidden" name="caseInformation.modifyRespondents" value="${tbSaveDto.caseInformation.modifyRespondents}"/>
	                    </td>
						<th>上报时间:</th>
						<td><fmt:formatDate value="${tbSaveDto.caseInformation.modifySurveyDate}" pattern="yyyy/MM/dd"/>
						<%-- <tag:dateInput id="birthday" name="caseInformation.modifySurveyDate" date="${tbSaveDto.caseInformation.modifySurveyDate}" style="display:none;"/> --%>
						<input type="text" class="layui-input x-admin-content-sm-date" name="caseInformation.modifySurveyDate" id="caseInformationModifySurveyDateId" value="<fmt:formatDate value='${tbSaveDto.caseInformation.modifySurveyDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;display:none;" />
	                    </td>
					</tr>
				</table>
			</fieldset>
		 </div>
    </div>
 </form>
 
 <script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#caseInformationModifySurveyDateId' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
    });

  });
</script>
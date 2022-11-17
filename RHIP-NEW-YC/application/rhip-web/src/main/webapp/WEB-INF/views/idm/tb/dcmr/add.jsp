<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="com.founder.rhip.idm.common.SpecialEvents" %>
<%@ page import="com.founder.rhip.idm.common.TbStatus" %>
<c:set var="T_DCMR" value="<%=SpecialEvents.T_DCMR.getValue()%>"/>
<c:set var="DCMR" value="<%=TbStatus.DCMR.getValue()%>" />
<script src="${pageContext.request.contextPath}/js/views/idm/tb/tb_common.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/tb/dcmr.js" type="text/javascript"></script>

<div class="toolbar">
    <%-- <a href="javascript:tbCommon.returnSearch('dcmr.searchTemp')" id="cancelContact"><b class="fanhui">返回</b></a> --%>
    <a href="javascript:tbCommon.returnSearch('dcmr.searchTemp')" ><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
    <c:if test="${type=='1'}">
        <%-- <a href="javascript:tbCommon.tbSubmit('1','${DCMR}','dcmr.searchTemp','tbFormDcmr')" id="saveContact"><b class="baocun">保存</b></a> --%>
        <a href="javascript:tbCommon.tbSubmit('1','${DCMR}','dcmr.searchTemp','tbFormDcmr')"  ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
   	</c:if>
    <c:if test="${type=='2'}">
         <%--<a href="javascript:tbCommon.tbSubmit('2','${DCMR}','dcmr.searchTemp','tbFormDcmr')" id="editContact"><b class="xiug">修改</b></a>--%>
        <%-- <a href="javascript:tbCommon.tbSubmit('2','${DCMR}','dcmr.searchTemp','tbFormDcmr')" id="editContact"><b class="baocun">保存</b></a> --%>
        <a href="javascript:tbCommon.tbSubmit('2','${DCMR}','dcmr.searchTemp','tbFormDcmr')"  ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
    </c:if>
</div>
<form id="tbFormDcmr">
	<input type="hidden" name="singleId" value="${tbSaveDto.singleId}" id="singleId"/>
	<input type="hidden" name="eventId" value="${T_DCMR}" id="eventId"/>
	<input type="hidden" name="idmId" value="${tbSaveDto.idmId}" id="idmId"/>
	<input type="hidden" name="specialStatus" value="${DCMR}"/>
	<input type="hidden" id="pageIndex" value="${pageIndex}">
	<input type="hidden" name="logoff" value="${tbSaveDto.logoff}"/>
	<div class="postcontent">
		<i class="popno">永城市肺结核病人专用门诊病历</i>
		<div class="postdiv divFixed125" style="top: 200px;">
			<fieldset class="layui-elem-field">
				<table class="posttable">
					<colgroup>
						<col style="width: 20%" />
						<col style="width: 30%" />
						<col style="width: 20%" />
						<col style="width: 30%" />
					</colgroup>
					<tr>
						<td colspan="2">
							<ehr:dic-town-street-village streetId="street_address" width="30%;"
												 townId="town_address" streetName="generalCondition.titleTown"
												 townName="generalCondition.titleCity"  streetValue="${tbSaveDto.generalCondition.titleTown}"
												 townValue="${tbSaveDto.generalCondition.titleCity}" />
							
						
							<%-- <ehr:dic-town-village villageName="generalCondition.titleTown" townName="generalCondition.titleCity"
		                       villageValue="${tbSaveDto.generalCondition.titleTown}" townValue="${tbSaveDto.generalCondition.titleCity}" width="180px;"/> --%>
						</td>
                        <td colspan="2" class="righttd">
                            单位名称:<input type="text" id="titleUnit" name="generalCondition.unitName" value="${tbSaveDto.generalCondition.unitName}" reg='{"maxlength":"70"}' style="width: 36%"/>
                        </td>
					</tr>
				</table>
			</fieldset>
			<fieldset class="layui-elem-field">
				<table class="posttable">
					<colgroup>
						<col style="width: 27%" />
						<col style="width: 29%" />
						<col style="width: 15%" />
						<col style="width: 29%" />
					</colgroup>
					<tr>
						<th>类型:</th>
						<td><ehr:dic-radio dicmeta="IDM00219" name="otherCondition.caseType"  value="${tbSaveDto.otherCondition.caseType}"/> </td>
						<th>X线片号:</th>
						<td><input type="text" id="xNo" name="labExamine.xNo" value="${tbSaveDto.labExamine.xNo}" reg='{"maxlength":"20"}'/></td>
					</tr>
					<tr>
						<th>门诊序号:</th>
						<td><input type="text" name="caseInformation.outpatientNo" value="${tbSaveDto.caseInformation.outpatientNo}"reg='{"maxlength":"50"}'/></td>
						<th><label class="required">费用类型:</label></th>
						<td><ehr:dic-radio dicmeta="IDM00220" uninclude="99,4" name="otherCondition.feesType"  value="${tbSaveDto.otherCondition.feesType}" reg='{"required":"true"}'/></td>
					</tr>
				</table>
			</fieldset>
			<fieldset class="layui-elem-field">
				<table class="posttable">
					<colgroup>
						<col style="width: 27%" />
						<col style="width: 29%" />
						<col style="width: 15%" />
						<col style="width: 29%" />
					</colgroup>
					<tr>
						<th><label class="required">姓名:</label></th>
						<td><input type="text" name="generalCondition.name" value="${tbSaveDto.generalCondition.name}" style="width: 100px;" reg='{"required":"true","maxlength":"100"}'/></td>
						<th><label class="required">性别:</label></th>
						<td>
			            	<ehr:dic-radio dicmeta="GBT226112003" name="generalCondition.gender" code="1,2" value="${tbSaveDto.generalCondition.gender}" reg='{"required":"true"}'/>
			            </td>
					</tr>
					<tr>
						<th>职业:</th>
						<td>
			            	<%--<ehr:dic-list dicmeta="GBT6565" name="generalCondition.occupation" width="180px;" value="${tbSaveDto.generalCondition.occupation}"--%>
		                                  <%--code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120208,CV020120209,CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120217,CV020120299"--%>
		                                  <%--onchange="toggleOtherSC('generalCondition.occupation','spanOccupationOther','CV020120299');"/>--%>
			            	 <%--<span id="spanOccupationOther" style="display: none;">--%>
		                         <%--<input type="text" name="generalCondition.occupationOther" value="${tbSaveDto.generalCondition.occupationOther}"--%>
		                                <%--reg='{"maxlength":"30"}' placeholder="若选择其他，请描叙" style="width: 20%;"/>--%>
		                     <%--</span>--%>
								<ehr:dic-list dicmeta="GBT6565"  width="180px;" code="0,1/2,3,4,5,6/7/8/9,X,Y,CV00031"  value="${tbSaveDto.generalCondition.occupation}" name="generalCondition.occupation"/>
			            </td>
						<th>羁押人员:</th>
						<td><ehr:dic-radio name="generalCondition.detain" dicmeta="PH00001" value="${tbSaveDto.generalCondition.detain == null ? '2' : tbSaveDto.generalCondition.detain}" code="1,2"/></td>
					</tr>
					<tr>
						<th><label class="required">身份证号:</label></th>
						<td>
							<input type="text" id="idCard" name="generalCondition.idcard" value="${tbSaveDto.generalCondition.idcard}"
                                   placeholder="输入身份证获取个人信息" reg='{"idCard":"true","required":"true"}'/>
                        </td>
						<th>民族:</th>
						<td>
			            	<%--<span id="nation">--%>
			            		<%--<ehr:dic-list name="generalCondition.nation" dicmeta="GBT3304" value="${tbSaveDto.generalCondition.nation eq null ? '01' : tbSaveDto.generalCondition.nation}"--%>
			            	     <%--width="25%"/>--%>
			            	<%--</span>--%>
			            	<%--<span id="nationOther" style="<c:if test="${tbSaveDto.generalCondition.nation != '44'}">display: none;</c:if>">--%>
			            		<%--<input type="text" name="generalCondition.nationOther" value="${tbSaveDto.generalCondition.nationOther}" --%>
			            	 	<%--style="width: 36%;" reg='{"maxlength":"20"}'/>--%>
			            	<%--</span>--%>
							<label><input type="radio" reg='{"required":true}' onclick="util.clickHideText(this,'cdmOtherNationDesc')" name="generalCondition.nation" ${tbSaveDto.generalCondition.nation eq"01" ?"checked":""} value="01" /> 汉族</label>
							<label><input type="radio" reg='{"required":true}' onclick="util.clickShowText(this,'cdmOtherNationDesc')" name="generalCondition.nation" ${(tbSaveDto.generalCondition.nation ne "1" && not empty tbSaveDto.generalCondition.nation && tbSaveDto.generalCondition.nation ne"01") ?"checked":""} value="99" /> 少数民族</label>
							<input type="text" id="cdmOtherNationDesc" ${tbSaveDto.generalCondition.nation ne "1" && not empty tbSaveDto.generalCondition.nation && tbSaveDto.generalCondition.nation ne"01"? "" : "class=\"hidediv\""} name="generalCondition.nationOther" value="${tbSaveDto.generalCondition.nationOther}" reg='{"required":"true"}' style="width: 70px;" />

						</td>
					</tr>
					<tr>
						<th>登记号:</th>
						<td><input type="text" name="generalCondition.registerNum" value="${tbSaveDto.generalCondition.registerNum}" style="width: 100px;" reg='{"maxlength":"100"}'/></td>
						<th>病案号:</th>
						<td><input type="text" name="generalCondition.unit" value="${tbSaveDto.generalCondition.unit}" style="width: 100px;" reg='{"maxlength":"100"}'/></td>
					</tr>
					<tr>
		                <th><label class="required">常住类型：</label></th>
		                <td>
		                    <ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005" reg='{"required":"true"}'
		                                   value='${"2"!=tbSaveDto.generalCondition.floatPopulation?"1":"2"}' onchange="idmCommon.toggerAddress()"/>
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
						<th>户籍地址（外地户籍者填写）:</th>
						<td colspan="3"><div class="${'2' eq tbSaveDto.generalCondition.floatPopulation?'hide':'' }" id="hr-address-select">
							<ehr:dic-town-street-village
									villageId="hrvillage_address" townId="hrtown_address" streetId="hrStreet_address"
									villageName="generalCondition.hrGroup" streetName="generalCondition.hrstreet"
									townName="generalCondition.hrtownShip" streetValue="${tbSaveDto.generalCondition.hrstreet}"
									villageValue="${tbSaveDto.generalCondition.hrGroup}" callback="idmCommon.displayHrAddress"
									townValue="${tbSaveDto.generalCondition.hrtownShip}" width="118px;" />
							</div><label id="tempHrValue">
								<ehr:dic code="${tbSaveDto.generalCondition.hrtownShip}" dicmeta="FS990001"/>
								<ehr:dic code="${tbSaveDto.generalCondition.hrstreet}" dicmeta="FS990001"/>
								<ehr:dic code="${tbSaveDto.generalCondition.hrGroup}" dicmeta="FS990001"/>
							</label>
			                 <input type="text" name="generalCondition.hrhouseNumber" id="hrhouseNumber" value="${tbSaveDto.generalCondition.hrhouseNumber}"
			                        style="width:300px;"/>(详细地址)
			             </td>
					</tr>
					<tr>
						<th>已在本辖区居住的时间:</th>
						<td colspan="3"><input type="text" name="generalCondition.livingConditionsOther" value="${tbSaveDto.generalCondition.livingConditionsOther}" reg='{"maxlength":"100"}' /> </td>
					</tr> 
					<tr>
						<th>工作单位:</th>
						<td colspan="3">
							<label id="unitName">${tbSaveDto.generalCondition.unitName}</label>
						</td>
					</tr>
					<tr>
						<th>电话:</th>
						<td><input type="text" name="generalCondition.phoneNumber" value="${tbSaveDto.generalCondition.phoneNumber}" reg='{"regex":"phone","maxlength":20}' style="width: 36%"/></td>
						<th>患者家庭年人均收入:</th>
						<td><input type="text" name="generalCondition.familyIncome" value="${tbSaveDto.generalCondition.familyIncome}" reg='{"maxlength":20}' style="width: 36%"/>元/年</td>
					</tr>
					<tr>
						<th>联系人1姓名:</th>
						<td><input type="text" name="generalCondition.contactName1" value="${tbSaveDto.generalCondition.contactName1}" reg='{"maxlength":50}'/></td>
						<th>电话:</th>
						<td><input type="text" name="generalCondition.contactPhone1" value="${tbSaveDto.generalCondition.contactPhone1}" reg='{"regex":"phone","maxlength":20}' style="width: 36%"/></td>
					</tr>
					<tr>
						<th>联系人2姓名:</th>
						<td><input type="text" name="generalCondition.contactName2" value="${tbSaveDto.generalCondition.contactName2 }" reg='{"maxlength":50}'/></td>
						<th>电话:</th>
						<td><input type="text" name="generalCondition.contactPhone2" value="${tbSaveDto.generalCondition.contactPhone2}" reg='{"regex":"phone","maxlength":20}' style="width: 36%"/></td>
					</tr>
					<tr>
						<th>患者来源:</th>
						<td colspan="3">
							<ehr:dic-radio dicmeta="IDM00214" name="otherCondition.caseSource"  value="${tbSaveDto.otherCondition.caseSource}" uninclude="2"
								onchange="toggleOther('otherCondition.caseSource','caseSourceOtherId','99')"/>
		                     <span id="caseSourceOtherId" style="display: none;">
		                     	<input type="text" name="otherCondition.caseSourceOther" value="${tbSaveDto.otherCondition.caseSourceOther}" reg='{"maxlength":"50"}' style="width: 20%;"/>
		                     </span>
						</td>
					</tr>
				</table>
			</fieldset>
			<fieldset class="layui-elem-field">
				<legend>主诉</legend>
				<table class="posttable">
					<tr>
						<td>
						 <textarea name="clinicalManifestations.chief" style="width: 100%" rows="5" reg='{"maxlength":"500"}'>${tbSaveDto.clinicalManifestations.chief}</textarea>
						</td>
					</tr>
				</table>
			</fieldset>
			<fieldset class="layui-elem-field">
				<legend>现病史</legend>
				<table class="posttable">
					<tr>
						<td>
						 <textarea name="clinicalManifestations.historyPresentIllness" style="width: 100%" rows="5" reg='{"maxlength":"500"}'>${tbSaveDto.clinicalManifestations.historyPresentIllness}</textarea>
						</td>
					</tr>
				</table>
			</fieldset>
			<fieldset class="layui-elem-field">
				<table class="posttable">
					<colgroup>
						<col style="width: 27%" />
						<col style="width: 29%" />
						<col style="width: 15%" />
						<col style="width: 29%" />
					</colgroup>
					<tr>
						<th>本次症状出现日期:</th>
						<td>
							<%-- <tag:dateInput id="symptomsTime" name="clinicalManifestations.symptomsTime" nullToToday="false" onlypast="true" pattern="yyyy/MM/dd"
								reg='{"compare":["firstDt","le","本次症状出现日期不能晚于本次首诊日期"]}' date="${tbSaveDto.clinicalManifestations.symptomsTime }"/> --%>
							<input type="text" reg='{"compare":["firstDt","le","本次症状出现日期不能晚于本次首诊日期"]}' class="layui-input x-admin-content-sm-date" name="clinicalManifestations.symptomsTime" id="symptomsTime" value="<fmt:formatDate value='${tbSaveDto.clinicalManifestations.symptomsTime}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />	
						</td>
						<th>本次首诊日期:</th>
						<td><%-- <tag:dateInput id="firstDt" name="clinicalManifestations.firstDt" nullToToday="false" onlypast="true" pattern="yyyy/MM/dd"
								reg='{"compare":["symptomsTime","ge","本次首诊日期不能早于本次症状出现日期"]}' date="${tbSaveDto.clinicalManifestations.firstDt}"/> --%>
								
								<input type="text" reg='{"compare":["symptomsTime","ge","本次首诊日期不能早于本次症状出现日期"]}' class="layui-input x-admin-content-sm-date" name="clinicalManifestations.firstDt" id="firstDt" value="<fmt:formatDate value='${tbSaveDto.clinicalManifestations.firstDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
						</td>
					</tr>
					<tr>
						<th>本次就诊时症状:</th>
					</tr>
					<tr>
						<td style="padding:0px;" colspan="4">
					    	<table>
					    		<colgroup>
									<col style="width: 27%" />
									<col style="width: 29%" />
									<col style="width: 15%" />
									<col style="width: 29%" />
								</colgroup>
								<tr>
									<th>咳嗽:</th>
									<td><ehr:dic-radio dicmeta="PH00001" name="clinicalManifestations.cough" code="1,2" value="${tbSaveDto.clinicalManifestations.cough}"/><br/></td>
									<th>咳痰:</th>
									<td><ehr:dic-radio dicmeta="PH00001" name="clinicalManifestations.expectoration" code="1,2" value="${tbSaveDto.clinicalManifestations.expectoration}"/><br/></td>
								</tr>
								<tr>
									<th>咯血:</th>
									<td><ehr:dic-radio dicmeta="PH00001" name="clinicalManifestations.hemoptysis" code="1,2" value="${tbSaveDto.clinicalManifestations.hemoptysis}"/><br/></td>
									<th>胸痛:</th>
									<td><ehr:dic-radio dicmeta="PH00001" name="clinicalManifestations.chestPain" code="1,2" value="${tbSaveDto.clinicalManifestations.chestPain}"/><br/></td>
								</tr>
								<tr>
									<th>发热:</th>
									<td><ehr:dic-radio dicmeta="PH00001" name="clinicalManifestations.fever" code="1,2" value="${tbSaveDto.clinicalManifestations.fever}"/></td>
									<th>乏力:</th>
									<td><ehr:dic-radio dicmeta="PH00001" name="clinicalManifestations.feeble" code="1,2" value="${tbSaveDto.clinicalManifestations.feeble}"/><br/></td>
								</tr>
								<tr>
									<th>食欲减退:</th>
									<td><ehr:dic-radio dicmeta="PH00001" name="clinicalManifestations.poorAppetite" code="1,2" value="${tbSaveDto.clinicalManifestations.poorAppetite}"/><br/></td>
									<th>盗汗:</th>
									<td><ehr:dic-radio dicmeta="PH00001" name="clinicalManifestations.nightSweat" code="1,2" value="${tbSaveDto.clinicalManifestations.nightSweat}"/><br/></td>
								</tr>
								<tr>
									<th>其它:</th>
									<td>
										<ehr:dic-radio dicmeta="PH00001" name="clinicalManifestations.otherSelect" code="1,2"
						   					value="${tbSaveDto.clinicalManifestations.otherSelect}" 
						   					onchange="toggleOther('clinicalManifestations.otherSelect','otherSpan',1)"/>
						   				<span id="otherSpan" style="${tbSaveDto.clinicalManifestations.otherSelect=='1' ? '' : 'display: none;'}">
										   	  <input type="text" name="clinicalManifestations.other" value="${tbSaveDto.clinicalManifestations.other}" reg='{"maxlength":"500"}' style="width: 36%"/>
										   </span> 
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</fieldset>
			<fieldset class="layui-elem-field">
				<table class="posttable">
					<colgroup>
						<col style="width: 27%" />
						<col style="width: 29%" />
						<col style="width: 15%" />
						<col style="width: 29%" />
					</colgroup>
					<tr>
						<th>既往结核病诊断和治疗情况:</th>
						<td><ehr:dic-radio dicmeta="PH00002" name="pastHistory.previousHistory" code="1,2"  value="${tbSaveDto.pastHistory.previousHistory }"
										onchange="toggleOther('pastHistory.previousHistory','firstVisitDate',1)"/>
						 </td>
						 <td></td>
						 <td></td>
					</tr>
					<tr id="firstVisitDate" style="${tbSaveDto.pastHistory.previousHistory=='1' ? '' : 'display:none;' }">
						<td colspan="4" style="padding: 0px;">
							<table>
								<colgroup>
									<col style="width: 27%" />
									<col style="width: 29%" />
									<col style="width: 15%" />
									<col style="width: 29%" />
								</colgroup>
								<tr>
									<th>首次确诊日期:</th>
									<td><%-- <tag:dateInput name="attackCondition.firstVisitDate" nullToToday="false" onlypast="true" pattern="yyyy/MM/dd"
											 date="${tbSaveDto.attackCondition.firstVisitDate }" style="width: 40%"/> --%>
									      <input type="text" reg='{"compare":["symptomsTime","ge","本次首诊日期不能早于本次症状出现日期"]}' class="layui-input x-admin-content-sm-date" name="attackCondition.firstVisitDate" id="attackConditionFirstVisitDateId" value="<fmt:formatDate value='${tbSaveDto.attackCondition.firstVisitDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 40%" />
											 </td>
									<th>抗结核治疗史:</th>
									<td><ehr:dic-radio dicmeta="PH00002" name="pastHistory.previousType" code="1,2" value="${tbSaveDto.pastHistory.previousType }"/></td>
								</tr>
								<tr>
									<th>首次治疗日期:</th>
									<td><%-- <tag:dateInput name="otherCondition.therapyTime" nullToToday="false" onlypast="true" pattern="yyyy/MM/dd"
										 date="${tbSaveDto.otherCondition.therapyTime }" style="width: 40%"/> --%>
										 <input type="text" reg='{"compare":["symptomsTime","ge","本次首诊日期不能早于本次症状出现日期"]}' class="layui-input x-admin-content-sm-date" name="otherCondition.therapyTime" id="otherConditionTherapyTimeId" value="<fmt:formatDate value='${tbSaveDto.otherCondition.therapyTime}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 40%" />
										 </td>
								</tr>
								<tr>
									<th>累计用药量:</th>
								</tr>
								<tr>
									<th>H:</th>
									<td><input type="text" name="otherCondition.hDays" value="${tbSaveDto.otherCondition.hDays }" style="width: 40%" reg='{"maxlength":"20"}'/>天</td>
									<th>R:</th>
									<td><input type="text" name="otherCondition.rDays" value="${tbSaveDto.otherCondition.rDays }" style="width: 40%" reg='{"maxlength":"20"}'/>天</td>
								</tr>
								<tr>
									<th>S:</th>
									<td><input type="text" name="otherCondition.sDays" value="${tbSaveDto.otherCondition.sDays }" style="width: 40%" reg='{"maxlength":"20"}'/>天</td>
									<th>E:</th>
									<td><input type="text" name="otherCondition.eDays" value="${tbSaveDto.otherCondition.eDays }" style="width: 40%" reg='{"maxlength":"20"}'/>天</td>
								</tr>
								<tr>
									<th>Z:</th>
									<td><input type="text" name="otherCondition.zDays" value="${tbSaveDto.otherCondition.zDays }" style="width: 40%" reg='{"maxlength":"20"}'/>天</td>
								</tr>
								<tr>
									<th>停止治疗原因:</th>
									<td colspan="3">
										<ehr:dic-radio dicmeta="IDM00228" name="pastHistory.stopReason" value="${tbSaveDto.pastHistory.stopReason}"
											onchange="toggleOther('pastHistory.stopReason','stopCauseOther',99)" />
					                     <span id="stopCauseOther"  style="display:none;">
					                     	<input type="text" name="pastHistory.stopReasonOther" value="${tbSaveDto.pastHistory.stopReasonOther}" reg='{"maxlength":"100"}' style="width: 20%;"/>
					                     </span>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</fieldset>
			<fieldset class="layui-elem-field">
				<legend>既往史</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 27%" />
						<col style="width: 29%" />
						<col style="width: 15%" />
						<col style="width: 29%" />
					</colgroup>
					<tr>
						<th>卡介苗接种史:</th>
						<td><ehr:dic-radio dicmeta="PH00002" name="pastHistory.bcgHistory" code="1,2" value="${tbSaveDto.pastHistory.bcgHistory }"/> </td>
						<th>肝病史:</th>
						<td><ehr:dic-radio dicmeta="PH00002" name="pastHistory.cldFlg" code="1,2" value="${tbSaveDto.pastHistory.cldFlg }"/> </td>
					</tr>
					<tr>
						<th>肾病史:</th>
						<td><ehr:dic-radio dicmeta="PH00002" name="pastHistory.crdFlg" code="1,2" value="${tbSaveDto.pastHistory.crdFlg }"/> </td>
						<th>与结核病患者的密切接触式:</th>
						<td><ehr:dic-radio dicmeta="PH00002" name="pastHistory.contactHistory" code="1,2" value="${tbSaveDto.pastHistory.contactHistory }"/> </td>
					</tr>
					<tr>
						<th>药物过敏史:</th>
						<td colspan="3"><ehr:dic-radio dicmeta="PH00002" name="pastHistory.drugAllergy" code="1,2" value="${tbSaveDto.pastHistory.drugAllergy }"/> </td>
					</tr>
				</table>
			</fieldset>
			<fieldset class="layui-elem-field">
				<legend>体格检查</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 27%" />
						<col style="width: 29%" />
						<col style="width: 15%" />
						<col style="width: 29%" />
					</colgroup>
					<tr>
						<th>一般情况</th>
					</tr>
					<tr>
						<th>体温:</th>
						<td>
							<input type="text" name="clinicalManifestations.temperature" value="${tbSaveDto.clinicalManifestations.temperature }" style="width: 20%;" reg='{"maxlength":"20"}'/>
						</td>
						<th>血压:</th>
						<td>
							<input type="text" name="clinicalManifestations.bloodPressure" value="${tbSaveDto.clinicalManifestations.bloodPressure }" style="width: 20%;" reg='{"maxlength":"20"}'/>
							/<input type="text" name="clinicalManifestations.bloodPressureDiastolic" value="${tbSaveDto.clinicalManifestations.bloodPressureDiastolic }" style="width: 20%;" reg='{"maxlength":"20"}'/>mmHg</td>
					</tr>
					<tr>
						<th>脉搏:</th>
						<td>
							<tag:numberInput name="clinicalManifestations.pulse" value="${tbSaveDto.clinicalManifestations.pulse}" 
		            			maxlength="3" cssClass="width30" style="width: 20%;"/>次/分
						</td>
						<th>呼吸:</th>
						<td>
							<tag:numberInput name="clinicalManifestations.respiratory" value="${tbSaveDto.clinicalManifestations.respiratory}" 
		            			maxlength="3" cssClass="width30" style="width: 20%"/>次/分
		            	</td>
					</tr>
					<tr>
						<th>体重:</th>
						<td>
							<tag:numberInput name="clinicalManifestations.weight" value="${tbSaveDto.clinicalManifestations.weight}" 
		            			maxlength="3" cssClass="width30" style="width: 20%"/>kg
						</td>
					</tr>
					<tr>
						<th>胸部检查:</th>
						<td colspan="3"><input type="text" name="labExamine.chestXrayFirstOther" value="${tbSaveDto.labExamine.chestXrayFirstOther }" reg='{"maxlength":"100"}'/></td>
					</tr>
					<tr>
						<th>心脏检查:</th>
						<td colspan="3"><input type="text" name="labExamine.heartCheck" value="${tbSaveDto.labExamine.heartCheck }" reg='{"maxlength":"100"}'/></td>
					</tr>
					<tr>
						<th>肝脏检查:</th>
						<td colspan="3"><input type="text" name="labExamine.liverCheck" value="${tbSaveDto.labExamine.liverCheck }" reg='{"maxlength":"100"}'/></td>
					</tr>
					<tr>
						<th>肾脏检查:</th>
						<td colspan="3"><input type="text" name="labExamine.kidneyCheck" value="${tbSaveDto.labExamine.kidneyCheck }" reg='{"maxlength":"100"}'/></td>
					</tr>
					<tr>
						<th>其它:</th>
						<td colspan="3"><input type="text" name="labExamine.other" value="${tbSaveDto.labExamine.other }" reg='{"maxlength":"100"}'/></td>
					</tr>
				</table>
			</fieldset>
			<fieldset class="layui-elem-field">
				<legend>结素试验、影像学和实验室检查</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 27%" />
						<col style="width: 29%" />
						<col style="width: 15%" />
						<col style="width: 29%" />
					</colgroup>
					<tr>
						<th>结素试验（PPD)结果:</th>
						<td><input type="text" name="labExamine.tuberculinTest" value="${tbSaveDto.labExamine.tuberculinTest}" reg='{"maxlength":"100"}'/>mm</td>
						<th>试验日期:</th>
						<td><%-- <tag:dateInput name="labExamine.resultReportDate_2" nullToToday="false" onlypast="true" pattern="yyyy/MM/dd" date="${tbSaveDto.labExamine.resultReportDate_2}"/> --%>
						
						<input type="text" class="layui-input x-admin-content-sm-date" name="labExamine.resultReportDate_2" id="labExamineResultReportDate_2Id" value="<fmt:formatDate value='${tbSaveDto.labExamine.resultReportDate_2}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
						</td>
					</tr>
					<tr>
						<th>X线检查结果:</th>
						<td><input type="text" name="labExamine.xrayTestResult" value="${tbSaveDto.labExamine.xrayTestResult}" reg='{"maxlength":"20"}'/></td>
					</tr>
                    <tr>
                        <th>空洞:</th>
                        <td colspan="3">
                            <ehr:dic-radio dicmeta="PH00002" name="labExamine.cavityFlag" code="1,2" value="${tbSaveDto.labExamine.cavityFlag}"
                                           onchange="toggleOther('labExamine.cavityFlag','cavity',1)"/>
                            <span id="cavity" style="display: none;">
                                <br/>
                                分级：<ehr:dic-radio dicmeta="IDM00237" name="labExamine.cavityScale" value="${tbSaveDto.labExamine.cavityScale}"/>
                                <br/>
                                位置描述：<input type="text" name="labExamine.cavity" value="${tbSaveDto.labExamine.cavity}" reg='{"maxlength":"100"}'/>
                            </span>
                        </td>
                    </tr>
					<tr>
						<th>X线号:</th>
						<td colspan="3"><label id="xNoTemp">${tbSaveDto.labExamine.xNo}</label></td>
					</tr>
					<tr>
						<th>痰菌检查</th>
					</tr>
					<tr>
						<th>痰涂片检查结果:</th>
						<td>
							<ehr:dic-list name="labExamine.phlegmPcr" dicmeta="PH00022" value="${tbSaveDto.labExamine.phlegmPcr }"
								onchange="toggleOtherSC('labExamine.phlegmPcr','picOther','99')"/>
		                     <span id="picOther" style="${tbSaveDto.labExamine.phlegmPcr=='99' ? '' : 'display: none;'}">
		                     	<input type="text" name="labExamine.phlegmPcrResult" value="${tbSaveDto.labExamine.phlegmPcrResult }" reg='{"maxlength":"20"}' style="width: 40%;"/>
		                     </span>
						</td>
						<th>痰培养检查结果:</th>
						<td>
							<ehr:dic-list name="labExamine.phlegmRtPcr" dicmeta="PH00022" value="${tbSaveDto.labExamine.phlegmRtPcr }"
								onchange="toggleOtherSC('labExamine.phlegmRtPcr','culOther','99')"/>
		                     <span id="culOther" style="${tbSaveDto.labExamine.phlegmRtPcr=='99' ? '' : 'display: none;'}">
		                     	<input type="text" name="labExamine.phlegmRtPcrResult" value="${tbSaveDto.labExamine.phlegmRtPcrResult }" reg='{"maxlength":"20"}' style="width: 40%;"/>
		                     </span>
						</td>
					</tr>
					<tr>
						<th>痰培养检查结果报告日期:</th>
						<td><%-- <tag:dateInput name="labExamine.cultureReportDt" nullToToday="false" onlypast="true" pattern="yyyy/MM/dd" date="${tbSaveDto.labExamine.cultureReportDt}"/> --%>
						<input type="text" class="layui-input x-admin-content-sm-date" name="labExamine.cultureReportDt" id="labExamineCultureReportDtId" value="<fmt:formatDate value='${tbSaveDto.labExamine.cultureReportDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
						</td>
					</tr>
					<tr>
						<th>药敏试验结果:</th>
					</tr>
					<tr>
						<th>H:</th>
						<td><ehr:dic-radio dicmeta="CV0450013" name="labExamine.drugH" value="${tbSaveDto.labExamine.drugH }"/> </td>
						<th>R:</th>
						<td><ehr:dic-radio dicmeta="CV0450013" name="labExamine.drugR" value="${tbSaveDto.labExamine.drugR }"/> </td>
					</tr>
					<tr>
						<th>E:</th>
						<td><ehr:dic-radio dicmeta="CV0450013" name="labExamine.drugE" value="${tbSaveDto.labExamine.drugE }"/> </td>
						<th>S:</th>
						<td><ehr:dic-radio dicmeta="CV0450013" name="labExamine.drugS" value="${tbSaveDto.labExamine.drugS }"/> </td>
					</tr>
					<tr>
						<th>药敏试验结果报告时间:</th>
						<td>
						<%-- <tag:dateInput name="labExamine.drugReportDt" nullToToday="false" onlypast="true" pattern="yyyy/MM/dd" date="${tbSaveDto.labExamine.drugReportDt}"/> --%>
						<input type="text" class="layui-input x-admin-content-sm-date" name="labExamine.drugReportDt" id="labExamineCultureReportDtId" value="<fmt:formatDate value='${tbSaveDto.labExamine.cultureReportDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
						</td>
					</tr>
					<tr>
						<th>HIV抗体检测结果:</th>
						<td colspan="3"><ehr:dic-radio dicmeta="IDM00236" name="labExamine.hivResult" value="${tbSaveDto.labExamine.hivResult}"/> </td>
					</tr>
					<tr>
						<th>如果HIV阳性，最近一次CD4+细胞计数值:</th>
						<td><input type="text" name="labExamine.hivCd4" value="${tbSaveDto.labExamine.hivCd4 }" reg='{"maxlength":"10"}'/> </td>
						<th>报告时间:</th>
						<td><%-- <tag:dateInput name="labExamine.hivReportDt" nullToToday="false" onlypast="true" pattern="yyyy/MM/dd" date="${tbSaveDto.labExamine.hivReportDt}"/> --%>
						<input type="text" class="layui-input x-admin-content-sm-date" name="labExamine.hivReportDt" id="labExamineHivReportDtId" value="<fmt:formatDate value='${tbSaveDto.labExamine.hivReportDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
						</td>
					</tr>
				</table>
			</fieldset>
			<fieldset class="layui-elem-field">
				<legend>结果登记</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 27%" />
						<col style="width: 29%" />
						<col style="width: 15%" />
						<col style="width: 29%" />
					</colgroup>
					<tr>
						<th>本次确诊日期:</th>
						<td><%-- <tag:dateInput name="diagnosis.diagnosisDt" nullToToday="false" onlypast="true" pattern="yyyy/MM/dd" date="${tbSaveDto.diagnosis.diagnosisDt }"/> --%>
						<input type="text" class="layui-input x-admin-content-sm-date" name="diagnosis.diagnosisDt" id="diagnosisDiagnosisDtId" value="<fmt:formatDate value='${tbSaveDto.diagnosis.diagnosisDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
						</td>
					</tr>
					<tr>
						<th>诊断结果 <input type="hidden" name="diagnosis.diagnosisType" value="2"/> </th>
					</tr>
					<tr>
						<th>肺结核:</th>
						<td colspan="3"><ehr:dic-radio name="diagnosis.lastDiagnosis" dicmeta="IDM00237" code="1,2,3" value="${tbSaveDto.diagnosis.lastDiagnosis}"/></td>
					</tr>
					<tr>
						<th>结核性胸膜炎Ⅳ型:</th>
						<td>
							<input type="radio" name="diagnosis.diagnosisAccording" value="1"
								<c:if test="${tbSaveDto.diagnosis.diagnosisAccording == '1'}">checked="checked"</c:if>
							onclick="toggleOther('diagnosis.diagnosisAccording','diagnosisReasonMulti',2);toggleOtherCK('diagnosis.diagnosisReasonMulti','diagnosisOther','99')"/>
						</td>
					</tr>
					<tr>
						<th>其他肺外结核Ⅴ型:</th>
						<td colspan="3">
						    <input type="radio" name="diagnosis.diagnosisAccording" value="2"
								<c:if test="${tbSaveDto.diagnosis.diagnosisAccording == '2'}">checked="checked"</c:if>
                                onclick="toggleOther('diagnosis.diagnosisAccording','diagnosisReasonMulti',2)"/>
		                    <span id="diagnosisReasonMulti" style="display: none;">
								&nbsp;&nbsp;&nbsp;<ehr:dic-checkbox name="diagnosis.diagnosisReasonMulti" dicmeta="IDM00238" value="${tbSaveDto.diagnosis.diagnosisReasonMulti}"
								onchange="toggleOtherCK('diagnosis.diagnosisReasonMulti','diagnosisOther','99')"/>
								<span id="diagnosisOther" style="display: none;">
									<input type="text" name="diagnosis.diagnosisOther" value="${tbSaveDto.diagnosis.diagnosisOther }"  reg='{"maxlength":"100"}'
									style="width: 20%"/>
								</span>
							</span>
						</td>
					</tr>
					<tr>
						<th>合并其他系统结核</th>
						<td colspan="3">
							<ehr:dic-radio dicmeta="PH00002" name="diagnosis.otherPhthisis" code="1,2" value="${tbSaveDto.diagnosis.otherPhthisis }"
								onchange="toggleOther('diagnosis.otherPhthisis','otherPhthisisMulti',1)"/>
							<span id="otherPhthisisMulti" style="${tbSaveDto.diagnosis.otherPhthisis=='1' ? '' : 'display: none;'}">
								&nbsp;&nbsp;&nbsp;<ehr:dic-checkbox dicmeta="IDM00238" name="diagnosis.otherPhthisisMulti" value="${tbSaveDto.diagnosis.otherPhthisisMulti }"
									onchange="toggleOtherCK('diagnosis.otherPhthisisMulti','otherPhthisisOther','99')"/>
								<span id="otherPhthisisOther" style="display: none;">
									<input type="text" name="diagnosis.otherPhthisisOther" value="${tbSaveDto.diagnosis.otherPhthisisOther }" reg='{"maxlength":"100"}'
									 style="width: 20%"/>
								</span>
							</span>
						</td>
					</tr>
					<tr>
						<th>合并症</th>
						<td colspan="3">
							<ehr:dic-radio dicmeta="PH00002" name="diagnosis.complication" code="1,2" value="${tbSaveDto.diagnosis.complication }"
								onchange="toggleOther('diagnosis.complication','complicationMulti',1)"/>
							
							<span id="complicationMulti" style="${tbSaveDto.diagnosis.complication=='1' ? '' : 'display: none;'}">
								&nbsp;&nbsp;&nbsp;<ehr:dic-checkbox dicmeta="IDM00239" name="diagnosis.complicationMulti" value="${tbSaveDto.diagnosis.complicationMulti }"
									onchange="toggleOtherCK('diagnosis.complicationMulti','complicationOther','99')" code="1,2,3,99"/>
								<span id="complicationOther" style="display: none;">
									<input type="text" name="diagnosis.complicationOther" value="${tbSaveDto.diagnosis.complicationOther }" reg='{"maxlength":"100"}'
									 style="width: 20%"/>
								</span>
							</span>
						</td>
					</tr>
					<tr>
						<th>本次登记日期</th>
						<td><%-- <tag:dateInput name="diagnosis.registerDt" nullToToday="true" onlypast="true" pattern="yyyy/MM/dd" date="${tbSaveDto.diagnosis.registerDt}"/> --%>
						<input type="text" class="layui-input x-admin-content-sm-date" name="diagnosis.registerDt" id="diagnosisRegisterDtId" value="<fmt:formatDate value='${tbSaveDto.diagnosis.registerDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
						</td>
						<th>患者登记分类</th>
						<td>
							<ehr:dic-list dicmeta="IDM00240" name="diagnosis.polioExcludeDiagnosis" value="${tbSaveDto.diagnosis.polioExcludeDiagnosis }"
								onchange="toggleOtherSC('diagnosis.polioExcludeDiagnosis','other','99')"/>
							<span id="other" style="${tbSaveDto.diagnosis.polioExcludeDiagnosis=='99' ? '' : 'display: none;'}">
								<input type="text" name="diagnosis.other" value="${tbSaveDto.diagnosis.other }" reg='{"maxlength":"100"}'
								style="width: 20%;"/>
							</span>
						</td>
					</tr>
				</table>
			</fieldset>
			<fieldset class="layui-elem-field">
				<legend>治疗情况</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 27%" />
						<col style="width: 29%" />
						<col style="width: 15%" />
						<col style="width: 29%" />
					</colgroup>
					<tr>
						<th>本次治疗日期:</th>
						<td><%-- <tag:dateInput name="otherCondition.thisDt" nullToToday="false" onlypast="true" pattern="yyyy/MM/dd" date="${tbSaveDto.otherCondition.thisDt}"/> --%>
						<input type="text" class="layui-input x-admin-content-sm-date" name="otherCondition.thisDt" id="otherConditionThisDtId" value="<fmt:formatDate value='${tbSaveDto.otherCondition.thisDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
						</td>
						<th>治疗分类:</th>
						<td>
							<ehr:dic-radio dicmeta="IDM00215" name="otherCondition.thisType" value="${tbSaveDto.otherCondition.thisType }"
								onchange="toggleOther('otherCondition.thisType','thisType1',99)"/>
							
							<span id="thisType1" style="display: none;">
								<ehr:dic-list dicmeta="IDM00241" name="otherCondition.thisType1" value="${tbSaveDto.otherCondition.thisType1}"
									onchange="toggleOtherSC('otherCondition.thisType1','thisTypeOther','99')"/>
								<span id="thisTypeOther" style="display: none;">
									<input type="text" name="otherCondition.thisTypeOther" value="${tbSaveDto.otherCondition.thisTypeOther }" reg='{"maxlength":"100"}'
									 style="width: 20%;"/>
								</span>
							</span> 
						</td>
					</tr>
					<tr>
						<th>治疗方案:</th>
						<td><input type="text" name="otherCondition.treatMethod" value="${tbSaveDto.otherCondition.treatMethod }" reg='{"maxlength":"100"}'/></td>
						<th>抗结核药物费用支付方式:</th>
						<td><ehr:dic-radio dicmeta="IDM00220" uninclude="3,4" name="otherCondition.thisFeesType" value="${tbSaveDto.otherCondition.thisFeesType }"/></td>
					</tr>
					<tr>
						<th>治疗管理方式:</th>
						<td colspan="3"><ehr:dic-radio dicmeta="IDM00243" name="otherCondition.thisManageType" value="${tbSaveDto.otherCondition.thisManageType }"/></td>
					</tr>
					<tr>
						<th>变更方案:</th>
						<td><input type="text" name="otherCondition.changeType" value="${tbSaveDto.otherCondition.changeType }" reg='{"maxlength":"100"}'/></td>
						<th>变更日期:</th>
						<td><%-- <tag:dateInput name="otherCondition.changeDt" nullToToday="false" onlypast="true" pattern="yyyy/MM/dd" date="${tbSaveDto.otherCondition.changeDt }"/> --%>
						<input type="text" class="layui-input x-admin-content-sm-date" name="otherCondition.changeDt" id="otherConditionChangeDtId" value="<fmt:formatDate value='${tbSaveDto.otherCondition.changeDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
						</td>
					</tr>
					<tr>
						<th>本次诊断结核病时HIV阳性者已开始抗病毒治疗:</th>
						<td><ehr:dic-radio dicmeta="PH00002" name="otherCondition.hiv" code="1,2" value="${tbSaveDto.otherCondition.hiv}"/></td>
						<th>开始日期:</th>
						<td><%-- <tag:dateInput name="otherCondition.hivStartDt" nullToToday="false" onlypast="true" pattern="yyyy/MM/dd" date="${tbSaveDto.otherCondition.hivStartDt }"/> --%>
						<input type="text" class="layui-input x-admin-content-sm-date" name="otherCondition.hivStartDt" id="otherConditionHivStartDtId" value="<fmt:formatDate value='${tbSaveDto.otherCondition.hivStartDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
						</td>
					</tr>
					<tr>
						<th>本次诊断结核病时HIV阳性者已开始CPT治疗:</th>
						<td><ehr:dic-radio dicmeta="PH00002" name="otherCondition.cpt" code="1,2" value="${tbSaveDto.otherCondition.cpt }"/></td>
						<th>开始日期:</th>
						<td><%-- <tag:dateInput name="otherCondition.cptStartDt" nullToToday="false" onlypast="true" pattern="yyyy/MM/dd" date="${tbSaveDto.otherCondition.cptStartDt }"/> --%>
						<input type="text" class="layui-input x-admin-content-sm-date" name="otherCondition.cptStartDt" id="otherConditionCptStartDtId" value="<fmt:formatDate value='${tbSaveDto.otherCondition.cptStartDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
						</td>
					</tr>
					<tr>
						<th>医生签名:</th>
						<td>
							<ehr:user userCode="${tbSaveDto.otherCondition.thisDoctor}"/>
							<input type="hidden" name="otherCondition.thisDoctor" value="${tbSaveDto.otherCondition.thisDoctor }"/>
						</td>
					</tr>
				</table>
			</fieldset>
			<div>
						
			</div>
			<fieldset class="layui-elem-field">
				<legend>治疗管理结果</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 27%" />
						<col style="width: 29%" />
						<col style="width: 15%" />
						<col style="width: 29%" />
					</colgroup>
					<tr>
						<th>停止治疗日期:</th>
						<td><%-- <tag:dateInput id="stopReasonDt" name="otherCondition.stopReasonDt" nullToToday="false" onlypast="true" pattern="yyyy/MM/dd" date="${tbSaveDto.otherCondition.stopReasonDt }"/> --%>
						<input type="text" class="layui-input x-admin-content-sm-date" name="otherCondition.stopReasonDt" id="stopReasonDt" value="<fmt:formatDate value='${tbSaveDto.otherCondition.stopReasonDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
						</td>
						<th>停止治疗原因:</th>
						<td>
							<ehr:dic-list name="otherCondition.stopReason" dicmeta="IDM00244" value="${tbSaveDto.otherCondition.stopReason}"
								onchange="toggleOtherSC('otherCondition.stopReason','stopReasonOther','99')" uninclude="8,99"/>
							<span id="stopReasonOther" style="${tbSaveDto.otherCondition.stopReason == '99'? '' : 'display:none;'}">
								<input type="text" name="otherCondition.stopReasonOther" value="${tbSaveDto.otherCondition.stopReasonOther}"
							   reg='{"maxlength":"100"}' style="width: 26%;"/>
							</span>
						</td>
					</tr>
					<tr>
						<th>实际管理方式:</th>
						<td><ehr:dic-radio name="otherCondition.manageType" dicmeta="IDM00243" value="${tbSaveDto.otherCondition.manageType }"/></td>
						<th>管理系统:</th>
						<td><ehr:dic-radio dicmeta="PH00002" name="otherCondition.sysManage" code="1,2" value="${tbSaveDto.otherCondition.sysManage }"/></td>
					</tr>
					<tr>
						<th>判断医生签名:</th>
						<td>
							<ehr:user userCode="${tbSaveDto.otherCondition.judgeDoctor}"/>
							<input type="hidden" name="otherCondition.judgeDoctor" value="${tbSaveDto.otherCondition.judgeDoctor}"/>
						</td>
						<th>日期:</th>
						<td><%-- <tag:dateInput name="otherCondition.judgeDt" nullToToday="false" onlypast="true" pattern="yyyy/MM/dd" date="${tbSaveDto.otherCondition.judgeDt }"/> --%>
						<input type="text" class="layui-input x-admin-content-sm-date" name="otherCondition.judgeDt" id="otherConditionJudgeDtId" value="<fmt:formatDate value='${tbSaveDto.otherCondition.judgeDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
						</td>
					</tr>
				</table>
			</fieldset>
			<fieldset class="layui-elem-field">
				<legend>病程记录</legend>
				<table class="posttable">
					<tr>
						<td><textarea  name="otherCondition.diseaseRecord" rows="6" cols="31" style="width: 100%" reg='{"maxlength":"4000"}'>${tbSaveDto.otherCondition.diseaseRecord }</textarea> </td>
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
      elem: '#symptomsTime' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
    });

    laydate.render({
      elem: '#firstDt' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
    });
    
    laydate.render({
        elem: '#attackConditionFirstVisitDateId' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
      });
    
    laydate.render({
        elem: '#otherConditionTherapyTimeId' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
      });
    
    laydate.render({
        elem: '#labExamineResultReportDate_2Id' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
      });
    
    laydate.render({
        elem: '#labExamineCultureReportDtId' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
    laydate.render({
        elem: '#labExamineHivReportDtId' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
    laydate.render({
        elem: '#diagnosisDiagnosisDtId' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
    laydate.render({
        elem: '#diagnosisRegisterDtId' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
    laydate.render({
        elem: '#otherConditionThisDtId' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
    
    laydate.render({
        elem: '#otherConditionChangeDtId' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
    
    laydate.render({
        elem: '#otherConditionHivStartDtId' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
    laydate.render({
        elem: '#otherConditionCptStartDtId' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
    laydate.render({
        elem: '#stopReasonDt' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
    laydate.render({
        elem: '#otherConditionJudgeDtId' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
      });
    
  });
</script>
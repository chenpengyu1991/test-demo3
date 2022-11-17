<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.founder.rhip.idm.common.SpecialEvents" %>
<%@ page import="com.founder.rhip.idm.common.TbStatus" %>
<c:set var="T_TREATMENT" value="<%=SpecialEvents.T_TREATMENT.getValue()%>"/>
<c:set var="TREATMENT" value="<%=TbStatus.TREATMENT.getValue()%>" />

<script src="${pageContext.request.contextPath}/js/views/idm/case/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/tb/tb_common.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/tb/treatment.js" type="text/javascript"></script>

<div class="toolbar">
    <%-- <a href="javascript:tbCommon.returnSearch('treatment.searchTemp')" id="cancelContact"><b class="fanhui">返回</b></a> --%>
    <a href="javascript:tbCommon.returnSearch('treatment.searchTemp')" ><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
    <c:if test="${type=='1'}">
        <%-- <a href="javascript:tbCommon.tbSubmit('1','${TREATMENT}','treatment.searchTemp','tbFormTreatment')" id="saveContact"><b class="baocun">保存</b></a> --%>
        <a href="javascript:tbCommon.tbSubmit('1','${TREATMENT}','treatment.searchTemp','tbFormTreatment')"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
   	</c:if>
    <c:if test="${type=='2'}">
         <%--<a href="javascript:tbCommon.tbSubmit('2','${TREATMENT}','treatment.searchTemp','tbFormTreatment')" id="editContact"><b class="xiug">修改</b></a>--%>
        <%-- <a href="javascript:tbCommon.tbSubmit('2','${TREATMENT}','treatment.searchTemp','tbFormTreatment')" id="editContact"><b class="baocun">保存</b></a> --%>
        <a href="javascript:tbCommon.tbSubmit('1','${TREATMENT}','treatment.searchTemp','tbFormTreatment')"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
    </c:if>
</div>

<form id="tbFormTreatment">
	<input type="hidden" name="singleId" value="${tbSaveDto.singleId}" id="singleId"/>
	<input type="hidden" name="eventId" value="${T_TREATMENT}" id="eventId"/>
	<input type="hidden" name="idmId" value="${tbSaveDto.idmId}" id="idmId"/>
	<input type="hidden" name="specialStatus" value="${TREATMENT}"/>
	<input type="hidden" name="logoff" value="${tbSaveDto.logoff}"/>
    <input type="hidden" name="generalCondition.idcard" value="${tbSaveDto.generalCondition.idcard}"/>
    <input type="hidden" name="diagnosis.diagnosisType" value="2"/>
    <input type="hidden" id="pageIndex" value="${pageIndex}">
	<div class="postcontent divFixed125" style="top: 190px;">
		<i class="popno">永城市结核病人登记治疗管理卡</i>
		<div class="postdiv">
		    <fieldset class="layui-elem-field">
				<table class="posttable">
					<colgroup>
						<col style="width: 25%" />
						<col style="width: 30%" />
						<col style="width: 17%" />
						<col style="width: 28%" />
					</colgroup>
					<tr>
						<th><label class="required"></label></th>
						<td colspan="3">
							<ehr:dic-town-street-village
									townId="hrtown_addressd" streetId="hrStreet_addressd"
									streetName="generalCondition.titleTown"
									townName="generalCondition.titleCity" streetValue="${tbSaveDto.generalCondition.titleTown}"
									townValue="${tbSaveDto.generalCondition.titleCity}" width="118px;" reg="{'required':true}"/>
						</td>
					</tr>
					<tr>
						<th><label class="required">病例登记号:</label></th>
						<td colspan="3">
                            <input type="text" name="generalCondition.registerNum" value="${tbSaveDto.generalCondition.registerNum}" style="width: 80px;" reg='{"required":"true","maxlength":"8"}'/>
                            <span>前四位请输入年份</span>
                        </td>
					</tr>
					<tr>
						<th><label class="required">姓名:</label></th>
						<td><input type="text" name="generalCondition.name" value="${tbSaveDto.generalCondition.name}" style="width: 100px;" reg='{"required":"true","maxlength":"100"}'/>
                        </td>
						<th><label class="required">职业:</label></th>
						<td>
			            	<%--<ehr:dic-list dicmeta="GBT6565" name="generalCondition.occupation" width="180px;" value="${tbSaveDto.generalCondition.occupation}"--%>
		                                  <%--code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120208,CV020120209,CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120217,CV020120299"--%>
		                                  <%--reg='{"required":"true"}' onchange="toggleOtherSC('generalCondition.occupation','occupationPart','CV020120299');"/>--%>
			            	 <%--<span  id="occupationPart" style="display: none">--%>
		                         <%--<label class="required"></label>--%>
		                         <%--<input type="text" name="generalCondition.occupationOther" value="${tbSaveDto.generalCondition.occupationOther}"--%>
		                                <%--reg='{"required":"true","maxlength":"30"}' placeholder="若选择其他，请描叙" style="width: 200px;"/>--%>
		                     <%--</span>--%>
								<ehr:dic-list dicmeta="GBT6565"  width="180px;" code="0,1/2,3,4,5,6/7/8/9,X,Y,CV00031"  value="${tbSaveDto.generalCondition.occupation}" name="generalCondition.occupation"/>
			            </td>
					</tr>
					<tr>
						<th><label class="required">常住类型:</label></th>
						<td>
		                    <ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005"  reg='{"required":"true"}'
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
						<th>户籍地址:</th>
						<td colspan="3"><div class="${'2' eq tbSaveDto.generalCondition.floatPopulation || '4' eq tbSaveDto.generalCondition.floatPopulation?'hide':'' }" id="hr-address-select">
							<ehr:dic-town-street-village
									villageId="hrvillage_address" townId="hrtown_address" streetId="hrStreet_address"
									villageName="generalCondition.hrGroup" streetName="generalCondition.hrstreet"
									townName="generalCondition.hrtownShip" streetValue="${tbSaveDto.generalCondition.hrstreet}"
									villageValue="${tbSaveDto.generalCondition.hrGroup}" callback="idmCommon.displayHrAddress"
									townValue="${tbSaveDto.generalCondition.hrtownShip}" width="118px;"/>
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
						<th><label class="required">工作单位:</label></th>
						<td colspan="3"><input type="text" id="unitName" name="generalCondition.unitName" value="${tbSaveDto.generalCondition.unitName}" reg='{"required":"true","maxlength":"70"}' style="width: 36%"/></td>
					</tr>
					<tr>
						<th><label class="required">电话:</label></th>
						<td><input type="text" name="generalCondition.phoneNumber" value="${tbSaveDto.generalCondition.phoneNumber}" reg='{"required":"true","regex":"phone","maxlength":20}' style="width: 36%"/></td>
						<th>X线号:</th>
						<td><input type="text" name="labExamine.xNo" value="${tbSaveDto.labExamine.xNo}"reg='{"maxlength":"20"}'/></td>
					</tr>
				</table>
			</fieldset>
			 <fieldset class="layui-elem-field">
				<table class="posttable">
					<colgroup>
						<col style="width: 25%" />
						<col style="width: 75%" />
					</colgroup>
					<tr>
						<th>1、性别:</th>
						<td>
			            	<ehr:dic-radio dicmeta="GBT226112003" name="generalCondition.gender" code="1,2" value="${tbSaveDto.generalCondition.gender}"/>
			            </td>
					</tr>
					<tr>
						<th>2、年龄:</th>
						<td>
							<tag:numberInput id="age" name="generalCondition.age" value="${tbSaveDto.generalCondition.age}" 
	            				maxlength="3" cssClass="width30" style="width: 20%"/>(周岁)
						</td>
					</tr>
					<tr>
						<th>3、病人来源:</th>
						<td colspan="3">
							<ehr:dic-radio dicmeta="IDM00221" name="otherCondition.caseSource"  value="${tbSaveDto.otherCondition.caseSource}"
								onchange="toggleOther('otherCondition.caseSource','caseSourceOther','99')"/>
		                     <span id="caseSourceOther" style="display:none;">
		                     	<input type="text" name="otherCondition.caseSourceOther" value="${tbSaveDto.otherCondition.caseSourceOther}" reg='{"maxlength":"50"}' style="width: 20%;"/>
		                     </span>
						</td>
					</tr>
					<tr>
						<th>4、症状:</th>
					</tr>
                    <tr>
                        <th>咳嗽咳痰:</th>
                        <td>
                            <ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.expectoration" code="1,2"  value="${tbSaveDto.clinicalManifestations.expectoration}"
                                              onchange="toggleOther('clinicalManifestations.expectoration','symptomDuration','1')"/>
		                     <span id="symptomDuration" style="display: none;">
		                     	持续时间:<ehr:dic-radio dicmeta="IDM00246" name="clinicalManifestations.symptomDuration" value="${tbSaveDto.clinicalManifestations.symptomDuration}"/>
		                     </span>
                        </td>
                    </tr>
                    <tr>
                        <th>咯血血痰:</th>
                        <td>
                            <ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.hemoptysis" code="1,2"  value="${tbSaveDto.clinicalManifestations.hemoptysis}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>其他:</th>
                        <td>
                            <ehr:dic-radio dicmeta="PH00002" name="clinicalManifestations.otherSelect" code="1,2"  value="${tbSaveDto.clinicalManifestations.otherSelect}"/>
                        </td>
                    </tr>
					<tr>
						<th>5、结核史:</th>
						<td><ehr:dic-radio dicmeta="PH00002" name="pastHistory.tuberculosisFlg" code="1,2" value="${tbSaveDto.pastHistory.tuberculosisFlg}"/></td>
					</tr>
					<tr>
						<th>6、诊断:</th>
					</tr>
					<tr>
						<th>肺结核:</th>
						<td colspan="3"><ehr:dic-radio name="diagnosis.lastDiagnosis" dicmeta="IDM00237" value="${tbSaveDto.diagnosis.lastDiagnosis }" code="1,2,3"/></td>
					</tr>
					<tr>
						<th>结核性胸膜炎Ⅳ型:</th>
						<td>
							<input type="radio" name="diagnosis.diagnosisAccording" value="1"
								<c:if test="${tbSaveDto.diagnosis.diagnosisAccording == '1'}">checked="checked"</c:if>
							onchange="toggleOther('diagnosis.diagnosisAccording','diagnosisReasonMultiTR','2');toggleOtherCK('diagnosis.diagnosisReasonMulti','diagnosisOtherTR','99')"/>
						</td>
					</tr>
					<tr>
						<th>其他肺外结核Ⅴ型:</th>
						<td colspan="3">
							<input type="radio" name="diagnosis.diagnosisAccording" value="2"
								<c:if test="${tbSaveDto.diagnosis.diagnosisAccording == '2'}">checked="checked"</c:if>
							 onchange="toggleOther('diagnosis.diagnosisAccording','diagnosisReasonMultiTR','2')"/>
		                    <span id="diagnosisReasonMultiTR" style="display: none;">
								<ehr:dic-checkbox name="diagnosis.diagnosisReasonMulti" dicmeta="IDM00238" value="${tbSaveDto.diagnosis.diagnosisReasonMulti}"
								onchange="toggleOtherCK('diagnosis.diagnosisReasonMulti','diagnosisOtherTR','99')"/>
								<span id="diagnosisOtherTR" style="display: none;">
									<input type="text" name="diagnosis.diagnosisOther" value="${tbSaveDto.diagnosis.diagnosisOther }"  reg='{"maxlength":"100"}'
									style="width: 20%"/>
								</span>
							</span>
						</td>
					</tr>
					<tr>
						<th><label class="required">7、初治:</label></th>
						<td><ehr:dic-radio dicmeta="IDM00248" name="otherCondition.thisType" value="${tbSaveDto.otherCondition.thisType }"
								onchange="toggleOther('otherCondition.thisType','thisType1TR','99')" reg='{"required":"true"}'/></td>
					</tr>
					<tr id="thisType1TR" style="display: none;">
						<th><label class="required">8、复治:</label></th>
						<td>
							<ehr:dic-list dicmeta="IDM00241" name="otherCondition.thisType1" value="${tbSaveDto.otherCondition.thisType1}"
								onchange="toggleOtherSC('otherCondition.thisType1','thisTypeOtherTR','99')" reg='{"required":"true"}'/>
							<span id="thisTypeOtherTR" style="${tbSaveDto.otherCondition.thisType1=='99' ? '' : 'display: none;'}">
								<input type="text" name="otherCondition.thisTypeOther" value="${tbSaveDto.otherCondition.thisTypeOther }"
								 style="width: 20%;" reg='{"required":"true","maxlength":"100"}'/>
							</span>
						</td>
					</tr>
					<tr>
						<th>9、复治病人最近治疗情况：&nbsp;&nbsp;1.实施:</th>
						<td><ehr:dic-radio dicmeta="IDM00226" name="otherCondition.cureCondition" value="${tbSaveDto.otherCondition.cureCondition}"/></td>
					</tr>
					<tr>
						<th>2.治疗单位:</th>
						<td><ehr:dic-radio dicmeta="IDM00227" name="otherCondition.cureUnit" value="${tbSaveDto.otherCondition.cureUnit}"/></td>
					</tr>
					<tr>
						<th>10、痰检结果&nbsp;&nbsp;1.登记时查痰:</th>
						<td colspan="3"><ehr:dic-radio dicmeta="IDM00250" name="labExamine.phlegmPcr" value="${tbSaveDto.labExamine.phlegmPcr}"/></td>
					</tr>
					<tr>
						<th>2. 治疗满两个月:</th>
						<td colspan="3"><ehr:dic-radio dicmeta="IDM00250" name="labExamine.sputum_2" value="${tbSaveDto.labExamine.sputum_2}"/></td>
					</tr>
					<tr>
						<th>3. 治疗满三个月:</th>
						<td colspan="3"><ehr:dic-radio dicmeta="IDM00250" name="labExamine.sputum_3" value="${tbSaveDto.labExamine.sputum_3}"/></td>
					</tr>
					<tr>
						<th>11、肺结核空洞:</th>
						<td><ehr:dic-radio dicmeta="PH00024" name="labExamine.cavity" value="${tbSaveDto.labExamine.cavity}"/></td>
					</tr>
					<tr>
						<th>12、合并症:</th>
						<td>
							<ehr:dic-checkbox dicmeta="IDM00239" name="diagnosis.complicationMulti" value="${tbSaveDto.diagnosis.complicationMulti }"
									onchange="toggleOtherCK('diagnosis.complicationMulti','complicationOtherTR','99')" code="1,2,3,4,99"/>
								<span id="complicationOtherTR" style="display: none;">
									<input type="text" name="diagnosis.complicationOther" value="${tbSaveDto.diagnosis.complicationOther }"
									 style="width: 20%" reg='{"maxlength":100}'/>
								</span>
						</td>
					</tr>
					<tr>
						<th><label class="required">13、化疗方案:</label> </th>
						<td colspan="3">
							<ehr:dic-radio dicmeta="IDM00222"  name="otherCondition.chemotherapy"  value="${tbSaveDto.otherCondition.chemotherapy}"
								 reg='{"required":"true"}'/><%--onchange="toggleOther('otherCondition.chemotherapy','chemotherapyOther','99');toggleOther('otherCondition.chemotherapy','chemotherapy1','1');toggleOther('otherCondition.chemotherapy','chemotherapy2','2');toggleOther('otherCondition.chemotherapy','chemotherapy3','3')"--%>
							<%--<span id="chemotherapyOther" style="${tbSaveDto.otherCondition.chemotherapy=='99' ? '' : 'display: none;'}">
								<input type="text" name="otherCondition.chemotherapyOther" value="${tbSaveDto.otherCondition.chemotherapyOther}"
									 style="width: 20%" reg='{"required":"true","maxlength":"50"}'/>
							</span>
                            <span id="chemotherapy1" style="${tbSaveDto.otherCondition.chemotherapy1=='1' ? '' : 'display: none;'}">
                                <br/>
								<ehr:dic-radio dicmeta="IDM00330"  name="otherCondition.chemotherapy1"  value="${tbSaveDto.otherCondition.chemotherapy1}" reg='{"required":"true"}'/>
							</span>
                            <span id="chemotherapy2" style="${tbSaveDto.otherCondition.chemotherapy2=='2' ? '' : 'display: none;'}">
                                <br/>
                                <ehr:dic-radio dicmeta="IDM00331"  name="otherCondition.chemotherapy2"  value="${tbSaveDto.otherCondition.chemotherapy2}" reg='{"required":"true"}'/>
							</span>
                            <span id="chemotherapy3" style="${tbSaveDto.otherCondition.chemotherapy3=='3' ? '' : 'display: none;'}">
                                <br/>
                                <ehr:dic-radio dicmeta="IDM00332"  name="otherCondition.chemotherapy3"  value="${tbSaveDto.otherCondition.chemotherapy3}" reg='{"required":"true"}'/>
							</span>--%>
						</td>
					</tr>
					<tr>
						<th>14、药费来源:</th>
						<td>
							<ehr:dic-radio dicmeta="IDM00220" code="3,1,4" name="otherCondition.thisFeesType" value="${tbSaveDto.otherCondition.thisFeesType}"
							onchange="toggleOther('otherCondition.thisFeesType','abatement','4')"/>
							<span id="abatement" style="${tbSaveDto.otherCondition.thisFeesType=='4' ? '' : 'display: none;'}">
								<input type="text" name="otherCondition.abatement" value="${tbSaveDto.otherCondition.abatement}" style="width: 20%" reg='{"maxlength":20}'/>%
							</span>
						</td>
					</tr>
					<tr>
						<th>15、管理方式:</th>
						<td><ehr:dic-radio dicmeta="IDM00243" name="otherCondition.manageType" value="${tbSaveDto.otherCondition.manageType}"/> </td>
					</tr>
					<tr>
						<th>16、转归:</th>
						<td colspan="3"><ehr:dic-radio dicmeta="IDM00244" uninclude="9,10,13,99" name="otherCondition.outcomeCode" value="${tbSaveDto.otherCondition.outcomeCode}"/> </td>
					</tr>
					<tr>
						<th>17、登记日期:</th>
						<td>
							<%-- <tag:dateInput id="registerDt" name="diagnosis.registerDt" date="${tbSaveDto.diagnosis.registerDt}" nullToToday="false"
							pattern="yyyy/MM/dd" onlypast="true" reg='{"compare":["confirmationDate","le","登记日期不能晚于确诊日期"]}' style="width: 20%" /> --%>
							
							<input type="text" reg='{"compare":["confirmationDate","le","登记日期不能晚于确诊日期"]}'  class="layui-input x-admin-content-sm-date" name="diagnosis.registerDt" id="registerDt" value="<fmt:formatDate value='${tbSaveDto.diagnosis.registerDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 20%;" />
						</td>
					</tr>
					<tr>
						<th>18、确诊日期:</th>
						<td>
							<%-- <tag:dateInput id="confirmationDate" name="attackCondition.confirmationDate" date="${tbSaveDto.attackCondition.confirmationDate}" nullToToday="false"
							 pattern="yyyy/MM/dd" onlypast="true" reg='{"compare":["registerDt","ge","确诊日期不能早于登记日期"]}' style="width: 20%"/> --%>
							 
							<input type="text" reg='{"compare":["registerDt","ge","确诊日期不能早于登记日期"]}' class="layui-input x-admin-content-sm-date" name="attackCondition.confirmationDate" id="confirmationDate" value="<fmt:formatDate value='${tbSaveDto.attackCondition.confirmationDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 20%;" /> 
						</td>
					</tr>
					<tr>
						<th><label class="required">19、始治日期:</label></th>
						<td>
							<c:choose>
								<c:when test="${tbSaveDto.otherCondition.thisDt == null}">
									<%-- <tag:dateInput id="thisDt" name="otherCondition.thisDt" date="${tbSaveDto.otherCondition.thisDt}" nullToToday="false"
										pattern="yyyy/MM/dd" onlypast="true" reg='{"required":"true","compare":["stopReasonDt","le","始治日期不能晚于停止治疗日期"]}' style="width: 20%"/> --%>
										
										<input type="text" reg='{"required":"true","compare":["stopReasonDt","le","始治日期不能晚于停止治疗日期"]}' class="layui-input x-admin-content-sm-date" name="otherCondition.thisDt" id="thisDt" value="<fmt:formatDate value='${tbSaveDto.otherCondition.thisDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 20%;" />
								</c:when>
								<c:otherwise>
									<%-- <tag:dateInput  name="otherCondition.thisDt" date="${tbSaveDto.otherCondition.thisDt}" nullToToday="false"
												   pattern="yyyy/MM/dd" onlypast="true"  style="width: 20%" id="thisDt" reg='{"required":"true","compare":["stopReasonDt","le","始治日期不能晚于停止治疗日期"]}'/> --%>
									
									<input type="text" reg='{"required":"true","compare":["stopReasonDt","le","始治日期不能晚于停止治疗日期"]}' class="layui-input x-admin-content-sm-date" name="otherCondition.thisDt" id="thisDt" value="<fmt:formatDate value='${tbSaveDto.otherCondition.thisDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 20%;" />
									<%--<fmt:formatDate value="${tbSaveDto.otherCondition.thisDt}" pattern="yyyy/MM/dd"/>--%>
									
									<input type="text"  class="layui-input x-admin-content-sm-date" name="otherCondition.thisDt" id="otherConditionThisDtId" value="<fmt:formatDate value='${tbSaveDto.otherCondition.thisDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;display:none;" />
									<%-- <tag:dateInput id="birthday" name="otherCondition.thisDt" date="${tbSaveDto.otherCondition.thisDt}" style="display:none;"/> --%>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th>20、停止治疗日期:</th>
						<td>
							<%-- <tag:dateInput id="stopReasonDt" name="otherCondition.stopReasonDt" nullToToday="false" onlypast="true" pattern="yyyy/MM/dd"
							 	date="${tbSaveDto.otherCondition.stopReasonDt }" reg='{"compare":["thisDt","ge","停止治疗日期不能早于始治日期"]}' style="width: 20%"/> --%>
							 	
							 	<input type="text" reg='{"compare":["thisDt","ge","停止治疗日期不能早于始治日期"]}' class="layui-input x-admin-content-sm-date" name="otherCondition.stopReasonDt" id="stopReasonDt" value="<fmt:formatDate value='${tbSaveDto.otherCondition.stopReasonDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 20%;" />
						</td>
					</tr>
				</table>
			</fieldset>
			<fieldset class="layui-elem-field">
				<table class="posttable">
					<colgroup>
						<col style="width: 15%" />
						<col style="width: 15%" />
						<col style="width: 15%" />
						<col style="width: 15%" />
						<col style="width: 15%" />
						<col style="width: 15%" />
					</colgroup>
					<tr>
						<th>填卡单位:</th>
						<td><ehr:org code="${tbSaveDto.caseInformation.modifySurveyOrg}"/>
							<input type="hidden" name="caseInformation.modifySurveyOrg" value="${tbSaveDto.caseInformation.modifySurveyOrg}"/>
						</td>
						<th>填卡人:</th>
						<td><ehr:user userCode="${tbSaveDto.caseInformation.modifyRespondents}"/>
							<input type="hidden" name="caseInformation.modifyRespondents" value="${tbSaveDto.caseInformation.modifyRespondents}"/>
						</td>
						<th>填卡日期:</th>
						<td><fmt:formatDate value="${tbSaveDto.caseInformation.modifySurveyDate}" pattern="yyyy/MM/dd"/>
							<%-- <tag:dateInput id="birthday" name="caseInformation.modifySurveyDate" date="${tbSaveDto.caseInformation.modifySurveyDate}" style="display:none;"/> --%>
							<input type="text"  class="layui-input x-admin-content-sm-date" name="caseInformation.modifySurveyDate" id="caseInformationModifySurveyDateId" value="<fmt:formatDate value='${tbSaveDto.caseInformation.modifySurveyDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;display:none;" />
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
      elem: '#registerDt' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
   	, trigger: 'click'
    });
    
    laydate.render({
        elem: '#confirmationDate' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	  , trigger: 'click'
      });
    
    laydate.render({
        elem: '#thisDt' 
     	    ,format: 'yyyy/MM/dd'
     	    ,max:0
     	  	,trigger: 'click'
			,done: function(value, date, endDate){
				if(!$.isEmpty(value)){
					$("#thisDt").removeClass('lose');
				}
			}
      });
    
    laydate.render({
        elem: '#otherConditionThisDtId' 
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
        elem: '#caseInformationModifySurveyDateId' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	  , trigger: 'click'
      });
    
  });
</script>
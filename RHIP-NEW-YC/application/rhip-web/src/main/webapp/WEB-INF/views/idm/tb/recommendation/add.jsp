<%@ page language="java" pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ page import="com.founder.rhip.idm.common.SpecialEvents" %>
<%@ page import="com.founder.rhip.idm.common.TbStatus" %>
<c:set var="T_RECOMMENDATION" value="<%=SpecialEvents.T_RECOMMENDATION.getValue()%>"/>
<c:set var="RECOMMENDATION" value="<%=TbStatus.RECOMMENDATION.getValue()%>" />
<script src="${pageContext.request.contextPath}/js/views/idm/tb/tb_common.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/tb/recommendation.js" type="text/javascript"></script>

<div class="toolbar">
    <%-- <a href="javascript:tbCommon.returnSearch('recommendation.searchTemp')" id="cancelContact"><b class="fanhui">返回</b></a> --%>
    <a href="javascript:tbCommon.returnSearch('recommendation.searchTemp')" ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe65c;</i>返回</button></a>
    <c:if test="${type=='1'}">
        <%-- <a href="javascript:tbCommon.tbSubmit('1','${RECOMMENDATION}','recommendation.searchTemp','tbFormRecommendation')" id="saveContact"><b class="baocun">保存</b></a> --%>
        <a href="javascript:tbCommon.tbSubmit('1','${RECOMMENDATION}','recommendation.searchTemp','tbFormRecommendation')" ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
   	</c:if>
    <c:if test="${type=='2'}">
         <%--<a href="javascript:tbCommon.tbSubmit('2','${RECOMMENDATION}','recommendation.searchTemp','tbFormRecommendation')" id="editContact"><b class="xiug">修改</b></a>--%>
        <%-- <a href="javascript:tbCommon.tbSubmit('2','${RECOMMENDATION}','recommendation.searchTemp','tbFormRecommendation')" id="editContact"><b class="baocun">保存</b></a> --%>
        <a href="javascript:tbCommon.tbSubmit('2','${RECOMMENDATION}','recommendation.searchTemp','tbFormRecommendation')" ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
    </c:if>
</div>
<form id="tbFormRecommendation">
	<input type="hidden" name="singleId" value="${tbSaveDto.singleId}" id="singleId"/>
	<input type="hidden" name="eventId" value="${T_RECOMMENDATION}" id="eventId"/>
	<input type="hidden" name="idmId" value="${tbSaveDto.idmId}" id="idmId"/>
	<input type="hidden" name="specialStatus" value="${RECOMMENDATION}"/>
	<input type="hidden" name="logoff" value="${tbSaveDto.logoff}"/>
	<input type="hidden" id="pageIndex" value="${pageIndex}">
    <div class="postcontent">
		<i class="popno">推荐单</i>
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
                    <tbody>
                    <tr>
                        <th><label class="required">姓名:</label></th>
                        <td><input type="text" id="name" name="generalCondition.name" value="${tbSaveDto.generalCondition.name}" reg='{"required":"true","maxlength":"100"}'></td>
                        <th><label class="required">身份证号:</label></th>
                        <td><input type="text" id="idCard" name="generalCondition.idcard" value="${tbSaveDto.generalCondition.idcard}"
                                   placeholder="输入身份证获取个人信息" reg='{"idCard":"true","required":"true"}'/>
                            <input type="hidden" name="generalCondition.age" id="age" value="${tbSaveDto.generalCondition.age}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>性别:</th>
                        <td>
                            <ehr:dic-radio name="generalCondition.gender" dicmeta="FS10006" value="${tbSaveDto.generalCondition.gender}"/>
                        </td>
                        <th>民族:</th>
                        <td>
			            	<%--<ehr:dic-list id="nation" name="generalCondition.nation" dicmeta="GBT3304" value="${tbSaveDto.generalCondition.nation eq null ? '01' : tbSaveDto.generalCondition.nation}"--%>
			            	     <%--width="50%;"/>--%>
                            <label><input type="radio" reg='{"required":true}' onclick="util.clickHideText(this,'cdmOtherNationDesc')" name="generalCondition.nation" ${tbSaveDto.generalCondition.nation eq"01" ?"checked":""} value="01" /> 汉族</label>
                            <label><input type="radio" reg='{"required":true}' onclick="util.clickShowText(this,'cdmOtherNationDesc')" name="generalCondition.nation" ${(tbSaveDto.generalCondition.nation ne "1" && not empty tbSaveDto.generalCondition.nation && tbSaveDto.generalCondition.nation ne"01") ?"checked":""} value="99" /> 少数民族</label>
                            <input type="text" id="cdmOtherNationDesc" ${tbSaveDto.generalCondition.nation ne "1" && not empty tbSaveDto.generalCondition.nation && tbSaveDto.generalCondition.nation ne"01"? "" : "class=\"hidediv\""} name="generalCondition.nationOther" value="${tbSaveDto.generalCondition.nationOther}" reg='{"required":"true"}' style="width: 70px;" />
                        </td>
                    </tr>
                    <tr>
                        <th>出生日期:</th>
                        <td>
                            <input type="text" class="layui-input x-admin-content-sm-date" name="generalCondition.birthday" id="birthday" value="<fmt:formatDate value='${tbSaveDto.generalCondition.birthday}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
                        </td>
                        <th><label class="required">联系电话:</label></th>
                        <td>
                        	<input type="text" id="phoneNumberId" name="generalCondition.phoneNumber" value="${tbSaveDto.generalCondition.phoneNumber}" 
                        		reg='{"required":"true","regex":"phone","maxlength":20}'/>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">职业:</label></th>
                        <td>
			            	<%--<ehr:dic-list id="occupation" dicmeta="GBT6565" name="generalCondition.occupation" width="100px;" value="${tbSaveDto.generalCondition.occupation}"--%>
		                                  <%--code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120208,CV020120209,CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120217,CV020120299"--%>
		                                  <%--reg='{"required":"true"}' onchange="toggleOtherSC('generalCondition.occupation','spanOccupationOther','CV020120299')"/>--%>
			            	 <%--<span  id="spanOccupationOther" style="display: none">--%>
		                         <%--&lt;%&ndash;<label class="required"></label>&ndash;%&gt;--%>
		                         <%--<input type="text" name="generalCondition.occupationOther" value="${tbSaveDto.generalCondition.occupationOther}"--%>
		                                <%--reg='{"required":"true","maxlength":"30"}' placeholder="若选择其他，请描述" style="width: 130px;"/>--%>
		                     <%--</span>--%>
                                <ehr:dic-list dicmeta="GBT6565"  width="180px;" code="0,1/2,3,4,5,6/7/8/9,X,Y,CV00031"  value="${tbSaveDto.generalCondition.occupation}" name="generalCondition.occupation"/>
			            </td>
                        <th>工作单位</th>
                        <td><input type="text" id="unitNameId" name="generalCondition.unitName" value="${tbSaveDto.generalCondition.unitName}" reg='{"maxlength":"70"}'/></td>
                    </tr>
                    <tr>
						<th><label class="required">常住类型:</label></th>
						<td>
		                    <ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005"
		                                  value='${tbSaveDto.generalCondition.floatPopulation}' onchange="idmCommon.toggerAddress()" reg='{"required":"true"}' />
		                </td>
					</tr>
                    <tr>
                        <th><label class="required">现住址:</label></th>
                        <td colspan="3">
                            <ehr:dic-town-street-village villageId="pavillage_address" streetId="pastreet_address" callback="idmCommon.displayPaAddress"
                                                         townId="patown_address" villageName="generalCondition.paGroup" streetName="generalCondition.pastreet"
                                                         townName="generalCondition.patownShip" villageValue="${tbSaveDto.generalCondition.paGroup}" streetValue="${tbSaveDto.generalCondition.pastreet}"
                                                         townValue="${tbSaveDto.generalCondition.patownShip}" width="118px;" reg="{'required':true}"/>
	                            <br><label id="tempPaValue">
	                                <ehr:dic code="${tbSaveDto.generalCondition.patownShip}" dicmeta="FS990001"/>
                                    <ehr:dic code="${tbSaveDto.generalCondition.pastreet}" dicmeta="FS990001"/>
                                    <ehr:dic code="${tbSaveDto.generalCondition.paGroup}" dicmeta="FS990001"/>
	                            </label>
	                            <input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${tbSaveDto.generalCondition.pahouseNumber}"
	                                   reg='{"required":"true","maxlength":"50"}' style="width:300px;"/>(详细地址)
			            </td>
                    </tr>
                    <tr>
                        <th><label class="required">户籍地址:</label></th>
                        <td colspan="3"><div class="${'2' eq tbSaveDto.generalCondition.floatPopulation?'hide':'' }" id="hr-address-select">
                            <ehr:dic-town-street-village
                                    villageId="hrvillage_address" townId="hrtown_address" streetId="hrStreet_address"
                                    villageName="generalCondition.hrGroup" streetName="generalCondition.hrstreet"
                                    townName="generalCondition.hrtownShip" streetValue="${tbSaveDto.generalCondition.hrstreet}"
                                    villageValue="${tbSaveDto.generalCondition.hrGroup}" callback="idmCommon.displayHrAddress"
                                    townValue="${tbSaveDto.generalCondition.hrtownShip}" width="118px;" reg="{'dependOn':'tbSaveDto.generalCondition.householdType','dependValue':'1','required':true}"/>
                            </div><label id="tempHrValue">
                                <ehr:dic code="${tbSaveDto.generalCondition.hrtownShip}" dicmeta="FS990001"/>
                                <ehr:dic code="${tbSaveDto.generalCondition.hrstreet}" dicmeta="FS990001"/>
                                <ehr:dic code="${tbSaveDto.generalCondition.hrGroup}" dicmeta="FS990001"/>
                            </label>
                            <input type="text" name="generalCondition.hrhouseNumber" id="hrhouseNumber" value="${tbSaveDto.generalCondition.hrhouseNumber}"
                                  reg='{"required":"true","maxlength":"50"}' style="width:300px;"/>(详细地址)
                        </td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
            <fieldset>
                <legend>推荐症状</legend>
                <table class="posttable">
                    <colgroup>
						<col style="width: 20%" />
						<col style="width: 30%" />
						<col style="width: 20%" />
						<col style="width: 30%" />
					</colgroup>
                    <tbody>
                    <tr>
                        <th>症状</th>
                    </tr>
                    <tr>
                        <th><label class="required">咳嗽:</label></th>
                        <td><ehr:dic-radio name="clinicalManifestations.cough" dicmeta="PH00001" code="1,2" value="${tbSaveDto.clinicalManifestations.cough}" reg='{"required":"true"}' /></td>
                        <th><label class="required">咳痰:</label></th>
                        <td><ehr:dic-radio name="clinicalManifestations.expectoration" dicmeta="PH00001" code="1,2" value="${tbSaveDto.clinicalManifestations.expectoration}" reg='{"required":"true"}'/></td>
                    </tr>
                    <tr>
                        <th><label class="required">咯血:</label></th>
                        <td><ehr:dic-radio name="clinicalManifestations.hemoptysis" dicmeta="PH00001" code="1,2" value="${tbSaveDto.clinicalManifestations.hemoptysis}" reg='{"required":"true"}'/></td>
                        <th><label class="required">胸痛:</label></th>
                        <td><ehr:dic-radio name="clinicalManifestations.chestPain" dicmeta="PH00001" code="1,2" value="${tbSaveDto.clinicalManifestations.chestPain}" reg='{"required":"true"}'/></td>
                    </tr>
                    <tr>
                        <th><label class="required">发热:</label></th>
                        <td><ehr:dic-radio name="clinicalManifestations.fever" dicmeta="PH00001" code="1,2" value="${tbSaveDto.clinicalManifestations.fever}" reg='{"required":"true"}'/></td>
                        <th><label class="required">乏力:</label></th>
                        <td><ehr:dic-radio dicmeta="PH00001" name="clinicalManifestations.feeble" code="1,2" value="${tbSaveDto.clinicalManifestations.feeble}" reg='{"required":"true"}'/><br/></td>
                    </tr>
                    <tr>
                        <th><label class="required">食欲减退:</label></th>
                        <td><ehr:dic-radio dicmeta="PH00001" name="clinicalManifestations.poorAppetite" code="1,2" value="${tbSaveDto.clinicalManifestations.poorAppetite}" reg='{"required":"true"}'/><br/></td>
                        <th><label class="required">盗汗:</label></th>
                        <td><ehr:dic-radio name="clinicalManifestations.nightSweat" dicmeta="PH00001" code="1,2" value="${tbSaveDto.clinicalManifestations.nightSweat}" reg='{"required":"true"}'/></td>
                    </tr>
                    <tr>
                        <th><label class="required">其他:</label></th>
                        <td>
							<ehr:dic-radio dicmeta="PH00001" name="clinicalManifestations.otherSelect" code="1,2"
			   					value="${tbSaveDto.clinicalManifestations.otherSelect}" reg='{"required":"true"}'
			   					onchange="toggleOther('clinicalManifestations.otherSelect','otherSpan',1)"/>
			   				<span id="otherSpan" style="${tbSaveDto.clinicalManifestations.otherSelect=='1' ? '' : 'display: none;'}">
							   	  <input type="text" name="clinicalManifestations.other" value="${tbSaveDto.clinicalManifestations.other}" reg='{"required":"true","maxlength":"500"}' style="width: 36%"/>
							   </span> 
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">持续时间:</label></th>
                        <td><ehr:dic-radio dicmeta="IDM00211" name="clinicalManifestations.symptomDuration" value="${tbSaveDto.clinicalManifestations.symptomDuration}" reg='{"required":"true"}'/></td>
                        <th><label class="required">结核病史:</label></th>
                        <td><ehr:dic-radio dicmeta="PH00002" name="pastHistory.tuberculosisFlg" code="1,2" value="${tbSaveDto.pastHistory.tuberculosisFlg}" reg='{"required":"true"}'/></td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
            <fieldset>
               <legend>单位信息</legend>
	            <table class="posttable">
	                <colgroup>
						<col style="width: 20%" />
						<col style="width: 30%" />
						<col style="width: 20%" />
						<col style="width: 30%" />
					</colgroup>
	                <tbody>
	                <tr>
	                    <th><label class="required">复查单位:</label></th>
	                    <td> <ehr:org-type-list name="caseInformation.reviewUnit" value="${tbSaveDto.caseInformation.reviewUnit==null || '' ? currentLoginInfo.organization.parentCode : tbSaveDto.caseInformation.reviewUnit}" reg='{"required":"true"}' width="50%;" code="420805016,${currentLoginInfo.organization.parentCode}" /></td>
	                    <th>推荐时间:</th>
	                    <td><fmt:formatDate value="${tbSaveDto.caseInformation.modifySurveyDate}" pattern="yyyy/MM/dd"/>
	                    	<tag:dateInput id="birthday" name="caseInformation.modifySurveyDate" date="${tbSaveDto.caseInformation.modifySurveyDate}" style="display:none;"/>
	                    	<tag:dateInput id="birthday" name="caseInformation.transferTreatmentDt" date="${tbSaveDto.caseInformation.modifySurveyDate}" style="display:none;"/>
	                    </td>
	                </tr>
	                <tr>
	                    <th>推荐单位:</th>
	                    <td>
	                    	<ehr:org code="${tbSaveDto.caseInformation.modifySurveyOrg}"/>
	                    	<input type="hidden" name="caseInformation.modifySurveyOrg" value="${tbSaveDto.caseInformation.modifySurveyOrg}"/>
	                    	<input type="hidden" name="caseInformation.transferTreatmentUnit" value="${tbSaveDto.caseInformation.modifySurveyOrg}"/>
	                    </td>
	                    <th>推荐人:</th>
	                    <td>
	                    	<ehr:user userCode="${tbSaveDto.caseInformation.modifyRespondents}"/>
	                    	<input type="hidden" name="caseInformation.modifyRespondents" value="${tbSaveDto.caseInformation.modifyRespondents}"/>
	                    	<input type="hidden" name="caseInformation.transferTreatmentDoctor" value="${tbSaveDto.caseInformation.modifyRespondents}"/>
	                    </td>
	                </tr>
	                </tbody>
	            </table>
	         </fieldset>
        </div>
    </div>
 </form>
  <script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#birthday' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
    });

  });
</script>
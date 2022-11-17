<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<script src="${pageContext.request.contextPath}/js/views/vaccine/hospital/add_rabies.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/vaccine/hospital/weightdose.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/card/readCard.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/vaccine/hospital/vaccine_common.js" type="text/javascript"></script>

<div class="toolbar">
    <!-- 	<a href="javascript:void(0)" id="healthEducationActiveBackButton"><b class="fanhui">返回</b></a> -->
    <!-- <a href="javascript:void(0)"
       id="healthEducationActiveSaveButton"
   ><b class="baocun">保存</b></a> -->
    <a href="javascript:void(0)" id="rabiesBack"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon"></i>返回</button></a>
    <a href="javascript:void(0)"
       id="rabiesSave">
        <button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button>
    </a>
</div>
<form method="post" id="vaccine_rabies_save">

<!-- 更新时用到 -->
<input type="hidden" name="ehrId" id="ehrId" value="${ehrId}"/>
<input type="hidden" name="VaccinationDetailsDTO.vaccineType" id="vaccineType" value="1"/>
<input type="hidden" id="personId" value="${vaccinationMgmt.personId}"/>
<input type="hidden" id="currentDate" value="${currentDate}">

<%--疫苗注射提示类型--%>
<input type="hidden" id="vaccinaType" value="${vaccinationEvent.flag}"/>
<%--患者身份证号码--%>
<input type="hidden" id="originalIdcard" value="${vaccinationMgmt.idCard}"/>
<%--狂犬疫苗接种类型 --%>
<input type="hidden" id="rabiesType" name="VaccinationDetailsDTO.rabiesType" value="${rabiesType}"/>
<!-- 患者基本情况 -->
<div class="postcontent contentfixed32" style="top: 65px;">
	<div style="text-align: center; font-size: 16px; font-weight: bold;">
		永城市狂犬病暴露预防处置记录卡
	</div>
	<label id="check-card-message" style="color: red"> ${checkMessage}</label>
	<div class="postdiv">
	<fieldset class="postcontent layui-elem-field">
	<legend>一般情况</legend>
	<table style="width:99%" class="posttable">
        <colgroup >
           		<col width="25%" />
                <col width="31%" />
                <col width="19%" />
                <col width="25%" />
        <colgroup>
		<tbody>
			<tr>
				<th><label >身份证号：</label></th>
				<td> 
					<input type="text" id="idCardTxt" name="VaccinationDetailsDTO.vaccinationMgmt.idCard" placeholder="输入身份证获取个人信息！"
                           reg='{"maxlength":"18","idCard":true}'  value="${vaccinationMgmt.idCard}" />
                    <%--<a class="readCard" id="button_read" title="请将市民卡或身份证放置读卡器上,点击这里" ><img src="${pageContext.request.contextPath}/images/btn/readcard.ico" >读卡</a>--%>
				</td>
				<th><label class="required">姓名：</label></th>
				<td>
					<input type="text" id="nameTxt" name="VaccinationDetailsDTO.vaccinationMgmt.name" reg='{"maxlength":"16" ,"required":"true"}'
						value="${vaccinationMgmt.name }"/>
				</td>
			</tr>
			<tr>
				<th><label class="required">性别：</label></th>
				<td><ehr:dic-list id="genderTxt" dicmeta="GBT226112003" name="VaccinationDetailsDTO.vaccinationMgmt.gender"
						reg='{"required":"true"}'
						value="${vaccinationMgmt.gender}" width="75%" />
				</td>
				<th><label class="required">年龄：</label></th>
				<td><input type="text" id="ageTxt" name="VaccinationDetailsDTO.vaccinationMgmt.age" reg='{"regex":"digits","required":"true"}'
						value="${vaccinationMgmt.age}" maxlength="3"/>&nbsp;岁
				</td>
			</tr>
			<tr>
				<th><label class="required">联系电话：</label></th>
				<td>
					<input type="text" id="phoneNumberTxt" name="VaccinationDetailsDTO.vaccinationMgmt.phoneNumber"
						 value="${vaccinationMgmt.phoneNumber }" maxlength="18"/>
				</td>
				<th><label>体重：</label></th>
				<td>
					<input type="text" id="weight" name="VaccinationDetailsDTO.vaccinationMgmt.weight"
						 value="${vaccinationMgmt.weight }" reg='{"regex":"digits","maxlength":"4"}' />&nbsp;公斤
				</td>
            <tr>
        <%--     <tr id="guardianNameHide" style="display: none;">
				<th><label class="required" >监护人姓名（未成年人需填写）：</label></th>
				<td>
					<input type="text" id="guardianNameText" name="VaccinationDetailsDTO.vaccinationMgmt.guardianNameText"
						reg='{"maxlength":"16" ,"required":"true"}' value="${vaccinationMgmt.guardianNameText}" />
				</td>
            </tr>
             <tr id="guardianPhoneHide" style="display: none;">
				<th><label class="required"  >监护人联系电话（未成年人需填写）：</label></th>
				<td>
					<input type="text" id="guardianPhoneText" name="VaccinationDetailsDTO.vaccinationMgmt.guardianPhoneText"
						reg='{"maxlength":"18","required":"true"}'  value="${vaccinationMgmt.guardianPhoneText}" />
				</td>
			</tr> --%>
			 <tr id="guardianNameShow" >
				<th><label>监护人姓名（未成年人需填写）：</label></th>
				<td>
					<input type="text" id="guardianNameText" name="VaccinationDetailsDTO.vaccinationMgmt.guardianNameText"  maxlength="16" value="${vaccinationMgmt.guardianNameText}" />
				</td>
            </tr>
             <tr id="guardianPhoneShow">
				<th><label>监护人联系电话（未成年人需填写）：</label></th>
				<td>
					<input type="text" id="guardianPhoneText" name="VaccinationDetailsDTO.vaccinationMgmt.guardianPhoneText"  maxlength="18" value="${vaccinationMgmt.guardianPhoneText}" />
				</td>
			</tr>
			<tr>
	    		 <th><label class="required">职业：</label></th>
	       		 <td colspan="3"><ehr:dic-radio reg='{"required":"true"}' dicmeta="GBT6565" value="${vaccinationMgmt.occupation}" name="VaccinationDetailsDTO.vaccinationMgmt.occupation" code="CV020120211,CV020120209,CV020120203,CV020120202,CV020120214,CV020120299"/></td>
			</tr>
			<tr>
				<th>居住地址：</th>
				<td colspan="3">
                    <ehr:dic-town-street-village townId="town_address" streetId="village_address"
                                                 townName="VaccinationDetailsDTO.vaccinationMgmt.patownShip" streetName="VaccinationDetailsDTO.vaccinationMgmt.pastreet"
                                                 townValue="${vaccinationMgmt.patownShip}" streetValue="${vaccinationMgmt.pastreet}"
                                                 width="120px;"
                    />
					<input type="text" id="text_pahouseNumber" name="VaccinationDetailsDTO.vaccinationMgmt.pahouseNumber"
                           reg='{"maxlength":"50"}' value="${vaccinationMgmt.pahouseNumber}" style="width: 200px;"/>
				</td>
			</tr>
		</tbody>
	</table>
	</fieldset>
	</div>
	<div class="postdiv">
		<fieldset class="postcontent layui-elem-field">
		<legend>狂犬病疫苗接种史</legend>
		<table style="width:99%" class="posttable">
        <colgroup >
           		<col width="25%" />
                <col width="31%" />
                <col width="19%" />
                <col width="25%" />
        <colgroup>
		<tbody>
			<tr>
            	<th>上次伤人日期：</th>
                <td>
                    <%--<tag:dateInput maxId="hitDate" id="preOpsDateTxt" name="VaccinationDetailsDTO.traumaHistory.preOpsDate"
                                   date="${traumaHistory.preOpsDate}" pattern="yyyy/MM/dd" onlypast="true" />--%>
                    <input type="text" reg='{"required":true}' class="layui-input x-admin-content-sm-date" name="VaccinationDetailsDTO.traumaHistory.preOpsDate" id="preOpsDateTxt" value="<fmt:formatDate value='${traumaHistory.preOpsDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 177px;" />
                </td>
                <th>是否流动人口：</th>
                <td>
                    <ehr:dic-radio name="VaccinationDetailsDTO.vaccinationMgmt.householdType" dicmeta="PH00001"
                    	value="${vaccinationMgmt.householdType}" code="1,2" onchange="mainPageH.toggerAddress()"/>
                </td>
            </tr>	
			<tr>
                <th >既往是否接种过狂犬病疫苗：</th>
                <td >
                <ehr:dic-radio name="VaccinationDetailsDTO.isInjected" dicmeta="PH00001" code="1,2" value="${vaccinationEvent.isInjected}"  />
                </td>
                <th><label class="required">是否全程接种：</label></th>
                <td>
                <ehr:dic-radio name="VaccinationDetailsDTO.completeFlag"  reg='{"required":"true"}' dicmeta="FS10186" code="0,1" value="${vaccinationEvent.completeFlag}"  />
                </td>
            </tr>
            <tr>
             <th class="isInjected" >最近一次接种时间：</th>
                <td class="isInjected">
                	<%--<tag:dateInput id="lastInjectedDate" name="VaccinationDetailsDTO.lastInjectedDate"
                                   date="${vaccinationEvent.lastInjectedDate}" onlypast="true" />--%>
                    <input type="text"  class="layui-input x-admin-content-sm-date" name="VaccinationDetailsDTO.lastInjectedDate" id="lastInjectedDate" value="<fmt:formatDate value='${vaccinationEvent.lastInjectedDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 177px;" />
                </td>
            </tr>
             <tr class="isInjected">
                <th >接种针次数：</th>
                <td >
                <input type="text" id="vaccinationCount" name="VaccinationDetailsDTO.count" reg='{"regex":"digits"}'
						value="${vaccinationEvent.count}" maxlength="2"/>
                </td>
                <th >疫苗品牌：</th>
                <td >
                	<ehr:dic-list id="factory" name="VaccinationDetailsDTO.factory" dicmeta="FS990003" value="${vaccinationEvent.factory}" width="150px;"/>
                </td>
            </tr>
            <tr class="isInjected">
                <th >一年内是否全程接种过</th>
                <td >
             		<ehr:dic-radio name="VaccinationDetailsDTO.isOneYearInjected" dicmeta="PH00001" code="1,2" value="${vaccinationEvent.isOneYearInjected}"  />
                </td>
                <th >一年前三年内是否全程接种过</th>
                <td >
                	<ehr:dic-radio name="VaccinationDetailsDTO.isThreeYearInjected" dicmeta="PH00001" code="1,2" value="${vaccinationEvent.isThreeYearInjected}"  />
                </td>
            </tr>
            <tr class="isInjected">
                <th >全程接种最后一剂接种时间</th>
             		<td class="isInjected">
                	<%--<tag:dateInput id="lastInjectedDate" name="VaccinationDetailsDTO.lastFullInjectedDate"
                                   date="${vaccinationEvent.lastFullInjectedDate}" onlypast="true" />--%>
                        <input type="text"  class="layui-input x-admin-content-sm-date" name="VaccinationDetailsDTO.lastFullInjectedDate" id="lastFullInjectedDate" value="<fmt:formatDate value='${vaccinationEvent.lastFullInjectedDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 177px;" />
                    </td>
                <th >三年内是否加强接种过</th>
                <td >
                	<ehr:dic-radio name="VaccinationDetailsDTO.isPowerInjected" dicmeta="PH00001" code="1,2" value="${vaccinationEvent.isPowerInjected}"  />
                </td>
            </tr>
            <tr class="isInjected">
                <th >加强接种最后一剂接种时间</th>
                <td class="isInjected">
                	<%--<tag:dateInput id="lastInjectedDate" name="VaccinationDetailsDTO.lastPowerInjectedDate"
                                   date="${vaccinationEvent.lastPowerInjectedDate}" onlypast="true" />--%>
                    <input type="text"  class="layui-input x-admin-content-sm-date" name="VaccinationDetailsDTO.lastPowerInjectedDate" id="lastPowerInjectedDate" value="<fmt:formatDate value='${vaccinationEvent.lastPowerInjectedDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 177px;" />
                </td>
            </tr>
             <tr class="isInjected">
                
                <th >其他情况：</th>
                <td colspan="3">
	                <textarea class="" style="width: 100%;" rows="5" cols="40" reg='{"maxlength":"500"}' id="otherNote" name="VaccinationDetailsDTO.otherNote">${vaccinationEvent.otherNote}</textarea>
                </td>
            </tr>
            <tr>
                <th >提示：</th>
                <td colspan="3" style="width: 99%">
                   <input type="hidden" id="vacciantionFlag" name="VaccinationDetailsDTO.vacciantionFlag" value="${vaccinationEvent.flag}" />
                   <!-- <p id="injectPattern0" style="display:none"> 系统没有记录到上次咬伤情况</p>
                   <p id="injectPattern1" style="display:none"> 上次咬伤未正规注射狂犬疫苗，此次重新注射</p>
                   <p id="injectPattern2" style="display:none"> 上次咬伤在半年内且已正规注射狂犬病疫苗，此次不用再次注射</p>
                   <p id="injectPattern3" style="display:none"> 上次咬伤在半年以外一年内且已正规注射狂犬病疫苗，此次于当天和其后的第三天分别注射一针疫苗</p>
                   <p id="injectPattern4" style="display:none"> 上次咬伤在一年外三年内且已正规注射狂犬病疫苗，此次于当天和其后的第三天、第七天分别注射一针疫苗</p>
                   <p id="injectPattern5" style="display:none"> 上次咬伤超过三年，此次须完整注射疫苗</p> -->
                   <p id="injectPattern0" style="display:none"> 系统没有记录到上次注射情况</p>
                   <p id="injectPattern1" style="display:none"> 上次注射未正规注射狂犬疫苗，此次重新注射</p>
                   <p id="injectPattern2" style="display:none"> 上次注射在半年内且已正规注射狂犬病疫苗，此次不用再次注射</p>
                   <p id="injectPattern3" style="display:none"> 上次注射在半年以外一年内且已正规注射狂犬病疫苗，此次于当天和其后的第三天分别注射一针疫苗</p>
                   <p id="injectPattern4" style="display:none"> 上次注射在一年外三年内且已正规注射狂犬病疫苗，此次于当天和其后的第三天、第七天分别注射一针疫苗</p>
                   <p id="injectPattern5" style="display:none"> 上次注射超过三年，此次须完整注射疫苗</p>
                   <p id="injectPattern6" style="display:none"> 健康人预防接种最后1剂后未满一年，此次不用再次注射</p>
                   <p id="injectPattern7" style="display:none"> 健康人预防接种最后1剂注射在一年外二年内此次注射一针加强</p>
                   <p id="injectPattern8" style="display:none"> 健康人预防接种最后1剂后超过二年，此次须完整注射疫苗</p>
                </td>
            </tr>
            </tbody>
		</table>
		</fieldset>
      </div>
     <!-- 咬伤情况 -->
	<div class="postdiv">
		<fieldset class="postcontent layui-elem-field">
		<legend>暴露（被伤）情况</legend>
		<table style="width:99%" class="posttable">
            <colgroup >
                <col width="18%" />
                <col width="30%" />
                <col width="18%" />
                <col width="30%" />
            <colgroup>
			<tbody>
				<%-- <c:if test="${rabiesType ne 9}"> --%>
				<tr>
					<th><label class="required">伤人日期：</label></th>
					<td>
						<%--<tag:dateInput reg='{"required":"true"}' name="VaccinationDetailsDTO.traumaHistory.opsDate" id="hitDate"
						date="${traumaHistory.opsDate}" onlypast="true" pattern="yyyy/MM/dd HH:mm"/>--%>
                        <input type="text" reg='{"required":true}' class="layui-input x-admin-content-sm-date" name="VaccinationDetailsDTO.traumaHistory.opsDate" id="hitDate" value="<fmt:formatDate value='${traumaHistory.opsDate}' pattern='yyyy/MM/dd HH:mm'/>" style="padding-left: 0px;width: 177px;" />

                            <input type="hidden" id="opsHour" name="VaccinationDetailsDTO.traumaHistory.opsHour"/>
                    </td>
                    <th>
                    <label class="required">就诊日期：</label>
                    </th>
                    <td>
                        <%--<tag:dateInput name="VaccinationDetailsDTO.traumaHistory.treatmentTime"   id="visitdate"
                                       date="${empty traumaHistory.treatmentTime ? treatmentTime : traumaHistory.treatmentTime}" reg='{"required":"true"}' onlypast="true" pattern="yyyy/MM/dd HH:mm"/>--%>
                        <input type="text" reg='{"required":true}' class="layui-input x-admin-content-sm-date" name="VaccinationDetailsDTO.traumaHistory.treatmentTime" id="visitdate" value="<fmt:formatDate value='${empty traumaHistory.treatmentTime ? treatmentTime : traumaHistory.treatmentTime}' pattern='yyyy/MM/dd HH:mm'/>" style="padding-left: 0px;width: 177px;" />
                        <input type="hidden" id="treatmentHour" name="VaccinationDetailsDTO.traumaHistory.treatmentHour"/>
                    </td>
                </tr>
				<tr>
					<th><label class="required">伤人动物：</label></th>
					<td>
						 <select id="hurtType" name="VaccinationDetailsDTO.traumaHistory.hurtType" reg='{"required":"true"}' style="width:50%; "
                                    onchange="toggleOtherSC('VaccinationDetailsDTO.traumaHistory.hurtType','hurtOther','0')" >
							<option value="">请选择</option>
							<option value="狗" ${traumaHistory.hurtType eq '狗' ? 'selected' : ''}>狗</option>
							<option value="猫" ${traumaHistory.hurtType eq '猫' ? 'selected' : ''}>猫</option>
							<option value="蝙蝠" ${traumaHistory.hurtType eq '蝙蝠' ? 'selected' : ''}>蝙蝠</option>
							<option value="0" ${traumaHistory.hurtType eq '0' ? 'selected' : ''}>其它</option>
						</select>
                        <span style="display: none" id="hurtOther">
                            <input type="text" id="hurtOtherTxt" name="VaccinationDetailsDTO.traumaHistory.hurtOther"
                                reg='{"required":"true","maxlength":"10"}' style="width: 130px"
                                value="${traumaHistory.hurtOther}"
                                />
                        </span>
                     </td>
                     <th><label class="required">动物来源：</label></th>
                     <td>
						 <select id="hurtSource" name="VaccinationDetailsDTO.traumaHistory.hurtSource" reg='{"required":"true"}' style="width:50%; "
                                    onchange="toggleOtherSC('VaccinationDetailsDTO.traumaHistory.hurtSource','sourceOther','0')" >
							<option value="">请选择</option>
							<option value="自家养"  ${traumaHistory.hurtSource eq '自家养' ? 'selected' : ''}>自家养</option>
							<option value="他人养"  ${traumaHistory.hurtSource eq '他人养' ? 'selected' : ''}>他人养</option>
							<option value="流浪动物"  ${traumaHistory.hurtSource eq '流浪动物' ? 'selected' : ''}>流浪动物</option>
							<option value="0" ${traumaHistory.hurtSource eq '0' ? 'selected' : ''}>其它</option>
						</select>
                        <span style="display: none" id="sourceOther">
                            <input type="text" id="hurtsourceOtherTxt" name="VaccinationDetailsDTO.traumaHistory.sourceOther"
                                reg='{"required":"true","maxlength":"10"}' style="width: 130px"
                                value="${traumaHistory.sourceOther}"
                                />
                        </span>
                     </td>
                  </tr>
                  <tr>
                  <th><label class="required">动物状况：</label></th>
                     <td>
						 <select id="hurtStatus" name="VaccinationDetailsDTO.traumaHistory.hurtStatus" reg='{"required":"true"}' style="width:50%;">
							<option value="">请选择</option>
							<option value="正常" ${traumaHistory.hurtStatus eq '正常' ? 'selected' : ''}>正常</option>
							<option value="可疑疯动物"${traumaHistory.hurtStatus eq '可疑疯动物' ? 'selected' : ''}>可疑疯动物</option>
							<option value="疯动物" ${traumaHistory.hurtStatus eq '疯动物' ? 'selected' : ''}>疯动物</option>
							<option value="不知道" ${traumaHistory.hurtStatus eq '不知道' ? 'selected' : ''}>不知道</option>
						</select>
                     </td>
                   <th><label class="required">伤口部位：</label></th>
                      <td>
                          <ehr:dic-list type="true" dicmeta="FS990002" id="opsNameSelect" value="${traumaHistory.opsName}" width="180px"
                          	 name="VaccinationDetailsDTO.traumaHistory.opsName" reg='{"required":"true"}'/>
                      </td>
                  </tr>
                  <tr>
                   <th><label class="required">暴露方式：</label></th>
                     <td>
						 <select id="exposeType" name="VaccinationDetailsDTO.traumaHistory.exposeType" reg='{"required":"true"}' style="width:50%; "
                                    onchange="toggleOtherSC('VaccinationDetailsDTO.traumaHistory.exposeType','exposeOther','0')" >
							<option value="" >请选择</option>
							<option value="咬伤" ${traumaHistory.exposeType eq '咬伤' ? 'selected' : ''}>咬伤</option>
							<option value="抓伤" ${traumaHistory.exposeType eq '抓伤' ? 'selected' : ''}>抓伤</option>
							<option value="0" ${traumaHistory.exposeType eq '0' ? 'selected' : ''}>其它</option>
						</select>
                        <span style="display: none" id="exposeOther">
                            <input type="text" id="exposeOtherText" name="VaccinationDetailsDTO.traumaHistory.exposeOther"
                                reg='{"required":"true","maxlength":"10"}' style="width: 40%"
                                value="${traumaHistory.exposeOther}"  />
                        </span>
                     </td>
                       <th><label class="required">被伤性质：</label></th>
                     <td>
						 <select id="hurtNature" name="VaccinationDetailsDTO.traumaHistory.hurtNature" reg='{"required":"true"}' style="width:50%;">
							<option value="">请选择</option>
							<option value="单处伤"  ${traumaHistory.hurtNature eq '单处伤' ? 'selected' : ''}>单处伤</option>
							<option value="多处伤" ${traumaHistory.hurtNature eq '多处伤' ? 'selected' : ''}>多处伤</option>
						</select>
                     </td>
                  </tr>
                  <%--</c:if>
                   <c:if test="${rabiesType eq 9}">
                  <tr>
                    <th>
                    <label class="required">就诊日期：</label>
                    </th>
                    <td>
                        <input type="text" reg='{"required":true}' class="layui-input x-admin-content-sm-date" name="VaccinationDetailsDTO.traumaHistory.treatmentTime" id="visitdate" value="<fmt:formatDate value='${empty traumaHistory.treatmentTime ? treatmentTime : traumaHistory.treatmentTime}' pattern='yyyy/MM/dd HH:mm'/>" style="padding-left: 0px;width: 177px;" />
                        <input type="hidden" id="treatmentHour" name="VaccinationDetailsDTO.traumaHistory.treatmentHour"/>
                    </td>
                </tr>
                  </c:if> --%>
              </tbody>
          </table>
          <br/>
          <br/>
          <div>
              <table class="layui-table">
                  <thead>
                      <tr>
                          <th style="width: 10%;text-align: center;">分级</th>
                          <th style="width: 50%;text-align: center;">接触方式</th>
                          <th style="width: 10%;text-align: center;">暴露程度</th>
                          <th style="width: 30%;text-align: center;">医师建议</th>
                      </tr>
                  </thead>
                  <tbody>
                      <tr>
                          <td>
                              <input id="bitelevel1" name="VaccinationDetailsDTO.traumaHistory.biteLevel"
                                  ${traumaHistory.biteLevel eq '1' ? 'checked=checked' : ''} type="radio" value="1" checked="checked">&nbsp;I级
                          </td>
                          <td>
                              符合以下情况之一者：
                              <br/>1、接触或喂养动物；
                              <br/>2、完好的皮肤被舔。
                          </td>
                          <td>无</td>
                          <td>
                          	1、确认接触方式可靠则不需处置;<br />
                          	2、暴露前免疫;
                          </td>
                      </tr>
                      <tr>
                          <td>
                              <input id="bitelevel2" name="VaccinationDetailsDTO.traumaHistory.biteLevel"
                                  ${traumaHistory.biteLevel eq '2' ? 'checked=checked' : ''}  type="radio" value="2" >&nbsp;II级
                          </td>
                          <td>
                              符合以下情况之一者：
                              <br/>1、裸露的皮肤被轻咬；
                              <br/>2、无出血的轻微抓伤或擦伤。
                          </td>
                          <td>轻度</td>
                          <td>1、处理伤口；<br/>2、接种人用狂犬病疫苗。</td>
                      </tr>
                      <tr>
                          <td>
                              <input id="bitelevel3" name="VaccinationDetailsDTO.traumaHistory.biteLevel"
                              ${traumaHistory.biteLevel eq '3' ? 'checked=checked' : ''} type="radio" value="3" >&nbsp;III级
                          </td>
                          <td>
                              符合以下情况之一者：
                              <br/>1、单处或多处贯穿性皮肤咬伤或抓伤；
                              <br/>2、破损皮肤被舔；
                              <br/>3、开放性伤口或粘膜被污染。
                          </td>
                          <td>重度</td>
                          <td>1、处理伤口；<br/>2、接种人用狂犬病疫苗。<br/>	3、注射狂犬病人免疫球蛋白。</td>
                      </tr>
                  </tbody>
              </table>
          </div>
          </fieldset>
      </div>
	<div class="postdiv">
		<fieldset class="postcontent layui-elem-field">
		<legend>伤口处理情况</legend>
		<div class="repeattable">
		<table class="layui-table">
        <tbody>
		<tr>
           <th style="width: 10%;text-align: center;">医疗机构</th>
           <th style="width: 40%;text-align: center;">冲洗</th>
           <th style="width: 20%;text-align: center;">消毒</th>
           <th style="width: 20%;text-align: center;">其他处理</th>
           <th rowspan="3" style="width: 10%;text-align: center;">如就诊时伤口已结痂或愈合，不主张进行伤口处理。请在此标注 <ehr:dic-radio name="VaccinationDetailsDTO.traumaHistory.noTreat" dicmeta="FS10186"   code="0,1" value="${traumaHistory.noTreat}"  /></th>
         </tr>
		<tr>
			<td>本门诊</td>
			<td><label class="required">冲洗方法：</label><input type="text" id="flushMethod" name="VaccinationDetailsDTO.traumaHistory.flushMethod" value="${traumaHistory.flushMethod }" reg="{'required':'true'}" style="width: 100px"  />
                <label class="required">冲洗时长：</label><input type="text" id="flushTime" name="VaccinationDetailsDTO.traumaHistory.flushTime"  value="${traumaHistory.flushTime }"reg="{'regex':'digits','required':'true'}"style="width: 30px"/>分</td>
			<td><label class="required">消毒剂：</label><input type="text" id="disInfectant" name="VaccinationDetailsDTO.traumaHistory.disInfectant" value="${traumaHistory.disInfectant} "reg="{'required':'true'}" style="width: 88px"  /></td>
			<td><input type="text" id="otherHandle" name="VaccinationDetailsDTO.traumaHistory.otherHandle" style="width: 154px;"   value="${traumaHistory.otherHandle }"/></td>
		</tr>
		<tr>
			<td>其他</td>
			<td><label style="padding-right:10px">冲洗方法：</label><input type="text" id="otherFlushMethod" name="VaccinationDetailsDTO.traumaHistory.otherFlushMethod"  value="${traumaHistory.otherFlushMethod }" style="width: 100px;"  />
                <label style="padding-right:10px">冲洗时长：</label><input type="text" id="otherFlushTime" name="VaccinationDetailsDTO.traumaHistory.otherFlushTime"  value="${traumaHistory.otherFlushTime }"style="width: 30px;"/>分</td>
			<td><label style="padding-right:10px">消毒剂：</label><input type="text" id="otherDisInfectant" name="VaccinationDetailsDTO.traumaHistory.otherDisInfectant" value="${traumaHistory.otherDisInfectant}" style="width: 88px" /></td>
			<td><input type="text" id="otherHandles" name="VaccinationDetailsDTO.traumaHistory.otherHandles" style="width: 154px;"  value="${traumaHistory.otherHandles }" /></td>
		</tr>
		</tbody>
		</table>
		</div>
		
		</fieldset>
      </div>
	<!-- 备注 -->
	<div class="postdiv">
		<fieldset class="postcontent layui-elem-field">
		<legend>备注</legend>
		<table class="posttable" style="width: 98%;">
		<tr>
		<td>
		<textarea class="vacnte" style="width: 100%;" rows="5" cols="40" reg='{"maxlength":"500"}' name="comment">${vaccinationEvent.comments}</textarea>
		</td>
		</tr>
		</table>
		</fieldset>
	</div>
	<%-- <div class="repeattable">
		<fieldset>
		<legend>全程接种情况</legend>
		<div style="padding: 5px;">
		<label class="required">是否全程接种:</label><input type="radio" id="completeFlagId0" name="completeFlag" value="0"  <c:if test="${vaccinationEvent.completeFlag eq 1}">checked="checked" </c:if> reg='{"required":"true"}' />未完成&nbsp;&nbsp;&nbsp;<input type="radio" name="completeFlag" id="completeFlagId1" value="1" <c:if test="${vaccinationEvent.completeFlag eq 0}">checked="checked" </c:if>reg='{"required":"true"}'/>已完成
		</div>
		</fieldset>
		</div> --%>
</div>
</form>

<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        laydate.render({
            elem: '#preOpsDateTxt'
            ,format: 'yyyy/MM/dd'
            ,max:0
            , trigger: 'click'
            ,done:function(value) {
                if(!$.isEmpty(value)){
                    $("#preOpsDateTxt").removeClass("lose");
                }else{
                    $("#preOpsDateTxt").addClass("lose");
                }
            }
        });

        laydate.render({
            elem: '#hitDate'
            ,type:'datetime'
            ,format:'yyyy/MM/dd HH:mm'
            , trigger: 'click'
            ,done:function(value) {
                if(!$.isEmpty(value)){
                    $("#hitDate").removeClass("lose");
                }else{
                    $("#hitDate").addClass("lose");
                }
            }
        });

        laydate.render({
            elem: '#visitdate'
            ,type:'datetime'
            ,format:'yyyy/MM/dd HH:mm'
            , trigger: 'click'
        });

        laydate.render({
            elem: '#lastFullInjectedDate'
            ,format: 'yyyy/MM/dd'
            , trigger: 'click'
        });
        laydate.render({
            elem: '#lastPowerInjectedDate'
            ,format: 'yyyy/MM/dd'
            , trigger: 'click'
        });
        laydate.render({
            elem: '#lastInjectedDate'
            ,format: 'yyyy/MM/dd'
            , trigger: 'click'
        });
        
    });


</script>

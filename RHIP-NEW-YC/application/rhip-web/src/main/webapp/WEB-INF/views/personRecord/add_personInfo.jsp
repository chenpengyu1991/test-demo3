<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/util/jquery.jqprint-0.3.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ehr/person/addPersonInfo.js" type="text/javascript" ></script>
<script type="text/javascript">
	$(function() {
		toggleOtherSC('PersonalBasicInfoDTO.personInfo.occupation','occupation_other',90);
	});
</script>
<%--<style>--%>
<%--#printDiv {--%>
<%--height: 650px;width: 870px;overflow: auto;--%>
<%--}--%>
<%--</style>--%>
<%--<script src="${pageContext.request.contextPath}/js/views/cdm/standardization/healthCard/list.js" type="text/javascript"></script>--%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/personalRecord/personInfo.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/personalRecord/common.css" />
<div id="beforeSaveDiv" class="Contentbox" style="text-align: left;">
	<div style="display: none" class="msgError" id="person_info_errbox"></div>
	<div id="msgError" class="msgError" style="display: none;">   </div>
	<form id="personInfoForm" method="post">
		<input type="hidden" value="${isElder}" id="isElder"/>
		<input type="hidden" value="${personInfo.id}" id="personId" name="PersonalBasicInfoDTO.personInfo.id"/>
		<input type="hidden" value="${personInfo.star}" name="PersonalBasicInfoDTO.personInfo.star"/>
		<input type="hidden" value="${guideIntoChronicDiseaseFlag}" id="guideIntoChronicDiseaseFlagId"/>
		<input type="hidden" id="isNotManageOrg" value="${isNotManageOrg}"/>

		<i class="pop_No" style="height: 40px;">
			<%--<a class="bc" id="button_save">保存</a>
			<a class="dy" id="button_print">打印</a>--%>
			<a href="javascript:void(0);" id="button_save" style="margin-top: 3.5px;"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
			<a href="javascript:void(0)" id="button_print" style="margin-top: 3.5px;"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe66d;</i>打印</button></a>
		</i>
		<div class="postcontent" id="printDiv">
			<%--<div style="height: 70px;">--%>
			<span class="span_floatleft">&emsp;&emsp;姓名：<c:out value="${personInfo.name}"></c:out><input value="${personInfo.name}" type="hidden" readonly="readonly" name="PersonalBasicInfoDTO.personInfo.name"/></span>

			<c:choose>
				<c:when test="${not empty personInfo.healthFileNoHtml}">
					${personInfo.healthFileNoHtml}
				</c:when>
				<c:otherwise>
					<s class="pop_No" style="width: 55%;">
						<span class="text"><b>编号：</b></span>
						<span></span><span></span><span></span><span></span><span></span>
						<span class="line">-</span>
						<span></span><span></span><span></span>
						<span class="line">-</span>
						<span></span><span></span><span></span>
						<span class="line">-</span>
						<span></span><span></span><span></span><span></span>
					</s>
				</c:otherwise>
			</c:choose>

			<%--</div>--%>
			<!-- <div class="postdiv"> -->
			<%--<fieldset>--%>
			<table class="posttable">
				<colgroup>
					<col style="width: 18%"/>
					<col style="width: 32%"/>
					<col style="width: 18%"/>
					<col style="width: 32%"/>
				</colgroup>
				<tr>
					<th style="text-align: right;">性别</th>
					<td colspan="3">
						<ehr:dic-radio dicmeta="GBT226112003" name="PersonalBasicInfoDTO.personInfo.gender" value="${PersonalBasicInfoDTO.personInfo.gender}" onchange="addPersonInfo.showMaternal()"/>
					</td>

				</tr>
				<tr>
					<th style="text-align: right;">出生日期</th>
					<td>
						<%-- <tag:dateInput name="PersonalBasicInfoDTO.personInfo.birthday" reg='{"required":true}' id="birthday" onlypast="true" style="width: 177px"  date="${PersonalBasicInfoDTO.personInfo.birthday}"/> --%>
						<input type="text" reg='{"required":true}' class="layui-input x-admin-content-sm-date" name="PersonalBasicInfoDTO.personInfo.birthday" id="birthday" value="<fmt:formatDate value='${PersonalBasicInfoDTO.personInfo.birthday}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 177px;" />
					</td>
					<th style="text-align: right;">本人电话</th>
					<td>
						<span id="phoneNumber_text"><c:out value="${PersonalBasicInfoDTO.personInfo.phoneNumber}" /></span>
						<input type="hidden" name="PersonalBasicInfoDTO.personInfo.phoneNumber" value="${PersonalBasicInfoDTO.personInfo.phoneNumber}">
					</td>
				</tr>
				<tr>
					<th style="text-align: right;">身份证号</th>
					<td><c:out value="${personInfo.idcard}" />
						<input type="hidden" name="PersonalBasicInfoDTO.personInfo.idcard" value="${personInfo.idcard}">
					</td>
					<th title="应填写目前所在工作单位的全称。离退休填写最后工作单位的全称;&#13;&#10;下岗待业或无工作经历者需具体注明。" style="text-align: right;">
						<label class="required">工作单位</label></th>
					<td>
						<c:if test="${isAdult || isElder eq '1'}">
							<input  reg='{"maxlength":"23","required":true}' type="text" name="PersonalBasicInfoDTO.personInfo.unitName" id="unitName" value="${PersonalBasicInfoDTO.personInfo.unitName==null?"务工":PersonalBasicInfoDTO.personInfo.unitName}"/>
						</c:if>
						<c:if test="${isNotAdult}">
							<input  reg='{"maxlength":"23"}' type="text" name="PersonalBasicInfoDTO.personInfo.unitName" id="unitName" value="${PersonalBasicInfoDTO.personInfo.unitName}"/>
						</c:if>
					</td>
				</tr>
				<tr>
					<th title="填写与建档对象关系紧密的亲友名称。" style="text-align: right;"><label class="required">紧急联系人姓名</label></th>
					<td>
						<c:if test="${isAdult || isElder eq '1'}">
							<input reg='{"maxlength":"16","required":true}' style="width: 190px;" type="text" name="PersonalBasicInfoDTO.personInfo.firstGuardian" id="firstGuardian" value="${PersonalBasicInfoDTO.personInfo.firstGuardian}" />
						</c:if>
						<c:if test="${isNotAdult}">
							<input reg='{"maxlength":"16"}' style="width: 190px;" type="text" name="PersonalBasicInfoDTO.personInfo.firstGuardian" id="firstGuardian" value="${PersonalBasicInfoDTO.personInfo.firstGuardian}" />
						</c:if>
					</td>
					<th style="text-align: right;">紧急联系人电话</th>
					<td><c:out value="${PersonalBasicInfoDTO.personInfo.guardianPhoneOne}" />
						<input reg='{"regex":"phone"}' type="hidden" readonly="readonly" name="PersonalBasicInfoDTO.personInfo.guardianPhoneOne" id="guardianPhone1" value="${PersonalBasicInfoDTO.personInfo.guardianPhoneOne}" />
					</td>
				</tr>
				<tr>
					<th style="text-align: right;">常住类型</th>
					<td>
						<span id="householdType_text"><ehr:dic dicmeta="FS10005" code="${PersonalBasicInfoDTO.personInfo.householdType}"/></span>
					</td>
					<th title="少数民族应填写全称。如彝族、回族等。" style="text-align: right;"><label class="required">民族</label></th>
					<td>
						<input type="hidden" id="nation" value="${PersonalBasicInfoDTO.personInfo.nation}"/>
						<label><input type="radio" reg="{'required':true}" onclick="util.clickHideText(this,'otherNationDesc')" name="PersonalBasicInfoDTO.personInfo.nation" ${PersonalBasicInfoDTO.personInfo.nation eq"01"|| PersonalBasicInfoDTO.personInfo.nation ==null ?"checked":""} value="01" /> 汉族</label>
						<label><input type="radio" reg="{'required':true}" onclick="util.clickShowText(this,'otherNationDesc')" name="PersonalBasicInfoDTO.personInfo.nation" ${(PersonalBasicInfoDTO.personInfo.nation ne"1" && not empty PersonalBasicInfoDTO.personInfo.nation && PersonalBasicInfoDTO.personInfo.nation ne"01") ?"checked":""} value="99" /> 少数民族</label>
						<input type="text" id="otherNationDesc" class="hidediv" name="PersonalBasicInfoDTO.personInfo.otherNationDesc" value="${PersonalBasicInfoDTO.personInfo.otherNationDesc}" reg='{"required":"true"}' style="width: 80px;" />
						<%--<ehr:dic-list id="nation" reg='{"required":true}' dicmeta="GBT3304" name="PersonalBasicInfoDTO.personInfo.nation" value="${PersonalBasicInfoDTO.personInfo.nation}"  />--%>
					</td>
				</tr>
				<tr>
					<th style="text-align: right;"><label class="required">血型</label></th>
					<td colspan="3">
						<ehr:dic-radio dicmeta="CV0450005" reg='{"required":true}' name="PersonalBasicInfoDTO.personInfo.aboBloodType" value="${PersonalBasicInfoDTO.personInfo.aboBloodType}"/>
					</td>
				</tr>
				<tr>
					<th style="text-align: right;"><label class="required">RH阴性</label></th>
					<td>
						<ehr:dic-radio dicmeta="FS10010"  reg='{"required":true}' name="PersonalBasicInfoDTO.personInfo.rhBloodType" value="${PersonalBasicInfoDTO.personInfo.rhBloodType}"/>
					</td>
					<th title="指截至建档时间,本人接受国内外教育取得的最高学历或现有水平所相当的学历。" style="text-align: right;"><label class="required">文化程度</label></th>
					<td>
						<c:if test="${isAdult || isElder eq '1'}">
							<ehr:dic-list  id="education" reg='{"required":true}' dicmeta="GBT46582006" name="PersonalBasicInfoDTO.personInfo.education" value="${PersonalBasicInfoDTO.personInfo.education}" width="190px;" code="IDM17,20,IDM18,IDM19,IDM20,IDM21,IDM02,IDM07,IDM22,IDM10"/>
						</c:if>
						<c:if test="${isNotAdult}">
							<ehr:dic-list id="education" dicmeta="GBT46582006" name="PersonalBasicInfoDTO.personInfo.education" value="${PersonalBasicInfoDTO.personInfo.education}" width="190px;" code="IDM17,20,IDM18,IDM19,IDM20,IDM21,IDM02,IDM07,IDM22,IDM10"/>
						</c:if>
					</td>
				</tr>
				<tr>
					<th style="text-align: right;"><label class="required">职业</label></th>
					<td colspan="3">
						<c:if test="${isAdult || isElder eq '1'}">
							<ehr:dic-list id="occupation" reg='{"required":true}' dicmeta="GBT6565" name="PersonalBasicInfoDTO.personInfo.occupation"
										  width="350px" value="${PersonalBasicInfoDTO.personInfo.occupation==null?'5':PersonalBasicInfoDTO.personInfo.occupation}" code="0,1/2,3,4,5,6/7/8/9,X,Y,CV00031"
										  onchange="toggleOtherSC('PersonalBasicInfoDTO.personInfo.occupation','occupation_other',90);"/>
							<span id="occupation_other" style="display: none">
								<input type="text" style="width: 200px;" reg='{"maxlength":"10","required":true}'
									   name="PersonalBasicInfoDTO.personInfo.occupationOther" value="${PersonalBasicInfoDTO.personInfo.occupationOther}" />
							</span>
						</c:if>
						<c:if test="${isNotAdult}">
							<ehr:dic-list id="occupation" dicmeta="GBT6565" name="PersonalBasicInfoDTO.personInfo.occupation"
										  width="350px" value="${PersonalBasicInfoDTO.personInfo.occupation}" code="0,1/2,3,4,5,6/7/8/9,X,Y,CV00031"
										  onchange="toggleOtherSC('PersonalBasicInfoDTO.personInfo.occupation','occupation_other',90);"/>
							<span id="occupation_other" style="display: none">
								<input type="text" style="width: 200px;" reg='{"maxlength":"10"}'
									   name="PersonalBasicInfoDTO.personInfo.occupationOther" value="${PersonalBasicInfoDTO.personInfo.occupationOther}" />
							</span>
						</c:if>
					</td>
				</tr>
				<tr>
					<c:if test="${isAdult || isElder eq '1'}">
						<th style="text-align: right;"><label class="required">婚姻状况</label></th>
						<td colspan="3">
							<ehr:dic-radio reg='{"required":"true"}' dicmeta="GBT226122003" name="PersonalBasicInfoDTO.personInfo.marriage" value="${PersonalBasicInfoDTO.personInfo.marriage}" code="10,20,30,40,90"/>
						</td>
					</c:if>
					<c:if test="${isNotAdult}">
						<th style="text-align: right;">婚姻状况</th>
						<td colspan="3">
							<ehr:dic-radio dicmeta="GBT226122003" name="PersonalBasicInfoDTO.personInfo.marriage" value="${PersonalBasicInfoDTO.personInfo.marriage}" code="10,20,30,40,90"/>
						</td>
					</c:if>
				</tr>
				<tr id="maternalThId">
					<th style="text-align: right;">是否孕产妇</th>
					<td>
						<ehr:dic-radio name="PersonalBasicInfoDTO.personInfo.maternalFlag" dicmeta="FS10281" value="${PersonalBasicInfoDTO.personInfo.maternalFlag eq null ? '1' : PersonalBasicInfoDTO.personInfo.maternalFlag}" code="1,2" onchange="addPersonInfo.isMaternal()"/>
					</td>
					<th></th>
					<td></td>
				</tr>
				<tr id="maternalTrId">
					<th style="text-align: right;"><label class="required">末次月经日期</label></th>
					<td>
						<%-- <tag:dateInput reg='{"compare":["estimatedDueDateId","le","末次月经日期不能晚与预产期"],"required":"true"}' id="lastMenstrualDateId" onlypast="true" name="PersonalBasicInfoDTO.personInfo.lastMenstrualDate" date="${PersonalBasicInfoDTO.personInfo.lastMenstrualDate}"  style="width:90px"/> --%>
						<input type="text" reg='{"compare":["estimatedDueDateId","le","末次月经日期不能晚与预产期"],"required":"true"}' class="layui-input x-admin-content-sm-date" name="PersonalBasicInfoDTO.personInfo.lastMenstrualDate" id="lastMenstrualDateId" value="<fmt:formatDate value='${PersonalBasicInfoDTO.personInfo.lastMenstrualDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 90px;" />
					</td>
					<th style="text-align: right;"><label class="required">预产期</label></th>
					<td>
						<%-- <tag:dateInput reg='{"compare":["lastMenstrualDateId","ge","预产期不能早于末次月经日期"],"required":"true"}' id="estimatedDueDateId" name="PersonalBasicInfoDTO.personInfo.estimatedDueDate" date="${PersonalBasicInfoDTO.personInfo.estimatedDueDate}"  style="width:90px"/> --%>
						<input type="text" reg='{"compare":["lastMenstrualDateId","ge","预产期不能早于末次月经日期"],"required":"true"}' class="layui-input x-admin-content-sm-date" name="PersonalBasicInfoDTO.personInfo.estimatedDueDate" id="estimatedDueDateId" value="<fmt:formatDate value='${PersonalBasicInfoDTO.personInfo.estimatedDueDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 90px;" />
					</td>
				</tr>
			</table>
			<%--</fieldset>
        </div>--%>
			<div class="postdiv">
				<fieldset class="layui-elem-field">
					<table class="posttable">
						<tr>
							<c:if test="${isAdult || isElder eq '1'}">
								<th style="width: 18%;border-right:0px;text-align: right;vertical-align: top;"><label class="required">医疗费用支付方式</label></th>
								<td>
									<ehr:dic-checkbox reg='{"required":"true"}' dicmeta="CV0710003" name="PersonalBasicInfoDTO.expenseInfoStr" value="${PersonalBasicInfoDTO.expenseInfoStr}" onchange="addPersonInfo.expenseInfoChange('03')"/>
								</td>
							</c:if>
							<c:if test="${isNotAdult}">
								<th style="width: 18%;vertical-align: top;text-align: right;">医疗费用支付方式</th>
								<td>
									<ehr:dic-checkbox dicmeta="CV0710003" name="PersonalBasicInfoDTO.expenseInfoStr" value="${PersonalBasicInfoDTO.expenseInfoStr}"/>
								</td>
							</c:if>
						</tr>
					</table>
				</fieldset>
				<fieldset class="layui-elem-field">
					<table class="posttable">
						<tr>
							<c:if test="${isAdult || isElder eq '1'}">
								<th style="width: 18%;vertical-align: top;text-align: right;"><label class="required">药物过敏史</label></th>
							</c:if>
							<c:if test="${isNotAdult}">
								<th style="width: 18%;vertical-align: top;text-align: right;">药物过敏史</th>
							</c:if>
							<td colspan="5">
								<label><input class="flag" type="radio" name="PersonalBasicInfoDTO.drugAllergyHistoryFlag" id="drugAllergyHistory_Flag1" value="1" ${PersonalBasicInfoDTO.drugAllergyHistoryFlag eq '1' || PersonalBasicInfoDTO.drugAllergyHistoryFlag eq null  ? 'checked=checked' : ''}/> 无</label>
								<label><input class="flag selectedFlag" type="radio" name="PersonalBasicInfoDTO.drugAllergyHistoryFlag" id="drugAllergyHistory_Flag2" value="2" ${PersonalBasicInfoDTO.drugAllergyHistoryFlag eq '2' ? 'checked=checked' : ''}/> 有</label>
								<br/>
								<span id="drugAllergyHistorySpan" style="display:${PersonalBasicInfoDTO.drugAllergyHistoryFlag eq '2' ? 'inline' : 'none'}">
								<ehr:dic-checkbox dicmeta="CV0501038" name="PersonalBasicInfoDTO.drugAllergyHistoryStr" value="${PersonalBasicInfoDTO.drugAllergyHistoryStr}"
												  reg='{"dependOn":"drugAllergyHistory_Flag2","required":"true"}' code="101,102,BRW107,9"
												  onchange="toggleOtherCK('PersonalBasicInfoDTO.drugAllergyHistoryStr','drugAllergyHistoryDescSpan',9);"/>
								<span id="drugAllergyHistoryDescSpan">
									<input type="text" style="width: 30%" reg="{'required':true}" name="PersonalBasicInfoDTO.drugAllergyHistoryOtherDesc" value="${PersonalBasicInfoDTO.drugAllergyHistoryOtherDesc}"/>
								</span>
							</span>
							</td>
						</tr>
						<tr>
							<c:if test="${isAdult || isElder eq '1'}">
								<th style="width: 18%;vertical-align: top;text-align: right;"><label class="required">暴露史</label></th>
							</c:if>
							<c:if test="${isNotAdult}">
								<th style="width: 18%;vertical-align: top;text-align: right">暴露史</th>
							</c:if>
							<td colspan="5">
								<label><input class="flag" type="radio" name="PersonalBasicInfoDTO.exposeHistory.exposeFlag" value="1" id="exposeHistory_Flag1" ${PersonalBasicInfoDTO.exposeHistoryFlag eq '1' || PersonalBasicInfoDTO.exposeHistoryFlag eq null  ? 'checked=checked' : ''}/> 无</label>
								<label><input class="flag selectedFlag" type="radio" name="PersonalBasicInfoDTO.exposeHistory.exposeFlag" value="2" id="exposeHistory_Flag2" ${PersonalBasicInfoDTO.exposeHistoryFlag eq '2' ? 'checked=checked' : ''}/> 有</label>
								<span id="exposeHistorySpan" style="display:${PersonalBasicInfoDTO.exposeHistoryFlag eq '2' ? 'inline' : 'none'}">
								<br />
								<label><input type="checkbox" reg='{"extension":["exposeHistoryVali","请至少选择一项"]}' name="PersonalBasicInfoDTO.exposeHistory.chemical" value="1" ${PersonalBasicInfoDTO.exposeHistory.chemical eq '1' ? 'checked=checked' : ''}/> 化学品&emsp;</label>
								<label><input type="checkbox" reg='{"extension":["exposeHistoryVali","请至少选择一项"]}' name="PersonalBasicInfoDTO.exposeHistory.poison" value="1" ${PersonalBasicInfoDTO.exposeHistory.poison eq '1' ? 'checked=checked' : ''}/> 毒物&emsp;</label>
								<label><input type="checkbox" reg='{"extension":["exposeHistoryVali","请至少选择一项"]}' name="PersonalBasicInfoDTO.exposeHistory.ray" value="1" ${PersonalBasicInfoDTO.exposeHistory.ray eq '1' ? 'checked=checked' : ''}/> 射线&emsp;</label>
							</span>
							</td>
						</tr>
					</table>
				</fieldset>
				<div class="postdiv">
					<fieldset class="layui-elem-field">
						<c:if test="${isAdult || isElder eq '1'}">
							<legend><label class="required">既往史</label></legend>
						</c:if>
						<c:if test="${isNotAdult}">
							<legend>既往史</legend>
						</c:if>
						<table class="posttable">
							<tr>
								<th title="填写现在和过去曾经患过的某种疾病,包括建档时还未治愈的慢性病或某些反复发作的疾病。对于经医疗单位明确诊断的疾病都应以一级及以上医院的正式诊断为依据,有病史卡的以卡上的疾病名称为准,没有病史卡的应有证据证明是经过医院明确诊断的。"
									style="width: 13%;vertical-align: top;text-align: right;">疾病</th>
								<td>
									<label><input class="flag" type="radio" name="PersonalBasicInfoDTO.diseaseHistoryFlag" value="1" id="diseaseHistory_Flag1" ${PersonalBasicInfoDTO.diseaseHistoryFlag eq '1' || PersonalBasicInfoDTO.diseaseHistoryFlag eq null  ? 'checked=checked' : ''}/> 无</label>
									<label>
										<input class="flag selectedFlag" type="radio" name="PersonalBasicInfoDTO.diseaseHistoryFlag" value="2" id="diseaseHistory_Flag2" ${PersonalBasicInfoDTO.diseaseHistoryFlag eq '2' ? 'checked=checked' : ''}/> 有
										<c:if test="${guideIntoChronicDiseaseFlag == '1'}">
											<font style="color: red">注：此患者已纳入纳入慢性病患者健康管理,请确认既往史中有没有高血压、糖尿病、严重精神障碍</font>
										</c:if>
									</label>
									<br/>
									<div id="diseaseHistorySpan" style="display:${PersonalBasicInfoDTO.diseaseHistoryFlag eq '2' ? 'inline' : 'none'}">
										<table>
											<tr>
												<td width="49%">
													<label><input reg='{"extension":["diseaseHistoryVali","请至少选择一项"]}' type="checkbox" name="PersonalBasicInfoDTO.gxy" value="201" ${PersonalBasicInfoDTO.gxy eq '201' ? 'checked=checked' : ''}/> 高血压 </label>
													确诊时间<%--  <tag:dateInput onlypast="true" reg='{"dependOn":"PersonalBasicInfoDTO.gxy","dependValue":"201","required":"true"}' name="PersonalBasicInfoDTO.gxyDate" date="${PersonalBasicInfoDTO.gxyDate}" style="width:80px"/> --%>
													<input type="text" reg='{"dependOn":"PersonalBasicInfoDTO.gxy","dependValue":"201","required":"true"}' class="layui-input x-admin-content-sm-date" name="PersonalBasicInfoDTO.gxyDate" id="PersonalBasicInfoDTOGxyDateId" value="<fmt:formatDate value='${PersonalBasicInfoDTO.gxyDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
												</td>
												<td width="49%">
													<label><input reg='{"extension":["diseaseHistoryVali","请至少选择一项"]}'  type="checkbox" name="PersonalBasicInfoDTO.tnb" value="202" ${PersonalBasicInfoDTO.tnb eq '202' ? 'checked=checked' : ''}/> 糖尿病 </label>
													确诊时间<%-- <tag:dateInput onlypast="true" reg='{"dependOn":"PersonalBasicInfoDTO.tnb","dependValue":"202","required":"true"}'  name="PersonalBasicInfoDTO.tnbDate" date="${PersonalBasicInfoDTO.tnbDate}"  style="width:80px"/> --%>
													<input type="text" reg='{"dependOn":"PersonalBasicInfoDTO.tnb","dependValue":"202","required":"true"}' class="layui-input x-admin-content-sm-date" name="PersonalBasicInfoDTO.tnbDate" id="PersonalBasicInfoDTOTnbDateId" value="<fmt:formatDate value='${PersonalBasicInfoDTO.tnbDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
												</td>
											</tr>
											<tr>
												<td width="49%">
													<label><input  reg='{"extension":["diseaseHistoryVali","请至少选择一项"]}' type="checkbox" name="PersonalBasicInfoDTO.gxb" value="203" ${PersonalBasicInfoDTO.gxb eq '203' ? 'checked=checked' : ''}/> 冠心病 </label>
													确诊时间<%-- <tag:dateInput onlypast="true" reg='{"dependOn":"PersonalBasicInfoDTO.gxb","dependValue":"203","required":"true"}'  name="PersonalBasicInfoDTO.gxbDate" date="${PersonalBasicInfoDTO.gxbDate}"  style="width:80px"/> --%>
													<input type="text" reg='{"dependOn":"PersonalBasicInfoDTO.gxb","dependValue":"203","required":"true"}' class="layui-input x-admin-content-sm-date" name="PersonalBasicInfoDTO.gxbDate" id="PersonalBasicInfoDTOGxbDateId" value="<fmt:formatDate value='${PersonalBasicInfoDTO.gxbDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
												</td>
												<td width="49%">
													<label><input  reg='{"extension":["diseaseHistoryVali","请至少选择一项"]}' type="checkbox" name="PersonalBasicInfoDTO.fjb" value="204" ${PersonalBasicInfoDTO.fjb eq '204' ? 'checked=checked' : ''}/> 慢性阻塞性肺疾病</label>
													确诊时间<%-- <tag:dateInput onlypast="true" reg='{"dependOn":"PersonalBasicInfoDTO.fjb","dependValue":"204","required":"true"}'  name="PersonalBasicInfoDTO.fjbDate" date="${PersonalBasicInfoDTO.fjbDate}"  style="width:70px"/> --%>
													<input type="text" reg='{"dependOn":"PersonalBasicInfoDTO.fjb","dependValue":"204","required":"true"}'  class="layui-input x-admin-content-sm-date" name="PersonalBasicInfoDTO.fjbDate" id="PersonalBasicInfoDTOFjbDateId" value="<fmt:formatDate value='${PersonalBasicInfoDTO.fjbDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width:80px;" />
												</td>
											</tr>
											<tr>
												<td width="49%">
													<label><input reg='{"extension":["diseaseHistoryVali","请至少选择一项"]}'  type="checkbox" name="PersonalBasicInfoDTO.nzz" value="206" ${PersonalBasicInfoDTO.nzz eq '206' ? 'checked=checked' : ''}/> 脑卒中</label>
													确诊时间<%-- <tag:dateInput onlypast="true" reg='{"dependOn":"PersonalBasicInfoDTO.nzz","dependValue":"206","required":"true"}'  name="PersonalBasicInfoDTO.nzzDate" date="${PersonalBasicInfoDTO.nzzDate}"  style="width:80px"/> --%>
													<input type="text" reg='{"dependOn":"PersonalBasicInfoDTO.nzz","dependValue":"206","required":"true"}'   class="layui-input x-admin-content-sm-date" name="PersonalBasicInfoDTO.nzzDate" id="PersonalBasicInfoDTONzzDateId" value="<fmt:formatDate value='${PersonalBasicInfoDTO.nzzDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width:80px;" />
												</td>
											</tr>
											<tr>
												<td width="99%" colspan="2">
													<label><input reg='{"extension":["diseaseHistoryVali","请至少选择一项"]}'  type="checkbox" name="PersonalBasicInfoDTO.exzl" value="205" ${PersonalBasicInfoDTO.exzl eq '205' ? 'checked=checked' : ''} onchange="addPersonInfo.exzlChange()"/> 恶性肿瘤</label>
													确诊时间<%-- <tag:dateInput onlypast="true" reg='{"dependOn":"PersonalBasicInfoDTO.exzl","dependValue":"205","required":"true"}'  name="PersonalBasicInfoDTO.exzlDate"  date="${PersonalBasicInfoDTO.exzlDate}"   style="width:80px"/> --%>
													<input type="text" reg='{"dependOn":"PersonalBasicInfoDTO.exzl","dependValue":"205","required":"true"}'   class="layui-input x-admin-content-sm-date" name="PersonalBasicInfoDTO.exzlDate" id="PersonalBasicInfoDTOExzlDateId" value="<fmt:formatDate value='${PersonalBasicInfoDTO.exzlDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width:80px;" />
													<span id="exzlNameSpan">
														名称 <input style="width: 180px" type="text"  name="PersonalBasicInfoDTO.exzlName" value="${PersonalBasicInfoDTO.exzlName}"/>
													</span>
												</td>
											</tr>
											<tr>
												<td width="49%">
													<label><input reg='{"extension":["diseaseHistoryVali","请至少选择一项"]}'  type="checkbox" name="PersonalBasicInfoDTO.zxjsb" value="207" ${PersonalBasicInfoDTO.zxjsb eq '207' ? 'checked=checked' : ''}/> 重性精神障碍</label>
													确诊时间<%-- <tag:dateInput onlypast="true" reg='{"dependOn":"PersonalBasicInfoDTO.zxjsb","dependValue":"207","required":"true"}'  name="PersonalBasicInfoDTO.zxjsbDate" date="${PersonalBasicInfoDTO.zxjsbDate}" style="width:80px"/> --%>
													<input type="text" reg='{"dependOn":"PersonalBasicInfoDTO.zxjsb","dependValue":"207","required":"true"}'    class="layui-input x-admin-content-sm-date" name="PersonalBasicInfoDTO.zxjsbDate" id="PersonalBasicInfoDTOZxjsbDateId" value="<fmt:formatDate value='${PersonalBasicInfoDTO.zxjsbDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width:80px;" />
												</td>
												<td width="49%">
													<label><input reg='{"extension":["diseaseHistoryVali","请至少选择一项"]}'  type="checkbox" name="PersonalBasicInfoDTO.jhb" value="208" ${PersonalBasicInfoDTO.jhb eq '208' ? 'checked=checked' : ''}/> 结核病</label>
													确诊时间<%-- <tag:dateInput onlypast="true" reg='{"dependOn":"PersonalBasicInfoDTO.jhb","dependValue":"208","required":"true"}'  name="PersonalBasicInfoDTO.jhbDate" date="${PersonalBasicInfoDTO.jhbDate}"  style="width:80px"/> --%>
													<input type="text" reg='{"dependOn":"PersonalBasicInfoDTO.jhb","dependValue":"208","required":"true"}'   class="layui-input x-admin-content-sm-date" name="PersonalBasicInfoDTO.jhbDate" id="PersonalBasicInfoDTOJhbDateId" value="<fmt:formatDate value='${PersonalBasicInfoDTO.jhbDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width:80px;" />
												</td>
											</tr>
											<tr>
												<td width="49%">
													<label><input reg='{"extension":["diseaseHistoryVali","请至少选择一项"]}'  type="checkbox" name="PersonalBasicInfoDTO.gy" value="209" ${PersonalBasicInfoDTO.gy eq '209' ? 'checked=checked' : ''}/> 肝炎</label>
													确诊时间<%-- <tag:dateInput onlypast="true" reg='{"dependOn":"PersonalBasicInfoDTO.gy","dependValue":"209","required":"true"}'  name="PersonalBasicInfoDTO.gyDate" date="${PersonalBasicInfoDTO.gyDate}" style="width:80px"/> --%>
													<input type="text" reg='{"dependOn":"PersonalBasicInfoDTO.gy","dependValue":"209","required":"true"}'   class="layui-input x-admin-content-sm-date" name="PersonalBasicInfoDTO.gyDate" id="PersonalBasicInfoDTOGyDateId" value="<fmt:formatDate value='${PersonalBasicInfoDTO.gyDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width:80px;" />
												</td>
												<td width="49%">
													<label><input reg='{"extension":["diseaseHistoryVali","请至少选择一项"]}'  type="checkbox" name="PersonalBasicInfoDTO.qtidm" value="212" ${PersonalBasicInfoDTO.qtidm eq '212' ? 'checked=checked' : ''}/> 其他法定传染病</label>
													确诊时间<%-- <tag:dateInput onlypast="true" reg='{"dependOn":"PersonalBasicInfoDTO.qtidm","dependValue":"212","required":"true"}'  name="PersonalBasicInfoDTO.qtidmDate" date="${PersonalBasicInfoDTO.qtidmDate}" style="width:80px"/> --%>
													<input type="text" reg='{"dependOn":"PersonalBasicInfoDTO.qtidm","dependValue":"212","required":"true"}'   class="layui-input x-admin-content-sm-date" name="PersonalBasicInfoDTO.qtidmDate" id="PersonalBasicInfoDTOQtidmDateId" value="<fmt:formatDate value='${PersonalBasicInfoDTO.qtidmDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width:80px;" />
												</td>
											</tr>
											<tr>
												<td width="99%" colspan="2">
													<label><input reg='{"extension":["diseaseHistoryVali","请至少选择一项"]}'  type="checkbox" name="PersonalBasicInfoDTO.zyb" value="213" ${PersonalBasicInfoDTO.zyb eq '213' ? 'checked=checked' : ''} onchange="addPersonInfo.zybChange()"/> 职业病</label>
													确诊时间<%-- <tag:dateInput onlypast="true" reg='{"dependOn":"PersonalBasicInfoDTO.zyb","dependValue":"213","required":"true"}'  name="PersonalBasicInfoDTO.zybDate" date="${PersonalBasicInfoDTO.zybDate}" style="width:80px"/> --%>
													<input type="text" reg='{"dependOn":"PersonalBasicInfoDTO.zyb","dependValue":"213","required":"true"}'  class="layui-input x-admin-content-sm-date" name="PersonalBasicInfoDTO.zybDate" id="PersonalBasicInfoDTOZybDateId" value="<fmt:formatDate value='${PersonalBasicInfoDTO.zybDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width:80px;" />
													<span id="zybNameSpan">
														名称 <input style="width: 180px" type="text"  name="PersonalBasicInfoDTO.zybName" value="${PersonalBasicInfoDTO.zybName}"/>
													</span>
												</td>
											</tr>
											<tr>
												<td width="99%" colspan="2">
													<label><input reg='{"extension":["diseaseHistoryVali","请至少选择一项"]}'  type="checkbox" name="PersonalBasicInfoDTO.qt" value="211" ${PersonalBasicInfoDTO.qt eq '211' ? 'checked=checked' : ''}/> 其他</label>
													<input style="width: 50%" reg='{"dependOn":"PersonalBasicInfoDTO.qt","dependValue":"211","required":"false","maxlength":"33"}'  type="text" name="PersonalBasicInfoDTO.qtxx" value="${PersonalBasicInfoDTO.qtxx}"/>
													确诊时间<%-- <tag:dateInput onlypast="true" reg='{"dependOn":"PersonalBasicInfoDTO.qt","dependValue":"211","required":"true"}' name="PersonalBasicInfoDTO.qtDate" date="${PersonalBasicInfoDTO.qtDate}" style="width:80px"/> --%>
													<input type="text" reg='{"dependOn":"PersonalBasicInfoDTO.qt","dependValue":"211","required":"true"}' class="layui-input x-admin-content-sm-date" name="PersonalBasicInfoDTO.qtDate" id="PersonalBasicInfoDTOQtDateId" value="<fmt:formatDate value='${PersonalBasicInfoDTO.qtDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width:80px;" />
												</td>
											</tr>
										</table>
									</div>
								</td>
							</tr>
							<tr>
								<th style="width: 13%;vertical-align: top;text-align: right;">手术</th>
								<td>
									<label><input class="flag" type="radio" name="PersonalBasicInfoDTO.surgeryHistoryFlag" id="surgeryHistory_Flag1" value="1" ${PersonalBasicInfoDTO.surgeryHistoryFlag eq '1' || PersonalBasicInfoDTO.surgeryHistoryFlag eq null ? 'checked=checked' : ''}/> 无</label>
									<label><input class="flag selectedInputFlag" type="radio" name="PersonalBasicInfoDTO.surgeryHistoryFlag" id="surgeryHistory_Flag2" value="2" ${PersonalBasicInfoDTO.surgeryHistoryFlag eq '2' ? 'checked=checked' : ''}/> 有 </label>
									<span id="surgeryHistorySpan" style="display:${PersonalBasicInfoDTO.surgeryHistoryFlag eq '2' ? 'inline' : 'none'}">
								<a id="addSurgeryHistory" href="javascript:void(0)" >增加</a>
								<a id="delSurgeryHistory" href="javascript:void(0)" >删除</a>
								<c:set scope="request" value="${fn:length(PersonalBasicInfoDTO.surgeryHistoryList)}" var="surgerySize"></c:set>
								<input id="surSize" type="hidden" value="${surgerySize}"/>
								<c:forEach items="${PersonalBasicInfoDTO.surgeryHistoryList}" var="surgeryHistory" varStatus="idx">
									<br/>
									<c:choose>
										<c:when test="${idx.index == surgerySize - 1}">
											<span>名称 <input style="width: 25%" reg='{"dependOn":"surgeryHistory_Flag2","required":"true","maxlength":"33"}' type="text" class="ap_req_value_input" name="PersonalBasicInfoDTO.surgeryHistoryList[${idx.index}].opsName" value="${surgeryHistory.opsName}"/>
												&emsp;
												时间 <%-- <tag:dateInput reg='{"dependOn":"surgeryHistory_Flag2","required":true}' onlypast="true" name="PersonalBasicInfoDTO.surgeryHistoryList[${idx.index}].opsDate" date="${surgeryHistory.opsDate}"  style="width:90px"/> --%>
												<input type="text" reg='{"dependOn":"surgeryHistory_Flag2","required":true}' class="layui-input x-admin-content-sm-date datetime" name="PersonalBasicInfoDTO.surgeryHistoryList[${idx.index}].opsDate" value="<fmt:formatDate value='${surgeryHistory.opsDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width:90px;" />
												&emsp;</span>
										</c:when>
										<c:otherwise>
											<span>名称 <input style="width: 25%" reg='{"dependOn":"surgeryHistory_Flag2","required":"true","maxlength":"33"}' type="text" class="ap_req_value_input" name="PersonalBasicInfoDTO.surgeryHistoryList[${idx.index}].opsName" value="${surgeryHistory.opsName}"/>
												&emsp;
												时间<%--  <tag:dateInput reg='{"dependOn":"surgeryHistory_Flag2","required":true}' onlypast="true" name="PersonalBasicInfoDTO.surgeryHistoryList[${idx.index}].opsDate" date="${surgeryHistory.opsDate}"  style="width:90px"/> --%>
												<input type="text" reg='{"dependOn":"surgeryHistory_Flag2","required":true}' class="layui-input x-admin-content-sm-date datetime" name="PersonalBasicInfoDTO.surgeryHistoryList[${idx.index}].opsDate" value="<fmt:formatDate value='${surgeryHistory.opsDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width:90px;" />
												&emsp;</span>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</span>
								</td>
							</tr>
							<tr>
								<th title="填写曾经发生的后果比较严重的外伤经历。" style="width: 13%;vertical-align: top;text-align: right;">外伤</th>
								<td>
									<label><input class="flag" type="radio" name="PersonalBasicInfoDTO.traumaHistoryFlag" id="traumaHistory_Flag1" value="1" ${PersonalBasicInfoDTO.traumaHistoryFlag eq '1' || PersonalBasicInfoDTO.traumaHistoryFlag eq null ? 'checked=checked' : ''}/> 无</label>
									<label><input class="flag selectedInputFlag" type="radio" name="PersonalBasicInfoDTO.traumaHistoryFlag" id="traumaHistory_Flag2" value="2" ${PersonalBasicInfoDTO.traumaHistoryFlag eq '2' ? 'checked=checked' : ''}/> 有</label>
									<span id="traumaHistorySpan" style="display:${PersonalBasicInfoDTO.traumaHistoryFlag eq '2' ? 'inline' : 'none'}">
								<a id="addTraumaHistory" href="javascript:void(0)" >增加</a>
								<a id="delTraumaHistory" href="javascript:void(0)" >删除</a>
								<c:set scope="request" value="${fn:length(PersonalBasicInfoDTO.traumaHistoryList)}" var="traumaSize"></c:set>
								<input id="traSize" type="hidden" value="${traumaSize}"/>
								<c:forEach items="${PersonalBasicInfoDTO.traumaHistoryList}" var="traumaHistory" varStatus="idx">
									<br/>
									<c:choose>
										<c:when test="${idx.index == traumaSize - 1}">
											<span>名称 <input style="width: 25%" reg='{"dependOn":"traumaHistory_Flag2","required":"true","maxlength":"33"}' type="text" class="ap_req_value_input" name="PersonalBasicInfoDTO.traumaHistoryList[${idx.index}].opsName" value="${traumaHistory.opsName}"/>
												&emsp;
												时间<%-- <tag:dateInput reg='{"dependOn":"traumaHistory_Flag2","required":true}' onlypast="true" name="PersonalBasicInfoDTO.traumaHistoryList[${idx.index}].opsDate" date="${traumaHistory.opsDate}" style="width:90px"/> --%>
												<input type="text" reg='{"dependOn":"traumaHistory_Flag2","required":true}' class="layui-input x-admin-content-sm-date datetime" name="PersonalBasicInfoDTO.traumaHistoryList[${idx.index}].opsDate" value="<fmt:formatDate value='${traumaHistory.opsDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width:90px;" />
												&emsp;</span>
										</c:when>
										<c:otherwise>
											 <span>名称 <input style="width: 25%" reg='{"dependOn":"traumaHistory_Flag2","required":"true","maxlength":"33"}' type="text" class="ap_req_value_input" name="PersonalBasicInfoDTO.traumaHistoryList[${idx.index}].opsName" value="${traumaHistory.opsName}"/>
												 &emsp;
												 时间<%-- <tag:dateInput reg='{"dependOn":"traumaHistory_Flag2","required":true}' onlypast="true" name="PersonalBasicInfoDTO.traumaHistoryList[${idx.index}].opsDate" date="${traumaHistory.opsDate}" style="width:90px"/> --%>
												 <input type="text" reg='{"dependOn":"traumaHistory_Flag2","required":true}' class="layui-input x-admin-content-sm-date datetime" name="PersonalBasicInfoDTO.traumaHistoryList[${idx.index}].opsDate" value="<fmt:formatDate value='${traumaHistory.opsDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width:90px;" />
												 &emsp;</span>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</span>
								</td>
							</tr>
							<tr>
								<th style="width: 13%;vertical-align: top;text-align: right;">输血</th>
								<td>
									<label><input class="flag" type="radio" name="PersonalBasicInfoDTO.transBloodHistoryFlag" id="transBloodHistory_Flag1" value="1" ${PersonalBasicInfoDTO.transBloodHistoryFlag eq '1' || PersonalBasicInfoDTO.transBloodHistoryFlag eq null ? 'checked=checked' : ''}/> 无</label>
									<label><input class="flag selectedInputFlag" type="radio" name="PersonalBasicInfoDTO.transBloodHistoryFlag" id="transBloodHistory_Flag2" value="2" ${PersonalBasicInfoDTO.transBloodHistoryFlag eq '2' ? 'checked=checked' : ''}/> 有</label>
									<span id="transBloodHistorySpan" style="display:${PersonalBasicInfoDTO.transBloodHistoryFlag eq '2' ? 'inline' : 'none'}">
										<a id="addBloodHistory" href="javascript:void(0)" >增加</a>
										<a id="delBloodHistory" href="javascript:void(0)" >删除</a>
										<c:set scope="request" value="${fn:length(PersonalBasicInfoDTO.transBloodHistoryList)}" var="bloodSize"></c:set>
										<input id="bloSize" type="hidden" value="${bloodSize}"/>
										<c:forEach items="${PersonalBasicInfoDTO.transBloodHistoryList}" var="transBloodHistory" varStatus="idx">
											<br/>
											<c:choose>
												<c:when test="${idx.index == bloodSize - 1}">
													<span>原因 <input style="width: 25%" reg='{"dependOn":"transBloodHistory_Flag2","required":"true","maxlength":"33"}' type="text" class="ap_req_value_input" name="PersonalBasicInfoDTO.transBloodHistoryList[${idx.index}].bloodReason" value="${transBloodHistory.bloodReason}"/>
													&emsp;
													 时间<%-- <tag:dateInput reg='{"dependOn":"transBloodHistory_Flag2","required":true}' onlypast="true" name="PersonalBasicInfoDTO.transBloodHistoryList[${idx.index}].bloodDate" date="${transBloodHistory.bloodDate}" style="width:90px"/> --%>
													<input type="text" reg='{"dependOn":"transBloodHistory_Flag2","required":true}' class="layui-input x-admin-content-sm-date datetime" name="PersonalBasicInfoDTO.transBloodHistoryList[${idx.index}].bloodDate" value="<fmt:formatDate value='${transBloodHistory.bloodDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width:90px;" />
													&emsp;</span>
												</c:when>
												<c:otherwise>
													 <span>原因 <input style="width: 25%" reg='{"dependOn":"transBloodHistory_Flag2","required":"true","maxlength":"33"}' type="text" class="ap_req_value_input" name="PersonalBasicInfoDTO.transBloodHistoryList[${idx.index}].bloodReason" value="${transBloodHistory.bloodReason}"/>
													&emsp;
													 时间<%-- <tag:dateInput reg='{"dependOn":"transBloodHistory_Flag2","required":true}' onlypast="true" name="PersonalBasicInfoDTO.transBloodHistoryList[${idx.index}].bloodDate" date="${transBloodHistory.bloodDate}" style="width:90px"/> --%>
													<input type="text" reg='{"dependOn":"transBloodHistory_Flag2","required":true}' class="layui-input x-admin-content-sm-date datetime" name="PersonalBasicInfoDTO.transBloodHistoryList[${idx.index}].bloodDate" value="<fmt:formatDate value='${transBloodHistory.bloodDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width:90px;" />
													&emsp;</span>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</span>
								</td>
							</tr>
						</table>
					</fieldset>
				</div>
				<div class="postdiv">
					<fieldset class="layui-elem-field">
						<c:if test="${isAdult || isElder eq '1'}">
							<legend><label class="required">家族史</label></legend>
						</c:if>
						<c:if test="${isNotAdult}">
							<legend>家族史</legend>
						</c:if>
						<table class="posttable">
							<tr>
								<th style="width: 13%;vertical-align: top;text-align: right;">父亲</th>
								<td colspan="5">
									<label><input class="flag" type="radio" name="PersonalBasicInfoDTO.fatherFlag" id="father_Flag1" value="1" ${PersonalBasicInfoDTO.fatherFlag eq '1' || PersonalBasicInfoDTO.fatherFlag eq null ? 'checked=checked' : ''}/> 无</label>
									<label><input class="flag selectedFlag" type="radio" name="PersonalBasicInfoDTO.fatherFlag" id="father_Flag2" value="2" ${PersonalBasicInfoDTO.fatherFlag eq '2' ? 'checked=checked' : ''}/> 有</label>
									<span id="fatherSpan" style="display:${PersonalBasicInfoDTO.fatherFlag eq '2' ? 'inline' : 'none'}">
								<br />
								<ehr:dic-checkbox onchange="toggleOtherCK('PersonalBasicInfoDTO.fatherStr','fatherStrDescSpan',99);" dicmeta="FS10240" reg='{"dependOn":"father_Flag2","required":"true"}' name="PersonalBasicInfoDTO.fatherStr" value="${PersonalBasicInfoDTO.fatherStr}" />
								<span id="fatherStrDescSpan">
								<input type="text" style="width: 30%" reg="{'required':true}" name="PersonalBasicInfoDTO.fatherStrDesc" value="${PersonalBasicInfoDTO.fatherStrDesc}"/>
								</span>
							</span>
								</td>
							</tr>
							<tr>
								<th style="width: 13%;vertical-align: top;text-align: right;">母亲</th>
								<td colspan="5">
									<label><input class="flag" type="radio" name="PersonalBasicInfoDTO.motherFlag" id="mother_Flag1" value="1" ${PersonalBasicInfoDTO.motherFlag eq '1' || PersonalBasicInfoDTO.motherFlag eq null ? 'checked=checked' : ''}/> 无</label>
									<label><input class="flag selectedFlag" type="radio" name="PersonalBasicInfoDTO.motherFlag" id="mother_Flag2" value="2" ${PersonalBasicInfoDTO.motherFlag eq '2' ? 'checked=checked' : ''}/> 有</label>
									<span id="motherSpan" style="display:${PersonalBasicInfoDTO.motherFlag eq '2' ? 'inline' : 'none'}">
								<br />
								<ehr:dic-checkbox onchange="toggleOtherCK('PersonalBasicInfoDTO.motherStr','motherStrDescSpan',99);" dicmeta="FS10240" reg='{"dependOn":"mother_Flag2","required":"true"}' name="PersonalBasicInfoDTO.motherStr" value="${PersonalBasicInfoDTO.motherStr}"></ehr:dic-checkbox>
							    <span id="motherStrDescSpan">
								<input id="motherStrDesc" reg="{'required':true}" style="width: 30%" type="text" name="PersonalBasicInfoDTO.motherStrDesc" value="${PersonalBasicInfoDTO.motherStrDesc}"/>
								</span>
							</span>
								</td>
							</tr>
							<tr>
								<th style="width: 13%;vertical-align: top;text-align: right;">兄妹</th>
								<td colspan="5">
									<label><input class="flag" type="radio" name="PersonalBasicInfoDTO.brotherFlag" id="brother_Flag1" value="1" ${PersonalBasicInfoDTO.brotherFlag eq '1' || PersonalBasicInfoDTO.brotherFlag eq null ? 'checked=checked' : ''}/> 无</label>
									<label><input class="flag selectedFlag" type="radio" name="PersonalBasicInfoDTO.brotherFlag" id="brother_Flag2" value="2" ${PersonalBasicInfoDTO.brotherFlag eq '2' ? 'checked=checked' : ''}/> 有</label>
									<span id="brotherSpan" style="display:${PersonalBasicInfoDTO.brotherFlag eq '2' ? 'inline' : 'none'}">
								<br />
								<ehr:dic-checkbox onchange="toggleOtherCK('PersonalBasicInfoDTO.brotherStr','brotherStrDescSpan',99);" dicmeta="FS10240" reg='{"dependOn":"brother_Flag2","required":"true"}' name="PersonalBasicInfoDTO.brotherStr" value="${PersonalBasicInfoDTO.brotherStr}"></ehr:dic-checkbox>
							    <span id="brotherStrDescSpan">
							    <input id="brotherStrDesc" reg="{'required':true}" style="width: 30%" type="text" name="PersonalBasicInfoDTO.brotherStrDesc" value="${PersonalBasicInfoDTO.brotherStrDesc}"/>
								</span>
							</span>
								</td>
							</tr>
							<tr>
								<th style="width: 13%;vertical-align: top;text-align: right;">子女</th>
								<td colspan="5">
									<label><input class="flag" type="radio" name="PersonalBasicInfoDTO.childFlag" id="child_Flag1" value="1" ${PersonalBasicInfoDTO.childFlag eq '1' || PersonalBasicInfoDTO.childFlag eq null ? 'checked=checked' : ''}/> 无</label>
									<label><input class="flag selectedFlag" type="radio" name="PersonalBasicInfoDTO.childFlag" id="child_Flag2" value="2" ${PersonalBasicInfoDTO.childFlag eq '2' ? 'checked=checked' : ''}/> 有</label>
									<span id="childSpan" style="display:${PersonalBasicInfoDTO.childFlag eq '2' ? 'inline' : 'none'}">
								<br />
								<ehr:dic-checkbox onchange="toggleOtherCK('PersonalBasicInfoDTO.childStr','childStrDescSpan',99);" dicmeta="FS10240" reg='{"dependOn":"child_Flag2","required":"true"}' name="PersonalBasicInfoDTO.childStr" value="${PersonalBasicInfoDTO.childStr}"></ehr:dic-checkbox>
							    <span id="childStrDescSpan">
								<input id="childStrDesc" reg="{'required':true}" style="width: 30%" type="text" name="PersonalBasicInfoDTO.childStrDesc" value="${PersonalBasicInfoDTO.childStrDesc}"/>
							    </span>
							</span>
								</td>
							</tr>
						</table>
					</fieldset>
				</div>
			</div>

			<div class="postdiv">
				<fieldset class="layui-elem-field">
					<table class="posttable">
						<tr>
							<c:if test="${isAdult || isElder eq '1'}">
								<th style="width: 13%;vertical-align: top;text-align: right;"><label class="required">遗传病史</label></th>
							</c:if>
							<c:if test="${isNotAdult}">
								<th style="width: 13%;vertical-align: top;text-align: right;">遗传病史</th>
							</c:if>
							<td colspan="5">
								<label><input class="flag" type="radio" name="PersonalBasicInfoDTO.familyHeredityHistoryFlag" id="familyHeredityHistory_Flag1" value="1" ${PersonalBasicInfoDTO.familyHeredityHistoryFlag eq '1' || PersonalBasicInfoDTO.familyHeredityHistoryFlag eq null ? 'checked=checked' : ''}/> 无</label>
								<label><input class="flag selectedInputFlag" type="radio" name="PersonalBasicInfoDTO.familyHeredityHistoryFlag" id="familyHeredityHistory_Flag2" value="2" ${PersonalBasicInfoDTO.familyHeredityHistoryFlag eq '2' ? 'checked=checked' : ''}/> 有</label>
								<span id="familyHeredityHistorySpan" style="display:${PersonalBasicInfoDTO.familyHeredityHistoryFlag eq '2' ? 'inline' : 'none'}">
								<a id="addFamilyHeredityHistory" href="javascript:void(0)" >增加</a>
								<a id="delFamilyHeredityHistory" href="javascript:void(0)" >删除</a>
								<c:set scope="request" value="${fn:length(PersonalBasicInfoDTO.familyHeredityHistoryList)}" var="familyHereditySize"></c:set>
								<input id="familyHereditySize" type="hidden" value="${familyHereditySize}"/>
								<c:forEach items="${PersonalBasicInfoDTO.familyHeredityHistoryList}" var="familyHeredityHistory" varStatus="idx">
									<br/>
									<c:choose>
										<c:when test="${idx.index == familyHereditySize - 1}">
											<span>疾病名称 <input style="width: 24%" reg='{"dependOn":"familyHeredityHistory_Flag2","required":"true","maxlength":"33"}'  type="text" class="ap_req_value_input" name="PersonalBasicInfoDTO.familyHeredityHistoryList[${idx.index}].heredityhistory" value="${familyHeredityHistory.heredityhistory}"/> &emsp;</span>
										</c:when>
										<c:otherwise>
											<span>疾病名称 <input style="width: 24%" reg='{"dependOn":"familyHeredityHistory_Flag2","required":"true","maxlength":"33"}'  type="text" class="ap_req_value_input" name="PersonalBasicInfoDTO.familyHeredityHistoryList[${idx.index}].heredityhistory" value="${familyHeredityHistory.heredityhistory}"/> &emsp;</span>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</span>
							</td>
						</tr>
						<tr>
							<c:if test="${isAdult || isElder eq '1'}">
								<th style="width: 13%;vertical-align: top;text-align: right;"><label class="required">残疾情况</label></th>
							</c:if>
							<c:if test="${isNotAdult}">
								<th style="width: 13%;vertical-align: top;text-align: right;">残疾情况</th>
							</c:if>
							<td colspan="5">
								<label><input class="flag" type="radio" name="PersonalBasicInfoDTO.deformityHistory.deformityFlag" id="deformity_Flag1" value="1" ${PersonalBasicInfoDTO.deformityFlag eq '1' || PersonalBasicInfoDTO.deformityFlag eq null ? 'checked=checked' : ''}/> 无</label>
								<label><input class="flag selectedFlag" type="radio" name="PersonalBasicInfoDTO.deformityHistory.deformityFlag" id="deformity_Flag2" value="2" ${PersonalBasicInfoDTO.deformityFlag eq '2' ? 'checked=checked' : ''}/> 有</label>
								<span id="deformitySpan" style="display:${PersonalBasicInfoDTO.deformityFlag eq '2' ? 'inline' : 'none'}">
								<label><input type="checkbox" reg='{"extension":["deformityVali","请至少选择一项"]}' name="PersonalBasicInfoDTO.deformityHistory.visionDeformity" value="1" ${PersonalBasicInfoDTO.deformityHistory.visionDeformity eq '1' ? 'checked=checked' : ''}/>视力残疾</label>
								<label><input type="checkbox" reg='{"extension":["deformityVali","请至少选择一项"]}' name="PersonalBasicInfoDTO.deformityHistory.hearingDeformity" value="1" ${PersonalBasicInfoDTO.deformityHistory.hearingDeformity eq '1' ? 'checked=checked' : ''}/>听力残疾</label>
								<label><input type="checkbox" reg='{"extension":["deformityVali","请至少选择一项"]}' name="PersonalBasicInfoDTO.deformityHistory.speechDeformity" value="1" ${PersonalBasicInfoDTO.deformityHistory.speechDeformity eq '1' ? 'checked=checked' : ''}/>言语残疾</label>
								<label><input type="checkbox" reg='{"extension":["deformityVali","请至少选择一项"]}' name="PersonalBasicInfoDTO.deformityHistory.limbDeformity" value="1" ${PersonalBasicInfoDTO.deformityHistory.limbDeformity eq '1' ? 'checked=checked' : ''}/>肢体残疾</label>
								<label><input type="checkbox" reg='{"extension":["deformityVali","请至少选择一项"]}' name="PersonalBasicInfoDTO.deformityHistory.intellectDeformity" value="1" ${PersonalBasicInfoDTO.deformityHistory.intellectDeformity eq '1' ? 'checked=checked' : ''}/>智力残疾</label>
								<label><input type="checkbox" reg='{"extension":["deformityVali","请至少选择一项"]}' name="PersonalBasicInfoDTO.deformityHistory.mindDeformity" value="1" ${PersonalBasicInfoDTO.deformityHistory.mindDeformity eq '1' ? 'checked=checked' : ''}/>精神残疾</label>
								<label><input type="checkbox" id="deformityHistoryOther" onclick="util.clickShowText(this,'deformityHistoryDesc')" reg='{"extension":["deformityVali","请至少选择一项"]}' name="PersonalBasicInfoDTO.deformityHistory.other" value="1" ${PersonalBasicInfoDTO.deformityHistory.other eq '1' ? 'checked' : ''}/>其他残疾</label>
								<input id="deformityHistoryDesc" style="width: 150px;" CLASS="hidediv" reg='{"dependOn":"PersonalBasicInfoDTO.deformityHistory.other","dependValue":"1","required":"true","maxlength":"33"}' type="text" name="PersonalBasicInfoDTO.deformityHistory.otherDesc" ${PersonalBasicInfoDTO.deformityHistory.otherDesc eq '1'} value="${PersonalBasicInfoDTO.deformityHistory.otherDesc}" >
							</span>
							</td>
						</tr>
					</table>
				</fieldset>
				<fieldset class="layui-elem-field">
					<legend title="农村地区在建立居民健康档案时需根据实际情况选择填写此项。">生活环境*<font color="red">农村地区必填</font></legend>
					<table class="posttable">
						<tr>
							<th style="width: 13%;text-align: right;">厨房排风设施</th>
							<td>
								<ehr:dic-radio dicmeta="CV0300302" name="PersonalBasicInfoDTO.personInfo.outWindType" value="${PersonalBasicInfoDTO.personInfo.outWindType}"/>
							</td>
						</tr>
						<tr>
							<th style="width: 13%;text-align: right;">燃料类型</th>
							<td>
								<ehr:dic-radio dicmeta="CV0300303" name="PersonalBasicInfoDTO.personInfo.fuel" value="${PersonalBasicInfoDTO.personInfo.fuel}"/>
							</td>
						</tr>
						<tr>
							<th style="width: 13%;text-align: right;">饮水</th>
							<td>
								<ehr:dic-radio dicmeta="CV0300115" name="PersonalBasicInfoDTO.personInfo.water" value="${PersonalBasicInfoDTO.personInfo.water}"/>
							</td>
						</tr>
						<tr>
							<th style="width: 13%;text-align: right;">厕所</th>
							<td>
								<ehr:dic-radio dicmeta="CV0300304" name="PersonalBasicInfoDTO.personInfo.hastoilet" value="${PersonalBasicInfoDTO.personInfo.hastoilet}"/>
							</td>
						</tr>
						<tr>
							<th style="width: 13%;text-align: right;">禽畜栏</th>
							<td>
								<ehr:dic-radio dicmeta="FS10015" name="PersonalBasicInfoDTO.personInfo.fowlType" value="${PersonalBasicInfoDTO.personInfo.fowlType}"/>
							</td>
						</tr>
					</table>
					<%--</fieldset>
				</div>--%>
			</div>
		</div>
	</form>
</div>
<div id="mbglk" class="div-basic"></div>

<script type="text/javascript">
	layui.use('laydate', function(){
		var laydate = layui.laydate;

		laydate.render({
			elem: '#birthday'
			,format: 'yyyy/MM/dd'
			,max:0
			, trigger: 'click'
		});

		laydate.render({
			elem: '#lastMenstrualDateId'
			,format: 'yyyy/MM/dd'
			,max:0
			, trigger: 'click'
		});

		laydate.render({
			elem: '#estimatedDueDateId'
			,format: 'yyyy/MM/dd'
			, trigger: 'click'
		});

		laydate.render({
			elem: '#PersonalBasicInfoDTOGxyDateId'
			,format: 'yyyy/MM/dd'
			,max:0
			, trigger: 'click'
			,done:function(value,date) {
				if(!$.isEmpty(value)){
					$("#PersonalBasicInfoDTOGxyDateId").removeClass("lose");
				}else{
					$("#PersonalBasicInfoDTOGxyDateId").addClass("lose");
				}
			}
		});


		laydate.render({
			elem: '#PersonalBasicInfoDTOTnbDateId'
			,format: 'yyyy/MM/dd'
			,max:0
			, trigger: 'click'
			,done:function(value,date) {
				if(!$.isEmpty(value)){
					$("#PersonalBasicInfoDTOTnbDateId").removeClass("lose");
				}else{
					$("#PersonalBasicInfoDTOTnbDateId").addClass("lose");
				}
			}
		});

		laydate.render({
			elem: '#PersonalBasicInfoDTOGxbDateId'
			,format: 'yyyy/MM/dd'
			,max:0
			, trigger: 'click'
			,done:function(value,date) {
				if(!$.isEmpty(value)){
					$("#PersonalBasicInfoDTOGxbDateId").removeClass("lose");
				}else{
					$("#PersonalBasicInfoDTOGxbDateId").addClass("lose");
				}
			}
		});

		laydate.render({
			elem: '#PersonalBasicInfoDTOFjbDateId'
			,format: 'yyyy/MM/dd'
			,max:0
			, trigger: 'click'
			,done:function(value,date) {
				if(!$.isEmpty(value)){
					$("#PersonalBasicInfoDTOFjbDateId").removeClass("lose");
				}else{
					$("#PersonalBasicInfoDTOFjbDateId").addClass("lose");
				}
			}
		});

		laydate.render({
			elem: '#PersonalBasicInfoDTONzzDateId'
			,format: 'yyyy/MM/dd'
			,max:0
			, trigger: 'click'
			,done:function(value,date) {
				if(!$.isEmpty(value)){
					$("#PersonalBasicInfoDTONzzDateId").removeClass("lose");
				}else{
					$("#PersonalBasicInfoDTONzzDateId").addClass("lose");
				}
			}
		});


		laydate.render({
			elem: '#PersonalBasicInfoDTOExzlDateId'
			,format: 'yyyy/MM/dd'
			,max:0
			, trigger: 'click'
			,done:function(value,date) {
				if(!$.isEmpty(value)){
					$("#PersonalBasicInfoDTOExzlDateId").removeClass("lose");
				}else{
					$("#PersonalBasicInfoDTOExzlDateId").addClass("lose");
				}
			}
		});

		laydate.render({
			elem: '#PersonalBasicInfoDTOZxjsbDateId'
			,format: 'yyyy/MM/dd'
			,max:0
			, trigger: 'click'
			,done:function(value,date) {
				if(!$.isEmpty(value)){
					$("#PersonalBasicInfoDTOZxjsbDateId").removeClass("lose");
				}else{
					$("#PersonalBasicInfoDTOZxjsbDateId").addClass("lose");
				}
			}
		});

		laydate.render({
			elem: '#PersonalBasicInfoDTOJhbDateId'
			,format: 'yyyy/MM/dd'
			,max:0
			, trigger: 'click'
			,done:function(value,date) {
				if(!$.isEmpty(value)){
					$("#PersonalBasicInfoDTOJhbDateId").removeClass("lose");
				}else{
					$("#PersonalBasicInfoDTOJhbDateId").addClass("lose");
				}
			}
		});

		laydate.render({
			elem: '#PersonalBasicInfoDTOGyDateId'
			,format: 'yyyy/MM/dd'
			,max:0
			, trigger: 'click'
			,done:function(value,date) {
				if(!$.isEmpty(value)){
					$("#PersonalBasicInfoDTOGyDateId").removeClass("lose");
				}else{
					$("#PersonalBasicInfoDTOGyDateId").addClass("lose");
				}
			}
		});

		laydate.render({
			elem: '#PersonalBasicInfoDTOQtidmDateId'
			,format: 'yyyy/MM/dd'
			,max:0
			, trigger: 'click'
			,done:function(value,date) {
				if(!$.isEmpty(value)){
					$("#PersonalBasicInfoDTOQtidmDateId").removeClass("lose");
				}else{
					$("#PersonalBasicInfoDTOQtidmDateId").addClass("lose");
				}
			}
		});

		laydate.render({
			elem: '#PersonalBasicInfoDTOZybDateId'
			,format: 'yyyy/MM/dd'
			,max:0
			, trigger: 'click'
			,done:function(value,date) {
				if(!$.isEmpty(value)){
					$("#PersonalBasicInfoDTOZybDateId").removeClass("lose");
				}else{
					$("#PersonalBasicInfoDTOZybDateId").addClass("lose");
				}
			}
		});

		laydate.render({
			elem: '#PersonalBasicInfoDTOQtDateId'
			,format: 'yyyy/MM/dd'
			,max:0
			,done:function(value,date) {
				if(!$.isEmpty(value)){
					$("#PersonalBasicInfoDTOQtDateId").removeClass("lose");
				}else{
					$("#PersonalBasicInfoDTOQtDateId").addClass("lose");
				}
			}
		});

		laydate.render({
			elem: '#PersonalBasicInfoDTOQtDateId'
			,format: 'yyyy/MM/dd'
			,max:0
			, trigger: 'click'
			,done:function(value,date) {
				if(!$.isEmpty(value)){
					$("#PersonalBasicInfoDTOQtDateId").removeClass("lose");
				}else{
					$("#PersonalBasicInfoDTOQtDateId").addClass("lose");
				}
			}
		});
	});


</script>
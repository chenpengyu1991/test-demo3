<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ZKTfinger/js/readcard/baseISSObject.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ZKTfinger/js/readcard/baseISSOnline.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ZKTfinger/js/readcard/common.js"></script>
<link href="${pageContext.request.contextPath}/js/fineuploader/fineuploader-3.4.1.css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/fineuploader/jquery.fineuploader-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}/js/views/he/upload/upload.js" type="text/javascript"></script>

<script type="text/javascript">
    $(document).ready(function() {
        healthEducationUpload.uploadFile("cdmCardHyperFile", "/he/upload/uploadFile/mbglkgxy", "/he/upload/deleteFile/mbglkgxy"); // 高血压
        healthEducationUpload.uploadFile("cdmCardDiabeteFile", "/he/upload/uploadFile/mbglktnb", "/he/upload/deleteFile/mbglktnb"); // 糖尿病
    });
</script>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<c:set var="JKMBK" value="<%=RoleType.JKMBK.getValue()%>"/>
<c:set var="YYMB" value="<%=RoleType.YYMB.getValue()%>"/>
<c:set var="ZXMB" value="<%=RoleType.ZXMB.getValue()%>"/>
<c:set var="ZMB" value="<%=RoleType.ZMB.getValue()%>"/>
<p id="cert_message" class="msgError" style="display: none;"></p>
<p id="cert_message_type" style="display: none;"></p>
<form id="report-input-form">
	<c:if test="${hospitalaReport ==true}">
		<input type="hidden" id="report-result" name='report-result' value="-1" />
		<input type="hidden"  name="hosReportRecordId" value="${reportInfo.hosReportRecordId}">
	</c:if>
	<input type="hidden" id="cdm_report_personId" name="personId" value="${personInfo.id}">
	<input type="hidden" id="cdm_person_personId"  name="personInfo.personId" value="${personInfo.id}">
	<div class="postcontent">
		<i class="popno">慢病上报</i>
		<div class="postdiv">
			<fieldset class="layui-elem-field">

				<legend>基本信息</legend>
				<table class="posttable">
					<colgroup>
						<col style="width: 15%;min-width:100px;" />
						<col style="width: 35%;min-width:200px;" />
						<col style="width: 15%;min-width:100px;" />
						<col style="width: 35%;min-width:200px;" />
					</colgroup>
					<tr>
						<th><label for="cdm_report_idcard">身份证</label></th>
						<td>
							<c:choose>
								<c:when test="${hospitalaReport ==true}">
									<input ${personInfo.idcard !=null and personInfo.idcard !='' ? 'readonly="readonly"' :'' } type="text"  id="cdm_report_idcard" name="personInfo.idcard" value="${personInfo.idcard}" reg='{"idCard":true}'  />
								</c:when>
								<c:otherwise>
									<input type="text" id="cdm_report_idcard" name="personInfo.idcard" value="${personInfo.idcard}" reg='{"idCard":true}' placeholder="输入身份证获取人员信息" class="x-layui-input"/>
								</c:otherwise>
							</c:choose>
							<input type="button" id="button_read" value="读卡" onclick="new Device().startFun()">
						</td>
						<th><label class="required" for="cdm_report_name">姓名</label></th>
						<td><input type="text" id="cdm_report_name" name="personInfo.name" value="${personInfo.name}" reg="{'required':true,'maxlength':16}" class="x-layui-input" /></td>
					</tr>
					<tr>
						<th><label class="required" class="required" for="birthday">出生日期</label></th>
						<td>
						<%-- <tag:dateInput name="personInfo.birthday" id="birthday" onlypast="true" reg="{'required':true}" date="${personInfo.birthday}" /> --%>
						<input type="text" class="layui-input x-admin-content-sm-date" reg="{'required':true}" placeholder="选择日期" name="personInfo.birthday" id="birthday" value="<fmt:formatDate value='${personInfo.birthday}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
						</td>
						<th><label class="required" class="required">性别</label></th>
						<td><ehr:dic-radio id="gender" uninclude="0,9" dicmeta="GBT226112003" name="personInfo.gender" value="${personInfo.gender}" reg="{'required':true}" /></td>
					</tr>
					<tr>
						<th><label class="required" for="marriage">婚姻</label></th>
						<td><ehr:dic-list dicmeta="GBT226122003" id="marriage" width="180px;"  name="personInfo.marriage" value="${personInfo.marriage}" reg="{'required':true}" /></td>
						<th><label class="required" for="occupation">职业</label></th>
						<td><ehr:dic-list dicmeta="GBT6565" width="180px;" code="0,1/2,3,4,5,6/7/8/9,X,Y,CV00031"  value="${personInfo.occupation}" id="occupation" name="personInfo.occupation" reg="{'required':true}" /></td>
					</tr>
					<tr>
						<th><label class="required" for="nation">民族</label></th>
						<td>
							<label><input type="radio" reg='{"required":true}' onclick="util.clickHideText(this,'otherNationDesc')" name="personInfo.nation" ${personInfo.nation eq"01" ?"checked":""} value="01" /> 汉族</label>
							<label><input type="radio" reg='{"required":true}' onclick="util.clickShowText(this,'otherNationDesc')" name="personInfo.nation" ${(personInfo.nation ne "1" && not empty personInfo.nation && personInfo.nation ne"01") ?"checked":""} value="99" /> 少数民族</label>
							<input type="text" id="otherNationDesc" class="hidediv" name="personInfo.otherNationDesc" value="${othermz==null?personInfo.otherNationDesc:othermz}" reg='{"required":"true"}' style="width: 70px;" class="x-layui-input" />
                            <input type="hidden" id="nationText" value="<ehr:dic code="${personInfo.nation}" dicmeta="GBT3304"/>"/>
						</td>
						<th><label class="required" for="education">文化程度</label></th>
						<td><ehr:dic-list dicmeta="GBT46582006" width="180px;" code="IDM17,20,IDM18,IDM19,IDM20,IDM21,IDM02,IDM07,IDM22,IDM10"   value="${personInfo.education}" id="education" name="personInfo.education" reg="{'required':true}" /></td>
					</tr>

					<tr>
						<th><label class="required" for="phoneNumber">电话</label></th>
						<td><input id="phoneNumber" type="text" name="personInfo.phoneNumber" value="${personInfo.phoneNumber}" reg="{'required':true,'regex':'phone'}" class="x-layui-input" /></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<th><label class="required">常住类型</label></th>
						<td><ehr:dic-radio reg="{'required':true}" dicmeta="FS10005" name="personInfo.householdType"
										   value='${personInfo.householdType}' 
						/></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<th><label class="required">现地址</label></th>
						<td colspan="3">
							<ehr:dic-town-street-village townName="personInfo.patownShip" streetName="personInfo.pastreet" villageName="personInfo.paGroup"
														 townId="pacounty" streetId="patownShip" villageId="pastreet" townValue="${personInfo.patownShip}" streetValue="${personInfo.pastreet}" villageValue="${personInfo.paGroup}"
														 width="180px" reg="{'required':true}" />
							<br/>
						</td>
					</tr>
					<tr>
						<th>现住址补充信息：</th>
						<td colspan="3">
							<label id="text_pahouseNumber_prefix">${orgPaName}${orgPaNamePastreet}<ehr:dic code="${personInfo.paGroup}" dicmeta="FS990001"/></label><br/>
							<textarea id="pahouseNumber"  name="personInfo.pahouseNumber" rows="1" placeholder="如无门牌号等详细信息此空则不用填写任何文字，如有门牌号码等详细信息请在此处手动填写，不再重复上方地址信息" class="x-layui-input" >${personInfo.pahouseNumber}</textarea>
							<%--<input type="text" placeholder="如无门牌号等详细信息，此空则不用填写任何文字，如有门牌号码等详细信息请在此处手动填写，不再重复上方地址信息" id="text_pahouseNumber" reg='{"required":true,"maxlength":50}'   name="PersonInfoDTO.personInfo.pahouseNumber" value="${personInfo.pahouseNumber}"/>--%>
						</td>
					</tr>
					<tr class="${'1' eq personInfo.householdType || empty personInfo.householdType ? '':'hide' }" id="hr-address-select">
						<th><label class="required">户籍地址</label></th>
						<td colspan="3">
							<div >
								<ehr:dic-town-street-village
										villageId="hrstreet" townId="hrcounty" streetId="hrtownShip"
										villageName="personInfo.hrGroup" streetName="personInfo.hrstreet"
										townName="personInfo.hrtownShip" streetValue="${personInfo.hrstreet}"
										villageValue="${personInfo.hrGroup}" 
										townValue="${personInfo.hrtownShip}" width="180px;" reg="{'dependOn':'personInfo.householdType','dependValue':'1','required':true}"/>
							</div>
						</td>
					</tr>
					<tr>
						<th>户籍地址补充信息：</th>
						<td colspan="3">
							<span id="text_hrhouseNumber_prefix"></span><br/>
							<textarea id="hrhouseNumber" name="personInfo.hrhouseNumber" rows="1" placeholder="如无门牌号等详细信息此空则不用填写任何文字，如有门牌号码等详细信息请在此处手动填写，不再重复上方地址信息" class="x-layui-input" >${personInfo.hrhouseNumber}</textarea>
						</td>
					</tr>
					<tr>
						<th><label  for="unitName">工作单位</label></th>
						<td><input type="text" id="unitName" name="personInfo.unitName" value="${personInfo.unitName}" reg="{'maxlength':46}" class="x-layui-input" /></td>
						<th>健康档案管理单位</th>
						<td>
							<input type="text" id="inputOrganName" readonly="readonly" name="personInfo.inputOrganName" class="x-layui-input" value="${personInfo.inputOrganName}" />
							<input type="hidden" id="inputOrganCode" name="personInfo.inputOrganCode" value="${personInfo.inputOrganCode}" /></td>
					</tr>
				</table>
			</fieldset>
			<fieldset class="${hospitalaReport==true?'hide' :'show'} layui-elem-field">
				<legend>选报慢病</legend>
				<div id="dis-select-box">
					<c:if test="${reportAbledFlags[4]}">
						<input type="checkbox" class="report-dis-switch" value="1" name="hbpFlag" ${reportInfo.hbpFlag eq '1' ? 'checked=true':''}>高血压
					</c:if>
					<c:if test="${reportAbledFlags[0]}">
						<input type="checkbox" class="report-dis-switch" value="1" name="diFlag" ${reportInfo.diFlag eq '1' ?'checked=true':''}>
						<label>糖尿病</label>
					</c:if>
					<c:if test="${reportAbledFlags[1]}">
						<input type="checkbox" class="report-dis-switch" value="1" name="coronaryFlag" ${reportInfo.coronaryFlag eq '1' ? 'checked=true':''}>冠心病
					</c:if>
					<c:if test="${reportAbledFlags[2]}">
						<input type="checkbox" class="report-dis-switch" value="1" name="strokeFlag" ${reportInfo.strokeFlag eq '1' ? 'checked=true':''}>
						<label>脑卒中</label>
					</c:if>
					<c:if test="${reportAbledFlags[3]}">
						<input type="checkbox" class="report-dis-switch" value="1" name="tumorFlag" ${reportInfo.tumorFlag eq '1' ? 'checked=true':''}>肿瘤
					</c:if>
				</div>
			</fieldset>
			<c:if test="${hospitalaReport !=true}">
				<ehr:authorize ifAnyGranted="${ZXMB},${JKMBK},${YYMB},${ZMB}">
					<fieldset class="layui-elem-field">
						<legend>报卡类型</legend>
						<div id="report-type-select-box">
							<input type="radio" class="report-type-switch" value="1" name="reportType" ${reportInfo.reportType !='2' ? 'checked=true':''}>
							<label>病例</label>
							<input type="radio" class="report-type-switch" value="2" name="reportType" ${reportInfo.reportType eq '2' ? 'checked=true':''}>
							<label>死亡</label>
						</div>
					</fieldset>

					<fieldset id="death-info-box" class="${reportInfo.reportType =='2' ? 'show' :'hide'} layui-elem-field" >
						<legend>死亡信息</legend>
						<table class="posttable">
							<colgroup>
								<col style="width: 15%;min-width:100px;" />
								<col style="width: 35%;min-width:200px;" />
								<col style="width: 15%;min-width:100px;" />
								<col style="width: 35%;min-width:200px;" />
							</colgroup>
							<tr>
								<th><label class="required" >死亡上报单位</label></th>
								<td><ehr:org-type-list id="deathReportOrganCode" type="hospital,centre"  width="250px" reg="{'required':true}" name="deathReportOrganCode" code=""  value="${reportInfo.deathReportOrganCode}"/>
								</td>
								<th><label class="required" >死亡日期</label></th>
								<td>
								<%-- <tag:dateInput onlypast="true"  name="deathDate" date="${reportInfo.deathDate}" reg="{'required':true}" /> --%>
								<input type="text" class="layui-input x-admin-content-sm-date" reg="{'required':true}" placeholder="选择日期" name="deathDate" id="deathDate" value="<fmt:formatDate value='${reportInfo.deathDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
								</td>
							</tr>
							<tr>
								<th><label class="required">死亡原因</label></th>
								<td colspan="3" ><input type="text" value="${reportInfo.deathReason}" name="deathReason" reg="{'required':true,'maxlength':100}" class="x-layui-input" /></td>
							</tr>
						</table>
					</fieldset>
				</ehr:authorize>
			</c:if>
			<c:if test="${reportAbledFlags[4]}">
				<div id="hbpFlag-box" class="${reportInfo.hbpFlag eq '1'?'show':'hide'}">
					<fieldset class="layui-elem-field">
						<legend>高血压<span style="color:red;"> (注：疾病信息录入后不可修改)</span></legend>
						<table class="posttable">
							<colgroup>
								<col style="width: 15%;min-width:100px;" />
								<col style="width: 35%;min-width:200px;" />
								<col style="width: 15%;min-width:100px;" />
								<col style="width: 35%;min-width:200px;" />
							</colgroup>
							<tr>
								<th><label class="required" for="hbpType2">高血压类型</label></th>
								<td>
										<%--27.   慢病管理-高血压报卡上报：只能报【原发性】的，继发性的去掉--%>
									<ehr:dic-list width="180px;" defaultval="true" dicmeta="DMD00006"  id="hbpType2" name="hbpType" value="${reportInfo.hbpType}" reg="{'required':true}" uninclude="2" />
								</td>
								<th><label class="required" for="hbpAccidentDate">发病日期</label></th>
								<td>
								<%-- <tag:dateInput onlypast="true" id="hbpAccidentDate" name="hbpAccidentDate" date="${reportInfo.hbpAccidentDate}" reg="{'required':true}" /> --%>
								<input type="text" class="layui-input x-admin-content-sm-date" reg="{'required':true}" placeholder="选择日期" name="hbpAccidentDate" id="hbpAccidentDate" value="<fmt:formatDate value='${reportInfo.hbpAccidentDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
								</td>
							</tr>
							<tr>
								<th><label class="required" for="hbpDiagnosisDate">诊断日期</label></th>
								<td style="vertical-align:top;">
								<%-- <tag:dateInput onlypast="true" id="hbpDiagnosisDate" name="hbpDiagnosisDate" date="${reportInfo.hbpDiagnosisDate}" reg='{"compare":["hbpAccidentDate","ge","诊断日期不能早于发病日期"]}' /> --%>
								<input type="text" class="layui-input x-admin-content-sm-date" reg='{"compare":["hbpAccidentDate","ge","诊断日期不能早于发病日期"]}' placeholder="选择日期" name="hbpDiagnosisDate" id="hbpDiagnosisDate" value="<fmt:formatDate value='${reportInfo.hbpDiagnosisDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
								</td>
								<th><label for="hbpDiagnosisDepends">诊断依据</label></th>
								<td><ehr:dic-list width="180px;"  type="true"  dicmeta="DMD00010"  id="hbpDiagnosisDepends" name="hbpDiagnosisDepends" value="${reportInfo.hbpDiagnosisDepends}" reg="{'maxlength':33}" /></td>
							</tr>
<%--							<tr id="hbpFlagTr" >--%>
<%--								<th><label class="required">高血压附件</label></th>--%>
<%--								<td colspan="3">--%>
<%--									<div id="cdmCardHyperFile"></div>--%>
<%--									<span style="color: red;">本附件需提供乡镇及乡镇以上医疗机构疾病诊断相关佐证材料（诊断证明、处方、病历、病案） </span><br/>--%>
<%--									<span style="color: blue;">注：单个附件请控制在2M之内,附件数量不能超过5个</span>--%>
<%--								</td>--%>
<%--							</tr>--%>
							<%-- <tr>
								<th>ICD-10编码</th>
								<td><input type="text" name="hbpIcdTenCode" value="${reportInfo.hbpIcdTenCode}" readonly="readonly"/></td>
							</tr> --%>
						</table>
					</fieldset>
				</div>
			</c:if>
			<div id="dis-info">
				<c:if test="${reportAbledFlags[0]}">
					<div id="diFlag-box" class="${reportInfo.diFlag eq '1'?'show':'hide'}">
						<fieldset class="layui-elem-field">
							<legend>糖尿病<span style="color:red;"> (注：疾病信息录入后不可修改)</span></legend>
							<table class="posttable">
								<colgroup>
									<col style="width: 15%;min-width:100px;" />
									<col style="width: 35%;min-width:200px;" />
									<col style="width: 15%;min-width:100px;" />
									<col style="width: 35%;min-width:200px;" />
								</colgroup>
								<tr>
									<th><label class="required" for="diType2">糖尿病类型</label></th>
									<td><ehr:dic-list width="180px;"  dicmeta="DMD00007"  id="diType2" name="diType" value="${reportInfo.diType}" reg="{'required':true}" code="2"/></td>
									<th><label class="required" for="diAccidentDate">发病日期</label></th>
									<td>
									<%-- <tag:dateInput onlypast="true" id="diAccidentDate" name="diAccidentDate" date="${reportInfo.diAccidentDate}" reg="{'required':true}" /> --%>
									<input type="text" class="layui-input x-admin-content-sm-date" reg="{'required':true}" placeholder="选择日期" name="diAccidentDate" id="diAccidentDate" value="<fmt:formatDate value='${reportInfo.diAccidentDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
									</td>
								</tr>
								<tr>
									<th><label class="required" for="diDiagnosisDate">诊断日期</label></th>
									<td style="vertical-align:top;">
									<%-- <tag:dateInput onlypast="true" id="diDiagnosisDate" name="diDiagnosisDate" reg='{"compare":["diAccidentDate","ge","诊断日期不能早于发病日期"]}' /> --%>
									<input type="text" class="layui-input x-admin-content-sm-date" reg='{"compare":["diAccidentDate","ge","诊断日期不能早于发病日期"]}' placeholder="选择日期" name="diDiagnosisDate" id="diDiagnosisDate"  style="padding-left: 0px;" value="<fmt:formatDate value='${reportInfo.diDiagnosisDate}' pattern='yyyy/MM/dd'/>"/>
									</td>
									<th><label for="diDiagnosisDepends">诊断依据</label></th>
									<td><ehr:dic-list width="180px;"  type="true"  dicmeta="DMD00010"  id="diDiagnosisDepends" name="diDiagnosisDepends" value="${reportInfo.diDiagnosisDepends}" reg="{'maxlength':33}" /></td>
								</tr>
<%--								<tr id="diFlagTr" >&lt;%&ndash;style="margin-top:10px;${reportInfo!=null&&reportInfo.diFlag eq '1'?'':'display: none;'}"&ndash;%&gt;--%>
<%--									<th><label class="required">糖尿病附件</label></th>--%>
<%--									<td colspan="3">--%>
<%--										<div id="cdmCardDiabeteFile"></div>--%>
<%--										<span style="color: red;">本附件需提供乡镇及乡镇以上医疗机构疾病诊断相关佐证材料（诊断证明、处方、病历、病案） </span><br/>--%>
<%--										<span style="color: blue;">注：单个附件请控制在2M之内,附件数量不能超过5个</span>--%>
<%--									</td>--%>
<%--								</tr>--%>
								<%-- <tr>
									<th>ICD-10编码</th>
									<td><input type="text" name="diIcdTenCode" value="${reportInfo.diIcdTenCode}" readonly="readonly"/></td>
								</tr> --%>
							</table>
						</fieldset>
					</div>
				</c:if>
				<c:if test="${reportAbledFlags[1]}">
					<div id="coronaryFlag-box" class="${reportInfo.coronaryFlag eq '1'?'show':'hide'}">
						<fieldset class="layui-elem-field">
							<legend>冠心病<span style="color:red;"> (注：疾病信息录入后不可修改)</span></legend>
							<table class="posttable">
								<colgroup>
									<col style="width: 15%;min-width:100px;" />
									<col style="width: 35%;min-width:200px;" />
									<col style="width: 15%;min-width:100px;" />
									<col style="width: 35%;min-width:200px;" />
								</colgroup>
								<tr>
									<th><label class="required" for="coronaryType">冠心病类型</label></th>
									<td><ehr:dic-list width="180px;"   dicmeta="DMD00008" id="coronaryType" name="coronaryType" value="${reportInfo.coronaryType}" reg="{'required':true}" /></td>
									<th><label class="required" for="coronaryAccidentDate">发病日期</label></th>
									<td>
									<%-- <tag:dateInput onlypast="true" id="coronaryAccidentDate" name="coronaryAccidentDate" date="${reportInfo.coronaryAccidentDate}" reg="{'required':true}" /> --%>
									<input type="text" class="layui-input x-admin-content-sm-date" reg="{'required':true}" placeholder="选择日期" name="coronaryAccidentDate" id="coronaryAccidentDate" value="<fmt:formatDate value='${reportInfo.coronaryAccidentDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
									</td>
								</tr>
								<tr>
									<th><label class="required" for="coronaryDiagnosisDate">诊断日期</label></th>
									<td style="vertical-align:top;">
									<%-- <tag:dateInput onlypast="true" id="coronaryDiagnosisDate" name="coronaryDiagnosisDate"  reg='{"compare":["coronaryAccidentDate","ge","诊断日期不能早于发病日期"]}' /> --%>
									<input type="text" class="layui-input x-admin-content-sm-date" reg='{"compare":["coronaryAccidentDate","ge","诊断日期不能早于发病日期"]}' placeholder="选择日期" name="coronaryDiagnosisDate" id="coronaryDiagnosisDate"  style="padding-left: 0px;" value="<fmt:formatDate value='${reportInfo.coronaryDiagnosisDate}' pattern='yyyy/MM/dd'/>"/>
									</td>
									<th><label for="coronaryDiagnosisDepends">诊断依据</label></th>
									<td><ehr:dic-list width="180px;"  type="true"  dicmeta="DMD00010" id="coronaryDiagnosisDepends" name="coronaryDiagnosisDepends" value="${reportInfo.coronaryDiagnosisDepends}"/></td>
								</tr>
								<%-- <tr>
									<th>ICD-10编码</th>
									<td><input type="text" name="coronaryIcdTenCode" value="${reportInfo.coronaryIcdTenCode}" readonly="readonly"/></td>
								</tr> --%>
							</table>
						</fieldset>
					</div>
				</c:if>
				<c:if test="${reportAbledFlags[2]}">
					<div id="strokeFlag-box" class="${reportInfo.strokeFlag eq '1'?'show':'hide'}">
						<fieldset class="layui-elem-field">
							<legend>脑卒中<span style="color:red;"> (注：疾病信息录入后不可修改)</span></legend>
							<table class="posttable">
								<colgroup>
									<col style="width: 15%;min-width:100px;" />
									<col style="width: 35%;min-width:200px;" />
									<col style="width: 15%;min-width:100px;" />
									<col style="width: 35%;min-width:200px;" />
								</colgroup>
								<tr>
									<th><label class="required" for="strokeType">脑卒中类型</label></th>
									<td><ehr:dic-list width="180px;"  dicmeta="DMD00009" id="strokeType" name="strokeType" value="${reportInfo.strokeType}" reg="{'required':true}" /></td>
									<th><label class="required" for="strokeAccidentDate">发病日期</label></th>
									<td>
									<%-- <tag:dateInput onlypast="true" id="strokeAccidentDate" name="strokeAccidentDate" date="${reportInfo.strokeAccidentDate}" reg="{'required':true}" /> --%>
									<input type="text" class="layui-input x-admin-content-sm-date" reg="{'required':true}" placeholder="选择日期" name="strokeAccidentDate" id="strokeAccidentDate" value="<fmt:formatDate value='${reportInfo.strokeAccidentDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
									</td>
								</tr>
								<tr>
									<th><label class="required" for="strokeDiagnosisDate">诊断日期</label></th>
									<td style="vertical-align:top;">
									<%-- <tag:dateInput onlypast="true" id="strokeDiagnosisDate" name="strokeDiagnosisDate"   reg='{"compare":["strokeAccidentDate","ge","诊断日期不能早于发病日期"]}' /> --%>
									<input type="text" class="layui-input x-admin-content-sm-date" reg='{"compare":["strokeAccidentDate","ge","诊断日期不能早于发病日期"]}' placeholder="选择日期" name="strokeDiagnosisDate" id="strokeDiagnosisDate"  style="padding-left: 0px;" value="<fmt:formatDate value='${reportInfo.strokeDiagnosisDate}' pattern='yyyy/MM/dd'/>"/>
									</td>
									<th><label for="strokeDiagnosisDepends">诊断依据</label></th>
									<td><ehr:dic-list width="180px;"  type="true"  dicmeta="DMD00010" id="strokeDiagnosisDepends" name="strokeDiagnosisDepends" value="${reportInfo.strokeDiagnosisDepends}" reg="{'maxlength':33}" />
									</td>
								</tr>
								<%-- <tr>
									<th>ICD-10编码</th>
									<td><input type="text" name="strokeIcdTenCode" value="${reportInfo.strokeIcdTenCode}" readonly="readonly"/></td>
								</tr> --%>
							</table>
						</fieldset>
					</div>
				</c:if>
				<c:if test="${reportAbledFlags[3]}">
					<div id="tumorFlag-box" class="${reportInfo.tumorFlag eq '1'?'show':'hide'}">
						<fieldset class="layui-elem-field">
							<legend>肿瘤<span style="color:red;"> (注：疾病信息录入后不可修改)</span></legend>
							<table class="posttable">
								<colgroup>
									<col style="width: 15%;min-width:100px;" />
									<col style="width: 35%;min-width:200px;" />
									<col style="width: 15%;min-width:100px;" />
									<col style="width: 35%;min-width:200px;" />
								</colgroup>
								<tr id="secondaryTrId" style="display: none">
									<input type="hidden" id="secondaryId" name="secondaryId" value="${reportInfo.secondaryId}"/>
									<th>是否继发</th>
									<td><input id="isSecondaryId" type="checkbox" value="1" name="isSecondary" ${reportInfo.isSecondary eq '1' ?'checked':''}/></td>
								</tr>
								<tr>
									<th><label class="required"  for="tumorIcd10Code">ICD-10编码</label></th>
									<td><input type="text" id="tumorIcd10Code" name="tumorIcdTenCode" value="${reportInfo.tumorIcdTenCode}" reg='{"required":true,"regex":"^C[0-9]{2}(\\.[a-zA-Z0-9]{1,3}([a-zA-Z0-9]|\\+)?)?$|^D[0-3][0-9](\\.[a-zA-Z0-9]{1,3}([a-zA-Z0-9]|\\+)?)?$|^D[4][0-8](\\.[a-zA-Z0-9]{1,3}([a-zA-Z0-9]|\\+)?)?$"}' tip="请输入正确的肿瘤icd10编码" /></td> 
									<th><label class="required" for="tumorType">肿瘤病名</label></th>
									<td><input type="text" id="tumorType" name="tumorType" value="${reportInfo.tumorType}" reg="{'required':true,'maxlength':50}" class="x-layui-input" /></td>

								</tr>
								<tr>

									<th><label class="required" for="tumorInformedFlag">知情状态标志</label></th>
									<td ><ehr:dic-list width="180px" dicmeta="PH00001"  id="tumorInformedFlag" name="tumorInformedFlag" value="${reportInfo.tumorInformedFlag}" reg="{'required':true}" /></td>

									<th><label for="tumorPrimaryPart">原发部位</label></th>
									<td><input type="text" id="tumorPrimaryPart" name="tumorPrimaryPart" value="${reportInfo.tumorPrimaryPart}" reg="{'maxlength':33}" class="x-layui-input" /></td>
								</tr>
								<tr>
									<th><label for="tumorMetastasisPart">转移部位</label></th>
									<td  style="vertical-align:top;"><input type="text" id="tumorMetastasisPart" name="tumorMetastasisPart" value="${reportInfo.tumorMetastasisPart}"
																			reg="{'maxlength':33}" class="x-layui-input"
									/></td>
									<th><label for="tumorDiagnosisDepends">诊断依据</label></th>
									<td><ehr:dic-list width="180px;"  type="true" dicmeta="DMD00010" id="tumorDiagnosisDepends" name="tumorDiagnosisDepends" value="${reportInfo.tumorDiagnosisDepends}"
													  reg="{'maxlength':33}"
									/></td>
								</tr>
								<tr>
									<th><label for="tumorPathologyType">病理类型</label></th>
									<td><input type="text" id="tumorPathologyType" name="tumorPathologyType" value="${reportInfo.tumorPathologyType}" reg="{'maxlength':16}" class="x-layui-input" /></td>
									<th><label for="tumorIcd03Code">ICD-0-3编码</label></th>
									<td><input type="text" id="tumorIcd03Code" name="tumorIcdThreeCode" value="${reportInfo.tumorIcdThreeCode}" reg="{'maxlength':8}" class="x-layui-input" /></td>
								</tr>
								<tr>
									<th><label class="required" for="tumorAccidentDate">发病日期</label></th>
									<td>
									<%-- <tag:dateInput onlypast="true" id="tumorAccidentDate" name="tumorAccidentDate" date="${reportInfo.tumorAccidentDate}" reg="{'required':true}" /> --%>
									<input type="text" class="layui-input x-admin-content-sm-date" reg="{'required':true}" placeholder="选择日期" name="tumorAccidentDate" id="tumorAccidentDate" value="<fmt:formatDate value='${reportInfo.tumorAccidentDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
									</td>
									<th><label class="required" for="tumorDiagnosisDate">诊断日期</label></th>
									<td>
									<%-- <tag:dateInput onlypast="true" id="tumorDiagnosisDate" name="tumorDiagnosisDate" reg='{"compare":["tumorAccidentDate","ge","诊断日期不能早于发病日期"]}' /> --%>
									<input type="text" class="layui-input x-admin-content-sm-date" reg='{"compare":["tumorAccidentDate","ge","诊断日期不能早于发病日期"]}' placeholder="选择日期" name="tumorDiagnosisDate" id="tumorDiagnosisDate" value="<fmt:formatDate value='${reportInfo.tumorDiagnosisDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
									</td>
								</tr>
									<%-- 								<tr> -->
                                    <%-- 								<th><label class="required" for="tumorIcd10Name">ICD-10名称</label></th> --%>
									<%-- 									<td><input type="text" id="tumorIcd10Name" name="tumorIcdTenName" value="${reportInfo.tumorIcdTenName}" --%>
									<%-- 										reg="{'required':true,'maxlength':100}" --%>
									<%-- 									/></td> --%>
									<%-- 									</tr> --%>
							</table>
							<div id="secondaryDivId" style="display: none">
								<fieldset class="layui-elem-field">
									<legend>继发源</legend>
									<table class="posttable">
										<colgroup>
											<col style="width: 15%;min-width:100px;" />
											<col style="width: 35%;min-width:200px;" />
											<col style="width: 15%;min-width:100px;" />
											<col style="width: 35%;min-width:200px;" />
										</colgroup>
										<tr>
											<!-- <th>ICD-10编码</th>
											<td id="tumorIcdTenCodeTdId"></td> -->
											<th>肿瘤病名</th>
											<td id="tumorTypeTdId"></td>
										</tr>
										<tr>
											<th>发病日期</th>
											<td id="tumorAccidentDateTdId"></td>
											<th>诊断日期</th>
											<td id="tumorDiagnosisDateTdId"></td>
										</tr>
									</table>
								</fieldset>
							</div>
						</fieldset>
					</div>
				</c:if>
				<c:choose>
					<c:when test="${hideAlloc ==true }"></c:when>
					<c:otherwise>
						<ehr:authorize ifAnyGranted="${JKMBK},${ADMIN}">
							<fieldset id="alloc-info-box" class="layui-elem-field">
								<legend> 分配 </legend>
								<table class="posttable">
									<colgroup>
										<col style="width: 15%;min-width:100px;" />
										<col style="width: 85%;min-width:200px;" />
									</colgroup>
									<tbody>
									<tr>
										<th><label class="required" for="diagnosisOrganCode">分配到</label></th>
										<td><ehr:org-type-list reg="{'dependOn':'report[${index}].approvalOp','dependValue':'3','required':true}" name="superManageOrganCode"  type="centre"  value="${currentSuperManageOrganCode}"/></td>
									</tr>
									</tbody>
								</table>
							</fieldset>
						</ehr:authorize>
					</c:otherwise>
				</c:choose>
				<div id="input-info">
					<fieldset class="layui-elem-field">
						<legend> 报告信息<span style="color:red;"> (注：报告信息录入后不可修改)</span> </legend>
						<table class="posttable">
							<colgroup>
								<col style="width: 15%;min-width:100px;" />
								<col style="width: 35%;min-width:200px;" />
								<col style="width: 15%;min-width:100px;" />
								<col style="width: 35%;min-width:200px;" />
							</colgroup>
							<tr>
								<th><label class="required" for="diagnosisOrganCode">诊断机构</label></th>
								<td colspan="3">
									<ehr:org-type-list id="diagnosisOrganCode"  width="250px" reg="{'required':true}" name="diagnosisOrganCode" type="hospital,centre"  value="${reportInfo.diagnosisOrganCode}"/>
									<c:if test="${hospitalaReport !=true}">
										外地诊断:<input id="otherDiagnosisOrganFlag" type="checkbox" value="2" name="otherDiagnosisOrganFlag" ${reportInfo.otherDiagnosisOrganFlag eq '2' ?'checked':''}>
										<input id="otherDiagnosisOrganName" style="width:150px " reg="{'maxlength':23,'dependOn':'otherDiagnosisOrganFlag','required':true}" type="text" value="${reportInfo.otherDiagnosisOrganName}" name="otherDiagnosisOrganName" class="x-layui-input" />
									</c:if>
								</td>
							</tr>
							<tr>
								<th><label for="ehrNo">门诊号</label></th>
								<td><input type="text" id="ehrNo" name="ehrNo" value="${reportInfo.ehrNo}" reg="{'maxlength':10}" class="x-layui-input" /></td>
								<th><label for="admissionNo">住院号</label></th>
								<td><input type="text" id="admissionNo" name="admissionNo" value="${reportInfo.admissionNo}" reg="{'maxlength':10}" class="x-layui-input" /></td>
							</tr>
							<tr>
								<th><label class="required">填报机构 </label></th>
								<td><input type="hidden" name="createOrganCode" value="${reportInfo.createOrganCode}" />

									<input type="text" readonly="readonly"
										   name="createOrganName" value="<ehr:org code="${reportInfo.createOrganCode}"  />" class="x-layui-input"
									/></td>
								<th><label class="required" for="createDate">填报时间</label></th>
								<td>
									<input id="createDate"  type="text" name="createDate"  readonly="readonly" value='<fmt:formatDate value="${reportInfo.createDate}" pattern="yyyy/MM/dd" />' class="x-layui-input" />
							</tr>
							<tr>
								<th><label class="required">填报医生 </label></th>
								<td><input type="hidden" name="createDoctorCode" value="${reportInfo.createDoctorCode}" />
									<c:if test="${not empty reportInfo.createDoctorCode }">
										<input type="text" readonly="readonly" name="createDoctorName" value="<ehr:user userCode="${reportInfo.createDoctorCode}"></ehr:user>" class="x-layui-input" />
									</c:if>
									<c:if test="${ empty reportInfo.createDoctorCode }">
										<input type="text" readonly="readonly" name="createDoctorName" value="${reportInfo.createDoctorName}" class="x-layui-input" />
									</c:if>
								</td>
								<td></td>
								<td></td>
							</tr>
						</table>
					</fieldset>
				</div>
			</div>
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
   	, trigger: 'click' 
    });

    laydate.render({
        elem: '#deathDate' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	  , trigger: 'click' 
      });
    
    laydate.render({
        elem: '#hbpAccidentDate' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	  , trigger: 'click' 
      });
    
    laydate.render({
        elem: '#hbpDiagnosisDate' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	  , trigger: 'click' 
      });
   
    laydate.render({
        elem: '#diAccidentDate' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	  , trigger: 'click' 
      });
    
    laydate.render({
        elem: '#diDiagnosisDate' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	  , trigger: 'click' 
      });
    
    laydate.render({
        elem: '#coronaryAccidentDate' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	  , trigger: 'click' 
      });
    
    laydate.render({
        elem: '#coronaryDiagnosisDate' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	  , trigger: 'click' 
      });
    
    laydate.render({
        elem: '#strokeAccidentDate' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	  , trigger: 'click' 
      });
    
    laydate.render({
        elem: '#strokeDiagnosisDate' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	  , trigger: 'click' 
      });
    
    laydate.render({
        elem: '#tumorAccidentDate' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	  , trigger: 'click' 
      });
    
    laydate.render({
        elem: '#tumorDiagnosisDate' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	  , trigger: 'click' 
      });
    
  });
</script>
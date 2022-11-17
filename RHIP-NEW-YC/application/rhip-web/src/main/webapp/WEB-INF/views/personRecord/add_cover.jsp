<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/util/jquery.jqprint-0.3.js" type="text/javascript"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/views/ZKTfinger/css/box.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ZKTfinger/js/main.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ZKTfinger/js/fingerprint.js"></script>
<%--<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ZKTfinger/js/jquery.js"></script>--%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ZKTfinger/js/baseMoth.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ZKTfinger/js/dhtmlxCommon.js"></script>
<script src="${pageContext.request.contextPath}/js/views/ehr/person/addCover.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ZKTfinger/js/readcard/baseISSObject.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ZKTfinger/js/readcard/baseISSOnline.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/ZKTfinger/js/readcard/common.js"></script>
<%@ page import="com.founder.rhip.mdm.common.OrgGenreCode" %>

<c:set var="HOSPITAL" value="<%=OrgGenreCode.HOSPITAL.getValue()%>" />
<c:set var="CENTRE" value="<%=OrgGenreCode.CENTRE.getValue()%>" />
<c:set var="INSTITUTES" value="<%=OrgGenreCode.INSTITUTES.getValue()%>" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/personalRecord/common.css" />
<div class="Contentbox" style="text-align: left;">
	<%--验证模式--%>
	<input type="hidden"  id="verifyModel" name="verifyModel" />
	<%--验证指纹--%>
	<input type="hidden" id="verifyTemplate" name="verifyTemplate" />
	<form id="fingerInfoForm" name="fingerInfoForm" method="post">
		<input type="hidden" id="finger_personId" name="personId" value="${personInfo.id}"/>
		<input type="hidden" id="finger_idcard" name="idcard" value="${personInfo.idcard}"/>
		<%--指纹模板--%>
		<input type="hidden"  id="fingerTemplate10" name="fingerTemplate" />
		<%--手指编号--%>
		<input type="hidden" id="fingerId" name="fingerId" />
	</form>
	<div id="comparisonDiv" class="box" style="display: none">
		<h2>指纹比对</h2>
		<div class="list">
			<canvas id="canvasComp" width="430" height="320"
					style="background: url('../js/views/ZKTfinger/image/base_fpVerify.jpg') rgb(243, 245, 240);"></canvas>
			<input type="button" value="关闭" onclick="closeCompa()" />
		</div>
	</div>
	<div id="bg" style="display: none;"></div>
	<div id="box" class="box" style="display: none;">
		<h2>指纹登记</h2>
		<div class="list">
			<canvas id="canvas" width="430" height="450"
					style="background: rgb(243, 245, 240)"></canvas>
			<input type="hidden" id="whetherModify" name="whetherModify" alt=""
				   value="111" />

			<div style="position: absolute; left: 310px; top: 325px; width: 70px; height: 28px;">
				<button type="button" id="submitButtonId" name="makeSureName"
						onclick="submitEvent()" class="button-form">确定</button>
			</div>
			<div style="position: absolute; left: 310px; top: 365px; width: 70px; height: 28px;">
				<button class="button-form" type="button" id="closeButton"
						name="closeButton" onclick='cancelEvent("确认保存当前修改吗?", "指纹数:");'>
					取消</button>
			</div>
		</div>
	</div>
	<p id="add_cert_message" class="msgError" style="display: none;"></p>
	<p id="add_cert_message_type" style="display: none;"></p>
	<div id="msgok" class="msgok" style="display: none;"></div>
	<div id="msgError" class="msgError" style="display: none;"></div>
	<div class="Contentbox" style="text-align: left;">
		<c:if test="${not empty msgError}">
			<input type="hidden" id="firstFlg" value="${msgError}"/>
		</c:if>

		<form id="coverForm" name="coverForm" method="post">
			<input type="hidden" id="text_recordStatus" name="PersonInfoDTO.recordStatus"/>
			<input type="hidden" id="text_personId" name="PersonInfoDTO.personInfo.id" value="${personInfo.id}"/>
			<input type="hidden" id="text_gender" name="PersonInfoDTO.personInfo.gender" value="${personInfo.gender}"/>
			<input type="hidden" id="text_starUpdateDate" name="PersonInfoDTO.personInfo.starUpdateDate" value="<fmt:formatDate value="${personInfo.starUpdateDate}" pattern="yyyy/MM/dd HH:mm:ss"/>"/>
			<c:if test="${'9' ne personInfo.otherIdcardType}">
				<input type="hidden" id="otherIdcardType" name="PersonInfoDTO.personInfo.otherIdcardType" value="${personInfo.otherIdcardType}"/>
			</c:if>
			<input type="hidden" id="idcard"  value="${personInfo.idcard}"/>
			<i class="pop_No">
				<%-- <div id="fpRegisterDiv" style="display: inline; height: do">
					<a id="fpRegister"
					   onclick='submitRegister("指纹", "指纹数:", "确认保存当前修改吗？", "驱动下载", false)'
					   title="请安装指纹驱动或启动该服务" class="finger" onmouseover="this.className='finger'">采指纹</a>
                       <a id="fpRegister"
                           onclick='submitRegister("指纹", "指纹数:", "确认保存当前修改吗？", "驱动下载", false)'
                           title="请安装指纹驱动或启动该服务" onmouseover="this.className='finger'">
                           <button class="layui-btn layui-btn-xs"><i class="layui-icon">&#xe605;</i>采指纹</button>
                       </a>
                     </div> --%>
                     <%--<a class="dk" id="button_read" onclick="new Device().startFun()">读卡</a>
                     <a class="bc" id="button_save">保存</a>
                     <a class="dy" id="button_print">打印</a>--%>
<%--                <a href="javascript:void(0);" id="button_read" onclick="new Device().startFun()"><button class="layui-btn layui-btn-xs"><i class="layui-icon">&#xe615;</i>读卡</button></a>--%>
                <a href="javascript:void(0);" id="button_save" style="margin-top: 3.5px;"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
                <a href="javascript:void(0)" id="button_print" style="margin-top: 3.5px;"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe66d;</i>打印</button></a>
			</i>
			<div class="postcontent" id="printDiv">
				<c:choose>
					<c:when test="${not empty personInfo.healthFileNo}">
						${personInfo.healthFileNoHtml}
					</c:when>
					<c:otherwise>
					<span id="personHealthFileNo">
						<s class="pop_No">
						<span class="text" style="width: 50px;"><b>编号：</b></span>
						<span></span><span></span><span></span><span></span><span></span>
						<span class="line">-</span>
						<span></span><span></span><span></span>
						<span class="line">-</span>
						<span></span><span></span><span></span>
						<span class="line">-</span>
						<span></span><span></span><span></span><span></span>
						</s>
					</span>
					</c:otherwise>
				</c:choose>
				<table class="posttable">
					<colgroup>
						<col style="width:150px;" class="hidcla"></col>
						<col style="width:100px;"></col>
						<col style="width:400px;"></col>
					</colgroup>
					<tr>
						<td rowspan="20" align="center" valign="top" class="hidcla">
							<img src="${pageContext.request.contextPath}/images/128.gif" style="width: 100px;height: 100px;"/>
							<br>
							<input name="" type="button" value="浏览..." />
							<br/><br/><br/><br/><br/><br/><br/><br/>
						</td>
						<td colspan="2" align="center" style="font-size: 20px;font-weight: bold;">
								居民健康档案
							<br/>
							<br/>
						</td>
					</tr>
					<tr>
						<th><label class="required">姓名：</label></th>
						<td><input reg='{"required":"true","maxlength":16}'  type="text"
								   id="text_name" name="PersonInfoDTO.personInfo.name" onblur="removeSpace(this)"
								   value="${personInfo.name}" /></td>
					</tr>
					<tr>
						<th><label class="required">证件类型：</label></th>
						<td>
							<c:choose>
								<c:when test="${empty personInfo.otherIdcardType || '9' eq personInfo.otherIdcardType || personInfo.filingFlag eq 0}">
									<ehr:dic-list id="otherIdcardType" defaultval="Y" width="200px" code="0,5,9"
												  name="PersonInfoDTO.personInfo.otherIdcardType"
												  value="${personInfo.otherIdcardType}" dicmeta="PH00034"
												  onchange="addPersonCover.changeIdType(this.value);"/>
								</c:when>
								<c:otherwise>
									<ehr:dic  code="${personInfo.otherIdcardType}" dicmeta="PH00034"></ehr:dic>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th><label class="required">证件号码：</label></th>
						<td>
							<c:if test="${empty personInfo.id }">
								<input type="text" name="PersonInfoDTO.personInfo.idcard" id="text_idcard"  reg='{"required":"true","idCard":true}' value="${personInfo.idcard}" ></input>
							</c:if>
							<c:if test="${not empty personInfo.id }">
								<c:choose>
									<c:when test="${not empty personInfo.idcard}">
										${personInfo.idcard}<input type="hidden" name="PersonInfoDTO.personInfo.idcard" maxlength="18" value="${personInfo.idcard}" />
									</c:when>
									<c:when test="${'9' eq personInfo.otherIdcardType}">
										<tag:idcardInput name="PersonInfoDTO.personInfo.idcard" id="text_idcard"  reg='{"idCard":true}' value="${personInfo.idcard}" ></tag:idcardInput>
									</c:when>
									<c:otherwise>
										${personInfo.otherIdcard}<input type="hidden" name="PersonInfoDTO.personInfo.otherIdcard" maxlength="18" value="${personInfo.otherIdcard}" />
									</c:otherwise>
								</c:choose>

							</c:if>
						</td>
					</tr>
					<input type="hidden" id="filingFlag" value="${personInfo.filingFlag}"/>
					<input type="hidden" id="babyCardNo" value="${personInfo.babyCardNo}"/>
					<tr class="hidediv" id="babyCardNoShow">
						<th>保健编号:</th>
						<td>${personInfo.babyCardNo}</td>
					</tr>
					<tr class="hidediv" id="babyCardNoShowText">
						<th>保健编号:</th>
						<td><input type="text" name="PersonInfoDTO.personInfo.babyCardNo" id="babyCardNoText" value="${personInfo.babyCardNo}"/></td>
					</tr>
					<tr>
						<th><label class="required">现住址： </label></th>
						<td>
							<ehr:dic-town-street-village villageId="village_address" streetId="street_address"
														 townId="town_address" villageName="PersonInfoDTO.personInfo.paGroup" streetName="PersonInfoDTO.personInfo.pastreet"
														 townName="PersonInfoDTO.personInfo.patownShip" villageValue="${personInfo.paGroup}" streetValue="${personInfo.pastreet}"
														 townValue="${personInfo.patownShip}" width="118px;" reg="{'required':true}" callback="addPersonCover.displayPaAddress"/>
						</td>
					</tr>
					<%--<tr>
						<th>小区名称：</th>
						<td>
							<select style="width: 118px" id="houseHoldList" name="PersonInfoDTO.personInfo.houseHold">
								<option>请选择</option>
							</select>
						</td>
					</tr>--%>
					<tr >
						<th class="htr">现住址补充信息：</th>
						<td class="htr">
							<label id="tempPaValue">${orgPaName}${orgPaNamePastreet}<ehr:dic code="${personInfo.paGroup}" dicmeta="FS990001"/></label><br/>
							<input type="hidden" name="PersonInfoDTO.personInfo.paAddressDetail" id="orgPaName" value="${personInfo.paAddressDetail}"/>
							<textarea id="text_pahouseNumber"  name="PersonInfoDTO.personInfo.pahouseNumber" rows="2" onblur="controlTextArea('text_pahouseNumber')" placeholder="如无门牌号等详细信息此空则不用填写任何文字，如有门牌号码等详细信息请在此处手动填写，不再重复上方地址信息" >${personInfo.pahouseNumber}</textarea>
							<%--<input type="text" placeholder="如无门牌号等详细信息，此空则不用填写任何文字，如有门牌号码等详细信息请在此处手动填写，不再重复上方地址信息" id="text_pahouseNumber" reg='{"required":true,"maxlength":50}'   name="PersonInfoDTO.personInfo.pahouseNumber" value="${personInfo.pahouseNumber}"/>--%>
						</td>
					</tr>
					<%--<tr>--%>
					<%--<th>常住类型：</th>--%>
					<%--<td><ehr:dic-radio dicmeta="FS10322" name="PersonInfoDTO.personInfo.livingType" value='${"4"!=personInfo.livingType?"3":"4"}' code="3,4"/></td>--%>
					<%--</tr>--%>
					<tr>
						<th>常住类型：</th>
						<td id="censusRadios"><ehr:dic-radio dicmeta="FS10005" name="PersonInfoDTO.personInfo.householdType" value="${(null==personInfo.householdType || ''==personInfo.householdType)?'1':personInfo.householdType}" code="1,2,4" /></td>
					</tr>
					<c:if test='${"2" != personInfo.householdType && "4" != personInfo.householdType}'>
						<tr id="homeTr">
							<th><label class="required">户籍地址：</label></th>
							<td>
								<ehr:dic-town-street-village
										villageId="homeVillage_address" townId="homeTown_address" streetId="homeStreet_address"
										villageName="PersonInfoDTO.personInfo.hrGroup" streetName="PersonInfoDTO.personInfo.hrstreet"
										townName="PersonInfoDTO.personInfo.hrtownShip" streetValue="${personInfo.hrstreet}"
										villageValue="${personInfo.hrGroup}" callback="addPersonCover.displayHrAddress"
										townValue="${personInfo.hrtownShip}" width="118px;" reg="{'dependOn':'PersonInfoDTO.personInfo.householdType','dependValue':'1','required':true}"/>
							</td>
						</tr>
						<%--<tr>
							<th>小区名称：</th>
							<td>
								<select style="width: 118px" id="HrhouseHoldList">
									<option>请选择</option>
								</select>
							</td>
						</tr>--%>
					</c:if>
					<c:if test='${"2" == personInfo.householdType || "4" == personInfo.householdType}'>
						<tr style="display: none" id="homeTr">
							<th><label class="required">户籍地址：</label></th>
							<td >
								<ehr:dic-town-street-village villageId="homeVillage_address" townId="homeTown_address" streetId="homeStreet_address"
															 streetValue="${personInfo.hrstreet}" villageName="PersonInfoDTO.personInfo.hrGroup" streetName="PersonInfoDTO.personInfo.hrstreet"
															 townName="PersonInfoDTO.personInfo.hrtownShip" villageValue="${personInfo.hrGroup}"
															 townValue="${personInfo.hrtownShip}" width="118px;"  reg="{'dependOn':'PersonInfoDTO.personInfo.householdType','dependValue':'1','required':true}"
															 callback="addPersonCover.displayHrAddress"/>
							</td>
						</tr>
					</c:if>
					<tr>
						<th><label id="hjdzbcxx" class="required">户籍地址补充信息：</label></th>
						<td >
						<span id="homeSpan" <c:if test='${"1" != personInfo.householdType}'> style="display: none;" </c:if> >
							<label id="tempHrValue">
								<ehr:dic code="${personInfo.hrtownShip}" dicmeta="FS990001"/>
								<ehr:dic code="${personInfo.hrstreet}" dicmeta="FS990001"/>
								<ehr:dic code="${personInfo.hrGroup}" dicmeta="FS990001"/>
							</label><br/>
							<input type="hidden" name="PersonInfoDTO.personInfo.hrAddressDetail" id="orgHrName" value="${personInfo.hrAddressDetail}"/>
						</span>
							<textarea id="text_hrhouseNumber" name="PersonInfoDTO.personInfo.hrhouseNumber" rows="2" reg='{"required":true}' onblur="controlTextArea('text_hrhouseNumber')" placeholder="如无门牌号等详细信息此空则不用填写任何文字，如有门牌号码等详细信息请在此处手动填写，不再重复上方地址信息" >${personInfo.hrhouseNumber}</textarea>
							<%--<input placeholder="如无门牌号等详细信息，此空则不用填写任何文字，如有门牌号码等详细信息请在此处手动填写，不再重复上方地址信息" reg='{"required":true,"maxlength":50}' type="text" id="text_hrhouseNumber" name="PersonInfoDTO.personInfo.hrhouseNumber" value="${personInfo.hrhouseNumber}"/>
						--%></td>
					</tr>
					<tr>
						<th style="vertical-align: top;padding-top: 15px;">
							<label class="required">人群分类：</label>
						</th>
						<td>
							<table class="posttable">
								<tr>
									<td style="ve">贫困人口：
										<label><input  type="radio" onclick="util.clickHideText(this,'quitDrinkAgeDesc')"  name="PersonInfoDTO.personInfo.poverty"${personInfo.poverty eq null or personInfo.poverty eq "1" ? "checked" :""}  value="1"/> 否</label>
										<label><input type="radio" id="poverty" onclick="util.clickShowText(this,'quitDrinkAgeDesc')" name="PersonInfoDTO.personInfo.poverty" ${personInfo.poverty eq"2" ?"checked" :""} value="2"/>是</label>


										<span id="quitDrinkAgeDesc" class="hidediv">贫困类型：<ehr:dic-list reg="{'required':true}" name="PersonInfoDTO.personInfo.povertyType" dicmeta="FS990024" value="${personInfo.povertyType }"></ehr:dic-list>
									</span>
									</td>
								</tr>
								<tr>
									<td>残疾人口：
										<label><input  type="radio" onclick="util.clickHideText(this,'disabledDesc')"  name="PersonInfoDTO.personInfo.disabled" ${personInfo.disabled eq null or personInfo.disabled eq "1" ? "checked" :""} value="1"/> 否</label>
										<label><input type="radio" id="disabled" onclick="util.clickShowText(this,'disabledDesc')" name="PersonInfoDTO.personInfo.disabled" ${personInfo.disabled eq"2" ?"checked" :""} value="2"/>是</label>
										<span class="hidediv" id="disabledDesc">残疾类型：<ehr:dic-list reg="{'required':true}" name="PersonInfoDTO.personInfo.veryPovertyType" dicmeta="FS990025" value="${personInfo.veryPovertyType }"></ehr:dic-list>
									</span>
									</td>
								</tr>
								<tr>
									<td>计生特困：
										<label><input  type="radio"   name="PersonInfoDTO.personInfo.veryPoverty" ${personInfo.veryPoverty eq null or personInfo.veryPoverty eq "1" ? "checked" :""} value="1"/> 否</label>
										<label><input type="radio"  name="PersonInfoDTO.personInfo.veryPoverty" ${personInfo.veryPoverty eq"2" ?"checked" :""} value="2"/>是</label>
								</tr>
							</table>



						</td>
					</tr>
					<tr>
						<th><label class="required">联系电话：</label></th>
						<td><input type="text" id="text_phoneNumber"
								   name="PersonInfoDTO.personInfo.phoneNumber"  reg='{"required":"true","maxlength":20,"regex":"phone"}'  value="${personInfo.phoneNumber}"/></td>
					</tr>
					<tr>
						<th><label class="required">紧急联系人电话：</label></th>
						<td>
							<input type="text" id="text_guardianPhoneOne"
								   name="PersonInfoDTO.personInfo.guardianPhoneOne"  reg='{"required":"true","maxlength":20,"regex":"phone"}'  value="${personInfo.guardianPhoneOne}"/>
						</td>
					</tr>
					<tr>
						<th>管理单位：</th>
						<td><ehr:org code="${personInfo.inputOrganCode}"/>
							<input type="hidden" id="text_inputOrganName" readonly="readonly" reg='{"required":true}'
								   name="PersonInfoDTO.personInfo.inputOrganName" value="${personInfo.inputOrganName}"/>
							<input type="hidden" id="text_inputOrganCode"
								   name="PersonInfoDTO.personInfo.inputOrganCode" value="${personInfo.inputOrganCode}"/>
						</td>
					</tr>
					<tr>
						<th><label class="required">管理医生：</label></th>
						<td>
							<ehr:staff-list reg='{"required":true}' name="PersonInfoDTO.personInfo.inputerId"
											value="${personInfo.inputerId}" defaultval="Y" style="width:358px"/>
						</td>
					</tr>
					<tr>
						<th><label class="required">管理日期：</label></th>
						<td >
							<jsp:useBean id="today" class="java.util.Date" />
							<c:if test="${empty personInfo.inputDate}">
								<%-- <tag:dateInput id="text_inputDate" reg='{"required":true}' style="178px" name="PersonInfoDTO.personInfo.inputDate" onlypast="true" date="${today}" pattern="yyyy/MM/dd"></tag:dateInput> --%>
								<input type="text" class="layui-input x-admin-content-sm-date" placeholder="管理日期" name="PersonInfoDTO.personInfo.inputDate" id="inputDate" value="<fmt:formatDate value="${today}" pattern="yyyy/MM/dd"/>" reg='{"required":"true"}' style="padding-left: 0px;width: 357.5px;">
							</c:if>
							<c:if test="${not empty personInfo.inputDate}">
								<%-- <tag:dateInput id="text_inputDate" reg='{"required":true}' style="178px" name="PersonInfoDTO.personInfo.inputDate"  date="${personInfo.inputDate}" onlypast="true" ></tag:dateInput> --%>
								<input type="text" class="layui-input x-admin-content-sm-date" placeholder="管理日期" name="PersonInfoDTO.personInfo.inputDate" id="inputDate" value="<fmt:formatDate value="${personInfo.inputDate}" pattern="yyyy/MM/dd"/>" reg='{"required":"true"}' style="padding-left: 0px;width: 357.5px;">
							</c:if>
						</td>
					</tr>
					<tr>
						<th>建档单位：</th>
						<td id="createOrganNameTd">
							${personInfo.createOrganName eq null ? currentLoginInfo.organization.organName : personInfo.createOrganName}
								<c:choose>
									<c:when test="${personInfo.createCenterOrganCode eq null && (currentLoginInfo.organization.genreCode eq HOSPITAL ||
									currentLoginInfo.organization.genreCode eq CENTRE || currentLoginInfo.organization.genreCode eq INSTITUTES)}">
										<input type="hidden" name="PersonInfoDTO.personInfo.createCenterOrganCode" value="${currentLoginInfo.organization.organCode}"/>
									</c:when>
									<c:when test="${personInfo.createCenterOrganCode eq null}">
										<input type="hidden" name="PersonInfoDTO.personInfo.createCenterOrganCode" value="${currentLoginInfo.organization.parentCode}"/>
									</c:when>
									<c:otherwise>
										<input type="hidden" name="PersonInfoDTO.personInfo.createCenterOrganCode" value="${personInfo.createCenterOrganCode}"/>
									</c:otherwise>
								</c:choose>
								<input type="hidden" name="PersonInfoDTO.personInfo.createGbcode" value="${personInfo.createGbcode eq null ? currentLoginInfo.organization.gbCode : personInfo.createGbcode}"/>
								<input type="hidden" name="PersonInfoDTO.personInfo.createOrganName" value="${personInfo.createOrganName eq null ? currentLoginInfo.organization.organName : personInfo.createOrganName}"/>
								<input type="hidden" name="PersonInfoDTO.personInfo.createOrganCode" value="${personInfo.createOrganCode eq null ? currentLoginInfo.organization.organCode : personInfo.createOrganCode}"/>
						</td>
					</tr>
					<tr>
						<th>建档医生：</th>
						<td id="createIdTd">
							<c:choose>
								<c:when test="${personInfo.star >=2}">
									<ehr:staff-name staffCode="${personInfo.createId}"/>
									<input type="hidden" name="PersonInfoDTO.personInfo.createId" value="${personInfo.createId}"/>
								</c:when>
								<c:otherwise>
									<ehr:staff-list reg='{"required":true}' name="PersonInfoDTO.personInfo.createId"
													value="${personInfo.createId eq null ? currentLoginInfo.user.staffCode : personInfo.createId}" defaultval="Y" style="width:358px"/>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th>建档日期：</th>
						<td id="createDateTd">
							<fmt:formatDate value="${personInfo.createDate eq null ? today : personInfo.createDate}" pattern="yyyy/MM/dd"/>
							<tag:dateInput style="display:none;" name="PersonInfoDTO.personInfo.createDate" onlypast="true" date="${personInfo.createDate eq null ? today : personInfo.createDate}" pattern="yyyy/MM/dd"></tag:dateInput>
						</td>
					</tr>
					<tr>
						<th title="此处只为标记,不关联任何业务"><label class="required">备注：</label></th>
						<td>
							<ehr:dic-list id="text_remarks" reg='{"required":true}' name="PersonInfoDTO.personInfo.remarks" value="${personInfo.remarks}" dicmeta="FS990026" width="358px;"/>
						</td>
					</tr>
				</table></div>
		</form>
	</div>
</div>
<style type="text/css">
		input::-webkit-input-placeholder, textarea::-webkit-input-placeholder {
    		color: #b3b3b3;
		}
</style>
<script type="text/javascript">
layui.use('laydate', function() {
    var laydate = layui.laydate;
    
    //执行一个laydate实例
    laydate.render({
      elem: '#inputDate' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
   	  , trigger: 'click' 
    });
    
  });

function controlTextArea(o) {
	var val = $("#"+o).val();
	if (!isEmpty(val)) {
		$("#"+o).removeClass("lose");
	} else {
		$("#"+o).addClass("lose");
	}
}
</script>
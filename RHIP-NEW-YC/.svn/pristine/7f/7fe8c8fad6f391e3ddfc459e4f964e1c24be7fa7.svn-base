<%@ page import="com.founder.rhip.ncp.common.NcpConstants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<c:set var="MONITOR" value="<%=NcpConstants.NCP_MONITOR_TYPE_1%>"/>
<c:set var="REEXAM" value="<%=NcpConstants.NCP_MONITOR_TYPE_2%>"/>
<c:set var="FOLLOW" value="<%=NcpConstants.NCP_MONITOR_TYPE_3%>"/>
<script type="text/javascript">
	$(function() {
		toggleOther('reexmItem.hxgnResult','hxgnDesc','2');
		toggleOther('reexmItem.ydgnResult','ydgnDesc','2');
		toggleOther('reexmItem.ctResult','ctDesc','2');
	})

</script>
<div class="ncp-followup-from-content">
	<form id="ncp-monitor-from" class="ncp-followup-from">
		<input type="hidden" name="id" id="id" value="${monitor==null?'':monitor.id}" />
		<input type="hidden" name="editFlag" id="editFlag" value="${editFlag}"/>
		<input type="hidden" name="planId" id="planId" value="${planId}"/>
        <input type="hidden" name="planType" id="planType" value="${planType}"/>
		<input type="hidden" name="type" id="type" value="${type}"/>
		<input type="hidden" name="cardno" value="${pat.cardno}"/>
		<input type="hidden" name="cardType" value="${pat.cardType}"/>
		<input type="hidden" name="patientId" value="${pat.id}"/>
		<input type="hidden" name="reexmItem.id" value="${monitor.reexmItem.id}"/><%--monitor==null||monitor.reexmItem==null?'':--%>
		<input type="hidden" name="reexmItem.monitorId" value="${monitor.id}"/>
		<input type="hidden" name="reexmItem.patientId" value="${pat.id}"/>
		<div class="postcontent">
			<div class="postdiv" style="margin-top: -8px;">
				<fieldset class="layui-elem-field">
					<legend>
						<c:if test="${MONITOR eq type}">监测填写</c:if>
						<c:if test="${REEXAM eq type}">复查填写</c:if>
						<c:if test="${FOLLOW eq type}">随访填写</c:if>
					</legend>
					<table class="posttable">
						<colgroup>
							<col style="min-width: 100px; width: 30%" />
							<col style="min-width: 150px; width: 70%" />
						</colgroup>
						<%--<tr>
                            <th><label class="" >姓名</label></th>
                            <td></td>
                        </tr>--%>
						<tr>
							<th>
								<label class="required" >
									<c:if test="${MONITOR eq type}">监测日期</c:if>
									<c:if test="${REEXAM eq type}">复查日期</c:if>
									<c:if test="${FOLLOW eq type}">随访日期</c:if>
								</label>
							</th>
							<td><tag:dateInput onlypast="true" name="monitorDate" style="width:178px;" date="${monitor.monitorDate}" reg="{'required':true}" /></td>
						</tr>

						<tr>
							<th><label class="" >血压</label></th>
							<td>
								<tag:numberInput name="sbp" value="${monitor.sbp}"
												 style="width: 40px"
												 reg="{'min':0,'max':9999}" id="bloodUp"/>/
								<tag:numberInput name="dbp" value="${monitor.dbp}"
												 style="width: 40px"
												 reg="{'min':0,'max':9999}"
												 id="leftBloodDown"/>mmHg
							</td>
						</tr>
						<tr>
							<th><label class="required">症状</label></th>
							<td>
								<ehr:dic-radio dicmeta="FS10238" reg="{'required':true}" name="symptomFlag" value="${monitor.symptomFlag }"></ehr:dic-radio>
								<div id="symptomDiv" class="${monitor.symptomFlag !='2'?'hide':'' }">
									<ehr:dic-checkbox dicmeta="NCP00009" name="curSymptom" value="${monitor.symptioms}" reg="{'required':true,'dependValue':'2','dependOn':'symptomFlag'}"/>
									<%--<input style="width: 100px;" reg="{'maxlength':100,'required':true,'dependValue':'10','dependOn':'curSymptom'}" type="text" name="otherSymptom" value=""></input>--%>
								</div>
							</td>
						</tr>
						<tr>
							<th><label class="required" >体温</label></th>
							<td>
								<tag:numberInput point="point" style="width: 80px"
												 value="${monitor.temp}"
												 name="temp"
												 reg="{'min':0,'max':99.9,'required':'true'}"></tag:numberInput>℃
							</td>
						</tr>
						<c:if test="${REEXAM eq type}">
							<tr>
								<th><label class="">血糖</label></th>
								<td><input reg="{'maxlength':4}" type="text" style="width: 80px" name="reexmItem.xt" value="${monitor.reexmItem.xt}"></input>mmol/L</td>
							</tr>
							<tr>
								<th><label class="required">血常规</label></th>
								<td>白细胞数：<tag:numberInput  point="point" maxlength="6" name="reexmItem.bxbs" value="${monitor.reexmItem.bxbs}" style="width: 40px" reg="{'min':0,'max':9999,'required':true}" />10<sup>9</sup>/L
									淋巴细胞数：<tag:numberInput  point="point" maxlength="6" name="reexmItem.lbxbs" value="${monitor.reexmItem.lbxbs}" style="width: 40px" reg="{'min':0,'max':9999,'required':true}" />10<sup>9</sup>/L
									淋巴细胞百分比：<tag:numberInput  point="point" maxlength="6" name="reexmItem.lbxbbfb" value="${monitor.reexmItem.lbxbbfb}" style="width: 40px" reg="{'min':0,'max':9999,'required':true}" />%<br/>
									中性粒细胞百分比：<tag:numberInput  point="point" maxlength="6" name="reexmItem.zxlxbbfb" value="${monitor.reexmItem.zxlxbbfb}" style="width: 40px" reg="{'min':0,'max':9999,'required':true}" />%
								</td>
							</tr>
							<%--<tr>
								<th><label class="required">生化</label></th>
								<td><input reg="{'maxlength':4,'required':true}" type="text" name="reexmItem.sh" value="${monitor.reexmItem.sh}"></input></td>
							</tr>--%>
							<tr>
								<th><label class="required">肝功能</label></th>
								<td>
									谷丙转氨酶：<tag:numberInput  point="point" maxlength="6" name="reexmItem.gbzam" value="${monitor.reexmItem.gbzam}" style="width: 40px" reg="{'min':0,'max':99999.9,'required':true}" />U/L
									谷草转氨酶：<tag:numberInput  point="point" maxlength="6" name="reexmItem.gczam" value="${monitor.reexmItem.gczam}" style="width: 40px" reg="{'min':0,'max':99999.9,'required':true}" />U/L
									总胆红素：<tag:numberInput  point="point" maxlength="6" name="reexmItem.zdhs" value="${monitor.reexmItem.zdhs}" style="width: 40px" reg="{'min':0,'max':99999.9,'required':true}" />umol/L
								</td>
							</tr>
							<tr>
								<th><label class="">肾功能</label></th>
								<td>
									血清肌酐：<tag:numberInput  point="point" maxlength="6" name="reexmItem.xqjg" value="${monitor.reexmItem.xqjg}" style="width: 40px" reg="{'min':0,'max':99999.9}" />umol/L
									血尿素：<tag:numberInput  point="point" maxlength="6" name="reexmItem.xls" value="${monitor.reexmItem.xls}" style="width: 40px" reg="{'min':0,'max':99999.9}" />umol/L
								</td>
							</tr>
							<tr>
								<th><label class="required">氧饱和度</label></th>
								<td>
									<tag:numberInput name="reexmItem.ybhd" value="${monitor.reexmItem.ybhd}" style="width: 40px" reg="{'min':0,'max':99999.9,'required':true}" />%</td>
							</tr>
							<tr>
								<th><label class="">胸部影像</label></th>
								<td>
									CT结果：<ehr:dic-radio onchange="toggleOther('reexmItem.ctResult','ctDesc','2')" dicmeta="NCP00004" name="reexmItem.ctResult" value="${monitor.reexmItem.ctResult}"></ehr:dic-radio>
									<input reg="{'maxlength':100}" type="text" id="ctDesc"  style="width: 160px" name="reexmItem.xbyx" value="${monitor.reexmItem.xbyx}"/>
								</td>
							</tr>
							<tr>
								<th><label class="">新冠肺炎病原学检测</label></th>
								<td>
									核酸检查：<ehr:dic-radio dicmeta="NCP00010" name="reexmItem.hsjc" value="${monitor.reexmItem.hsjc}"></ehr:dic-radio>
								</td>
							</tr>
							<tr>
								<th><label class="">新冠肺炎血清学检查</label></th>
								<td>
									IgM抗体：<ehr:dic-radio dicmeta="NCP00010" name="reexmItem.igmkt" value="${monitor.reexmItem.igmkt}"></ehr:dic-radio>&nbsp;&nbsp;
									IgG抗体：<ehr:dic-radio dicmeta="NCP00010" name="reexmItem.iggkt" value="${monitor.reexmItem.iggkt}"></ehr:dic-radio>
								</td>
							</tr>
							<tr>
								<th><label class="">呼吸功能</label></th>
								<td>
									<ehr:dic-radio onchange="toggleOther('reexmItem.hxgnResult','hxgnDesc','2')" dicmeta="NCP00004" name="reexmItem.hxgnResult" value="${monitor.reexmItem.hxgnResult}"></ehr:dic-radio>
									<input reg="{'maxlength':100}" type="text" id="hxgnDesc" style="width: 160px" name="reexmItem.hxgn" value="${monitor.reexmItem.hxgn}"/>
								</td>
							</tr>
							<tr>
								<th><label class="">运动功能</label></th>
								<td>
									<ehr:dic-radio onchange="toggleOther('reexmItem.ydgnResult','ydgnDesc','2')" dicmeta="NCP00004" name="reexmItem.ydgnResult" value="${monitor.reexmItem.ydgnResult}"></ehr:dic-radio>
									<input reg="{'maxlength':100}" type="text" id="ydgnDesc" style="width: 160px" name="reexmItem.ydgn" value="${monitor.reexmItem.ydgn}"/>
								</td>
							</tr>
						</c:if>
						<tr>
							<th><label class="">其他检查</label></th>
							<td><input reg="{'maxlength':100}" type="text" name="otherInspect" value="${monitor.otherInspect}"/></td>
						</tr>
						<tr>
							<th><label class="required">
									<c:if test="${MONITOR eq type}">监测评价</c:if>
									<c:if test="${REEXAM eq type}">复查评价</c:if>
									<c:if test="${FOLLOW eq type}">随访评价</c:if>
								</label></th>
							<td><%--toggleOther('sideEffects','hbp-followup-effectsState','2')--%>
								<ehr:dic-radio reg="{'required':true}" onchange="toggleOther('healthAssessment','healthAssessmentDesc','2')" dicmeta="NCP00004" name="healthAssessment" value="${monitor.healthAssessment}"></ehr:dic-radio>
								<input style="width:352px;" class="${monitor.healthAssessment!='2'?'hide':'' }" type="text" id="healthAssessmentDesc"   value="${monitor.healthAssessmentDesc}" name="healthAssessmentDesc" reg="{'required':true,'maxlength':100,'dependOn':'healthAssessment','dependValue':'2'}"  >
								<%--class="${monitor.healthAssessment!='2'?'hide':'' }"--%>
							</td>
						</tr>
						<tr>
							<th><label class="required">健康指导</label></th>
							<td>
								<%--<input type="checkbox" reg='{"extension":["healthGuidanceVali","请至少选择一项"]}'
                                       name="guideIntoChronicDisease" ${monitor.healthGuidance eq"1" ?"checked":""}
                                       value="1"/>--%>
								<ehr:dic-checkbox dicmeta="NCP00008" name="healthGuidance" reg="{'required':true}" value="${monitor.healthGuidance}"/>
								<input style="width: 100px;" reg="{'required':true,'maxlength':100,'dependOn':'healthGuidance','dependValue':'5'}" id="healthGuidanceDesc" type="text" name="healthGuidanceDesc" value="${monitor.healthGuidanceDesc}"></input>
							</td>
						</tr>
					</table>
				</fieldset>
				<fieldset class="layui-elem-field">
					<legend>转诊</legend>
					<table class="posttable">
						<colgroup>
							<col style="min-width: 100px; width: 30%" />
							<col style="min-width: 150px; width: 70%" />
						</colgroup>
						<tr>
							<th><label class="required" for="referralFlag">转诊</label></th>
							<td><ehr:dic-radio reg='{"required":"true"}' dicmeta="FS10246" name="referral" id="referralFlag" value="${monitor.referral}"/></td>
						</tr>
					</table>
					<table class="posttable" style="${monitor.referral !='1'?'display:none':'' }" id="referralSpan">
						<colgroup>
							<col style="min-width: 100px; width: 30%" />
							<col style="min-width: 150px; width: 70%" />
						</colgroup>
						<tr>
							<th><label class="" for="referralOrg">机构</label></th>
							<td class="colinput">
								<ehr:org-type-list id="referralOrg"  width="275px" name="referralOrg" type="hospital,centre" reg="{}" value="${monitor.referralOrg}"/>
							</td>
						</tr>
						<tr>
							<th><label class="" for="referralDept">科别</label></th>
							<td><input type="text" name="referralDept" id="referralDept" reg="{'maxlength':100}" value="${monitor.referralDept}"/></td>
						</tr>
						<tr>
							<th>接诊医生</th>
							<td><input type="text" name="referralDoctor" id="referralDoctor" reg="{'maxlength':100}" value="${monitor.referralDoctor}"/></td>
						</tr>
						<tr>
							<th>转诊日期</th>
							<td><tag:dateInput onlypast="true" id="referralDate" name="referralDate" style="width:178px;" date="${monitor.referralDate}"/></td>
						</tr>
						<tr>
							<th><label class="" for="referralReason">原因</label></th>
							<td><input type="text" name="referralReason" id="referralReason" reg="{'maxlength':150}" value="${monitor.referralReason}"/></td>
						</tr>
					</table>
				</fieldset>
				<c:set var="input" value="${monitor}" scope="request"></c:set>
				<jsp:include page="../common/inputInfo.jsp"></jsp:include>
			</div>
		</div>
	</form>
	<jsp:include page="monitorPrint.jsp"/>
</div>


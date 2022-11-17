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
<style>
	#hbpPrintFollowUp .table-01{width:100%;height:100%; overflow:auto;clear:both;vertical-align:middle;}
	#hbpPrintFollowUp .table-01{background:#FFF}
	#hbpPrintFollowUp .table-01 table{width:100%; border-left:#C8BAAE solid 1px;border-top:#C8BAAE solid 1px;border-collapse:collapse;}
	#hbpPrintFollowUp .table-01 td{text-align:left;height:24px;line-height:24px;border:1px solid #ccc;padding:2px;}
	#hbpPrintFollowUp .table-01 th{border:1px solid #CCC;background:#EFF7FF;font-weight:normal;}
	#hbpPrintFollowUp .table-01 td.td_gray{background:#EEE;}
	#hbpPrintFollowUp .table-01 td.h_top{background:#66B9DB; font-weight:bold;text-align:center;color:#FFF;}
</style>

<div id="printFollowUp" style="display: none">
	<h3 align="center">
		<c:if test="${MONITOR eq type}">监测记录</c:if>
		<c:if test="${REEXAM eq type}">复查记录</c:if>
		<c:if test="${FOLLOW eq type}">随访记录</c:if>
	</h3>
	<div class="postdiv">
		<fieldset>
			<legend>

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
					<td>
						<fmt:formatDate value="${monitor.monitorDate}" pattern="yyyy/MM/dd"/>
					</td>
				</tr>

				<tr>
					<th><label class="" >血压</label></th>
					<td>${monitor.sbp}/${monitor.dbp}mmHg
						<%--<tag:numberInput name="sbp" value="${monitor.sbp}"
										 style="width: 40px"
										 reg="{'min':0,'max':9999}" id="bloodUp"/>/
						<tag:numberInput name="dbp" value="${monitor.dbp}"
										 style="width: 40px"
										 reg="{'min':0,'max':9999}"
										 id="leftBloodDown"/>mmHg--%>
					</td>
				</tr>
				<tr>
					<th><label class="required">症状</label></th>
					<td>
						<ehr:dic code="${monitor.symptomFlag }" dicmeta="FS10238" />
						<div id="symptomDiv" class="${monitor.symptomFlag !='2'?'hide':'' }">
							<ehr:dic code="${monitor.symptioms }" dicmeta="NCP00009" />
						</div>
					</td>
				</tr>
				<tr>
					<th><label class="required" >体温</label></th>
					<td>${monitor.temp}℃
					</td>
				</tr>
				<c:if test="${REEXAM eq type}">
					<tr>
						<th><label class="">血糖</label></th>
						<td>${monitor.reexmItem.xt}mmol/L</td>
					</tr>
					<tr>
						<th><label class="required">血常规</label></th>
						<td>${monitor.reexmItem.xcg}</td>
					</tr>
					<tr>
						<th><label class="required">生化</label></th>
						<td>${monitor.reexmItem.sh}</td>
					</tr>
					<tr>
						<th><label class="required">氧饱和度</label></th>
						<td>${monitor.reexmItem.ybhd}</td>
					</tr>
					<tr>
						<th><label class="">胸部影像</label></th>
						<td>${monitor.reexmItem.xbyx}</td>
					</tr>
					<tr>
						<th><label class="">新冠肺炎病原学检测</label></th>
						<td>${monitor.reexmItem.byxjc}</td>
					</tr>
					<tr>
						<th><label class="">呼吸功能</label></th>
						<td>${monitor.reexmItem.hxgn}</td>
					</tr>
					<tr>
						<th><label class="">运动功能</label></th>
						<td>${monitor.reexmItem.ydgn}</td>
					</tr>
				</c:if>
				<tr>
					<th><label class="">其他检查</label></th>
					<td>${monitor.otherInspect}</td>
				</tr>
				<tr>
					<th><label class="required">
						<c:if test="${MONITOR eq type}">监测评价</c:if>
						<c:if test="${REEXAM eq type}">复查评价</c:if>
						<c:if test="${FOLLOW eq type}">随访评价</c:if>
					</label></th>
					<td>
						<ehr:dic code="${monitor.healthAssessment }" dicmeta="NCP00004" />
						<c:if test="${monitor.healthAssessment=='2'}">
							${monitor.healthAssessmentDesc}
						</c:if>
					</td>
				</tr>
				<tr>
					<th><label class="required">健康指导</label></th>
					<td>
						<ehr:dic code="${monitor.healthGuidance }" dicmeta="NCP00008" />
						<span name="healthGuidanceDesc">${monitor.healthGuidanceDesc} </span>
					</td>
				</tr>
			</table>
		</fieldset>
		<fieldset>
			<legend>转诊</legend>
			<table class="posttable">
				<colgroup>
					<col style="min-width: 100px; width: 30%" />
					<col style="min-width: 150px; width: 70%" />
				</colgroup>
				<tr>
					<th><label class="required" >转诊</label></th>
					<td><ehr:dic code="${monitor.referral }" dicmeta="FS10246" /></td>
				</tr>
			</table>
			<table class="posttable" style="${monitor.referral !='1'?'display:none':'' }" id="referralSpan">
				<colgroup>
					<col style="min-width: 100px; width: 30%" />
					<col style="min-width: 150px; width: 70%" />
				</colgroup>
				<tr>
					<th><label class="" >机构</label></th>
					<td class="colinput">
						<ehr:org code="${monitor.referralOrg}"/>
						<%--<ehr:org-type-list id="referralOrg"  width="275px" name="referralOrg" type="hospital,centre" reg="{}" value="${monitor.referralOrg}"/>--%>
					</td>
				</tr>
				<tr>
					<th><label class=""  >科别</label></th>
					<td>${monitor.referralDept}</td>
				</tr>
				<tr>
					<th>接诊医生</th>
					<td>${monitor.referralDoctor}</td>
				</tr>
				<tr>
					<th>转诊日期</th>
					<td>
						<fmt:formatDate value="${monitor.referralDate}" pattern="yyyy/MM/dd"/>
					</td>
				</tr>
				<tr>
					<th><label class="" >原因</label></th>
					<td>${monitor.referralReason}</td>
				</tr>
			</table>
		</fieldset>
		<c:set var="input" value="${monitor}" scope="request"></c:set>
		<jsp:include page="../common/inputInfo.jsp"></jsp:include>
	</div>
</div>
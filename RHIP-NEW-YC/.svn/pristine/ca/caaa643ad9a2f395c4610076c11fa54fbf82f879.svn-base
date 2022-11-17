<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />
<script src="${pageContext.request.contextPath}/js/views/ehr/child/deathReport/view.js" type="text/javascript"></script>
<style>
<!--
.postcontent th {
	text-align:center;
}
-->
</style>
<div class="toolbar">
	<a href="javascript:void(0)" id="childDeathViewBack">
		<button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon"></i>返回</button>
	</a>
</div>
<div style="background-color: white; height: 515px;">
	<ul>
		<li style="text-align: center; font-size: 25px;">儿童死亡报告卡</li>
	</ul>
	<div class="postdiv" style="margin-top:20px;padding-bottom:0px;">
		<table class="posttable">
			<!-- <tr>
				<td style="width: 70%;"></td>
				<td style="line-height:1.5em;">
					表制定机关：国家卫生计生委<br/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：卫计统60-1表<br/>
					批准机关：国家统计局<br/>
					批准文号：国统制[2015]166号 <br/>
					有效期至：2017年12月
				</td>
			</tr> -->
			<tr>
				<td style="width: 70%;float:left;margin-left:60px;">
					<input type="text" style="width:100px;" name="hrtownShip" 
						value="${deathMedicineCertificate.hrtownShip}" readonly="readonly"/>区县&nbsp;
					<input type="text" style="width:100px;" 
						value="${deathMedicineCertificate.patownShip}"  readonly="readonly"　readonly="readonly"/>
				</td>
				<td style="float:right;margin-right:20px;">
					<input disabled="disabled" style="width:13px;height:13px;line-height:13px;margin-right:2px; vertical-align:-2px;*vertical-align:middle;_vertical-align:3px;" type="checkbox" name="isAdd" value="" id="isAdd">补卡
				</td>
			</tr>
		</table>
	</div>
	<div class="table-basic">
		<table>
			<colgroup>
				<col style="width: 15%;"/>
	            <col style="width: 35%;"/>
				<col style="width: 15%;"/>
	            <col style="width: 35%;"/>
			</colgroup>
			<tr>
				<th width="15%">编号</th>
				<td colspan="3">${deathMedicineCertificate.reportNo}</td>
			</tr>
			<tr>
				<th>住址</th>
				<td colspan="3">
					<ehr:dic code="${deathMedicineCertificate.pacounty}" dicmeta="FS990001" />
					<ehr:dic code="${deathMedicineCertificate.patownShip}" dicmeta="FS990001" />
					<ehr:dic code="${deathMedicineCertificate.pastreet}" dicmeta="FS990001" />
					${deathMedicineCertificate.pahouseNumber}
				</td>
			</tr>
			<tr>
				<th width="15%">父亲姓名</th>
				<td><c:out value="${deathMedicineCertificate.fathorName}"></c:out></td>
				<th width="15%">母亲姓名</th>
				<td><c:out value="${deathMedicineCertificate.mothorName}"></c:out></td>
			</tr>
			<tr>
				<th width="15%">儿童姓名</th>
				<td><c:out value="${deathMedicineCertificate.name}"></c:out></td>
				<th width="15%">联系电话</th>
				<td><c:out value="${deathMedicineCertificate.familyPhone}"></c:out></td>
			</tr>
			<tr>
				<th width="15%">户籍</th>
				<td colspan="3">
					<ehr:dic code="${deathMedicineCertificate.censusRegister}" dicmeta="YC201701" />
				</td>
			</tr>
			<tr>
				<th width="15%">性别</th>
				<td>
					<ehr:dic code="${deathMedicineCertificate.gender}" dicmeta="GBT226112003_1" />
				</td>
				<th width="15%">出生日期</th>
				<td><fmt:formatDate value="${deathMedicineCertificate.birthday}" pattern="yyyy/MM/dd HH:mm"/></td>
			</tr>
			<tr>
				<th width="15%">出生体重(克)</th>
				<td>
					<c:out value="${deathMedicineCertificate.bornWeight}" />&nbsp;&nbsp;&nbsp;&nbsp;
					<ehr:dic code="${deathMedicineCertificate.bornWeightSelect}" dicmeta="YC201706" />
				</td>
				<th>孕周</th>
				<td><c:out value="${deathMedicineCertificate.pregnantWeek}" />周</td>
			</tr>
			<tr>
				<th width="15%">出生地点</th>
				<td colspan="3">
					<ehr:dic code="${deathMedicineCertificate.bornSite}" dicmeta="YC201708" />
			</tr>
			<tr>
				<th width="15%">死亡日期</th>
				<td><fmt:formatDate value="${deathMedicineCertificate.deathDate}" pattern="yyyy/MM/dd HH:mm"/></td>
				<th width="15%">死亡年龄</th>
				<td>
					<c:out value="${deathMedicineCertificate.ageSui}"/>&nbsp;岁&nbsp;&nbsp;&nbsp;
					<c:out value="${deathMedicineCertificate.ageMonth}"/>&nbsp;月&nbsp;&nbsp;&nbsp;
					<c:out value="${deathMedicineCertificate.ageDay}"/>&nbsp;天&nbsp;&nbsp;&nbsp;
					<c:out value="${deathMedicineCertificate.ageHour}"/>&nbsp;小时&nbsp;&nbsp;&nbsp;
					<c:out value="${deathMedicineCertificate.ageSecond}"/>&nbsp;分
				</td>
			</tr>
			<tr>
				<th width="15%">死亡诊断</th>
				<td colspan="3">
					(a) 直接导致死亡的疾病或情况:${deathMedicineCertificate.directCondition}<br/>
					(b) 引起(a)的疾病或情况:${deathMedicineCertificate.conditionA}<br/>
					(c) 引起(b)的疾病或情况:${deathMedicineCertificate.conditionB}<br/>
					(d) 引起(c)的疾病或情况:${deathMedicineCertificate.conditionC}<br/>
					根本死因:<c:out value="${deathMedicineCertificate.deathReason}"/>
				</td>
			</tr>
			<tr>
				<th width="15%">分类编号</th>
				<td>
					<c:out value="${deathMedicineCertificate.categoryNo}"/>
					<ehr:dic code="${deathMedicineCertificate.categoryNo}" dicmeta="YC201702"/>
				</td>
				<th width="15%">ICD-10编码</th>
				<td><c:out value="${deathMedicineCertificate.icd10Code}"/></td>
			</tr>
			<tr>
				<th width="15%">死亡地点</th>
				<td>
					<ehr:dic code="${deathMedicineCertificate.deathSite}" dicmeta="YC201703" />
                </td>
				<th width="15%">死前治疗</th>
				<td>
					<ehr:dic code="${deathMedicineCertificate.deathBeforeTreat}" dicmeta="YC201704" />
				</td>
			</tr>
			<tr>
				<th width="15%">诊断级别</th>
				<td colspan="3">
					<ehr:dic code="${deathMedicineCertificate.diagnosisLevel}" dicmeta="YC201705" />
			    </td>
			</tr>
			<tr>
				<th width="15%">未治疗或未就医主要原因</th>
				<td colspan="3">
					<ehr:dic code="${deathMedicineCertificate.noTreatReason}" dicmeta="YC201707" />
            	</td>
			</tr>
			<tr>
				<th width="15%">死因诊断依据</th>
				<td colspan="3">
					<ehr:dic code="${deathMedicineCertificate.deathReasonBasis}" dicmeta="YC201709" />
				</td>
			</tr>
			<tr>
				<th>填报单位</th>
				<td>
					<c:out value="${deathMedicineCertificate.fillOrganName}"></c:out>
				</td>
				<th>填报人</th>
				<td>
					<c:out value="${deathMedicineCertificate.fillUserName}"></c:out>
				</td>
			</tr>
			<tr>
				<th>填报日期</th>
				<td><fmt:formatDate value="${deathMedicineCertificate.fillTime}" pattern="yyyy/MM/dd"/></td>
			</tr>
		</table>
	</div>
</div>